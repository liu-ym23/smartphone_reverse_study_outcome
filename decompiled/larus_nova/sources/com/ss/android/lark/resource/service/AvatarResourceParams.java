package com.ss.android.lark.resource.service;

import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public class AvatarResourceParams implements Serializable {
    private CutType cutType;
    private ImageFormat format;
    private String fsUnit;
    private int height;
    private boolean isOnlyLocal;
    private boolean noop;
    private int quality;
    private int width;

    public static final enum CutType extends Enum<CutType> {
        public static final CutType BOTTOM = null;
        public static final CutType CENTER = null;
        public static final CutType FACE = null;
        public static final CutType LEFT = null;
        public static final CutType NOOP = null;
        public static final CutType RIGHT = null;
        public static final CutType TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CutType[] f439529a = null;
        private int value;

        static {
            CutType r100 = new CutType("TOP", 0, 1);
            TOP = r100;
            CutType r101 = new CutType("BOTTOM", 1, 2);
            BOTTOM = r101;
            CutType r102 = new CutType("LEFT", 2, 3);
            LEFT = r102;
            CutType r103 = new CutType("RIGHT", 3, 4);
            RIGHT = r103;
            CutType r104 = new CutType("CENTER", 4, 5);
            CENTER = r104;
            CutType r110 = new CutType("FACE", 5, 6);
            FACE = r110;
            CutType r111 = new CutType("NOOP", 6, 7);
            NOOP = r111;
            f439529a = new CutType[]{r100, r101, r102, r103, r104, r110, r111};
        }

        public static CutType[] values() {
            return (CutType[]) f439529a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static CutType forNumber(int r100) {
            switch(r100) {
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L4;
            };
        L4:
            return FACE;
        L6:
            return NOOP;
        L8:
            return FACE;
        L10:
            return CENTER;
        L12:
            return RIGHT;
        L14:
            return LEFT;
        L16:
            return BOTTOM;
        L18:
            return TOP;
        }

        public static CutType valueOf(String r100) {
            return (CutType) r27.a.a(CutType.class, r100);
        }

        public static CutType valueOf(int r100) {
            return forNumber(r100);
        }

        public CutType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ImageFormat extends Enum<ImageFormat> {
        public static final ImageFormat JPEG = null;
        public static final ImageFormat PNG = null;
        public static final ImageFormat WEBP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ImageFormat[] f439530a = null;
        private int value;

        static {
            ImageFormat r100 = new ImageFormat("WEBP", 0, 1);
            WEBP = r100;
            ImageFormat r101 = new ImageFormat("JPEG", 1, 2);
            JPEG = r101;
            ImageFormat r102 = new ImageFormat("PNG", 2, 3);
            PNG = r102;
            f439530a = new ImageFormat[]{r100, r101, r102};
        }

        public static ImageFormat[] values() {
            return (ImageFormat[]) f439530a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static ImageFormat forNumber(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return PNG;
        L11:
            return PNG;
        L13:
            return JPEG;
        L15:
            return WEBP;
        }

        public static ImageFormat valueOf(String r100) {
            return (ImageFormat) r27.a.a(ImageFormat.class, r100);
        }

        public static ImageFormat valueOf(int r100) {
            return forNumber(r100);
        }

        public ImageFormat(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public int getQuality() {
        int r100 = this.quality;
        if (r100 > 1) goto L6;
        return 1;
    L6:
        if (r100 > 70) goto L8;
        return 70;
    L8:
        return 100;
    }

    public AvatarResourceParams() {
        this.cutType = CutType.FACE;
        this.format = ImageFormat.PNG;
        this.quality = 70;
    }

    public CutType getCutType() {
        return this.cutType;
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

    public int getWidth() {
        return this.width;
    }

    public boolean isNoop() {
        return this.noop;
    }

    public boolean isOnlyLocal() {
        return this.isOnlyLocal;
    }

    public void setCutType(CutType r100) {
        this.cutType = r100;
    }

    public void setFormat(ImageFormat r100) {
        this.format = r100;
    }

    public void setFsUnit(String r100) {
        this.fsUnit = r100;
    }

    public void setHeight(int r100) {
        this.height = r100;
    }

    public void setIsOnlyLocal(boolean r100) {
        this.isOnlyLocal = r100;
    }

    public void setNoop(boolean r100) {
        this.noop = r100;
    }

    public void setQuality(int r100) {
        this.quality = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }
}
