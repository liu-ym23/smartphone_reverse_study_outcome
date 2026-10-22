package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;

/* JADX INFO: loaded from: classes23.dex */
public class AddImageTransformMetaDataProducer implements Producer<EncodedImage> {
    private final Producer<EncodedImage> mInputProducer;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class AddImageTransformMetaDataConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private AddImageTransformMetaDataConsumer(Consumer<EncodedImage> r100) {
            super(r100);
        }

        public /* synthetic */ AddImageTransformMetaDataConsumer(Consumer r100, AnonymousClass1 r101) {
            this(r100);
        }

        public void onNewResultImpl(EncodedImage r100, int r101) {
            if (r100 != null) goto L6;
            getConsumer().onNewResult(null, r101);
            return;
        L6:
            if (EncodedImage.isMetaDataAvailable(r100) == true) goto L8;
            r100.parseMetaData();
        L8:
            getConsumer().onNewResult(r100, r101);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public /* bridge */ /* synthetic */ void onNewResultImpl(Object r100, int r101) {
            onNewResultImpl((EncodedImage) r100, r101);
        }
    }

    public AddImageTransformMetaDataProducer(Producer<EncodedImage> r100) {
        this.mInputProducer = r100;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> r100, ProducerContext r101) {
        this.mInputProducer.produceResults(new AddImageTransformMetaDataConsumer(r100, null), r101);
    }
}
