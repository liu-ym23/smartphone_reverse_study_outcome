package com.bytedance.android.shopping.buynow.controller;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public boolean a;
    public final AndroidYaTaInstance b;
    public final View c;
    public final RecyclerView d;

    public static Float a(Object r1) {
        if ((r1 instanceof Number) == false) goto L6;
        return Float.valueOf(((Number) r1).floatValue());
    L6:
        if ((r1 instanceof String) == false) goto L9;
        return StringsKt.toFloatOrNull((String) r1);
    L9:
        return StringsKt.toFloatOrNull(r1.toString());
    }

    public b(AndroidYaTaInstance r2, View r3, RecyclerView r4) {
        Intrinsics.checkNotNullParameter(r3, "ceilingContainer");
        Intrinsics.checkNotNullParameter(r4, "bodyContainer");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
