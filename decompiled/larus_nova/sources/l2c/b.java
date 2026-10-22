package l2c;

import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.ss.android.lark.reaction.loader.reaction.ReactionResource;
import java.io.InputStream;
import rkb.d;
import rkb.e;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements d<ReactionResource, InputStream> {

    public static class a implements e<ReactionResource, InputStream> {
        public a() {
        }

        @Override // rkb.e
        public final void teardown() {
        }

        @Override // rkb.e
        public final d<ReactionResource, InputStream> build(MultiModelLoaderFactory r100) {
            return new b();
        }
    }

    public b() {
    }

    @Override // rkb.d
    public final rkb.a<InputStream> getResourceFetcher(ReactionResource r100, int r101, int r102) {
        return new l2c.a(r100.reactionKey);
    }
}
