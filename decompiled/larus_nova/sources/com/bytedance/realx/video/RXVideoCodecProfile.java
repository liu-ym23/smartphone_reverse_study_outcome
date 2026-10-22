package com.bytedance.realx.video;

/* JADX INFO: loaded from: classes21.dex */
final enum RXVideoCodecProfile extends Enum<RXVideoCodecProfile> {
    private static final /* synthetic */ RXVideoCodecProfile[] $VALUES = null;
    public static final RXVideoCodecProfile ByteVC1ProfileMain = null;
    public static final RXVideoCodecProfile ByteVC1ProfileMain10 = null;
    public static final RXVideoCodecProfile ByteVC1ProfileMain10HDR10 = null;
    public static final RXVideoCodecProfile ByteVC1ProfileMax = null;
    public static final RXVideoCodecProfile ByteVC1ProfileUnknown = null;
    public static final RXVideoCodecProfile ProfileBaseline = null;
    public static final RXVideoCodecProfile ProfileConstrainedBaseline = null;
    public static final RXVideoCodecProfile ProfileConstrainedHigh = null;
    public static final RXVideoCodecProfile ProfileHigh = null;
    public static final RXVideoCodecProfile ProfileMain = null;
    public static final RXVideoCodecProfile Unknown = null;
    public static final RXVideoCodecProfile VP8ProfileMain = null;
    private int value;

    static {
        RXVideoCodecProfile r100 = new RXVideoCodecProfile("Unknown", 0, 0);
        Unknown = r100;
        RXVideoCodecProfile r101 = new RXVideoCodecProfile("ProfileConstrainedBaseline", 1, 1);
        ProfileConstrainedBaseline = r101;
        RXVideoCodecProfile r102 = new RXVideoCodecProfile("ProfileBaseline", 2, 2);
        ProfileBaseline = r102;
        RXVideoCodecProfile r103 = new RXVideoCodecProfile("ProfileMain", 3, 3);
        ProfileMain = r103;
        RXVideoCodecProfile r104 = new RXVideoCodecProfile("ProfileConstrainedHigh", 4, 4);
        ProfileConstrainedHigh = r104;
        RXVideoCodecProfile r105 = new RXVideoCodecProfile("ProfileHigh", 5, 5);
        ProfileHigh = r105;
        RXVideoCodecProfile r110 = new RXVideoCodecProfile("ByteVC1ProfileUnknown", 6, 10);
        ByteVC1ProfileUnknown = r110;
        RXVideoCodecProfile r111 = new RXVideoCodecProfile("ByteVC1ProfileMain", 7, 11);
        ByteVC1ProfileMain = r111;
        RXVideoCodecProfile r112 = new RXVideoCodecProfile("ByteVC1ProfileMain10", 8, 12);
        ByteVC1ProfileMain10 = r112;
        RXVideoCodecProfile r113 = new RXVideoCodecProfile("VP8ProfileMain", 9, 80);
        VP8ProfileMain = r113;
        RXVideoCodecProfile r106 = new RXVideoCodecProfile("ByteVC1ProfileMain10HDR10", 10, 100);
        ByteVC1ProfileMain10HDR10 = r106;
        RXVideoCodecProfile r107 = new RXVideoCodecProfile("ByteVC1ProfileMax", 11, 128);
        ByteVC1ProfileMax = r107;
        $VALUES = new RXVideoCodecProfile[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107};
    }

    public static RXVideoCodecProfile[] values() {
        return (RXVideoCodecProfile[]) $VALUES.clone();
    }

    public int toSystemProfile() {
        int r100 = this.value;
        if (r100 == 0) goto L31;
        if (r100 == 1) goto L31;
        if (r100 == 2) goto L31;
        if (r100 != 3) goto L10;
        return 2;
    L10:
        if (r100 != 4) goto L12;
        return 8;
    L12:
        if (r100 != 5) goto L14;
        return 8;
    L14:
        if (r100 != 80) goto L16;
        return 1;
    L16:
        if (r100 != 100) goto L18;
        return 4096;
    L18:
        if (r100 == 128) goto L24;
        switch(r100) {
            case 10: goto L23;
            case 11: goto L23;
            case 12: goto L22;
            default: goto L21;
        };
    L22:
        return 2;
    L23:
        return 1;
    L21:
        throw new RuntimeException("profile not match system!");
    L24:
        return 4;
    L31:
        return 1;
    }

    public int toInt() {
        return this.value;
    }

    public static RXVideoCodecProfile fromValue(int r100) {
        if (r100 == 0) goto L45;
        if (r100 == 1) goto L43;
        if (r100 == 2) goto L41;
        if (r100 == 3) goto L39;
        if (r100 == 4) goto L37;
        if (r100 == 5) goto L35;
        if (r100 == 80) goto L33;
        if (r100 == 100) goto L31;
        if (r100 == 128) goto L29;
        switch(r100) {
            case 10: goto L27;
            case 11: goto L25;
            case 12: goto L23;
            default: goto L21;
        };
    L21:
        return Unknown;
    L23:
        return ByteVC1ProfileMain10;
    L25:
        return ByteVC1ProfileMain;
    L27:
        return ByteVC1ProfileUnknown;
    L29:
        return ByteVC1ProfileMax;
    L31:
        return ByteVC1ProfileMain10HDR10;
    L33:
        return VP8ProfileMain;
    L35:
        return ProfileHigh;
    L37:
        return ProfileConstrainedHigh;
    L39:
        return ProfileMain;
    L41:
        return ProfileBaseline;
    L43:
        return ProfileConstrainedBaseline;
    L45:
        return Unknown;
    }

    public static RXVideoCodecProfile valueOf(String r100) {
        return (RXVideoCodecProfile) r27.a.a(RXVideoCodecProfile.class, r100);
    }

    private RXVideoCodecProfile(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
