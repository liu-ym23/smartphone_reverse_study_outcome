package q2c;

import java.util.Objects;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f531477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f531478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f531479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f531480d;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f531477a, this.f531478b, Boolean.valueOf(this.f531480d)});
    }

    public d() {
        this.f531480d = true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f531480d == r101.f531480d) goto L11;
    L15:
        return false;
    L11:
        if (Objects.equals(this.f531477a, r101.f531477a) == false) goto L15;
        if (Objects.equals(this.f531478b, r101.f531478b) == false) goto L15;
        return true;
    }

    public d(String r100, String r101) {
        this.f531480d = true;
        this.f531477a = r100;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.f531478b = r101;
    }
}
