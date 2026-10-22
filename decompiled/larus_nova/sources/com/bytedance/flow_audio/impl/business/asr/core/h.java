package com.bytedance.flow_audio.impl.business.asr.core;

import com.bytedance.flow_audio.api.business.asr.error.FlowAsrErrorType;
import com.bytedance.flow_audio.api.business.asr.session.FlowAsrCancelReason;
import com.bytedance.flow_audio.api.business.asr.session.FlowAsrSessionState;
import com.bytedance.flow_audio.impl.business.asr.FlowAsrPrepareDecision;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f243934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Long> f243935b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f243936a = null;

        static {
            int[] r100 = new int[FlowAsrPrepareDecision.values().length];
            r100[FlowAsrPrepareDecision.ALREADY_PREPARED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[FlowAsrPrepareDecision.IGNORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[FlowAsrPrepareDecision.START_PREPARE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f243936a = r100;
        }
    }

    public static e b(hw5.a r100) {
        return new e(CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a.q0(r100)));
    }

    public h(String r100, t r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "completionTimeoutMs");
        this.f243934a = r100;
        this.f243935b = r101;
    }

    @Override // com.bytedance.flow_audio.impl.business.asr.core.g
    public final e a(d r110, b0 r111) {
        boolean r100 = false;
        boolean r101 = true;
        if (Intrinsics.areEqual(r110, d.t.f243923a) == false) goto L14;
        int r102 = a.f243936a[r111.f243884b.ordinal()];
        if (r102 == 1) goto L175;
        if (r102 == 2) goto L174;
        if (r102 != 3) goto L10;
        return new e(CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a[]{com.bytedance.flow_audio.impl.business.asr.core.a.y.f243873a, new com.bytedance.flow_audio.impl.business.asr.core.a.j0(FlowAsrSessionState.PREPARING), com.bytedance.flow_audio.impl.business.asr.core.a.w0.f243871a, com.bytedance.flow_audio.impl.business.asr.core.a.n.f243855a}));
    L10:
        throw new NoWhenBranchMatchedException();
    L174:
        return new e(0);
    L175:
        return new e(0);
    L14:
        if (Intrinsics.areEqual(r110, d.v.f243925a) == false) goto L36;
        ArrayList r103 = new ArrayList();
        int r104 = a.f243936a[r111.f243884b.ordinal()];
        if (r104 == 1) goto L24;
        if (r104 == 2) goto L176;
        if (r104 != 3) goto L21;
        CollectionsKt.addAll(r103, CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a[]{com.bytedance.flow_audio.impl.business.asr.core.a.y.f243873a, new com.bytedance.flow_audio.impl.business.asr.core.a.j0(FlowAsrSessionState.PREPARING), com.bytedance.flow_audio.impl.business.asr.core.a.w0.f243871a, com.bytedance.flow_audio.impl.business.asr.core.a.n.f243855a}));
        goto L24
    L21:
        throw new NoWhenBranchMatchedException();
    L176:
        return new e(0);
    L24:
        if (r111.f243895m == false) goto L32;
        String r105 = r111.f243896n;
        if (r105 != null) goto L28;
        r105 = "";
    L28:
        com.bytedance.flow_audio.impl.business.asr.core.a[] r106 = new com.bytedance.flow_audio.impl.business.asr.core.a[7];
        r106[0] = com.bytedance.flow_audio.impl.business.asr.core.a.z.f243875a;
        r106[1] = new com.bytedance.flow_audio.impl.business.asr.core.a.j0(FlowAsrSessionState.RECORDING);
        r106[2] = com.bytedance.flow_audio.impl.business.asr.core.a.o.f243856a;
        r106[3] = new com.bytedance.flow_audio.impl.business.asr.core.a.s0(r105);
        r106[4] = new com.bytedance.flow_audio.impl.business.asr.core.a.j0(FlowAsrSessionState.STOPPING);
        r106[5] = com.bytedance.flow_audio.impl.business.asr.core.a.k0.f243849a;
        StringBuilder r107 = new StringBuilder("start file replay ok taskId=");
        r107.append(this.f243934a);
        r107.append(" hasFilePath=");
        if (r105.length() <= 0) goto L31;
        r100 = true;
    L31:
        r107.append(r100);
        r106[6] = new com.bytedance.flow_audio.impl.business.asr.core.a.g0(r107.toString());
        CollectionsKt.addAll(r103, CollectionsKt.listOf(r106));
    L33:
        e r108 = new e(r103);
    L177:
        return r108;
    L32:
        CollectionsKt.addAll(r103, CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a[]{com.bytedance.flow_audio.impl.business.asr.core.a.z.f243875a, new com.bytedance.flow_audio.impl.business.asr.core.a.j0(FlowAsrSessionState.RECORDING), com.bytedance.flow_audio.impl.business.asr.core.a.i0.f243845a, com.bytedance.flow_audio.impl.business.asr.core.a.v0.f243870a, com.bytedance.flow_audio.impl.business.asr.core.a.u.f243868a, com.bytedance.flow_audio.impl.business.asr.core.a.o.f243856a, new com.bytedance.flow_audio.impl.business.asr.core.a.g0("start: ok taskId=" + this.f243934a)}));
        goto L33
    L36:
        if (Intrinsics.areEqual(r110, d.w.f243926a) == false) goto L45;
        com.bytedance.flow_audio.impl.business.asr.q r109 = r111.f243885c;
        if (r109.f244016a == false) goto L178;
        List r112 = CollectionsKt.mutableListOf(new com.bytedance.flow_audio.impl.business.asr.core.a[]{new com.bytedance.flow_audio.impl.business.asr.core.a.j0(FlowAsrSessionState.STOPPING)});
        if (r109.f244017b == false) goto L43;
        CollectionsKt.addAll(r112, CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a[]{com.bytedance.flow_audio.impl.business.asr.core.a.x0.f243872a, com.bytedance.flow_audio.impl.business.asr.core.a.r.f243861a}));
    L43:
        CollectionsKt.addAll(r112, CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a[]{com.bytedance.flow_audio.impl.business.asr.core.a.r0.f243862a, com.bytedance.flow_audio.impl.business.asr.core.a.h0.f243843a, com.bytedance.flow_audio.impl.business.asr.core.a.d0.f243836a, com.bytedance.flow_audio.impl.business.asr.core.a.a0.f243829a, com.bytedance.flow_audio.impl.business.asr.core.a.k0.f243849a}));
        return new e(r112);
    L178:
        return new e(0);
    L45:
        if ((r110 instanceof d.s) == false) goto L54;
        d.s r113 = (d.s) r110;
        if (r111.f243894l == true) goto L180;
        FlowAsrSessionState r114 = r111.f243883a;
        FlowAsrSessionState r115 = FlowAsrSessionState.CANCELING;
        if (r114 == r115) goto L180;
        r108 = new e(CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a[]{new com.bytedance.flow_audio.impl.business.asr.core.a.j0(r115), com.bytedance.flow_audio.impl.business.asr.core.a.e.f243837a, com.bytedance.flow_audio.impl.business.asr.core.a.b.f243831a, com.bytedance.flow_audio.impl.business.asr.core.a.i.f243844a, com.bytedance.flow_audio.impl.business.asr.core.a.c.f243833a, com.bytedance.flow_audio.impl.business.asr.core.a.y0.f243874a, com.bytedance.flow_audio.impl.business.asr.core.a.g.f243840a, new com.bytedance.flow_audio.impl.business.asr.core.a.h(true), new com.bytedance.flow_audio.impl.business.asr.core.a.j0(FlowAsrSessionState.CANCELED), new com.bytedance.flow_audio.impl.business.asr.core.a.m(r113.f243922a), new com.bytedance.flow_audio.impl.business.asr.core.a.g0("cancel completed locally: reason=" + r113.f243922a + " taskId=" + this.f243934a)}));
    L180:
        return new e(0);
    L54:
        if (Intrinsics.areEqual(r110, d.u.f243924a) == false) goto L57;
        return new e(CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a[]{new com.bytedance.flow_audio.impl.business.asr.core.a.j0(FlowAsrSessionState.RELEASED), com.bytedance.flow_audio.impl.business.asr.core.a.e.f243837a, com.bytedance.flow_audio.impl.business.asr.core.a.b.f243831a, com.bytedance.flow_audio.impl.business.asr.core.a.i.f243844a, com.bytedance.flow_audio.impl.business.asr.core.a.o0.f243857a, new com.bytedance.flow_audio.impl.business.asr.core.a.h(true), com.bytedance.flow_audio.impl.business.asr.core.a.g.f243840a, com.bytedance.flow_audio.impl.business.asr.core.a.f.f243839a, new com.bytedance.flow_audio.impl.business.asr.core.a.g0("release: taskId=" + this.f243934a), com.bytedance.flow_audio.impl.business.asr.core.a.j.f243846a}));
    L57:
        if ((r110 instanceof d.f) == false) goto L63;
        d.f r116 = (d.f) r110;
        if (r111.f243886d == false) goto L182;
        r108 = new e(CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a[]{new com.bytedance.flow_audio.impl.business.asr.core.a.l(r116.f243907a), new com.bytedance.flow_audio.impl.business.asr.core.a.b0(r116.f243907a)}));
        goto L177
    L182:
        return new e(0);
    L63:
        if ((r110 instanceof d.h) == false) goto L74;
        d.h r117 = (d.h) r110;
        FlowAsrSessionState r118 = r111.f243883a;
        if (r118 != FlowAsrSessionState.RECORDING) goto L67;
    L70:
        if (r101 == false) goto L183;
        r108 = new e(CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a.s(r117.f243909a)));
        goto L177
    L183:
        return new e(0);
    L67:
        if (r118 == FlowAsrSessionState.PENDING_FAIL) goto L70;
        r101 = false;
        goto L70
    L74:
        if ((r110 instanceof d.i) == false) goto L85;
        d.i r119 = (d.i) r110;
        FlowAsrSessionState r120 = r111.f243883a;
        if (r120 != FlowAsrSessionState.RECORDING) goto L78;
    L81:
        if (r101 == false) goto L184;
        r108 = new e(CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a.t(r119.f243910a)));
        goto L177
    L184:
        return new e(0);
    L78:
        if (r120 == FlowAsrSessionState.PENDING_FAIL) goto L81;
        r101 = false;
        goto L81
    L85:
        if ((r110 instanceof d.g) == false) goto L94;
        d.g r121 = (d.g) r110;
        if (r111.f243887e == true) goto L90;
        return new e(0);
    L90:
        if (r111.f243893k == true) goto L186;
        r108 = new e(CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a.c0(r121.f243908a)));
        goto L177
    L186:
        return b(r121.f243908a);
    L94:
        if ((r110 instanceof d.j) == false) goto L97;
        return b(((d.j) r110).f243911a);
    L97:
        if ((r110 instanceof d.c) == false) goto L106;
        d.c r122 = (d.c) r110;
        if (Intrinsics.areEqual(r122.f243904a.f21353a, this.f243934a) == true) goto L102;
        return new e(0);
    L102:
        if (r111.f243888f == false) goto L189;
        r108 = new e(CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a.e0(r122.f243904a)));
        goto L177
    L189:
        return new e(0);
    L106:
        if ((r110 instanceof d.b) == false) goto L115;
        d.b r123 = (d.b) r110;
        if (Intrinsics.areEqual(r123.f243903a.f21351a, this.f243934a) == true) goto L111;
        return new e(0);
    L111:
        if (r111.f243889g == false) goto L191;
        r108 = new e(CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a[]{com.bytedance.flow_audio.impl.business.asr.core.a.k.f243848a, new com.bytedance.flow_audio.impl.business.asr.core.a.u0(r123.f243903a)}));
        goto L177
    L191:
        return new e(0);
    L115:
        if ((r110 instanceof d.a) == false) goto L124;
        if (Intrinsics.areEqual(((d.a) r110).f243902a.f21351a, this.f243934a) == true) goto L120;
        return new e(0);
    L120:
        if (r111.f243889g == true) goto L194;
        return new e(0);
    L194:
        return new e(CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a[]{com.bytedance.flow_audio.impl.business.asr.core.a.b.f243831a, com.bytedance.flow_audio.impl.business.asr.core.a.h0.f243843a, com.bytedance.flow_audio.impl.business.asr.core.a.C3490a.f243828a}));
    L124:
        if ((r110 instanceof d.e) == false) goto L130;
        d.e r124 = (d.e) r110;
        if (r111.f243894l == false) goto L196;
        return new e(0);
    L196:
        return b(r124.f243906a);
    L130:
        if (Intrinsics.areEqual(r110, d.C3492d.f243905a) == false) goto L139;
        if (r111.f243894l == true) goto L197;
        ArrayList r125 = new ArrayList();
        FlowAsrSessionState r126 = r111.f243883a;
        FlowAsrSessionState r127 = FlowAsrSessionState.CANCELING;
        if (r126 == r127) goto L137;
        r125.add(new com.bytedance.flow_audio.impl.business.asr.core.a.j0(r127));
    L137:
        CollectionsKt.addAll(r125, CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a[]{com.bytedance.flow_audio.impl.business.asr.core.a.e.f243837a, com.bytedance.flow_audio.impl.business.asr.core.a.b.f243831a, com.bytedance.flow_audio.impl.business.asr.core.a.i.f243844a, com.bytedance.flow_audio.impl.business.asr.core.a.y0.f243874a, com.bytedance.flow_audio.impl.business.asr.core.a.g.f243840a, new com.bytedance.flow_audio.impl.business.asr.core.a.h(true), new com.bytedance.flow_audio.impl.business.asr.core.a.j0(FlowAsrSessionState.CANCELED), new com.bytedance.flow_audio.impl.business.asr.core.a.m(FlowAsrCancelReason.SERVER), new com.bytedance.flow_audio.impl.business.asr.core.a.g0("server cancel completed: taskId=" + this.f243934a)}));
        r108 = new e(r125);
        goto L177
    L197:
        return new e(0);
    L139:
        if (Intrinsics.areEqual(r110, d.k.f243912a) == false) goto L145;
        if (r111.f243890h == false) goto L198;
        long r128 = this.f243935b.invoke().longValue();
        return b(new hw5.a(FlowAsrErrorType.TIMEOUT, "ASR completion timeout after " + r128 + " ms", 505, "timeoutMs=" + r128 + ",state=" + r111.f243883a));
    L198:
        return new e(0);
    L145:
        if ((r110 instanceof d.l) == false) goto L148;
        return b(((d.l) r110).f243913a);
    L148:
        if ((r110 instanceof d.r) == false) goto L154;
        d.r r129 = (d.r) r110;
        com.bytedance.flow_audio.impl.business.asr.n r130 = r129.f243921b;
        if (r130 != null) goto L201;
        r108 = new e(CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a.c0(r129.f243920a)));
        goto L177
    L201:
        return new e(CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a[]{new com.bytedance.flow_audio.impl.business.asr.core.a.j0(FlowAsrSessionState.RETRYING), new com.bytedance.flow_audio.impl.business.asr.core.a.m0(r129.f243920a, r130), com.bytedance.flow_audio.impl.business.asr.core.a.b.f243831a, com.bytedance.flow_audio.impl.business.asr.core.a.i.f243844a, com.bytedance.flow_audio.impl.business.asr.core.a.p0.f243858a, new com.bytedance.flow_audio.impl.business.asr.core.a.t0(r129.f243920a, r130)}));
    L154:
        if ((r110 instanceof d.q) == false) goto L160;
        hw5.a r131 = ((d.q) r110).f243919b;
        if (r131 != null) goto L203;
        return new e(CollectionsKt.listOf(com.bytedance.flow_audio.impl.business.asr.core.a.k0.f243849a));
    L203:
        return b(r131);
    L160:
        if ((r110 instanceof d.m) == false) goto L163;
        r108 = new e(CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a.c0(((d.m) r110).f243914a)));
        goto L177
    L163:
        if ((r110 instanceof d.o) == false) goto L166;
        r108 = new e(CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a.a1(((d.o) r110).f243916a)));
        goto L177
    L166:
        if ((r110 instanceof d.n) == false) goto L169;
        d.n r132 = (d.n) r110;
        r108 = new e(CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a[]{new com.bytedance.flow_audio.impl.business.asr.core.a.j0(FlowAsrSessionState.FINISHED), new com.bytedance.flow_audio.impl.business.asr.core.a.q(r132.f243915a), com.bytedance.flow_audio.impl.business.asr.core.a.d.f243835a, new com.bytedance.flow_audio.impl.business.asr.core.a.g0("finish: len=" + r132.f243915a.f496224a.length() + " taskId=" + this.f243934a)}));
        goto L177
    L169:
        if ((r110 instanceof d.p) == false) goto L173;
        r108 = new e(CollectionsKt.listOf(new com.bytedance.flow_audio.impl.business.asr.core.a.c0(((d.p) r110).f243917a)));
        goto L177
    L173:
        throw new NoWhenBranchMatchedException();
    }
}
