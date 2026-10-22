package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.RoundedNinePatchDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class WrappingUtils {
    private static final String TAG = "WrappingUtils";
    private static final Drawable sEmptyDrawable = null;

    public WrappingUtils() {
    }

    static {
        sEmptyDrawable = new ColorDrawable(0);
    }

    public static DrawableParent findDrawableParentForLeaf(DrawableParent r100) {
    L2:
        Object r101 = r100.getDrawable();
        if (r101 == r100) goto L8;
        if ((r101 instanceof DrawableParent) == false) goto L8;
        r100 = (DrawableParent) r101;
    L8:
        return r100;
    }

    public static void resetRoundingParams(Rounded r100) {
        r100.setCircle(false);
        r100.setRadius(0.0f);
        r100.setBorder(0, 0.0f);
        r100.setPadding(0.0f);
        r100.setScaleDownInsideBorders(false);
    }

    public static void applyRoundingParams(Rounded r100, RoundingParams r101) {
        r100.setCircle(r101.getRoundAsCircle());
        r100.setRadii(r101.getCornersRadii());
        r100.setBorder(r101.getBorderColor(), r101.getBorderWidth());
        r100.setPadding(r101.getPadding());
        r100.setScaleDownInsideBorders(r101.getScaleDownInsideBorders());
    }

    @Nullable
    public static Drawable maybeWrapWithMatrix(@Nullable Drawable r100, @Nullable Matrix r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L7;
        return new MatrixDrawable(r100, r101);
    L7:
        return r100;
    }

    public static Drawable maybeWrapWithRoundedOverlayColor(@Nullable Drawable r100, @Nullable RoundingParams r101) {
    L19:
        th = move-exception;
        if (FrescoSystrace.isTracing() == false) goto L23;
        FrescoSystrace.endSection();
    L23:
        throw th;
    L3:
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("WrappingUtils#maybeWrapWithRoundedOverlayColor");     // Catch: Throwable -> L19
    L5:
        if (r100 == null) goto L16;
        if (r101 == null) goto L16;
        if (r101.getRoundingMethod() != RoundingParams.RoundingMethod.OVERLAY_COLOR) goto L16;
        RoundedCornersDrawable r102 = new RoundedCornersDrawable(r100);     // Catch: Throwable -> L19
        applyRoundingParams(r102, r101);     // Catch: Throwable -> L19
        r102.setOverlayColor(r101.getOverlayColor());     // Catch: Throwable -> L19
        if (FrescoSystrace.isTracing() == false) goto L14;
        FrescoSystrace.endSection();
    L14:
        return r102;
    L16:
        if (FrescoSystrace.isTracing() == false) goto L18;
        FrescoSystrace.endSection();
    L18:
        return r100;
    }

    @Nullable
    public static Drawable maybeWrapWithScaleType(@Nullable Drawable r100, @Nullable ScalingUtils.ScaleType r101) {
        return maybeWrapWithScaleType(r100, r101, null);
    }

    public static void updateOverlayColorRounding(DrawableParent r100, @Nullable RoundingParams r101) {
        Drawable r102 = r100.getDrawable();
        if (r101 == null) goto L11;
        if (r101.getRoundingMethod() != RoundingParams.RoundingMethod.OVERLAY_COLOR) goto L11;
        if ((r102 instanceof RoundedCornersDrawable) == false) goto L9;
        RoundedCornersDrawable r103 = (RoundedCornersDrawable) r102;
        applyRoundingParams(r103, r101);
        r103.setOverlayColor(r101.getOverlayColor());
        return;
    L9:
        r100.setDrawable(maybeWrapWithRoundedOverlayColor(r100.setDrawable(sEmptyDrawable), r101));
        return;
    L11:
        if ((r102 instanceof RoundedCornersDrawable) == false) goto L16;
        Drawable r104 = sEmptyDrawable;
        r100.setDrawable(((RoundedCornersDrawable) r102).setCurrent(r104));
        r104.setCallback(null);
        return;
    }

    public static ScaleTypeDrawable wrapChildWithScaleType(DrawableParent r100, ScalingUtils.ScaleType r101) {
        Drawable r102 = maybeWrapWithScaleType(r100.setDrawable(sEmptyDrawable), r101);
        r100.setDrawable(r102);
        Preconditions.checkNotNull(r102, "Parent has no child drawable!");
        return (ScaleTypeDrawable) r102;
    }

    private static Drawable applyLeafRounding(Drawable r100, RoundingParams r101, Resources r102) {
        if ((r100 instanceof BitmapDrawable) == false) goto L7;
        BitmapDrawable r103 = (BitmapDrawable) r100;
        RoundedBitmapDrawable r104 = new RoundedBitmapDrawable(r102, r103.getBitmap(), r103.getPaint());
        applyRoundingParams(r104, r101);
        return r104;
    L7:
        if ((r100 instanceof NinePatchDrawable) == false) goto L11;
        RoundedNinePatchDrawable r105 = new RoundedNinePatchDrawable((NinePatchDrawable) r100);
        applyRoundingParams(r105, r101);
        return r105;
    L11:
        if ((r100 instanceof ColorDrawable) == false) goto L14;
        RoundedColorDrawable r106 = RoundedColorDrawable.fromColorDrawable((ColorDrawable) r100);
        applyRoundingParams(r106, r101);
        return r106;
    L14:
        FLog.w(TAG, "Don't know how to round that drawable: %s", new Object[]{r100});
        return r100;
    }

    public static Drawable maybeApplyLeafRounding(@Nullable Drawable r100, @Nullable RoundingParams r101, Resources r102) {
    L26:
        th = move-exception;
        if (FrescoSystrace.isTracing() == false) goto L30;
        FrescoSystrace.endSection();
    L30:
        throw th;
    L3:
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("WrappingUtils#maybeApplyLeafRounding");     // Catch: Throwable -> L26
    L5:
        if (r100 == null) goto L23;
        if (r101 == null) goto L23;
        if (r101.getRoundingMethod() != RoundingParams.RoundingMethod.BITMAP_ONLY) goto L23;
        if ((r100 instanceof ForwardingDrawable) == false) goto L17;
        DrawableParent r103 = findDrawableParentForLeaf((ForwardingDrawable) r100);     // Catch: Throwable -> L26
        r103.setDrawable(applyLeafRounding(r103.setDrawable(sEmptyDrawable), r101, r102));     // Catch: Throwable -> L26
        if (FrescoSystrace.isTracing() == false) goto L16;
        FrescoSystrace.endSection();
    L16:
        return r100;
    L17:
        Drawable r104 = applyLeafRounding(r100, r101, r102);     // Catch: Throwable -> L26
        if (FrescoSystrace.isTracing() == false) goto L21;
        FrescoSystrace.endSection();
    L21:
        return r104;
    L23:
        if (FrescoSystrace.isTracing() == false) goto L25;
        FrescoSystrace.endSection();
    L25:
        return r100;
    }

    @Nullable
    public static Drawable maybeWrapWithScaleType(@Nullable Drawable r100, @Nullable ScalingUtils.ScaleType r101, @Nullable PointF r102) {
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("WrappingUtils#maybeWrapWithScaleType");
    L5:
        if (r100 == null) goto L16;
        if (r101 == null) goto L16;
        ScaleTypeDrawable r103 = new ScaleTypeDrawable(r100, r101);
        if (r102 == null) goto L12;
        r103.setFocusPoint(r102);
    L12:
        if (FrescoSystrace.isTracing() == false) goto L14;
        FrescoSystrace.endSection();
    L14:
        return r103;
    L16:
        if (FrescoSystrace.isTracing() == false) goto L18;
        FrescoSystrace.endSection();
    L18:
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void updateLeafRounding(DrawableParent r100, @Nullable RoundingParams r101, Resources r102) {
        DrawableParent r103 = findDrawableParentForLeaf(r100);
        Drawable r104 = r103.getDrawable();
        if (r101 == null) goto L12;
        if (r101.getRoundingMethod() != RoundingParams.RoundingMethod.BITMAP_ONLY) goto L12;
        if ((r104 instanceof Rounded) == false) goto L9;
        applyRoundingParams((Rounded) r104, r101);
        return;
    L9:
        if (r104 == 0) goto L16;
        r103.setDrawable(sEmptyDrawable);
        r103.setDrawable(applyLeafRounding(r104, r101, r102));
        return;
    L16:
        return;
    L12:
        if ((r104 instanceof Rounded) == false) goto L18;
        resetRoundingParams((Rounded) r104);
        return;
    }
}
