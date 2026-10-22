package com.ss.android.lark.pb.misc;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum DeniedReason extends Enum<DeniedReason> implements WireEnum {
    private static final /* synthetic */ DeniedReason[] $VALUES = null;
    public static final ProtoAdapter<DeniedReason> ADAPTER = null;
    public static final DeniedReason BE_BLOCKED = null;
    public static final DeniedReason BLOCKED = null;
    public static final DeniedReason CROSS_TENANT_DENY = null;
    public static final DeniedReason CRYPTO_CHAT_DENY = null;
    public static final DeniedReason EXTERNAL_COORDINATE_CTL = null;
    public static final DeniedReason NOT_SUPPORT_AI = null;
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
        DeniedReason r117 = new DeniedReason("NOT_SUPPORT_AI", 17, 51);
        NOT_SUPPORT_AI = r117;
        $VALUES = new DeniedReason[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117};
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
        if (r100 == 51) goto L43;
        switch(r100) {
            case 0: goto L41;
            case 1: goto L39;
            case 2: goto L37;
            case 3: goto L35;
            case 4: goto L33;
            case 5: goto L31;
            case 6: goto L29;
            case 7: goto L27;
            case 8: goto L25;
            case 9: goto L23;
            case 10: goto L21;
            case 11: goto L19;
            case 12: goto L17;
            default: goto L5;
        };
    L5:
        switch(r100) {
            case 15: goto L15;
            case 16: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            default: goto L6;
        };
    L6:
        return null;
    L9:
        return PRIVATE_CHAT_CROSS_TENANT;
    L11:
        return PRIVATE_CHAT_DENY;
    L13:
        return PRIVATE_CHAT_KMS_UNAVAILABLE;
    L15:
        return PRIVATE_CHAT_DISABLED;
    L17:
        return SEND_SECRET_CHAT_BY_ICON_DENY;
    L19:
        return TARGET_EXTERNAL_COORDINATE_CTL;
    L21:
        return EXTERNAL_COORDINATE_CTL;
    L23:
        return PRIVATE_CALENDAR;
    L25:
        return TARGET_PRIVACY_SETTING;
    L27:
        return PRIVACY_SETTING;
    L29:
        return NO_FRIENDSHIP;
    L31:
        return BLOCKED;
    L33:
        return CRYPTO_CHAT_DENY;
    L35:
        return SAME_TENANT_DENY;
    L37:
        return CROSS_TENANT_DENY;
    L39:
        return BE_BLOCKED;
    L41:
        return UNKNOWN_REASON;
    L43:
        return NOT_SUPPORT_AI;
    }

    public static DeniedReason valueOf(String r100) {
        return (DeniedReason) a.a(DeniedReason.class, r100);
    }

    private DeniedReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
