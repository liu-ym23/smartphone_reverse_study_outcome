package com.bytedance.android.shopping.store.lifecycle;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    public static final /* synthetic */ int e = 0;
    public final HashMap<Integer, Long> a;
    public boolean b;
    public String c;
    public int d;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        if (a(this.a, 100) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public g() {
        this.a = new HashMap();
        this.c = "none";
        this.d = -1;
    }

    public static long a(HashMap r0, int r1) {
        Long r2 = (Long) r0.get(Integer.valueOf(r1));
        if (r2 != null) goto L7;
        return -1;
    L7:
        return r2.longValue();
    }

    public final void c(int r6, Long r7) {
        if (a(this.a, r6) != (-1)) goto L10;
        HashMap<Integer, Long> r0 = this.a;
        Integer r8 = Integer.valueOf(r6);
        if (r7 == null) goto L7;
        long r1 = r7.longValue();
    L8:
        r0.put(r8, Long.valueOf(r1));
        return;
    L7:
        r1 = System.currentTimeMillis();
        goto L8
    }
}
