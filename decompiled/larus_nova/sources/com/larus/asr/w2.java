package com.larus.asr;

import com.bytedance.flow_audio.api.business.asr.result.FlowAsrResultType;
import com.bytedance.flow_audio.api.business.asr.session.FlowAsrCancelReason;
import com.larus.audio.IFlowAsrClientService;
import com.larus.audio.audiov3.task.asr.sami.data.AudioEvent;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class w2 implements lw5.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f288227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ qw5.a f288228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f288229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ KmpAsrSessionAdapter f288230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ KmpAsrSessionAdapter.a f288231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f288232g;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f288233a = null;

        static {
            int[] r100 = new int[FlowAsrResultType.values().length];
            r100[FlowAsrResultType.STREAM_FINAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f288233a = r100;
        }
    }

    @Override // lw5.f
    public final void A2(jw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Map<String, y5> r101 = this.f288230e.f287125c;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        y5 r103 = (y5) r102.get(this.f288227b);
        if (r103 == null) goto L8;
        com.larus.audio.report.h r104 = r103.f288266e;
        if (r104 == null) goto L9;
        r104.n(false);
        return;
    L9:
        return;
    }

    @Override // lw5.f
    public final void G0(jw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Map<String, y5> r101 = this.f288230e.f287125c;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        y5 r103 = (y5) r102.get(this.f288227b);
        if (r103 == null) goto L14;
        final n4 r104 = r103.f288269h;
        if (r104 == null) goto L15;
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        if ((r100 instanceof r4) == false) goto L9;
        final r4 r105 = (r4) r100;
    L10:
        if (r105 == null) goto L16;
        com.larus.utils.t0.e(new h4(r104, r105));
        return;
    L16:
        return;
    L9:
        r105 = null;
        goto L10
    L15:
        return;
    }

    @Override // lw5.f
    public final Map<String, String> b3(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        return MapsKt.emptyMap();
    }

    @Override // lw5.f
    public final void l1(jw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
    }

    @Override // lw5.f
    public final void n0(jw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
    }

    @Override // lw5.f
    public final void y(final jw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        final KmpAsrSessionAdapter.a r101 = this.f288231f;
        com.larus.utils.t0.e(new v2(r100, r101));
    }

    @Override // lw5.f
    public final void y1(jw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
    }

    @Override // lw5.f
    public final void z2(jw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
    }

    @Override // lw5.f
    public final void E1(jw5.a r100, iw5.c r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "result");
        FLogger.f375446a.i("KmpAsrSessionAdapter", "[voiceInputSessionDidStream][" + r100.getTaskId() + "][" + r101.f496226c + "] text: " + g2a.d.a(r101.f496224a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.asr.s2] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.asr.t2] */
    @Override // lw5.f
    public final jw5.a K(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "extra");
        IFlowAsrClientService.f288298a.getClass();
        IFlowAsrClientService r102 = IFlowAsrClientService.a.a();
        final String r103 = this.f288227b;
        qw5.a r104 = this.f288228c;
        final KmpAsrSessionAdapter.a r105 = this.f288231f;
        ?? r106 = new s2(r105, r103);
        final KmpAsrSessionAdapter r107 = this.f288230e;
        ?? r108 = new t2(r107, r103);
        if (this.f288229d == false) goto L5;
        u2 r109 = new u2(r107, r103);
    L6:
        com.larus.audio.asr.r r110 = r102.l(r103, r104, r106, r108, r109);
        if (this.f288229d == true) goto L13;
        ww5.a r111 = (ww5.a) this.f288230e.f287123a.getValue();
        if (r111 != null) goto L12;
        return null;
    L12:
        return r111.M1(this.f288228c, r110);
    L13:
        return new r4(this.f288228c, r110);
    L5:
        r109 = 0;
        goto L6
    }

    @Override // lw5.f
    public final void Q(jw5.a r100, rw5.d r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "data");
    }

    @Override // lw5.f
    public final void e1(final jw5.a r100, final FlowAsrCancelReason r110) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r110, "reason");
        final KmpAsrSessionAdapter r101 = this.f288230e;
        final String r102 = this.f288227b;
        final String r103 = this.f288232g;
        final KmpAsrSessionAdapter.a r104 = this.f288231f;
        com.larus.utils.t0.e(new q2(r101, r102, r100, r103, r110, r104));
    }

    @Override // lw5.f
    public final void j(final jw5.a r100, final iw5.c r110) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r110, "result");
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r110, "result");
        FLogger.f375446a.i("KmpAsrSessionAdapter", "[asrSessionDidReceiveStreamResult][" + r100.getTaskId() + "][" + r110.f496226c + "] text: " + g2a.d.a(r110.f496224a));
        if (a.f288233a[r110.f496226c.ordinal()] == 1) goto L5;
        return;
    L5:
        if (r110.f496224a.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        final y5 r102 = (y5) ((LinkedHashMap) this.f288230e.f287125c).get(this.f288227b);
        if (r102 == null) goto L13;
        r102.f288271j = true;
    L13:
        if (r102 == null) goto L17;
        com.larus.audio.report.h r103 = r102.f288266e;
        if (r103 == null) goto L17;
        r103.n(true);
    L17:
        final KmpAsrSessionAdapter.a r104 = this.f288231f;
        final String r105 = this.f288232g;
        com.larus.utils.t0.e(new r2(r104, r110, r102, r100, r105));
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // lw5.f
    public final void o1(final jw5.a r110, final iw5.c r111) {
        Intrinsics.checkNotNullParameter(r110, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        String r100 = null;
        if (r111 == null) goto L5;
        iw5.b r101 = r111.f496228e;
    L6:
        if (r101 == null) goto L20;
        iw5.b r102 = r111.f496228e;
        if (r102 == null) goto L20;
        String r103 = this.f288232g;
        KmpAsrSessionAdapter r104 = this.f288230e;
        String r105 = r102.f496221a;
        List<iw5.a> r106 = r102.f496222b;
        if ((!r106.isEmpty()) == true) goto L13;
        r106 = null;
    L13:
        if (r106 == null) goto L19;
        Lazy r107 = com.larus.utils.gson.b.f375403a;
        List<iw5.a> r108 = r106;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r112 = r108.iterator();
    L16:
        if (r112.hasNext() == false) goto L18;
        iw5.a r113 = (iw5.a) r112.next();
        r104.getClass();
        r109.add(new AudioEvent(r113.getType(), r113.f496218b, r113.f496219c, r113.f496220d));
        goto L16
    L18:
        r100 = com.larus.utils.gson.b.a(r109);
    L19:
        final com.larus.audio.c r114 = new com.larus.audio.c(r103, r105, r100, r102.f496223c);
    L21:
        final KmpAsrSessionAdapter r115 = this.f288230e;
        final String r116 = this.f288227b;
        final String r117 = this.f288232g;
        final KmpAsrSessionAdapter.a r118 = this.f288231f;
        com.larus.utils.t0.e(new o2(r115, r116, r110, r111, r117, r114, r118));
        return;
    L20:
        r114 = null;
        goto L21
    L5:
        r101 = null;
        goto L6
    }

    @Override // lw5.f
    public final void x2(final jw5.a r100, final hw5.a r110) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r110, "error");
        final KmpAsrSessionAdapter r101 = this.f288230e;
        final String r102 = this.f288227b;
        final String r103 = this.f288232g;
        final KmpAsrSessionAdapter.a r104 = this.f288231f;
        com.larus.utils.t0.e(new p2(r101, r102, r100, r110, r103, r104));
    }

    public w2(String r100, qw5.a r101, boolean r102, KmpAsrSessionAdapter r103, KmpAsrSessionAdapter.a r104, String r105) {
        this.f288227b = r100;
        this.f288228c = r101;
        this.f288229d = r102;
        this.f288230e = r103;
        this.f288231f = r104;
        this.f288232g = r105;
    }
}
