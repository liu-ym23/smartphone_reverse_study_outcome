package go5;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bytedance.ee.util.glide.BearGlideUrl;
import java.io.InputStream;
import lr5.f;
import okhttp3.Call;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements ModelLoader<BearGlideUrl, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Call.a f481922a;

    public static class a implements ModelLoaderFactory<BearGlideUrl, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Call.a f481923a;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final void teardown() {
        }

        public a(f r100) {
            this.f481923a = r100;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<BearGlideUrl, InputStream> build(MultiModelLoaderFactory r100) {
            return new b(this.f481923a);
        }
    }

    public b(Call.a r100) {
        this.f481922a = r100;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* bridge */ /* synthetic */ boolean handles(BearGlideUrl r100) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData<InputStream> buildLoadData(BearGlideUrl r100, int r101, int r102, Options r103) {
        BearGlideUrl r104 = r100;
        return new ModelLoader.LoadData(r104, new go5.a(this.f481922a, r104));
    }
}
