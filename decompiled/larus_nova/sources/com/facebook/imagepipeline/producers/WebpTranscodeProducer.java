package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.nativecode.WebpTranscoder;
import com.facebook.imagepipeline.nativecode.WebpTranscoderFactory;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class WebpTranscodeProducer implements Producer<EncodedImage> {
    private static final int DEFAULT_JPEG_QUALITY = 80;
    public static final String PRODUCER_NAME = "WebpTranscodeProducer";
    private final Executor mExecutor;
    private final Producer<EncodedImage> mInputProducer;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    public class WebpTranscodeConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private final ProducerContext mContext;
        private TriState mShouldTranscodeWhenFinished;
        final /* synthetic */ WebpTranscodeProducer this$0;

        public void onNewResultImpl(@Nullable EncodedImage r100, int r101) {
            if (this.mShouldTranscodeWhenFinished != TriState.UNSET) goto L7;
            if (r100 == null) goto L7;
            this.mShouldTranscodeWhenFinished = WebpTranscodeProducer.access$000(r100);
        L7:
            if (this.mShouldTranscodeWhenFinished != TriState.NO) goto L11;
            getConsumer().onNewResult(r100, r101);
            return;
        L11:
            if (BaseConsumer.isLast(r101) == true) goto L13;
            return;
        L13:
            if (this.mShouldTranscodeWhenFinished != TriState.YES) goto L16;
            if (r100 == null) goto L16;
            WebpTranscodeProducer.access$100(this.this$0, r100, getConsumer(), this.mContext);
            return;
        L16:
            getConsumer().onNewResult(r100, r101);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public /* bridge */ /* synthetic */ void onNewResultImpl(@Nullable Object r100, int r101) {
            onNewResultImpl((EncodedImage) r100, r101);
        }

        public WebpTranscodeConsumer(WebpTranscodeProducer r100, Consumer<EncodedImage> r101, ProducerContext r102) {
            this.this$0 = r100;
            super(r101);
            this.mContext = r102;
            this.mShouldTranscodeWhenFinished = TriState.UNSET;
        }
    }

    public static /* synthetic */ TriState access$000(EncodedImage r100) {
        return shouldTranscode(r100);
    }

    public static /* synthetic */ PooledByteBufferFactory access$200(WebpTranscodeProducer r100) {
        return r100.mPooledByteBufferFactory;
    }

    private static TriState shouldTranscode(EncodedImage r100) {
        Preconditions.checkNotNull(r100);
        ImageFormat r101 = ImageFormatChecker.getImageFormat_WrapIOException(r100.getInputStream());
        if (DefaultImageFormats.isStaticWebpFormat(r101) == false) goto L11;
        WebpTranscoder r102 = WebpTranscoderFactory.getWebpTranscoder();
        if (r102 != null) goto L9;
        return TriState.NO;
    L9:
        return TriState.valueOf(!r102.isWebpNativelySupported(r101));
    L11:
        if (r101 != ImageFormat.UNKNOWN) goto L15;
        return TriState.UNSET;
    L15:
        return TriState.NO;
    }

    public static /* synthetic */ void access$300(EncodedImage r100, PooledByteBufferOutputStream r101) throws Exception {
        doTranscode(r100, r101);
    }

    private static void doTranscode(EncodedImage r100, PooledByteBufferOutputStream r101) throws Exception {
        InputStream r102 = r100.getInputStream();
        ImageFormat r103 = ImageFormatChecker.getImageFormat_WrapIOException(r102);
        if (r103 != DefaultImageFormats.WEBP_SIMPLE) goto L5;
    L15:
        WebpTranscoderFactory.getWebpTranscoder().transcodeWebpToJpeg(r102, r101, 80);
        r100.setImageFormat(DefaultImageFormats.JPEG);
        return;
    L5:
        if (r103 == DefaultImageFormats.WEBP_EXTENDED) goto L15;
        if (r103 != DefaultImageFormats.WEBP_LOSSLESS) goto L10;
    L14:
        WebpTranscoderFactory.getWebpTranscoder().transcodeWebpToPng(r102, r101);
        r100.setImageFormat(DefaultImageFormats.PNG);
        return;
    L10:
        if (r103 == DefaultImageFormats.WEBP_EXTENDED_WITH_ALPHA) goto L14;
        throw new IllegalArgumentException("Wrong image format");
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> r100, ProducerContext r101) {
        this.mInputProducer.produceResults(new WebpTranscodeConsumer(this, r100, r101), r101);
    }

    public WebpTranscodeProducer(Executor r100, PooledByteBufferFactory r101, Producer<EncodedImage> r102) {
        this.mExecutor = (Executor) Preconditions.checkNotNull(r100);
        this.mPooledByteBufferFactory = (PooledByteBufferFactory) Preconditions.checkNotNull(r101);
        this.mInputProducer = (Producer) Preconditions.checkNotNull(r102);
    }

    private void transcodeLastResult(EncodedImage r100, final Consumer<EncodedImage> r110, ProducerContext r111) {
        Preconditions.checkNotNull(r100);
        final EncodedImage r101 = EncodedImage.cloneOrNull(r100);
        final ProducerListener r102 = r111.getListener();
        final String r103 = PRODUCER_NAME;
        final String r104 = r111.getId();
        final int r105 = Priority.getIntPriorityValue(r111.getPriority());
        StatefulPriorityProducerRunnable<EncodedImage> r106 = new AnonymousClass1(this, r110, r102, r103, r104, r105, r101);
        this.mExecutor.execute(r106);
    }

    public static /* synthetic */ void access$100(WebpTranscodeProducer r100, EncodedImage r101, Consumer r102, ProducerContext r103) {
        r100.transcodeLastResult(r101, r102, r103);
    }
}
