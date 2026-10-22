package com.larus.voicecall.impl.component.subtitle;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.keva.Keva;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.plugins.a1;
import com.larus.audio.call.subtitle.SubtitleAction;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.av_call.constant.ThemeType;
import com.larus.common_ui.widget.roundlayout.CustomRoundImageView;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.SafeExtKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.voicecall.impl.RealtimeCallService;
import com.larus.voicecall.impl.subtitle.RealtimeCallSubtitleLayout;
import com.larus.voicecall.impl.subtitle.SubtitleListUpdateType;
import com.larus.voicecall.impl.subtitle.q0;
import com.larus.voicecall.impl.ui.VoiceCallBgLayout;
import com.larus.voicecall.impl.ui.VoiceCallContentLayout;
import com.larus.voicecall.impl.ui.utils.NewThemeSwitchAvatar;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.util.t0;
import com.larus.voicecall.impl.util.y0;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;
import v19.c7;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ¥\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002¥\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010j\u001a\u00020kH\u0016J\u0010\u0010l\u001a\u00020k2\u0006\u0010m\u001a\u00020nH\u0016J\b\u0010o\u001a\u00020kH\u0016J\u0010\u0010p\u001a\u00020k2\u0006\u0010q\u001a\u00020rH\u0016J\u0010\u0010s\u001a\u00020k2\u0006\u0010t\u001a\u00020iH\u0002J\b\u0010u\u001a\u00020kH\u0002J\u0018\u0010v\u001a\u00020k2\u0006\u0010q\u001a\u00020w2\u0006\u0010x\u001a\u00020yH\u0002J\u0018\u0010z\u001a\b\u0012\u0004\u0012\u00020|0{2\b\u0010}\u001a\u0004\u0018\u00010~H\u0002J\b\u0010\u007f\u001a\u00020kH\u0016J\u0013\u0010\u0080\u0001\u001a\u00020k2\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0016J\u001c\u0010\u0083\u0001\u001a\u00020k2\u0007\u0010\u0084\u0001\u001a\u00020i2\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0016J\u001c\u0010\u0085\u0001\u001a\u00020k2\u0007\u0010\u0086\u0001\u001a\u00020i2\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0016J\t\u0010\u0087\u0001\u001a\u00020iH\u0016J\t\u0010\u0088\u0001\u001a\u00020iH\u0016J\u0012\u0010\u0089\u0001\u001a\u00020k2\u0007\u0010\u0084\u0001\u001a\u00020iH\u0002J\t\u0010\u008a\u0001\u001a\u00020kH\u0002J\u001c\u0010\u008b\u0001\u001a\u00020k2\u000b\b\u0002\u0010\u008c\u0001\u001a\u0004\u0018\u00010iH\u0002¢\u0006\u0003\u0010\u008d\u0001J\t\u0010\u008e\u0001\u001a\u00020kH\u0002J\u0019\u0010\u008f\u0001\u001a\u00020k2\u000e\u0010\u0090\u0001\u001a\t\u0012\u0005\u0012\u00030\u0091\u00010{H\u0016J\u001f\u0010\u0092\u0001\u001a\u00020k2\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0016J'\u0010\u0096\u0001\u001a\u0004\u0018\u00010S2\u0014\u0010\u0097\u0001\u001a\u000f\u0012\u0004\u0012\u00020y\u0012\u0004\u0012\u00020i0\u0098\u0001H\u0016¢\u0006\u0003\u0010\u0099\u0001J\u0013\u0010\u009a\u0001\u001a\u00020k2\b\u0010\u009b\u0001\u001a\u00030\u0082\u0001H\u0016J/\u0010\u009c\u0001\u001a\u00020k2\b\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020S2\b\u0010 \u0001\u001a\u00030\u009e\u00012\u0007\u0010¡\u0001\u001a\u00020SH\u0016J\t\u0010¢\u0001\u001a\u00020kH\u0016J\u000b\u0010£\u0001\u001a\u0004\u0018\u00010gH\u0016J\t\u0010¤\u0001\u001a\u00020kH\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000b\u001a\u0004\b1\u00102R\u001d\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u000b\u001a\u0004\b6\u00107R\u001d\u00109\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u000b\u001a\u0004\b;\u0010<R\u001d\u0010>\u001a\u0004\u0018\u00010?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u000b\u001a\u0004\b@\u0010AR\u001d\u0010C\u001a\u0004\u0018\u00010D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u000b\u001a\u0004\bE\u0010FR\u001d\u0010H\u001a\u0004\u0018\u00010I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u000b\u001a\u0004\bJ\u0010KR\u001d\u0010M\u001a\u0004\u0018\u00010N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\u000b\u001a\u0004\bO\u0010PR\u000e\u0010R\u001a\u00020SX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010T\u001a\u0004\u0018\u00010U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010\u000b\u001a\u0004\bV\u0010WR\u001d\u0010Y\u001a\u0004\u0018\u00010Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010\u000b\u001a\u0004\b[\u0010\\R\u001d\u0010^\u001a\u0004\u0018\u00010_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010\u000b\u001a\u0004\b`\u0010aR\u001b\u0010c\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010\u000b\u001a\u0004\bd\u0010FR\u0010\u0010f\u001a\u0004\u0018\u00010gX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020iX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¦\u0001"}, d2 = {"Lcom/larus/voicecall/impl/component/subtitle/RealtimeSubtitleComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/subtitle/IRealtimeSubtitleAbility;", "Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderActionProvider;", "<init>", "()V", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "callParam", "Lcom/larus/audio/call/RealtimeCallParam;", "getCallParam", "()Lcom/larus/audio/call/RealtimeCallParam;", "callParam$delegate", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "tracer", "Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "getTracer", "()Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "tracer$delegate", "contentAbility", "Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "getContentAbility", "()Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "contentAbility$delegate", "sceneAbility", "Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "getSceneAbility", "()Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "sceneAbility$delegate", "coreAbility", "Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "getCoreAbility", "()Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "coreAbility$delegate", "topAbility", "Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "getTopAbility", "()Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "topAbility$delegate", "bottomAbility", "Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "getBottomAbility", "()Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "bottomAbility$delegate", "vlmAbility", "Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "getVlmAbility", "()Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "vlmAbility$delegate", "videoSubtitleAbility", "Lcom/larus/voicecall/impl/component/videosubtitle/IVideoSubtitleAbility;", "getVideoSubtitleAbility", "()Lcom/larus/voicecall/impl/component/videosubtitle/IVideoSubtitleAbility;", "videoSubtitleAbility$delegate", "viewStateManager", "Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "getViewStateManager", "()Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "viewStateManager$delegate", "windowAbility", "Lcom/larus/voicecall/impl/component/window/IRealtimeWindowAbility;", "getWindowAbility", "()Lcom/larus/voicecall/impl/component/window/IRealtimeWindowAbility;", "windowAbility$delegate", "feedbackAbility", "Lcom/larus/voicecall/impl/component/feedback/IRealtimeCallFeedbackAbility;", "getFeedbackAbility", "()Lcom/larus/voicecall/impl/component/feedback/IRealtimeCallFeedbackAbility;", "feedbackAbility$delegate", "curUiState", "", "voiceCallSubtitleLayout", "Lcom/larus/voicecall/impl/subtitle/RealtimeCallSubtitleLayout;", "getVoiceCallSubtitleLayout", "()Lcom/larus/voicecall/impl/subtitle/RealtimeCallSubtitleLayout;", "voiceCallSubtitleLayout$delegate", "voiceCallContentLayout", "Lcom/larus/voicecall/impl/ui/VoiceCallContentLayout;", "getVoiceCallContentLayout", "()Lcom/larus/voicecall/impl/ui/VoiceCallContentLayout;", "voiceCallContentLayout$delegate", "subtitleButton", "Lcom/larus/common_ui/widget/roundlayout/CustomRoundImageView;", "getSubtitleButton", "()Lcom/larus/common_ui/widget/roundlayout/CustomRoundImageView;", "subtitleButton$delegate", "stateManager", "getStateManager", "stateManager$delegate", "subtitleViewModel", "Lcom/larus/voicecall/impl/subtitle/RealtimeCallSubtitleViewModel;", "floatSubtitleMode", "", "onAttach", "", "onConnectionStateChanged", "state", "Lcom/larus/im/internal/audio/context/SessionState;", "onVContextReady", "onViewCreated", "view", "Landroid/view/View;", "onSubtitleChange", "toOpen", "setupSubtitleListener", "tryShowPopupMenu", "Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;", "data", "Lcom/larus/voicecall/impl/subtitle/DisplaySubtitleData;", "buildSubtitleMenuItems", "", "Lcom/larus/bmhome/view/screenmenu/abs/IMenuItem;", "message", "Lcom/larus/im/bean/message/Message;", "onSubtitleButtonClick", "closeSubtitle", "reason", "", "openSubtitle", "isAuto", "switchSubtitle", "floatSubtitle", "isSubtitleOpen", "isFloatSubtitle", "showSubtitleView", "dimInBackgroundContent", "dimOutBackgroundContent", "disableAnim", "(Ljava/lang/Boolean;)V", "hideSubtitleView", "insertFakePhotoPlaceHolder", "photoList", "Lcom/larus/voicecall/impl/subtitle/bean/ImageProcessorWrapper;", "appendImgMsgToQueue", "res", "Lcom/larus/bmhome/upload/audio/AudioUploadImgRes;", "rawData", "findLastTarHolderPos", "block", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Integer;", "appendSuggest", "suggest", "onUpdateUIState", "currentMajorState", "Lcom/larus/audio/call/mgr/MajorState;", "currentState", "newMajorState", "newState", LiveCommonConstants.REASON_ON_DEDTROY, "getSubtitleViewModel", "tryChangePipDialog", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeSubtitleComponent extends RealtimeComponent implements com.larus.voicecall.impl.component.subtitle.a, com.larus.voicecall.impl.subtitle.g {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final /* synthetic */ int f377652J = 0;
    public final Lazy A;
    public final Lazy B;
    public int C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public q0 H;
    public boolean I;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f377653n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f377654o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f377655p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f377656q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f377657r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f377658s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f377659t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f377660u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f377661v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f377662w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f377663x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f377664y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f377665z;

    public static final class a {
    }

    public static final class b implements y3a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RealtimeSubtitleComponent f377666a;

        public b(RealtimeSubtitleComponent r100) {
            this.f377666a = r100;
        }

        @Override // y3a.a
        public final void a(y3a.c r100) {
            Intrinsics.checkNotNullParameter(r100, "newEvent");
            if ((r100 instanceof y3a.d) == false) goto L39;
            FLogger r101 = FLogger.f375446a;
            StringBuilder r102 = new StringBuilder("[realtime_ball_video_debug] subtitle view visible change, toVisible=");
            y3a.d r103 = (y3a.d) r100;
            r102.append(r103.f565907a);
            r102.append(", subtitleOpen=");
            RealtimeCallUtil.f379424a.getClass();
            r102.append(RealtimeCallUtil.f379461z);
            r102.append(", floatSubtitleMode=");
            r102.append(this.f377666a.I);
            r102.append(", isFullVideo=");
            r102.append(this.f377666a.C3().f484277r);
            r102.append(", isPipVideo=");
            r102.append(this.f377666a.C3().f484278s);
            r102.append(", isVideoFullPreview=");
            com.larus.voicecall.impl.component.vlm.b r104 = this.f377666a.E3();
            LinearLayout r105 = null;
            if (r104 == null) goto L7;
            Boolean r106 = Boolean.valueOf(r104.s6());
        L8:
            r102.append(r106);
            r102.append(", useTwoLine=");
            r102.append(z2.f365865a.realtimeCallUseTwoLineStyle());
            r101.i("RealtimeSubtitleComponent", r102.toString());
            g3a.a r107 = this.f377666a.B3();
            if (r107 == null) goto L14;
            VoiceCallBgLayout r108 = r107.Nl();
            if (r108 == null) goto L14;
            r105 = r108.f379310a.f378265d;
        L14:
            if (r103.f565907a == false) goto L25;
            if (r105 == null) goto L17;
            e1.x(r105);
        L17:
            g3a.a r109 = this.f377666a.B3();
            if (r109 == null) goto L32;
            VoiceCallContentLayout r110 = r109.dg();
            if (r110 == null) goto L32;
            Intrinsics.checkNotNullParameter("subtitle_view_visible_change_to_visible", "caller");
            if (r110.f379324g == false) goto L32;
            r110.f379318a.f378281i.i();
            e1.o(r110.f379318a.f378281i);
        L32:
            FragmentActivity r111 = s1a.a.c(this.f377666a).getActivity();
            if (r111 == null) goto L50;
            boolean r112 = v19.h.f552477a;
            boolean r113 = v19.h.b(r111);
            if (r103.f565907a == false) goto L37;
            y0.a(r111, !r113);
            return;
        L37:
            y0.a(r111, false);
            return;
        L50:
            return;
        L25:
            g3a.a r114 = this.f377666a.B3();
            if (r114 == null) goto L30;
            VoiceCallContentLayout r115 = r114.dg();
            if (r115 == null) goto L30;
            r115.n6("subtitle_view_visible_change_to_gone");
        L30:
            if (r105 == null) goto L32;
            e1.o(r105);
            goto L32
        L7:
            r106 = null;
            goto L8
        L39:
            if ((r100 instanceof y3a.b) == false) goto L49;
            RealtimeSubtitleComponent r116 = this.f377666a;
            int r117 = RealtimeSubtitleComponent.f377652J;
            g3a.a r118 = r116.B3();
            if (r118 == null) goto L53;
            VoiceCallBgLayout r119 = r118.Nl();
            if (r119 == null) goto L54;
            LinearLayout r120 = r119.f379310a.f378265d;
            if (r120 == null) goto L55;
            r120.setAlpha(((y3a.b) r100).f565906a);
            return;
        L55:
            return;
        L54:
            return;
        L53:
            return;
        L49:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    @Override // com.larus.voicecall.impl.component.subtitle.b
    public final void Ab() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("onSubtitleButtonClick, useTwoLine=");
        r101.append(z2.f365865a.realtimeCallUseTwoLineStyle());
        r101.append(", subtitleOpen=");
        RealtimeCallUtil.f379424a.getClass();
        r101.append(RealtimeCallUtil.f379461z);
        r101.append(", enableSubtitle=");
        r101.append(RealtimeCallUtil.k());
        r101.append(", videoSubtitleAbilityNull=");
        if (D3() != null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        r101.append(", shouldUseVideoSubtitle=");
        com.larus.voicecall.impl.component.videosubtitle.a r103 = D3();
        if (r103 == null) goto L9;
        Boolean r104 = Boolean.valueOf(r103.Tr());
    L10:
        r101.append(r104);
        r101.append(", floatSubtitleMode=");
        r101.append(this.I);
        r101.append(", isFullVideo=");
        r101.append(C3().f484277r);
        r101.append(", isPipVideo=");
        r101.append(C3().f484278s);
        r101.append(", isScreenShare=");
        r101.append(C3().f484279t);
        r101.append(", useNewInteractionStyle=");
        r101.append(p3().f484243k0);
        r100.i("RealtimeSubtitleComponent", r101.toString());
        g3a.a r105 = B3();
        if (r105 == null) goto L18;
        SimpleDraweeView r106 = r105.kj();
        if (r106 == null) goto L18;
        Animation r107 = r106.getAnimation();
        if (r107 == null) goto L18;
        r107.cancel();
    L18:
        if (RealtimeCallUtil.f379461z == false) goto L20;
        Zk("click_btn");
        return;
    L20:
        nV(false, "click_btn");
        return;
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public final g3a.a B3() {
        return (g3a.a) this.f377658s.getValue();
    }

    public final e3a.b C3() {
        return (e3a.b) this.f377654o.getValue();
    }

    public final com.larus.voicecall.impl.component.videosubtitle.a D3() {
        return (com.larus.voicecall.impl.component.videosubtitle.a) this.f377664y.getValue();
    }

    public final com.larus.voicecall.impl.component.vlm.b E3() {
        return (com.larus.voicecall.impl.component.vlm.b) this.f377663x.getValue();
    }

    public final VoiceCallContentLayout G3() {
        return (VoiceCallContentLayout) this.E.getValue();
    }

    public final RealtimeCallSubtitleLayout H3() {
        return (RealtimeCallSubtitleLayout) this.D.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        RealtimeCallUtil.f379424a.getClass();
        boolean r100 = RealtimeCallUtil.f379461z;
        if (((Boolean) RealtimeCallUtil.C.getValue()).booleanValue() == false) goto L6;
        ((Keva) RealtimeCallUtil.f379449n.getValue()).storeBoolean("key_record_subtitle_state", r100);
    L6:
        if (C3().f484263d == false) goto L11;
        if (RealtimeCallUtil.f379461z == false) goto L11;
        FLogger.f375446a.i("RealtimeSubtitleComponent", "rememberVideoSubtitleModeIfNeeded store, isFloatSubtitle=" + this.I);
        t0 r101 = t0.f379475a;
        boolean r102 = this.I;
        r101.getClass();
        ((Keva) t0.f379476b.getValue()).storeInt("VIDEO_SUBTITLE_MODE_WHEN_EXIT_REALTIME", r102 ? 1 : 0);
    L11:
        if (com.larus.voicecall.impl.tracer.w.f379244a <= 0) goto L13;
        com.larus.voicecall.impl.tracer.w.f379245b += System.currentTimeMillis() - com.larus.voicecall.impl.tracer.w.f379244a;
    L13:
        q0 r103 = this.H;
        if (r103 == null) goto L26;
        FLogger r104 = FLogger.f375446a;
        r104.i("RealtimeCallSubtitleViewModel", MapMonitorConst.EVENT_DESTROY);
        r104.j("Realtime call", "Realtime call destroy");
        r103.a("destroy()");
        r103.f378950p.removeCallbacksAndMessages(null);
        ReentrantLock r105 = r103.f378939e;
        r105.lock();
        LinkedList<a78.a> r106 = r103.f378940f;     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r106, "$this$operateDataSource");     // Catch: Throwable -> L23
        r106.clear();     // Catch: Throwable -> L23
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L23
        r105.unlock();
        r103.f378949o.clear();
        Handler r108 = r103.f378946l;
        if (r108 == null) goto L20;
        r108.removeCallbacksAndMessages(null);
    L20:
        r103.f378945k.quitSafely();
        RealtimeCallUtil.f379461z = false;
        com.larus.voicecall.impl.tracer.w.f379244a = 0;
        com.larus.voicecall.impl.tracer.w.f379245b = 0;
        com.larus.voicecall.impl.tracer.w.f379246c = false;
        com.larus.voicecall.impl.tracer.w.f379247d = null;
        if (ObricFeatureServiceDelegate.f387839b.a() == false) goto L29;
        GlobalAudioObserver.f289772a.c(GlobalAudioSceneEnum.TTS_REAL_TIME_CALL, GlobalAudioStateEnum.STOPPED, null);
        return;
    L29:
        return;
    L23:
        th = move-exception;
        r105.unlock();
        throw th;
    }

    public final e3a.a p3() {
        return (e3a.a) this.f377653n.getValue();
    }

    @Override // com.larus.voicecall.impl.component.subtitle.b
    public final boolean xU() {
        RealtimeCallUtil.f379424a.getClass();
        return RealtimeCallUtil.f379461z;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.subtitle.a.class);
        if (z2.f365865a.realtimeCallUseTwoLineStyle() == false) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.subtitle.b.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, c.class);
        return;
    }

    public final RealtimeCallService z3() {
        return (RealtimeCallService) this.f377656q.getValue();
    }

    public RealtimeSubtitleComponent() {
        this.f377653n = LazyKt.lazy(new o(this));
        this.f377654o = LazyKt.lazy(new f(this));
        this.f377655p = LazyKt.lazy(new g(this));
        this.f377656q = LazyKt.lazy(new h(this));
        this.f377657r = LazyKt.lazy(new i(this));
        this.f377658s = LazyKt.lazy(new j(this));
        this.f377659t = LazyKt.lazy(new k(this));
        this.f377660u = LazyKt.lazy(new l(this));
        this.f377661v = LazyKt.lazy(new m(this));
        this.f377662w = LazyKt.lazy(new n(this));
        this.f377663x = LazyKt.lazy(new z(this));
        this.f377664y = LazyKt.lazy(new b0(this));
        this.f377665z = LazyKt.lazy(new c0(this));
        this.A = LazyKt.lazy(new d0(this));
        this.B = LazyKt.lazy(new e0(this));
        this.C = -1;
        this.D = LazyKt.lazy(new f0(this));
        this.E = LazyKt.lazy(new g0(this));
        this.F = LazyKt.lazy(new h0(this));
        this.G = LazyKt.lazy(new e(this));
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void A0() {
        p3();
        C3();
        z3();
        com.larus.voicecall.impl.component.scene.a r100 = (com.larus.voicecall.impl.component.scene.a) this.f377659t.getValue();
        com.larus.voicecall.impl.component.core.a r101 = (com.larus.voicecall.impl.component.core.a) this.f377660u.getValue();
        m3a.a r102 = (m3a.a) this.f377661v.getValue();
        E3();
    }

    @Override // com.larus.voicecall.impl.subtitle.g
    public final void b0() {
        com.larus.voicecall.impl.component.vlm.b r100 = E3();
        if (r100 == null) goto L6;
        r100.X60();
        return;
    }

    public final void h3() {
        if (C3().f484268i == ThemeType.MAIN_BOT) goto L5;
    L9:
        VoiceCallContentLayout r100 = G3();
        boolean r101 = true;
        if (r100 != null) goto L12;
    L17:
        boolean r102 = false;
    L18:
        if (r102 == false) goto L23;
        VoiceCallContentLayout r103 = G3();
        if (r103 == null) goto L23;
        float r104 = r103.getAlpha();
    L25:
        if (r104 == 1.0f) goto L28;
        r101 = false;
    L28:
        if (r101 == false) goto L30;
        return;
    L30:
        VoiceCallContentLayout r105 = G3();
        if (r105 == null) goto L33;
        e1.x(r105);
    L33:
        VoiceCallContentLayout r106 = G3();
        if (r106 != null) goto L36;
    L41:
        VoiceCallContentLayout r107 = G3();
        if (r107 == null) goto L47;
        com.larus.voicecall.impl.utils.c.e(r107, r104, 1.0f);
        return;
    L47:
        return;
    L36:
        if (r106.f379321d == false) goto L39;
        r106.f379318a.f378291s.setVisibility(0);
        goto L41
    L39:
        if (r106.f379322e == false) goto L41;
        r106.f379318a.f378289q.setVisibility(0);
    L23:
        r104 = 0.0f;
        goto L25
    L12:
        if (r100.getVisibility() != 0) goto L14;
        boolean r108 = true;
    L15:
        if (r108 != true) goto L17;
        r102 = true;
        goto L18
    L14:
        r108 = false;
        goto L15
    L5:
        if (NewThemeSwitchAvatar.a() == false) goto L9;
        VoiceCallContentLayout r109 = G3();
        if (r109 == null) goto L45;
        r109.setAlpha(1.0f);
        return;
    }

    @Override // com.larus.voicecall.impl.component.subtitle.c
    public final q0 G00() {
        return this.H;
    }

    @Override // com.larus.voicecall.impl.component.subtitle.b
    public final boolean NT() {
        return this.I;
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void I6(jd9.c r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        if ((r100 instanceof jd9.c.a) == false) goto L13;
        a1 r101 = z3().w();
        if (r101 == null) goto L8;
        r101.h2(p3().f484243k0);
    L8:
        if (z2.f365865a.updateNetInfoAndSubtitleStatusEnabled() == false) goto L14;
        a1 r102 = z3().w();
        if (r102 == null) goto L15;
        RealtimeCallUtil.f379424a.getClass();
        r102.e2(RealtimeCallUtil.f379461z);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void Q3(boolean r100) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).isAdded() == false) goto L6;
        ((w3a.k) this.G.getValue()).d(new w3a.m(r100));
    L6:
        if (z2.f365865a.updateNetInfoAndSubtitleStatusEnabled() == false) goto L11;
        a1 r101 = z3().w();
        if (r101 == null) goto L12;
        r101.e2(r100);
        return;
    L12:
        return;
    }

    @Override // com.larus.voicecall.impl.component.subtitle.c
    public final void Qn(String r110) {
        Intrinsics.checkNotNullParameter(r110, "suggest");
        q0 r100 = this.H;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNullParameter(r110, "suggest");
        q0.s(r100, SubtitleListUpdateType.ASR_NEW, null, r110, null, null, UUID.randomUUID().toString(), null, null, 216);
        return;
    }

    @Override // com.larus.voicecall.impl.component.subtitle.c
    public final void Va(List<x3a.a> r110) {
        Intrinsics.checkNotNullParameter(r110, "photoList");
        q0 r111 = this.H;
        if (r111 == null) goto L8;
        Intrinsics.checkNotNullParameter(r110, "photoList");
        Iterator<T> r112 = r110.iterator();
    L6:
        if (r112.hasNext() == false) goto L10;
        x3a.a r100 = (x3a.a) r112.next();
        q0.s(r111, SubtitleListUpdateType.INSERT_PHOTO, null, r100.f562404a.f489227e, r100, null, null, null, null, 240);
        goto L6
    L10:
        return;
    }

    @Override // com.larus.voicecall.impl.component.subtitle.b
    public final void Zk(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.f379461z == true) goto L5;
        return;
    L5:
        com.larus.voicecall.impl.component.vlm.b r101 = E3();
        boolean r102 = true;
        if (r101 != null) goto L8;
    L10:
        boolean r103 = false;
    L11:
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("[realtime_ball_video_debug] closeSubtitle begin, reason=");
        r105.append(r100);
        r105.append(", subtitleOpen=");
        r105.append(RealtimeCallUtil.f379461z);
        r105.append(", floatSubtitleMode=");
        r105.append(this.I);
        r105.append(", isFullVideo=");
        r105.append(C3().f484277r);
        r105.append(", isPipVideo=");
        r105.append(C3().f484278s);
        r105.append(", isScreenShare=");
        r105.append(C3().f484279t);
        r105.append(", isVideoFullPreview=");
        r105.append(r103);
        r105.append(", useTwoLine=");
        r105.append(z2.f365865a.realtimeCallUseTwoLineStyle());
        r105.append(", videoSubtitleAbilityNull=");
        if (D3() != null) goto L14;
        boolean r106 = true;
    L15:
        r105.append(r106);
        r104.i("RealtimeSubtitleComponent", r105.toString());
        Q3(!RealtimeCallUtil.f379461z);
        int r107 = c68.b.f22600a;
        c68.b.d("RealtimeSubtitleComponent", "closeSubtitle, reason: ".concat(r100));
        ((IRealtimeCallTracer) this.f377657r.getValue()).B(IRealtimeCallTracer.TotalTimeType.SUBTITLE, false);
        RealtimeCallUtil.f379461z = false;
        CustomRoundImageView r108 = (CustomRoundImageView) this.F.getValue();
        if (r108 == null) goto L18;
        int r109 = com.larus.utils.j0.f375426a;
        r108.setContentDescription(com.larus.utils.j0.d(R.string.larus_call_accessibility_showCaptions));
    L18:
        m3a.a r110 = (m3a.a) this.f377661v.getValue();
        if (r110 == null) goto L21;
        r110.cu();
    L21:
        RealtimeCallSubtitleLayout r111 = H3();
        if (r111 != null) goto L24;
    L29:
        com.larus.voicecall.impl.component.videosubtitle.a r112 = D3();
        if (r112 == null) goto L32;
        r112.aX(false, "click");
    L32:
        if (r103 == true) goto L40;
        StringBuilder r113 = new StringBuilder("[realtime_ball_video_debug] closeSubtitle will switchFullMode, reason=");
        r113.append(r100);
        r113.append(", runtimeFull=");
        r113.append(C3().f484277r);
        r113.append(", runtimePip=");
        r113.append(C3().f484278s);
        r113.append(", videoCaptureMayStartedByAbility=");
        if (E3() != null) goto L37;
        r102 = false;
    L37:
        r113.append(r102);
        r104.i("RealtimeSubtitleComponent", r113.toString());
        com.larus.voicecall.impl.component.vlm.b r114 = E3();
        if (r114 == null) goto L42;
        r114.m20();
        return;
    L42:
        return;
    L40:
        r104.i("RealtimeSubtitleComponent", "[realtime_ball_video_debug] closeSubtitle skip switchFullMode, reason=" + r100 + ", isVideoFullPreview=true");
        return;
    L24:
        if (r111.getVisibility() != 0) goto L26;
        boolean r115 = true;
    L27:
        if (r115 == false) goto L29;
        r111.Z5();
        h3();
        goto L29
    L26:
        r115 = false;
        goto L27
    L14:
        r106 = false;
        goto L15
    L8:
        if (r101.s6() != true) goto L10;
        r103 = true;
        goto L11
    }

    public final void m3(Boolean r100) {
        boolean r101 = false;
        if (r100 == null) goto L5;
        boolean r102 = r100.booleanValue();
    L11:
        VoiceCallContentLayout r103 = G3();
        if (r103 == null) goto L14;
        float r104 = r103.getAlpha();
    L16:
        if (C3().f484268i == ThemeType.MAIN_BOT) goto L18;
    L35:
        if (r102 == false) goto L45;
        VoiceCallContentLayout r105 = G3();
        if (r105 == null) goto L39;
        r105.setAlpha(0.0f);
    L39:
        VoiceCallContentLayout r106 = G3();
        if (r106 == null) goto L42;
        e1.o(r106);
    L42:
        VoiceCallContentLayout r107 = G3();
        if (r107 == null) goto L59;
        r107.f379318a.f378289q.setVisibility(4);
        r107.f379318a.f378291s.setVisibility(4);
        return;
    L59:
        return;
    L45:
        VoiceCallContentLayout r108 = G3();
        if (r108 == null) goto L48;
        com.larus.voicecall.impl.utils.c.e(r108, r104, 0.0f);
    L48:
        View r109 = s1a.a.getActivity(this).getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L53;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r110 = ThreadMethodProxy.currentThread();
        if (r110 == com.larus.home.impl.utils.c.f346341a) goto L53;
        com.larus.home.impl.utils.c.a(r110, "getDecorView");
    L53:
        SafeExtKt.b(r109, new d(this), 300);
        return;
    L18:
        if (NewThemeSwitchAvatar.a() == false) goto L35;
        boolean r111 = v19.h.f552477a;
        if (v19.h.a(null) == false) goto L22;
        float r112 = 0.15f;
    L24:
        if (r104 != r112) goto L26;
        r101 = true;
    L26:
        if (r101 == false) goto L28;
        return;
    L28:
        if (r102 == false) goto L32;
        VoiceCallContentLayout r113 = G3();
        if (r113 == null) goto L55;
        r113.setAlpha(r112);
        return;
    L55:
        return;
    L32:
        VoiceCallContentLayout r114 = G3();
        if (r114 == null) goto L57;
        com.larus.voicecall.impl.utils.c.e(r114, r104, r112);
        return;
    L57:
        return;
    L22:
        r112 = 0.1f;
        goto L24
    L14:
        r104 = 0.0f;
        goto L16
    L5:
        com.larus.voicecall.impl.component.vlm.b r115 = E3();
        if (r115 != null) goto L8;
    L10:
        r102 = false;
        goto L11
    L8:
        if (r115.s6() != true) goto L10;
        r102 = true;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.voicecall.impl.component.subtitle.w] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.voicecall.impl.component.subtitle.v] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.voicecall.impl.component.subtitle.u] */
    /* JADX WARN: Type inference failed for: r3v10, types: [com.larus.voicecall.impl.component.subtitle.y] */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.larus.voicecall.impl.component.subtitle.t] */
    @Override // com.larus.av_call.component.RealtimeComponent, com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(final View r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.k() == true) goto L5;
        return;
    L5:
        z2 r100 = z2.f365865a;
        boolean r101 = false;
        if (r100.realtimeCallUseTwoLineStyle() == false) goto L18;
        Pair<Boolean, Boolean> r102 = com.larus.voicecall.impl.l.f378359i;
        if (com.larus.voicecall.impl.l.a.b(s1a.a.getActivity(this)) == true) goto L18;
        if (RealtimeCallUtil.f379461z == false) goto L12;
        FLogger.f375446a.i("RealtimeSubtitleComponent", "reset subtitle state for two-line style because record permission is missing");
    L12:
        RealtimeCallUtil.f379461z = false;
        CustomRoundImageView r103 = (CustomRoundImageView) this.F.getValue();
        if (r103 == null) goto L15;
        int r104 = com.larus.utils.j0.f375426a;
        r103.setContentDescription(com.larus.utils.j0.d(R.string.larus_call_accessibility_showCaptions));
    L15:
        m3a.a r105 = (m3a.a) this.f377661v.getValue();
        if (r105 == null) goto L18;
        r105.cu();
    L18:
        r110.post(new p(r110));
        RealtimeCallSubtitleLayout r111 = H3();
        if (r111 == null) goto L21;
        r111.setBotSpeakingProvider(new q(this));
    L21:
        RealtimeCallSubtitleLayout r112 = H3();
        if (r112 == null) goto L24;
        r112.setCurrentSceneMode(new r(this));
    L24:
        com.larus.voicecall.impl.component.scene.a r113 = (com.larus.voicecall.impl.component.scene.a) this.f377659t.getValue();
        if (r113 == null) goto L27;
        r113.getCurrentScene();
    L27:
        RealtimeCallSubtitleLayout r114 = H3();
        if (r114 == null) goto L31;
        r114.setGetRealtimeCallTracer(new s(this));
    L31:
        if (com.larus.audio.call.f.f() == false) goto L33;
        final StateFlowImpl r106 = z3().f288939o;
        Flow<Integer> r107 = new RealtimeSubtitleComponent$onViewCreated$$inlined$map$1(r106);
    L34:
        com.larus.voicecall.impl.component.scene.a r108 = (com.larus.voicecall.impl.component.scene.a) this.f377659t.getValue();
        if (r108 == null) goto L37;
        LiveData<com.larus.voicecall.impl.scene.m> r109 = r108.getCurrentScene();
    L38:
        Intrinsics.checkNotNullParameter(this, "<this>");
        q0 r115 = new q0(r107, r109, com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), new com.larus.voicecall.impl.tracer.w.a(p3().f484235d, C3().f484260a, p3().f484237f, p3().f484253t), (IRealtimeCallTracer) this.f377657r.getValue(), new t(this));
        RealtimeCallService r116 = z3();
        r116.getClass();
        Intrinsics.checkNotNullParameter(r115, "listener");
        r116.q().C0(r115);
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)), null, null, new RealtimeSubtitleComponent$onViewCreated$7$1(r115, this, null), 3, null);
        this.H = r115;
        int r117 = m0.f375450a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (m0.b(com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext()) <= c7.b(640)) goto L47;
        RealtimeCallSubtitleLayout r118 = H3();
        if (r118 == null) goto L47;
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
        if (r119 == null) goto L46;
        r119.width = c7.b(640);
        r118.setLayoutParams(r119);
        goto L47
    L46:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L47:
        CustomRoundImageView r120 = (CustomRoundImageView) this.F.getValue();
        if (r120 == null) goto L50;
        e1.d(r120, new x(this));
    L50:
        com.larus.voicecall.impl.component.scene.a r121 = (com.larus.voicecall.impl.component.scene.a) this.f377659t.getValue();
        if (r121 == null) goto L55;
        LiveData<com.larus.voicecall.impl.scene.m> r122 = r121.getCurrentScene();
        if (r122 == null) goto L55;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r122.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), new i0(new y(this)));
    L55:
        RealtimeCallSubtitleLayout r123 = H3();
        if (r123 == null) goto L59;
        r123.setSubtitleLongClickListener(new a0(this));
    L59:
        if (RealtimeCallUtil.f(C3().f484263d) == true) goto L61;
    L76:
        a1 r124 = z3().w();
        if (r124 == 0) goto L79;
        r124.D1(new u(this));
    L79:
        a1 r125 = z3().w();
        if (r125 == 0) goto L82;
        r125.w2(new v(this));
    L82:
        a1 r126 = z3().w();
        if (r126 == 0) goto L86;
        r126.t2(new w(this));
        return;
    L86:
        return;
    L61:
        if (p3().T == true) goto L76;
        if (p3().f484243k0 == true) goto L76;
        CustomRoundImageView r127 = (CustomRoundImageView) this.F.getValue();
        if (r127 != null) goto L67;
    L72:
        if (r101 == false) goto L74;
    L75:
        nV(true, "auto_open");
        goto L76
    L74:
        if (r100.realtimeCallUseTwoLineStyle() == false) goto L76;
    L67:
        if (r127.getVisibility() != 0) goto L69;
        boolean r128 = true;
    L70:
        if (r128 != true) goto L72;
        r101 = true;
        goto L72
    L69:
        r128 = false;
        goto L70
    L37:
        r109 = null;
        goto L38
    L33:
        r107 = z3().f288935k;
        goto L34
    }

    @Override // com.larus.voicecall.impl.component.subtitle.c
    public final Integer wi(com.larus.voicecall.impl.component.picture.e r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        q0 r101 = this.H;
        if (r101 == null) goto L12;
        Intrinsics.checkNotNullParameter(r100, "block");
        ArrayList<com.larus.voicecall.impl.subtitle.c> r102 = r101.f378949o;
        ListIterator<com.larus.voicecall.impl.subtitle.c> r103 = r102.listIterator(r102.size());
    L6:
        if (r103.hasPrevious() == false) goto L10;
        if (((Boolean) r100.invoke(r103.previous())).booleanValue() == false) goto L6;
        int r104 = r103.nextIndex();
    L17:
        return Integer.valueOf(r104);
    L10:
        r104 = -1;
        goto L17
    L12:
        return null;
    }

    @Override // com.larus.voicecall.impl.component.subtitle.b
    public final void Cf(boolean r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.f379461z == true) goto L6;
        FLogger.f375446a.i("RealtimeSubtitleComponent", "switchSubtitle skip, subtitleOpen=false, floatSubtitle=" + r100 + ", reason=" + r110);
        return;
    L6:
        int r101 = c68.b.f22600a;
        c68.b.d("RealtimeSubtitleComponent", "switchSubtitle, floatSubtitle: " + r100 + ", reason: " + r110);
        boolean r102 = true;
        if (r100 == true) goto L9;
    L11:
        boolean r103 = false;
    L12:
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("switchSubtitle target, requestFloat=");
        r105.append(r100);
        r105.append(", targetFloat=");
        r105.append(r103);
        r105.append(", reason=");
        r105.append(r110);
        r105.append(", videoSubtitleAbilityNull=");
        if (D3() != null) goto L15;
        boolean r106 = true;
    L16:
        r105.append(r106);
        r105.append(", currentFloatSubtitle=");
        r105.append(this.I);
        r105.append(", isFullVideo=");
        r105.append(C3().f484277r);
        r105.append(", isPipVideo=");
        r105.append(C3().f484278s);
        r104.i("RealtimeSubtitleComponent", r105.toString());
        this.I = r103;
        if (r103 == false) goto L29;
        com.larus.voicecall.impl.component.videosubtitle.a r107 = D3();
        if (r107 == null) goto L21;
        r107.aX(true, r110);
    L21:
        RealtimeCallSubtitleLayout r108 = H3();
        if (r108 != null) goto L24;
        return;
    L24:
        if (r108.getVisibility() == 0) goto L27;
        r102 = false;
    L27:
        if (r102 == false) goto L42;
        r108.Z5();
        h3();
        return;
    L42:
        return;
    L29:
        com.larus.voicecall.impl.component.videosubtitle.a r109 = D3();
        if (r109 == null) goto L32;
        r109.aX(false, r110);
    L32:
        RealtimeCallSubtitleLayout r111 = H3();
        if (r111 != null) goto L35;
        return;
    L35:
        if (r111.getVisibility() == 0) goto L38;
        r102 = false;
    L38:
        if (r102 == true) goto L45;
        r111.V5(this.H, C3(), this);
        r111.setVisible(false);
        m3(null);
        return;
    L45:
        return;
    L15:
        r106 = false;
        goto L16
    L9:
        if (D3() == null) goto L11;
        r103 = true;
        goto L12
    }

    @Override // com.larus.voicecall.impl.component.subtitle.c
    public final void TW(com.larus.bmhome.upload.audio.i r100, x3a.a r101) {
        Intrinsics.checkNotNullParameter(r100, "res");
        q0 r102 = this.H;
        if (r102 == null) goto L9;
        Intrinsics.checkNotNullParameter(r100, "res");
        if (r102.f378958x.contains(r101.f562408e) == false) goto L7;
        FLogger.f375446a.e("RealtimeCallSubtitleViewModel", "appendImgMsgToQueue the same key add to queue. key=" + r101.f562408e + " remote_url=" + r101.f562410g);
        return;
    L7:
        r102.f378958x.add(r101.f562408e);
        r102.f378956v.setValue(TuplesKt.to(r100, r101));
        return;
    }

    @Override // com.larus.voicecall.impl.component.subtitle.b
    public final void nV(boolean r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "reason");
        Pair<Boolean, Boolean> r100 = com.larus.voicecall.impl.l.f378359i;
        if (com.larus.voicecall.impl.l.a.b(s1a.a.getActivity(this)) == true) goto L6;
        FLogger.f375446a.i("RealtimeSubtitleComponent", "openSubtitle skip, record permission is missing");
        return;
    L6:
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.f379461z == false) goto L11;
        FLogger.f375446a.i("RealtimeSubtitleComponent", "openSubtitle skip, already open, isAuto=" + r110 + ", reason=" + r111);
        return;
    L11:
        if (z2.f365865a.realtimeCallUseTwoLineStyle() == false) goto L17;
        if (com.larus.voicecall.impl.l.a.b(s1a.a.getActivity(this)) == true) goto L17;
        FLogger.f375446a.i("RealtimeSubtitleComponent", "openSubtitle ignored because record permission is missing in two-line style, isAuto=" + r110 + ", reason=" + r111);
        return;
    L17:
        if (C3().f484279t == false) goto L20;
        FLogger.f375446a.i("RealtimeSubtitleComponent", "openSubtitle ignored when screen sharing, isAuto=" + r110 + ", reason=" + r111);
        return;
    L20:
        com.larus.voicecall.impl.component.videosubtitle.a r101 = D3();
        boolean r102 = false;
        if (r101 != null) goto L23;
    L25:
        boolean r103 = false;
    L26:
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("openSubtitle check float, isAuto=");
        r105.append(r110);
        r105.append(", reason=");
        r105.append(r111);
        r105.append(", useNewInteractionStyle=");
        r105.append(p3().f484243k0);
        r105.append(", videoSubtitleAbilityNull=");
        if (D3() != null) goto L29;
        boolean r106 = true;
    L30:
        r105.append(r106);
        r105.append(", shouldUseVideoSubtitle=");
        r105.append(r103);
        r105.append(", isFullVideo=");
        r105.append(C3().f484277r);
        r105.append(", isPipVideo=");
        r105.append(C3().f484278s);
        r104.i("RealtimeSubtitleComponent", r105.toString());
        if (p3().f484243k0 == false) goto L36;
        if (r103 == true) goto L36;
        r104.i("RealtimeSubtitleComponent", "openSubtitle, isAuto: " + r110 + ", reason: " + r111 + ", useNewInteractionStyle: " + p3().f484243k0);
        com.larus.voicecall.impl.component.vlm.b r107 = E3();
        if (r107 == null) goto L36;
        r107.Y80("onSubtitleOpen");
    L36:
        Q3(!RealtimeCallUtil.f379461z);
        int r108 = c68.b.f22600a;
        c68.b.d("RealtimeSubtitleComponent", "openSubtitle, isAuto: " + r110 + ", reason: " + r111);
        ((IRealtimeCallTracer) this.f377657r.getValue()).B(IRealtimeCallTracer.TotalTimeType.SUBTITLE, true);
        RealtimeCallUtil.f379461z = true;
        this.I = r103;
        StringBuilder r112 = new StringBuilder("openSubtitle result, floatSubtitleMode=");
        r112.append(this.I);
        r112.append(", videoSubtitleAbilityNull=");
        if (D3() != null) goto L39;
        boolean r109 = true;
    L40:
        r112.append(r109);
        r112.append(", isFullVideo=");
        r112.append(C3().f484277r);
        r112.append(", isPipVideo=");
        r112.append(C3().f484278s);
        r104.i("RealtimeSubtitleComponent", r112.toString());
        CustomRoundImageView r113 = (CustomRoundImageView) this.F.getValue();
        if (r113 == null) goto L43;
        int r114 = com.larus.utils.j0.f375426a;
        r113.setContentDescription(com.larus.utils.j0.d(R.string.larus_call_accessibility_offCaptions));
    L43:
        m3a.a r115 = (m3a.a) this.f377661v.getValue();
        if (r115 == null) goto L46;
        r115.kz();
    L46:
        StringBuilder r116 = new StringBuilder("showSubtitleView, isAuto=");
        r116.append(r110);
        r116.append(", floatSubtitleMode=");
        r116.append(this.I);
        r116.append(", videoSubtitleAbilityNull=");
        if (D3() != null) goto L49;
        r102 = true;
    L49:
        r116.append(r102);
        r116.append(", isFullVideo=");
        r116.append(C3().f484277r);
        r116.append(", isPipVideo=");
        r116.append(C3().f484278s);
        r104.i("RealtimeSubtitleComponent", r116.toString());
        if (this.I == false) goto L54;
        com.larus.voicecall.impl.component.videosubtitle.a r117 = D3();
        if (r117 == null) goto L64;
        r117.aX(true, "click");
    L64:
        if (this.I == true) goto L69;
        com.larus.voicecall.impl.component.vlm.b r118 = E3();
        if (r118 == null) goto L70;
        r118.Y80("onSubtitleOpen");
        return;
    L70:
        return;
    L69:
        return;
    L54:
        RealtimeCallSubtitleLayout r119 = H3();
        if (r119 == null) goto L57;
        r119.V5(this.H, C3(), this);
    L57:
        RealtimeCallSubtitleLayout r120 = H3();
        if (r120 == null) goto L60;
        r120.setVisible(r110);
    L60:
        if (r110 == false) goto L62;
        m3(Boolean.TRUE);
        goto L64
    L62:
        m3(null);
        goto L64
    L39:
        r109 = false;
        goto L40
    L29:
        r106 = false;
        goto L30
    L23:
        if (r101.Tr() != true) goto L25;
        r103 = true;
        goto L26
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void o1(MajorState r110, int r111, MajorState r112, int r113) {
        Intrinsics.checkNotNullParameter(r110, "currentMajorState");
        Intrinsics.checkNotNullParameter(r112, "newMajorState");
        q0 r100 = this.H;
        if (r100 != null) goto L5;
    L26:
        if (r113 == 14) goto L30;
        if (r113 == 15) goto L31;
        FLogger.f375446a.i("RealtimeSubtitleComponent", "onUpdateUIState_RealtimeSubtitleComponent currentMajorState=" + r110 + " currentState=" + r111 + " newMajorState=" + r112 + " newState=" + r113);
        this.C = r113;
        return;
    L31:
        return;
    L30:
        return;
    L5:
        if (r113 == 14) goto L9;
        if (r113 == 15) goto L9;
        r100.f378951q = r113;
    L9:
        if (ArraysKt.contains(new Integer[]{14, 7}, Integer.valueOf(r113)) == false) goto L13;
        if (r111 != 3) goto L13;
        int r101 = 2;
    L16:
        FLogger.f375446a.i("RealtimeCallSubtitleViewModel", "updateCallState state:" + r101 + ", uiState:" + r111 + ", newState:" + r113);
        if (r101 == 2) goto L25;
        if (r101 != 3) goto L20;
        r100.f378942h.tryEmit(new com.larus.voicecall.impl.subtitle.y0(SubtitleAction.LISTENING, 0, 0, false, 14));
        goto L26
    L20:
        if (r101 == 9) goto L25;
        if (r101 != 14) goto L26;
        r100.f378942h.tryEmit(new com.larus.voicecall.impl.subtitle.y0(SubtitleAction.OTHER, 0, 0, false, 14));
    L25:
        r100.f378942h.tryEmit(new com.larus.voicecall.impl.subtitle.y0(SubtitleAction.WAIT, 0, 0, false, 14));
    L13:
        if (ArraysKt.contains(new Integer[]{14, 15, 7, 8}, Integer.valueOf(r113)) == false) goto L15;
        r101 = r111;
        goto L16
    L15:
        r101 = r113;
        goto L16
    }
}
