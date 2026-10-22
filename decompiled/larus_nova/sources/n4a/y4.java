package n4a;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.NamedPipe;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes32.dex */
public final class y4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f517973a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f517974b = null;

    static {
        f517973a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', OthersPermission.STICKY, Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO, 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f', 'g', 'h', 'i', 'j', 'k', Symlink.UNIX_ID, 'm', 'n', 'o', NamedPipe.UNIX_ID, 'q', Permission.READ, 's', OthersPermission.STICKY_E, 'u', 'v', Permission.WRITE, Permission.EXECUTE, 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        f517974b = new byte[128];
        int r100 = 0;
    L3:
        if (r100 >= 128) goto L5;
        f517974b[r100] = -1;
        r100 = r100 + 1;
        goto L3
    L5:
        int r101 = 65;
    L7:
        if (r101 > 90) goto L9;
        f517974b[r101] = (byte) (r101 - 65);
        r101 = r101 + 1;
        goto L7
    L9:
        int r102 = 97;
    L11:
        if (r102 > 122) goto L13;
        f517974b[r102] = (byte) ((r102 - 97) + 26);
        r102 = r102 + 1;
        goto L11
    L13:
        int r103 = 48;
    L15:
        if (r103 > 57) goto L17;
        f517974b[r103] = (byte) ((r103 - 48) + 52);
        r103 = r103 + 1;
        goto L15
    L17:
        byte[] r104 = f517974b;
        r104[43] = 62;
        r104[47] = 63;
    }

    public static byte[] b(byte[] r100, Key r101) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher r102 = Cipher.getInstance(f5.o("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
        r102.init(1, r101);
        return r102.doFinal(r100);
    }

    public static byte[] c(byte[] r100, byte[] r101, byte[] r102) throws Exception {
        IvParameterSpec r103 = new IvParameterSpec(r102);
        SecretKeySpec r104 = new SecretKeySpec(r100, f5.o("EQUVT"));
        Cipher r105 = Cipher.getInstance(f5.o("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        r105.init(2, r104, r103);
        return r105.doFinal(r101);
    }

    public static String d(byte[] r100) {
        return g(r100);
    L4:
        th = move-exception;
        n.a(th, "er", "e64");
        return null;
    }

    public static byte[] e(String r100) {
        int r101 = 0;
        if (r100 == null) goto L5;
        byte[] r102 = f5.j(r100);
        int r103 = r102.length;
        ByteArrayOutputStream r104 = new ByteArrayOutputStream(r103);
    L7:
        if (r101 >= r103) goto L50;
    L8:
        byte[] r105 = f517974b;
        int r106 = r101 + 1;
        byte r107 = r105[r102[r101]];
        if (r106 >= r103) goto L13;
        if (r107 != (-1)) goto L13;
        r101 = r106;
    L13:
        if (r107 == (-1)) goto L50;
    L14:
        int r108 = r106 + 1;
        byte r109 = r105[r102[r106]];
        if (r108 >= r103) goto L19;
        if (r109 != (-1)) goto L19;
        r106 = r108;
    L19:
        if (r109 == (-1)) goto L50;
        r104.write((r107 << 2) | ((r109 & 48) >>> 4));
    L21:
        if (r108 == r103) goto L23;
        int r110 = r108 + 1;
        byte r111 = r102[r108];
        if (r111 == 61) goto L27;
        byte r112 = r105[r111];
        if (r110 >= r103) goto L33;
        if (r112 != (-1)) goto L33;
        r108 = r110;
    L33:
        if (r112 == (-1)) goto L50;
        r104.write(((r109 & 15) << 4) | ((r112 & 60) >>> 2));
    L35:
        if (r110 == r103) goto L37;
        int r113 = r110 + 1;
        byte r114 = r102[r110];
        if (r114 == 61) goto L41;
        byte r115 = r105[r114];
        if (r113 >= r103) goto L47;
        if (r115 != (-1)) goto L47;
        r110 = r113;
    L47:
        if (r115 == (-1)) goto L50;
        r104.write(r115 | ((r112 & 3) << 6));
        r101 = r113;
        goto L7
    L41:
        return r104.toByteArray();
    L37:
        return r104.toByteArray();
    L27:
        return r104.toByteArray();
    L23:
        return r104.toByteArray();
    L50:
        return r104.toByteArray();
    L5:
        return new byte[0];
    }

    public static byte[] f(byte[] r100, byte[] r101, byte[] r102) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        IvParameterSpec r103 = new IvParameterSpec(r102);
        SecretKeySpec r104 = new SecretKeySpec(r100, f5.o("EQUVT"));
        Cipher r105 = Cipher.getInstance(f5.o("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        r105.init(1, r104, r103);     // Catch: InvalidAlgorithmParameterException -> L5
    L8:
        return r105.doFinal(r101);
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public static String g(byte[] r100) {
        StringBuffer r101 = new StringBuffer();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L13;
        int r104 = r103 + 1;
        int r105 = r100[r103] & UByte.MAX_VALUE;
        char[] r106 = f517973a;
        if (r104 == r102) goto L6;
        int r107 = r104 + 1;
        int r108 = r100[r104] & UByte.MAX_VALUE;
        if (r107 == r102) goto L10;
        int r109 = r107 + 1;
        int r110 = r100[r107] & UByte.MAX_VALUE;
        r101.append(r106[r105 >>> 2]);
        r101.append(r106[((r105 & 3) << 4) | ((r108 & 240) >>> 4)]);
        r101.append(r106[((r108 & 15) << 2) | ((r110 & 192) >>> 6)]);
        r101.append(r106[r110 & 63]);
        r103 = r109;
        goto L3
    L10:
        r101.append(r106[r105 >>> 2]);
        r101.append(r106[((r105 & 3) << 4) | ((r108 & 240) >>> 4)]);
        r101.append(r106[(r108 & 15) << 2]);
        String r111 = ContainerUtils.KEY_VALUE_DELIMITER;
    L7:
        r101.append(r111);
        goto L13
    L6:
        r101.append(r106[r105 >>> 2]);
        r101.append(r106[(r105 & 3) << 4]);
        r111 = "==";
    L13:
        return r101.toString();
    }

    public static byte[] a(byte[] r100) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator r101 = KeyGenerator.getInstance(f5.o("EQUVT"));
        byte[] r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        r101.init(256);
        byte[] r103 = r101.generateKey().getEncoded();
        PublicKey r104 = f5.q();
        if (r104 != null) goto L8;
        return null;
    L8:
        byte[] r105 = b(r103, r104);
        r102 = f(r103, r100, f5.p());     // Catch: Throwable -> L11
    L13:
        byte[] r106 = new byte[r105.length + r102.length];
        System.arraycopy(r105, 0, r106, 0, r105.length);
        System.arraycopy(r102, 0, r106, r105.length, r102.length);
        return r106;
    L11:
        th = move-exception;
        n.a(th, "er", "asEn");
        goto L13
    }
}
