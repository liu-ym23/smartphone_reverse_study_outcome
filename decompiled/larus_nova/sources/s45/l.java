package s45;

import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f540576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f540577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f540578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f540579d;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f540576a, this.f540577b, this.f540578c});
    }

    public l() {
        this.f540576a = "";
        this.f540577b = "";
        this.f540578c = "";
        this.f540579d = "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L19:
        return false;
    L8:
        if (l.class != r100.getClass()) goto L19;
        l r101 = (l) r100;
        if (Objects.equals(this.f540576a, r101.f540576a) == true) goto L13;
    L17:
        return false;
    L13:
        if (Objects.equals(this.f540577b, r101.f540577b) == false) goto L17;
        if (Objects.equals(this.f540578c, r101.f540578c) == false) goto L17;
        return true;
    }
}
