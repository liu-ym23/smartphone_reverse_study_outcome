package hn6;

import android.content.Context;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.locallife.biz.btm.btm_checker.interfaces.CheckReason;
import com.bytedance.locallife.biz.btm.btm_checker.interfaces.CheckType;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.ss.android.ugc.aweme.etkit.IEventTrackInterceptor;
import com.ss.android.ugc.aweme.etkit.TrackModel;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public abstract class a implements IEventTrackInterceptor {
    public a() {
    }

    public abstract CheckType b();

    public abstract List<d> c();

    public abstract List<e> d();

    @Override // com.ss.android.ugc.aweme.etkit.IEventTrackInterceptor
    public final void a(Context r100, TrackModel r110) {
        Intrinsics.checkNotNullParameter(r110, "trackModel");
        Iterator<e> r101 = d().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (r101.next().a(r110) == false) goto L4;
        return;
    L8:
        Iterator<d> r102 = c().iterator();
        Integer r103 = null;
        c r104 = null;
    L10:
        if (r102.hasNext() == false) goto L13;
        r104 = r102.next().a(new b(r110, b()));
        if (r104.f486115a == true) goto L10;
    L13:
        if (r104 == null) goto L32;
        int r105 = fn6.a.f477928a;
        Intrinsics.checkNotNullParameter(r104, "resp");
        TrackModel r106 = r104.f486117c.f486112a;
        Object r111 = r106.f450808b.b();
        int r107 = fn6.a.C5931a.f477929a[r104.f486117c.f486113b.ordinal()];
        if (r107 == 1) goto L20;
        if (r107 != 2) goto L19;
        String r108 = "poi_btm_valid_result";
    L21:
        fu6.b r109 = HostServiceUtilsKt.m0();
        Pair[] r112 = new Pair[7];
        r112[0] = TuplesKt.to("target_event", r106.f450807a);
        r112[1] = TuplesKt.to(LocationMonitorConst.CHECK_RESULT, String.valueOf(r104.f486115a));
        CheckReason r113 = r104.f486116b;
        if (r113 == null) goto L24;
        r103 = Integer.valueOf(r113.ordinal());
    L24:
        r112[2] = TuplesKt.to("check_msg", String.valueOf(r103));
        r112[3] = TuplesKt.to("target_btm", fn6.a.a(r111, "btm"));
        r112[4] = TuplesKt.to("target_btm_pre", fn6.a.a(r111, "btm_pre"));
        r112[5] = TuplesKt.to("target_btm_ppre", fn6.a.a(r111, "btm_ppre"));
        r112[6] = TuplesKt.to("target_btm_show_id", fn6.a.a(r111, "btm_show_id"));
        r109.sendEvent(r108, MapsKt.mapOf(r112));
        return;
    L19:
        throw new NoWhenBranchMatchedException();
    L20:
        r108 = "poi_btm_cover_result";
        goto L21
    }
}
