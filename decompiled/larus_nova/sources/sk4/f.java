package sk4;

import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class f {
    public static final String a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        byte[] r101 = r100.f542397b;
        if (r101 != null) goto L6;
        return null;
    L6:
        int r102 = ArraysKt.indexOf(r101, (byte) 0);
        if (r102 >= 0) goto L11;
        r102 = r101.length;
    L11:
        return StringsKt.decodeToString(Arrays.copyOf(r101, Math.min(r102, r101.length)));
    }
}
