package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ImageOOMOptStrategy;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessorRunner;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class PostprocessorProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String NAME = "PostprocessorProducer";
    static final String POSTPROCESSOR = "Postprocessor";
    public static final String STRATEGY_CENTER = "strategy_center";
    private final PlatformBitmapFactory mBitmapFactory;
    private final Executor mExecutor;
    private final Producer<CloseableReference<CloseableImage>> mInputProducer;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.producers.PostprocessorProducer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class PostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        private boolean mIsClosed;
        private boolean mIsDirty;
        private boolean mIsPostProcessingRunning;
        private final ProducerListener mListener;
        private final Postprocessor mPostprocessor;
        private final ProducerContext mProducerContext;
        private final String mRequestId;

        @Nullable
        private CloseableReference<CloseableImage> mSourceImageRef;
        private int mStatus;
        final /* synthetic */ PostprocessorProducer this$0;

        private void clearRunningAndStartIfDirty() {
            monitor-enter(this);
            this.mIsPostProcessingRunning = false;     // Catch: Throwable -> L9
            boolean r100 = setRunningIfDirtyAndNotRunning();     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            if (r100 == false) goto L14;
            submitPostprocessing();
            return;
        L14:
            return;
        L9:
            th = move-exception;
            throw th;
        }

        private boolean close() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (this.mIsClosed == false) goto L8;
            monitor-exit(this);     // Catch: Throwable -> L12
            return false;
        L8:
            CloseableReference<CloseableImage> r100 = this.mSourceImageRef;     // Catch: Throwable -> L12
            this.mSourceImageRef = null;     // Catch: Throwable -> L12
            this.mIsClosed = true;     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            CloseableReference.closeSafely(r100);
            return true;
        }

        private synchronized boolean isClosed() {
            monitor-enter(this);
            boolean r100 = this.mIsClosed;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r100;
        L6:
            th = move-exception;
            throw th;
        }

        private synchronized boolean setRunningIfDirtyAndNotRunning() {
            monitor-enter(this);
        L17:
            th = move-exception;
            throw th;
        L4:
            if (this.mIsClosed == false) goto L6;
        L14:
            monitor-exit(this);
            return false;
        L6:
            if (this.mIsDirty == false) goto L14;
            if (this.mIsPostProcessingRunning == true) goto L14;
            if (CloseableReference.isValid(this.mSourceImageRef) == false) goto L14;
            this.mIsPostProcessingRunning = true;     // Catch: Throwable -> L17
            monitor-exit(this);
            return true;
        }

        private void submitPostprocessing() {
            Executor r100 = PostprocessorProducer.access$800(this.this$0);
            final int r101 = Priority.getIntPriorityValue(this.mProducerContext.getPriority());
            r100.execute(new AnonymousClass2(this, r101));
        }

        private void maybeNotifyOnCancellation() {
            if (close() == false) goto L6;
            getConsumer().onCancellation();
            return;
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            maybeNotifyOnCancellation();
        }

        public static /* synthetic */ void access$200(PostprocessorConsumer r100) {
            r100.maybeNotifyOnCancellation();
        }

        public static /* synthetic */ CloseableReference access$300(PostprocessorConsumer r100) {
            return r100.mSourceImageRef;
        }

        public static /* synthetic */ int access$400(PostprocessorConsumer r100) {
            return r100.mStatus;
        }

        public static /* synthetic */ void access$700(PostprocessorConsumer r100) {
            r100.clearRunningAndStartIfDirty();
        }

        private float calScaleRatio(Bitmap r100) {
            if (r100 == null) goto L63;
            ProducerContext r101 = this.mProducerContext;
            if (r101 != null) goto L7;
            return 1.0f;
        L7:
            if (r101.getImageRequest() == null) goto L72;
            int r102 = this.mProducerContext.getImageRequest().getTargetWidth();
            int r103 = this.mProducerContext.getImageRequest().getTargetHeight();
            if (r102 <= 0) goto L12;
            if (r103 <= 0) goto L12;
        L21:
            if (r102 <= 0) goto L65;
            if (r103 <= 0) goto L66;
            float r104 = Math.max((r102 * 1.0f) / r100.getWidth(), (r103 * 1.0f) / r100.getHeight());
            if (FrescoCacheMonitorUtil.isSRAutoScaleLowerFirst() == false) goto L44;
            if (r104 > 1.0f) goto L29;
            return 1.0f;
        L29:
            if (r104 >= 1.2f) goto L32;
        L48:
            return 1.1f;
        L32:
            if (r104 >= 1.3f) goto L35;
        L51:
            return 1.2f;
        L35:
            if (r104 >= 1.4f) goto L38;
        L54:
            return 1.3f;
        L38:
            if (r104 >= 1.5f) goto L41;
        L57:
            return 1.4f;
        L41:
            if (r104 < 2.0f) goto L60;
        L61:
            return 2.0f;
        L60:
            return 1.5f;
        L44:
            if (r104 > 1.0f) goto L47;
            return 1.0f;
        L47:
            if (r104 <= 1.1f) goto L48;
            if (r104 <= 1.2f) goto L51;
            if (r104 <= 1.3f) goto L54;
            if (r104 <= 1.4f) goto L57;
            if (r104 > 1.5f) goto L61;
        L66:
            return 1.0f;
        L65:
            return 1.0f;
        L12:
            SizeDeterminer r105 = this.mProducerContext.getImageRequest().getSizeDeterminer();
            if (r105 == null) goto L21;
            View r106 = r105.getView();
            if (r106 == null) goto L21;
            if (r106.getWidth() <= 0) goto L21;
            if (r106.getHeight() <= 0) goto L21;
            r102 = r106.getWidth();
            r103 = r106.getHeight();
            goto L21
        L72:
            return 1.0f;
        L63:
            return 1.0f;
        }

        private void maybeNotifyOnFailure(Throwable r100) {
            if (close() == false) goto L6;
            getConsumer().onFailure(r100);
            return;
        }

        private boolean shouldPostprocess(CloseableImage r100) {
            return r100 instanceof CloseableStaticBitmap;
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable r100) {
            maybeNotifyOnFailure(r100);
        }

        public static /* synthetic */ CloseableReference access$302(PostprocessorConsumer r100, CloseableReference r101) {
            r100.mSourceImageRef = r101;
            return r101;
        }

        public static /* synthetic */ boolean access$502(PostprocessorConsumer r100, boolean r101) {
            r100.mIsDirty = r101;
            return r101;
        }

        private void doPostprocessing(CloseableReference<CloseableImage> r100, int r101) {
            Preconditions.checkArgument(CloseableReference.isValid(r100));
            if (shouldPostprocess(r100.get(), this.mPostprocessor) == true) goto L6;
            maybeNotifyOnNewResult(r100, r101);
            return;
        L6:
            HashMap r102 = new HashMap();
            this.mListener.onProducerStart(this.mRequestId, PostprocessorProducer.NAME);
            CloseableReference<CloseableImage> r103 = postprocessInternal(r100.get(), r102);     // Catch: Throwable -> L11 OutOfMemoryError -> L13 Exception -> L22
            ProducerListener r104 = this.mListener;     // Catch: Throwable -> L11
            String r105 = this.mRequestId;     // Catch: Throwable -> L11
            r104.onProducerFinishWithSuccess(r105, PostprocessorProducer.NAME, getExtraMap(r104, r105, this.mPostprocessor, r102));     // Catch: Throwable -> L11
            maybeNotifyOnNewResult(r103, r101);     // Catch: Throwable -> L11
            CloseableReference.closeSafely(r103);
            return;
        L11:
            th = move-exception;
            CloseableReference.closeSafely(null);
            throw th;
        L22:
            e = move-exception;
            ProducerListener r106 = this.mListener;     // Catch: Throwable -> L11
            String r107 = this.mRequestId;     // Catch: Throwable -> L11
            r106.onProducerFinishWithFailure(r107, PostprocessorProducer.NAME, e, getExtraMap(r106, r107, this.mPostprocessor, r102));     // Catch: Throwable -> L11
            maybeNotifyOnFailure(e);     // Catch: Throwable -> L11
            CloseableReference.closeSafely(null);
            return;
        L13:
            e = move-exception;
            ImageOOMOptStrategy r108 = ImageOOMOptStrategy.getStrategy();     // Catch: Throwable -> L11
            if (r108 != null) goto L17;
        L21:
            throw e;     // Catch: Throwable -> L11
        L17:
            if (r108.isEnablePostProcessorOOMOpt() == false) goto L21;
            ProducerListener r109 = this.mListener;     // Catch: Throwable -> L11
            String r110 = this.mRequestId;     // Catch: Throwable -> L11
            r109.onProducerFinishWithSuccess(r110, PostprocessorProducer.NAME, getExtraMap(r109, r110, this.mPostprocessor, r102));     // Catch: Throwable -> L11
            maybeNotifyOnNewResult(r100, r101);     // Catch: Throwable -> L11
            r108.optMemoryWhenPostProcessorOOM();     // Catch: Throwable -> L11
            CloseableReference.closeSafely(null);
        }

        private void maybeNotifyOnNewResult(CloseableReference<CloseableImage> r100, int r101) {
            boolean r102 = BaseConsumer.isLast(r101);
            if (r102 == false) goto L5;
        L6:
            if (r102 == true) goto L8;
            return;
        L8:
            if (close() == false) goto L12;
        L9:
            getConsumer().onNewResult(r100, r101);
            return;
        L12:
            return;
        L5:
            if (isClosed() == false) goto L9;
            goto L6
        }

        private CloseableReference<CloseableImage> postprocessInternal(CloseableImage r110, Map<String, String> r111) {
            CloseableStaticBitmap r100 = (CloseableStaticBitmap) r110;
            Bitmap r101 = r100.getUnderlyingBitmap();
            Postprocessor r102 = this.mPostprocessor;
            if ((r102 instanceof BasePostprocessor) == false) goto L38;
            if (r102 != null) goto L6;
        L11:
            Postprocessor r103 = this.mPostprocessor;
            if (r103 != null) goto L14;
        L37:
            CloseableReference<Bitmap> r104 = ((BasePostprocessor) this.mPostprocessor).process(r101, PostprocessorProducer.access$900(this.this$0), r111);
        L39:
            CloseableReference<Bitmap> r112 = r104;
        L40:
            int r105 = r100.getRotationAngle();
            int r106 = r100.getExifOrientation();
            Rect r107 = r100.getRegionToDecode();
            Rect r108 = r100.getSmartCrop();
            int r113 = r100.getSampleSize();
            if (r110.isRequestInternet() == false) goto L44;
            int r114 = 0;
        L61:
            CloseableReference<Bitmap> r109 = r112;
            CloseableReference<CloseableImage> r115 = CloseableReference.of(new CloseableStaticBitmap(r109, r110.getQualityInfo(), r105, r106, r107, r108, r113, r110.getImageFormat(), r114, r111));     // Catch: Throwable -> L56
            CloseableReference.closeSafely(r112);
            return r115;
        L56:
            th = move-exception;
            CloseableReference.closeSafely(r112);
            throw th;
        L44:
            if (r110.isHitDiskCache() == false) goto L47;
            r114 = 2;
            goto L61
        L47:
            if (r110.isHitEncodeMemoryCache() == false) goto L50;
            r114 = 1;
            goto L61
        L50:
            if (r110.isHitBitmapMemoryCache() == false) goto L52;
            r114 = 3;
            goto L61
        L52:
            r114 = -1;
            goto L61
        L14:
            if ("IterativeBoxBlurPostProcessor".equalsIgnoreCase(r103.getName()) == false) goto L37;
            if (r101.getConfig().equals(Bitmap.Config.RGB_565) == false) goto L37;
            ProducerContext r116 = this.mProducerContext;
            if (r116 == null) goto L37;
            if (r116.getImageRequest() == null) goto L37;
            if (SimplayerImageStrategy.getStrategy() == null) goto L37;
            if (SimplayerImageStrategy.getStrategy().getIntValue(1000, this.mProducerContext.getImageRequest().getSourceUri().toString(), 0) != 1) goto L37;
            SimplayerImageStrategy.isOpenLog();
            CloseableReference<Bitmap> r117 = r100.cloneUnderlyingBitmapReference();
            if (SimplayerImageStrategy.isUploadLog() == false) goto L36;
            if (r111 == null) goto L36;
            String r118 = r111.get("strategy_center");     // Catch: JSONException -> L34
            if (r118 != null) goto L31;
            JSONObject r119 = new JSONObject();     // Catch: JSONException -> L34
        L32:
            r119.put("skip_post_processor", 1);     // Catch: JSONException -> L34
            r111.put("strategy_center", r119.toString());     // Catch: JSONException -> L34
            goto L36
        L31:
            r119 = new JSONObject(r118);     // Catch: JSONException -> L34
        L34:
            e = move-exception;
            e.printStackTrace();
        L36:
            r112 = r117;
            goto L40
        L6:
            if ("SRPostProcessor".equalsIgnoreCase(r102.getName()) == false) goto L11;
            float r120 = calScaleRatio(r101);
            if (r100.getExtraMap() == null) goto L10;
            r111.putAll(r100.getExtraMap());
        L10:
            r111.put("sr_stretch", String.valueOf(r120));
            r104 = ((BasePostprocessor) this.mPostprocessor).process(r101, PostprocessorProducer.access$900(this.this$0), r111);
            goto L39
        L38:
            r104 = r102.process(r101, PostprocessorProducer.access$900(this.this$0));
            goto L39
        }

        private boolean shouldPostprocess(CloseableImage r100, Postprocessor r101) {
            return r100 instanceof CloseableStaticBitmap;
        }

        private void updateSourceImageRef(@Nullable CloseableReference<CloseableImage> r100, int r101) {
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L4:
            if (this.mIsClosed == false) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L7:
            CloseableReference<CloseableImage> r102 = this.mSourceImageRef;     // Catch: Throwable -> L13
            this.mSourceImageRef = CloseableReference.cloneOrNull(r100);     // Catch: Throwable -> L13
            this.mStatus = r101;     // Catch: Throwable -> L13
            this.mIsDirty = true;     // Catch: Throwable -> L13
            boolean r103 = setRunningIfDirtyAndNotRunning();     // Catch: Throwable -> L13
            monitor-exit(this);     // Catch: Throwable -> L13
            CloseableReference.closeSafely(r102);
            if (r103 == false) goto L17;
            submitPostprocessing();
            return;
        }

        public void onNewResultImpl(CloseableReference<CloseableImage> r100, int r101) {
            if (CloseableReference.isValid(r100) == false) goto L5;
            updateSourceImageRef(r100, r101);
            return;
        L5:
            if (BaseConsumer.isLast(r101) == false) goto L10;
            maybeNotifyOnNewResult(null, r101);
            return;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public /* bridge */ /* synthetic */ void onNewResultImpl(Object r100, int r101) {
            onNewResultImpl((CloseableReference) r100, r101);
        }

        public static /* synthetic */ void access$600(PostprocessorConsumer r100, CloseableReference r101, int r102) {
            r100.doPostprocessing(r101, r102);
        }

        private Map<String, String> getExtraMap(ProducerListener r100, String r101, Postprocessor r102, Map<String, String> r103) {
            if (r100.requiresExtraMap(r101) == true) goto L6;
            return null;
        L6:
            r103.put(PostprocessorProducer.POSTPROCESSOR, r102.getName());
            return Collections.unmodifiableMap(r103);
        }

        public PostprocessorConsumer(final PostprocessorProducer r100, Consumer<CloseableReference<CloseableImage>> r101, ProducerListener r102, String r103, Postprocessor r104, ProducerContext r105) {
            this.this$0 = r100;
            super(r101);
            this.mSourceImageRef = null;
            this.mStatus = 0;
            this.mIsDirty = false;
            this.mIsPostProcessingRunning = false;
            this.mListener = r102;
            this.mRequestId = r103;
            this.mPostprocessor = r104;
            this.mProducerContext = r105;
            r105.addCallbacks(new AnonymousClass1(this, r100));
        }
    }

    public class RepeatedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> implements RepeatedPostprocessorRunner {
        private boolean mIsClosed;

        @Nullable
        private CloseableReference<CloseableImage> mSourceImageRef;
        final /* synthetic */ PostprocessorProducer this$0;

        private boolean close() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (this.mIsClosed == false) goto L8;
            monitor-exit(this);     // Catch: Throwable -> L12
            return false;
        L8:
            CloseableReference<CloseableImage> r100 = this.mSourceImageRef;     // Catch: Throwable -> L12
            this.mSourceImageRef = null;     // Catch: Throwable -> L12
            this.mIsClosed = true;     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            CloseableReference.closeSafely(r100);
            return true;
        }

        private void updateInternal() {
            monitor-enter(this);
        L15:
            th = move-exception;
            throw th;
        L4:
            if (this.mIsClosed == false) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L15
            return;
        L7:
            CloseableReference<CloseableImage> r100 = CloseableReference.cloneOrNull(this.mSourceImageRef);     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
            getConsumer().onNewResult(r100, 0);     // Catch: Throwable -> L12
            CloseableReference.closeSafely(r100);
            return;
        L12:
            th = move-exception;
            CloseableReference.closeSafely(r100);
            throw th;
        }

        @Override // com.facebook.imagepipeline.request.RepeatedPostprocessorRunner
        public synchronized void update() {
            monitor-enter(this);
            updateInternal();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            if (close() == false) goto L6;
            getConsumer().onCancellation();
            return;
        }

        public static /* synthetic */ boolean access$1000(RepeatedPostprocessorConsumer r100) {
            return r100.close();
        }

        private void setSourceImageRef(CloseableReference<CloseableImage> r100) {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.mIsClosed == false) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L11
            return;
        L7:
            CloseableReference<CloseableImage> r101 = this.mSourceImageRef;     // Catch: Throwable -> L11
            this.mSourceImageRef = CloseableReference.cloneOrNull(r100);     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            CloseableReference.closeSafely(r101);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable r100) {
            if (close() == false) goto L6;
            getConsumer().onFailure(r100);
            return;
        }

        public void onNewResultImpl(CloseableReference<CloseableImage> r100, int r101) {
            if (BaseConsumer.isNotLast(r101) == false) goto L5;
            return;
        L5:
            setSourceImageRef(r100);
            updateInternal();
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public /* bridge */ /* synthetic */ void onNewResultImpl(Object r100, int r101) {
            onNewResultImpl((CloseableReference) r100, r101);
        }

        private RepeatedPostprocessorConsumer(final PostprocessorProducer r100, PostprocessorConsumer r101, RepeatedPostprocessor r102, ProducerContext r103) {
            this.this$0 = r100;
            super(r101);
            this.mIsClosed = false;
            this.mSourceImageRef = null;
            r102.setCallback(this);
            r103.addCallbacks(new AnonymousClass1(this, r100));
        }

        public /* synthetic */ RepeatedPostprocessorConsumer(PostprocessorProducer r100, PostprocessorConsumer r101, RepeatedPostprocessor r102, ProducerContext r103, AnonymousClass1 r104) {
            this(r100, r101, r102, r103);
        }
    }

    public class SingleUsePostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        final /* synthetic */ PostprocessorProducer this$0;

        private SingleUsePostprocessorConsumer(PostprocessorProducer r100, PostprocessorConsumer r101) {
            this.this$0 = r100;
            super(r101);
        }

        public void onNewResultImpl(CloseableReference<CloseableImage> r100, int r101) {
            if (BaseConsumer.isNotLast(r101) == false) goto L5;
            return;
        L5:
            getConsumer().onNewResult(r100, r101);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public /* bridge */ /* synthetic */ void onNewResultImpl(Object r100, int r101) {
            onNewResultImpl((CloseableReference) r100, r101);
        }

        public /* synthetic */ SingleUsePostprocessorConsumer(PostprocessorProducer r100, PostprocessorConsumer r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public static /* synthetic */ Executor access$800(PostprocessorProducer r100) {
        return r100.mExecutor;
    }

    public static /* synthetic */ PlatformBitmapFactory access$900(PostprocessorProducer r100) {
        return r100.mBitmapFactory;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> r110, ProducerContext r111) {
        ProducerListener r100 = r111.getListener();
        Postprocessor r101 = r111.getImageRequest().getPostprocessor();
        PostprocessorConsumer r102 = new PostprocessorConsumer(this, r110, r100, r111.getId(), r101, r111);
        if ((r101 instanceof RepeatedPostprocessor) == false) goto L5;
        Consumer<CloseableReference<CloseableImage>> r103 = new RepeatedPostprocessorConsumer(this, r102, (RepeatedPostprocessor) r101, r111, null);
    L6:
        this.mInputProducer.produceResults(r103, r111);
        return;
    L5:
        r103 = new SingleUsePostprocessorConsumer(this, r102, null);
        goto L6
    }

    public PostprocessorProducer(Producer<CloseableReference<CloseableImage>> r100, PlatformBitmapFactory r101, Executor r102) {
        this.mInputProducer = (Producer) Preconditions.checkNotNull(r100);
        this.mBitmapFactory = r101;
        this.mExecutor = (Executor) Preconditions.checkNotNull(r102);
    }
}
