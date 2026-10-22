package com.bytedance.android.shopping.deepfeed.utlis;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import he3.d1;
import he3.h2;
import he3.l;
import he3.m2;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import yj.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h {
    public static final Map<String, Long> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static boolean b(h2 r5) {
        if (r5 == null) goto L39;
        List<d1> r6 = r5.a();
        if (r6 == null) goto L40;
        List<d1> r7 = r6;
        if ((r7 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r8 = r7.iterator();
    L13:
        if (r8.hasNext() == false) goto L32;
        Map<String, Object> r1 = ((d1) r8.next()).b();
        Object r3 = null;
        if (r1 == null) goto L17;
        Object r2 = r1.get("deep_feed_surprise_coupon_animation_url");
    L19:
        if ((r2 instanceof String) == false) goto L22;
        r3 = r2;
    L22:
        String r4 = (String) r3;
        if (r4 != null) goto L25;
    L28:
        boolean r9 = true;
    L30:
        if ((!r9) == false) goto L13;
        boolean r10 = true;
    L33:
        if (r10 != true) goto L41;
        return true;
    L41:
        return false;
    L25:
        if (r4.length() == 0) goto L28;
        r9 = false;
        goto L30
    L17:
        r2 = null;
    L32:
        r10 = false;
        goto L33
    L9:
        if (r7.isEmpty() == false) goto L11;
    L40:
        return false;
    L39:
        return false;
    }

    public static boolean c(h2 r11) {
        if (com.bytedance.android.shopping.deepfeed.ui.ability.b.a.a() == false) goto L6;
        return true;
    L6:
        if (b(r11) == true) goto L8;
        return false;
    L8:
        IHybridHostService r12 = com.bytedance.android.ec.hybrid.a.h();
        if (r12 == null) goto L31;
        s r13 = r12.getIHybridHostUserService();
        if (r13 == null) goto L31;
        String r14 = r13.getCurrentUserId();
        if (r14 == null) goto L31;
        Long r2 = (Long) ((LinkedHashMap) a).get(r14);
        if (r2 != null) goto L18;
        int r3 = ed3.b.a;
        Intrinsics.checkNotNullParameter("mall_deep_feed_popup.".concat(r14), "key");
        r2 = 0L;
    L18:
        long r5 = r2.longValue();
        if (r5 > 0) goto L21;
        return true;
    L21:
        int r15 = tc3.f.a;
        Integer r16 = tc3.a.a().c();
        if (r16 == null) goto L24;
        int r17 = r16.intValue();
    L25:
        long r6 = r5 + (((long) RangesKt.coerceAtLeast(r17, 0)) * 86400000);
        TimeZone r18 = TimeZone.getTimeZone("GMT+8");
        Intrinsics.checkNotNullParameter(r18, "targetTimeZone");
        Calendar r4 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        long r7 = r4.getTimeInMillis();
        r4.setTimeZone(r18);
        r4.setTimeInMillis(r7);
        r4.set(11, 0);
        r4.set(12, 0);
        r4.set(13, 0);
        r4.set(14, 0);
        long r8 = r4.getTimeInMillis();
        if (r8 <= (r7 + ((long) r18.getRawOffset()))) goto L29;
        r4.add(5, -1);
        r8 = r4.getTimeInMillis();
    L29:
        if (r8 <= r6) goto L31;
        return true;
    L24:
        r17 = 0;
    L31:
        return false;
    }

    public static m2 a(l r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "fallbackTitle");
        if (r1 == null) goto L13;
        Map<Long, he3.j> r0 = r1.b();
        if (r0 == null) goto L13;
        Collection<he3.j> r3 = r0.values();
        if (r3 == null) goto L13;
        he3.j r4 = (he3.j) CollectionsKt.firstOrNull(r3);
        if (r4 == null) goto L13;
        m2 r5 = r4.d();
        if (r5 == null) goto L13;
    L19:
        return r5;
    L13:
        if (r1 == null) goto L18;
        String r6 = r1.c();
        if (r6 == null) goto L18;
        r2 = r6;
    L18:
        r5 = new m2(r2, 2);
        goto L19
    }
}
