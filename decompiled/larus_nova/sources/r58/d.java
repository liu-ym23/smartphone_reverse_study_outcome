package r58;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f536320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f536321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f536322c;

    public d(int r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        this(r100, r101, null);
    }

    public d(int r100, byte[] r101, Long r102) {
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f536320a = r100;
        this.f536321b = r101;
        this.f536322c = r102;
    }
}
