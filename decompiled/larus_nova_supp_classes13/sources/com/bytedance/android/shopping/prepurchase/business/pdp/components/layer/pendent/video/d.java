package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.os.SystemClock;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public final /* synthetic */ a a;

    public d(a r1) {
        this.a = r1;
    }

    public final void a(boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "stopType");
        if (this.a.j.a() == false) goto L6;
        return;
    L6:
        if (this.a.d >= 0) goto L8;
        return;
    L8:
        long r0 = SystemClock.elapsedRealtime();
        a r2 = this.a;
        long r1 = r0 - r2.d;
        r2.d = -1;
        Pair[] r3 = new Pair[4];
        if (r6 == false) goto L11;
        String r8 = "1";
    L12:
        r3[0] = TuplesKt.to("is_play_over", r8);
        r3[1] = TuplesKt.to("duration", Long.valueOf(r1));
        r3[2] = TuplesKt.to("stop_type", r7);
        r3[3] = TuplesKt.to("video_source_type", Integer.valueOf(com.bytedance.android.shopping.extensions.k.f(this.a.j.c.e.h())));
        b("pd_video_play_time", MapsKt.mutableMapOf(r3));
        return;
    L11:
        r8 = "0";
        goto L12
    }

    public final void b(String r9, Map<String, ? extends Object> r10) {
        vg3.z r0 = this.a.k.m();
        if (r0 == null) goto L16;
        LinkedHashMap r1 = new LinkedHashMap();
        Map<String, Object> r2 = this.a.j.f;
        if (r2 == null) goto L7;
        r1.putAll(r2);
    L7:
        if (r10 == null) goto L9;
        r1.putAll(r10);
    L9:
        String r11 = this.a.j.c.e.j();
        if (r11 != null) goto L12;
        r11 = "";
    L12:
        r1.put("video_id", r11);
        Unit r12 = Unit.INSTANCE;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m r3 = r0.d(r1);
        if (r3 == null) goto L17;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r3, r9, false, null, null, 14);
        return;
    L17:
        return;
    }
}
