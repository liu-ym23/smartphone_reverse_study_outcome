package dva;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.caverock.androidsvg.SVG;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements ResourceDecoder<InputStream, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f470229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f470230b;

    public e(f r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "streamSvgDecoder");
        Intrinsics.checkNotNullParameter(r101, "svgBitmapTranscoder");
        this.f470229a = r100;
        this.f470230b = r101;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final boolean handles(InputStream r100, Options r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "options");
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final Resource<Bitmap> decode(InputStream r100, int r101, int r102, Options r103) {
        InputStream r104 = r100;
        Intrinsics.checkNotNullParameter(r104, "source");
        Intrinsics.checkNotNullParameter(r103, "options");
        Resource<SVG> r105 = this.f470229a.a(r104, r101, r102, r103);
        return this.f470230b.transcode(r105, r103);
    }
}
