package com.bytedance.locallife.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes21.dex */
public final class e {
    public static String a(long r100, long r101, String r102) {
        return new BigDecimal(r100).divide(new BigDecimal(r101), 1, RoundingMode.HALF_UP).toString() + r102;
    }
}
