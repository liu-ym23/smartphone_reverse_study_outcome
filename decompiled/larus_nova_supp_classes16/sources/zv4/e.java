package zv4;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public static final int[] a = null;
    public static final int[] b = null;

    static {
        a = new int[]{R.attr.textSelectHandleLeft};
        b = new int[]{R.attr.textSelectHandleRight};
    }

    public static Drawable a(Context r2, int[] r3, int r4) {
        TypedArray r5 = r2.getTheme().obtainStyledAttributes(r3);
        Drawable r1 = r5.getDrawable(0);
        if (r1 != null) goto L5;
        r1 = AppCompatResources.getDrawable(r2, r5.getResourceId(0, r4));
    L5:
        r5.recycle();
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.mutate();
    }
}
