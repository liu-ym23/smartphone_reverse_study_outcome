package r1;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes39.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f535587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f535588b;

    public p() {
        this.f535587a = null;
        this.f535588b = null;
    }

    public final String a() {
        String r100 = "0";
        if (TextUtils.isEmpty(this.f535587a) == true) goto L9;
        if ("0".equals(this.f535587a) == true) goto L9;
        return this.f535587a;
    L9:
        if (TextUtils.isEmpty(this.f535588b) == false) goto L11;
    L14:
        d r101 = com.apm.lite.e.b();
        r101.getClass();
        String r102 = r101.f535555b.getDeviceId();     // Catch: Throwable -> L17
    L18:
        this.f535587a = r102;
        if (TextUtils.isEmpty(r102) == false) goto L21;
    L25:
        o r103 = o.b();
        r103.getClass();
        r100 = com.apm.lite.k.h.b(r103.f535579b.getAbsolutePath());     // Catch: Throwable -> L29
    L27:
        this.f535588b = r100;
        return r100;
    L21:
        if ("0".equals(this.f535587a) == true) goto L25;
        return this.f535587a;
    L17:
        r102 = "";
        goto L18
    L11:
        if ("0".equals(this.f535588b) == true) goto L14;
        return this.f535588b;
    }
}
