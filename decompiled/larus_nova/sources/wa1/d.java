package wa1;

import android.content.Context;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f558803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f558804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static x60.c.a f558805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f558806d = null;

    public d() {
    }

    static {
        f558806d = new d();
        f558805c = new x60.c.a(false, false, false, false);
    }

    public final Context getContext() {
        a r100 = f558803a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getContext();
    }
}
