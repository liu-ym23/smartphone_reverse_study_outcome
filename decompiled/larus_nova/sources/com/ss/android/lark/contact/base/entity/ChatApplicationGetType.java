package com.ss.android.lark.contact.base.entity;

/* JADX INFO: loaded from: classes35.dex */
public final enum ChatApplicationGetType extends Enum<ChatApplicationGetType> {
    public static final ChatApplicationGetType AFTER = null;
    public static final ChatApplicationGetType BEFORE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatApplicationGetType[] f418867a = null;
    private int value;

    static {
        ChatApplicationGetType r100 = new ChatApplicationGetType("BEFORE", 0, 1);
        BEFORE = r100;
        ChatApplicationGetType r101 = new ChatApplicationGetType("AFTER", 1, 2);
        AFTER = r101;
        f418867a = new ChatApplicationGetType[]{r100, r101};
    }

    public static ChatApplicationGetType[] values() {
        return (ChatApplicationGetType[]) f418867a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static ChatApplicationGetType forNumber(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return null;
    L9:
        return AFTER;
    L11:
        return BEFORE;
    }

    public static ChatApplicationGetType valueOf(String r100) {
        return (ChatApplicationGetType) r27.a.a(ChatApplicationGetType.class, r100);
    }

    public static ChatApplicationGetType valueOf(int r100) {
        return forNumber(r100);
    }

    public ChatApplicationGetType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
