package vs3;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: classes14.dex */
public final class a {
    public static void a(View r100, Activity r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getContext() != null) goto L7;
        return;
    L7:
        int r102 = 0;
        if (r100.getContext() != r101) goto L30;
        if (r100.getBackground() == null) goto L15;
        r100.getBackground().setCallback(null);     // Catch: Throwable -> L13
        r100.setBackgroundDrawable(null);     // Catch: Throwable -> L13
    L15:
        if ((r100 instanceof ImageView) == false) goto L21;
        ImageView r103 = (ImageView) r100;
        Drawable r104 = r103.getDrawable();
        if (r104 == null) goto L19;
        r104.setCallback(null);
    L19:
        r103.setImageDrawable(null);
    L21:
        if ((r100 instanceof TextView) == false) goto L30;
        TextView r105 = (TextView) r100;
        Drawable[] r106 = r105.getCompoundDrawables();
        int r107 = r106.length;
        int r108 = 0;
    L23:
        if (r108 >= r107) goto L28;
        Drawable r109 = r106[r108];
        if (r109 == null) goto L27;
        r109.setCallback(null);
    L27:
        r108 = r108 + 1;
        goto L23
    L28:
        r105.setCompoundDrawables(null, null, null, null);
    L30:
        if ((r100 instanceof ViewGroup) == false) goto L34;
        ViewGroup r110 = (ViewGroup) r100;
        int r111 = r110.getChildCount();
    L32:
        if (r102 >= r111) goto L41;
        a(r110.getChildAt(r102), r101);
        r102 = r102 + 1;
        goto L32
    L41:
        return;
    }
}
