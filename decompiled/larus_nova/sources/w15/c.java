package w15;

import android.content.Context;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes16.dex */
public final class c {
    public static final Drawable a(Drawable r100, Context r101) {
        Drawable.ConstantState r102 = r100.getConstantState();
        if (r102 == null) goto L11;
        Drawable r103 = r102.newDrawable(r101.getResources());
        if (r103 == null) goto L12;
        Drawable r104 = r103.mutate();
        if (r104 != null) goto L10;
        return r100;
    L10:
        return r104;
    L12:
        return r100;
    L11:
        return r100;
    }
}
