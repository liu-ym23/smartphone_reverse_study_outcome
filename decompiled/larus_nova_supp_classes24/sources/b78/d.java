package b78;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.audio.call.utils.AvBizType;
import com.larus.im.internal.audio.u;
import com.larus.im.internal.delegate.w;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.AvAecOutputType;
import com.larus.im.service.audio.AvAudioKitMode;
import com.larus.im.service.audio.VideoSourceType;
import com.larus.im.service.audio.h1;
import com.larus.im.service.audio.x0;
import gd9.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements c {
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

    public d(AvBizType r2) {
        Intrinsics.checkNotNullParameter(r2, "bizType");
        this.a = r2;
    }

    @Override // b78.c
    public final void e(boolean r44, IRealtimeCallTracer r45, RealtimeCallParam r46, com.larus.audio.call.tracer.b r47) {
        Intrinsics.checkNotNullParameter(r45, "tracer");
        Intrinsics.checkNotNullParameter(r46, "params");
        Intrinsics.checkNotNullParameter(r47, "traceSpan");
        if (this.a != AvBizType.VOICE_CALL) goto L5;
        boolean r4 = true;
    L6:
        com.larus.im.service.audio.e r5 = null;
        if (r4 == false) goto L22;
        w.a r8 = w.j().f;
        if (r8 == null) goto L11;
        int r9 = r8.q;
    L12:
        Integer r10 = Integer.valueOf(r9);
        if (r10.intValue() <= 0) goto L15;
        boolean r11 = true;
    L16:
        if (r11 == true) goto L19;
        r10 = null;
    L19:
        if (r10 == null) goto L21;
        int r12 = r10.intValue();
    L23:
        int r13 = r12;
        if (r4 == false) goto L39;
        w.a r6 = w.j().f;
        if (r6 == null) goto L28;
        int r7 = r6.r;
    L29:
        Integer r14 = Integer.valueOf(r7);
        if (r14.intValue() <= 0) goto L32;
        boolean r15 = true;
    L33:
        if (r15 == true) goto L36;
        r14 = null;
    L36:
        if (r14 == null) goto L38;
        int r16 = r14.intValue();
    L40:
        int r17 = r16;
        boolean r19 = r46.T;
        if (r19 == false) goto L43;
        int r110 = 40;
    L49:
        if (r19 == true) goto L51;
        String r20 = com.larus.audio.call.f.c().a();
    L52:
        String r111 = r20;
        int r21 = com.larus.im.a.a;
        o r22 = com.larus.im.internal.d.a;
        u r23 = u.c;
        String r24 = this.a.getBizId();
        AudioSessionType r25 = AudioSessionType.MMT;
        String r26 = com.larus.audio.call.f.c().appContext().c();
        String r27 = com.larus.audio.call.f.c().appContext().b();
        String r29 = com.larus.audio.call.f.c().appContext().a();
        long r210 = CastLongProtector.parseLong(com.larus.audio.call.f.c().appContext().h());
        String r30 = com.larus.audio.call.f.d().e;
        String r112 = r46.e;
        RealtimeCallParam.p r31 = r46.o;
        String r113 = r31.c;
        String r114 = r31.h;
        Map<String, String> r35 = i.b(r46, r47, this.a, r44);
        RealtimeCallParam.m r32 = r46.B;
        if (r32 == null) goto L55;
        String r37 = r32.a;
    L56:
        String r38 = this.a.getBizId();
        RealtimeCallParam.h r33 = r46.k;
        com.larus.im.service.d r3 = new com.larus.im.service.d(r37, r38, r33.z, r33.A, com.larus.audio.call.f.c().b(), r46.b0);
        h1 r34 = r46.n.f;
        if (r34 == null) goto L60;
        String r115 = r114;
        String r211 = r113;
        r5 = new com.larus.im.service.audio.e(VideoSourceType.EXTERNAL_ENCODED, r34, r46.a0, 2);
    L59:
        com.larus.im.service.audio.e r39 = r5;
    L64:
        if (r46.T == false) goto L68;
        AvAecOutputType.a r36 = AvAecOutputType.Companion;
        int r40 = r46.V;
        r36.getClass();
        if (AvAecOutputType.a.a(r40) != AvAecOutputType.AecStereo) goto L68;
        int r116 = 2;
    L69:
        AvAudioKitMode r41 = r46.x;
        boolean r42 = r46.T;
        String r43 = com.larus.audio.call.common.b.a;
        if (r42 == false) goto L72;
    L77:
        boolean r212 = false;
    L79:
        if (r46.T == false) goto L81;
        AvAecOutputType.a r117 = AvAecOutputType.Companion;
        int r48 = r46.V;
        r117.getClass();
        AvAecOutputType r49 = AvAecOutputType.a.a(r48);
    L82:
        String r310 = r115;
        com.larus.im.service.audio.c r118 = new com.larus.im.service.audio.c(1, r17, r116, r13, r110, r41, r42, r43, r111, r212, r49, "");
        com.larus.audio.call.util.e.a.i("MMTSessionCreator", "create mmt audio session with config: " + r118);
        Unit r0 = Unit.INSTANCE;
        this.b = new b78.a(r45, r46, r23.b(new x0(r24, r25, r26, r27, r29, Long.valueOf(r210), r30, r112, r211, r310, r118, false, r35, r3, null, r39, 49152)));
        return;
    L81:
        r49 = AvAecOutputType.AecMono;
        goto L82
    L72:
        if (r111.length() <= 0) goto L74;
        boolean r119 = true;
    L75:
        if (r119 == false) goto L77;
        r212 = true;
        goto L79
    L74:
        r119 = false;
    L68:
        r116 = r46.l.f;
        goto L69
    L60:
        r115 = r114;
        r211 = r113;
        Boolean r50 = r46.a0;
        if (r50 == null) goto L59;
        boolean r51 = r50.booleanValue();
        com.larus.audio.call.util.e.a.i("MMTSessionCreator", "MMT video preferHardwareAcceleration=" + r51);
        r39 = new com.larus.im.service.audio.e(null, null, Boolean.valueOf(r51), 7);
        goto L64
    L55:
        r37 = null;
        goto L56
    L51:
        r20 = "";
        goto L52
    L43:
        int r52 = r46.U;
        if (r52 != 0) goto L46;
    L48:
        r110 = 20;
        goto L49
    L46:
        if ((r52 % 20) != 0) goto L48;
        r110 = r52;
        goto L49
    L38:
        r16 = r46.o.j;
        goto L40
    L32:
        r15 = false;
        goto L33
    L28:
        r7 = 0;
        goto L29
    L39:
        r16 = r46.o.j;
        goto L40
    L21:
        r12 = r46.l.e;
        goto L23
    L15:
        r11 = false;
        goto L16
    L11:
        r9 = 0;
        goto L12
    L22:
        r12 = r46.l.e;
        goto L23
    L5:
        r4 = false;
        goto L6
    }
}
