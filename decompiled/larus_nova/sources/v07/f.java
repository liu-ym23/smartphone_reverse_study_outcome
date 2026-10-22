package v07;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements AnimatedImageFrame {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f552324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f552325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f552326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f552327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f552328e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AnimatedDrawableFrameInfo.DisposalMethod f552329f;

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public final void dispose() {
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public final int getXOffset() {
        return 0;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public final int getYOffset() {
        return 0;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public final int getDurationMs() {
        return this.f552326c;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public final int getHeight() {
        return this.f552328e;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public final int getWidth() {
        return this.f552327d;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageFrame
    public final void renderFrame(int r100, int r101, Bitmap r102) {
        e r103 = this.f552324a;
        int r104 = this.f552325b;
        monitor-enter(r103);
        r103.f552320a.setTime(r104);     // Catch: Throwable -> L15
        Bitmap r105 = r103.f552323d;     // Catch: Throwable -> L15
        if (r105 == null) goto L10;
        if (r105.isRecycled() == false) goto L10;
        r103.f552323d = null;     // Catch: Throwable -> L15
    L10:
        if (r103.f552323d == r102) goto L12;
        r103.f552323d = r102;     // Catch: Throwable -> L15
        r103.f552322c.setBitmap(r102);     // Catch: Throwable -> L15
    L12:
        r103.f552321b.e(r100, r101);     // Catch: Throwable -> L15
        r103.f552322c.save();     // Catch: Throwable -> L15
        r103.f552322c.scale(r103.f552321b.c(), r103.f552321b.c());     // Catch: Throwable -> L15
        r103.f552320a.draw(r103.f552322c, r103.f552321b.b(), r103.f552321b.d());     // Catch: Throwable -> L15
        r103.f552322c.restore();     // Catch: Throwable -> L15
        monitor-exit(r103);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public f(e r100, int r101, int r102, int r103, int r104, AnimatedDrawableFrameInfo.DisposalMethod r105) {
        this.f552324a = r100;
        this.f552325b = r101;
        this.f552326c = r102;
        this.f552327d = r103;
        this.f552328e = r104;
        this.f552329f = r105;
    }
}
