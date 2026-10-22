package com.ss.android.lark.filedetail.dto;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public final enum FileState extends Enum<FileState> {
    public static final FileState DELETED = null;
    public static final FileState NORMAL = null;
    public static final FileState RECOVERABLE = null;
    public static final FileState UNRECOVERABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FileState[] f421493a = null;
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
        f421493a = new FileState[]{r100, r101, r102, r103};
    }

    public static FileState[] values() {
        return (FileState[]) f421493a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static FileState forNumber(int r100) {
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L15;
        if (r100 == 4) goto L13;
        return NORMAL;
    L13:
        return UNRECOVERABLE;
    L15:
        return RECOVERABLE;
    L17:
        return DELETED;
    L19:
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
