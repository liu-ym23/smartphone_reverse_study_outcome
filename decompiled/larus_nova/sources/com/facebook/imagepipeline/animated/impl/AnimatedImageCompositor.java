package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;

/* JADX INFO: loaded from: classes23.dex */
public class AnimatedImageCompositor {
    private final AnimatedDrawableBackend mAnimatedDrawableBackend;
    private final Callback mCallback;
    private final Paint mTransparentFillPaint;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult = null;

        static {
            int[] r100 = new int[FrameNeededResult.values().length];
            $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult = r100;
            r100[FrameNeededResult.REQUIRED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[FrameNeededResult.NOT_REQUIRED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[FrameNeededResult.ABORT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[FrameNeededResult.SKIP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public interface Callback {
        CloseableReference<Bitmap> getCachedBitmap(int r100, ImageFormat r101, boolean r102);

        void onIntermediateResult(int r100, Bitmap r101);
    }

    public static final enum FrameNeededResult extends Enum<FrameNeededResult> {
        private static final /* synthetic */ FrameNeededResult[] $VALUES = null;
        public static final FrameNeededResult ABORT = null;
        public static final FrameNeededResult NOT_REQUIRED = null;
        public static final FrameNeededResult REQUIRED = null;
        public static final FrameNeededResult SKIP = null;

        static {
            FrameNeededResult r100 = new FrameNeededResult("REQUIRED", 0);
            REQUIRED = r100;
            FrameNeededResult r101 = new FrameNeededResult("NOT_REQUIRED", 1);
            NOT_REQUIRED = r101;
            FrameNeededResult r102 = new FrameNeededResult("SKIP", 2);
            SKIP = r102;
            FrameNeededResult r103 = new FrameNeededResult("ABORT", 3);
            ABORT = r103;
            $VALUES = new FrameNeededResult[]{r100, r101, r102, r103};
        }

        public static FrameNeededResult[] values() {
            return (FrameNeededResult[]) $VALUES.clone();
        }

        public static FrameNeededResult valueOf(String r100) {
            return (FrameNeededResult) Enum.valueOf(FrameNeededResult.class, r100);
        }

        private FrameNeededResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    private FrameNeededResult isFrameNeededForRendering(int r100) {
        AnimatedDrawableFrameInfo r101 = this.mAnimatedDrawableBackend.getFrameInfo(r100);
        AnimatedDrawableFrameInfo.DisposalMethod r102 = r101.disposalMethod;
        if (r102 != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) goto L7;
        return FrameNeededResult.REQUIRED;
    L7:
        if (r102 != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) goto L15;
        if (isFullFrame(r101) == false) goto L13;
        return FrameNeededResult.NOT_REQUIRED;
    L13:
        return FrameNeededResult.REQUIRED;
    L15:
        if (r102 != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) goto L19;
        return FrameNeededResult.SKIP;
    L19:
        return FrameNeededResult.ABORT;
    }

    private boolean isFullFrame(AnimatedDrawableFrameInfo r100) {
        if (r100.xOffset == 0) goto L5;
    L11:
        return false;
    L5:
        if (r100.yOffset != 0) goto L11;
        if (r100.width != this.mAnimatedDrawableBackend.getRenderedWidth()) goto L11;
        if (r100.height != this.mAnimatedDrawableBackend.getRenderedHeight()) goto L11;
        return true;
    }

    private boolean isKeyFrame(int r100) {
        if (r100 != 0) goto L5;
        return true;
    L5:
        AnimatedDrawableFrameInfo r101 = this.mAnimatedDrawableBackend.getFrameInfo(r100);
        AnimatedDrawableFrameInfo r102 = this.mAnimatedDrawableBackend.getFrameInfo(r100 - 1);
        if (r101.blendOperation != AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) goto L11;
        if (isFullFrame(r101) == false) goto L11;
        return true;
    L11:
        if (r102.disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) goto L13;
    L15:
        return false;
    L13:
        if (isFullFrame(r102) == false) goto L15;
        return true;
    }

    public AnimatedImageCompositor(AnimatedDrawableBackend r100, Callback r101) {
        this.mAnimatedDrawableBackend = r100;
        this.mCallback = r101;
        Paint r102 = new Paint();
        this.mTransparentFillPaint = r102;
        r102.setColor(0);
        r102.setStyle(Paint.Style.FILL);
        r102.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    private void disposeToBackground(Canvas r100, AnimatedDrawableFrameInfo r101) {
        int r102 = r101.xOffset;
        int r103 = r101.yOffset;
        r100.drawRect(r102, r103, r102 + r101.width, r103 + r101.height, this.mTransparentFillPaint);
    }

    private int prepareCanvasWithClosestCachedFrame(int r100, Canvas r101) {
    L2:
        if (r100 < 0) goto L27;
        int r102 = AnonymousClass1.$SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[isFrameNeededForRendering(r100).ordinal()];
        if (r102 != 1) goto L6;
        AnimatedDrawableFrameInfo r103 = this.mAnimatedDrawableBackend.getFrameInfo(r100);
        CloseableReference<Bitmap> r104 = this.mCallback.getCachedBitmap(r100, this.mAnimatedDrawableBackend.getAnimatedImageResult().getImage().getImageFormat(), this.mAnimatedDrawableBackend.isAnimatedHeifIndividualCacheEnabled());
        if (r104 == null) goto L24;
        r101.drawBitmap(r104.get(), 0.0f, 0.0f, null);     // Catch: Throwable -> L20
        if (r103.disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) goto L18;
        disposeToBackground(r101, r103);     // Catch: Throwable -> L20
    L18:
        int r105 = r100 + 1;
        r104.close();
        return r105;
    L20:
        th = move-exception;
        r104.close();
        throw th;
    L24:
        if (isKeyFrame(r100) == false) goto L26;
        return r100;
    L26:
        r100 = r100 - 1;
        goto L2
    L6:
        if (r102 == 2) goto L12;
        if (r102 != 3) goto L26;
        return r100;
    L12:
        return r100 + 1;
    L27:
        return 0;
    }

    public void renderFrame(int r100, Bitmap r101) {
        Canvas r102 = new Canvas(r101);
        r102.drawColor(0, PorterDuff.Mode.SRC);
        if (isKeyFrame(r100) == true) goto L5;
        int r103 = prepareCanvasWithClosestCachedFrame(r100 - 1, r102);
    L6:
        if (r103 >= r100) goto L17;
        AnimatedDrawableFrameInfo r104 = this.mAnimatedDrawableBackend.getFrameInfo(r103);
        AnimatedDrawableFrameInfo.DisposalMethod r105 = r104.disposalMethod;
        if (r105 == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) goto L16;
        if (r104.blendOperation != AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) goto L13;
        disposeToBackground(r102, r104);
    L13:
        this.mAnimatedDrawableBackend.renderFrame(r103, r102);
        this.mCallback.onIntermediateResult(r103, r101);
        if (r105 != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) goto L16;
        disposeToBackground(r102, r104);
    L16:
        r103 = r103 + 1;
        goto L6
    L17:
        AnimatedDrawableFrameInfo r106 = this.mAnimatedDrawableBackend.getFrameInfo(r100);
        if (r106.blendOperation != AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) goto L20;
        disposeToBackground(r102, r106);
    L20:
        this.mAnimatedDrawableBackend.renderFrame(r100, r102);
        return;
    L5:
        r103 = r100;
        goto L6
    }
}
