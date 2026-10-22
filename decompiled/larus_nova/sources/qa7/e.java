package qa7;

import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes19.dex */
public final class e<F, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F f532273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S f532274b;

    public final int hashCode() {
        return this.f532273a.hashCode() ^ this.f532274b.hashCode();
    }

    public final String toString() {
        return "Pair{" + String.valueOf(this.f532273a) + " " + String.valueOf(this.f532274b) + i.f25855d;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof e) == true) goto L5;
        return false;
    L5:
        e r101 = (e) r100;
        F r102 = r101.f532273a;
        F r103 = this.f532273a;
        if (r102 == r103) goto L12;
        if (r102 != null) goto L9;
    L11:
        boolean r104 = false;
    L13:
        if (r104 == false) goto L25;
        S r105 = r101.f532274b;
        S r106 = this.f532274b;
        if (r105 == r106) goto L21;
        if (r105 != null) goto L18;
    L20:
        boolean r107 = false;
    L22:
        if (r107 == false) goto L26;
        return true;
    L26:
        return false;
    L18:
        if (r105.equals(r106) == false) goto L20;
    L21:
        r107 = true;
        goto L22
    L25:
        return false;
    L9:
        if (r102.equals(r103) == false) goto L11;
    L12:
        r104 = true;
        goto L13
    }

    public e(F r100, S r101) {
        this.f532273a = r100;
        this.f532274b = r101;
    }
}
