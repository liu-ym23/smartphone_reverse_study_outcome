package jg;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f498941a = 0;

    static {
    }

    public static String b(long r100) {
        long r101 = 100;
        if ((r100 % r101) != 0) goto L6;
        return String.valueOf(r100 / r101);
    L6:
        if ((r100 % ((long) 10)) != 0) goto L8;
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(a(r100, 100, 1))}, 1));
    L8:
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(a(r100, 100, 2))}, 1));
    }

    public static double a(double r100, double r101, int r102) {
        if (r102 < 0) goto L6;
        return new BigDecimal(String.valueOf(r100)).divide(new BigDecimal(String.valueOf(r101)), r102, 4).doubleValue();
    L6:
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }
}
