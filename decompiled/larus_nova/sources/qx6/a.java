package qx6;

import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final int a(float r100, int r101) {
        return (RangesKt.coerceAtMost(255, RangesKt.coerceAtLeast(0, (int) (r100 * 255))) << 24) + (r101 & 16777215);
    }
}
