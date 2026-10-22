package com.google.archivepatcher.shared;

import iv7.j;

/* JADX INFO: loaded from: classes23.dex */
public final enum PatchConstants$CompressionMethod extends Enum<PatchConstants$CompressionMethod> {
    public static final PatchConstants$CompressionMethod DEFLATE = null;
    public static final PatchConstants$CompressionMethod STORED = null;
    public static final PatchConstants$CompressionMethod UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PatchConstants$CompressionMethod[] f274684a = null;

    static {
        PatchConstants$CompressionMethod r100 = new PatchConstants$CompressionMethod("DEFLATE", 0);
        DEFLATE = r100;
        PatchConstants$CompressionMethod r101 = new PatchConstants$CompressionMethod("STORED", 1);
        STORED = r101;
        PatchConstants$CompressionMethod r102 = new PatchConstants$CompressionMethod("UNKNOWN", 2);
        UNKNOWN = r102;
        f274684a = new PatchConstants$CompressionMethod[]{r100, r101, r102};
    }

    public static PatchConstants$CompressionMethod[] values() {
        return (PatchConstants$CompressionMethod[]) f274684a.clone();
    }

    public int value() {
        int r100 = j.f495955a[ordinal()];
        if (r100 != 1) goto L5;
        return 8;
    L5:
        if (r100 != 2) goto L9;
        return 0;
    L9:
        throw new IllegalArgumentException("Unknown compression method");
    }

    public static PatchConstants$CompressionMethod fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 8) goto L8;
        return UNKNOWN;
    L8:
        return DEFLATE;
    L10:
        return STORED;
    }

    public static PatchConstants$CompressionMethod valueOf(String r100) {
        return (PatchConstants$CompressionMethod) r27.a.a(PatchConstants$CompressionMethod.class, r100);
    }

    public PatchConstants$CompressionMethod(String r100, int r101) {
        super(r100, r101);
    }
}
