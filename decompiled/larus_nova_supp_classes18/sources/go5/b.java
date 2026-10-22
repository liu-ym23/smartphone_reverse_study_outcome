package go5;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bytedance.ee.util.glide.BearGlideUrl;
import java.io.InputStream;
import lr5.f;
import okhttp3.Call;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements ModelLoader<BearGlideUrl, InputStream> {
    public final Call.a a;

    public static class a implements ModelLoaderFactory<BearGlideUrl, InputStream> {
        public final Call.a a;

        public final void teardown() {
        }

        public a(f r1) {
            this.a = r1;
        }

        public final ModelLoader<BearGlideUrl, InputStream> build(MultiModelLoaderFactory r2) {
            return new b(this.a);
        }
    }

    public b(Call.a r1) {
        this.a = r1;
    }

    public final /* bridge */ /* synthetic */ boolean handles(Object r1) {
        BearGlideUrl r2 = (BearGlideUrl) r1;
        return true;
    }

    public final ModelLoader.LoadData buildLoadData(Object r1, int r2, int r3, Options r4) {
        BearGlideUrl r5 = (BearGlideUrl) r1;
        return new ModelLoader.LoadData(r5, new go5.a(this.a, r5));
    }
}
