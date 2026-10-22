package com.facebook.imagepipeline.producers;

import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;

/* JADX INFO: loaded from: classes23.dex */
public class RemoveImageTransformMetaDataProducer implements Producer<CloseableReference<PooledByteBuffer>> {
    private final Producer<EncodedImage> mInputProducer;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class RemoveImageTransformMetaDataConsumer extends DelegatingConsumer<EncodedImage, CloseableReference<PooledByteBuffer>> {
        final /* synthetic */ RemoveImageTransformMetaDataProducer this$0;

        private RemoveImageTransformMetaDataConsumer(RemoveImageTransformMetaDataProducer r100, Consumer<CloseableReference<PooledByteBuffer>> r101) {
            this.this$0 = r100;
            super(r101);
        }

        public void onNewResultImpl(EncodedImage r100, int r101) {
            CloseableReference<PooledByteBuffer> r102 = null;
        L9:
            th = move-exception;
            CloseableReference.closeSafely(r102);
            throw th;
        L4:
            if (EncodedImage.isValid(r100) == false) goto L6;
            r102 = r100.getByteBufferRef();     // Catch: Throwable -> L9
        L6:
            getConsumer().onNewResult(r102, r101);     // Catch: Throwable -> L9
            CloseableReference.closeSafely(r102);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public /* bridge */ /* synthetic */ void onNewResultImpl(Object r100, int r101) {
            onNewResultImpl((EncodedImage) r100, r101);
        }

        public /* synthetic */ RemoveImageTransformMetaDataConsumer(RemoveImageTransformMetaDataProducer r100, Consumer r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public RemoveImageTransformMetaDataProducer(Producer<EncodedImage> r100) {
        this.mInputProducer = r100;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<PooledByteBuffer>> r100, ProducerContext r101) {
        this.mInputProducer.produceResults(new RemoveImageTransformMetaDataConsumer(this, r100, null), r101);
    }
}
