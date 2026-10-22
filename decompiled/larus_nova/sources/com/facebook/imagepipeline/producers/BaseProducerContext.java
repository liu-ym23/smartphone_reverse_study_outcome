package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class BaseProducerContext implements ProducerContext {
    private final List<ProducerContextCallbacks> mCallbacks;
    private final Object mCallerContext;
    private final String mId;
    private final ImageRequest mImageRequest;
    private boolean mIsCancelled;
    private boolean mIsIntermediateResultExpected;
    private boolean mIsPrefetch;
    private final ImageRequest.RequestLevel mLowestPermittedRequestLevel;
    private Priority mPriority;
    private final ProducerListener mProducerListener;

    @Nullable
    public synchronized List<ProducerContextCallbacks> cancelNoCallbacks() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsCancelled == false) goto L9;
        monitor-exit(this);
        return null;
    L9:
        this.mIsCancelled = true;     // Catch: Throwable -> L12
        ArrayList r100 = new ArrayList(this.mCallbacks);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r100;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized Priority getPriority() {
        monitor-enter(this);
        Priority r100 = this.mPriority;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isCancelled() {
        monitor-enter(this);
        boolean r100 = this.mIsCancelled;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized boolean isIntermediateResultExpected() {
        monitor-enter(this);
        boolean r100 = this.mIsIntermediateResultExpected;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized boolean isPrefetch() {
        monitor-enter(this);
        boolean r100 = this.mIsPrefetch;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public void cancel() {
        callOnCancellationRequested(cancelNoCallbacks());
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public Object getCallerContext() {
        return this.mCallerContext;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public String getId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ImageRequest getImageRequest() {
        return this.mImageRequest;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ProducerListener getListener() {
        return this.mProducerListener;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ImageRequest.RequestLevel getLowestPermittedRequestLevel() {
        return this.mLowestPermittedRequestLevel;
    }

    public static void callOnCancellationRequested(@Nullable List<ProducerContextCallbacks> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<ProducerContextCallbacks> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().onCancellationRequested();
        goto L6
    }

    public static void callOnIsIntermediateResultExpectedChanged(@Nullable List<ProducerContextCallbacks> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<ProducerContextCallbacks> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().onIsIntermediateResultExpectedChanged();
        goto L6
    }

    public static void callOnIsPrefetchChanged(@Nullable List<ProducerContextCallbacks> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<ProducerContextCallbacks> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().onIsPrefetchChanged();
        goto L6
    }

    public static void callOnPriorityChanged(@Nullable List<ProducerContextCallbacks> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<ProducerContextCallbacks> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().onPriorityChanged();
        goto L6
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void addCallbacks(ProducerContextCallbacks r100) {
        monitor-enter(this);
        this.mCallbacks.add(r100);     // Catch: Throwable -> L8
        boolean r101 = this.mIsCancelled;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        if (r101 == false) goto L13;
        r100.onCancellationRequested();
        return;
    L13:
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> setIsIntermediateResultExpectedNoCallbacks(boolean r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (r100 != this.mIsIntermediateResultExpected) goto L8;
        monitor-exit(this);
        return null;
    L8:
        this.mIsIntermediateResultExpected = r100;     // Catch: Throwable -> L11
        ArrayList r101 = new ArrayList(this.mCallbacks);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> setIsPrefetchNoCallbacks(boolean r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (r100 != this.mIsPrefetch) goto L8;
        monitor-exit(this);
        return null;
    L8:
        this.mIsPrefetch = r100;     // Catch: Throwable -> L11
        ArrayList r101 = new ArrayList(this.mCallbacks);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> setPriorityNoCallbacks(Priority r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (r100 != this.mPriority) goto L8;
        monitor-exit(this);
        return null;
    L8:
        this.mPriority = r100;     // Catch: Throwable -> L11
        ArrayList r101 = new ArrayList(this.mCallbacks);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    }

    public BaseProducerContext(ImageRequest r100, String r101, ProducerListener r102, Object r103, ImageRequest.RequestLevel r104, boolean r105, boolean r106, Priority r107) {
        this.mImageRequest = r100;
        this.mId = r101;
        this.mProducerListener = r102;
        this.mCallerContext = r103;
        this.mLowestPermittedRequestLevel = r104;
        this.mIsPrefetch = r105;
        this.mPriority = r107;
        this.mIsIntermediateResultExpected = r106;
        this.mIsCancelled = false;
        this.mCallbacks = new ArrayList();
    }
}
