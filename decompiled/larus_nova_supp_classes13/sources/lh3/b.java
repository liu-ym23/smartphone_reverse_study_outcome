package lh3;

import com.google.gson.Gson;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static j a() {
        int r1 = pi3.a.a;     // Catch: Throwable -> L15
        String r2 = ih3.c.b.b();     // Catch: Throwable -> L15
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.length() <= 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L21;
        return (j) new Gson().fromJson(r2, j.class);
    L21:
        return null;
    L8:
        r3 = false;
    L15:
        th = move-exception;
        th.toString();
        return null;
    }

    static {
    }
}
