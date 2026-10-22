package n4a;

import android.content.Context;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static d f517217c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f517218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f517219b;

    public static d a(Context r100) {
        if (f517217c != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f517217c != null) goto L9;
        f517217c = new d(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f517217c;
    }

    public d(Context r100) {
        this.f517218a = r100.getApplicationContext();
        String r101 = f5.o("RYW1hcF9kZXZpY2VfYWRpdQ");
        byte[] r102 = k.f517415a;
        this.f517219b = b5.a(r101);
    }
}
