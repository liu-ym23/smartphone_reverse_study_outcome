package if5;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bytedance.ee.bear.middleground.comment.image.CommentImageGlideUrl;
import java.io.InputStream;
import okhttp3.Call;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements ModelLoader<CommentImageGlideUrl, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Call.a f489592a;

    public static class a implements ModelLoaderFactory<CommentImageGlideUrl, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Call.a f489593a;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final void teardown() {
        }

        public a(lr5.f r100) {
            this.f489593a = r100;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<CommentImageGlideUrl, InputStream> build(MultiModelLoaderFactory r100) {
            return new h(this.f489593a);
        }
    }

    public h(Call.a r100) {
        this.f489592a = r100;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* bridge */ /* synthetic */ boolean handles(CommentImageGlideUrl r100) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData<InputStream> buildLoadData(CommentImageGlideUrl r100, int r101, int r102, Options r103) {
        CommentImageGlideUrl r104 = r100;
        return new ModelLoader.LoadData(r104, new g(this.f489592a, r104));
    }
}
