package x6a;

import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.renderscript.Matrix4f;
import android.view.View;
import android.view.ViewGroup;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.utils.m;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class d {
    public static int e(e r100) {
        View r101 = r100.getView();
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getHeight();
    }

    public static int f(e r100) {
        View r101 = r100.getView();
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getScrollX();
    }

    public static int g(e r100) {
        View r101 = r100.getView();
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getScrollY();
    }

    public static int h(e r100) {
        View r101 = r100.getView();
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getWidth();
    }

    public static void i(e r100) {
        View r101 = r100.getView();
        if (r101 == null) goto L6;
        r101.invalidate();
        return;
    }

    public static void j(e r100) {
        View r101 = r100.getView();
        if (r101 == null) goto L6;
        r101.requestLayout();
        return;
    }

    public static void b(e r100, float r101) {
        View r102 = r100.getView();
        if (r102 == null) goto L6;
        r102.setAlpha(r101);
        return;
    }

    public static void c(e r100, float[] r101) {
        View r102 = r100.getView();
        if (r102 != null) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 29) goto L9;
        r102.setAnimationMatrix(i.d(r101));
        return;
    L9:
        m r103 = new m();
        Matrix4f r104 = new Matrix4f(r101);
        com.lynx.tasm.utils.h.a r105 = new com.lynx.tasm.utils.h.a();
        r105.a();
        com.lynx.tasm.utils.h.a(m.b(r104.getArray()), r105);
        r103.l(r105);
        r102.setTranslationX(r103.h());
        r102.setTranslationY(r103.i());
        r102.setTranslationZ(r103.j());
        r102.setRotation(r103.c());
        r102.setRotationX(r103.d());
        r102.setRotationY(r103.e());
        r102.setScaleX(r103.f());
        r102.setScaleY(r103.g());
    }

    public static PointF d(e r100, PointF r101) {
        View r102 = r100.getView();
        if (r102 != null) goto L5;
        return r101;
    L5:
        int[] r103 = new int[2];
        r102.getRootView().getLocationOnScreen(r103);
        float[] r104 = {r101.x, r101.y};
        if (r102.getMatrix().isIdentity() == true) goto L8;
        r102.getMatrix().mapPoints(r104);
    L8:
        View r105 = r102.getRootView();
    L9:
        if (r102 == r105) goto L17;
        View r106 = (View) r102.getParent();
        if (r106 == null) goto L12;
        r104[0] = r104[0] + r102.getLeft();
        r104[1] = r104[1] + r102.getTop();
        r104[0] = r104[0] - r106.getScrollX();
        r104[1] = r104[1] - r106.getScrollY();
        if (r106.getMatrix().isIdentity() == true) goto L16;
        r106.getMatrix().mapPoints(r104);
    L16:
        r102 = r106;
        goto L9
    L12:
        LLog.e("LynxUIHelper", "transformFromViewToRootView failed, parent is null.");
    L17:
        r104[0] = r104[0] + r103[0];
        r104[1] = r104[1] + r103[1];
        return new PointF(r104[0], r104[1]);
    }

    public static void k(e r100, boolean r101) {
        View r102 = r100.getView();
        if ((r102 instanceof ViewGroup) == false) goto L6;
        ((ViewGroup) r102).setClipChildren(r101);
        return;
    }

    public static void l(e r100, boolean r101) {
        View r102 = r100.getView();
        if (r102 == null) goto L6;
        r102.setWillNotDraw(r101);
        return;
    }

    public static void a(e r100, boolean r101, Rect r102) {
        View r103 = r100.getView();
        if (r103 != null) goto L5;
        return;
    L5:
        if (r101 == true) goto L8;
        r102 = null;
    L8:
        r103.setClipBounds(r102);
    }
}
