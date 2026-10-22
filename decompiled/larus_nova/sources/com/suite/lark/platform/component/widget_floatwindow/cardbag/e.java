package com.suite.lark.platform.component.widget_floatwindow.cardbag;

import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    @FunctionalInterface
    public interface a {
    }

    public static void a(FrameLayout r100) {
        if (r100 == null) goto L11;
        int r101 = 0;
    L6:
        if (r101 >= r100.getChildCount()) goto L15;
        View r102 = r100.getChildAt(r101);
        jpc.a r103 = (jpc.a) r102.getTag();
        if (r103 != null) goto L10;
        r103 = new jpc.a();
    L10:
        int r104 = r102.getPaddingLeft();
        int r105 = r102.getPaddingTop();
        r102.getPaddingRight();
        r102.getPaddingBottom();
        r103.f500014c = r105;
        r103.f500013b = r104;
        r101 = r101 + 1;
        goto L6
    L15:
        return;
    }
}
