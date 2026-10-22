package com.larus.common_ui.qrcode;

import android.graphics.Bitmap;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.f;
import nv7.b;

/* JADX INFO: loaded from: classes27.dex */
public final class LarkQRCodeUtil {

    public static final enum EccLevel extends Enum<EccLevel> {
        public static final EccLevel AUTO = null;
        public static final EccLevel HIGH = null;
        public static final EccLevel LOW = null;
        public static final EccLevel MEDIUM = null;
        public static final EccLevel MEDIUM_HIGH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EccLevel[] f327772a = null;

        static {
            EccLevel r100 = new EccLevel("AUTO", 0);
            AUTO = r100;
            EccLevel r101 = new EccLevel("LOW", 1);
            LOW = r101;
            EccLevel r102 = new EccLevel("MEDIUM", 2);
            MEDIUM = r102;
            EccLevel r103 = new EccLevel("MEDIUM_HIGH", 3);
            MEDIUM_HIGH = r103;
            EccLevel r104 = new EccLevel("HIGH", 4);
            HIGH = r104;
            f327772a = new EccLevel[]{r100, r101, r102, r103, r104};
        }

        public static EccLevel[] values() {
            return (EccLevel[]) f327772a.clone();
        }

        public static EccLevel valueOf(String r100) {
            return (EccLevel) r27.a.a(EccLevel.class, r100);
        }

        public EccLevel(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f327773a = null;

        static {
            int[] r100 = new int[EccLevel.values().length];
            f327773a = r100;
            r100[EccLevel.LOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f327773a[EccLevel.MEDIUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f327773a[EccLevel.MEDIUM_HIGH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f327773a[EccLevel.HIGH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f327773a[EccLevel.AUTO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static ErrorCorrectionLevel a(EccLevel r100) {
        if (r100 == null) goto L4;
        int r101 = a.f327773a[r100.ordinal()];
        if (r101 == 1) goto L18;
        if (r101 == 3) goto L16;
        if (r101 == 4) goto L14;
        return ErrorCorrectionLevel.M;
    L14:
        return ErrorCorrectionLevel.H;
    L16:
        return ErrorCorrectionLevel.Q;
    L18:
        return ErrorCorrectionLevel.L;
    L4:
        return ErrorCorrectionLevel.M;
    }

    public static Bitmap b(b r100) {
        int r101 = r100.f520912a;
        int r102 = r100.f520913b;
        int[] r103 = new int[r101 * r102];
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L12;
        int r105 = r104 * r101;
        int r106 = 0;
    L5:
        if (r106 >= r101) goto L11;
        int r107 = r105 + r106;
        if (r100.b(r106, r104) == false) goto L9;
        int r108 = -16777216;
    L10:
        r103[r107] = r108;
        r106 = r106 + 1;
        goto L5
    L9:
        r108 = -1;
        goto L10
    L11:
        r104 = r104 + 1;
        goto L3
    L12:
        Bitmap r109 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);
        r109.setPixels(r103, 0, r101, 0, 0, r101, r102);
        return r109;
    }

    public static b d(b r110) {
        int[] r100 = r110.c();
        int r101 = r100[2] + 0;
        int r102 = r100[3] + 0;
        b r103 = new b(r101, r102);
        int r104 = r103.f520915d.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        r103.f520915d[r105] = 0;
        r105 = r105 + 1;
        goto L3
    L5:
        int r106 = 0;
    L7:
        if (r106 >= (r101 + 0)) goto L16;
        int r107 = 0;
    L10:
        if (r107 >= (r102 + 0)) goto L15;
        if (r110.b((r106 + 0) + r100[0], (r107 + 0) + r100[1]) == false) goto L14;
        r103.d(r106, r107);
    L14:
        r107 = r107 + 1;
        goto L10
    L15:
        r106 = r106 + 1;
        goto L7
    L16:
        return r103;
    }

    public static b c(f r110, int r111, int r112) {
        com.google.zxing.qrcode.encoder.b r113 = r110.f276010e;
        if (r113 == null) goto L15;
        int r100 = r113.f275997b;
        int r101 = r113.f275998c;
        int r114 = Math.max(r111, r100);
        int r115 = Math.max(r112, r101);
        int r102 = Math.max(1, Math.min(r114 / r100, r115 / r101));
        int r103 = (r114 - (r100 * r102)) / 2;
        int r104 = (r115 - (r101 * r102)) / 2;
        b r105 = new b(r114, r115);
        int r116 = 0;
    L5:
        if (r116 >= r101) goto L13;
        int r106 = r103;
        int r107 = 0;
    L7:
        if (r107 >= r100) goto L12;
        if (r113.a(r107, r116) != 1) goto L11;
        r105.e(r106, r104, r102, r102);
    L11:
        r107 = r107 + 1;
        r106 = r106 + r102;
        goto L7
    L12:
        r116 = r116 + 1;
        r104 = r104 + r102;
        goto L5
    L13:
        return r105;
    L15:
        throw new IllegalArgumentException("QRCode matrix is null");
    }
}
