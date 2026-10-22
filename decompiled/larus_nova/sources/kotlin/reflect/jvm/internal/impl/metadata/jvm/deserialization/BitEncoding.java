package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.UByte;

/* JADX INFO: loaded from: classes5.dex */
public class BitEncoding {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean FORCE_8TO7_ENCODING = false;

    private static /* synthetic */ void $$$reportNull$$$0(int r110) {
        if (r110 == 1) goto L11;
        if (r110 == 3) goto L11;
        if (r110 == 6) goto L11;
        if (r110 == 8) goto L11;
        if (r110 == 10) goto L11;
        if (r110 == 12) goto L11;
        if (r110 == 14) goto L11;
        String r100 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L13:
        if (r110 == 1) goto L21;
        if (r110 == 3) goto L21;
        if (r110 == 6) goto L21;
        if (r110 == 8) goto L21;
        if (r110 == 10) goto L21;
        if (r110 == 12) goto L21;
        if (r110 == 14) goto L21;
        int r111 = 3;
    L22:
        Object[] r112 = new Object[r111];
        if (r110 == 1) goto L31;
        if (r110 == 3) goto L31;
        if (r110 == 6) goto L31;
        if (r110 == 8) goto L31;
        if (r110 == 10) goto L31;
        if (r110 == 12) goto L31;
        if (r110 == 14) goto L31;
        r112[0] = "data";
    L33:
        if (r110 == 1) goto L47;
        if (r110 == 3) goto L46;
        if (r110 == 6) goto L45;
        if (r110 == 8) goto L44;
        if (r110 == 10) goto L43;
        if (r110 == 12) goto L42;
        if (r110 == 14) goto L41;
        r112[1] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
    L48:
        switch(r110) {
            case 1: goto L57;
            case 2: goto L56;
            case 3: goto L57;
            case 4: goto L55;
            case 5: goto L54;
            case 6: goto L57;
            case 7: goto L53;
            case 8: goto L57;
            case 9: goto L52;
            case 10: goto L57;
            case 11: goto L51;
            case 12: goto L57;
            case 13: goto L50;
            case 14: goto L57;
            default: goto L49;
        };
    L49:
        r112[2] = "encodeBytes";
        goto L57
    L50:
        r112[2] = "decode7to8";
        goto L57
    L51:
        r112[2] = "combineStringArrayIntoBytes";
        goto L57
    L52:
        r112[2] = "dropMarker";
        goto L57
    L53:
        r112[2] = "decodeBytes";
        goto L57
    L54:
        r112[2] = "splitBytesToStringArray";
        goto L57
    L55:
        r112[2] = "addModuloByte";
        goto L57
    L56:
        r112[2] = "encode8to7";
    L57:
        String r101 = String.format(r100, r112);
        if (r110 == 1) goto L67;
        if (r110 == 3) goto L67;
        if (r110 == 6) goto L67;
        if (r110 == 8) goto L67;
        if (r110 == 10) goto L67;
        if (r110 == 12) goto L67;
        if (r110 == 14) goto L67;
        throw new IllegalArgumentException(r101);
    L67:
        throw new IllegalStateException(r101);
    L41:
        r112[1] = "decode7to8";
        goto L48
    L42:
        r112[1] = "combineStringArrayIntoBytes";
        goto L48
    L43:
        r112[1] = "dropMarker";
        goto L48
    L44:
        r112[1] = "decodeBytes";
        goto L48
    L45:
        r112[1] = "splitBytesToStringArray";
        goto L48
    L46:
        r112[1] = "encode8to7";
        goto L48
    L47:
        r112[1] = "encodeBytes";
    L31:
        r112[0] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
    L21:
        r111 = 2;
    L11:
        r100 = "@NotNull method %s.%s must not return null";
        goto L13
    }

    static {
        String r100 = System.getProperty("kotlin.jvm.serialization.use8to7");     // Catch: SecurityException -> L5
    L6:
        FORCE_8TO7_ENCODING = "true".equals(r100);
        return;
    L5:
        r100 = null;
        goto L6
    }

    private BitEncoding() {
    }

    private static byte[] combineStringArrayIntoBytes(String[] r110) {
        if (r110 != null) goto L4;
        $$$reportNull$$$0(11);
    L4:
        int r100 = r110.length;
        int r101 = 0;
        int r102 = 0;
    L5:
        if (r101 >= r100) goto L7;
        r102 = r102 + r110[r101].length();
        r101 = r101 + 1;
        goto L5
    L7:
        byte[] r103 = new byte[r102];
        int r104 = r110.length;
        int r105 = 0;
        int r106 = 0;
    L8:
        if (r105 >= r104) goto L13;
        String r107 = r110[r105];
        int r108 = r107.length();
        int r109 = 0;
    L10:
        if (r109 >= r108) goto L12;
        r103[r106] = (byte) r107.charAt(r109);
        r109 = r109 + 1;
        r106 = r106 + 1;
        goto L10
    L12:
        r105 = r105 + 1;
        goto L8
    L13:
        return r103;
    }

    private static byte[] decode7to8(byte[] r110) {
        if (r110 != null) goto L4;
        $$$reportNull$$$0(13);
    L4:
        int r100 = (r110.length * 7) / 8;
        byte[] r101 = new byte[r100];
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L5:
        if (r102 >= r100) goto L11;
        int r105 = (r110[r103] & UByte.MAX_VALUE) >>> r104;
        r103 = r103 + 1;
        int r106 = r104 + 1;
        r101[r102] = (byte) (r105 + ((r110[r103] & ((1 << r106) - 1)) << (7 - r104)));
        if (r104 != 6) goto L9;
        r103 = r103 + 1;
        r104 = 0;
    L10:
        r102 = r102 + 1;
        goto L5
    L9:
        r104 = r106;
        goto L10
    L11:
        return r101;
    }

    public static byte[] decodeBytes(String[] r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        if (r100.length > 0) goto L7;
    L17:
        byte[] r101 = combineStringArrayIntoBytes(r100);
        addModuloByte(r101, 127);
        return decode7to8(r101);
    L7:
        if (r100[0].isEmpty() == true) goto L17;
        char r102 = r100[0].charAt(0);
        if (r102 != 0) goto L15;
        byte[] r103 = UtfEncodingKt.stringsToBytes(dropMarker(r100));
        if (r103 != null) goto L13;
        $$$reportNull$$$0(8);
    L13:
        return r103;
    L15:
        if (r102 != 65535) goto L17;
        r100 = dropMarker(r100);
        goto L17
    }

    private static String[] dropMarker(String[] r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(9);
    L4:
        String[] r101 = (String[]) r100.clone();
        r101[0] = r101[0].substring(1);
        return r101;
    }

    private static void addModuloByte(byte[] r100, int r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        int r102 = r100.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L7;
        r100[r103] = (byte) ((r100[r103] + r101) & 127);
        r103 = r103 + 1;
        goto L5
    }
}
