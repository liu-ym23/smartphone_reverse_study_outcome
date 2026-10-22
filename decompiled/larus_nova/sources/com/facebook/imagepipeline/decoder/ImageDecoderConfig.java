package com.facebook.imagepipeline.decoder;

import com.facebook.imageformat.ImageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ImageDecoderConfig {
    private final Map<ImageFormat, ImageDecoder> mCustomImageDecoders;
    private final List<ImageFormat.FormatChecker> mCustomImageFormats;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.decoder.ImageDecoderConfig$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes23.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private Map<ImageFormat, ImageDecoder> mCustomImageDecoders;
        private List<ImageFormat.FormatChecker> mCustomImageFormats;

        public Builder() {
        }

        public ImageDecoderConfig build() {
            return new ImageDecoderConfig(this, null);
        }

        public static /* synthetic */ Map access$000(Builder r100) {
            return r100.mCustomImageDecoders;
        }

        public static /* synthetic */ List access$100(Builder r100) {
            return r100.mCustomImageFormats;
        }

        public Builder overrideDecoder(ImageFormat r100, ImageDecoder r101) {
            if (this.mCustomImageDecoders != null) goto L5;
            this.mCustomImageDecoders = new HashMap();
        L5:
            this.mCustomImageDecoders.put(r100, r101);
            return this;
        }

        public Builder addDecodingCapability(ImageFormat r100, ImageFormat.FormatChecker r101, ImageDecoder r102) {
            if (this.mCustomImageFormats != null) goto L5;
            this.mCustomImageFormats = new ArrayList();
        L5:
            this.mCustomImageFormats.add(r101);
            overrideDecoder(r100, r102);
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Map<ImageFormat, ImageDecoder> getCustomImageDecoders() {
        return this.mCustomImageDecoders;
    }

    public List<ImageFormat.FormatChecker> getCustomImageFormats() {
        return this.mCustomImageFormats;
    }

    private ImageDecoderConfig(Builder r100) {
        this.mCustomImageDecoders = Builder.access$000(r100);
        this.mCustomImageFormats = Builder.access$100(r100);
    }

    public /* synthetic */ ImageDecoderConfig(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
