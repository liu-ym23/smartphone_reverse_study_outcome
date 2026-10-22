package rv3;

import android.app.AlertDialog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes14.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<AlertDialog> f539401a;

    static {
    }

    public static AlertDialog a() {
        WeakReference<AlertDialog> r100 = f539401a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }
}
