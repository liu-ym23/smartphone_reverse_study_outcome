package wl;

import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final String a(long r100) {
        long r101 = 100;
        if ((r100 % r101) != 0) goto L6;
        return String.valueOf(r100 / r101);
    L6:
        if ((r100 % ((long) 10)) != 0) goto L8;
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        return String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(r100 / 100.0d)}, 1));
    L8:
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        return String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r100 / 100.0d)}, 1));
    }
}
