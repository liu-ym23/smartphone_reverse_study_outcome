package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class CloseableProducerToDataSourceAdapter<T> extends AbstractProducerToDataSourceAdapter<CloseableReference<T>> {
    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    @Nullable
    public CloseableReference<T> getResult() {
        return CloseableReference.cloneOrNull((CloseableReference) super.getResult());
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    @Nullable
    public /* bridge */ /* synthetic */ Object getResult() {
        return getResult();
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public /* bridge */ /* synthetic */ void closeResult(Object r100) {
        closeResult((CloseableReference) r100);
    }

    public void closeResult(CloseableReference<T> r100) {
        CloseableReference.closeSafely(r100);
    }

    public void onNewResultImpl(CloseableReference<T> r100, int r101) {
        super.onNewResultImpl(CloseableReference.cloneOrNull(r100), r101);
    }

    @Override // com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter
    public /* bridge */ /* synthetic */ void onNewResultImpl(Object r100, int r101) {
        onNewResultImpl((CloseableReference) r100, r101);
    }

    private CloseableProducerToDataSourceAdapter(Producer<CloseableReference<T>> r100, SettableProducerContext r101, RequestListener r102) {
        super(r100, r101, r102);
    }

    public static <T> DataSource<CloseableReference<T>> create(Producer<CloseableReference<T>> r100, SettableProducerContext r101, RequestListener r102) {
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("CloseableProducerToDataSourceAdapter#create");
    L5:
        CloseableProducerToDataSourceAdapter r103 = new CloseableProducerToDataSourceAdapter(r100, r101, r102);
        if (FrescoSystrace.isTracing() == false) goto L8;
        FrescoSystrace.endSection();
    L8:
        return r103;
    }
}
