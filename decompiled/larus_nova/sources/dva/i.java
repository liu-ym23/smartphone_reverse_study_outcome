package dva;

import android.graphics.Bitmap;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.CacheSink;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.byted.cast.common.Constants;
import com.caverock.androidsvg.SVG;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class i implements ResourceEncoder<SVG> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResourceEncoder<Bitmap> f470231a;

    public i(BitmapEncoder r100) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        this.f470231a = r100;
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public final EncodeStrategy getEncodeStrategy(Options r100) {
        Intrinsics.checkNotNullParameter(r100, "options");
        return this.f470231a.getEncodeStrategy(r100);
    }

    @Override // com.bumptech.glide.load.Encoder
    public final boolean encode(Object r100, CacheSink r101, Options r102) {
        Resource r103 = (Resource) r100;
        Intrinsics.checkNotNullParameter(r103, "data");
        Intrinsics.checkNotNullParameter(r101, Constants.ROLE_SINK);
        Intrinsics.checkNotNullParameter(r102, "options");
        Intrinsics.checkNotNullParameter(r103, "toTranscode");
        Intrinsics.checkNotNullParameter(r102, "options");
        a r104 = new a(r103);
        return this.f470231a.encode(r104, r101, r102);
    }
}
