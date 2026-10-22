package com.enroll.audio.enroll.view;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProvider;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.enroll.audio.enroll.animation.AnimationType;
import com.enroll.audio.enroll.model.TeamEnrollState;
import com.enroll.audio.enroll.model.TeamMember;
import com.enroll.audio.enroll.model.TeamState;
import com.enroll.audio.enroll.resource.VoicePrintResourceManager;
import com.enroll.audio.enroll.vm.EnrollViewModel;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import kotlinx.coroutines.w1;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b>\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 Ì\u00012\u00020\u00012\u00020\u0002:\u0002Ì\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\fJ\u000e\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020&J\b\u0010q\u001a\u00020ZH\u0014J\b\u0010r\u001a\u00020ZH\u0014J\u000e\u0010s\u001a\u00020Z2\u0006\u0010t\u001a\u00020uJ\u0010\u0010v\u001a\u00020Z2\u0006\u0010w\u001a\u00020xH\u0014J$\u0010y\u001a\u00020Z2\u0006\u0010z\u001a\u00020{2\u0014\b\u0002\u0010|\u001a\u000e\u0012\u0004\u0012\u00020~\u0012\u0004\u0012\u00020\u007f0}J7\u0010\u0080\u0001\u001a\u00020Z2\u0007\u0010\u0081\u0001\u001a\u00020k2\u0006\u0010z\u001a\u00020{2\u0007\u0010\u0082\u0001\u001a\u00020G2\u0014\b\u0002\u0010|\u001a\u000e\u0012\u0004\u0012\u00020~\u0012\u0004\u0012\u00020\u007f0}J%\u0010\u0083\u0001\u001a\u00020Z2\u0006\u0010z\u001a\u00020{2\u0014\b\u0002\u0010|\u001a\u000e\u0012\u0004\u0012\u00020~\u0012\u0004\u0012\u00020\u007f0}J\u0011\u0010\u0087\u0001\u001a\u00020Z2\u0006\u0010w\u001a\u00020xH\u0014J\u0010\u0010D\u001a\u00020Z2\u0006\u0010w\u001a\u00020xH\u0002J\t\u0010\u0088\u0001\u001a\u00020GH\u0002J\t\u0010\u0089\u0001\u001a\u00020GH\u0002J\u0010\u0010\u008a\u0001\u001a\u00020Z2\u0007\u0010\u008b\u0001\u001a\u00020EJ\t\u0010\u008c\u0001\u001a\u00020ZH\u0002J\u0019\u0010\u008d\u0001\u001a\u00020Z2\u0007\u0010\u008e\u0001\u001a\u00020\b2\u0007\u0010\u008f\u0001\u001a\u00020\bJ\t\u0010\u0090\u0001\u001a\u00020GH\u0002J\t\u0010\u0091\u0001\u001a\u00020GH\u0002J\u001b\u0010\u0092\u0001\u001a\u00020Z2\u0007\u0010\u008e\u0001\u001a\u00020\b2\u0007\u0010\u008f\u0001\u001a\u00020\bH\u0002J-\u0010\u0093\u0001\u001a\u00020Z2\u0007\u0010\u0094\u0001\u001a\u00020k2\u0007\u0010\u0082\u0001\u001a\u00020G2\u0007\u0010\u0095\u0001\u001a\u00020G2\u0007\u0010\u0096\u0001\u001a\u00020GH\u0002J-\u0010\u0097\u0001\u001a\u00020Z2\u0007\u0010\u0094\u0001\u001a\u00020k2\u0007\u0010\u0082\u0001\u001a\u00020G2\u0007\u0010\u0098\u0001\u001a\u00020G2\u0007\u0010\u0099\u0001\u001a\u00020GH\u0002J\u0010\u0010\u009a\u0001\u001a\u00020G2\u0007\u0010\u0094\u0001\u001a\u00020kJ\u0010\u0010\u009b\u0001\u001a\u00020G2\u0007\u0010\u0094\u0001\u001a\u00020kJ\u0010\u0010\u009c\u0001\u001a\u00020G2\u0007\u0010\u0094\u0001\u001a\u00020kJ\u0010\u0010\u009d\u0001\u001a\u00020G2\u0007\u0010\u009e\u0001\u001a\u00020kJ1\u0010\u009f\u0001\u001a\u00020Z2\u0007\u0010\u0094\u0001\u001a\u00020k2\u0007\u0010\u0082\u0001\u001a\u00020G2\t\b\u0002\u0010\u009e\u0001\u001a\u00020G2\t\b\u0002\u0010 \u0001\u001a\u00020GH\u0002J\u0007\u0010¡\u0001\u001a\u00020ZJ\u0007\u0010¢\u0001\u001a\u00020ZJ\u0007\u0010£\u0001\u001a\u00020ZJ\u0007\u0010¤\u0001\u001a\u00020~J\u0010\u0010¦\u0001\u001a\u00020Z2\u0007\u0010§\u0001\u001a\u00020(J\u001e\u0010¨\u0001\u001a\u00020Z2\u0006\u0010\\\u001a\u00020/2\u000b\b\u0002\u0010©\u0001\u001a\u0004\u0018\u00010\u007fH\u0002J\t\u0010ª\u0001\u001a\u00020ZH\u0002J\t\u0010«\u0001\u001a\u00020ZH\u0002J\t\u0010¬\u0001\u001a\u00020ZH\u0002J\t\u0010\u00ad\u0001\u001a\u00020ZH\u0002J\"\u0010®\u0001\u001a\u00020Z2\u0007\u0010¯\u0001\u001a\u00020/2\u0007\u0010°\u0001\u001a\u00020/H\u0082@¢\u0006\u0003\u0010±\u0001J\t\u0010²\u0001\u001a\u00020ZH\u0002J\t\u0010³\u0001\u001a\u00020ZH\u0002J\u0010\u0010´\u0001\u001a\u00020ZH\u0082@¢\u0006\u0003\u0010µ\u0001J\r\u0010¸\u0001\u001a\u00020\b*\u00020~H\u0002J\r\u0010¹\u0001\u001a\u00020~*\u00020~H\u0002J\u001b\u0010º\u0001\u001a\u00020E2\u0007\u0010»\u0001\u001a\u00020~2\u0007\u0010¼\u0001\u001a\u00020~H\u0002J\u0011\u0010½\u0001\u001a\u00030¾\u00012\u0007\u0010\u009e\u0001\u001a\u00020kJ\u001a\u0010¿\u0001\u001a\u00020Z2\b\u0010À\u0001\u001a\u00030¾\u00012\u0007\u0010Á\u0001\u001a\u00020GJ\r\u0010Â\u0001\u001a\b\u0012\u0004\u0012\u00020l0iJ\u0017\u0010Ã\u0001\u001a\u00020Z2\u000e\u0010Ä\u0001\u001a\t\u0012\u0004\u0012\u00020Z0Å\u0001J\u0012\u0010Æ\u0001\u001a\u00020Z2\u0007\u0010Ç\u0001\u001a\u00020GH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00105\"\u0004\b:\u00107R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\u000e\u0010D\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010M\u001a\u00020N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bO\u0010PR\u000e\u0010S\u001a\u00020TX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010U\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\u001cR\u0014\u0010W\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bX\u0010\u001cR\u001a\u0010\\\u001a\u00020]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0011\u0010b\u001a\u00020c¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u0011\u0010f\u001a\u00020c¢\u0006\b\n\u0000\u001a\u0004\bg\u0010eR \u0010h\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00020l0j0iX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020lX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020lX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020lX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020lX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0084\u0001\u001a\u00020N8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0086\u0001\u0010R\u001a\u0005\b\u0085\u0001\u0010PR\u000f\u0010¥\u0001\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010¶\u0001\u001a\u00020\b8F¢\u0006\u0007\u001a\u0005\b·\u0001\u0010\u001cR\u0018\u0010È\u0001\u001a\u00030É\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÊ\u0001\u0010Ë\u0001¨\u0006Í\u0001"}, d2 = {"Lcom/enroll/audio/enroll/view/EnrollTeamView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/lifecycle/LifecycleOwner;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "enrollHandleContext", "Lkotlin/coroutines/CoroutineContext;", "enrollHandleScope", "Lkotlinx/coroutines/CoroutineScope;", "enrollProgressContext", "enrollProgressScope", "viewModel", "Lcom/enroll/audio/enroll/vm/EnrollViewModel;", "getViewModel", "()Lcom/enroll/audio/enroll/vm/EnrollViewModel;", "historyLength", "index", "getIndex", "()I", "setIndex", "(I)V", ST.UUID_DEVICE, "Ljava/util/UUID;", "getUuid", "()Ljava/util/UUID;", "setUuid", "(Ljava/util/UUID;)V", WikiSpaceType.TEAM, "Lcom/enroll/audio/enroll/model/EnrollTeam;", "asrResponse", "Lcom/enroll/audio/enroll/asr/AsrResponse;", "getAsrResponse", "()Lcom/enroll/audio/enroll/asr/AsrResponse;", "setAsrResponse", "(Lcom/enroll/audio/enroll/asr/AsrResponse;)V", "enrollState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/enroll/audio/enroll/model/TeamEnrollState;", "getEnrollState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "timeoutTimer", "Landroid/os/CountDownTimer;", "getTimeoutTimer", "()Landroid/os/CountDownTimer;", "setTimeoutTimer", "(Landroid/os/CountDownTimer;)V", "sentenceAsrTimer", "getSentenceAsrTimer", "setSentenceAsrTimer", "asrTimerJob", "Lkotlinx/coroutines/Job;", "getAsrTimerJob", "()Lkotlinx/coroutines/Job;", "setAsrTimerJob", "(Lkotlinx/coroutines/Job;)V", "checkingTimerJob", "getCheckingTimerJob", "setCheckingTimerJob", "drawHalo", "", "haloX", "", "haloY", "mLastHoloX", "mLastHoloY", "handlerThread", "Landroid/os/HandlerThread;", "haloPaint", "Landroid/graphics/Paint;", "getHaloPaint", "()Landroid/graphics/Paint;", "haloPaint$delegate", "Lkotlin/Lazy;", "mHandler", "Landroid/os/Handler;", "totalTravelDistanceX", "getTotalTravelDistanceX", "totalTravelDistanceY", "getTotalTravelDistanceY", "setTeam", "", "t", "state", "Lcom/enroll/audio/enroll/model/TeamState;", "getState", "()Lcom/enroll/audio/enroll/model/TeamState;", "setState", "(Lcom/enroll/audio/enroll/model/TeamState;)V", "haloImage", "Landroid/graphics/Bitmap;", "getHaloImage", "()Landroid/graphics/Bitmap;", "arcImage", "getArcImage", "subTitleViews", "", "Lkotlin/Pair;", "Lcom/enroll/audio/enroll/model/TeamMember;", "Landroid/widget/TextView;", "titleView", "subTitleViewLine1", "subTitleViewLine2", "subTitleViewLine3", "onAttachedToWindow", "onDetachedFromWindow", "releaseAsrResource", "callback", "Lcom/enroll/audio/enroll/BtHeadsetAsrCallback;", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "onAnimationStart", "animatorType", "Lcom/enroll/audio/enroll/animation/AnimationType;", "args", "", "", "", "onAnimationUpdate", "member", "fraction", "onAnimationEnd", "arcBitmapPaint", "getArcBitmapPaint", "arcBitmapPaint$delegate", "onDraw", "imageStartX", "imageStartY", "setHoloVisible", "visible", "resetHoloPos", "setHaloProgress", "current", "total", "imageEndX", "imageEndY", "onHaloProgressChanged", "onScale", "teamMember", "fromScale", "targetScale", "onAlpha", "fromAlpha", "targetAlpha", "getOnStagedTranslateStartY", "getOnStagedTranslateEndY", "getOnDoneTranslateEndY", "getOnDoneTranslateStartY", "from", "onBlur", PickerReporterConstants.KEY.TARGET, "onCandidateReset", "onStageReset", "prepare", "asrTaskUuid", "hasNetworkErrorInAsr", "onAsrResponseStream", "resp", "updateEnrollState", "data", "startTimeout", "cancelTimeout", "restartAsrTimer", "cancelAsrTimer", "onEnrollStateChanged", "oldState", "newState", "(Lcom/enroll/audio/enroll/model/TeamEnrollState;Lcom/enroll/audio/enroll/model/TeamEnrollState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onWholePageTimeout", "onSentenceAsrTimeout", EventConstant.Value.RETRY, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "textLines", "getTextLines", "validLength", "rawText", "checkSimilarity", "text", "given", "findView", "Landroid/view/View;", "updateBlur", "view", "value", "getTextViews", "animateHaloToInvisible", "end", "Lkotlin/Function0;", "updateHaloAlpha", "alpha", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnrollTeamView extends ConstraintLayout implements LifecycleOwner {
    public static final Lazy<List<Integer>> F = null;
    public final TextView A;
    public final TextView B;
    public final TextView C;
    public final Lazy D;
    public boolean E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleRegistry f273903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f273904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineScope f273905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EnrollViewModel f273906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f273907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f273908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UUID f273909g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public jt7.g f273910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ct7.a f273911i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final StateFlowImpl f273912j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CountDownTimer f273913k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CountDownTimer f273914l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Job f273915m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Job f273916n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f273917o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f273918p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f273919q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f273920r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f273921s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f273922t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Handler f273923u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TeamState f273924v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Bitmap f273925w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Bitmap f273926x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<Pair<TeamMember, TextView>> f273927y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final TextView f273928z;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f273929a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f273930b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f273931c = null;

        static {
            int[] r100 = new int[AnimationType.values().length];
            r100[AnimationType.FADE_IN_TO_CANDIDATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L91:
            r100[AnimationType.FROM_CANDIDATE_TO_STAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L103:
            r100[AnimationType.FROM_STAGE_TO_DONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L8:
            f273929a = r100;
            int[] r101 = new int[TeamMember.values().length];
            r101[TeamMember.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L38
        L93:
            r101[TeamMember.TITLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L39
        L105:
            r101[TeamMember.UPPER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L40
        L61:
            r101[TeamMember.MIDDLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L41
        L73:
            r101[TeamMember.LOWER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L42
        L16:
            f273930b = r101;
            int[] r102 = new int[TeamEnrollState.values().length];
            r102[TeamEnrollState.BORN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L43
        L63:
            r102[TeamEnrollState.ENROLLING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L44
        L77:
            r102[TeamEnrollState.OVERSIZE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L45
        L87:
            r102[TeamEnrollState.NOT_START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L46
        L95:
            r102[TeamEnrollState.CHECKING_SIMILARITY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L47
        L65:
            r102[TeamEnrollState.SIMILARITY_FAIL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L48
        L89:
            r102[TeamEnrollState.SIMILARITY_PASS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L49
        L101:
            r102[TeamEnrollState.EDITTING_VOICE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L50
        L59:
            r102[TeamEnrollState.EDIT_VOICE_SUCCESS.ordinal()] = 9;     // Catch: NoSuchFieldError -> L51
        L75:
            r102[TeamEnrollState.EDIT_VOICE_FAILED.ordinal()] = 10;     // Catch: NoSuchFieldError -> L52
        L99:
            r102[TeamEnrollState.CHECKING_ENROLL.ordinal()] = 11;     // Catch: NoSuchFieldError -> L53
        L69:
            r102[TeamEnrollState.ENROLL_MATCHED.ordinal()] = 12;     // Catch: NoSuchFieldError -> L54
        L71:
            r102[TeamEnrollState.ENROLL_NOT_MATCHED_NETWORK_ERROR.ordinal()] = 13;     // Catch: NoSuchFieldError -> L55
        L85:
            r102[TeamEnrollState.ENROLL_NOT_MATCHED_COMMON_ERROR.ordinal()] = 14;     // Catch: NoSuchFieldError -> L56
        L67:
            r102[TeamEnrollState.TIMEOUT.ordinal()] = 15;     // Catch: NoSuchFieldError -> L57
        L81:
            r102[TeamEnrollState.DONE.ordinal()] = 16;     // Catch: NoSuchFieldError -> L58
        L33:
            f273931c = r102;
        }
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EnrollTeamView f273932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f273933b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f273934c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f273935d;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            EnrollTeamView r101 = this.f273932a;
            r101.f273920r = this.f273933b.element;
            r101.f273921s = this.f273934c.element;
            this.f273935d.countDown();
        }

        public c(EnrollTeamView r100, Ref.IntRef r101, Ref.IntRef r102, CountDownLatch r103) {
            this.f273932a = r100;
            this.f273933b = r101;
            this.f273934c = r102;
            this.f273935d = r103;
        }
    }

    private final int getTotalTravelDistanceX() {
        return Math.abs(((int) 0.0f) - ((int) b6()));
    }

    private final int getTotalTravelDistanceY() {
        return Math.abs(((int) 0.0f) - ((int) c6()));
    }

    public final void u6() {
        setHoloVisible(false);
        H6(-1, -1);
        this.f273918p = b6();
        this.f273919q = c6();
    }

    static {
        F = LazyKt.lazy(new x());
    }

    private final Paint getArcBitmapPaint() {
        return (Paint) this.D.getValue();
    }

    private final Paint getHaloPaint() {
        return (Paint) this.f273922t.getValue();
    }

    public final String T5() {
        UUID r100 = this.f273909g;
        if (r100 != null) goto L5;
        UUID r101 = UUID.randomUUID();
        this.f273909g = r101;
        return String.valueOf(r101);
    L5:
        return String.valueOf(r100);
    }

    public final void U5() {
        FLogger.f375446a.i("EnrollTeamView", "------ cancelAsrTimer ------");
        Job r100 = this.f273915m;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        CountDownTimer r101 = this.f273914l;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f273914l = null;
        this.f273915m = null;
    }

    public final void V5() {
        FLogger.f375446a.i("EnrollTeamView", "------ cancelTimeout ------");
        CountDownTimer r100 = this.f273913k;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f273913k = null;
    }

    public final float b6() {
        return this.f273906d.getLeftBorderLine() - (this.f273925w.getWidth() / 2);
    }

    public final float c6() {
        return ((this.f273906d.getNeckGuideLine() - this.f273906d.getTopGuideLine()) * 2) - this.f273925w.getHeight();
    }

    public final int getTextLines() {
        jt7.g r100 = this.f273910h;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
        r100 = null;
    L6:
        return 1 + r100.c();
    }

    public final List<TextView> getTextViews() {
        ArrayList r100 = new ArrayList();
        r100.add(this.f273928z);
        jt7.g r101 = this.f273910h;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
        r101 = null;
    L5:
        int r102 = r101.c();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L17;
        if (r103 != 0) goto L9;
        r100.add(this.A);
    L16:
        r103 = r103 + 1;
        goto L6
    L9:
        if (r103 != 1) goto L11;
        r100.add(this.B);
        goto L16
    L11:
        if (r103 != 2) goto L16;
        r100.add(this.C);
        goto L16
    L17:
        return r100;
    }

    public final void n6() {
        FLogger r100 = FLogger.f375446a;
        r100.i("EnrollTeamView", "onCandidateReset");
        int r101 = Math.abs(this.f273906d.getTopGuideLine() - this.f273906d.getFootGuideLine());
        r100.i("EnrollTeamView", "onCandidateReset offsetY = " + r101);
        this.f273928z.setTextSize(((Number) et7.h.f473932b.getValue()).floatValue());
        float r102 = (float) r101;
        this.f273928z.setTranslationY(r102);
        Iterator r103 = ((ArrayList) this.f273927y).iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L13;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        TextView r107 = (TextView) ((Pair) r105).getSecond();
        r107.setTextSize(((Number) et7.h.f473933c.getValue()).floatValue());
        if (r104 != 0) goto L11;
        r107.setTranslationY(((((Number) et7.h.f473935e.getValue()).floatValue() * r106) * 0.9f) + r102);
    L12:
        r104 = r106;
        goto L4
    L11:
        r107.setTranslationY(((((Number) et7.h.f473935e.getValue()).floatValue() * r106) * 0.9f) + r102);
        goto L12
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        FLogger.f375446a.i("EnrollTeamView", "onAttachedToWindow");
        this.f273903a.setCurrentState(Lifecycle.State.STARTED);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FLogger.f375446a.i("EnrollTeamView", "onDetachedFromWindow");
        this.f273903a.setCurrentState(Lifecycle.State.CREATED);
        V5();
        U5();
    }

    public final Bitmap getArcImage() {
        return this.f273926x;
    }

    public final ct7.a getAsrResponse() {
        return this.f273911i;
    }

    public final Job getAsrTimerJob() {
        return this.f273915m;
    }

    public final Job getCheckingTimerJob() {
        return this.f273916n;
    }

    public final z0<TeamEnrollState> getEnrollState() {
        return this.f273912j;
    }

    public final Bitmap getHaloImage() {
        return this.f273925w;
    }

    public final int getIndex() {
        return this.f273908f;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.f273903a;
    }

    public final CountDownTimer getSentenceAsrTimer() {
        return this.f273914l;
    }

    public final TeamState getState() {
        return this.f273924v;
    }

    public final CountDownTimer getTimeoutTimer() {
        return this.f273913k;
    }

    public final UUID getUuid() {
        return this.f273909g;
    }

    public final EnrollViewModel getViewModel() {
        return this.f273906d;
    }

    public EnrollTeamView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final Object C6(Continuation<? super Unit> r100) {
        if ((r100 instanceof EnrollTeamView$retry$1) == false) goto L7;
        EnrollTeamView$retry$1 r101 = (EnrollTeamView$retry$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        V6(this, TeamEnrollState.ENROLLING);
        this.f273906d.reportEvent(jt7.m.f500332a);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        this.f273906d.reportEvent(jt7.n.f500333a);
        u6();
        r101.label = 1;
        if (DelayKt.delay(500, r101) != r104) goto L17;
        return r104;
    L7:
        r101 = new EnrollTeamView$retry$1(this, r100);
        goto L8
    }

    public final void S5(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "end");
        setHoloVisible(false);
        getHaloPaint().setAlpha((int) (255 * 1.0f));
        postInvalidate();
        ((q) r100).invoke();
    }

    public final View Y5(TeamMember r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        int r101 = b.f273930b[r100.ordinal()];
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L23;
        if (r101 == 3) goto L22;
        if (r101 == 4) goto L21;
        if (r101 != 5) goto L14;
        return this.C;
    L14:
        throw new NoWhenBranchMatchedException();
    L21:
        return this.B;
    L22:
        return this.A;
    L23:
        return this.f273928z;
    L19:
        return this;
    }

    public final float Z5(TeamMember r100) {
        Intrinsics.checkNotNullParameter(r100, "teamMember");
        float r101 = this.f273906d.getNeckGuideLine();
        if (r100 != TeamMember.ALL) goto L5;
        return r101;
    L5:
        if (r100 == TeamMember.TITLE) goto L29;
        Iterator r102 = ((ArrayList) this.f273927y).iterator();
    L9:
        if (r102.hasNext() == false) goto L16;
        Object r103 = r102.next();
        if (((Pair) r103).getFirst() != r100) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L9;
    L17:
        Pair r105 = (Pair) r103;
        if (r105 != null) goto L22;
        return 0.0f;
    L22:
        return r101 + (((Number) et7.h.f473936f.getValue()).floatValue() * ((TeamMember) r105.getFirst()).getOrder());
    L13:
        r104 = false;
        goto L14
    L16:
        r103 = null;
        goto L17
    L29:
        return r101;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        if (this.f273917o == true) goto L6;
        return;
    L6:
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        getHaloPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN));
    L12:
        r100.drawBitmap(this.f273925w, this.f273918p, this.f273919q, getHaloPaint());
        return;
    L11:
        getHaloPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
        goto L12
    L8:
        r101 = false;
        goto L9
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        setBackgroundResource(R.color.enroll_transaction_color);
        super.onDraw(r100);
    }

    public final String s6(String r110) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r110, "$", "", false, 4, null), ",", "", false, 4, null), " ", "", false, 4, null), "，", "", false, 4, null), "。", "", false, 4, null), "？", "", false, 4, null), "“", "", false, 4, null), "”", "", false, 4, null);
    }

    public final void setAsrResponse(ct7.a r100) {
        this.f273911i = r100;
    }

    public final void setAsrTimerJob(Job r100) {
        this.f273915m = r100;
    }

    public final void setCheckingTimerJob(Job r100) {
        this.f273916n = r100;
    }

    public final void setHoloVisible(boolean r100) {
        this.f273917o = r100;
    }

    public final void setIndex(int r100) {
        this.f273908f = r100;
    }

    public final void setSentenceAsrTimer(CountDownTimer r100) {
        this.f273914l = r100;
    }

    public final void setState(TeamState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f273924v = r100;
    }

    public final void setTeam(jt7.g r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
        this.f273910h = r100;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(WikiSpaceType.TEAM);
        r100 = null;
    L5:
        int r101 = r100.c();
        if (r101 != 1) goto L8;
        this.A.setVisibility(0);
        this.B.setVisibility(8);
        this.C.setVisibility(8);
        return;
    L8:
        if (r101 != 2) goto L10;
        this.A.setVisibility(0);
        this.B.setVisibility(0);
        this.C.setVisibility(8);
        return;
    L10:
        if (r101 != 3) goto L13;
        this.A.setVisibility(0);
        this.B.setVisibility(0);
        this.C.setVisibility(0);
        return;
    L13:
        throw new RuntimeException("invalid subtitleLines");
    }

    public final void setTimeoutTimer(CountDownTimer r100) {
        this.f273913k = r100;
    }

    public final void setUuid(UUID r100) {
        this.f273909g = r100;
    }

    public EnrollTeamView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public static void R5(final EnrollTeamView r100, Message r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r101.what != 0) goto L22;
        FLogger r102 = FLogger.f375446a;
        r102.i("EnrollTeamView", "EVENT_UPDATE_HALO got " + r101.arg1 + " / " + r101.arg2);
        int r103 = r101.arg1;
        int r104 = r101.arg2;
        float r105 = ((float) r103) / ((float) r104);
        if (r103 == 0) goto L20;
        if (r103 != r104) goto L11;
        if (r103 == (-1)) goto L20;
    L11:
        if (r105 <= 1.0f) goto L13;
        r105 = 1.0f;
    L13:
        final Ref.IntRef r106 = new Ref.IntRef();
        r106.element = ((int) r100.b6()) + ((int) (r100.getTotalTravelDistanceX() * r105));
        final Ref.IntRef r107 = new Ref.IntRef();
        r107.element = ((int) r100.c6()) + ((int) (r100.getTotalTravelDistanceY() * r105));
        final CountDownLatch r108 = new CountDownLatch(1);
        if (r107.element <= 0) goto L17;
        r107.element = 0;
    L17:
        if (r106.element <= 0) goto L19;
        r106.element = 0;
    L19:
        new Handler(Looper.getMainLooper()).post(new y(r100, r106, r107, r108));
        r108.await();
        return;
    L20:
        r102.i("EnrollTeamView", "EVENT_UPDATE_HALO reset from given -1 , -1");
        r100.f273920r = r100.b6();
        r100.f273921s = r100.c6();
        r100.f273918p = r100.b6();
        r100.f273919q = r100.c6();
        r100.postInvalidate();
        return;
    }

    public static void V6(EnrollTeamView r100, TeamEnrollState r101) {
        TeamEnrollState r102 = (TeamEnrollState) r100.f273912j.getValue();
        FLogger.f375446a.i("EnrollTeamView", "onEnrollStateUpdate to " + r101 + ' ');
        r100.f273912j.setValue(r101);
        BuildersKt.launch$default(r100.f273904b, null, null, new EnrollTeamView$updateEnrollState$1(r100, r102, r101, null), 3, null);
    }

    public static void i6(EnrollTeamView r100, AnimationType r101) {
        Map r102 = MapsKt.emptyMap();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "animatorType");
        Intrinsics.checkNotNullParameter(r102, "args");
        int r103 = b.f273929a[r101.ordinal()];
        if (r103 != 1) goto L5;
        r100.f273924v = TeamState.CANDIDATE;
        V6(r100, TeamEnrollState.NOT_START);
        return;
    L5:
        if (r103 != 2) goto L7;
        r100.f273924v = TeamState.ONSTAGE;
        V6(r100, TeamEnrollState.BORN);
        V6(r100, TeamEnrollState.ENROLLING);
        return;
    L7:
        if (r103 != 3) goto L10;
        r100.f273924v = TeamState.DONE;
        r100.setVisibility(8);
        V6(r100, TeamEnrollState.DONE);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void H6(int r100, int r101) {
        FLogger.f375446a.i("EnrollTeamView", "setHaloProgress [" + r100 + '/' + r101 + ']');
        this.f273923u.obtainMessage(0, r100, r101).sendToTarget();
    }

    public final void N6(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if ((r100 instanceof TextView) == false) goto L5;
        TextView r102 = (TextView) r100;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        float r103 = 0.001f;
        if (r101 >= 0.001f) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        int r105 = kt7.c.f506070a;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        FLogger.f375446a.i("EnrollFileUtils", "setBlur radius: clear");
        r102.getPaint().setMaskFilter(null);
        r102.postInvalidate();
        return;
    L14:
        kt7.c.c(r102, r103);
        return;
    L11:
        r103 = r101;
        r104 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r7v8, types: [com.enroll.audio.enroll.view.u, java.lang.Object] */
    public EnrollTeamView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f273903a = new LifecycleRegistry(this);
        this.f273904b = CoroutineScopeKt.CoroutineScope(w1.a(1, "enrollHandleContext").plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f273905c = CoroutineScopeKt.CoroutineScope(w1.a(1, "enrollProgressContext").plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f273906d = (EnrollViewModel) new ViewModelProvider((FragmentActivity) r100).get(EnrollViewModel.class);
        this.f273908f = -1;
        this.f273912j = j1.a(TeamEnrollState.NOT_START);
        PthreadHandlerThreadV2 r103 = new PthreadHandlerThreadV2("team-enroll-halo");
        ThreadMethodProxy.start(r103);
        this.f273922t = LazyKt.lazy(new s());
        this.f273923u = new Handler(r103.getLooper(), new t(this));
        this.f273924v = TeamState.NA;
        ArrayList r104 = new ArrayList();
        this.f273927y = r104;
        ViewGroup.inflate(r100, R.layout.enroll_enroll_team_view, this);
        TextView r105 = (TextView) findViewById(R.id.stage_main_text);
        if (r105 != null) goto L5;
        r105 = new TextView(r100, r101);
    L5:
        this.f273928z = r105;
        TextView r106 = (TextView) findViewById(R.id.stage_sub_text_line1);
        if (r106 != null) goto L8;
        r106 = new TextView(r100, r101);
    L8:
        this.A = r106;
        TextView r107 = (TextView) findViewById(R.id.stage_sub_text_line2);
        if (r107 != null) goto L11;
        r107 = new TextView(r100, r101);
    L11:
        this.B = r107;
        TextView r108 = (TextView) findViewById(R.id.stage_sub_text_line3);
        if (r108 != null) goto L14;
        r108 = new TextView(r100, r101);
    L14:
        this.C = r108;
        r104.add(TuplesKt.to(TeamMember.UPPER, r106));
        r104.add(TuplesKt.to(TeamMember.MIDDLE, r107));
        r104.add(TuplesKt.to(TeamMember.LOWER, r108));
        int r109 = com.enroll.audio.enroll.e.f273728a;
        ?? r110 = new u(this);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r110, "closure");
        if (getViewTreeObserver().isAlive() == false) goto L17;
        getViewTreeObserver().addOnPreDrawListener(new com.enroll.audio.enroll.d(this, r110));
    L17:
        r105.setTextSize(((Number) et7.h.f473932b.getValue()).floatValue());
        Iterator r111 = r104.iterator();
    L19:
        if (r111.hasNext() == false) goto L21;
        ((TextView) ((Pair) r111.next()).getSecond()).setTextSize(((Number) et7.h.f473933c.getValue()).floatValue());
        goto L19
    L21:
        int r112 = (int) r100.getResources().getDimension(R.dimen.enroll_enroll_halo_size);
        VoicePrintResourceManager.f273781a.getClass();
        Bitmap r113 = VoicePrintResourceManager.c(r112, r112);
        if (r113 != null) goto L24;
        r113 = Bitmap.createBitmap(RangesKt.coerceAtLeast(r112, 1), RangesKt.coerceAtLeast(r112, 1), Bitmap.Config.ARGB_8888);
    L24:
        this.f273925w = r113;
        int r114 = r112 / 30;
        Bitmap r115 = VoicePrintResourceManager.c(RangesKt.coerceAtLeast(r114, 1), RangesKt.coerceAtLeast(r114, 1));
        if (r115 != null) goto L27;
        r115 = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    L27:
        this.f273926x = r115;
        FLogger.f375446a.i("EnrollTeamView", "init halo bitmapSize=" + r112 + " halo=" + r113.getWidth() + Permission.EXECUTE + r113.getHeight() + " arc=" + r115.getWidth() + Permission.EXECUTE + r115.getHeight());
        this.f273903a.setCurrentState(Lifecycle.State.CREATED);
        this.D = LazyKt.lazy(new v());
    }

    public final void o6(TeamMember r100, float r101, float r102) {
        float r103 = 0.6f + ((r102 - 0.6f) * r101);
        int r104 = b.f273930b[r100.ordinal()];
        if (r104 != 1) goto L5;
        this.f273928z.setScaleX(r103);
        this.f273928z.setScaleY(r103);
        Iterator r105 = ((ArrayList) this.f273927y).iterator();
    L31:
        if (r105.hasNext() == false) goto L42;
        TextView r106 = (TextView) ((Pair) r105.next()).getSecond();
        r106.setScaleX(r103);
        r106.setScaleY(r103);
        goto L31
    L42:
        return;
    L5:
        if (r104 != 2) goto L7;
        this.f273928z.setScaleX(r103);
        this.f273928z.setScaleY(r103);
        return;
    L7:
        if (r104 != 3) goto L9;
    L15:
        List<Pair<TeamMember, TextView>> r107 = this.f273927y;
        ArrayList r108 = new ArrayList();
        Iterator r109 = ((ArrayList) r107).iterator();
    L17:
        if (r109.hasNext() == false) goto L24;
        Object r110 = r109.next();
        if (((Pair) r110).getFirst() != r100) goto L21;
        boolean r111 = true;
    L22:
        if (r111 == false) goto L17;
        r108.add(r110);
        goto L17
    L21:
        r111 = false;
        goto L22
    L24:
        Iterator r112 = r108.iterator();
    L26:
        if (r112.hasNext() == false) goto L41;
        TextView r113 = (TextView) ((Pair) r112.next()).getSecond();
        r113.setScaleX(r103);
        r113.setScaleY(r103);
        goto L26
    L41:
        return;
    L9:
        if (r104 == 4) goto L15;
        if (r104 == 5) goto L15;
        throw new NoWhenBranchMatchedException();
    }

    public static void k6(EnrollTeamView r100, TeamMember r101, AnimationType r102, float r103) {
        Map r104 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r101, "member");
        Intrinsics.checkNotNullParameter(r102, "animatorType");
        Intrinsics.checkNotNullParameter(r104, "args");
        int r105 = b.f273929a[r102.ordinal()];
        if (r105 == 1) goto L11;
        if (r105 != 2) goto L6;
        r100.o6(r101, r103, 1.0f);
        return;
    L6:
        if (r105 != 3) goto L9;
        return;
    L9:
        throw new NoWhenBranchMatchedException();
    L11:
        float r106 = (0.15f * r103) + 0.0f;
        int r107 = b.f273930b[r101.ordinal()];
        if (r107 == 1) goto L28;
        if (r107 == 2) goto L27;
        List<Pair<TeamMember, TextView>> r108 = r100.f273927y;
        ArrayList r109 = new ArrayList();
        Iterator r110 = ((ArrayList) r108).iterator();
    L16:
        if (r110.hasNext() == false) goto L23;
        Object r111 = r110.next();
        if (((Pair) r111).getFirst() != r101) goto L20;
        boolean r112 = true;
    L21:
        if (r112 == false) goto L16;
        r109.add(r111);
        goto L16
    L20:
        r112 = false;
        goto L21
    L23:
        Iterator r113 = r109.iterator();
    L25:
        if (r113.hasNext() == false) goto L32;
        ((TextView) ((Pair) r113.next()).getSecond()).setAlpha(r106);
    L32:
        r100.o6(r101, r103, 0.6f);
        return;
    L27:
        r100.f273928z.setAlpha(r106);
        goto L32
    L28:
        r100.f273928z.setAlpha(r106);
        Iterator r114 = ((ArrayList) r100.f273927y).iterator();
    L30:
        if (r114.hasNext() == false) goto L32;
        ((TextView) ((Pair) r114.next()).getSecond()).setAlpha(r106);
        goto L30
    }
}
