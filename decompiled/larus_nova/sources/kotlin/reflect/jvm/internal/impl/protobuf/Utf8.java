package kotlin.reflect.jvm.internal.impl.protobuf;

/* JADX INFO: loaded from: classes5.dex */
final class Utf8 {
    private static int incompleteStateFor(int r100) {
        if (r100 <= (-12)) goto L6;
        return -1;
    L6:
        return r100;
    }

    private static int incompleteStateFor(int r100, int r101) {
        if (r100 <= (-12)) goto L5;
    L8:
        return -1;
    L5:
        if (r101 > (-65)) goto L8;
        return r100 ^ (r101 << 8);
    }

    private static int incompleteStateFor(int r100, int r101, int r102) {
        if (r100 <= (-12)) goto L5;
    L9:
        return -1;
    L5:
        if (r101 > (-65)) goto L9;
        if (r102 > (-65)) goto L9;
        return (r100 ^ (r101 << 8)) ^ (r102 << 16);
    }

    public static boolean isValidUtf8(byte[] r100) {
        return isValidUtf8(r100, 0, r100.length);
    }

    private static int incompleteStateFor(byte[] r100, int r101, int r102) {
        byte r103 = r100[r101 - 1];
        int r104 = r102 - r101;
        if (r104 == 0) goto L15;
        if (r104 == 1) goto L13;
        if (r104 != 2) goto L11;
        return incompleteStateFor(r103, r100[r101], r100[r101 + 1]);
    L11:
        throw new AssertionError();
    L13:
        return incompleteStateFor(r103, r100[r101]);
    L15:
        return incompleteStateFor(r103);
    }

    public static boolean isValidUtf8(byte[] r100, int r101, int r102) {
        if (partialIsValidUtf8(r100, r101, r102) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int partialIsValidUtf8(byte[] r100, int r101, int r102) {
    L2:
        if (r101 >= r102) goto L6;
        if (r100[r101] < 0) goto L6;
        r101 = r101 + 1;
    L6:
        if (r101 < r102) goto L9;
        return 0;
    L9:
        return partialIsValidUtf8NonAscii(r100, r101, r102);
    }

    private static int partialIsValidUtf8NonAscii(byte[] r100, int r101, int r102) {
    L2:
        if (r101 >= r102) goto L3;
        int r103 = r101 + 1;
        byte r104 = r100[r101];
        if (r104 >= 0) goto L46;
        if (r104 < (-32)) goto L9;
        if (r104 < (-16)) goto L19;
        if (r103 >= (r102 - 2)) goto L36;
        int r105 = r103 + 1;
        byte r106 = r100[r103];
        if (r106 > (-65)) goto L45;
        if ((((r104 << 28) + (r106 + 112)) >> 30) != 0) goto L45;
        int r107 = r105 + 1;
        if (r100[r105] > (-65)) goto L45;
        r103 = r107 + 1;
        if (r100[r107] <= (-65)) goto L46;
    L45:
        return -1;
    L36:
        return incompleteStateFor(r100, r103, r102);
    L19:
        if (r103 >= (r102 - 1)) goto L21;
        int r108 = r103 + 1;
        byte r109 = r100[r103];
        if (r109 > (-65)) goto L32;
        if (r104 != (-32)) goto L28;
        if (r109 < (-96)) goto L32;
    L28:
        if (r104 != (-19)) goto L30;
        if (r109 >= (-96)) goto L32;
    L30:
        r101 = r108 + 1;
        if (r100[r108] <= (-65)) goto L2;
    L32:
        return -1;
    L21:
        return incompleteStateFor(r100, r103, r102);
    L9:
        if (r103 >= r102) goto L10;
        if (r104 < (-62)) goto L15;
        r101 = r103 + 1;
        if (r100[r103] <= (-65)) goto L2;
    L15:
        return -1;
    L10:
        return r104;
    L46:
        r101 = r103;
        goto L2
    L3:
        return 0;
    }

    public static int partialIsValidUtf8(int r100, byte[] r101, int r102, int r103) {
        if (r100 == 0) goto L55;
        if (r102 < r103) goto L5;
        return r100;
    L5:
        byte r104 = (byte) r100;
        if (r104 >= (-32)) goto L15;
        if (r104 < (-62)) goto L13;
        int r105 = r102 + 1;
        if (r101[r102] > (-65)) goto L13;
    L12:
        r102 = r105;
    L13:
        return -1;
    L15:
        if (r104 >= (-16)) goto L33;
        byte r106 = (byte) (~(r100 >> 8));
        if (r106 != 0) goto L23;
        int r107 = r102 + 1;
        byte r108 = r101[r102];
        if (r107 >= r103) goto L21;
        r102 = r107;
        r106 = r108;
        goto L23
    L21:
        return incompleteStateFor(r104, r108);
    L23:
        if (r106 <= (-65)) goto L25;
    L32:
        return -1;
    L25:
        if (r104 != (-32)) goto L28;
        if (r106 < (-96)) goto L32;
    L28:
        if (r104 != (-19)) goto L30;
        if (r106 >= (-96)) goto L32;
    L30:
        r105 = r102 + 1;
        if (r101[r102] <= (-65)) goto L12;
    L33:
        byte r109 = (byte) (~(r100 >> 8));
        if (r109 != 0) goto L40;
        int r110 = r102 + 1;
        r109 = r101[r102];
        if (r110 >= r103) goto L38;
        byte r111 = 0;
    L41:
        if (r111 != 0) goto L47;
        int r112 = r110 + 1;
        byte r113 = r101[r110];
        if (r112 >= r103) goto L45;
        r111 = r113;
        r110 = r112;
        goto L47
    L45:
        return incompleteStateFor(r104, r109, r113);
    L47:
        if (r109 <= (-65)) goto L49;
    L53:
        return -1;
    L49:
        if ((((r104 << 28) + (r109 + 112)) >> 30) != 0) goto L53;
        if (r111 > (-65)) goto L53;
        r102 = r110 + 1;
        if (r101[r110] <= (-65)) goto L55;
    L38:
        return incompleteStateFor(r104, r109);
    L40:
        r111 = (byte) (r100 >> 16);
        r110 = r102;
    L55:
        return partialIsValidUtf8(r101, r102, r103);
    }
}
