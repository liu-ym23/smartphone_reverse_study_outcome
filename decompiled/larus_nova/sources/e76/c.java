package e76;

import java.util.Arrays;

/* JADX INFO: loaded from: classes19.dex */
public final class c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V f471184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f471185b;

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f471184a, this.f471185b});
    }

    public c(V r100) {
        this.f471184a = r100;
        this.f471185b = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        V r102 = this.f471184a;
        if (r102 != null) goto L11;
    L13:
        Throwable r103 = this.f471185b;
        if (r103 != null) goto L16;
    L19:
        return false;
    L16:
        if (r101.f471185b == null) goto L19;
        return r103.toString().equals(this.f471185b.toString());
    L11:
        if (r102.equals(r101.f471184a) == false) goto L13;
        return true;
    }

    public c(Throwable r100) {
        this.f471185b = r100;
        this.f471184a = null;
    }
}
