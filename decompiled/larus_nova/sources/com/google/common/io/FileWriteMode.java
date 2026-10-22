package com.google.common.io;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final enum FileWriteMode extends Enum<FileWriteMode> {
    public static final FileWriteMode APPEND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FileWriteMode[] f275620a = null;

    static {
        FileWriteMode r100 = new FileWriteMode();
        APPEND = r100;
        f275620a = new FileWriteMode[]{r100};
    }

    public FileWriteMode() {
        super("APPEND", 0);
    }

    public static FileWriteMode[] values() {
        return (FileWriteMode[]) f275620a.clone();
    }

    public static FileWriteMode valueOf(String r100) {
        return (FileWriteMode) r27.a.a(FileWriteMode.class, r100);
    }
}
