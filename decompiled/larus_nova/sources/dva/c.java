package dva;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.caverock.androidsvg.SVG;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements ResourceDecoder<ByteBuffer, SVG> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f470227a;

    public c(f r100) {
        Intrinsics.checkNotNullParameter(r100, "streamSvgDecoder");
        this.f470227a = r100;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final boolean handles(ByteBuffer r100, Options r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "options");
        return true;
    }

    public final Resource<SVG> a(ByteBuffer r100, int r101, int r102, Options r103) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r103, "options");
        int r104 = r100.remaining();
        byte[] r105 = new byte[r104];
        r100.get(r105, 0, r104);
        ByteArrayInputStream r106 = new ByteArrayInputStream(r105);
        return this.f470227a.a(r106, r101, r102, r103);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* bridge */ /* synthetic */ Resource<SVG> decode(ByteBuffer r100, int r101, int r102, Options r103) {
        return a(r100, r101, r102, r103);
    }
}
