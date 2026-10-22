package com.ss.android.lark.chat.core.model;

/* JADX INFO: loaded from: classes35.dex */
public final enum MessageFetchScene extends Enum<MessageFetchScene> {
    public static final MessageFetchScene FIRST_SCREEN = null;
    public static final MessageFetchScene NEXT_PAGE = null;
    public static final MessageFetchScene PREVIOUS_PAGE = null;
    public static final MessageFetchScene SPECIFIED_POSITION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageFetchScene[] f414750a = null;
    private String desc;
    private final int value;

    static {
        MessageFetchScene r100 = new MessageFetchScene("FIRST_SCREEN", 0, 1, "首屏");
        FIRST_SCREEN = r100;
        MessageFetchScene r101 = new MessageFetchScene("SPECIFIED_POSITION", 1, 2, "指定位置");
        SPECIFIED_POSITION = r101;
        MessageFetchScene r102 = new MessageFetchScene("PREVIOUS_PAGE", 2, 3, "上一页");
        PREVIOUS_PAGE = r102;
        MessageFetchScene r103 = new MessageFetchScene("NEXT_PAGE", 3, 4, "下一页");
        NEXT_PAGE = r103;
        f414750a = new MessageFetchScene[]{r100, r101, r102, r103};
    }

    public static MessageFetchScene[] values() {
        return (MessageFetchScene[]) f414750a.clone();
    }

    public String getDesc() {
        return this.desc;
    }

    public int getNumber() {
        return this.value;
    }

    public static MessageFetchScene fromValue(int r100) {
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L15;
        if (r100 == 4) goto L13;
        return FIRST_SCREEN;
    L13:
        return NEXT_PAGE;
    L15:
        return PREVIOUS_PAGE;
    L17:
        return SPECIFIED_POSITION;
    L19:
        return FIRST_SCREEN;
    }

    public static MessageFetchScene valueOf(String r100) {
        return (MessageFetchScene) r27.a.a(MessageFetchScene.class, r100);
    }

    public MessageFetchScene(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.desc = r103;
    }
}
