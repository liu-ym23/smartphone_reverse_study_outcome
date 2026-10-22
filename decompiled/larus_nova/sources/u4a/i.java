package u4a;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.animax.loader.AnimaXLoaderRequest;

/* JADX INFO: loaded from: classes32.dex */
public final class i {

    public interface a {
    }

    public static boolean a(m r100, l r101) {
        AnimaXLoaderRequest r102 = (AnimaXLoaderRequest) r100;
        e r103 = r102.a();
        boolean r104 = false;
        if (r103 != null) goto L5;
        return false;
    L5:
        String r105 = r102.b();
        if (r105 != null) goto L8;
        Uri r106 = null;
    L9:
        int r107 = ((Integer) r103.f548732a).intValue();
        int r108 = ((Integer) r103.f548733b).intValue();
        g r109 = new g(r101);
        ImageRequestBuilder r110 = ImageRequestBuilder.newBuilderWithSource(r106).setImageDecodeOptions(ImageDecodeOptions.newBuilder().setBitmapConfig(Bitmap.Config.ARGB_8888).setForceStaticImage(true).build()).setRequestPriority(Priority.HIGH);
        String r111 = y4a.a.f566160a;
        if (r107 < 32) goto L18;
        if (r108 < 32) goto L18;
        if (y4a.a.c() == false) goto L16;
    L17:
        r104 = true;
        goto L18
    L16:
        if (y4a.a.f566166g == true) goto L17;
    L18:
        if (r104 == false) goto L20;
        r110.setResizeOptions(new ResizeOptions(r107 / 2, r108 / 2));
    L20:
        ImageRequest r112 = r110.build();
        DataSource<CloseableReference<CloseableImage>> r113 = Fresco.getImagePipeline().fetchDecodedImage(r112, "FrescoUtil");
        r113.subscribe(new h(r109, r113), CallerThreadExecutor.getInstance());
        return true;
    L8:
        r106 = UriProtector.parse(r105);
        goto L9
    }
}
