package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.core.ImagePipelineExperiments;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imageutils.HeifFormatUtil;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public abstract class MultiplexProducer<K, T extends Closeable> implements Producer<T> {
    private final Producer<T> mInputProducer;
    final Map<K, MultiplexProducer<K, T>.Multiplexer> mMultiplexers;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.producers.MultiplexProducer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class Multiplexer {
        private final CopyOnWriteArraySet<Pair<Consumer<T>, ProducerContext>> mConsumerContextPairs;

        @Nullable
        private MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer mForwardingConsumer;
        private final K mKey;

        @Nullable
        private T mLastIntermediateResult;
        private float mLastProgress;
        private int mLastStatus;

        @Nullable
        private BaseProducerContext mMultiplexProducerContext;
        final /* synthetic */ MultiplexProducer this$0;

        public class ForwardingConsumer extends BaseConsumer<T> {
            final /* synthetic */ Multiplexer this$1;

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onCancellationImpl() {
            L10:
                th = move-exception;
                if (FrescoSystrace.isTracing() == false) goto L14;
                FrescoSystrace.endSection();
            L14:
                throw th;
            L3:
                if (FrescoSystrace.isTracing() == false) goto L5;
                FrescoSystrace.beginSection("MultiplexProducer#onCancellation");     // Catch: Throwable -> L10
            L5:
                this.this$1.onCancelled(this);     // Catch: Throwable -> L10
                if (FrescoSystrace.isTracing() == false) goto L17;
                FrescoSystrace.endSection();
                return;
            }

            private ForwardingConsumer(Multiplexer r100) {
                this.this$1 = r100;
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onFailureImpl(Throwable r100) {
            L10:
                th = move-exception;
                if (FrescoSystrace.isTracing() == false) goto L14;
                FrescoSystrace.endSection();
            L14:
                throw th;
            L3:
                if (FrescoSystrace.isTracing() == false) goto L5;
                FrescoSystrace.beginSection("MultiplexProducer#onFailure");     // Catch: Throwable -> L10
            L5:
                this.this$1.onFailure(this, r100);     // Catch: Throwable -> L10
                if (FrescoSystrace.isTracing() == false) goto L17;
                FrescoSystrace.endSection();
                return;
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onProgressUpdateImpl(float r100) {
            L10:
                th = move-exception;
                if (FrescoSystrace.isTracing() == false) goto L14;
                FrescoSystrace.endSection();
            L14:
                throw th;
            L3:
                if (FrescoSystrace.isTracing() == false) goto L5;
                FrescoSystrace.beginSection("MultiplexProducer#onProgressUpdate");     // Catch: Throwable -> L10
            L5:
                this.this$1.onProgressUpdate(this, r100);     // Catch: Throwable -> L10
                if (FrescoSystrace.isTracing() == false) goto L17;
                FrescoSystrace.endSection();
                return;
            }

            public /* synthetic */ ForwardingConsumer(Multiplexer r100, AnonymousClass1 r101) {
                this(r100);
            }

            public void onNewResultImpl(T r100, int r101) {
            L10:
                th = move-exception;
                if (FrescoSystrace.isTracing() == false) goto L14;
                FrescoSystrace.endSection();
            L14:
                throw th;
            L3:
                if (FrescoSystrace.isTracing() == false) goto L5;
                FrescoSystrace.beginSection("MultiplexProducer#onNewResult");     // Catch: Throwable -> L10
            L5:
                this.this$1.onNextResult(this, r100, r101);     // Catch: Throwable -> L10
                if (FrescoSystrace.isTracing() == false) goto L17;
                FrescoSystrace.endSection();
                return;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public /* bridge */ /* synthetic */ void onNewResultImpl(Object r100, int r101) {
                onNewResultImpl((Closeable) r100, r101);
            }
        }

        private synchronized boolean computeIsIntermediateResultExpected() {
            monitor-enter(this);
            Iterator<Pair<Consumer<T>, ProducerContext>> r100 = this.mConsumerContextPairs.iterator();     // Catch: Throwable -> L14
        L5:
            if (r100.hasNext() == false) goto L11;
            if (((ProducerContext) r100.next().second).isIntermediateResultExpected() == false) goto L5;
            monitor-exit(this);
            return true;
        L11:
            monitor-exit(this);
            return false;
        L14:
            th = move-exception;
            throw th;
        }

        private synchronized boolean computeIsPrefetch() {
            monitor-enter(this);
            Iterator<Pair<Consumer<T>, ProducerContext>> r100 = this.mConsumerContextPairs.iterator();     // Catch: Throwable -> L14
        L5:
            if (r100.hasNext() == false) goto L11;
            if (((ProducerContext) r100.next().second).isPrefetch() == true) goto L5;
            monitor-exit(this);
            return false;
        L11:
            monitor-exit(this);
            return true;
        L14:
            th = move-exception;
            throw th;
        }

        private synchronized Priority computePriority() {
            monitor-enter(this);
            Priority r100 = Priority.LOW;     // Catch: Throwable -> L10
            Iterator<Pair<Consumer<T>, ProducerContext>> r101 = this.mConsumerContextPairs.iterator();     // Catch: Throwable -> L10
        L5:
            if (r101.hasNext() == false) goto L8;
            r100 = Priority.getHigherPriority(r100, ((ProducerContext) r101.next().second).getPriority());     // Catch: Throwable -> L10
            goto L5
        L8:
            monitor-exit(this);
            return r100;
        L10:
            th = move-exception;
            throw th;
        }

        private void startInputProducerIfHasAttachedConsumers() {
            monitor-enter(this);
            boolean r100 = true;
            if (this.mMultiplexProducerContext != null) goto L6;
            boolean r101 = true;
        L7:
            Preconditions.checkArgument(r101);     // Catch: Throwable -> L20
            if (this.mForwardingConsumer == null) goto L11;
            r100 = false;
        L11:
            Preconditions.checkArgument(r100);     // Catch: Throwable -> L20
            if (this.mConsumerContextPairs.isEmpty() == false) goto L16;
            MultiplexProducer.access$700(this.this$0, this.mKey, this);     // Catch: Throwable -> L20
            monitor-exit(this);     // Catch: Throwable -> L20
            return;
        L16:
            ProducerContext r102 = (ProducerContext) this.mConsumerContextPairs.iterator().next().second;     // Catch: Throwable -> L20
            this.mMultiplexProducerContext = new BaseProducerContext(r102.getImageRequest(), r102.getId(), r102.getListener(), r102.getCallerContext(), r102.getLowestPermittedRequestLevel(), computeIsPrefetch(), computeIsIntermediateResultExpected(), computePriority());     // Catch: Throwable -> L20
            MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer r103 = new ForwardingConsumer(this, null);     // Catch: Throwable -> L20
            this.mForwardingConsumer = r103;     // Catch: Throwable -> L20
            BaseProducerContext r104 = this.mMultiplexProducerContext;     // Catch: Throwable -> L20
            monitor-exit(this);     // Catch: Throwable -> L20
            MultiplexProducer.access$900(this.this$0).produceResults(r103, r104);
            return;
        L6:
            r101 = false;
        L20:
            th = move-exception;
            throw th;
        }

        @Nullable
        private synchronized List<ProducerContextCallbacks> updateIsIntermediateResultExpected() {
            monitor-enter(this);
            BaseProducerContext r100 = this.mMultiplexProducerContext;     // Catch: Throwable -> L11
            if (r100 != null) goto L8;
            monitor-exit(this);
            return null;
        L8:
            List<ProducerContextCallbacks> r101 = r100.setIsIntermediateResultExpectedNoCallbacks(computeIsIntermediateResultExpected());     // Catch: Throwable -> L11
            monitor-exit(this);
            return r101;
        L11:
            th = move-exception;
            throw th;
        }

        @Nullable
        private synchronized List<ProducerContextCallbacks> updateIsPrefetch() {
            monitor-enter(this);
            BaseProducerContext r100 = this.mMultiplexProducerContext;     // Catch: Throwable -> L11
            if (r100 != null) goto L8;
            monitor-exit(this);
            return null;
        L8:
            List<ProducerContextCallbacks> r101 = r100.setIsPrefetchNoCallbacks(computeIsPrefetch());     // Catch: Throwable -> L11
            monitor-exit(this);
            return r101;
        L11:
            th = move-exception;
            throw th;
        }

        @Nullable
        private synchronized List<ProducerContextCallbacks> updatePriority() {
            monitor-enter(this);
            BaseProducerContext r100 = this.mMultiplexProducerContext;     // Catch: Throwable -> L11
            if (r100 != null) goto L8;
            monitor-exit(this);
            return null;
        L8:
            List<ProducerContextCallbacks> r101 = r100.setPriorityNoCallbacks(computePriority());     // Catch: Throwable -> L11
            monitor-exit(this);
            return r101;
        L11:
            th = move-exception;
            throw th;
        }

        public static /* synthetic */ void access$000(Multiplexer r100) {
            r100.startInputProducerIfHasAttachedConsumers();
        }

        public static /* synthetic */ CopyOnWriteArraySet access$200(Multiplexer r100) {
            return r100.mConsumerContextPairs;
        }

        public static /* synthetic */ BaseProducerContext access$300(Multiplexer r100) {
            return r100.mMultiplexProducerContext;
        }

        public static /* synthetic */ List access$400(Multiplexer r100) {
            return r100.updateIsPrefetch();
        }

        public static /* synthetic */ List access$500(Multiplexer r100) {
            return r100.updatePriority();
        }

        public static /* synthetic */ List access$600(Multiplexer r100) {
            return r100.updateIsIntermediateResultExpected();
        }

        private void closeSafely(Closeable r100) {
            if (r100 != null) goto L9;
            return;
        L9:
            r100.close();     // Catch: IOException -> L5
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        public void onCancelled(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer r100) {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.mForwardingConsumer == r100) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L11
            return;
        L7:
            this.mForwardingConsumer = null;     // Catch: Throwable -> L11
            this.mMultiplexProducerContext = null;     // Catch: Throwable -> L11
            closeSafely(this.mLastIntermediateResult);     // Catch: Throwable -> L11
            this.mLastIntermediateResult = null;     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            startInputProducerIfHasAttachedConsumers();
        }

        public Multiplexer(MultiplexProducer r100, K r101) {
            this.this$0 = r100;
            this.mConsumerContextPairs = Sets.newCopyOnWriteArraySet();
            this.mKey = r101;
        }

        private void addCallbacks(final Pair<Consumer<T>, ProducerContext> r100, ProducerContext r101) {
            r101.addCallbacks(new AnonymousClass1(this, r100));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean addNewConsumer(Consumer<T> r100, ProducerContext r101) {
            Pair<Consumer<T>, ProducerContext> r102 = Pair.create(r100, r101);
            monitor-enter(this);
        L34:
            th = move-exception;
            throw th;
        L5:
            if (MultiplexProducer.access$100(this.this$0, this.mKey) == this) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L34
            return false;
        L9:
            this.mConsumerContextPairs.add(r102);     // Catch: Throwable -> L34
            List<ProducerContextCallbacks> r103 = updateIsPrefetch();     // Catch: Throwable -> L34
            List<ProducerContextCallbacks> r104 = updatePriority();     // Catch: Throwable -> L34
            List<ProducerContextCallbacks> r105 = updateIsIntermediateResultExpected();     // Catch: Throwable -> L34
            Closeable r106 = this.mLastIntermediateResult;     // Catch: Throwable -> L34
            float r107 = this.mLastProgress;     // Catch: Throwable -> L34
            int r108 = this.mLastStatus;     // Catch: Throwable -> L34
            monitor-exit(this);     // Catch: Throwable -> L34
            BaseProducerContext.callOnIsPrefetchChanged(r103);
            BaseProducerContext.callOnPriorityChanged(r104);
            BaseProducerContext.callOnIsIntermediateResultExpectedChanged(r105);
            monitor-enter(r102);
            monitor-enter(this);     // Catch: Throwable -> L31
        L28:
            th = move-exception;
            throw th;     // Catch: Throwable -> L31
        L15:
            if (r106 == this.mLastIntermediateResult) goto L17;
            r106 = null;
        L19:
            monitor-exit(this);     // Catch: Throwable -> L28
            if (r106 != null) goto L22;
        L25:
            monitor-exit(r102);     // Catch: Throwable -> L31
            addCallbacks(r102, r101);
            return true;
        L22:
            if (r107 <= 0.0f) goto L24;
            r100.onProgressUpdate(r107);     // Catch: Throwable -> L31
        L24:
            r100.onNewResult(r106, r108);     // Catch: Throwable -> L31
            closeSafely(r106);     // Catch: Throwable -> L31
            goto L25
        L17:
            if (r106 == null) goto L19;
            r106 = this.this$0.cloneOrNull(r106);     // Catch: Throwable -> L28
        L31:
            th = move-exception;
            throw th;
        }

        public void onFailure(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer r100, Throwable r101) {
            monitor-enter(this);
        L20:
            th = move-exception;
            throw th;
        L4:
            if (this.mForwardingConsumer == r100) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L20
            return;
        L7:
            Iterator<Pair<Consumer<T>, ProducerContext>> r102 = this.mConsumerContextPairs.iterator();     // Catch: Throwable -> L20
            this.mConsumerContextPairs.clear();     // Catch: Throwable -> L20
            MultiplexProducer.access$700(this.this$0, this.mKey, this);     // Catch: Throwable -> L20
            closeSafely(this.mLastIntermediateResult);     // Catch: Throwable -> L20
            this.mLastIntermediateResult = null;     // Catch: Throwable -> L20
            monitor-exit(this);     // Catch: Throwable -> L20
        L10:
            if (r102.hasNext() == false) goto L19;
            Pair<Consumer<T>, ProducerContext> r103 = r102.next();
            monitor-enter(r103);
            ((Consumer) r103.first).onFailure(r101);     // Catch: Throwable -> L16
            monitor-exit(r103);     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            throw th;
        }

        public void onProgressUpdate(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer r100, float r101) {
            if (ImagePipelineFactory.hasBeenInitialized() == false) goto L14;
            ImagePipelineExperiments r102 = ImagePipelineFactory.getInstance().getImagePipelineConfig().getExperiments();
            if (r102.getIntermediateProgressUpdatesDisabled() == false) goto L8;
            return;
        L8:
            if (r102.getIntermediateProgressUpdatesForPrefetchDisabled() == false) goto L14;
            BaseProducerContext r103 = this.mMultiplexProducerContext;
            if (r103 == null) goto L14;
            if (r103.isPrefetch() == false) goto L14;
            return;
        L14:
            monitor-enter(this);
        L32:
            th = move-exception;
            throw th;
        L16:
            if (this.mForwardingConsumer == r100) goto L19;
            monitor-exit(this);     // Catch: Throwable -> L32
            return;
        L19:
            this.mLastProgress = r101;     // Catch: Throwable -> L32
            Iterator<Pair<Consumer<T>, ProducerContext>> r104 = this.mConsumerContextPairs.iterator();     // Catch: Throwable -> L32
            monitor-exit(this);     // Catch: Throwable -> L32
        L22:
            if (r104.hasNext() == false) goto L31;
            Pair<Consumer<T>, ProducerContext> r105 = r104.next();
            monitor-enter(r105);
            ((Consumer) r105.first).onProgressUpdate(r101);     // Catch: Throwable -> L28
            monitor-exit(r105);     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            throw th;
        }

        public void onNextResult(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer r100, T r101, int r102) {
            monitor-enter(this);
        L29:
            th = move-exception;
            throw th;
        L4:
            if (this.mForwardingConsumer == r100) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L29
            return;
        L7:
            closeSafely(this.mLastIntermediateResult);     // Catch: Throwable -> L29
            this.mLastIntermediateResult = null;     // Catch: Throwable -> L29
            Iterator<Pair<Consumer<T>, ProducerContext>> r103 = this.mConsumerContextPairs.iterator();     // Catch: Throwable -> L29
            if (BaseConsumer.isNotLast(r102) == false) goto L10;
            this.mLastIntermediateResult = (T) this.this$0.cloneOrNull(r101);     // Catch: Throwable -> L29
            this.mLastStatus = r102;     // Catch: Throwable -> L29
        L11:
            monitor-exit(this);     // Catch: Throwable -> L29
            int r104 = 0;
        L14:
            if (r103.hasNext() == false) goto L28;
            Pair<Consumer<T>, ProducerContext> r105 = r103.next();
            monitor-enter(r105);
            int r106 = r104 + 1;
            if (useCloneResultOrNot(r101, r105, r102, r104) == false) goto L22;
            monitor-exit(r105);     // Catch: Throwable -> L25
        L24:
            r104 = r106;
            goto L14
        L22:
            ((Consumer) r105.first).onNewResult(r101, r102);     // Catch: Throwable -> L25
            monitor-exit(r105);     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            throw th;
        L28:
            return;
        L10:
            this.mConsumerContextPairs.clear();     // Catch: Throwable -> L29
            MultiplexProducer.access$700(this.this$0, this.mKey, this);     // Catch: Throwable -> L29
            goto L11
        }

        private boolean useCloneResultOrNot(T r100, Pair<Consumer<T>, ProducerContext> r101, int r102, int r103) {
            if (r103 != 0) goto L6;
            return false;
        L6:
            if (this.this$0.getImageFormat(r100) != HeifFormatUtil.getHeifFormatAnimated()) goto L8;
            Closeable r104 = this.this$0.cloneResultOrNull(r100);
        L9:
            if (r104 != null) goto L19;
            if (r104 == null) goto L18;
            closeSafely(r104);
        L18:
            return false;
        L19:
            ((Consumer) r101.first).onNewResult(r104, r102);     // Catch: Throwable -> L13
            closeSafely(r104);
            return true;
        L13:
            th = move-exception;
            closeSafely(r104);
            throw th;
        L8:
            r104 = null;
            goto L9
        }
    }

    public abstract T cloneOrNull(T r100);

    public T cloneResultOrNull(T r100) {
        return null;
    }

    public abstract ImageFormat getImageFormat(T r100);

    public abstract K getKey(ProducerContext r100);

    public MultiplexProducer(Producer<T> r100) {
        this.mInputProducer = r100;
        this.mMultiplexers = new HashMap();
    }

    public static /* synthetic */ Producer access$900(MultiplexProducer r100) {
        return r100.mInputProducer;
    }

    private synchronized MultiplexProducer<K, T>.Multiplexer createAndPutNewMultiplexer(K r100) {
        monitor-enter(this);
        MultiplexProducer<K, T>.Multiplexer r101 = new Multiplexer(this, r100);     // Catch: Throwable -> L6
        this.mMultiplexers.put(r100, r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized MultiplexProducer<K, T>.Multiplexer getExistingMultiplexer(K r100) {
        monitor-enter(this);
        MultiplexProducer<K, T>.Multiplexer r101 = this.mMultiplexers.get(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ Multiplexer access$100(MultiplexProducer r100, Object r101) {
        return r100.getExistingMultiplexer(r101);
    }

    private synchronized void removeMultiplexer(K r100, MultiplexProducer<K, T>.Multiplexer r101) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mMultiplexers.get(r100) != r101) goto L6;
        this.mMultiplexers.remove(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<T> r100, ProducerContext r101) {
    L29:
        th = move-exception;
        if (FrescoSystrace.isTracing() == false) goto L33;
        FrescoSystrace.endSection();
    L33:
        throw th;
    L3:
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("MultiplexProducer#produceResults");     // Catch: Throwable -> L29
    L5:
        K r102 = getKey(r101);     // Catch: Throwable -> L29
    L6:
        monitor-enter(this);     // Catch: Throwable -> L29
        MultiplexProducer<K, T>.Multiplexer r103 = getExistingMultiplexer(r102);     // Catch: Throwable -> L26
        if (r103 != null) goto L10;
        r103 = createAndPutNewMultiplexer(r102);     // Catch: Throwable -> L26
        boolean r104 = true;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L26
        if (r103.addNewConsumer(r100, r101) == false) goto L6;
        if (r104 == false) goto L17;
        Multiplexer.access$000(r103);     // Catch: Throwable -> L29
    L23:
        if (FrescoSystrace.isTracing() == false) goto L41;
        FrescoSystrace.endSection();
        return;
    L41:
        return;
    L17:
        if (FrescoCacheMonitorUtil.isOptMultiOriginListener() == false) goto L23;
        r101.getListener().onUltimateProducerReached(r101.getId(), this.mInputProducer.getClass().getSimpleName(), true);     // Catch: Exception -> L20 Throwable -> L29
    L20:
        e = move-exception;
        FLog.e("MultipleProducer", "MultipleProducer exception in produceResults", e);     // Catch: Throwable -> L29
        goto L23
    L10:
        r104 = false;
        goto L11
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    }

    public static /* synthetic */ void access$700(MultiplexProducer r100, Object r101, Multiplexer r102) {
        r100.removeMultiplexer(r101, r102);
    }
}
