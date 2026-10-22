package com.ss.android.lark.pb.improto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum AppId extends Enum<AppId> implements WireEnum {
    private static final /* synthetic */ AppId[] $VALUES = null;
    public static final ProtoAdapter<AppId> ADAPTER = null;
    public static final AppId APP_ID_DOUBAO = null;
    public static final AppId APP_ID_FEISHU = null;
    public static final AppId APP_ID_NONE = null;
    private final int value;

    static {
        AppId r100 = new AppId("APP_ID_NONE", 0, 0);
        APP_ID_NONE = r100;
        AppId r101 = new AppId("APP_ID_FEISHU", 1, 1);
        APP_ID_FEISHU = r101;
        AppId r102 = new AppId("APP_ID_DOUBAO", 2, 176);
        APP_ID_DOUBAO = r102;
        $VALUES = new AppId[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(AppId.class);
    }

    public static AppId[] values() {
        return (AppId[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static AppId fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 176) goto L10;
        return null;
    L10:
        return APP_ID_DOUBAO;
    L12:
        return APP_ID_FEISHU;
    L14:
        return APP_ID_NONE;
    }

    public static AppId valueOf(String r100) {
        return (AppId) a.a(AppId.class, r100);
    }

    private AppId(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
