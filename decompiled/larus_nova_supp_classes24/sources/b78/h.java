package b78;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.audio.call.utils.AvBizType;
import com.larus.im.internal.audio.u;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.AvAecOutputType;
import com.larus.im.service.audio.AvAudioKitMode;
import com.larus.im.service.audio.x0;
import gd9.o;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h implements c {
    public final AvBizType a;
    public a b;

    @Override // b78.c
    public final boolean a() {
        return false;
    }

    @Override // b78.c
    public final boolean async() {
        return false;
    }

    @Override // b78.c
    public final a b() {
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

    public h(AvBizType r2) {
        Intrinsics.checkNotNullParameter(r2, "bizType");
        this.a = r2;
    }

    @Override // b78.c
    public final void e(boolean r24, IRealtimeCallTracer r25, RealtimeCallParam r26, com.larus.audio.call.tracer.b r27) {
        Intrinsics.checkNotNullParameter(r25, "tracer");
        Intrinsics.checkNotNullParameter(r26, "params");
        Intrinsics.checkNotNullParameter(r27, "traceSpan");
        com.larus.im.service.audio.c.Companion.getClass();
        com.larus.im.service.audio.c r4 = new com.larus.im.service.audio.c(1, 24000, 1, 16000, 20, AvAudioKitMode.PURE_BIZ, false, "", "", false, AvAecOutputType.AecMono, "");
        int r5 = com.larus.im.a.a;
        o r6 = com.larus.im.internal.d.a;
        u r7 = u.c;
        String r8 = this.a.getBizId();
        AudioSessionType r9 = AudioSessionType.SAMI;
        String r10 = com.larus.audio.call.f.c().appContext().c();
        String r11 = com.larus.audio.call.f.c().appContext().b();
        String r12 = com.larus.audio.call.f.c().appContext().a();
        long r16 = CastLongProtector.parseLong(com.larus.audio.call.f.c().appContext().h());
        String r13 = com.larus.audio.call.f.d().e;
        String r14 = r26.e;
        RealtimeCallParam.p r15 = r26.o;
        String r17 = r15.c;
        String r19 = r15.h;
        Map<String, String> r110 = i.b(r26, r27, this.a, false);
        this.b = new a(r25, r26, r7.b(new x0(r8, r9, r10, r11, r12, Long.valueOf(r16), r13, r14, r17, r19, r4, false, r110, null, null, null, 122880)));
    }
}
