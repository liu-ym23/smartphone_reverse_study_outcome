package com.bytedance.lark.pb.security.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ChallengeType extends Enum<ChallengeType> implements WireEnum {
    private static final /* synthetic */ ChallengeType[] $VALUES = null;
    public static final ProtoAdapter<ChallengeType> ADAPTER = null;
    public static final ChallengeType CHALLENGE_TYPE_UNKNOWN = null;
    public static final ChallengeType INCOMPATIBLE_OS_TYPE = null;
    public static final ChallengeType INCOMPATIBLE_TERMINAL_TYPE = null;
    public static final ChallengeType NEED_APPLY_DEVICE_OWNERSHIP = null;
    public static final ChallengeType NEED_APPLY_DEVICE_STATUS = null;
    public static final ChallengeType NEED_BIND_LSA_CLIENT = null;
    public static final ChallengeType NEED_CLIENT_APPLY_DEVICE_OWNERSHIP = null;
    public static final ChallengeType NEED_CLIENT_APPLY_DEVICE_STATUS = null;
    public static final ChallengeType NEED_CLIENT_MANAGED_DEVICE = null;
    public static final ChallengeType NEED_CLIENT_NOT_MANAGED_DEVICE = null;
    public static final ChallengeType NEED_CLIENT_REGISTERED_DEVICE = null;
    public static final ChallengeType NEED_MANAGED_DEVICE = null;
    public static final ChallengeType NEED_OAUTH_REAUTHORIZATION = null;
    public static final ChallengeType NEED_REGISTERED_DEVICE = null;
    public static final ChallengeType NOT_MANAGED_DEVICE = null;
    private final int value;

    static {
        ChallengeType r100 = new ChallengeType("CHALLENGE_TYPE_UNKNOWN", 0, 0);
        CHALLENGE_TYPE_UNKNOWN = r100;
        ChallengeType r101 = new ChallengeType("NEED_APPLY_DEVICE_OWNERSHIP", 1, 1);
        NEED_APPLY_DEVICE_OWNERSHIP = r101;
        ChallengeType r102 = new ChallengeType("NEED_APPLY_DEVICE_STATUS", 2, 2);
        NEED_APPLY_DEVICE_STATUS = r102;
        ChallengeType r103 = new ChallengeType("NEED_REGISTERED_DEVICE", 3, 3);
        NEED_REGISTERED_DEVICE = r103;
        ChallengeType r104 = new ChallengeType("NEED_MANAGED_DEVICE", 4, 4);
        NEED_MANAGED_DEVICE = r104;
        ChallengeType r105 = new ChallengeType("NEED_CLIENT_APPLY_DEVICE_OWNERSHIP", 5, 5);
        NEED_CLIENT_APPLY_DEVICE_OWNERSHIP = r105;
        ChallengeType r110 = new ChallengeType("NEED_CLIENT_APPLY_DEVICE_STATUS", 6, 6);
        NEED_CLIENT_APPLY_DEVICE_STATUS = r110;
        ChallengeType r111 = new ChallengeType("NEED_CLIENT_REGISTERED_DEVICE", 7, 7);
        NEED_CLIENT_REGISTERED_DEVICE = r111;
        ChallengeType r112 = new ChallengeType("NEED_CLIENT_MANAGED_DEVICE", 8, 8);
        NEED_CLIENT_MANAGED_DEVICE = r112;
        ChallengeType r113 = new ChallengeType("INCOMPATIBLE_OS_TYPE", 9, 9);
        INCOMPATIBLE_OS_TYPE = r113;
        ChallengeType r114 = new ChallengeType("INCOMPATIBLE_TERMINAL_TYPE", 10, 10);
        INCOMPATIBLE_TERMINAL_TYPE = r114;
        ChallengeType r115 = new ChallengeType("NEED_BIND_LSA_CLIENT", 11, 11);
        NEED_BIND_LSA_CLIENT = r115;
        ChallengeType r106 = new ChallengeType("NOT_MANAGED_DEVICE", 12, 12);
        NOT_MANAGED_DEVICE = r106;
        ChallengeType r107 = new ChallengeType("NEED_CLIENT_NOT_MANAGED_DEVICE", 13, 13);
        NEED_CLIENT_NOT_MANAGED_DEVICE = r107;
        ChallengeType r108 = new ChallengeType("NEED_OAUTH_REAUTHORIZATION", 14, 16);
        NEED_OAUTH_REAUTHORIZATION = r108;
        $VALUES = new ChallengeType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108};
        ADAPTER = ProtoAdapter.newEnumAdapter(ChallengeType.class);
    }

    public static ChallengeType[] values() {
        return (ChallengeType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ChallengeType fromValue(int r100) {
        if (r100 == 16) goto L36;
        switch(r100) {
            case 0: goto L34;
            case 1: goto L32;
            case 2: goto L30;
            case 3: goto L28;
            case 4: goto L26;
            case 5: goto L24;
            case 6: goto L22;
            case 7: goto L20;
            case 8: goto L18;
            case 9: goto L16;
            case 10: goto L14;
            case 11: goto L12;
            case 12: goto L10;
            case 13: goto L8;
            default: goto L5;
        };
    L5:
        return null;
    L8:
        return NEED_CLIENT_NOT_MANAGED_DEVICE;
    L10:
        return NOT_MANAGED_DEVICE;
    L12:
        return NEED_BIND_LSA_CLIENT;
    L14:
        return INCOMPATIBLE_TERMINAL_TYPE;
    L16:
        return INCOMPATIBLE_OS_TYPE;
    L18:
        return NEED_CLIENT_MANAGED_DEVICE;
    L20:
        return NEED_CLIENT_REGISTERED_DEVICE;
    L22:
        return NEED_CLIENT_APPLY_DEVICE_STATUS;
    L24:
        return NEED_CLIENT_APPLY_DEVICE_OWNERSHIP;
    L26:
        return NEED_MANAGED_DEVICE;
    L28:
        return NEED_REGISTERED_DEVICE;
    L30:
        return NEED_APPLY_DEVICE_STATUS;
    L32:
        return NEED_APPLY_DEVICE_OWNERSHIP;
    L34:
        return CHALLENGE_TYPE_UNKNOWN;
    L36:
        return NEED_OAUTH_REAUTHORIZATION;
    }

    public static ChallengeType valueOf(String r100) {
        return (ChallengeType) a.a(ChallengeType.class, r100);
    }

    private ChallengeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
