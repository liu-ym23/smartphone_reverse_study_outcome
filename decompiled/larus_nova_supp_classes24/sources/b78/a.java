package b78;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.TriggerType;
import com.larus.audio.call.record.AVInnerRecordAdapter$linkAudioRecorder$1;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.audio.call.util.p;
import com.larus.im.internal.audio.ability.SessionReleaseReason;
import com.larus.im.service.audio.AvAecType;
import com.larus.im.service.audio.ModalType;
import com.larus.im.service.audio.cmd.TargetVideoSourceType;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.im.service.audio.l;
import com.larus.im.service.audio.n;
import com.larus.im.service.audio.o;
import com.larus.im.service.audio.q;
import com.larus.im.service.audio.v;
import com.larus.im.service.audio.x;
import com.larus.im.service.audio.x0;
import com.larus.im.service.audio.y;
import com.larus.im.service.audio.z;
import com.larus.im.service.audio.z0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;
import ouc.g0;
import ouc.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements id9.d {
    public final IRealtimeCallTracer a;
    public final RealtimeCallParam b;
    public final id9.d c;

    public final void A(o r2) {
        this.c.A(r2);
    }

    public final void B(xe9.d r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        this.c.B(r2);
    }

    public final void C(SessionReleaseReason r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        this.c.C(r2);
    }

    public final void D(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.c.D(r2);
    }

    public final y a() {
        return this.c.a();
    }

    public final void b(v r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.c.b(r2);
    }

    public final n c(int r2, AvAecType r3, AVInnerRecordAdapter$linkAudioRecorder$1 r4) {
        Intrinsics.checkNotNullParameter(r3, "aecType");
        Intrinsics.checkNotNullParameter(r4, "preProcessor");
        return this.c.c(r2, r3, r4);
    }

    public final void d(x r2) {
        Intrinsics.checkNotNullParameter(r2, "receiver");
        this.c.d(r2);
    }

    public final z e() {
        return this.c.e();
    }

    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "paramsJson");
        this.c.f(r2);
    }

    public final x0 getSessionConfig() {
        return this.c.getSessionConfig();
    }

    public final void h(boolean r2) {
        this.c.h(r2);
    }

    public final boolean k() {
        return this.c.k();
    }

    public final void m(ModalType r2, TargetVideoSourceType r3) {
        Intrinsics.checkNotNullParameter(r2, "modalType");
        Intrinsics.checkNotNullParameter(r3, "videoSourceType");
        this.c.m(r2, r3);
    }

    public final void n(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c.n(r2);
    }

    public final void o() {
        this.c.o();
    }

    public final void q(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c.q(r2);
    }

    public final void r(Map<String, ? extends Object> r2) {
        this.c.r(r2);
    }

    public final int s(String r2) {
        Intrinsics.checkNotNullParameter(r2, "token");
        return this.c.s(r2);
    }

    public final void start() {
        this.c.start();
    }

    public final jd9.c state() {
        return this.c.state();
    }

    public final void t() {
        this.c.t();
    }

    public final void u(l r2) {
        Intrinsics.checkNotNullParameter(r2, "frame");
        this.c.u(r2);
    }

    public final q v() {
        return this.c.v();
    }

    public final void w(v r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.c.w(r2);
    }

    public final void x(x r2) {
        Intrinsics.checkNotNullParameter(r2, "receiver");
        this.c.x(r2);
    }

    public final void y(Map<String, String> r2) {
        this.c.y(r2);
    }

    public final void p(TriggerMode r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "triggerType");
        String r0 = null;
        if (r7 == null) goto L5;
        d0 r8 = g.a(r7);
    L6:
        String r1 = this.b.p.i;
        if (p.a(r1) == false) goto L9;
        LinkedHashMap r2 = new LinkedHashMap();
        g0 r3 = k.c(r1);
        Intrinsics.checkNotNullParameter("enter_method", "key");
        Intrinsics.checkNotNullParameter(r3, "element");
        ouc.i r4 = (ouc.i) r2.put("enter_method", r3);
        r8 = q68.d.a(new d0(r2), r8);
    L9:
        id9.d r5 = this.c;
        if (r8 == null) goto L12;
        String r9 = r8.toString();
    L13:
        r5.p(r6, r9);
        if (r6 != TriggerMode.HELLO) goto L16;
    L17:
        this.a.Q(IRealtimeCallTracer.HelloStatus.TRIGGER_HELLO, null);
    L18:
        Integer r10 = sf9.b.b(r6);
        if (r10 == null) goto L52;
        int r11 = r10.intValue();
        TriggerType.Companion.getClass();
        if (r11 != 1) goto L23;
        TriggerType r12 = TriggerType.TYPE_HELLO;
    L46:
        if (r12 == null) goto L48;
        r0 = r12.getLogName();
    L48:
        if (r0 != null) goto L50;
        r0 = "";
    L50:
        this.a.y(r0, this.b, new d0(new LinkedHashMap()));
        return;
    L23:
        if (r11 != 2) goto L25;
        r12 = TriggerType.TYPE_WAIT;
        goto L46
    L25:
        if (r11 != 4) goto L27;
        r12 = TriggerType.TYPE_HANG_UP;
        goto L46
    L27:
        if (r11 != 5) goto L29;
        r12 = TriggerType.TYPE_DENY_AUTH;
        goto L46
    L29:
        if (r11 != 6) goto L31;
        r12 = TriggerType.TYPE_AUTH_SUCCESS;
        goto L46
    L31:
        if (r11 == 8) goto L40;
        switch(r11) {
            case 12: goto L39;
            case 13: goto L38;
            case 14: goto L37;
            case 15: goto L36;
            case 16: goto L35;
            case 17: goto L34;
            default: goto L33;
        };
    L33:
        r12 = null;
        goto L46
    L34:
        r12 = TriggerType.TYPE_DORA_E_BOT_ACTIVE;
        goto L46
    L35:
        r12 = TriggerType.TYPE_CLIENT_SUMMON_NOTICE;
        goto L46
    L36:
        r12 = TriggerType.TYPE_QUERY_WHEN_SILENCE;
        goto L46
    L37:
        r12 = TriggerType.TYPE_IMAGE_QUERY;
        goto L46
    L38:
        r12 = TriggerType.TYPE_NOTIFICATION_SUMMARY;
        goto L46
    L39:
        r12 = TriggerType.TYPE_CONTINUE;
        goto L46
    L40:
        r12 = TriggerType.TYPE_ONBOARDING_START;
        goto L46
    L52:
        return;
    L16:
        if (r6 != TriggerMode.HELLO_NEW) goto L18;
    L12:
        r9 = null;
        goto L13
    L5:
        r8 = null;
        goto L6
    }

    public a(IRealtimeCallTracer r2, RealtimeCallParam r3, id9.d r4) {
        Intrinsics.checkNotNullParameter(r2, "tracer");
        Intrinsics.checkNotNullParameter(r3, "param");
        Intrinsics.checkNotNullParameter(r4, "ability");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
