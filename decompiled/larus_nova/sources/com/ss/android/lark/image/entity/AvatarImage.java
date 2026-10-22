package com.ss.android.lark.image.entity;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: loaded from: classes36.dex */
public class AvatarImage implements Key, Serializable {
    private static final String LOG_TAG = "AvatarImage";
    private volatile transient byte[] cacheKeyBytes;
    private long createTime;
    private CutType cutType;
    private long decodeStartTime;
    private String entityId;
    private transient ErrorResult errorResult;
    private ImageFormat format;
    private String fsUnit;
    private int height;
    private boolean isOnlyLocal;
    private String key;
    private boolean noop;
    private int quality;
    private long resourceSize;
    private long waitTime;
    private int width;

    public static class Builder {
        private CutType cutType;
        private String entityId;
        private ImageFormat format;
        private String fsUnit;
        private int height;
        private boolean isOnlyLocal;
        private String key;
        private boolean noop;
        private int quality;
        private int width;

        public AvatarImage build() {
            return new AvatarImage(this, null);
        }

        public Builder(String r100) {
            this.width = 0;
            this.height = 0;
            this.cutType = CutType.FACE;
            this.format = ImageFormat.WEBP;
            this.quality = 70;
            this.fsUnit = r100;
        }

        public static /* synthetic */ String access$000(Builder r100) {
            return r100.key;
        }

        public static /* synthetic */ String access$100(Builder r100) {
            return r100.entityId;
        }

        public static /* synthetic */ int access$200(Builder r100) {
            return r100.width;
        }

        public static /* synthetic */ int access$300(Builder r100) {
            return r100.height;
        }

        public static /* synthetic */ CutType access$400(Builder r100) {
            return r100.cutType;
        }

        public static /* synthetic */ ImageFormat access$500(Builder r100) {
            return r100.format;
        }

        public static /* synthetic */ int access$600(Builder r100) {
            return r100.quality;
        }

        public static /* synthetic */ boolean access$700(Builder r100) {
            return r100.noop;
        }

        public static /* synthetic */ boolean access$800(Builder r100) {
            return r100.isOnlyLocal;
        }

        public static /* synthetic */ String access$900(Builder r100) {
            return r100.fsUnit;
        }

        public Builder cutType(CutType r100) {
            this.cutType = r100;
            return this;
        }

        public Builder format(ImageFormat r100) {
            this.format = r100;
            return this;
        }

        public Builder fsUnit(String r100) {
            this.fsUnit = r100;
            return this;
        }

        public Builder isOnlyLocal(boolean r100) {
            this.isOnlyLocal = r100;
            return this;
        }

        public Builder noop(boolean r100) {
            this.noop = r100;
            return this;
        }

        public Builder quality(int r100) {
            this.quality = r100;
            return this;
        }

        private Builder(String r100, String r101, int r102, int r103) {
            this.width = 0;
            this.height = 0;
            this.cutType = CutType.FACE;
            this.format = ImageFormat.WEBP;
            this.quality = 70;
            this.key = r100;
            this.entityId = r101;
            this.width = r102;
            this.height = r103;
        }

