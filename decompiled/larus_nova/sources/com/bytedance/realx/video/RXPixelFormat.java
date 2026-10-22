package com.bytedance.realx.video;

/* JADX INFO: loaded from: classes21.dex */
public final enum RXPixelFormat extends Enum<RXPixelFormat> {
    private static final /* synthetic */ RXPixelFormat[] $VALUES = null;
    public static final RXPixelFormat kArgb = null;
    public static final RXPixelFormat kBgra = null;
    public static final RXPixelFormat kI420 = null;
    public static final RXPixelFormat kIYUV = null;
    public static final RXPixelFormat kMJPEG = null;
    public static final RXPixelFormat kNative = null;
    public static final RXPixelFormat kNv12 = null;
    public static final RXPixelFormat kNv21 = null;
    public static final RXPixelFormat kRGB565 = null;
    public static final RXPixelFormat kRgb = null;
    public static final RXPixelFormat kRgb24 = null;
    public static final RXPixelFormat kRgba = null;
    public static final RXPixelFormat kTexture2D = null;
    public static final RXPixelFormat kTextureOES = null;
    public static final RXPixelFormat kUYVY = null;
    public static final RXPixelFormat kUnknown = null;
    public static final RXPixelFormat kYUY2 = null;
    public static final RXPixelFormat kYV12 = null;
    private int value;

    /* JADX INFO: renamed from: com.bytedance.realx.video.RXPixelFormat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$realx$video$RXPixelFormat = null;

        static {
            int[] r100 = new int[RXPixelFormat.values().length];
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat = r100;
            r100[RXPixelFormat.kArgb.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L60:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kBgra.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L44:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kRgba.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L56:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kI420.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L62:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kNv12.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L46:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kNv21.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L50:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kRgb.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L70:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kNative.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L40:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kIYUV.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L64:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kYUY2.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L66:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kYV12.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L52:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kUYVY.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L58:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kRGB565.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L42:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kMJPEG.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L48:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kTexture2D.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L68:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kTextureOES.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L38:
            $SwitchMap$com$bytedance$realx$video$RXPixelFormat[RXPixelFormat.kUnknown.ordinal()] = 17;     // Catch: NoSuchFieldError -> L37
            return;
        }
    }

    static {
        RXPixelFormat r100 = new RXPixelFormat("kUnknown", 0, 0);
        kUnknown = r100;
        RXPixelFormat r101 = new RXPixelFormat("kArgb", 1, 1);
        kArgb = r101;
        RXPixelFormat r102 = new RXPixelFormat("kBgra", 2, 2);
        kBgra = r102;
        RXPixelFormat r103 = new RXPixelFormat("kRgba", 3, 3);
        kRgba = r103;
        RXPixelFormat r104 = new RXPixelFormat("kRgb24", 4, 4);
        kRgb24 = r104;
        RXPixelFormat r105 = new RXPixelFormat("kI420", 5, 5);
        kI420 = r105;
        RXPixelFormat r110 = new RXPixelFormat("kNv12", 6, 6);
        kNv12 = r110;
        RXPixelFormat r111 = new RXPixelFormat("kNv21", 7, 7);
        kNv21 = r111;
        RXPixelFormat r112 = new RXPixelFormat("kRgb", 8, 8);
        kRgb = r112;
        RXPixelFormat r113 = new RXPixelFormat("kNative", 9, 9);
        kNative = r113;
        RXPixelFormat r114 = new RXPixelFormat("kIYUV", 10, 10);
        kIYUV = r114;
        RXPixelFormat r115 = new RXPixelFormat("kYUY2", 11, 11);
        kYUY2 = r115;
        RXPixelFormat r106 = new RXPixelFormat("kYV12", 12, 12);
        kYV12 = r106;
        RXPixelFormat r107 = new RXPixelFormat("kUYVY", 13, 13);
        kUYVY = r107;
        RXPixelFormat r108 = new RXPixelFormat("kRGB565", 14, 14);
        kRGB565 = r108;
        RXPixelFormat r109 = new RXPixelFormat("kMJPEG", 15, 15);
        kMJPEG = r109;
        RXPixelFormat r116 = new RXPixelFormat("kTexture2D", 16, 16);
        kTexture2D = r116;
        RXPixelFormat r117 = new RXPixelFormat("kTextureOES", 17, 17);
        kTextureOES = r117;
        $VALUES = new RXPixelFormat[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117};
    }

    public static RXPixelFormat[] values() {
        return (RXPixelFormat[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$bytedance$realx$video$RXPixelFormat[ordinal()]) {
            case 1: goto L36;
            case 2: goto L34;
            case 3: goto L32;
            case 4: goto L30;
            case 5: goto L28;
            case 6: goto L26;
            case 7: goto L24;
            case 8: goto L22;
            case 9: goto L20;
            case 10: goto L18;
            case 11: goto L16;
            case 12: goto L14;
            case 13: goto L12;
            case 14: goto L10;
            case 15: goto L8;
            case 16: goto L6;
            default: goto L4;
        };
    L4:
        return "kUnknown";
    L6:
        return "kTextureOES";
    L8:
        return "kTexture2D";
    L10:
        return "kMJPEG";
    L12:
        return "kRGB565";
    L14:
        return "kUYVY";
    L16:
        return "kYV12";
    L18:
        return "kYUY2";
    L20:
        return "kIYUV";
    L22:
        return "kNative";
    L24:
        return "kRgb";
    L26:
        return "kNv21";
    L28:
        return "kNv12";
    L30:
        return "kI420";
    L32:
        return "kRgba";
    L34:
        return "kBgra";
    L36:
        return "kArgb";
    }

    public int value() {
        return this.value;
    }

    public static RXPixelFormat fromId(int r100) {
        if (r100 == 3553) goto L17;
        if (r100 == 36197) goto L15;
        RXPixelFormat[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L12;
        RXPixelFormat r104 = r101[r103];
        if (r104.value() == r100) goto L10;
        r103 = r103 + 1;
        goto L7
    L10:
        return r104;
    L12:
        return null;
    L15:
        return kTextureOES;
    L17:
        return kTexture2D;
    }

    public static RXPixelFormat valueOf(String r100) {
        return (RXPixelFormat) r27.a.a(RXPixelFormat.class, r100);
    }

    private RXPixelFormat(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
