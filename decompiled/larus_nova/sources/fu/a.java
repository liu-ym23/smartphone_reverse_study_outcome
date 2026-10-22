package fu;

import android.graphics.Bitmap;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {
    static {
    }

    public static ImageRequest a(String r100, ResizeOptions r101, Priority r102, Bitmap.Config r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = Priority.MEDIUM;
    L9:
        if ((r104 & 16) == 0) goto L11;
        r103 = Bitmap.Config.ARGB_8888;
    L11:
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r102, "priority");
        ImageDecodeOptionsBuilder r105 = new ImageDecodeOptionsBuilder();
        r105.setBitmapConfig(r103);
        r105.setPreDecodeFrameCount(1);
        r105.setDecodeAllFrames(false);
        ImageDecodeOptions r106 = new ImageDecodeOptions(r105);
        ImageRequestBuilder r107 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r100)).setRequestPriority(r102).setImageDecodeOptions(r106);
        if (r101 == null) goto L15;
        r107.setResizeOptions(r101);
    L15:
        return r107.build();
    }
}
