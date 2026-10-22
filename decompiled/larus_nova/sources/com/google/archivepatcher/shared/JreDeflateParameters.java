package com.google.archivepatcher.shared;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.framework.common.ContainerUtils;

/* JADX INFO: loaded from: classes23.dex */
public final enum JreDeflateParameters extends Enum<JreDeflateParameters> {
    public static final JreDeflateParameters LEVEL1_STRATEGY0_NOWRAP = null;
    public static final JreDeflateParameters LEVEL1_STRATEGY0_WRAP = null;
    public static final JreDeflateParameters LEVEL1_STRATEGY1_NOWRAP = null;
    public static final JreDeflateParameters LEVEL1_STRATEGY1_WRAP = null;
    public static final JreDeflateParameters LEVEL1_STRATEGY2_NOWRAP = null;
    public static final JreDeflateParameters LEVEL1_STRATEGY2_WRAP = null;
    public static final JreDeflateParameters LEVEL2_STRATEGY0_NOWRAP = null;
    public static final JreDeflateParameters LEVEL2_STRATEGY0_WRAP = null;
    public static final JreDeflateParameters LEVEL2_STRATEGY1_NOWRAP = null;
    public static final JreDeflateParameters LEVEL2_STRATEGY1_WRAP = null;
    public static final JreDeflateParameters LEVEL2_STRATEGY2_NOWRAP = null;
    public static final JreDeflateParameters LEVEL2_STRATEGY2_WRAP = null;
    public static final JreDeflateParameters LEVEL3_STRATEGY0_NOWRAP = null;
    public static final JreDeflateParameters LEVEL3_STRATEGY0_WRAP = null;
    public static final JreDeflateParameters LEVEL3_STRATEGY1_NOWRAP = null;
    public static final JreDeflateParameters LEVEL3_STRATEGY1_WRAP = null;
    public static final JreDeflateParameters LEVEL3_STRATEGY2_NOWRAP = null;
    public static final JreDeflateParameters LEVEL3_STRATEGY2_WRAP = null;
    public static final JreDeflateParameters LEVEL4_STRATEGY0_NOWRAP = null;
    public static final JreDeflateParameters LEVEL4_STRATEGY0_WRAP = null;
    public static final JreDeflateParameters LEVEL4_STRATEGY1_NOWRAP = null;
    public static final JreDeflateParameters LEVEL4_STRATEGY1_WRAP = null;
    public static final JreDeflateParameters LEVEL4_STRATEGY2_NOWRAP = null;
    public static final JreDeflateParameters LEVEL4_STRATEGY2_WRAP = null;
    public static final JreDeflateParameters LEVEL5_STRATEGY0_NOWRAP = null;
    public static final JreDeflateParameters LEVEL5_STRATEGY0_WRAP = null;
    public static final JreDeflateParameters LEVEL5_STRATEGY1_NOWRAP = null;
    public static final JreDeflateParameters LEVEL5_STRATEGY1_WRAP = null;
    public static final JreDeflateParameters LEVEL5_STRATEGY2_NOWRAP = null;
    public static final JreDeflateParameters LEVEL5_STRATEGY2_WRAP = null;
    public static final JreDeflateParameters LEVEL6_STRATEGY0_NOWRAP = null;
    public static final JreDeflateParameters LEVEL6_STRATEGY0_WRAP = null;
    public static final JreDeflateParameters LEVEL6_STRATEGY1_NOWRAP = null;
    public static final JreDeflateParameters LEVEL6_STRATEGY1_WRAP = null;
    public static final JreDeflateParameters LEVEL6_STRATEGY2_NOWRAP = null;
    public static final JreDeflateParameters LEVEL6_STRATEGY2_WRAP = null;
    public static final JreDeflateParameters LEVEL7_STRATEGY0_NOWRAP = null;
    public static final JreDeflateParameters LEVEL7_STRATEGY0_WRAP = null;
    public static final JreDeflateParameters LEVEL7_STRATEGY1_NOWRAP = null;
    public static final JreDeflateParameters LEVEL7_STRATEGY1_WRAP = null;
    public static final JreDeflateParameters LEVEL7_STRATEGY2_NOWRAP = null;
    public static final JreDeflateParameters LEVEL7_STRATEGY2_WRAP = null;
    public static final JreDeflateParameters LEVEL8_STRATEGY0_NOWRAP = null;
    public static final JreDeflateParameters LEVEL8_STRATEGY0_WRAP = null;
    public static final JreDeflateParameters LEVEL8_STRATEGY1_NOWRAP = null;
    public static final JreDeflateParameters LEVEL8_STRATEGY1_WRAP = null;
    public static final JreDeflateParameters LEVEL8_STRATEGY2_NOWRAP = null;
    public static final JreDeflateParameters LEVEL8_STRATEGY2_WRAP = null;
    public static final JreDeflateParameters LEVEL9_STRATEGY0_NOWRAP = null;
    public static final JreDeflateParameters LEVEL9_STRATEGY0_WRAP = null;
    public static final JreDeflateParameters LEVEL9_STRATEGY1_NOWRAP = null;
    public static final JreDeflateParameters LEVEL9_STRATEGY1_WRAP = null;
    public static final JreDeflateParameters LEVEL9_STRATEGY2_NOWRAP = null;
    public static final JreDeflateParameters LEVEL9_STRATEGY2_WRAP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JreDeflateParameters[] f274679a = null;
    public final int level;
    public final boolean nowrap;
    public final int strategy;

