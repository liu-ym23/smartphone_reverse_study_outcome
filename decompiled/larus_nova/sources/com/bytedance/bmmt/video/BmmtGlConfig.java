package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: classes8.dex */
public final class BmmtGlConfig {
    private static volatile int texture2DGlFormat = 6408;

    private BmmtGlConfig() {
    }

    public static int getTexture2DGlFormat() {
        int r100 = texture2DGlFormat;
        if (r100 == 0) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("texture2DGlFormat not set");
    }

    public static void setTexture2DGlFormat(int r100) {
        if (r100 != 6408) goto L5;
    L11:
        texture2DGlFormat = r100;
        return;
    L5:
        if (r100 == 6407) goto L11;
        if (r100 == 6409) goto L11;
        throw new IllegalArgumentException("Unsupported glFormat: " + r100);
    }
}
