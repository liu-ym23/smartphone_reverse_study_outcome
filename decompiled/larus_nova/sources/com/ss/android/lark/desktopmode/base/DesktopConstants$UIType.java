package com.ss.android.lark.desktopmode.base;

import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public final enum DesktopConstants$UIType extends Enum<DesktopConstants$UIType> {
    public static final DesktopConstants$UIType DRAWER_MAX_C2 = null;
    public static final DesktopConstants$UIType DRAWER_NORMAL_C1 = null;
    public static final DesktopConstants$UIType FLOAT_MODAL_THIN_M2 = null;
    public static final DesktopConstants$UIType FLOAT_MODAL_WIDE_M1 = null;
    public static final DesktopConstants$UIType FLOAT_POPOVER_P1 = null;
    public static final DesktopConstants$UIType UNKNOWN = null;
    public static final DesktopConstants$UIType WINDOW_CENTER_D3 = null;
    public static final DesktopConstants$UIType WINDOW_NORMAL_D1 = null;
    public static final DesktopConstants$UIType WINDOW_WIDE_D2 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DesktopConstants$UIType[] f420391a = null;
    private String value;

    static {
        DesktopConstants$UIType r100 = new DesktopConstants$UIType("UNKNOWN", 0, "UNKNOWN");
        UNKNOWN = r100;
        DesktopConstants$UIType r101 = new DesktopConstants$UIType("FLOAT_MODAL_WIDE_M1", 1, "M1");
        FLOAT_MODAL_WIDE_M1 = r101;
        DesktopConstants$UIType r102 = new DesktopConstants$UIType("FLOAT_MODAL_THIN_M2", 2, "M2");
        FLOAT_MODAL_THIN_M2 = r102;
        DesktopConstants$UIType r103 = new DesktopConstants$UIType("FLOAT_POPOVER_P1", 3, DiagnoseResult.DIAGNOSE_LEVEL_P1);
        FLOAT_POPOVER_P1 = r103;
        DesktopConstants$UIType r104 = new DesktopConstants$UIType("DRAWER_NORMAL_C1", 4, "C1");
        DRAWER_NORMAL_C1 = r104;
        DesktopConstants$UIType r105 = new DesktopConstants$UIType("DRAWER_MAX_C2", 5, "C2");
        DRAWER_MAX_C2 = r105;
        DesktopConstants$UIType r110 = new DesktopConstants$UIType("WINDOW_NORMAL_D1", 6, "D1");
        WINDOW_NORMAL_D1 = r110;
        DesktopConstants$UIType r111 = new DesktopConstants$UIType("WINDOW_WIDE_D2", 7, "D2");
        WINDOW_WIDE_D2 = r111;
        DesktopConstants$UIType r112 = new DesktopConstants$UIType("WINDOW_CENTER_D3", 8, "D3");
        WINDOW_CENTER_D3 = r112;
        f420391a = new DesktopConstants$UIType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static DesktopConstants$UIType[] values() {
        return (DesktopConstants$UIType[]) f420391a.clone();
    }

    public String getValue() {
        return this.value;
    }

    public static DesktopConstants$UIType forValue(String r100) {
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case 2126: goto L34;
            case 2127: goto L30;
            case 2157: goto L26;
            case 2158: goto L22;
            case 2159: goto L18;
            case 2436: goto L14;
            case 2437: goto L10;
            case 2529: goto L6;
            default: goto L37;
        };
    L37:
        switch(r101) {
            case 0: goto L55;
            case 1: goto L53;
            case 2: goto L51;
            case 3: goto L49;
            case 4: goto L47;
            case 5: goto L45;
            case 6: goto L43;
            case 7: goto L41;
            default: goto L39;
        };
    L39:
        return UNKNOWN;
    L41:
        return FLOAT_POPOVER_P1;
    L43:
        return FLOAT_MODAL_THIN_M2;
    L45:
        return FLOAT_MODAL_WIDE_M1;
    L47:
        return WINDOW_CENTER_D3;
    L49:
        return WINDOW_WIDE_D2;
    L51:
        return WINDOW_NORMAL_D1;
    L53:
        return DRAWER_MAX_C2;
    L55:
        return DRAWER_NORMAL_C1;
    L6:
        if (r100.equals(DiagnoseResult.DIAGNOSE_LEVEL_P1) == false) goto L37;
        r101 = 7;
        goto L37
    L10:
        if (r100.equals("M2") == false) goto L37;
        r101 = 6;
        goto L37
    L14:
        if (r100.equals("M1") == false) goto L37;
        r101 = 5;
        goto L37
    L18:
        if (r100.equals("D3") == false) goto L37;
        r101 = 4;
        goto L37
    L22:
        if (r100.equals("D2") == false) goto L37;
        r101 = 3;
        goto L37
    L26:
        if (r100.equals("D1") == false) goto L37;
        r101 = 2;
        goto L37
    L30:
        if (r100.equals("C2") == false) goto L37;
        r101 = 1;
        goto L37
    L34:
        if (r100.equals("C1") == false) goto L37;
        r101 = 0;
        goto L37
    }

    public static DesktopConstants$UIType valueOf(String r100) {
        return (DesktopConstants$UIType) a.a(DesktopConstants$UIType.class, r100);
    }

    public DesktopConstants$UIType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
