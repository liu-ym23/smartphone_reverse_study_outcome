package pc0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f528462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f528463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f528464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f528465e;

    public final String toString() {
        return "LinkRegion(uid='" + this.f528461a + "', x=" + this.f528462b + ", y=" + this.f528463c + ", width=" + this.f528464d + ", height=" + this.f528465e + ')';
    }

    public c(String r100, float r101, float r102, float r103, float r104) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        this.f528461a = r100;
        this.f528462b = r101;
        this.f528463c = r102;
        this.f528464d = r103;
        this.f528465e = r104;
    }
}
