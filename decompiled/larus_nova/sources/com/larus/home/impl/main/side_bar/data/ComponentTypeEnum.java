package com.larus.home.impl.main.side_bar.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/larus/home/impl/main/side_bar/data/ComponentTypeEnum;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "TOP_SECTION", "MID_SECTION", "BOTTOM_SECTION", "CONTAINER", "ACTION_ITEM", "PROFILE", "CONVERSATION_CONTAINER", "SEARCH", "NOTICE", "CREATION_ASSET", "COLLECTION_ASSET", "BOT_ASSET", "ASSET_CONTAINER", "CASE_CONTAINER", "CASE_CONTAINER_OUTER", "LARK_ADDRESS_BOOK", "BACK_DOUBAO", "AI_CREATE_ACTION", "FEED_ACTION", "MAIN_BOT", "CONVERSATION_NEW_CONVERSATION_CHAT", "CONVERSATION_NEW_CONVERSATION_OFFICE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ComponentTypeEnum extends Enum<ComponentTypeEnum> {
    public static final ComponentTypeEnum ACTION_ITEM = null;
    public static final ComponentTypeEnum AI_CREATE_ACTION = null;
    public static final ComponentTypeEnum ASSET_CONTAINER = null;
    public static final ComponentTypeEnum BACK_DOUBAO = null;
    public static final ComponentTypeEnum BOTTOM_SECTION = null;
    public static final ComponentTypeEnum BOT_ASSET = null;
    public static final ComponentTypeEnum CASE_CONTAINER = null;
    public static final ComponentTypeEnum CASE_CONTAINER_OUTER = null;
    public static final ComponentTypeEnum COLLECTION_ASSET = null;
    public static final ComponentTypeEnum CONTAINER = null;
    public static final ComponentTypeEnum CONVERSATION_CONTAINER = null;
    public static final ComponentTypeEnum CONVERSATION_NEW_CONVERSATION_CHAT = null;
    public static final ComponentTypeEnum CONVERSATION_NEW_CONVERSATION_OFFICE = null;
    public static final ComponentTypeEnum CREATION_ASSET = null;
    public static final ComponentTypeEnum FEED_ACTION = null;
    public static final ComponentTypeEnum LARK_ADDRESS_BOOK = null;
    public static final ComponentTypeEnum MAIN_BOT = null;
    public static final ComponentTypeEnum MID_SECTION = null;
    public static final ComponentTypeEnum NOTICE = null;
    public static final ComponentTypeEnum PROFILE = null;
    public static final ComponentTypeEnum SEARCH = null;
    public static final ComponentTypeEnum TOP_SECTION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComponentTypeEnum[] f344422a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f344423b = null;
    private final int type;

    public static EnumEntries<ComponentTypeEnum> getEntries() {
        return f344423b;
    }

    static {
        ComponentTypeEnum r100 = new ComponentTypeEnum("TOP_SECTION", 0, 1);
        TOP_SECTION = r100;
        ComponentTypeEnum r101 = new ComponentTypeEnum("MID_SECTION", 1, 2);
        MID_SECTION = r101;
        ComponentTypeEnum r102 = new ComponentTypeEnum("BOTTOM_SECTION", 2, 3);
        BOTTOM_SECTION = r102;
        ComponentTypeEnum r103 = new ComponentTypeEnum("CONTAINER", 3, 4);
        CONTAINER = r103;
        ComponentTypeEnum r104 = new ComponentTypeEnum("ACTION_ITEM", 4, 5);
        ACTION_ITEM = r104;
        ComponentTypeEnum r110 = new ComponentTypeEnum("PROFILE", 5, 9);
        PROFILE = r110;
        ComponentTypeEnum r111 = new ComponentTypeEnum("CONVERSATION_CONTAINER", 6, 100);
        CONVERSATION_CONTAINER = r111;
        ComponentTypeEnum r112 = new ComponentTypeEnum("SEARCH", 7, 101);
        SEARCH = r112;
        ComponentTypeEnum r113 = new ComponentTypeEnum("NOTICE", 8, 102);
        NOTICE = r113;
        ComponentTypeEnum r105 = new ComponentTypeEnum("CREATION_ASSET", 9, 103);
        CREATION_ASSET = r105;
        ComponentTypeEnum r106 = new ComponentTypeEnum("COLLECTION_ASSET", 10, 104);
        COLLECTION_ASSET = r106;
        ComponentTypeEnum r114 = new ComponentTypeEnum("BOT_ASSET", 11, 105);
        BOT_ASSET = r114;
        ComponentTypeEnum r107 = new ComponentTypeEnum("ASSET_CONTAINER", 12, 106);
        ASSET_CONTAINER = r107;
        ComponentTypeEnum r108 = new ComponentTypeEnum("CASE_CONTAINER", 13, 111);
        CASE_CONTAINER = r108;
        ComponentTypeEnum r109 = new ComponentTypeEnum("CASE_CONTAINER_OUTER", 14, 112);
        CASE_CONTAINER_OUTER = r109;
        ComponentTypeEnum r115 = new ComponentTypeEnum("LARK_ADDRESS_BOOK", 15, 113);
        LARK_ADDRESS_BOOK = r115;
        ComponentTypeEnum r116 = new ComponentTypeEnum("BACK_DOUBAO", 16, 107);
        BACK_DOUBAO = r116;
        ComponentTypeEnum r117 = new ComponentTypeEnum("AI_CREATE_ACTION", 17, 108);
        AI_CREATE_ACTION = r117;
        ComponentTypeEnum r118 = new ComponentTypeEnum("FEED_ACTION", 18, 109);
        FEED_ACTION = r118;
        ComponentTypeEnum r119 = new ComponentTypeEnum("MAIN_BOT", 19, 110);
        MAIN_BOT = r119;
        ComponentTypeEnum r120 = new ComponentTypeEnum("CONVERSATION_NEW_CONVERSATION_CHAT", 20, 114);
        CONVERSATION_NEW_CONVERSATION_CHAT = r120;
        ComponentTypeEnum r121 = new ComponentTypeEnum("CONVERSATION_NEW_CONVERSATION_OFFICE", 21, 115);
        CONVERSATION_NEW_CONVERSATION_OFFICE = r121;
        ComponentTypeEnum[] r122 = {r100, r101, r102, r103, r104, r110, r111, r112, r113, r105, r106, r114, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121};
        f344422a = r122;
        f344423b = EnumEntriesKt.enumEntries(r122);
    }

    public static ComponentTypeEnum[] values() {
        return (ComponentTypeEnum[]) f344422a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static ComponentTypeEnum valueOf(String r100) {
        return (ComponentTypeEnum) r27.a.a(ComponentTypeEnum.class, r100);
    }

    public ComponentTypeEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
