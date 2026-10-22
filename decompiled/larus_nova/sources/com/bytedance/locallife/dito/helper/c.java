package com.bytedance.locallife.dito.helper;

import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    public static final ViewParent a(View r100, RecyclerView r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Intrinsics.areEqual(r100.getParent(), r101) == true) goto L14;
        if (r101 == null) goto L14;
        Object r102 = r100.getParent();
        if ((r102 instanceof View) == false) goto L9;
        View r103 = (View) r102;
    L10:
        if (r103 != null) goto L12;
        return null;
    L12:
        return a(r103, r101);
    L9:
        r103 = null;
    L14:
        if ((r100 instanceof ViewParent) == true) goto L16;
        return null;
    L16:
        return (ViewParent) r100;
    }

    public static final int b(View r100, ViewParent r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Intrinsics.areEqual(r100.getParent(), r101) == true) goto L16;
        if (r101 == null) goto L16;
        int r102 = r100.getTop();
        Object r103 = r100.getParent();
        if ((r103 instanceof View) == false) goto L9;
        View r104 = (View) r103;
    L10:
        if (r104 == null) goto L12;
        int r105 = b(r104, r101);
    L14:
        return r102 + r105;
    L12:
        r105 = 0;
        goto L14
    L9:
        r104 = null;
    L16:
        return r100.getTop();
    }
}
