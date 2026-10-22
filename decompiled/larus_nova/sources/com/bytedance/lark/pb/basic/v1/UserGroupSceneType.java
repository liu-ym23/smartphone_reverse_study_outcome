package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum UserGroupSceneType extends Enum<UserGroupSceneType> implements WireEnum {
    private static final /* synthetic */ UserGroupSceneType[] $VALUES = null;
    public static final ProtoAdapter<UserGroupSceneType> ADAPTER = null;
    public static final UserGroupSceneType SceneType_APPROVAL = null;
    public static final UserGroupSceneType SceneType_APP_CENTER = null;
    public static final UserGroupSceneType SceneType_CALENDAR = null;
    public static final UserGroupSceneType SceneType_CCM = null;
    public static final UserGroupSceneType SceneType_DICTIONARY = null;
    public static final UserGroupSceneType SceneType_HELP_DESK = null;
    public static final UserGroupSceneType SceneType_OKR = null;
    public static final UserGroupSceneType SceneType_OPEN_PLATFORM = null;
    public static final UserGroupSceneType SceneType_SUBSCRIPTIONS = null;
    public static final UserGroupSceneType SceneType_UNKNOWN = null;
    private final int value;

    static {
        UserGroupSceneType r100 = new UserGroupSceneType("SceneType_UNKNOWN", 0, 0);
        SceneType_UNKNOWN = r100;
        UserGroupSceneType r101 = new UserGroupSceneType("SceneType_CCM", 1, 1);
        SceneType_CCM = r101;
        UserGroupSceneType r102 = new UserGroupSceneType("SceneType_CALENDAR", 2, 2);
        SceneType_CALENDAR = r102;
        UserGroupSceneType r103 = new UserGroupSceneType("SceneType_HELP_DESK", 3, 3);
        SceneType_HELP_DESK = r103;
        UserGroupSceneType r104 = new UserGroupSceneType("SceneType_APPROVAL", 4, 4);
        SceneType_APPROVAL = r104;
        UserGroupSceneType r105 = new UserGroupSceneType("SceneType_SUBSCRIPTIONS", 5, 5);
        SceneType_SUBSCRIPTIONS = r105;
        UserGroupSceneType r110 = new UserGroupSceneType("SceneType_OKR", 6, 6);
        SceneType_OKR = r110;
        UserGroupSceneType r111 = new UserGroupSceneType("SceneType_OPEN_PLATFORM", 7, 7);
        SceneType_OPEN_PLATFORM = r111;
        UserGroupSceneType r112 = new UserGroupSceneType("SceneType_DICTIONARY", 8, 8);
        SceneType_DICTIONARY = r112;
        UserGroupSceneType r113 = new UserGroupSceneType("SceneType_APP_CENTER", 9, 9);
        SceneType_APP_CENTER = r113;
        $VALUES = new UserGroupSceneType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        ADAPTER = ProtoAdapter.newEnumAdapter(UserGroupSceneType.class);
    }

    public static UserGroupSceneType[] values() {
        return (UserGroupSceneType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static UserGroupSceneType fromValue(int r100) {
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
        return SceneType_APP_CENTER;
    L8:
        return SceneType_DICTIONARY;
    L10:
        return SceneType_OPEN_PLATFORM;
    L12:
        return SceneType_OKR;
    L14:
        return SceneType_SUBSCRIPTIONS;
    L16:
        return SceneType_APPROVAL;
    L18:
        return SceneType_HELP_DESK;
    L20:
        return SceneType_CALENDAR;
    L22:
        return SceneType_CCM;
    L24:
        return SceneType_UNKNOWN;
    }

    public static UserGroupSceneType valueOf(String r100) {
        return (UserGroupSceneType) a.a(UserGroupSceneType.class, r100);
    }

    private UserGroupSceneType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
