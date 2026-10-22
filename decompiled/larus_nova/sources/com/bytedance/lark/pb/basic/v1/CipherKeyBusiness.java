package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum CipherKeyBusiness extends Enum<CipherKeyBusiness> implements WireEnum {
    private static final /* synthetic */ CipherKeyBusiness[] $VALUES = null;
    public static final ProtoAdapter<CipherKeyBusiness> ADAPTER = null;
    public static final CipherKeyBusiness CCM = null;
    public static final CipherKeyBusiness IM = null;
    public static final CipherKeyBusiness Unknown = null;
    private final int value;

    static {
        CipherKeyBusiness r100 = new CipherKeyBusiness("Unknown", 0, 0);
        Unknown = r100;
        CipherKeyBusiness r101 = new CipherKeyBusiness("IM", 1, 1);
        IM = r101;
        CipherKeyBusiness r102 = new CipherKeyBusiness("CCM", 2, 2);
        CCM = r102;
        $VALUES = new CipherKeyBusiness[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(CipherKeyBusiness.class);
    }

    public static CipherKeyBusiness[] values() {
        return (CipherKeyBusiness[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static CipherKeyBusiness fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return CCM;
    L12:
        return IM;
    L14:
        return Unknown;
    }

    public static CipherKeyBusiness valueOf(String r100) {
        return (CipherKeyBusiness) a.a(CipherKeyBusiness.class, r100);
    }

    private CipherKeyBusiness(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
