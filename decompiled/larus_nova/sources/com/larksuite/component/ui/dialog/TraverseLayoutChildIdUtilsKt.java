package com.larksuite.component.ui.dialog;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class TraverseLayoutChildIdUtilsKt {
    public static final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        int r101 = r100.getId();
        int r102 = d.f284129e.get(r101);
        if (r102 == 0) goto L6;
        r100.setId(r102);
    L6:
        if ((r100 instanceof ViewGroup) == false) goto L10;
        ViewGroup r103 = (ViewGroup) r100;
        TraverseLayoutChildIdUtilsKt$traverseViewChangeId$1 r104 = TraverseLayoutChildIdUtilsKt$traverseViewChangeId$1.INSTANCE;
        int r105 = r103.getChildCount();
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L12;
        r104.invoke(r103.getChildAt(r106));
        r106 = r106 + 1;
        goto L8
    L12:
        return;
    }
}
