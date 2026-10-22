package p50;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.fresco.animation.bitmap.cache.NoOpCache;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f527745a;

    public c() {
        this.f527745a = new Handler(Looper.getMainLooper());
    }

    public final void b(Uri r100, Function4<? super Uri, ? super Bitmap, ? super Integer, ? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequest.fromUri(r100), "animatedImage").subscribe(new a(this, r101, r100), TTExecutors.getCPUThreadPool());
    }

    public static final void a(c r100, CloseableAnimatedImage r110, Function4 r111, Uri r112, int r113, int r114) {
        r100.getClass();
        if (r110.getImageResult() == null) goto L7;
        AnimatedDrawableBackendFrameRenderer r101 = new AnimatedDrawableBackendFrameRenderer(new NoOpCache(), new AnimatedDrawableBackendImpl(new AnimatedDrawableUtil(), r110.getImageResult(), new Rect(0, 0, r110.getWidth(), r110.getHeight())));
        Bitmap r102 = Bitmap.createBitmap(r110.getWidth(), r110.getHeight(), Bitmap.Config.ARGB_8888);
        r101.renderFrame(r114, r102);
        r100.f527745a.post(new b(r111, r112, r102, r113, r114));
        return;
    }
}
