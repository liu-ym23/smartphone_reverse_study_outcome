package nz5;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes19.dex */
public final class j {
    public static boolean a(View r110, Rect r111) {
        LinkedList r100 = new LinkedList();
        r100.add(r110);
    L3:
        int r101 = 0;
        if (r100.isEmpty() == true) goto L39;
        View r112 = (View) r100.removeFirst();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L17
        int[] r103 = new int[2];     // Catch: Throwable -> L17
        r112.getLocationOnScreen(r103);     // Catch: Throwable -> L17
        int r104 = r103[0];     // Catch: Throwable -> L17
        int r105 = r103[1];     // Catch: Throwable -> L17
        int r106 = r112.getWidth() + r104;     // Catch: Throwable -> L17
        int r107 = r112.getHeight() + r105;     // Catch: Throwable -> L17
        if (r104 <= r111.left) goto L9;
    L15:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        hz5.k.b("Helios-Log-Detection-Task", "---------not Cover: topView=" + r112);
        boolean r108 = false;
    L20:
        if (r108 == false) goto L3;
        if (r112.getAlpha() != 0.0f) goto L24;
    L29:
        boolean r109 = true;
    L30:
        hz5.k.b("Helios-Log-Detection-Task", "---------isTransparent=" + r109);
        if (r109 == false) goto L32;
        if ((r112 instanceof ViewGroup) == false) goto L3;
        ViewGroup r113 = (ViewGroup) r112;
        int r114 = r113.getChildCount();
    L37:
        if (r101 >= r114) goto L3;
        View r115 = r113.getChildAt(r101);
        hz5.k.b("Helios-Log-Detection-Task", "---------addView=" + r115);
        r100.add(r115);
        r101 = r101 + 1;
        goto L37
    L32:
        hz5.k.b("Helios-Log-Detection-Task", "------------------------Cover detect------------------------");
        return true;
    L24:
        if (r112.getBackground() == null) goto L29;
        if (r112.getBackground().getOpacity() == (-2)) goto L29;
        r109 = false;
        goto L30
    L9:
        if (r106 < r111.right) goto L15;
        if (r105 > r111.top) goto L15;
        if (r107 < r111.bottom) goto L15;
        hz5.k.b("Helios-Log-Detection-Task", "---------isCover: topView=" + r112);     // Catch: Throwable -> L17
        r108 = true;
    L17:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L39:
        hz5.k.b("Helios-Log-Detection-Task", "------------------------NotCover------------------------");
        return false;
    }
}
