package com.ss.android.lark.image.impl.compress2;

import java.io.File;

/* JADX INFO: loaded from: classes36.dex */
public class CompressResult {
    public File compressImageFile;
    public final Throwable error;
    public int originHeight;
    public long originSize;
    public int originWidth;
    public int outHeight;
    public long outSize;
    public int outWidth;

    /* JADX INFO: renamed from: com.ss.android.lark.image.impl.compress2.CompressResult$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private File compressImageFile;
        private Throwable error;
        private int originHeight;
        private long originSize;
        private int originWidth;
        private int outHeight;
        private long outSize;
        private int outWidth;

        public CompressResult build() {
            return new CompressResult(this, null);
        }

        private Builder() {
        }

        public /* synthetic */ Builder(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ Throwable access$000(Builder r100) {
            return r100.error;
        }

        public static /* synthetic */ int access$100(Builder r100) {
            return r100.outWidth;
        }

        public static /* synthetic */ int access$200(Builder r100) {
            return r100.outHeight;
        }

        public static /* synthetic */ long access$300(Builder r100) {
            return r100.outSize;
        }

        public static /* synthetic */ int access$400(Builder r100) {
            return r100.originWidth;
        }

        public static /* synthetic */ int access$500(Builder r100) {
            return r100.originHeight;
        }

        public static /* synthetic */ long access$600(Builder r100) {
            return r100.originSize;
        }

        public static /* synthetic */ File access$700(Builder r100) {
            return r100.compressImageFile;
        }

        public Builder compressImageFile(File r100) {
            this.compressImageFile = r100;
            return this;
        }

        public Builder originHeight(int r100) {
            this.originHeight = r100;
            return this;
        }

        public Builder originSize(long r100) {
            this.originSize = r100;
            return this;
        }

        public Builder originWidth(int r100) {
            this.originWidth = r100;
            return this;
        }

        public Builder outHeight(int r100) {
            this.outHeight = r100;
            return this;
        }

        public Builder outSize(long r100) {
            this.outSize = r100;
            return this;
        }

        public Builder outWidth(int r100) {
            this.outWidth = r100;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public float getCompressRatio() {
        long r100 = this.outSize;
        if (r100 <= 0) goto L8;
        long r101 = this.originSize;
        if (r101 > 0) goto L7;
        return 1.0f;
    L7:
        return (r100 * 1.0f) / r101;
    L8:
        return 1.0f;
    }

    private CompressResult(Builder r100) {
        this.error = Builder.access$000(r100);
        this.outWidth = Builder.access$100(r100);
        this.outHeight = Builder.access$200(r100);
        this.outSize = Builder.access$300(r100);
        this.originWidth = Builder.access$400(r100);
        this.originHeight = Builder.access$500(r100);
        this.originSize = Builder.access$600(r100);
        this.compressImageFile = Builder.access$700(r100);
    }

    public CompressResult(Throwable r100) {
        this.error = r100;
    }

    public /* synthetic */ CompressResult(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