        public static Builder obtain(String r100, String r101, int r102, int r103) {
            return new Builder(r100, r101, r102, r103);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f426280a = null;

        static {
            int[] r100 = new int[ImageFormat.values().length];
            f426280a = r100;
            r100[ImageFormat.PNG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f426280a[ImageFormat.JPEG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f426280a[ImageFormat.HEIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) goto L6;
        this.cacheKeyBytes = getId().getBytes(Key.CHARSET);
    L6:
        return this.cacheKeyBytes;
    }

    private String getId() {
        if (this.noop == false) goto L7;
        return this.key + "_origin";
    L7:
        return this.key + "_w" + this.width + "_h" + this.height + "_format" + this.format + "_quality" + this.quality + "isOnlyLocal" + this.isOnlyLocal;
    }

    public long getEntityId() {
        if (TextUtils.isEmpty(this.entityId) == false) goto L9;
        return 0;
    L9:
        return CastLongProtector.parseLong(this.entityId);
    L7:
        Log.e(LOG_TAG, "Failed to convert id to long, avatar is:" + this);
        return 0;
    }

    public String getImageType() {
        ImageFormat r100 = this.format;
        if (r100 != null) goto L5;
        return "webp";
    L5:
        int r101 = a.f426280a[r100.ordinal()];
        if (r101 != 1) goto L8;
        return LoadParams.ImageFormat.PNG;
    L8:
        if (r101 != 2) goto L10;
        return "jpg";
    L10:
        if (r101 == 3) goto L12;
        return "webp";
    L12:
        return "heic";
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Objects.hash(new Object[]{this.key, this.entityId, Integer.valueOf(this.width), Integer.valueOf(this.height), this.cutType, this.format, Integer.valueOf(this.quality), Boolean.valueOf(this.noop), Boolean.valueOf(this.isOnlyLocal)});
    }

    public String toString() {
        return "avatar#Key is: " + this.key + ", entityId is: " + this.entityId + ", width is: " + this.width + ", height is: " + this.height;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public CutType getCutType() {
        return this.cutType;
    }

    public long getDecodeStartTime() {
        return this.decodeStartTime;
    }

    public String getEntityIdStr() {
        return this.entityId;
    }

    public ErrorResult getErrorResult() {
        return this.errorResult;
    }

    public ImageFormat getFormat() {
        return this.format;
    }

    public String getFsUnit() {
        return this.fsUnit;
    }

    public int getHeight() {
        return this.height;
    }

    public String getImageId() {
        return this.key;
    }

    public String getKey() {
        return this.key;
    }

    public int getQuality() {
        return this.quality;
    }

    public long getResourceSize() {
        return this.resourceSize;
    }

    public long getWaitTime() {
        return this.waitTime;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isNoop() {
        return this.noop;
    }

    public boolean isOnlyLocal() {
        return this.isOnlyLocal;
    }

    private AvatarImage(Builder r100) {
        this.width = 0;
        this.height = 0;
        this.cutType = CutType.FACE;
        this.format = ImageFormat.WEBP;
        this.quality = 70;
        this.key = Builder.access$000(r100);
        this.entityId = Builder.access$100(r100);
        this.width = Builder.access$200(r100);
        this.height = Builder.access$300(r100);
        this.cutType = Builder.access$400(r100);
        this.format = Builder.access$500(r100);
        this.quality = Builder.access$600(r100);
        this.noop = Builder.access$700(r100);
        this.isOnlyLocal = Builder.access$800(r100);
        this.fsUnit = Builder.access$900(r100);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L31:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L31;
        AvatarImage r101 = (AvatarImage) r100;
        if (this.width == r101.width) goto L13;
    L29:
        return false;
    L13:
        if (this.height != r101.height) goto L29;
        if (this.quality != r101.quality) goto L29;
        if (this.noop != r101.noop) goto L29;
        if (this.isOnlyLocal != r101.isOnlyLocal) goto L29;
        if (Objects.equals(this.key, r101.key) == false) goto L29;
        String r102 = this.entityId;
        if (Objects.equals(r102, r102) == false) goto L29;
        if (this.cutType != r101.cutType) goto L29;
        if (this.format != r101.format) goto L29;
        return true;
    }

    public AvatarImage setCutType(CutType r100) {
        this.cutType = r100;
        return this;
    }

    public void setDecodeStartTime(long r100) {
        this.decodeStartTime = r100;
    }

    public void setErrorResult(ErrorResult r100) {
        this.errorResult = r100;
    }

    public AvatarImage setHeight(int r100) {
        this.height = r100;
        return this;
    }

    public AvatarImage setImageFormat(ImageFormat r100) {
        this.format = r100;
        return this;
    }

    public AvatarImage setKey(String r100) {
        this.key = r100;
        return this;
    }

    public AvatarImage setNoop(boolean r100) {
        this.noop = r100;
        return this;
    }

    public AvatarImage setOnlyLocal(boolean r100) {
        this.isOnlyLocal = r100;
        return this;
    }

    public void setResourceSize(long r100) {
        this.resourceSize = r100;
    }

    public void setWaitTime(long r100) {
        this.waitTime = r100;
    }

    public AvatarImage setWidth(int r100) {
        this.width = r100;
        return this;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(getCacheKeyBytes());
    }

    public /* synthetic */ AvatarImage(Builder r100, a r101) {
        this(r100);
    }
}
