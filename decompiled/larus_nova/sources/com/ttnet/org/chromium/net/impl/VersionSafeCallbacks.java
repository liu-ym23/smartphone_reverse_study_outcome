package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.BidirectionalStream;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.NetworkQualityRttListener;
import com.ttnet.org.chromium.net.NetworkQualityThroughputListener;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import com.ttnet.org.chromium.net.UrlRequest;
import com.ttnet.org.chromium.net.UrlResponseInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes41.dex */
public class VersionSafeCallbacks {

    public static final class BidirectionalStreamCallback extends BidirectionalStream.Callback {
        private final BidirectionalStream.Callback mWrappedCallback;

        public BidirectionalStreamCallback(BidirectionalStream.Callback r100) {
            this.mWrappedCallback = r100;
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onStreamReady(BidirectionalStream r100) {
            this.mWrappedCallback.onStreamReady(r100);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onCanceled(BidirectionalStream r100, UrlResponseInfo r101) {
            this.mWrappedCallback.onCanceled(r100, r101);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onResponseHeadersReceived(BidirectionalStream r100, UrlResponseInfo r101) {
            this.mWrappedCallback.onResponseHeadersReceived(r100, r101);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onSucceeded(BidirectionalStream r100, UrlResponseInfo r101) {
            this.mWrappedCallback.onSucceeded(r100, r101);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onFailed(BidirectionalStream r100, UrlResponseInfo r101, CronetException r102) {
            this.mWrappedCallback.onFailed(r100, r101, r102);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onResponseTrailersReceived(BidirectionalStream r100, UrlResponseInfo r101, UrlResponseInfo.HeaderBlock r102) {
            this.mWrappedCallback.onResponseTrailersReceived(r100, r101, r102);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onReadCompleted(BidirectionalStream r100, UrlResponseInfo r101, ByteBuffer r102, boolean r103) {
            this.mWrappedCallback.onReadCompleted(r100, r101, r102, r103);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Callback
        public void onWriteCompleted(BidirectionalStream r100, UrlResponseInfo r101, ByteBuffer r102, boolean r103) {
            this.mWrappedCallback.onWriteCompleted(r100, r101, r102, r103);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class LibraryLoader extends CronetEngine.Builder.LibraryLoader {
        private final CronetEngine.Builder.LibraryLoader mWrappedLoader;

        public LibraryLoader(CronetEngine.Builder.LibraryLoader r100) {
            this.mWrappedLoader = r100;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder.LibraryLoader
        public void loadLibrary(String r100) {
            this.mWrappedLoader.loadLibrary(r100);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class NetworkQualityRttListenerWrapper extends NetworkQualityRttListener {
        private final NetworkQualityRttListener mWrappedListener;

        @Override // com.ttnet.org.chromium.net.NetworkQualityRttListener
        public Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }

        public int hashCode() {
            return this.mWrappedListener.hashCode();
        }

        public NetworkQualityRttListenerWrapper(NetworkQualityRttListener r100) {
            super(r100.getExecutor());
            this.mWrappedListener = r100;
        }

        public boolean equals(Object r100) {
            if (r100 != null) goto L4;
            return false;
        L4:
            if ((r100 instanceof NetworkQualityRttListenerWrapper) == true) goto L7;
            return false;
        L7:
            return this.mWrappedListener.equals(((NetworkQualityRttListenerWrapper) r100).mWrappedListener);
        }

        @Override // com.ttnet.org.chromium.net.NetworkQualityRttListener
        public void onRttObservation(int r100, long r101, int r102) {
            this.mWrappedListener.onRttObservation(r100, r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class NetworkQualityThroughputListenerWrapper extends NetworkQualityThroughputListener {
        private final NetworkQualityThroughputListener mWrappedListener;

        @Override // com.ttnet.org.chromium.net.NetworkQualityThroughputListener
        public Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }

        public int hashCode() {
            return this.mWrappedListener.hashCode();
        }

        public NetworkQualityThroughputListenerWrapper(NetworkQualityThroughputListener r100) {
            super(r100.getExecutor());
            this.mWrappedListener = r100;
        }

        public boolean equals(Object r100) {
            if (r100 != null) goto L4;
            return false;
        L4:
            if ((r100 instanceof NetworkQualityThroughputListenerWrapper) == true) goto L7;
            return false;
        L7:
            return this.mWrappedListener.equals(((NetworkQualityThroughputListenerWrapper) r100).mWrappedListener);
        }

        @Override // com.ttnet.org.chromium.net.NetworkQualityThroughputListener
        public void onThroughputObservation(int r100, long r101, int r102) {
            this.mWrappedListener.onThroughputObservation(r100, r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class RequestFinishedInfoListener extends RequestFinishedInfo.Listener {
        private final RequestFinishedInfo.Listener mWrappedListener;

        @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Listener
        public Executor getExecutor() {
            return this.mWrappedListener.getExecutor();
        }

        public RequestFinishedInfoListener(RequestFinishedInfo.Listener r100) {
            super(r100.getExecutor());
            this.mWrappedListener = r100;
        }

        @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Listener
        public void onRequestFinished(RequestFinishedInfo r100) {
            this.mWrappedListener.onRequestFinished(r100);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class UploadDataProviderWrapper extends UploadDataProvider {
        private final UploadDataProvider mWrappedProvider;

        @Override // com.ttnet.org.chromium.net.UploadDataProvider, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.mWrappedProvider.close();
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() throws IOException {
            return this.mWrappedProvider.getLength();
        }

        public UploadDataProviderWrapper(UploadDataProvider r100) {
            this.mWrappedProvider = r100;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r100) throws IOException {
            this.mWrappedProvider.rewind(r100);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r100, ByteBuffer r101) throws IOException {
            this.mWrappedProvider.read(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class UrlRequestCallback extends UrlRequest.Callback {
        private final UrlRequest.Callback mWrappedCallback;

        public UrlRequestCallback(UrlRequest.Callback r100) {
            this.mWrappedCallback = r100;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onCanceled(UrlRequest r100, UrlResponseInfo r101) {
            this.mWrappedCallback.onCanceled(r100, r101);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onSucceeded(UrlRequest r100, UrlResponseInfo r101) {
            this.mWrappedCallback.onSucceeded(r100, r101);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onFailed(UrlRequest r100, UrlResponseInfo r101, CronetException r102) {
            this.mWrappedCallback.onFailed(r100, r101, r102);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onReadCompleted(UrlRequest r100, UrlResponseInfo r101, ByteBuffer r102) throws Exception {
            this.mWrappedCallback.onReadCompleted(r100, r101, r102);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onResponseStarted(UrlRequest r100, UrlResponseInfo r101, String r102) throws Exception {
            this.mWrappedCallback.onResponseStarted(r100, r101, r102);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onRedirectReceived(UrlRequest r100, UrlResponseInfo r101, String r102, String r103) throws Exception {
            this.mWrappedCallback.onRedirectReceived(r100, r101, r102, r103);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class UrlRequestStatusListener extends UrlRequest.StatusListener {
        private final UrlRequest.StatusListener mWrappedListener;

        public UrlRequestStatusListener(UrlRequest.StatusListener r100) {
            this.mWrappedListener = r100;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.StatusListener
        public void onStatus(int r100) {
            this.mWrappedListener.onStatus(r100);
        }
    }

    public VersionSafeCallbacks() {
    }
}
