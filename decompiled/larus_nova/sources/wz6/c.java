package wz6;

/* JADX INFO: loaded from: classes21.dex */
public final class c {
    public static float a(float r100) {
        if (r100 > 0.04045f) goto L6;
        return r100 / 12.92f;
    L6:
        return (float) Math.pow((r100 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static float b(float r100) {
        if (r100 > 0.0031308f) goto L6;
        return r100 * 12.92f;
    L6:
        return (float) ((Math.pow(r100, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int c(float r100, int r101, int r102) {
        float r103 = ((r101 >> 24) & 255) / 255.0f;
        float r104 = a(((r101 >> 16) & 255) / 255.0f);
        float r105 = a(((r101 >> 8) & 255) / 255.0f);
        float r106 = a((r101 & 255) / 255.0f);
        float r107 = a(((r102 >> 16) & 255) / 255.0f);
        float r108 = r103 + (((((r102 >> 24) & 255) / 255.0f) - r103) * r100);
        float r109 = r105 + ((a(((r102 >> 8) & 255) / 255.0f) - r105) * r100);
        float r110 = r106 + (r100 * (a((r102 & 255) / 255.0f) - r106));
        float r111 = b(r104 + ((r107 - r104) * r100)) * 255.0f;
        float r112 = b(r109) * 255.0f;
        float r113 = b(r110) * 255.0f;
        return (((Math.round(r111) << 16) | (Math.round(r108 * 255.0f) << 24)) | (Math.round(r112) << 8)) | Math.round(r113);
    }
}
