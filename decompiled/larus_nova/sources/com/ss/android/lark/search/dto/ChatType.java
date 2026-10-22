package com.ss.android.lark.search.dto;

import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public final enum ChatType extends Enum<ChatType> {
    public static final ChatType All_THREAD = null;
    public static final ChatType OUTER = null;
    public static final ChatType PRIVATE = null;
    public static final ChatType PRIVATE_THREAD = null;
    public static final ChatType PUBLIC_ABSENT = null;
    public static final ChatType PUBLIC_JOIN = null;
    public static final ChatType PUBLIC_THREAD = null;
    public static final ChatType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatType[] f440118a = null;
    private int value;

    static {
        ChatType r100 = new ChatType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ChatType r101 = new ChatType("PRIVATE", 1, 1);
        PRIVATE = r101;
        ChatType r102 = new ChatType("OUTER", 2, 2);
        OUTER = r102;
        ChatType r103 = new ChatType("PUBLIC_JOIN", 3, 3);
        PUBLIC_JOIN = r103;
        ChatType r104 = new ChatType("PUBLIC_ABSENT", 4, 4);
        PUBLIC_ABSENT = r104;
        ChatType r105 = new ChatType("PUBLIC_THREAD", 5, 5);
        PUBLIC_THREAD = r105;
        ChatType r110 = new ChatType("PRIVATE_THREAD", 6, 6);
        PRIVATE_THREAD = r110;
        ChatType r111 = new ChatType("All_THREAD", 7, 7);
        All_THREAD = r111;
        f440118a = new ChatType[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static ChatType[] values() {
        return (ChatType[]) f440118a.clone();
    }

    public final int getNumber() {
        return this.value;
    }

    public static ChatType forNumber(int r100) {
        switch(r100) {
            case 0: goto L20;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L4;
        };
    L4:
        return UNKNOWN;
    L6:
        return All_THREAD;
    L8:
        return PRIVATE_THREAD;
    L10:
        return PUBLIC_THREAD;
    L12:
        return PUBLIC_ABSENT;
    L14:
        return PUBLIC_JOIN;
    L16:
        return OUTER;
    L18:
        return PRIVATE;
    L20:
        return UNKNOWN;
    }

    public static ChatType valueOf(String r100) {
        return (ChatType) a.a(ChatType.class, r100);
    }

    public ChatType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
