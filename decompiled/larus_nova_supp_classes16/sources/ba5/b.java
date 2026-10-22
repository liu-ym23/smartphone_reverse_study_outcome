package ba5;

import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bytedance.ee.plugin.common.ttpdfreader.PagePart;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements ResourceDecoder<PagePart, Bitmap> {
    public b() {
    }

    public final /* bridge */ /* synthetic */ boolean handles(Object r1, Options r2) throws IOException {
        PagePart r3 = (PagePart) r1;
        return true;
    }

    public final Resource decode(Object r1, int r2, int r3, Options r4) throws IOException {
        return BitmapResource.obtain(((PagePart) r1).getRenderedBitmap(), Glide.get(eu5.b.a).getBitmapPool());
    }
}
