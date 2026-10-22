package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.imageformat.ImageFormat;
import com.tencent.connect.common.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ImageDecodeBitmapConfigStrategy {
    public static ImageDecodeBitmapConfigStrategy DEFAULT;
    public static ImageDecodeBitmapConfigStrategy MEMORY_AT_LEAST;
    private static ImageDecodeBitmapConfigStrategy sStrategy;

    public ImageDecodeBitmapConfigStrategy() {
    }

    public abstract Bitmap.Config getBitmapConfig(String r100, int r101, int r102, int r103, int r104, boolean r105, ImageFormat r106);

    static {
        DEFAULT = new AnonymousClass1();
        MEMORY_AT_LEAST = new AnonymousClass2();
        sStrategy = DEFAULT;
    }

    private static boolean isMeizu() {
        String r100 = Build.BRAND;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.toLowerCase(Locale.ENGLISH).indexOf("meizu") <= (-1)) goto L9;
        return true;
    L9:
        return false;
    }

    public static /* synthetic */ boolean access$000() {
        return isMeizu15();
    }

    private static boolean isMeizu15() {
        if (isMeizu() == false) goto L8;
        String r100 = Build.DEVICE;
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        return r100.contains(Constants.VIA_REPORT_TYPE_WPA_STATE);
    L8:
        return false;
    }

    public static ImageDecodeBitmapConfigStrategy getStrategy() {
        return sStrategy;
    }

    public static void setStrategy(ImageDecodeBitmapConfigStrategy r100) {
        sStrategy = r100;
    }
}
