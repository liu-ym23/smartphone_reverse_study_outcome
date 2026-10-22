package ms.bd.c;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f515124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f515125b;

    public final int hashCode() {
        Object r100 = this.f515124a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r102 + 31) * 31;
        Object r104 = this.f515125b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (d.class == r100.getClass()) goto L11;
        return false;
    L11:
        d r101 = (d) r100;
        Object r102 = this.f515124a;
        if (r102 != null) goto L17;
        if (r101.f515124a == null) goto L19;
        return false;
    L19:
        Object r103 = this.f515125b;
        Object r104 = r101.f515125b;
        if (r103 != null) goto L26;
        if (r104 == null) goto L27;
        return false;
    L27:
        return true;
    L26:
        return r103.equals(r104);
    L17:
        if (r102.equals(r101.f515124a) == true) goto L19;
        return false;
    }

    public d(ByteBuffer r100, Long r101) {
        this.f515124a = r100;
        this.f515125b = r101;
    }
}
