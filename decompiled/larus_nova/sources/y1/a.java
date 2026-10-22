package y1;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.List;
import java.util.zip.CRC32;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public final class a {
    public static byte[] f(int r100) {
        return new byte[]{(byte) (r100 & 255), (byte) ((r100 >> 8) & 255), (byte) ((r100 >> 16) & 255), (byte) ((r100 >> 24) & 255)};
    }

    public static int d(byte[] r100) {
        int r101 = ((r100[0] & UByte.MAX_VALUE) | ((r100[1] << 8) & 65280)) | ((r100[2] << 16) & 16711680);
        return ((r100[3] << 24) & (-16777216)) | r101;
    }

    public static String i(String r100) {
        char[] r101 = "0123456789ABCDEF".toCharArray();
        StringBuilder r102 = new StringBuilder("");
        byte[] r103 = r100.getBytes();
        int r104 = 0;
    L4:
        if (r104 >= r103.length) goto L7;
        r102.append(r101[(r103[r104] & 240) >> 4]);
        r102.append(r101[r103[r104] & 15]);
        r102.append(',');
        r104 = r104 + 1;
        goto L4
    L7:
        return r102.toString().trim();
    }

    public static byte[] j(String r100) {
        int r101 = 0;
        if (r100 == null) goto L20;
        if (r100.trim().equals("") == true) goto L20;
        String r102 = r100.replace(",", "");
        if (r102 == null) goto L18;
        if (r102.trim().equals("") == true) goto L18;
        byte[] r103 = new byte[r102.length() / 2];
    L14:
        if (r101 >= (r102.length() / 2)) goto L16;
        int r104 = r101 * 2;
        r103[r101] = (byte) CastIntegerProtector.parseInt(r102.substring(r104, r104 + 2), 16);
        r101 = r101 + 1;
        goto L14
    L16:
        return r103;
    L18:
        return new byte[0];
    L20:
        return new byte[0];
    }

    public static String k(byte[] r100) {
        StringBuffer r101 = new StringBuffer();
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        r101.append(String.format("%02x", new Object[]{Byte.valueOf(r100[r102])}));
        r101.append(",");
        r102 = r102 + 1;
        goto L4
    L7:
        return r101.toString();
    }

    public static byte[] b(byte[] r100, byte[] r101) {
        byte[] r102 = new byte[r100.length + r101.length];
        System.arraycopy(r100, 0, r102, 0, r100.length);
        System.arraycopy(r101, 0, r102, r100.length, r101.length);
        return r102;
    }

    public static long e(byte[] r100, int r101) {
        CRC32 r102 = new CRC32();
        r102.update(r100, 0, r101);
        return r102.getValue();
    }

    public static void g(List r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L12;
        if (r101 >= 0) goto L8;
        return;
    L8:
        if (r100.size() <= r101) goto L13;
        ListProtector.remove(r100, r101);
        ListProtector.add(r100, r101, null);
        return;
    L13:
        return;
    }

    public static boolean h(byte[] r100, byte[] r101) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L22;
        return true;
    L22:
        return false;
    L7:
        if (r101 != null) goto L10;
        return true;
    L10:
        if (r100.length >= r101.length) goto L12;
        return false;
    L12:
        int r102 = 0;
    L14:
        if (r102 >= r101.length) goto L19;
        if (r100[r102] != r101[r102]) goto L17;
        r102 = r102 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    }

    public static void a(List r100, Object r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L12;
        if (r102 >= 0) goto L8;
        return;
    L8:
        if (r100.size() <= r102) goto L13;
        ListProtector.remove(r100, r102);
        ListProtector.add(r100, r102, r101);
        return;
    L13:
        return;
    }

    public static byte[] c(byte[] r100, byte[] r101, byte[] r102, byte[] r103) {
        byte[] r104 = new byte[((r100.length + r101.length) + r102.length) + r103.length];
        System.arraycopy(r100, 0, r104, 0, r100.length);
        System.arraycopy(r101, 0, r104, r100.length, r101.length);
        System.arraycopy(r102, 0, r104, r100.length + r101.length, r102.length);
        System.arraycopy(r103, 0, r104, (r100.length + r101.length) + r102.length, r103.length);
        return r104;
    }
}
