package we8;

import android.widget.TextView;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
public final class a {
    public static final float a(int r100, boolean r101) {
        float r102 = r100;
        if (r101 == true) goto L7;
        Lazy r103 = e.f559400a;
        return r102 + c7.c(Integer.valueOf(e.b(e.f559403d)));
    L7:
        return r102;
    }

    public static void b(TextView r100, float r101, boolean r102, Float r103, Float r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r103 = null;
    L6:
        if ((r105 & 8) == 0) goto L8;
        r104 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r102 == true) goto L12;
        Lazy r106 = e.f559400a;
        r101 = r101 + c7.c(Integer.valueOf(e.b(e.f559403d)));
    L12:
        if (r103 == null) goto L15;
        r101 = Math.max(r101, r103.floatValue());
    L15:
        if (r104 == null) goto L18;
        r101 = Math.min(r101, r104.floatValue());
    L18:
        r100.setTextSize(0, r101);
    }
}
