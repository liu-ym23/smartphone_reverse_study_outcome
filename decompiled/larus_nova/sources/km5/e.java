package km5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f504085a = 0;

    static {
    }

    public static Bitmap a(Context r100, int r101) {
        Drawable r102 = ContextCompat.getDrawable(r100, r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        if ((r102 instanceof VectorDrawable) == false) goto L8;
    L11:
        Bitmap r103 = Bitmap.createBitmap(r102.getIntrinsicWidth(), r102.getMinimumHeight(), Bitmap.Config.ARGB_8888);
        Canvas r104 = new Canvas(r103);
        r102.setBounds(0, 0, r104.getWidth(), r104.getHeight());
        r102.draw(r104);
        return r103;
    L8:
        if ((r102 instanceof VectorDrawableCompat) == true) goto L11;
        return null;
    }

    public static boolean b(String r100, String... r101) {
        if (r100 == null) goto L10;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L10;
        if (StringsKt.equals(r100, r101[r103], true) == true) goto L8;
        r103 = r103 + 1;
        goto L5
    L8:
        return true;
    L10:
        return false;
    }
}
