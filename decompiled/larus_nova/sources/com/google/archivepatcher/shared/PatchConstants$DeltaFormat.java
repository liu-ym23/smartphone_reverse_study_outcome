package com.google.archivepatcher.shared;

/* JADX INFO: loaded from: classes23.dex */
public final enum PatchConstants$DeltaFormat extends Enum<PatchConstants$DeltaFormat> {
    public static final PatchConstants$DeltaFormat BSDIFF = null;
    public static final PatchConstants$DeltaFormat FILE_BY_FILE = null;
    public static final PatchConstants$DeltaFormat HDIFF = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PatchConstants$DeltaFormat[] f274685a = null;
    public final byte patchValue;
    public final boolean supportsMultiEntryDelta;

    static {
        PatchConstants$DeltaFormat r100 = new PatchConstants$DeltaFormat("BSDIFF", 0, (byte) 0, true);
        BSDIFF = r100;
        PatchConstants$DeltaFormat r101 = new PatchConstants$DeltaFormat("FILE_BY_FILE", 1, (byte) 1, false);
        FILE_BY_FILE = r101;
        PatchConstants$DeltaFormat r102 = new PatchConstants$DeltaFormat("HDIFF", 2, (byte) 2, true);
        HDIFF = r102;
        f274685a = new PatchConstants$DeltaFormat[]{r100, r101, r102};
    }

    public static PatchConstants$DeltaFormat[] values() {
        return (PatchConstants$DeltaFormat[]) f274685a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "DeltaFormat{patchValue=" + this.patchValue + ", supportsMultiEntryDelta=" + this.supportsMultiEntryDelta + '}';
    }

    public static PatchConstants$DeltaFormat fromPatchValue(byte r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 != 2) goto L10;
        return HDIFF;
    L10:
        throw new IllegalArgumentException("Unknown patch value " + r100);
    L12:
        return FILE_BY_FILE;
    L14:
        return BSDIFF;
    }

    public static PatchConstants$DeltaFormat valueOf(String r100) {
        return (PatchConstants$DeltaFormat) r27.a.a(PatchConstants$DeltaFormat.class, r100);
    }

    public PatchConstants$DeltaFormat(String r100, int r101, byte r102, boolean r103) {
        super(r100, r101);
        this.patchValue = r102;
        this.supportsMultiEntryDelta = r103;
    }
}
