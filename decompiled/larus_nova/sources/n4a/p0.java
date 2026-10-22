package n4a;

import android.content.Context;

/* JADX INFO: loaded from: classes32.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f517580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e5 f517581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f517582c;

    public p0(Context r100, e5 r101, String r102) {
        this.f517580a = r100.getApplicationContext();
        this.f517581b = r101;
        this.f517582c = r102;
    }

    public final byte[] a() {
        Context r100 = this.f517580a;
        e5 r101 = this.f517581b;
        String r102 = this.f517582c;
        StringBuilder r103 = new StringBuilder();
        r103.append("\"sdkversion\":\"");     // Catch: Throwable -> L10
        r103.append(r101.b());     // Catch: Throwable -> L10
        r103.append("\",\"product\":\"");     // Catch: Throwable -> L10
        r103.append(r101.a());     // Catch: Throwable -> L10
        r103.append("\",\"nt\":\"");     // Catch: Throwable -> L10
        int r104 = x4.d(r100);     // Catch: Throwable -> L6
    L8:
        r103.append(r104);     // Catch: Throwable -> L10
        r103.append("\",\"details\":");     // Catch: Throwable -> L10
        r103.append(r102);     // Catch: Throwable -> L10
    L13:
        return f5.j(r103.toString());
    L6:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L10
        r104 = -1;
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }
}
