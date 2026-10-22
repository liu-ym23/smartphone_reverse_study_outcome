package com.larus.bmhome.chat.layout.holder.helper;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b1 {
    public static final void a(a1 r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "view");
        w0 r102 = new w0(r100);
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        r101.setOnLongClickListener(r102);
    }
}
