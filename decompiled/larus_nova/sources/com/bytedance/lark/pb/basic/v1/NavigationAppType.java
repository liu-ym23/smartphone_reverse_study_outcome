package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum NavigationAppType extends Enum<NavigationAppType> implements WireEnum {
    private static final /* synthetic */ NavigationAppType[] $VALUES = null;
    public static final ProtoAdapter<NavigationAppType> ADAPTER = null;
    public static final NavigationAppType APP_TYPE_CUSTOM_NATIVE = null;
    public static final NavigationAppType APP_TYPE_LARK_NATIVE = null;
    public static final NavigationAppType APP_TYPE_MINI = null;
    public static final NavigationAppType APP_TYPE_OPEN_APP = null;
    public static final NavigationAppType APP_TYPE_URL = null;
    public static final NavigationAppType APP_TYPE_WEB = null;
    private final int value;

    static {
        NavigationAppType r100 = new NavigationAppType("APP_TYPE_LARK_NATIVE", 0, 1);
        APP_TYPE_LARK_NATIVE = r100;
        NavigationAppType r101 = new NavigationAppType("APP_TYPE_MINI", 1, 2);
        APP_TYPE_MINI = r101;
        NavigationAppType r102 = new NavigationAppType("APP_TYPE_WEB", 2, 3);
        APP_TYPE_WEB = r102;
        NavigationAppType r103 = new NavigationAppType("APP_TYPE_CUSTOM_NATIVE", 3, 4);
        APP_TYPE_CUSTOM_NATIVE = r103;
        NavigationAppType r104 = new NavigationAppType("APP_TYPE_OPEN_APP", 4, 5);
        APP_TYPE_OPEN_APP = r104;
        NavigationAppType r110 = new NavigationAppType("APP_TYPE_URL", 5, 6);
        APP_TYPE_URL = r110;
        $VALUES = new NavigationAppType[]{r100, r101, r102, r103, r104, r110};
        ADAPTER = ProtoAdapter.newEnumAdapter(NavigationAppType.class);
    }

    public static NavigationAppType[] values() {
        return (NavigationAppType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static NavigationAppType fromValue(int r100) {
        switch(r100) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return APP_TYPE_URL;
    L8:
        return APP_TYPE_OPEN_APP;
    L10:
        return APP_TYPE_CUSTOM_NATIVE;
    L12:
        return APP_TYPE_WEB;
    L14:
        return APP_TYPE_MINI;
    L16:
        return APP_TYPE_LARK_NATIVE;
    }

    public static NavigationAppType valueOf(String r100) {
        return (NavigationAppType) a.a(NavigationAppType.class, r100);
    }

    private NavigationAppType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
