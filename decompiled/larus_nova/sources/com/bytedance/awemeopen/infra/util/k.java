package com.bytedance.awemeopen.infra.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f198968a = 0;

    static {
    }

    public k() {
    }

    public static String b(long r100) {
        Intrinsics.checkNotNullParameter("万", "k10");
        Intrinsics.checkNotNullParameter("亿", "million100");
        if (r100 >= 0) goto L6;
        return "0";
    L6:
        if (r100 >= 10000) goto L9;
        return String.valueOf(r100);
    L9:
        if (r100 >= 100000000) goto L15;
        String r101 = "1.0亿";
        String r102 = a(r100, 10000, "");
        if (Intrinsics.areEqual(r102, "10000.0") == false) goto L19;
        return r101;
    L19:
        return r102 + "万";
    L15:
        return a(r100, 100000000, "亿");
    }

    public static String a(long r100, long r101, String r102) {
        return new BigDecimal(r100).divide(new BigDecimal(r101), 1, RoundingMode.HALF_UP).toString() + r102;
    }
}
