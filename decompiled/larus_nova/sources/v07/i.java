package v07;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.fresco.heif.HeifDecoder;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;
import java.util.Objects;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements ImageDecoder {
    public i() {
    }

    @Override // com.facebook.imagepipeline.decoder.ImageDecoder
    public final CloseableImage decode(EncodedImage r100, int r101, QualityInfo r102, ImageDecodeOptions r103) {
        BitmapFactory.Options r104 = new BitmapFactory.Options();
        r104.inPreferredConfig = Bitmap.Config.ARGB_8888;
        r104.inPremultiplied = false;
        if (Objects.equals(r100.getImageFormat().getFileExtension(), "heic") == false) goto L5;
        Bitmap r105 = HeifDecoder.sBitmapFactory.decodeStream(r100.getInputStream(), null, r104);
    L7:
        return new CloseableStaticBitmap(r105, SimpleBitmapReleaser.getInstance(), r102, r100.getRotationAngle());
    L5:
        r105 = BitmapFactory.decodeStream(r100.getInputStream(), null, r104);
        goto L7
    }
}