    static {
        JreDeflateParameters r100 = new JreDeflateParameters("LEVEL1_STRATEGY0_NOWRAP", 0, 1, 0, true);
        LEVEL1_STRATEGY0_NOWRAP = r100;
        JreDeflateParameters r101 = new JreDeflateParameters("LEVEL2_STRATEGY0_NOWRAP", 1, 2, 0, true);
        LEVEL2_STRATEGY0_NOWRAP = r101;
        JreDeflateParameters r102 = new JreDeflateParameters("LEVEL3_STRATEGY0_NOWRAP", 2, 3, 0, true);
        LEVEL3_STRATEGY0_NOWRAP = r102;
        JreDeflateParameters r103 = new JreDeflateParameters("LEVEL4_STRATEGY0_NOWRAP", 3, 4, 0, true);
        LEVEL4_STRATEGY0_NOWRAP = r103;
        JreDeflateParameters r104 = new JreDeflateParameters("LEVEL5_STRATEGY0_NOWRAP", 4, 5, 0, true);
        LEVEL5_STRATEGY0_NOWRAP = r104;
        JreDeflateParameters r105 = new JreDeflateParameters("LEVEL6_STRATEGY0_NOWRAP", 5, 6, 0, true);
        LEVEL6_STRATEGY0_NOWRAP = r105;
        JreDeflateParameters r106 = new JreDeflateParameters("LEVEL7_STRATEGY0_NOWRAP", 6, 7, 0, true);
        LEVEL7_STRATEGY0_NOWRAP = r106;
        JreDeflateParameters r110 = new JreDeflateParameters("LEVEL8_STRATEGY0_NOWRAP", 7, 8, 0, true);
        LEVEL8_STRATEGY0_NOWRAP = r110;
        JreDeflateParameters r107 = new JreDeflateParameters("LEVEL9_STRATEGY0_NOWRAP", 8, 9, 0, true);
        LEVEL9_STRATEGY0_NOWRAP = r107;
        JreDeflateParameters r108 = new JreDeflateParameters("LEVEL1_STRATEGY1_NOWRAP", 9, 1, 1, true);
        LEVEL1_STRATEGY1_NOWRAP = r108;
        JreDeflateParameters r109 = new JreDeflateParameters("LEVEL2_STRATEGY1_NOWRAP", 10, 2, 1, true);
        LEVEL2_STRATEGY1_NOWRAP = r109;
        JreDeflateParameters r111 = new JreDeflateParameters("LEVEL3_STRATEGY1_NOWRAP", 11, 3, 1, true);
        LEVEL3_STRATEGY1_NOWRAP = r111;
        JreDeflateParameters r112 = new JreDeflateParameters("LEVEL4_STRATEGY1_NOWRAP", 12, 4, 1, true);
        LEVEL4_STRATEGY1_NOWRAP = r112;
        JreDeflateParameters r113 = new JreDeflateParameters("LEVEL5_STRATEGY1_NOWRAP", 13, 5, 1, true);
        LEVEL5_STRATEGY1_NOWRAP = r113;
        JreDeflateParameters r210 = new JreDeflateParameters("LEVEL6_STRATEGY1_NOWRAP", 14, 6, 1, true);
        LEVEL6_STRATEGY1_NOWRAP = r210;
        JreDeflateParameters r114 = new JreDeflateParameters("LEVEL7_STRATEGY1_NOWRAP", 15, 7, 1, true);
        LEVEL7_STRATEGY1_NOWRAP = r114;
        JreDeflateParameters r115 = new JreDeflateParameters("LEVEL8_STRATEGY1_NOWRAP", 16, 8, 1, true);
        LEVEL8_STRATEGY1_NOWRAP = r115;
        JreDeflateParameters r116 = new JreDeflateParameters("LEVEL9_STRATEGY1_NOWRAP", 17, 9, 1, true);
        LEVEL9_STRATEGY1_NOWRAP = r116;
        JreDeflateParameters r117 = new JreDeflateParameters("LEVEL1_STRATEGY2_NOWRAP", 18, 1, 2, true);
        LEVEL1_STRATEGY2_NOWRAP = r117;
        JreDeflateParameters r118 = new JreDeflateParameters("LEVEL2_STRATEGY2_NOWRAP", 19, 2, 2, true);
        LEVEL2_STRATEGY2_NOWRAP = r118;
        JreDeflateParameters r119 = new JreDeflateParameters("LEVEL3_STRATEGY2_NOWRAP", 20, 3, 2, true);
        LEVEL3_STRATEGY2_NOWRAP = r119;
        JreDeflateParameters r211 = new JreDeflateParameters("LEVEL4_STRATEGY2_NOWRAP", 21, 4, 2, true);
        LEVEL4_STRATEGY2_NOWRAP = r211;
        JreDeflateParameters r212 = new JreDeflateParameters("LEVEL5_STRATEGY2_NOWRAP", 22, 5, 2, true);
        LEVEL5_STRATEGY2_NOWRAP = r212;
        JreDeflateParameters r213 = new JreDeflateParameters("LEVEL6_STRATEGY2_NOWRAP", 23, 6, 2, true);
        LEVEL6_STRATEGY2_NOWRAP = r213;
        JreDeflateParameters r214 = new JreDeflateParameters("LEVEL7_STRATEGY2_NOWRAP", 24, 7, 2, true);
        LEVEL7_STRATEGY2_NOWRAP = r214;
        JreDeflateParameters r215 = new JreDeflateParameters("LEVEL8_STRATEGY2_NOWRAP", 25, 8, 2, true);
        LEVEL8_STRATEGY2_NOWRAP = r215;
        JreDeflateParameters r216 = new JreDeflateParameters("LEVEL9_STRATEGY2_NOWRAP", 26, 9, 2, true);
        LEVEL9_STRATEGY2_NOWRAP = r216;
        JreDeflateParameters r217 = new JreDeflateParameters("LEVEL1_STRATEGY0_WRAP", 27, 1, 0, false);
        LEVEL1_STRATEGY0_WRAP = r217;
        JreDeflateParameters r310 = new JreDeflateParameters("LEVEL2_STRATEGY0_WRAP", 28, 2, 0, false);
        LEVEL2_STRATEGY0_WRAP = r310;
        JreDeflateParameters r218 = new JreDeflateParameters("LEVEL3_STRATEGY0_WRAP", 29, 3, 0, false);
        LEVEL3_STRATEGY0_WRAP = r218;
        JreDeflateParameters r219 = new JreDeflateParameters("LEVEL4_STRATEGY0_WRAP", 30, 4, 0, false);
        LEVEL4_STRATEGY0_WRAP = r219;
        JreDeflateParameters r311 = new JreDeflateParameters("LEVEL5_STRATEGY0_WRAP", 31, 5, 0, false);
        LEVEL5_STRATEGY0_WRAP = r311;
        JreDeflateParameters r312 = new JreDeflateParameters("LEVEL6_STRATEGY0_WRAP", 32, 6, 0, false);
        LEVEL6_STRATEGY0_WRAP = r312;
        JreDeflateParameters r313 = new JreDeflateParameters("LEVEL7_STRATEGY0_WRAP", 33, 7, 0, false);
        LEVEL7_STRATEGY0_WRAP = r313;
        JreDeflateParameters r314 = new JreDeflateParameters("LEVEL8_STRATEGY0_WRAP", 34, 8, 0, false);
        LEVEL8_STRATEGY0_WRAP = r314;
        JreDeflateParameters r410 = new JreDeflateParameters("LEVEL9_STRATEGY0_WRAP", 35, 9, 0, false);
        LEVEL9_STRATEGY0_WRAP = r410;
        JreDeflateParameters r315 = new JreDeflateParameters("LEVEL1_STRATEGY1_WRAP", 36, 1, 1, false);
        LEVEL1_STRATEGY1_WRAP = r315;
        JreDeflateParameters r316 = new JreDeflateParameters("LEVEL2_STRATEGY1_WRAP", 37, 2, 1, false);
        LEVEL2_STRATEGY1_WRAP = r316;
        JreDeflateParameters r317 = new JreDeflateParameters("LEVEL3_STRATEGY1_WRAP", 38, 3, 1, false);
        LEVEL3_STRATEGY1_WRAP = r317;
        JreDeflateParameters r318 = new JreDeflateParameters("LEVEL4_STRATEGY1_WRAP", 39, 4, 1, false);
        LEVEL4_STRATEGY1_WRAP = r318;
        JreDeflateParameters r319 = new JreDeflateParameters("LEVEL5_STRATEGY1_WRAP", 40, 5, 1, false);
        LEVEL5_STRATEGY1_WRAP = r319;
        JreDeflateParameters r411 = new JreDeflateParameters("LEVEL6_STRATEGY1_WRAP", 41, 6, 1, false);
        LEVEL6_STRATEGY1_WRAP = r411;
        JreDeflateParameters r412 = new JreDeflateParameters("LEVEL7_STRATEGY1_WRAP", 42, 7, 1, false);
        LEVEL7_STRATEGY1_WRAP = r412;
        JreDeflateParameters r413 = new JreDeflateParameters("LEVEL8_STRATEGY1_WRAP", 43, 8, 1, false);
        LEVEL8_STRATEGY1_WRAP = r413;
        JreDeflateParameters r414 = new JreDeflateParameters("LEVEL9_STRATEGY1_WRAP", 44, 9, 1, false);
        LEVEL9_STRATEGY1_WRAP = r414;
        JreDeflateParameters r415 = new JreDeflateParameters("LEVEL1_STRATEGY2_WRAP", 45, 1, 2, false);
        LEVEL1_STRATEGY2_WRAP = r415;
        JreDeflateParameters r416 = new JreDeflateParameters("LEVEL2_STRATEGY2_WRAP", 46, 2, 2, false);
        LEVEL2_STRATEGY2_WRAP = r416;
        JreDeflateParameters r417 = new JreDeflateParameters("LEVEL3_STRATEGY2_WRAP", 47, 3, 2, false);
        LEVEL3_STRATEGY2_WRAP = r417;
        JreDeflateParameters r418 = new JreDeflateParameters("LEVEL4_STRATEGY2_WRAP", 48, 4, 2, false);
        LEVEL4_STRATEGY2_WRAP = r418;
        JreDeflateParameters r510 = new JreDeflateParameters("LEVEL5_STRATEGY2_WRAP", 49, 5, 2, false);
        LEVEL5_STRATEGY2_WRAP = r510;
        JreDeflateParameters r419 = new JreDeflateParameters("LEVEL6_STRATEGY2_WRAP", 50, 6, 2, false);
        LEVEL6_STRATEGY2_WRAP = r419;
        JreDeflateParameters r511 = new JreDeflateParameters("LEVEL7_STRATEGY2_WRAP", 51, 7, 2, false);
        LEVEL7_STRATEGY2_WRAP = r511;
        JreDeflateParameters r512 = new JreDeflateParameters("LEVEL8_STRATEGY2_WRAP", 52, 8, 2, false);
        LEVEL8_STRATEGY2_WRAP = r512;
        JreDeflateParameters r513 = new JreDeflateParameters("LEVEL9_STRATEGY2_WRAP", 53, 9, 2, false);
        LEVEL9_STRATEGY2_WRAP = r513;
        f274679a = new JreDeflateParameters[]{r100, r101, r102, r103, r104, r105, r106, r110, r107, r108, r109, r111, r112, r113, r210, r114, r115, r116, r117, r118, r119, r211, r212, r213, r214, r215, r216, r217, r310, r218, r219, r311, r312, r313, r314, r410, r315, r316, r317, r318, r319, r411, r412, r413, r414, r415, r416, r417, r418, r510, r419, r511, r512, r513};
    }

