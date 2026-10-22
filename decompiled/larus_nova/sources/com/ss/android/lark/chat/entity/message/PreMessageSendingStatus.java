package com.ss.android.lark.chat.entity.message;

/* JADX INFO: loaded from: classes35.dex */
public final enum PreMessageSendingStatus extends Enum<PreMessageSendingStatus> {
    public static final PreMessageSendingStatus FAILED = null;
    public static final PreMessageSendingStatus PENDING = null;
    public static final PreMessageSendingStatus UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreMessageSendingStatus[] f415303a = null;
    private int value;

    static {
        PreMessageSendingStatus r100 = new PreMessageSendingStatus("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        PreMessageSendingStatus r101 = new PreMessageSendingStatus("PENDING", 1, 1);
        PENDING = r101;
        PreMessageSendingStatus r102 = new PreMessageSendingStatus("FAILED", 2, 2);
        FAILED = r102;
        f415303a = new PreMessageSendingStatus[]{r100, r101, r102};
    }

    public static PreMessageSendingStatus[] values() {
        return (PreMessageSendingStatus[]) f415303a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static PreMessageSendingStatus forNumber(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return UNKNOWN;
    L9:
        return FAILED;
    L11:
        return PENDING;
    }

    public static PreMessageSendingStatus valueOf(String r100) {
        return (PreMessageSendingStatus) r27.a.a(PreMessageSendingStatus.class, r100);
    }

    public PreMessageSendingStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
