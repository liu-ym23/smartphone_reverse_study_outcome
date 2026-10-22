package com.larus.suggest.impl.wcb.request;

import android.os.SystemClock;
import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.suggest.impl.wcb.policy.c0;
import com.larus.suggest.impl.wcb.policy.s;
import com.larus.suggest.impl.wcb.policy.t;
import com.larus.suggest.impl.wcb.policy.u;
import com.larus.suggest.impl.wcb.policy.z;
import com.larus.suggest.impl.wcb.render.h;
import com.larus.suggest.impl.wcb.render.i;
import com.larus.suggest.impl.wcb.render.m;
import com.larus.suggest.impl.wcb.render.n;
import com.larus.suggest.impl.wcb.render.o;
import com.larus.suggest.impl.wcb.render.p;
import com.larus.suggest.impl.wcb.render.q;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import hx9.l;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class WcbResponseConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f370081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kx9.a f370082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f370083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f370084d;

    public WcbResponseConsumer(hx9.a r100, kx9.a r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "monitor");
        Intrinsics.checkNotNullParameter(r102, "inputStateTracker");
        this.f370081a = r100;
        this.f370082b = r101;
        this.f370083c = r102;
        this.f370084d = new m(r100);
    }

    public final Object f(jx9.a r100, com.larus.suggest.impl.wcb.render.l r101, q r102, Function0<Boolean> r103, Continuation<? super n.b> r104) {
        if ((r104 instanceof WcbResponseConsumer$submitRenderPlan$1) == false) goto L7;
        WcbResponseConsumer$submitRenderPlan$1 r105 = (WcbResponseConsumer$submitRenderPlan$1) r104;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r107 = r105.result;
        Object r108 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r109 = r105.label;
        if (r109 == 0) goto L14;
        if (r109 != 1) goto L13;
        r103 = (Function0) r105.L$1;
        r100 = (jx9.a) r105.L$0;
        ResultKt.throwOnFailure(r107);
    L17:
        n r110 = (n) r107;
        if (r103.invoke().booleanValue() == true) goto L21;
        return null;
    L21:
        if ((r110 instanceof n.b) == false) goto L24;
        return (n.b) r110;
    L24:
        if ((r110 instanceof n.a) == false) goto L28;
        kx9.a.d(this.f370082b, r100, ((n.a) r110).f370062a, true, 4);
        return null;
    L28:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r107);
        r105.L$0 = r100;
        r105.L$1 = r103;
        r105.label = 1;
        r107 = r102.a(r101, r105);
        if (r107 != r108) goto L17;
        return r108;
    L7:
        r105 = new WcbResponseConsumer$submitRenderPlan$1(this, r104);
        goto L8
    }

    public final Object e(f r100, NexPulseResponseData r101, jx9.a r110, q r111, Function0 r112, ContinuationImpl r113) {
        m r102 = this.f370084d;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        z r103 = r100.f370118f.f370099a;
        if (r103.e().b(r100, r101, r102.f370061a) == false) goto L9;
        p r104 = r100.f370118f.f370103e;
        if (r104 == null) goto L9;
        if (r101 == null) goto L9;
        com.larus.suggest.impl.wcb.render.l.c r105 = new com.larus.suggest.impl.wcb.render.l.c(r104, r103.g().b(r100, r101));
    L11:
        if (r105 == null) goto L13;
        Object r106 = f(r110, r105, r111, r112, r113);
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        return r106;
    L18:
        return Unit.INSTANCE;
    L13:
        return Unit.INSTANCE;
    L9:
        r105 = null;
        goto L11
    }

    public final Object a(f r110, NexPulseResponseData r111, jx9.a r210, q r211, p r212, Function0<Boolean> r213, Continuation<? super Boolean> r214) {
        if ((r214 instanceof WcbResponseConsumer$acceptDisplay$1) == false) goto L7;
        WcbResponseConsumer$acceptDisplay$1 r100 = (WcbResponseConsumer$acceptDisplay$1) r214;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L17;
        if (r104 == 1) goto L16;
        if (r104 != 2) goto L15;
        ResultKt.throwOnFailure(r102);
    L37:
        return Boxing.boxBoolean(false);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Function0 r105 = (Function0) r100.L$5;
        p r106 = (p) r100.L$4;
        q r107 = (q) r100.L$3;
        jx9.a r112 = (jx9.a) r100.L$2;
        NexPulseResponseData r113 = (NexPulseResponseData) r100.L$1;
        f r114 = (f) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Function0 r115 = r105;
        q r116 = r107;
        NexPulseResponseData r108 = r113;
    L21:
        s r109 = (s) r102;
        if (r115.invoke().booleanValue() == true) goto L26;
        return Boxing.boxBoolean(false);
    L26:
        if (r114.f370118f.f370099a.h().l(r114) == false) goto L30;
        FLogger.f375446a.w("WcbLog", "intercept wcb result, reason=wcb consumed in conversation");
        return Boxing.boxBoolean(false);
    L30:
        if ((r109 instanceof s.b) == false) goto L39;
        FLogger r117 = FLogger.f375446a;
        StringBuilder r118 = new StringBuilder("display.evaluate wcb cause ");
        s.b r119 = (s.b) r109;
        r118.append(r119.f370005a);
        r117.i("WcbLog", r118.toString());
        kx9.a.d(this.f370082b, r112, r119.f370005a, true, 4);
        if (r106 != null) goto L37;
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.L$5 = null;
        r100.label = 2;
        if (e(r114, r108, r112, r116, r115, r100) != r103) goto L37;
        return r103;
    L39:
        return Boxing.boxBoolean(true);
    L17:
        ResultKt.throwOnFailure(r102);
        t r120 = r110.f370118f.f370099a.getDisplay();
        l r121 = this.f370081a;
        r100.L$0 = r110;
        r108 = r111;
        r100.L$1 = r108;
        r112 = r210;
        r100.L$2 = r112;
        r116 = r211;
        r100.L$3 = r116;
        r100.L$4 = r212;
        r115 = r213;
        r100.L$5 = r115;
        r100.label = 1;
        r102 = r120.a(r110, r121, r100);
        if (r102 != r103) goto L20;
        return r103;
    L20:
        r106 = r212;
        r114 = r110;
    L7:
        r100 = new WcbResponseConsumer$acceptDisplay$1(this, r214);
        goto L8
    }

    public final Object b(f r100, NexPulseResponseData r110, jx9.a r111, q r112, p r113, Function0<Boolean> r114, Continuation<? super Boolean> r115) {
        if ((r115 instanceof WcbResponseConsumer$acceptInteraction$1) == false) goto L7;
        WcbResponseConsumer$acceptInteraction$1 r101 = (WcbResponseConsumer$acceptInteraction$1) r115;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        WcbResponseConsumer$acceptInteraction$1 r103 = r101;
        Object r116 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r116);
    L24:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r116);
        u r117 = r100.f370118f.f370099a.d().a(r100, this.f370081a, this.f370083c);
        if ((r117 instanceof u.b) == false) goto L17;
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("[pipeline] interaction intercept wcb cause ");
        u.b r118 = (u.b) r117;
        r107.append(r118.f370007a);
        r106.w("WcbLog", r107.toString());
        kx9.a.d(this.f370082b, r111, r118.f370007a, true, 4);
        if (r113 != null) goto L24;
        r103.label = 1;
        if (e(r100, r110, r111, r112, r114, r103) != r104) goto L24;
        return r104;
    L17:
        return Boxing.boxBoolean(true);
    L7:
        r101 = new WcbResponseConsumer$acceptInteraction$1(this, r115);
        goto L8
    }

    public final Object c(f r210, jx9.a r211, g r212, q r213, p r214, d r215, Continuation r216) {
        if ((r216 instanceof WcbResponseConsumer$consume$1) == false) goto L7;
        WcbResponseConsumer$consume$1 r100 = (WcbResponseConsumer$consume$1) r216;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        WcbResponseConsumer$consume$1 r110 = r100;
        Object r102 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r110.label;
        if (r103 == 0) goto L20;
        if (r103 == 1) goto L19;
        if (r103 == 2) goto L18;
        if (r103 == 3) goto L17;
        if (r103 != 4) goto L16;
        ResultKt.throwOnFailure(r102);
    L47:
        return r102;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        NexPulseResponseData r104 = (NexPulseResponseData) r110.L$5;
        Function0<Boolean> r105 = (Function0) r110.L$4;
        p r106 = (p) r110.L$3;
        q r107 = (q) r110.L$2;
        jx9.a r108 = (jx9.a) r110.L$1;
        f r109 = (f) r110.L$0;
        ResultKt.throwOnFailure(r102);
        Function0<Boolean> r112 = r105;
        p r113 = r106;
        f r114 = r109;
        q r115 = r107;
        NexPulseResponseData r116 = r104;
    L42:
        if (((Boolean) r102).booleanValue() == true) goto L44;
        return null;
    L44:
        r110.L$0 = null;
        r110.L$1 = null;
        r110.L$2 = null;
        r110.L$3 = null;
        r110.L$4 = null;
        r110.L$5 = null;
        r110.label = 4;
        r102 = d(r114, r116, r108, r115, r113, r112, r110);
        if (r102 != r111) goto L47;
        return r111;
    L18:
        NexPulseResponseData r117 = (NexPulseResponseData) r110.L$5;
        Function0<Boolean> r118 = (Function0) r110.L$4;
        p r119 = (p) r110.L$3;
        q r120 = (q) r110.L$2;
        jx9.a r121 = (jx9.a) r110.L$1;
        f r122 = (f) r110.L$0;
        ResultKt.throwOnFailure(r102);
        Function0<Boolean> r123 = r118;
        p r124 = r119;
        q r125 = r120;
        jx9.a r126 = r121;
        f r127 = r122;
    L35:
        if (((Boolean) r102).booleanValue() == true) goto L37;
        return null;
    L37:
        r110.L$0 = r127;
        r110.L$1 = r126;
        r110.L$2 = r125;
        r110.L$3 = r124;
        r110.L$4 = r123;
        r110.L$5 = r117;
        r110.label = 3;
        f r128 = r127;
        jx9.a r129 = r126;
        q r130 = r125;
        p r131 = r124;
        Function0<Boolean> r132 = r123;
        Object r133 = b(r127, r117, r126, r125, r124, r123, r110);
        if (r133 != r111) goto L40;
        return r111;
    L40:
        r114 = r128;
        r116 = r117;
        r102 = r133;
        r108 = r129;
        r112 = r132;
        r113 = r131;
        r115 = r130;
        goto L42
    L19:
        Function0<Boolean> r134 = (Function0) r110.L$4;
        p r135 = (p) r110.L$3;
        q r136 = (q) r110.L$2;
        jx9.a r137 = (jx9.a) r110.L$1;
        f r138 = (f) r110.L$0;
        ResultKt.throwOnFailure(r102);
        Function0<Boolean> r139 = r134;
        p r140 = r135;
        q r141 = r136;
        jx9.a r142 = r137;
        Object r143 = r102;
        f r144 = r138;
    L27:
        NexPulseResponseData r145 = (NexPulseResponseData) r143;
        if (r145 != null) goto L30;
        return null;
    L30:
        r110.L$0 = r144;
        r110.L$1 = r142;
        r110.L$2 = r141;
        r110.L$3 = r140;
        r110.L$4 = r139;
        r110.L$5 = r145;
        r110.label = 2;
        Function0<Boolean> r146 = r139;
        p r147 = r140;
        q r148 = r141;
        Object r149 = a(r144, r145, r142, r141, r140, r146, r110);
        if (r149 != r111) goto L33;
        return r111;
    L33:
        r127 = r144;
        r126 = r142;
        r102 = r149;
        r117 = r145;
        r123 = r146;
        r124 = r147;
        r125 = r148;
        goto L35
    L20:
        ResultKt.throwOnFailure(r102);
        FLogger.f375446a.i("WcbLog", "[pipeline] result.consume chat=" + r210.f370116d + " exec=" + r210.f370117e + " source=" + r212.f370120b + " result=" + r212.f370119a.getClass().getSimpleName());
        if (((Boolean) r215.invoke()).booleanValue() == true) goto L23;
        return null;
    L23:
        r110.L$0 = r210;
        r110.L$1 = r211;
        r110.L$2 = r213;
        r110.L$3 = r214;
        r110.L$4 = r215;
        r110.label = 1;
        Object r150 = g(r210, r211, r212, r213, r214, r215, r110);
        if (r150 != r111) goto L26;
        return r111;
    L26:
        r142 = r211;
        r140 = r214;
        r139 = r215;
        r143 = r150;
        r144 = r210;
        r141 = r213;
    L7:
        r100 = new WcbResponseConsumer$consume$1(this, r216);
        goto L8
    }

    public final Object d(f r100, NexPulseResponseData r110, jx9.a r111, q r112, p r113, Function0<Boolean> r114, Continuation<? super p> r115) {
        if ((r115 instanceof WcbResponseConsumer$render$1) == false) goto L7;
        WcbResponseConsumer$render$1 r101 = (WcbResponseConsumer$render$1) r115;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        WcbResponseConsumer$render$1 r103 = r101;
        Object r116 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r116);
    L35:
        n.b r117 = (n.b) r116;
        if (r117 != null) goto L38;
        return null;
    L38:
        return new p(r117.f370063a);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r116);
        m r118 = this.f370084d;
        r118.getClass();
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        Intrinsics.checkNotNullParameter(r110, "response");
        z r106 = r100.f370118f.f370099a;
        h r119 = r106.e().a(r118.f370061a);
        i r107 = r106.g().a(r100, r110, r119);
        if (r107 != null) goto L17;
        FLogger.f375446a.i("WcbLog", "ignore wcb cause presentation unavailable, nexPulseType=" + r110.getNexPulseType());
        com.larus.suggest.impl.wcb.render.l r108 = null;
    L30:
        if (r108 != null) goto L32;
        return null;
    L32:
        FLogger.f375446a.i("WcbLog", "[pipeline] plan.create ".concat(r108.getClass().getName()));
        r103.label = 1;
        r116 = f(r111, r108, r112, r114, r103);
        if (r116 != r104) goto L35;
        return r104;
    L17:
        if (r113 == null) goto L19;
        o r109 = new o.c(r113);
    L21:
        if (Intrinsics.areEqual(r109, o.a.f370065a) == false) goto L24;
        com.larus.suggest.impl.wcb.render.l r120 = new com.larus.suggest.impl.wcb.render.l.a(r107, null);
    L29:
        r108 = r120;
        goto L30
    L24:
        if ((r109 instanceof o.c) == false) goto L27;
        r120 = new com.larus.suggest.impl.wcb.render.l.c(((o.c) r109).f370067a, r107);
        goto L29
    L27:
        if ((r109 instanceof o.b) == false) goto L40;
        FLogger.f375446a.i("WcbLog", "ignore wcb cause " + ((o.b) r109).f370066a);
        r120 = null;
        goto L29
    L40:
        throw new NoWhenBranchMatchedException();
    L19:
        r109 = r106.i().a(r100, r110, r119);
    L7:
        r101 = new WcbResponseConsumer$render$1(this, r115);
        goto L8
    }

    public final Object g(f r110, jx9.a r111, g r112, q r113, p r114, d r210, Continuation r211) {
        if ((r211 instanceof WcbResponseConsumer$validateResponse$1) == false) goto L7;
        WcbResponseConsumer$validateResponse$1 r100 = (WcbResponseConsumer$validateResponse$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        WcbResponseConsumer$validateResponse$1 r102 = r100;
        Object r103 = r102.result;
        Object r115 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L34:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        if (r112.f370120b != WcbTransportSource.NETWORK) goto L17;
        boolean r105 = true;
    L19:
        if (r110.f370118f.f370099a.h().l(r110) == false) goto L24;
        FLogger.f375446a.w("WcbLog", "intercept wcb result, reason=wcb consumed in conversation");
        if (r105 == false) goto L23;
        this.f370083c.f370089c = false;
    L23:
        return null;
    L24:
        NexPulseResponseData r116 = r112.f370119a.getResponse();
        r111.f500934f = SystemClock.elapsedRealtime();
        r111.f500937i = r116;
        if (r105 == false) goto L27;
        this.f370083c.f370089c = false;
    L27:
        c0 r106 = r110.f370118f.f370099a.a().a(r112.f370119a, r110, this.f370081a, r110.f370118f.f370099a.h().f(r110));
        if (r106 == null) goto L35;
        kx9.a r107 = this.f370082b;
        String r108 = r106.f369964b;
        long r109 = r106.f369963a;
        boolean r117 = r106.f369965c;
        r107.getClass();
        kx9.a.c(r111, r108, r109, r117);
        if (r114 != null) goto L34;
        r102.label = 1;
        if (e(r110, r116, r111, r113, r210, r102) != r115) goto L34;
        return r115;
    L35:
        return r116;
    L17:
        r105 = false;
    L7:
        r100 = new WcbResponseConsumer$validateResponse$1(this, r211);
        goto L8
    }
}
