package s28;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes24.dex */
public final class a {
    public a() {
    }

    public static void a(Rect r100, View r101) {
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        r100.set(r103.leftMargin, r103.topMargin, r103.rightMargin, r103.bottomMargin);
        return;
    L5:
        r100.set(0, 0, 0, 0);
    }
}
