package wr0;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes46.dex */
public final class d {
    public static View a(View r100, MotionEvent r101) {
        if (r100 == null) goto L22;
        if (r101 == null) goto L22;
        int r102 = 0;
        boolean r103 = false;
        if ((r100 instanceof ViewGroup) == false) goto L9;
        ViewGroup r104 = (ViewGroup) r100;
        int r105 = r104.getChildCount();
    L17:
        if (r102 >= r105) goto L22;
        View r106 = a(r104.getChildAt(r102), r101);
        if (r106 != null) goto L20;
        r102 = r102 + 1;
        goto L17
    L20:
        return r106;
    L9:
        if (r100.getVisibility() != 0) goto L12;
        float r107 = r101.getRawX();
        float r108 = r101.getRawY();
        RectF r109 = new RectF();
        int[] r110 = new int[2];
        r100.getLocationOnScreen(r110);
        float r111 = r110[0];
        float r112 = r110[1];
        r109.left = r111;
        r109.right = r111 + r100.getWidth();
        r109.top = r112;
        r109.bottom = r112 + r100.getHeight();
        r103 = r109.contains(r107, r108);
    L12:
        if (r103 == false) goto L15;
        return r100;
    L15:
        return null;
    L22:
        return null;
    }
}
