package bu9;

import android.os.Build;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public b() {
    }

    public static oq9.b a() {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        return oq9.b.b;
    L6:
        return oq9.b.a;
    }
}
