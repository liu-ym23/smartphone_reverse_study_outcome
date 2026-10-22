package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: classes8.dex */
final enum BmmtVideoCodecProfile extends Enum<BmmtVideoCodecProfile> {
    private static final /* synthetic */ BmmtVideoCodecProfile[] $VALUES = null;
    public static final BmmtVideoCodecProfile AV1ProfileMain = null;
    public static final BmmtVideoCodecProfile ByteVC1ProfileMain = null;
    public static final BmmtVideoCodecProfile ByteVC1ProfileMain10 = null;
    public static final BmmtVideoCodecProfile ByteVC1ProfileMain10HDR10 = null;
    public static final BmmtVideoCodecProfile ByteVC1ProfileMax = null;
    public static final BmmtVideoCodecProfile ByteVC1ProfileUnknown = null;
    public static final BmmtVideoCodecProfile ProfileBaseline = null;
    public static final BmmtVideoCodecProfile ProfileConstrainedBaseline = null;
    public static final BmmtVideoCodecProfile ProfileConstrainedHigh = null;
    public static final BmmtVideoCodecProfile ProfileHigh = null;
    public static final BmmtVideoCodecProfile ProfileMain = null;
    public static final BmmtVideoCodecProfile Unknown = null;
    public static final BmmtVideoCodecProfile VP8ProfileMain = null;
    private int value;

    private static /* synthetic */ BmmtVideoCodecProfile[] $values() {
        return new BmmtVideoCodecProfile[]{Unknown, ProfileConstrainedBaseline, ProfileBaseline, ProfileMain, ProfileConstrainedHigh, ProfileHigh, ByteVC1ProfileUnknown, ByteVC1ProfileMain, ByteVC1ProfileMain10, VP8ProfileMain, AV1ProfileMain, ByteVC1ProfileMain10HDR10, ByteVC1ProfileMax};
    }

    static {
        Unknown = new BmmtVideoCodecProfile("Unknown", 0, 0);
        ProfileConstrainedBaseline = new BmmtVideoCodecProfile("ProfileConstrainedBaseline", 1, 1);
        ProfileBaseline = new BmmtVideoCodecProfile("ProfileBaseline", 2, 2);
        ProfileMain = new BmmtVideoCodecProfile("ProfileMain", 3, 3);
        ProfileConstrainedHigh = new BmmtVideoCodecProfile("ProfileConstrainedHigh", 4, 4);
        ProfileHigh = new BmmtVideoCodecProfile("ProfileHigh", 5, 5);
        ByteVC1ProfileUnknown = new BmmtVideoCodecProfile("ByteVC1ProfileUnknown", 6, 10);
        ByteVC1ProfileMain = new BmmtVideoCodecProfile("ByteVC1ProfileMain", 7, 11);
        ByteVC1ProfileMain10 = new BmmtVideoCodecProfile("ByteVC1ProfileMain10", 8, 12);
        VP8ProfileMain = new BmmtVideoCodecProfile("VP8ProfileMain", 9, 80);
        AV1ProfileMain = new BmmtVideoCodecProfile("AV1ProfileMain", 10, 90);
        ByteVC1ProfileMain10HDR10 = new BmmtVideoCodecProfile("ByteVC1ProfileMain10HDR10", 11, 100);
        ByteVC1ProfileMax = new BmmtVideoCodecProfile("ByteVC1ProfileMax", 12, 128);
        $VALUES = $values();
    }

    public static BmmtVideoCodecProfile[] values() {
        return (BmmtVideoCodecProfile[]) $VALUES.clone();
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

    public static BmmtVideoCodecProfile fromValue(int r100) {
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

    public static BmmtVideoCodecProfile valueOf(String r100) {
        return (BmmtVideoCodecProfile) r27.a.a(BmmtVideoCodecProfile.class, r100);
    }

    private BmmtVideoCodecProfile(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
