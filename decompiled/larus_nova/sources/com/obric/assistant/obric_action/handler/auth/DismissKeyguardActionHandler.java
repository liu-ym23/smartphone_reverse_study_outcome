package com.obric.assistant.obric_action.handler.auth;

import afa.b;
import afa.c;
import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.obric.assistant.spi.keyguard.IKeyguardService;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/obric_action/handler/auth/DismissKeyguardActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/auth/DismissKeyguardActionParams;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/auth/DismissKeyguardActionParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DismissKeyguardActionHandler implements IObricActionHandler<c, Unit> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<c> f390459b;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r100 = d.c.f390410a;
        return d.c.f390410a;
    }

    public DismissKeyguardActionHandler() {
        this.f390459b = c.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<c> b() {
        return this.f390459b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final c a(Context r100, String r101) {
        return (c) IObricActionHandler.b.a(this, r100, r101);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r110, c r111, Continuation<? super h<? extends Unit>> r112) {
        c r113 = r111;
        if (r113 != null) goto L5;
        r113 = new c(0);
    L5:
        FLogger r100 = FLogger.f375446a;
        r100.i("DismissKeyguardActionHandler", "handle: context=" + r110 + ", params=" + r113);
        KeyguardService r101 = KeyguardService.f392886a;
        boolean r114 = r101.isKeyguardLocked();
        Boolean r102 = r113.e();
        if (r102 == null) goto L8;
        boolean r103 = r102.booleanValue();
    L9:
        Boolean r104 = r113.a();
        if (r104 == null) goto L12;
        boolean r105 = r104.booleanValue();
    L13:
        Boolean r106 = r113.d();
        if (r106 == null) goto L16;
        boolean r107 = r106.booleanValue();
    L17:
        Boolean r108 = r113.c();
        if (r108 == null) goto L20;
        boolean r109 = r108.booleanValue();
    L21:
        Boolean r115 = r113.b();
        if (r115 == null) goto L24;
        boolean r116 = r115.booleanValue();
    L25:
        if (r103 == false) goto L28;
        if (r114 == true) goto L28;
        r100.i("DismissKeyguardActionHandler", "skipWhenKeyguardDismissed and keyguard not locked, return success");
        return h.a.c(h.f390443d, null, null, 3);
    L28:
        j r117 = new j(IntrinsicsKt.intercepted(r112), 1);
        r117.C();
        AtomicBoolean r118 = new AtomicBoolean(false);
        r117.i(new afa.a(r118));
        IKeyguardService.a.a(r101, new b(r118, r117), r109, r107, r105, r116, null, 32);
        Object r119 = r117.B();
        if (r119 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L33;
        DebugProbesKt.probeCoroutineSuspended(r112);
        return r119;
    L33:
        return r119;
    L24:
        r116 = false;
        goto L25
    L20:
        r109 = false;
        goto L21
    L16:
        r107 = true;
        goto L17
    L12:
        r105 = true;
        goto L13
    L8:
        r103 = true;
        goto L9
    }

    public static final void e(AtomicBoolean r100, i r101, h r102, String r103) {
        if (r100.compareAndSet(false, true) == true) goto L6;
        FLogger.f375446a.w("DismissKeyguardActionHandler", r103.concat(" ignored because dismissKeyguard result already completed"));
        return;
    L6:
        if (r101.isActive() == true) goto L13;
        FLogger.f375446a.w("DismissKeyguardActionHandler", r103.concat(" ignored because dismissKeyguard continuation is inactive"));
        return;
    L13:
        r101.resumeWith(Result.m9449constructorimpl(r102));     // Catch: IllegalStateException -> L10
        return;
    L10:
        e = move-exception;
        FLogger.f375446a.e("DismissKeyguardActionHandler", r103 + " resume dismissKeyguard result failed. " + e.getMessage(), e);
    }
}
