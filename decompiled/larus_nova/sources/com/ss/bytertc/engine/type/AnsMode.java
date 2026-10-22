package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AnsMode extends Enum<AnsMode> {
    private static final /* synthetic */ AnsMode[] $VALUES = null;
    public static final AnsMode ANS_MODE_AUTOMATIC = null;
    public static final AnsMode ANS_MODE_DISABLE = null;
    public static final AnsMode ANS_MODE_HIGH = null;
    public static final AnsMode ANS_MODE_LOW = null;
    public static final AnsMode ANS_MODE_MEDIUM = null;
    private final int value;

    static {
        AnsMode r100 = new AnsMode("ANS_MODE_DISABLE", 0, 0);
        ANS_MODE_DISABLE = r100;
        AnsMode r101 = new AnsMode("ANS_MODE_LOW", 1, 1);
        ANS_MODE_LOW = r101;
        AnsMode r102 = new AnsMode("ANS_MODE_MEDIUM", 2, 2);
        ANS_MODE_MEDIUM = r102;
        AnsMode r103 = new AnsMode("ANS_MODE_HIGH", 3, 3);
        ANS_MODE_HIGH = r103;
        AnsMode r104 = new AnsMode("ANS_MODE_AUTOMATIC", 4, 4);
        ANS_MODE_AUTOMATIC = r104;
        $VALUES = new AnsMode[]{r100, r101, r102, r103, r104};
    }

    public static AnsMode[] values() {
        return (AnsMode[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static AnsMode fromId(int r100) {
        AnsMode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        AnsMode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return ANS_MODE_AUTOMATIC;
    }

    public static AnsMode valueOf(String r100) {
        return (AnsMode) a.a(AnsMode.class, r100);
    }

    private AnsMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
