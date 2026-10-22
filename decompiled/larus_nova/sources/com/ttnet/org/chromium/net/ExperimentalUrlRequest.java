package com.ttnet.org.chromium.net;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ExperimentalUrlRequest extends UrlRequest {

    public static abstract class Builder extends UrlRequest.Builder {
        public static final int DEFAULT_IDEMPOTENCY = 0;
        public static final int IDEMPOTENT = 1;
        public static final int NOT_IDEMPOTENT = 2;

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public abstract Builder addHeader(String r100, String r101);

        public Builder addRequestAnnotation(Object r100) {
            return this;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public abstract Builder allowDirectExecutor();

        public Builder bindToNetwork(long r100) {
            return this;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public abstract ExperimentalUrlRequest build();

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public abstract Builder disableCache();

        public Builder disableConnectionMigration() {
            return this;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public abstract Builder setHttpMethod(String r100);

        public Builder setIdempotency(int r100) {
            return this;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public abstract Builder setPriority(int r100);

        public Builder setRequestFinishedListener(RequestFinishedInfo.Listener r100) {
            return this;
        }

        public Builder setTrafficStatsTag(int r100) {
            return this;
        }

        public Builder setTrafficStatsUid(int r100) {
            return this;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public abstract Builder setUploadDataProvider(UploadDataProvider r100, Executor r101);

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public /* bridge */ /* synthetic */ UrlRequest.Builder allowDirectExecutor() {
            return allowDirectExecutor();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public /* bridge */ /* synthetic */ UrlRequest build() {
            return build();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public /* bridge */ /* synthetic */ UrlRequest.Builder disableCache() {
            return disableCache();
        }

        public Builder() {
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public /* bridge */ /* synthetic */ UrlRequest.Builder setHttpMethod(String r100) {
            return setHttpMethod(r100);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public /* bridge */ /* synthetic */ UrlRequest.Builder setPriority(int r100) {
            return setPriority(r100);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public /* bridge */ /* synthetic */ UrlRequest.Builder addHeader(String r100, String r101) {
            return addHeader(r100, r101);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
        public /* bridge */ /* synthetic */ UrlRequest.Builder setUploadDataProvider(UploadDataProvider r100, Executor r101) {
            return setUploadDataProvider(r100, r101);
        }
    }

    public ExperimentalUrlRequest() {
    }
}
