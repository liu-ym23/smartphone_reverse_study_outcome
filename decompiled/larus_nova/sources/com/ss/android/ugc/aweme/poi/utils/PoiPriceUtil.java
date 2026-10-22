package com.ss.android.ugc.aweme.poi.utils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/utils/PoiPriceUtil;", "", "<init>", "()V", "locallife-saas-common_release"}, k = 1, mv = {1, 4, 3})
public final class PoiPriceUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PoiPriceUtil f451367a = null;

    static {
        f451367a = new PoiPriceUtil();
    }

    private PoiPriceUtil() {
    }

    public static String a(long r100) {
        long r101 = 100;
        if ((r100 % r101) != 0) goto L6;
        return String.valueOf(r100 / r101);
    L6:
        if ((r100 % ((long) 10)) != 0) goto L8;
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(b(r100, 1))}, 1));
    L8:
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(b(r100, 2))}, 1));
    }

    public static double b(double r100, int r101) {
        if (r101 < 0) goto L4;
        boolean r102 = true;
    L5:
        if (r102 == false) goto L9;
        return new BigDecimal(String.valueOf(r100)).divide(new BigDecimal(String.valueOf(100.0d)), r101, 4).doubleValue();
    L9:
        throw new IllegalArgumentException("The scale must be a positive integer or zero".toString());
    L4:
        r102 = false;
        goto L5
    }
}
