package bw3;

import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i0 {
    public static final String a(double r4) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        return String.format(Locale.US, "%.3f", Arrays.copyOf(new Object[]{Double.valueOf(r4)}, 1));
    }

    public static final double b(double r3) {
        if (Double.isInfinite(r3) == false) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r0 == true) goto L11;
        return 0.0d;
    L11:
        return RangesKt.coerceAtLeast(r3, 0.0d);
    L5:
        if (Double.isNaN(r3) == true) goto L7;
        r0 = true;
        goto L9
    }
}
