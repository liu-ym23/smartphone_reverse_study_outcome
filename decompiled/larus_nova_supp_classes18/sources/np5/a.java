package np5;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static void a(ImageView r2, int r3, int r4) {
        Context r0 = r2.getContext();
        Drawable r5 = AppCompatResources.getDrawable(r0, r3);
        Drawable r1 = null;
        if (r5 == null) goto L6;
        r5.mutate();
        Drawable r6 = DrawableCompat.unwrap(r5);
        DrawableCompat.setTintList(r6, null);
        r1 = DrawableCompat.wrap(r6);
        r1.setTintList(r0.getResources().getColorStateList(r4));
    L6:
        r2.setImageDrawable(r1);
    }
}
