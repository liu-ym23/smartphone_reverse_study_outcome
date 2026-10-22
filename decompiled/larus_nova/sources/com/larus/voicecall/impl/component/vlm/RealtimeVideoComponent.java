package com.larus.voicecall.impl.component.vlm;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.av_call.view.VoiceCallBottomLayout;
import com.larus.av_call.view.VoiceCallTopLayout;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.ZoomableTextureView;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.livetutor.impl.home.viewmodel.LiveTutorHomeVM;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i3;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.RealtimeCallService;
import com.larus.voicecall.impl.ui.VoiceCallContentLayout;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.utils.RealtimeNoticeDialogHelper;
import com.larus.voicecall.impl.video.VideoFaceMemoryAuthDialog;
import com.larus.voicecall.impl.video.VideoPreviewState;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.vesdk.VEDisplaySettings;
import com.ss.android.vesdk.VESDK;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import v19.e6;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000Ô\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\u009b\u0001\u0018\u0000 \u0080\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0006\u0080\u0002\u0081\u0002\u0082\u0002B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J0\u0010\u009d\u0001\u001a\u00030\u008a\u00012\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\u0007\u0010 \u0001\u001a\u00020o2\b\u0010¡\u0001\u001a\u00030\u009f\u00012\u0007\u0010¢\u0001\u001a\u00020oH\u0016J\t\u0010¤\u0001\u001a\u00020\bH\u0002J\t\u0010¥\u0001\u001a\u00020\bH\u0002J\u001f\u0010¦\u0001\u001a\u00030\u008a\u00012\b\u0010§\u0001\u001a\u00030¨\u00012\t\b\u0002\u0010©\u0001\u001a\u00020\bH\u0002J\n\u0010ª\u0001\u001a\u00030\u008a\u0001H\u0016J\n\u0010«\u0001\u001a\u00030\u008a\u0001H\u0016J\n\u0010¯\u0001\u001a\u00030\u008a\u0001H\u0002J\u0013\u0010°\u0001\u001a\u00030\u008a\u00012\u0007\u0010±\u0001\u001a\u00020`H\u0016J\u0014\u0010²\u0001\u001a\u00030\u008a\u00012\b\u0010³\u0001\u001a\u00030´\u0001H\u0002J\n\u0010µ\u0001\u001a\u00030\u008a\u0001H\u0002J\u0014\u0010¶\u0001\u001a\u00030\u008a\u00012\b\u0010³\u0001\u001a\u00030´\u0001H\u0002J\u0014\u0010·\u0001\u001a\u00030\u008a\u00012\b\u0010¸\u0001\u001a\u00030¹\u0001H\u0016J \u0010º\u0001\u001a\u00030\u008a\u00012\b\u0010¸\u0001\u001a\u00030\u0089\u00012\n\u0010»\u0001\u001a\u0005\u0018\u00010¼\u0001H\u0016J3\u0010½\u0001\u001a\u00030\u008a\u00012\u0007\u0010¾\u0001\u001a\u00020o2\u0007\u0010¿\u0001\u001a\u00020o2\t\b\u0002\u0010À\u0001\u001a\u00020\b2\n\b\u0002\u0010Á\u0001\u001a\u00030\u0089\u0001H\u0002J\n\u0010Â\u0001\u001a\u00030\u008a\u0001H\u0016J\n\u0010Ã\u0001\u001a\u00030\u008a\u0001H\u0016J\n\u0010Ä\u0001\u001a\u00030\u008a\u0001H\u0002J\n\u0010Å\u0001\u001a\u00030\u008a\u0001H\u0002J\n\u0010Ç\u0001\u001a\u00030\u008a\u0001H\u0002J\u0014\u0010È\u0001\u001a\u00030\u008a\u00012\b\u0010É\u0001\u001a\u00030\u0089\u0001H\u0002J\n\u0010Ê\u0001\u001a\u00030\u008a\u0001H\u0002J\u0013\u0010Ë\u0001\u001a\u00030\u008a\u00012\u0007\u0010Ì\u0001\u001a\u00020\bH\u0002J\n\u0010Í\u0001\u001a\u00030\u008a\u0001H\u0002J\n\u0010Î\u0001\u001a\u00030\u008a\u0001H\u0002J\u0012\u0010Ï\u0001\u001a\u00020\b2\u0007\u0010©\u0001\u001a\u00020\bH\u0002J\u0013\u0010Ð\u0001\u001a\u00030\u008a\u00012\u0007\u0010Ñ\u0001\u001a\u00020\bH\u0002J&\u0010Ò\u0001\u001a\u00030\u008a\u00012\u0007\u0010Ó\u0001\u001a\u00020o2\u0007\u0010Ô\u0001\u001a\u00020o2\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0002J\n\u0010×\u0001\u001a\u00030\u008a\u0001H\u0002J\u0013\u0010Ø\u0001\u001a\u00030\u008a\u00012\u0007\u0010Ù\u0001\u001a\u00020\bH\u0002J\t\u0010Ú\u0001\u001a\u00020\bH\u0002J\u0013\u0010Û\u0001\u001a\u00030\u008a\u00012\u0007\u0010Ü\u0001\u001a\u00020gH\u0016J\n\u0010Ý\u0001\u001a\u00030\u008a\u0001H\u0002J\u0014\u0010Þ\u0001\u001a\u00030\u008a\u00012\b\u0010ß\u0001\u001a\u00030\u0089\u0001H\u0002J\n\u0010à\u0001\u001a\u00030\u008a\u0001H\u0002J\u0013\u0010á\u0001\u001a\u00030\u008a\u00012\u0007\u0010â\u0001\u001a\u00020\bH\u0002J\n\u0010ã\u0001\u001a\u00030\u008a\u0001H\u0002J\u0014\u0010ä\u0001\u001a\u00030\u008a\u00012\b\u0010Ü\u0001\u001a\u00030\u008c\u0001H\u0002J\u0014\u0010å\u0001\u001a\u00030\u008a\u00012\b\u0010§\u0001\u001a\u00030\u0089\u0001H\u0016J\u0014\u0010æ\u0001\u001a\u00030\u008a\u00012\b\u0010§\u0001\u001a\u00030\u0089\u0001H\u0016J\n\u0010ç\u0001\u001a\u00030\u008a\u0001H\u0016J\u001d\u0010è\u0001\u001a\u00030\u008a\u00012\b\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010©\u0001\u001a\u00020\bH\u0016J\n\u0010é\u0001\u001a\u00030\u008a\u0001H\u0016J\t\u0010ê\u0001\u001a\u00020\bH\u0016J\n\u0010ë\u0001\u001a\u00030\u008a\u0001H\u0016J\t\u0010ì\u0001\u001a\u00020\bH\u0016J\t\u0010í\u0001\u001a\u00020\bH\u0016J\u001d\u0010è\u0001\u001a\u00030\u008a\u00012\b\u0010§\u0001\u001a\u00030\u0089\u00012\u0007\u0010©\u0001\u001a\u00020\bH\u0016J6\u0010ï\u0001\u001a\u00030\u008a\u00012\b\u0010ß\u0001\u001a\u00030\u0089\u00012\u000f\u0010ð\u0001\u001a\n\u0012\u0005\u0012\u00030\u008a\u00010\u0099\u00012\u000f\u0010ñ\u0001\u001a\n\u0012\u0005\u0012\u00030\u008a\u00010\u0099\u0001H\u0002J\n\u0010ò\u0001\u001a\u00030\u008a\u0001H\u0002J)\u0010ó\u0001\u001a\u00030\u008a\u00012\u0007\u0010ô\u0001\u001a\u00020\b2\b\u0010§\u0001\u001a\u00030\u0089\u00012\n\b\u0002\u0010õ\u0001\u001a\u00030ö\u0001H\u0002J\u0013\u0010÷\u0001\u001a\u00020\b2\b\u0010§\u0001\u001a\u00030\u0089\u0001H\u0002J\n\u0010ø\u0001\u001a\u00030\u008a\u0001H\u0002J\u0010\u0010ù\u0001\u001a\u00020\bH\u0096@¢\u0006\u0003\u0010ú\u0001J\u001d\u0010û\u0001\u001a\u00020\b2\u0006\u0010u\u001a\u00020`2\n\u0010ü\u0001\u001a\u0005\u0018\u00010ý\u0001H\u0016J\n\u0010þ\u0001\u001a\u00030\u008a\u0001H\u0016J\t\u0010ÿ\u0001\u001a\u00020\bH\u0016R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0010\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0010\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0010\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0010\u001a\u0004\b1\u00102R\u001b\u00104\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0010\u001a\u0004\b6\u00107R\u001b\u00109\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0010\u001a\u0004\b:\u0010\nR\u001d\u0010<\u001a\u0004\u0018\u00010=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0010\u001a\u0004\b>\u0010?R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0010\u001a\u0004\bC\u0010DR\u001d\u0010F\u001a\u0004\u0018\u00010G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0010\u001a\u0004\bH\u0010IR\u001d\u0010K\u001a\u0004\u0018\u00010G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0010\u001a\u0004\bL\u0010IR\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010P\u001a\u0004\u0018\u00010Q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\u0010\u001a\u0004\bR\u0010SR\u001d\u0010U\u001a\u0004\u0018\u00010V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u0010\u001a\u0004\bW\u0010XR\u001d\u0010Z\u001a\u0004\u0018\u00010[8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010\u0010\u001a\u0004\b\\\u0010]R\u001d\u0010_\u001a\u0004\u0018\u00010`8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\u0010\u001a\u0004\ba\u0010bR\u000e\u0010d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010h\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bh\u0010\nR\u001d\u0010i\u001a\u0004\u0018\u00010j8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bm\u0010\u0010\u001a\u0004\bk\u0010lR\u000e\u0010n\u001a\u00020oX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010p\u001a\u0004\u0018\u00010q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bt\u0010\u0010\u001a\u0004\br\u0010sR\u001b\u0010u\u001a\u00020v8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\by\u0010\u0010\u001a\u0004\bw\u0010xR\u000e\u0010z\u001a\u00020{X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010}\u001a\u00020~8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010\u0010\u001a\u0005\b\u007f\u0010\u0080\u0001R\u000f\u0010\u0082\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0083\u0001\u001a\n\u0012\u0005\u0012\u00030\u0085\u00010\u0084\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0087\u0001\u001a\u0013\u0012\u0005\u0012\u00030\u0089\u0001\u0012\u0005\u0012\u00030\u008a\u0001\u0018\u00010\u0088\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008e\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u008f\u0001\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0091\u0001\u0010\u0010\u001a\u0005\b\u0090\u0001\u0010?R\u000f\u0010\u0092\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0093\u0001\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0093\u0001\u0010\nR\u0016\u0010\u0094\u0001\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0095\u0001\u0010\nR\u0016\u0010\u0096\u0001\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0096\u0001\u0010\nR\u000f\u0010\u0097\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0098\u0001\u001a\n\u0012\u0005\u0012\u00030\u008a\u00010\u0099\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u009a\u0001\u001a\u00030\u009b\u0001X\u0082\u000e¢\u0006\u0005\n\u0003\u0010\u009c\u0001R\u000f\u0010£\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¬\u0001\u001a\u00030\u00ad\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010®\u0001\u001a\n\u0012\u0005\u0012\u00030\u008a\u00010\u0099\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010Æ\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010î\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0083\u0002"}, d2 = {"Lcom/larus/voicecall/impl/component/vlm/RealtimeVideoComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "Lcom/larus/voicecall/impl/component/vlm/float_window/IRealtimeGlobalFloatWindowAbility;", "Lcom/obric/assistant/ability/call/IObricRealtimeVideoAbility;", "<init>", "()V", "useBackCamera", "", "getUseBackCamera", "()Z", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity$delegate", "Lkotlin/Lazy;", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "coreAbility", "Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "getCoreAbility", "()Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "coreAbility$delegate", "subtitleAbility", "Lcom/larus/voicecall/impl/component/subtitle/IRealtimeSubtitleAbility;", "getSubtitleAbility", "()Lcom/larus/voicecall/impl/component/subtitle/IRealtimeSubtitleAbility;", "subtitleAbility$delegate", "topAbility", "Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "getTopAbility", "()Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "topAbility$delegate", "contentAbility", "Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "getContentAbility", "()Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "contentAbility$delegate", "bottomAbility", "Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "getBottomAbility", "()Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "bottomAbility$delegate", "tracer", "Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "getTracer", "()Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "tracer$delegate", "fixTouristEnable", "getFixTouristEnable", "fixTouristEnable$delegate", "viewStateManager", "Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "getViewStateManager", "()Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "viewStateManager$delegate", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "switchCameraView", "Landroid/widget/ImageView;", "getSwitchCameraView", "()Landroid/widget/ImageView;", "switchCameraView$delegate", "flashlightIcon", "getFlashlightIcon", "flashlightIcon$delegate", "showHideFlashIconJob", "Lkotlinx/coroutines/Job;", "bottomControlArea", "Lcom/larus/av_call/view/VoiceCallBottomLayout;", "getBottomControlArea", "()Lcom/larus/av_call/view/VoiceCallBottomLayout;", "bottomControlArea$delegate", "videoViewContainer", "Landroid/widget/FrameLayout;", "getVideoViewContainer", "()Landroid/widget/FrameLayout;", "videoViewContainer$delegate", "voiceCallTopLayout", "Lcom/larus/av_call/view/VoiceCallTopLayout;", "getVoiceCallTopLayout", "()Lcom/larus/av_call/view/VoiceCallTopLayout;", "voiceCallTopLayout$delegate", "smallViewPortPH", "Landroid/view/View;", "getSmallViewPortPH", "()Landroid/view/View;", "smallViewPortPH$delegate", "hasLoseConnect", "hasPendingCloseVideo", "curConnectStatus", "Lcom/larus/im/internal/audio/context/SessionState;", "isVeCaptureEnable", "sceneAbility", "Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "getSceneAbility", "()Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "sceneAbility$delegate", "curUiState", "", "cameraManager", "Lcom/larus/voicecall/impl/component/vlm/camera/camera_state/ICameraManager;", "getCameraManager", "()Lcom/larus/voicecall/impl/component/vlm/camera/camera_state/ICameraManager;", "cameraManager$delegate", "videoView", "Landroid/view/TextureView;", "getVideoView", "()Landroid/view/TextureView;", "videoView$delegate", "viewModel", "Lcom/larus/voicecall/impl/video/RealtimeCallVideoViewModel;", "isFirstOpen", "videoSwitcher", "Lcom/larus/voicecall/impl/video/ViewPortSwitcher;", "getVideoSwitcher", "()Lcom/larus/voicecall/impl/video/ViewPortSwitcher;", "videoSwitcher$delegate", "hasMobLeave", "viewStateSnapshot", "", "Lcom/larus/voicecall/impl/component/vlm/RealtimeVideoComponent$ViewStateSnapshot;", "needCloseSubtitle", "fullVideoPreviewLazyTask", "Lkotlin/Function1;", "", "", "lastPreviewState", "Lcom/larus/voicecall/impl/video/VideoPreviewState;", "pendingCameraStatusUpdate", "hasSentInitialAppBackgroundContext", "stateManager", "getStateManager", "stateManager$delegate", "shouldResumeWhenAppForeground", "isBackCamera", "videoCaptureStarted", "getVideoCaptureStarted", "isOpenVlm", "everToastedFaceMemory", "onRejectCameraPermission", "Lkotlin/Function0;", "appForegroundObserver", "com/larus/voicecall/impl/component/vlm/RealtimeVideoComponent$appForegroundObserver$1", "Lcom/larus/voicecall/impl/component/vlm/RealtimeVideoComponent$appForegroundObserver$1;", "onUpdateUIState", "currentMajorState", "Lcom/larus/audio/call/mgr/MajorState;", "currentState", "newMajorState", "newState", "needEnterHalf", "shouldUseFloatVideoSubtitle", "shouldOpenFullPreviewWhenAutoEnterVideo", "closeVideo", "reason", "Lcom/larus/voicecall/impl/component/vlm/ExitVideoModalReason;", "needSwitchModal", "onAttach", "onVContextReady", "lastScale", "", "pinchClicker", "switchSubtitleWhenPopToFullVideo", "onViewCreated", "view", "showFocusView", "e", "Landroid/view/MotionEvent;", "hideFocusView", "triggerFocus", "onReceiveEvent", "event", "Lcom/larus/im/service/audio/MediaSessionListener$Event;", "otherEvent", "content", "", "mobVideoError", "deviceState", "deviceError", "isCheckoutModalError", "errorMsg", LiveCommonConstants.REASON_ON_DEDTROY, "onFragmentViewDestroyed", "setupVideoView", "setupVideoControl", "needEnterVideoCall", "registerSceneChangeListener", "mobExitVideoCall", "leaveMethod", "setupMenus", "updateCameraStatusContext", "useBack", "resumeCamera", "setupObservers", "startVideoCapture", "setOtherVideoChildrenVisible", "visible", "syncVePreviewSize", "width", "height", "fitMode", "Lcom/ss/android/vesdk/VEDisplaySettings$VEDisplayFitMode;", "syncVePreviewSizeAfterLayout", "onFirstFrameCapture", "isVECapture", "shouldRefreshFlashlightAfterFirstFrame", "onConnectionStateChanged", "state", "onVideoStart", "setVideoFullPreviewMode", "caller", "showFlashlightOnOpenFullVideo", "setForceDarkMode", "force", "hideSomeViews", "restoreSomeViews", "switchPopMode", "switchFullMode", "openLLMVideo", "tryCloseVideo", "tryPreloadVideoCapture", "isCameraBack", "refreshPipDialog", "isVideoFullPreviewMode", "isVideoPipPreviewMode", "isRequestCameraPermission", "requestCameraPermission", "onGranted", "onReject", "setupFlashlight", "resetFlashlightIcon", "show", "delayTime", "", "shouldCloseFlashlightWhenHidden", "closeFlashlight", "enableFlashlight", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showGlobalFloatWindow", "config", "Lcom/larus/voicecall/impl/component/vlm/float_window/GlobalFloatWindowConfig;", "hideGlobalFloatWindow", "isGlobalFloatWindowShowing", "Companion", "CameraStatus", "ViewStateSnapshot", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeVideoComponent extends RealtimeComponent implements com.larus.voicecall.impl.component.vlm.b, naa.b {

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public static final /* synthetic */ int f377808g1 = 0;
    public final Lazy A;
    public Job B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public boolean G;
    public boolean H;
    public boolean H0;
    public jd9.c I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Lazy f377809J;
    public int K;
    public final Lazy L;
    public float L0;
    public final Lazy M;
    public final com.larus.voicecall.impl.video.n N;
    public boolean O;
    public final Lazy P;
    public final n0 P0;
    public boolean Q;
    public final List<b> R;
    public boolean S;
    public Function1<? super String, Unit> T;
    public VideoPreviewState U;
    public boolean V;
    public boolean V0;
    public boolean W;
    public final Lazy X;
    public boolean Y;
    public boolean Z;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public boolean f377810b1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final m0 f377811k0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f377812n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f377813o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f377814p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final d f377815p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f377816q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f377817r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f377818s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f377819t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f377820u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f377821v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f377822w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f377823x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f377824y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f377825z;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/voicecall/impl/component/vlm/RealtimeVideoComponent$CameraStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NO_CHANGE", "BACK", "FRONT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CameraStatus extends Enum<CameraStatus> {
        public static final CameraStatus BACK = null;
        public static final CameraStatus FRONT = null;
        public static final CameraStatus NO_CHANGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CameraStatus[] f377826a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f377827b = null;
        private final String value;

        public static EnumEntries<CameraStatus> getEntries() {
            return f377827b;
        }

        static {
            CameraStatus r100 = new CameraStatus("NO_CHANGE", 0, "0");
            NO_CHANGE = r100;
            CameraStatus r101 = new CameraStatus("BACK", 1, "1");
            BACK = r101;
            CameraStatus r102 = new CameraStatus("FRONT", 2, "2");
            FRONT = r102;
            CameraStatus[] r103 = {r100, r101, r102};
            f377826a = r103;
            f377827b = EnumEntriesKt.enumEntries(r103);
        }

        public static CameraStatus[] values() {
            return (CameraStatus[]) f377826a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static CameraStatus valueOf(String r100) {
            return (CameraStatus) r27.a.a(CameraStatus.class, r100);
        }

        public CameraStatus(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f377828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f377829b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<VideoPreviewState, Boolean> f377830c;

        public b() {
            throw null;
        }

        public b(int r100, VoiceCallContentLayout r101) {
            Function1<VideoPreviewState, Boolean> r102 = new f2();
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "restorePredict");
            this.f377828a = r100;
            this.f377829b = r101;
            this.f377830c = r102;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f377831a = null;

        static {
            int[] r100 = new int[VideoPreviewState.values().length];
            r100[VideoPreviewState.close.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[VideoPreviewState.full.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[VideoPreviewState.pip.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f377831a = r100;
        }
    }

    public static final class d implements f09.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RealtimeVideoComponent f377832a;

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            FLogger.f375446a.i("RealtimeVideoComponent", "app enter to background. videoCaptureStarted=" + this.f377832a.D5());
            if (this.f377832a.D5() == false) goto L21;
            this.f377832a.E3().y("onAppBackground");
            if (this.f377832a.i4() == true) goto L7;
            com.larus.voicecall.impl.plugins.o1 r100 = this.f377832a.E3().z();
            if (r100 == null) goto L19;
            r100.N();
        L19:
            this.f377832a.Y = true;
            return;
        L7:
            if (z2.f365865a.isRealtimeVideoBackgroundPublishEnable() == false) goto L13;
            com.larus.voicecall.impl.plugins.o1 r101 = this.f377832a.E3().z();
            if (r101 == null) goto L13;
            com.larus.im.service.audio.z r102 = r101.e();
            if (r102 == null) goto L13;
            r102.u();
        L13:
            com.larus.voicecall.impl.component.vlm.camera.camera_state.f r103 = this.f377832a.G3();
            if (r103 == null) goto L19;
            r103.closeCamera();
            goto L19
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            FLogger.f375446a.i("RealtimeVideoComponent", "app enter to onAppForeground. videoCaptureStarted=" + this.f377832a.D5() + " shouldResumeWhenAppForeground=" + this.f377832a.Y);
            RealtimeVideoComponent r100 = this.f377832a;
            if (r100.Y == true) goto L5;
            return;
        L5:
            if (r100.i4() == true) goto L7;
            com.larus.voicecall.impl.plugins.o1 r101 = this.f377832a.E3().z();
            if (r101 == null) goto L19;
            r101.V1(this.f377832a.Z3());
        L19:
            RealtimeVideoComponent r102 = this.f377832a;
            if (r102.i4() == false) goto L24;
            com.larus.voicecall.impl.component.vlm.camera.camera_state.f r103 = r102.G3();
            if (r103 == null) goto L27;
            r103.b(Intrinsics.areEqual(r102.N.f379613b.getValue(), Boolean.TRUE));
        L27:
            RealtimeVideoComponent r104 = this.f377832a;
            r104.Y = false;
            r104.E3().y("onAppForeground");
            return;
        L24:
            com.larus.voicecall.impl.plugins.o1 r105 = r102.E3().z();
            if (r105 == null) goto L27;
            r105.b(Intrinsics.areEqual(r102.N.f379613b.getValue(), Boolean.TRUE));
            goto L27
        L7:
            if (z2.f365865a.isRealtimeVideoBackgroundPublishEnable() == false) goto L13;
            com.larus.voicecall.impl.plugins.o1 r106 = this.f377832a.E3().z();
            if (r106 == null) goto L13;
            com.larus.im.service.audio.z r107 = r106.e();
            if (r107 == null) goto L13;
            r107.s();
        L13:
            com.larus.voicecall.impl.component.vlm.camera.camera_state.f r108 = this.f377832a.G3();
            if (r108 == null) goto L19;
            r108.openCamera();
            goto L19
        }

        public d(RealtimeVideoComponent r100) {
            this.f377832a = r100;
        }
    }

    public static final class e implements ZoomableTextureView.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RealtimeVideoComponent f377833a;

        @Override // com.larus.common_ui.view.ZoomableTextureView.c
        public final void b() {
        }

        @Override // com.larus.common_ui.view.ZoomableTextureView.c
        public final void c() {
        }

        @Override // com.larus.common_ui.view.ZoomableTextureView.c
        public final void f() {
        }

        @Override // com.larus.common_ui.view.ZoomableTextureView.c
        public final void a() {
            this.f377833a.L0 = 1.0f;
            FLogger.f375446a.i("RealtimeVideoComponent", "start scale video");
        }

        public e(RealtimeVideoComponent r100) {
            this.f377833a = r100;
        }

        @Override // com.larus.common_ui.view.ZoomableTextureView.c
        public final void d(float r110) {
            FLogger.f375446a.i("RealtimeVideoComponent", "end scale video startScale=1.0 endScale=" + r110);
            if (r110 <= 1.0f) goto L5;
            String r111 = "zoom_in";
        L6:
            String r100 = r111;
            int r112 = com.larus.voicecall.impl.util.x0.f379492a;
            RealtimeVideoComponent r113 = this.f377833a;
            int r101 = RealtimeVideoComponent.f377808g1;
            com.larus.voicecall.impl.util.x0.c(r113.Q3().a(), this.f377833a.B3(), this.f377833a.Q3().f484272m, false, Boolean.valueOf(Intrinsics.areEqual(this.f377833a.N.f379613b.getValue(), Boolean.TRUE)), PinchEnterMethod.PINCH, r100, null, 136);
            return;
        L5:
            r111 = "zoom_out";
            goto L6
        }

        @Override // com.larus.common_ui.view.ZoomableTextureView.c
        public final void e(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            if (this.f377833a.D5() == true) goto L5;
            return;
        L5:
            if (this.f377833a.s6() == false) goto L27;
            RealtimeVideoComponent r101 = this.f377833a;
            if (r101.i4() == false) goto L11;
            com.larus.voicecall.impl.component.vlm.camera.camera_state.f r102 = r101.G3();
            if (r102 == null) goto L14;
            r102.f(r100.getX(), r100.getY());
        L14:
            final RealtimeVideoComponent r103 = this.f377833a;
            g3a.a r104 = r103.H3();
            if (r104 == null) goto L28;
            ZoomableTextureView r105 = r104.iB();
            if (r105 == null) goto L30;
            g3a.a r106 = r103.H3();
            if (r106 == null) goto L29;
            AppCompatImageView r107 = r106.Km();
            if (r107 == null) goto L31;
            r107.setAlpha(0.0f);
            r107.setTranslationX(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r100.getX() - (r107.getMeasuredWidth() / 2), 0.0f), r105.getMeasuredWidth() - r107.getMeasuredWidth()));
            r107.setTranslationY(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r100.getY() - (r107.getMeasuredHeight() / 2), 0.0f), r105.getMeasuredHeight() - r107.getMeasuredHeight()));
            r107.setScaleX(1.0f);
            r107.setScaleY(1.0f);
            ViewPropertyAnimator r108 = r107.animate();
            r108.alpha(1.0f);
            r108.scaleX(0.6f);
            r108.scaleY(0.6f);
            r108.setDuration(300);
            r108.withEndAction(new k1(r103));
            r108.start();
            return;
        L31:
            return;
        L29:
            return;
        L30:
            return;
        L28:
            return;
        L11:
            int r109 = m2.f377974a;
            Context r110 = r101.getContext();
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r110, "ctx");
            float r111 = r100.getRawX();
            float r112 = r100.getRawY();
            Resources r113 = r110.getResources();
            DisplayMetrics r114 = WindowDisplayMetricsOverride.apply(r113, r113.getDisplayMetrics());
            int r115 = r114.widthPixels;
            float r116 = r112 / r114.heightPixels;
            Pair r117 = TuplesKt.to(Float.valueOf(Math.max(0.0f, Math.min(1.0f, r111 / r115))), Float.valueOf(Math.max(0.0f, Math.min(1.0f, r116))));
            com.larus.voicecall.impl.plugins.o1 r118 = r101.E3().z();
            if (r118 == null) goto L14;
            r118.f(((Number) r117.getFirst()).floatValue(), ((Number) r117.getSecond()).floatValue());
            goto L14
        }

        @Override // com.larus.common_ui.view.ZoomableTextureView.c
        public final void g(float r100, float r101, float r102) {
            RealtimeVideoComponent r103 = this.f377833a;
            if (r100 != r103.L0) goto L5;
            boolean r104 = true;
        L6:
            if (r104 == false) goto L9;
            return;
        L9:
            if (r103.i4() == false) goto L14;
            com.larus.voicecall.impl.component.vlm.camera.camera_state.f r105 = this.f377833a.G3();
            if (r105 == null) goto L22;
            r105.d(r100);
            return;
        L22:
            return;
        L14:
            if (r100 <= this.f377833a.L0) goto L18;
            FLogger.f375446a.i("RealtimeVideoComponent", "zoom_in scaleFactor=" + r100 + " focusX=" + r101 + " focusY=" + r102);
            com.larus.voicecall.impl.plugins.o1 r106 = this.f377833a.E3().z();
            if (r106 == null) goto L24;
            r106.g();
            return;
        L24:
            return;
        L18:
            FLogger.f375446a.i("RealtimeVideoComponent", "zoom_out scaleFactor=" + r100 + " focusX=" + r101 + " focusY=" + r102);
            com.larus.voicecall.impl.plugins.o1 r107 = this.f377833a.E3().z();
            if (r107 == null) goto L26;
            r107.k();
            return;
        L26:
            return;
        L5:
            r104 = false;
            goto L6
        }
    }

    public static final class f implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f377834a;

        public f(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f377834a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f377834a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f377834a.invoke(r100);
        }
    }

    static {
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.f377812n.getValue();
    }

    public static void h4() {
        t3a.g r100 = t3a.g.f544528j.getValue();
        if (r100.f544531c == true) goto L17;
        r100.a();
        return;
    L17:
        t3a.b r101 = r100.f544532d;     // Catch: Exception -> L14
        if (r101 != null) goto L8;
    L12:
        r100.f544532d = null;     // Catch: Exception -> L14
        r100.b();     // Catch: Exception -> L14
        r100.a();     // Catch: Exception -> L14
        r100.f544531c = false;     // Catch: Exception -> L14
        FLogger.f375446a.i("RealtimeVideoGlobalFloatWindow", "global float window hidden");     // Catch: Exception -> L14
        return;
    L8:
        if (r101.f544504l == 0) goto L12;
        if (r101.f544502j == null) goto L12;
        r101.c(r101.f544494b);     // Catch: Exception -> L14
        r101.f544504l = 0;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        FLogger.f375446a.e("RealtimeVideoGlobalFloatWindow", "hide global float window error: " + e.getMessage(), e);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void A2() {
        FLogger.f375446a.d("RealtimeVideoComponent", "onDestroyView");
        if (i4() == true) goto L8;
        com.larus.voicecall.impl.plugins.o1 r100 = E3().z();
        if (r100 == null) goto L9;
        r100.o();
        return;
    L9:
        return;
    }

    public final e3a.a B3() {
        return (e3a.a) this.f377813o.getValue();
    }

    public final com.larus.voicecall.impl.component.bottom.b C3() {
        return (com.larus.voicecall.impl.component.bottom.b) this.f377820u.getValue();
    }

    public final VoiceCallBottomLayout D3() {
        return (VoiceCallBottomLayout) this.C.getValue();
    }

    @Override // naa.b
    public final boolean DZ() {
        if (this.N.f379614c.getValue() != VideoPreviewState.pip) goto L5;
        return true;
    L5:
        return false;
    }

    public final RealtimeCallService E3() {
        return (RealtimeCallService) this.f377814p.getValue();
    }

    public final com.larus.voicecall.impl.component.vlm.camera.camera_state.f G3() {
        return (com.larus.voicecall.impl.component.vlm.camera.camera_state.f) this.L.getValue();
    }

    public final g3a.a H3() {
        return (g3a.a) this.f377819t.getValue();
    }

    public final ImageView IF() {
        return (ImageView) this.A.getValue();
    }

    public final e3a.b Q3() {
        return (e3a.b) this.f377824y.getValue();
    }

    public final boolean R4() {
        boolean r100 = z2.f365865a.getRealtimeCallNewStyleConfig().a();
        if (Q3().f484263d == true) goto L6;
        FLogger.f375446a.i("RealtimeVideoComponent", "shouldUseFloatVideoSubtitle use setting, isMainBot=" + Q3().f484263d + ", settingDefault=" + r100);
        return r100;
    L6:
        RealtimeCallUtil r101 = RealtimeCallUtil.f379424a;
        boolean r102 = Q3().f484263d;
        r101.getClass();
        boolean r103 = RealtimeCallUtil.f(r102);
        Boolean r104 = null;
        if (r103 == false) goto L15;
        com.larus.voicecall.impl.util.t0.f379475a.getClass();
        int r105 = ((Keva) com.larus.voicecall.impl.util.t0.f379476b.getValue()).getInt("VIDEO_SUBTITLE_MODE_WHEN_EXIT_REALTIME", -1);
        if (r105 != 0) goto L11;
        r104 = Boolean.FALSE;
        goto L15
    L11:
        if (r105 != 1) goto L15;
        r104 = Boolean.TRUE;
    L15:
        if (r104 == null) goto L17;
        boolean r106 = r104.booleanValue();
    L18:
        FLogger.f375446a.i("RealtimeVideoComponent", "shouldUseFloatVideoSubtitle use remembered, rememberedMode=" + r104 + ", settingDefault=" + r100 + ", result=" + r106 + ", subtitleEnabled=" + r103 + ", subtitleOpen=" + RealtimeCallUtil.f379461z + ", lastPreviewState=" + this.U + ", isFullVideo=" + Q3().f484277r + ", isPipVideo=" + Q3().f484278s);
        return r106;
    L17:
        r106 = r100;
        goto L18
    }

    public final com.larus.voicecall.impl.component.scene.a V3() {
        return (com.larus.voicecall.impl.component.scene.a) this.f377809J.getValue();
    }

    public final com.larus.voicecall.impl.component.subtitle.a W3() {
        return (com.larus.voicecall.impl.component.subtitle.a) this.f377817r.getValue();
    }

    public final ImageView X3() {
        return (ImageView) this.f377825z.getValue();
    }

    @Override // com.larus.voicecall.impl.component.vlm.b
    public final void X60() {
        if (this.N.f379614c.getValue() != VideoPreviewState.pip) goto L6;
        h4();
        T4(a4(), null);
        return;
    }

    public final boolean Z3() {
        return Intrinsics.areEqual(this.N.f379613b.getValue(), Boolean.TRUE);
    }

    public final TextureView a4() {
        return (TextureView) this.M.getValue();
    }

    public final FrameLayout c4() {
        return (FrameLayout) this.D.getValue();
    }

    public final w3a.k d4() {
        return (w3a.k) this.f377823x.getValue();
    }

    public final VoiceCallTopLayout e4() {
        return (VoiceCallTopLayout) this.E.getValue();
    }

    public final boolean i4() {
        RealtimeCallUtil r100 = RealtimeCallUtil.f379424a;
        AudioSessionType r101 = Q3().f484264e;
        r100.getClass();
        return RealtimeCallUtil.L(r101);
    }

    @Override // naa.b
    public final void ju() {
        q4("openLLMVideo", new z0(this), this.f377811k0);
    }

    @Override // com.larus.voicecall.impl.component.vlm.b
    public final void m20() {
        Intrinsics.checkNotNullParameter("onSubtitleClose", "reason");
        com.larus.voicecall.impl.plugins.o1 r100 = E3().z();
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.D5() != true) goto L7;
    L8:
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("[realtime_ball_video_debug] switchFullMode called, reason=onSubtitleClose, serviceVideoCaptureStarted=");
        r103.append(r101);
        r103.append(", componentVideoCaptureStarted=");
        r103.append(D5());
        r103.append(", previewState=");
        r103.append(this.N.f379614c.getValue());
        r103.append(", runtimeFull=");
        r103.append(Q3().f484277r);
        r103.append(", runtimePip=");
        r103.append(Q3().f484278s);
        r103.append(", subtitleOpen=");
        RealtimeCallUtil.f379424a.getClass();
        r103.append(RealtimeCallUtil.f379461z);
        r102.i("RealtimeVideoComponent", r103.toString());
        if (r101 == false) goto L11;
        com.larus.voicecall.impl.video.n r104 = this.N;
        r104.getClass();
        Intrinsics.checkNotNullParameter("onSubtitleClose", "reason");
        r104.a(VideoPreviewState.full, "onSubtitleClose", new com.larus.voicecall.impl.video.m());
        return;
    L11:
        r102.i("RealtimeVideoComponent", "[realtime_ball_video_debug] switchFullMode skip, reason=onSubtitleClose, videoCaptureStarted=false");
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.f379438h == false) goto L5;
        h4();
    L5:
        RealtimeCallUtil.R = false;
        if (Q3().f484263d == false) goto L9;
        com.larus.voicecall.impl.util.t0 r100 = com.larus.voicecall.impl.util.t0.f379475a;
        boolean r101 = D5();
        r100.getClass();
        ((Keva) com.larus.voicecall.impl.util.t0.f379476b.getValue()).storeBoolean("IS_VIDEO_MODEL_WHEN_EXIT_REALTIME", r101);
    L9:
        if (D5() == false) goto L17;
        String r102 = Q3().a().H;
        if (StringsKt.isBlank(r102) == false) goto L13;
        r102 = "end_call";
    L13:
        j4(r102);
        Job r103 = RealtimeNoticeDialogHelper.f379516b;
        if (r103 == null) goto L16;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L16:
        RealtimeNoticeDialogHelper.f379516b = null;
    L17:
        FLogger.f375446a.i("RealtimeVideoComponent", "onDestroy  videoCaptureStarted=" + D5() + " mainBot=" + Q3().f484263d);
        if (i4() == false) goto L26;
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r104 = G3();
        if (r104 == null) goto L22;
        r104.closeCamera();
    L22:
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r105 = G3();
        if (r105 == null) goto L25;
        r105.onDestroy();
    L25:
        VESDK.enableRefactorRecorder(false);
    L26:
        com.larus.voicecall.impl.plugins.o1 r106 = E3().z();
        if (r106 == null) goto L29;
        r106.m0(true);
    L29:
        AppHost.f326268a.a().c(this.f377815p0);
    }

    public final void p4() {
        VideoPreviewState r100 = this.U;
        boolean r101 = true;
        if (r100 == VideoPreviewState.close) goto L5;
        if (r100 == null) goto L5;
    L11:
        if (this.O == true) goto L13;
    L16:
        FLogger r102 = FLogger.f375446a;
        r102.i("jyt_test", "start video 2 needSwitchModal=" + r101);
        r102.i("jyt_test", "start video 2 end, isSuccess=" + V4(r101));
        this.O = false;
        return;
    L13:
        if (B3().f484245m == false) goto L16;
        r101 = false;
    L5:
        RealtimeNoticeDialogHelper.b();
        ((IRealtimeCallTracer) this.f377821v.getValue()).B(IRealtimeCallTracer.TotalTimeType.VIDEO_SHARE_START_TIME, true);
        ((w3a.k) this.X.getValue()).a(w3a.f.f558197a);
        this.Q = false;
        if (i4() == false) goto L11;
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r103 = G3();
        if (r103 == null) goto L11;
        r103.openCamera();
        goto L11
    }

    @Override // com.larus.voicecall.impl.component.vlm.b, naa.b
    public final boolean s6() {
        if (this.N.f379614c.getValue() != VideoPreviewState.full) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.voicecall.impl.component.vlm.b
    public final boolean xH() {
        return Intrinsics.areEqual(this.N.f379613b.getValue(), Boolean.TRUE);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.vlm.b.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, naa.b.class);
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.larus.voicecall.impl.component.vlm.m0] */
    public RealtimeVideoComponent() {
        this.f377812n = LazyKt.lazy(new g0(this));
        this.f377813o = LazyKt.lazy(new i0(this));
        this.f377814p = LazyKt.lazy(new o0(this));
        this.f377816q = LazyKt.lazy(new p0(this));
        this.f377817r = LazyKt.lazy(new q0(this));
        this.f377818s = LazyKt.lazy(new s0(this));
        this.f377819t = LazyKt.lazy(new t0(this));
        this.f377820u = LazyKt.lazy(new u0(this));
        this.f377821v = LazyKt.lazy(new v0(this));
        this.f377822w = LazyKt.lazy(new w0());
        this.f377823x = LazyKt.lazy(new r0(this));
        this.f377824y = LazyKt.lazy(new c1(this));
        this.f377825z = LazyKt.lazy(new n1(this));
        this.A = LazyKt.lazy(new y1(this));
        this.C = LazyKt.lazy(new a2(this));
        this.D = LazyKt.lazy(new b2(this));
        this.E = LazyKt.lazy(new c2(this));
        this.F = LazyKt.lazy(new d2(this));
        this.I = jd9.c.e.f498761c;
        this.f377809J = LazyKt.lazy(new e2(this));
        this.K = -1;
        this.L = LazyKt.lazy(new h0(this));
        this.M = LazyKt.lazy(new j0(this));
        this.N = new com.larus.voicecall.impl.video.n();
        this.O = true;
        this.P = LazyKt.lazy(new k0(this));
        this.R = new ArrayList();
        this.V = true;
        this.X = LazyKt.lazy(new l0(this));
        this.f377811k0 = new m0(this);
        this.f377815p0 = new d(this);
        this.H0 = true;
        this.L0 = 1.0f;
        this.P0 = new n0(this);
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void A0() {
        getActivity();
        B3();
        E3();
        com.larus.voicecall.impl.component.core.a r100 = (com.larus.voicecall.impl.component.core.a) this.f377816q.getValue();
        W3();
        Q3();
        w3a.k r101 = (w3a.k) this.X.getValue();
        com.larus.voicecall.impl.plugins.o1 r102 = E3().z();
        if (r102 == null) goto L6;
        r102.x2(B3().f484245m);
        return;
    }

    @Override // com.larus.voicecall.impl.component.vlm.b
    public final boolean D5() {
        com.larus.voicecall.impl.plugins.o1 r100 = E3().z();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.D5() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.voicecall.impl.component.vlm.b
    public final void my() {
        if (B3().f484245m == false) goto L9;
        RealtimeCallUtil.f379424a.getClass();
        if (((Boolean) RealtimeCallUtil.f379441i0.getValue()).booleanValue() == false) goto L9;
        com.larus.voicecall.impl.plugins.o1 r100 = E3().z();
        if (r100 == null) goto L11;
        r100.L0(a4(), Z3());
        return;
    L11:
        return;
    L9:
        FLogger.f375446a.e("RealtimeVideoComponent", "tryPreloadVideoCapture but openVLMOnStart is false");
    }

    public static TextureView h3(RealtimeVideoComponent r100) {
        return new TextureView(r100.getActivity());
    }

    public final void B4(VideoPreviewState r100) {
        Iterator r101 = ((ArrayList) this.R).iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        b r102 = (b) r101.next();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "state");
        if (r102.f377830c.invoke(r100).booleanValue() == false) goto L8;
        r102.f377829b.setVisibility(r102.f377828a);
        boolean r103 = true;
    L9:
        if (r103 == false) goto L4;
        FLogger.f375446a.d("RealtimeVideoComponent", "remove snapshot for view id: " + r102.f377829b.getId());
        r101.remove();
        goto L4
    L8:
        r103 = false;
        goto L9
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void D9(com.larus.im.service.audio.z0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        boolean r101 = false;
        if ((r100 instanceof pf9.o) == false) goto L12;
        com.larus.voicecall.impl.plugins.o1 r102 = E3().z();
        if (r102 != null) goto L7;
    L9:
        if (r101 == false) goto L44;
        D5();
        return;
    L44:
        return;
    L7:
        if (r102.y1() != true) goto L9;
        r101 = true;
        goto L9
    L12:
        if ((r100 instanceof pf9.o0) == false) goto L26;
        if (D5() == false) goto L23;
        if (((pf9.o0) r100).f528962a == false) goto L23;
        int r103 = com.larus.voicecall.impl.util.x0.f379492a;
        e3a.b r104 = Q3();
        e3a.a r105 = B3();
        boolean r106 = Intrinsics.areEqual(this.N.f379613b.getValue(), Boolean.TRUE);
        Intrinsics.checkNotNullParameter(r104, "runtimeData");
        Intrinsics.checkNotNullParameter(r105, "argumentData");
        com.larus.platform.service.o r107 = com.larus.platform.service.o.f365780a;
        JSONObject r108 = new JSONObject();
        if (r106 == false) goto L20;
        String r109 = "back_camera";
    L21:
        r108.put("camera_position", r109);
        r108.put("current_page", "chat");
        com.larus.voicecall.impl.util.x0.a(r108, r104.a(), r105);
        Unit r110 = Unit.INSTANCE;
        r107.reportEvent("enter_video_call", r108);
        B3().f470940h1 = false;
        return;
    L20:
        r109 = "front_camera";
    L23:
        if (D5() == false) goto L47;
        StringBuilder r111 = new StringBuilder("videoCaptureStarted=");
        r111.append(D5());
        r111.append(" isSuccess=");
        pf9.o0 r112 = (pf9.o0) r100;
        r111.append(r112.f528962a);
        k4(-1, -1, true, r111.toString());
        FLogger.f375446a.e("RealtimeVideoComponent", "server enter video call failed! videoCaptureStarted=" + D5() + " isSuccess=" + r112.f528962a);
        return;
    L47:
        return;
    L26:
        if ((r100 instanceof pf9.l0) == false) goto L49;
        boolean r113 = z2.f365865a.hasFaceMemoryFunc();
        boolean r114 = AccountService.f365697a.a();
        if (r113 == false) goto L39;
        if (r114 == true) goto L39;
        if (this.Z == false) goto L34;
        return;
    L34:
        this.Z = true;
        int r115 = VideoFaceMemoryAuthDialog.f379566g;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentManager r116 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragmentManager();
        Map r117 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r116, "fragmentManager");
        Intrinsics.checkNotNullParameter(r117, "params");
        VideoFaceMemoryAuthDialog r118 = new VideoFaceMemoryAuthDialog();
        LandscapeRestrictionOperation r119 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r118, "face_auth", r119);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r116, r118, r119) == true) goto L51;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L41
    L38:
        r118.show(r116, "face_auth");
        return;
    L51:
        return;
    L39:
        FLogger.f375446a.i("RealtimeVideoComponent", "[ignore_video_face_toast_event]:hasFaceMemoryFunc=" + r113 + " or isInMinorMode=" + r114);
        return;
    }

    public final void F4(boolean r100) {
        com.larus.voicecall.impl.component.bottom.b r101 = C3();
        if (r101 == null) goto L7;
        VoiceCallBottomLayout r102 = r101.BT();
        if (r102 == null) goto L7;
        r102.i8(r100, Q3().f484275p, Q3().f484276q);
    L7:
        m3a.a r103 = (m3a.a) this.f377818s.getValue();
        if (r103 == null) goto L13;
        VoiceCallTopLayout r104 = r103.Fv();
        if (r104 == null) goto L14;
        r104.U5(r100, Q3().f484275p, Q3().f484276q);
        return;
    L14:
        return;
    }

    public final void G4(boolean r100) {
        FrameLayout r101 = c4();
        if (r101 == null) goto L18;
        ArrayList r102 = new ArrayList();
        i2 r103 = new i2(r101);
    L6:
        if (r103.hasNext() == false) goto L10;
        View r104 = r103.next();
        if ((!Intrinsics.areEqual(r104, a4())) == false) goto L6;
        r102.add(r104);
        goto L6
    L10:
        Iterator r105 = r102.iterator();
    L12:
        if (r105.hasNext() == false) goto L27;
        View r106 = (View) r105.next();
        if (r100 == false) goto L16;
        int r107 = 0;
    L17:
        r106.setVisibility(r107);
        goto L12
    L16:
        r107 = 8;
        goto L17
    L27:
        return;
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void I6(jd9.c r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        boolean r101 = r100 instanceof jd9.c.a;
        boolean r102 = false;
        if (r101 == true) goto L5;
    L21:
        this.I = r100;
        if (r101 == true) goto L24;
    L26:
        boolean r103 = r100 instanceof jd9.c.d;
        if (r103 == false) goto L29;
        this.G = true;
    L29:
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.E() == false) goto L56;
        if (r103 == true) goto L33;
    L35:
        com.larus.voicecall.impl.component.bottom.b r104 = C3();
        if (r104 == null) goto L38;
        VoiceCallBottomLayout r105 = r104.BT();
    L39:
        if (r101 == false) goto L49;
        if (r105 == null) goto L57;
        com.larus.av_call.view.b r106 = r105.getRightDynamicButton();
        if (r106 != null) goto L44;
        return;
    L44:
        if (this.K == 7) goto L46;
        r102 = true;
    L46:
        h88.d r107 = r106.f290644c;
        if (r107 == null) goto L59;
        r107.a(r102);
        return;
    L59:
        return;
    L57:
        return;
    L49:
        if (r105 == null) goto L61;
        com.larus.av_call.view.b r108 = r105.getRightDynamicButton();
        if (r108 == null) goto L62;
        h88.d r109 = r108.f290644c;
        if (r109 == null) goto L63;
        r109.a(false);
        return;
    L63:
        return;
    L62:
        return;
    L61:
        return;
    L38:
        r105 = null;
        goto L39
    L33:
        if (D5() == false) goto L35;
        p3(ExitVideoModalReason.EXIT_FOR_DISCONNECT, true);
        this.H = true;
        j4("lose_internet_connection");
        goto L35
    L56:
        return;
    L24:
        if (this.W == true) goto L26;
        this.W = true;
        E3().y("onConnectionStateChanged");
        goto L26
    L5:
        if (z2.f365865a.O1() == false) goto L21;
        if (this.G == false) goto L21;
        if (D5() == false) goto L14;
        com.larus.voicecall.impl.plugins.o1 r110 = E3().z();
        if (r110 == null) goto L20;
        r110.r0();
    L20:
        FLogger.f375446a.i("RealtimeVideoComponent", "onConnectionStateChanged videoCaptureStarted=" + D5() + " isScreenShare=" + Q3().f484279t + " hasPendingCloseVideo=" + this.H);
        this.H = false;
        goto L21
    L14:
        if (Q3().f484279t == true) goto L20;
        if (this.H == false) goto L20;
        com.larus.voicecall.impl.plugins.o1 r111 = E3().z();
        if (r111 == null) goto L20;
        r111.v2();
        goto L20
    }

    @Override // naa.b
    public final void PW(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (D5() == false) goto L6;
        ExitVideoModalReason r101 = ExitVideoModalReason.O_EXIT_VIDEO_MODAL;
        p3(r101, true);
        j4(r101.getStr());
        return;
    }

    public final boolean V4(boolean r100) {
        String r101 = null;
        boolean r102 = false;
        if (i4() == false) goto L21;
        RealtimeCallUtil.f379424a.getClass();
        if (((Boolean) RealtimeCallUtil.f379454s.getValue()).booleanValue() == false) goto L21;
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r103 = G3();
        if (r103 == null) goto L9;
        r3a.l r104 = r103.getCurrentState();
    L11:
        if ((r104 instanceof com.larus.voicecall.impl.component.vlm.camera.camera_state.a) == false) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == false) goto L21;
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r106 = G3();
        if (r106 == null) goto L21;
        r106.openCamera();
        goto L21
    L13:
        if ((r104 instanceof com.larus.voicecall.impl.component.vlm.camera.camera_state.b) == true) goto L16;
        r105 = false;
        goto L17
    L9:
        r104 = null;
    L21:
        com.larus.voicecall.impl.plugins.o1 r107 = E3().z();
        if (r107 == null) goto L24;
        r102 = r107.M2(a4(), r100, Z3());
    L24:
        if (r102 == false) goto L33;
        int r108 = com.larus.voicecall.impl.util.x0.f379492a;
        e3a.b r109 = Q3();
        e3a.a r110 = B3();
        Intrinsics.checkNotNullParameter(r109, "runtimeData");
        Intrinsics.checkNotNullParameter(r110, "argumentData");
        com.larus.platform.service.o r111 = com.larus.platform.service.o.f365780a;
        JSONObject r112 = new JSONObject();
        r112.put("current_page", "chat");
        RealtimeCallParam.c r113 = r109.a().f288756p.f288867o;
        if (r113 == null) goto L28;
        String r114 = r113.f288780a;
    L29:
        r112.put(LiveTutorHomeVM.ACTION_BAR_ITEM_ID, r114);
        RealtimeCallParam.c r115 = r109.a().f288756p.f288867o;
        if (r115 == null) goto L32;
        r101 = r115.f288783d;
    L32:
        r112.put("action_bar_key", r101);
        com.larus.voicecall.impl.util.x0.a(r112, r109.a(), r110);
        Unit r116 = Unit.INSTANCE;
        r111.reportEvent("start_video_capture", r112);
        goto L33
    L28:
        r114 = null;
    L33:
        return r102;
    }

    @Override // com.larus.voicecall.impl.component.vlm.b
    public final void Y80(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (D5() == true) goto L6;
        FLogger.f375446a.e("RealtimeVideoComponent", "switchPopMode but videoCaptureStarted is false");
        return;
    L6:
        com.larus.voicecall.impl.video.n r101 = this.N;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "reason");
        r101.a(VideoPreviewState.pip, r100, new com.larus.voicecall.impl.video.j());
    }

    public final void j4(String r100) {
        if (this.Q == true) goto L6;
        ((IRealtimeCallTracer) this.f377821v.getValue()).k0(r100, Q3().a(), Intrinsics.areEqual(this.N.f379613b.getValue(), Boolean.TRUE), B3());
        this.Q = true;
        return;
    }

    public final void l4(boolean r100) {
        int r101 = com.larus.voicecall.impl.util.x0.f379492a;
        e3a.b r102 = Q3();
        e3a.a r103 = B3();
        Intrinsics.checkNotNullParameter(r102, "runtimeData");
        Intrinsics.checkNotNullParameter(r103, "argumentData");
        com.larus.platform.service.o r104 = com.larus.platform.service.o.f365780a;
        JSONObject r105 = new JSONObject();
        r105.put("current_page", "chat");
        com.larus.voicecall.impl.util.x0.a(r105, r102.a(), r103);
        r105.put("is_ve_capture", r100 ? 1 : 0);
        Unit r106 = Unit.INSTANCE;
        r104.reportEvent("video_call_first_frame", r105);
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner()), Dispatchers.getMain(), null, new RealtimeVideoComponent$onFirstFrameCapture$1(this, null), 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [com.larus.voicecall.impl.component.vlm.h1] */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.larus.voicecall.impl.component.vlm.r1] */
    /* JADX WARN: Type inference failed for: r4v9, types: [com.larus.voicecall.impl.component.vlm.i1] */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.larus.voicecall.impl.component.vlm.m1] */
    @Override // com.larus.av_call.component.RealtimeComponent, com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        FLogger r101 = FLogger.f375446a;
        r101.d("RealtimeVideoComponent", "onViewCreated width=" + r100.getWidth() + " height=" + r100.getHeight());
        z2 r102 = z2.f365865a;
        final boolean r103 = r102.getRealtimeCallNewStyleConfig().b();
        if (r103 == false) goto L8;
        ImageView r104 = X3();
        if (r104 == null) goto L8;
        r104.setImageResource(R.drawable.larus_ic_switch_camera);
    L8:
        if (r102.realtimeTalkbackOptEnable() == true) goto L10;
    L17:
        ImageView r105 = X3();
        if (r105 == null) goto L20;
        com.larus.utils.e1.d(r105, new e1(this, r103));
    L20:
        com.larus.voicecall.impl.plugins.o1 r106 = E3().z();
        if (r106 == null) goto L23;
        r106.A1(new f1(this));
    L23:
        ((w3a.k) this.X.getValue()).c(new k2(this));
        com.larus.voicecall.impl.component.bottom.b r107 = C3();
        if (r107 == null) goto L28;
        VoiceCallBottomLayout r108 = r107.BT();
        if (r108 == null) goto L28;
        r108.setLLMVideoBtnClickListener(new g1(this));
    L28:
        FrameLayout r109 = c4();
        boolean r110 = false;
        if (r109 == null) goto L31;
        r109.addView(a4(), 0, new ViewGroup.LayoutParams(-1, -1));
    L31:
        RealtimeCallUtil.f379424a.getClass();
        if (((Boolean) RealtimeCallUtil.f379441i0.getValue()).booleanValue() == true) goto L37;
        FrameLayout r111 = c4();
        if (r111 == null) goto L37;
        com.larus.utils.e1.q(r111);
    L37:
        if (i4() == false) goto L47;
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r112 = G3();
        if (r112 == null) goto L41;
        r112.m(a4());
    L41:
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r113 = G3();
        if (r113 == 0) goto L44;
        r113.j(new h1(this));
    L44:
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r114 = G3();
        if (r114 == 0) goto L47;
        r114.q(new i1(this));
    L47:
        MutableLiveData<Boolean> r115 = this.N.f379613b;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r115.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), new f(new l1(this)));
        com.larus.voicecall.impl.component.core.a r116 = (com.larus.voicecall.impl.component.core.a) this.f377816q.getValue();
        if (r116 == 0) goto L51;
        r116.yK(new m1(this));
    L51:
        if (B3().f484245m == false) goto L68;
        FrameLayout r117 = c4();
        if (r117 == null) goto L56;
        r117.setBackgroundResource(R.color.larus_static_black);
    L56:
        if (((Boolean) this.f377822w.getValue()).booleanValue() == false) goto L61;
        Pair<Boolean, Boolean> r118 = com.larus.voicecall.impl.l.f378359i;
        if (i3.f365750a.i() == false) goto L61;
        boolean r119 = false;
    L62:
        Pair<Boolean, Boolean> r120 = com.larus.voicecall.impl.l.f378359i;
        if (com.larus.voicecall.impl.l.a.b(getActivity()) == false) goto L68;
        if (r119 == false) goto L68;
        com.larus.voicecall.impl.component.core.a r121 = (com.larus.voicecall.impl.component.core.a) this.f377816q.getValue();
        if (r121 == null) goto L68;
        r121.tF("videoWrapper_onViewCreated", false, new o1());
    L61:
        r119 = true;
    L68:
        com.larus.voicecall.impl.plugins.o1 r122 = E3().z();
        if (r122 == null) goto L71;
        r122.r2(new p1(this));
    L71:
        MutableLiveData<VideoPreviewState> r123 = this.N.f379614c;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r123.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), new f(new q1(this)));
        com.larus.voicecall.impl.plugins.o1 r124 = E3().z();
        if (r124 == 0) goto L74;
        r124.W0(new r1(this));
    L74:
        StringBuilder r125 = new StringBuilder("[flashlight_debug] setupFlashlight, flashlightIconNull=");
        if (IF() != null) goto L77;
        r110 = true;
    L77:
        r125.append(r110);
        r125.append(", initialVisibility=");
        ImageView r126 = IF();
        Boolean r127 = null;
        if (r126 == null) goto L80;
        Integer r128 = Integer.valueOf(r126.getVisibility());
    L81:
        r125.append(r128);
        r125.append(", initialSelected=");
        ImageView r129 = IF();
        if (r129 == null) goto L84;
        r127 = Boolean.valueOf(r129.isSelected());
    L84:
        r125.append(r127);
        r125.append(", isVeCaptureEnable=");
        r125.append(i4());
        r125.append(", useTwoLine=");
        r125.append(r102.realtimeCallUseTwoLineStyle());
        r101.i("RealtimeVideoComponent", r125.toString());
        ImageView r130 = IF();
        if (r130 == null) goto L88;
        com.larus.utils.e1.d(r130, new j1(this));
    L88:
        if (RealtimeCallUtil.f379438h == false) goto L90;
        t3a.g.f544528j.getValue().f544537i = this.P0;
    L91:
        AppHost.f326268a.a().j(this.f377815p0);
        if (B3().f484245m == false) goto L94;
        int r131 = com.larus.voicecall.impl.util.x0.f379492a;
        com.larus.voicecall.impl.util.x0.d(Q3(), B3(), e6.f552469a.b());
    L94:
        g3a.a r132 = H3();
        if (r132 == null) goto L100;
        ZoomableTextureView r133 = r132.iB();
        if (r133 == null) goto L101;
        r133.setGestureListener(new e(this));
        return;
    L101:
        return;
    L100:
        return;
    L90:
        com.larus.voicecall.impl.video.y r134 = (com.larus.voicecall.impl.video.y) this.P.getValue();
        Function0<Unit> r135 = new a1(this);
        r134.getClass();
        Intrinsics.checkNotNullParameter(r135, "action");
        r134.f379633i = r135;
        goto L91
    L80:
        r128 = null;
        goto L81
    L10:
        if (Intrinsics.areEqual(this.N.f379613b.getValue(), Boolean.TRUE) == false) goto L14;
        ImageView r136 = X3();
        if (r136 == null) goto L17;
        r136.setContentDescription(getContext().getString(R.string.larus_accessibility_icon_flipCameraBack));
        goto L17
    L14:
        ImageView r137 = X3();
        if (r137 == null) goto L17;
        r137.setContentDescription(getContext().getString(R.string.larus_accessibility_icon_flipCameraFront));
        goto L17
    }

    public final Object z3(Continuation<? super Boolean> r100) {
        z2 r101 = z2.f365865a;
        boolean r102 = false;
        if (r101.getRealtimeCallNewStyleConfig().e() == true) goto L6;
        FLogger.f375446a.i("RealtimeVideoComponent", "[flashlight_debug] enableFlashlight=false, reason=useFlashlight_config_false, isCameraBack=" + this.N.f379613b.getValue() + ", previewState=" + this.N.f379614c.getValue() + ", videoCaptureStarted=" + D5() + ", useTwoLine=" + r101.realtimeCallUseTwoLineStyle());
    L18:
        return Boxing.boxBoolean(r102);
    L6:
        if (i4() == false) goto L20;
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r103 = G3();
        if (r103 != null) goto L10;
    L12:
        boolean r104 = false;
    L13:
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("[flashlight_debug] enableFlashlight check ve, result=");
        r106.append(r104);
        r106.append(", isTorchSupported=");
        r106.append(r104);
        r106.append(", isCameraBack=");
        r106.append(this.N.f379613b.getValue());
        r106.append(", previewState=");
        r106.append(this.N.f379614c.getValue());
        r106.append(", videoCaptureStarted=");
        r106.append(D5());
        r106.append(", cameraManagerNull=");
        if (G3() != null) goto L16;
        r102 = true;
    L16:
        r106.append(r102);
        r105.i("RealtimeVideoComponent", r106.toString());
        r102 = r104;
        goto L18
    L10:
        if (r103.isCameraTorchSupported() != true) goto L12;
        r104 = true;
        goto L13
    L20:
        return BuildersKt.withContext(Dispatchers.getIO(), new RealtimeVideoComponent$enableFlashlight$2(this, null), r100);
    }

    public static final boolean m3(RealtimeVideoComponent r100, String r101) {
        r100.getClass();
        if (Intrinsics.areEqual(r101, "switch_camera") == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.areEqual(r101, "close_video") == true) goto L10;
        if (Intrinsics.areEqual(r101, "pip_video_view") == true) goto L10;
        return false;
    }

    public final boolean T4(View r100, t3a.e r101) {
        Intrinsics.checkNotNullParameter(r100, "videoView");
    L18:
        e = move-exception;
        FLogger.f375446a.e("RealtimeVideoComponent", "show global float window error: " + e.getMessage(), e);
        return false;
    L4:
        if (z2.f365865a.D0() == false) goto L6;
        t3a.g.f544528j.getValue().f544537i = this.P0;     // Catch: Exception -> L18
    L6:
        FLogger.f375446a.i("RealtimeVideoComponent", "show global float window");     // Catch: Exception -> L18
        if (r101 != null) goto L9;
        r101 = new t3a.e(0);     // Catch: Exception -> L18
    L9:
        boolean r102 = t3a.g.f544528j.getValue().c(r100, r101);     // Catch: Exception -> L18
        if (r102 == false) goto L23;
        int r103 = r101.f544522a;     // Catch: Exception -> L18
        int r104 = r101.f544523b;     // Catch: Exception -> L18
        VEDisplaySettings.VEDisplayFitMode r105 = VEDisplaySettings.VEDisplayFitMode.SCALE_MODE_CENTER_CROP;     // Catch: Exception -> L18
        if (i4() == false) goto L23;
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r106 = G3();     // Catch: Exception -> L18
        if (r106 == null) goto L23;
        r106.e(r103, r104, r105);     // Catch: Exception -> L18
    L23:
        return r102;
    }

    @Override // com.larus.voicecall.impl.component.vlm.b
    public final void c30(ExitVideoModalReason r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (D5() == false) goto L6;
        p3(r100, r101);
        j4(r100.getStr());
        return;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.voicecall.impl.component.vlm.x0] */
    public final void p3(ExitVideoModalReason r100, final boolean r101) {
        if (r100 == ExitVideoModalReason.OPEN_SHARE_SCREEN) goto L5;
    L7:
        boolean r102 = com.bytedance.apm.util.u.a();
        final ?? r103 = new x0(this, r101);
        if (r102 == false) goto L10;
        r103.run();
        return;
    L10:
        a4().post(new y0(r103));
        return;
    L5:
        if (B3().f484243k0 == false) goto L7;
        this.H0 = false;
        goto L7
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void z2(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r100, "event");
        if (Intrinsics.areEqual(r100, "OTHER_EVENT_RTC_FIRST_LOCAL_VIDEO_FRAME_CAPTURED") == false) goto L6;
        com.larus.platform.service.o r102 = com.larus.platform.service.o.f365780a;
        JSONObject r103 = new JSONObject();
        r103.put("duration", -1);
        r103.put("camera_type", "rtc");
        Unit r104 = Unit.INSTANCE;
        r102.reportEvent("flow_video_capture_first_frame", r103);
        return;
    L6:
        if (Intrinsics.areEqual(r100, "OTHER_EVENT_RTC_VIDEO_STOPPED") == false) goto L28;
    L22:
        th = move-exception;
        FLogger.f375446a.e("RealtimeVideoComponent", "otherEvent err event=" + r100 + ", content=" + r101);
        StringBuilder r105 = new StringBuilder("video on error. msg=");
        r105.append(th);
        EnsureManager.ensureNotReachHere(r105.toString());
        return;
    L8:
        if ((r101 instanceof String) == false) goto L11;
        String r106 = (String) r101;     // Catch: Throwable -> L22
    L13:
        if (r106 != null) goto L15;
        r106 = "";
    L15:
        JSONObject r107 = new JSONObject(r106);     // Catch: Throwable -> L22
        int r108 = JSONObjectProtectorUtils.getInt(r107, "device_state");     // Catch: Throwable -> L22
        int r109 = JSONObjectProtectorUtils.getInt(r107, "device_error");     // Catch: Throwable -> L22
        if (D5() == true) goto L18;
        return;
    L18:
        if (r108 != 3) goto L30;
        if (r109 <= 0) goto L31;
        k4(r108, r109, false, "");     // Catch: Throwable -> L22
        FLogger.f375446a.e("RealtimeVideoComponent", "exit video call for rtc error. payload=" + r101);     // Catch: Throwable -> L22
        c30(ExitVideoModalReason.EXIT_FOR_RTC_ERROR, true);     // Catch: Throwable -> L22
        return;
    L31:
        return;
    L30:
        return;
    L11:
        r106 = null;
        goto L13
    }

    public final void q4(String r110, Function0 r111, m0 r112) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)), Dispatchers.getMain().plus(new h2(CoroutineExceptionHandler.Key, r110, this)), null, new RealtimeVideoComponent$requestCameraPermission$2(this, r110, r111, r112, null), 2, null);
    }

    public final void v4(boolean r110, String r111, long r112) {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("[flashlight_debug] resetFlashlightIcon request, show=");
        r101.append(r110);
        r101.append(", reason=");
        r101.append(r111);
        r101.append(", delayTime=");
        r101.append(r112);
        r101.append(", oldJobActive=");
        Job r102 = this.B;
        if (r102 == null) goto L5;
        Boolean r103 = Boolean.valueOf(r102.isActive());
    L6:
        r101.append(r103);
        r101.append(", oldVisibility=");
        ImageView r104 = IF();
        if (r104 == null) goto L9;
        Integer r105 = Integer.valueOf(r104.getVisibility());
    L10:
        r101.append(r105);
        r101.append(", oldSelected=");
        ImageView r106 = IF();
        if (r106 == null) goto L13;
        Boolean r107 = Boolean.valueOf(r106.isSelected());
    L14:
        r101.append(r107);
        r101.append(", isCameraBack=");
        r101.append(this.N.f379613b.getValue());
        r101.append(", previewState=");
        r101.append(this.N.f379614c.getValue());
        r101.append(", videoCaptureStarted=");
        r101.append(D5());
        r100.i("RealtimeVideoComponent", r101.toString());
        Job r108 = this.B;
        if (r108 == null) goto L17;
        Job.DefaultImpls.cancel$default(r108, null, 1, null);
    L17:
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.B = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner()), null, null, new RealtimeVideoComponent$resetFlashlightIcon$1(r112, this, r110, r111, null), 3, null);
        return;
    L13:
        r107 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public final void k4(int r100, int r101, boolean r102, String r103) {
        com.larus.platform.service.o r104 = com.larus.platform.service.o.f365780a;
        JSONObject r105 = new JSONObject();
        r105.put("is_checkout_modal_error", r102);
        r105.put("error_msg", r103);
        r105.put("device_state", r100);
        r105.put("device_error", r101);
        r105.put("modal_type", "video_call");
        int r106 = com.larus.voicecall.impl.util.x0.f379492a;
        com.larus.voicecall.impl.util.x0.a(r105, Q3().a(), B3());
        Unit r107 = Unit.INSTANCE;
        r104.reportEvent("realtime_vlm_call_error", r105);
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void o1(MajorState r100, int r101, MajorState r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "currentMajorState");
        Intrinsics.checkNotNullParameter(r102, "newMajorState");
        super.o1(r100, r101, r102, r103);
        if (r103 != 14) goto L5;
        return;
    L5:
        if (r103 == 15) goto L9;
        this.K = r103;
        return;
    }
}
