package com.bytedance.realx.video;

/* JADX INFO: loaded from: classes21.dex */
public final enum RXVideoScaleFilter extends Enum<RXVideoScaleFilter> {
    private static final /* synthetic */ RXVideoScaleFilter[] $VALUES = null;
    public static final RXVideoScaleFilter kFFMPegBicubic = null;
    public static final RXVideoScaleFilter kFFMPegBilinear = null;
    public static final RXVideoScaleFilter kFFMPegFastBilinear = null;
    public static final RXVideoScaleFilter kFFMPegGauss = null;
    public static final RXVideoScaleFilter kFFMPegLanczos = null;
    public static final RXVideoScaleFilter kLibYUVBilinear = null;
    public static final RXVideoScaleFilter kLibYUVBox = null;
    public static final RXVideoScaleFilter kLibYUVLinear = null;
    public static final RXVideoScaleFilter kLibYUVNone = null;
    public static final RXVideoScaleFilter kOpenGLBicubic = null;
    public static final RXVideoScaleFilter kOpenGLBilinear = null;
    public static final RXVideoScaleFilter kOpenGLBox = null;
    public static final RXVideoScaleFilter kOpenGLOrigin = null;
    private int value;

    /* JADX INFO: renamed from: com.bytedance.realx.video.RXVideoScaleFilter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$realx$video$RXVideoScaleFilter = null;

        static {
            int[] r100 = new int[RXVideoScaleFilter.values().length];
            $SwitchMap$com$bytedance$realx$video$RXVideoScaleFilter = r100;
            r100[RXVideoScaleFilter.kLibYUVNone.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L34:
            $SwitchMap$com$bytedance$realx$video$RXVideoScaleFilter[RXVideoScaleFilter.kLibYUVLinear.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L40:
            $SwitchMap$com$bytedance$realx$video$RXVideoScaleFilter[RXVideoScaleFilter.kLibYUVBilinear.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L54:
            $SwitchMap$com$bytedance$realx$video$RXVideoScaleFilter[RXVideoScaleFilter.kLibYUVBox.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L36:
            $SwitchMap$com$bytedance$realx$video$RXVideoScaleFilter[RXVideoScaleFilter.kFFMPegFastBilinear.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L42:
            $SwitchMap$com$bytedance$realx$video$RXVideoScaleFilter[RXVideoScaleFilter.kFFMPegBilinear.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$com$bytedance$realx$video$RXVideoScaleFilter[RXVideoScaleFilter.kFFMPegBicubic.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L50:
            $SwitchMap$com$bytedance$realx$video$RXVideoScaleFilter[RXVideoScaleFilter.kFFMPegGauss.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L32:
            $SwitchMap$com$bytedance$realx$video$RXVideoScaleFilter[RXVideoScaleFilter.kFFMPegLanczos.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L38:
            $SwitchMap$com$bytedance$realx$video$RXVideoScaleFilter[RXVideoScaleFilter.kOpenGLOrigin.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$com$bytedance$realx$video$RXVideoScaleFilter[RXVideoScaleFilter.kOpenGLBilinear.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L48:
            $SwitchMap$com$bytedance$realx$video$RXVideoScaleFilter[RXVideoScaleFilter.kOpenGLBicubic.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L30:
            $SwitchMap$com$bytedance$realx$video$RXVideoScaleFilter[RXVideoScaleFilter.kOpenGLBox.ordinal()] = 13;     // Catch: NoSuchFieldError -> L29
            return;
        }
    }

    static {
        RXVideoScaleFilter r100 = new RXVideoScaleFilter("kLibYUVNone", 0, 0);
        kLibYUVNone = r100;
        RXVideoScaleFilter r101 = new RXVideoScaleFilter("kLibYUVLinear", 1, 1);
        kLibYUVLinear = r101;
        RXVideoScaleFilter r102 = new RXVideoScaleFilter("kLibYUVBilinear", 2, 2);
        kLibYUVBilinear = r102;
        RXVideoScaleFilter r103 = new RXVideoScaleFilter("kLibYUVBox", 3, 3);
        kLibYUVBox = r103;
        RXVideoScaleFilter r104 = new RXVideoScaleFilter("kFFMPegFastBilinear", 4, 4);
        kFFMPegFastBilinear = r104;
        RXVideoScaleFilter r105 = new RXVideoScaleFilter("kFFMPegBilinear", 5, 5);
        kFFMPegBilinear = r105;
        RXVideoScaleFilter r110 = new RXVideoScaleFilter("kFFMPegBicubic", 6, 6);
        kFFMPegBicubic = r110;
        RXVideoScaleFilter r111 = new RXVideoScaleFilter("kFFMPegGauss", 7, 7);
        kFFMPegGauss = r111;
        RXVideoScaleFilter r112 = new RXVideoScaleFilter("kFFMPegLanczos", 8, 8);
        kFFMPegLanczos = r112;
        RXVideoScaleFilter r113 = new RXVideoScaleFilter("kOpenGLOrigin", 9, 9);
        kOpenGLOrigin = r113;
        RXVideoScaleFilter r114 = new RXVideoScaleFilter("kOpenGLBilinear", 10, 10);
        kOpenGLBilinear = r114;
        RXVideoScaleFilter r115 = new RXVideoScaleFilter("kOpenGLBicubic", 11, 11);
        kOpenGLBicubic = r115;
        RXVideoScaleFilter r106 = new RXVideoScaleFilter("kOpenGLBox", 12, 12);
        kOpenGLBox = r106;
        $VALUES = new RXVideoScaleFilter[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
    }

    public static RXVideoScaleFilter[] values() {
        return (RXVideoScaleFilter[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$bytedance$realx$video$RXVideoScaleFilter[ordinal()]) {
            case 1: goto L30;
            case 2: goto L28;
            case 3: goto L26;
            case 4: goto L24;
            case 5: goto L22;
            case 6: goto L20;
            case 7: goto L18;
            case 8: goto L16;
            case 9: goto L14;
            case 10: goto L12;
            case 11: goto L10;
            case 12: goto L8;
            case 13: goto L6;
            default: goto L4;
        };
    L4:
        return "unknownValue";
    L6:
        return "kOpenGLBox";
    L8:
        return "kOpenGLBicubic";
    L10:
        return "kOpenGLBilinear";
    L12:
        return "kOpenGLOrigin";
    L14:
        return "kFFMPegLanczos";
    L16:
        return "kFFMPegGauss";
    L18:
        return "kFFMPegBicubic";
    L20:
        return "kFFMPegBilinear";
    L22:
        return "kFFMPegFastBilinear";
    L24:
        return "kLibYUVBox";
    L26:
        return "kLibYUVBilinear";
    L28:
        return "kLibYUVLinear";
    L30:
        return "kLibYUVNone";
    }

    public int value() {
        return this.value;
    }

    public static RXVideoScaleFilter fromId(int r100) {
        RXVideoScaleFilter[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        RXVideoScaleFilter r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static RXVideoScaleFilter valueOf(String r100) {
        return (RXVideoScaleFilter) r27.a.a(RXVideoScaleFilter.class, r100);
    }

    private RXVideoScaleFilter(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
