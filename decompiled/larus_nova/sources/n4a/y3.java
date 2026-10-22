package n4a;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class y3 extends j0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Map<String, String> f517963n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f517964o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f517965p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f517966q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public byte[] f517967r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public byte[] f517968s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f517969t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f517970u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Map<String, String> f517971v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f517972w;

    public y3(Context r100, e5 r101) {
        super(r100, r101);
        this.f517963n = null;
        this.f517964o = "";
        this.f517965p = "";
        this.f517966q = "";
        this.f517967r = null;
        this.f517968s = null;
        this.f517969t = false;
        this.f517970u = null;
        this.f517971v = null;
        this.f517972w = false;
    }

    @Override // com.loc.bo
    public final Map<String, String> a() {
        return this.f517963n;
    }

    @Override // com.loc.bo
    public final String c() {
        return this.f517965p;
    }

    @Override // n4a.a5, com.loc.bo
    public final String e() {
        return this.f517966q;
    }

    @Override // n4a.j0, com.loc.bo
    public final Map<String, String> h() {
        return this.f517971v;
    }

    @Override // com.loc.bo
    public final String j() {
        return this.f517964o;
    }

    @Override // com.loc.bo
    public final String k() {
        return "loc";
    }

    @Override // n4a.j0
    public final byte[] p() {
        return this.f517967r;
    }

    @Override // n4a.j0
    public final byte[] q() {
        return this.f517968s;
    }

    @Override // n4a.j0
    public final boolean s() {
        return this.f517969t;
    }

    @Override // n4a.j0
    public final String t() {
        return this.f517970u;
    }

    @Override // n4a.j0
    public final boolean u() {
        return this.f517972w;
    }

    public final void v(byte[] r100) {
        ByteArrayOutputStream r101 = null;
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: Throwable -> L14
        if (r100 != null) goto L29;
    L6:
        this.f517968s = r102.toByteArray();     // Catch: Throwable -> L12
        r102.close();     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L12:
        th = th;
        r101 = r102;
    L31:
        th.printStackTrace();     // Catch: Throwable -> L22
        if (r101 == null) goto L41;
        r101.close();     // Catch: IOException -> L19
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L41:
        return;
    L22:
        th = move-exception;
        if (r101 != null) goto L39;
    L28:
        throw th;
    L39:
        r101.close();     // Catch: IOException -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L29:
        r102.write(f5.i(r100.length));     // Catch: Throwable -> L12
        r102.write(r100);     // Catch: Throwable -> L12
    L14:
        th = th;
        goto L31
    }
}
