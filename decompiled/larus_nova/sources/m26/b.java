package m26;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends BasePostprocessor {
    public b() {
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public final CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101) {
        Intrinsics.checkNotNullParameter(r100, "sourceBitmap");
        Intrinsics.checkNotNullParameter(r101, "bitmapFactory");
        CloseableReference<Bitmap> r102 = null;
        CloseableReference<Bitmap> r103 = r101.createBitmapInternal(r100.getWidth(), r100.getHeight(), Bitmap.Config.RGB_565);     // Catch: Throwable -> L14
        new Canvas(r103.get()).drawBitmap(r100, 0.0f, 0.0f, null);     // Catch: Throwable -> L7
        CloseableReference<Bitmap> r104 = CloseableReference.cloneOrNull(r103);     // Catch: Throwable -> L7
        CloseableReference.closeSafely(r103);
        return r104;
    L7:
        r102 = r103;
    L19:
        f.b("preload fail when makeDefaultRequest");     // Catch: Throwable -> L11
        CloseableReference.closeSafely(r102);
        return super.process(r100, r101);
    L11:
        th = move-exception;
        CloseableReference.closeSafely(r102);
        throw th;
    }
}
