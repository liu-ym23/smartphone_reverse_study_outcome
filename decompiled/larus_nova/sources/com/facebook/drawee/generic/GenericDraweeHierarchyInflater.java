package com.facebook.drawee.generic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.larus.nova.R;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class GenericDraweeHierarchyInflater {
    public GenericDraweeHierarchyInflater() {
    }

    private static RoundingParams getRoundingParams(GenericDraweeHierarchyBuilder r100) {
        if (r100.getRoundingParams() != null) goto L6;
        r100.setRoundingParams(new RoundingParams());
    L6:
        return r100.getRoundingParams();
    }

    @Nullable
    private static ScalingUtils.ScaleType getScaleTypeFromXml(TypedArray r100, int r101) {
        switch(r100.getInt(r101, -2)) {
            case -1: goto L24;
            case 0: goto L23;
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            case 8: goto L7;
            default: goto L5;
        };
    L24:
        return null;
    L5:
        throw new RuntimeException("XML attribute not specified!");
    L7:
        return ScalingUtils.ScaleType.FIT_BOTTOM_START;
    L9:
        return ScalingUtils.ScaleType.FOCUS_CROP;
    L11:
        return ScalingUtils.ScaleType.CENTER_CROP;
    L13:
        return ScalingUtils.ScaleType.CENTER_INSIDE;
    L15:
        return ScalingUtils.ScaleType.CENTER;
    L17:
        return ScalingUtils.ScaleType.FIT_END;
    L19:
        return ScalingUtils.ScaleType.FIT_CENTER;
    L21:
        return ScalingUtils.ScaleType.FIT_START;
    L23:
        return ScalingUtils.ScaleType.FIT_XY;
    }

    public static GenericDraweeHierarchyBuilder inflateBuilder(Context r100, @Nullable AttributeSet r101) {
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("GenericDraweeHierarchyBuilder#inflateBuilder");
    L5:
        GenericDraweeHierarchyBuilder r102 = updateBuilder(new GenericDraweeHierarchyBuilder(r100, r100.getResources()), r100, r101);
        if (FrescoSystrace.isTracing() == false) goto L8;
        FrescoSystrace.endSection();
    L8:
        return r102;
    }

    public static GenericDraweeHierarchy inflateHierarchy(Context r100, @Nullable AttributeSet r101) {
        return inflateBuilder(r100, r101).build();
    }

    @Nullable
    private static Drawable getDrawable(Context r100, TypedArray r101, int r102) {
        int r103 = r101.getResourceId(r102, 0);
        if (r103 != 0) goto L6;
        return null;
    L6:
        return r100.getResources().getDrawable(r103);
    }

    public static GenericDraweeHierarchyBuilder updateBuilder(GenericDraweeHierarchyBuilder r110, Context r111, @Nullable AttributeSet r112) {
        Context r100 = r111;
        if (r112 == null) goto L137;
        TypedArray r101 = r100.obtainStyledAttributes(r112, new int[]{R.attr.actualImageScaleType, R.attr.backgroundImage, R.attr.fadeDuration, R.attr.failureImage, R.attr.failureImageScaleType, R.attr.overlayImage, R.attr.placeholderImage, R.attr.placeholderImageScaleType, R.attr.pressedStateOverlayImage, R.attr.progressBarAutoRotateInterval, R.attr.progressBarImage, R.attr.progressBarImageScaleType, R.attr.retryImage, R.attr.retryImageScaleType, R.attr.roundAsCircle, R.attr.roundBottomEnd, R.attr.roundBottomLeft, R.attr.roundBottomRight, R.attr.roundBottomStart, R.attr.roundTopEnd, R.attr.roundTopLeft, R.attr.roundTopRight, R.attr.roundTopStart, R.attr.roundWithOverlayColor, R.attr.roundedCornerRadius, R.attr.roundingBorderColor, R.attr.roundingBorderPadding, R.attr.roundingBorderWidth, R.attr.viewAspectRatio});
        int r102 = r101.getIndexCount();     // Catch: Throwable -> L133
        int r103 = 0;
        int r104 = 0;
        boolean r105 = true;
        boolean r106 = true;
        boolean r113 = true;
        boolean r114 = true;
        boolean r115 = true;
        boolean r116 = true;
        boolean r117 = true;
        boolean r118 = true;
        int r119 = 0;
    L7:
        if (r104 >= r102) goto L100;
        int r107 = r101.getIndex(r104);     // Catch: Throwable -> L98
        if (r107 != 0) goto L12;
        r110.setActualImageScaleType(getScaleTypeFromXml(r101, r107));     // Catch: Throwable -> L98
    L97:
        r104 = r104 + 1;
        r100 = r111;
        goto L7
    L12:
        if (r107 != 6) goto L15;
        r110.setPlaceholderImage(getDrawable(r100, r101, r107));     // Catch: Throwable -> L98
        goto L97
    L15:
        if (r107 != 8) goto L18;
        r110.setPressedStateOverlay(getDrawable(r100, r101, r107));     // Catch: Throwable -> L98
        goto L97
    L18:
        if (r107 != 10) goto L21;
        r110.setProgressBarImage(getDrawable(r100, r101, r107));     // Catch: Throwable -> L98
        goto L97
    L21:
        if (r107 != 2) goto L24;
        r110.setFadeDuration(r101.getInt(r107, 0));     // Catch: Throwable -> L98
        goto L97
    L24:
        if (r107 != 28) goto L27;
        r110.setDesiredAspectRatio(r101.getFloat(r107, 0.0f));     // Catch: Throwable -> L98
        goto L97
    L27:
        if (r107 != 7) goto L30;
        r110.setPlaceholderImageScaleType(getScaleTypeFromXml(r101, r107));     // Catch: Throwable -> L98
        goto L97
    L30:
        if (r107 != 12) goto L33;
        r110.setRetryImage(getDrawable(r100, r101, r107));     // Catch: Throwable -> L98
        goto L97
    L33:
        if (r107 != 13) goto L36;
        r110.setRetryImageScaleType(getScaleTypeFromXml(r101, r107));     // Catch: Throwable -> L98
        goto L97
    L36:
        if (r107 != 3) goto L39;
        r110.setFailureImage(getDrawable(r100, r101, r107));     // Catch: Throwable -> L98
        goto L97
    L39:
        if (r107 != 4) goto L42;
        r110.setFailureImageScaleType(getScaleTypeFromXml(r101, r107));     // Catch: Throwable -> L98
        goto L97
    L42:
        if (r107 != 11) goto L45;
        r110.setProgressBarImageScaleType(getScaleTypeFromXml(r101, r107));     // Catch: Throwable -> L98
        goto L97
    L45:
        if (r107 != 9) goto L49;
        r103 = r101.getInteger(r107, r103);     // Catch: Throwable -> L98
        goto L97
    L49:
        if (r107 != 1) goto L52;
        r110.setBackground(getDrawable(r100, r101, r107));     // Catch: Throwable -> L98
        goto L97
    L52:
        if (r107 != 5) goto L55;
        r110.setOverlay(getDrawable(r100, r101, r107));     // Catch: Throwable -> L98
        goto L97
    L55:
        if (r107 != 14) goto L58;
        getRoundingParams(r110).setRoundAsCircle(r101.getBoolean(r107, false));     // Catch: Throwable -> L98
        goto L97
    L58:
        if (r107 != 24) goto L60;
        r119 = r101.getDimensionPixelSize(r107, r119);     // Catch: Throwable -> L98
        goto L97
    L60:
        int r108 = r119;
        if (r107 != 20) goto L65;
        r105 = r101.getBoolean(r107, r105);     // Catch: Throwable -> L98
    L63:
        r119 = r108;
        goto L97
    L65:
        if (r107 != 21) goto L68;
        r113 = r101.getBoolean(r107, r113);     // Catch: Throwable -> L98
        goto L63
    L68:
        if (r107 != 16) goto L71;
        r117 = r101.getBoolean(r107, r117);     // Catch: Throwable -> L98
        goto L63
    L71:
        if (r107 != 17) goto L74;
        r115 = r101.getBoolean(r107, r115);     // Catch: Throwable -> L98
        goto L63
    L74:
        if (r107 != 22) goto L77;
        r106 = r101.getBoolean(r107, r106);     // Catch: Throwable -> L98
        goto L63
    L77:
        if (r107 != 19) goto L80;
        r114 = r101.getBoolean(r107, r114);     // Catch: Throwable -> L98
        goto L63
    L80:
        if (r107 != 18) goto L83;
        r118 = r101.getBoolean(r107, r118);     // Catch: Throwable -> L98
        goto L63
    L83:
        if (r107 != 15) goto L86;
        r116 = r101.getBoolean(r107, r116);     // Catch: Throwable -> L98
        goto L63
    L86:
        if (r107 != 23) goto L88;
        r119 = r108;
        getRoundingParams(r110).setOverlayColor(r101.getColor(r107, 0));     // Catch: Throwable -> L98
        goto L97
    L88:
        r119 = r108;
        if (r107 != 27) goto L92;
        getRoundingParams(r110).setBorderWidth(r101.getDimensionPixelSize(r107, 0));     // Catch: Throwable -> L98
        goto L97
    L92:
        if (r107 != 25) goto L95;
        getRoundingParams(r110).setBorderColor(r101.getColor(r107, 0));     // Catch: Throwable -> L98
        goto L97
    L95:
        if (r107 != 26) goto L97;
        getRoundingParams(r110).setPadding(r101.getDimensionPixelSize(r107, 0));     // Catch: Throwable -> L98
    L98:
        th = th;
    L135:
        r101.recycle();
        r111.getResources().getConfiguration().getLayoutDirection();
        throw th;
    L100:
        boolean r109 = false;
        r101.recycle();
        if (r111.getResources().getConfiguration().getLayoutDirection() != 1) goto L117;
        if (r105 == false) goto L105;
        if (r114 == false) goto L105;
        boolean r120 = true;
    L106:
        if (r113 == false) goto L109;
        if (r106 == false) goto L109;
        boolean r121 = true;
    L110:
        if (r115 == false) goto L113;
        if (r118 == false) goto L113;
        boolean r122 = true;
    L114:
        if (r117 == false) goto L132;
        if (r116 == false) goto L132;
    L131:
        r109 = true;
    L132:
        boolean r123 = r109;
        int r124 = r103;
        boolean r125 = r120;
        int r126 = r119;
    L139:
        if (r110.getProgressBarImage() == null) goto L142;
        if (r124 <= 0) goto L142;
        r110.setProgressBarImage(new AutoRotateDrawable(r110.getProgressBarImage(), r124));
    L142:
        if (r126 <= 0) goto L157;
        RoundingParams r127 = getRoundingParams(r110);
        if (r125 == false) goto L146;
        float r128 = r126;
    L147:
        if (r121 == false) goto L149;
        float r129 = r126;
    L150:
        if (r122 == false) goto L152;
        float r130 = r126;
    L153:
        if (r123 == false) goto L155;
        float r131 = r126;
    L156:
        r127.setCornersRadii(r128, r129, r130, r131);
        goto L157
    L155:
        r131 = 0.0f;
        goto L156
    L152:
        r130 = 0.0f;
        goto L153
    L149:
        r129 = 0.0f;
        goto L150
    L146:
        r128 = 0.0f;
    L157:
        return r110;
    L113:
        r122 = false;
    L109:
        r121 = false;
    L105:
        r120 = false;
        goto L106
    L117:
        if (r105 == false) goto L120;
        if (r106 == false) goto L120;
        r120 = true;
    L121:
        if (r113 == false) goto L124;
        if (r114 == false) goto L124;
        r121 = true;
    L125:
        if (r115 == false) goto L128;
        if (r116 == false) goto L128;
        r122 = true;
    L129:
        if (r117 == false) goto L132;
        if (r118 == false) goto L132;
    L128:
        r122 = false;
    L124:
        r121 = false;
    L120:
        r120 = false;
    L133:
        th = th;
        goto L135
    L137:
        r121 = true;
        r124 = 0;
        r126 = 0;
        r122 = true;
        r125 = true;
        r123 = true;
        goto L139
    }
}
