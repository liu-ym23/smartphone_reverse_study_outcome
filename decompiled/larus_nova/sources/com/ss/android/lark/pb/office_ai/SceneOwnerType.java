package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum SceneOwnerType extends Enum<SceneOwnerType> implements WireEnum {
    private static final /* synthetic */ SceneOwnerType[] $VALUES = null;
    public static final ProtoAdapter<SceneOwnerType> ADAPTER = null;
    public static final SceneOwnerType MyAIOwnerType_APP = null;
    public static final SceneOwnerType MyAIOwnerType_OFFICIAL = null;
    public static final SceneOwnerType MyAIOwnerType_USER = null;
    private final int value;

    static {
        SceneOwnerType r100 = new SceneOwnerType("MyAIOwnerType_USER", 0, 1);
        MyAIOwnerType_USER = r100;
        SceneOwnerType r101 = new SceneOwnerType("MyAIOwnerType_APP", 1, 2);
        MyAIOwnerType_APP = r101;
        SceneOwnerType r102 = new SceneOwnerType("MyAIOwnerType_OFFICIAL", 2, 3);
        MyAIOwnerType_OFFICIAL = r102;
        $VALUES = new SceneOwnerType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(SceneOwnerType.class);
    }

    public static SceneOwnerType[] values() {
        return (SceneOwnerType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SceneOwnerType fromValue(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return null;
    L11:
        return MyAIOwnerType_OFFICIAL;
    L13:
        return MyAIOwnerType_APP;
    L15:
        return MyAIOwnerType_USER;
    }

    public static SceneOwnerType valueOf(String r100) {
        return (SceneOwnerType) a.a(SceneOwnerType.class, r100);
    }

    private SceneOwnerType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
