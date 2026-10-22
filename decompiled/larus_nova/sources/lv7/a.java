package lv7;

import java.nio.charset.Charset;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f510964a = null;

    /* JADX INFO: renamed from: lv7.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC6739a {
    }

    public static class b extends AbstractC6739a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int[] f510965a = null;

        static {
            f510965a = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        }
    }

    public a() {
    }

    static {
        f510964a = Charset.forName("UTF-8");
    }

    public static byte[] a(String r110) {
        byte[] r111 = r110.getBytes(f510964a);
        int r100 = r111.length;
        int r101 = (r100 * 3) / 4;
        byte[] r102 = new byte[r101];
        int[] r103 = b.f510965a;
        int r104 = r100 + 0;
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
        int r108 = 0;
    L3:
        boolean r112 = true;
        if (r105 >= r104) goto L50;
        if (r106 != 0) goto L13;
    L6:
        int r113 = r105 + 4;
        if (r113 > r104) goto L11;
        r107 = (((r103[r111[r105] & UByte.MAX_VALUE] << 18) | (r103[r111[r105 + 1] & UByte.MAX_VALUE] << 12)) | (r103[r111[r105 + 2] & UByte.MAX_VALUE] << 6)) | r103[r111[r105 + 3] & UByte.MAX_VALUE];
        if (r107 < 0) goto L11;
        r102[r108 + 2] = (byte) r107;
        r102[r108 + 1] = (byte) (r107 >> 8);
        r102[r108] = (byte) (r107 >> 16);
        r108 = r108 + 3;
        r105 = r113;
    L11:
        if (r105 >= r104) goto L50;
    L13:
        int r114 = r105 + 1;
        int r109 = r103[r111[r105] & UByte.MAX_VALUE];
        if (r106 == 0) goto L45;
        if (r106 != 1) goto L17;
        if (r109 < 0) goto L43;
    L42:
        r109 = r109 | (r107 << 6);
    L46:
        r106 = r106 + 1;
        r107 = r109;
    L49:
        r105 = r114;
        goto L3
    L43:
        if (r109 == (-1)) goto L49;
    L57:
        r108 = 0;
        r112 = false;
    L58:
        if (r112 == false) goto L64;
        if (r108 == r101) goto L87;
        byte[] r115 = new byte[r108];
        System.arraycopy(r102, 0, r115, 0, r108);
        return r115;
    L87:
        return r102;
    L64:
        throw new IllegalArgumentException("bad base-64");
    L17:
        if (r106 != 2) goto L19;
        if (r109 >= 0) goto L42;
        if (r109 != (-2)) goto L39;
        r102[r108] = (byte) (r107 >> 4);
        r108 = r108 + 1;
        r106 = 4;
        goto L49
    L39:
        if (r109 == (-1)) goto L49;
    L19:
        if (r106 == 3) goto L29;
        if (r106 == 4) goto L25;
        if (r106 != 5) goto L49;
        if (r109 == (-1)) goto L49;
    L25:
        if (r109 != (-2)) goto L27;
        r106 = r106 + 1;
        goto L49
    L27:
        if (r109 == (-1)) goto L49;
    L29:
        if (r109 < 0) goto L31;
        int r116 = r109 | (r107 << 6);
        r102[r108 + 2] = (byte) r116;
        r102[r108 + 1] = (byte) (r116 >> 8);
        r102[r108] = (byte) (r116 >> 16);
        r108 = r108 + 3;
        r107 = r116;
        r106 = 0;
        goto L49
    L31:
        if (r109 != (-2)) goto L33;
        r102[r108 + 1] = (byte) (r107 >> 2);
        r102[r108] = (byte) (r107 >> 10);
        r108 = r108 + 2;
        r106 = 5;
        goto L49
    L33:
        if (r109 == (-1)) goto L49;
    L45:
        if (r109 >= 0) goto L46;
        if (r109 == (-1)) goto L49;
    L50:
        if (r106 == 1) goto L57;
        if (r106 == 2) goto L56;
        if (r106 == 3) goto L55;
        if (r106 == 4) goto L57;
    L55:
        int r117 = r108 + 1;
        r102[r108] = (byte) (r107 >> 10);
        r108 = r117 + 1;
        r102[r117] = (byte) (r107 >> 2);
        goto L58
    L56:
        r102[r108] = (byte) (r107 >> 4);
        r108 = r108 + 1;
        goto L58
    }
}
