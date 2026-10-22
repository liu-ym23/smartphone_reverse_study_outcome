package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes23.dex */
public class BranchOnSeparateImagesProducer implements Producer<EncodedImage> {
    private final Producer<EncodedImage> mInputProducer1;
    private final Producer<EncodedImage> mInputProducer2;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class OnFirstImageConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private ProducerContext mProducerContext;
        final /* synthetic */ BranchOnSeparateImagesProducer this$0;

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable r100) {
            BranchOnSeparateImagesProducer.access$100(this.this$0).produceResults(getConsumer(), this.mProducerContext);
        }

        public void onNewResultImpl(EncodedImage r100, int r101) {
            ImageRequest r102 = this.mProducerContext.getImageRequest();
            boolean r103 = BaseConsumer.isLast(r101);
            boolean r104 = ThumbnailSizeChecker.isImageBigEnough(r100, r102.getResizeOptions());
            if (r100 == null) goto L11;
            if (r104 == false) goto L6;
        L7:
            if (r103 == false) goto L10;
            if (r104 == false) goto L10;
            getConsumer().onNewResult(r100, r101);
        L10:
            int r105 = BaseConsumer.turnOffStatusFlag(r101, 1);
            getConsumer().onNewResult(r100, r105);
            goto L11
        L6:
            if (r102.getLocalThumbnailPreviewsEnabled() == true) goto L7;
        L11:
            if (r103 == false) goto L17;
            if (r104 == false) goto L14;
            return;
        L14:
            if (r102.getLoadThumbnailOnlyForAndroidSdkAboveQ() == true) goto L19;
            EncodedImage.closeSafely(r100);
            BranchOnSeparateImagesProducer.access$100(this.this$0).produceResults(getConsumer(), this.mProducerContext);
            return;
        L19:
            return;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public /* bridge */ /* synthetic */ void onNewResultImpl(Object r100, int r101) {
            onNewResultImpl((EncodedImage) r100, r101);
        }

        private OnFirstImageConsumer(BranchOnSeparateImagesProducer r100, Consumer<EncodedImage> r101, ProducerContext r102) {
            this.this$0 = r100;
            super(r101);
            this.mProducerContext = r102;
        }

        public /* synthetic */ OnFirstImageConsumer(BranchOnSeparateImagesProducer r100, Consumer r101, ProducerContext r102, AnonymousClass1 r103) {
            this(r100, r101, r102);
        }
    }

    public static /* synthetic */ Producer access$100(BranchOnSeparateImagesProducer r100) {
        return r100.mInputProducer2;
    }

    public BranchOnSeparateImagesProducer(Producer<EncodedImage> r100, Producer<EncodedImage> r101) {
        this.mInputProducer1 = r100;
        this.mInputProducer2 = r101;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> r100, ProducerContext r101) {
        OnFirstImageConsumer r102 = new OnFirstImageConsumer(this, r100, r101, null);
        this.mInputProducer1.produceResults(r102, r101);
    }
}
