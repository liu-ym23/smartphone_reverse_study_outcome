package if5;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bytedance.ee.bear.middleground.comment.image.CommentImageGlideUrl;
import java.io.InputStream;
import okhttp3.Call;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements ModelLoader<CommentImageGlideUrl, InputStream> {
    public final Call.a a;

    public static class a implements ModelLoaderFactory<CommentImageGlideUrl, InputStream> {
        public final Call.a a;

        public final void teardown() {
        }

        public a(lr5.f r1) {
            this.a = r1;
        }

        public final ModelLoader<CommentImageGlideUrl, InputStream> build(MultiModelLoaderFactory r2) {
            return new h(this.a);
        }
    }

    public h(Call.a r1) {
        this.a = r1;
    }

    public final /* bridge */ /* synthetic */ boolean handles(Object r1) {
        CommentImageGlideUrl r2 = (CommentImageGlideUrl) r1;
        return true;
    }

    public final ModelLoader.LoadData buildLoadData(Object r1, int r2, int r3, Options r4) {
        CommentImageGlideUrl r5 = (CommentImageGlideUrl) r1;
        return new ModelLoader.LoadData(r5, new g(this.a, r5));
    }
}
