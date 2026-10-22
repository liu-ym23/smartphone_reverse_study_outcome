package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
final enum AddressFamily extends Enum<AddressFamily> {
    private static final /* synthetic */ AddressFamily[] $VALUES = null;
    public static final AddressFamily ADDRESS_FAMILY_IPV4 = null;
    public static final AddressFamily ADDRESS_FAMILY_IPV6 = null;
    public static final AddressFamily ADDRESS_FAMILY_UNSPECIFIED = null;

    static {
        AddressFamily r100 = new AddressFamily("ADDRESS_FAMILY_UNSPECIFIED", 0);
        ADDRESS_FAMILY_UNSPECIFIED = r100;
        AddressFamily r101 = new AddressFamily("ADDRESS_FAMILY_IPV4", 1);
        ADDRESS_FAMILY_IPV4 = r101;
        AddressFamily r102 = new AddressFamily("ADDRESS_FAMILY_IPV6", 2);
        ADDRESS_FAMILY_IPV6 = r102;
        $VALUES = new AddressFamily[]{r100, r101, r102};
    }

    public static AddressFamily[] values() {
        return (AddressFamily[]) $VALUES.clone();
    }

    public static AddressFamily valueOf(String r100) {
        return (AddressFamily) a.a(AddressFamily.class, r100);
    }

    private AddressFamily(String r100, int r101) {
        super(r100, r101);
    }
}
