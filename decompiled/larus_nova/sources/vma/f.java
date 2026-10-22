package vma;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f {
    static {
    }

    @JvmStatic
    public static final void a(TextView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Typeface r102 = r100.getTypeface();
        if (r102 != null) goto L5;
        r102 = Typeface.DEFAULT;
    L5:
        int r103 = 0;
        if (r102 != null) goto L9;
    L7:
        boolean r104 = false;
    L12:
        if (Build.VERSION.SDK_INT < 28) goto L15;
        Typeface r105 = Typeface.create(r102, r101, r104);
    L23:
        r100.setTypeface(r105);
        return;
    L15:
        if (r101 < 600) goto L18;
        if (r104 == false) goto L18;
        r103 = 3;
    L22:
        r105 = Typeface.create(r102, r103);
    L18:
        if (r101 < 600) goto L20;
        r103 = 1;
        goto L22
    L20:
        if (r104 == false) goto L22;
        r103 = 2;
        goto L22
    L9:
        if (r102.isItalic() != true) goto L7;
        r104 = true;
        goto L12
    }
}
