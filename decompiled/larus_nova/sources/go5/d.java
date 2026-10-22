package go5;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.io.InputStream;
import lr5.f;
import okhttp3.Call;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements ModelLoader<ThumbGlideUrl, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Call.a f481931a;

    public static class a implements ModelLoaderFactory<ThumbGlideUrl, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Call.a f481932a;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final void teardown() {
        }

        public a(f r100) {
            this.f481932a = r100;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<ThumbGlideUrl, InputStream> build(MultiModelLoaderFactory r100) {
            return new d(this.f481932a);
        }
    }

    public d(Call.a r100) {
        this.f481931a = r100;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* bridge */ /* synthetic */ boolean handles(ThumbGlideUrl r100) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData<InputStream> buildLoadData(ThumbGlideUrl r100, int r101, int r102, Options r103) {
        ThumbGlideUrl r104 = r100;
        return new ModelLoader.LoadData(r104, new c(this.f481931a, r104));
    }
}
