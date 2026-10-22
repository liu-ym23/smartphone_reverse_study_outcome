package dva;

import android.graphics.drawable.PictureDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.caverock.androidsvg.SVG;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class h implements ResourceTranscoder<SVG, PictureDrawable> {
    public h() {
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public final Resource<PictureDrawable> transcode(Resource<SVG> r100, Options r101) {
        Intrinsics.checkNotNullParameter(r100, "toTranscode");
        Intrinsics.checkNotNullParameter(r101, "options");
        return new SimpleResource(new PictureDrawable(r100.get().g(null)));
    }
}
