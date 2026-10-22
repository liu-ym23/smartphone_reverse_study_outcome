package com.larus.suggest.impl.wcb.request;

import com.larus.platform.service.AccountService;
import com.larus.suggest.impl.wcb.loading.WcbLoadingRenderDecorator;
import com.larus.suggest.impl.wcb.policy.a0;
import com.larus.suggest.impl.wcb.render.k;
import com.larus.suggest.impl.wcb.render.q;
import com.larus.suggest.impl.wcb.render.r;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import hx9.l;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes31.dex */
public final class WcbRequestPipeline {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f370071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f370072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f370073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f370074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WcbRequestExecutionRunner f370075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WcbResponseConsumer f370076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f370077g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q f370078h;

    public final long d() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("[pipeline] transaction.invalidate chat=");
        r101.append(this.f370071a.b());
        r101.append(" exec=");
        r101.append(this.f370077g);
        r101.append(" hasTransaction=");
        if (this.f370078h == null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        r100.i("WcbLog", r101.toString());
        this.f370077g++;
        q r103 = this.f370078h;
        if (r103 == null) goto L9;
        r103.cancel();
    L9:
        this.f370078h = null;
        return this.f370077g;
    L5:
        r102 = false;
        goto L6
    }

    public final void a(c r110) {
        Intrinsics.checkNotNullParameter(r110, "request");
        if (r110.f370100b != WcbRequestTrigger.FOREGROUND) goto L13;
        q r100 = this.f370078h;
        if (r100 == null) goto L9;
        boolean r101 = true;
        if (r100.isActive() != true) goto L9;
    L10:
        if (r101 == false) goto L13;
        this.f370071a.x4();
        return;
    L9:
        r101 = false;
    L13:
        long r102 = d();
        BuildersKt.launch$default(this.f370074d, null, null, new WcbRequestPipeline$execute$1(this, r110, r102, null), 3, null);
    }

    public final boolean e(f r100) {
        if (r100.f370117e == this.f370077g) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r100.f370113a, AccountService.f365697a.getUserId()) == false) goto L7;
        return true;
    }

    public final Object c(q r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof WcbRequestPipeline$finishRenderTransaction$1) == false) goto L7;
        WcbRequestPipeline$finishRenderTransaction$1 r102 = (WcbRequestPipeline$finishRenderTransaction$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 != 1) goto L15;
        r100 = (q) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L25
    L20:
        if (this.f370078h != r100) goto L24;
        this.f370078h = null;
    L24:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r104);
        FLogger.f375446a.i("WcbLog", "[pipeline] transaction.finish isActive=" + r100.isActive() + ", transaction=" + r100);
        r102.L$0 = r100;     // Catch: Throwable -> L25
        r102.label = 1;     // Catch: Throwable -> L25
        if (r100.b(r102) != r105) goto L20;
        return r105;
    L25:
        th = move-exception;
        if (this.f370078h != r100) goto L29;
        this.f370078h = null;
    L29:
        throw th;
    L7:
        r102 = new WcbRequestPipeline$finishRenderTransaction$1(this, r101);
        goto L8
    }

    public final Object b(f r210, jx9.a r211, a0 r212, Continuation<? super Unit> r213) {
        if ((r213 instanceof WcbRequestPipeline$executeDecision$1) == false) goto L7;
        WcbRequestPipeline$executeDecision$1 r100 = (WcbRequestPipeline$executeDecision$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        WcbRequestPipeline$executeDecision$1 r102 = r100;
        Object r103 = r102.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L22;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L14;
        Throwable r105 = (Throwable) r102.L$0;
        ResultKt.throwOnFailure(r103);
        throw r105;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
    L39:
        return Unit.INSTANCE;
    L17:
        q r106 = (q) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L20
    L35:
        r102.L$0 = null;
        r102.label = 2;
        if (c(r106, r102) != r110) goto L39;
        return r110;
    L20:
        th = th;
    L45:
        r102.L$0 = th;
        r102.label = 3;
        if (c(r106, r102) != r110) goto L55;
        return r110;
    L55:
        throw th;
    L22:
        ResultKt.throwOnFailure(r103);
        if (e(r210) == true) goto L25;
        q r107 = null;
    L26:
        if (r107 != null) goto L53;
        FLogger.f375446a.w("WcbLog", "[pipeline] transaction is null, exec=" + r210.f370117e);
        return Unit.INSTANCE;
    L53:
        Ref.ObjectRef r108 = new Ref.ObjectRef();     // Catch: Throwable -> L42
        WcbRequestExecutionRunner r109 = this.f370075e;     // Catch: Throwable -> L42
        long r111 = r211.f500933e;     // Catch: Throwable -> L42
        q r112 = r107;
        WcbRequestPipeline$executeDecision$2 r113 = new WcbRequestPipeline$executeDecision$2(r108, this, r210, r211, r107, null);     // Catch: Throwable -> L40
        r102.L$0 = r112;     // Catch: Throwable -> L40
        r102.label = 1;     // Catch: Throwable -> L40
        if (r109.a(r210, r212, r111, r113, r102) != r110) goto L34;
        return r110;
    L34:
        r106 = r112;
    L40:
        th = th;
    L44:
        r106 = r112;
    L42:
        th = th;
        r112 = r107;
        goto L44
    L25:
        FLogger.f375446a.i("WcbLog", "[pipeline] transaction.begin chat=" + r210.f370116d + " exec=" + r210.f370117e + " decision=" + r212.getClass().getSimpleName());
        q r114 = this.f370073c.a(new k(r210, r211, r212));
        this.f370078h = r114;
        r107 = r114;
    L7:
        r100 = new WcbRequestPipeline$executeDecision$1(this, r213);
        goto L8
    }

    public WcbRequestPipeline(hx9.a r100, String r101, WcbLoadingRenderDecorator r102, kx9.a r103, a r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "initializedConversationId");
        Intrinsics.checkNotNullParameter(r102, "renderer");
        Intrinsics.checkNotNullParameter(r103, "monitor");
        Intrinsics.checkNotNullParameter(r104, "inputStateTracker");
        this.f370071a = r100;
        this.f370072b = r101;
        this.f370073c = r102;
        this.f370074d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.f370075e = new WcbRequestExecutionRunner(r104);
        this.f370076f = new WcbResponseConsumer(r100, r103, r104);
    }
}
