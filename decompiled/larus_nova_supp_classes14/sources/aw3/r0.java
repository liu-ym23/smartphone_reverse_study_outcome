package aw3;

import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r0 {
    public static final String a(double r4) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        return String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r4)}, 1));
    }
}
