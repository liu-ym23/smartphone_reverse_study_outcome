package com.ss.android.lark.image.impl.compress2;

import android.text.TextUtils;
import com.larksuite.framework.utils.s;
import java.util.Objects;

/* JADX INFO: loaded from: classes36.dex */
class ImageCacheKey {
    private int expectQuality;
    private int expectShortSize;
    private String fileKey;

    /* JADX INFO: renamed from: com.ss.android.lark.image.impl.compress2.ImageCacheKey$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private int expectQuality;
        private int expectShortSize;
        private String fileKey;

        public ImageCacheKey build() {
            return new ImageCacheKey(this, null);
        }

        public String toKey() {
            return ImageCacheKey.access$500(build());
        }

        private Builder() {
        }

        public /* synthetic */ Builder(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ String access$000(Builder r100) {
            return r100.fileKey;
        }

        public static /* synthetic */ int access$100(Builder r100) {
            return r100.expectShortSize;
        }

        public static /* synthetic */ int access$200(Builder r100) {
            return r100.expectQuality;
        }

        public Builder expectQuality(int r100) {
            this.expectQuality = r100;
            return this;
        }

        public Builder expectShortSize(int r100) {
            this.expectShortSize = r100;
            return this;
        }

        public Builder fileKey(String r100) {
            this.fileKey = r100;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    private String toKey() {
        String r100 = s.b(this.fileKey);
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = String.valueOf(Objects.hashCode(this.fileKey));
    L6:
        return String.format("%s_%d_%d", new Object[]{r100, Integer.valueOf(this.expectQuality), Integer.valueOf(this.expectShortSize)});
    }

    private ImageCacheKey(Builder r100) {
        this.fileKey = Builder.access$000(r100);
        this.expectShortSize = Builder.access$100(r100);
        this.expectQuality = Builder.access$200(r100);
    }

    public static /* synthetic */ String access$500(ImageCacheKey r100) {
        return r100.toKey();
    }

    public /* synthetic */ ImageCacheKey(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
