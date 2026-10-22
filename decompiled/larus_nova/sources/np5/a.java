package np5;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    public static void a(ImageView r100, int r101, int r102) {
        Context r103 = r100.getContext();
        Drawable r104 = AppCompatResources.getDrawable(r103, r101);
        Drawable r105 = null;
        if (r104 == null) goto L6;
        r104.mutate();
        Drawable r106 = DrawableCompat.unwrap(r104);
        DrawableCompat.setTintList(r106, null);
        r105 = DrawableCompat.wrap(r106);
        r105.setTintList(r103.getResources().getColorStateList(r102));
    L6:
        r100.setImageDrawable(r105);
    }
}
