package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum TnsBlockedFeature extends Enum<TnsBlockedFeature> implements WireEnum {
    private static final /* synthetic */ TnsBlockedFeature[] $VALUES = null;
    public static final ProtoAdapter<TnsBlockedFeature> ADAPTER = null;
    public static final TnsBlockedFeature BLOCKED_ADD_MEMBER = null;
    public static final TnsBlockedFeature BLOCKED_BOT_POST = null;
    public static final TnsBlockedFeature BLOCKED_CHAT_MENU_TNS = null;
    public static final TnsBlockedFeature BLOCKED_CHAT_TAB = null;
    public static final TnsBlockedFeature BLOCKED_GROUP_TASK = null;
    public static final TnsBlockedFeature BLOCKED_MANAGE_BOT = null;
    public static final TnsBlockedFeature BLOCKED_MESSAGE_MENU = null;
    public static final TnsBlockedFeature BLOCKED_MODIFY_CHAT_INFO = null;
    public static final TnsBlockedFeature BLOCKED_REMOVE_MEMBER = null;
    public static final TnsBlockedFeature UNKNOWN_BLOCKED_FEATURE = null;
    private final int value;

    static {
        TnsBlockedFeature r100 = new TnsBlockedFeature("UNKNOWN_BLOCKED_FEATURE", 0, 0);
        UNKNOWN_BLOCKED_FEATURE = r100;
        TnsBlockedFeature r101 = new TnsBlockedFeature("BLOCKED_ADD_MEMBER", 1, 1);
        BLOCKED_ADD_MEMBER = r101;
        TnsBlockedFeature r102 = new TnsBlockedFeature("BLOCKED_REMOVE_MEMBER", 2, 2);
        BLOCKED_REMOVE_MEMBER = r102;
        TnsBlockedFeature r103 = new TnsBlockedFeature("BLOCKED_CHAT_TAB", 3, 3);
        BLOCKED_CHAT_TAB = r103;
        TnsBlockedFeature r104 = new TnsBlockedFeature("BLOCKED_CHAT_MENU_TNS", 4, 4);
        BLOCKED_CHAT_MENU_TNS = r104;
        TnsBlockedFeature r105 = new TnsBlockedFeature("BLOCKED_MESSAGE_MENU", 5, 5);
        BLOCKED_MESSAGE_MENU = r105;
        TnsBlockedFeature r110 = new TnsBlockedFeature("BLOCKED_BOT_POST", 6, 6);
        BLOCKED_BOT_POST = r110;
        TnsBlockedFeature r111 = new TnsBlockedFeature("BLOCKED_MANAGE_BOT", 7, 7);
        BLOCKED_MANAGE_BOT = r111;
        TnsBlockedFeature r112 = new TnsBlockedFeature("BLOCKED_GROUP_TASK", 8, 8);
        BLOCKED_GROUP_TASK = r112;
        TnsBlockedFeature r113 = new TnsBlockedFeature("BLOCKED_MODIFY_CHAT_INFO", 9, 9);
        BLOCKED_MODIFY_CHAT_INFO = r113;
        $VALUES = new TnsBlockedFeature[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        ADAPTER = ProtoAdapter.newEnumAdapter(TnsBlockedFeature.class);
    }

    public static TnsBlockedFeature[] values() {
        return (TnsBlockedFeature[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TnsBlockedFeature fromValue(int r100) {
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
        return BLOCKED_MODIFY_CHAT_INFO;
    L8:
        return BLOCKED_GROUP_TASK;
    L10:
        return BLOCKED_MANAGE_BOT;
    L12:
        return BLOCKED_BOT_POST;
    L14:
        return BLOCKED_MESSAGE_MENU;
    L16:
        return BLOCKED_CHAT_MENU_TNS;
    L18:
        return BLOCKED_CHAT_TAB;
    L20:
        return BLOCKED_REMOVE_MEMBER;
    L22:
        return BLOCKED_ADD_MEMBER;
    L24:
        return UNKNOWN_BLOCKED_FEATURE;
    }

    public static TnsBlockedFeature valueOf(String r100) {
        return (TnsBlockedFeature) a.a(TnsBlockedFeature.class, r100);
    }

    private TnsBlockedFeature(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
