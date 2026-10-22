package y6b;

import java.util.Objects;

/* JADX INFO: loaded from: classes35.dex */
public final class g implements y28.b<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f566553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f566554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f566555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f566556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f566557e;

    public final int hashCode() {
        return Objects.hash(new Object[]{Long.valueOf(this.f566553a), Boolean.valueOf(this.f566555c), Boolean.valueOf(this.f566554b)});
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof g) == false) goto L19;
        g r101 = (g) r100;
        if (this.f566553a == r101.f566553a) goto L10;
        return false;
    L10:
        if (this.f566555c == r101.f566555c) goto L12;
        return false;
    L12:
        if (this.f566554b != r101.f566554b) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    }

    @Override // y28.b
    public final boolean isContentSame(y28.b r100) {
        return equals((g) r100);
    }

    @Override // y28.b
    public final boolean isItemSame(y28.b r100) {
        if (this != ((g) r100)) goto L5;
        return true;
    L5:
        return false;
    }

    public g(long r100, boolean r101, boolean r102) {
        this.f566553a = r100;
        this.f566554b = r101;
        this.f566555c = r102;
    }
}
