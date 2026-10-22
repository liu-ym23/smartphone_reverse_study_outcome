package com.obric.assistant.session.endpoint;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.obric.assistant.reporter.IObricReporter;
import com.obric.assistant.session.bean.ActivateEventType;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.IApplicationActivityOperation;
import com.obric.assistant.session.model.IAutoMicOperation;
import com.obric.assistant.session.model.IDoraOperation;
import com.obric.assistant.session.model.ILaunchMethodOperation;
import com.obric.assistant.session.model.ISessionEndPoint;
import com.obric.assistant.session.model.ISessionMaintaining;
import com.obric.assistant.voice.ContentScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010 \u001a\u00020\u0010H\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J\u001c\u0010\"\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010&\u001a\u00020\u0007H\u0016J\u0018\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*H\u0016J'\u0010+\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010\u000b2\u0006\u0010-\u001a\u00020.H\u0016¢\u0006\u0002\u0010/R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/assistant/session/endpoint/LaunchMethodReporterEndpoint;", "Lcom/obric/assistant/session/model/ISessionEndPoint;", "Lcom/obric/assistant/session/model/ILaunchMethodOperation;", "<init>", "()V", "mCurLaunchMethod", "Ljava/util/concurrent/atomic/AtomicReference;", "", "mIsAIPowerKeyExchange", "", "processOrder", "", "getProcessOrder", "()I", "isAppBackgroundWhenAiKeyDown", "onSessionPrepared", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "args", "Landroid/os/Bundle;", "onSessionProcess", "Lkotlin/Pair;", "Lcom/obric/assistant/session/bean/ErrorCode;", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldDisableScreenShot", "foreGroundAppPackageName", "foreGroundActivityName", "getDefaultLauncherPackageName", "updateLaunchReportParams", "launchService", "launchMethod", "onAiKeyDown", "updateWakeupSource", "updateLaunchMethod", "eventType", "Lcom/obric/assistant/session/bean/ActivateEventType;", "rawLaunchMethod", "getLaunchMethod", "reportAiKeyPressDuration", "duration", WsConstants.KEY_PAYLOAD, "Lorg/json/JSONObject;", "reportAiKeyWakeupDuration", "systemKeyToWakeupDuration", "wakeupTimeMillis", "", "(ILjava/lang/Integer;J)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LaunchMethodReporterEndpoint implements ISessionEndPoint, ILaunchMethodOperation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<String> f391537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f391538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f391539c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f391540a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f391541b = null;

        static {
            int[] r100 = new int[ContentScene.values().length];
            r100[ContentScene.OAUTO_CALL_USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[ContentScene.PRIORITY_NOTIFICATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L6:
            f391540a = r100;
            int[] r101 = new int[ActivateEventType.values().length];
            r101[ActivateEventType.SinglePress.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L29:
            r101[ActivateEventType.DoublePress.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L23:
            r101[ActivateEventType.LongPress.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L25:
            r101[ActivateEventType.Other.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L11:
            f391541b = r101;
        }
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int f() {
        return 0;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int h() {
        return 40;
    }

    @Override // com.obric.assistant.session.model.ILaunchMethodOperation
    public final String a() {
        return this.f391537a.get();
    }

    @Override // com.obric.assistant.session.model.ILaunchMethodOperation
    public final void g() {
        this.f391539c = AppHost.f326268a.a().isAppBackground();
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTagName() {
        return "LaunchMethodReporterEndpoint";
    }

    public LaunchMethodReporterEndpoint() {
        this.f391537a = new AtomicReference("other");
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public Context getContext() {
        return ISessionEndPoint.a.getContext(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTAG() {
        return ISessionEndPoint.a.b(this);
    }

    @Override // com.obric.assistant.session.model.ILaunchMethodOperation
    public final void j() {
        IDoraOperation r100 = bga.f.a();
        if (r100 == null) goto L5;
        boolean r101 = r100.c();
    L6:
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "updateWakeupSource with requestFrom " + bga.j.a() + " and session " + bga.j.c() + " doraProxyWakeup " + r101 + ' ');
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_VOICE_ASSIST") == false) goto L13;
        if (Intrinsics.areEqual(bga.j.c(), "VOICE") == false) goto L11;
        String r102 = "voice.wakeup";
    L23:
        if (Intrinsics.areEqual("WAKEUP_SOURCE_DORA_VOICE_WAKEUP", bga.j.a()) == false) goto L26;
        if (r101 == false) goto L26;
        r102 = "dora.wakeup";
    L26:
        IObricReporter.f391335a.getClass();
        IObricReporter r103 = IObricReporter.a.a();
        if (r103 == null) goto L30;
        r103.p(r102);
        return;
    L30:
        return;
    L11:
        r102 = "voice.breath";
        goto L23
    L13:
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_BLUETOOTH") == false) goto L16;
        r102 = "voice.bluetooth";
        goto L23
    L16:
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_DORA_KEY_DOWN") == false) goto L18;
    L21:
        r102 = "dora.bluetooth";
        goto L23
    L18:
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_DORA_KEY_UP") == true) goto L21;
        r102 = "voice.other";
        goto L23
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.obric.assistant.session.model.ILaunchMethodOperation
    public final String b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intent r101 = new Intent("android.intent.action.MAIN");
        r101.addCategory("android.intent.category.HOME");
        ResolveInfo r102 = r100.getPackageManager().resolveActivity(r101, 65536);
        if (r102 == null) goto L7;
        ActivityInfo r103 = r102.activityInfo;
        if (r103 == null) goto L7;
        return r103.packageName;
    L7:
        return null;
    }

    @Override // com.obric.assistant.session.model.ILaunchMethodOperation
    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "launchService");
        String r101 = this.f391537a.get();
        if (ILoginService.f286097a.getAccountInfo().f531528a == true) goto L6;
        r100 = "open_doubao";
    L6:
        IObricReporter.f391335a.getClass();
        IObricReporter r102 = IObricReporter.a.a();
        if (r102 != null) goto L9;
        return;
    L9:
        if (this.f391539c == true) goto L11;
    L13:
        boolean r103 = false;
    L14:
        r102.n(r101, r100, r103);
        return;
    L11:
        if (Intrinsics.areEqual(r101, "long_press_ai_button") == false) goto L13;
        r103 = true;
        goto L14
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void n(ErrorCode r100) {
        ISessionEndPoint.a.c(this, r100);
    }

    @Override // com.obric.assistant.session.model.ILaunchMethodOperation
    public final void c(int r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new LaunchMethodReporterEndpoint$reportAiKeyPressDuration$1(r101, r100, this, null), 3, null);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final Object d(Bundle r100, Continuation<? super Pair<? extends ErrorCode, String>> r101) {
        if ((r101 instanceof LaunchMethodReporterEndpoint$onSessionProcess$1) == false) goto L7;
        LaunchMethodReporterEndpoint$onSessionProcess$1 r102 = (LaunchMethodReporterEndpoint$onSessionProcess$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        j();
        String r107 = bga.j.a();
        switch(r107.hashCode()) {
            case -263612710: goto L51;
            case 651570445: goto L47;
            case 1003009595: goto L29;
            case 1284758364: goto L25;
            case 1306767466: goto L21;
            default: goto L57;
        };
    L57:
        String r108 = "other";
    L58:
        ILaunchMethodOperation.a.a(this, null, r108, 1);
        IInteractionStateService r109 = IAssistantInteractionServiceKt.getInteractionStateService();
        IApplicationActivityOperation r110 = bga.c.a();
        if (r110 == null) goto L62;
        String r111 = r110.c();
        if (r111 == null) goto L62;
    L63:
        r109.setWakeUpAppPkg(r111, "LaunchMethodReporter onSessionProcess");
        IApplicationActivityOperation r112 = bga.c.a();
        if (r112 == null) goto L67;
        String r113 = r112.c();
        if (r113 == null) goto L67;
    L68:
        IApplicationActivityOperation r114 = bga.c.a();
        if (r114 == null) goto L72;
        String r115 = r114.a();
        if (r115 == null) goto L72;
    L73:
        boolean r116 = l(r113, r115);
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_VOICE_ASSIST") == false) goto L76;
    L77:
        j();
    L78:
        Boolean r117 = Boxing.boxBoolean(r116);
        Intrinsics.checkNotNullParameter("disableScreenShot", "key");
        Intrinsics.checkNotNullParameter(r117, "value");
        ISessionMaintaining r118 = bga.j.b();
        if (r118 == null) goto L82;
        r118.h("disableScreenShot", r117);
        Unit r119 = Unit.INSTANCE;
    L82:
        return TuplesKt.to(ErrorCode.CONTINUE, "");
    L76:
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_DORA_VOICE_WAKEUP") == false) goto L78;
    L72:
        r115 = "";
    L67:
        r113 = "";
    L62:
        r111 = "";
        goto L63
    L21:
        if (r107.equals("WAKEUP_SOURCE_BLUETOOTH") == false) goto L57;
        r108 = "third_party_gesture";
        goto L58
    L25:
        if (r107.equals("WAKEUP_SOURCE_DORA_KEY_UP") == false) goto L57;
        r108 = "dora_radio";
        goto L58
    L29:
        if (r107.equals("WAKEUP_SOURCE_AUTO_MIC") == false) goto L57;
        IAutoMicOperation r120 = bga.e.a();
        if (r120 == null) goto L36;
        zfa.a r121 = r120.getToken();
        if (r121 == null) goto L36;
        ContentScene r122 = r121.f571784a;
    L37:
        if (r122 != null) goto L39;
        int r123 = -1;
    L40:
        if (r123 != 1) goto L42;
        r108 = "oauto_automic";
        goto L58
    L42:
        if (r123 != 2) goto L57;
        r108 = "high_priority_notification";
        goto L58
    L39:
        r123 = a.f391540a[r122.ordinal()];
    L36:
        r122 = null;
        goto L37
    L47:
        if (r107.equals("WAKEUP_SOURCE_DORA_VOICE_WAKEUP") == false) goto L57;
        r108 = "dora_call";
        goto L58
    L51:
        if (r107.equals("WAKEUP_SOURCE_VOICE_ASSIST") == false) goto L57;
        if (Intrinsics.areEqual(bga.j.c(), "BREATH") == false) goto L56;
        r108 = "speak_nearby";
        goto L58
    L56:
        r108 = "audio";
        goto L58
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.label = 1;
        if (ISessionEndPoint.a.e(this) != r105) goto L17;
        return r105;
    L7:
        r102 = new LaunchMethodReporterEndpoint$onSessionProcess$1(this, r101);
        goto L8
    }

    @Override // com.obric.assistant.session.model.ILaunchMethodOperation
    public final void e(ActivateEventType r100, String r101) {
        if (com.larus.utils.o0.d(r101) == false) goto L6;
        this.f391537a.set(r101);
        return;
    L6:
        String r102 = "other";
        if (r100 != null) goto L10;
        this.f391537a.set("other");
        return;
    L10:
        boolean r103 = this.f391538b;
        int r104 = a.f391541b[r100.ordinal()];
        if (r104 != 1) goto L13;
        if (r103 == true) goto L29;
        r102 = "single_click_ai_button";
    L30:
        this.f391537a.set(r102);
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "onShow login, the launch method is : [ " + r102 + " ]");
        return;
    L29:
        r102 = "single_click_power_button";
        goto L30
    L13:
        if (r104 != 2) goto L15;
        if (r103 == true) goto L26;
        r102 = "double_click_ai_button";
        goto L30
    L26:
        r102 = "double_click_power_button";
        goto L30
    L15:
        if (r104 != 3) goto L17;
        if (r103 == true) goto L23;
        r102 = "long_press_ai_button";
        goto L30
    L23:
        r102 = "long_press_power_button";
        goto L30
    L17:
        if (r104 == 4) goto L30;
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.obric.assistant.session.model.ILaunchMethodOperation
    public final boolean l(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "foreGroundAppPackageName");
        Intrinsics.checkNotNullParameter(r101, "foreGroundActivityName");
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r100, getContext().getPackageName()) == false) goto L9;
        if (StringsKt.contains$default(r101, "com.obric.miniapp", false, 2, null) == true) goto L9;
    L10:
        return true;
    L9:
        if (Intrinsics.areEqual(r100, b(getContext())) == true) goto L10;
        return false;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void p(Context r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "args");
        ISessionEndPoint.a.d(this, r100, r101);
        if (Intrinsics.areEqual(bga.j.a(), "other") == true) goto L10;
        boolean r102 = r101.getBoolean("toggle_ai_button");
        boolean r103 = true;
        if (r102 == true) goto L8;
        r103 = false;
    L8:
        this.f391538b = r103;
        return;
    }

    @Override // com.obric.assistant.session.model.ILaunchMethodOperation
    public final void i(int r110, Integer r111, long r112) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new LaunchMethodReporterEndpoint$reportAiKeyWakeupDuration$1(r110, r111, this, r112, null), 3, null);
    }
}
