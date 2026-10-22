package com.larksuite.component.universe_design.tab;

import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c {
    public c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int a(View r100, boolean r101) {
        if (r100 != 0) goto L5;
        return 0;
    L5:
        if (r101 == false) goto L9;
        return r100.getLeft();
    L9:
        if ((r100 instanceof a) == false) goto L13;
        return ((a) r100).getContentViewLeft();
    L13:
        return r100.getLeft();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int b(View r100, boolean r101) {
        if (r100 != 0) goto L5;
        return 0;
    L5:
        if (r101 == false) goto L9;
        return r100.getRight();
    L9:
        if ((r100 instanceof a) == false) goto L13;
        return ((a) r100).getContentViewRight();
    L13:
        return r100.getRight();
    }

    public static void c(UDTabLayout r100, View r101, View r102, float r103, Drawable r104) {
        Intrinsics.checkNotNullParameter(r100, "tabLayout");
        Intrinsics.checkNotNullParameter(r104, "indicator");
        boolean r105 = r100.isIndicatorFullWidth();
        int r106 = a(r101, r105);
        int r107 = b(r101, r105);
        int r108 = a(r102, r105);
        int r109 = b(r102, r105);
        r104.setBounds((int) (r106 + ((r108 - r106) * r103)), r104.getBounds().top, (int) (r107 + ((r109 - r107) * r103)), r104.getBounds().bottom);
    }
}
