package r60;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public final class a {
    public static boolean c(View r100) {
        if (r100.getAlpha() >= 1.0f) goto L5;
        return true;
    L5:
        Drawable r101 = r100.getBackground();
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.getOpacity() != (-2)) goto L11;
        return true;
    L11:
        if (r101.getOpacity() != (-3)) goto L13;
        return true;
    L13:
        if (r101.getAlpha() < 255) goto L19;
        return false;
    L19:
        return true;
    }

    public static boolean a(View r100, Rect r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
        int[] r103 = new int[2];     // Catch: Throwable -> L14
        r100.getLocationOnScreen(r103);     // Catch: Throwable -> L14
        int r104 = r103[0];     // Catch: Throwable -> L14
        int r105 = r103[1];     // Catch: Throwable -> L14
        int r106 = r100.getWidth() + r104;     // Catch: Throwable -> L14
        int r107 = r100.getHeight() + r105;     // Catch: Throwable -> L14
        if (r104 <= r101.left) goto L6;
    L12:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        return false;
    L6:
        if (r106 < r101.right) goto L12;
        if (r105 > r101.top) goto L12;
        if (r107 < r101.bottom) goto L12;
        return true;
    L14:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public static boolean d(View r100, Rect r101) {
        if ((r100 instanceof ViewGroup) == false) goto L33;
        LinkedList r102 = new LinkedList();
        r102.add(r100);
    L6:
        if (r102.isEmpty() == true) goto L33;
        ViewGroup r103 = (ViewGroup) r102.removeFirst();
        if (r103.getChildCount() == 0) goto L9;
        int r104 = r103.getChildCount();
        int r105 = 0;
    L11:
        if (r105 >= r104) goto L17;
        View r106 = r103.getChildAt(r105);
        if ((r106 instanceof ViewGroup) == false) goto L15;
        r102.add(r106);
    L15:
        r105 = r105 + 1;
        goto L11
    L17:
        if (a(r103, r101) == false) goto L6;
        if (r103.getAlpha() >= 1.0f) goto L21;
    L30:
        boolean r107 = true;
    L31:
        if (r107 == true) goto L6;
        return true;
    L21:
        if (r103.getBackground() == null) goto L30;
        if (r103.getBackground().getOpacity() == (-2)) goto L30;
        if (r103.getBackground().getOpacity() == (-3)) goto L30;
        if (r103.getBackground().getAlpha() < 255) goto L30;
        r107 = false;
        goto L31
    L9:
        return false;
    L33:
        return false;
    }

    public static boolean b(View r100, View r101, View r102) {
        if (r100 != null) goto L28;
    L27:
        return false;
    L28:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L25
        Rect r104 = new Rect();     // Catch: Throwable -> L25
        r100.getWindowVisibleDisplayFrame(r104);     // Catch: Throwable -> L25
        if (r104.isEmpty() == false) goto L8;
        return false;
    L8:
        if (a(r101, r104) == false) goto L13;
        if (c(r101) == true) goto L13;
    L31:
        return true;
    L13:
        if (a(r101, r104) == true) goto L16;
        return false;
    L16:
        if (a(r102, r104) == false) goto L21;
        if (c(r102) == false) goto L31;
    L21:
        if (a(r102, r104) == false) goto L32;
        return d(r102, r104);
    L32:
        return false;
    L25:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    }
}
