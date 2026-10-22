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
public final class f implements c {
    public final AvBizType a;
    public volatile b78.a b;

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

    public f(AvBizType r2) {
        Intrinsics.checkNotNullParameter(r2, "bizType");
        this.a = r2;
    }

    @Override // b78.c
    public final void e(boolean r40, IRealtimeCallTracer r41, RealtimeCallParam r42, com.larus.audio.call.tracer.b r43) {
        Intrinsics.checkNotNullParameter(r41, "tracer");
        Intrinsics.checkNotNullParameter(r42, "params");
        Intrinsics.checkNotNullParameter(r43, "traceSpan");
        int r4 = com.larus.im.a.a;
        o r5 = com.larus.im.internal.d.a;
        u r6 = u.c;
        if (r42.T == true) goto L5;
        String r7 = com.larus.audio.call.f.c().a();
    L6:
        String r15 = r7;
        String r20 = this.a.getBizId();
        AudioSessionType r21 = AudioSessionType.RTC;
        String r22 = com.larus.audio.call.f.c().appContext().c();
        String r23 = com.larus.audio.call.f.c().appContext().b();
        String r24 = com.larus.audio.call.f.c().appContext().a();
        long r25 = CastLongProtector.parseLong(com.larus.audio.call.f.c().appContext().h());
        String r8 = com.larus.audio.call.f.d().e;
        String r14 = r42.e;
        RealtimeCallParam.p r9 = r42.o;
        String r13 = r9.c;
        String r12 = r9.h;
        Map<String, String> r32 = i.b(r42, r43, this.a, r40);
        boolean r3 = r42.v;
        AvAecOutputType.a r10 = AvAecOutputType.Companion;
        int r11 = r42.V;
        r10.getClass();
        if (AvAecOutputType.a.a(r11) == AvAecOutputType.AecMono) goto L9;
        int r16 = 2;
    L10:
        int r17 = r42.l.e;
        int r19 = r42.o.j;
        Integer r26 = Integer.valueOf(r42.U);
        boolean r110 = true;
        if (r26.intValue() <= 0) goto L13;
        boolean r27 = true;
    L14:
        if (r27 == true) goto L17;
        r26 = null;
    L17:
        if (r26 == null) goto L19;
        int r111 = r26.intValue();
    L20:
        AvAudioKitMode r29 = r42.x;
        boolean r30 = r42.T;
        String r112 = com.larus.audio.call.common.b.a;
        if (r30 == false) goto L23;
    L28:
        r110 = false;
    L29:
        String r113 = com.larus.audio.call.common.b.b;
        com.larus.im.service.audio.c r114 = new com.larus.im.service.audio.c(1, r19, r16, r17, r111, r29, r30, r112, r15, r110, AvAecOutputType.a.a(r42.V), r113);
        com.larus.audio.call.util.e.a.i("RTCAudioSessionCreator", "create rtc audio session with config: " + r114);
        id9.d r31 = r6.b(new x0(r20, r21, r22, r23, r24, Long.valueOf(r25), r8, r14, r13, r12, r114, r3, r32, null, null, null, 122880));
        r42.t = r31.k() ? 1 : 0;
        this.b = new b78.a(r41, r42, r31);
        return;
    L23:
        if (r15.length() <= 0) goto L25;
        boolean r115 = true;
    L26:
        if (r115 == false) goto L28;
    L25:
        r115 = false;
        goto L26
    L19:
        r111 = 20;
        goto L20
    L13:
        r27 = false;
        goto L14
    L9:
        r16 = r42.l.f;
        goto L10
    L5:
        r7 = "";
        goto L6
    }
}
