package com.ss.bytertc.audio.device.base;

import android.os.Build;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class ManufacturerChecker {
    private static final String hrType = "ronoh";
    private static final String hwType = "iewauh";
    private static final String oneType = "sulpeno";
    private static final String realType = "emlaer";
    private static final String rmType = "imder";
    private static Type typeResult = null;
    private static final String voType = "oviv";
    private static final String xmType = "imoaix";

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type HR = null;
        public static final Type HW = null;
        public static final Type OP = null;
        public static final Type RM = null;
        public static final Type UNKNOWN = null;
        public static final Type VO = null;
        public static final Type XM = null;

        static {
            Type r100 = new Type("UNKNOWN", 0);
            UNKNOWN = r100;
            Type r101 = new Type("XM", 1);
            XM = r101;
            Type r102 = new Type("RM", 2);
            RM = r102;
            Type r103 = new Type("HW", 3);
            HW = r103;
            Type r104 = new Type("HR", 4);
            HR = r104;
            Type r105 = new Type("VO", 5);
            VO = r105;
            Type r110 = new Type("OP", 6);
            OP = r110;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public ManufacturerChecker() {
    }

    public static Type getManufacturerType() {
        return getManufacturerType(Build.BRAND);
    }

    public static Type getManufacturerType(String r100) {
        Type r101 = typeResult;
        if (r101 == null) goto L5;
        return r101;
    L5:
        if (r100 == null) goto L40;
        if (r100.isEmpty() == true) goto L40;
        String r102 = new StringBuilder(r100).reverse().toString().toLowerCase();
        if (r102.equalsIgnoreCase(xmType) == false) goto L13;
        typeResult = Type.XM;
    L38:
        return typeResult;
    L13:
        if (r102.equalsIgnoreCase(rmType) == false) goto L16;
        typeResult = Type.RM;
        goto L38
    L16:
        if (r102.equalsIgnoreCase(hwType) == false) goto L19;
        typeResult = Type.HW;
        goto L38
    L19:
        if (r102.equalsIgnoreCase(hrType) == false) goto L22;
        typeResult = Type.HR;
        goto L38
    L22:
        if (r102.equalsIgnoreCase(voType) == false) goto L25;
        typeResult = Type.VO;
        goto L38
    L25:
        if (r102.length() != 4) goto L31;
        if (r102.startsWith("op") == false) goto L31;
        if (r102.endsWith("po") == false) goto L31;
    L36:
        typeResult = Type.OP;
    L31:
        if (r102.equalsIgnoreCase(oneType) == true) goto L36;
        if (r102.equalsIgnoreCase(realType) == true) goto L36;
        typeResult = Type.UNKNOWN;
    L40:
        return Type.UNKNOWN;
    }
}
