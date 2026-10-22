package com.obric.assistant.session.endpoint;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.product.platform.api.pocketmode.PocketModeDetector;
import com.obric.assistant.multiuser.api.IObricMultiUserService;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.IDoraOperation;
import com.obric.assistant.session.model.ISessionEndPoint;
import com.obric.assistant.session.model.IVoiceWakeupOperation;
import com.obric.assistant.spi.audio.ObricBackTraceLogDelegate;
import com.obric.assistant.spi.audio.ObricWakeupAudioCaptureDelegate;
import com.obric.assistant.spi.audio.ObricWakeupTruthUploadDelegate;
import com.obric.assistant.spi.audio.WakeupAudioCaptureTriggerType;
import com.obric.assistant.spi.wakeup.ObricOneshotDelegate;
import com.obric.assistant.spi.wakeup.WakeupLatencyTrackDelegate;
import com.obric.assistant.t1;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0014H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\bH\u0016J\u0012\u0010!\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010\"\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%H\u0002J\f\u0010,\u001a\u00020\u0014*\u00020+H\u0002J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u001bH\u0016J\u0013\u0010/\u001a\u00020\u001c*\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u00100J\f\u0010/\u001a\u00020\u001c*\u00020\u001cH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/assistant/session/endpoint/VoiceWakeupSessionEndpoint;", "Lcom/obric/assistant/session/model/ISessionEndPoint;", "Lcom/obric/assistant/session/model/IVoiceWakeupOperation;", "<init>", "()V", "isHandlingActivateTimerRunning", "", "uniqueWakeupId", "", "shouldNotifyVoiceWakeupGenerated", "notificationScope", "Lkotlinx/coroutines/CoroutineScope;", "prepareOrder", "getPrepareOrder", "()I", "processOrder", "getProcessOrder", "pocketModeDetector", "Lcom/obric/aiagent/product/platform/api/pocketmode/PocketModeDetector;", "onSessionPrepared", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "args", "Landroid/os/Bundle;", "onSessionProcess", "Lkotlin/Pair;", "Lcom/obric/assistant/session/bean/ErrorCode;", "", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearOneshotTask", "clearOneshotPipe", "getWakeupId", "trackWakeupS3", "handleOneshotParams", "notifyBreathCaptureInteractionStartIfNeeded", "interactionAudioStartTimeMs", "", "mainHandler", "Landroid/os/Handler;", "delayedClearOneshotPipe", "Ljava/lang/Runnable;", "countDownTimer", "Landroid/os/CountDownTimer;", "go", "onSessionCompleted", "code", "toLogTail", "(Ljava/lang/Integer;)Ljava/lang/String;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceWakeupSessionEndpoint implements ISessionEndPoint, IVoiceWakeupOperation {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f391544i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f391545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f391546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f391547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f391548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PocketModeDetector f391549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f391550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w0 f391551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f391552h;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f391553a = null;

        static {
            int[] r100 = new int[ErrorCode.values().length];
            r100[ErrorCode.QUIT_SESSION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ErrorCode.ONLY_END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ErrorCode.END_ON_SHOW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ErrorCode.LAUNCH_ASSISTANT_DIRECTLY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f391553a = r100;
        }
    }

    public static final class c extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceWakeupSessionEndpoint f391554a;

        @Override // android.os.CountDownTimer
        public final void onTick(long r100) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            this.f391554a.f391545a = false;
            FLogger r100 = FLogger.f375446a;
            VoiceWakeupSessionEndpoint r101 = this.f391554a;
            r101.getClass();
            r100.i(ISessionEndPoint.a.b(r101), "activate Countdown timer onFinish");
        }

        public c(VoiceWakeupSessionEndpoint r100) {
            this.f391554a = r100;
            super(800, 200);
        }
    }

    static {
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int f() {
        return -50;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int h() {
        return 20;
    }

    @Override // com.obric.assistant.session.model.IVoiceWakeupOperation
    public final void a() {
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "clearOneshotTask executes now !");
        wna.a.a();
        wna.a.d();
        ObricOneshotDelegate.f392920b.g();
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTagName() {
        return "VoiceWakeupSessionEndpoint";
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.obric.assistant.session.endpoint.w0] */
    public VoiceWakeupSessionEndpoint() {
        this.f391546b = -1;
        this.f391548d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f391549e = PocketModeDetector.f385009a;
        this.f391550f = new Handler(Looper.getMainLooper());
        this.f391551g = new w0(this);
        this.f391552h = new c(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public Context getContext() {
        return ISessionEndPoint.a.getContext(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTAG() {
        return ISessionEndPoint.a.b(this);
    }

    @Override // com.obric.assistant.session.model.IVoiceWakeupOperation
    public final int b() {
        return this.f391546b;
    }

    public static String c(Integer r100) {
        if (r100 == null) goto L13;
        String r101 = r100.toString();
        if (r101 == null) goto L13;
        if (r101.length() != 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        String r103 = "";
    L14:
        if (r103 != null) goto L17;
        return "";
    L17:
        return r103;
    L12:
        r103 = "***" + StringsKt.takeLast(r101, 4);
        goto L14
    L9:
        r102 = false;
    L13:
        r103 = null;
        goto L14
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void n(ErrorCode r110) {
        Intrinsics.checkNotNullParameter(r110, "code");
        FLogger r100 = FLogger.f375446a;
        r100.i(ISessionEndPoint.a.b(this), "onSessionCompleted " + r110 + " requestFrom " + bga.j.a());
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_VOICE_ASSIST") == false) goto L6;
        this.f391550f.removeCallbacks(this.f391551g);
    L6:
        if (r110 == ErrorCode.END_ON_SHOW) goto L8;
    L10:
        int r111 = b.f391553a[r110.ordinal()];
        if (r111 == 1) goto L23;
        if (r111 == 2) goto L20;
        if (r111 == 3) goto L20;
        if (r111 == 4) goto L20;
        return;
    L20:
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_VOICE_ASSIST") == false) goto L26;
        r100.i(ISessionEndPoint.a.b(this), "clearOneshotPipe");
        this.f391550f.postDelayed(this.f391551g, 0);
        return;
    L26:
        return;
    L23:
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_VOICE_ASSIST") == false) goto L28;
        r100.i(ISessionEndPoint.a.b(this), "clearOneshotTask");
        a();
        return;
    L28:
        return;
    L8:
        if (this.f391547c == false) goto L10;
        this.f391547c = false;
        BuildersKt.launch$default(this.f391548d, null, null, new VoiceWakeupSessionEndpoint$onSessionCompleted$1(null), 3, null);
        goto L10
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final Object d(Bundle r410, Continuation<? super Pair<? extends ErrorCode, String>> r411) {
        if ((r411 instanceof VoiceWakeupSessionEndpoint$onSessionProcess$1) == false) goto L7;
        VoiceWakeupSessionEndpoint$onSessionProcess$1 r100 = (VoiceWakeupSessionEndpoint$onSessionProcess$1) r411;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r102);
        Object r210 = "WAKEUP_SOURCE_DORA_VOICE_WAKEUP";
        Object r110 = "";
    L254:
        if (((Boolean) r102).booleanValue() == true) goto L256;
        boolean r105 = true;
    L258:
        if (Intrinsics.areEqual(bga.j.c(), "VOICE") == false) goto L260;
        ObricWakeupTruthUploadDelegate.f392845b.d(this.f391546b, r105);
    L260:
        if (r105 == false) goto L264;
        this.f391549e.f(false, AppHost.f326268a.a().isAppBackground(), new x0());
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "onSessionProcess, return because in pocket mode");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "Voice-in-pocket-mode");
    L264:
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_VOICE_ASSIST") == false) goto L266;
    L269:
        boolean r106 = true;
    L270:
        this.f391547c = r106;
        return TuplesKt.to(ErrorCode.CONTINUE, r110);
    L266:
        if (Intrinsics.areEqual(bga.j.a(), r210) == true) goto L269;
        r106 = false;
    L256:
        r105 = false;
        goto L258
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Bundle r107 = (Bundle) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L20:
        Application r111 = AppHost.f326268a.getApplication();
        IWakeupStatisticsAPI r108 = wha.a.a();
        if (r108 == null) goto L24;
        r108.clear();
    L24:
        if (r107 == null) goto L26;
        long r112 = r107.getLong(InteractConst.WAKEUP_REQUEST_TIME);
    L27:
        if (r107 == null) goto L29;
        long r109 = r107.getLong(InteractConst.WAKEUP_REQUEST_TIME);
    L30:
        long r113 = System.currentTimeMillis();
        if (r109 <= 0) goto L34;
        WakeupLatencyTrackDelegate r114 = WakeupLatencyTrackDelegate.f392924b;
        r114.d(bga.j.a(), bga.j.c(), r109);
        r114.b(r113);
    L34:
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_VOICE_ASSIST") == true) goto L37;
    L35:
        int r115 = -1;
    L48:
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "onShow handle oneshot params ---> start! ");
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L51
        ObricBackTraceLogDelegate.f392833b.b(r107.getInt("backtrace_history_length", 0));     // Catch: Throwable -> L51
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L51
    L54:
        if (r107 != null) goto L57;
        Object r117 = "WAKEUP_SOURCE_DORA_VOICE_WAKEUP";
    L60:
        r210 = r117;
        r110 = "";
        Application r118 = r111;
        Object r412 = r103;
    L91:
        int r119 = r107.getInt(InteractConst.USER_HANDLE_ID, 0);
        IObricMultiUserService.f390298a.getClass();
        IObricMultiUserService r120 = IObricMultiUserService.a.a();
        Unit r121 = null;
        if (r120 == null) goto L94;
        Integer r122 = Boxing.boxInt(r120.c());
    L95:
        FLogger r123 = FLogger.f375446a;
        r123.i(ISessionEndPoint.a.b(this), "onShow check userhandle given " + c(Boxing.boxInt(r119)) + " and current " + c(r122) + " requestFrom " + bga.j.a());
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_VOICE_ASSIST") == false) goto L104;
        if (r122 != null) goto L100;
    L101:
        r123.e(ISessionEndPoint.a.b(this), "onShow bad uid givenUid : " + c(Boxing.boxInt(r119)) + " myID : " + c(r122));
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "Voice-wrong-uid");
    L100:
        if (r119 != r122.intValue()) goto L101;
    L104:
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_VOICE_ASSIST") == false) goto L145;
        IDoraService r124 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r124 == null) goto L110;
        DeviceService r125 = r124.device();
        if (r125 == null) goto L110;
        boolean r126 = r125.J();
    L111:
        if (r124 == null) goto L113;
        boolean r127 = r124.b();
    L114:
        if (r124 == null) goto L118;
        DeviceService r128 = r124.device();
        if (r128 == null) goto L118;
        boolean r129 = r128.M();
    L119:
        if (r129 == false) goto L125;
        if (r127 == true) goto L122;
    L124:
        boolean r130 = false;
    L126:
        r123.i(ISessionEndPoint.a.b(this), "from voice wakeup and dora state is  connect ? " + r126 + " switch " + r127 + ", suppressForDora " + r130);
        IDoraOperation r131 = bga.f.a();
        if (r131 == null) goto L129;
        boolean r132 = r131.c();
    L130:
        if (r132 == true) goto L145;
        if (r126 == false) goto L145;
        if (r130 == false) goto L145;
        if (Intrinsics.areEqual(bga.j.c(), "BREATH") == true) goto L145;
        r123.e(ISessionEndPoint.a.b(this), "onShow return caused by the dora is online  ,but the interactor is not working correctly");
        CoWakeupApi r133 = uha.a.a();     // Catch: Throwable -> L141
        if (r133 == null) goto L139;
        r133.reload();     // Catch: Throwable -> L141
        r121 = Unit.INSTANCE;     // Catch: Throwable -> L141
    L139:
        Result.m9449constructorimpl(r121);     // Catch: Throwable -> L141
    L143:
        com.obric.assistant.utils.o.f393884a.getClass();
        com.obric.assistant.utils.o.c(r107, "interactor not working", "Voice-sync-error");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "Voice-sync-error");
    L141:
        th = move-exception;
        Result.Companion r134 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L143
    L129:
        r132 = false;
        goto L130
    L122:
        if (r124.device().S() == false) goto L124;
        r130 = true;
        goto L126
    L125:
        r130 = r127;
    L118:
        r129 = false;
        goto L119
    L113:
        r127 = false;
    L110:
        r126 = false;
    L145:
        boolean r135 = CollectionsKt.listOf(new Integer[]{Boxing.boxInt(2), Boxing.boxInt(1), Boxing.boxInt(3)}).contains(Boxing.boxInt(ISessionEndPoint.a.a().getMode()));
        int r136 = R.string.obric_ai_btn_toast_2;
        if (r135 == false) goto L183;
        boolean r137 = Intrinsics.areEqual(bga.j.c(), "VOICE");
        if (ISessionEndPoint.a.a().getMode() == 2) goto L153;
        int r138 = 1;
        if (ISessionEndPoint.a.a().getMode() == 1) goto L154;
        boolean r139 = false;
    L155:
        int r140 = ISessionEndPoint.a.a().getMode();
        if (r140 == r138) goto L167;
        if (r140 == 2) goto L165;
        if (r140 == 3) goto L162;
    L169:
        boolean r141 = false;
    L171:
        if (r137 == false) goto L175;
        if (r139 == false) goto L175;
        if (r141 == false) goto L175;
        r123.i(ISessionEndPoint.a.b(this), "onSessionProcess, bypass call/ringtone intercept for voice wakeup, mode=" + ISessionEndPoint.a.a().getMode() + ", rom concurrent record supported");
    L175:
        com.obric.assistant.utils.o r142 = com.obric.assistant.utils.o.f393884a;
        String r143 = "Voice-mic-in-use-calling: " + ISessionEndPoint.a.a().getMode();
        r142.getClass();
        com.obric.assistant.utils.o.c(r107, "imic_in_use", r143);
        r123.i(ISessionEndPoint.a.b(this), "onSessionProcess, return because mode=" + ISessionEndPoint.a.a().getMode());
        if (r137 == false) goto L181;
        if (r141 == false) goto L179;
    L180:
        r136 = R.string.obric_ai_btn_toast_mic_in_use_via_aikey;
        goto L181
    L179:
        if (ISessionEndPoint.a.a().getMode() == 3) goto L180;
    L181:
        aga.j.l(r136);
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "Voice-mic-in-use-calling");
    L162:
        if (com.obric.assistant.common.utils.y.f() == false) goto L164;
        r123.i("RomWakeupOptimizeUtils", "isSupportVoipCallOpt skipped: bluetooth connected but concurrent btmic not supported");
        goto L169
    L164:
        r141 = com.obric.assistant.common.utils.y.i(com.obric.assistant.common.utils.y.c());
        goto L171
    L165:
        r141 = com.obric.assistant.common.utils.y.h();
        goto L171
    L167:
        if (com.obric.assistant.common.utils.y.f() == false) goto L170;
        r123.i("RomWakeupOptimizeUtils", "isSupportMicInUseOpt skipped: bluetooth connected but concurrent btmic not supported");
        goto L169
    L170:
        r141 = com.obric.assistant.common.utils.y.g(com.obric.assistant.common.utils.y.c());
    L154:
        r139 = true;
        goto L155
    L153:
        r138 = 1;
    L183:
        List r144 = com.obric.assistant.common.utils.p.b(r118);
        Application r145 = r118;
        if (com.obric.assistant.common.utils.p.f(r145, r144) == false) goto L212;
        if (Intrinsics.areEqual(bga.j.c(), "BREATH") == true) goto L188;
    L191:
        com.obric.assistant.utils.o.f393884a.getClass();
        com.obric.assistant.utils.o.c(r107, "mic_in_use", "Voice-mic-in-use-common");
        if (NetworkUtils.isNetworkAvailable(r145) == true) goto L194;
        r136 = R.string.larus_network_error;
    L209:
        aga.j.l(r136);
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "onSessionProcess, return because mic in use");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "Voice-mic-in-use-common");
    L194:
        Intrinsics.checkNotNullParameter(r144, "micInUsePkgNames");
        ArrayList r146 = (ArrayList) r144;
        if (r146.isEmpty() == true) goto L203;
        Iterator r147 = r146.iterator();
    L199:
        if (r147.hasNext() == false) goto L203;
        if (com.obric.assistant.common.utils.p.f387885a.contains((String) r147.next()) == false) goto L199;
        boolean r148 = true;
    L204:
        if (r148 == false) goto L207;
        r136 = R.string.obric_ai_btn_toast_mic_in_use_by_camera;
        goto L209
    L207:
        if (Intrinsics.areEqual(bga.j.c(), "VOICE") == false) goto L209;
        r136 = R.string.obric_ai_btn_toast_mic_in_use_via_aikey;
    L203:
        r148 = false;
        goto L204
    L188:
        if (com.obric.assistant.common.utils.p.g() == false) goto L191;
        com.obric.assistant.utils.o.f393884a.getClass();
        com.obric.assistant.utils.o.c(r107, "mic_in_use", "Voice-mic-in-use-and-breath");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "Voice-mic-in-use-and-breath");
    L212:
        if (this.f391545a == false) goto L215;
        r123.w(ISessionEndPoint.a.b(this), "an activating action is running , wait about 1s to try again");
        com.obric.assistant.utils.o.f393884a.getClass();
        com.obric.assistant.utils.o.c(r107, "timer_running", "Voice-timer-running");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "Voice-timer-running");
    L215:
        r123.w(ISessionEndPoint.a.b(this), "ready for activating....");
        this.f391552h.start();
        r123.i(ISessionEndPoint.a.b(this), "activate Countdown timer onStart");
        this.f391545a = true;
        Activity r149 = AppHost.f326268a.a().getCurrentActivity();
        if ((r149 instanceof FragmentActivity) == false) goto L218;
        FragmentActivity r150 = (FragmentActivity) r149;
    L219:
        r123.w(ISessionEndPoint.a.b(this), "onShow currentActivity is : " + r150);
        if (r150 == null) goto L224;
        t1a.b r151 = aga.j.g(r150);
        if (r151 == null) goto L224;
        maa.e r152 = (maa.e) r151.getAbility(maa.e.class);
    L225:
        if (r152 == null) goto L235;
        String r153 = ISessionEndPoint.a.b(this);
        StringBuilder r154 = new StringBuilder("checking if in clicktalking ");
        r154.append(r152.x3());
        r154.append(" , is oneshot ? ");
        ConcurrentMap<Integer, wna.a.b> r155 = wna.a.f560481a;
        r154.append(!((ConcurrentHashMap) r155).isEmpty());
        r123.w(r153, r154.toString());
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_VOICE_ASSIST") == false) goto L235;
        if (r152.x3() == false) goto L235;
        if ((!((ConcurrentHashMap) r155).isEmpty()) == false) goto L235;
        r123.w(ISessionEndPoint.a.b(this), "re-wakeup when the session is click talking , not handle any more");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "Voice-re-wakeup-when-sessioning");
    L235:
        if (Intrinsics.areEqual(bga.j.c(), "VOICE") == false) goto L248;
        if (t1.f393353a.r1() == true) goto L248;
        IBluetoothHeadSetAPI r156 = tha.c.a();
        if (r156 == null) goto L244;
        if (r156.a() != true) goto L244;
        boolean r157 = true;
    L245:
        if (r157 == true) goto L248;
        boolean r158 = true;
    L249:
        if (r158 == false) goto L256;
        PocketModeDetector r159 = this.f391549e;
        r100.L$0 = null;
        r100.label = 2;
        r102 = r159.d(r100);
        Object r160 = r412;
        if (r102 != r160) goto L254;
        return r160;
    L244:
        r157 = false;
    L248:
        r158 = false;
    L224:
        r152 = null;
        goto L225
    L218:
        r150 = null;
        goto L219
    L94:
        r122 = null;
        goto L95
    L57:
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_VOICE_ASSIST") == true) goto L61;
        r117 = r8;
        if (Intrinsics.areEqual(bga.j.a(), r117) == false) goto L60;
    L62:
        String r161 = r107.getString("keyword", "");
        long r162 = r107.getLong(InteractConst.WAKEUP_ONESHOT_OFFSET_TIME, -1);
        if (Intrinsics.areEqual(bga.j.c(), "BREATH") == true) goto L66;
        r115 = r107.getInt(InteractConst.INTENT_SESSION_ID, 0);
    L66:
        r118 = r111;
        r412 = r103;
        long r163 = r107.getLong(InteractConst.WAKEUP_STAGE1_START_TIME, 0);
        FLogger r164 = FLogger.f375446a;
        r110 = "";
        r210 = r117;
        r164.i(ISessionEndPoint.a.b(this), "handleOneshotParams =========> " + r161 + " - " + r162 + " - " + r115);
        Intrinsics.checkNotNull(r161);
        if (r161.length() <= 0) goto L69;
        boolean r165 = true;
    L70:
        if (r165 == true) goto L75;
        long r211 = 0;
        if (r162 >= 0) goto L76;
        ObricOneshotDelegate.f392920b.g();
    L76:
        ObricOneshotDelegate r166 = ObricOneshotDelegate.f392920b;
        r166.i(r115, r161, r162);
        if (r163 <= r211) goto L85;
        r164.i(ISessionEndPoint.a.b(this), "handleOneshotParams useChipStage1StartTime, stage1StartTime=" + r163);
        long r167 = r163 - ((long) 100);
        r166.b(0, r167);
        if (Intrinsics.areEqual(bga.j.c(), "BREATH") == false) goto L91;
        ObricWakeupAudioCaptureDelegate r168 = ObricWakeupAudioCaptureDelegate.f392843b;
        if (r168.a() == false) goto L91;
        long r310 = System.currentTimeMillis();
        r168.b(new hga.f(r310, WakeupAudioCaptureTriggerType.BREATH_WAKEUP, this.f391546b, r167, r310, null, null, null, null, null, null, null, null, 0, 0.0f, 0.0f, 0, false, false, 1048516));
        goto L91
    L85:
        Object r169 = AppHost.f326268a.getApplication().getSystemService("keyguard");
        Intrinsics.checkNotNull(r169, "null cannot be cast to non-null type android.app.KeyguardManager");
        boolean r170 = ((KeyguardManager) r169).isKeyguardLocked();
        if (Intrinsics.areEqual(bga.j.c(), "BREATH") == false) goto L89;
        if (r170 == false) goto L89;
        long r171 = 1600;
    L90:
        r166.b(r162 + r171, System.currentTimeMillis());
    L89:
        r171 = AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
        goto L90
    L75:
        r211 = 0;
        goto L76
    L69:
        r165 = false;
        goto L70
    L61:
        r117 = r8;
    L51:
        th = move-exception;
        Result.Companion r172 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L54
    L37:
        if (r112 == 0) goto L39;
        long r173 = r113 - r112;
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "onShow login start with IPC is " + r173 + " and now is " + r113);
    L40:
        IWakeupStatisticsAPI r174 = wha.a.a();
        if (r174 == null) goto L35;
        r174.setStartTime(r113 - r173);
        r115 = -1;
        r174.b("wakeup_stage3_1_ipc", false, ((long) (-1)) * r173);
        r174.b("wakeup_stage3_2_on_show", false, r113);
        if (r107 == null) goto L46;
        Bundle r175 = r107.getBundle(InteractConst.WAKEUP_TRACKER_DURATION);
        if (r175 == null) goto L46;
    L47:
        r174.setBundle(r175);
    L46:
        r175 = com.larus.utils.f.c(new Pair[0]);
        goto L47
    L39:
        r173 = 0;
        goto L40
    L29:
        r109 = 0;
        goto L30
    L26:
        r112 = 0;
        goto L27
    L16:
        ResultKt.throwOnFailure(r102);
        r100.L$0 = r410;
        r100.label = 1;
        if (ISessionEndPoint.a.e(this) != r103) goto L19;
        return r103;
    L19:
        r107 = r410;
    L7:
        r100 = new VoiceWakeupSessionEndpoint$onSessionProcess$1(this, r411);
        goto L8
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void p(Context r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "args");
        ISessionEndPoint.a.d(this, r100, r101);
        FLogger r102 = FLogger.f375446a;
        r102.i(ISessionEndPoint.a.b(this), "onSessionPrepared clearOneshotParam");
        this.f391547c = false;
        ObricOneshotDelegate.f392920b.g();
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_VOICE_ASSIST") == false) goto L7;
        wna.a.c(r101);
        if (t1.f393353a.r1() == true) goto L7;
        this.f391549e.b();
        r102.i(ISessionEndPoint.a.b(this), "onSessionPrepared start pocket mode detection");
    L7:
        this.f391546b = r101.getInt(InteractConst.WAKEUP_WAKEUP_ID, -1);
    }
}
