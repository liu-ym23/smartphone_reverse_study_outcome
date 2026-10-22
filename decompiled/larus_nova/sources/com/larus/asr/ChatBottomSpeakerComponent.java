package com.larus.asr;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.google.gson.Gson;
import com.ixigua.lib.track.TrackParams;
import com.larus.asr.api.databinding.LarusWidgetSpeakerBinding;
import com.larus.asr.config.builder.ChatSpeakerElementKey;
import com.larus.asr.direct.IAsrDirectFillAbility;
import com.larus.asr.handsfree.AsrInputMode;
import com.larus.asr.handsfree.HandsfreeDirectEntry;
import com.larus.asr.handsfree.HandsfreeForegroundService;
import com.larus.asr.session.ComponentAsrSession;
import com.larus.asr.session.InputTextAsrSession;
import com.larus.asr.session.InputTextAsrSession2;
import com.larus.asr.session.InputTextAsrSession2V2;
import com.larus.asr.session.QuicInterpretAsrSessionV2;
import com.larus.asr.session.SamiCallAsrSession;
import com.larus.asr.session.SendMessageAsrSession;
import com.larus.asr.session.SendMessageAsrSessionV2;
import com.larus.asr.view.ChatSpeaker;
import com.larus.audio.audiov3.config.task.sami.asr.ReportType;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import com.larus.audio.audiov3.task.asr.AsrLifeState;
import com.larus.audio.audiov3.task.asr.AsrState;
import com.larus.audio.audiov3.task.asr.sami.data.SamiAsrDataBin;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.adapter.MessageModifyMode;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.b9;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.business.debug.base.audio.module.ASRModule;
import com.larus.camera.api.IFlowCamera;
import com.larus.chat.api.nita.IChatBottomNitaView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.TouchInterceptingView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.HandsfreeExperimentConfig;
import com.larus.platform.model.SpeakStyleConfig;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.common.spi.toast.ObricToastHelperDelegate;
import com.obric.assistant.spi.actionbar.ObricActionBarTrackServiceDelegate;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Ñ\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\b*\u0003LÙ\u0001\b\u0016\u0018\u0000 Ü\u00032\u00060\u0001j\u0002`\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0006Ü\u0003Ý\u0003Þ\u0003B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010N\u001a\u00020A2\b\u0010O\u001a\u0004\u0018\u00010\u00142\u0006\u0010P\u001a\u00020\u0016H\u0002J\t\u0010Ö\u0001\u001a\u00020AH\u0016J\t\u0010×\u0001\u001a\u00020AH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\"H\u0014J\u0012\u0010Û\u0001\u001a\u00020A2\u0007\u0010Ü\u0001\u001a\u00020\"H\u0004J\f\u0010Ý\u0001\u001a\u0005\u0018\u00010Þ\u0001H\u0002J\t\u0010ß\u0001\u001a\u00020>H\u0004J\u0012\u0010à\u0001\u001a\u00020A2\u0007\u0010á\u0001\u001a\u00020\"H\u0014J\u0013\u0010â\u0001\u001a\u00020A2\b\u0010Ü\u0001\u001a\u00030Þ\u0001H\u0016J\t\u0010ã\u0001\u001a\u00020AH\u0016J\t\u0010ä\u0001\u001a\u00020AH\u0016J\t\u0010å\u0001\u001a\u00020AH\u0016J\t\u0010æ\u0001\u001a\u00020AH\u0016J\t\u0010ç\u0001\u001a\u00020AH\u0016J\t\u0010è\u0001\u001a\u00020AH\u0002J\t\u0010é\u0001\u001a\u00020AH\u0002J\u0014\u0010ê\u0001\u001a\u00020A2\t\u0010ë\u0001\u001a\u0004\u0018\u00010\u0014H\u0016J\f\u0010ì\u0001\u001a\u0005\u0018\u00010í\u0001H\u0016J'\u0010î\u0001\u001a\u0004\u0018\u00010A2\u0006\u0010b\u001a\u00020\u00142\f\b\u0002\u0010ï\u0001\u001a\u0005\u0018\u00010ð\u0001H\u0002¢\u0006\u0003\u0010ñ\u0001J'\u0010ò\u0001\u001a\u0004\u0018\u00010A2\u0006\u0010b\u001a\u00020\u00142\f\b\u0002\u0010ï\u0001\u001a\u0005\u0018\u00010ð\u0001H\u0002¢\u0006\u0003\u0010ñ\u0001J\t\u0010ó\u0001\u001a\u00020AH\u0002J\u0011\u0010ô\u0001\u001a\u0004\u0018\u00010AH\u0002¢\u0006\u0003\u0010õ\u0001J\u0012\u0010ö\u0001\u001a\u00020A2\u0007\u0010÷\u0001\u001a\u00020\nH\u0016J\t\u0010ø\u0001\u001a\u00020\u0016H\u0016J\t\u0010ù\u0001\u001a\u00020AH\u0002J\u0014\u0010ú\u0001\u001a\u00020A2\t\u0010û\u0001\u001a\u0004\u0018\u00010\u0014H\u0002J\t\u0010ü\u0001\u001a\u00020AH\u0002J!\u0010\u0080\u0002\u001a\u00020A2\u0016\u0010\u0081\u0002\u001a\u0011\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0082\u0002H\u0014J¬\u0001\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u00142\u0007\u0010\u0084\u0002\u001a\u00020\u00162\u0007\u0010\u0085\u0002\u001a\u00020\u00162\b\u0010\u0086\u0002\u001a\u00030\u0087\u00022\u0007\u0010\u0088\u0002\u001a\u00020\u00162\b\u0010\u0089\u0002\u001a\u00030\u008a\u00022\t\u0010\u008b\u0002\u001a\u0004\u0018\u00010\n2\n\u0010\u008c\u0002\u001a\u0005\u0018\u00010\u008d\u00022\u0015\u0010\u008e\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020A\u0018\u00010G2\u0017\u0010\u008f\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0005\u0012\u00030í\u0001\u0018\u00010\u0082\u00022#\u0010\u0090\u0002\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0005\u0012\u00030í\u00010Ó\u0001\u0012\u0004\u0012\u00020A\u0018\u00010GH\u0016¢\u0006\u0003\u0010\u0091\u0002J\t\u0010\u0092\u0002\u001a\u00020\nH\u0002JK\u0010\u0093\u0002\u001a\u0015\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0094\u00022\u0007\u0010\u0084\u0002\u001a\u00020\u00162\b\u0010\u0089\u0002\u001a\u00030\u008a\u00022\u0007\u0010\u0095\u0002\u001a\u00020\u00142\b\u0010\u0086\u0002\u001a\u00030\u0087\u00022\u0007\u0010\u0085\u0002\u001a\u00020\u0016H\u0014J:\u0010\u0097\u0002\u001a\u00020A2\u0007\u0010\u0098\u0002\u001a\u00020\n2\b\u0010\u0099\u0002\u001a\u00030\u009a\u00022\b\u0010\u009b\u0002\u001a\u00030\u009a\u00022\b\u0010\u009c\u0002\u001a\u00030\u009a\u00022\b\u0010\u009d\u0002\u001a\u00030\u009a\u0002H\u0016J\u0013\u0010\u009e\u0002\u001a\u00030\u009f\u00022\u0007\u0010 \u0002\u001a\u00020\nH\u0002J6\u0010¡\u0002\u001a\u00020A2\u0007\u0010¢\u0002\u001a\u00020\u00162\u0007\u0010\u0088\u0002\u001a\u00020\u00162\u0007\u0010£\u0002\u001a\u00020\u00142\b\u0010\u0086\u0002\u001a\u00030\u0087\u00022\u0006\u0010b\u001a\u00020\u0014H\u0016J\t\u0010¤\u0002\u001a\u00020AH\u0016J\u001b\u0010¥\u0002\u001a\u00020A2\u0007\u0010¦\u0002\u001a\u00020\u00162\u0007\u0010§\u0002\u001a\u00020\nH\u0016J\u0013\u0010¨\u0002\u001a\u00020A2\b\u0010©\u0002\u001a\u00030Ã\u0001H\u0016J\u0013\u0010ª\u0002\u001a\u00020A2\b\u0010©\u0002\u001a\u00030Ã\u0001H\u0016J\u0012\u0010«\u0002\u001a\u00020A2\u0007\u0010¬\u0002\u001a\u00020\nH\u0016J\u0011\u0010\u00ad\u0002\u001a\u00020A2\u0006\u0010b\u001a\u00020\u0014H\u0016J\u0013\u0010®\u0002\u001a\u00020A2\b\u0010©\u0002\u001a\u00030Å\u0001H\u0016J\u0013\u0010¯\u0002\u001a\u00020A2\b\u0010©\u0002\u001a\u00030Å\u0001H\u0016J\t\u0010°\u0002\u001a\u00020\u0016H\u0016J\t\u0010±\u0002\u001a\u00020AH\u0016J\f\u0010²\u0002\u001a\u0005\u0018\u00010Þ\u0001H\u0016J\u0013\u0010³\u0002\u001a\u00020A2\b\u0010´\u0002\u001a\u00030µ\u0002H\u0004J\t\u0010¶\u0002\u001a\u00020AH\u0016J\t\u0010·\u0002\u001a\u00020AH\u0016J6\u0010¸\u0002\u001a\u00020A2\b\u0010ï\u0001\u001a\u00030ð\u00012\u000b\b\u0002\u0010¹\u0002\u001a\u0004\u0018\u00010\u00142\u0014\u0010º\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140Ó\u0001H\u0002J\t\u0010»\u0002\u001a\u00020AH\u0002J\t\u0010¼\u0002\u001a\u00020AH\u0002J\t\u0010½\u0002\u001a\u00020AH\u0014J\b\u0010'\u001a\u00020\u0016H\u0016J\t\u0010¾\u0002\u001a\u00020AH\u0002Jc\u0010¿\u0002\u001a\u00020A2\u0013\u0010À\u0002\u001a\u000e\u0012\u0004\u0012\u00020n\u0012\u0004\u0012\u00020\u00160G2\u0013\u0010Á\u0002\u001a\u000e\u0012\u0004\u0012\u00020p\u0012\u0004\u0012\u00020\u00160G2\u0019\u0010Â\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020A0E2\u0013\u0010Ã\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00160GH\u0016J\u0018\u0010Ä\u0002\u001a\u00020A2\r\u0010\u0090\u0002\u001a\b\u0012\u0004\u0012\u00020A0@H\u0016J\u001e\u0010Å\u0002\u001a\u00020A2\u0013\u0010Æ\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020h0GH\u0016J\u0012\u0010Ç\u0002\u001a\u00020A2\u0007\u0010È\u0002\u001a\u00020kH\u0016J\u0012\u0010É\u0002\u001a\u00020A2\u0007\u0010È\u0002\u001a\u00020kH\u0016J\t\u0010Ê\u0002\u001a\u00020AH\u0002J\u0012\u0010Ë\u0002\u001a\u00020A2\u0007\u0010Ì\u0002\u001a\u00020YH\u0002J\u0012\u0010Í\u0002\u001a\u00020A2\u0007\u0010Ì\u0002\u001a\u00020YH\u0002J\u000b\u0010Î\u0002\u001a\u0004\u0018\u00010\u0014H\u0002J\t\u0010Ï\u0002\u001a\u00020\u0016H\u0002J\u0012\u0010Ð\u0002\u001a\u00020A2\u0007\u0010Ñ\u0002\u001a\u00020\u0016H\u0016J\u001b\u0010Ò\u0002\u001a\u00020A2\u0007\u0010£\u0002\u001a\u00020\u00142\u0007\u0010Ó\u0002\u001a\u00020\u0016H\u0016J\t\u0010Ô\u0002\u001a\u00020\u0016H\u0016J\n\u0010Õ\u0002\u001a\u00030Ö\u0002H\u0016J\u0013\u0010×\u0002\u001a\u00020A2\b\u0010\u0086\u0002\u001a\u00030\u0087\u0002H\u0016J\u000b\u0010Ø\u0002\u001a\u0004\u0018\u00010[H\u0016J\u000b\u0010Ù\u0002\u001a\u0004\u0018\u00010YH\u0016J\f\u0010Ú\u0002\u001a\u0005\u0018\u00010Û\u0002H\u0016J\t\u0010Ü\u0002\u001a\u00020\u0016H\u0016J\u0012\u0010Ý\u0002\u001a\u00020A2\u0007\u0010Þ\u0002\u001a\u00020\u0016H\u0016J\t\u0010ß\u0002\u001a\u00020\u0016H\u0016J\t\u0010à\u0002\u001a\u00020AH\u0016J\u0011\u0010á\u0002\u001a\u00020A2\u0006\u0010b\u001a\u00020\u0014H\u0016J\u001a\u0010â\u0002\u001a\u00020A2\u0006\u0010b\u001a\u00020\u00142\u0007\u0010ã\u0002\u001a\u00020rH\u0016J\u001b\u0010ä\u0002\u001a\u00020A2\u0007\u0010å\u0002\u001a\u00020\u00142\u0007\u0010æ\u0002\u001a\u00020\u0016H\u0016J\u0012\u0010ç\u0002\u001a\u00020\u00162\u0007\u0010å\u0002\u001a\u00020\u0014H\u0016J\t\u0010è\u0002\u001a\u00020AH\u0016J\u0010\u0010é\u0002\u001a\u00020\u00162\u0007\u0010å\u0002\u001a\u00020\u0014J2\u0010ê\u0002\u001a\u00020A2\u0007\u0010å\u0002\u001a\u00020\u00142\u0014\u0010º\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140Ó\u00012\b\u0010\u0086\u0002\u001a\u00030\u0087\u0002H\u0016J\u0012\u0010ë\u0002\u001a\u00020\u00162\u0007\u0010å\u0002\u001a\u00020\u0014H\u0016J\u0012\u0010ì\u0002\u001a\u00020\u00142\u0007\u0010å\u0002\u001a\u00020\u0014H\u0016J\u0012\u0010í\u0002\u001a\u00020\u00142\u0007\u0010å\u0002\u001a\u00020\u0014H\u0016J\u0013\u0010î\u0002\u001a\u00020A2\b\u0010ï\u0001\u001a\u00030ð\u0001H\u0016J\f\u0010ï\u0002\u001a\u0005\u0018\u00010í\u0001H\u0016J\f\u0010ð\u0002\u001a\u0005\u0018\u00010ñ\u0002H\u0016JW\u0010ò\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u0082\u00022\u0007\u0010å\u0002\u001a\u00020\u00142\b\u0010ó\u0002\u001a\u00030ð\u00012\n\u0010ô\u0002\u001a\u0005\u0018\u00010ñ\u00022\n\u0010õ\u0002\u001a\u0005\u0018\u00010í\u00012\u0014\u0010º\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140Ó\u0001H\u0016J\u0012\u0010ö\u0002\u001a\u00020\u00142\u0007\u0010÷\u0002\u001a\u00020\u0014H\u0002J\u0011\u0010ø\u0002\u001a\u00020A2\u0006\u0010b\u001a\u00020\u0014H\u0016J$\u0010ù\u0002\u001a\u00020A2\u0019\u0010\u0090\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020A0EH\u0016J!\u0010ú\u0002\u001a\u00020A2\u0016\u0010û\u0002\u001a\u0011\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0082\u0002H\u0016J\t\u0010ü\u0002\u001a\u00020\u0016H\u0016J'\u0010ý\u0002\u001a\u00020A2\b\u0010ï\u0001\u001a\u00030ð\u00012\b\u00104\u001a\u0004\u0018\u00010\u00142\b\u0010\u0086\u0002\u001a\u00030\u0087\u0002H\u0016J\u0013\u0010þ\u0002\u001a\u00020\u00162\b\u0010\u0086\u0002\u001a\u00030\u0087\u0002H\u0016J\t\u0010ÿ\u0002\u001a\u00020AH\u0016J\u0012\u0010\u0080\u0003\u001a\u00020A2\u0007\u0010\u0081\u0003\u001a\u00020\u0014H\u0016J\f\u0010\u0082\u0003\u001a\u0005\u0018\u00010\u0083\u0003H\u0016J\u000b\u0010\u0084\u0003\u001a\u0004\u0018\u00010\u0014H\u0016J\u001d\u0010\u0085\u0003\u001a\u00020A2\u0006\u0010b\u001a\u00020\u00142\n\u0010ï\u0001\u001a\u0005\u0018\u00010ð\u0001H\u0016J\u0018\u0010\u0086\u0003\u001a\u0011\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010Ó\u0001H\u0016J\u000b\u0010\u0087\u0003\u001a\u0004\u0018\u00010\u0014H\u0016J\t\u0010\u0088\u0003\u001a\u00020\u0016H\u0016J\u0011\u0010\u0089\u0003\u001a\u00020\u00162\b\u0010O\u001a\u0004\u0018\u00010\u0014J\u0014\u0010\u008a\u0003\u001a\u00020A2\t\u0010\u008b\u0003\u001a\u0004\u0018\u00010<H\u0016J\u0014\u0010\u008c\u0003\u001a\u00020A2\t\u0010\u008d\u0003\u001a\u0004\u0018\u00010>H\u0016J\u001a\u0010\u008e\u0003\u001a\u00020A2\u000f\u0010\u0090\u0002\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@H\u0016J&\u0010\u008f\u0003\u001a\u00020A2\u001b\u0010\u0090\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020A\u0018\u00010EH\u0016J\u001a\u0010\u0090\u0003\u001a\u00020A2\u000f\u0010\u0090\u0002\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@H\u0016J\u001a\u0010\u0091\u0003\u001a\u00020A2\u000f\u0010\u0090\u0002\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@H\u0016J\u001e\u0010\u0092\u0003\u001a\u00020A2\u0013\u0010\u0090\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020A0GH\u0016J\n\u0010\u0093\u0003\u001a\u00030\u0094\u0003H\u0016J'\u0010\u0095\u0003\u001a\u00020A2\u001c\u0010\u0096\u0003\u001a\u0017\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010Ó\u00010@H\u0016J\u0018\u0010\u0097\u0003\u001a\u00020A2\r\u0010\u0096\u0003\u001a\b\u0012\u0004\u0012\u00020\u00140@H\u0016J\u001a\u0010\u0098\u0003\u001a\u00020A2\u000f\u0010\u0096\u0003\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010@H\u0016J\n\u0010§\u0003\u001a\u00030¦\u0003H\u0002J\"\u0010¨\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0005\u0012\u00030í\u0001\u0018\u00010Ó\u00012\u0007\u0010©\u0003\u001a\u00020\u0014H\u0016J\t\u0010ª\u0003\u001a\u00020\u0016H\u0002J\n\u0010«\u0003\u001a\u00030\u008d\u0002H\u0016J\u000b\u0010¬\u0003\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u00ad\u0003\u001a\u00030\u009c\u0003H\u0016J\t\u0010®\u0003\u001a\u00020\u0016H\u0016J\t\u0010¯\u0003\u001a\u00020\u0016H\u0016J\u0014\u0010°\u0003\u001a\u00020A2\t\u0010±\u0003\u001a\u0004\u0018\u00010\u0014H\u0016J\t\u0010²\u0003\u001a\u00020\u0016H\u0016J\t\u0010³\u0003\u001a\u00020\u0016H\u0016J\u0012\u0010´\u0003\u001a\u00020A2\u0007\u0010£\u0002\u001a\u00020\u0014H\u0016J\t\u0010µ\u0003\u001a\u00020AH\u0016J\t\u0010¶\u0003\u001a\u00020AH\u0016J\t\u0010·\u0003\u001a\u00020\u0016H\u0002J\u0012\u0010¸\u0003\u001a\u00020A2\u0007\u0010¹\u0003\u001a\u00020\u0014H\u0002J\u0015\u0010º\u0003\u001a\u00020A2\n\u0010»\u0003\u001a\u0005\u0018\u00010¼\u0003H\u0002J%\u0010½\u0003\u001a\u00020\u00162\b\u0010¾\u0003\u001a\u00030¿\u00032\u0007\u0010À\u0003\u001a\u00020\u00142\u0007\u0010Á\u0003\u001a\u00020\u0014H\u0016J\t\u0010Ì\u0003\u001a\u00020AH\u0002J\t\u0010Í\u0003\u001a\u00020AH\u0002J\u0013\u0010Î\u0003\u001a\u00020A2\b\u0010Ï\u0003\u001a\u00030\u008d\u0002H\u0002J\t\u0010Ð\u0003\u001a\u00020AH\u0002J\t\u0010Ñ\u0003\u001a\u00020AH\u0002J\t\u0010Ò\u0003\u001a\u00020AH\u0002J\t\u0010Ó\u0003\u001a\u00020AH\u0002J\t\u0010Ô\u0003\u001a\u00020AH\u0002J\t\u0010Õ\u0003\u001a\u00020AH\u0002J\u0012\u0010Ö\u0003\u001a\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010×\u0003H\u0016J\u0012\u0010Ø\u0003\u001a\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010×\u0003H\u0016J\t\u0010Ù\u0003\u001a\u00020\u0014H\u0002J\u000b\u0010Ú\u0003\u001a\u0004\u0018\u00010[H\u0002J\t\u0010Û\u0003\u001a\u00020\u0014H\u0002R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u0004\u0018\u00010\"8DX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001b\u0010.\u001a\u00020/8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b0\u00101R\u0010\u00104\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u0002068DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010?\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010B\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010C\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010D\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020A\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020A0GX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010H\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0018\"\u0004\bJ\u0010\u001aR\u0010\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0004\n\u0002\u0010MR\u001b\u0010Q\u001a\u00020R8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bS\u0010TR\u0016\u0010W\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Z\u001a\n\u0012\u0004\u0012\u00020[\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\\\u001a\u0004\u0018\u00010]8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u00103\u001a\u0004\b^\u0010_R\u001a\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00160GX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010b\u001a\u00020\u0014X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001a\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020h0GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010i\u001a\b\u0012\u0004\u0012\u00020k0jX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010l\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010m\u001a\u000e\u0012\u0004\u0012\u00020n\u0012\u0004\u0012\u00020\u00160GX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010o\u001a\u000e\u0012\u0004\u0012\u00020p\u0012\u0004\u0012\u00020\u00160GX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010q\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020A0EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010s\u001a\u0004\u0018\u00010t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bw\u00103\u001a\u0004\bu\u0010vR\u001d\u0010x\u001a\u0004\u0018\u00010y8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b|\u00103\u001a\u0004\bz\u0010{R\u001f\u0010}\u001a\u0004\u0018\u00010~8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0081\u0001\u00103\u001a\u0005\b\u007f\u0010\u0080\u0001R \u0010\u0082\u0001\u001a\u00030\u0083\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0086\u0001\u00103\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R \u0010\u0087\u0001\u001a\u0004\u0018\u00010y8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0089\u0001\u00103\u001a\u0005\b\u0088\u0001\u0010{R\"\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008e\u0001\u00103\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\"\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0093\u0001\u00103\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\"\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0098\u0001\u00103\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\"\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009d\u0001\u00103\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\"\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u00018DX\u0084\u0084\u0002¢\u0006\u000f\n\u0005\b¢\u0001\u00103\u001a\u0006\b \u0001\u0010¡\u0001R\"\u0010£\u0001\u001a\u0005\u0018\u00010¤\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b§\u0001\u00103\u001a\u0006\b¥\u0001\u0010¦\u0001R\"\u0010¨\u0001\u001a\u0005\u0018\u00010©\u00018DX\u0084\u0084\u0002¢\u0006\u000f\n\u0005\b¬\u0001\u00103\u001a\u0006\bª\u0001\u0010«\u0001R\"\u0010\u00ad\u0001\u001a\u0005\u0018\u00010®\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b±\u0001\u00103\u001a\u0006\b¯\u0001\u0010°\u0001R\"\u0010²\u0001\u001a\u0005\u0018\u00010³\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¶\u0001\u00103\u001a\u0006\b´\u0001\u0010µ\u0001R\"\u0010·\u0001\u001a\u0005\u0018\u00010¸\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b»\u0001\u00103\u001a\u0006\b¹\u0001\u0010º\u0001R\"\u0010¼\u0001\u001a\u0005\u0018\u00010½\u00018DX\u0084\u0084\u0002¢\u0006\u000f\n\u0005\bÀ\u0001\u00103\u001a\u0006\b¾\u0001\u0010¿\u0001R\u0017\u0010Á\u0001\u001a\n\u0012\u0005\u0012\u00030Ã\u00010Â\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010Ä\u0001\u001a\n\u0012\u0005\u0012\u00030Å\u00010Â\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010Æ\u0001\u001a\u00030Ç\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÊ\u0001\u00103\u001a\u0006\bÈ\u0001\u0010É\u0001R \u0010Ë\u0001\u001a\u00030Ì\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÏ\u0001\u00103\u001a\u0006\bÍ\u0001\u0010Î\u0001R\u0014\u0010Ð\u0001\u001a\u00070Ñ\u0001R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010Ò\u0001\u001a\u0019\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010Ó\u0001\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010Ô\u0001\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010Õ\u0001\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010Ø\u0001\u001a\u00030Ù\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010Ú\u0001R\u001f\u0010ý\u0001\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bþ\u0001\u0010d\"\u0005\bÿ\u0001\u0010fR\u000f\u0010\u0096\u0002\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0099\u0003\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0099\u0003\u0010\u0018R\u0016\u0010\u009a\u0003\u001a\u00020\u00168DX\u0084\u0004¢\u0006\u0007\u001a\u0005\b\u009a\u0003\u0010\u0018R\u0010\u0010\u009b\u0003\u001a\u00030\u009c\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009d\u0003\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009e\u0003\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009f\u0003\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010 \u0003\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010¡\u0003\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¢\u0003\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010£\u0003\u001a\u00030\u008d\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¤\u0003\u001a\u00030\u008d\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¥\u0003\u001a\u0005\u0018\u00010¦\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Â\u0003\u001a\u0005\u0018\u00010Ã\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ä\u0003\u001a\u0005\u0018\u00010Å\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Æ\u0003\u001a\u0005\u0018\u00010Ç\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010È\u0003\u001a\u00030É\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ê\u0003\u001a\u00030Ë\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006ß\u0003"}, d2 = {"Lcom/larus/asr/ChatBottomSpeakerComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "Lcom/larus/bmhome/ability/IChatSpeakerCoreAbility;", "Lcom/larus/asr/session/IFlowAsrSessionContext;", "Lcom/larus/audio/asr/HandsfreeAsrTraceSource;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "settingRepo", "Lcom/larus/bmhome/chat/model/repo/ISettingRepoService;", "getSettingRepo", "()Lcom/larus/bmhome/chat/model/repo/ISettingRepoService;", "keepScreenOnOwner", "", "initSpeaker", "", "getInitSpeaker", "()Z", "setInitSpeaker", "(Z)V", "speakerViewStub", "Landroid/view/ViewStub;", "getSpeakerViewStub", "()Landroid/view/ViewStub;", "setSpeakerViewStub", "(Landroid/view/ViewStub;)V", MmEndWindowAvatar.TYPE_SPEAKER, "Lcom/larus/asr/view/ChatSpeaker;", "getSpeaker", "()Lcom/larus/asr/view/ChatSpeaker;", "setSpeaker", "(Lcom/larus/asr/view/ChatSpeaker;)V", "hasSetAsrResultInterceptor", "flowAsrSession", "Lcom/larus/asr/session/IFlowAsrSession;", "getFlowAsrSession", "()Lcom/larus/asr/session/IFlowAsrSession;", "setFlowAsrSession", "(Lcom/larus/asr/session/IFlowAsrSession;)V", "chatAsrSessionManager", "Lcom/larus/asr/session/ChatAsrSessionManager;", "getChatAsrSessionManager$impl_mainlandRelease", "()Lcom/larus/asr/session/ChatAsrSessionManager;", "chatAsrSessionManager$delegate", "Lkotlin/Lazy;", "botId", "reader", "Lcom/larus/bmhome/chat/model/repo/ITtsReader;", "getReader", "()Lcom/larus/bmhome/chat/model/repo/ITtsReader;", "logger", "Lcom/larus/utils/logger/FlowFormatLogger;", "chatSpeakerConfig", "Lcom/larus/asr/config/ChatSpeakerConfig;", "chatSpeakerSpec", "Lcom/larus/asr/config/builder/ChatSpeakerSpec;", "onSpeakerCancelCallback", "Lkotlin/Function0;", "", "onSpeakerSubmitCallback", "onSpeakerSpeechCallback", "onSpeakerCancelOnNetworkUnavailable", "Lkotlin/Function2;", "onAlterToVoiceSendCallback", "Lkotlin/Function1;", "alterToVoiceSend", "getAlterToVoiceSend", "setAlterToVoiceSend", "alterToVoiceSendLru", "com/larus/asr/ChatBottomSpeakerComponent$alterToVoiceSendLru$1", "Lcom/larus/asr/ChatBottomSpeakerComponent$alterToVoiceSendLru$1;", "cacheAlterToVoiceSend", "localMsgId", "value", "bottomViewModel", "Lcom/larus/asr/BottomViewModelSpeakerViewModel;", "getBottomViewModel", "()Lcom/larus/asr/BottomViewModelSpeakerViewModel;", "bottomViewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "onConversationIdOrTypeChanged", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility$ChangeListener;", "Lcom/larus/im/bean/conversation/Conversation;", "onBotChanged", "Lcom/larus/im/bean/bot/BotModel;", "titleComponentAbility", "Lcom/larus/chat/api/IChatTitleAbility;", "getTitleComponentAbility", "()Lcom/larus/chat/api/IChatTitleAbility;", "titleComponentAbility$delegate", "asrResultInterceptor", DBDefinition.TASK_ID, "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "asrResultWithExtInterceptor", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/ASRWithExtResult;", "asrResultRewriteInterceptors", "", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$ISendContentRewriteInterceptor;", "onRealSendAudioMsgFinish", "successResultInterceptor", "Lcom/larus/audio/AsrSuccessResult;", "failResultInterceptor", "Lcom/larus/audio/AsrFailResult;", "audioDataCallback", "", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "listComponentAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getListComponentAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "listComponentAbility$delegate", "fragmentAbility", "Lcom/larus/chat/api/IChatFragmentOutAbility;", "getFragmentAbility", "()Lcom/larus/chat/api/IChatFragmentOutAbility;", "fragmentAbility$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "listAbility", "getListAbility", "listAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "asrDirectFillAbility", "Lcom/larus/asr/direct/IAsrDirectFillAbility;", "getAsrDirectFillAbility", "()Lcom/larus/asr/direct/IAsrDirectFillAbility;", "asrDirectFillAbility$delegate", "fastSendImageAbility", "Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "getFastSendImageAbility", "()Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "fastSendImageAbility$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "pageUploadedImageAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IPageUploadedImageAbility;", "getPageUploadedImageAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IPageUploadedImageAbility;", "pageUploadedImageAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "inputViewSlotAbility", "Lcom/larus/chat/api/IInputViewSlot;", "getInputViewSlotAbility", "()Lcom/larus/chat/api/IInputViewSlot;", "inputViewSlotAbility$delegate", "referenceMsgAbility", "Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "getReferenceMsgAbility", "()Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "referenceMsgAbility$delegate", "latestPhotoShortcutAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ILatestPhotoShortcutAbility;", "getLatestPhotoShortcutAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ILatestPhotoShortcutAbility;", "latestPhotoShortcutAbility$delegate", "obricInstructionAbility", "Lcom/obric/assistant/ability/chat/instruction/IObricInstructionAbility;", "getObricInstructionAbility", "()Lcom/obric/assistant/ability/chat/instruction/IObricInstructionAbility;", "obricInstructionAbility$delegate", "speakerStateListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/ChatSpeakerStateListener;", "asrLifeStateListeners", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/AsrLifeStateListener;", "continueTalkV2Config", "Lcom/larus/platform/model/audio/ContinueTalkV2Config;", "getContinueTalkV2Config", "()Lcom/larus/platform/model/audio/ContinueTalkV2Config;", "continueTalkV2Config$delegate", "speakConfig", "Lcom/larus/platform/model/SpeakStyleConfig;", "getSpeakConfig", "()Lcom/larus/platform/model/SpeakStyleConfig;", "speakConfig$delegate", "customAsrListener", "Lcom/larus/asr/ChatBottomSpeakerComponent$CustomAsrListener;", "asrSessionExtraProvider", "", "asrBizSceneProvider", "shouldInterruptMessageOnAsrStartProvider", WidgetCostModule.TYPE_ON_CREATE, "onAttach", "handsfreeResetListener", "com/larus/asr/ChatBottomSpeakerComponent$handsfreeResetListener$1", "Lcom/larus/asr/ChatBottomSpeakerComponent$handsfreeResetListener$1;", "wireHandsfreeCallback", "view", "findMessageListPassthroughTarget", "Landroid/view/View;", "resolveConfiguredSpeakerSpec", "applySpeakerConfig", PickerReporterConstants.KEY.TARGET, "onViewCreated", "onPause", "onResume", "onStop", "onFragmentViewDestroyed", LiveCommonConstants.REASON_ON_DEDTROY, "trySetContinuousSpeech", "countDownRecordTime", "setSpeakerViewTag", "tagId", "getSpeakerViewTag", "", "setChatSpeakerCancelListener", "msg", "Lcom/larus/im/bean/message/Message;", "(Ljava/lang/String;Lcom/larus/im/bean/message/Message;)Lkotlin/Unit;", "setChatSpeakerSubmitListener", "setChatSpeakerAlterAudioListener", "setChatSpeakerSpeechListener", "()Lkotlin/Unit;", "setSpeakerGradientBackground", "resId", "isSpeaking", "deleteOlderAudioFileForO", "deleteOlderFile", "parentPath", "delayHideImeAfterAudioSend", "runningSpeakTaskId", "getRunningSpeakTaskId", "setRunningSpeakTaskId", "sendAudioMessageAdapter", "newExt", "", "invokeOnSpeak", "fromTextArea", "asrOnly", "voiceInputType", "Lcom/larus/asr/VoiceInputType;", "needVibrate", "traceInfo", "Lcom/larus/audio/asr/AsrTraceInfo;", "vuiId", "preStartTime", "", "onFinishCall", "extraMap", "callback", "(ZZLcom/larus/asr/VoiceInputType;ZLcom/larus/audio/asr/AsrTraceInfo;Ljava/lang/Integer;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "getCurrentPicCnt", "createAsrSession", "Lkotlin/Triple;", "asrTaskId", "moveCount", "handleTouchAction", "action", "globalX", "", "globalY", "deltaX", "deltaY", "initChatData", "Lorg/json/JSONObject;", "count", "setSpeakerViewVisible", "visible", "reason", "performCancel", "setImmerse", "isImmerse", "immerseBgColor", "registerSpeakerStateListener", "listener", "unregisterSpeakerStateListener", "setAudioVisualizerBottomMargin", GXTemplateKey.FLEXBOX_MARGIN, "setTaskIdForUpdateAsrScreenshot", "registerAsrListener", "unregisterAsrListener", "enableSpeakerHandleTouch", "setSpringUIMode", "obtainSpeakerView", "notifyStateChanged", "state", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/ChatSpeakerState;", "forceDarkMode", "hideBackground", "appendInstructionParams", "asr", "messageExt", "addConversationIdOrTypeListener", "removeConversationIdOrTypeListener", "addBotListenerVibrateAdapter", "addBotListener", "setOnAsrResultInterceptor", "successResultHandle", "failResultHandle", "audioDataHandle", "handle", "setOnRealSendAudioMessageFinishCallback", "setOnAsrResultWithExtInterceptor", "withExtHandle", "addAsrResultRewriteInterceptor", "interceptor", "removeAsrResultRewriteInterceptor", "removeBotListener", "updateColorForSubscriber", "conversation", "updateBotId", "getCurrentBotIdByArguments", "canUseSimultaneousTranslator", "setForceHideSpearShadow", "forceHide", "stopReader", "manual", "isTtsEnabled", "getViewModel", "Lcom/larus/asr/session/IFlowAsrMsgHandler;", "hideSpeakerAndSubmit", "getBotModel", "getConversation", "getChatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "isSpeakerVisible", "setKeepScreenOn", "on", "interruptAudioTextSubmit", "scrollToLatest", "onAsrStart", "onAsrAudioData", "data", "fillInTextInput", "asrResult", "requestFocus", "appendAsrResultIfVoiceRetained", "reportAudioInputEditing", "handleAsrResultInModify", "interruptAudioTextResult", "checkInputLegality", "processAsrResult", "processAsrResultForSendMessage", "dealWithAsrFileForO", "getReferenceImage", "getReferenceMessageInfo", "Lcom/larus/im/bean/message/ReferenceInfo;", "packAudioTextMsgExt", "sendMsg", "refInfo", "attachInfo", "rewriteAsrMessageContent", "content", "afterSendAudioText", "requestAudioPermission", "packExtAfterAddLocal", "ext", "enableAsrTwopass", "afterAddAudioTextMsg", "isAsrSpeakerPressed", "resetInputHint", "switch2TextInput", "hintText", "packAsrChatContext", "Lorg/json/JSONArray;", "getRunningSpeakerTaskId", "resetSpeakerListeners", "getLarkSessionContext", "getAsrBizScene", "shouldInterruptMessageOnAsrStart", "getAlterToVoiceSendForMsg", "setConfig", "config", "setSpec", "spec", "setOnCancel", "setOnCancelOnNetworkUnavailable", "setOnSubmit", "setOnSpeech", "onAlterToVoiceSend", "getSessionContext", "Landroid/content/Context;", "setAsrSessionExtraProvider", ShortVideoSegments.KEY_PROP_PROVIDER, "setAsrBizSceneProvider", "setShouldInterruptMessageOnAsrStartProvider", "isHandsfreeScene", "isHandsfreeExperimentOn", "currentAsrInputMode", "Lcom/larus/asr/handsfree/AsrInputMode;", "handsfreeAutoSubmitInFlight", "handsfreeSubmitDispatched", "handsfreeForceBackfillSession", "handsfreeEnterMethod", "pendingHandsfreeEnterMethod", "isDirectHandsfreeEntry", "handsfreeModeStartTime", "speakSessionStartTime", "endTraceSnapshot", "Lcom/larus/asr/ChatBottomSpeakerComponent$HandsfreeTraceState;", "currentTraceState", "currentHandsfreeAsrTraceFields", "eventName", "isHandsfreeBackfillBehavior", "getHandsfreeDurationMs", "getHandsfreeEnterMethod", "getCurrentAsrInputMode", "isInHandsfreeMode", "isHandsfreeSessionLatched", "updateHandsfreeBackfillAsrLogId", "asrLogId", "isHandsfreeForceBackfillSession", "shouldForceHandsfreeBackfillOnMaxDuration", "markHandsfreeForceBackfillSession", "enterHandsfree", "resetAsrInputMode", "hasHandsfreeBlockingArtifacts", "submitHandsfreeOnce", "from", "handleHandsfreeOnStopSettled", "stopActivity", "Landroid/app/Activity;", "tryEnterHandsfreeDirectly", "entry", "Lcom/larus/asr/handsfree/HandsfreeDirectEntry;", "traceId", "enterFrom", "overlay", "Lcom/larus/asr/handsfree/HandsfreeBlockOverlayView;", "handsfreeAutoSendWarningTimer", "Landroid/os/CountDownTimer;", "handsfreeAutoSendWarningToast", "Lcom/larus/common_ui/toast/ToastUtils$ToastHandle;", "backToastDebouncer", "Lcom/larus/asr/handsfree/HandsfreeBlockToastDebouncer;", "backCallback", "Landroidx/activity/OnBackPressedCallback;", "registerHandsfreeBackCallback", "showHandsfreeBlockToast", "showOrUpdateHandsfreeAutoSendWarning", "leftSeconds", "startHandsfreeAutoSendWarningTimer", "stopHandsfreeAutoSendWarningTimer", "onHandsfreeActivated", "onHandsfreeDeactivated", "installFocusInterruptHandler", "uninstallFocusInterruptHandler", "getImageUriList", "", "getImageUrlList", "getConversationId", "currentBot", "getBotId", "Companion", "CustomAsrListener", "HandsfreeTraceState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ChatBottomSpeakerComponent extends BaseContentWidget implements com.larus.bmhome.chat.component.bottom.core.speaker.l, va8.u, com.larus.asr.session.p, com.larus.audio.asr.m0 {
    public static final Set<String> F2 = null;
    public final b0 A;
    public boolean B;
    public final ChatBottomSpeakerComponent$alterToVoiceSendLru$1 C;
    public final com.larus.ui.arch.vm.internal.l D;
    public p1 E;
    public final ChatBottomSpeakerComponent$backCallback$1 E2;
    public o1 F;
    public final Lazy G;
    public String G1;
    public Function1<? super String, Boolean> H;
    public final Lazy H0;
    public int H1;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Function1<? super String, com.larus.bmhome.chat.component.bottom.core.speaker.a> f287073J;
    public final List<ICoreInputAbility.c> K;
    public Function0<Unit> L;
    public final Lazy L0;
    public volatile AsrInputMode L1;
    public Function1<? super com.larus.audio.b, Boolean> M;
    public volatile boolean M1;
    public Function1<? super com.larus.audio.a, Boolean> N;
    public Function2<? super String, ? super byte[], Unit> O;
    public final Lazy P;
    public final Lazy P0;
    public volatile boolean P1;
    public final Lazy Q;
    public volatile boolean Q1;
    public final Lazy R;
    public final Lazy S;
    public volatile String S1;
    public final Lazy T;
    public String T1;
    public final Lazy U;
    public final Lazy V;
    public final CopyOnWriteArraySet<com.larus.bmhome.chat.component.bottom.core.speaker.h> V0;
    public volatile boolean V1;
    public final Lazy W;
    public final Lazy X;
    public final Lazy Y;
    public final Lazy Z;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public final CopyOnWriteArraySet<com.larus.bmhome.chat.component.bottom.core.speaker.b> f287074b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public volatile long f287075b2;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public final Lazy f287076g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public volatile long f287077g2;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public final Lazy f287078h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public volatile c f287079h2;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final Lazy f287080k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public final b f287081k1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f287082m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f287083n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f287084o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewStub f287085p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final Lazy f287086p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public Function0<? extends Map<String, String>> f287087p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public d58.c f287088p2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ChatSpeaker f287089q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f287090r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.larus.asr.session.o f287091s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f287092t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f287093u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final f2a.d f287094v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public Function0<String> f287095v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public t1 f287096v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public x48.b f287097w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public y48.v f287098x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public Function0<Boolean> f287099x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public t19.s.a f287100x2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Function0<Unit> f287101y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public final e f287102y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public final d58.e f287103y2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Function2<? super String, ? super Boolean, Unit> f287104z;

    /* JADX INFO: loaded from: classes3.dex */
    public static final class a {
    }

    /* JADX INFO: loaded from: classes3.dex */
    public final class b implements h68.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatBottomSpeakerComponent f287105a;

        @Override // h68.d
        public final void b(h68.b r100) {
            Intrinsics.checkNotNullParameter(r100, "asrStreamSentenceResp");
        }

        @Override // h68.d
        public final void f(y58.b r100, ReportType r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "type");
        }

        public b(ChatBottomSpeakerComponent r100) {
            this.f287105a = r100;
        }

        @Override // h68.d
        public final void a(y58.b r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            y58.b r101 = y58.b.a(r100, g2a.d.b(r100.f566271d));
            FLogger.f375446a.i("ChatBottomSpeakerComponent", "onResult => audioState:" + r100.f566274g + ", errCode:" + r100.f566269b + ",errorMessage:" + r100.f566270c + ",result:" + r101);
            Iterator<com.larus.bmhome.chat.component.bottom.core.speaker.b> r102 = this.f287105a.f287074b1.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r102.next().a(r100);
            goto L4
        }

        @Override // h68.d
        public final void c(SamiAsrDataBin r100) {
            FLogger.f375446a.i("ChatBottomSpeakerComponent", "onAsrResponse");
        }

        @Override // h68.d
        public final void e(AsrState r100) {
            Intrinsics.checkNotNullParameter(r100, "asrState");
            FLogger.f375446a.i("ChatBottomSpeakerComponent", "onStateChange => asrState: " + r100);
        }

        @Override // h68.d
        public void onEvent(AsrEventEnum r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            FLogger.f375446a.i("ChatBottomSpeakerComponent", "onEvent : " + r100);
        }

        @Override // h68.d
        public final void d(AsrLifeState r100, String r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "lifeState");
            FLogger.f375446a.i("ChatBottomSpeakerComponent", "onLifeStateChange => lifeState=" + r100 + " taskId=" + r101 + " extraMap=" + g2a.d.c(GsonProtectorUtils.toJson(new Gson(), r102)));
            ObricActionBarTrackServiceDelegate.f392818b.t(r100, r101, r102);
            Iterator<T> r103 = this.f287105a.f287074b1.iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            ((com.larus.bmhome.chat.component.bottom.core.speaker.b) r103.next()).q(r100, r101, r102);
            goto L4
        }
    }

    /* JADX INFO: loaded from: classes24.dex */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f287107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f287108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f287109c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f287110d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f287111e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f287107a == r101.f287107a) goto L12;
            return false;
        L12:
            if (this.f287108b == r101.f287108b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f287109c, r101.f287109c) == true) goto L18;
            return false;
        L18:
            if (this.f287110d == r101.f287110d) goto L21;
            return false;
        L21:
            if (this.f287111e == r101.f287111e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f287107a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f287108b == true) goto L10;
            r100 = 1237;
        L10:
            int r103 = (r102 + r100) * 31;
            String r104 = this.f287109c;
            if (r104 != null) goto L13;
            int r105 = 0;
        L14:
            int r106 = (r103 + r105) * 31;
            long r107 = this.f287110d;
            int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
            long r109 = this.f287111e;
            return r108 + ((int) (r109 ^ (r109 >>> 32)));
        L13:
            r105 = r104.hashCode();
            goto L14
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "HandsfreeTraceState(isHandsfreeMode=" + this.f287107a + ", isDirectEntry=" + this.f287108b + ", enterMethod=" + this.f287109c + ", handsfreeDurationMs=" + this.f287110d + ", totalDurationMs=" + this.f287111e + ')';
        }

        public c(boolean r100, boolean r101, String r102, long r103, long r104) {
            this.f287107a = r100;
            this.f287108b = r101;
            this.f287109c = r102;
            this.f287110d = r103;
            this.f287111e = r104;
        }
    }

    /* JADX INFO: loaded from: classes24.dex */
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f287112a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f287113b = null;

        static {
            int[] r100 = new int[VoiceInputType.values().length];
            r100[VoiceInputType.ClickSpeaker.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[VoiceInputType.DoraVoiceSpeaker.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L29:
            r100[VoiceInputType.ThirdPartySpeaker.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L23:
            r100[VoiceInputType.DoraRadioSpeaker.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L8:
            f287112a = r100;
            int[] r101 = new int[HandsfreeDirectEntry.values().length];
            r101[HandsfreeDirectEntry.MIC_ICON_CLICK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L25:
            r101[HandsfreeDirectEntry.VOICE_INPUT_BUTTON_PRESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L11:
            f287113b = r101;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class e implements com.larus.bmhome.chat.component.bottom.core.speaker.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatBottomSpeakerComponent f287114a;

        public e(ChatBottomSpeakerComponent r100) {
            this.f287114a = r100;
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.speaker.h
        public final void a(com.larus.bmhome.chat.component.bottom.core.speaker.g r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if ((r100 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.e) == false) goto L5;
        L8:
            FLogger.f375446a.i("ChatBottomSpeakerComponent", "[HF] handsfreeResetListener: state=" + Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName() + " -> resetAsrInputMode");
            this.f287114a.j4();
            return;
        L5:
            if (Intrinsics.areEqual(r100, com.larus.bmhome.chat.component.bottom.core.speaker.g.b.f299420a) == true) goto L8;
            if (Intrinsics.areEqual(r100, com.larus.bmhome.chat.component.bottom.core.speaker.g.a.f299419a) == true) goto L8;
        }
    }

    /* JADX INFO: loaded from: classes24.dex */
    public static final class f implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatBottomSpeakerComponent f287115a;

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            maa.e r100 = (maa.e) s1a.d.a(this.f287115a).getAbility(maa.e.class);
            if (r100 == null) goto L6;
            r100.v50("pressing bottom button");
        L6:
            return Unit.INSTANCE;
        }

        public f(ChatBottomSpeakerComponent r100) {
            this.f287115a = r100;
        }
    }

    /* JADX INFO: loaded from: classes24.dex */
    public static final class g implements com.larus.platform.api.g1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2<Boolean, Boolean, Unit> f287116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChatBottomSpeakerComponent f287117b;

        @Override // com.larus.platform.api.g1.b
        public final void onGoSettingsDialogDismiss(boolean r100) {
        }

        @Override // com.larus.platform.api.g1.b
        public final void onGoSettingsDialogShow() {
        }

        @Override // com.larus.platform.api.g1.b
        public final void onSettingPageReturn() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public g(Function2<? super Boolean, ? super Boolean, Unit> r100, ChatBottomSpeakerComponent r101) {
            this.f287116a = r100;
            this.f287117b = r101;
        }

        @Override // com.larus.platform.api.g1.c
        public final void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "grantedList");
            Intrinsics.checkNotNullParameter(r102, "deniedList");
            this.f287116a.invoke(Boolean.valueOf(r100), Boolean.TRUE);
            com.larus.bmhome.instruction.g r104 = this.f287117b.vc();
            if (r104 == null) goto L6;
            r104.Ot();
            return;
        }
    }

    public static final class h implements Function0<ry8.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f287118a;

        public h(AttachReceiver r100) {
            this.f287118a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [ry8.a, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final ry8.a invoke() {
            AttachReceiver r100 = this.f287118a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(ry8.a.class));
        }
    }

    public static final class i implements Function0<qaa.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f287119a;

        public i(AttachReceiver r100) {
            this.f287119a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [qaa.a, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final qaa.a invoke() {
            AttachReceiver r100 = this.f287119a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(qaa.a.class));
        }
    }

    public static final class j implements Function0<LifecycleOwner> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentFeature f287120a;

        public j(ComponentFeature r100) {
            this.f287120a = r100;
        }

        @Override // kotlin.jvm.functions.Function0
        public final LifecycleOwner invoke() {
            return this.f287120a;
        }
    }

    public static final class k implements Function0<ViewModelStoreOwner> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentFeature f287121a;

        public k(ComponentFeature r100) {
            this.f287121a = r100;
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStoreOwner invoke() {
            return s1a.a.c(this.f287121a);
        }
    }

    public static final class l implements Function0<ViewModelProvider.Factory> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f287122a = null;

        static {
            f287122a = new l();
        }

        public l() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    @Override // com.larus.asr.session.p
    public void Ga(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
    }

    @Override // com.larus.asr.session.p
    public String Jb(String r100) {
        Intrinsics.checkNotNullParameter(r100, "asrResult");
        return r100;
    }

    public void l4(Map<String, String> r100) {
    }

    static {
        F2 = SetsKt.setOf(new String[]{DocumentType.DOCX_NAME, DocumentType.SHEET_NAME, "slides"});
    }

    private final ICoreInputAbility Z3() {
        return (ICoreInputAbility) this.U.getValue();
    }

    private final de8.c f1() {
        return (de8.c) this.S.getValue();
    }

    private final com.larus.bmhome.chat.component.bottom.reference.a g5() {
        return (com.larus.bmhome.chat.component.bottom.reference.a) this.H0.getValue();
    }

    private final com.larus.bmhome.chat.component.cvs.y u0() {
        return (com.larus.bmhome.chat.component.cvs.y) this.P.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void A2() {
        AsrInputMode r100 = this.L1;
        AsrInputMode r101 = AsrInputMode.HANDSFREE;
        if (r100 != r101) goto L13;
        FLogger r102 = FLogger.f375446a;
        r102.w("ChatBottomSpeakerComponent", "[HF] onFragmentViewDestroyed: cancel active handsfree session before root destroyed");
        ChatSpeaker r103 = a4();
        if (r103 == null) goto L8;
        r103.E7();
    L8:
        if (this.L1 != r101) goto L10;
    L11:
        r102.w("ChatBottomSpeakerComponent", "[HF] onFragmentViewDestroyed: cancel did not reset handsfree state, force reset");
        j4();
    L15:
        com.larus.asr.handsfree.a.f287297a.getClass();
        com.larus.asr.handsfree.a.a();
        return;
    L10:
        if (d4() == false) goto L15;
    L13:
        if (d4() == false) goto L15;
        FLogger.f375446a.w("ChatBottomSpeakerComponent", "[HF] onFragmentViewDestroyed: force reset handsfree UI artifacts before root destroyed");
        j4();
        goto L15
    }

    @Override // com.larus.asr.session.p
    public final List<String> E9() {
        com.larus.bmhome.chat.component.bottom.core.speaker.n r100 = (com.larus.bmhome.chat.component.bottom.core.speaker.n) this.Z.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.E9();
    }

    @Override // com.larus.asr.session.p
    public final long Ea() {
        if (this.f287075b2 > 0) goto L5;
        return 0;
    L5:
        return SystemClock.elapsedRealtime() - this.f287075b2;
    }

    @Override // com.larus.asr.session.p
    public final boolean I9() {
        ry8.b r100 = (ry8.b) this.G.getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r100.L9(), Boolean.TRUE);
    }

    @Override // com.larus.asr.session.p
    public final List<String> L0() {
        com.larus.bmhome.chat.component.bottom.core.speaker.n r100 = (com.larus.bmhome.chat.component.bottom.core.speaker.n) this.Z.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.L0();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final boolean Lo() {
        if (this.L1 != AsrInputMode.HANDSFREE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public boolean N70() {
        if (this.f287093u == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.asr.session.p
    public boolean Ra() {
        if (com.larus.platform.service.z2.f365865a.getStreamAsrConfig().b() == true) goto L13;
        m58.q r100 = m58.h.f512133d;
        if (r100 == null) goto L11;
        ASRModule r101 = r100.c();
        if (r101 == null) goto L11;
        if (r101.n() != true) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == true) goto L13;
        return false;
    L11:
        r102 = false;
    L13:
        com.larus.bmhome.instruction.g r103 = vc();
        if (r103 != null) goto L16;
    L18:
        boolean r104 = false;
    L19:
        if (r104 == true) goto L30;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r105 = f70();
        if (r105 != null) goto L23;
    L25:
        boolean r106 = false;
    L26:
        if (r106 == true) goto L31;
        return true;
    L31:
        return false;
    L23:
        if (r105.iJ() != true) goto L25;
        r106 = true;
        goto L26
    L30:
        return false;
    L16:
        if (r103.z0() != true) goto L18;
        r104 = true;
        goto L19
    }

    @Override // com.larus.asr.session.p
    public final JSONArray Xa() {
        hq9.n r100 = com.larus.platform.service.z2.f365865a.U0().a();
        if (r100 == null) goto L5;
        int r101 = r100.a();
    L6:
        JSONObject r102 = new JSONObject();
        JSONArray r103 = new JSONArray();
        Object r104 = null;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L15
        u7 r106 = (u7) this.T.getValue();     // Catch: Throwable -> L15
        if (r106 == null) goto L12;
        MessageAdapter r107 = r106.MF();     // Catch: Throwable -> L15
        if (r107 == null) goto L12;
        List r108 = CollectionsKt.take(r107.getCurrentList(), r101);     // Catch: Throwable -> L15
    L13:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r109) == true) goto L21;
        r104 = r109;
    L21:
        List r110 = (List) r104;
        if (r110 != null) goto L24;
        r110 = CollectionsKt.emptyList();
    L24:
        Iterator r111 = r110.iterator();
    L26:
        if (r111.hasNext() == false) goto L59;
        Message r112 = (Message) r111.next();
        String r113 = r112.getContent();
        if (r113 != null) goto L30;
    L33:
        boolean r114 = true;
    L34:
        if (r114 == true) goto L26;
        if (com.larus.bmhome.chat.bean.d.G0(r112) == false) goto L44;
        if (r112.getContentType() != 1) goto L44;
        if (r112.getSourceFromAsr() == false) goto L44;
        JSONObject r115 = new JSONObject();
        r115.put("type", "asr_input");
        r115.put("data", r112.getContent());
        r115.put("time", String.valueOf(r112.getCreateTime()));
        r103.put(r115);
    L44:
        if (com.larus.bmhome.chat.bean.d.G0(r112) == false) goto L53;
        if (r112.getMessageStatusLocal() != 11) goto L53;
        if (r112.getContentType() == 1) goto L53;
        if (r112.getSourceFromAsr() == false) goto L53;
        JSONObject r116 = new JSONObject();
        r116.put("type", "user_input");
        r116.put("data", r112.getContent());
        r116.put("time", String.valueOf(r112.getCreateTime()));
        r103.put(r116);
    L53:
        if (com.larus.bmhome.chat.bean.d.G0(r112) == true) goto L26;
        String r117 = r112.getContent();
        if (r117 == null) goto L26;
        if (r117.length() > 8000) goto L26;
        JSONObject r118 = new JSONObject();
        r118.put("type", "bot_resp");
        JSONObject r119 = new JSONObject();
        r119.put("content", r117);
        r119.put("content_type", r112.getContentType());
        Unit r120 = Unit.INSTANCE;
        r118.put("data", r119.toString());
        r118.put("time", String.valueOf(r112.getCreateTime()));
        r103.put(r118);
        goto L26
    L30:
        if (r113.length() == 0) goto L33;
        r114 = false;
        goto L34
    L59:
        r102.put("chat_context", r103);
        RepoDispatcherDelegate r121 = RepoDispatcherDelegate.f307737b;
        r102.put(SpeechEngineDefines.PARAMS_KEY_ASR_LANGUAGE_STRING, r121.c().S0());
        r102.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r121.c().Z(r121.c().r0()));
        r102.put("speech_language", r121.c().Q0());
        return r102.optJSONArray("chat_context");
    L12:
        r108 = null;
    L15:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    L5:
        r101 = 20;
        goto L6
    }

    public final ChatSpeaker a4() {
        if (this.f287085p == null) goto L11;
        if (this.f287089q != null) goto L11;
        ChatSpeaker r100 = e4();
        if (r100 == null) goto L9;
        this.f287084o = true;
        this.f287089q = r100;
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "[SpeakerBuilder] initializeSpeaker component=" + getClass().getSimpleName() + " target=" + r100.getClass().getSimpleName() + ':' + r100.hashCode() + " builderEnabled=" + y48.h.a());
        H3(r100);
        goto L11
    L9:
        FLogger.f375446a.e("ChatBottomSpeakerComponent", "please check view! speaker is null and v is " + r100);
    L11:
        return this.f287089q;
    }

    public final boolean d4() {
        if (this.f287088p2 == null) goto L5;
    L8:
        return true;
    L5:
        if (isEnabled() == true) goto L8;
        return false;
    }

    public ChatSpeaker e4() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("[HF] initSpeaker: invoked, speakerViewStub=");
        boolean r102 = false;
        if (this.f287085p == null) goto L5;
        boolean r103 = true;
    L6:
        r101.append(r103);
        r100.i("ChatBottomSpeakerComponent", r101.toString());
        if (com.larus.bmhome.utils.i2.a().e() == false) goto L11;
        IChatBottomNitaView r104 = (IChatBottomNitaView) ServiceManager.get().getService(IChatBottomNitaView.class);
        if (r104 == null) goto L11;
        View r105 = r104.a(getContext());
    L12:
        if (r105 == null) goto L23;
        ViewStub r106 = this.f287085p;
        if (r106 != null) goto L16;
    L18:
        boolean r107 = false;
    L19:
        if (r107 == false) goto L23;
        ViewStub r108 = this.f287085p;
        if (r108 == null) goto L26;
        View r109 = sy8.a.a(r108, r108.getId(), r105);
    L27:
        StringBuilder r110 = new StringBuilder("[HF] initSpeaker: inflated=");
        if (r109 == null) goto L30;
        r102 = true;
    L30:
        r110.append(r102);
        r110.append(" type=");
        if (r109 == null) goto L33;
        String r111 = r109.getClass().getSimpleName();
    L34:
        r110.append(r111);
        r100.i("ChatBottomSpeakerComponent", r110.toString());
        if ((r109 instanceof ChatSpeaker) == false) goto L38;
        ChatSpeaker r112 = (ChatSpeaker) r109;
        v4(r112);
        return r112;
    L38:
        return null;
    L33:
        r111 = null;
    L26:
        r109 = null;
        goto L27
    L16:
        if (r106.isAttachedToWindow() != true) goto L18;
        r107 = true;
    L23:
        ViewStub r113 = this.f287085p;
        if (r113 == null) goto L26;
        r113.setLayoutResource(R.layout.larus_layout_chat_speaker);
        r109 = r113.inflate();
    L11:
        r105 = null;
        goto L12
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.larus.asr.session.p
    public final BottomViewModelSpeakerViewModel f() {
        return (BottomViewModelSpeakerViewModel) this.D.getValue();
    }

    public final com.larus.bmhome.chat.component.bottom.attachment.g1 f70() {
        return (com.larus.bmhome.chat.component.bottom.attachment.g1) this.Y.getValue();
    }

    public final void i4() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("[HF] onHandsfreeDeactivated: begin overlay=");
        if (this.f287088p2 == null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        r100.i("ChatBottomSpeakerComponent", r101.toString());
        com.larus.asr.handsfree.a.f287297a.getClass();
        com.larus.asr.handsfree.a.a();
        t1 r103 = this.f287096v2;
        if (r103 == null) goto L9;
        r103.cancel();
    L9:
        this.f287096v2 = null;
        t19.s.a r104 = this.f287100x2;
        if (r104 == null) goto L12;
        com.larus.utils.t0.e(new t19.r(r104));
    L12:
        this.f287100x2 = null;
        d58.c r105 = this.f287088p2;
        if (r105 == null) goto L20;
        ViewParent r106 = r105.getParent();
        if ((r106 instanceof ViewGroup) == false) goto L17;
        ViewGroup r107 = (ViewGroup) r106;
    L18:
        if (r107 == null) goto L20;
        r107.removeView(r105);
        r100.i("HandsfreeBlockOverlay", "detached from parent=".concat(r107.getClass().getSimpleName()));
        goto L20
    L17:
        r107 = null;
    L20:
        this.f287088p2 = null;
        ChatSpeaker r108 = a4();
        if (r108 == null) goto L23;
        r108.c6();
    L23:
        setEnabled(false);
        x5.d().a(false);
        x5.a().b(null);
        x5.a().c(null);
        r100.i("ChatBottomSpeakerComponent", "[HF] onHandsfreeDeactivated: done");
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void j4() {
        AsrInputMode r100 = this.L1;
        AsrInputMode r101 = AsrInputMode.LONG_PRESS;
        boolean r102 = true;
        if (r100 == r101) goto L5;
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("[HF] resetAsrInputMode: HANDSFREE -> LONG_PRESS (caller=");
        StackTraceElement r105 = (StackTraceElement) ArraysKt.getOrNull(new Throwable().getStackTrace(), 1);
        if (r105 == null) goto L17;
        String r106 = r105.getMethodName();
    L18:
        r104.append(r106);
        r104.append(')');
        r103.i("ChatBottomSpeakerComponent", r104.toString());
        this.f287079h2 = W3();
        this.L1 = r101;
        i4();
        return;
    L17:
        r106 = null;
        goto L18
    L5:
        if (d4() == false) goto L12;
        FLogger r107 = FLogger.f375446a;
        StringBuilder r108 = new StringBuilder("[HF] resetAsrInputMode: already LONG_PRESS but blocking artifacts remain (overlay=");
        if (this.f287088p2 != null) goto L10;
        r102 = false;
    L10:
        r108.append(r102);
        r108.append(", back=");
        r108.append(isEnabled());
        r108.append(") -> force deactivate");
        r107.w("ChatBottomSpeakerComponent", r108.toString());
        i4();
        return;
    L12:
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "[HF] resetAsrInputMode: already LONG_PRESS, no-op");
    }

    public final y48.v k4() {
        y48.v r100 = this.f287098x;
        if (r100 != null) goto L29;
        int r101 = y48.f.f566092h;
        y48.f r102 = y48.f.a.a();
        r102.b(this.f287097w);
        x48.b r103 = this.f287097w;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        if (r103 == null) goto L28;
        z48.a r104 = r103.f562448a;
        if (r104 == null) goto L28;
        final a58.a r105 = r104.f570033a;
        if (r105 == null) goto L15;
        Function1 r106 = new u1(r105);
        Intrinsics.checkNotNullParameter(r106, "configure");
        ChatSpeakerElementKey r107 = ChatSpeakerElementKey.Tips;
        Map<ChatSpeakerElementKey, y48.i> r108 = r102.f566096d;
        y48.i r109 = r108.get(r107);
        if (r109 != null) goto L14;
        int r110 = y48.i.f566101j;
        r109 = y48.i.a.a(r107);
    L14:
        Intrinsics.checkNotNullParameter(r109, "source");
        y48.w r111 = new y48.w(r109);
        r106.invoke(r111);
        r108.put(r107, r111.a());
    L15:
        final b58.a r112 = r104.f570034b;
        if (r112 == null) goto L21;
        Function1 r113 = new v1(r112);
        Intrinsics.checkNotNullParameter(r113, "configure");
        ChatSpeakerElementKey r114 = ChatSpeakerElementKey.CancelArea;
        Map<ChatSpeakerElementKey, y48.i> r115 = r102.f566096d;
        y48.i r116 = r115.get(r114);
        if (r116 != null) goto L20;
        int r117 = y48.i.f566101j;
        r116 = y48.i.a.a(r114);
    L20:
        Intrinsics.checkNotNullParameter(r116, "source");
        y48.b r118 = new y48.b(r116);
        r113.invoke(r118);
        r115.put(r114, r118.a());
    L21:
        final b58.a r119 = r104.f570035c;
        if (r119 == null) goto L28;
        Function1 r120 = new w1(r119);
        Intrinsics.checkNotNullParameter(r120, "configure");
        ChatSpeakerElementKey r121 = ChatSpeakerElementKey.ActionArea;
        Map<ChatSpeakerElementKey, y48.i> r122 = r102.f566096d;
        y48.i r123 = r122.get(r121);
        if (r123 != null) goto L26;
        int r124 = y48.i.f566101j;
        r123 = y48.i.a.a(r121);
    L26:
        Intrinsics.checkNotNullParameter(r123, "source");
        y48.b r125 = new y48.b(r123);
        r120.invoke(r125);
        r122.put(r121, r125.a());
    L28:
        return r102.a();
    L29:
        return r100;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final boolean m0() {
        com.larus.asr.session.o r100 = this.f287091s;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.m0();
    }

    @Override // com.larus.asr.session.p
    public final void m8() {
        u7 r100 = (u7) this.T.getValue();
        if (r100 == null) goto L6;
        r100.w70();
        return;
    }

    @Override // com.larus.asr.session.p
    public final String nb() {
        Function0<String> r100 = this.f287095v1;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.invoke();
    }

    @Override // com.larus.asr.session.p
    public final boolean ob() {
        if (this.V1 == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f287075b2 > 0) goto L8;
        return false;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget, com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "[onCreate]");
        Bundle r100 = f1().f468086b;
        String r101 = "";
        if (r100 == null) goto L5;
        String r102 = r100.getString("argBotId", "");
    L7:
        if (com.larus.utils.o0.d(r102) == true) goto L16;
        com.larus.bmhome.chat.component.cvs.y r103 = u0();
        if (r103 == null) goto L15;
        String r104 = r103.getBotId();
        if (r104 == null) goto L15;
        r101 = r104;
    L15:
        r102 = r101;
    L16:
        this.f287093u = r102;
        CopyOnWriteArrayList<h68.d> r105 = com.larus.asr.d.f287231a;
        b r106 = this.f287081k1;
        Intrinsics.checkNotNullParameter(r106, "listener");
        com.larus.asr.d.f287231a.add(r106);
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public void onDestroy() {
        remove();
        B9(this.f287102y1);
        j4();
        com.larus.asr.handsfree.a.f287297a.getClass();
        com.larus.asr.handsfree.a.a();
        com.larus.audio.asr.m0 r100 = com.larus.audio.asr.l0.f288426a;
        Intrinsics.checkNotNullParameter(this, "source");
        if (com.larus.audio.asr.l0.f288426a != this) goto L5;
        com.larus.audio.asr.l0.f288426a = null;
    L5:
        com.larus.bmhome.chat.component.cvs.y r101 = u0();
        if (r101 == null) goto L8;
        r101.lQ(this.E);
    L8:
        com.larus.bmhome.chat.component.cvs.y r102 = u0();
        if (r102 == null) goto L11;
        r102.lQ(this.F);
    L11:
        CopyOnWriteArrayList<h68.d> r103 = com.larus.asr.d.f287231a;
        b r104 = this.f287081k1;
        Intrinsics.checkNotNullParameter(r104, "listener");
        CopyOnWriteArrayList<h68.d> r105 = com.larus.asr.d.f287231a;
        r105.remove(r104);
        ChatBottomSpeakerComponent$alterToVoiceSendLru$1 r106 = this.C;
        monitor-enter(r106);
        this.C.clear();     // Catch: Throwable -> L20
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r106);
        b r108 = this.f287081k1;
        Intrinsics.checkNotNullParameter(r108, "listener");
        r105.remove(r108);
        com.larus.asr.session.o r109 = this.f287091s;
        if (r109 == null) goto L18;
        r109.clear();
    L18:
        this.f287091s = null;
        return;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onPause() {
        if (this.f287084o == true) goto L5;
        return;
    L5:
        if (this.L1 != AsrInputMode.HANDSFREE) goto L7;
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "[HF] onPause: keep handsfree recording across foreground/background switch");
        return;
    L7:
        ChatSpeaker r100 = a4();
        if (r100 == null) goto L13;
        r100.E7();
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        if (this.f287088p2 != null) goto L5;
        return;
    L5:
        if (this.L1 == AsrInputMode.HANDSFREE) goto L9;
        FLogger.f375446a.w("ChatBottomSpeakerComponent", "[HF] onResume: overlay remains after handsfree exited -> force resetAsrInputMode (leak guard)");
        j4();
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onStop() {
        if (this.L1 != AsrInputMode.HANDSFREE) goto L6;
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "[HF] onStop: defer handsfree foreground/background decision");
        Intrinsics.checkNotNullParameter(this, "<this>");
        final FragmentActivity r100 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        com.larus.utils.t0.f375468a.post(new o(this, r100));
        return;
    L6:
        com.larus.asr.session.o r101 = this.f287091s;
        if (r101 == null) goto L9;
        r101.onStop();
    L9:
        setKeepScreenOn(false);
        if (d4() == false) goto L13;
        FLogger.f375446a.w("ChatBottomSpeakerComponent", "[HF] onStop: force reset remaining handsfree UI artifacts");
        j4();
        return;
    }

    @Override // com.larus.asr.session.p
    public final Map<String, String> qa() {
        Function0<? extends Map<String, String>> r100 = this.f287087p1;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.invoke();
    }

    @Override // com.larus.asr.session.p
    public final boolean ta() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Boolean.valueOf(AppHost.f326268a.a().isAppBackground()));     // Catch: Throwable -> L4
    L6:
        Boolean r102 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = r102;
    L9:
        boolean r103 = ((Boolean) r101).booleanValue();
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.bmhome.a0 r104 = com.larus.bmhome.b0.a(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        if (r104 != null) goto L12;
    L14:
        boolean r105 = false;
    L15:
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "[HF] shouldForceHandsfreeBackfillOnMaxDuration: appBackground=" + r103 + " sideBarOpen=" + r105);
        if (r103 == true) goto L23;
        if (r105 == true) goto L24;
        return false;
    L24:
        return true;
    L23:
        return true;
    L12:
        if (r104.Ga() != true) goto L14;
        r105 = true;
    L4:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // com.larus.asr.session.p
    public final void vb() {
        IAIChatControlTraceService.Companion r100 = IAIChatControlTraceService.f365889a;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r101 = f70();
        Integer r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(com.larus.bmhome.chat.component.bottom.attachment.g1.a.b(r101));
    L6:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r104 = f70();
        if (r104 == null) goto L9;
        Integer r105 = Integer.valueOf(r104.Y40(new m()));
    L10:
        com.larus.bmhome.instruction.g r106 = vc();
        if (r106 == null) goto L15;
        boolean r107 = true;
        if (r106.z0() != true) goto L15;
    L16:
        if (r107 == false) goto L20;
        com.larus.bmhome.instruction.g r108 = vc();
        if (r108 == null) goto L24;
        int r109 = r108.bd();
    L23:
        r102 = Integer.valueOf(r109);
    L24:
        r100.fc("audio", r103, r102, r105);
        return;
    L20:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r110 = f70();
        if (r110 == null) goto L24;
        r109 = r110.Y40(new n());
    L15:
        r107 = false;
        goto L16
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public final com.larus.bmhome.instruction.g vc() {
        return (com.larus.bmhome.instruction.g) this.f287080k0.getValue();
    }

    @Override // com.larus.asr.session.p
    public final boolean xa() {
        Function0<Boolean> r100 = this.f287099x1;
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.invoke().booleanValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public void y2() {
        FLogger r100 = FLogger.f375446a;
        r100.i("ChatBottomSpeakerComponent", "[HF] onAttach: component=" + hashCode() + " exp=" + h4() + " cfg=" + com.larus.platform.service.z2.f365865a.voiceInputHandsfreeConfig());
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, va8.u.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r101 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r101 != null) goto L5;
        r100.w("ChatBottomSpeakerComponent", "[HF] backCallback register skipped: activity is null");
    L6:
        e8(this.f287102y1);
        return;
    L5:
        OnBackPressedDispatcher r102 = r101.getOnBackPressedDispatcher();
        Intrinsics.checkNotNullParameter(this, "<this>");
        r102.addCallback(com.larus.ui.arch.component.internal.attach.a.b(this, this), this.E2);
        r100.i("ChatBottomSpeakerComponent", "[HF] backCallback registered on dispatcher");
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v63, types: [com.larus.asr.ChatBottomSpeakerComponent$backCallback$1] */
    public ChatBottomSpeakerComponent() {
        this.f287082m = R.id.speaker;
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "init ChatBottomSpeakerComponent");
        this.f287083n = "ChatBottomSpeakerComponent-" + hashCode();
        this.f287092t = LazyKt.lazy(LazyThreadSafetyMode.NONE, new p(this));
        this.f287094v = new f2a.d("VoiceInput", "ChatBottomSpeakerComponent");
        this.A = new b0();
        this.C = new ChatBottomSpeakerComponent$alterToVoiceSendLru$1();
        this.D = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(BottomViewModelSpeakerViewModel.class), Reflection.getOrCreateKotlinClass(ChatBottomSpeakerVMState.class), new j(this), new k(this), l.f287122a);
        this.G = LazyKt.lazy(new h0(this));
        this.H = new i0();
        this.I = "";
        this.f287073J = new j0();
        this.K = new ArrayList();
        this.M = new k0();
        this.N = new l0();
        this.O = new m0();
        this.P = LazyKt.lazy(new n0(this));
        this.Q = LazyKt.lazy(new o0(this));
        this.R = LazyKt.lazy(new h(this));
        this.S = LazyKt.lazy(new q(this));
        this.T = LazyKt.lazy(new r(this));
        this.U = LazyKt.lazy(new s(this));
        this.V = LazyKt.lazy(new t(this));
        this.W = LazyKt.lazy(new u(this));
        this.X = LazyKt.lazy(new w(this));
        this.Y = LazyKt.lazy(new x(this));
        this.Z = LazyKt.lazy(new y(this));
        this.f287080k0 = LazyKt.lazy(new z(this));
        this.f287086p0 = LazyKt.lazy(new a0(this));
        this.H0 = LazyKt.lazy(new c0(this));
        this.L0 = LazyKt.lazy(new d0(this));
        this.P0 = LazyKt.lazy(new i(this));
        this.V0 = new CopyOnWriteArraySet();
        this.f287074b1 = new CopyOnWriteArraySet();
        this.f287076g1 = LazyKt.lazy(new e0());
        this.f287078h1 = LazyKt.lazy(new f0());
        this.f287081k1 = new b(this);
        this.f287102y1 = new e(this);
        this.L1 = AsrInputMode.LONG_PRESS;
        this.f287103y2 = new d58.e(0);
        this.E2 = new ChatBottomSpeakerComponent$backCallback$1(this);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void A9() {
        ChatSpeaker r100 = a4();
        if (r100 == null) goto L6;
        r100.E7();
        return;
    }

    @Override // com.larus.asr.session.p
    public final Object F9() {
        ChatSpeaker r100 = a4();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTag();
    }

    @Override // com.larus.asr.session.p
    public final void Fa() {
        ICoreInputAbility r100 = Z3();
        if (r100 == null) goto L6;
        r100.Rk();
        return;
    }

    @Override // com.larus.asr.session.p
    public final ReferenceInfo G9() {
        com.larus.bmhome.chat.component.bottom.reference.a r100 = g5();
        if (r100 == null) goto L7;
        ReferenceInfo r101 = r100.T6();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return ObricActionBarTrackServiceDelegate.f392818b.r();
    }

    @Override // com.larus.asr.session.p
    public final ChatPageContext M1() {
        return (ChatPageContext) s1a.d.a(this).a(ChatPageContext.class);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void N4() {
        ChatSpeaker r100 = a4();
        if (r100 == null) goto L17;
        LarusWidgetSpeakerBinding r101 = r100.getBinding();
        if (r101 == null) goto L19;
        r100.B = true;
        r101.f287183e.setBackgroundResource(R.drawable.larus_bg_speaker_shadow_night);
        r101.f287194p.setTextColor(ColorProtector.parseColor("#FFCCCCCC"));
        TextView r102 = r101.f287189k;
        if (r102 == null) goto L10;
        r102.setTextColor(ColorProtector.parseColor("#FF777777"));
    L10:
        TextView r103 = r101.f287193o;
        if (r103 == null) goto L13;
        r103.setTextColor(ColorProtector.parseColor("#FF0A84FF"));
    L13:
        r101.f287181c.setBackgroundResource(R.drawable.larus_bg_audio_speak_dark);
        r101.f287180b.setBackgroundResource(R.drawable.larus_bg_audio_visualizer_dark);
        if (r100.f288112b.getEnableNewStyle() == false) goto L18;
        r101.f287182d.setBackground(ChatSpeaker.V5(ColorProtector.parseColor("#FF000000")));
        return;
    L18:
        return;
    L19:
        return;
    }

    @Override // com.larus.asr.session.p
    public final boolean Sa() {
        ChatSpeaker r100 = a4();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        return true;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void TO() {
        ChatSpeaker r100 = a4();
        if (r100 == null) goto L6;
        r100.setSpringUIMode(true);
        return;
    }

    public final c W3() {
        long r100 = SystemClock.elapsedRealtime();
        if (this.L1 != AsrInputMode.HANDSFREE) goto L5;
        boolean r101 = true;
    L6:
        boolean r102 = this.V1;
        String r103 = this.S1;
        long r104 = 0;
        if (this.f287075b2 <= 0) goto L9;
        long r105 = r100 - this.f287075b2;
    L11:
        if (this.f287077g2 <= 0) goto L14;
        r104 = r100 - this.f287077g2;
    L14:
        return new c(r101, r102, r103, r105, r104);
    L9:
        r105 = 0;
        goto L11
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.larus.asr.session.p
    public final AttachmentInfo X9() {
        com.larus.bmhome.instruction.g r100 = vc();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.n4();
    }

    @Override // com.larus.asr.session.p
    public final Context getSessionContext() {
        return getContext();
    }

    @Override // com.larus.asr.session.p
    public final wc9.e h() {
        com.larus.bmhome.chat.component.cvs.y r100 = u0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.h();
    }

    public final boolean h4() {
        b9 r100 = (b9) s1a.d.a(this).getAbility(b9.class);
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
        return false;
    L10:
        if (com.larus.platform.service.z2.f365865a.voiceInputHandsfreeConfig().isHandsfreeSupported() == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (r100.nt() != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void hideBackground() {
        ChatSpeaker r100 = a4();
        if (r100 == null) goto L6;
        r100.N6();
        return;
    }

    @Override // com.larus.asr.session.p
    public final BotModel i() {
        com.larus.bmhome.chat.component.cvs.y r100 = u0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.j0();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final ChatSpeaker jM() {
        return a4();
    }

    public final void p4() {
        Context r100 = getContext();
        if (r100 != null) goto L5;
        r100 = AppHost.f326268a.getApplication();
    L5:
        t19.s.f544207a.getClass();
        t19.s.s(r100, R.string.larus_voiceInput_toast_unsupportFeatures);
    }

    @Override // com.larus.asr.session.p
    public final boolean ya() {
        com.larus.bmhome.chat.component.bottom.attachment.g1 r100 = f70();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
    L16:
        return true;
    L10:
        if (this.L1 != AsrInputMode.HANDSFREE) goto L18;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r102 = f70();
        if (r102 == null) goto L14;
        int r103 = com.larus.bmhome.chat.component.bottom.attachment.g1.a.b(r102);
    L15:
        if (r103 > 0) goto L16;
        return false;
    L14:
        r103 = 0;
        goto L15
    L18:
        return false;
    L5:
        if (r100.iJ() != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void zu() {
        ChatSpeaker r100 = a4();
        if (r100 == null) goto L6;
        r100.setBackgroundResource(R.drawable.larus_bg_gradient_speaker_view);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l, com.larus.asr.session.p
    public final AsrInputMode B5() {
        return this.L1;
    }

    @Override // com.larus.asr.session.p
    public final boolean Cb() {
        return this.Q1;
    }

    @Override // com.larus.asr.session.p
    public final String Qa() {
        return this.S1;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final boolean Sx() {
        return this.f287090r;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final int U2() {
        return this.f287082m;
    }

    @Override // com.larus.asr.session.p
    public final String ua() {
        return this.G1;
    }

    public static final boolean B3(ChatBottomSpeakerComponent r100) {
        com.larus.bmhome.instruction.g r101 = r100.vc();
        String r102 = null;
        if (r101 == null) goto L11;
        com.larus.bmhome.actionbar.model.z0 r103 = r101.yF();
        if (r103 == null) goto L11;
        com.larus.bmhome.actionbar.model.r r104 = r103.f295621q;
        if (r104 == null) goto L11;
        com.larus.bmhome.actionbar.model.j1 r105 = r104.f295412e;
        if (r105 == null) goto L11;
        String r106 = r105.f295240l;
    L12:
        com.larus.bmhome.chat.component.cvs.y r107 = r100.u0();
        if (r107 == null) goto L15;
        BotModel r108 = r107.j0();
    L16:
        if (r108 == null) goto L20;
        SpeakerVoice r109 = r108.getVoiceType();
        if (r109 == null) goto L20;
        r102 = r109.getStyleId();
    L20:
        Lazy r110 = u4.f288096a;
        boolean r111 = u4.a(r100.vc(), r102);
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "canUseSimultaneousTranslator: canUse=" + r111 + " v3SpeakerIdList=" + r106 + " currentSpeakerId=" + r102);
        return r111;
    L15:
        r108 = null;
    L11:
        r106 = null;
        goto L12
    }

    public static final va8.o C3(ChatBottomSpeakerComponent r100) {
        return (va8.o) r100.V.getValue();
    }

    public static final /* synthetic */ ICoreInputAbility D3(ChatBottomSpeakerComponent r100) {
        return r100.Z3();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v39, types: [com.larus.asr.d1] */
    public static Unit h3(final ChatBottomSpeakerComponent r110) {
        boolean r100 = r110.h4();
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("[HF] enterHandsfree called: exp=");
        r102.append(r100);
        r102.append(" currentMode=");
        r102.append(r110.L1);
        r102.append(" runningTaskId=");
        String r103 = r110.G1;
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102.append(StringsKt.take(r103, 8));
        r101.i("ChatBottomSpeakerComponent", r102.toString());
        if (r100 == true) goto L8;
        r101.w("ChatBottomSpeakerComponent", "[HF] enterHandsfree skipped: experiment off");
    L151:
        return Unit.INSTANCE;
    L8:
        AsrInputMode r104 = r110.L1;
        AsrInputMode r105 = AsrInputMode.HANDSFREE;
        if (r104 != r105) goto L11;
        r101.i("ChatBottomSpeakerComponent", "[HF] enterHandsfree skipped: already HANDSFREE");
        goto L151
    L11:
        r101.i("ChatBottomSpeakerComponent", "[HF] enterHandsfree: LONG_PRESS -> HANDSFREE");
        r110.L1 = r105;
        r110.M1 = false;
        r110.P1 = false;
        r110.Q1 = false;
        if (r110.V1 == true) goto L14;
    L16:
        long r106 = SystemClock.elapsedRealtime();
    L17:
        r110.f287075b2 = r106;
        if (r110.V1 == true) goto L20;
        r110.S1 = "voice_lock";
    L20:
        IAsrDirectFillAbility r107 = (IAsrDirectFillAbility) r110.W.getValue();
        if (r107 == null) goto L23;
        r107.R30();
    L23:
        ry8.a r108 = (ry8.a) r110.R.getValue();
        if (r108 == null) goto L28;
        TouchInterceptingView r109 = r108.BC();
        if (r109 == null) goto L28;
        r109.setVisibility(8);
    L28:
        com.larus.asr.session.o r111 = r110.f287091s;
        boolean r112 = true;
        if ((r111 instanceof SendMessageAsrSession) == false) goto L32;
        ((SendMessageAsrSession) r111).i();
    L44:
        r101.i("ChatBottomSpeakerComponent", "[HF] onHandsfreeActivated: begin");
        com.larus.asr.handsfree.a.f287297a.getClass();
        if (com.larus.asr.handsfree.a.f287298b == true) goto L156;
        if (com.larus.platform.service.z2.f365865a.voiceInputHandsfreeConfig().getForegroundServiceEnabled() == true) goto L50;
        r101.i("HandsfreeForegroundServiceManager", "[HF] foreground service disabled by settings");
        goto L156
    L50:
        AppHost.Companion r113 = AppHost.f326268a;
        Application r114 = r113.getApplication();
        int r115 = HandsfreeForegroundService.f287295b;
        Intrinsics.checkNotNullParameter(r114, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intent r116 = new Intent(r114, HandsfreeForegroundService.class);
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L59
        if (Build.VERSION.SDK_INT >= 26) goto L54;
    L56:
        Object r118 = r114.startService(r116);     // Catch: Throwable -> L59
    L57:
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L59
    L62:
        if (Result.m9456isSuccessimpl(r119) == false) goto L64;
        com.larus.asr.handsfree.a.f287298b = true;
        FLogger.f375446a.i("HandsfreeForegroundServiceManager", "[HF] foreground service start requested");
    L64:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);
        if (r120 == null) goto L156;
        FLogger.f375446a.e("HandsfreeForegroundServiceManager", "[HF] foreground service start failed, " + r120.getMessage());
        if (Build.VERSION.SDK_INT < 26) goto L156;
        ContextCompat.startForegroundService(r114, r116);     // Catch: Throwable -> L70
        Object r121 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L70
    L73:
        if (Result.m9456isSuccessimpl(r121) == false) goto L75;
        Unit r122 = (Unit) r121;
        com.larus.asr.handsfree.a.f287298b = true;
        FLogger.f375446a.i("HandsfreeForegroundServiceManager", "[HF] foreground service fallback startForegroundService requested");
    L75:
        Throwable r123 = Result.m9452exceptionOrNullimpl(r121);
        if (r123 == null) goto L156;
        FLogger.f375446a.e("HandsfreeForegroundServiceManager", "[HF] foreground service fallback start failed, " + r123.getMessage());
    L70:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L73
    L54:
        if (r113.a().isAppBackground() == false) goto L56;
        ContextCompat.startForegroundService(r114, r116);     // Catch: Throwable -> L59
        r118 = Unit.INSTANCE;     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L156:
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L89
        ICoreInputAbility r127 = r110.Z3();     // Catch: Throwable -> L89
        if (r127 == null) goto L86;
        long r128 = de8.d.a(r110.f1());     // Catch: Throwable -> L89
        va8.o r129 = (va8.o) r110.V.getValue();     // Catch: Throwable -> L89
        if (r129 == null) goto L84;
        Boolean r130 = Boolean.valueOf(r129.w());     // Catch: Throwable -> L89
    L85:
        r127.Wy("audio_handsfree", r128, r130);     // Catch: Throwable -> L89
        Unit r131 = Unit.INSTANCE;     // Catch: Throwable -> L89
    L87:
        Result.m9449constructorimpl(r131);     // Catch: Throwable -> L89
    L91:
        va8.o r132 = (va8.o) r110.V.getValue();
        if (r132 != null) goto L94;
    L96:
        boolean r133 = false;
    L97:
        if (r133 == false) goto L101;
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "[HF] onHandsfreeActivated: hideIme");
        ICoreInputAbility r134 = r110.Z3();
        if (r134 == null) goto L101;
        r134.qp(false);
    L101:
        ICoreInputAbility r135 = r110.Z3();
        if (r135 == null) goto L104;
        r135.C1(false, false, "handsfree");
    L104:
        com.larus.bmhome.chat.component.fastsend.e0 r136 = (com.larus.bmhome.chat.component.fastsend.e0) r110.X.getValue();
        if (r136 != null) goto L107;
    L109:
        boolean r137 = false;
    L110:
        if (r137 == false) goto L114;
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "[HF] onHandsfreeActivated: hide bottom album (fastSendImage)");
        com.larus.bmhome.chat.component.fastsend.e0 r138 = (com.larus.bmhome.chat.component.fastsend.e0) r110.X.getValue();
        if (r138 == null) goto L114;
        r138.Wi("handsfree");
    L114:
        Intrinsics.checkNotNullParameter(r110, "<this>");
        View r139 = com.larus.ui.arch.component.internal.attach.a.b(r110, r110).getView();
        if ((r139 instanceof ViewGroup) == false) goto L117;
        ViewGroup r140 = (ViewGroup) r139;
    L118:
        if (r140 != null) goto L120;
    L130:
        FLogger r141 = FLogger.f375446a;
        StringBuilder r142 = new StringBuilder("[HF] onHandsfreeActivated: overlay skipped, root=");
        if (r140 == null) goto L133;
        boolean r143 = true;
    L134:
        r142.append(r143);
        r142.append(" existing=");
        if (r110.f287088p2 != null) goto L138;
        r112 = false;
    L138:
        r142.append(r112);
        r141.w("ChatBottomSpeakerComponent", r142.toString());
    L139:
        r110.E2.remove();
        r110.E2.setEnabled(false);
        FLogger r144 = FLogger.f375446a;
        r144.i("ChatBottomSpeakerComponent", "[HF] onHandsfreeActivated: backCallback disabled, back passes through");
        r144.i("ChatBottomSpeakerComponent", "[HF] onHandsfreeActivated: sidebar remains enabled");
        ?? r145 = new d1(r110);
        x5.a().b(r145);
        x5.a().c(r145);
        t1 r146 = r110.f287096v2;
        if (r146 == null) goto L142;
        r146.cancel();
    L142:
        r110.f287096v2 = null;
        t19.s.a r147 = r110.f287100x2;
        if (r147 == null) goto L145;
        com.larus.utils.t0.e(new t19.r(r147));
    L145:
        r110.f287100x2 = null;
        long r148 = com.larus.platform.service.z2.f365865a.voiceInputHandsfreeConfig().getMaxAudioDurationMs();
        if (r148 > 0) goto L148;
        r144.i("ChatBottomSpeakerComponent", "[HF] auto-send warning timer skipped: maxAudioDurationMs=" + r148);
    L149:
        r144.i("ChatBottomSpeakerComponent", "[HF] onHandsfreeActivated: done");
        goto L151
    L148:
        t1 r149 = new t1(r148, r110);
        r149.start();
        r110.f287096v2 = r149;
        r144.i("ChatBottomSpeakerComponent", "[HF] auto-send warning timer started: maxAudioDurationMs=" + r148);
        goto L149
    L133:
        r143 = false;
        goto L134
    L120:
        if (r110.f287088p2 != null) goto L130;
        d58.c r150 = new d58.c(r140.getContext());
        r150.setDisableGesture(com.larus.platform.service.z2.f365865a.voiceInputHandsfreeConfig().getHandsfreeLayerDisableGesture());
        r150.setOnBlockedGesture(new q0(r110));
        r150.setBottomBlockHeightProvider(new s0(r110));
        List r151 = CollectionsKt.listOfNotNull(r110.a4());
        Intrinsics.checkNotNullParameter(r140, "parent");
        Intrinsics.checkNotNullParameter(r151, "handsfreeUIViews");
        if (r150.getParent() == null) goto L124;
        FLogger.f375446a.w("HandsfreeBlockOverlay", "attach skipped: overlay already attached");
    L129:
        r110.f287088p2 = r150;
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "[HF] onHandsfreeActivated: overlay attached");
        goto L139
    L124:
        r140.addView(r150);
        Iterator r152 = r151.iterator();
    L126:
        if (r152.hasNext() == false) goto L128;
        ((View) r152.next()).bringToFront();
        goto L126
    L128:
        FLogger.f375446a.i("HandsfreeBlockOverlay", "attached to parent=" + r140.getClass().getSimpleName() + ", lifted " + r151.size() + " handsfree UI views");
        goto L129
    L117:
        r140 = null;
        goto L118
    L107:
        if (r136.bx() != true) goto L109;
        r137 = true;
        goto L110
    L94:
        if (r132.w() != true) goto L96;
        r133 = true;
        goto L97
    L84:
        r130 = null;
        goto L85
    L86:
        r131 = null;
    L89:
        th = move-exception;
        Result.Companion r153 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L91
    L32:
        if ((r111 instanceof SendMessageAsrSessionV2) == false) goto L44;
        SendMessageAsrSessionV2 r154 = (SendMessageAsrSessionV2) r111;
        r154.f287555o.removeCallbacks(r154.f287556p);
        if (r154.f287439a.B5() != r105) goto L36;
        boolean r155 = true;
    L37:
        d58.a r156 = r154.f287550j;
        if (r155 == false) goto L40;
        long r157 = r156.f467064a;
    L42:
        if (r157 <= 0) goto L44;
        r154.f287555o.postDelayed(r154.f287556p, r157);
        goto L44
    L40:
        r157 = r156.f467065b;
        goto L42
    L36:
        r155 = false;
        goto L37
    L14:
        if (r110.f287077g2 <= 0) goto L16;
        r106 = r110.f287077g2;
        goto L17
    }

    public static Unit m3(ChatBottomSpeakerComponent r100) {
        r100.getClass();
        VoiceCallServiceDelegate r101 = VoiceCallServiceDelegate.f377087a;
        com.larus.bmhome.chat.component.cvs.y r102 = r100.u0();
        BotModel r103 = null;
        if (r102 == null) goto L5;
        wc9.e r104 = r102.h();
    L7:
        if (r101.o("voice_call", "asr_slide", com.larus.bmhome.utils.i.f(r104)) == false) goto L9;
        FLogger.f375446a.w("ChatBottomSpeakerComponent", "openContinuousTalk, downgrade click asr slide");
        return Unit.INSTANCE;
    L9:
        com.larus.bmhome.chat.component.cvs.y r105 = r100.u0();
        String r106 = "";
        if (r105 == null) goto L13;
        String r107 = r105.Y1();
        if (r107 == null) goto L13;
    L14:
        String r108 = r100.f287093u;
        if (r108 == null) goto L18;
        r106 = r108;
    L18:
        com.larus.bmhome.chat.component.cvs.y r109 = r100.u0();
        if (r109 == null) goto L22;
        r103 = r109.j0();
    L22:
        if (r101.u(r107, r106, r103) == false) goto L24;
        StateFlowImpl r110 = ce8.c.f23471a;
        t1a.b r111 = s1a.d.a(r100);
        Intrinsics.checkNotNullParameter(r111, "<this>");
        String r112 = UUID.randomUUID().toString();
        ce8.c.f23472b = r112;
        ce8.c.f23473c = "long_press_asr_slide";
        ce8.c.b("long_press_asr_slide", r112, r111);
        String r113 = ce8.c.f23472b;
    L25:
        xa8.e r114 = new xa8.e("long_press_asr_slide", r113, null, null, true, 12);
        xa8.b r115 = (xa8.b) s1a.d.a(r100).getAbility(xa8.b.class);
        if (r115 == null) goto L29;
        r115.fk(r114);
    L29:
        return Unit.INSTANCE;
    L24:
        r113 = UUID.randomUUID().toString();
        Intrinsics.checkNotNull(r113);
    L13:
        r107 = "";
        goto L14
    L5:
        r104 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void A4(com.larus.bmhome.chat.component.bottom.core.speaker.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f287074b1.add(r100);
        com.larus.asr.session.o r101 = this.f287091s;
        if (r101 == null) goto L6;
        r101.A4(r100);
        return;
    }

    @Override // com.larus.audio.asr.m0
    public final Map<String, Object> B(String r110) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        if (h4() == true) goto L5;
        return null;
    L5:
        c r100 = this.f287079h2;
        if (r100 != null) goto L8;
        r100 = W3();
    L8:
        int r101 = d58.b.f467067a;
        boolean r102 = r100.f287107a;
        boolean r103 = r100.f287108b;
        String r104 = r100.f287109c;
        long r105 = r100.f287110d;
        long r106 = r100.f287111e;
        if (this.Q1 == false) goto L11;
    L14:
        boolean r107 = true;
    L15:
        Intrinsics.checkNotNullParameter(r110, "eventName");
        String r111 = "0";
        if (Intrinsics.areEqual(r110, "flow_im_asr_start") == false) goto L26;
        Map r112 = MapsKt.createMapBuilder();
        if (r102 == true) goto L20;
        if (r103 == true) goto L20;
    L21:
        r112.put("is_speak_handsfree", r111);
        if (r104 == null) goto L42;
        r112.put("handsfree_enter_method", r104);
    L42:
        return MapsKt.build(r112);
    L20:
        r111 = "1";
        goto L21
    L26:
        if (Intrinsics.areEqual(r110, "flow_im_asr_end") == false) goto L43;
        Map r113 = MapsKt.createMapBuilder();
        if (r102 == true) goto L30;
        if (r103 == true) goto L30;
    L31:
        r113.put("is_speak_handsfree", r111);
        if (r104 == null) goto L34;
        r113.put("handsfree_enter_method", r104);
    L34:
        r113.put("speak_handsfree_duration", String.valueOf(r105));
        r113.put("speak_duration", String.valueOf(r106));
        if (r102 == true) goto L37;
        if (r103 == true) goto L37;
    L39:
        String r108 = "send_direct";
    L40:
        r113.put("end_status", r108);
        return MapsKt.build(r113);
    L37:
        if (r107 == false) goto L39;
        r108 = "fill_back";
    L30:
        r111 = "1";
        goto L31
    L43:
        return null;
    L11:
        if (Intrinsics.areEqual(com.larus.platform.service.z2.f365865a.voiceInputHandsfreeConfig().getHandsfreeAsrEndBehavior(), HandsfreeExperimentConfig.ASR_END_BACKFILL) == true) goto L14;
        r107 = false;
        goto L15
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public void B9(com.larus.bmhome.chat.component.bottom.core.speaker.h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.V0.remove(r100);
        com.larus.asr.session.o r101 = this.f287091s;
        if (r101 == null) goto L6;
        r101.B9(r100);
        return;
    }

    @Override // com.larus.asr.session.p
    public final void Bb(final Function2<? super Boolean, ? super Boolean, Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "callback");
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.RECORD_AUDIO") == 0) goto L5;
        List r100 = CollectionsKt.mutableListOf(new String[]{"android.permission.RECORD_AUDIO"});
        com.larus.platform.service.i2 r101 = com.larus.platform.service.i2.f365748b;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r102 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        g r103 = new g(r110, this);
        JSONObject r104 = new JSONObject();
        r104.put("enter_method", "asr");
        Unit r111 = Unit.INSTANCE;
        com.larus.platform.api.g1.a.a(r102, r100, r103, null, r104, 8);
        return;
    L5:
        List r105 = CollectionsKt.mutableListOf(new String[]{"android.permission.RECORD_AUDIO"});
        com.larus.platform.service.i2 r106 = com.larus.platform.service.i2.f365748b;
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.platform.service.i2.q(com.larus.ui.arch.component.internal.attach.a.b(this, this), r105, new z0(r110));
    }

    @Override // com.larus.asr.session.p
    public final void Gb(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        com.larus.bmhome.chat.component.bottom.reference.a r101 = g5();
        if (r101 == null) goto L6;
        r101.sZ();
    L6:
        if (ObricFeatureServiceDelegate.f387839b.a() == false) goto L18;
        b68.b.f17861a.getClass();
        Intrinsics.checkNotNullParameter("/record/asr/pcm_o/", "basePath");
        if (TextUtils.isEmpty("/record/asr/pcm_o/") == false) goto L10;
        final String r102 = null;
    L17:
        ThreadMethodProxy.start(new PthreadThreadV2(new e1(r102, this), "ChatBottomSpeakerComponent"));
        goto L18
    L10:
        StringBuilder r103 = new StringBuilder();
        m58.b r104 = m58.h.f512140k;
        if (r104 == null) goto L15;
        Application r105 = r104.getApplication();
        if (r105 == null) goto L15;
        File r106 = r105.getFilesDir();
    L16:
        r103.append(r106);
        r103.append("/record/asr/pcm_o/");
        r102 = r103.toString();
    L15:
        r106 = null;
    L18:
        u7 r107 = (u7) this.T.getValue();
        boolean r108 = false;
        if (r107 == null) goto L21;
        r107.O5(false);
    L21:
        com.larus.bmhome.instruction.g r109 = vc();
        if (r109 == null) goto L28;
        ICoreInputAbility r110 = Z3();
        if (r110 == null) goto L28;
        com.larus.bmhome.chat.model.b0 r111 = r110.tO();
        if (r111 == null) goto L28;
        r109.FC(r111);
    L28:
        com.larus.bmhome.instruction.g r112 = vc();
        if (r112 == null) goto L31;
        r112.FP();
    L31:
        com.larus.bmhome.instruction.g r113 = vc();
        if (r113 == null) goto L34;
        r113.cO();
    L34:
        com.larus.bmhome.chat.component.bottom.reference.a r114 = g5();
        if (r114 != null) goto L37;
    L39:
        if (r108 == false) goto L46;
        com.larus.bmhome.chat.component.bottom.reference.a r115 = g5();
        if (r115 == null) goto L43;
        r115.NR();
    L43:
        IFlowSdkDepend r116 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r116 == null) goto L46;
        r116.N();
        com.larus.home.impl.sdk.n1.f346205a.h();
    L46:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ChatBottomSpeakerComponent$delayHideImeAfterAudioSend$1(this, null), 3, null);
        Function0<Unit> r117 = this.L;
        if (r117 == null) goto L50;
        r117.invoke();
        return;
    L50:
        return;
    L37:
        if (r114.GD() != true) goto L39;
        r108 = true;
        goto L39
    }

    public void H3(ChatSpeaker r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (y48.h.a() == false) goto L9;
        y48.v r101 = k4();
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("[SpeakerBuilder] applySpeakerConfig component=");
        r103.append(getClass().getSimpleName());
        r103.append(" target=");
        r103.append(r100.getClass().getSimpleName());
        r103.append(':');
        r103.append(r100.hashCode());
        r103.append(" route=builder source=");
        if (this.f287098x == null) goto L7;
        String r104 = "spec";
    L8:
        r103.append(r104);
        r103.append(" scene=");
        r103.append(r101.f566139a);
        r102.i("ChatBottomSpeakerComponent", r103.toString());
        r100.setSpec(r101);
        return;
    L7:
        r104 = "legacy_config";
        goto L8
    L9:
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("[SpeakerBuilder] applySpeakerConfig component=");
        r106.append(getClass().getSimpleName());
        r106.append(" target=");
        r106.append(r100.getClass().getSimpleName());
        r106.append(':');
        r106.append(r100.hashCode());
        r106.append(" route=legacy configPresent=");
        if (this.f287097w == null) goto L12;
        boolean r107 = true;
    L13:
        r106.append(r107);
        r105.i("ChatBottomSpeakerComponent", r106.toString());
        r100.setConfig(this.f287097w);
        return;
    L12:
        r107 = false;
        goto L13
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void K8(com.larus.bmhome.chat.component.bottom.core.speaker.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f287074b1.remove(r100);
        com.larus.asr.session.o r101 = this.f287091s;
        if (r101 == null) goto L6;
        r101.K8(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void KH(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.L = r100;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void KR(ICoreInputAbility.c r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        if (((ArrayList) this.K).contains(r100) == true) goto L6;
        ((ArrayList) this.K).add(r100);
        return;
    }

    @Override // com.larus.asr.session.p
    public boolean Kb(VoiceInputType r100) {
        Intrinsics.checkNotNullParameter(r100, "voiceInputType");
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).isAdded() == true) goto L5;
    L7:
        return false;
    L5:
        if (x5.d().d() == false) goto L7;
        return true;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void Ln(com.larus.feishu.office.im.impl.base.v r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f287095v1 = r100;
    }

    @Override // com.larus.asr.session.p
    public final void O9(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        this.I = r100;
    }

    @Override // com.larus.asr.session.p
    public final void Q9(Map<String, String> r100) {
        ICoreInputAbility r101 = Z3();
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        String r103 = "show_speak";
    L11:
        if (r100 == null) goto L13;
        String r104 = r100.put("sec_scene", r103);
    L13:
        l4(r100);
        return;
    L10:
        r103 = "show_keyboard";
        goto L11
    L5:
        if (r101.Rp() != 2) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void Qs(ICoreInputAbility.c r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        ((ArrayList) this.K).remove(r100);
    }

    @Override // com.larus.asr.session.p
    public final void R9(String r100) {
        IAsrDirectFillAbility r101 = (IAsrDirectFillAbility) this.W.getValue();
        if (r101 == null) goto L6;
        r101.YZ(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void Sh(Function0<Unit> r100) {
        this.f287101y = r100;
    }

    @Override // com.larus.asr.session.p
    public final boolean Ua(String r100) {
        Intrinsics.checkNotNullParameter(r100, "asrResult");
        com.larus.bmhome.instruction.g r101 = vc();
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L9:
        return !r102;
    L5:
        if (r101.x(r100) != true) goto L7;
        r102 = true;
        goto L9
    }

    @Override // com.larus.asr.session.p
    public final void V9(String r100) {
        Intrinsics.checkNotNullParameter(r100, "hintText");
        ICoreInputAbility r101 = Z3();
        if (r101 == null) goto L6;
        r101.g2(1, true);
        r101.Yk(r100);
        return;
    }

    @Override // com.larus.asr.session.p
    public void W9(VoiceInputType r100) {
        Intrinsics.checkNotNullParameter(r100, "voiceInputType");
        ChatSpeaker r101 = a4();
        if (r101 == null) goto L6;
        r101.V6(r100);
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final void X2(int r100) {
        this.f287082m = r100;
    }

    public final boolean X3(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        ChatBottomSpeakerComponent$alterToVoiceSendLru$1 r102 = this.C;
        monitor-enter(r102);
        Boolean r103 = (Boolean) this.C.get(r100);     // Catch: Throwable -> L19
        if (r103 == null) goto L16;
        boolean r104 = r103.booleanValue();     // Catch: Throwable -> L19
    L17:
        monitor-exit(r102);
        return r104;
    L16:
        r104 = this.B;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L10:
        return this.B;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void ZS(com.larus.feishu.office.im.impl.base.o r100) {
        this.f287104z = r100;
        com.larus.asr.session.o r101 = this.f287091s;
        if (r101 == null) goto L6;
        r101.na(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void b3(Function1<? super String, com.larus.bmhome.chat.component.bottom.core.speaker.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "withExtHandle");
        this.f287073J = r100;
        com.larus.asr.session.o r101 = this.f287091s;
        if (r101 == null) goto L6;
        r101.b3(r100);
        return;
    }

    public final boolean c4(String r110) {
        Intrinsics.checkNotNullParameter(r110, "asrResult");
        ICoreInputAbility r100 = Z3();
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.FF() == MessageModifyMode.MODIFY_TO_REPLACE_TXT) goto L8;
        return false;
    L8:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatBottomSpeakerComponent$handleAsrResultInModify$1(r100, r110, this, null), 3, null);
        return true;
    }

    @Override // com.larus.asr.session.p
    public final void ca(String r100) {
        ChatSpeaker r101 = a4();
        if (r101 == null) goto L6;
        r101.setTag(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void cl(int r100) {
        ChatSpeaker r101 = a4();
        if (r101 == null) goto L6;
        r101.g8(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public void e8(com.larus.bmhome.chat.component.bottom.core.speaker.h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.V0.add(r100);
        com.larus.asr.session.o r101 = this.f287091s;
        if (r101 == null) goto L6;
        r101.e8(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void fm(com.larus.bmhome.clarification.l1 r100) {
        this.f287099x1 = r100;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void fp(x48.b r100) {
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "[SpeakerBuilder] setConfig component=" + getClass().getSimpleName() + " configPresent=true speakerInitialized=" + this.f287084o);
        this.f287097w = r100;
        this.f287098x = null;
        ChatSpeaker r101 = a4();
        if (r101 == null) goto L6;
        H3(r101);
        return;
    }

    @Override // com.larus.asr.session.p
    public final void ha(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "[HF] mark force backfill session: reason=".concat(r100));
        this.Q1 = true;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void kD(y48.v r100) {
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "[SpeakerBuilder] setSpec component=" + getClass().getSimpleName() + " scene=" + r100.f566139a + " speakerInitialized=" + this.f287084o + " builderEnabled=" + y48.h.a());
        this.f287098x = r100;
        if (y48.h.a() == false) goto L8;
        ChatSpeaker r101 = a4();
        if (r101 == null) goto L9;
        H3(r101);
        return;
    L9:
        return;
    }

    @Override // com.larus.asr.session.p
    public final boolean m2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "asrResult");
        ICoreInputAbility r101 = Z3();
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.m2(r100) != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.asr.session.p
    public void onAsrStart(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        ChatSpeaker r101 = a4();
        if (r101 == null) goto L6;
        r101.E8();
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "[onViewCreated] " + r100 + "  viewmodel_hash_code=" + ((BottomViewModelSpeakerViewModel) this.D.getValue()).hashCode());
        if ((r100 instanceof ChatSpeaker) == false) goto L6;
        ChatSpeaker r101 = (ChatSpeaker) r100;
        this.f287089q = r101;
        v4(r101);
        H3(r101);
    L9:
        this.E = new p1(this);
        com.larus.bmhome.chat.component.cvs.y r102 = u0();
        if (r102 == null) goto L12;
        r102.rh(new p0(), this.E);
    L12:
        this.F = new o1(this);
        com.larus.bmhome.chat.component.cvs.y r103 = u0();
        if (r103 == null) goto L16;
        r103.ll(new r0(), this.F);
    L16:
        if (com.larus.platform.service.z2.f365865a.S1().getEnableNewStyle() == false) goto L24;
        if (r101 != null) goto L19;
        return;
    L19:
        if (f1().m() == null) goto L21;
        boolean r104 = true;
    L22:
        r101.r7(r104, f1().m());
        return;
    L21:
        r104 = false;
        goto L22
    L24:
        return;
    L6:
        if ((r100 instanceof ViewStub) == false) goto L8;
        this.f287085p = (ViewStub) r100;
        r101 = a4();
        goto L9
    L8:
        r101 = a4();
        goto L9
    }

    public final void q4(String r100) {
        if (this.L1 == AsrInputMode.HANDSFREE) goto L7;
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "[HF] submitHandsfreeOnce skipped (from=" + r100 + "): not in handsfree");
        return;
    L7:
        if (this.M1 == false) goto L10;
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "[HF] submitHandsfreeOnce skipped (from=" + r100 + "): auto-submit already in flight");
        return;
    L10:
        this.M1 = true;
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "[HF] submitHandsfreeOnce (from=" + r100 + ") -> hideSpeakerAndSubmit");
        ChatSpeaker r101 = a4();
        if (r101 == null) goto L14;
        ChatSpeaker.W6(r101);
        return;
    }

    @Override // com.larus.asr.session.p
    public final void sb(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        RepoDispatcherDelegate.f307737b.e().x1().a().i6("ban_speaker_visible_" + r100, false);
    }

    @Override // com.larus.asr.session.p
    public final void setKeepScreenOn(final boolean r100) {
        if (r100 == false) goto L5;
        fa9.e.f476067a.a("voice_input", this.f287083n);
    L6:
        com.larus.utils.t0.e(new j1(this, r100));
        return;
    L5:
        fa9.e.f476067a.f("voice_input", this.f287083n);
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void tT(com.larus.feishu.office.im.impl.base.p r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f287087p1 = r100;
    }

    @Override // com.larus.asr.session.p
    public String ub(String r100) {
        Intrinsics.checkNotNullParameter(r100, "asrResult");
        com.larus.bmhome.instruction.g r101 = vc();
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.z0() != true) goto L7;
    L8:
        if (r102 == false) goto L15;
        com.larus.bmhome.instruction.g r103 = vc();
        if (r103 == null) goto L15;
        String r104 = r103.kb(r100);
        if (r104 == null) goto L15;
        r100 = r104;
    L15:
        Iterator r105 = ((ArrayList) this.K).iterator();
    L17:
        if (r105.hasNext() == false) goto L19;
        r100 = ((ICoreInputAbility.c) r105.next()).a(r100);
        goto L17
    L19:
        return r100;
    L7:
        r102 = false;
        goto L8
    }

    public final void v4(ChatSpeaker r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        boolean r101 = h4();
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "[HF] wireHandsfreeCallback: speaker=" + r100.hashCode() + " exp=" + r101);
        r100.setHandsfreeSceneEnabled(r101);
        View r102 = null;
        if (r101 == false) goto L15;
        r100.setHandsfreeLayerDisableGesture(com.larus.platform.service.z2.f365865a.voiceInputHandsfreeConfig().getHandsfreeLayerDisableGesture());
        r100.setOnHandsfreeBlockedGesture(new com.larus.asr.k(this));
        ry8.a r103 = (ry8.a) this.R.getValue();
        if (r103 == null) goto L14;
        View r104 = r103.getRootView();
        if (r104 == null) goto L14;
        View r105 = r104.findViewById(R.id.message_list_parent);
        if (r105 == null) goto L14;
        if ((r105 instanceof ViewStub) == true) goto L14;
        r102 = r105;
    L14:
        r100.setHandsfreeTouchPassthroughTarget(r102);
        r100.setOnEnterHandsfree(new v(this));
        return;
    L15:
        r100.setHandsfreeLayerDisableGesture(false);
        r100.setOnHandsfreeBlockedGesture(null);
        r100.setHandsfreeTouchPassthroughTarget(null);
        r100.setOnEnterHandsfree(new g0());
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void xe(int r100) {
        ChatSpeaker r101 = a4();
        if (r101 == null) goto L6;
        r101.setAudioVisualizerBottomMargin(r100);
        return;
    }

    public static final void E3(ChatBottomSpeakerComponent r100, long r101) {
        Context r102 = r100.getContext();
        if (r102 != null) goto L5;
        r102 = AppHost.f326268a.getApplication();
    L5:
        boolean r103 = true;
        final String r104 = r102.getString(R.string.larus_voiceInput_toast_autoSent, new Object[]{String.valueOf(r101)});
        final t19.s.a r105 = r100.f287100x2;
        t19.s.a r106 = null;
        if (r105 == null) goto L15;
        u19.f r107 = t19.s.f544208b.get();
        u19.f r108 = r105.f544209a;
        if (r107 == r108) goto L10;
    L12:
        r103 = false;
    L13:
        if (r103 == false) goto L15;
    L17:
        if (r105 != null) goto L29;
        t19.s.f544207a.getClass();
        Intrinsics.checkNotNullParameter(r104, "text");
        final Context r109 = t19.s.f(r102);
        if (r109 == null) goto L28;
        int r110 = v19.c.b(R.attr.larus_toast_warning_icon, null, R.drawable.larus_toast_warning_icon);
        Intrinsics.checkNotNullParameter(r104, "text");
        Object r111 = ObricToastHelperDelegate.f387851b.createToastHolder(r109);
        if ((r111 instanceof u19.f) == false) goto L24;
        final u19.f r112 = (u19.f) r111;
    L25:
        if (r112 != null) goto L27;
        r112 = new u19.e();
    L27:
        r112.setAutoDisappear(false);
        r112.setDuration(0);
        r112.icon(r110);
        r112.text(r104);
        r112.setYOffsetPx(null);
        r106 = new t19.s.a(r112);
        com.larus.utils.t0.e(new t19.f(r112, r109));
        goto L28
    L24:
        r112 = null;
    L28:
        r100.f287100x2 = r106;
        return;
    L29:
        Intrinsics.checkNotNullParameter(r104, "text");
        com.larus.utils.t0.e(new t19.q(r105, r104));
        return;
    L10:
        if (r108.isShown() == false) goto L12;
    L15:
        r105 = null;
        goto L17
    }

    public static final void G3(ChatBottomSpeakerComponent r100, wc9.e r101) {
        r100.getClass();
        boolean r102 = com.larus.bmhome.utils.i.f(r101);
        boolean r103 = IAIChatService.f365899a.q8();
        if (r100.f1().C() == true) goto L12;
        if (r103 == false) goto L12;
        if (r102 == true) goto L7;
    L8:
        if (r102 == true) goto L12;
        if (com.larus.platform.service.z2.f365865a.enableSubscriberMultiBotNewSkin() == false) goto L12;
    L11:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L28;
        ChatSpeaker r105 = r100.a4();
        if (r105 == null) goto L29;
        r105.f288134x = true;
        LarusWidgetSpeakerBinding r106 = r105.getBinding();
        if (r106 == null) goto L30;
        FrameLayout r107 = r106.f287180b;
        if (r107 == null) goto L31;
        LarusWidgetSpeakerBinding r108 = r105.getBinding();
        if (r108 == null) goto L25;
        FrameLayout r109 = r108.f287180b;
        if (r109 == null) goto L25;
        Context r110 = r109.getContext();
    L26:
        r107.setBackgroundResource(v19.c.b(R.attr.larus_bg_audio_visualizer_subscribed, r110, R.drawable.larus_bg_audio_visualizer_subscribed));
        return;
    L25:
        r110 = null;
        goto L26
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L7:
        if (com.larus.platform.service.z2.f365865a.enableSubscriberMainBotNewSkin() == true) goto L11;
    L12:
        r104 = false;
        goto L13
    }

    @Override // com.larus.asr.session.p
    public final void J9(String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "asrResult");
        if (r111 == false) goto L10;
        ICoreInputAbility r100 = Z3();
        if (r100 == null) goto L7;
        ICoreInputAbility.b.d(r100, r110, false, false, null, null, false, 62);
    L7:
        ICoreInputAbility r112 = Z3();
        if (r112 == null) goto L14;
        r112.g2(3, true);
        return;
    L14:
        return;
    L10:
        ICoreInputAbility r113 = Z3();
        if (r113 == null) goto L16;
        r113.aR(r110);
        return;
    }

    @Override // com.larus.asr.session.p
    public final void Ja(final String r100, final Message r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        ChatSpeaker r102 = a4();
        if (r102 == null) goto L5;
        Function0<Unit> r103 = new h1(this, r100, r101);
        Intrinsics.checkNotNullParameter(r103, "callback");
        r102.f288115e = r103;
        Unit r104 = Unit.INSTANCE;
    L5:
        ChatSpeaker r105 = a4();
        if (r105 == null) goto L8;
        Function2<? super Boolean, ? super VoiceInputType, Unit> r106 = new f1(this, r101, r100);
        Intrinsics.checkNotNullParameter(r106, "callback");
        r105.f288116f = r106;
        Unit r107 = Unit.INSTANCE;
    L8:
        ChatSpeaker r108 = a4();
        if (r108 == null) goto L11;
        Function0<Unit> r109 = new g1(this);
        Intrinsics.checkNotNullParameter(r109, "callback");
        r108.f288117g = r109;
        Unit r110 = Unit.INSTANCE;
    L11:
        ChatSpeaker r111 = a4();
        if (r111 == null) goto L15;
        Function1<? super Boolean, Unit> r112 = new b1(this);
        Intrinsics.checkNotNullParameter(r112, "callback");
        r111.f288118h = r112;
        return;
    }

    @Override // com.larus.asr.session.p
    public void Ma(String r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "data");
        ChatSpeaker r102 = a4();
        if (r102 == null) goto L6;
        r102.d8(LifecycleOwnerKt.getLifecycleScope(this), r101);
        return;
    }

    public final void Q3(String r100, boolean r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        return;
    L10:
        ChatBottomSpeakerComponent$alterToVoiceSendLru$1 r103 = this.C;
        monitor-enter(r103);
        Boolean r104 = Boolean.valueOf(r101);     // Catch: Throwable -> L15
        this.C.put(r100, r104);     // Catch: Throwable -> L15
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r103);
        return;
    L15:
        th = move-exception;
        throw th;
    L4:
        if (r100.length() == 0) goto L7;
        r102 = false;
        goto L8
    }

    public static boolean z3(ChatBottomSpeakerComponent r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "asrResult");
        HandsfreeExperimentConfig r103 = com.larus.platform.service.z2.f365865a.voiceInputHandsfreeConfig();
        if (r100.ob() == true) goto L5;
    L9:
        boolean r104 = false;
    L10:
        if (r104 == false) goto L18;
        if ((!StringsKt.isBlank(r101)) == false) goto L16;
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "handsfree interceptor: backfill text to input");
        r100.J9(r101, true);
        IAsrDirectFillAbility r105 = (IAsrDirectFillAbility) r100.W.getValue();
        if (r105 == null) goto L19;
        r105.mR(r102);
        return true;
    L19:
        return true;
    L16:
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "handsfree interceptor: empty asrResult, skip fillInTextInput");
        return true;
    L18:
        return r100.H.invoke(r101).booleanValue();
    L5:
        if (Intrinsics.areEqual(r103.getHandsfreeAsrEndBehavior(), HandsfreeExperimentConfig.ASR_END_BACKFILL) == false) goto L7;
    L8:
        r104 = true;
        goto L10
    L7:
        if (r100.Q1 == false) goto L9;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final boolean dz(final HandsfreeDirectEntry r110, final String r111, final String r112) {
        Intrinsics.checkNotNullParameter(r110, "entry");
        Intrinsics.checkNotNullParameter(r111, "traceId");
        Intrinsics.checkNotNullParameter(r112, "enterFrom");
        if (h4() == true) goto L5;
        return false;
    L5:
        final HandsfreeExperimentConfig r100 = com.larus.platform.service.z2.f365865a.voiceInputHandsfreeConfig();
        int r101 = d.f287113b[r110.ordinal()];
        if (r101 == 1) goto L17;
        if (r101 != 2) goto L15;
        if (r100.getVoiceInputClickEnabled() == true) goto L12;
    L19:
        boolean r102 = false;
    L20:
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("[HF] tryEnterHandsfreeDirectly: entry=");
        r104.append(r110);
        r104.append(" exp=");
        r104.append(h4());
        r104.append(" mainbot=");
        com.larus.bmhome.chat.component.cvs.y r105 = u0();
        if (r105 == null) goto L23;
        wc9.e r106 = r105.h();
    L24:
        r104.append(com.larus.bmhome.utils.i.f(r106));
        r104.append(" micClickBehavior=");
        r104.append(r100.getMicClickBehavior());
        r104.append(" voiceInputClickEnabled=");
        r104.append(r100.getVoiceInputClickEnabled());
        r104.append(" longPressLockEnabled=");
        r104.append(r100.getLongPressLockEnabled());
        r104.append(" hit=");
        r104.append(r102);
        r103.i("ChatBottomSpeakerComponent", r104.toString());
        if (r102 == true) goto L27;
        return false;
    L27:
        final ChatSpeaker r107 = a4();
        if (r107 != null) goto L31;
        r103.e("ChatBottomSpeakerComponent", "[HF] tryEnterHandsfreeDirectly: speaker is null after lazy getter, abort");
        return false;
    L31:
        v4(r107);
        Bb(new c1(this, r107, r110, r111, r112, r100));
        return true;
    L23:
        r106 = null;
        goto L24
    L12:
        if (r100.getMicClickBehavior() != 0) goto L19;
    L18:
        r102 = true;
        goto L20
    L15:
        throw new NoWhenBranchMatchedException();
    L17:
        if (r100.getMicClickBehavior() != 1) goto L19;
        goto L18
    }

    @Override // com.larus.asr.session.p
    public final void ib(String r110, Map<String, String> r111, VoiceInputType r112) {
        Intrinsics.checkNotNullParameter(r110, "asrResult");
        Intrinsics.checkNotNullParameter(r111, "messageExt");
        Intrinsics.checkNotNullParameter(r112, "voiceInputType");
        com.larus.bmhome.instruction.g r100 = vc();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L24;
        com.larus.bmhome.instruction.g r103 = vc();
        if (r103 != null) goto L12;
    L14:
        if (r101 == false) goto L22;
        ICoreInputAbility r104 = Z3();
        if (r104 == null) goto L18;
        ICoreInputAbility.b.d(r104, r110, false, false, null, null, false, 62);
    L18:
        ICoreInputAbility r113 = Z3();
        if (r113 == null) goto L26;
        r113.g2(3, true);
        return;
    L26:
        return;
    L22:
        Y2(this, r112, r110, r111);
        return;
    L12:
        if (r103.i3() != true) goto L14;
        r101 = true;
        goto L14
    L24:
        Y2(this, r112, r110, r111);
        return;
    L5:
        if (r100.z0() != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.larus.asr.session.p
    public void sa(Message r100, String r101, VoiceInputType r102) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r102, "voiceInputType");
        u7 r103 = (u7) this.Q.getValue();
        if (r103 == null) goto L6;
        r103.JE();
    L6:
        if (Kb(r102) == false) goto L11;
        u7 r104 = (u7) this.Q.getValue();
        if (r104 == null) goto L12;
        r104.W70();
        return;
    L12:
        return;
    }

    public static Unit Y2(ChatBottomSpeakerComponent r100, VoiceInputType r101, String r102, Map r103) {
        ICoreInputAbility r104 = r100.Z3();
        if (r104 == null) goto L19;
        int r105 = d.f287112a[r101.ordinal()];
        if (r105 != 1) goto L7;
        String r106 = ObricActionBarTrackType.OBRIC_CLICK_SPEAK;
    L17:
        r104.SK(r102, true, null, r106, r103);
        goto L19
    L7:
        if (r105 != 2) goto L9;
        r106 = "dora_call";
        goto L17
    L9:
        if (r105 != 3) goto L11;
        r106 = "obric_thirdparty_wakeup_speak";
        goto L17
    L11:
        if (r105 == 4) goto L13;
        r106 = null;
        goto L17
    L13:
        r106 = "dora_radio";
    L19:
        return Unit.INSTANCE;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public final void la(Function1<? super com.larus.audio.b, Boolean> r100, Function1<? super com.larus.audio.a, Boolean> r101, Function2<? super String, ? super byte[], Unit> r102, Function1<? super String, Boolean> r103) {
        Intrinsics.checkNotNullParameter(r100, "successResultHandle");
        Intrinsics.checkNotNullParameter(r101, "failResultHandle");
        Intrinsics.checkNotNullParameter(r102, "audioDataHandle");
        Intrinsics.checkNotNullParameter(r103, "handle");
        this.H = r103;
        this.f287090r = true;
        this.N = r101;
        this.O = r102;
        this.M = r100;
        com.larus.asr.session.o r104 = this.f287091s;
        if (r104 == null) goto L6;
        r104.la(r100, r101, r102, r103);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l, com.larus.asr.session.p
    public void L8(boolean r100, boolean r101, String r102, VoiceInputType r103, String r110) {
        Intrinsics.checkNotNullParameter(r102, "reason");
        Intrinsics.checkNotNullParameter(r103, "voiceInputType");
        Intrinsics.checkNotNullParameter(r110, DBDefinition.TASK_ID);
        FLogger r104 = FLogger.f375446a;
        StringBuilder r111 = new StringBuilder("setSpeakerVisibility: ");
        ChatSpeaker r105 = a4();
        boolean r106 = true;
        int r107 = 0;
        if (r105 != null) goto L5;
        Boolean r108 = null;
    L10:
        r111.append(r108);
        r111.append(" --> ");
        r111.append(r100);
        r111.append(", reason: ");
        r111.append(r102);
        r104.i("ChatBottomSpeakerComponent", r111.toString());
        ChatSpeaker r109 = a4();
        if (r109 == null) goto L55;
        Intrinsics.checkNotNullParameter(this, "<this>");
        va8.g0 r112 = (va8.g0) s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).getAbility(va8.g0.class);
        if (r112 == null) goto L15;
        r112.PJ(r100);
    L15:
        Intrinsics.checkNotNullParameter(this, "<this>");
        ew8.c r113 = (ew8.c) s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).getAbility(ew8.c.class);
        if (r109.getVisibility() != 0) goto L18;
        boolean r114 = true;
    L19:
        if (r114 == r100) goto L26;
        if (r101 == false) goto L26;
        if (r100 == false) goto L24;
        com.larus.bmhome.utils.a4.f314971a.getClass();
        com.larus.bmhome.utils.a4.a(com.larus.bmhome.utils.a4.f314972b);
        goto L26
    L24:
        if (com.larus.platform.service.z2.f365865a.getVibrateConfig().f486827b == false) goto L26;
        com.larus.bmhome.utils.a4.f314971a.getClass();
        com.larus.bmhome.utils.a4.a(com.larus.bmhome.utils.a4.f314972b);
    L26:
        if (r100 == false) goto L30;
        if (r113 == null) goto L30;
        r113.wH();
    L30:
        if (r100 == false) goto L32;
        int r115 = 0;
    L33:
        r109.setVisibility(r115);
        if (r100 == false) goto L38;
        ry8.c r116 = (ry8.c) this.f287086p0.getValue();
        if (r116 == null) goto L41;
        r116.py();
    L41:
        ry8.a r117 = (ry8.a) this.R.getValue();
        if (r117 == null) goto L56;
        TouchInterceptingView r118 = r117.BC();
        if (r118 == null) goto L57;
        if (r100 == true) goto L47;
    L49:
        r106 = false;
    L50:
        if (r106 == true) goto L53;
        r107 = 8;
    L53:
        r118.setVisibility(r107);
        return;
    L47:
        if (this.L1 == AsrInputMode.HANDSFREE) goto L49;
    L57:
        return;
    L56:
        return;
    L38:
        ry8.c r119 = (ry8.c) this.f287086p0.getValue();
        if (r119 == null) goto L41;
        r119.NN();
        goto L41
    L32:
        r115 = 8;
        goto L33
    L18:
        r114 = false;
        goto L19
    L55:
        return;
    L5:
        if (r105.getVisibility() != 0) goto L7;
        boolean r120 = true;
    L8:
        r108 = Boolean.valueOf(r120);
        goto L10
    L7:
        r120 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.larus.asr.session.e] */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.larus.asr.session.d] */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.larus.asr.x0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v18, types: [T, com.larus.asr.session.q0] */
    /* JADX WARN: Type inference failed for: r11v2, types: [T, com.larus.asr.session.SendMessageAsrSessionV2] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v4, types: [T, com.larus.asr.session.InputTextAsrSession2V2] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r13v2, types: [T, com.larus.asr.session.QuicInterpretAsrSessionV2] */
    /* JADX WARN: Type inference failed for: r14v2, types: [com.larus.asr.session.f] */
    /* JADX WARN: Type inference failed for: r14v4, types: [com.larus.asr.session.b] */
    public Triple<com.larus.asr.session.o, Boolean, Boolean> V3(final boolean r110, final com.larus.audio.asr.c0 r111, String r112, VoiceInputType r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r111, "traceInfo");
        Intrinsics.checkNotNullParameter(r112, "asrTaskId");
        Intrinsics.checkNotNullParameter(r113, "voiceInputType");
        final com.larus.asr.session.g r100 = (com.larus.asr.session.g) this.f287092t.getValue();
        Function0 r101 = new w0(this, r110, r111);
        ChatBottomSpeakerComponent$createAsrSession$session$2 r115 = new ChatBottomSpeakerComponent$createAsrSession$session$2(this);
        ?? r116 = new x0(this);
        Function0 r102 = new y0(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r112, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r113, "voiceInputType");
        Intrinsics.checkNotNullParameter(r101, "instructionInputIntercepted");
        Intrinsics.checkNotNullParameter(r115, "canUseSimultaneousTranslator");
        Intrinsics.checkNotNullParameter(r116, "simultaneousTranslatorAbilityGetter");
        Intrinsics.checkNotNullParameter(r102, "clickTalkAbilityGetter");
        if (((Boolean) r101.invoke()).booleanValue() == false) goto L10;
        if (com.larus.platform.service.z2.f365865a.asrSessionComponentSplit() == true) goto L7;
        ?? r117 = new InputTextAsrSession(r100.f287845a, r112);
    L28:
        if ((r117 instanceof ComponentAsrSession) == false) goto L30;
        ComponentAsrSession r118 = (ComponentAsrSession) r117;
    L31:
        r100.f287846b = r118;
        if ((r117 instanceof InputTextAsrSession) == false) goto L34;
    L37:
        boolean r119 = true;
    L39:
        return new Triple(r117, Boolean.valueOf(!r119), Boolean.valueOf(r119));
    L34:
        if ((r117 instanceof com.larus.asr.session.q0) == true) goto L37;
        r119 = false;
        goto L39
    L30:
        r118 = null;
        goto L31
    L7:
        final Ref.ObjectRef r120 = new Ref.ObjectRef();
        ?? r121 = new com.larus.asr.session.q0(r100.f287845a, r112, new com.larus.asr.session.b(r100, r120));
        r120.element = r121;
        ?? r122 = r121;
    L8:
        r117 = r122;
        goto L28
    L10:
        if (r115.invoke().booleanValue() == true) goto L12;
        VoiceInputType.Companion.getClass();
        if (VoiceInputType.a.a(r113) == false) goto L18;
        r117 = new SamiCallAsrSession(r100.f287845a, r112, r114, r102, r113);
        goto L28
    L18:
        if (r114 == false) goto L24;
        if (com.larus.platform.service.z2.f365865a.asrSessionComponentSplit() == true) goto L22;
        r117 = new InputTextAsrSession2(r100.f287845a, r112);
        goto L28
    L22:
        final Ref.ObjectRef r123 = new Ref.ObjectRef();
        ?? r124 = new InputTextAsrSession2V2(r100.f287845a, r112, new com.larus.asr.session.f(r100, r123));
        r123.element = r124;
        r122 = r124;
        goto L8
    L24:
        if (com.larus.platform.service.z2.f365865a.asrSessionComponentSplit() == true) goto L26;
        r117 = new SendMessageAsrSession(r100.f287845a, r112, r113);
        goto L28
    L26:
        final Ref.ObjectRef r125 = new Ref.ObjectRef();
        ?? r126 = new SendMessageAsrSessionV2(r100.f287845a, r112, r113, new com.larus.asr.session.e(r100, r125));
        r125.element = r126;
        r122 = r126;
        goto L8
    L12:
        if (com.larus.platform.service.z2.f365865a.asrSessionComponentSplit() == true) goto L14;
        r117 = new com.larus.asr.session.i1(r100.f287845a, r112, r116);
        goto L28
    L14:
        final Ref.ObjectRef r127 = new Ref.ObjectRef();
        ?? r128 = new QuicInterpretAsrSessionV2(r100.f287845a, r112, r116, new com.larus.asr.session.d(r100, r127));
        r127.element = r128;
        r117 = r128;
        goto L28
    }

    @Override // com.larus.asr.session.p
    public Map<String, String> eb(String r110, Message r111, ReferenceInfo r112, Object r113, Map<String, String> r114) {
        Intrinsics.checkNotNullParameter(r110, "asrResult");
        Intrinsics.checkNotNullParameter(r111, "sendMsg");
        Intrinsics.checkNotNullParameter(r114, "messageExt");
        String r100 = "";
        String r101 = null;
        if (r113 == null) goto L10;
        Map<String, String> r115 = MapsKt.toMutableMap(IAIChatService.f365899a.A7(new Pair("", "")));
        com.larus.bmhome.instruction.g r116 = vc();
        if (r116 == null) goto L9;
        Map<String, String> r117 = r116.nK(null);
        if (r117 == null) goto L9;
        r115.putAll(r117);
    L9:
        return r115;
    L10:
        com.larus.bmhome.instruction.g r118 = vc();
        boolean r102 = true;
        if (r118 == null) goto L29;
        String r119 = r118.Qh(r110);
        if (r119 == null) goto L29;
        if (TypeIntrinsics.isMutableMap(r111.getExt()) == false) goto L29;
        Map<String, String> r120 = r111.getExt();
        Intrinsics.checkNotNull(r120, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
        TypeIntrinsics.asMutableMap(r120).put(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION, r119);
        Map<String, String> r121 = r111.getExt();
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
        Map r122 = TypeIntrinsics.asMutableMap(r121);
        com.larus.bmhome.instruction.g r123 = vc();
        if (r123 == null) goto L22;
        com.larus.bmhome.actionbar.model.z0 r124 = r123.yF();
        if (r124 == null) goto L22;
        String r125 = r124.f295606b;
        if (r125 == null) goto L22;
    L23:
        r122.put("action_bar_key", r125);
        IAIChatService.Companion r126 = IAIChatService.f365899a;
        Map<String, String> r127 = r111.getExt();
        Intrinsics.checkNotNull(r127, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
        r126.i7(TypeIntrinsics.asMutableMap(r127));
        if ((!r114.isEmpty()) == true) goto L27;
        r114 = null;
    L27:
        if (r114 == null) goto L29;
        Map<String, String> r128 = r111.getExt();
        Intrinsics.checkNotNull(r128, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
        TypeIntrinsics.asMutableMap(r128).putAll(r114);
    L22:
        r125 = "";
    L29:
        Map<String, String> r129 = r111.getExt();
        if (r129 == null) goto L33;
        Map<String, String> r130 = MapsKt.toMutableMap(r129);
        if (r130 == null) goto L33;
    L35:
        if (r112 == null) goto L89;
        u7 r131 = (u7) this.T.getValue();
        if (r131 == null) goto L48;
        List<Message> r132 = r131.zj();
        if (r132 == null) goto L48;
        Iterator<T> r133 = r132.iterator();
    L42:
        if (r133.hasNext() == false) goto L46;
        Object r134 = r133.next();
        if (Intrinsics.areEqual(((Message) r134).getMessageId(), r112.referencedMessageId) == false) goto L42;
    L47:
        Message r103 = (Message) r134;
    L49:
        com.larus.bmhome.chat.component.bottom.reference.a r135 = g5();
        if (r135 != null) goto L52;
    L54:
        r102 = false;
    L55:
        com.larus.bmhome.chat.component.bottom.reference.a r136 = g5();
        if (r136 == null) goto L58;
        r101 = r136.vS();
    L58:
        IAIChatService.f365899a.F7(r130, r103, r112.searchIndex, "reference_input", Intrinsics.areEqual(r101, "reference"));
        if (r102 == true) goto L61;
    L65:
        boolean r137 = com.larus.platform.service.z2.f365865a.getBasicExperienceBugFixConfig().f486821d;
        com.larus.bmhome.chat.component.bottom.reference.a r138 = g5();
        if (r138 == null) goto L115;
        String r139 = r138.vS();
        if (r139 == null) goto L115;
        int r104 = r139.hashCode();
        if (r104 == (-1165870106)) goto L86;
        if (r104 == 1101148556) goto L83;
        if (r104 != 1660791271) goto L115;
        if (r139.equals("auto_cite") == false) goto L115;
        if (r137 == false) goto L81;
        r130.put("select_text_action", new JSONObject().put("action", com.bytedance.android.ec.core.event.a.VALUE_QUESTION).toString());
    L81:
        r130.put("sec_scene", "choose_text_auto_cite");
        goto L115
    L83:
        if (r139.equals("rewrite") == false) goto L115;
        r130.put("select_text_action", new JSONObject().put("action", r139).toString());
        r130.put("sec_scene", "rewrite");
        goto L115
    L86:
        if (r139.equals(com.bytedance.android.ec.core.event.a.VALUE_QUESTION) == false) goto L115;
        r130.put("select_text_action", new JSONObject().put("action", r139).toString());
        r130.put("sec_scene", "click_cite_button");
    L115:
        com.larus.bmhome.instruction.g r140 = vc();
        if (r140 == null) goto L121;
        String r141 = r140.c0();
        if (r141 == null) goto L121;
        r100 = r141;
    L121:
        r130.put("gen_music_create_type", r100);
        return r130;
    L61:
        if (Intrinsics.areEqual(r101, "auto_cite") == false) goto L63;
        String r142 = "choose_text_auto_cite";
    L64:
        r130.put("enter_method_trace", r142);
        goto L65
    L63:
        r142 = "click_chat";
        goto L64
    L52:
        if (r135.i9() != true) goto L54;
    L46:
        r134 = null;
    L48:
        r103 = null;
        goto L49
    L89:
        int r143 = com.larus.utils.p0.f375454a;
        Map<String, String> r144 = r111.getExt();
        if (r144 == null) goto L92;
        String r145 = r144.get(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION);
    L94:
        if (com.larus.utils.p0.b(r145).optInt("instruction_type") != 7) goto L115;
        u7 r146 = (u7) this.T.getValue();
        if (r146 == null) goto L110;
        List<Message> r147 = r146.zj();
        if (r147 == null) goto L110;
        Iterator<T> r148 = r147.iterator();
    L101:
        if (r148.hasNext() == false) goto L108;
        Object r149 = r148.next();
        if (((Message) r149).getContentType() == 0) goto L105;
        boolean r150 = true;
    L106:
        if (r150 == false) goto L101;
    L109:
        Message r105 = (Message) r149;
    L111:
        IAIChatService.Companion r106 = IAIChatService.f365899a;
        if (r105 == null) goto L114;
        r101 = r105.getMessageId();
    L114:
        r106.F7(r130, r105, r106.d(r101), "instruction_input", true);
        goto L115
    L105:
        r150 = false;
        goto L106
    L108:
        r149 = null;
    L110:
        r105 = null;
        goto L111
    L92:
        r145 = null;
    L33:
        r130 = new LinkedHashMap();
        goto L35
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public void pv(int r110, float r111, float r112, float r113, float r114) {
        Integer r100 = null;
        if (this.f287093u != null) goto L6;
        FLogger.f375446a.e("ChatBottomSpeakerComponent", "handleTouchAction[" + r110 + "]: botId is null");
        t19.s r101 = t19.s.f544207a;
        Context r102 = getContext();
        r101.getClass();
        t19.s.b(r102, R.string.larus_system_error_toast, false);
        this.G1 = null;
        A9();
        return;
    L6:
        ChatSpeaker r103 = a4();
        if (r103 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L16;
        FLogger.f375446a.e("ChatBottomSpeakerComponent", "handleTouchAction[" + r110 + "]: speaker is invisible");
        return;
    L16:
        if (r110 == (-1)) goto L29;
        if (r110 != 0) goto L42;
        int r105 = this.H1 + 1;
        this.H1 = r105;
        if (r105 != 1) goto L25;
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("handleTouchAction[");
        r107.append(r110);
        r107.append("], moveStart,speaker:");
        ChatSpeaker r108 = a4();
        if (r108 == null) goto L24;
        r100 = Integer.valueOf(r108.hashCode());
    L24:
        r107.append(r100);
        r106.i("ChatBottomSpeakerComponent", r107.toString());
    L25:
        ChatSpeaker r109 = a4();
        if (r109 == null) goto L39;
        r109.u6(TuplesKt.to(Float.valueOf(r111), Float.valueOf(r112)), TuplesKt.to(Float.valueOf(r113), Float.valueOf(r114)));
        return;
    L39:
        return;
    L42:
        return;
    L29:
        if (this.H1 <= 0) goto L35;
        FLogger r115 = FLogger.f375446a;
        StringBuilder r116 = new StringBuilder("handleTouchAction[");
        r116.append(r110);
        r116.append("], moveEnd after ");
        r116.append(this.H1);
        r116.append(",speaker:");
        ChatSpeaker r117 = a4();
        if (r117 == null) goto L33;
        Integer r118 = Integer.valueOf(r117.hashCode());
    L34:
        r116.append(r118);
        r115.i("ChatBottomSpeakerComponent", r116.toString());
        this.H1 = 0;
        goto L35
    L33:
        r118 = null;
    L35:
        this.G1 = null;
        ChatSpeaker r119 = a4();
        if (r119 == null) goto L41;
        ChatSpeaker.A8(r119, r111, r112, r113, r114, false, 16);
        return;
    L41:
        return;
    L9:
        if (r103.getVisible() == true) goto L11;
        r104 = true;
        goto L12
    }

    public static Unit p3(ChatBottomSpeakerComponent r110, ChatSpeaker r111, HandsfreeDirectEntry r112, String r113, String r114, HandsfreeExperimentConfig r115, boolean r210) {
        if (r210 == true) goto L5;
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "[HF] tryEnterHandsfreeDirectly: audio permission denied, abort (no overlay)");
        return Unit.INSTANCE;
    L5:
        x5.d().a(true);
        va8.o r100 = (va8.o) r110.V.getValue();
        int r101 = 0;
        if (r100 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L15;
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "[HF] tryEnterHandsfreeDirectly: hideIme before entering handsfree");
        ICoreInputAbility r103 = r110.Z3();
        if (r103 == null) goto L15;
        r103.qp(false);
    L15:
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "[HF] tryEnterHandsfreeDirectly: permission granted, speaker=" + r111.hashCode() + " invokeOnSpeak+enableHandsFree(directly=true)");
        int r104 = d.f287113b[r112.ordinal()];
        if (r104 != 1) goto L18;
        String r105 = "mic_icon";
    L23:
        r110.T1 = r105;
        com.larus.bmhome.chat.component.bottom.core.speaker.l.a.a(r110, false, false, VoiceInputType.TouchSpeaker, true, new com.larus.audio.asr.c0(r113, r114, r101, 252), null, null, null, null, null, 992);
        r111.k6(r115.getCancelIconStyle(), true);
        return Unit.INSTANCE;
    L18:
        if (r104 != 2) goto L21;
        r105 = "input_box_click";
        goto L23
    L21:
        throw new NoWhenBranchMatchedException();
    L8:
        if (r100.w() != true) goto L10;
        r102 = true;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9, types: [com.larus.asr.session.SamiCallAsrSession] */
    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.l
    public String LT(boolean r310, boolean r311, VoiceInputType r312, boolean r313, com.larus.audio.asr.c0 r314, Integer r315, Long r316, final Function1<? super String, Unit> r410, Map<String, Object> r411, Function1<? super Map<String, ? extends Object>, Unit> r412) {
        Intrinsics.checkNotNullParameter(r312, "voiceInputType");
        Intrinsics.checkNotNullParameter(r314, "traceInfo");
        if (h4() == false) goto L5;
        j4();
    L5:
        String r100 = this.T1;
        this.T1 = null;
        if (r100 == null) goto L8;
        boolean r101 = true;
    L9:
        this.V1 = r101;
        this.S1 = r100;
        this.f287075b2 = 0;
        this.f287077g2 = SystemClock.elapsedRealtime();
        this.f287079h2 = null;
        this.P1 = false;
        this.Q1 = false;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).getFragmentManager() == null) goto L239;
        String r102 = UUID.randomUUID().toString();
        this.G1 = r102;
        f2a.c r103 = this.f287094v.b("fromTextArea");
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put(new f2a.f("from_text_area"), String.valueOf(r310));
        r104.put(new f2a.f("asr_only"), String.valueOf(r311));
        f2a.f r105 = f2a.f.f475238h;
        com.larus.bmhome.chat.component.cvs.y r106 = u0();
        String r110 = "";
        if (r106 == null) goto L15;
        String r107 = r106.Y1();
        if (r107 == null) goto L15;
    L16:
        r104.put(r105, r107);
        f2a.f r108 = f2a.f.f475235e;
        com.larus.bmhome.chat.component.cvs.y r109 = u0();
        if (r109 == null) goto L20;
        String r111 = r109.getBotId();
        if (r111 == null) goto L20;
    L21:
        r104.put(r108, r111);
        r103.d(r104);
        r103.f475230c.f475256d = "invokeOnSpeak";
        List<String> r112 = CollectionsKt.listOf(r314.f288366a);
        f2a.g r113 = r103.f475230c;
        r113.f475254b = r112;
        r113.f475257e = r314.f288367b;
        f2a.c.c(r103, null, 15);
        com.larus.bmhome.chat.component.bottom.multimodal.latest.a r114 = (com.larus.bmhome.chat.component.bottom.multimodal.latest.a) this.L0.getValue();
        if (r114 == null) goto L24;
        r114.g0("ChatBottomSpeakerComponent#invokeOnSpeak");
    L24:
        com.larus.asr.session.o r115 = this.f287091s;
        if ((r115 instanceof SamiCallAsrSession) == false) goto L27;
        SamiCallAsrSession r116 = (SamiCallAsrSession) r115;
    L28:
        if (r116 != null) goto L30;
    L32:
        SamiCallAsrSession r117 = null;
    L33:
        SamiCallAsrSession r118 = r117;
        Triple<com.larus.asr.session.o, Boolean, Boolean> r119 = V3(r310, r314, r102, r312, r311);
        boolean r120 = r119.getSecond().booleanValue();
        boolean r121 = r119.getThird().booleanValue();
        com.larus.asr.session.o r122 = r119.getFirst();
        f2a.c r123 = this.f287094v.b("createAsrSession");
        LinkedHashMap r124 = new LinkedHashMap();
        f2a.f r125 = new f2a.f("session_type");
        String r126 = Reflection.getOrCreateKotlinClass(r122.getClass()).getSimpleName();
        if (r126 != null) goto L36;
        r126 = "";
    L36:
        r124.put(r125, r126);
        r124.put(new f2a.f("is_speak"), String.valueOf(r120));
        r124.put(new f2a.f("reset_task_id"), String.valueOf(r121));
        r123.d(r124);
        r123.f475230c.f475256d = "invokeOnSpeak";
        List<String> r127 = CollectionsKt.listOf(r314.f288366a);
        f2a.g r128 = r123.f475230c;
        r128.f475254b = r127;
        r128.f475257e = r314.f288367b;
        f2a.c.c(r123, null, 15);
        this.f287091s = r122;
        Bundle r129 = f1().f468086b;
        if (r129 == null) goto L42;
        String r130 = r129.getString("item_id", "");
        if (r130 == null) goto L42;
        String r131 = r130;
    L43:
        Iterator<com.larus.bmhome.chat.component.bottom.core.speaker.b> r132 = this.f287074b1.iterator();
    L45:
        if (r132.hasNext() == false) goto L47;
        com.larus.bmhome.chat.component.bottom.core.speaker.b r133 = r132.next();
        Intrinsics.checkNotNull(r133);
        r122.A4(r133);
        goto L45
    L47:
        Iterator<com.larus.bmhome.chat.component.bottom.core.speaker.h> r134 = this.V0.iterator();
    L49:
        if (r134.hasNext() == false) goto L52;
        com.larus.bmhome.chat.component.bottom.core.speaker.h r135 = r134.next();
        Intrinsics.checkNotNull(r135);
        r122.e8(r135);
        goto L49
    L52:
        if (h4() == false) goto L54;
        final Function2<? super String, ? super String, Boolean> r136 = new k1(this);
    L55:
        r122.la(this.M, this.N, this.O, new m1(r136));
        r122.ra(r136);
        r122.na(this.f287104z);
        r122.b3(this.f287073J);
        r122.sa(new f(this));
        long r210 = SystemClock.elapsedRealtime();
        if (r120 == false) goto L60;
        ChatSpeaker r211 = a4();
        if (r211 == null) goto L60;
        ChatSpeaker.o7(r211, 0, false, new t0(this), 3);
    L60:
        com.larus.bmhome.instruction.g r137 = (com.larus.bmhome.instruction.g) s1a.d.a(this).getAbility(com.larus.bmhome.instruction.g.class);
        if (r137 == null) goto L66;
        if (r137.z0() != true) goto L66;
        boolean r138 = true;
    L67:
        boolean r139 = !r138;
        ICoreInputAbility r140 = Z3();
        if (r140 == null) goto L82;
        com.larus.bmhome.chat.component.cvs.y r141 = u0();
        if (r141 == null) goto L72;
        BotModel r142 = r141.j0();
    L73:
        com.larus.bmhome.chat.component.cvs.y r143 = u0();
        if (r143 == null) goto L80;
        String r144 = r143.Y1();
        if (r144 == null) goto L80;
        r110 = r144;
    L80:
        if (r140.lW(r142, r110) != true) goto L82;
        boolean r145 = true;
    L83:
        int r146 = com.larus.bmhome.utils.r.f315104a;
        if (com.larus.bmhome.utils.r.a(s1a.d.a(this)).f510335a == false) goto L88;
        if (r139 == false) goto L88;
        if (r145 == false) goto L88;
        boolean r147 = true;
    L89:
        IFlowSdkDepend r148 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r148 == null) goto L94;
        r148.N();
        if (com.larus.home.impl.sdk.n1.f346205a.w() != true) goto L94;
        boolean r149 = true;
    L96:
        if (((lq9.k) this.f287076g1.getValue()).a() == true) goto L98;
    L112:
        boolean r150 = false;
    L113:
        ChatSpeaker r151 = a4();
        if (r151 == null) goto L117;
        r151.V8(new u0(r147, r150));
    L117:
        if (r120 == false) goto L160;
        ChatSpeaker r152 = a4();
        if (r152 == null) goto L121;
        r152.f288136z = true;
    L121:
        boolean r153 = h4();
        com.larus.bmhome.chat.component.cvs.y r154 = u0();
        if (r154 == null) goto L124;
        wc9.e r155 = r154.h();
    L125:
        boolean r156 = com.larus.bmhome.utils.i.f(r155);
        com.larus.platform.service.z2 r157 = com.larus.platform.service.z2.f365865a;
        HandsfreeExperimentConfig r158 = r157.voiceInputHandsfreeConfig();
        FLogger r159 = FLogger.f375446a;
        StringBuilder r160 = new StringBuilder("[HF] invokeOnSpeak StepA gate: exp=");
        r160.append(r153);
        r160.append(" voiceInputType=");
        r160.append(r312);
        r160.append(" mainbot=");
        r160.append(r156);
        r160.append(" longPressLockEnabled=");
        r160.append(r158.getLongPressLockEnabled());
        r160.append(" speaker=");
        ChatSpeaker r161 = a4();
        if (r161 == null) goto L128;
        Integer r162 = Integer.valueOf(r161.hashCode());
    L129:
        r160.append(r162);
        r159.i("ChatBottomSpeakerComponent", r160.toString());
        if (r153 == false) goto L140;
        if (r312 != VoiceInputType.TouchSpeaker) goto L140;
        if (r158.getLongPressLockEnabled() == false) goto L140;
        ChatSpeaker r163 = a4();
        if (r163 != null) goto L138;
        r159.e("ChatBottomSpeakerComponent", "[HF] invokeOnSpeak StepA: speaker is null, cannot inflate lock UI");
    L144:
        final Ref.IntRef r164 = new Ref.IntRef();
        r164.element = -1;
        final Ref.IntRef r165 = new Ref.IntRef();
        r165.element = -1;
        if (r157.S1().getEnableNewStyle() == false) goto L150;
        ChatSpeaker r166 = a4();
        if (r166 == null) goto L150;
        r166.setOnBlurVisibilityChanged(new n1(this, r164, r165));
    L150:
        if (r157.getVibrateConfig().f486827b == false) goto L160;
        if (r310 == false) goto L156;
        if ((SystemClock.elapsedRealtime() - r210) <= 100) goto L156;
        com.larus.bmhome.utils.a4.f314971a.getClass();
        com.larus.bmhome.utils.a4.a(com.larus.bmhome.utils.a4.f314972b);
    L156:
        if ((SystemClock.elapsedRealtime() - r210) <= 500) goto L160;
        com.larus.bmhome.utils.a4.f314971a.getClass();
        com.larus.bmhome.utils.a4.a(com.larus.bmhome.utils.a4.f314972b);
        goto L160
    L138:
        r159.i("ChatBottomSpeakerComponent", "[HF] invokeOnSpeak StepA: inflate lock UI (directly=false)");
        r163.k6(r158.getCancelIconStyle(), false);
    L140:
        if (r153 == false) goto L144;
        ChatSpeaker r167 = a4();
        if (r167 == null) goto L144;
        r167.c6();
        goto L144
    L128:
        r162 = null;
        goto L129
    L124:
        r155 = null;
    L160:
        if (h4() == false) goto L162;
        d58.a r212 = new d58.a(com.larus.platform.service.z2.f365865a.voiceInputHandsfreeConfig().getMaxAudioDurationMs(), 0, 500);
    L163:
        com.larus.audio.asr.m0 r168 = com.larus.audio.asr.l0.f288426a;
        Intrinsics.checkNotNullParameter(this, "source");
        com.larus.audio.asr.l0.f288426a = this;
        IFlowCamera r169 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r169 == null) goto L166;
        int r170 = r169.y();
    L167:
        if (r170 != 0) goto L182;
        com.larus.bmhome.instruction.g r171 = vc();
        if (r171 != null) goto L171;
    L173:
        boolean r172 = false;
    L174:
        if (r172 == false) goto L178;
        com.larus.bmhome.instruction.g r173 = vc();
        if (r173 == null) goto L181;
        r170 = r173.bd();
    L181:
        r170 = 0;
        goto L182
    L178:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r174 = f70();
        if (r174 == null) goto L181;
        r170 = com.larus.bmhome.chat.component.bottom.attachment.g1.a.b(r174);
        goto L182
    L171:
        if (r171.z0() != true) goto L173;
        r172 = true;
    L182:
        com.larus.bmhome.chat.component.bottom.reference.a r175 = g5();
        if (r175 == null) goto L187;
        boolean r176 = true;
        if (r175.i9() != true) goto L188;
        boolean r177 = true;
    L189:
        if (r177 == false) goto L191;
        String r178 = "cite";
    L192:
        ICoreInputAbility r179 = Z3();
        if (r179 != null) goto L195;
    L197:
        boolean r180 = false;
    L198:
        if (r180 == false) goto L200;
        String r181 = ObricActionBarTrackType.SPEAK;
    L201:
        IFlowCamera r182 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r182 != null) goto L204;
    L206:
        r176 = false;
    L207:
        if (r176 == true) goto L209;
        String r183 = "camera_confirm";
        String r184 = null;
    L217:
        String r185 = r184;
        r122.pa(r131, r310, r313, com.larus.audio.asr.c0.a(r314, r170, r178, r181, r183, null, 135), r210, r316, r315, r212);
        if (r121 == false) goto L221;
        this.G1 = r185;
    L221:
        if ((r122 instanceof SamiCallAsrSession) == false) goto L237;
        com.larus.asr.session.o r186 = this.f287091s;
        if ((r186 instanceof SamiCallAsrSession) == false) goto L225;
        final ?? r187 = (SamiCallAsrSession) r186;
    L227:
        if (r118 == null) goto L234;
        if (r118 == r187) goto L234;
        FLogger.f375446a.i("ChatBottomSpeakerComponent", "invokeOnSpeak close previous active click talk session before start new");
        SamiCallAsrSession.d(r118);
        if (r411 == null) goto L232;
        final ?? r188 = new HashMap(r411);
    L233:
        com.larus.utils.t0.a(new com.larus.asr.l(r187, r410, r188));
        goto L237
    L232:
        r188 = r185;
    L234:
        if (r187 == 0) goto L237;
        r187.i(r410, r411);
        goto L237
    L225:
        r187 = r185;
    L237:
        return this.G1;
    L209:
        Intrinsics.checkNotNullParameter(this, "<this>");
        by7.e r189 = by7.h.h(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        if (r189 == null) goto L215;
        r184 = null;
        String r190 = TrackParams.optString$default(by7.h.a(r189), "current_page", null, 2, null);
        if (r190 == null) goto L216;
    L214:
        r183 = r190;
    L216:
        r190 = "other";
        goto L214
    L215:
        r184 = null;
        goto L216
    L204:
        if (r182.y() != 0) goto L206;
    L200:
        r181 = ObricActionBarTrackType.KEY_BOARD;
        goto L201
    L195:
        if (r179.Rp() != 2) goto L197;
        r180 = true;
        goto L198
    L191:
        r178 = null;
    L188:
        r177 = false;
        goto L189
    L187:
        r176 = true;
        goto L188
    L166:
        r170 = 0;
        goto L167
    L162:
        r212 = d58.a.f467063d;
        goto L163
    L98:
        if (((lq9.k) this.f287076g1.getValue()).b() == false) goto L112;
        if (r149 == true) goto L112;
        if (r139 == false) goto L112;
        if (r145 == false) goto L112;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r191 = f70();
        if (r191 != null) goto L105;
    L107:
        boolean r192 = false;
    L108:
        if (r192 == true) goto L112;
        if (((SpeakStyleConfig) this.f287078h1.getValue()).getEnableNewStyle() == false) goto L112;
        r150 = true;
        goto L113
    L105:
        if (r191.isVisible() != true) goto L107;
        r192 = true;
    L94:
        r149 = false;
    L88:
        r147 = false;
        goto L89
    L72:
        r142 = null;
    L82:
        r145 = false;
    L66:
        r138 = false;
        goto L67
    L54:
        r136 = new l1(this);
    L42:
        r131 = "";
        goto L43
    L30:
        if (r116.f287507m == false) goto L32;
        r117 = r116;
        goto L33
    L27:
        r116 = null;
    L20:
        r111 = "";
    L15:
        r107 = "";
        goto L16
    L239:
        return null;
    L8:
        r101 = false;
        goto L9
    }
}
