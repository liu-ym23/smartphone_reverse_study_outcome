package com.bytedance.realx.video;

/* JADX INFO: loaded from: classes21.dex */
public final enum RXVideoRotation extends Enum<RXVideoRotation> {
    private static final /* synthetic */ RXVideoRotation[] $VALUES = null;
    public static final RXVideoRotation VIDEO_ROTATION_0 = null;
    public static final RXVideoRotation VIDEO_ROTATION_180 = null;
    public static final RXVideoRotation VIDEO_ROTATION_270 = null;
    public static final RXVideoRotation VIDEO_ROTATION_90 = null;
    private int value;

    static {
        RXVideoRotation r100 = new RXVideoRotation("VIDEO_ROTATION_0", 0, 0);
        VIDEO_ROTATION_0 = r100;
        RXVideoRotation r101 = new RXVideoRotation("VIDEO_ROTATION_90", 1, 90);
        VIDEO_ROTATION_90 = r101;
        RXVideoRotation r102 = new RXVideoRotation("VIDEO_ROTATION_180", 2, 180);
        VIDEO_ROTATION_180 = r102;
        RXVideoRotation r103 = new RXVideoRotation("VIDEO_ROTATION_270", 3, 270);
        VIDEO_ROTATION_270 = r103;
        $VALUES = new RXVideoRotation[]{r100, r101, r102, r103};
    }

    public static RXVideoRotation[] values() {
        return (RXVideoRotation[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static RXVideoRotation fromId(int r100) {
        RXVideoRotation[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        RXVideoRotation r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static RXVideoRotation valueOf(String r100) {
        return (RXVideoRotation) r27.a.a(RXVideoRotation.class, r100);
    }

    private RXVideoRotation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
