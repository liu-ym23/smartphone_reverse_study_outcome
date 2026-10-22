package com.ss.android.lark.resource.service;

import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public class AvatarFsUnitParams implements Serializable {
    private AvatarResourceParams.CutType cutType;
    private AvatarResourceParams.ImageFormat imageFormat;
    private ImageSizeType imageSizeType;
    private boolean isNoop;
    private com.bytedance.lark.pb.media.v1.AvatarFsUnitParams.Quality quality;

    public static final enum ImageSizeType extends Enum<ImageSizeType> {
        public static final ImageSizeType BIG = null;
        public static final ImageSizeType MIDDLE = null;
        public static final ImageSizeType ORIGIN = null;
        public static final ImageSizeType SMALL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ImageSizeType[] f439528a = null;
        private int value;

        static {
            ImageSizeType r100 = new ImageSizeType("SMALL", 0, 1);
            SMALL = r100;
            ImageSizeType r101 = new ImageSizeType("MIDDLE", 1, 2);
            MIDDLE = r101;
            ImageSizeType r102 = new ImageSizeType("BIG", 2, 3);
            BIG = r102;
            ImageSizeType r103 = new ImageSizeType("ORIGIN", 3, 4);
            ORIGIN = r103;
            f439528a = new ImageSizeType[]{r100, r101, r102, r103};
        }

        public static ImageSizeType[] values() {
            return (ImageSizeType[]) f439528a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static ImageSizeType forNumber(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return ORIGIN;
        L13:
            return ORIGIN;
        L15:
            return BIG;
        L17:
            return MIDDLE;
        L19:
            return SMALL;
        }

        public static ImageSizeType valueOf(String r100) {
            return (ImageSizeType) r27.a.a(ImageSizeType.class, r100);
        }

        public static ImageSizeType valueOf(int r100) {
            return forNumber(r100);
        }

        public ImageSizeType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public AvatarFsUnitParams() {
        this.cutType = AvatarResourceParams.CutType.FACE;
        this.imageSizeType = ImageSizeType.ORIGIN;
        this.imageFormat = AvatarResourceParams.ImageFormat.PNG;
    }

    public AvatarResourceParams.CutType getCutType() {
        return this.cutType;
    }

    public AvatarResourceParams.ImageFormat getImageFormat() {
        return this.imageFormat;
    }

    public ImageSizeType getImageSizeType() {
        return this.imageSizeType;
    }

    public com.bytedance.lark.pb.media.v1.AvatarFsUnitParams.Quality getQuality() {
        return this.quality;
    }

    public boolean isNoop() {
        return this.isNoop;
    }

    public void setCutType(AvatarResourceParams.CutType r100) {
        this.cutType = r100;
    }

    public void setImageFormat(AvatarResourceParams.ImageFormat r100) {
        this.imageFormat = r100;
    }

    public void setImageSizeType(ImageSizeType r100) {
        this.imageSizeType = r100;
    }

    public void setNoop(boolean r100) {
        this.isNoop = r100;
    }

    public void setQuality(int r100) {
        if (r100 > 1) goto L6;
        this.quality = com.bytedance.lark.pb.media.v1.AvatarFsUnitParams.Quality.Q1;
        return;
    L6:
        if (r100 > 70) goto L8;
        this.quality = com.bytedance.lark.pb.media.v1.AvatarFsUnitParams.Quality.Q70;
        return;
    L8:
        this.quality = com.bytedance.lark.pb.media.v1.AvatarFsUnitParams.Quality.Q_NOOP;
    }
}
