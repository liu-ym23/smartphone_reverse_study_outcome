package com.facebook.imagepipeline.datasource;

import com.facebook.common.internal.Preconditions;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.BaseConsumer;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.request.HasImageRequest;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbstractProducerToDataSourceAdapter<T> extends AbstractDataSource<T> implements HasImageRequest {
    private final RequestListener mRequestListener;
    private final SettableProducerContext mSettableProducerContext;

    private synchronized void onCancellationImpl() {
        monitor-enter(this);
        Preconditions.checkState(isClosed());     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private Consumer<T> createConsumer() {
        return new AnonymousClass1(this);
    }

    @Override // com.facebook.imagepipeline.request.HasImageRequest
    public ImageRequest getImageRequest() {
        return this.mSettableProducerContext.getImageRequest();
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public boolean close() {
        if (super.close() == true) goto L7;
        return false;
    L7:
        if (super.isFinished() == true) goto L11;
        this.mRequestListener.onRequestCancellation(this.mSettableProducerContext.getId());
        this.mSettableProducerContext.cancel();
        return true;
    L11:
        return true;
    }

    public static /* synthetic */ void access$100(AbstractProducerToDataSourceAdapter r100) {
        r100.onCancellationImpl();
    }

    private void onFailureImpl(Throwable r100) {
        if (super.setFailure(r100) == false) goto L6;
        this.mRequestListener.onRequestFailure(this.mSettableProducerContext.getImageRequest(), this.mSettableProducerContext.getId(), r100, this.mSettableProducerContext.isPrefetch());
        return;
    }

    public static /* synthetic */ void access$000(AbstractProducerToDataSourceAdapter r100, Throwable r101) {
        r100.onFailureImpl(r101);
    }

    public static /* synthetic */ boolean access$200(AbstractProducerToDataSourceAdapter r100, float r101) {
        return r100.setProgress(r101);
    }

    public void onNewResultImpl(@Nullable T r100, int r101) {
        boolean r102 = BaseConsumer.isLast(r101);
        if (super.setResult(r100, r102) == false) goto L10;
        if (r102 == false) goto L6;
        this.mRequestListener.onRequestSuccess(this.mSettableProducerContext.getImageRequest(), this.mSettableProducerContext.getId(), this.mSettableProducerContext.isPrefetch());
        return;
    L6:
        RequestListener r103 = this.mRequestListener;
        if ((r103 instanceof BaseRequestListener) == false) goto L12;
        ((BaseRequestListener) r103).onRequestIntermediateResult(this.mSettableProducerContext.getImageRequest(), this.mSettableProducerContext.getId(), this.mSettableProducerContext.isPrefetch());
        return;
    L12:
        return;
    }

    public AbstractProducerToDataSourceAdapter(Producer<T> r100, SettableProducerContext r101, RequestListener r102) {
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()");
    L5:
        this.mSettableProducerContext = r101;
        if (r101 != null) goto L8;
    L12:
        setOptOnNewResultMsg(false);
    L13:
        setCallerContext(r101.getCallerContext());
        this.mRequestListener = r102;
        if (FrescoSystrace.isTracing() == false) goto L16;
        FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->onRequestStart");
    L16:
        r102.onRequestStart(r101.getImageRequest(), r101.getCallerContext(), r101.getId(), r101.isPrefetch());
        if (FrescoSystrace.isTracing() == false) goto L20;
        FrescoSystrace.endSection();
    L20:
        if (FrescoSystrace.isTracing() == false) goto L22;
        FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->produceResult");
    L22:
        r100.produceResults(createConsumer(), r101);
        if (FrescoSystrace.isTracing() == false) goto L26;
        FrescoSystrace.endSection();
    L26:
        if (FrescoSystrace.isTracing() == false) goto L29;
        FrescoSystrace.endSection();
        return;
    L29:
        return;
    L8:
        if (r101.getImageRequest() == null) goto L12;
        if (r101.getImageRequest().isOptOnNewResultMsg() == false) goto L12;
        setOptOnNewResultMsg(true);
        goto L13
    }
}
