package n4a;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes32.dex */
public final class d1 extends h1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f517221b;

    public d1(String r100, e1 r101) {
        super(r101);
        this.f517221b = r100;
    }

    @Override // n4a.h1
    public final boolean c() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.f517221b);     // Catch: Throwable -> L8
        if (r100.exists() == false) goto L10;
        int r101 = r100.list().length;     // Catch: Throwable -> L8
    L12:
        if (r101 >= 30) goto L14;
        return false;
    L14:
        return true;
    L10:
        r101 = 0;
    L8:
        th = move-exception;
        r.f(th, "fus", "gfn");
        goto L10
    }
}
