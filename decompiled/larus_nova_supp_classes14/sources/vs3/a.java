package vs3;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static void a(View r7, Activity r8) {
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.getContext() != null) goto L7;
        return;
    L7:
        int r1 = 0;
        if (r7.getContext() != r8) goto L30;
        if (r7.getBackground() == null) goto L15;
        r7.getBackground().setCallback(null);     // Catch: Throwable -> L13
        r7.setBackgroundDrawable(null);     // Catch: Throwable -> L13
    L15:
        if ((r7 instanceof ImageView) == false) goto L21;
        ImageView r0 = (ImageView) r7;
        Drawable r3 = r0.getDrawable();
        if (r3 == null) goto L19;
        r3.setCallback(null);
    L19:
        r0.setImageDrawable(null);
    L21:
        if ((r7 instanceof TextView) == false) goto L30;
        TextView r2 = (TextView) r7;
        Drawable[] r4 = r2.getCompoundDrawables();
        int r5 = r4.length;
        int r6 = 0;
    L23:
        if (r6 >= r5) goto L28;
        Drawable r9 = r4[r6];
        if (r9 == null) goto L27;
        r9.setCallback(null);
    L27:
        r6 = r6 + 1;
        goto L23
    L28:
        r2.setCompoundDrawables(null, null, null, null);
    L30:
        if ((r7 instanceof ViewGroup) == false) goto L34;
        ViewGroup r10 = (ViewGroup) r7;
        int r11 = r10.getChildCount();
    L32:
        if (r1 >= r11) goto L41;
        a(r10.getChildAt(r1), r8);
        r1 = r1 + 1;
        goto L32
    L41:
        return;
    }
}
