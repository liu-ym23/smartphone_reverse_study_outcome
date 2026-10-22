package com.facebook.imagepipeline.listener;

import android.os.SystemClock;
import android.util.Pair;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class RequestLoggingListener extends BaseRequestListener {
    private static final String TAG = "RequestLoggingListener";
    private final Map<Pair<String, String>, Long> mProducerStartTimeMap;
    private final Map<String, Long> mRequestStartTimeMap;

    public RequestLoggingListener() {
        this.mProducerStartTimeMap = new HashMap();
        this.mRequestStartTimeMap = new HashMap();
    }

    private static long getTime() {
        return SystemClock.uptimeMillis();
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public synchronized void onRequestCancellation(String r100) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (FLog.isLoggable(2) == false) goto L7;
        Long r101 = this.mRequestStartTimeMap.remove(r100);     // Catch: Throwable -> L9
        long r102 = getTime();     // Catch: Throwable -> L9
        FLog.v(TAG, "time %d: onRequestCancellation: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(r102), r100, Long.valueOf(getElapsedTime(r101, r102)));     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public boolean requiresExtraMap(String r100) {
        return FLog.isLoggable(2);
    }

    private static long getElapsedTime(@Nullable Long r100, long r101) {
        if (r100 != null) goto L4;
        return -1;
    L4:
        return r101 - r100.longValue();
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onProducerStart(String r100, String r101) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (FLog.isLoggable(2) == false) goto L7;
        Pair<String, String> r102 = Pair.create(r100, r101);     // Catch: Throwable -> L9
        long r103 = getTime();     // Catch: Throwable -> L9
        this.mProducerStartTimeMap.put(r102, Long.valueOf(r103));     // Catch: Throwable -> L9
        FLog.v(TAG, "time %d: onProducerStart: {requestId: %s, producer: %s}", Long.valueOf(r103), r100, r101);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onProducerEvent(String r110, String r111, String r112) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (FLog.isLoggable(2) == false) goto L7;
        FLog.v(TAG, "time %d: onProducerEvent: {requestId: %s, stage: %s, eventName: %s; elapsedTime: %d ms}", new Object[]{Long.valueOf(getTime()), r110, r111, r112, Long.valueOf(getElapsedTime(this.mProducerStartTimeMap.get(Pair.create(r110, r111)), getTime()))});     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onProducerFinishWithCancellation(String r110, String r111, @Nullable Map<String, String> r112) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (FLog.isLoggable(2) == false) goto L7;
        Long r100 = this.mProducerStartTimeMap.remove(Pair.create(r110, r111));     // Catch: Throwable -> L9
        long r101 = getTime();     // Catch: Throwable -> L9
        FLog.v(TAG, "time %d: onProducerFinishWithCancellation: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s}", new Object[]{Long.valueOf(r101), r110, r111, Long.valueOf(getElapsedTime(r100, r101)), r112});     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onProducerFinishWithSuccess(String r110, String r111, @Nullable Map<String, String> r112) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (FLog.isLoggable(2) == false) goto L7;
        Long r100 = this.mProducerStartTimeMap.remove(Pair.create(r110, r111));     // Catch: Throwable -> L9
        long r101 = getTime();     // Catch: Throwable -> L9
        FLog.v(TAG, "time %d: onProducerFinishWithSuccess: {requestId: %s, producer: %s, elapsedTime: %d ms, extraMap: %s}", new Object[]{Long.valueOf(r101), r110, r111, Long.valueOf(getElapsedTime(r100, r101)), r112});     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public synchronized void onRequestSuccess(ImageRequest r100, String r101, boolean r102) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (FLog.isLoggable(2) == false) goto L7;
        Long r103 = this.mRequestStartTimeMap.remove(r101);     // Catch: Throwable -> L9
        long r104 = getTime();     // Catch: Throwable -> L9
        FLog.v(TAG, "time %d: onRequestSuccess: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(r104), r101, Long.valueOf(getElapsedTime(r103, r104)));     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onUltimateProducerReached(String r110, String r111, boolean r112) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (FLog.isLoggable(2) == false) goto L7;
        Long r100 = this.mProducerStartTimeMap.remove(Pair.create(r110, r111));     // Catch: Throwable -> L9
        long r101 = getTime();     // Catch: Throwable -> L9
        FLog.v(TAG, "time %d: onUltimateProducerReached: {requestId: %s, producer: %s, elapsedTime: %d ms, success: %b}", new Object[]{Long.valueOf(r101), r110, r111, Long.valueOf(getElapsedTime(r100, r101)), Boolean.valueOf(r112)});     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onProducerFinishWithFailure(String r110, String r111, Throwable r112, @Nullable Map<String, String> r113) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (FLog.isLoggable(5) == false) goto L7;
        Long r100 = this.mProducerStartTimeMap.remove(Pair.create(r110, r111));     // Catch: Throwable -> L9
        long r101 = getTime();     // Catch: Throwable -> L9
        FLog.w(TAG, r112, "time %d: onProducerFinishWithFailure: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s, throwable: %s}", new Object[]{Long.valueOf(r101), r110, r111, Long.valueOf(getElapsedTime(r100, r101)), r113, r112.toString()});     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public synchronized void onRequestFailure(ImageRequest r100, String r101, Throwable r102, boolean r110) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (FLog.isLoggable(5) == false) goto L7;
        Long r103 = this.mRequestStartTimeMap.remove(r101);     // Catch: Throwable -> L9
        long r104 = getTime();     // Catch: Throwable -> L9
        FLog.w(TAG, "time %d: onRequestFailure: {requestId: %s, elapsedTime: %d ms, throwable: %s}", new Object[]{Long.valueOf(r104), r101, Long.valueOf(getElapsedTime(r103, r104)), r102.toString()});     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public synchronized void onRequestStart(ImageRequest r100, Object r101, String r102, boolean r110) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (FLog.isLoggable(2) == false) goto L7;
        FLog.v(TAG, "time %d: onRequestSubmit: {requestId: %s, callerContext: %s, isPrefetch: %b}", Long.valueOf(getTime()), r102, r101, Boolean.valueOf(r110));     // Catch: Throwable -> L9
        this.mRequestStartTimeMap.put(r102, Long.valueOf(getTime()));     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }
}
