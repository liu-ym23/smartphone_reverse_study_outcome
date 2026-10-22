package com.google.zxing.pdf417.decoder;

import r27.a;

/* JADX INFO: loaded from: classes23.dex */
final enum DecodedBitStreamParser$Mode extends Enum<DecodedBitStreamParser$Mode> {
    public static final DecodedBitStreamParser$Mode ALPHA = null;
    public static final DecodedBitStreamParser$Mode ALPHA_SHIFT = null;
    public static final DecodedBitStreamParser$Mode LOWER = null;
    public static final DecodedBitStreamParser$Mode MIXED = null;
    public static final DecodedBitStreamParser$Mode PUNCT = null;
    public static final DecodedBitStreamParser$Mode PUNCT_SHIFT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DecodedBitStreamParser$Mode[] f275958a = null;

    static {
        DecodedBitStreamParser$Mode r100 = new DecodedBitStreamParser$Mode("ALPHA", 0);
        ALPHA = r100;
        DecodedBitStreamParser$Mode r101 = new DecodedBitStreamParser$Mode("LOWER", 1);
        LOWER = r101;
        DecodedBitStreamParser$Mode r102 = new DecodedBitStreamParser$Mode("MIXED", 2);
        MIXED = r102;
        DecodedBitStreamParser$Mode r103 = new DecodedBitStreamParser$Mode("PUNCT", 3);
        PUNCT = r103;
        DecodedBitStreamParser$Mode r104 = new DecodedBitStreamParser$Mode("ALPHA_SHIFT", 4);
        ALPHA_SHIFT = r104;
        DecodedBitStreamParser$Mode r105 = new DecodedBitStreamParser$Mode("PUNCT_SHIFT", 5);
        PUNCT_SHIFT = r105;
        f275958a = new DecodedBitStreamParser$Mode[]{r100, r101, r102, r103, r104, r105};
    }

    public static DecodedBitStreamParser$Mode[] values() {
        return (DecodedBitStreamParser$Mode[]) f275958a.clone();
    }

    public static DecodedBitStreamParser$Mode valueOf(String r100) {
        return (DecodedBitStreamParser$Mode) a.a(DecodedBitStreamParser$Mode.class, r100);
    }

    public DecodedBitStreamParser$Mode(String r100, int r101) {
        super(r100, r101);
    }
}
