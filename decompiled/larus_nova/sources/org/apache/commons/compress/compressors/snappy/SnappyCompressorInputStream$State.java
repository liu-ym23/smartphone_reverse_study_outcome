package org.apache.commons.compress.compressors.snappy;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
final enum SnappyCompressorInputStream$State extends Enum<SnappyCompressorInputStream$State> {
    private static final /* synthetic */ SnappyCompressorInputStream$State[] $VALUES = null;
    public static final SnappyCompressorInputStream$State IN_BACK_REFERENCE = null;
    public static final SnappyCompressorInputStream$State IN_LITERAL = null;
    public static final SnappyCompressorInputStream$State NO_BLOCK = null;

    static {
        SnappyCompressorInputStream$State r100 = new SnappyCompressorInputStream$State("NO_BLOCK", 0);
        NO_BLOCK = r100;
        SnappyCompressorInputStream$State r101 = new SnappyCompressorInputStream$State("IN_LITERAL", 1);
        IN_LITERAL = r101;
        SnappyCompressorInputStream$State r102 = new SnappyCompressorInputStream$State("IN_BACK_REFERENCE", 2);
        IN_BACK_REFERENCE = r102;
        $VALUES = new SnappyCompressorInputStream$State[]{r100, r101, r102};
    }

    public static SnappyCompressorInputStream$State[] values() {
        return (SnappyCompressorInputStream$State[]) $VALUES.clone();
    }

    public static SnappyCompressorInputStream$State valueOf(String r100) {
        return (SnappyCompressorInputStream$State) a.a(SnappyCompressorInputStream$State.class, r100);
    }

    private SnappyCompressorInputStream$State(String r100, int r101) {
        super(r100, r101);
    }
}
