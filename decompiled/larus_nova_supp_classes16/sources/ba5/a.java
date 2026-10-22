package ba5;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.loader.PDFPageModel;
import com.bytedance.ee.plugin.common.ttpdfreader.PagePart;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements DataFetcher<PagePart> {
    public final PDFPageModel a;

    public final void cancel() {
    }

    public final void cleanup() {
    }

    public final Class<PagePart> getDataClass() {
        return PagePart.class;
    }

    public final DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    public a(PDFPageModel r1) {
        this.a = r1;
    }

    public final void loadData(Priority r9, DataFetcher.DataCallback<? super PagePart> r10) {
        tt5.a.h("PDFPageDataFetcher", "loadData, page: " + this.a.getPage() + ", thread: " + ThreadMethodProxy.currentThread());     // Catch: Exception -> L5
        r10.onDataReady(this.a.getPdfReader().loadPageSync(this.a.getPage(), ((float) this.a.getWidth()) * 1.0f, ((float) this.a.getHeight()) * 1.0f, this.a.getBounds(), this.a.getBestQuality(), this.a.getAnnotationRendering()));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e("PDFPageDataFetcher", "loadPageSync err. ", e, false);
        r10.onLoadFailed(e);
    }
}
