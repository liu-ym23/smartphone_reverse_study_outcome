package dva;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import com.ss.android.lark.log.Log;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements ResourceDecoder<InputStream, SVG> {

    public static final class a {
    }

    static {
    }

    public f() {
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final boolean handles(InputStream r100, Options r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "options");
        return true;
    }

    public final Resource<SVG> a(InputStream r100, int r101, int r102, Options r103) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r103, "options");
        SVG r104 = SVG.d(new d(r100));     // Catch: SVGParseException -> L20
        Log.d("StreamSvgDecoder", "width: " + r101 + ", height: " + r102);     // Catch: SVGParseException -> L20
        if (r101 == Integer.MIN_VALUE) goto L12;
        float r105 = r101;
        SVG.d0 r106 = r104.f272756a;     // Catch: SVGParseException -> L20
        if (r106 == null) goto L11;
        r106.f272833s = new SVG.o(r105);     // Catch: SVGParseException -> L20
        goto L12
    L11:
        throw new IllegalArgumentException("SVG document is empty");     // Catch: SVGParseException -> L20
    L12:
        if (r102 == Integer.MIN_VALUE) goto L19;
        float r107 = r102;
        SVG.d0 r108 = r104.f272756a;     // Catch: SVGParseException -> L20
        if (r108 == null) goto L17;
        r108.f272834t = new SVG.o(r107);     // Catch: SVGParseException -> L20
        goto L19
    L17:
        throw new IllegalArgumentException("SVG document is empty");     // Catch: SVGParseException -> L20
    L19:
        return new SimpleResource(r104);
    L20:
        e = move-exception;
        Log.e("StreamSvgDecoder", "StreamSvgDecoder.decode throw Exception, " + e);
        throw new IOException("Cannot load SVG from stream", e);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* bridge */ /* synthetic */ Resource<SVG> decode(InputStream r100, int r101, int r102, Options r103) {
        return a(r100, r101, r102, r103);
    }
}
