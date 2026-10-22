package v07;

import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements AnimatedImage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f[] f552316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f552317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f552318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f552319d;

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public final AnimatedImage cloneOrNull() {
        return null;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public final void dispose() {
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public final boolean doesRenderSupportScaling() {
        return true;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public final int getDecodeStatus() {
        return 0;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public final int getLoopCount() {
        return 0;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public final int getFrameCount() {
        return this.f552316a.length;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public final int getHeight() {
        return this.f552316a[0].f552328e;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public final int getWidth() {
        return this.f552316a[0].f552327d;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public final int getDuration() {
        return this.f552318c;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public final int[] getFrameDurations() {
        return this.f552319d;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public final ImageFormat getImageFormat() {
        return DefaultImageFormats.GIF;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public final int getSizeInBytes() {
        return this.f552317b;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public final AnimatedImageFrame getFrame(int r100) {
        return this.f552316a[r100];
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public final AnimatedDrawableFrameInfo getFrameInfo(int r110) {
        f r100 = this.f552316a[r110];
        r100.getClass();
        return new AnimatedDrawableFrameInfo(r110, 0, 0, r100.f552327d, r100.f552328e, AnimatedDrawableFrameInfo.BlendOperation.BLEND_WITH_PREVIOUS, this.f552316a[r110].f552329f);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public final AnimatedImageFrame getFrameNew(int r100) {
        return this.f552316a[r100];
    }

    public d(f[] r100, int r101, int r102) {
        this.f552316a = r100;
        this.f552317b = r101;
        this.f552318c = r102;
        this.f552319d = new int[r100.length];
        int r103 = r100.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        this.f552319d[r104] = this.f552316a[r104].f552326c;
        r104 = r104 + 1;
        goto L3
    }
}
