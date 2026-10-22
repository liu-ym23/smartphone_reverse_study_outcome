package com.ss.android.lark.download.service;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public final enum FileState extends Enum<FileState> {
    public static final FileState DELETED = null;
    public static final FileState FREED_UP = null;
    public static final FileState NORMAL = null;
    public static final FileState RECOVERABLE = null;
    public static final FileState UNRECOVERABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FileState[] f420524a = null;
    private int value;

    static {
        FileState r100 = new FileState(EffectConstants.NORMAL, 0, 1);
        NORMAL = r100;
        FileState r101 = new FileState("DELETED", 1, 2);
        DELETED = r101;
        FileState r102 = new FileState("RECOVERABLE", 2, 3);
        RECOVERABLE = r102;
        FileState r103 = new FileState("UNRECOVERABLE", 3, 4);
        UNRECOVERABLE = r103;
        FileState r104 = new FileState("FREED_UP", 4, 5);
        FREED_UP = r104;
        f420524a = new FileState[]{r100, r101, r102, r103, r104};
    }

    public static FileState[] values() {
        return (FileState[]) f420524a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static FileState forNumber(int r100) {
        if (r100 == 1) goto L23;
        if (r100 == 2) goto L21;
        if (r100 == 3) goto L19;
        if (r100 == 4) goto L17;
        if (r100 == 5) goto L15;
        return NORMAL;
    L15:
        return FREED_UP;
    L17:
        return UNRECOVERABLE;
    L19:
        return RECOVERABLE;
    L21:
        return DELETED;
    L23:
        return NORMAL;
    }

    public static FileState valueOf(String r100) {
        return (FileState) a.a(FileState.class, r100);
    }

    public static FileState valueOf(int r100) {
        return forNumber(r100);
    }

    public FileState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
