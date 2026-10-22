package vob;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes36.dex */
public final class d {
    public static int b(View r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) r100.getLayoutParams());
    }

    public static int c(View r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r100.getLayoutParams());
    }

    public static int e(View r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getWidth();
    }

    public static int a(View r100, boolean r101) {
        boolean r102 = false;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (ViewCompat.getLayoutDirection(r100) != 1) goto L8;
        r102 = true;
    L8:
        if (r102 == false) goto L13;
        if (r101 == false) goto L12;
        return r100.getLeft() + ViewCompat.getPaddingEnd(r100);
    L12:
        return r100.getLeft();
    L13:
        if (r101 == false) goto L16;
        return r100.getRight() - ViewCompat.getPaddingEnd(r100);
    L16:
        return r100.getRight();
    }

    public static int d(View r100, boolean r101) {
        boolean r102 = false;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (ViewCompat.getLayoutDirection(r100) != 1) goto L8;
        r102 = true;
    L8:
        if (r102 == false) goto L13;
        if (r101 == false) goto L12;
        return r100.getRight() - ViewCompat.getPaddingStart(r100);
    L12:
        return r100.getRight();
    L13:
        if (r101 == false) goto L16;
        return r100.getLeft() + ViewCompat.getPaddingStart(r100);
    L16:
        return r100.getLeft();
    }
}
