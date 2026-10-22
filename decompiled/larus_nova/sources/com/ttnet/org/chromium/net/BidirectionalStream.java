package com.ttnet.org.chromium.net;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BidirectionalStream {

    public static abstract class Builder {
        public static final int STREAM_PRIORITY_HIGHEST = 4;
        public static final int STREAM_PRIORITY_IDLE = 0;
        public static final int STREAM_PRIORITY_LOW = 2;
        public static final int STREAM_PRIORITY_LOWEST = 1;
        public static final int STREAM_PRIORITY_MEDIUM = 3;

        public Builder() {
        }

        public abstract Builder addHeader(String r100, String r101);

        public abstract BidirectionalStream build();

        public abstract Builder delayRequestHeadersUntilFirstFlush(boolean r100);

        public abstract Builder setHttpMethod(String r100);

        public abstract Builder setPriority(int r100);
    }

    public static abstract class Callback {
        public Callback() {
        }

        public void onCanceled(BidirectionalStream r100, UrlResponseInfo r101) {
        }

        public abstract void onFailed(BidirectionalStream r100, UrlResponseInfo r101, CronetException r102);

        public abstract void onReadCompleted(BidirectionalStream r100, UrlResponseInfo r101, ByteBuffer r102, boolean r103);

        public abstract void onResponseHeadersReceived(BidirectionalStream r100, UrlResponseInfo r101);

        public void onResponseTrailersReceived(BidirectionalStream r100, UrlResponseInfo r101, UrlResponseInfo.HeaderBlock r102) {
        }

        public abstract void onStreamReady(BidirectionalStream r100);

        public abstract void onSucceeded(BidirectionalStream r100, UrlResponseInfo r101);

        public abstract void onWriteCompleted(BidirectionalStream r100, UrlResponseInfo r101, ByteBuffer r102, boolean r103);
    }

    public BidirectionalStream() {
    }

    public abstract void cancel();

    public abstract void flush();

    public abstract boolean isDone();

    public abstract void read(ByteBuffer r100);

    public abstract void start();

    public abstract void write(ByteBuffer r100, boolean r101);
}
