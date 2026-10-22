package tsb;

import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.ss.android.lark.newemoji.loader.EmojiImageResource;
import java.io.InputStream;
import rkb.d;
import rkb.e;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements d<EmojiImageResource, InputStream> {

    public static class a implements e<EmojiImageResource, InputStream> {
        public a() {
        }

        @Override // rkb.e
        public final void teardown() {
        }

        @Override // rkb.e
        public final d<EmojiImageResource, InputStream> build(MultiModelLoaderFactory r100) {
            return new b();
        }
    }

    public b() {
    }

    @Override // rkb.d
    public final rkb.a<InputStream> getResourceFetcher(EmojiImageResource r100, int r101, int r102) {
        return new tsb.a(r100.getImageKey());
    }
}
