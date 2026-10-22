package com.bytedance.crash.util;

import java.util.Arrays;

/* JADX INFO: loaded from: classes15.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long[] f203417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f203418b;

    public q(String r100) {
        this.f203418b = r100;
    }

    public final String a(long r110) {
        Long[] r100 = this.f203417a;
        if (r100 != null) goto L6;
        return "";
    L6:
        int r101 = r100.length;
        int r102 = 0;
        long r103 = Long.MIN_VALUE;
    L8:
        if (r102 >= r101) goto L13;
        Long r104 = r100[r102];
        if (r110 < r104.longValue()) goto L12;
        r103 = r104.longValue();
        r102 = r102 + 1;
        goto L8
    L12:
        long r111 = r104.longValue() - 1;
    L14:
        String r105 = "[";
        if (r103 == Long.MIN_VALUE) goto L17;
        r105 = "[" + r103 + this.f203418b;
    L17:
        String r106 = r105 + " - ";
        if (r111 == Long.MAX_VALUE) goto L21;
        r106 = r106 + r111 + this.f203418b;
    L21:
        return r106 + "]";
    L13:
        r111 = Long.MAX_VALUE;
        goto L14
    }

    public final void c(Long[] r100) {
        Arrays.sort(r100);
        this.f203417a = r100;
    }

    public final void b(long r100, long r110) {
        int r101 = ((int) ((r100 - 0) / r110)) + 1;
        Long[] r102 = new Long[r101];
        int r103 = 0;
    L3:
        int r104 = r101 - 1;
        if (r103 >= r104) goto L6;
        r102[r103] = Long.valueOf((((long) r103) * r110) + 0);
        r103 = r103 + 1;
        goto L3
    L6:
        r102[r104] = Long.valueOf(r100);
        c(r102);
    }
}
