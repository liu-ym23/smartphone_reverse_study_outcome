package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;

/* JADX INFO: loaded from: classes23.dex */
public class BitmapPrepareProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String PRODUCER_NAME = "BitmapPrepareProducer";
    private final Producer<CloseableReference<CloseableImage>> mInputProducer;
    private final int mMaxBitmapSizeBytes;
    private final int mMinBitmapSizeBytes;
    private final boolean mPreparePrefetch;

    public static class BitmapPrepareConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        private final int mMaxBitmapSizeBytes;
        private final int mMinBitmapSizeBytes;

        private void internalPrepareBitmap(CloseableReference<CloseableImage> r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r100.isValid() == false) goto L27;
            CloseableImage r101 = r100.get();
            if (r101 != null) goto L9;
            return;
        L9:
            if (r101.isClosed() == false) goto L12;
            return;
        L12:
            if ((r101 instanceof CloseableStaticBitmap) == false) goto L26;
            Bitmap r102 = ((CloseableStaticBitmap) r101).getUnderlyingBitmap();
            if (r102 != null) goto L16;
            return;
        L16:
            int r103 = r102.getRowBytes() * r102.getHeight();
            if (r103 >= this.mMinBitmapSizeBytes) goto L20;
            return;
        L20:
            if (r103 <= this.mMaxBitmapSizeBytes) goto L22;
            return;
        L22:
            r102.prepareToDraw();
            return;
        L26:
            return;
        }

        public void onNewResultImpl(CloseableReference<CloseableImage> r100, int r101) {
            internalPrepareBitmap(r100);
            getConsumer().onNewResult(r100, r101);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public /* bridge */ /* synthetic */ void onNewResultImpl(Object r100, int r101) {
            onNewResultImpl((CloseableReference) r100, r101);
        }

        public BitmapPrepareConsumer(Consumer<CloseableReference<CloseableImage>> r100, int r101, int r102) {
            super(r100);
            this.mMinBitmapSizeBytes = r101;
            this.mMaxBitmapSizeBytes = r102;
        }
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> r100, ProducerContext r101) {
        if (r101.isPrefetch() == true) goto L5;
    L7:
        this.mInputProducer.produceResults(new BitmapPrepareConsumer(r100, this.mMinBitmapSizeBytes, this.mMaxBitmapSizeBytes), r101);
        return;
    L5:
        if (this.mPreparePrefetch == true) goto L7;
        this.mInputProducer.produceResults(r100, r101);
    }

    public BitmapPrepareProducer(Producer<CloseableReference<CloseableImage>> r100, int r101, int r102, boolean r103) {
        if (r101 > r102) goto L5;
        boolean r104 = true;
    L6:
        Preconditions.checkArgument(r104);
        this.mInputProducer = (Producer) Preconditions.checkNotNull(r100);
        this.mMinBitmapSizeBytes = r101;
        this.mMaxBitmapSizeBytes = r102;
        this.mPreparePrefetch = r103;
        return;
    L5:
        r104 = false;
        goto L6
    }
}
