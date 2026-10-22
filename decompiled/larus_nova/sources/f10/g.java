package f10;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes45.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f475049a = 0;

    static {
    }

    public static boolean a(View r100, int r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getVisibility() == 0) goto L7;
        return false;
    L7:
        if (r100.isShown() == true) goto L9;
        return false;
    L9:
        if (r100.getGlobalVisibleRect(new Rect()) == false) goto L36;
        Rect r102 = new Rect();
        boolean r103 = r100.getGlobalVisibleRect(r102);
        if (r101 == 1) goto L14;
    L16:
        boolean r104 = false;
    L17:
        if (r101 == 0) goto L19;
    L21:
        boolean r105 = false;
    L22:
        if (r104 == true) goto L26;
        if (r105 == true) goto L26;
        boolean r106 = false;
    L27:
        if (r103 == false) goto L34;
        if (r106 == false) goto L35;
        return true;
    L35:
        return false;
    L34:
        return false;
    L26:
        r106 = true;
        goto L27
    L19:
        if (r102.width() <= (r100.getMeasuredWidth() / 2)) goto L21;
        r105 = true;
        goto L22
    L14:
        if (r102.height() <= (r100.getMeasuredHeight() / 2)) goto L16;
        r104 = true;
        goto L17
    L36:
        return false;
    }
}
