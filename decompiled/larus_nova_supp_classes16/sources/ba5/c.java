package ba5;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.loader.PDFPageModel;
import com.bytedance.ee.plugin.common.ttpdfreader.PagePart;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements ModelLoader<PDFPageModel, PagePart> {

    public static class a implements ModelLoaderFactory<PDFPageModel, PagePart> {
        public a() {
        }

        public final void teardown() {
        }

        public final ModelLoader<PDFPageModel, PagePart> build(MultiModelLoaderFactory r1) {
            return new c();
        }
    }

    public c() {
    }

    public final /* bridge */ /* synthetic */ boolean handles(Object r1) {
        PDFPageModel r2 = (PDFPageModel) r1;
        return true;
    }

    public final ModelLoader.LoadData buildLoadData(Object r1, int r2, int r3, Options r4) {
        PDFPageModel r5 = (PDFPageModel) r1;
        return new ModelLoader.LoadData(r5, new ba5.a(r5));
    }
}
