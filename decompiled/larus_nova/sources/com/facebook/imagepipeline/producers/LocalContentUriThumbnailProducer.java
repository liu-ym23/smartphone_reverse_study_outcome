package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.os.CancellationSignal;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public class LocalContentUriThumbnailProducer implements Producer<CloseableReference<CloseableImage>> {
    private static final String CREATED_THUMBNAIL = "createdThumbnail";
    public static final String PRODUCER_NAME = "LocalThumbnailBitmapProducer";
    private final ContentResolver mContentResolver;
    private final Executor mExecutor;

    public static /* synthetic */ ContentResolver access$000(LocalContentUriThumbnailProducer r100) {
        return r100.mContentResolver;
    }

    public LocalContentUriThumbnailProducer(Executor r100, ContentResolver r101) {
        this.mExecutor = r100;
        this.mContentResolver = r101;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(final Consumer<CloseableReference<CloseableImage>> r110, ProducerContext r111) {
        final ProducerListener r100 = r111.getListener();
        final String r101 = r111.getId();
        final ImageRequest r102 = r111.getImageRequest();
        final CancellationSignal r103 = new CancellationSignal();
        final String r104 = PRODUCER_NAME;
        final StatefulProducerRunnable<CloseableReference<CloseableImage>> r112 = new AnonymousClass1(this, r110, r100, r104, r101, r100, r101, r102, r103);
        r111.addCallbacks(new AnonymousClass2(this, r112));
        this.mExecutor.execute(r112);
    }
}
