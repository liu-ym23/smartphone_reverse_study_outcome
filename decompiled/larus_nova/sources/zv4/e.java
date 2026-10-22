package zv4;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f573692a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f573693b = null;

    static {
        f573692a = new int[]{R.attr.textSelectHandleLeft};
        f573693b = new int[]{R.attr.textSelectHandleRight};
    }

    public static Drawable a(Context r100, int[] r101, int r102) {
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r101);
        Drawable r104 = r103.getDrawable(0);
        if (r104 != null) goto L5;
        r104 = AppCompatResources.getDrawable(r100, r103.getResourceId(0, r102));
    L5:
        r103.recycle();
        if (r104 != null) goto L9;
        return null;
    L9:
        return r104.mutate();
    }
}
