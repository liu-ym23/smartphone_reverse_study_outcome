package ija;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f490154a = 0;

    static {
        new a(0.4f, 0.0f, 0.2f, 1.0f);
    }

    public static final float a(float r100) {
        float r101 = Float.intBitsToFloat(((int) ((((long) Float.floatToRawIntBits(r100)) & 8589934591L) / ((long) 3))) + 709952852);
        float r102 = r101 - ((r101 - (r100 / (r101 * r101))) * 0.33333334f);
        return r102 - ((r102 - (r100 / (r102 * r102))) * 0.33333334f);
    }

    public static final int b(float r100, float[] r101, int r102) {
        if (r100 >= 0.0f) goto L8;
        if (r100 < (-8.34465E-7f)) goto L12;
        r100 = 0.0f;
    L13:
        r101[r102] = r100;
        return !Float.isNaN(r100) ? 1 : 0;
    L12:
        r100 = Float.NaN;
        goto L13
    L8:
        if (r100 <= 1.0f) goto L13;
        if (r100 > 1.0000008f) goto L12;
        r100 = 1.0f;
        goto L13
    }
}
