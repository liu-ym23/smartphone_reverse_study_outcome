package i46;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static void a(Context r100, ImageView r101, int r102, int r103) {
        VectorDrawableCompat r104 = VectorDrawableCompat.create(r100.getResources(), r102, r100.getTheme());     // Catch: Exception -> L6
        Drawable r105 = r104;
        if (r104 == null) goto L10;
        r104.setTint(r100.getResources().getColor(r103));     // Catch: Exception -> L6
        r105 = r104;
    L10:
        if (r105 == null) goto L15;
        r101.setImageDrawable(r105);
        return;
    L15:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        Drawable r106 = ResourcesCompat.getDrawable(r100.getResources(), r102, r100.getTheme());
        r105 = r106;
        if (r106 == null) goto L10;
        DrawableCompat.setTint(r106, r100.getResources().getColor(r103));
        r105 = r106;
        goto L10
    }
}
