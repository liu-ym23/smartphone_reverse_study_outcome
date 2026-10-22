package com.loc;

import com.ss.android.downloadlib.constants.MimeType;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import n4a.a5;
import n4a.f5;
import n4a.n;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends a5 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final byte[] f379901k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f379902l;

    @Override // com.loc.bo
    public final Map<String, String> a() {
        HashMap r100 = new HashMap();
        r100.put("Content-Type", MimeType.ZIP);
        r100.put("Content-Length", String.valueOf(this.f379901k.length));
        return r100;
    }

    @Override // com.loc.bo
    public final boolean g() {
        return false;
    }

    @Override // com.loc.bo
    public final Map<String, String> h() {
        return null;
    }

    @Override // com.loc.bo
    public final byte[] i() {
        return this.f379901k;
    }

    @Override // com.loc.bo
    public final String c() {
        byte[] r100 = n4a.c.f517195a;
        String r101 = f5.o("IaHR0cDovL2xvZ3MuYW1hcC5jb20vd3MvbG9nL3VwbG9hZD9wcm9kdWN0PSVzJnR5cGU9JXMmcGxhdGZvcm09JXMmY2hhbm5lbD0lcyZzaWduPSVz");
        Object[] r102 = new Object[5];
        r102[0] = "1";
        r102[1] = this.f379902l;
        r102[2] = "1";
        r102[3] = "open";
        byte[] r103 = f5.j("9aj&#k81");
        byte[] r104 = new byte[r103.length + 50];
        System.arraycopy(this.f379901k, 0, r104, 0, 50);
        System.arraycopy(r103, 0, r104, 50, r103.length);
        String r105 = null;
        MessageDigest r106 = MessageDigest.getInstance(f5.o("ETUQ1"));     // Catch: Throwable -> L5
        r106.update(r104);     // Catch: Throwable -> L5
        byte[] r107 = r106.digest();     // Catch: Throwable -> L5
    L13:
        r105 = f5.s(r107);     // Catch: Throwable -> L9
    L11:
        r102[4] = r105;
        return String.format(r101, r102);
    L9:
        th = move-exception;
        n.a(th, "ut", "h2s");
    L5:
        th = move-exception;
        n.a(th, "MD5", "gmb");
        r107 = null;
        goto L13
    }

    public a(byte[] r100, String r101) {
        this.f379902l = "1";
        this.f379901k = (byte[]) r100.clone();
        this.f379902l = r101;
        this.f379932i = bo.a.f379938e;
        b(bo.c.f379950a);
    }
}
