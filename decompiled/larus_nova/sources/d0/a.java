package d0;

import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes28.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f466154a = null;

    static {
        int[] r100 = new int[256];
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r102 > 255) goto L7;
        r100[r102] = -1;
        r102 = r102 + 1;
    L7:
        if (r101 >= 65) goto L9;
        r100["ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(r101)] = r101;
        r101 = r101 + 1;
        goto L7
    L9:
        f466154a = r100;
    }

    public static byte[] a(String r110) {
        int r100 = r110.length();
        byte[] r101 = new byte[r100];
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L5;
        r101[r103] = (byte) r110.charAt(r103);
        r103 = r103 + 1;
        goto L3
    L5:
        byte[] r111 = new byte[r100];
        int r104 = 0;
    L6:
        if (r102 >= r100) goto L19;
        int[] r105 = f466154a;
        int r106 = r105[r101[r102] & UByte.MAX_VALUE];
        r102 = r102 + 1;
        if (r106 < 0) goto L6;
        int r107 = r102 + 1;
        int r108 = r105[r101[r102] & UByte.MAX_VALUE];
        int r109 = r107 + 1;
        int r112 = r105[r101[r107] & UByte.MAX_VALUE];
        int r113 = r109 + 1;
        int r114 = r105[r101[r109] & UByte.MAX_VALUE];
        int r115 = r104 + 1;
        r111[r104] = (byte) ((r106 << 2) | (r108 >> 4));
        if (r112 >= 64) goto L16;
        int r116 = r115 + 1;
        r111[r115] = (byte) ((r108 << 4) | (r112 >> 2));
        if (r114 >= 64) goto L15;
        r111[r116] = (byte) ((r112 << 6) | r114);
        r104 = r116 + 1;
    L17:
        r102 = r113;
        goto L6
    L15:
        r104 = r116;
        goto L17
    L16:
        r104 = r115;
        goto L17
    L19:
        return Arrays.copyOf(r111, r104);
    }
}
