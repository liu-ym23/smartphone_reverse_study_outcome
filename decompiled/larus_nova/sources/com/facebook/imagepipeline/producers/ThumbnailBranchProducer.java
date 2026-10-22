package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;

/* JADX INFO: loaded from: classes23.dex */
public class ThumbnailBranchProducer implements Producer<EncodedImage> {
    private final ThumbnailProducer<EncodedImage>[] mThumbnailProducers;

    public class ThumbnailConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private final ProducerContext mProducerContext;
        private final int mProducerIndex;
        private final ResizeOptions mResizeOptions;
        final /* synthetic */ ThumbnailBranchProducer this$0;

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable r100) {
            if (ThumbnailBranchProducer.access$000(this.this$0, this.mProducerIndex + 1, getConsumer(), this.mProducerContext) == true) goto L6;
            getConsumer().onFailure(r100);
            return;
        }

        public void onNewResultImpl(EncodedImage r100, int r101) {
            if (r100 == null) goto L9;
            if (BaseConsumer.isNotLast(r101) == false) goto L6;
        L7:
            getConsumer().onNewResult(r100, r101);
            return;
        L6:
            if (ThumbnailSizeChecker.isImageBigEnough(r100, this.mResizeOptions) == true) goto L7;
        L9:
            if (BaseConsumer.isLast(r101) == false) goto L15;
            EncodedImage.closeSafely(r100);
            if (ThumbnailBranchProducer.access$000(this.this$0, this.mProducerIndex + 1, getConsumer(), this.mProducerContext) == true) goto L16;
            getConsumer().onNewResult(null, 1);
            return;
        L16:
            return;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public /* bridge */ /* synthetic */ void onNewResultImpl(Object r100, int r101) {
            onNewResultImpl((EncodedImage) r100, r101);
        }

        public ThumbnailConsumer(ThumbnailBranchProducer r100, Consumer<EncodedImage> r101, ProducerContext r102, int r103) {
            this.this$0 = r100;
            super(r101);
            this.mProducerContext = r102;
            this.mProducerIndex = r103;
            this.mResizeOptions = r102.getImageRequest().getResizeOptions();
        }
    }

    public ThumbnailBranchProducer(ThumbnailProducer<EncodedImage>... r100) {
        ThumbnailProducer<EncodedImage>[] r101 = (ThumbnailProducer[]) Preconditions.checkNotNull(r100);
        this.mThumbnailProducers = r101;
        Preconditions.checkElementIndex(0, r101.length);
    }

    private int findFirstProducerForSize(int r100, ResizeOptions r101) {
    L2:
        ThumbnailProducer<EncodedImage>[] r102 = this.mThumbnailProducers;
        if (r100 >= r102.length) goto L8;
        if (r102[r100].canProvideImageForSize(r101) == true) goto L6;
        r100 = r100 + 1;
        goto L2
    L6:
        return r100;
    L8:
        return -1;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> r100, ProducerContext r101) {
        if (r101.getImageRequest().getResizeOptions() != null) goto L6;
        r100.onNewResult(null, 1);
        return;
    L6:
        if (produceResultsFromThumbnailProducer(0, r100, r101) == true) goto L10;
        r100.onNewResult(null, 1);
        return;
    }

    private boolean produceResultsFromThumbnailProducer(int r100, Consumer<EncodedImage> r101, ProducerContext r102) {
        int r103 = findFirstProducerForSize(r100, r102.getImageRequest().getResizeOptions());
        if (r103 != (-1)) goto L6;
        return false;
    L6:
        this.mThumbnailProducers[r103].produceResults(new ThumbnailConsumer(this, r101, r102, r103), r102);
        return true;
    }

    public static /* synthetic */ boolean access$000(ThumbnailBranchProducer r100, int r101, Consumer r102, ProducerContext r103) {
        return r100.produceResultsFromThumbnailProducer(r101, r102, r103);
    }
}
