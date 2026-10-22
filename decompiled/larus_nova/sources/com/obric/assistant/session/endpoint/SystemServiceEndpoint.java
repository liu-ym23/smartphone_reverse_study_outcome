package com.obric.assistant.session.endpoint;

import android.app.Activity;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.media.MediaResourceManager;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ObricAssistantDelegate;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.IAiKeyOperation;
import com.obric.assistant.session.model.IDoraOperation;
import com.obric.assistant.session.model.ILaunchMethodOperation;
import com.obric.assistant.session.model.ISessionEndPoint;
import com.obric.assistant.session.model.ISessionMaintaining;
import com.obric.assistant.session.model.ISystemServiceOperation;
import com.obric.assistant.spi.keyguard.IKeyguardService;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.startup.IAssistantStartupTelemetry;
import com.obric.assistant.state.api.v2.ObricStateService;
import com.obric.audio.continuous_talk.ContinuousTalkStatus;
import com.obric.sva.sdk.utils.InteractConst;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0003J\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0006*\u00020\u000eH\u0002¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/session/endpoint/SystemServiceEndpoint;", "Lcom/obric/assistant/session/model/ISessionEndPoint;", "Lcom/obric/assistant/session/model/ISystemServiceOperation;", "<init>", "()V", "processOrder", "", "getProcessOrder", "()I", "onSessionProcess", "Lkotlin/Pair;", "Lcom/obric/assistant/session/bean/ErrorCode;", "", "args", "Landroid/os/Bundle;", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startCreationCanvas", "", "readDisplayId", "(Landroid/os/Bundle;)Ljava/lang/Integer;", "startCameraResult", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SystemServiceEndpoint implements ISessionEndPoint, ISystemServiceOperation {

    public static final class a implements oga.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SystemServiceEndpoint f391542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f391543b;

        @Override // oga.a
        public final void onDismissFailed() {
            FLogger r100 = FLogger.f375446a;
            SystemServiceEndpoint r101 = this.f391542a;
            r101.getClass();
            r100.i(ISessionEndPoint.a.b(r101), "dismiss failed");
            String r102 = this.f391543b;
            if (r102 == null) goto L6;
            IAssistantStartupTelemetry.a.a(AssistantStartupTelemetry.f392915a, r102, "blocked", "dismiss_keyguard_failed", null, 24);
            return;
        }

        @Override // oga.a
        public final void onDismissSucceeded() {
            FLogger r100 = FLogger.f375446a;
            SystemServiceEndpoint r101 = this.f391542a;
            r101.getClass();
            r100.i(ISessionEndPoint.a.b(r101), "dismiss success");
            String r102 = this.f391543b;
            if (r102 == null) goto L5;
            IAssistantStartupTelemetry.a.a(AssistantStartupTelemetry.f392915a, r102, "dropped", "legacy_launcher_fallback", null, 24);
        L5:
            IAiKeyOperation r103 = bga.b.a();
            if (r103 == null) goto L9;
            r103.startLauncherIntent();
            return;
        }

        public a(SystemServiceEndpoint r100, String r101) {
            this.f391542a = r100;
            this.f391543b = r101;
        }
    }

    public SystemServiceEndpoint() {
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int f() {
        return 0;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int h() {
        return 50;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTagName() {
        return "SystemServiceEndpoint";
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public Context getContext() {
        return ISessionEndPoint.a.getContext(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTAG() {
        return ISessionEndPoint.a.b(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void n(ErrorCode r100) {
        ISessionEndPoint.a.c(this, r100);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final Object d(Bundle r110, Continuation<? super Pair<? extends ErrorCode, String>> r111) {
        if ((r111 instanceof SystemServiceEndpoint$onSessionProcess$1) == false) goto L7;
        SystemServiceEndpoint$onSessionProcess$1 r100 = (SystemServiceEndpoint$onSessionProcess$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r110 = (Bundle) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L17:
        String r104 = null;
        ContinuousTalkStatus r105 = null;
        r104 = null;
        boolean r106 = false;
        String r107 = "";
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_ALL_SEARCH") == false) goto L32;
        String r113 = r110.getString("all_search");
        if (r113 == null) goto L23;
        r107 = r113;
    L23:
        ILaunchMethodOperation r114 = bga.g.a();
        if (r114 == null) goto L26;
        ILaunchMethodOperation.a.a(r114, null, "global_search", 1);
    L26:
        com.obric.assistant.reporter.b.a("global_search", null, 6);
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "mark global search launch method");
        ISessionMaintaining r115 = bga.j.b();
        if (r115 == null) goto L30;
        ISessionMaintaining.a.a(r115, com.larus.utils.f.c(new Pair[]{TuplesKt.to("all_search", r107)}), null, false, 29);
    L30:
        return TuplesKt.to(ErrorCode.LAUNCH_ASSISTANT_DIRECTLY, "System-all-search-launch");
    L32:
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_CANVAS_PS") == false) goto L62;
        if (r110 != null) goto L35;
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "startCreationCanvas args is null");
    L60:
        return TuplesKt.to(ErrorCode.LAUNCH_ASSISTANT_DIRECTLY, "Album-canvas-ps");
    L35:
        String r116 = r110.getString("local_uri", null);
        if (r110.containsKey("display_id") == false) goto L44;
        Integer r108 = Integer.valueOf(r110.getInt("display_id", 0));
        if (r108.intValue() < 0) goto L41;
        boolean r109 = true;
    L42:
        if (r109 == false) goto L44;
    L45:
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "startCreationCanvas uri = " + r116 + ", displayId = " + r108);
        if (r116 != null) goto L48;
    L49:
        r106 = true;
    L50:
        if (r106 == true) goto L60;
        ILaunchMethodOperation r117 = bga.g.a();
        if (r117 == null) goto L55;
        ILaunchMethodOperation.a.a(r117, null, "doubao_edit_from_album", 1);
    L55:
        ILaunchMethodOperation r118 = bga.g.a();
        if (r118 == null) goto L58;
        r118.k("open_doubao");
    L58:
        IAssistantInteractionServiceKt.getInteractionStateService().setWakeUpAppPkg(v0.a(r110), "SystemServiceEndpoint startCreationCanvas ");
        ObricAssistantDelegate.f385138b.a(r116, r108);
        IApplog.f287053a.o("obric_doubao_edit_photo_click");
        goto L60
    L48:
        if (r116.length() != 0) goto L50;
    L41:
        r109 = false;
    L44:
        r108 = null;
        goto L45
    L62:
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_CAMERA_RESULT_PS") == false) goto L82;
        if (r110 != null) goto L65;
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "startCameraResult args is null");
    L80:
        return TuplesKt.to(ErrorCode.LAUNCH_ASSISTANT_DIRECTLY, "Album-camera-result");
    L65:
        String r119 = r110.getString("local_uri", null);
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "startCameraResult uri = " + r119);
        if (r119 != null) goto L68;
    L69:
        r106 = true;
    L70:
        if (r106 == true) goto L80;
        ILaunchMethodOperation r120 = bga.g.a();
        if (r120 == null) goto L75;
        ILaunchMethodOperation.a.a(r120, null, "gui_photo_qa", 1);
    L75:
        ILaunchMethodOperation r121 = bga.g.a();
        if (r121 == null) goto L78;
        r121.k("open_doubao");
    L78:
        ObricAssistantDelegate.f385138b.d(r119);
        IApplog.f287053a.o("obric_gui_photo_qa_click");
        goto L80
    L68:
        if (r119.length() != 0) goto L70;
    L82:
        if (Build.VERSION.SDK_INT >= 33) goto L84;
    L190:
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "launch doubao as click launcher icon");
        String r122 = r110.getString("obric_startup_attempt_id");
        if (r122 != null) goto L193;
    L195:
        IKeyguardService.a.a(KeyguardService.f392886a, new a(this, r104), false, false, false, false, null, 62);
        return TuplesKt.to(ErrorCode.ONLY_END, "System-dismiss-keyguard");
    L193:
        if ((!StringsKt.isBlank(r122)) == false) goto L195;
        r104 = r122;
        goto L195
    L84:
        if (ObricFeatureServiceDelegate.f387839b.c() == false) goto L190;
        if (r110.getInt(InteractConst.WAKEUP_PULL_UP_ONCE) != 1) goto L90;
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "onShow pull up once , no showing , then hide!");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "System-pullup-once");
    L90:
        AppHost.Companion r123 = AppHost.f326268a;
        Object r124 = r123.getApplication().getSystemService("display");
        Intrinsics.checkNotNull(r124, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        if (((DisplayManager) r124).getDisplay(0).getRotation() == 0) goto L102;
        IAssistantChatWindow r125 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r125 != null) goto L95;
    L97:
        boolean r126 = false;
    L98:
        if (r126 == true) goto L102;
        aga.j.l(R.string.obric_assist_not_available_when_screen_rotated);
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "System-rotate-display");
    L95:
        if (r125.isWindowMode() != true) goto L97;
        r126 = true;
    L102:
        if (ObricStateService.f392961a.a() == false) goto L105;
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "doOnShow, isRealtimeCalling, return");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "System-realtime-calling");
    L105:
        Activity r127 = r123.a().getCurrentActivity();
        if ((r127 instanceof FragmentActivity) == false) goto L108;
        FragmentActivity r128 = (FragmentActivity) r127;
    L109:
        FLogger r129 = FLogger.f375446a;
        r129.w(ISessionEndPoint.a.b(this), "onShow currentActivity is : " + r128);
        if (r128 == null) goto L114;
        t1a.b r130 = aga.j.g(r128);
        if (r130 == null) goto L114;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r131 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) r130.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
    L115:
        if (r128 == null) goto L119;
        t1a.b r132 = aga.j.g(r128);
        if (r132 == null) goto L119;
        com.obric.audio.continuous_talk.b r133 = (com.obric.audio.continuous_talk.b) r132.getAbility(com.obric.audio.continuous_talk.b.class);
    L120:
        IAiKeyOperation r134 = bga.b.a();
        if (r134 != null) goto L123;
    L125:
        boolean r135 = false;
    L126:
        IDoraOperation r136 = bga.f.a();
        if (r136 != null) goto L129;
    L131:
        boolean r137 = false;
    L132:
        if (r131 != null) goto L134;
    L136:
        boolean r138 = false;
    L137:
        if (r133 == null) goto L140;
        r105 = r133.u10();
    L140:
        if (r105 != ContinuousTalkStatus.RUNNING) goto L142;
        boolean r139 = true;
    L143:
        if (r135 == true) goto L181;
        if (r137 == true) goto L181;
        if (r138 == true) goto L181;
        if (r139 == true) goto L181;
        if (aga.j.i() == false) goto L153;
        r129.i(ISessionEndPoint.a.b(this), "user guide is showing, ignore");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "System-user-guiding");
    L153:
        if (com.obric.assistant.voice.n.f394383a == false) goto L157;
        r129.i(ISessionEndPoint.a.b(this), "onShow while vocie enrolling, ignore request");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "System-voice-enrolling");
    L157:
        if (r110.getBoolean(InteractConst.WAKEUP_IGNORE_REQUEST, false) != true) goto L161;
        r129.i(ISessionEndPoint.a.b(this), "onShow ignore request");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "System-ignore-request");
    L161:
        if (Intrinsics.areEqual("WAKEUP_SOURCE_ON_START_UP", bga.j.a()) == false) goto L165;
        r129.i(ISessionEndPoint.a.b(this), "onShow on start up");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "System-startup");
    L165:
        if (((Set) aga.c.f3364a.getValue()).contains(bga.j.a()) == true) goto L168;
        r129.w(ISessionEndPoint.a.b(this), "onShow don't wakeup assistant for unsupported source: ".concat(bga.j.a()));
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "System-invalid-request-from");
    L168:
        IAssistantChatWindow r140 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r140 != null) goto L171;
    L173:
        if (r106 == false) goto L179;
        IAssistantChatWindow r141 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r141 == null) goto L178;
        r141.onWakeupBlockedBySystemAlertWindowPermission();
    L178:
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "Blocked-by-system-alert-window-permission");
    L179:
        Lazy r142 = MediaResourceManager.f358950a;
        ((com.larus.media.j0) MediaResourceManager.f358950a.getValue()).getClass();
        MediaResourceManager.g().f358998d = true;
        return TuplesKt.to(ErrorCode.CONTINUE, "");
    L171:
        if (r140.isNewGlobalPanelBlockedByPermission() != true) goto L173;
        r106 = true;
    L181:
        if (r135 == false) goto L183;
        String r143 = "System-aiKeyPressing";
    L188:
        r129.i(ISessionEndPoint.a.b(this), "ai key pressing or chatBottom is in speaking, So ignore .... [detail is : isAiKeyPressing " + r135 + ", isDoraPressing " + r137 + ", isClickTalkSpeaking " + r138 + ", isContinuousTalkRunning " + r139 + ']');
        return TuplesKt.to(ErrorCode.QUIT_SESSION, r143);
    L183:
        if (r137 == false) goto L185;
        r143 = "System-doraPressing";
        goto L188
    L185:
        if (r138 == false) goto L187;
        r143 = "System-clickTalkSpeaking";
        goto L188
    L187:
        r143 = "System-continuousTalkRunning";
        goto L188
    L142:
        r139 = false;
        goto L143
    L134:
        if (r131.m0() != true) goto L136;
        r138 = true;
        goto L137
    L129:
        if (r136.b() != true) goto L131;
        r137 = true;
        goto L132
    L123:
        if (r134.isAiKeyPressing() != true) goto L125;
        r135 = true;
    L119:
        r133 = null;
    L114:
        r131 = null;
        goto L115
    L108:
        r128 = null;
        goto L109
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        r100.L$0 = r110;
        r100.label = 1;
        if (ISessionEndPoint.a.e(this) != r102) goto L17;
        return r102;
    L7:
        r100 = new SystemServiceEndpoint$onSessionProcess$1(this, r111);
        goto L8
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void p(Context r100, Bundle r101) {
        ISessionEndPoint.a.d(this, r100, r101);
    }
}
