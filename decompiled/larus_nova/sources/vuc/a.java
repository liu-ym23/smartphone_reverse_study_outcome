package vuc;

/* JADX INFO: loaded from: classes42.dex */
public final class a {
    public static int a(float r100, int r101, int r102) {
        int r103 = (r101 >> 24) & 255;
        int r104 = (r101 >> 16) & 255;
        int r105 = (r101 >> 8) & 255;
        int r106 = r101 & 255;
        return ((((r103 + ((int) ((((r102 >> 24) & 255) - r103) * r100))) << 24) | ((r104 + ((int) ((((r102 >> 16) & 255) - r104) * r100))) << 16)) | ((r105 + ((int) ((((r102 >> 8) & 255) - r105) * r100))) << 8)) | (r106 + ((int) (r100 * ((r102 & 255) - r106))));
    }
}
