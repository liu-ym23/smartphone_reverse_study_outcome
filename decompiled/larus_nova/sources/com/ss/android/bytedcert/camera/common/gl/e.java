package com.ss.android.bytedcert.camera.common.gl;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float[] f407298a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[] f407299b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float[] f407300c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float[] f407301d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float[] f407302e = null;

    public static float a(float r100) {
        if (r100 != 0.0f) goto L6;
        return 1.0f;
    L6:
        return 0.0f;
    }

    static {
        f407298a = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        f407299b = new float[]{1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
        f407300c = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
        f407301d = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        f407302e = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    }

    public static float[] b(int r110, boolean r111, boolean r112) {
        if (r110 != 90) goto L5;
        float[] r113 = f407299b;
    L13:
        if (r111 == false) goto L15;
        r113 = new float[]{a(r113[0]), r113[1], a(r113[2]), r113[3], a(r113[4]), r113[5], a(r113[6]), r113[7]};
    L15:
        if (r112 == true) goto L17;
        return r113;
    L17:
        return new float[]{r113[0], a(r113[1]), r113[2], a(r113[3]), r113[4], a(r113[5]), r113[6], a(r113[7])};
    L5:
        if (r110 != 180) goto L7;
        r113 = f407300c;
        goto L13
    L7:
        if (r110 == 270) goto L9;
        r113 = f407298a;
        goto L13
    L9:
        r113 = f407301d;
        goto L13
    }
}
