package com.bytedance.lark.pb.settings.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum WayToAddFriendItem extends Enum<WayToAddFriendItem> implements WireEnum {
    private static final /* synthetic */ WayToAddFriendItem[] $VALUES = null;
    public static final ProtoAdapter<WayToAddFriendItem> ADAPTER = null;
    public static final WayToAddFriendItem WAY_TO_ADD_FRIEND_ITEM_CHAT = null;
    public static final WayToAddFriendItem WAY_TO_ADD_FRIEND_ITEM_CONTACT_TOKEN = null;
    public static final WayToAddFriendItem WAY_TO_ADD_FRIEND_ITEM_DOCS = null;
    public static final WayToAddFriendItem WAY_TO_ADD_FRIEND_ITEM_NAME_CARD = null;
    public static final WayToAddFriendItem WAY_TO_ADD_FRIEND_ITEM_UNKNOWN = null;
    private final int value;

    static {
        WayToAddFriendItem r100 = new WayToAddFriendItem("WAY_TO_ADD_FRIEND_ITEM_UNKNOWN", 0, 0);
        WAY_TO_ADD_FRIEND_ITEM_UNKNOWN = r100;
        WayToAddFriendItem r101 = new WayToAddFriendItem("WAY_TO_ADD_FRIEND_ITEM_CHAT", 1, 1);
        WAY_TO_ADD_FRIEND_ITEM_CHAT = r101;
        WayToAddFriendItem r102 = new WayToAddFriendItem("WAY_TO_ADD_FRIEND_ITEM_CONTACT_TOKEN", 2, 2);
        WAY_TO_ADD_FRIEND_ITEM_CONTACT_TOKEN = r102;
        WayToAddFriendItem r103 = new WayToAddFriendItem("WAY_TO_ADD_FRIEND_ITEM_DOCS", 3, 4);
        WAY_TO_ADD_FRIEND_ITEM_DOCS = r103;
        WayToAddFriendItem r104 = new WayToAddFriendItem("WAY_TO_ADD_FRIEND_ITEM_NAME_CARD", 4, 8);
        WAY_TO_ADD_FRIEND_ITEM_NAME_CARD = r104;
        $VALUES = new WayToAddFriendItem[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(WayToAddFriendItem.class);
    }

    public static WayToAddFriendItem[] values() {
        return (WayToAddFriendItem[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static WayToAddFriendItem fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 4) goto L16;
        if (r100 == 8) goto L14;
        return null;
    L14:
        return WAY_TO_ADD_FRIEND_ITEM_NAME_CARD;
    L16:
        return WAY_TO_ADD_FRIEND_ITEM_DOCS;
    L18:
        return WAY_TO_ADD_FRIEND_ITEM_CONTACT_TOKEN;
    L20:
        return WAY_TO_ADD_FRIEND_ITEM_CHAT;
    L22:
        return WAY_TO_ADD_FRIEND_ITEM_UNKNOWN;
    }

    public static WayToAddFriendItem valueOf(String r100) {
        return (WayToAddFriendItem) a.a(WayToAddFriendItem.class, r100);
    }

    private WayToAddFriendItem(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
