package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.base.LLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes32.dex */
public final class o {
    public o() {
    }

    public static boolean f(View r100, View r101) {
        if (r100 == null) goto L18;
        if (r101 == null) goto L18;
        if ((r100 instanceof ViewGroup) == true) goto L10;
        return false;
    L10:
        if (r101.getParent() == null) goto L18;
        if (r101.getParent() == r100) goto L13;
        if ((r101.getParent() instanceof View) == false) goto L18;
        r101 = (View) r101.getParent();
        goto L10
    L13:
        return true;
    L18:
        return false;
    }

    public static PointF a(View r100, View r101, PointF r110) {
        if (r100 == null) goto L22;
        if (r101 == null) goto L22;
        if (r100 != r101) goto L7;
        return r110;
    L7:
        float[] r102 = {r110.x, r110.y};
        ArrayList r111 = new ArrayList();
    L8:
        if (r101 == null) goto L11;
        if (r101 == r100) goto L11;
        r111.add(r101);
        r101 = (View) r101.getParent();
    L11:
        Matrix r103 = new Matrix();
        int r104 = r111.size() - 1;
    L12:
        if (r104 < 0) goto L21;
        View r105 = (View) ListProtector.get(r111, r104);
        r102[0] = r102[0] + r100.getScrollX();
        r102[1] = r102[1] + r100.getScrollY();
        r102[0] = r102[0] - r105.getLeft();
        r102[1] = r102[1] - r105.getTop();
        if (r105.getMatrix().isIdentity() == true) goto L19;
        r103.reset();
        if (r105.getMatrix().invert(r103) == false) goto L18;
        float[] r106 = {r102[0], r102[1]};
        r103.mapPoints(r106);
        r102[0] = r106[0];
        r102[1] = r106[1];
        goto L19
    L18:
        r102[0] = Float.MAX_VALUE;
        r102[1] = Float.MAX_VALUE;
    L19:
        r104 = r104 - 1;
        r100 = r105;
        goto L12
    L21:
        return new PointF(r102[0], r102[1]);
    L22:
        LLog.e("ViewHelper", "convertPointFromAncestorToDescendant failed since ancestor or descendant is null");
        return r110;
    }

    public static PointF b(View r100, View r101, PointF r102) {
        if (r101 == null) goto L21;
        if (r100 == null) goto L21;
        if (r101 != r100) goto L8;
        return r102;
    L8:
        float[] r103 = {r102.x, r102.y};
        if (r100.getMatrix().isIdentity() == true) goto L11;
        r100.getMatrix().mapPoints(r103);
    L11:
        if (r100 == r101) goto L20;
        View r104 = (View) r100.getParent();
        if (r104 == null) goto L14;
        r103[0] = r103[0] + r100.getLeft();
        r103[1] = r103[1] + r100.getTop();
        r103[0] = r103[0] - r104.getScrollX();
        r103[1] = r103[1] - r104.getScrollY();
        if (r104.getMatrix().isIdentity() == true) goto L18;
        r104.getMatrix().mapPoints(r103);
    L18:
        r100 = r104;
        goto L11
    L14:
        LLog.e("ViewHelper", "convertPointFromDescendantToAncestor failed, parent is null.");
    L20:
        return new PointF(r103[0], r103[1]);
    L21:
        LLog.e("ViewHelper", "convertPointFromAncestorToDescendant failed since view or another is null");
        return r102;
    }

    public static PointF c(View r100, View r101, PointF r102) {
        if (r100 == null) goto L17;
        if (r101 == null) goto L17;
        if (r100 != r101) goto L8;
        return r102;
    L8:
        if (f(r100, r101) == false) goto L12;
        return a(r100, r101, r102);
    L12:
        if (f(r101, r100) == true) goto L14;
        PointF r103 = b(r100, r100.getRootView(), r102);
        return a(r101.getRootView(), r101, r103);
    L14:
        return b(r100, r101, r102);
    L17:
        LLog.e("ViewHelper", "convertPointFromAncestorToDescendant failed since view or another is null");
        return r102;
    }

    public static RectF d(View r100, View r101, RectF r102) {
        if (r100 == null) goto L7;
        if (r100 != r101) goto L5;
        return r102;
    L5:
        PointF r103 = new PointF(r102.left, r102.top);
        PointF r104 = new PointF(r102.right, r102.top);
        PointF r105 = new PointF(r102.left, r102.bottom);
        PointF r106 = new PointF(r102.right, r102.bottom);
        PointF r107 = a(r100, r101, r103);
        PointF r108 = a(r100, r101, r104);
        PointF r109 = a(r100, r101, r105);
        PointF r110 = a(r100, r101, r106);
        RectF r111 = new RectF();
        r111.left = Math.min(Math.min(r107.x, r108.x), Math.min(r109.x, r110.x));
        r111.top = Math.min(Math.min(r107.y, r108.y), Math.min(r109.y, r110.y));
        r111.right = Math.max(Math.max(r107.x, r108.x), Math.max(r109.x, r110.x));
        r111.bottom = Math.max(Math.max(r107.y, r108.y), Math.max(r109.y, r110.y));
        return r111;
    L7:
        LLog.e("ViewHelper", "convertPointFromAncestorToDescendant failed since ancestor or descendant is null");
        return r102;
    }

    public static RectF e(View r100, View r101, RectF r102) {
        if (r101 == null) goto L7;
        if (r101 != r100) goto L5;
        return r102;
    L5:
        PointF r103 = new PointF(r102.left, r102.top);
        PointF r104 = new PointF(r102.right, r102.top);
        PointF r105 = new PointF(r102.left, r102.bottom);
        PointF r106 = new PointF(r102.right, r102.bottom);
        PointF r107 = b(r100, r101, r103);
        PointF r108 = b(r100, r101, r104);
        PointF r109 = b(r100, r101, r105);
        PointF r110 = b(r100, r101, r106);
        RectF r111 = new RectF();
        r111.left = Math.min(Math.min(r107.x, r108.x), Math.min(r109.x, r110.x));
        r111.top = Math.min(Math.min(r107.y, r108.y), Math.min(r109.y, r110.y));
        r111.right = Math.max(Math.max(r107.x, r108.x), Math.max(r109.x, r110.x));
        r111.bottom = Math.max(Math.max(r107.y, r108.y), Math.max(r109.y, r110.y));
        return r111;
    L7:
        LLog.e("ViewHelper", "convertPointFromAncestorToDescendant failed since ancestor or descendant is null");
        return r102;
    }
}
