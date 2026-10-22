package com.ss.android.lark.pb.chatters;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum UserAgreementType extends Enum<UserAgreementType> implements WireEnum {
    private static final /* synthetic */ UserAgreementType[] $VALUES = null;
    public static final ProtoAdapter<UserAgreementType> ADAPTER = null;
    public static final UserAgreementType PERSONAL_INFO_TRANSFER_TO_ABROAD = null;
    private final int value;

    static {
        UserAgreementType r100 = new UserAgreementType("PERSONAL_INFO_TRANSFER_TO_ABROAD", 0, 1);
        PERSONAL_INFO_TRANSFER_TO_ABROAD = r100;
        $VALUES = new UserAgreementType[]{r100};
        ADAPTER = ProtoAdapter.newEnumAdapter(UserAgreementType.class);
    }

    public static UserAgreementType[] values() {
        return (UserAgreementType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static UserAgreementType fromValue(int r100) {
        if (r100 == 1) goto L7;
        return null;
    L7:
        return PERSONAL_INFO_TRANSFER_TO_ABROAD;
    }

    public static UserAgreementType valueOf(String r100) {
        return (UserAgreementType) a.a(UserAgreementType.class, r100);
    }

    private UserAgreementType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
