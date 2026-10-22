package qz6;

import androidx.core.util.Pair;
import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes21.dex */
public final class h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f535379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f535380b;

    public h() {
    }

    public final int hashCode() {
        T r100 = this.f535379a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        T r103 = this.f535380b;
        if (r103 == null) goto L11;
        r101 = r103.hashCode();
    L11:
        return r102 ^ r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "Pair{" + String.valueOf(this.f535379a) + " " + String.valueOf(this.f535380b) + i.f25855d;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof Pair) == true) goto L5;
        return false;
    L5:
        Pair r101 = (Pair) r100;
        F r102 = r101.first;
        Object r103 = this.f535379a;
        if (r102 == r103) goto L12;
        if (r102 != 0) goto L9;
    L11:
        boolean r104 = false;
    L13:
        if (r104 == false) goto L25;
        S r105 = r101.second;
        Object r106 = this.f535380b;
        if (r105 == r106) goto L21;
        if (r105 != 0) goto L18;
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
}
