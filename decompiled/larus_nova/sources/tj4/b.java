package tj4;

import java.util.Arrays;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f546409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f546410b;

    public b(int r100, byte[] r101) {
        this.f546409a = r100;
        this.f546410b = r101;
    }

    public b(int r100, byte[] r101, int r102) {
        this.f546409a = r100;
        this.f546410b = Arrays.copyOf(r101, r102);
    }
}
