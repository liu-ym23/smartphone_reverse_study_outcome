package kotlin.time;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\u001a\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0010"}, d2 = {"durationAssertionsEnabled", "", "getDurationAssertionsEnabled", "()Z", "precisionFormats", "", "Ljava/lang/ThreadLocal;", "Ljava/text/DecimalFormat;", "[Ljava/lang/ThreadLocal;", "createFormatForDecimals", "decimals", "", "formatToExactDecimals", "", "value", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DurationJvmKt {
    private static final boolean durationAssertionsEnabled = false;
    private static final ThreadLocal<DecimalFormat>[] precisionFormats = null;

    static {
        int r100 = 0;
        durationAssertionsEnabled = false;
        ThreadLocal<DecimalFormat>[] r101 = new ThreadLocal[4];
    L3:
        if (r100 >= 4) goto L5;
        r101[r100] = new ThreadLocal();
        r100 = r100 + 1;
        goto L3
    L5:
        precisionFormats = r101;
    }

    public static final boolean getDurationAssertionsEnabled() {
        return durationAssertionsEnabled;
    }

    private static final DecimalFormat createFormatForDecimals(int r100) {
        DecimalFormat r101 = new DecimalFormat("0");
        if (r100 <= 0) goto L5;
        r101.setMinimumFractionDigits(r100);
    L5:
        r101.setRoundingMode(RoundingMode.HALF_UP);
        return r101;
    }

    public static final String formatToExactDecimals(double r100, int r101) {
        ThreadLocal<DecimalFormat>[] r102 = precisionFormats;
        if (r101 >= r102.length) goto L9;
        ThreadLocal<DecimalFormat> r103 = r102[r101];
        DecimalFormat r104 = r103.get();
        if (r104 != null) goto L7;
        r104 = createFormatForDecimals(r101);
        r103.set(r104);
    L8:
        DecimalFormat r105 = r104;
    L11:
        return r105.format(r100);
    L7:
        Intrinsics.checkNotNull(r104);
        goto L8
    L9:
        r105 = createFormatForDecimals(r101);
        goto L11
    }
}
