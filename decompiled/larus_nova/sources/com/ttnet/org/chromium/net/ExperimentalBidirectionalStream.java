package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ExperimentalBidirectionalStream extends BidirectionalStream {

    public static abstract class Builder extends BidirectionalStream.Builder {
        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public abstract Builder addHeader(String r100, String r101);

        public Builder addRequestAnnotation(Object r100) {
            return this;
        }

        public Builder bindToNetwork(long r100) {
            return this;
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public abstract ExperimentalBidirectionalStream build();

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public abstract Builder delayRequestHeadersUntilFirstFlush(boolean r100);

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public abstract Builder setHttpMethod(String r100);

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public abstract Builder setPriority(int r100);

        public Builder setTrafficStatsTag(int r100) {
            return this;
        }

        public Builder setTrafficStatsUid(int r100) {
            return this;
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public /* bridge */ /* synthetic */ BidirectionalStream build() {
            return build();
        }

        public Builder() {
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public /* bridge */ /* synthetic */ BidirectionalStream.Builder delayRequestHeadersUntilFirstFlush(boolean r100) {
            return delayRequestHeadersUntilFirstFlush(r100);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public /* bridge */ /* synthetic */ BidirectionalStream.Builder setHttpMethod(String r100) {
            return setHttpMethod(r100);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public /* bridge */ /* synthetic */ BidirectionalStream.Builder setPriority(int r100) {
            return setPriority(r100);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public /* bridge */ /* synthetic */ BidirectionalStream.Builder addHeader(String r100, String r101) {
            return addHeader(r100, r101);
        }
    }

    public ExperimentalBidirectionalStream() {
    }
}
