package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import androidx.palette.graphics.Palette;
import androidx.palette.graphics.Target;
import com.facebook.common.logging.FLog;

/* JADX INFO: loaded from: classes23.dex */
public class ColorCalculator {
    private static final String TAG = "ColorCalculator";

    /* JADX INFO: renamed from: com.facebook.imagepipeline.image.ColorCalculator$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$imagepipeline$image$ColorCalculator$PhotoBgColorStyle = null;

        static {
            int[] r100 = new int[PhotoBgColorStyle.values().length];
            $SwitchMap$com$facebook$imagepipeline$image$ColorCalculator$PhotoBgColorStyle = r100;
            r100[PhotoBgColorStyle.MUTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$facebook$imagepipeline$image$ColorCalculator$PhotoBgColorStyle[PhotoBgColorStyle.VIBRANT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$facebook$imagepipeline$image$ColorCalculator$PhotoBgColorStyle[PhotoBgColorStyle.DARK_MUTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$facebook$imagepipeline$image$ColorCalculator$PhotoBgColorStyle[PhotoBgColorStyle.DARK_VIBRANT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$facebook$imagepipeline$image$ColorCalculator$PhotoBgColorStyle[PhotoBgColorStyle.LIGHT_MUTED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$facebook$imagepipeline$image$ColorCalculator$PhotoBgColorStyle[PhotoBgColorStyle.LIGHT_VIBRANT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static final enum PhotoBgColorStyle extends Enum<PhotoBgColorStyle> {
        private static final /* synthetic */ PhotoBgColorStyle[] $VALUES = null;
        public static final PhotoBgColorStyle DARK_MUTED = null;
        public static final PhotoBgColorStyle DARK_VIBRANT = null;
        public static final PhotoBgColorStyle DEFAULT = null;
        public static final PhotoBgColorStyle LIGHT_MUTED = null;
        public static final PhotoBgColorStyle LIGHT_VIBRANT = null;
        public static final PhotoBgColorStyle MUTED = null;
        public static final PhotoBgColorStyle VIBRANT = null;

        static {
            PhotoBgColorStyle r100 = new PhotoBgColorStyle("DEFAULT", 0);
            DEFAULT = r100;
            PhotoBgColorStyle r101 = new PhotoBgColorStyle("MUTED", 1);
            MUTED = r101;
            PhotoBgColorStyle r102 = new PhotoBgColorStyle("VIBRANT", 2);
            VIBRANT = r102;
            PhotoBgColorStyle r103 = new PhotoBgColorStyle("DARK_MUTED", 3);
            DARK_MUTED = r103;
            PhotoBgColorStyle r104 = new PhotoBgColorStyle("DARK_VIBRANT", 4);
            DARK_VIBRANT = r104;
            PhotoBgColorStyle r105 = new PhotoBgColorStyle("LIGHT_MUTED", 5);
            LIGHT_MUTED = r105;
            PhotoBgColorStyle r110 = new PhotoBgColorStyle("LIGHT_VIBRANT", 6);
            LIGHT_VIBRANT = r110;
            $VALUES = new PhotoBgColorStyle[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static PhotoBgColorStyle[] values() {
            return (PhotoBgColorStyle[]) $VALUES.clone();
        }

        public static PhotoBgColorStyle valueOf(String r100) {
            return (PhotoBgColorStyle) Enum.valueOf(PhotoBgColorStyle.class, r100);
        }

        private PhotoBgColorStyle(String r100, int r101) {
            super(r100, r101);
        }
    }

    public ColorCalculator() {
    }

    private static Integer getColor(Palette.Builder r100, PhotoBgColorStyle r101) {
        Integer r102 = null;
        if (r101 != null) goto L5;
    L13:
        Palette.Swatch r103 = null;
    L14:
        if (r103 == null) goto L16;
        r102 = Integer.valueOf(r103.getRgb());
    L16:
        if (r102 != null) goto L19;
        FLog.d(TAG, "使用dominantSwatch算色/非常规算法算色失败");
        return Integer.valueOf(r100.generate().getDominantSwatch().getRgb());
    L19:
        return r102;
    L5:
        switch(AnonymousClass1.$SwitchMap$com$facebook$imagepipeline$image$ColorCalculator$PhotoBgColorStyle[r101.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L13;
        };
    L7:
        r103 = r100.addTarget(Target.LIGHT_VIBRANT).generate().getLightVibrantSwatch();
        goto L14
    L8:
        r103 = r100.addTarget(Target.LIGHT_MUTED).generate().getLightMutedSwatch();
        goto L14
    L9:
        r103 = r100.addTarget(Target.DARK_VIBRANT).generate().getDarkVibrantSwatch();
        goto L14
    L10:
        r103 = r100.addTarget(Target.DARK_MUTED).generate().getDarkMutedSwatch();
        goto L14
    L11:
        r103 = r100.addTarget(Target.VIBRANT).generate().getVibrantSwatch();
        goto L14
    L12:
        r103 = r100.addTarget(Target.MUTED).generate().getMutedSwatch();
        goto L14
    }

    public static CalculateColorInfo getColorByAlgorithm(Bitmap r100, int r101, int r102, PhotoBgColorStyle r103) {
        if (r100 != null) goto L5;
    L17:
        return null;
    L5:
        if (r100.isRecycled() == true) goto L17;
        if (r101 <= 0) goto L17;
        int r104 = Math.min(r101, r100.getHeight());     // Catch: Exception -> L18
        Palette.Builder r105 = Palette.from(r100).clearTargets().clearFilters();     // Catch: Exception -> L18
        r105.setRegion(0, 0, r100.getWidth(), r104);     // Catch: Exception -> L18
        if (r102 <= 0) goto L11;
        r105.resizeBitmapArea(r102 * r102);     // Catch: Exception -> L18
    L11:
        int r106 = getColor(r105, r103).intValue();     // Catch: Exception -> L18
        if (r104 == r100.getHeight()) goto L14;
        int r107 = r100.getHeight();     // Catch: Exception -> L18
        int r108 = r107 - r104;     // Catch: Exception -> L18
        r105.setRegion(0, r108, r100.getWidth(), r107);     // Catch: Exception -> L18
        return new CalculateColorInfo(r106, getColor(r105, r103).intValue());
    L14:
        return new CalculateColorInfo(r106, r106);
    }
}
