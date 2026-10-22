package ftc;

import android.text.Spanned;

/* JADX INFO: loaded from: classes41.dex */
public abstract class c {
    public static boolean a(int r100, CharSequence r101, Object r102) {
        if ((r101 instanceof Spanned) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Spanned) r101).getSpanStart(r102) != r100) goto L7;
        return true;
    }
}
