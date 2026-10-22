package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum DeniedReason extends Enum<DeniedReason> implements WireEnum {
    private static final /* synthetic */ DeniedReason[] $VALUES = null;
    public static final ProtoAdapter<DeniedReason> ADAPTER = null;
    public static final DeniedReason BE_BLOCKED = null;
    public static final DeniedReason BLOCKED = null;
    public static final DeniedReason CROSS_TENANT_DENY = null;
    public static final DeniedReason CRYPTO_CHAT_DENY = null;
    public static final DeniedReason EXTERNAL_COORDINATE_CTL = null;
    public static final DeniedReason NO_FRIENDSHIP = null;
    public static final DeniedReason PRIVACY_SETTING = null;
    public static final DeniedReason PRIVATE_CALENDAR = null;
    public static final DeniedReason PRIVATE_CHAT_CROSS_TENANT = null;
    public static final DeniedReason PRIVATE_CHAT_DENY = null;
    public static final DeniedReason PRIVATE_CHAT_DISABLED = null;
    public static final DeniedReason PRIVATE_CHAT_KMS_UNAVAILABLE = null;
    public static final DeniedReason SAME_TENANT_DENY = null;
    public static final DeniedReason SEND_SECRET_CHAT_BY_ICON_DENY = null;
    public static final DeniedReason TARGET_EXTERNAL_COORDINATE_CTL = null;
    public static final DeniedReason TARGET_PRIVACY_SETTING = null;
    public static final DeniedReason UNKNOWN_REASON = null;
    private final int value;

    static {
        DeniedReason r100 = new DeniedReason("UNKNOWN_REASON", 0, 0);
        UNKNOWN_REASON = r100;
        DeniedReason r101 = new DeniedReason("BE_BLOCKED", 1, 1);
        BE_BLOCKED = r101;
        DeniedReason r102 = new DeniedReason("CROSS_TENANT_DENY", 2, 2);
        CROSS_TENANT_DENY = r102;
        DeniedReason r103 = new DeniedReason("SAME_TENANT_DENY", 3, 3);
        SAME_TENANT_DENY = r103;
        DeniedReason r104 = new DeniedReason("CRYPTO_CHAT_DENY", 4, 4);
        CRYPTO_CHAT_DENY = r104;
        DeniedReason r105 = new DeniedReason("BLOCKED", 5, 5);
        BLOCKED = r105;
        DeniedReason r110 = new DeniedReason("NO_FRIENDSHIP", 6, 6);
        NO_FRIENDSHIP = r110;
        DeniedReason r111 = new DeniedReason("PRIVACY_SETTING", 7, 7);
        PRIVACY_SETTING = r111;
        DeniedReason r112 = new DeniedReason("TARGET_PRIVACY_SETTING", 8, 8);
        TARGET_PRIVACY_SETTING = r112;
        DeniedReason r113 = new DeniedReason("PRIVATE_CALENDAR", 9, 9);
        PRIVATE_CALENDAR = r113;
        DeniedReason r114 = new DeniedReason("EXTERNAL_COORDINATE_CTL", 10, 10);
        EXTERNAL_COORDINATE_CTL = r114;
        DeniedReason r115 = new DeniedReason("TARGET_EXTERNAL_COORDINATE_CTL", 11, 11);
        TARGET_EXTERNAL_COORDINATE_CTL = r115;
        DeniedReason r106 = new DeniedReason("SEND_SECRET_CHAT_BY_ICON_DENY", 12, 12);
        SEND_SECRET_CHAT_BY_ICON_DENY = r106;
        DeniedReason r107 = new DeniedReason("PRIVATE_CHAT_DISABLED", 13, 15);
        PRIVATE_CHAT_DISABLED = r107;
        DeniedReason r108 = new DeniedReason("PRIVATE_CHAT_KMS_UNAVAILABLE", 14, 16);
        PRIVATE_CHAT_KMS_UNAVAILABLE = r108;
        DeniedReason r109 = new DeniedReason("PRIVATE_CHAT_DENY", 15, 17);
        PRIVATE_CHAT_DENY = r109;
        DeniedReason r116 = new DeniedReason("PRIVATE_CHAT_CROSS_TENANT", 16, 18);
        PRIVATE_CHAT_CROSS_TENANT = r116;
        $VALUES = new DeniedReason[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116};
        ADAPTER = ProtoAdapter.newEnumAdapter(DeniedReason.class);
    }

    public static DeniedReason[] values() {
        return (DeniedReason[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static DeniedReason fromValue(int r100) {
        switch(r100) {
            case 0: goto L38;
            case 1: goto L36;
            case 2: goto L34;
            case 3: goto L32;
            case 4: goto L30;
            case 5: goto L28;
            case 6: goto L26;
            case 7: goto L24;
            case 8: goto L22;
            case 9: goto L20;
            case 10: goto L18;
            case 11: goto L16;
            case 12: goto L14;
            case 13: goto L3;
            case 14: goto L3;
            case 15: goto L12;
            case 16: goto L10;
            case 17: goto L8;
            case 18: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return PRIVATE_CHAT_CROSS_TENANT;
    L8:
        return PRIVATE_CHAT_DENY;
    L10:
        return PRIVATE_CHAT_KMS_UNAVAILABLE;
    L12:
        return PRIVATE_CHAT_DISABLED;
    L14:
        return SEND_SECRET_CHAT_BY_ICON_DENY;
    L16:
        return TARGET_EXTERNAL_COORDINATE_CTL;
    L18:
        return EXTERNAL_COORDINATE_CTL;
    L20:
        return PRIVATE_CALENDAR;
    L22:
        return TARGET_PRIVACY_SETTING;
    L24:
        return PRIVACY_SETTING;
    L26:
        return NO_FRIENDSHIP;
    L28:
        return BLOCKED;
    L30:
        return CRYPTO_CHAT_DENY;
    L32:
        return SAME_TENANT_DENY;
    L34:
        return CROSS_TENANT_DENY;
    L36:
        return BE_BLOCKED;
    L38:
        return UNKNOWN_REASON;
    }

    public static DeniedReason valueOf(String r100) {
        return (DeniedReason) a.a(DeniedReason.class, r100);
    }

    private DeniedReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
