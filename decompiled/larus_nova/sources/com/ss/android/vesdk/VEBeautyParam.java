package com.ss.android.vesdk;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes40.dex */
public final class VEBeautyParam {

    @Retention(RetentionPolicy.SOURCE)
    public @interface VEBeautyType {
    }

    public static String a(int r100) {
        if (r100 != 1) goto L5;
        return "beauty_brighten";
    L5:
        if (r100 != 2) goto L7;
        return "beauty_smooth";
    L7:
        if (r100 != 4) goto L9;
        return "reshape_eye";
    L9:
        if (r100 != 5) goto L11;
        return "reshape cheek";
    L11:
        if (r100 == 9) goto L23;
        switch(r100) {
            case 17: goto L21;
            case 18: goto L19;
            case 19: goto L17;
            case 20: goto L15;
            default: goto L13;
        };
    L13:
        return "";
    L15:
        return "beauty_pouch";
    L17:
        return "beauty_nasolabial";
    L19:
        return "beauty_blusher";
    L21:
        return "beauty_lipstick";
    L23:
        return "sharp";
    }
}
