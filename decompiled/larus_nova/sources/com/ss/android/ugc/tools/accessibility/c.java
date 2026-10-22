package com.ss.android.ugc.tools.accessibility;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes40.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<Matrix> f454818a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<RectF> f454819b = null;

    static {
        f454818a = new ThreadLocal();
        f454819b = new ThreadLocal();
    }

    public static void a(ViewParent r100, View r101, Matrix r102) {
        Object r103 = r101.getParent();
        if ((r103 instanceof View) == false) goto L6;
        if (r103 == r100) goto L6;
        View r104 = (View) r103;
        a(r100, r104, r102);
        r102.preTranslate(-r104.getScrollX(), -r104.getScrollY());
    L6:
        r102.preTranslate(r101.getLeft(), r101.getTop());
        if (r101.getMatrix().isIdentity() == true) goto L10;
        r102.preConcat(r101.getMatrix());
        return;
    }
}
