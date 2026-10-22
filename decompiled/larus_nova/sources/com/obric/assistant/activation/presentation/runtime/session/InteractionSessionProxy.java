package com.obric.assistant.activation.presentation.runtime.session;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.service.voice.VoiceInteractionSession;
import android.view.View;
import bba.b;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningChildCoordinator;
import com.obric.assistant.activation.presentation.runtime.manager.ObricMainProcessStateManager;
import com.obric.assistant.activation.presentation.runtime.manager.f;
import com.obric.assistant.activation.presentation.runtime.manager.l;
import com.obric.assistant.activation.presentation.runtime.precheck.ObricChildListeningPrecheck;
import com.obric.assistant.activation.presentation.runtime.session.dispatch.InteractionSessionEventDispatcher;
import com.obric.assistant.common.utils.i;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes32.dex */
public final class InteractionSessionProxy extends VoiceInteractionSession {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLong f385477d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f385478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f385479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InteractionSessionProxy$controller$1 f385480c;

    public static final class a {
    }

    static {
        f385477d = new AtomicLong(SystemClock.elapsedRealtimeNanos());
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onCreate() {
        i.a r100 = i.a("InteractionSessionProxy_onCreate");
        FLogger r101 = FLogger.f375446a;     // Catch: Throwable -> L7
        r101.i("InteractionSessionProxy", "onCreate start, id=" + this.f385478a);     // Catch: Throwable -> L7
        super.onCreate();     // Catch: Throwable -> L7
        final Context r102 = getContext();     // Catch: Throwable -> L7
        ObricListeningChildCoordinator r103 = ObricListeningChildCoordinator.f385289a;     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L7
        final b r104 = new b(r102);     // Catch: Throwable -> L7
        final ObricChildListeningPrecheck r105 = new ObricChildListeningPrecheck(r102);     // Catch: Throwable -> L7
        ObricListeningChildCoordinator r106 = ObricListeningChildCoordinator.f385289a;     // Catch: Throwable -> L7
        Function0 r107 = new l(r102, r105, r104);     // Catch: Throwable -> L7
        r106.getClass();     // Catch: Throwable -> L7
        ObricListeningChildCoordinator.i(r107);     // Catch: Throwable -> L7
        InteractionSessionEventDispatcher r108 = InteractionSessionEventDispatcher.f385541a;     // Catch: Throwable -> L7
        r108.c(getContext());     // Catch: Throwable -> L7
        r108.d(getContext(), this.f385478a, this.f385480c);     // Catch: Throwable -> L7
        r101.i("InteractionSessionProxy", "onCreate complete, id=" + this.f385478a);     // Catch: Throwable -> L7
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L7
        if (r100 == null) goto L13;
        r100.a();
        return;
    L13:
        return;
    L7:
        th = move-exception;
        if (r100 == null) goto L10;
        r100.a();
    L10:
        throw th;
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final View onCreateContentView() {
        FLogger.f375446a.i("InteractionSessionProxy", "onCreateContentView, id=" + this.f385478a);
        return null;
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onDestroy() {
        i.a r100 = i.a("InteractionSessionProxy_onDestroy");
        FLogger r101 = FLogger.f375446a;     // Catch: Throwable -> L10
        r101.i("InteractionSessionProxy", "onDestroy start, id=" + this.f385478a);     // Catch: Throwable -> L10
        if (InteractionSessionEventDispatcher.f385541a.e(this.f385478a) == false) goto L6;
        ObricListeningChildCoordinator r102 = ObricListeningChildCoordinator.f385289a;     // Catch: Throwable -> L10
        Function0 r103 = new f();     // Catch: Throwable -> L10
        r102.getClass();     // Catch: Throwable -> L10
        ObricListeningChildCoordinator.i(r103);     // Catch: Throwable -> L10
    L6:
        super.onDestroy();     // Catch: Throwable -> L10
        r101.i("InteractionSessionProxy", "onDestroy complete, id=" + this.f385478a);     // Catch: Throwable -> L10
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L10
        if (r100 == null) goto L16;
        r100.a();
        return;
    L16:
        return;
    L10:
        th = move-exception;
        if (r100 == null) goto L13;
        r100.a();
    L13:
        throw th;
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [com.obric.assistant.activation.presentation.runtime.session.InteractionSessionProxy$controller$1] */
    public InteractionSessionProxy(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        long r101 = f385477d.incrementAndGet();
        this.f385478a = r101;
        this.f385479b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f385480c = new InteractionSessionProxy$controller$1(this);
        FLogger.f375446a.i("InteractionSessionProxy", "constructor, id=" + r101);
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onHandleAssist(VoiceInteractionSession.AssistState r100) {
        Intrinsics.checkNotNullParameter(r100, "assistState");
        i.a r101 = i.a("InteractionSessionProxy_onHandleAssist");
        FLogger.f375446a.i("InteractionSessionProxy", "onHandleAssist, id=" + this.f385478a + ", index=" + r100.getIndex() + ", count=" + r100.getCount() + ", focused=" + r100.isFocused());     // Catch: Throwable -> L14
        super.onHandleAssist(r100);     // Catch: Throwable -> L14
        InteractionSessionEventDispatcher r102 = InteractionSessionEventDispatcher.f385541a;     // Catch: Throwable -> L14
        long r103 = this.f385478a;     // Catch: Throwable -> L14
        monitor-enter(r102);     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r100, "assistState");     // Catch: Throwable -> L11
        InteractionSessionEventDispatcher.a.C4590a r104 = new InteractionSessionEventDispatcher.a.C4590a(r103, r100);     // Catch: Throwable -> L11
        InteractionSessionEventDispatcher.b(r104.f385546c, null, InteractionSessionEventDispatcher.f385542b.c(r104));     // Catch: Throwable -> L11
        monitor-exit(r102);     // Catch: Throwable -> L14
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L14
        if (r101 == null) goto L21;
        r101.a();
        return;
    L21:
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        if (r101 == null) goto L17;
        r101.a();
    L17:
        throw th;
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onHandleScreenshot(Bitmap r100) {
        i.a r101 = i.a("InteractionSessionProxy_onHandleScreenshot");
        FLogger r102 = FLogger.f375446a;     // Catch: Throwable -> L18
        StringBuilder r103 = new StringBuilder("onHandleScreenshot, id=");     // Catch: Throwable -> L18
        r103.append(this.f385478a);     // Catch: Throwable -> L18
        r103.append(", hasScreenshot=");     // Catch: Throwable -> L18
        if (r100 == null) goto L6;
        boolean r104 = true;
    L7:
        r103.append(r104);     // Catch: Throwable -> L18
        r102.i("InteractionSessionProxy", r103.toString());     // Catch: Throwable -> L18
        super.onHandleScreenshot(r100);     // Catch: Throwable -> L18
        InteractionSessionEventDispatcher r105 = InteractionSessionEventDispatcher.f385541a;     // Catch: Throwable -> L18
        long r106 = this.f385478a;     // Catch: Throwable -> L18
        monitor-enter(r105);     // Catch: Throwable -> L18
        InteractionSessionEventDispatcher.a.b r107 = new InteractionSessionEventDispatcher.a.b(r106, r100);     // Catch: Throwable -> L15
        InteractionSessionEventDispatcher.b("onHandleScreenshot", null, InteractionSessionEventDispatcher.f385542b.c(r107));     // Catch: Throwable -> L15
        monitor-exit(r105);     // Catch: Throwable -> L18
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L18
        if (r101 == null) goto L25;
        r101.a();
        return;
    L25:
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L6:
        r104 = false;
    L18:
        th = move-exception;
        if (r101 == null) goto L21;
        r101.a();
    L21:
        throw th;
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onPrepareShow(Bundle r100, int r101) {
        i.a r102 = i.a("InteractionSessionProxy_onPrepareShow");
        FLogger r103 = FLogger.f375446a;     // Catch: Throwable -> L19
        StringBuilder r104 = new StringBuilder("onPrepareShow, id=");     // Catch: Throwable -> L19
        r104.append(this.f385478a);     // Catch: Throwable -> L19
        r104.append(", invocationType=");     // Catch: Throwable -> L19
        Integer r105 = null;
        if (r100 == null) goto L7;
        Intrinsics.checkNotNullParameter(r100, "<this>");     // Catch: Throwable -> L19
        Integer r106 = Integer.valueOf(r100.getInt("invocation_type"));     // Catch: Throwable -> L19
    L8:
        r104.append(r106);     // Catch: Throwable -> L19
        r104.append(", showSessionId=");     // Catch: Throwable -> L19
        if (r100 == null) goto L11;
        Intrinsics.checkNotNullParameter(r100, "<this>");     // Catch: Throwable -> L19
        r105 = Integer.valueOf(r100.getInt("android.service.voice.SHOW_SESSION_ID"));     // Catch: Throwable -> L19
    L11:
        r104.append(r105);     // Catch: Throwable -> L19
        r104.append(", showFlags=");     // Catch: Throwable -> L19
        r104.append(r101);     // Catch: Throwable -> L19
        r104.append(", hasArgs=");     // Catch: Throwable -> L19
        if (r100 == null) goto L14;
        boolean r107 = true;
    L15:
        r104.append(r107);     // Catch: Throwable -> L19
        r103.i("InteractionSessionProxy", r104.toString());     // Catch: Throwable -> L19
        super.onPrepareShow(r100, r101);     // Catch: Throwable -> L19
        setUiEnabled(false);     // Catch: Throwable -> L19
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L19
        if (r102 == null) goto L25;
        r102.a();
        return;
    L25:
        return;
    L14:
        r107 = false;
        goto L15
    L7:
        r106 = null;
    L19:
        th = move-exception;
        if (r102 == null) goto L22;
        r102.a();
    L22:
        throw th;
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onShow(Bundle r110, int r111) {
        i.a r100 = i.a("InteractionSessionProxy_onShow");
        if (r110 != null) goto L37;
    L7:
        FLogger r101 = FLogger.f375446a;     // Catch: Throwable -> L5
        StringBuilder r102 = new StringBuilder("onShow, id=");     // Catch: Throwable -> L5
        r102.append(this.f385478a);     // Catch: Throwable -> L5
        r102.append(", invocationType=");     // Catch: Throwable -> L5
        Integer r103 = null;
        if (r110 == null) goto L11;
        Intrinsics.checkNotNullParameter(r110, "<this>");     // Catch: Throwable -> L5
        Integer r104 = Integer.valueOf(r110.getInt("invocation_type"));     // Catch: Throwable -> L5
    L12:
        r102.append(r104);     // Catch: Throwable -> L5
        r102.append(", showSessionId=");     // Catch: Throwable -> L5
        if (r110 == null) goto L15;
        Intrinsics.checkNotNullParameter(r110, "<this>");     // Catch: Throwable -> L5
        r103 = Integer.valueOf(r110.getInt("android.service.voice.SHOW_SESSION_ID"));     // Catch: Throwable -> L5
    L15:
        r102.append(r103);     // Catch: Throwable -> L5
        r102.append(", showFlags=");     // Catch: Throwable -> L5
        r102.append(r111);     // Catch: Throwable -> L5
        r102.append(", hasArgs=");     // Catch: Throwable -> L5
        if (r110 == null) goto L18;
        boolean r105 = true;
    L19:
        r102.append(r105);     // Catch: Throwable -> L5
        r101.i("InteractionSessionProxy", r102.toString());     // Catch: Throwable -> L5
        super.onShow(r110, r111);     // Catch: Throwable -> L5
        if (r110 != null) goto L24;
        r101.e("InteractionSessionProxy", "drop onShow with null args, id=" + this.f385478a);     // Catch: Throwable -> L31
    L27:
        r101.i("InteractionSessionProxy", "hide framework Session after onShow, id=" + this.f385478a);     // Catch: Throwable -> L5
        onHide();     // Catch: Throwable -> L5
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L5
        if (r100 == null) goto L40;
        r100.a();
        return;
    L40:
        return;
    L24:
        if (r110.getInt(InteractConst.WAKEUP_PULL_UP_ONCE) != 1) goto L26;
        r101.i("InteractionSessionProxy", "ignore pull up once onShow, id=" + this.f385478a);     // Catch: Throwable -> L31
        goto L27
    L26:
        ObricListeningChildCoordinator.f385289a.getClass();     // Catch: Throwable -> L31
        ObricListeningChildCoordinator.j(r110);     // Catch: Throwable -> L31
        InteractionSessionEventDispatcher.f385541a.f(this.f385478a, r110, r111);     // Catch: Throwable -> L31
        ObricScreenshotRequester.f385481a.getClass();     // Catch: Throwable -> L31
        ObricScreenshotRequester.a(r110);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        FLogger.f375446a.i("InteractionSessionProxy", "hide framework Session after onShow, id=" + this.f385478a);     // Catch: Throwable -> L5
        onHide();     // Catch: Throwable -> L5
        throw th;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        if (r100 == null) goto L36;
        r100.a();
    L36:
        throw th;
    L18:
        r105 = false;
        goto L19
    L11:
        r104 = null;
        goto L12
    L37:
        r110.putBoolean("o_main_process_ready", ((Boolean) ObricMainProcessStateManager.f385365c.getValue()).booleanValue());     // Catch: Throwable -> L5
        goto L7
    }
}
