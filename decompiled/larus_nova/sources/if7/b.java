package if7;

import android.os.Build;

/* JADX INFO: loaded from: classes22.dex */
public final class b {
    public static jf7.b a() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 28) goto L12;
        if (r100 != 27) goto L10;
        if (Build.VERSION.PREVIEW_SDK_INT > 0) goto L12;
    L10:
        return jf7.b.a.f498905a;
    L12:
        return jf7.a.C6433a.f498904a;
    }
}
