package com.larus.camera.impl.edulibs.camera.internal.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Base64;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.utils.z0;
import java.math.BigDecimal;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f321630a = 0;

    /* JADX INFO: renamed from: com.larus.camera.impl.edulibs.camera.internal.util.a$a, reason: collision with other inner class name */
    public static final class C4147a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f321631a;

        public C4147a(Bitmap r100) {
            Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
            this.f321631a = r100;
        }
    }

    static {
    }

    public static Bitmap a(String r100) throws Exception {
        Intrinsics.checkNotNullParameter(r100, "base64Data");
        byte[] r101 = Base64.decode(r100, 2);
        return BitmapFactory.decodeByteArray(r101, 0, r101.length);
    }

    public static double d(float r100) {
        return new BigDecimal(String.valueOf(r100)).setScale(2, 4).doubleValue();
    }

    public static C4147a b(Bitmap r100, float[] r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r101, "points");
        int r103 = 1;
    L11:
        return new C4147a(c(r100, r101, r102, 1 / r103));
    L6:
        e = move-exception;
        r103 = r103 * 2;
        if (r103 <= 8) goto L11;
        throw e;
    }

    public static Bitmap c(Bitmap r110, float[] r111, int r112, float r210) {
        int r100 = r110.getWidth();
        int r101 = r110.getHeight();
        Intrinsics.checkNotNullParameter(r111, "points");
        Intrinsics.checkNotNullParameter(r111, "points");
        float r102 = 0.0f;
        int r113 = 0;
        if (r111.length >= 7) goto L5;
        float r103 = 0.0f;
    L6:
        int r104 = Math.round(Math.max(0.0f, r103));
        Intrinsics.checkNotNullParameter(r111, "points");
        if (r111.length >= 8) goto L9;
        float r114 = 0.0f;
    L10:
        int r115 = Math.round(Math.max(0.0f, r114));
        float r105 = r100;
        Intrinsics.checkNotNullParameter(r111, "points");
        if (r111.length < 7) goto L14;
        r102 = Math.max(Math.max(Math.max(r111[0], r111[2]), r111[4]), r111[6]);
    L14:
        int r106 = Math.round(Math.min(r105, r102));
        float r107 = r101;
        Intrinsics.checkNotNullParameter(r111, "points");
        if (r111.length >= 8) goto L17;
        float r108 = 0.0f;
    L18:
        Rect r116 = new Rect(r104, r115, r106, Math.round(Math.min(r107, r108)));
        Matrix r109 = new Matrix();
        r109.setRotate(r112, r110.getWidth() / 2, r110.getHeight() / 2);
        r109.postScale(r210, r210);
        Bitmap r117 = Bitmap.createBitmap(r110, r116.left, r116.top, r116.width(), r116.height(), r109, true);
        if (Intrinsics.areEqual(r117, r110) == true) goto L21;
    L23:
        int r118 = r112 % 90;
        if (r118 != 0) goto L26;
    L56:
        if (r117 == null) goto L58;
        return r117;
    L58:
        return r110;
    L26:
        if (r116.width() > 0) goto L28;
    L30:
        boolean r119 = false;
    L31:
        if (r118 == 0) goto L56;
        if (r119 == false) goto L56;
        double r120 = Math.toRadians(r112);
        if (r112 >= 90) goto L36;
    L41:
        Intrinsics.checkNotNull(r116);
        int r121 = r116.left;
    L42:
        int r122 = 0;
    L44:
        if (r122 >= r111.length) goto L51;
        float r123 = r111[r122];
        if (r123 < (r121 - 1)) goto L50;
        if (r123 > (r121 + 1)) goto L50;
        int r124 = r122 + 1;
        int r125 = (int) Math.abs(Math.sin(r120) * ((double) (r116.bottom - r111[r124])));
        int r126 = (int) Math.abs(Math.cos(r120) * ((double) (r111[r124] - r116.top)));
        int r127 = (int) Math.abs(((double) (r111[r124] - r116.top)) / Math.sin(r120));
        int r128 = (int) Math.abs(((double) (r116.bottom - r111[r124])) / Math.cos(r120));
        int r129 = r125;
        r113 = r127;
    L52:
        r116.set(r129, r126, r113 + r129, r128 + r126);
        Intrinsics.checkNotNull(r117);
        Bitmap r130 = Bitmap.createBitmap(r117, r116.left, r116.top, r116.width(), r116.height());
        if (Intrinsics.areEqual(r117, r130) == true) goto L55;
        Intrinsics.checkNotNull(r117);
        r117.recycle();
    L55:
        r117 = r130;
    L50:
        r122 = r122 + 2;
        goto L44
    L51:
        r129 = 0;
        r128 = 0;
        r126 = 0;
        goto L52
    L36:
        if (r112 > 180) goto L38;
    L40:
        Intrinsics.checkNotNull(r116);
        r121 = r116.right;
        goto L42
    L38:
        if (r112 >= 270) goto L40;
    L28:
        if (r116.height() <= 0) goto L30;
        r119 = true;
        goto L31
    L21:
        if (r110.getConfig() == null) goto L23;
        r117 = r110.copy(z0.b(r110.getConfig()), false);
        goto L23
    L17:
        r108 = Math.max(Math.max(Math.max(r111[1], r111[3]), r111[5]), r111[7]);
        goto L18
    L9:
        r114 = Math.min(Math.min(Math.min(r111[1], r111[3]), r111[5]), r111[7]);
        goto L10
    L5:
        r103 = Math.min(Math.min(Math.min(r111[0], r111[2]), r111[4]), r111[6]);
        goto L6
    }
}
