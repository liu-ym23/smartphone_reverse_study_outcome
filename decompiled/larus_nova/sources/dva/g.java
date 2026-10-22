package dva;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.caverock.androidsvg.SVG;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g implements ResourceTranscoder<SVG, Bitmap> {
    public g() {
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public final Resource<Bitmap> transcode(Resource<SVG> r100, Options r101) {
        Intrinsics.checkNotNullParameter(r100, "toTranscode");
        Intrinsics.checkNotNullParameter(r101, "options");
        return new a(r100);
    }
}
