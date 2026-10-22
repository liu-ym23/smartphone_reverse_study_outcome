package com.bytedance.lark.pb.tool.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum UserLoginState extends Enum<UserLoginState> implements WireEnum {
    private static final /* synthetic */ UserLoginState[] $VALUES = null;
    public static final ProtoAdapter<UserLoginState> ADAPTER = null;
    public static final UserLoginState BACKGROUND_ONLINE = null;
    public static final UserLoginState FOREGROUND_ONLINE = null;
    public static final UserLoginState OFFLINE = null;
    private final int value;

    static {
        UserLoginState r100 = new UserLoginState("OFFLINE", 0, 0);
        OFFLINE = r100;
        UserLoginState r101 = new UserLoginState("FOREGROUND_ONLINE", 1, 1);
        FOREGROUND_ONLINE = r101;
        UserLoginState r102 = new UserLoginState("BACKGROUND_ONLINE", 2, 2);
        BACKGROUND_ONLINE = r102;
        $VALUES = new UserLoginState[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(UserLoginState.class);
    }

    public static UserLoginState[] values() {
        return (UserLoginState[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static UserLoginState fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return BACKGROUND_ONLINE;
    L12:
        return FOREGROUND_ONLINE;
    L14:
        return OFFLINE;
    }

    public static UserLoginState valueOf(String r100) {
        return (UserLoginState) a.a(UserLoginState.class, r100);
    }

    private UserLoginState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
