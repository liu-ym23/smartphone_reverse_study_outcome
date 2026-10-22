package com.bytedance.locallife.common.number;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes21.dex */
public final class NumberFormatUtilKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f257130a = null;

    static {
        f257130a = LazyKt.lazy(NumberFormatUtilKt$safeDecimalFormat$2.INSTANCE);
    }

    public static final String a(float r100, int r101) {
        double r102 = new BigDecimal(String.valueOf(r100)).doubleValue();
        Lazy r103 = f257130a;
        DecimalFormat r104 = (DecimalFormat) r103.getValue();
        r104.setGroupingUsed(false);
        r104.setRoundingMode(RoundingMode.HALF_UP);
        r104.setMinimumIntegerDigits(1);
        r104.setMinimumFractionDigits(r101);
        r104.setMaximumFractionDigits(r101);
        return ((DecimalFormat) r103.getValue()).format(r102);
    }
}
