package rv3;

import android.app.AlertDialog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public static WeakReference<AlertDialog> a;

    static {
    }

    public static AlertDialog a() {
        WeakReference<AlertDialog> r0 = a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }
}
