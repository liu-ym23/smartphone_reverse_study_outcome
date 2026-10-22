package w15;

import android.content.Context;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public static final Drawable a(Drawable r1, Context r2) {
        Drawable.ConstantState r0 = r1.getConstantState();
        if (r0 == null) goto L11;
        Drawable r3 = r0.newDrawable(r2.getResources());
        if (r3 == null) goto L12;
        Drawable r4 = r3.mutate();
        if (r4 != null) goto L10;
        return r1;
    L10:
        return r4;
    L12:
        return r1;
    L11:
        return r1;
    }
}
