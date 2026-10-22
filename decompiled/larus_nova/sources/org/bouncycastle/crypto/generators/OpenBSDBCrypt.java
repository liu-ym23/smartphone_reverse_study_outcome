package org.bouncycastle.crypto.generators;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Set;
import kotlin.UByte;
import kotlin.text.Typography;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class OpenBSDBCrypt {
    private static final Set<String> allowedVersions = null;
    private static final byte[] decodingTable = null;
    private static final String defaultVersion = "2y";
    private static final byte[] encodingTable = null;

    static {
        encodingTable = new byte[]{46, 47, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57};
        decodingTable = new byte[128];
        HashSet r100 = new HashSet();
        allowedVersions = r100;
        r100.add("2");
        r100.add("2x");
        r100.add("2a");
        r100.add(defaultVersion);
        r100.add("2b");
        int r101 = 0;
        int r102 = 0;
    L3:
        byte[] r103 = decodingTable;
        if (r102 >= r103.length) goto L6;
        r103[r102] = -1;
        r102 = r102 + 1;
    L6:
        byte[] r104 = encodingTable;
        if (r101 >= r104.length) goto L9;
        decodingTable[r104[r101]] = (byte) r101;
        r101 = r101 + 1;
        goto L6
    }

    private OpenBSDBCrypt() {
    }

    public static boolean checkPassword(String r100, byte[] r101) {
        if (r101 == null) goto L6;
        return doCheckPassword(r100, Arrays.clone(r101));
    L6:
        throw new IllegalArgumentException("Missing password.");
    }

    public static boolean checkPassword(String r100, char[] r101) {
        if (r101 == null) goto L6;
        return doCheckPassword(r100, Strings.toUTF8ByteArray(r101));
    L6:
        throw new IllegalArgumentException("Missing password.");
    }

    private static String createBcryptString(String r100, byte[] r101, byte[] r102, int r103) {
        if (allowedVersions.contains(r100) == false) goto L11;
        StringBuilder r104 = new StringBuilder(60);
        r104.append(Typography.dollar);
        r104.append(r100);
        r104.append(Typography.dollar);
        if (r103 >= 10) goto L7;
        String r105 = "0" + r103;
    L8:
        r104.append(r105);
        r104.append(Typography.dollar);
        encodeData(r104, r102);
        encodeData(r104, BCrypt.generate(r101, r102, r103));
        return r104.toString();
    L7:
        r105 = Integer.toString(r103);
        goto L8
    L11:
        throw new IllegalArgumentException("Version " + r100 + " is not accepted by this implementation.");
    }

    private static byte[] decodeSaltString(String r110) {
        char[] r111 = r110.toCharArray();
        ByteArrayOutputStream r100 = new ByteArrayOutputStream(16);
        if (r111.length != 22) goto L24;
        int r101 = 0;
    L6:
        if (r101 >= r111.length) goto L18;
        char r102 = r111[r101];
        if (r102 > 'z') goto L17;
        if (r102 < '.') goto L17;
        if (r102 <= '9') goto L15;
        if (r102 < 'A') goto L17;
    L15:
        r101 = r101 + 1;
    L17:
        throw new IllegalArgumentException("Salt string contains invalid character: " + r102);
    L18:
        char[] r103 = new char[24];
        System.arraycopy(r111, 0, r103, 0, r111.length);
        int r112 = 0;
    L19:
        if (r112 >= 24) goto L21;
        byte[] r104 = decodingTable;
        byte r105 = r104[r103[r112]];
        byte r106 = r104[r103[r112 + 1]];
        byte r107 = r104[r103[r112 + 2]];
        byte r108 = r104[r103[r112 + 3]];
        r100.write((r105 << 2) | (r106 >> 4));
        r100.write((r106 << 4) | (r107 >> 2));
        r100.write(r108 | (r107 << 6));
        r112 = r112 + 4;
        goto L19
    L21:
        byte[] r113 = r100.toByteArray();
        byte[] r109 = new byte[16];
        System.arraycopy(r113, 0, r109, 0, 16);
        return r109;
    L24:
        throw new DataLengthException("Invalid base64 salt length: " + r111.length + " , 22 required.");
    }

    private static boolean doCheckPassword(String r100, byte[] r110) {
        if (r100 == null) goto L64;
        if (r100.charAt(1) != '2') goto L62;
        int r101 = r100.length();
        if (r101 != 60) goto L9;
    L15:
        int r102 = 3;
        if (r100.charAt(2) != '$') goto L25;
        if (r100.charAt(0) != '$') goto L23;
        if (r100.charAt(5) != '$') goto L23;
    L31:
        if (r100.charAt(2) != '$') goto L33;
        String r103 = r100.substring(1, 2);
    L35:
        if (allowedVersions.contains(r103) == false) goto L58;
        String r104 = r100.substring(r102, r102 + 2);
        int r105 = CastIntegerProtector.parseInt(r104);     // Catch: NumberFormatException -> L55
        if (r105 < 4) goto L54;
        if (r105 > 31) goto L54;
        String r111 = doGenerate(r103, r110, decodeSaltString(r100.substring(r100.lastIndexOf(36) + 1, r101 - 31)), r105);
        if (r101 != r111.length()) goto L44;
        boolean r106 = true;
    L45:
        int r107 = 0;
    L46:
        if (r107 == r101) goto L52;
        if (r100.charAt(r107) != r111.charAt(r107)) goto L50;
        boolean r108 = true;
    L51:
        r106 = r106 & r108;
        r107 = r107 + 1;
        goto L46
    L50:
        r108 = false;
        goto L51
    L52:
        return r106;
    L44:
        r106 = false;
    L54:
        throw new IllegalArgumentException("Invalid cost factor: " + r105 + ", 4 < cost < 31 expected.");
    L56:
        throw new IllegalArgumentException("Invalid cost factor: " + r104);
    L58:
        throw new IllegalArgumentException("Bcrypt version '" + r103 + "' is not supported by this implementation");
    L33:
        r103 = r100.substring(1, 3);
        r102 = 4;
    L23:
        throw new IllegalArgumentException("Invalid Bcrypt String format.");
    L25:
        if (r100.charAt(0) != '$') goto L60;
        if (r100.charAt(3) != '$') goto L60;
        if (r100.charAt(6) == '$') goto L31;
    L60:
        throw new IllegalArgumentException("Invalid Bcrypt String format.");
    L9:
        if (r101 != 59) goto L14;
        if (r100.charAt(2) == '$') goto L15;
    L14:
        throw new DataLengthException("Bcrypt String length: " + r101 + ", 60 required.");
    L62:
        throw new IllegalArgumentException("not a Bcrypt string");
    L64:
        throw new IllegalArgumentException("Missing bcryptString.");
    }

    private static String doGenerate(String r100, byte[] r101, byte[] r102, int r103) {
        if (allowedVersions.contains(r100) == false) goto L27;
        if (r102 == null) goto L25;
        if (r102.length != 16) goto L23;
        if (r103 < 4) goto L21;
        if (r103 > 31) goto L21;
        int r104 = 72;
        if (r101.length >= 72) goto L15;
        r104 = r101.length + 1;
    L15:
        byte[] r105 = new byte[r104];
        if (r104 <= r101.length) goto L18;
        r104 = r101.length;
    L18:
        System.arraycopy(r101, 0, r105, 0, r104);
        Arrays.fill(r101, (byte) 0);
        String r106 = createBcryptString(r100, r105, r102, r103);
        Arrays.fill(r105, (byte) 0);
        return r106;
    L21:
        throw new IllegalArgumentException("Invalid cost factor.");
    L23:
        throw new DataLengthException("16 byte salt required: " + r102.length);
    L25:
        throw new IllegalArgumentException("Salt required.");
    L27:
        throw new IllegalArgumentException("Version " + r100 + " is not accepted by this implementation.");
    }

    private static void encodeData(StringBuilder r100, byte[] r110) {
        if (r110.length != 24) goto L5;
    L9:
        int r101 = 0;
        if (r110.length != 16) goto L12;
        byte[] r102 = new byte[18];
        System.arraycopy(r110, 0, r102, 0, r110.length);
        r110 = r102;
        boolean r103 = true;
    L13:
        int r104 = r110.length;
    L14:
        if (r101 >= r104) goto L16;
        int r105 = r110[r101] & UByte.MAX_VALUE;
        int r106 = r110[r101 + 1] & UByte.MAX_VALUE;
        int r107 = r110[r101 + 2] & UByte.MAX_VALUE;
        byte[] r108 = encodingTable;
        r100.append((char) r108[(r105 >>> 2) & 63]);
        r100.append((char) r108[((r105 << 4) | (r106 >>> 4)) & 63]);
        r100.append((char) r108[((r106 << 2) | (r107 >>> 6)) & 63]);
        r100.append((char) r108[r107 & 63]);
        r101 = r101 + 3;
        goto L14
    L16:
        int r111 = r100.length();
        if (r103 != true) goto L19;
        int r112 = r111 - 2;
    L20:
        r100.setLength(r112);
        return;
    L19:
        r112 = r111 - 1;
        goto L20
    L12:
        r110[r110.length - 1] = 0;
        r103 = false;
        goto L13
    L5:
        if (r110.length == 16) goto L9;
        throw new DataLengthException("Invalid length: " + r110.length + ", 24 for key or 16 for salt expected");
    }

    public static String generate(String r100, byte[] r101, byte[] r102, int r103) {
        if (r101 == null) goto L6;
        return doGenerate(r100, Arrays.clone(r101), r102, r103);
    L6:
        throw new IllegalArgumentException("Password required.");
    }

    public static String generate(String r100, char[] r101, byte[] r102, int r103) {
        if (r101 == null) goto L6;
        return doGenerate(r100, Strings.toUTF8ByteArray(r101), r102, r103);
    L6:
        throw new IllegalArgumentException("Password required.");
    }

    public static String generate(byte[] r100, byte[] r101, int r102) {
        return generate(defaultVersion, r100, r101, r102);
    }

    public static String generate(char[] r100, byte[] r101, int r102) {
        return generate(defaultVersion, r100, r101, r102);
    }
}
