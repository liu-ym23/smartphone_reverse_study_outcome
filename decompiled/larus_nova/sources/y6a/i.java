package y6a;

/* JADX INFO: loaded from: classes32.dex */
public final class i {
    public i() {
    }

    public static long a(float r100, float r101) {
        int r102 = Float.floatToRawIntBits(r100);
        long r103 = ((long) r102) << 32;
        return ((long) Float.floatToRawIntBits(r101)) | r103;
    }

    public static long b(int r100, int r101) {
        return a(r100, r101);
    }
}
