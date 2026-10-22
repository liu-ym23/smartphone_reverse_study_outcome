package com.bytedance.badger.collect.impl.constants;

import r27.a;

/* JADX INFO: loaded from: classes47.dex */
public final enum NetworkMethodEnum extends Enum<NetworkMethodEnum> {
    private static final /* synthetic */ NetworkMethodEnum[] $VALUES = null;
    public static final NetworkMethodEnum GET = null;
    public static final NetworkMethodEnum POST = null;
    public static final NetworkMethodEnum POST_FOR_WIFI_TO_CELLULAR = null;

    static {
        NetworkMethodEnum r100 = new NetworkMethodEnum("GET", 0);
        GET = r100;
        NetworkMethodEnum r101 = new NetworkMethodEnum("POST", 1);
        POST = r101;
        NetworkMethodEnum r102 = new NetworkMethodEnum("POST_FOR_WIFI_TO_CELLULAR", 2);
        POST_FOR_WIFI_TO_CELLULAR = r102;
        $VALUES = new NetworkMethodEnum[]{r100, r101, r102};
    }

    public static NetworkMethodEnum[] values() {
        return (NetworkMethodEnum[]) $VALUES.clone();
    }

    public static NetworkMethodEnum valueOf(String r100) {
        return (NetworkMethodEnum) a.a(NetworkMethodEnum.class, r100);
    }

    private NetworkMethodEnum(String r100, int r101) {
        super(r100, r101);
    }
}
