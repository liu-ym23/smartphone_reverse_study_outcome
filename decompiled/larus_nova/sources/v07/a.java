package v07;

import android.graphics.Movie;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements ImageDecoder {
    public a() {
    }

    @Override // com.facebook.imagepipeline.decoder.ImageDecoder
    public final CloseableImage decode(EncodedImage r110, int r111, QualityInfo r112, ImageDecodeOptions r210) {
        InputStream r100 = r110.getInputStream();
        Movie r101 = Movie.decodeStream(r100);     // Catch: Throwable -> L6 IOException -> L8
        e r102 = new e(r101);     // Catch: Throwable -> L6 IOException -> L8
        r100.reset();     // Catch: Throwable -> L6 IOException -> L8
        b r113 = new b(r101);     // Catch: Throwable -> L6 IOException -> L8
        r113.a();     // Catch: Throwable -> L6 IOException -> L8
        int r114 = r113.b();     // Catch: Throwable -> L6 IOException -> L8
        f[] r115 = new f[r114];     // Catch: Throwable -> L6 IOException -> L8
        int r103 = 0;
        int r116 = 0;
    L4:
        if (r116 >= r114) goto L10;
        int r104 = r113.c(r116);     // Catch: Throwable -> L6 IOException -> L8
        int r117 = r103 + r104;     // Catch: Throwable -> L6 IOException -> L8
        r115[r116] = new f(r102, r117, r104, r101.width(), r101.height(), AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT);     // Catch: Throwable -> L6 IOException -> L8
        r116 = r116 + 1;     // Catch: Throwable -> L6 IOException -> L8
        r103 = r117;
        goto L4
    L10:
        CloseableAnimatedImage r105 = new CloseableAnimatedImage(AnimatedImageResult.forAnimatedImage(new d(r115, r110.getSize(), r101.duration())), r210, r110.getImageFormat());     // Catch: Throwable -> L6 IOException -> L8
        r100.close();     // Catch: IOException -> L17
    L12:
        return r105;
    L6:
        th = move-exception;
        r100.close();     // Catch: IOException -> L18
    L16:
        throw th;
    L8:
        e = move-exception;
        throw new RuntimeException("Error while decoding gif", e);     // Catch: Throwable -> L6
    }
}
