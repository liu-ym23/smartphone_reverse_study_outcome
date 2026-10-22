package com.bytedance.dora.transfer;

/* JADX INFO: loaded from: classes15.dex */
public final enum DoraDeviceLinkType extends Enum<DoraDeviceLinkType> {
    public static final DoraDeviceLinkType BLE_ANCS = null;
    public static final DoraDeviceLinkType BLE_GATT_OVER_BT = null;
    public static final DoraDeviceLinkType BLE_L2CAP_OVER_BT = null;
    public static final DoraDeviceLinkType MFI_IAP2 = null;
    public static final DoraDeviceLinkType SPP = null;
    public static final DoraDeviceLinkType UNKNOWN = null;
    public static final DoraDeviceLinkType WIFI_AWARE = null;
    public static final DoraDeviceLinkType WIFI_P2P = null;
    public static final DoraDeviceLinkType WIFI_SOFT_AP = null;
    public static final DoraDeviceLinkType WIFI_STATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraDeviceLinkType[] f204663a = null;
    private final int value;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f204664a = null;

        static {
            int[] r100 = new int[DoraDeviceLinkType.values().length];
            f204664a = r100;
            r100[DoraDeviceLinkType.MFI_IAP2.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f204664a[DoraDeviceLinkType.WIFI_SOFT_AP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f204664a[DoraDeviceLinkType.WIFI_STATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f204664a[DoraDeviceLinkType.WIFI_P2P.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f204664a[DoraDeviceLinkType.SPP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        DoraDeviceLinkType r100 = new DoraDeviceLinkType("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        DoraDeviceLinkType r101 = new DoraDeviceLinkType("MFI_IAP2", 1, 0);
        MFI_IAP2 = r101;
        DoraDeviceLinkType r102 = new DoraDeviceLinkType("BLE_GATT_OVER_BT", 2, 1);
        BLE_GATT_OVER_BT = r102;
        DoraDeviceLinkType r103 = new DoraDeviceLinkType("BLE_L2CAP_OVER_BT", 3, 2);
        BLE_L2CAP_OVER_BT = r103;
        DoraDeviceLinkType r104 = new DoraDeviceLinkType("BLE_ANCS", 4, 3);
        BLE_ANCS = r104;
        DoraDeviceLinkType r105 = new DoraDeviceLinkType("WIFI_STATION", 5, 4);
        WIFI_STATION = r105;
        DoraDeviceLinkType r110 = new DoraDeviceLinkType("WIFI_SOFT_AP", 6, 5);
        WIFI_SOFT_AP = r110;
        DoraDeviceLinkType r111 = new DoraDeviceLinkType("WIFI_AWARE", 7, 6);
        WIFI_AWARE = r111;
        DoraDeviceLinkType r112 = new DoraDeviceLinkType("WIFI_P2P", 8, 7);
        WIFI_P2P = r112;
        DoraDeviceLinkType r113 = new DoraDeviceLinkType("SPP", 9, 8);
        SPP = r113;
        f204663a = new DoraDeviceLinkType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static DoraDeviceLinkType[] values() {
        return (DoraDeviceLinkType[]) f204663a.clone();
    }

    public String getTrackerDesc() {
        int r100 = a.f204664a[ordinal()];
        if (r100 != 1) goto L5;
        return "iAP2";
    L5:
        if (r100 != 2) goto L7;
        return "SOFT_AP";
    L7:
        if (r100 != 3) goto L9;
        return "STATION";
    L9:
        if (r100 != 4) goto L11;
        return "P2P";
    L11:
        if (r100 != 5) goto L13;
        return "SPP";
    L13:
        return name();
    }

    public int getValue() {
        return this.value;
    }

    public static DoraDeviceLinkType fromValue(int r100) {
        DoraDeviceLinkType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        DoraDeviceLinkType r104 = r101[r103];
        if (r104.value == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return UNKNOWN;
    }

    public static DoraDeviceLinkType valueOf(String r100) {
        return (DoraDeviceLinkType) r27.a.a(DoraDeviceLinkType.class, r100);
    }

    public DoraDeviceLinkType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
