package o37;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f521912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f521913b = null;

    public a() {
    }

    static {
        f521913b = new a();
    }

    public static int a() {
        b r100 = f521912a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.a();
    }

    public final Context getContext() {
        b r100 = f521912a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getContext();
    }
}
