package com.bytedance.android.shopping.mall.feed.help;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECItemCardTag;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n {
    public int a;
    public int b;
    public final Map<String, Map<String, Object>> c;
    public final Map<String, Pair<Integer, ECHybridListItemVO>> d;
    public final Map<String, Pair<Integer, ECHybridListItemVO>> e;
    public final Map<String, Pair<Integer, ECHybridListItemVO>> f;
    public final Map<String, Pair<Integer, ECHybridListItemVO>> g;
    public final Map<String, Pair<Integer, ECHybridListItemVO>> h;
    public final Map<String, Pair<Integer, ECHybridListItemVO>> i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public int p;
    public int q;
    public final List<ECHybridListItemVO> r;
    public final Map<String, Pair<Integer, ECHybridListItemVO>> s;
    public final int t;
    public boolean u;
    public final String v;

    public n(String r2) {
        Intrinsics.checkNotNullParameter(r2, "pageName");
        this.v = r2;
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
        this.h = new LinkedHashMap();
        this.i = new LinkedHashMap();
        this.j = 2;
        this.k = 3;
        this.l = 3;
        this.m = 3;
        this.n = 2;
        this.o = 2;
        this.r = new ArrayList();
        this.s = new LinkedHashMap();
        this.t = 2;
    }

    public static boolean b(ECHybridListItemVO r2) {
        ECNAMallCardExtra r3 = r2.c();
        if (r3 == null) goto L7;
        ECItemCardTag r4 = r3.getCardTag();
        if (r4 == null) goto L7;
        String[] r5 = r4.getRid();
    L9:
        if (r5 == null) goto L15;
        boolean r1 = false;
        if (r5.length != 0) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == true) goto L15;
    L17:
        return !r1;
    L13:
        r6 = false;
    L15:
        r1 = true;
    L7:
        r5 = null;
        goto L9
    }

    public static boolean c(ECHybridListItemVO r2) {
        ECNAMallCardExtra r3 = r2.c();
        if (r3 == null) goto L7;
        ECItemCardTag r4 = r3.getCardTag();
        if (r4 == null) goto L7;
        String[] r5 = r4.getPid();
    L9:
        if (r5 == null) goto L15;
        boolean r1 = false;
        if (r5.length != 0) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == true) goto L15;
    L17:
        return !r1;
    L13:
        r6 = false;
    L15:
        r1 = true;
    L7:
        r5 = null;
        goto L9
    }

    public static String[] f(ECHybridListItemVO r0) {
        ECNAMallCardExtra r1 = r0.c();
        if (r1 == null) goto L7;
        ECItemCardTag r2 = r1.getCardTag();
        if (r2 == null) goto L7;
        return r2.getRid();
    L7:
        return null;
    }

    public final void e(int r2) {
        if (r2 <= this.p) goto L5;
        this.p = r2;
    L5:
        ((LinkedHashMap) this.d).clear();
        ((LinkedHashMap) this.e).clear();
        ((LinkedHashMap) this.f).clear();
        ((LinkedHashMap) this.g).clear();
        ((LinkedHashMap) this.h).clear();
        ((LinkedHashMap) this.i).clear();
    }

    public static void d(Map r3, String r4) {
        LinkedHashMap r5 = (LinkedHashMap) r3;
        Pair r0 = (Pair) r5.get(r4);
        if (r0 == null) goto L9;
        int r1 = ((Number) r0.component1()).intValue();
        ECHybridListItemVO r2 = (ECHybridListItemVO) r0.component2();
        if (r1 != 1) goto L7;
        r5.remove(r4);
        return;
    L7:
        r5.put(r4, TuplesKt.to(Integer.valueOf(r1 - 1), r2));
        return;
    }

    public final boolean a(ECHybridListItemVO r8, Map<String, Pair<Integer, ECHybridListItemVO>> r9, String[] r10, int r11, String r12) {
        int r0 = r10.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L17;
        String r3 = r10[r2];
        if (r9.containsKey(r3) == false) goto L15;
        Pair r4 = (Pair) ((LinkedHashMap) r9).get(r3);
        if (r4 == null) goto L16;
        int r6 = ((Number) r4.component1()).intValue();
        ECHybridListItemVO r5 = (ECHybridListItemVO) r4.component2();
        int r7 = r6 + 1;
        if (r7 == r11) goto L10;
        r9.put(r3, TuplesKt.to(Integer.valueOf(r7), r5));
        goto L16
    L10:
        Map<String, Map<String, Object>> r13 = this.c;
        LinkedHashMap r14 = (LinkedHashMap) r13;
        Map r15 = (Map) r14.get(r5.Q);
        if (r15 == null) goto L13;
        ThreadPoolHelper.c().submit(new m(r15, r12));
    L13:
        return true;
    L16:
        r2 = r2 + 1;
        goto L3
    L15:
        r9.put(r3, TuplesKt.to(1, r8));
        goto L16
    L17:
        return false;
    }
}
