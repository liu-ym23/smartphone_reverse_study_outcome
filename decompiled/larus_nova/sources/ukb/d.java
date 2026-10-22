package ukb;

import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.cache.CacheSink;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements ResourceEncoder {
    public d() {
    }

    @Override // com.bumptech.glide.load.Encoder
    public final boolean encode(Object r100, CacheSink r101, Options r102) {
        return false;
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public final EncodeStrategy getEncodeStrategy(Options r100) {
        return EncodeStrategy.SOURCE;
    }
}
