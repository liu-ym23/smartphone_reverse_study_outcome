package q2c;

import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes37.dex */
public final class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f531474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f531475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<d> f531476c;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f531474a, Integer.valueOf(this.f531475b), this.f531476c});
    }

    public c() {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f531475b == r101.f531475b) goto L11;
    L15:
        return false;
    L11:
        if (Objects.equals(this.f531474a, r101.f531474a) == false) goto L15;
        if (Objects.equals(this.f531476c, r101.f531476c) == false) goto L15;
        return true;
    }
}
