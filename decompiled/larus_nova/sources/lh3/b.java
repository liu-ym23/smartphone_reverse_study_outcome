package lh3;

import com.google.gson.Gson;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f509238a = 0;

    public static j a() {
        int r100 = pi3.a.f529323a;     // Catch: Throwable -> L15
        String r101 = ih3.c.f489801b.b();     // Catch: Throwable -> L15
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r101.length() <= 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L12;
        r101 = null;
    L12:
        if (r101 == null) goto L21;
        return (j) new Gson().fromJson(r101, j.class);
    L21:
        return null;
    L8:
        r102 = false;
    L15:
        th = move-exception;
        th.toString();
        return null;
    }

    static {
    }
}
