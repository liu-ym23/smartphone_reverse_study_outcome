package com.ss.android.lark.image.impl.compress2;

/* JADX INFO: loaded from: classes36.dex */
class CompressRequest {
    IImageSource iImageSource;

    /* JADX INFO: renamed from: com.ss.android.lark.image.impl.compress2.CompressRequest$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private IImageSource iImageSource;

        public CompressRequest build() {
            return new CompressRequest(this, null);
        }

        private Builder() {
        }

        public /* synthetic */ Builder(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ IImageSource access$000(Builder r100) {
            return r100.iImageSource;
        }

        public Builder iImageSource(IImageSource r100) {
            this.iImageSource = r100;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    private CompressRequest(Builder r100) {
        this.iImageSource = Builder.access$000(r100);
    }

    public /* synthetic */ CompressRequest(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
