package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: classes8.dex */
public final enum PixelFormat extends Enum<PixelFormat> {
    private static final /* synthetic */ PixelFormat[] $VALUES = null;
    public static final PixelFormat kArgb = null;
    public static final PixelFormat kBgra = null;
    public static final PixelFormat kI420 = null;
    public static final PixelFormat kIYUV = null;
    public static final PixelFormat kMJPEG = null;
    public static final PixelFormat kNative = null;
    public static final PixelFormat kNv12 = null;
    public static final PixelFormat kNv21 = null;
    public static final PixelFormat kRGB565 = null;
    public static final PixelFormat kRgb = null;
    public static final PixelFormat kRgb24 = null;
    public static final PixelFormat kRgba = null;
    public static final PixelFormat kTexture2D = null;
    public static final PixelFormat kTextureOES = null;
    public static final PixelFormat kUYVY = null;
    public static final PixelFormat kUnknown = null;
    public static final PixelFormat kYUY2 = null;
    public static final PixelFormat kYV12 = null;
    private int value;

    /* JADX INFO: renamed from: com.bytedance.bmmt.video.PixelFormat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bmmt$video$PixelFormat = null;

        static {
            int[] r100 = new int[PixelFormat.values().length];
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat = r100;
            r100[PixelFormat.kArgb.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L60:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kBgra.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L44:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kRgba.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L56:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kI420.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L62:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kNv12.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L46:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kNv21.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L50:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kRgb.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L70:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kNative.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L40:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kIYUV.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L64:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kYUY2.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L66:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kYV12.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L52:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kUYVY.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L58:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kRGB565.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L42:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kMJPEG.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L48:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kTexture2D.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L68:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kTextureOES.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L38:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kUnknown.ordinal()] = 17;     // Catch: NoSuchFieldError -> L37
            return;
        }
    }

    private static /* synthetic */ PixelFormat[] $values() {
        return new PixelFormat[]{kUnknown, kArgb, kBgra, kRgba, kRgb24, kI420, kNv12, kNv21, kRgb, kNative, kIYUV, kYUY2, kYV12, kUYVY, kRGB565, kMJPEG, kTexture2D, kTextureOES};
    }

    static {
        kUnknown = new PixelFormat("kUnknown", 0, 0);
        kArgb = new PixelFormat("kArgb", 1, 1);
        kBgra = new PixelFormat("kBgra", 2, 2);
        kRgba = new PixelFormat("kRgba", 3, 3);
        kRgb24 = new PixelFormat("kRgb24", 4, 4);
        kI420 = new PixelFormat("kI420", 5, 5);
        kNv12 = new PixelFormat("kNv12", 6, 6);
        kNv21 = new PixelFormat("kNv21", 7, 7);
        kRgb = new PixelFormat("kRgb", 8, 8);
        kNative = new PixelFormat("kNative", 9, 9);
        kIYUV = new PixelFormat("kIYUV", 10, 10);
        kYUY2 = new PixelFormat("kYUY2", 11, 11);
        kYV12 = new PixelFormat("kYV12", 12, 12);
        kUYVY = new PixelFormat("kUYVY", 13, 13);
        kRGB565 = new PixelFormat("kRGB565", 14, 14);
        kMJPEG = new PixelFormat("kMJPEG", 15, 15);
        kTexture2D = new PixelFormat("kTexture2D", 16, 16);
        kTextureOES = new PixelFormat("kTextureOES", 17, 17);
        $VALUES = $values();
    }

    public static PixelFormat[] values() {
        return (PixelFormat[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$bytedance$bmmt$video$PixelFormat[ordinal()]) {
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

    public static PixelFormat fromId(int r100) {
        if (r100 == 3553) goto L17;
        if (r100 == 36197) goto L15;
        PixelFormat[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L12;
        PixelFormat r104 = r101[r103];
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

    public static PixelFormat valueOf(String r100) {
        return (PixelFormat) r27.a.a(PixelFormat.class, r100);
    }

    private PixelFormat(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
