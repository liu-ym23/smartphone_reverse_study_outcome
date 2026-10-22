package com.obric.assistant.session.endpoint;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.core.content.IntentCompat;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.IAssistActivateOperation;
import com.obric.assistant.session.model.IDoraOperation;
import com.obric.assistant.session.model.ILaunchMethodOperation;
import com.obric.assistant.session.model.ISessionEndPoint;
import com.obric.assistant.session.model.ISessionMaintaining;
import com.obric.assistant.session.singleton.DoraWakeupDetector;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u001eJ\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u000f\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\u0003H\u0016J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010%\u001a\u00020\u0013H\u0016J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u001cH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/assistant/session/endpoint/DoraSessionEndpoint;", "Lcom/obric/assistant/session/model/ISessionEndPoint;", "Lcom/obric/assistant/session/model/IDoraOperation;", "Lcom/obric/assistant/session/singleton/DoraWakeupDetector$DoraActionListener;", "<init>", "()V", "isDoraProxyWakeup", "", "isAutoMicDoraWakeup", "vuiId", "", "Ljava/lang/Integer;", "isDoraPressing", "prepareOrder", "getPrepareOrder", "()I", "processOrder", "getProcessOrder", "onSessionPrepared", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "args", "Landroid/os/Bundle;", "startTouchSpeakTask", "Ljava/lang/Runnable;", "onSessionProcess", "Lkotlin/Pair;", "Lcom/obric/assistant/session/bean/ErrorCode;", "", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVuiId", "()Ljava/lang/Integer;", "setAutoMicDoraWakeup", "enable", "action", "onDoraWakeup", "onDoraRadioStop", "onSessionCompleted", "code", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraSessionEndpoint implements ISessionEndPoint, IDoraOperation, DoraWakeupDetector.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f391531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f391532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Integer f391533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f391534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s0 f391535e;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f391536a = null;

        static {
            int[] r100 = new int[ErrorCode.values().length];
            r100[ErrorCode.QUIT_SESSION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ErrorCode.ONLY_END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f391536a = r100;
        }
    }

    @Override // com.obric.assistant.session.model.IDoraOperation
    public final DoraSessionEndpoint action() {
        return this;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int f() {
        return 50;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int h() {
        return 90;
    }

    @Override // com.obric.assistant.session.singleton.DoraWakeupDetector.a
    public final void a() {
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "onDoraRadioStop");
        this.f391534d = false;
        com.larus.utils.y.b().removeCallbacks(this.f391535e);
        ObricInteractDelegate.f392884b.notifyAiKeyEvent(0);
        IAssistActivateOperation r100 = bga.d.a();
        if (r100 == null) goto L6;
        r100.k();
        return;
    }

    @Override // com.obric.assistant.session.model.IDoraOperation
    public final void e() {
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "setAutoMicDoraWakeup to true");
        this.f391532b = true;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTagName() {
        return "DoraSessionEndpoint";
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.assistant.session.endpoint.s0] */
    public DoraSessionEndpoint() {
        this.f391535e = new s0();
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public Context getContext() {
        return ISessionEndPoint.a.getContext(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTAG() {
        return ISessionEndPoint.a.b(this);
    }

    @Override // com.obric.assistant.session.model.IDoraOperation
    public final boolean b() {
        return this.f391534d;
    }

    @Override // com.obric.assistant.session.model.IDoraOperation
    public final boolean c() {
        return this.f391531a;
    }

    @Override // com.obric.assistant.session.model.IDoraOperation
    public final Integer g() {
        return this.f391533c;
    }

    @Override // com.obric.assistant.session.singleton.DoraWakeupDetector.a
    public final void i(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        FLogger r101 = FLogger.f375446a;
        r101.i(ISessionEndPoint.a.b(this), "onDoraWakeup : " + this.f391532b);
        this.f391531a = true;
        if (this.f391532b == false) goto L5;
        r100.putBoolean("AUTO_MIC_REQUEST", true);
        this.f391532b = false;
    L5:
        Lazy r102 = aga.j.f3367a;
        Intrinsics.checkNotNullParameter(r100, "bundle");
        r101.i("AiIsland-SessionUtils", "launchAssistantForDoraWakeup");
        Object r103 = AppHost.f326268a.getApplication().getSystemService("search");
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.app.SearchManager");
        SearchManager r104 = (SearchManager) r103;
        r104.getClass().getMethod("launchAssist", new Class[]{Bundle.class}).invoke(r104, new Object[]{r100});
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void n(ErrorCode r100) {
        Intrinsics.checkNotNullParameter(r100, "code");
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "onSessionCompleted " + r100);
        if (a.f391536a[r100.ordinal()] == 1) goto L6;
        return;
    L6:
        if (this.f391531a == false) goto L9;
        DoraWakeupDetector r101 = DoraWakeupDetector.f391630a;
        DoraWakeupDetector.f();
        return;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final Object d(Bundle r110, Continuation<? super Pair<? extends ErrorCode, String>> r111) {
        if ((r111 instanceof DoraSessionEndpoint$onSessionProcess$1) == false) goto L7;
        DoraSessionEndpoint$onSessionProcess$1 r100 = (DoraSessionEndpoint$onSessionProcess$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        Bundle r105 = (Bundle) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Bundle r106 = r105;
    L17:
        String r107 = bga.j.a();
        if (ArraysKt.contains(new String[]{"WAKEUP_SOURCE_DORA_KEY_DOWN", "WAKEUP_SOURCE_DORA_KEY_UP", "WAKEUP_SOURCE_DORA_KEY_CANCEL", "WAKEUP_SOURCE_DORA_VOICE_WAKEUP"}, r107) == false) goto L20;
    L28:
        FLogger r108 = FLogger.f375446a;
        r108.i(ISessionEndPoint.a.b(this), "requestFromStr in dora endpoint -> ".concat(r107));
        switch(r107.hashCode()) {
            case -1093096773: goto L67;
            case 651570445: goto L66;
            case 1003009595: goto L65;
            case 1284758364: goto L61;
            case 1996669219: goto L32;
            default: goto L30;
        };
    L30:
        String r109 = "WAKEUP_SOURCE_AUTO_MIC";
    L74:
        if (ArraysKt.contains(new String[]{"WAKEUP_SOURCE_DORA_VOICE_WAKEUP", r109}, r107) == true) goto L84;
        ILaunchMethodOperation r112 = bga.g.a();
        if (r112 == null) goto L78;
        r112.j();
    L78:
        IObricChatService.f386556a.getClass();
        IObricChatService r113 = IObricChatService.a.a();
        if (r113 == null) goto L82;
        r113.e();
    L82:
        return TuplesKt.to(ErrorCode.ONLY_END, "dora-not-in-wakeup");
    L84:
        return TuplesKt.to(ErrorCode.CONTINUE, "");
    L61:
        String r114 = "WAKEUP_SOURCE_AUTO_MIC";
        if (r107.equals("WAKEUP_SOURCE_DORA_KEY_UP") == true) goto L64;
    L63:
        r109 = r114;
        goto L74
    L64:
        r109 = r114;
    L70:
        com.larus.utils.y.b().removeCallbacks(this.f391535e);
        ObricInteractDelegate.f392884b.notifyAiKeyEvent(0);
        IAssistActivateOperation r115 = bga.d.a();
        if (r115 == null) goto L74;
        Boxing.boxBoolean(r115.k());
        goto L74
    L65:
        r109 = "WAKEUP_SOURCE_AUTO_MIC";
        r107.equals(r109);
        goto L74
    L66:
        r109 = "WAKEUP_SOURCE_AUTO_MIC";
        r107.equals("WAKEUP_SOURCE_DORA_VOICE_WAKEUP");
        goto L74
    L67:
        r109 = "WAKEUP_SOURCE_AUTO_MIC";
        if (r107.equals("WAKEUP_SOURCE_DORA_KEY_CANCEL") == true) goto L70;
    L32:
        if (r107.equals("WAKEUP_SOURCE_DORA_KEY_DOWN") == false) goto L30;
        long r116 = r106.getLong(IntentCompat.EXTRA_TIME, -1);
        r114 = "WAKEUP_SOURCE_AUTO_MIC";
        long r117 = SystemClock.uptimeMillis();
        long r118 = r106.getLong(IntentCompat.EXTRA_TIME, -1);
        if (r118 <= 0) goto L37;
        long r119 = RangesKt.coerceAtLeast(r117 - r118, 0);
    L38:
        r108.i(ISessionEndPoint.a.b(this), "doraKeyDown: eventTime=" + r116 + ", currentUptime=" + r117 + ", backtrackDurationMs=" + r119);
        IAssistActivateOperation r120 = bga.d.a();
        if (r120 == null) goto L41;
        Boxing.boxBoolean(r120.e(r106, r119));
    L41:
        ILaunchMethodOperation r121 = bga.g.a();
        if (r121 == null) goto L44;
        ILaunchMethodOperation.a.a(r121, null, "dora_radio", 1);
    L44:
        ILaunchMethodOperation r122 = bga.g.a();
        if (r122 == null) goto L47;
        r122.k("open_radio_mode");
    L47:
        IAssistActivateOperation r123 = bga.d.a();
        if (r123 != null) goto L50;
    L52:
        boolean r124 = false;
    L53:
        if (r124 == false) goto L57;
        IAssistActivateOperation r125 = bga.d.a();
        if (r125 == null) goto L57;
        r125.a();
    L57:
        ObricInteractDelegate.f392884b.notifyAiKeyEvent(1);
        IAssistActivateOperation r126 = bga.d.a();
        if (r126 == null) goto L60;
        Boxing.boxBoolean(IAssistActivateOperation.a.b(r126, null, true, new t0(this), 3));
    L60:
        com.larus.utils.y.b().postDelayed(this.f391535e, 500);
        goto L63
    L50:
        if (r123.j() == true) goto L52;
        r124 = true;
        goto L53
    L37:
        r119 = 100;
        goto L38
    L20:
        if (Intrinsics.areEqual(r107, "WAKEUP_SOURCE_AUTO_MIC") == false) goto L84;
        ISessionMaintaining r127 = bga.j.b();
        if (r127 != null) goto L24;
    L26:
        boolean r128 = false;
    L27:
        if (r128 == false) goto L84;
    L24:
        if (r127.g() != true) goto L26;
        r128 = true;
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        r106 = r110;
        r100.L$0 = r106;
        r100.label = 1;
        if (ISessionEndPoint.a.e(this) != r103) goto L17;
        return r103;
    L7:
        r100 = new DoraSessionEndpoint$onSessionProcess$1(this, r111);
        goto L8
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void p(Context r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "args");
        ISessionEndPoint.a.d(this, r100, r110);
        String r101 = bga.j.a();
        if (ArraysKt.contains(new String[]{"WAKEUP_SOURCE_DORA_KEY_DOWN", "WAKEUP_SOURCE_DORA_KEY_UP", "WAKEUP_SOURCE_DORA_KEY_CANCEL", "WAKEUP_SOURCE_DORA_VOICE_WAKEUP"}, r101) == false) goto L5;
    L17:
        this.f391531a = true;
        this.f391533c = Integer.valueOf(r110.getInt("DORA_WAKEUP_VUIID"));
        FLogger.f375446a.i(ISessionEndPoint.a.b(this), "dora wakeup, vuiid: " + this.f391533c);
        int r111 = r101.hashCode();
        if (r111 == (-1093096773)) goto L33;
        if (r111 == 1284758364) goto L29;
        if (r111 == 1996669219) goto L25;
        return;
    L25:
        if (r101.equals("WAKEUP_SOURCE_DORA_KEY_DOWN") == false) goto L42;
        this.f391534d = true;
        return;
    L42:
        return;
    L29:
        if (r101.equals("WAKEUP_SOURCE_DORA_KEY_UP") == false) goto L43;
        this.f391534d = false;
        return;
    L43:
        return;
    L33:
        if (r101.equals("WAKEUP_SOURCE_DORA_KEY_CANCEL") == false) goto L44;
        this.f391534d = false;
        return;
    L44:
        return;
    L5:
        if (Intrinsics.areEqual(r101, "WAKEUP_SOURCE_AUTO_MIC") == false) goto L15;
        ISessionMaintaining r102 = bga.j.b();
        if (r102 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L15;
    L9:
        if (r102.g() != true) goto L11;
        r103 = true;
    L15:
        if (this.f391534d == true) goto L37;
        this.f391531a = false;
        this.f391533c = null;
        return;
    }
}