    public static JreDeflateParameters[] values() {
        return (JreDeflateParameters[]) f274679a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "level=" + this.level + ",strategy=" + this.strategy + ",nowrap=" + this.nowrap;
    }

    public static JreDeflateParameters parseString(String r100) {
        String[] r101 = r100.split(",");
        return of(CastIntegerProtector.parseInt(r101[0].split(ContainerUtils.KEY_VALUE_DELIMITER)[1]), CastIntegerProtector.parseInt(r101[1].split(ContainerUtils.KEY_VALUE_DELIMITER)[1]), Boolean.parseBoolean(r101[2].split(ContainerUtils.KEY_VALUE_DELIMITER)[1]));
    }

    public static JreDeflateParameters valueOf(String r100) {
        return (JreDeflateParameters) r27.a.a(JreDeflateParameters.class, r100);
    }

    public static JreDeflateParameters of(int r100, int r101, boolean r102) {
        switch((((r100 * 100) + (r101 * 10)) + (r102 ? 1 : 0))) {
            case 100: goto L113;
            case 101: goto L111;
            case 110: goto L109;
            case 111: goto L107;
            case 120: goto L105;
            case 121: goto L103;
            case 200: goto L101;
            case 201: goto L99;
            case 210: goto L97;
            case 211: goto L95;
            case 220: goto L93;
            case 221: goto L91;
            case 300: goto L89;
            case 301: goto L87;
            case 310: goto L85;
            case 311: goto L83;
            case 320: goto L81;
            case 321: goto L79;
            case 400: goto L77;
            case 401: goto L75;
            case 410: goto L73;
            case 411: goto L71;
            case 420: goto L69;
            case 421: goto L67;
            case 500: goto L65;
            case 501: goto L63;
            case 510: goto L61;
            case 511: goto L59;
            case 520: goto L57;
            case 521: goto L55;
            case 600: goto L53;
            case 601: goto L51;
            case 610: goto L49;
            case 611: goto L47;
            case 620: goto L45;
            case 621: goto L43;
            case 700: goto L41;
            case 701: goto L39;
            case 710: goto L37;
            case 711: goto L35;
            case 720: goto L33;
            case 721: goto L31;
            case 800: goto L29;
            case 801: goto L27;
            case 810: goto L25;
            case 811: goto L23;
            case 820: goto L21;
            case 821: goto L19;
            case 900: goto L17;
            case 901: goto L15;
            case 910: goto L13;
            case 911: goto L11;
            case 920: goto L9;
            case 921: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalArgumentException("No such parameters");
    L7:
        return LEVEL9_STRATEGY2_NOWRAP;
    L9:
        return LEVEL9_STRATEGY2_WRAP;
    L11:
        return LEVEL9_STRATEGY1_NOWRAP;
    L13:
        return LEVEL9_STRATEGY1_WRAP;
    L15:
        return LEVEL9_STRATEGY0_NOWRAP;
    L17:
        return LEVEL9_STRATEGY0_WRAP;
    L19:
        return LEVEL8_STRATEGY2_NOWRAP;
    L21:
        return LEVEL8_STRATEGY2_WRAP;
    L23:
        return LEVEL8_STRATEGY1_NOWRAP;
    L25:
        return LEVEL8_STRATEGY1_WRAP;
    L27:
        return LEVEL8_STRATEGY0_NOWRAP;
    L29:
        return LEVEL8_STRATEGY0_WRAP;
    L31:
        return LEVEL7_STRATEGY2_NOWRAP;
    L33:
        return LEVEL7_STRATEGY2_WRAP;
    L35:
        return LEVEL7_STRATEGY1_NOWRAP;
    L37:
        return LEVEL7_STRATEGY1_WRAP;
    L39:
        return LEVEL7_STRATEGY0_NOWRAP;
    L41:
        return LEVEL7_STRATEGY0_WRAP;
    L43:
        return LEVEL6_STRATEGY2_NOWRAP;
    L45:
        return LEVEL6_STRATEGY2_WRAP;
    L47:
        return LEVEL6_STRATEGY1_NOWRAP;
    L49:
        return LEVEL6_STRATEGY1_WRAP;
    L51:
        return LEVEL6_STRATEGY0_NOWRAP;
    L53:
        return LEVEL6_STRATEGY0_WRAP;
    L55:
        return LEVEL5_STRATEGY2_NOWRAP;
    L57:
        return LEVEL5_STRATEGY2_WRAP;
    L59:
        return LEVEL5_STRATEGY1_NOWRAP;
    L61:
        return LEVEL5_STRATEGY1_WRAP;
    L63:
        return LEVEL5_STRATEGY0_NOWRAP;
    L65:
        return LEVEL5_STRATEGY0_WRAP;
    L67:
        return LEVEL4_STRATEGY2_NOWRAP;
    L69:
        return LEVEL4_STRATEGY2_WRAP;
    L71:
        return LEVEL4_STRATEGY1_NOWRAP;
    L73:
        return LEVEL4_STRATEGY1_WRAP;
    L75:
        return LEVEL4_STRATEGY0_NOWRAP;
    L77:
        return LEVEL4_STRATEGY0_WRAP;
    L79:
        return LEVEL3_STRATEGY2_NOWRAP;
    L81:
        return LEVEL3_STRATEGY2_WRAP;
    L83:
        return LEVEL3_STRATEGY1_NOWRAP;
    L85:
        return LEVEL3_STRATEGY1_WRAP;
    L87:
        return LEVEL3_STRATEGY0_NOWRAP;
    L89:
        return LEVEL3_STRATEGY0_WRAP;
    L91:
        return LEVEL2_STRATEGY2_NOWRAP;
    L93:
        return LEVEL2_STRATEGY2_WRAP;
    L95:
        return LEVEL2_STRATEGY1_NOWRAP;
    L97:
        return LEVEL2_STRATEGY1_WRAP;
    L99:
        return LEVEL2_STRATEGY0_NOWRAP;
    L101:
        return LEVEL2_STRATEGY0_WRAP;
    L103:
        return LEVEL1_STRATEGY2_NOWRAP;
    L105:
        return LEVEL1_STRATEGY2_WRAP;
    L107:
        return LEVEL1_STRATEGY1_NOWRAP;
    L109:
        return LEVEL1_STRATEGY1_WRAP;
    L111:
        return LEVEL1_STRATEGY0_NOWRAP;
    L113:
        return LEVEL1_STRATEGY0_WRAP;
    }

    public JreDeflateParameters(String r100, int r101, int r102, int r103, boolean r104) {
        super(r100, r101);
        if (r102 < 1) goto L12;
        if (r102 > 9) goto L12;
        if (r103 < 0) goto L12;
        if (r103 > 2) goto L12;
        this.level = r102;
        this.strategy = r103;
        this.nowrap = r104;
        return;
    L12:
        throw new IllegalArgumentException("Only levels 1-9 and strategies 0-2 are valid.");
    }
}
