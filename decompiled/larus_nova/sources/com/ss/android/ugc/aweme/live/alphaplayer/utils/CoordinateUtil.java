package com.ss.android.ugc.aweme.live.alphaplayer.utils;

/* JADX INFO: loaded from: classes40.dex */
public class CoordinateUtil {
    public static void a(float[] r100, float r101, float r102, float r103, float r104) {
        if (r100 == null) goto L8;
        if (r100.length < 8) goto L8;
        r100[0] = r101;
        r100[1] = r104;
        r100[2] = r103;
        r100[3] = r104;
        r100[4] = r101;
        r100[5] = r102;
        r100[6] = r103;
        r100[7] = r102;
        return;
    L8:
        throw new RuntimeException("data is invalid");
    }
}
