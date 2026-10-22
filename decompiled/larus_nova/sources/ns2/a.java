package ns2;

import java.lang.ref.WeakReference;
import ls2.b;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<b> f520284a;

    public static b a() {
        WeakReference<b> r100 = f520284a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    static {
    }
}
