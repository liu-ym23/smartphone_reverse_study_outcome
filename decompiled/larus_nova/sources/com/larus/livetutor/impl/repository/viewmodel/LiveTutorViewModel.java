package com.larus.livetutor.impl.repository.viewmodel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieCompositionFactory;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.apm.ApmAgent;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.business.debug.api.ILiveTutorDebugService;
import com.larus.business.debug.api.RTCDebugInfo;
import com.larus.common.apphost.AppHost;
import com.larus.ivykit.web.TTWebViewService;
import com.larus.livetutor.api.idl.ConsumeStatus;
import com.larus.livetutor.api.idl.ControlAction;
import com.larus.livetutor.api.idl.ControlReason;
import com.larus.livetutor.api.idl.DoubaoActionbarPageQueryParams;
import com.larus.livetutor.api.idl.DoubaoSuggestQueryParams;
import com.larus.livetutor.api.idl.EvaluateLabel;
import com.larus.livetutor.api.idl.FeedbackStatus;
import com.larus.livetutor.api.idl.FixedAudioMsg;
import com.larus.livetutor.api.idl.FixedAudioType;
import com.larus.livetutor.api.idl.LiveTutorCallInfo;
import com.larus.livetutor.api.idl.LiveTutorClientControlMsg;
import com.larus.livetutor.api.idl.LiveTutorQueryType;
import com.larus.livetutor.api.idl.LiveTutorV2Params;
import com.larus.livetutor.api.idl.PauseLocation;
import com.larus.livetutor.api.idl.Signal;
import com.larus.livetutor.api.idl.SignalType;
import com.larus.livetutor.api.idl.StartCallResponse;
import com.larus.livetutor.api.idl.StartControlMsg;
import com.larus.livetutor.api.idl.SubtitleMsg;
import com.larus.livetutor.api.idl.TutorEntranceType;
import com.larus.livetutor.api.idl.UserAsrEndMsg;
import com.larus.livetutor.api.idl.UserSetting;
import com.larus.livetutor.impl.hybrid.LiveTutorHybridContainer;
import com.larus.livetutor.impl.rtc.LogEntity;
import com.larus.livetutor.impl.rtc.LogStatus;
import com.larus.livetutor.impl.rtc.TutorRTCServiceImpl;
import com.larus.livetutor.impl.rtc.adpter.BaseConnectedMsg;
import com.larus.livetutor.impl.rtc.adpter.LiveTutorConnectedStatus;
import com.larus.livetutor.impl.rtc.api.RTCAction;
import com.larus.livetutor.impl.rtc.api.RTCInfo;
import com.larus.livetutor.impl.rtc.api.RTCServiceStatus;
import com.larus.livetutor.impl.rtc.handler.RTCMonitor;
import com.larus.livetutor.impl.rtc.interfaces.RTCNetworkQuality;
import com.larus.livetutor.impl.rtc.interfaces.SubtitleStream;
import com.larus.livetutor.impl.tutor.controller.LiveTutorAnimController;
import com.larus.livetutor.impl.tutor.controller.LiveTutorFeedbackController;
import com.larus.livetutor.impl.tutor.controller.LiveTutorMessageController;
import com.larus.livetutor.impl.tutor.controller.LiveTutorPauseController;
import com.larus.livetutor.impl.tutor.controller.LiveTutorSubtitleControllerV2;
import com.larus.livetutor.impl.tutor.controller.LiveTutorWaitController;
import com.larus.livetutor.impl.tutor.controller.r0;
import com.larus.livetutor.impl.tutor.data.LiveTutorControlReason;
import com.larus.livetutor.impl.tutor.data.LiveTutorDoubaoTrackerData;
import com.larus.livetutor.impl.tutor.data.LiveTutorPauseEvent;
import com.larus.livetutor.impl.tutor.data.feedback.CommonFeedbackConfig;
import com.larus.livetutor.impl.tutor.data.feedback.CommonFeedbackItemEntity;
import com.larus.livetutor.impl.tutor.data.feedback.CommonFeedbackModel;
import com.larus.livetutor.impl.tutor.data.feedback.StarItemEntity;
import com.larus.livetutor.impl.tutor.fragment.LiveTutorSubtitleFragment;
import com.larus.livetutor.impl.utils.UtilsKt;
import com.larus.livetutor.impl.utils.track.LiveTutorTrackerService;
import com.larus.livetutor.impl.view.CommonFeedbackDialog;
import com.larus.livetutor.impl.view.LiveTutorSettingsDialog;
import com.larus.livetutor.impl.view.error.LiveTutorException;
import com.larus.livetutor.impl.view.m2;
import com.larus.nova.R;
import com.larus.platform.service.i2;
import com.larus.settings.tutor.LiveTutorConfig;
import com.larus.utils.logger.FLogger;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bduploader.UploadKeys;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.i1;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000¾\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 ©\u00022\u00020\u0001:\u0002©\u0002B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010¹\u0001\u001a\u00030ª\u00012\u0014\u0010º\u0001\u001a\u000f\u0012\u0005\u0012\u00030ª\u00010·\u0001j\u0003`¸\u0001J\n\u0010»\u0001\u001a\u00030ª\u0001H\u0002J\t\u0010¼\u0001\u001a\u00020YH\u0002J\u001f\u0010½\u0001\u001a\u00030ª\u00012\b\u0010¾\u0001\u001a\u00030¿\u00012\t\u0010À\u0001\u001a\u0004\u0018\u00010\u000fH\u0016J\u001f\u0010Á\u0001\u001a\u00030ª\u00012\b\u0010¾\u0001\u001a\u00030¿\u00012\t\u0010À\u0001\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010Â\u0001\u001a\u00030ª\u00012\u0006\u0010\u0002\u001a\u00020\u0003J\u0012\u0010Ã\u0001\u001a\u00030ª\u00012\b\u0010Ä\u0001\u001a\u00030Å\u0001J\n\u0010Æ\u0001\u001a\u00030ª\u0001H\u0002J\n\u0010Ç\u0001\u001a\u00030ª\u0001H\u0002J\n\u0010È\u0001\u001a\u00030ª\u0001H\u0002J\u0014\u0010É\u0001\u001a\u00030ª\u00012\b\u0010Ê\u0001\u001a\u00030£\u0001H\u0002J\u0016\u0010Ë\u0001\u001a\u00030ª\u00012\n\u0010Ì\u0001\u001a\u0005\u0018\u00010Í\u0001H\u0002J\u0013\u0010Î\u0001\u001a\u00030ª\u00012\u0007\u0010Ï\u0001\u001a\u00020\u000fH\u0016J\n\u0010Ð\u0001\u001a\u00030ª\u0001H\u0002J\u0011\u0010Ñ\u0001\u001a\u00030ª\u00012\u0007\u0010Ò\u0001\u001a\u00020-J\u0014\u0010Ó\u0001\u001a\u00030ª\u00012\b\u0010Ò\u0001\u001a\u00030Ô\u0001H\u0002J\u0014\u0010Õ\u0001\u001a\u00030ª\u00012\b\u0010Ò\u0001\u001a\u00030Ö\u0001H\u0002J\u0013\u0010×\u0001\u001a\u00030ª\u00012\u0007\u0010Ò\u0001\u001a\u000202H\u0002J\u0016\u0010Ø\u0001\u001a\u00030ª\u00012\f\b\u0002\u0010Ù\u0001\u001a\u0005\u0018\u00010Í\u0001J\b\u0010Ú\u0001\u001a\u00030ª\u0001J\b\u0010Û\u0001\u001a\u00030ª\u0001J\n\u0010Ü\u0001\u001a\u00030ª\u0001H\u0002J3\u0010Ý\u0001\u001a\u00030ª\u00012\t\b\u0002\u0010Þ\u0001\u001a\u00020?2\t\b\u0002\u0010ß\u0001\u001a\u00020\t2\u0013\b\u0002\u0010à\u0001\u001a\f\u0012\u0005\u0012\u00030ª\u0001\u0018\u00010·\u0001J\b\u0010á\u0001\u001a\u00030ª\u0001J\b\u0010â\u0001\u001a\u00030ª\u0001J(\u0010ã\u0001\u001a\u00030ª\u00012\u0007\u0010ä\u0001\u001a\u00020\t2\u0007\u0010å\u0001\u001a\u00020Q2\f\b\u0002\u0010æ\u0001\u001a\u0005\u0018\u00010ç\u0001J\u001c\u0010è\u0001\u001a\u00030ª\u00012\b\u0010é\u0001\u001a\u00030£\u00012\b\u0010ê\u0001\u001a\u00030£\u0001J\n\u0010ë\u0001\u001a\u00030ª\u0001H\u0002J\u0012\u0010ì\u0001\u001a\u00030ª\u00012\b\u0010í\u0001\u001a\u00030î\u0001J\u001f\u0010ï\u0001\u001a\u00030ª\u00012\u0015\u0010ð\u0001\u001a\u0010\u0012\u0004\u0012\u00020k\u0012\u0005\u0012\u00030ª\u00010ñ\u0001J\t\u0010ò\u0001\u001a\u00020\tH\u0002J\b\u0010ó\u0001\u001a\u00030ª\u0001J\u0011\u0010ô\u0001\u001a\u00030ª\u00012\u0007\u0010å\u0001\u001a\u00020QJ\u0011\u0010õ\u0001\u001a\u00030ª\u00012\u0007\u0010å\u0001\u001a\u00020QJ\u001a\u0010ö\u0001\u001a\u00030ª\u00012\u0007\u0010÷\u0001\u001a\u00020\u000f2\u0007\u0010å\u0001\u001a\u00020QJ\n\u0010ø\u0001\u001a\u00030ª\u0001H\u0002J\u0013\u0010ù\u0001\u001a\u00030ª\u00012\u0007\u0010ú\u0001\u001a\u00020\tH\u0002J\u0011\u0010û\u0001\u001a\u00030ª\u00012\u0007\u0010÷\u0001\u001a\u00020\u000fJ\b\u0010ü\u0001\u001a\u00030ª\u0001J\b\u0010ý\u0001\u001a\u00030ª\u0001J\b\u0010þ\u0001\u001a\u00030ª\u0001J\b\u0010ÿ\u0001\u001a\u00030ª\u0001J\b\u0010\u0080\u0002\u001a\u00030ª\u0001J\b\u0010\u0081\u0002\u001a\u00030ª\u0001J\b\u0010\u0082\u0002\u001a\u00030ª\u0001J\u0007\u0010\u0083\u0002\u001a\u00020\tJ\u0011\u0010\u0084\u0002\u001a\u00030ª\u00012\u0007\u0010\u0085\u0002\u001a\u00020\tJ\u0012\u0010\u0086\u0002\u001a\u00030ª\u00012\b\u0010\u0087\u0002\u001a\u00030\u0088\u0002J\u0012\u0010\u0089\u0002\u001a\u00030ª\u00012\b\u0010\u008a\u0002\u001a\u00030\u0088\u0002J=\u0010\u008b\u0002\u001a\u00030ª\u00012\n\u0010\u0087\u0002\u001a\u0005\u0018\u00010\u0088\u00022\n\u0010\u008a\u0002\u001a\u0005\u0018\u00010\u0088\u00022\u0015\u0010\u008c\u0002\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0005\u0012\u00030ª\u00010ñ\u0001¢\u0006\u0003\u0010\u008d\u0002J\u0012\u0010\u008e\u0002\u001a\u00030ª\u00012\b\u0010º\u0001\u001a\u00030\u008f\u0002J\b\u0010\u0090\u0002\u001a\u00030ª\u0001J\u0013\u0010\u0091\u0002\u001a\u00030ª\u00012\t\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0093\u0002\u001a\u00030ª\u0001J\n\u0010\u0094\u0002\u001a\u00030ª\u0001H\u0002J\b\u0010\u0095\u0002\u001a\u00030ª\u0001J\u0014\u0010\u0096\u0002\u001a\u00030ª\u00012\n\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0098\u0002J1\u0010\u0099\u0002\u001a\u00030ª\u00012'\u0010º\u0001\u001a\"\u0012\u0016\u0012\u00140?¢\u0006\u000f\b\u009a\u0002\u0012\n\b\u009b\u0002\u0012\u0005\b\b(\u009c\u0002\u0012\u0005\u0012\u00030ª\u00010ñ\u0001J\b\u0010\u009d\u0002\u001a\u00030\u009e\u0002J\b\u0010\u009f\u0002\u001a\u00030ª\u0001J\b\u0010 \u0002\u001a\u00030ª\u0001J\u001a\u0010¡\u0002\u001a\u00030ª\u00012\u0007\u0010¢\u0002\u001a\u00020\u000f2\u0007\u0010£\u0002\u001a\u00020\u000fJ\u001a\u0010¤\u0002\u001a\u00030ª\u00012\u0007\u0010¢\u0002\u001a\u00020\u000f2\u0007\u0010£\u0002\u001a\u00020\u000fJ\u0013\u0010¥\u0002\u001a\u00030ª\u00012\t\b\u0001\u0010Ä\u0001\u001a\u00020?J\u0017\u0010¦\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0005\u0012\u00030¨\u00020§\u0002H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0019\u001a\u0004\b$\u0010%R\u0016\u0010'\u001a\u0004\u0018\u00010(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010.\u001a\u0004\u0018\u00010-8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00101\u001a\b\u0012\u0004\u0012\u0002020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020204¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u00107\u001a\u0004\u0018\u0001028F¢\u0006\u0006\u001a\u0004\b8\u00109R\u0013\u0010:\u001a\u0004\u0018\u0001028F¢\u0006\u0006\u001a\u0004\b;\u00109R\u000e\u0010<\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010?0>¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u001f\u0010B\u001a\u0010\u0012\f\u0012\n C*\u0004\u0018\u00010\t0\t0>¢\u0006\b\n\u0000\u001a\u0004\bD\u0010AR\u0019\u0010E\u001a\n\u0012\u0004\u0012\u00020F\u0018\u0001048F¢\u0006\u0006\u001a\u0004\bG\u00106R\u0019\u0010H\u001a\n\u0012\u0004\u0012\u00020I\u0018\u0001048F¢\u0006\u0006\u001a\u0004\bJ\u00106R\"\u0010M\u001a\u0004\u0018\u00010L2\b\u0010K\u001a\u0004\u0018\u00010L@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u000e\u0010V\u001a\u00020QX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020QX\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010X\u001a\u00020Y8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\u0019\u001a\u0004\bZ\u0010[R\u0011\u0010]\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\"\u0010a\u001a\u0004\u0018\u00010`2\b\u0010K\u001a\u0004\u0018\u00010`@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\"\u0010d\u001a\u0004\u0018\u00010`2\b\u0010K\u001a\u0004\u0018\u00010`@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\be\u0010cR\u0014\u0010f\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bg\u0010\nR\u000e\u0010h\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020QX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010j\u001a\b\u0012\u0004\u0012\u00020k0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010l\u001a\b\u0012\u0004\u0012\u00020k04¢\u0006\b\n\u0000\u001a\u0004\bm\u00106R\u0019\u0010n\u001a\n\u0012\u0004\u0012\u00020p\u0018\u00010o8F¢\u0006\u0006\u001a\u0004\bq\u0010rR\u000e\u0010s\u001a\u00020tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010w\u001a\u00020x8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b{\u0010\u0019\u001a\u0004\by\u0010zR\u0010\u0010|\u001a\u0004\u0018\u00010}X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010~\u001a\u00020\u007fX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R,\u0010\u0084\u0001\u001a\u0010\u0012\f\u0012\n C*\u0004\u0018\u00010\t0\t0>X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0085\u0001\u0010A\"\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0012\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u008a\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u008b\u0001\u0018\u0001048F¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u00106R\u0017\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u00018F¢\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u000f\u0010\u0091\u0001\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020\t0>¢\u0006\t\n\u0000\u001a\u0005\b\u0093\u0001\u0010AR\u0014\u0010\u0094\u0001\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0005\n\u0003\u0010\u0095\u0001R\u0011\u0010\u0096\u0001\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0097\u0001\u001a\n\u0012\u0005\u0012\u00030\u0099\u00010\u0098\u00018F¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0015\u0010\u009c\u0001\u001a\u00030\u009d\u00018F¢\u0006\b\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001d\u0010 \u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0098\u00018F¢\u0006\b\u001a\u0006\b¡\u0001\u0010\u009b\u0001R\u0016\u0010¢\u0001\u001a\u0005\u0018\u00010£\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R&\u0010¤\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0¥\u00010>¢\u0006\t\n\u0000\u001a\u0005\b¦\u0001\u0010AR\u0019\u0010§\u0001\u001a\b\u0012\u0004\u0012\u00020\t0>¢\u0006\t\n\u0000\u001a\u0005\b¨\u0001\u0010AR\u001a\u0010©\u0001\u001a\t\u0012\u0005\u0012\u00030ª\u00010>¢\u0006\t\n\u0000\u001a\u0005\b«\u0001\u0010AR\u0011\u0010¬\u0001\u001a\u0004\u0018\u00010}X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u00ad\u0001\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010®\u0001\u001a\u00020QX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010¯\u0001\u001a\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010°\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010±\u0001\u001a\t\u0012\u0005\u0012\u00030²\u00010>¢\u0006\t\n\u0000\u001a\u0005\b³\u0001\u0010AR\u0014\u0010´\u0001\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0005\n\u0003\u0010\u0095\u0001R#\u0010µ\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0005\u0012\u00030ª\u00010·\u0001j\u0003`¸\u00010¶\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006ª\u0002"}, d2 = {"Lcom/larus/livetutor/impl/repository/viewmodel/LiveTutorViewModel;", "Lcom/larus/livetutor/impl/repository/viewmodel/LiveTutorBaseViewModel;", KtvSubElement.CONTAINER, "Lcom/larus/livetutor/impl/hybrid/LiveTutorHybridContainer;", "<init>", "(Lcom/larus/livetutor/impl/hybrid/LiveTutorHybridContainer;)V", "animController", "Lcom/larus/livetutor/impl/tutor/controller/LiveTutorAnimController;", "isAnimTransiting", "", "()Z", "messageController", "Lcom/larus/livetutor/impl/tutor/controller/LiveTutorMessageController;", "messageCallback", "Lcom/larus/livetutor/impl/tutor/core/interfaces/ILiveTutorMessageCallback;", "", "getMessageCallback", "()Lcom/larus/livetutor/impl/tutor/core/interfaces/ILiveTutorMessageCallback;", "subtitleController", "Lcom/larus/livetutor/impl/tutor/controller/LiveTutorSubtitleControllerV2;", "waitController", "Lcom/larus/livetutor/impl/tutor/controller/LiveTutorWaitController;", "getWaitController", "()Lcom/larus/livetutor/impl/tutor/controller/LiveTutorWaitController;", "waitController$delegate", "Lkotlin/Lazy;", "saveController", "Lcom/larus/livetutor/impl/tutor/controller/LiveTutorSaveController;", "pauseController", "Lcom/larus/livetutor/impl/tutor/controller/LiveTutorPauseController;", "feedbackController", "Lcom/larus/livetutor/impl/tutor/controller/LiveTutorFeedbackController;", "imagePreviewController", "Lcom/larus/livetutor/impl/tutor/controller/LiveTutorImagePreviewController;", "liveTutorConfig", "Lcom/larus/settings/tutor/LiveTutorConfig;", "getLiveTutorConfig", "()Lcom/larus/settings/tutor/LiveTutorConfig;", "liveTutorConfig$delegate", "rtcService", "Lcom/larus/livetutor/impl/rtc/TutorRtcService;", "getRtcService", "()Lcom/larus/livetutor/impl/rtc/TutorRtcService;", "rtcPageState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus;", "currentPageState", "getCurrentPageState", "()Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus;", "_contentState", "Lcom/larus/livetutor/impl/rtc/api/BusinessConnectedStatus;", "contentState", "Lkotlinx/coroutines/flow/SharedFlow;", "getContentState", "()Lkotlinx/coroutines/flow/SharedFlow;", "currentContentState", "getCurrentContentState", "()Lcom/larus/livetutor/impl/rtc/api/BusinessConnectedStatus;", "previousContentState", "getPreviousContentState", "teachEnd", "loadingStep", "Landroidx/lifecycle/MutableLiveData;", "", "getLoadingStep", "()Landroidx/lifecycle/MutableLiveData;", "subtitleState", "kotlin.jvm.PlatformType", "getSubtitleState", "audioExtraFlow", "Lcom/larus/livetutor/impl/rtc/interfaces/SubtitleStream;", "getAudioExtraFlow", "subtitleMsgFlow", "Lcom/larus/livetutor/api/idl/SubtitleMsg;", "getSubtitleMsgFlow", "value", "Lcom/larus/livetutor/api/idl/LiveTutorCallInfo;", "callInfo", "getCallInfo", "()Lcom/larus/livetutor/api/idl/LiveTutorCallInfo;", "tutorId", "", "getTutorId", "()J", "setTutorId", "(J)V", "searchId", "resId", "liveTutorV2Params", "Lcom/larus/livetutor/api/idl/LiveTutorV2Params;", "getLiveTutorV2Params", "()Lcom/larus/livetutor/api/idl/LiveTutorV2Params;", "liveTutorV2Params$delegate", "enterTime", "getEnterTime", "()Ljava/lang/String;", "Lcom/larus/livetutor/impl/repository/viewmodel/PageChildState;", "rtcConnectStatus", "getRtcConnectStatus", "()Lcom/larus/livetutor/impl/repository/viewmodel/PageChildState;", "webviewLoadStatus", "getWebviewLoadStatus", "pageReady", "getPageReady", "hasAlreadyCallStartSuccess", "loadingStart", "_logFlow", "Lcom/larus/livetutor/impl/rtc/LogEntity;", "logFlow", "getLogFlow", "networkQualityFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/livetutor/impl/rtc/interfaces/RTCNetworkQuality;", "getNetworkQualityFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "longThinkingTimeOut", "Ljava/lang/Runnable;", "longAsrSubmitTimeOut", "longLoadingTimeOut", "subtitleFragment", "Lcom/larus/livetutor/impl/tutor/fragment/LiveTutorSubtitleFragment;", "getSubtitleFragment", "()Lcom/larus/livetutor/impl/tutor/fragment/LiveTutorSubtitleFragment;", "subtitleFragment$delegate", "restartPopDismissJob", "Lkotlinx/coroutines/Job;", "currentUserSetting", "Lcom/larus/livetutor/api/idl/UserSetting;", "getCurrentUserSetting", "()Lcom/larus/livetutor/api/idl/UserSetting;", "setCurrentUserSetting", "(Lcom/larus/livetutor/api/idl/UserSetting;)V", "speedingChanging", "getSpeedingChanging", "setSpeedingChanging", "(Landroidx/lifecycle/MutableLiveData;)V", "settingsDialog", "Lcom/larus/livetutor/impl/view/LiveTutorSettingsDialog;", "actionFlow", "Lcom/larus/livetutor/impl/rtc/api/RTCAction;", "getActionFlow", "audioController", "Lcom/larus/livetutor/impl/rtc/interfaces/ITutorRTCAudioController;", "getAudioController", "()Lcom/larus/livetutor/impl/rtc/interfaces/ITutorRTCAudioController;", "audioUuid", "pressState", "getPressState", "pressToShort", "Ljava/lang/Boolean;", "asrStartState", "pauseRtc", "Landroidx/lifecycle/LiveData;", "Lcom/larus/livetutor/impl/tutor/data/LiveTutorPauseEvent;", "getPauseRtc", "()Landroidx/lifecycle/LiveData;", "currentPauseLocation", "Lcom/larus/livetutor/api/idl/PauseLocation;", "getCurrentPauseLocation", "()Lcom/larus/livetutor/api/idl/PauseLocation;", "saveBoardUuid", "getSaveBoardUuid", "resumeFailView", "Landroid/view/View;", "keyboardStatus", "Lkotlin/Pair;", "getKeyboardStatus", "keyboardEvent", "getKeyboardEvent", "dismissTtsSpeedControlHintEvent", "", "getDismissTtsSpeedControlHintEvent", "backgroundExitJob", "leaveRoomByEnterBackground", "backgroundTime", "finishRtcDeferred", "Lkotlinx/coroutines/Deferred;", "activityConfiguration", "Landroid/content/res/Configuration;", "getActivityConfiguration", "isUseTTWebview", "closePageListeners", "", "Lkotlin/Function0;", "Lcom/larus/livetutor/impl/repository/viewmodel/ClosePageListener;", "addClosePageListener", "listener", "broadcastClosePageEvent", "buildParams", "refreshData", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Lcom/larus/livetutor/impl/repository/viewmodel/ITutorRefresh$RefreshStrategy;", "dataT", "startRefreshData", "initViewModel", "handleStartCallResponse", "res", "Lcom/larus/livetutor/api/idl/StartCallResponse;", "dispatchRefreshState", "tryCallOnStart", "showRestartInfoPop", "restart2Learn", "view", "showResumeFailTips", "pauseReason", "Lcom/larus/livetutor/api/idl/ControlReason;", "pageStateLog", "info", "closeAudioCaptureState", "updatePageState", "state", "receiveRtcError", "Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus$Error;", "receiveRtcConnected", "Lcom/larus/livetutor/impl/rtc/api/RTCServiceStatus$Connected;", "updateContentState", "tryResume", "reason", "clickToClose", "closePage", "doExit", "tryFinishRtc", DBDefinition.RETRY_COUNT, "force", "onSuccess", "retryConnectRtc", "refreshConnectStatus", "loadUriResult", "isSuccess", "duration", "e", "", "transitionEnterTeachWithAnim", "planView", "teachView", "requestAudioCapturePermission", "collectRtcDebugInfo", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "addDebugInfo", "function", "Lkotlin/Function1;", "cannotClick", "onUserAsrStart", "onUserAsrCancel", "onUserAsrEnd", "onUserAsrTextSend", "content", "openKeyBoard", "closeKeyBoard", "isSend", "onUserTextSend", "openSubtitleFragment", "breakTimer", "showError", "saveBoard", "switchPauseStatusProactively", "openSettingsDialog", "dismissTtsSpeedControlHint", "isPause", "updateKeyboardShowing", "isKeyboardShowing", "updateSpeed", "newSpeed", "", "updatePitch", "newPitch", "updateUserSettings", "result", "(Ljava/lang/Double;Ljava/lang/Double;Lkotlin/jvm/functions/Function1;)V", "registerSubtitleListener", "Lcom/larus/livetutor/impl/tutor/controller/SubtitleStreamListener;", "sendLongWaitTimeout", "sendLocalTips", "tips", "enterForeground", "exitAndResetState", "enterBackground", "handleContinueAction", "action", "Lcom/larus/livetutor/api/idl/ControlAction;", "setLocalVolumeListener", "Lkotlin/ParameterName;", "name", ITTVideoEngineEventSource.KEY_VOLUME, "getWebViewLocation", "", LiveCommonConstants.REASON_ON_DEDTROY, "releaseRtc", "eLogger", "tag", "log", "dLogger", "toast", "getTrackerParams", "", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorViewModel extends LiveTutorBaseViewModel {
    public static final a Companion = null;
    public static final int DAILY_FREQUENCY_LIMIT_ERR_NO = 1070005;
    public static final int INPUT_CQC_ERR_NO = 1070007;
    public static final int NOT_EXIST_ERR_NO = 1070008;
    public static final int NOT_RECOGNIZED_ERR_NO = 1070009;
    public static final int NOT_SUPPORT_TYPE_ERR_NO = 1070006;
    public static final int NO_RETRY_ERR_NO = 1070002;
    private final MutableSharedFlow<ij9.a> _contentState;
    private final MutableSharedFlow<LogEntity> _logFlow;
    private final MutableLiveData<Configuration> activityConfiguration;
    private final LiveTutorAnimController animController;
    private ij9.a asrStartState;
    private String audioUuid;
    private Job backgroundExitJob;
    private long backgroundTime;
    private LiveTutorCallInfo callInfo;
    private final Set<Function0<Unit>> closePageListeners;
    private final LiveTutorHybridContainer container;
    private final d1<ij9.a> contentState;
    private UserSetting currentUserSetting;
    private final MutableLiveData<Unit> dismissTtsSpeedControlHintEvent;
    private final String enterTime;
    private final LiveTutorFeedbackController feedbackController;
    private Deferred<Boolean> finishRtcDeferred;
    private boolean hasAlreadyCallStartSuccess;
    private final com.larus.livetutor.impl.tutor.controller.t imagePreviewController;
    private Boolean isUseTTWebview;
    private final MutableLiveData<Boolean> keyboardEvent;
    private final MutableLiveData<Pair<Boolean, Boolean>> keyboardStatus;
    private boolean leaveRoomByEnterBackground;
    private final Lazy liveTutorConfig$delegate;
    private final Lazy liveTutorV2Params$delegate;
    private long loadingStart;
    private final MutableLiveData<Integer> loadingStep;
    private final d1<LogEntity> logFlow;
    private final Runnable longAsrSubmitTimeOut;
    private final Runnable longLoadingTimeOut;
    private final Runnable longThinkingTimeOut;
    private final LiveTutorMessageController messageController;
    private final LiveTutorPauseController pauseController;
    private final MutableLiveData<Boolean> pressState;
    private Boolean pressToShort;
    private final long resId;
    private Job restartPopDismissJob;
    private View resumeFailView;
    private l0 rtcConnectStatus;
    private final MutableSharedFlow<RTCServiceStatus> rtcPageState;
    private final com.larus.livetutor.impl.tutor.controller.h0 saveController;
    private final long searchId;
    private LiveTutorSettingsDialog settingsDialog;
    private MutableLiveData<Boolean> speedingChanging;
    private final LiveTutorSubtitleControllerV2 subtitleController;
    private final Lazy subtitleFragment$delegate;
    private final MutableLiveData<Boolean> subtitleState;
    private boolean teachEnd;
    private long tutorId;
    private final Lazy waitController$delegate;
    private l0 webviewLoadStatus;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel$closePage$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(Object r100) {
            super(0, r100, LiveTutorViewModel.class, "doExit", "doExit()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            LiveTutorViewModel.access$doExit((LiveTutorViewModel) this.receiver);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel$closePage$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass2 extends AdaptedFunctionReference implements Function0<Unit> {
        public AnonymousClass2(Object r100) {
            super(0, r100, LiveTutorViewModel.class, "tryFinishRtc", "tryFinishRtc(IZLkotlin/jvm/functions/Function0;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            LiveTutorViewModel.tryFinishRtc$default((LiveTutorViewModel) this.receiver, 0, false, null, 7, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel$enterBackground$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel$enterBackground$1", f = "LiveTutorViewModel.kt", i = {0}, l = {1136}, m = "invokeSuspend", n = {"$this$safeLaunchAlive"}, s = {"L$0"})
    public static final class C114741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayTime;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ LiveTutorViewModel this$0;

        /* JADX INFO: renamed from: com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel$enterBackground$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel$enterBackground$1$1", f = "LiveTutorViewModel.kt", i = {}, l = {DataLoaderHelper.DATALOADER_KEY_INT_MAX_ALIVE_HOST_NUM}, m = "invokeSuspend", n = {}, s = {})
        public static final class C44111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ LiveTutorViewModel this$0;

            public C44111(LiveTutorViewModel r100, Continuation<? super C44111> r101) {
                this.this$0 = r100;
                super(2, r101);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                C44111 r102 = new C44111(this.this$0, r101);
                r102.L$0 = r100;
                return r102;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
                return ((C44111) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r110) {
                Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r101 = this.label;
                if (r101 == 0) goto L9;
                if (r101 != 1) goto L8;
                ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L15
            L13:
                Object r111 = Result.m9449constructorimpl(Boxing.boxBoolean(((Boolean) r110).booleanValue()));     // Catch: Throwable -> L15
            L17:
                Throwable r102 = Result.m9452exceptionOrNullimpl(r111);
                if (r102 == null) goto L20;
                boolean r103 = kj9.b.f503724a;
                kj9.b.b("[enterBackground] tryFinishRtc exception: " + r102);
            L20:
                Boolean r104 = Boxing.boxBoolean(false);
                if (Result.m9455isFailureimpl(r111) == true) goto L23;
                return r111;
            L23:
                return r104;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                ResultKt.throwOnFailure(r110);
                CoroutineScope r112 = (CoroutineScope) this.L$0;
                LiveTutorViewModel r105 = this.this$0;
                Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L15
                CompletableDeferred r114 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);     // Catch: Throwable -> L15
                LiveTutorViewModel.tryFinishRtc$default(r105, 0, true, null, 5, null);     // Catch: Throwable -> L15
                r114.complete(Boxing.boxBoolean(true));     // Catch: Throwable -> L15
                this.label = 1;     // Catch: Throwable -> L15
                r110 = r114.await(this);     // Catch: Throwable -> L15
                if (r110 != r100) goto L13;
                return r100;
            L15:
                th = move-exception;
                Result.Companion r106 = Result.Companion;
                r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
                goto L17
            }
        }

        public C114741(long r100, LiveTutorViewModel r101, Continuation<? super C114741> r102) {
            this.$delayTime = r100;
            this.this$0 = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C114741 r102 = new C114741(this.$delayTime, this.this$0, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C114741) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            CoroutineScope r102 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r110);
            CoroutineScope r103 = r102;
        L12:
            Job r111 = LiveTutorViewModel.access$getBackgroundExitJob$p(this.this$0);
            if (r111 != null) goto L15;
        L17:
            boolean r112 = false;
        L18:
            if (r112 == false) goto L20;
            kj9.b.a("[enterBackground] backgroundExitJob timeout, auto finish rtc");
            LiveTutorViewModel.access$setLeaveRoomByEnterBackground$p(this.this$0, true);
            LiveTutorViewModel r113 = this.this$0;
            LiveTutorViewModel.access$setFinishRtcDeferred$p(r113, BuildersKt.async$default(r103, null, null, new C44111(r113, null), 3, null));
            return Unit.INSTANCE;
        L20:
            return Unit.INSTANCE;
        L15:
            if (r111.isActive() != true) goto L17;
            r112 = true;
            goto L18
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            CoroutineScope r114 = (CoroutineScope) this.L$0;
            long r104 = this.$delayTime;
            this.L$0 = r114;
            this.label = 1;
            if (DelayKt.delay(r104, this) != r100) goto L11;
            return r100;
        L11:
            r103 = r114;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel$enterForeground$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel$enterForeground$1", f = "LiveTutorViewModel.kt", i = {}, l = {1084}, m = "invokeSuspend", n = {}, s = {})
    public static final class C114751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LiveTutorViewModel this$0;

        /* JADX INFO: renamed from: com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel$enterForeground$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel$enterForeground$1$1", f = "LiveTutorViewModel.kt", i = {}, l = {1084}, m = "invokeSuspend", n = {}, s = {})
        public static final class C44121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            int label;
            final /* synthetic */ LiveTutorViewModel this$0;

            public C44121(LiveTutorViewModel r100, Continuation<? super C44121> r101) {
                this.this$0 = r100;
                super(2, r101);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C44121(this.this$0, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
                return ((C44121) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r102 = this.label;
                if (r102 == 0) goto L8;
                if (r102 != 1) goto L7;
                ResultKt.throwOnFailure(r100);
            L16:
                return (Boolean) r100;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r100);
                Deferred r103 = LiveTutorViewModel.access$getFinishRtcDeferred$p(this.this$0);
                if (r103 == null) goto L14;
                this.label = 1;
                r100 = r103.await(this);
                if (r100 != r101) goto L16;
                return r101;
            L14:
                return null;
            }
        }

        public C114751(LiveTutorViewModel r100, Continuation<? super C114751> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C114751(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C114751) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L13;
            if (r102 != 1) goto L12;
            ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L7 Exception -> L9
        L21:
            Job r103 = LiveTutorViewModel.access$getBackgroundExitJob$p(this.this$0);
            if (r103 != null) goto L27;
        L28:
            LiveTutorViewModel.access$setBackgroundExitJob$p(this.this$0, null);
            LiveTutorViewModel.access$setFinishRtcDeferred$p(this.this$0, null);
            this.this$0.retryConnectRtc();
            return Unit.INSTANCE;
        L27:
            Job.DefaultImpls.cancel$default(r103, null, 1, null);
            goto L28
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            ResultKt.throwOnFailure(r100);
            boolean r104 = kj9.b.f503724a;
            StringBuilder r105 = new StringBuilder("[enterForeground] exitByBackground auto reconnect, finishRtcDeferred = ");
            Deferred r106 = LiveTutorViewModel.access$getFinishRtcDeferred$p(this.this$0);
            if (r106 == null) goto L16;
            Boolean r107 = Boxing.boxBoolean(r106.isCompleted());
        L17:
            r105.append(r107);
            kj9.b.a(r105.toString());
            LiveTutorViewModel.access$setLeaveRoomByEnterBackground$p(this.this$0, false);
            LiveTutorViewModel.access$setRtcConnectStatus$p(this.this$0, null);     // Catch: Throwable -> L7 Exception -> L9
            LiveTutorViewModel.access$get_contentState$p(this.this$0).tryEmit(new LiveTutorConnectedStatus.Loading(null, null, new BaseConnectedMsg(null, null, null), true));     // Catch: Throwable -> L7 Exception -> L9
            LiveTutorViewModel.access$exitAndResetState(this.this$0);     // Catch: Throwable -> L7 Exception -> L9
            C44121 r108 = new C44121(this.this$0, null);     // Catch: Throwable -> L7 Exception -> L9
            this.label = 1;     // Catch: Throwable -> L7 Exception -> L9
            if (TimeoutKt.c(1000, r108, this) != r101) goto L21;
            return r101;
        L16:
            r107 = null;
        L7:
            th = move-exception;
            Job r109 = LiveTutorViewModel.access$getBackgroundExitJob$p(this.this$0);
            if (r109 == null) goto L33;
            Job.DefaultImpls.cancel$default(r109, null, 1, null);
        L33:
            LiveTutorViewModel.access$setBackgroundExitJob$p(this.this$0, null);
            LiveTutorViewModel.access$setFinishRtcDeferred$p(this.this$0, null);
            this.this$0.retryConnectRtc();
            throw th;
        L9:
            e = move-exception;
            boolean r110 = kj9.b.f503724a;     // Catch: Throwable -> L7
            kj9.b.b("[enterForeground] await finishRtc exception: " + e);     // Catch: Throwable -> L7
            r103 = LiveTutorViewModel.access$getBackgroundExitJob$p(this.this$0);
            if (r103 == null) goto L28;
            goto L27
        }
    }

    /* JADX INFO: renamed from: com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel$showRestartInfoPop$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel$showRestartInfoPop$1", f = "LiveTutorViewModel.kt", i = {0}, l = {472}, m = "invokeSuspend", n = {"view"}, s = {"L$0"})
    public static final class C114761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ LiveTutorViewModel this$0;

        public C114761(LiveTutorViewModel r100, Continuation<? super C114761> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C114761(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C114761) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            View r102 = (View) this.L$0;
            ResultKt.throwOnFailure(r110);
        L15:
            LiveTutorViewModel.access$getContainer$p(this.this$0).b(r102);
            kj9.b.a("[showRestartInfoPop] dismiss restart pop");
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            kj9.b.a("[showRestartInfoPop] show restart pop");
            LiveTutorHybridContainer r111 = LiveTutorViewModel.access$getContainer$p(this.this$0);
            String r103 = UtilsKt.c().getString(R.string.larus_tutor_continuing_from_left_cn);
            String r104 = UtilsKt.c().getString(R.string.larus_tutor_restart_explanation_cn);
            final LiveTutorViewModel r105 = this.this$0;
            View r112 = r111.i(r103, r104, new k0(r105));
            LiveTutorTrackerService r106 = kj9.b.c();
            if (r106 == null) goto L11;
            com.larus.livetutor.impl.utils.track.a.b(r106, "if_continue", UtilsKt.c().getString(R.string.larus_tutor_continuing_from_left_cn), null, null, null, null, 60);
        L11:
            this.L$0 = r112;
            this.label = 1;
            if (DelayKt.delay(5000, this) != r100) goto L14;
            return r100;
        L14:
            r102 = r112;
            goto L15
        }
    }

    /* JADX INFO: renamed from: com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel$tryCallOnStart$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel$tryCallOnStart$1", f = "LiveTutorViewModel.kt", i = {}, l = {UploadKeys.KeyIsTTNetEngineFallback}, m = "invokeSuspend", n = {}, s = {})
    public static final class C114771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ StartControlMsg $msg;
        int label;
        final /* synthetic */ LiveTutorViewModel this$0;

        public C114771(LiveTutorViewModel r100, StartControlMsg r101, Continuation<? super C114771> r102) {
            this.this$0 = r100;
            this.$msg = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C114771(this.this$0, this.$msg, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C114771) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r310) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r310);
            Object r102 = r310;
        L19:
            Pair r103 = (Pair) r102;
            if (r103 != null) goto L22;
        L21:
            r103 = TuplesKt.to(Boxing.boxInt(-1), "rtcService is null");
        L22:
            int r104 = ((Number) r103.component1()).intValue();
            String r105 = (String) r103.component2();
            if (r104 != 0) goto L25;
            this.this$0.notifyPageRefreshStatus(PageStateViewModel.RefreshStatus.SUCCESS);
        L27:
            return Unit.INSTANCE;
        L25:
            LiveTutorViewModel.access$receiveRtcError(this.this$0, new RTCServiceStatus.Error(RTCMonitor.Companion.BusinessErrorType.RTC_SIGNAL_CLIENT_SEND_ERROR.getValue(), r104, r105));
            goto L27
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r310);
            com.larus.livetutor.impl.rtc.l0 r106 = LiveTutorViewModel.access$getRtcService(this.this$0);
            if (r106 == null) goto L21;
            StartControlMsg r110 = this.$msg;
            this.label = 1;
            kotlinx.coroutines.j r111 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
            r111.C();
            TutorRTCServiceImpl r107 = r106.f356397b;
            if (r107 == null) goto L14;
            com.larus.livetutor.impl.rtc.j0 r108 = new com.larus.livetutor.impl.rtc.j0(r111);
            Intrinsics.checkNotNullParameter(r110, "msg");
            Intrinsics.checkNotNullParameter(r108, "callback");
            r107.f356260y = r110.getTutorId();
            FLogger.f375446a.i("TutorRTCServiceImpl", "onCallStart start " + r110.getTutorId());
            r107.f().getClass();
            Intrinsics.checkNotNullParameter("live_tutor_start_control", "scene");
            r107.g().c(new Signal(SignalType.StartControl, null, null, null, null, null, null, null, null, 0 == true ? 1 : 0, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, r110, null, null, null, null, null, null, null, null, null, null, null, 134184958, null), new com.larus.livetutor.impl.rtc.d0(r108));
        L14:
            r102 = r111.B();
            if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
            DebugProbesKt.probeCoroutineSuspended(this);
        L17:
            if (r102 != r100) goto L19;
            return r100;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit Ap(boolean r100, LiveTutorDoubaoTrackerData r101) {
        return restart2Learn$lambda$18$lambda$17(r100, r101);
    }

    public static /* synthetic */ void Bp(LiveTutorViewModel r100) {
        longThinkingTimeOut$lambda$4(r100);
    }

    public static /* synthetic */ Unit Cp(LiveTutorViewModel r100, boolean r101) {
        return restart2Learn$lambda$18(r100, r101);
    }

    public static /* synthetic */ Unit Dp(LiveTutorViewModel r100, ControlReason r101) {
        return refreshData$lambda$12(r100, r101);
    }

    public static /* synthetic */ LiveTutorSubtitleFragment Fp(LiveTutorViewModel r100) {
        return subtitleFragment_delegate$lambda$9(r100);
    }

    public static /* synthetic */ Unit Mo(LiveTutorDoubaoTrackerData r100) {
        return onUserTextSend$lambda$42(r100);
    }

    public static /* synthetic */ Unit No(boolean r100) {
        return updatePitch$lambda$50(r100);
    }

    public static /* synthetic */ Unit Oo(LiveTutorViewModel r100, boolean r101) {
        return onUserTextSend$lambda$41(r100, r101);
    }

    public static /* synthetic */ Unit Po(LiveTutorViewModel r100) {
        return doExit$lambda$22(r100);
    }

    public static /* synthetic */ void Qo(LiveTutorViewModel r100, DialogInterface r101) {
        openSettingsDialog$lambda$48$lambda$47(r100, r101);
    }

    public static /* synthetic */ Unit So(boolean r100, LiveTutorDoubaoTrackerData r101) {
        return onUserTextSend$lambda$41$lambda$40(r100, r101);
    }

    public static /* synthetic */ Unit To(LiveTutorViewModel r100, boolean r101) {
        return onUserAsrTextSend$lambda$38(r100, r101);
    }

    public static /* synthetic */ LiveTutorWaitController Wo(LiveTutorViewModel r100) {
        return waitController_delegate$lambda$0(r100);
    }

    public static /* synthetic */ Unit Yo(int r100, Function0 r101, LiveTutorViewModel r102, boolean r103, boolean r104) {
        return tryFinishRtc$lambda$23(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ LiveTutorConfig Zo() {
        return liveTutorConfig_delegate$lambda$1();
    }

    public static /* synthetic */ Unit ap(LiveTutorViewModel r100) {
        return transitionEnterTeachWithAnim$lambda$28(r100);
    }

    public static /* synthetic */ Unit bp(LiveTutorViewModel r100) {
        return subtitleFragment_delegate$lambda$9$lambda$8$lambda$7(r100);
    }

    public static /* synthetic */ Unit cp(LiveTutorViewModel r100, boolean r101) {
        return retryConnectRtc$lambda$25(r100, r101);
    }

    private final void doExit() {
        tryFinishRtc$default(this, 0, false, new k(this), 3, null);
    }

    public static /* synthetic */ Unit dp(LiveTutorDoubaoTrackerData r100) {
        return onUserAsrTextSend$lambda$39(r100);
    }

    public static /* synthetic */ Unit ep(LiveTutorViewModel r100, ControlReason r101, View r102) {
        return showResumeFailTips$lambda$19(r100, r101, r102);
    }

    public static /* synthetic */ void hp(LiveTutorViewModel r100) {
        longLoadingTimeOut$lambda$6(r100);
    }

    public static /* synthetic */ LiveTutorV2Params ip(LiveTutorViewModel r100) {
        return liveTutorV2Params_delegate$lambda$3(r100);
    }

    public static /* synthetic */ void kp(LiveTutorViewModel r100) {
        exitAndResetState$lambda$52(r100);
    }

    public static /* synthetic */ Unit lp(boolean r100) {
        return updateSpeed$lambda$49(r100);
    }

    public static /* synthetic */ Unit np(LiveTutorViewModel r100, ControlReason r101) {
        return refreshData$lambda$13(r100, r101);
    }

    public static /* synthetic */ Unit pp(boolean r100) {
        return onUserAsrCancel$lambda$33(r100);
    }

    public static /* synthetic */ Unit rp(LiveTutorViewModel r100, UserAsrEndMsg r101) {
        return onUserAsrEnd$lambda$36(r100, r101);
    }

    public static /* synthetic */ Unit sp(LiveTutorDoubaoTrackerData r100) {
        return onUserAsrEnd$lambda$34(r100);
    }

    public static /* synthetic */ Unit tp(LiveTutorViewModel r100, UserSetting r101, Function1 r102, boolean r103) {
        return updateUserSettings$lambda$51(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit up(LiveTutorViewModel r100, boolean r101) {
        return onUserAsrStart$lambda$32(r100, r101);
    }

    public static /* synthetic */ Unit vp(UserAsrEndMsg r100, LiveTutorDoubaoTrackerData r101) {
        return onUserAsrEnd$lambda$36$lambda$35(r100, r101);
    }

    public static /* synthetic */ Unit wp(boolean r100) {
        return requestAudioCapturePermission$lambda$29(r100);
    }

    public static /* synthetic */ Unit xp(boolean r100, LiveTutorDoubaoTrackerData r101) {
        return onUserAsrTextSend$lambda$38$lambda$37(r100, r101);
    }

    public static /* synthetic */ Unit yp(Function1 r100, LogEntity r101) {
        return addDebugInfo$lambda$31(r100, r101);
    }

    public static /* synthetic */ void zp(LiveTutorViewModel r100) {
        longAsrSubmitTimeOut$lambda$5(r100);
    }

    /* JADX INFO: renamed from: startRefreshData, reason: avoid collision after fix types in other method */
    public void startRefreshData2(ITutorRefresh.RefreshStrategy r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
    }

    private final void broadcastClosePageEvent() {
        kj9.b.a("[broadcastClosePageEvent]");
        Iterator<T> r100 = this.closePageListeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Function0) r100.next()).invoke();
        goto L4
    }

    private final LiveTutorV2Params buildParams() {
        LiveTutorHybridContainer r100 = this.container;
        Intent r101 = r100.getContext().getIntent();
        Long r102 = null;
        if (r101 == null) goto L7;
        Bundle r103 = r101.getExtras();
        if (r103 == null) goto L7;
        Object r104 = r103.get(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE);
    L9:
        if ((r104 instanceof Integer) == true) goto L11;
        r104 = null;
    L11:
        Integer r105 = (Integer) r104;
        if (r105 != null) goto L21;
        Uri r106 = r100.getContext().getIntent().getData();
        if (r106 == null) goto L16;
        String r107 = UriProtector.getQueryParameter(r106, ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE);
    L18:
        if ((r107 instanceof Integer) == true) goto L20;
        r107 = null;
    L20:
        r105 = (Integer) r107;
        goto L21
    L16:
        r107 = null;
    L21:
        if (r105 == null) goto L23;
        int r108 = r105.intValue();
    L24:
        LiveTutorHybridContainer r109 = this.container;
        Intent r110 = r109.getContext().getIntent();
        if (r110 == null) goto L29;
        Bundle r111 = r110.getExtras();
        if (r111 == null) goto L29;
        Object r112 = r111.get("query_text");
    L31:
        if ((r112 instanceof String) == true) goto L33;
        r112 = null;
    L33:
        String r113 = (String) r112;
        if (r113 != null) goto L42;
        Uri r114 = r109.getContext().getIntent().getData();
        if (r114 == null) goto L38;
        r113 = UriProtector.getQueryParameter(r114, "query_text");
    L40:
        if ((r113 instanceof String) == true) goto L42;
        String r115 = null;
    L43:
        LiveTutorHybridContainer r116 = this.container;
        Intent r117 = r116.getContext().getIntent();
        if (r117 == null) goto L48;
        Bundle r118 = r117.getExtras();
        if (r118 == null) goto L48;
        Object r119 = r118.get("image_uri");
    L50:
        if ((r119 instanceof String) == true) goto L52;
        r119 = null;
    L52:
        String r120 = (String) r119;
        if (r120 != null) goto L61;
        Uri r121 = r116.getContext().getIntent().getData();
        if (r121 == null) goto L57;
        r120 = UriProtector.getQueryParameter(r121, "image_uri");
    L59:
        if ((r120 instanceof String) == true) goto L61;
        r120 = null;
        goto L61
    L57:
        r120 = null;
    L61:
        LiveTutorHybridContainer r122 = this.container;
        Intent r123 = r122.getContext().getIntent();
        if (r123 == null) goto L66;
        Bundle r124 = r123.getExtras();
        if (r124 == null) goto L66;
        Object r125 = r124.get("image_url");
    L68:
        if ((r125 instanceof String) == true) goto L70;
        r125 = null;
    L70:
        String r126 = (String) r125;
        if (r126 != null) goto L79;
        Uri r127 = r122.getContext().getIntent().getData();
        if (r127 == null) goto L75;
        r126 = UriProtector.getQueryParameter(r127, "image_url");
    L77:
        if ((r126 instanceof String) == true) goto L79;
        r126 = null;
        goto L79
    L75:
        r126 = null;
    L79:
        LiveTutorHybridContainer r128 = this.container;
        Intent r129 = r128.getContext().getIntent();
        if (r129 == null) goto L84;
        Bundle r130 = r129.getExtras();
        if (r130 == null) goto L84;
        Object r131 = r130.get("live_tutor_rec_query_id");
    L86:
        if ((r131 instanceof String) == true) goto L88;
        r131 = null;
    L88:
        String r132 = (String) r131;
        if (r132 != null) goto L97;
        Uri r133 = r128.getContext().getIntent().getData();
        if (r133 == null) goto L93;
        r132 = UriProtector.getQueryParameter(r133, "live_tutor_rec_query_id");
    L95:
        if ((r132 instanceof String) == true) goto L97;
        r132 = null;
        goto L97
    L93:
        r132 = null;
    L97:
        LiveTutorHybridContainer r134 = this.container;
        Intent r135 = r134.getContext().getIntent();
        if (r135 == null) goto L102;
        Bundle r136 = r135.getExtras();
        if (r136 == null) goto L102;
        Object r137 = r136.get(MusicAppletPage.KEY_MESSAGE_ID);
    L104:
        if ((r137 instanceof String) == true) goto L106;
        r137 = null;
    L106:
        String r138 = (String) r137;
        if (r138 != null) goto L115;
        Uri r139 = r134.getContext().getIntent().getData();
        if (r139 == null) goto L111;
        r138 = UriProtector.getQueryParameter(r139, MusicAppletPage.KEY_MESSAGE_ID);
    L113:
        if ((r138 instanceof String) == true) goto L115;
        r138 = null;
        goto L115
    L111:
        r138 = null;
    L115:
        LiveTutorHybridContainer r140 = this.container;
        Intent r141 = r140.getContext().getIntent();
        if (r141 == null) goto L120;
        Bundle r142 = r141.getExtras();
        if (r142 == null) goto L120;
        Object r143 = r142.get("enter_method");
    L122:
        if ((r143 instanceof String) == true) goto L124;
        r143 = null;
    L124:
        String r144 = (String) r143;
        if (r144 != null) goto L133;
        Uri r145 = r140.getContext().getIntent().getData();
        if (r145 == null) goto L129;
        r144 = UriProtector.getQueryParameter(r145, "enter_method");
    L131:
        if ((r144 instanceof String) == true) goto L133;
        r144 = null;
        goto L133
    L129:
        r144 = null;
    L133:
        if (r144 != null) goto L135;
        r144 = "suggested_prompt";
    L135:
        String r146 = r144;
        LiveTutorHybridContainer r147 = this.container;
        Intent r148 = r147.getContext().getIntent();
        if (r148 == null) goto L140;
        Bundle r149 = r148.getExtras();
        if (r149 == null) goto L140;
        Object r150 = r149.get("tutor_id");
    L142:
        if ((r150 instanceof Long) == true) goto L144;
        r150 = null;
    L144:
        Long r151 = (Long) r150;
        if (r151 != null) goto L154;
        Uri r152 = r147.getContext().getIntent().getData();
        if (r152 == null) goto L149;
        String r153 = UriProtector.getQueryParameter(r152, "tutor_id");
    L151:
        if ((r153 instanceof Long) == true) goto L153;
        r153 = null;
    L153:
        r151 = (Long) r153;
        goto L154
    L149:
        r153 = null;
    L154:
        LiveTutorV2Params r154 = new LiveTutorV2Params(Integer.valueOf(r108), null, null, null, null, r146, 30, null);
        boolean r155 = false;
        if (r108 != TutorEntranceType.DoubaoActionbarPage.getValue()) goto L177;
        if (r132 != null) goto L159;
    L162:
        boolean r156 = true;
    L163:
        if (r156 == true) goto L165;
        int r157 = LiveTutorQueryType.FixedQuery.getValue();
    L172:
        Integer r158 = Integer.valueOf(r157);
        List r159 = CollectionsKt.listOfNotNull(oj9.b.a(r126, r120));
        if (r132 == null) goto L175;
        r102 = StringsKt.toLongOrNull(r132);
    L175:
        r154.setDoubaoActionbarPageQueryParams(new DoubaoActionbarPageQueryParams(r158, r159, r115, r102));
    L212:
        return r154;
    L165:
        if (r115 != null) goto L167;
    L168:
        r155 = true;
    L169:
        if (r155 == true) goto L171;
        r157 = LiveTutorQueryType.Text.getValue();
        goto L172
    L171:
        r157 = LiveTutorQueryType.Image.getValue();
        goto L172
    L167:
        if (r115.length() != 0) goto L169;
    L159:
        if (r132.length() == 0) goto L162;
        r156 = false;
        goto L163
    L177:
        if (r108 != TutorEntranceType.DoubaoSuggest.getValue()) goto L191;
        if (r115 != null) goto L181;
    L182:
        r155 = true;
    L183:
        if (r155 == false) goto L185;
        LiveTutorQueryType r160 = LiveTutorQueryType.Image;
    L186:
        Integer r161 = Integer.valueOf(r160.getValue());
        List r162 = CollectionsKt.listOfNotNull(oj9.b.a(r126, r120));
        Long r163 = null;
        if (r138 == null) goto L189;
        r102 = StringsKt.toLongOrNull(r138);
    L189:
        r154.setDoubaoSuggestQueryParams(new DoubaoSuggestQueryParams(r161, r162, r115, r163, r102, 8, null));
        goto L212
    L185:
        r160 = LiveTutorQueryType.Text;
        goto L186
    L181:
        if (r115.length() != 0) goto L183;
    L191:
        if (r108 != TutorEntranceType.History.getValue()) goto L212;
        r154.setLiveTutorId(r151);
        if (r132 != null) goto L195;
    L198:
        boolean r164 = true;
    L199:
        if (r164 == true) goto L201;
        int r165 = LiveTutorQueryType.FixedQuery.getValue();
    L208:
        Integer r166 = Integer.valueOf(r165);
        List r167 = CollectionsKt.listOfNotNull(oj9.b.a(r126, r120));
        if (r132 == null) goto L211;
        r102 = StringsKt.toLongOrNull(r132);
    L211:
        r154.setDoubaoActionbarPageQueryParams(new DoubaoActionbarPageQueryParams(r166, r167, r115, r102));
        goto L212
    L201:
        if (r115 != null) goto L203;
    L204:
        r155 = true;
    L205:
        if (r155 == true) goto L207;
        r165 = LiveTutorQueryType.Text.getValue();
        goto L208
    L207:
        r165 = LiveTutorQueryType.Image.getValue();
        goto L208
    L203:
        if (r115.length() != 0) goto L205;
    L195:
        if (r132.length() == 0) goto L198;
        r164 = false;
    L140:
        r150 = null;
    L120:
        r143 = null;
    L102:
        r137 = null;
    L84:
        r131 = null;
    L66:
        r125 = null;
    L48:
        r119 = null;
        goto L50
    L38:
        r113 = null;
    L42:
        r115 = r113;
    L29:
        r112 = null;
        goto L31
    L23:
        r108 = TutorEntranceType.DoubaoSuggest.getValue();
    L7:
        r104 = null;
        goto L9
    }

    private final boolean cannotClick() {
        if (Intrinsics.areEqual(this.pressState.getValue(), Boolean.TRUE) == false) goto L5;
    L10:
        return true;
    L5:
        if (this.saveController.c() == true) goto L10;
        if (getPageReady() == false) goto L10;
        return false;
    }

    private final void closeAudioCaptureState() {
        kj9.b.a("[closeAudioCaptureState]");
        com.larus.livetutor.impl.rtc.l0 r100 = getRtcService();
        if (r100 == null) goto L8;
        TutorRTCServiceImpl r101 = r100.f356397b;
        if (r101 == null) goto L9;
        r101.p(false);
        return;
    L9:
        return;
    }

    private final void dispatchRefreshState() {
        l0 r100 = this.webviewLoadStatus;
        l0 r101 = this.rtcConnectStatus;
        if (r100 == null) goto L13;
        if (r101 == null) goto L13;
        if (nj9.b.c(r101) == true) goto L10;
        eLogger("dispatchRefreshState", "rtc error: " + r101);
        PageStateViewModel.RefreshStatus r102 = PageStateViewModel.RefreshStatus.API_ERROR;
        r102.setPageChildState(r101);
        notifyPageRefreshStatus(r102);
        com.larus.livetutor.impl.hybrid.b.b(this.container, this.longLoadingTimeOut);
        return;
    L10:
        if (nj9.b.c(r100) == true) goto L12;
        eLogger("dispatchRefreshState", "webview error: " + r100);
        PageStateViewModel.RefreshStatus r103 = PageStateViewModel.RefreshStatus.API_ERROR;
        r103.setPageChildState(r100);
        notifyPageRefreshStatus(r103);
        com.larus.livetutor.impl.hybrid.b.b(this.container, this.longLoadingTimeOut);
        return;
    L12:
        tryCallOnStart();
        com.larus.livetutor.impl.hybrid.b.b(this.container, this.longLoadingTimeOut);
        return;
    L13:
        dLogger("dispatchRefreshState", "waiting other result: rtcConnectStatus = " + r101 + ", webviewLoadStatus = " + r100);
        recordFirstLoadingFail(r100, r101);
        com.larus.livetutor.impl.hybrid.b.b(this.container, this.longLoadingTimeOut);
        com.larus.livetutor.impl.hybrid.b.a(this.container, 20000, this.longLoadingTimeOut);
    }

    private final void exitAndResetState() {
        com.larus.livetutor.impl.hybrid.b.b(this.container, this.longThinkingTimeOut);
        com.larus.livetutor.impl.hybrid.b.b(this.container, this.longAsrSubmitTimeOut);
        Job r100 = this.restartPopDismissJob;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.restartPopDismissJob = null;
        Job r101 = this.backgroundExitJob;
        if (r101 == null) goto L8;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L8:
        this.backgroundExitJob = null;
        this.pauseController.d();
        this.saveController.e();
        LiveTutorFeedbackController r102 = this.feedbackController;
        r102.f356438d.removeCallbacks(r102.f356440f);
        com.larus.livetutor.impl.tutor.controller.t r103 = this.imagePreviewController;
        Dialog r104 = r103.f356541e;
        if (r104 == null) goto L11;
        com.larus.livetutor.impl.tutor.controller.t.a(r104);
    L11:
        r103.f356541e = null;
        LiveTutorHybridContainer r105 = this.container;
        Runnable r106 = new h0(this);
        Intrinsics.checkNotNullParameter(r105, "<this>");
        Intrinsics.checkNotNullParameter(r106, "action");
        ((Handler) r105.f356152b.getValue()).post(r106);
    }

    private final boolean getPageReady() {
        if (nj9.b.c(this.rtcConnectStatus) == true) goto L5;
    L7:
        return false;
    L5:
        if (nj9.b.c(this.webviewLoadStatus) == false) goto L7;
        return true;
    }

    private final com.larus.livetutor.impl.rtc.l0 getRtcService() {
        boolean r100 = kj9.b.f503724a;
        String r101 = this.enterTime;
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        kj9.b.a("getTutorRtcService uniqueKey=" + r101 + " isRegistered=" + kj9.b.f503724a);
        Map<String, com.larus.livetutor.impl.rtc.l0> r102 = kj9.b.f503726c;
        if (r102.containsKey(r101) == true) goto L7;
        r102.put(r101, new com.larus.livetutor.impl.rtc.l0());
        return (com.larus.livetutor.impl.rtc.l0) ((LinkedHashMap) r102).get(r101);
    L7:
        return (com.larus.livetutor.impl.rtc.l0) ((LinkedHashMap) r102).get(r101);
    }

    private final LiveTutorSubtitleFragment getSubtitleFragment() {
        return (LiveTutorSubtitleFragment) this.subtitleFragment$delegate.getValue();
    }

    private final LiveTutorWaitController getWaitController() {
        return (LiveTutorWaitController) this.waitController$delegate.getValue();
    }

    private final void requestAudioCapturePermission() {
        kj9.b.a("[requestAudioCapturePermission]");
        List<String> r100 = CollectionsKt.mutableListOf(new String[]{"android.permission.RECORD_AUDIO"});
        i2.f365748b.a(this.container.getContext(), r100, new f());
    }

    private final void showRestartInfoPop() {
        LiveTutorCallInfo r100 = this.callInfo;
        if (r100 == null) goto L10;
        Integer r101 = r100.getConsumeStatus();
        int r102 = ConsumeStatus.Consume.getValue();
        if (r101 == null) goto L10;
        if (r101.intValue() != r102) goto L10;
        boolean r103 = true;
    L11:
        Integer r104 = null;
        if (r103 == true) goto L14;
    L18:
        boolean r105 = kj9.b.f503724a;
        StringBuilder r106 = new StringBuilder("[showRestartInfoPop] consumeStatus = ");
        LiveTutorCallInfo r107 = this.callInfo;
        if (r107 == null) goto L21;
        r104 = r107.getConsumeStatus();
    L21:
        r106.append(r104);
        r106.append(", hasAlreadyCallStartSuccess = ");
        r106.append(this.hasAlreadyCallStartSuccess);
        r106.append(", return");
        kj9.b.a(r106.toString());
        return;
    L14:
        if (this.hasAlreadyCallStartSuccess == true) goto L18;
        this.restartPopDismissJob = UtilsKt.m(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), new C114761(this, null), 2);
        return;
    L10:
        r103 = false;
        goto L11
    }

    private final void tryCallOnStart() {
        StartControlMsg r100 = new StartControlMsg(Long.valueOf(this.tutorId), ControlAction.Continue, Long.valueOf(this.searchId), Long.valueOf(this.resId));
        boolean r101 = kj9.b.f503724a;
        kj9.b.a("[callOnStart] " + r100);
        UtilsKt.m(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), new C114771(this, r100, null), 2);
    }

    public final void closePage() {
        kj9.b.a("[closePage]");
        broadcastClosePageEvent();
        final LiveTutorFeedbackController r100 = this.feedbackController;
        if (r100.f356439e == false) goto L5;
    L8:
        final AnonymousClass1 r101 = new AnonymousClass1(this);
        final AnonymousClass2 r102 = new AnonymousClass2(this);
        Intrinsics.checkNotNullParameter(r101, "doExit");
        Intrinsics.checkNotNullParameter(r102, "finishRtc");
        LiveTutorCallInfo r103 = r100.f356436b.getCallInfo();
        boolean r104 = true;
        if (r103 == null) goto L16;
        Integer r105 = r103.getFeedbackStatus();
        int r106 = FeedbackStatus.Evaluated.getValue();
        if (r105 == null) goto L16;
        if (r105.intValue() != r106) goto L16;
        boolean r107 = true;
    L18:
        if ((!r107) == false) goto L68;
        long r108 = System.currentTimeMillis();
        Lazy r109 = com.larus.livetutor.impl.utils.i.f356679a;
        Intrinsics.checkNotNullParameter("live_tutor_feedback_last_show_time", "key");
        if (UtilsKt.e(r108, com.larus.livetutor.impl.utils.i.a().getLong("live_tutor_feedback_last_show_time", 0)) == true) goto L22;
        Intrinsics.checkNotNullParameter("live_tutor_feedback_times_in_day", "key");
        com.larus.livetutor.impl.utils.i.a().storeInt("live_tutor_feedback_times_in_day", 0);
    L25:
        boolean r110 = false;
    L26:
        if (r110 == false) goto L28;
        StringBuilder r111 = new StringBuilder("[LiveTutorFeedbackController] checkFrequency hit dayLimit, lastShow = ");
        Intrinsics.checkNotNullParameter("live_tutor_feedback_last_show_time", "key");
        r111.append(com.larus.livetutor.impl.utils.i.a().getLong("live_tutor_feedback_last_show_time", 0));
        kj9.b.a(r111.toString());
    L39:
        boolean r112 = false;
    L41:
        if (r112 == false) goto L68;
        CommonFeedbackModel r113 = (CommonFeedbackModel) ((HashMap) CommonFeedbackConfig.f356555b).get("live_tutor_exit_feedback_root_feedback_node_id");
        if (r113 == null) goto L47;
        CommonFeedbackItemEntity r114 = (CommonFeedbackItemEntity) CollectionsKt.firstOrNull(r113.getEntities());
        if (r114 == null) goto L47;
        kj9.b.a("[showFeedback] model = " + r113 + ", entity = " + r114);
        List<Integer> r115 = r114.getSelectedIds();
        List<EvaluateLabel> r116 = r114.getCommonLabels();
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator<T> r118 = r116.iterator();
    L50:
        if (r118.hasNext() == false) goto L59;
        EvaluateLabel r119 = (EvaluateLabel) r118.next();
        Integer r120 = r119.getEvaluateLabelId();
        if (r120 == null) goto L54;
        int r121 = r120.intValue();
    L55:
        String r122 = r119.getEvaluateLabelDesc();
        if (r122 != null) goto L58;
        r122 = "";
    L58:
        r117.add(new m2(r121, r122, CollectionsKt.contains(r115, r119.getEvaluateLabelId()), 8));
        goto L50
    L54:
        r121 = 0;
        goto L55
    L59:
        final List r123 = CollectionsKt.toMutableList(r117);
        final CommonFeedbackDialog r124 = new CommonFeedbackDialog(r100.f356435a);
        Function3<? super String, ? super Map<Integer, EvaluateLabel>, ? super List<m2>, Boolean> r125 = new com.larus.livetutor.impl.tutor.controller.k(r123);
        Intrinsics.checkNotNullParameter(r125, "<set-?>");
        r124.f356700v = r125;
        Function3<? super String, ? super Map<Integer, EvaluateLabel>, ? super List<m2>, String> r126 = new com.larus.livetutor.impl.tutor.controller.l(r123);
        Intrinsics.checkNotNullParameter(r126, "<set-?>");
        r124.f356701w = r126;
        Function3<? super String, ? super Map<Integer, EvaluateLabel>, ? super List<m2>, Boolean> r127 = new com.larus.livetutor.impl.tutor.controller.m();
        Intrinsics.checkNotNullParameter(r127, "<set-?>");
        r124.f356702x = r127;
        r124.f356697s = new com.larus.livetutor.impl.tutor.controller.n(r124, r101);
        r124.f356699u = new com.larus.livetutor.impl.tutor.controller.o();
        r124.f356698t = new com.larus.livetutor.impl.tutor.controller.p(r100, r124, r101);
        StarItemEntity r128 = new StarItemEntity(r123);
        Intrinsics.checkNotNullParameter(r128, "starItemEntity");
        r124.f356695q = r128;
        r124.setOnShowListener(new com.larus.livetutor.impl.tutor.controller.q(r102));
        r124.setCanceledOnTouchOutside(false);
        if (DialogLancet.shouldBlockDialogShow(r124) == false) goto L71;
        DialogLancet.handleBlockedDialogShow(r124);
    L64:
        if (r104 == false) goto L68;
        return;
    L71:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L70
    L63:
        DialogLancet.beforeDialogShow(r124);
        r124.show();
        DialogLancet.afterDialogShow(r124);
    L47:
        r104 = false;
        goto L64
    L28:
        long r129 = r100.f356436b.getLiveTutorConfig().getFeedbackCloseCd() * 1000;
        long r130 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter("live_tutor_feedback_close_time", "key");
        long r131 = com.larus.livetutor.impl.utils.i.a().getLong("live_tutor_feedback_close_time", 0);
        if (r129 < 0) goto L31;
        boolean r132 = true;
    L32:
        if (r132 == false) goto L67;
        if (Math.abs(r130 - r131) > r129) goto L36;
        boolean r133 = true;
    L37:
        if (r133 == false) goto L40;
        StringBuilder r134 = new StringBuilder("[LiveTutorFeedbackController] checkFrequency hit closeLimit, closeTime = ");
        Intrinsics.checkNotNullParameter("live_tutor_feedback_close_time", "key");
        r134.append(com.larus.livetutor.impl.utils.i.a().getLong("live_tutor_feedback_close_time", 0));
        kj9.b.a(r134.toString());
        goto L39
    L40:
        r112 = true;
        goto L41
    L36:
        r133 = false;
        goto L37
    L67:
        throw new IllegalArgumentException("duration must be non-negative".toString());
    L31:
        r132 = false;
        goto L32
    L22:
        Intrinsics.checkNotNullParameter("live_tutor_feedback_times_in_day", "key");
        if (com.larus.livetutor.impl.utils.i.a().getInt("live_tutor_feedback_times_in_day", 0) < r100.f356436b.getLiveTutorConfig().getFeedbackDayLimit()) goto L25;
        r110 = true;
    L68:
        r101.invoke();
        return;
    L16:
        r107 = false;
        goto L18
    L5:
        if (this.teachEnd == true) goto L8;
        kj9.b.a("[tryShowDialogAndExit] No Dialog: time: " + this.feedbackController.f356439e + ", teachEnd: " + this.teachEnd);
        doExit();
    }

    public final void dismissTtsSpeedControlHint() {
        this.dismissTtsSpeedControlHintEvent.postValue(Unit.INSTANCE);
    }

    public final ij9.a getCurrentContentState() {
        if ((CollectionsKt.lastOrNull(this.rtcPageState.getReplayCache()) instanceof RTCServiceStatus.Connected) == true) goto L7;
        return null;
    L7:
        return (ij9.a) CollectionsKt.lastOrNull(this.contentState.getReplayCache());
    }

    public final RTCServiceStatus getCurrentPageState() {
        return (RTCServiceStatus) CollectionsKt.lastOrNull(this.rtcPageState.getReplayCache());
    }

    public final PauseLocation getCurrentPauseLocation() {
        return new PauseLocation(Long.valueOf(this.subtitleController.f356461e), Long.valueOf(this.subtitleController.f356464h));
    }

    public final LiveTutorConfig getLiveTutorConfig() {
        return (LiveTutorConfig) this.liveTutorConfig$delegate.getValue();
    }

    public final LiveTutorV2Params getLiveTutorV2Params() {
        return (LiveTutorV2Params) this.liveTutorV2Params$delegate.getValue();
    }

    public final lj9.a<String> getMessageCallback() {
        return this.messageController.f356445b;
    }

    public final LiveData<LiveTutorPauseEvent> getPauseRtc() {
        return this.pauseController.f356449b;
    }

    public final ij9.a getPreviousContentState() {
        if ((CollectionsKt.lastOrNull(this.rtcPageState.getReplayCache()) instanceof RTCServiceStatus.Connected) == true) goto L5;
    L7:
        return null;
    L5:
        if (this.contentState.getReplayCache().size() <= 1) goto L7;
        return (ij9.a) CollectionsKt.firstOrNull(this.contentState.getReplayCache());
    }

    public final LiveData<String> getSaveBoardUuid() {
        return this.saveController.f356498h;
    }

    public final int[] getWebViewLocation() {
        int[] r100 = new int[2];
        this.container.f356155e.f355978g.getBulletContainerView().getLocationInWindow(r100);
        return r100;
    }

    public final boolean isAnimTransiting() {
        return this.animController.f356432d;
    }

    public final boolean isPause() {
        LiveTutorPauseController r100 = this.pauseController;
        LiveTutorPauseEvent r101 = r100.f356449b.getValue();
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
    L11:
        return true;
    L10:
        if ((!r100.f356450c.isEmpty()) == true) goto L11;
        return false;
    L5:
        if (r101.getPauseStatus() != true) goto L7;
        r102 = true;
        goto L8
    }

    public final void onDestroy() {
        LiveTutorAnimController r100 = this.animController;
        r100.c();
        r100.b(null);
        r100.f356431c = null;
        LottieCompositionFactory.clearCache();
        this.subtitleController.f356459c = null;
        com.larus.livetutor.impl.tutor.controller.h0 r101 = this.saveController;
        EventCenter.unregisterJsEventSubscriber("liveTutorSendBoardImg", r101.f356499i);
        r101.e();
        EventCenter.unregisterJsEventSubscriber("liveTutorConvenientContinue", getWaitController().f356469e);
        com.larus.livetutor.impl.tutor.controller.t r102 = this.imagePreviewController;
        EventCenter.unregisterJsEventSubscriber("liveTutorPreviewImage", r102.f356540d);
        Dialog r103 = r102.f356541e;
        if (r103 == null) goto L5;
        com.larus.livetutor.impl.tutor.controller.t.a(r103);
    L5:
        r102.f356541e = null;
        this.feedbackController.getClass();
        ((HashMap) CommonFeedbackConfig.f356555b).clear();
        ((HashMap) CommonFeedbackConfig.f356556c).clear();
        this.closePageListeners.clear();
        exitAndResetState();
        this.resumeFailView = null;
        tryFinishRtc$default(this, 0, false, null, 7, null);
        releaseRtc();
        releaseTracker();
        boolean r104 = kj9.b.f503724a;
        kj9.b.a("onDestroy isRegistered=" + kj9.b.f503724a);
        kj9.b.f503724a = false;
        LiveTutorTrackerService r105 = kj9.b.f503727d;
        if (r105 == null) goto L8;
        ((ConcurrentHashMap) r105.f356687a).clear();
        r105.f356688b = null;
    L8:
        kj9.b.f503727d = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.livetutor.impl.repository.viewmodel.w] */
    public final void onUserAsrStart() {
        if (ContextCompat.checkSelfPermission(this.container.getContext(), "android.permission.RECORD_AUDIO") == 0) goto L6;
        requestAudioCapturePermission();
        return;
    L6:
        PauseLocation r100 = getCurrentPauseLocation();
        this.audioUuid = UUID.randomUUID().toString();
        this.asrStartState = getCurrentContentState();
        boolean r101 = kj9.b.f503724a;
        kj9.b.a("[onUserAsrStart] uuid = " + this.audioUuid + ", pauseLocation: " + r100);
        jj9.b r102 = getAudioController();
        if (r102 == 0) goto L9;
        r102.b(this.audioUuid, r100, new w(this));
    L9:
        this.container.b(null);
    }

    public final void openSubtitleFragment() {
        if (cannotClick() == false) goto L5;
        return;
    L5:
        kj9.b.a("[openSubtitleFragment]");
        ArrayList r100 = (ArrayList) this.subtitleController.f356460d;
        if ((!r100.isEmpty()) == true) goto L9;
        r100 = null;
    L9:
        if (r100 == null) goto L20;
        LiveTutorTrackerService r101 = kj9.b.c();
        if (r101 == null) goto L13;
        r101.f356690d.c();
    L13:
        LiveTutorSubtitleFragment r102 = getSubtitleFragment();
        long r103 = this.subtitleController.f356462f;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "data");
        ((ArrayList) r102.f356575i).clear();
        ((ArrayList) r102.f356575i).addAll(r100);
        r102.f356576j = r103;
        LiveTutorSubtitleFragment.SubtitleAdapter r104 = r102.f356574h;
        if (r104 == null) goto L16;
        r104.notifyDataSetChanged();
    L16:
        this.container.a(r102);
        dismissTtsSpeedControlHint();
        LiveTutorPauseController.b(this.pauseController, ControlReason.Subtitle, false, null, false, 14);
        LiveTutorTrackerService r105 = kj9.b.c();
        if (r105 == null) goto L21;
        com.larus.livetutor.impl.utils.track.a.a(r105, "subtitle", "blackboard_display", null, null, null, null, null, 124);
        return;
    L21:
        return;
    }

    public final void refreshConnectStatus() {
        if (nj9.b.c(this.rtcConnectStatus) == true) goto L6;
        this.rtcConnectStatus = null;
    L6:
        if (nj9.b.c(this.webviewLoadStatus) == true) goto L9;
        this.webviewLoadStatus = null;
        return;
    }

    public final void releaseRtc() {
        boolean r100 = kj9.b.f503724a;
        String r101 = this.enterTime;
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        if (r101.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L11;
        com.larus.livetutor.impl.rtc.l0 r103 = kj9.b.f503726c.remove(r101);
        if (r103 == null) goto L12;
        r103.d();
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void sendLongWaitTimeout() {
        dLogger("longWaitingTimeOut", "long time waiting, auto continue");
        com.larus.livetutor.impl.rtc.l0 r100 = getRtcService();
        if (r100 == null) goto L6;
        r100.e(new LiveTutorClientControlMsg(ControlAction.WaitTimeout, null, null, null, 14, null));
        return;
    }

    private static final LiveTutorConfig liveTutorConfig_delegate$lambda$1() {
        return com.larus.settings.tutor.d.a();
    }

    private final void openKeyBoard() {
        if (cannotClick() == false) goto L5;
        return;
    L5:
        kj9.b.a("[openKeyBoard]");
        this.container.b(null);
        LiveTutorPauseController.b(this.pauseController, ControlReason.Keyboard, false, null, false, 14);
        this.keyboardStatus.setValue(TuplesKt.to(Boolean.TRUE, Boolean.FALSE));
        LiveTutorTrackerService r100 = kj9.b.c();
        if (r100 == null) goto L9;
        com.larus.livetutor.impl.utils.track.a.a(r100, "click_keyboard", "guided_tutor_frame", null, null, null, null, null, 124);
        return;
    }

    public final void breakTimer() {
        com.larus.livetutor.impl.rtc.l0 r100 = getRtcService();
        if (r100 == null) goto L8;
        TutorRTCServiceImpl r101 = r100.f356397b;
        if (r101 == null) goto L9;
        r101.f();
        return;
    L9:
        return;
    }

    public final void clickToClose() {
        if (getPageReady() == true) goto L6;
        String r100 = "fail";
    L8:
        String r101 = r100;
    L10:
        LiveTutorTrackerService r102 = kj9.b.c();
        if (r102 != null) goto L13;
    L17:
        closePage();
        return;
    L13:
        if (Intrinsics.areEqual(r101, "page_loading") == false) goto L15;
        Long r103 = Long.valueOf(System.currentTimeMillis() - this.loadingStart);
    L16:
        com.larus.livetutor.impl.utils.track.a.a(r102, "exit_click", "guided_tutor_frame", r101, r103, null, null, null, 112);
        goto L17
    L15:
        r103 = null;
        goto L16
    L6:
        if (this.container.f356160j == false) goto L9;
        r100 = "teaching";
        goto L8
    L9:
        r101 = "page_loading";
        goto L10
    }

    public final void enterBackground() {
        this.backgroundTime = System.currentTimeMillis();
        Job r100 = this.backgroundExitJob;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        long r101 = getLiveTutorConfig().getBackLeaveRoomTimeout();
        boolean r102 = kj9.b.f503724a;
        kj9.b.a("[enterBackground]backgroundTime = " + this.backgroundTime + "\npageReady = " + getPageReady() + "\ndelayTime = " + r101 + "\nstatus = " + getCurrentContentState());
        if (this.leaveRoomByEnterBackground == false) goto L8;
        return;
    L8:
        if (r101 < 0) goto L12;
        this.backgroundExitJob = UtilsKt.n(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), new C114741(r101, this, null), 2);
        return;
    }

    public final void enterForeground() {
        LiveTutorTrackerService r100 = kj9.b.c();
        if (r100 == null) goto L10;
        long r101 = System.currentTimeMillis() - this.backgroundTime;
        RTCServiceStatus r102 = getCurrentPageState();
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L8:
        JSONObject r104 = new JSONObject();
        r104.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, "live_tutor_background_duation");
        r104.put(LocationMonitorConst.ERR_MSG, r103);
        JSONObject r105 = new JSONObject();
        r105.put("background_time", Float.valueOf(r101 / 1000.0f));
        LiveTutorTrackerService.b(r100, "live_tutor_tracker", LiveTutorTrackerService.c(r104, r105), 4);
        UtilsKt.j(r104, r100.a());
        ApmAgent.monitorEvent("live_tutor_tracker", r104, r105, new JSONObject());
        goto L10
    L7:
        r103 = null;
    L10:
        if (this.leaveRoomByEnterBackground == false) goto L12;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C114751(this, null), 2, null);
        return;
    L12:
        kj9.b.a("[enterForeground] no leaveRoomByEnterBackground, cancel backgroundExitJob");
        Job r106 = this.backgroundExitJob;
        if (r106 == null) goto L15;
        Job.DefaultImpls.cancel$default(r106, null, 1, null);
    L15:
        this.backgroundExitJob = null;
    }

    public final d1<RTCAction> getActionFlow() {
        com.larus.livetutor.impl.rtc.l0 r100 = getRtcService();
        if (r100 == null) goto L10;
        TutorRTCServiceImpl r101 = r100.f356397b;
        if (r101 == null) goto L11;
        com.larus.livetutor.impl.rtc.handler.v r102 = r101.h();
        if (r102 != null) goto L9;
        return null;
    L9:
        return r102.f356365d;
    L11:
        return null;
    L10:
        return null;
    }

    public final jj9.b getAudioController() {
        com.larus.livetutor.impl.rtc.l0 r100 = getRtcService();
        if (r100 == null) goto L7;
        TutorRTCServiceImpl r101 = r100.f356397b;
        if (r101 == null) goto L7;
        return (com.larus.livetutor.impl.rtc.handler.d) r101.f356248m.getValue();
    L7:
        return null;
    }

    public final d1<SubtitleStream> getAudioExtraFlow() {
        com.larus.livetutor.impl.rtc.l0 r100 = getRtcService();
        if (r100 == null) goto L9;
        TutorRTCServiceImpl r101 = r100.f356397b;
        if (r101 == null) goto L9;
        com.larus.livetutor.impl.rtc.handler.w r102 = r101.i();
        if (r102 == null) goto L9;
        return r102.f356372d;
    L9:
        return null;
    }

    public final i1<RTCNetworkQuality> getNetworkQualityFlow() {
        com.larus.livetutor.impl.rtc.l0 r100 = getRtcService();
        if (r100 == null) goto L13;
        TutorRTCServiceImpl r101 = r100.f356397b;
        if (r101 == null) goto L9;
        com.larus.livetutor.impl.rtc.handler.w r102 = r101.i();
        if (r102 == null) goto L9;
        MutableSharedFlow<RTCNetworkQuality> r103 = r102.f356376h;
    L10:
        if (r103 != null) goto L12;
        return null;
    L12:
        return kotlinx.coroutines.flow.e.F(r103, ViewModelKt.getViewModelScope(this), g1.a.a(g1.f504854a, 5000, 2), RTCNetworkQuality.NORMAL);
    L9:
        r103 = null;
        goto L10
    L13:
        return null;
    }

    public final d1<SubtitleMsg> getSubtitleMsgFlow() {
        com.larus.livetutor.impl.rtc.l0 r100 = getRtcService();
        if (r100 == null) goto L9;
        TutorRTCServiceImpl r101 = r100.f356397b;
        if (r101 == null) goto L9;
        com.larus.livetutor.impl.rtc.handler.w r102 = r101.i();
        if (r102 == null) goto L9;
        return r102.f356371c;
    L9:
        return null;
    }

    @Override // com.larus.livetutor.impl.repository.viewmodel.LiveTutorBaseViewModel, com.larus.livetutor.impl.tutor.controller.a
    public Map<String, Object> getTrackerParams() {
        Map<String, Object> r100 = MapsKt.toMutableMap(super.getTrackerParams());
        String r101 = "1";
        if (Intrinsics.areEqual(this.subtitleState.getValue(), Boolean.TRUE) == false) goto L5;
        Object r102 = "1";
    L6:
        r100.put("is_subtitle", r102);
        r100.put("tutor_part_idx", Long.valueOf(this.subtitleController.f356462f));
        if (AppHost.f326268a.a().isAppBackground() == true) goto L9;
        Object r103 = "1";
    L10:
        r100.put("is_foreground", r103);
        Double r104 = this.currentUserSetting.getTtsSpeed();
        if (r104 == null) goto L13;
        double r105 = r104.doubleValue();
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;
        r100.put("speed", String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r105)}, 1)));
    L13:
        Double r107 = this.currentUserSetting.getTtsPitch();
        if (r107 == null) goto L16;
        double r108 = r107.doubleValue();
        StringCompanionObject r109 = StringCompanionObject.INSTANCE;
        r100.put(TextureRenderKeys.KEY_IS_PITCH, String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(r108)}, 1)));
    L16:
        Boolean r110 = this.isUseTTWebview;
        if (r110 != null) goto L19;
    L23:
        return r100;
    L19:
        if (r110.booleanValue() == true) goto L22;
        r101 = "0";
    L22:
        r100.put("is_use_tt_webview", r101);
        goto L23
    L9:
        r103 = "0";
        goto L10
    L5:
        r102 = "0";
        goto L6
    }

    public final void openSettingsDialog() {
        if (cannotClick() == false) goto L5;
        return;
    L5:
        this.keyboardEvent.postValue(Boolean.FALSE);
        kj9.b.a("[openSettingsDialog]");
        LiveTutorSettingsDialog r100 = new LiveTutorSettingsDialog(this, this.container.getContext());
        r100.setOnShowListener(new j0(this));
        INVOKEVIRTUAL_com_larus_livetutor_impl_repository_viewmodel_LiveTutorViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r100);
        this.settingsDialog = r100;
        LiveTutorTrackerService r101 = kj9.b.c();
        if (r101 == null) goto L9;
        com.larus.livetutor.impl.utils.track.a.a(r101, "more", "guided_tutor_frame", null, null, null, null, null, 124);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.livetutor.impl.repository.viewmodel.i0, java.lang.Object] */
    public final void retryConnectRtc() {
        trackerOnRetryRtc();
        if (this.tutorId == 0) goto L5;
        final LiveTutorV2Params r100 = new LiveTutorV2Params(Integer.valueOf(TutorEntranceType.History.getValue()), Long.valueOf(this.tutorId), null, null, this.currentUserSetting, null, 44, null);
    L6:
        final com.larus.livetutor.impl.rtc.l0 r101 = getRtcService();
        if (r101 == null) goto L10;
        final ?? r102 = new i0(this);
        Intrinsics.checkNotNullParameter(r102, "callback");
        r101.b(true, new com.larus.livetutor.impl.rtc.g0(r101, r100, r102));
        return;
    L10:
        return;
    L5:
        r100 = getLiveTutorV2Params();
        goto L6
    }

    public final void saveBoard() {
        if (cannotClick() == false) goto L5;
        return;
    L5:
        com.larus.livetutor.impl.tutor.controller.h0 r100 = this.saveController;
        if (r100.c() == false) goto L8;
        r100.f356491a.eLogger("LiveTutorSaveController", "saveBoarding return");
    L21:
        LiveTutorPauseController.b(this.pauseController, ControlReason.DownloadBoard, false, null, false, 14);
        this.keyboardEvent.postValue(Boolean.FALSE);
        return;
    L8:
        kj9.b.a("[LiveTutorSaveController] saveBoard");
        String r101 = UUID.randomUUID().toString();
        r100.f356498h.setValue(r101);
        gj9.b.a(new gj9.d(r100.f356491a.getEnterTime(), r101, MapsKt.mapOf(new Pair[]{TuplesKt.to("image", oj9.b.b(r100.f356491a.getLiveTutorV2Params())), TuplesKt.to("text", oj9.b.c(r100.f356491a.getLiveTutorV2Params()))})));
        com.larus.livetutor.impl.hybrid.b.a(r100.f356492b, r100.f356491a.getLiveTutorConfig().getLongBoardGenerateTimeout(), r100.f356501k);
        r100.f356493c = System.currentTimeMillis();
        LiveTutorTrackerService r102 = kj9.b.c();
        if (r102 == null) goto L12;
        com.larus.livetutor.impl.utils.track.a.a(r102, SVGRenderEngine.SAVE, "guided_tutor_frame", null, null, null, null, null, 124);
    L12:
        if (r100.f356496f != null) goto L14;
        r100.f356496f = new com.larus.livetutor.impl.utils.g(r100.f356492b.getContext());
    L14:
        com.larus.livetutor.impl.utils.g r103 = r100.f356496f;
        if (r103 == null) goto L21;
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L24;
        DialogLancet.handleBlockedDialogShow(r103);
        goto L21
    L24:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L20:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
        goto L21
    }

    public final void showError() {
        breakTimer();
        this.animController.c();
        closeAudioCaptureState();
        LiveTutorHybridContainer r100 = this.container;
        r100.g();
        r100.b(null);
        reportEnterRetryErrorPage();
    }

    public final void switchPauseStatusProactively() {
        if (cannotClick() == false) goto L5;
        return;
    L5:
        boolean r100 = isPause();
        boolean r101 = kj9.b.f503724a;
        kj9.b.a("[switchPauseStatusProactively] isPause = " + r100);
        if (r100 == false) goto L8;
        LiveTutorPauseController.e(this.pauseController, ControlReason.PauseContinueButton, null, true, 2);
        String r102 = "put_on";
    L9:
        String r103 = r102;
        LiveTutorTrackerService r104 = kj9.b.c();
        if (r104 == null) goto L13;
        com.larus.livetutor.impl.utils.track.a.a(r104, r103, "guided_tutor_frame", null, null, null, null, null, 124);
        return;
    L13:
        return;
    L8:
        LiveTutorPauseController.b(this.pauseController, ControlReason.PauseContinueButton, false, null, true, 6);
        r102 = "put_off";
        goto L9
    }

    public final MutableLiveData<Configuration> getActivityConfiguration() {
        return this.activityConfiguration;
    }

    public final LiveTutorCallInfo getCallInfo() {
        return this.callInfo;
    }

    public final d1<ij9.a> getContentState() {
        return this.contentState;
    }

    public final UserSetting getCurrentUserSetting() {
        return this.currentUserSetting;
    }

    public final MutableLiveData<Unit> getDismissTtsSpeedControlHintEvent() {
        return this.dismissTtsSpeedControlHintEvent;
    }

    public final String getEnterTime() {
        return this.enterTime;
    }

    public final MutableLiveData<Boolean> getKeyboardEvent() {
        return this.keyboardEvent;
    }

    public final MutableLiveData<Pair<Boolean, Boolean>> getKeyboardStatus() {
        return this.keyboardStatus;
    }

    public final MutableLiveData<Integer> getLoadingStep() {
        return this.loadingStep;
    }

    public final d1<LogEntity> getLogFlow() {
        return this.logFlow;
    }

    public final MutableLiveData<Boolean> getPressState() {
        return this.pressState;
    }

    public final l0 getRtcConnectStatus() {
        return this.rtcConnectStatus;
    }

    public final MutableLiveData<Boolean> getSpeedingChanging() {
        return this.speedingChanging;
    }

    public final MutableLiveData<Boolean> getSubtitleState() {
        return this.subtitleState;
    }

    public final long getTutorId() {
        return this.tutorId;
    }

    public final l0 getWebviewLoadStatus() {
        return this.webviewLoadStatus;
    }

    public LiveTutorViewModel(LiveTutorHybridContainer r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.container = r100;
        this.animController = new LiveTutorAnimController(this);
        this.messageController = new LiveTutorMessageController(this);
        this.subtitleController = new LiveTutorSubtitleControllerV2();
        LazyThreadSafetyMode r101 = LazyThreadSafetyMode.NONE;
        this.waitController$delegate = LazyKt.lazy(r101, new o(this));
        this.saveController = new com.larus.livetutor.impl.tutor.controller.h0(this, r100);
        LiveTutorPauseController r102 = new LiveTutorPauseController(this);
        this.pauseController = r102;
        this.feedbackController = new LiveTutorFeedbackController(r100.getContext(), this);
        this.imagePreviewController = new com.larus.livetutor.impl.tutor.controller.t(this, r102, r100);
        this.liveTutorConfig$delegate = LazyKt.lazy(r101, new p());
        this.rtcPageState = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        MutableSharedFlow<ij9.a> r103 = SharedFlowKt.MutableSharedFlow$default(2, 0, null, 6, null);
        this._contentState = r103;
        this.contentState = r103;
        this.loadingStep = new MutableLiveData();
        Lazy r104 = com.larus.livetutor.impl.utils.i.f356679a;
        Intrinsics.checkNotNullParameter("live_tutor_subtitles_switch_cache", "key");
        Boolean r105 = Boolean.valueOf(com.larus.livetutor.impl.utils.i.a().getBoolean("live_tutor_subtitles_switch_cache", true));
        boolean r106 = r105.booleanValue();
        boolean r107 = kj9.b.f503724a;
        kj9.b.a("[LiveTutorViewModel] init subtitleState = " + r106);
        this.subtitleState = new MutableLiveData(r105);
        this.liveTutorV2Params$delegate = LazyKt.lazy(r101, new q(this));
        this.enterTime = String.valueOf(System.currentTimeMillis());
        MutableSharedFlow<LogEntity> r108 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this._logFlow = r108;
        this.logFlow = r108;
        this.longThinkingTimeOut = new r(this);
        this.longAsrSubmitTimeOut = new s(this);
        this.longLoadingTimeOut = new t(this);
        this.subtitleFragment$delegate = LazyKt.lazy(r101, new u(this));
        LiveTutorConfig r109 = getLiveTutorConfig();
        Intrinsics.checkNotNullParameter(r109, "<this>");
        this.currentUserSetting = new UserSetting(Double.valueOf(oj9.a.b(r109)), Double.valueOf(oj9.a.a(r109)));
        this.speedingChanging = new MutableLiveData(Boolean.FALSE);
        this.audioUuid = "";
        this.pressState = new MutableLiveData();
        this.keyboardStatus = new MutableLiveData();
        this.keyboardEvent = new MutableLiveData();
        this.dismissTtsSpeedControlHintEvent = new MutableLiveData();
        this.activityConfiguration = new MutableLiveData();
        this.closePageListeners = new LinkedHashSet();
    }

    public static void INVOKEVIRTUAL_com_larus_livetutor_impl_repository_viewmodel_LiveTutorViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(LiveTutorSettingsDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void INVOKEVIRTUAL_com_larus_livetutor_impl_repository_viewmodel_LiveTutorViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(LiveTutorSettingsDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static final /* synthetic */ void access$doExit(LiveTutorViewModel r100) {
        r100.doExit();
    }

    public static final /* synthetic */ void access$exitAndResetState(LiveTutorViewModel r100) {
        r100.exitAndResetState();
    }

    public static final /* synthetic */ Job access$getBackgroundExitJob$p(LiveTutorViewModel r100) {
        return r100.backgroundExitJob;
    }

    public static final /* synthetic */ LiveTutorHybridContainer access$getContainer$p(LiveTutorViewModel r100) {
        return r100.container;
    }

    public static final /* synthetic */ Deferred access$getFinishRtcDeferred$p(LiveTutorViewModel r100) {
        return r100.finishRtcDeferred;
    }

    public static final /* synthetic */ com.larus.livetutor.impl.rtc.l0 access$getRtcService(LiveTutorViewModel r100) {
        return r100.getRtcService();
    }

    public static final /* synthetic */ MutableSharedFlow access$get_contentState$p(LiveTutorViewModel r100) {
        return r100._contentState;
    }

    private final void closeKeyBoard(boolean r100) {
        LiveTutorPauseController.e(this.pauseController, ControlReason.Keyboard, null, false, 6);
        this.keyboardStatus.setValue(TuplesKt.to(Boolean.FALSE, Boolean.valueOf(r100)));
        int r101 = com.larus.livetutor.impl.utils.j.f356680a;
        com.larus.livetutor.impl.utils.j.a(this.container.getContext());
    }

    private static final Unit doExit$lambda$22(LiveTutorViewModel r100) {
        r100.container.f356151a.finish();
        return Unit.INSTANCE;
    }

    private static final void exitAndResetState$lambda$52(LiveTutorViewModel r100) {
        r100.container.g();
        LiveTutorSettingsDialog r101 = r100.settingsDialog;
        if (r101 == null) goto L6;
        INVOKEVIRTUAL_com_larus_livetutor_impl_repository_viewmodel_LiveTutorViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r101);
        return;
    }

    private static final LiveTutorV2Params liveTutorV2Params_delegate$lambda$3(LiveTutorViewModel r100) {
        return r100.buildParams();
    }

    private static final void longAsrSubmitTimeOut$lambda$5(LiveTutorViewModel r100) {
        r100.dLogger("longAsrTimeOut", "long time asr");
        r100.toast(R.string.larus_tutor_toast_3_cn);
    }

    private static final void longLoadingTimeOut$lambda$6(LiveTutorViewModel r100) {
        r100.eLogger("longLoadingTimeOut", "long time loading, webview load status: " + r100.webviewLoadStatus + ", rtc connect status: " + r100.rtcConnectStatus);
        if (r100.webviewLoadStatus != null) goto L6;
        r100.webviewLoadStatus = new nj9.c(-10001);
        r100.dispatchRefreshState();
        return;
    }

    private static final void longThinkingTimeOut$lambda$4(LiveTutorViewModel r100) {
        r100.eLogger("longThinkingTimeOut", "long time stay state: " + r100.getCurrentContentState());
    }

    private static final Unit onUserAsrCancel$lambda$33(boolean r100) {
        boolean r101 = kj9.b.f503724a;
        kj9.b.a("[onUserAsrCancel] cancel asr " + r100);
        return Unit.INSTANCE;
    }

    private static final Unit onUserAsrEnd$lambda$34(LiveTutorDoubaoTrackerData r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$doubaoEvent");
        r100.setScene(ObricActionBarTrackType.SPEAK);
        return Unit.INSTANCE;
    }

    private static final Unit onUserAsrTextSend$lambda$39(LiveTutorDoubaoTrackerData r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$doubaoEvent");
        r100.setScene(ObricActionBarTrackType.SPEAK);
        return Unit.INSTANCE;
    }

    private static final Unit onUserTextSend$lambda$42(LiveTutorDoubaoTrackerData r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$doubaoEvent");
        r100.setScene(ObricActionBarTrackType.KEY_BOARD);
        return Unit.INSTANCE;
    }

    private final void receiveRtcConnected(RTCServiceStatus.Connected r100) {
        l0 r101 = this.rtcConnectStatus;
        PageStateViewModel.RefreshStatus r102 = PageStateViewModel.RefreshStatus.SUCCESS;
        if (Intrinsics.areEqual(r101, r102.getPageChildState()) == true) goto L11;
        if ((r100.getBusinessState() instanceof LiveTutorConnectedStatus.Idle) == false) goto L11;
        this.rtcConnectStatus = r102.getPageChildState();
        LiveTutorTrackerService r103 = kj9.b.c();
        if (r103 == null) goto L9;
        LiveTutorTrackerService.i(r103, "rtc_enter_success", null, r100.getBusinessState().toString(), 0, 18);
    L9:
        dispatchRefreshState();
    L11:
        if (getPageReady() == false) goto L14;
        ij9.a r104 = r100.getBusinessState();
        this._contentState.tryEmit(r104);
        boolean r105 = kj9.b.f503724a;
        kj9.b.a("[updatePageState] from " + getPreviousContentState() + " to " + r100.getBusinessState());
        updateContentState(r104);
        return;
    }

    private final void receiveRtcError(RTCServiceStatus.Error r110) {
        boolean r100 = kj9.b.f503724a;
        kj9.b.b("[receiveRtcError] error: " + r110);
        l0 r101 = this.rtcConnectStatus;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L11;
        kj9.b.b("[receiveRtcError] receive duplicate error, return\nstate = " + r110 + "\nrtcConnectStatus = " + this.rtcConnectStatus);
        return;
    L11:
        this.leaveRoomByEnterBackground = false;
        Job r103 = this.backgroundExitJob;
        if (r103 == null) goto L14;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L14:
        nj9.a r104 = new nj9.a(r110.getMessage(), r110.getErrorCode());
        r104.f356220a = r110.getExtraInfo();
        reportFailOccur(r104, "rtc_enter_fail", null);
        this.rtcConnectStatus = r104;
        tryFinishRtc$default(this, 0, true, null, 5, null);
        dispatchRefreshState();
        exitAndResetState();
        return;
    L5:
        if (nj9.b.c(r101) == true) goto L7;
        r102 = true;
        goto L8
    }

    private static final Unit requestAudioCapturePermission$lambda$29(boolean r100) {
        if (r100 == false) goto L5;
        kj9.b.a("[requestAudioCapturePermission] true");
    L5:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.larus.livetutor.impl.repository.viewmodel.c0, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void restart2Learn(View r110) {
        kj9.b.a("[restart2Learn] click to restart");
        reportRestart();
        LiveTutorFeedbackController r100 = this.feedbackController;
        LiveTutorCallInfo r101 = r100.f356436b.getCallInfo();
        if (r101 == null) goto L5;
        r101.setFeedbackStatus(Integer.valueOf(FeedbackStatus.UnEvaluated.getValue()));
    L5:
        r100.f356439e = false;
        this.teachEnd = false;
        com.larus.livetutor.impl.rtc.l0 r102 = getRtcService();
        if (r102 == null) goto L10;
        ?? r103 = new c0(this);
        Intrinsics.checkNotNullParameter(r103, "callback");
        TutorRTCServiceImpl r104 = r102.f356397b;
        if (r104 == 0) goto L10;
        r104.n(2000, r103);
    L10:
        LiveTutorPauseController.b(this.pauseController, null, true, Integer.valueOf(LiveTutorControlReason.RESTART_LEARN.getValue()), false, 9);
        LiveTutorSubtitleControllerV2 r105 = this.subtitleController;
        ((ArrayList) r105.f356460d).clear();
        r0 r106 = r105.f356459c;
        if (r106 == null) goto L13;
        r106.onClear();
    L13:
        this.container.b(r110);
        Job r111 = this.restartPopDismissJob;
        if (r111 == null) goto L17;
        Job.DefaultImpls.cancel$default(r111, null, 1, null);
        return;
    }

    private final void showResumeFailTips(final ControlReason r100) {
        kj9.b.a("[showResumeFailTips]");
        if (this.resumeFailView == null) goto L6;
        kj9.b.a("[showResumeFailTips] resume fail view already show, return");
        return;
    L6:
        this.resumeFailView = this.container.i("恢复讲题失败，点击继续讲题", "继续", new c(this, r100));
    }

    private static final LiveTutorSubtitleFragment subtitleFragment_delegate$lambda$9(final LiveTutorViewModel r100) {
        LiveTutorSubtitleFragment r101 = new LiveTutorSubtitleFragment();
        Function0<Unit> r102 = new n(r100);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f355894e = r102;
        return r101;
    }

    private static final Unit subtitleFragment_delegate$lambda$9$lambda$8$lambda$7(LiveTutorViewModel r100) {
        kj9.b.a("[closeSubtitleFragment]");
        LiveTutorTrackerService r101 = kj9.b.c();
        if (r101 == null) goto L5;
        r101.f356690d.c();
    L5:
        r100.container.g();
        LiveTutorPauseController.e(r100.pauseController, ControlReason.Subtitle, null, false, 6);
        return Unit.INSTANCE;
    }

    private static final Unit transitionEnterTeachWithAnim$lambda$28(LiveTutorViewModel r100) {
        kj9.b.a("[transitionEnterTeachWithAnim] transition anim end");
        r100.showRestartInfoPop();
        LiveTutorFeedbackController r101 = r100.feedbackController;
        r101.f356438d.removeCallbacks(r101.f356440f);
        r101.f356438d.postDelayed(r101.f356440f, r101.f356436b.getLiveTutorConfig().getFeedbackTime() * ((long) 1000));
        r100.hasAlreadyCallStartSuccess = true;
        r100.feedbackController.a(r100.tutorId);
        return Unit.INSTANCE;
    }

    private final void updateContentState(ij9.a r100) {
        trackerOnStateChanged(r100);
        if ((r100 instanceof LiveTutorConnectedStatus.Thinking) == false) goto L6;
        com.larus.livetutor.impl.hybrid.b.a(this.container, 15000, this.longThinkingTimeOut);
        return;
    L6:
        if ((r100 instanceof LiveTutorConnectedStatus.Loading) == false) goto L9;
        this.loadingStep.postValue(((LiveTutorConnectedStatus.Loading) r100).getLoadingStep());
        return;
    L9:
        if ((r100 instanceof LiveTutorConnectedStatus.RoundEnd) == false) goto L14;
        this.teachEnd = true;
        return;
    }

    private static final Unit updatePitch$lambda$50(boolean r100) {
        if (r100 == false) goto L7;
        LiveTutorTrackerService r101 = kj9.b.c();
        if (r101 == null) goto L7;
        com.larus.livetutor.impl.utils.track.a.a(r101, TextureRenderKeys.KEY_IS_PITCH, "guided_tutor_frame", null, null, null, null, null, 124);
    L7:
        return Unit.INSTANCE;
    }

    private static final Unit updateSpeed$lambda$49(boolean r100) {
        if (r100 == false) goto L7;
        LiveTutorTrackerService r101 = kj9.b.c();
        if (r101 == null) goto L7;
        com.larus.livetutor.impl.utils.track.a.a(r101, "speed", "guided_tutor_frame", null, null, null, null, null, 124);
    L7:
        return Unit.INSTANCE;
    }

    private static final LiveTutorWaitController waitController_delegate$lambda$0(LiveTutorViewModel r100) {
        return new LiveTutorWaitController(r100);
    }

    public final void addClosePageListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.closePageListeners.add(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.livetutor.impl.repository.viewmodel.d] */
    public final void addDebugInfo(final Function1<? super LogEntity, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "function");
        com.larus.livetutor.impl.rtc.l0 r101 = getRtcService();
        if (r101 == 0) goto L6;
        r101.c(new d(r100));
        return;
    }

    public final void collectRtcDebugInfo(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.larus.livetutor.impl.rtc.l0 r100 = getRtcService();
        if (r100 == null) goto L10;
        RTCInfo r101 = r100.a();
        if (r101 == null) goto L11;
        String r102 = "time: " + new Date(System.currentTimeMillis()) + "\ncurrent part id: " + this.subtitleController.f356461e + "\ncurrent part in tutor idx: " + this.subtitleController.f356462f;
        RTCDebugInfo r111 = new RTCDebugInfo(r101.getRtcAppId(), r101.getRoomID(), r101.getBotID(), r101.getRtcCallId(), r101.getTutorId(), r101.getSdkVersion());
        ILiveTutorDebugService r103 = (ILiveTutorDebugService) ServiceManager.get().getService(ILiveTutorDebugService.class);
        if (r103 == null) goto L12;
        r103.a(r111, r110, r102);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void handleContinueAction(ControlAction r110) {
        dLogger("handleContinueAction", "action = " + r110);
        if (r110 == null) goto L7;
        com.larus.livetutor.impl.rtc.l0 r100 = getRtcService();
        if (r100 == null) goto L7;
        r100.e(new LiveTutorClientControlMsg(r110, null, null, null, 14, null));
    L7:
        tryResume$default(this, null, 1, null);
        LiveTutorTrackerService r101 = kj9.b.c();
        if (r101 == null) goto L11;
        com.larus.livetutor.impl.utils.track.a.a(r101, "go_on", "go_on", null, null, null, null, null, 124);
        return;
    }

    public final void handleStartCallResponse(StartCallResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "res");
        boolean r101 = kj9.b.f503724a;
        kj9.b.a("[handleStartCallResponse] call info = " + r100.getLiveTutorCallInfo() + ']');
        LiveTutorCallInfo r102 = r100.getLiveTutorCallInfo();
        this.callInfo = r102;
        if (r102 == null) goto L7;
        Long r103 = r102.getTutorId();
        if (r103 == null) goto L7;
        long r104 = r103.longValue();
    L8:
        this.tutorId = r104;
        getLiveTutorV2Params().setLiveTutorId(Long.valueOf(this.tutorId));
        LiveTutorCallInfo r105 = this.callInfo;
        if (r105 == null) goto L13;
        UserSetting r106 = r105.getTutorUserSetting();
        if (r106 == null) goto L13;
        this.currentUserSetting = r106;
    L13:
        long r107 = this.tutorId;
        LiveTutorHybridContainer r108 = this.container;
        com.larus.livetutor.impl.rtc.l0 r109 = getRtcService();
        LiveTutorCallInfo r110 = this.callInfo;
        if (r110 == null) goto L21;
        Integer r111 = r110.getConsumeStatus();
        int r112 = ConsumeStatus.Consume.getValue();
        if (r111 == null) goto L21;
        if (r111.intValue() != r112) goto L21;
        boolean r113 = true;
    L22:
        trackerEnterPage(r107, r108, r109, r113);
        LiveTutorFeedbackController r114 = this.feedbackController;
        Long r115 = Long.valueOf(this.tutorId);
        com.larus.livetutor.impl.rtc.l0 r116 = getRtcService();
        if (r116 == null) goto L27;
        RTCInfo r117 = r116.a();
        if (r117 == null) goto L27;
        Long r118 = Long.valueOf(r117.getRtcCallId());
    L28:
        r114.f356441g = r115;
        r114.f356442h = r118;
        return;
    L27:
        r118 = null;
    L21:
        r113 = false;
    L7:
        r104 = 0;
        goto L8
    }

    public final void initViewModel(LiveTutorHybridContainer r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.animController.b(r100);
        this.loadingStart = System.currentTimeMillis();
        Long r101 = getLiveTutorV2Params().getLiveTutorId();
        if (r101 == null) goto L5;
        long r102 = r101.longValue();
    L6:
        this.tutorId = r102;
        boolean r103 = kj9.b.f503724a;
        kj9.b.a("registerContext isRegistered=" + kj9.b.f503724a);
        if (kj9.b.f503724a == true) goto L10;
        kj9.b.f503724a = true;
    L10:
        initTracker(r100, this, this.searchId, this.resId);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.livetutor.impl.repository.viewmodel.l] */
    public final void onUserAsrCancel(long r110) {
        boolean r100 = kj9.b.f503724a;
        kj9.b.a("[onUserAsrCancel], asr state is " + this.asrStartState + ", isLongPressing:" + this.pressState.getValue() + "， uuid =" + this.audioUuid);
        Boolean r101 = this.pressState.getValue();
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r102) == true) goto L5;
        kj9.b.a("[onUserAsrCancel] press too short, ignore");
        this.pressToShort = r102;
    L5:
        MutableLiveData<Boolean> r103 = this.pressState;
        Boolean r104 = Boolean.FALSE;
        r103.setValue(r104);
        jj9.b r105 = getAudioController();
        if (r105 == 0) goto L8;
        r105.a(this.audioUuid, this.asrStartState, new l());
    L8:
        this.asrStartState = null;
        this.keyboardEvent.setValue(r104);
        LiveTutorTrackerService r106 = kj9.b.c();
        if (r106 == null) goto L12;
        com.larus.livetutor.impl.utils.track.a.a(r106, "long_press_cancel", "guided_tutor_frame", null, null, Long.valueOf(r110), null, null, 108);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.larus.livetutor.impl.repository.viewmodel.b0] */
    public final void onUserAsrEnd(long r110) {
        boolean r100 = kj9.b.f503724a;
        kj9.b.a("[onUserAsrEnd] asr state is " + this.asrStartState + ", isLongPressing: " + this.pressState.getValue() + ", uuid =" + this.audioUuid);
        if (r110 > getLiveTutorConfig().getShortPressTimeout()) goto L5;
    L17:
        kj9.b.a("[onUserAsrEnd] press too short, trans to cancel");
        toast(R.string.larus_tutor_toast_4_cn);
        onUserAsrCancel(r110);
        return;
    L5:
        if (r110 <= ViewConfiguration.getLongPressTimeout()) goto L17;
        Boolean r101 = this.pressState.getValue();
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r102) == true) goto L10;
        kj9.b.a("[onUserAsrEnd] press too short, ignore");
        this.pressToShort = r102;
    L10:
        MutableLiveData<Boolean> r103 = this.pressState;
        Boolean r104 = Boolean.FALSE;
        r103.setValue(r104);
        doubaoEvent("send_message", new a0());
        jj9.b r105 = getAudioController();
        if (r105 == 0) goto L13;
        r105.f(this.audioUuid, this.asrStartState, new b0(this));
    L13:
        this.asrStartState = null;
        com.larus.livetutor.impl.hybrid.b.a(this.container, getLiveTutorConfig().getLongAsrSubmitTimeout(), this.longAsrSubmitTimeOut);
        this.keyboardEvent.setValue(r104);
        LiveTutorTrackerService r106 = kj9.b.c();
        if (r106 == null) goto L19;
        com.larus.livetutor.impl.utils.track.a.a(r106, "long_press_send", "guided_tutor_frame", null, null, Long.valueOf(r110), null, null, 108);
        return;
    }

    public final void onUserTextSend(String r110) {
        Intrinsics.checkNotNullParameter(r110, "content");
        boolean r100 = kj9.b.f503724a;
        kj9.b.a("[onUserTextSend] " + r110);
        com.larus.livetutor.impl.rtc.l0 r101 = getRtcService();
        if (r101 == null) goto L5;
        r101.f(r110, new m(this));
    L5:
        LiveTutorPauseController.e(this.pauseController, ControlReason.PauseContinueButton, null, false, 6);
        LiveTutorTrackerService r102 = kj9.b.c();
        if (r102 == null) goto L8;
        com.larus.livetutor.impl.utils.track.a.a(r102, "click_send", "guided_tutor_frame", null, null, null, null, null, 124);
    L8:
        doubaoEvent("send_message", new x());
    }

    @Override // com.larus.livetutor.impl.repository.viewmodel.PageStateViewModel
    public void pageStateLog(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        super.pageStateLog(r100);
        kj9.b.a(r100);
    }

    public final void registerSubtitleListener(r0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.subtitleController.f356459c = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.larus.livetutor.impl.rtc.i0, java.lang.Object] */
    public final void sendLocalTips(final String r310) {
        dLogger("sendLocalTips", "tips = " + r310);
        com.larus.livetutor.impl.rtc.l0 r100 = getRtcService();
        if (r100 == null) goto L8;
        TutorRTCServiceImpl r101 = r100.f356397b;
        if (r101 == null) goto L9;
        FixedAudioMsg r102 = new FixedAudioMsg(FixedAudioType.FixedText, r310);
        ?? r110 = new com.larus.livetutor.impl.rtc.i0(r310);
        Intrinsics.checkNotNullParameter(r102, "playMsg");
        Intrinsics.checkNotNullParameter(r110, "callback");
        r101.g().c(new Signal(SignalType.FixedAudioMsg, null, null, null, null, null, null, null, null, null, 0 == true ? 1 : 0, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, null, null, null, r102, null, null, null, null, null, null, 133169150, null), new com.larus.livetutor.impl.rtc.z(r101, r110, r102));
        return;
    L9:
        return;
    }

    public final void setCurrentUserSetting(UserSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.currentUserSetting = r100;
    }

    public final void setLocalVolumeListener(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.livetutor.impl.rtc.l0 r101 = getRtcService();
        if (r101 == null) goto L8;
        Intrinsics.checkNotNullParameter(r100, "listener");
        TutorRTCServiceImpl r102 = r101.f356397b;
        if (r102 == null) goto L9;
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.livetutor.impl.rtc.handler.w r103 = r102.i();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        r103.f356375g = r100;
        return;
    L9:
        return;
    }

    public final void setSpeedingChanging(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.speedingChanging = r100;
    }

    public final void setTutorId(long r100) {
        this.tutorId = r100;
    }

    public final void toast(int r110) {
        AppHost.Companion r100 = AppHost.f326268a;
        String r101 = r100.getApplication().getString(r110);
        t19.s r111 = t19.s.f544207a;
        Application r102 = r100.getApplication();
        r111.getClass();
        t19.s.t(r102, r101);
        LiveTutorTrackerService r103 = kj9.b.c();
        if (r103 == null) goto L6;
        com.larus.livetutor.impl.utils.track.a.b(r103, "guided_tutor_frame", r101, null, null, null, null, 60);
        return;
    }

    public final void tryResume(ControlReason r100) {
        dLogger("tryResume", "tryResume pauseRtc = " + getPauseRtc().getValue());
        LiveTutorPauseController.e(this.pauseController, r100, null, false, 6);
    }

    public final void updateKeyboardShowing(boolean r100) {
        if (r100 == false) goto L4;
        openKeyBoard();
        return;
    L4:
        closeKeyBoard(false);
    }

    public final void updatePageState(RTCServiceStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        com.larus.livetutor.impl.hybrid.b.b(this.container, this.longThinkingTimeOut);
        this.rtcPageState.tryEmit(r100);
        if ((r100 instanceof RTCServiceStatus.Initial) == false) goto L5;
    L13:
        notifyPageRefreshStatus(PageStateViewModel.RefreshStatus.LOADING);
        return;
    L5:
        if ((r100 instanceof RTCServiceStatus.Connecting) == true) goto L13;
        if ((r100 instanceof RTCServiceStatus.Error) == false) goto L11;
        receiveRtcError((RTCServiceStatus.Error) r100);
        return;
    L11:
        if ((r100 instanceof RTCServiceStatus.Connected) == false) goto L16;
        receiveRtcConnected((RTCServiceStatus.Connected) r100);
        return;
    }

    public final void updatePitch(double r100) {
        boolean r101 = kj9.b.f503724a;
        kj9.b.a("[updatePitch] newPitch: " + r100);
        updateUserSettings(this.currentUserSetting.getTtsSpeed(), Double.valueOf(r100), new e());
    }

    public final void updateSpeed(double r100) {
        boolean r101 = kj9.b.f503724a;
        kj9.b.a("[updateSpeed] newSpeed: " + r100);
        updateUserSettings(Double.valueOf(r100), this.currentUserSetting.getTtsPitch(), new b());
    }

    public static final /* synthetic */ void access$receiveRtcError(LiveTutorViewModel r100, RTCServiceStatus.Error r101) {
        r100.receiveRtcError(r101);
    }

    public static final /* synthetic */ void access$restart2Learn(LiveTutorViewModel r100, View r101) {
        r100.restart2Learn(r101);
    }

    public static final /* synthetic */ void access$setBackgroundExitJob$p(LiveTutorViewModel r100, Job r101) {
        r100.backgroundExitJob = r101;
    }

    public static final /* synthetic */ void access$setFinishRtcDeferred$p(LiveTutorViewModel r100, Deferred r101) {
        r100.finishRtcDeferred = r101;
    }

    public static final /* synthetic */ void access$setLeaveRoomByEnterBackground$p(LiveTutorViewModel r100, boolean r101) {
        r100.leaveRoomByEnterBackground = r101;
    }

    public static final /* synthetic */ void access$setRtcConnectStatus$p(LiveTutorViewModel r100, l0 r101) {
        r100.rtcConnectStatus = r101;
    }

    private static final Unit addDebugInfo$lambda$31(Function1 r100, LogEntity r101) {
        Intrinsics.checkNotNullParameter(r101, "it");
        r100.invoke(r101);
        return Unit.INSTANCE;
    }

    private static final Unit onUserAsrEnd$lambda$36(LiveTutorViewModel r100, final UserAsrEndMsg r101) {
        com.larus.livetutor.impl.hybrid.b.b(r100.container, r100.longAsrSubmitTimeOut);
        boolean r102 = kj9.b.f503724a;
        kj9.b.a("[onUserAsrEnd] end asr " + r101);
        if (r101 == null) goto L5;
        String r103 = r101.getAsrContent();
    L6:
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        r100.toast(R.string.larus_tutor_toast_3_cn);
    L15:
        r100.doubaoEvent(ObricActionBarTrackType.EVENT_SEND_MESSAGE_STATUS, new v(r101));
        return Unit.INSTANCE;
    L14:
        r100.tryResume(ControlReason.PauseContinueButton);
        goto L15
    L8:
        if (r103.length() == 0) goto L11;
        r104 = false;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    private static final Unit onUserAsrEnd$lambda$36$lambda$35(UserAsrEndMsg r100, LiveTutorDoubaoTrackerData r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$doubaoEvent");
        r101.setScene(ObricActionBarTrackType.SPEAK);
        if (r100 == null) goto L7;
        Long r102 = r100.getTutorPartId();
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L8:
        r101.setLiveTutorPartId(r103);
        if (r100 == null) goto L11;
        int r104 = 1;
    L12:
        r101.setSuccess(Integer.valueOf(r104));
        return Unit.INSTANCE;
    L11:
        r104 = 0;
    L7:
        r103 = null;
        goto L8
    }

    private static final Unit onUserAsrStart$lambda$32(LiveTutorViewModel r100, boolean r101) {
        boolean r102 = kj9.b.f503724a;
        kj9.b.a("[onUserAsrStart] start asr " + r101);
        if (Intrinsics.areEqual(r100.pressToShort, Boolean.TRUE) == true) goto L5;
        r100.pressState.setValue(Boolean.valueOf(r101));
    L5:
        r100.pressToShort = null;
        return Unit.INSTANCE;
    }

    private static final Unit onUserAsrTextSend$lambda$38(LiveTutorViewModel r100, final boolean r101) {
        boolean r102 = kj9.b.f503724a;
        kj9.b.a("[onUserAsrTextSend] sendUserInputContent result " + r101);
        if (r101 == true) goto L5;
        r100.eLogger("onUserAsrTextSend", "sendUserInputContent failed");
        r100.toast(R.string.larus_tutor_toast_5_cn);
    L6:
        r100.doubaoEvent(ObricActionBarTrackType.EVENT_SEND_MESSAGE_STATUS, new i(r101));
        return Unit.INSTANCE;
    L5:
        r100.tryResume(ControlReason.PauseContinueButton);
        goto L6
    }

    private static final Unit onUserAsrTextSend$lambda$38$lambda$37(boolean r100, LiveTutorDoubaoTrackerData r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$doubaoEvent");
        r101.setScene(ObricActionBarTrackType.SPEAK);
        if (r100 == false) goto L5;
        int r102 = 1;
    L6:
        r101.setSuccess(Integer.valueOf(r102));
        return Unit.INSTANCE;
    L5:
        r102 = 0;
        goto L6
    }

    private static final Unit onUserTextSend$lambda$41(LiveTutorViewModel r100, final boolean r101) {
        boolean r102 = kj9.b.f503724a;
        kj9.b.a("[onUserTextSend] sendUserInputContent result " + r101);
        if (r101 == true) goto L5;
        r100.eLogger("onUserTextSend", "sendUserInputContent failed");
        r100.toast(R.string.larus_tutor_toast_5_cn);
    L5:
        r100.doubaoEvent(ObricActionBarTrackType.EVENT_SEND_MESSAGE_STATUS, new d0(r101));
        return Unit.INSTANCE;
    }

    private static final Unit onUserTextSend$lambda$41$lambda$40(boolean r100, LiveTutorDoubaoTrackerData r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$doubaoEvent");
        r101.setScene(ObricActionBarTrackType.KEY_BOARD);
        if (r100 == false) goto L5;
        int r102 = 1;
    L6:
        r101.setSuccess(Integer.valueOf(r102));
        return Unit.INSTANCE;
    L5:
        r102 = 0;
        goto L6
    }

    private static final void openSettingsDialog$lambda$48$lambda$47(LiveTutorViewModel r100, DialogInterface r101) {
        r100.dismissTtsSpeedControlHint();
        LiveTutorTrackerService r102 = kj9.b.c();
        if (r102 == null) goto L6;
        com.larus.livetutor.impl.utils.track.a.b(r102, "pop_expo", null, null, null, null, null, 62);
        return;
    }

    private static final Unit refreshData$lambda$12(LiveTutorViewModel r100, ControlReason r101) {
        View r102 = r100.resumeFailView;
        if (r102 == null) goto L5;
        r100.container.b(r102);
    L5:
        r100.resumeFailView = null;
        com.larus.livetutor.impl.hybrid.b.b(r100.container, r100.longThinkingTimeOut);
        return Unit.INSTANCE;
    }

    private static final Unit refreshData$lambda$13(LiveTutorViewModel r100, ControlReason r101) {
        r100.showResumeFailTips(r101);
        return Unit.INSTANCE;
    }

    private static final Unit restart2Learn$lambda$18(LiveTutorViewModel r100, final boolean r101) {
        boolean r102 = kj9.b.f503724a;
        kj9.b.b("[restart2Learn] restart " + r101);
        r100.updateEnterTeachTime();
        r100.pauseController.d();
        r100.doubaoEvent(ObricActionBarTrackType.EVENT_SEND_MESSAGE_STATUS, new y(r101));
        return Unit.INSTANCE;
    }

    private static final Unit restart2Learn$lambda$18$lambda$17(boolean r100, LiveTutorDoubaoTrackerData r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$doubaoEvent");
        r101.setScene(ObricActionBarTrackType.KEY_BOARD);
        if (r100 == false) goto L5;
        int r102 = 1;
    L6:
        r101.setSuccess(Integer.valueOf(r102));
        return Unit.INSTANCE;
    L5:
        r102 = 0;
        goto L6
    }

    private static final Unit retryConnectRtc$lambda$25(LiveTutorViewModel r100, boolean r101) {
        if (r101 == true) goto L5;
        r100.eLogger("retryConnectRtc", "retry rtc fail");
        nj9.a r102 = new nj9.a(0);
        r100.reportFailOccur(r102, "rtc_enter_fail", null);
        r100.rtcConnectStatus = r102;
        r100.dispatchRefreshState();
    L7:
        return Unit.INSTANCE;
    L5:
        r100.dLogger("retryConnectRtc", "retry rtc success");
        goto L7
    }

    public final void dLogger(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "log");
        boolean r102 = kj9.b.f503724a;
        kj9.b.a("[" + r100 + "] " + r101);
        this._logFlow.tryEmit(new LogEntity(r100, r101, LogStatus.Normal));
    }

    public final void eLogger(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "log");
        boolean r102 = kj9.b.f503724a;
        kj9.b.b("[" + r100 + "] " + r101);
        this._logFlow.tryEmit(new LogEntity(r100, r101, LogStatus.Error));
    }

    public final void onUserAsrTextSend(String r110, long r111) {
        Intrinsics.checkNotNullParameter(r110, "content");
        String r112 = StringsKt.trim(r110).toString();
        if (r112.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        MutableLiveData<Boolean> r101 = this.pressState;
        Boolean r102 = Boolean.FALSE;
        r101.setValue(r102);
        boolean r103 = kj9.b.f503724a;
        kj9.b.a("[onUserAsrTextSend] contentLength=" + r112.length() + ", duration=" + r111);
        com.larus.livetutor.impl.rtc.l0 r104 = getRtcService();
        if (r104 == null) goto L11;
        r104.f(r112, new e0(this));
    L11:
        this.keyboardEvent.setValue(r102);
        LiveTutorTrackerService r105 = kj9.b.c();
        if (r105 == null) goto L14;
        com.larus.livetutor.impl.utils.track.a.a(r105, "voice_wakeup_send", "guided_tutor_frame", null, null, Long.valueOf(r111), null, null, 108);
    L14:
        doubaoEvent("send_message", new f0());
        return;
    L5:
        r100 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.larus.livetutor.impl.repository.viewmodel.g] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.livetutor.impl.repository.viewmodel.h] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void refreshData(ITutorRefresh.RefreshStrategy r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        com.larus.livetutor.impl.rtc.l0 r102 = getRtcService();
        if (r102 == null) goto L5;
        LiveTutorV2Params r103 = getLiveTutorV2Params();
        Intrinsics.checkNotNullParameter(this, "viewModel");
        boolean r104 = kj9.b.f503724a;
        kj9.b.a("init params = " + r103);
        boolean r105 = AppHost.f326268a.isDebug();
        r102.f356396a = this;
        ij9.b.f490146a.getClass();
        TutorRTCServiceImpl r106 = new TutorRTCServiceImpl(r105);
        r106.f().getClass();
        r102.f356397b = r106;
        r106.p(false);
        r102.g(r106, r103);
    L5:
        this.animController.a(this);
        this.subtitleController.e(this);
        this.messageController.a();
        getWaitController().a();
        final com.larus.livetutor.impl.tutor.controller.h0 r107 = this.saveController;
        EventCenter.registerJsEventSubscriber("liveTutorSendBoardImg", r107.f356499i);
        r107.f356491a.addClosePageListener(new com.larus.livetutor.impl.tutor.controller.x(r107));
        this.pauseController.a(new g(this), new h(this));
        super.refreshData(r100, r101);
    }

    @Override // com.larus.livetutor.impl.repository.viewmodel.LifecyclePageStateViewModel
    public /* bridge */ /* synthetic */ void startRefreshData(ITutorRefresh.RefreshStrategy r100, String r101) {
        startRefreshData2(r100, r101);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.livetutor.impl.repository.viewmodel.z, java.lang.Object] */
    public final void transitionEnterTeachWithAnim(View r110, View r111) {
        Intrinsics.checkNotNullParameter(r110, "planView");
        Intrinsics.checkNotNullParameter(r111, "teachView");
        LiveTutorAnimController r100 = this.animController;
        ?? r101 = new z(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "planView");
        Intrinsics.checkNotNullParameter(r111, "teachView");
        Intrinsics.checkNotNullParameter(r101, "transitionEnd");
        r100.f356432d = true;
        LottieAnimationView r102 = r100.f356431c;
        if (r102 == null) goto L5;
        r102.setAnimation("DiBuKuoSan/DiBuKuoSan.json");
        r102.setImageAssetsFolder("DiBuKuoSan/images");
        UtilsKt.p(r102, com.larus.utils.i.d(UtilsKt.c()), com.larus.utils.i.b(UtilsKt.c()));
    L5:
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r110, View.ALPHA, new float[]{1.0f, 0.0f});
        r103.setDuration(150);
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r110, View.TRANSLATION_Y, new float[]{0.0f, -i5.A()});
        r104.setDuration(150);
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r111, View.ALPHA, new float[]{0.0f, 1.0f});
        r105.setStartDelay(283);
        r105.setDuration(216);
        Intrinsics.checkNotNull(r105);
        r105.addListener(new com.larus.livetutor.impl.tutor.controller.i(r111));
        AnimatorSet r112 = new AnimatorSet();
        r112.playTogether(new Animator[]{r103, r104, r105});
        r112.addListener(new com.larus.livetutor.impl.tutor.controller.h(r100));
        r112.addListener(new com.larus.livetutor.impl.tutor.controller.g(r110, r100, r101));
        r112.start();
        r100.f356433e = r112;
    }

    @Override // com.larus.livetutor.impl.repository.viewmodel.LifecyclePageStateViewModel, com.larus.livetutor.impl.repository.viewmodel.ITutorRefresh
    public /* bridge */ /* synthetic */ void refreshData(ITutorRefresh.RefreshStrategy r100, Object r101) {
        refreshData(r100, (String) r101);
    }

    private static final Unit showResumeFailTips$lambda$19(LiveTutorViewModel r100, ControlReason r101, View r102) {
        Intrinsics.checkNotNullParameter(r102, "it");
        kj9.b.a("[showResumeFailTips] click resume");
        r100.container.b(r102);
        r100.resumeFailView = null;
        LiveTutorPauseController.e(r100.pauseController, r101, null, false, 6);
        return Unit.INSTANCE;
    }

    public final void loadUriResult(boolean r100, long r110, Throwable r111) {
        boolean r101 = kj9.b.f503724a;
        kj9.b.a("[loadUriResult] webview isSuccess: " + r100);
        boolean r102 = r111 instanceof LiveTutorException;
        if (r102 == false) goto L5;
        int r103 = ((LiveTutorException) r111).getErrCode();
    L6:
        if (r102 == false) goto L8;
        String r112 = ((LiveTutorException) r111).getErrMsg();
    L9:
        String r104 = r112;
        TTWebViewService r113 = (TTWebViewService) ServiceManager.get().getService(TTWebViewService.class);
        if (r113 == null) goto L12;
        Boolean r114 = Boolean.valueOf(r113.a());
    L13:
        this.isUseTTWebview = r114;
        if (nj9.b.c(this.webviewLoadStatus) == false) goto L17;
        eLogger("loadUriResult", "webview load success already, errCode: " + r103 + ", errMsg: " + r104);
        return;
    L17:
        if (r100 == false) goto L22;
        LiveTutorTrackerService r105 = kj9.b.c();
        if (r105 == null) goto L21;
        LiveTutorTrackerService.i(r105, "webview_load_success", Long.valueOf(r110), r104, r103, 16);
    L21:
        l0 r106 = PageStateViewModel.RefreshStatus.SUCCESS.getPageChildState();
    L23:
        this.webviewLoadStatus = r106;
        dispatchRefreshState();
        return;
    L22:
        r106 = new nj9.c(r103);
        r106.f356220a = r104;
        reportFailOccur(r106, "webview_load_fail", Long.valueOf(r110));
        goto L23
    L12:
        r114 = Boolean.FALSE;
        goto L13
    L8:
        r112 = "";
        goto L9
    L5:
        r103 = 0;
        goto L6
    }

    public final void tryFinishRtc(final int r100, final boolean r101, final Function0<Unit> r102) {
        com.larus.livetutor.impl.rtc.l0 r103 = getRtcService();
        if (r103 == null) goto L6;
        r103.b(r101, new j(r100, r102, this, r101));
        return;
    }

    public final void updateUserSettings(Double r110, Double r210, final Function1<? super Boolean, Unit> r211) {
        Intrinsics.checkNotNullParameter(r211, "result");
        boolean r100 = kj9.b.f503724a;
        kj9.b.a("[updateSpeed] newSpeed: " + r110 + ", newPitch: " + r210);
        this.speedingChanging.setValue(Boolean.TRUE);
        final UserSetting r101 = new UserSetting(r110, r210);
        jj9.b r102 = getAudioController();
        if (r102 == null) goto L5;
        r102.d(r101, getCurrentPauseLocation(), 1000, new g0(this, r101, r211));
    L5:
        LiveTutorPauseController.b(this.pauseController, null, true, Integer.valueOf(LiveTutorControlReason.UPDATE_SPEED.getValue()), false, 9);
    }

    public static /* synthetic */ void tryResume$default(LiveTutorViewModel r100, ControlReason r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L8;
        LiveTutorPauseEvent r104 = r100.getPauseRtc().getValue();
        if (r104 == null) goto L7;
        r101 = r104.getPauseReason();
        goto L8
    L7:
        r101 = null;
    L8:
        r100.tryResume(r101);
    }

    private static final Unit updateUserSettings$lambda$51(LiveTutorViewModel r100, UserSetting r101, Function1 r102, boolean r103) {
        boolean r104 = kj9.b.f503724a;
        kj9.b.b("[updateSpeed] modifyTTSSpeed " + r103);
        if (r103 == false) goto L5;
        r100.currentUserSetting = r101;
    L5:
        r102.invoke(Boolean.valueOf(r103));
        r100.speedingChanging.setValue(Boolean.FALSE);
        LiveTutorPauseController.e(r100.pauseController, null, Integer.valueOf(LiveTutorControlReason.UPDATE_SPEED.getValue()), false, 5);
        return Unit.INSTANCE;
    }

    private static final Unit tryFinishRtc$lambda$23(int r100, Function0 r101, LiveTutorViewModel r102, boolean r103, boolean r104) {
        boolean r105 = kj9.b.f503724a;
        kj9.b.a("[tryFinishRtc] finish rtc success: " + r104 + ", retryCount: " + r100);
        if (r104 == false) goto L5;
    L8:
        if (r101 == null) goto L11;
        r101.invoke();
    L11:
        return Unit.INSTANCE;
    L5:
        if (r100 >= 3) goto L8;
        r102.tryFinishRtc(r100 + 1, r103, r101);
        goto L11
    }

    public static /* synthetic */ void loadUriResult$default(LiveTutorViewModel r100, boolean r101, long r102, Throwable r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.loadUriResult(r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void tryFinishRtc$default(LiveTutorViewModel r100, int r101, boolean r102, Function0 r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = false;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = null;
    L11:
        r100.tryFinishRtc(r101, r102, r103);
    }
}
