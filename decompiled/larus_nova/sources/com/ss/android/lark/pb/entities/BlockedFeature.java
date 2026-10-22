package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum BlockedFeature extends Enum<BlockedFeature> implements WireEnum {
    private static final /* synthetic */ BlockedFeature[] $VALUES = null;
    public static final ProtoAdapter<BlockedFeature> ADAPTER = null;
    public static final BlockedFeature ADD_MEMBER = null;
    public static final BlockedFeature BOT_POST = null;
    public static final BlockedFeature CHAT_MENU_TNS = null;
    public static final BlockedFeature CHAT_TAB = null;
    public static final BlockedFeature GROUP_TASK = null;
    public static final BlockedFeature MANAGE_BOT = null;
    public static final BlockedFeature MESSAGE_MENU = null;
    public static final BlockedFeature MODIFY_CHAT_INFO = null;
    public static final BlockedFeature REMOVE_MEMBER = null;
    public static final BlockedFeature UNKNOWN_BLOCKED_FEATURE = null;
    private final int value;

    static {
        BlockedFeature r100 = new BlockedFeature("UNKNOWN_BLOCKED_FEATURE", 0, 0);
        UNKNOWN_BLOCKED_FEATURE = r100;
        BlockedFeature r101 = new BlockedFeature("ADD_MEMBER", 1, 1);
        ADD_MEMBER = r101;
        BlockedFeature r102 = new BlockedFeature("REMOVE_MEMBER", 2, 2);
        REMOVE_MEMBER = r102;
        BlockedFeature r103 = new BlockedFeature("CHAT_TAB", 3, 3);
        CHAT_TAB = r103;
        BlockedFeature r104 = new BlockedFeature("CHAT_MENU_TNS", 4, 4);
        CHAT_MENU_TNS = r104;
        BlockedFeature r105 = new BlockedFeature("MESSAGE_MENU", 5, 5);
        MESSAGE_MENU = r105;
        BlockedFeature r110 = new BlockedFeature("BOT_POST", 6, 6);
        BOT_POST = r110;
        BlockedFeature r111 = new BlockedFeature("MANAGE_BOT", 7, 7);
        MANAGE_BOT = r111;
        BlockedFeature r112 = new BlockedFeature("GROUP_TASK", 8, 8);
        GROUP_TASK = r112;
        BlockedFeature r113 = new BlockedFeature("MODIFY_CHAT_INFO", 9, 9);
        MODIFY_CHAT_INFO = r113;
        $VALUES = new BlockedFeature[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        ADAPTER = ProtoAdapter.newEnumAdapter(BlockedFeature.class);
    }

    public static BlockedFeature[] values() {
        return (BlockedFeature[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static BlockedFeature fromValue(int r100) {
        switch(r100) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return MODIFY_CHAT_INFO;
    L8:
        return GROUP_TASK;
    L10:
        return MANAGE_BOT;
    L12:
        return BOT_POST;
    L14:
        return MESSAGE_MENU;
    L16:
        return CHAT_MENU_TNS;
    L18:
        return CHAT_TAB;
    L20:
        return REMOVE_MEMBER;
    L22:
        return ADD_MEMBER;
    L24:
        return UNKNOWN_BLOCKED_FEATURE;
    }

    public static BlockedFeature valueOf(String r100) {
        return (BlockedFeature) a.a(BlockedFeature.class, r100);
    }

    private BlockedFeature(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
