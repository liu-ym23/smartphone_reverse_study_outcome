package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/salamander/anniex/AnnieXPopupStatus;", "", "", "value", "I", "getValue", "()I", "ENTER_FULL_SCREEN", "ENTER_HALF_SCREEN", "LEAVE_FULL_SCREEN", "LEAVE_HALF_SCREEN", "DESTROY", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AnnieXPopupStatus extends Enum<AnnieXPopupStatus> {
    public static final AnnieXPopupStatus DESTROY = null;
    public static final AnnieXPopupStatus ENTER_FULL_SCREEN = null;
    public static final AnnieXPopupStatus ENTER_HALF_SCREEN = null;
    public static final AnnieXPopupStatus LEAVE_FULL_SCREEN = null;
    public static final AnnieXPopupStatus LEAVE_HALF_SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnnieXPopupStatus[] f267841a = null;
    private final int value;

    public static AnnieXPopupStatus valueOf(String r100) {
        return (AnnieXPopupStatus) r27.a.a(AnnieXPopupStatus.class, r100);
    }

    public static AnnieXPopupStatus[] values() {
        return (AnnieXPopupStatus[]) f267841a.clone();
    }

    static {
        AnnieXPopupStatus r100 = new AnnieXPopupStatus("ENTER_FULL_SCREEN", 0, 1);
        ENTER_FULL_SCREEN = r100;
        AnnieXPopupStatus r101 = new AnnieXPopupStatus("ENTER_HALF_SCREEN", 1, 2);
        ENTER_HALF_SCREEN = r101;
        AnnieXPopupStatus r102 = new AnnieXPopupStatus("LEAVE_FULL_SCREEN", 2, 3);
        LEAVE_FULL_SCREEN = r102;
        AnnieXPopupStatus r103 = new AnnieXPopupStatus("LEAVE_HALF_SCREEN", 3, 4);
        LEAVE_HALF_SCREEN = r103;
        AnnieXPopupStatus r104 = new AnnieXPopupStatus("DESTROY", 4, 5);
        DESTROY = r104;
        f267841a = new AnnieXPopupStatus[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public AnnieXPopupStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
