package wp9;

import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f560622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f560623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f560624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f560625d;

    public final Integer a(float r100) {
        if (this.f560625d != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return null;
    L9:
        this.f560625d = r100;
        int r102 = this.f560622a;
        return Integer.valueOf(RangesKt.coerceIn((int) (r102 + (this.f560624c * r100)), Math.min(r102, this.f560623b), Math.max(this.f560622a, this.f560623b)));
    L5:
        r101 = false;
        goto L6
    }

    public e(int r100, int r101) {
        this.f560622a = r100;
        this.f560623b = r101;
        this.f560624c = r101 - r100;
        this.f560625d = -1.0f;
    }
}
