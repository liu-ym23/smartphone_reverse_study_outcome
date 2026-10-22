package km5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Bitmap a(Context r4, int r5) {
        Drawable r6 = ContextCompat.getDrawable(r4, r5);
        if (r6 != null) goto L6;
        return null;
    L6:
        if ((r6 instanceof VectorDrawable) == false) goto L8;
    L11:
        Bitmap r7 = Bitmap.createBitmap(r6.getIntrinsicWidth(), r6.getMinimumHeight(), Bitmap.Config.ARGB_8888);
        Canvas r0 = new Canvas(r7);
        r6.setBounds(0, 0, r0.getWidth(), r0.getHeight());
        r6.draw(r0);
        return r7;
    L8:
        if ((r6 instanceof VectorDrawableCompat) == true) goto L11;
        return null;
    }

    public static boolean b(String r5, String... r6) {
        if (r5 == null) goto L10;
        int r1 = r6.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L10;
        if (StringsKt.equals(r5, r6[r2], true) == true) goto L8;
        r2 = r2 + 1;
        goto L5
    L8:
        return true;
    L10:
        return false;
    }
}
