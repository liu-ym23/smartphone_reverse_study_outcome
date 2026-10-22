package eua;

import com.bytedance.frameworks.baselib.network.http.util.d;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements cua.b, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f474112b;

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        int r100 = b.f474113a;
        if ((this instanceof cua.a) == false) goto L5;
        d r101 = ((cua.a) this).getBuffer();
    L15:
        return r101.toString();
    L5:
        r101 = new d(64);
        String r102 = this.f474111a;
        String r103 = this.f474112b;
        int r104 = r102.length() + 2;
        if (r103 == null) goto L8;
        r104 = r104 + r103.length();
    L8:
        char[] r105 = r101.f244781a;
        int r106 = r105.length;
        int r107 = r101.f244782b;
        if (r104 <= (r106 - r107)) goto L11;
        int r108 = r107 + r104;
        char[] r109 = new char[Math.max(r105.length << 1, r108)];
        System.arraycopy(r101.f244781a, 0, r109, 0, r101.f244782b);
        r101.f244781a = r109;
    L11:
        r101.a(r102);
        r101.a(": ");
        if (r103 == null) goto L15;
        r101.a(r103);
        goto L15
    }

    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // cua.b
    public final String getName() {
        return this.f474111a;
    }

    @Override // cua.b
    public final String getValue() {
        return this.f474112b;
    }

    public a(String r100, String r101) {
        if (r100 == null) goto L7;
        this.f474111a = r100;
        this.f474112b = r101;
        return;
    L7:
        throw new IllegalArgumentException("Name may not be null");
    }
}
