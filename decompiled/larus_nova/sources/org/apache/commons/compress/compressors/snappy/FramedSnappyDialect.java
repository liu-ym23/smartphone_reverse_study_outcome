package org.apache.commons.compress.compressors.snappy;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum FramedSnappyDialect extends Enum<FramedSnappyDialect> {
    private static final /* synthetic */ FramedSnappyDialect[] $VALUES = null;
    public static final FramedSnappyDialect IWORK_ARCHIVE = null;
    public static final FramedSnappyDialect STANDARD = null;
    private final boolean checksumWithCompressedChunks;
    private final boolean streamIdentifier;

    static {
        FramedSnappyDialect r100 = new FramedSnappyDialect("STANDARD", 0, true, true);
        STANDARD = r100;
        FramedSnappyDialect r101 = new FramedSnappyDialect("IWORK_ARCHIVE", 1, false, false);
        IWORK_ARCHIVE = r101;
        $VALUES = new FramedSnappyDialect[]{r100, r101};
    }

    public static FramedSnappyDialect[] values() {
        return (FramedSnappyDialect[]) $VALUES.clone();
    }

    public boolean hasStreamIdentifier() {
        return this.streamIdentifier;
    }

    public boolean usesChecksumWithCompressedChunks() {
        return this.checksumWithCompressedChunks;
    }

    public static FramedSnappyDialect valueOf(String r100) {
        return (FramedSnappyDialect) a.a(FramedSnappyDialect.class, r100);
    }

    private FramedSnappyDialect(String r100, int r101, boolean r102, boolean r103) {
        super(r100, r101);
        this.streamIdentifier = r102;
        this.checksumWithCompressedChunks = r103;
    }
}
