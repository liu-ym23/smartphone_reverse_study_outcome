package com.ss.android.lark.chat.entity.message;

/* JADX INFO: loaded from: classes35.dex */
public final enum SendStatus extends Enum<SendStatus> {
    public static final SendStatus DRAFT = null;
    public static final SendStatus FAIL = null;
    public static final SendStatus SENDING = null;
    public static final SendStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SendStatus[] f415310a = null;
    private int value;

    static {
        SendStatus r100 = new SendStatus("SUCCESS", 0, 0);
        SUCCESS = r100;
        SendStatus r101 = new SendStatus("SENDING", 1, 1);
        SENDING = r101;
        SendStatus r102 = new SendStatus("FAIL", 2, 2);
        FAIL = r102;
        SendStatus r103 = new SendStatus("DRAFT", 3, 3);
        DRAFT = r103;
        f415310a = new SendStatus[]{r100, r101, r102, r103};
    }

    public static SendStatus[] values() {
        return (SendStatus[]) f415310a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static SendStatus forNumber(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return DRAFT;
    L14:
        return FAIL;
    L16:
        return SENDING;
    L18:
        return SUCCESS;
    }

    public static SendStatus valueOf(String r100) {
        return (SendStatus) r27.a.a(SendStatus.class, r100);
    }

    public SendStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
