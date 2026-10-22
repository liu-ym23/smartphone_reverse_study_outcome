package com.larus.dora.impl.device;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class t0 {
    public static final Integer a(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        Object r102 = r100.get(r101);
    L7:
        if ((r102 instanceof Integer) == false) goto L10;
        return (Integer) r102;
    L10:
        if ((r102 instanceof String) == true) goto L12;
        return null;
    L12:
        return StringsKt.toIntOrNull((String) r102);
    L5:
        r102 = null;
        goto L7
    }
}
