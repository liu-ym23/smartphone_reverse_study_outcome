package org.apache.commons.lang3;

import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.miui.easygo.constant.EasyGoConstant;
import com.tencent.connect.common.Constants;
import org.apache.commons.lang3.math.NumberUtils;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum JavaVersion extends Enum<JavaVersion> {
    private static final /* synthetic */ JavaVersion[] $VALUES = null;
    public static final JavaVersion JAVA_0_9 = null;
    public static final JavaVersion JAVA_10 = null;
    public static final JavaVersion JAVA_11 = null;
    public static final JavaVersion JAVA_1_1 = null;
    public static final JavaVersion JAVA_1_2 = null;
    public static final JavaVersion JAVA_1_3 = null;
    public static final JavaVersion JAVA_1_4 = null;
    public static final JavaVersion JAVA_1_5 = null;
    public static final JavaVersion JAVA_1_6 = null;
    public static final JavaVersion JAVA_1_7 = null;
    public static final JavaVersion JAVA_1_8 = null;
    public static final JavaVersion JAVA_1_9 = null;
    public static final JavaVersion JAVA_9 = null;
    public static final JavaVersion JAVA_RECENT = null;
    private final String name;
    private final float value;

    static {
        JavaVersion r100 = new JavaVersion("JAVA_0_9", 0, 1.5f, "0.9");
        JAVA_0_9 = r100;
        JavaVersion r101 = new JavaVersion("JAVA_1_1", 1, 1.1f, "1.1");
        JAVA_1_1 = r101;
        JavaVersion r102 = new JavaVersion("JAVA_1_2", 2, 1.2f, "1.2");
        JAVA_1_2 = r102;
        JavaVersion r103 = new JavaVersion("JAVA_1_3", 3, 1.3f, "1.3");
        JAVA_1_3 = r103;
        JavaVersion r104 = new JavaVersion("JAVA_1_4", 4, 1.4f, "1.4");
        JAVA_1_4 = r104;
        JavaVersion r105 = new JavaVersion("JAVA_1_5", 5, 1.5f, "1.5");
        JAVA_1_5 = r105;
        JavaVersion r106 = new JavaVersion("JAVA_1_6", 6, 1.6f, "1.6");
        JAVA_1_6 = r106;
        JavaVersion r110 = new JavaVersion("JAVA_1_7", 7, 1.7f, "1.7");
        JAVA_1_7 = r110;
        JavaVersion r111 = new JavaVersion("JAVA_1_8", 8, 1.8f, "1.8");
        JAVA_1_8 = r111;
        JavaVersion r112 = new JavaVersion("JAVA_1_9", 9, 9.0f, Constants.VIA_SHARE_TYPE_MINI_PROGRAM);
        JAVA_1_9 = r112;
        JavaVersion r113 = new JavaVersion("JAVA_9", 10, 9.0f, Constants.VIA_SHARE_TYPE_MINI_PROGRAM);
        JAVA_9 = r113;
        JavaVersion r107 = new JavaVersion("JAVA_10", 11, 10.0f, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        JAVA_10 = r107;
        JavaVersion r108 = new JavaVersion("JAVA_11", 12, 11.0f, "11");
        JAVA_11 = r108;
        JavaVersion r109 = new JavaVersion("JAVA_RECENT", 13, maxVersion(), Float.toString(maxVersion()));
        JAVA_RECENT = r109;
        $VALUES = new JavaVersion[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r107, r108, r109};
    }

    private static float maxVersion() {
        float r100 = toFloatVersion(System.getProperty("java.specification.version", "99.0"));
        if (r100 <= 0.0f) goto L5;
        return r100;
    L5:
        return 99.0f;
    }

    public static JavaVersion[] values() {
        return (JavaVersion[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }

    public static JavaVersion get(String r100) {
        if ("0.9".equals(r100) == false) goto L7;
        return JAVA_0_9;
    L7:
        if ("1.1".equals(r100) == false) goto L11;
        return JAVA_1_1;
    L11:
        if ("1.2".equals(r100) == false) goto L15;
        return JAVA_1_2;
    L15:
        if ("1.3".equals(r100) == false) goto L19;
        return JAVA_1_3;
    L19:
        if ("1.4".equals(r100) == false) goto L23;
        return JAVA_1_4;
    L23:
        if ("1.5".equals(r100) == false) goto L27;
        return JAVA_1_5;
    L27:
        if ("1.6".equals(r100) == false) goto L31;
        return JAVA_1_6;
    L31:
        if ("1.7".equals(r100) == false) goto L35;
        return JAVA_1_7;
    L35:
        if ("1.8".equals(r100) == false) goto L39;
        return JAVA_1_8;
    L39:
        if (Constants.VIA_SHARE_TYPE_MINI_PROGRAM.equals(r100) == false) goto L43;
        return JAVA_9;
    L43:
        if (Constants.VIA_REPORT_TYPE_SHARE_TO_QQ.equals(r100) == false) goto L47;
        return JAVA_10;
    L47:
        if ("11".equals(r100) == false) goto L51;
        return JAVA_11;
    L51:
        if (r100 != null) goto L53;
        return null;
    L53:
        float r101 = toFloatVersion(r100);
        if ((((double) r101) - 1.0d) >= 1.0d) goto L60;
        int r102 = Math.max(r100.indexOf(46), r100.indexOf(44));
        int r103 = Math.max(r100.length(), r100.indexOf(44, r102));
        if (CastFloatProtector.parseFloat(r100.substring(r102 + 1, r103)) > 0.9f) goto L58;
    L63:
        return null;
    L58:
        return JAVA_RECENT;
    L60:
        if (r101 <= 10.0f) goto L63;
        return JAVA_RECENT;
    }

    public static JavaVersion getJavaVersion(String r100) {
        return get(r100);
    }

    private static float toFloatVersion(String r100) {
        if (r100.contains(".") == false) goto L10;
        String[] r101 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r101.length >= 2) goto L7;
        return -1.0f;
    L7:
        return NumberUtils.toFloat(r101[0] + '.' + r101[1], -1.0f);
    L10:
        return NumberUtils.toFloat(r100, -1.0f);
    }

    public static JavaVersion valueOf(String r100) {
        return (JavaVersion) a.a(JavaVersion.class, r100);
    }

    public boolean atLeast(JavaVersion r100) {
        if (this.value < r100.value) goto L5;
        return true;
    L5:
        return false;
    }

    private JavaVersion(String r100, int r101, float r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.name = r103;
    }
}
