package com.google.archivepatcher.shared;

/* JADX INFO: loaded from: classes23.dex */
public final enum PatchConstants$CompatibilityWindowId extends Enum<PatchConstants$CompatibilityWindowId> {
    public static final PatchConstants$CompatibilityWindowId DEFAULT_DEFLATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PatchConstants$CompatibilityWindowId[] f274683a = null;
    public final byte patchValue;

    static {
        PatchConstants$CompatibilityWindowId r100 = new PatchConstants$CompatibilityWindowId();
        DEFAULT_DEFLATE = r100;
        f274683a = new PatchConstants$CompatibilityWindowId[]{r100};
    }

    public PatchConstants$CompatibilityWindowId() {
        super("DEFAULT_DEFLATE", 0);
        this.patchValue = 0;
    }

    public static PatchConstants$CompatibilityWindowId[] values() {
        return (PatchConstants$CompatibilityWindowId[]) f274683a.clone();
    }

    public static PatchConstants$CompatibilityWindowId fromPatchValue(byte r100) {
        if (r100 == 0) goto L6;
        return null;
    L6:
        return DEFAULT_DEFLATE;
    }

    public static PatchConstants$CompatibilityWindowId valueOf(String r100) {
        return (PatchConstants$CompatibilityWindowId) r27.a.a(PatchConstants$CompatibilityWindowId.class, r100);
    }
}
