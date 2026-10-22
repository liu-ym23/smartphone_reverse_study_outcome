package com.larus.voicecall.impl.component.vlm;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.keva.Keva;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.av_call.constant.ThemeType;
import com.larus.av_call.model.RealtimePageMode;
import com.larus.av_call.view.VoiceCallBottomLayout;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.RealtimeCallService;
import com.larus.voicecall.impl.bean.RealtimeVlmLimitStatus;
import com.larus.voicecall.impl.degrade.RealtimeCallDegradeManager;
import com.larus.voicecall.impl.plugins.u2;
import com.larus.voicecall.impl.subtitle.RealtimeCallScreenShareLayout;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.utils.RealtimeNoticeDialogHelper;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import hq9.z3;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 \u0084\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0006\u0082\u0001\u0083\u0001\u0084\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010O\u001a\u00020PH\u0016J\b\u0010Q\u001a\u00020PH\u0016J\b\u0010R\u001a\u00020PH\u0002J\b\u0010S\u001a\u00020PH\u0002J\u0010\u0010T\u001a\u00020P2\u0006\u0010U\u001a\u00020VH\u0016J\u001a\u0010W\u001a\u00020P2\u0006\u0010X\u001a\u00020\t2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J,\u0010[\u001a\u00020P2\u0006\u0010\\\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020\u000b2\b\b\u0002\u0010^\u001a\u00020=2\b\b\u0002\u0010_\u001a\u00020\tH\u0002J\b\u0010`\u001a\u00020PH\u0016J\"\u0010a\u001a\u00020P2\u0006\u0010b\u001a\u00020\u000b2\u0006\u0010c\u001a\u00020\u000b2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\u0010\u0010f\u001a\u00020P2\u0006\u0010X\u001a\u00020gH\u0016J\u0010\u0010h\u001a\u00020P2\u0006\u0010i\u001a\u00020HH\u0016J\"\u0010j\u001a\u00020P2\u0006\u0010k\u001a\u00020\t2\u0006\u0010l\u001a\u00020m2\b\b\u0002\u0010n\u001a\u00020=H\u0002J\u0012\u0010o\u001a\u0004\u0018\u00010p2\u0006\u0010q\u001a\u00020\u000bH\u0016J\b\u0010r\u001a\u00020=H\u0002J\u0018\u0010s\u001a\u00020P2\u0006\u0010t\u001a\u00020=2\u0006\u0010u\u001a\u00020\tH\u0016J\b\u0010v\u001a\u00020=H\u0016J(\u0010w\u001a\u00020P2\u0006\u0010k\u001a\u00020\t2\u0006\u0010x\u001a\u00020m2\u0006\u0010M\u001a\u00020=2\u0006\u0010n\u001a\u00020=H\u0016J\b\u0010y\u001a\u00020=H\u0016J \u0010w\u001a\u00020P2\u0006\u0010k\u001a\u00020\t2\u0006\u0010M\u001a\u00020=2\u0006\u0010n\u001a\u00020=H\u0016J\u0012\u0010z\u001a\u00020P2\b\u0010N\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010{\u001a\u00020P2\u0006\u0010|\u001a\u00020\tH\u0002J\b\u0010}\u001a\u00020PH\u0002J\u0010\u0010~\u001a\u00020P2\u0006\u0010\u007f\u001a\u00020\tH\u0002J\u0011\u0010\u0080\u0001\u001a\u00020P2\u0006\u0010N\u001a\u00020\tH\u0002J\u0013\u0010\u0081\u0001\u001a\u00020P2\b\b\u0002\u0010N\u001a\u00020\tH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0015\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0015\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0015\u001a\u0004\b,\u0010-R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0015\u001a\u0004\b1\u00102R\u001b\u00104\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0015\u001a\u0004\b6\u00107R\u001d\u00109\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0015\u001a\u0004\b:\u0010-R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0015\u001a\u0004\b>\u0010?R\u000e\u0010A\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010D\u001a\u0004\u0018\u00010C2\b\u0010B\u001a\u0004\u0018\u00010C@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bE\u0010FR\u000e\u0010G\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010J\u001a\u00020I2\u0006\u0010B\u001a\u00020I@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0085\u0001"}, d2 = {"Lcom/larus/voicecall/impl/component/vlm/RealtimeScreenShareComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/vlm/IRealtimeScreenShareAbility;", "Lcom/obric/assistant/ability/call/IObricRealtimeScreenShareAbility;", "<init>", "()V", "formatLogger", "Lcom/larus/utils/logger/FlowFormatLogger;", "currentCallIdForLog", "", "topPadding", "", "getTopPadding", "()I", "setTopPadding", "(I)V", "contentAbility", "Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "getContentAbility", "()Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "contentAbility$delegate", "Lkotlin/Lazy;", "coreAbility", "Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "getCoreAbility", "()Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "coreAbility$delegate", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "screenShareApi", "Lcom/larus/voicecall/impl/plugins/RealtimeScreenSharePluginProvider;", "getScreenShareApi", "()Lcom/larus/voicecall/impl/plugins/RealtimeScreenSharePluginProvider;", "screenShareApi$delegate", "tracer", "Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "getTracer", "()Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "tracer$delegate", "stateManager", "Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "getStateManager", "()Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "stateManager$delegate", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "viewStateManager", "getViewStateManager", "viewStateManager$delegate", "enableShareScreenToChildThread", "", "getEnableShareScreenToChildThread", "()Z", "enableShareScreenToChildThread$delegate", "needHalf", "value", "Lkotlinx/coroutines/Job;", "startScreenShareJob", "setStartScreenShareJob", "(Lkotlinx/coroutines/Job;)V", "curConnectState", "Lcom/larus/im/internal/audio/context/SessionState;", "Lcom/larus/voicecall/impl/component/vlm/RealtimeScreenShareComponent$ScreenShareState;", "curState", "setCurState", "(Lcom/larus/voicecall/impl/component/vlm/RealtimeScreenShareComponent$ScreenShareState;)V", "skipEnterView", "enterMethod", "onVContextReady", "", "onAttach", "onScreenShareStopped", "onScreenShareStaring", "onViewCreated", "view", "Landroid/view/View;", "otherEvent", "event", "content", "", "mobVideoError", "deviceState", "deviceError", "isCheckoutModalError", "errorMsg", LiveCommonConstants.REASON_ON_DEDTROY, "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onReceiveEvent", "Lcom/larus/im/service/audio/MediaSessionListener$Event;", "onConnectionStateChanged", "state", "exitScreenShareMode", "endMethod", "exitChannel", "Lcom/larus/voicecall/impl/component/vlm/ExitScreenShareReason;", "needSwitchModal", "screenShareMenuItem", "Lcom/larus/bmhome/view/screenmenu/MenuItem;", "menuId", "shouldGrayScreenShareMenuItemByBottomRule", "handleScreenShareClick", "isScreenShareSelected", "clickMethod", "shouldHideScreenShareMenuItem", "tryExitScreenShareMode", "endChannel", "isScreenShareMode", "tryEnterScreenShareMode", "showToast", "txt", "enterScreenShareMode", "mobLeaveScreenShare", "leaveMethod", "mobClickScreenShare", "mobEnterScreenShare", "ScreenShareState", "ScreenShareEnterBlockReason", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeScreenShareComponent extends RealtimeComponent implements com.larus.voicecall.impl.component.vlm.a, naa.a {
    public static final /* synthetic */ int F = 0;
    public Job A;
    public jd9.c B;
    public ScreenShareState C;
    public boolean D;
    public String E;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final f2a.d f377789n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f377790o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f377791p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f377792q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f377793r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f377794s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f377795t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f377796u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f377797v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f377798w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f377799x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f377800y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f377801z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/voicecall/impl/component/vlm/RealtimeScreenShareComponent$ScreenShareEnterBlockReason;", "", "<init>", "(Ljava/lang/String;I)V", "DOWNGRADE", "LIMITED", "SCENE_MODE", "NOT_CONNECTED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ScreenShareEnterBlockReason extends Enum<ScreenShareEnterBlockReason> {
        public static final ScreenShareEnterBlockReason DOWNGRADE = null;
        public static final ScreenShareEnterBlockReason LIMITED = null;
        public static final ScreenShareEnterBlockReason NOT_CONNECTED = null;
        public static final ScreenShareEnterBlockReason SCENE_MODE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScreenShareEnterBlockReason[] f377802a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f377803b = null;

        public static EnumEntries<ScreenShareEnterBlockReason> getEntries() {
            return f377803b;
        }

        static {
            ScreenShareEnterBlockReason r100 = new ScreenShareEnterBlockReason("DOWNGRADE", 0);
            DOWNGRADE = r100;
            ScreenShareEnterBlockReason r101 = new ScreenShareEnterBlockReason("LIMITED", 1);
            LIMITED = r101;
            ScreenShareEnterBlockReason r102 = new ScreenShareEnterBlockReason("SCENE_MODE", 2);
            SCENE_MODE = r102;
            ScreenShareEnterBlockReason r103 = new ScreenShareEnterBlockReason("NOT_CONNECTED", 3);
            NOT_CONNECTED = r103;
            ScreenShareEnterBlockReason[] r104 = {r100, r101, r102, r103};
            f377802a = r104;
            f377803b = EnumEntriesKt.enumEntries(r104);
        }

        public static ScreenShareEnterBlockReason[] values() {
            return (ScreenShareEnterBlockReason[]) f377802a.clone();
        }

        public static ScreenShareEnterBlockReason valueOf(String r100) {
            return (ScreenShareEnterBlockReason) r27.a.a(ScreenShareEnterBlockReason.class, r100);
        }

        public ScreenShareEnterBlockReason(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/voicecall/impl/component/vlm/RealtimeScreenShareComponent$ScreenShareState;", "", "<init>", "(Ljava/lang/String;I)V", "CLOSE", "SHARING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ScreenShareState extends Enum<ScreenShareState> {
        public static final ScreenShareState CLOSE = null;
        public static final ScreenShareState SHARING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScreenShareState[] f377804a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f377805b = null;

        public static EnumEntries<ScreenShareState> getEntries() {
            return f377805b;
        }

        static {
            ScreenShareState r100 = new ScreenShareState("CLOSE", 0);
            CLOSE = r100;
            ScreenShareState r101 = new ScreenShareState("SHARING", 1);
            SHARING = r101;
            ScreenShareState[] r102 = {r100, r101};
            f377804a = r102;
            f377805b = EnumEntriesKt.enumEntries(r102);
        }

        public static ScreenShareState[] values() {
            return (ScreenShareState[]) f377804a.clone();
        }

        public static ScreenShareState valueOf(String r100) {
            return (ScreenShareState) r27.a.a(ScreenShareState.class, r100);
        }

        public ScreenShareState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b implements w3a.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RealtimeScreenShareComponent f377806a;

        public b(RealtimeScreenShareComponent r100) {
            this.f377806a = r100;
        }

        @Override // w3a.i
        public final void a(w3a.h r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            if ((r100 instanceof w3a.j) == false) goto L8;
            RealtimeScreenShareComponent r101 = this.f377806a;
            if (r101.C != ScreenShareState.SHARING) goto L18;
            int r102 = com.larus.voicecall.impl.util.x0.f379492a;
            String r103 = r101.E;
            RealtimeCallParam r104 = r101.B3().a();
            e3a.a r105 = this.f377806a.z3();
            boolean r106 = ((w3a.j) r100).f558198a;
            RealtimeCallUtil.f379424a.getClass();
            com.larus.voicecall.impl.util.x0.b(r103, r104, r105, r106, RealtimeCallUtil.f379461z, "microphone");
            return;
        L18:
            return;
        L8:
            if ((r100 instanceof w3a.m) == false) goto L13;
            RealtimeScreenShareComponent r107 = this.f377806a;
            if (r107.C != ScreenShareState.SHARING) goto L20;
            int r108 = com.larus.voicecall.impl.util.x0.f379492a;
            com.larus.voicecall.impl.util.x0.b(r107.E, r107.B3().a(), this.f377806a.z3(), this.f377806a.B3().f484272m, ((w3a.m) r100).f558207a, "subtitle");
            return;
        L20:
            return;
        L13:
            if ((r100 instanceof w3a.n) == false) goto L22;
            RealtimeScreenShareComponent r109 = this.f377806a;
            if (r109.C != ScreenShareState.SHARING) goto L23;
            int r110 = com.larus.voicecall.impl.util.x0.f379492a;
            String r111 = r109.E;
            RealtimeCallParam r112 = r109.B3().a();
            e3a.a r113 = this.f377806a.z3();
            boolean r114 = this.f377806a.B3().f484272m;
            RealtimeCallUtil.f379424a.getClass();
            com.larus.voicecall.impl.util.x0.b(r111, r112, r113, r114, RealtimeCallUtil.f379461z, "break");
            return;
        L23:
            return;
        }
    }

    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f377807a;

        public c(s r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f377807a = r100;
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
            return this.f377807a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f377807a.invoke(r100);
        }
    }

    /* JADX INFO: renamed from: com.larus.voicecall.impl.component.vlm.RealtimeScreenShareComponent$onActivityResult$9, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.component.vlm.RealtimeScreenShareComponent$onActivityResult$9", f = "RealtimeScreenShareComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.larus.im.service.audio.f1 $config;
        int label;
        final /* synthetic */ RealtimeScreenShareComponent this$0;

        public AnonymousClass9(RealtimeScreenShareComponent r100, com.larus.im.service.audio.f1 r101, Continuation<? super AnonymousClass9> r102) {
            this.this$0 = r100;
            this.$config = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass9(this.this$0, this.$config, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass9) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r100);
            RealtimeScreenShareComponent r101 = this.this$0;
            com.larus.im.service.audio.f1 r102 = this.$config;
            int r103 = RealtimeScreenShareComponent.F;
            u2 r104 = r101.C3();
            if (r104 == null) goto L7;
            r104.n(r102);
        L7:
            RealtimeScreenShareComponent r105 = this.this$0;
            Job r106 = r105.A;
            if (r106 == null) goto L10;
            Job.DefaultImpls.cancel$default(r106, null, 1, null);
        L10:
            r105.A = null;
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final e3a.b B3() {
        return (e3a.b) this.f377798w.getValue();
    }

    public final u2 C3() {
        return (u2) this.f377794s.getValue();
    }

    @Override // com.larus.voicecall.impl.component.vlm.a
    public final boolean H80() {
        if (z2.f365865a.realtimeCallUseTwoLineStyle() == false) goto L7;
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.C() == false) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // naa.a
    public final boolean mu() {
        if (this.C != ScreenShareState.SHARING) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.vlm.a.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, naa.a.class);
    }

    public final e3a.a z3() {
        return (e3a.a) this.f377797v.getValue();
    }

    public RealtimeScreenShareComponent() {
        this.f377789n = new f2a.d("ScreenShare", "FlowCallUI");
        this.f377791p = LazyKt.lazy(new com.larus.voicecall.impl.component.vlm.c(this));
        this.f377792q = LazyKt.lazy(new n(this));
        this.f377793r = LazyKt.lazy(new y(this));
        this.f377794s = LazyKt.lazy(new z(this));
        this.f377795t = LazyKt.lazy(new a0(this));
        this.f377796u = LazyKt.lazy(new b0(this));
        this.f377797v = LazyKt.lazy(new c0(this));
        this.f377798w = LazyKt.lazy(new d0(this));
        this.f377799x = LazyKt.lazy(new e0(this));
        this.f377800y = LazyKt.lazy(new f0());
        this.f377801z = true;
        this.B = jd9.c.f.f498762c;
        this.C = ScreenShareState.CLOSE;
        this.E = "";
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void A0() {
        B3();
        RealtimeCallService r100 = (RealtimeCallService) this.f377793r.getValue();
        C3();
        IRealtimeCallTracer r101 = (IRealtimeCallTracer) this.f377795t.getValue();
        w3a.k r102 = (w3a.k) this.f377796u.getValue();
    }

    public final String m3() {
        String r100 = z3().f470943v1;
        if (StringsKt.isBlank(r100) == true) goto L5;
        return r100;
    L5:
        return B3().f484260a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        u2 r100 = C3();
        if (r100 == null) goto L5;
        r100.Y0(null);
    L5:
        u2 r101 = C3();
        if (r101 == null) goto L8;
        r101.A1(null);
    L8:
        u2 r102 = C3();
        if (r102 == null) goto L11;
        r102.z0(null);
    L11:
        FLogger.f375446a.i("RealtimeScreenShareComponent", "onDestroy curState=" + this.C + '.');
        if (this.C != ScreenShareState.SHARING) goto L27;
        final boolean r103 = AppHost.f326268a.a().isAppBackground();
        final Ref.ObjectRef r104 = new Ref.ObjectRef();
        String r105 = B3().a().H;
        boolean r106 = StringsKt.isBlank(r105);
        T r107 = r105;
        if (r106 == false) goto L16;
        r107 = "end_call";
    L16:
        r104.element = r107;
        if (r103 == true) goto L19;
    L21:
        f2a.c r108 = this.f377789n.b("ScreenShareExitFragmentDestroy");
        r108.f475230c.f475256d = "RealtimeScreenShareComponent.onDestroy";
        String r109 = m3();
        if ((!StringsKt.isBlank(r109)) == true) goto L25;
        r109 = null;
    L25:
        r108.f475230c.f475254b = CollectionsKt.listOfNotNull(r109);
        r108.f(new k(r104, r103));
        f2a.c.c(r108, null, 15);
        p3((String) r104.element, ExitScreenShareReason.FRAGMENT_DESTROY, true);
        return;
    L19:
        if (Intrinsics.areEqual(r107, "end_call") == false) goto L21;
        r104.element = "end_share_screen_out_of_app";
        goto L21
    }

    @Override // com.larus.voicecall.impl.component.vlm.a
    public final int Li() {
        return this.f377790o;
    }

    public static Intent h3(MediaProjectionManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102100);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(102100, "android/media/projection/MediaProjectionManager", "createScreenCaptureIntent", r110, r111, "android.content.Intent", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (Intent) r106.f474983b;
    L21:
        return r110.createScreenCaptureIntent();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void D9(com.larus.im.service.audio.z0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof pf9.o0) == false) goto L12;
        ScreenShareState r101 = this.C;
        ScreenShareState r102 = ScreenShareState.SHARING;
        if (r101 == r102) goto L7;
    L9:
        if (r101 != r102) goto L14;
        StringBuilder r103 = new StringBuilder("event.isSuccess=");
        pf9.o0 r104 = (pf9.o0) r100;
        r103.append(r104.f528962a);
        r103.append(" curState=");
        r103.append(this.C);
        D3(-1, -1, true, r103.toString());
        FLogger.f375446a.e("RealtimeScreenShareComponent", "server enter screen share failed! event.isSuccess=" + r104.f528962a + " curState=" + this.C);
        return;
    L14:
        return;
    L7:
        if (((pf9.o0) r100).f528962a == false) goto L9;
        String r105 = this.E;
        com.larus.platform.service.o r106 = com.larus.platform.service.o.f365780a;
        JSONObject r107 = new JSONObject();
        int r108 = com.larus.voicecall.impl.util.x0.f379492a;
        com.larus.voicecall.impl.util.x0.a(r107, B3().a(), z3());
        r107.put("enter_method", r105);
        r107.put("current_page", "chat");
        Unit r109 = Unit.INSTANCE;
        r106.reportEvent("enter_share_screen", r107);
        return;
    }

    public final void E3(ScreenShareState r110) {
        com.larus.av_call.view.c r100 = null;
        boolean r101 = false;
        if (r110 != ScreenShareState.SHARING) goto L41;
        if (this.f377790o <= 0) goto L9;
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r102 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r102 == null) goto L9;
        int r103 = this.f377790o;
        r102.setPadding(r102.getPaddingLeft(), r103, r102.getPaddingRight(), r102.getPaddingBottom());
    L9:
        B3().f484279t = true;
        com.larus.voicecall.impl.component.vlm.b r104 = (com.larus.voicecall.impl.component.vlm.b) s1a.d.a(this).getAbility(com.larus.voicecall.impl.component.vlm.b.class);
        if (r104 == null) goto L12;
        r104.c30(ExitVideoModalReason.OPEN_SHARE_SCREEN, false);
    L12:
        com.larus.voicecall.impl.component.subtitle.a r105 = (com.larus.voicecall.impl.component.subtitle.a) s1a.d.a(this).getAbility(com.larus.voicecall.impl.component.subtitle.a.class);
        if (r105 == null) goto L15;
        r105.Zk("open_screen_share");
    L15:
        com.larus.voicecall.impl.component.bottom.b r106 = (com.larus.voicecall.impl.component.bottom.b) s1a.d.a(this).getAbility(com.larus.voicecall.impl.component.bottom.b.class);
        if (r106 == null) goto L37;
        VoiceCallBottomLayout r107 = r106.BT();
        if (r107 == null) goto L37;
        com.larus.av_call.view.c r108 = r107.f290583a;
        if (r108 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L23:
        View r109 = r100.h();
        if (r109 == null) goto L36;
        r109.setSelected(true);
        Application r111 = i88.e.f488685a;
        ThemeType r112 = r107.f290591i;
        boolean r113 = r107.f290595m;
        h88.b r114 = r107.f290588f;
        if (r114 != null) goto L28;
    L30:
        Intrinsics.checkNotNullParameter(r109, "<this>");
        Intrinsics.checkNotNullParameter(r112, "themeType");
        if (r101 == true) goto L35;
        if (r113 == true) goto L35;
        i88.e.o(r112);
    L35:
        r109.setBackgroundResource(R.drawable.larus_ic_voice_video_share_screen_select);
        goto L36
    L28:
        if (r114.f484277r != true) goto L30;
        r101 = true;
    L36:
        r107.u9(true);
        r107.c6();
        goto L37
    L22:
        r100 = r108;
    L37:
        ((IRealtimeCallTracer) this.f377795t.getValue()).B(IRealtimeCallTracer.TotalTimeType.SCREEN_SHARE_START_TIME, true);
        ((w3a.k) this.f377796u.getValue()).a(w3a.e.f558196a);
        w3a.k r115 = (w3a.k) this.f377799x.getValue();
        if (r115 == null) goto L79;
        r115.d(new w3a.l(true));
    L79:
        this.C = r110;
        return;
    L41:
        if (this.f377790o > 0) goto L43;
    L47:
        B3().f484279t = false;
        ((IRealtimeCallTracer) this.f377795t.getValue()).B(IRealtimeCallTracer.TotalTimeType.SCREEN_SHARE_START_TIME, false);
        if (this.D == true) goto L50;
        ((w3a.k) this.f377796u.getValue()).a(w3a.b.f558192a);
    L50:
        this.D = false;
        Lazy r116 = RealtimeNoticeDialogHelper.f379515a;
        com.larus.voicecall.impl.component.bottom.b r117 = (com.larus.voicecall.impl.component.bottom.b) s1a.d.a(this).getAbility(com.larus.voicecall.impl.component.bottom.b.class);
        if (r117 == null) goto L68;
        VoiceCallBottomLayout r118 = r117.BT();
        if (r118 == null) goto L68;
        com.larus.av_call.view.c r119 = r118.f290583a;
        if (r119 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L58:
        View r120 = r100.h();
        if (r120 == null) goto L67;
        r120.setSelected(false);
        Application r121 = i88.e.f488685a;
        ThemeType r122 = r118.f290591i;
        boolean r123 = r118.f290595m;
        h88.b r124 = r118.f290588f;
        if (r124 != null) goto L63;
    L65:
        boolean r125 = false;
    L66:
        i88.e.i(r120, r122, r123, r125);
        goto L67
    L63:
        if (r124.f484277r != true) goto L65;
        r125 = true;
    L67:
        r118.u9(false);
        r118.c6();
        goto L68
    L57:
        r100 = r119;
    L68:
        w3a.k r126 = (w3a.k) this.f377799x.getValue();
        if (r126 == null) goto L72;
        r126.d(new w3a.l(false));
    L72:
        if (z3().f484243k0 == false) goto L79;
        if (this.f377801z == false) goto L78;
        w3a.k r127 = (w3a.k) this.f377799x.getValue();
        if (r127 == null) goto L78;
        RealtimePageMode r128 = RealtimePageMode.HALF_SCREEN;
        int r129 = w3a.k.f558199g;
        r127.b(r128, 0);
    L78:
        this.f377801z = true;
        goto L79
    L43:
        if (z3().f484243k0 == false) goto L47;
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r130 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r130 == null) goto L47;
        r130.setPadding(r130.getPaddingLeft(), 0, r130.getPaddingRight(), r130.getPaddingBottom());
        goto L47
    }

    @Override // com.larus.voicecall.impl.component.vlm.a
    public final com.larus.bmhome.view.screenmenu.l0 EY(int r410) {
        String r100 = Y2(R.string.larus_call_shareScreen_title);
        Integer r110 = Integer.valueOf(R.drawable.larus_ic_realtime_screen_share);
        if (B3().f484279t == true) goto L29;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r101 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext();
        if (r101 == null) goto L7;
        Pair<Boolean, Boolean> r111 = com.larus.voicecall.impl.l.f378359i;
        boolean r102 = com.larus.voicecall.impl.l.a.b(r101);
    L8:
        com.larus.voicecall.impl.component.scene.a r103 = (com.larus.voicecall.impl.component.scene.a) s1a.d.a(this).getAbility(com.larus.voicecall.impl.component.scene.a.class);
        if (r103 != null) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r102 == true) goto L16;
    L26:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L29;
        boolean r112 = true;
    L30:
        boolean r106 = v19.h.f552477a;
        if (v19.h.b(getContext()) == false) goto L33;
        Integer r107 = -1;
    L35:
        return new com.larus.bmhome.view.screenmenu.l0(r410, 0, r100, null, null, null, null, null, null, false, false, null, r110, null, false, r112, r107, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -200710, 127);
    L33:
        r107 = null;
        goto L35
    L16:
        if (B3().f484263d == false) goto L26;
        if (r104 == false) goto L21;
        if (z3().f484243k0 == false) goto L26;
    L21:
        if (B3().f484270k == 6) goto L26;
        if (B3().f484270k == 7) goto L26;
        r105 = false;
        goto L27
    L11:
        if (r103.oY() != true) goto L13;
        r104 = true;
        goto L14
    L7:
        r102 = true;
    L29:
        r112 = false;
        goto L30
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void I6(jd9.c r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.B = r100;
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.B() == true) goto L5;
        return;
    L5:
        if ((r100 instanceof jd9.c.d) == true) goto L7;
        return;
    L7:
        if (this.C != ScreenShareState.SHARING) goto L12;
        p3("lose_internet_connection", ExitScreenShareReason.SESSION_DISCONNECT, true);
        return;
    }

    @Override // com.larus.voicecall.impl.component.vlm.a, naa.a
    public final void P6(String r110) {
        String r100 = "";
        if (r110 != null) goto L5;
        r110 = "";
    L5:
        this.E = r110;
        com.larus.platform.service.o r101 = com.larus.platform.service.o.f365780a;
        JSONObject r102 = new JSONObject();
        int r103 = com.larus.voicecall.impl.util.x0.f379492a;
        com.larus.voicecall.impl.util.x0.a(r102, B3().a(), z3());
        r102.put("enter_method", r110);
        r102.put("current_page", "chat");
        Unit r111 = Unit.INSTANCE;
        r101.reportEvent("click_share_screen", r102);
        f2a.c r112 = this.f377789n.b("ScreenShareEnterRequest");
        r112.f475230c.f475256d = "RealtimeScreenShareComponent.tryEnterScreenShareMode";
        String r104 = m3();
        if ((!StringsKt.isBlank(r104)) == true) goto L9;
        r104 = null;
    L9:
        r112.f475230c.f475254b = CollectionsKt.listOfNotNull(r104);
        r112.f(new l(this));
        f2a.c.c(r112, null, 15);
        u2 r113 = C3();
        if (r113 == null) goto L12;
        RealtimeVlmLimitStatus r114 = r113.W1();
    L14:
        if (r114 == RealtimeVlmLimitStatus.DOWNGRADE) goto L16;
    L23:
        u2 r115 = C3();
        if (r115 == null) goto L26;
        RealtimeVlmLimitStatus r116 = r115.W1();
    L28:
        if (r116 == RealtimeVlmLimitStatus.NOT_LIMIT) goto L35;
        Lazy r117 = RealtimeNoticeDialogHelper.f379515a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        RealtimeNoticeDialogHelper.a(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        FLogger.f375446a.i("RealtimeScreenShareComponent", "can not screen share, because of limited!");
        f2a.c r118 = this.f377789n.c("ScreenShareEnterBlockedLimited");
        r118.f475230c.f475256d = "RealtimeScreenShareComponent.tryEnterScreenShareMode";
        String r105 = m3();
        if ((!StringsKt.isBlank(r105)) == true) goto L33;
        r105 = null;
    L33:
        r118.f475230c.f475254b = CollectionsKt.listOfNotNull(r105);
        f2a.c.c(r118, null, 15);
        return;
    L35:
        com.larus.voicecall.impl.component.scene.a r119 = (com.larus.voicecall.impl.component.scene.a) s1a.d.a(this).getAbility(com.larus.voicecall.impl.component.scene.a.class);
        if (r119 != null) goto L38;
    L40:
        boolean r120 = false;
    L41:
        if (r120 == false) goto L52;
        String r121 = Y2(R.string.larus_call_shareScreen_unavailable);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r106 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext();
        if (r106 == null) goto L45;
        t19.s.j(t19.s.f544207a, r106, r121, 0, false, 24);
    L45:
        f2a.c r122 = this.f377789n.c("ScreenShareEnterBlockedSceneMode");
        r122.f475230c.f475256d = "RealtimeScreenShareComponent.tryEnterScreenShareMode";
        String r107 = m3();
        if ((!StringsKt.isBlank(r107)) == true) goto L49;
        r107 = null;
    L49:
        r122.f475230c.f475254b = CollectionsKt.listOfNotNull(r107);
        f2a.c.c(r122, null, 15);
        return;
    L52:
        if ((this.B instanceof jd9.c.a) == true) goto L96;
        FLogger.f375446a.e("RealtimeScreenShareComponent", "curConnectState is " + this.B + ", so cannot connect");
        f2a.c r123 = this.f377789n.c("ScreenShareEnterBlockedNotConnected");
        r123.f475230c.f475256d = "RealtimeScreenShareComponent.tryEnterScreenShareMode";
        String r108 = m3();
        if ((!StringsKt.isBlank(r108)) == true) goto L57;
        r108 = null;
    L57:
        r123.f475230c.f475254b = CollectionsKt.listOfNotNull(r108);
        r123.f(new m(this));
        f2a.c.c(r123, null, 15);
        return;
    L96:
        Object r109 = AppHost.f326268a.getApplication().getSystemService("media_projection");     // Catch: Throwable -> L89
        if ((r109 instanceof MediaProjectionManager) == false) goto L63;
        MediaProjectionManager r124 = (MediaProjectionManager) r109;     // Catch: Throwable -> L89
    L64:
        if (r124 == null) goto L83;
        z68.c r125 = z68.c.f570543a;     // Catch: Throwable -> L89
        String r126 = this.E;     // Catch: Throwable -> L89
        r125.getClass();     // Catch: Throwable -> L89
        if (r126 == null) goto L69;
        r100 = r126;
    L69:
        String r127 = r100.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L89
        if (StringsKt.contains$default(r127, "resume", false, 2, null) == false) goto L73;
        String r128 = DownloadSettingKeys.AUTO_RESUME;
    L76:
        z68.c.i(r128);     // Catch: Throwable -> L89
        f2a.c r129 = this.f377789n.b("ScreenSharePermissionRequestStart");     // Catch: Throwable -> L89
        r129.f475230c.f475256d = "RealtimeScreenShareComponent.enterScreenShareMode";     // Catch: Throwable -> L89
        String r130 = m3();     // Catch: Throwable -> L89
        if ((!StringsKt.isBlank(r130)) == true) goto L80;
        r130 = null;
    L80:
        r129.f475230c.f475254b = CollectionsKt.listOfNotNull(r130);     // Catch: Throwable -> L89
        f2a.c.c(r129, null, 15);     // Catch: Throwable -> L89
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L89
        FragmentActivity r131 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();     // Catch: Throwable -> L89
        if (r131 == null) goto L97;
        r131.startActivityForResult(h3(r124), 101);     // Catch: Throwable -> L89
        return;
    L97:
        return;
    L73:
        if (StringsKt.contains$default(r127, EventConstant.Value.RETRY, false, 2, null) == false) goto L75;
        r128 = "system_retry";
        goto L76
    L75:
        r128 = "user_click";
        goto L76
    L83:
        FLogger.f375446a.e("RealtimeScreenShareComponent", "current os version too low，do not support screen share!");     // Catch: Throwable -> L89
        z68.c r132 = z68.c.f570543a;     // Catch: Throwable -> L89
        RealtimeCallUtil.f379424a.getClass();     // Catch: Throwable -> L89
        int r133 = RealtimeCallUtil.q().b();     // Catch: Throwable -> L89
        int r134 = RealtimeCallUtil.q().a();     // Catch: Throwable -> L89
        int r135 = RealtimeCallUtil.q().c();     // Catch: Throwable -> L89
        r132.getClass();     // Catch: Throwable -> L89
        z68.c.j(false, r133, r134, r135, new da9.e(0), "runtime_error", "projection_manager_null");     // Catch: Throwable -> L89
        f2a.c r136 = this.f377789n.a("ScreenSharePermissionRequestNoProjectionManager");     // Catch: Throwable -> L89
        r136.f475230c.f475256d = "RealtimeScreenShareComponent.enterScreenShareMode";     // Catch: Throwable -> L89
        String r137 = m3();     // Catch: Throwable -> L89
        if ((!StringsKt.isBlank(r137)) == true) goto L87;
        r137 = null;
    L87:
        r136.f475230c.f475254b = CollectionsKt.listOfNotNull(r137);     // Catch: Throwable -> L89
        f2a.c.c(r136, null, 15);     // Catch: Throwable -> L89
        return;
    L63:
        r124 = null;
    L89:
        th = move-exception;
        FLogger.f375446a.e("RealtimeScreenShareComponent", "enterScreenShareMode on err! msg=" + th);
        z68.c r138 = z68.c.f570543a;
        RealtimeCallUtil.f379424a.getClass();
        int r139 = RealtimeCallUtil.q().b();
        int r140 = RealtimeCallUtil.q().a();
        int r141 = RealtimeCallUtil.q().c();
        String r142 = th.getClass().getSimpleName();
        r138.getClass();
        z68.c.j(false, r139, r140, r141, new da9.e(0), "runtime_error", r142);
        f2a.c r143 = this.f377789n.a("ScreenSharePermissionRequestException");
        r143.f475230c.f475256d = "RealtimeScreenShareComponent.enterScreenShareMode";
        String r144 = m3();
        if ((!StringsKt.isBlank(r144)) == true) goto L94;
        r144 = null;
    L94:
        r143.f475230c.f475254b = CollectionsKt.listOfNotNull(r144);
        r143.f(new w(th));
        f2a.c.c(r143, null, 15);
        EnsureManager.ensureNotReachHere(th, "enterScreenShareMode failed!");
        return;
    L38:
        if (r119.oY() != true) goto L40;
        r120 = true;
        goto L41
    L26:
        r116 = null;
        goto L28
    L16:
        if ((!StringsKt.isBlank(RealtimeNoticeDialogHelper.f379517c)) == false) goto L23;
        Context r145 = getContext();
        Intrinsics.checkNotNullParameter(r145, "ctx");
        t19.s.j(t19.s.f544207a, r145, RealtimeNoticeDialogHelper.f379517c, null, false, 28);
        FLogger.f375446a.e("RealtimeScreenShareComponent", "can not screen share, because of downgrade!");
        f2a.c r146 = this.f377789n.c("ScreenShareEnterBlockedDowngrade");
        r146.f475230c.f475256d = "RealtimeScreenShareComponent.tryEnterScreenShareMode";
        String r147 = m3();
        if ((!StringsKt.isBlank(r147)) == true) goto L21;
        r147 = null;
    L21:
        r146.f475230c.f475254b = CollectionsKt.listOfNotNull(r147);
        f2a.c.c(r146, null, 15);
        return;
    L12:
        r114 = null;
        goto L14
    }

    @Override // naa.a
    public final void Wf(String r100) {
        Intrinsics.checkNotNullParameter(r100, "endMethod");
        if (this.C != ScreenShareState.SHARING) goto L6;
        this.D = false;
        p3(r100, ExitScreenShareReason.O_EXIT_SCREEN_SHARE, true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.voicecall.impl.component.vlm.q] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.voicecall.impl.component.vlm.p] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.voicecall.impl.component.vlm.s] */
    @Override // com.larus.av_call.component.RealtimeComponent, com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        g3a.a r101 = (g3a.a) this.f377791p.getValue();
        if (r101 == null) goto L7;
        RealtimeCallScreenShareLayout r102 = r101.Df();
        if (r102 == null) goto L7;
        r102.setScreenShareExitClickListener(new o(this));
    L7:
        u2 r103 = C3();
        if (r103 == 0) goto L10;
        r103.z0(new p(this));
    L10:
        u2 r104 = C3();
        if (r104 == 0) goto L13;
        r104.Y0(new q(this));
    L13:
        u2 r105 = C3();
        if (r105 == null) goto L16;
        r105.A1(new r(this));
    L16:
        MutableLiveData<b19.a> r106 = b19.b.f16952a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r106.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this), new c(new s(this)));
        ((w3a.k) this.f377796u.getValue()).c(new b(this));
    }

    @Override // com.larus.voicecall.impl.component.vlm.a
    public final void setTopPadding(int r100) {
        this.f377790o = r100;
    }

    @Override // com.larus.voicecall.impl.component.vlm.a
    public final void Yh(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "clickMethod");
        FLogger r102 = FLogger.f375446a;
        r102.i("RealtimeScreenShareComponent", "click share screen btn. isSelected=" + r100 + ", room_id=" + B3().f484262c);
        Keva r103 = RealtimeCallDegradeManager.f378324a;
        if (RealtimeCallDegradeManager.h("video_call", "video_button", true) == false) goto L6;
        r102.e("RealtimeScreenShareComponent", "share screen is not available, because of downgrade!");
        return;
    L6:
        if (r100 == true) goto L8;
        P6(r101);
        return;
    L8:
        Intrinsics.checkNotNullParameter("voice_call", "scene");
        if (((Boolean) RealtimeCallDegradeManager.g("voice_call", true).getFirst()).booleanValue() == false) goto L12;
        r102.e("RealtimeScreenShareComponent", "voice call is not available, because of time limit downgrade!");
        return;
    L12:
        DW(r101, ExitScreenShareReason.USER_CLICK, false, true);
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void z2(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r100, "event");
        if (Intrinsics.areEqual(r100, "OTHER_EVENT_RTC_END_SCREEN_SHARE") == false) goto L28;
        FLogger r102 = FLogger.f375446a;
        r102.i("RealtimeScreenShareComponent", "otherEvent event=".concat(r100));
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L19
        boolean r104 = z2.f365865a.V0();     // Catch: Throwable -> L19
        if (this.C != ScreenShareState.SHARING) goto L17;
        if (r104 == false) goto L17;
        if ((r101 instanceof String) == false) goto L12;
        String r105 = (String) r101;     // Catch: Throwable -> L19
    L14:
        if (r105 != null) goto L16;
        r105 = "";
    L16:
        JSONObject r106 = new JSONObject(r105);     // Catch: Throwable -> L19
        D3(r106.optInt("device_state", -1), r106.optInt("device_error", -1), false, "");     // Catch: Throwable -> L19
        r102.e("RealtimeScreenShareComponent", "exit screen share for error. content=" + r101);     // Catch: Throwable -> L19
        DW("on_error_from_rtc", ExitScreenShareReason.EXIT_FOR_RTC_ERROR, false, true);     // Catch: Throwable -> L19
        goto L17
    L12:
        r105 = null;
    L17:
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L29;
        FLogger.f375446a.e("RealtimeScreenShareComponent", "otherEvent  OTHER_EVENT_RTC_END_SCREEN_SHARE error. error=" + r108 + " , content=" + r101);
        return;
    L29:
        return;
    L19:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void onActivityResult(final int r110, final int r111, Intent r112) {
        if (r112 != null) goto L10;
        FLogger.f375446a.e("RealtimeScreenShareComponent", "onActivityResult on err. data is empty!");
        f2a.c r100 = this.f377789n.a("ScreenSharePermissionResultMissingData");
        r100.f475230c.f475256d = "RealtimeScreenShareComponent.onActivityResult";
        String r101 = m3();
        if ((true ^ StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        r100.f475230c.f475254b = CollectionsKt.listOfNotNull(r101);
        r100.f(new d(r110, r111));
        f2a.c.c(r100, null, 15);
        return;
    L10:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r102 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r102 == null) goto L13;
        String r103 = r102.getClass().getCanonicalName();
    L14:
        if (r103 != null) goto L16;
        r103 = "";
    L16:
        String r113 = r103;
        if (StringsKt.isBlank(r113) == false) goto L25;
        FLogger.f375446a.e("RealtimeScreenShareComponent", "activity name is empty");
        f2a.c r104 = this.f377789n.a("ScreenSharePermissionResultActivityNameEmpty");
        r104.f475230c.f475256d = "RealtimeScreenShareComponent.onActivityResult";
        String r105 = m3();
        if ((true ^ StringsKt.isBlank(r105)) == true) goto L22;
        r105 = null;
    L22:
        r104.f475230c.f475254b = CollectionsKt.listOfNotNull(r105);
        r104.f(new e(r110, r111));
        f2a.c.c(r104, null, 15);
        return;
    L25:
        if (r110 == 101) goto L27;
    L61:
        z68.c.f570543a.getClass();
        Object r106 = z68.c.f570544b;
        monitor-enter(r106);
        z68.b r107 = z68.c.f570545c;     // Catch: Throwable -> L80
        monitor-exit(r106);
        if (r107 == null) goto L71;
        da9.e r114 = r107.f570542c;
        da9.c r115 = r114.f467731e;
        da9.c r116 = r107.f570542c.f467731e;
        z68.c.g("flow_screen_share_start_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", "fail"), TuplesKt.to("reason", "permission_denied"), TuplesKt.to("error_code", "permission_denied"), TuplesKt.to("start_cost_ms", Integer.valueOf((int) (SystemClock.elapsedRealtime() - r107.f570540a))), TuplesKt.to("profile", z68.c.e(r115.f467722b, r115.f467723c, r114.f467728b)), TuplesKt.to("resolution", z68.c.k(r116.f467722b, r116.f467723c)), TuplesKt.to("target_fps", Integer.valueOf(r107.f570542c.f467728b))}));
        monitor-enter(r106);
        z68.c.f570545c = null;     // Catch: Throwable -> L77
        z68.c.f570546d = null;     // Catch: Throwable -> L77
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L77
        monitor-exit(r106);
    L77:
        th = move-exception;
        throw th;
    L71:
        f2a.c r109 = this.f377789n.c("ScreenSharePermissionResultDeniedOrOther");
        r109.f475230c.f475256d = "RealtimeScreenShareComponent.onActivityResult";
        String r117 = m3();
        if ((true ^ StringsKt.isBlank(r117)) == true) goto L75;
        r117 = null;
    L75:
        r109.f475230c.f475254b = CollectionsKt.listOfNotNull(r117);
        r109.f(new i(r110, r111));
        f2a.c.c(r109, null, 15);
        return;
    L80:
        th = move-exception;
        throw th;
    L27:
        if (r111 != (-1)) goto L61;
        f2a.c r118 = this.f377789n.b("ScreenSharePermissionResultGranted");
        r118.f475230c.f475256d = "RealtimeScreenShareComponent.onActivityResult";
        String r119 = m3();
        if ((!StringsKt.isBlank(r119)) == true) goto L32;
        r119 = null;
    L32:
        r118.f475230c.f475254b = CollectionsKt.listOfNotNull(r119);
        r118.f(new f(r110, r111));
        f2a.c.c(r118, null, 15);
        E3(ScreenShareState.SHARING);
        boolean r120 = com.larus.im.a.a().c().shareScreenUseSoftAec();
        z2 r121 = z2.f365865a;
        boolean r122 = r121.shareScreenEnableDualAec();
        FLogger r123 = FLogger.f375446a;
        r123.i("RealtimeScreenShareComponent", "onActivityResult shareScreenUseSoftAec=" + r120 + " shareScreenEnableDualAec=" + r122);
        z3 r124 = r121.v3();
        if (r122 == false) goto L36;
        boolean r125 = r124.c();
    L40:
        if (r125 == false) goto L44;
        com.larus.voicecall.impl.component.core.a r126 = (com.larus.voicecall.impl.component.core.a) this.f377792q.getValue();
        if (r126 == null) goto L44;
        r126.UQ();
    L44:
        RealtimeCallUtil.f379424a.getClass();
        final com.larus.im.service.audio.f1 r127 = new com.larus.im.service.audio.f1(r113, Y2(R.string.larus_call_shareScreen_android_notification_desc), r112, RealtimeCallUtil.q().c(), RealtimeCallUtil.q().b(), RealtimeCallUtil.q().a(), r125);
        r123.i("RealtimeScreenShareComponent", "startScreenShare encoderFrameRate=" + RealtimeCallUtil.q().c() + " activityCanonicalName=" + r113 + " needCheckToCallMode=" + r125 + " encoderWidth=" + RealtimeCallUtil.q().b() + " encoderHeight=" + RealtimeCallUtil.q().a());
        f2a.c r128 = this.f377789n.b("ScreenShareStartInvoke");
        r128.f475230c.f475256d = "RealtimeScreenShareComponent.onActivityResult";
        String r129 = m3();
        if ((!StringsKt.isBlank(r129)) == true) goto L48;
        r129 = null;
    L48:
        r128.f475230c.f475254b = CollectionsKt.listOfNotNull(r129);
        r128.f(new g(r127, this));
        f2a.c.c(r128, null, 15);
        if (((Boolean) this.f377800y.getValue()).booleanValue() == false) goto L54;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Job r130 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner()), Dispatchers.getIO(), null, new AnonymousClass9(this, r127, null), 2, null);
        Job r131 = this.A;
        if (r131 == null) goto L53;
        Job.DefaultImpls.cancel$default(r131, null, 1, null);
    L53:
        this.A = r130;
    L57:
        if (r125 == false) goto L88;
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r132 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r132 == null) goto L89;
        r132.postDelayed(new h(this), 500);
        return;
    L89:
        return;
    L88:
        return;
    L54:
        u2 r133 = C3();
        if (r133 == null) goto L57;
        r133.n(r127);
        goto L57
    L36:
        if (r124.c() == false) goto L39;
        if (r120 == true) goto L39;
        r125 = true;
    L39:
        r125 = false;
        goto L40
    L13:
        r103 = null;
        goto L14
    }

    public final void p3(final String r100, final ExitScreenShareReason r101, final boolean r102) {
        if (r101 == ExitScreenShareReason.ENTER_VIDEO_CALL) goto L5;
    L7:
        FLogger.f375446a.i("RealtimeScreenShareComponent", "exitScreenShareMode  endMethod=" + r100);
        f2a.c r103 = this.f377789n.b("ScreenShareStopInvoke");
        r103.f475230c.f475256d = "RealtimeScreenShareComponent.exitScreenShareMode";
        String r104 = m3();
        if ((!StringsKt.isBlank(r104)) == true) goto L11;
        r104 = null;
    L11:
        r103.f475230c.f475254b = CollectionsKt.listOfNotNull(r104);
        r103.f(new j(r100, r101, r102));
        f2a.c.c(r103, null, 15);
        ((IRealtimeCallTracer) this.f377795t.getValue()).e0(this.E, r100, B3().a(), z3());
        com.larus.im.service.audio.e1 r105 = new com.larus.im.service.audio.e1(z2.f365865a.v3().c());
        Job r106 = this.A;
        if (r106 == null) goto L14;
        Job.DefaultImpls.cancel$default(r106, null, 1, null);
    L14:
        this.A = null;
        u2 r107 = C3();
        if (r107 == null) goto L17;
        r107.n0(r102, r105);
    L17:
        E3(ScreenShareState.CLOSE);
        return;
    L5:
        if (z3().f484243k0 == false) goto L7;
        this.f377801z = false;
        FLogger.f375446a.i("RealtimeScreenShareComponent", "exitScreenShareMode  endMethod=" + r100 + " exitChannel=" + r101);
        goto L7
    }

    public final void D3(int r100, int r101, boolean r102, String r103) {
        com.larus.platform.service.o r104 = com.larus.platform.service.o.f365780a;
        JSONObject r105 = new JSONObject();
        r105.put("is_checkout_modal_error", r102);
        r105.put("error_msg", r103);
        r105.put("device_state", r100);
        r105.put("device_error", r101);
        r105.put("modal_type", "screen_share");
        int r106 = com.larus.voicecall.impl.util.x0.f379492a;
        com.larus.voicecall.impl.util.x0.a(r105, B3().a(), z3());
        Unit r107 = Unit.INSTANCE;
        r104.reportEvent("realtime_vlm_call_error", r105);
    }

    @Override // com.larus.voicecall.impl.component.vlm.a
    public final void DW(String r100, ExitScreenShareReason r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "endMethod");
        Intrinsics.checkNotNullParameter(r101, "endChannel");
        if (this.C != ScreenShareState.SHARING) goto L6;
        this.D = r102;
        p3(r100, r101, r103);
        return;
    }
}
