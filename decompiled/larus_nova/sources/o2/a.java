package o2;

import android.app.Application;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Application f521756a;

    static {
    }

    public static Application a() {
        Application r100 = f521756a;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("applet sdk is NOT initialized");
    }
}
