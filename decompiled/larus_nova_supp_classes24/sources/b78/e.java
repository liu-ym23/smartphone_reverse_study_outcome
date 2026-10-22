package b78;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.audio.call.utils.AvBizType;
import com.larus.im.internal.audio.u;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.AvAecOutputType;
import com.larus.im.service.audio.x0;
import gd9.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e implements c {
    public final AvBizType a;
    public b78.a b;

    public static final class a {
    }

    static {
    }

    @Override // b78.c
    public final boolean a() {
        return true;
    }

    @Override // b78.c
    public final boolean async() {
        return true;
    }

    @Override // b78.c
    public final b78.a b() {
        return this.b;
    }

    @Override // b78.c
    public final void c() {
        w68.a r0 = w68.b.a;
    }

    @Override // b78.c
    public final void d() {
        w68.a r0 = w68.b.a;
    }

    public e(AvBizType r2) {
        Intrinsics.checkNotNullParameter(r2, "bizType");
        this.a = r2;
    }

    @Override // b78.c
    public final void e(boolean r36, IRealtimeCallTracer r37, RealtimeCallParam r38, com.larus.audio.call.tracer.b r39) {
        Intrinsics.checkNotNullParameter(r37, "tracer");
        Intrinsics.checkNotNullParameter(r38, "params");
        Intrinsics.checkNotNullParameter(r39, "traceSpan");
        int r4 = com.larus.im.a.a;
        o r5 = com.larus.im.internal.d.a;
        u r6 = u.c;
        String r7 = this.a.getBizId();
        AudioSessionType r8 = AudioSessionType.QUIC;
        String r9 = com.larus.audio.call.f.c().appContext().c();
        String r10 = com.larus.audio.call.f.c().appContext().b();
        String r11 = com.larus.audio.call.f.c().appContext().a();
        long r20 = CastLongProtector.parseLong(com.larus.audio.call.f.c().appContext().h());
        String r13 = com.larus.audio.call.f.d().e;
        String r14 = r38.e;
        RealtimeCallParam.p r12 = r38.o;
        String r15 = r12.c;
        String r16 = r12.h;
        Map<String, String> r19 = i.b(r38, r39, this.a, r36);
        RealtimeCallParam.d r3 = r38.l;
        com.larus.im.service.audio.c r0 = new com.larus.im.service.audio.c(1, r38.o.j, r3.f, r3.e, 20, r38.x, false, com.larus.audio.call.common.b.a, "", false, AvAecOutputType.AecMono, "");
        com.larus.audio.call.util.e.a.i("QuicSessionCreator", "create rtc audio session with config: " + r0);
        Unit r1 = Unit.INSTANCE;
        this.b = new b78.a(r37, r38, r6.b(new x0(r7, r8, r9, r10, r11, Long.valueOf(r20), r13, r14, r15, r16, r0, false, r19, null, null, null, 122880)));
    }
}
