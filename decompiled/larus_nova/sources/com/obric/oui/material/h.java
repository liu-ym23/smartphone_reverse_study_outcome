package com.obric.oui.material;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class h {
    public static final void c(Iterable<? extends g> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Iterator<? extends g> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().a(r101);
        goto L4
    }

    public static final void d(ViewGroup[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L15;
        ViewGroup r104 = r100[r103];
        int r105 = r104.getChildCount();
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L14;
        int r107 = r106 + 1;
        KeyEvent.Callback r108 = r104.getChildAt(r106);
        if ((r108 instanceof g) == false) goto L9;
        g r109 = (g) r108;
    L10:
        if (r109 == null) goto L13;
        r109.a(r101);
    L13:
        r106 = r107;
        goto L5
    L9:
        r109 = null;
        goto L10
    L14:
        r103 = r103 + 1;
        goto L3
    }

    public static final void e(ViewGroup[] r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L15;
        ViewGroup r104 = r100[r103];
        int r105 = r104.getChildCount();
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L14;
        int r107 = r106 + 1;
        KeyEvent.Callback r108 = r104.getChildAt(r106);
        if ((r108 instanceof g) == false) goto L9;
        g r109 = (g) r108;
    L10:
        if (r109 == null) goto L13;
        r109.setBackdropTarget(r101);
    L13:
        r106 = r107;
        goto L5
    L9:
        r109 = null;
        goto L10
    L14:
        r103 = r103 + 1;
        goto L3
    }

    public static final void a(View r100, boolean r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == false) goto L5;
        OMaterialHelper.s(r100, r102, 1);
        return;
    L5:
        OMaterialHelper.s(r100, 0, 1);
    }

    public static final void b(View r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r102 == false) goto L8;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == false) goto L7;
        OMaterialHelper.s(r100, 2, 1);
        return;
    L7:
        OMaterialHelper.s(r100, 0, 0);
        return;
    L8:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == false) goto L11;
        OMaterialHelper.s(r100, 3, 1);
        return;
    L11:
        OMaterialHelper.s(r100, 0, 0);
    }
}
