package x1;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.crypto.utils.CryptoConst;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes39.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f562093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f562094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f562095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f562096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f562097e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f562098f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f562099g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f562100h;

    public d() {
        this.f562097e = y1.a.j(y1.a.i("HEAD"));
        this.f562098f = y1.a.j(y1.a.i("TAIL"));
        this.f562099g = new byte[4];
        this.f562100h = new byte[4];
    }

    public final byte[] a(byte[] r100) {
        byte[] r101 = y1.a.f(r100.length);
        long r102 = y1.a.e(r100, r100.length);
        return y1.a.c(y1.a.b(this.f562097e, r101), r100, new byte[]{(byte) r102, (byte) (r102 >> 8), (byte) (r102 >> 16), (byte) (r102 >> 24)}, this.f562098f);
    }

    public final byte[] c(byte[] r100) {
        SecretKeySpec r101 = new SecretKeySpec(this.f562095c, CryptoConst.ALGORITHM_AES);
        Cipher r102 = Cipher.getInstance("AES/CBC/NoPadding");     // Catch: NoSuchPaddingException -> L5 NoSuchAlgorithmException -> L7
    L24:
        r102.init(2, r101, new IvParameterSpec(new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, HTTP.CR, 14, 15}));     // Catch: InvalidKeyException -> L12 InvalidAlgorithmParameterException -> L14
    L16:
        byte[] r103 = new byte[r100.length];
    L31:
        return r102.doFinal(r100);
    L21:
        e = move-exception;
        e.printStackTrace();
        return r103;
    L19:
        e = move-exception;
        e.printStackTrace();
        return r103;
    L14:
        e = move-exception;
        e.printStackTrace();
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L7:
        e = move-exception;
        e.printStackTrace();
    L9:
        r102 = null;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public final byte[] d(byte[] r100) {
        byte[] r101 = this.f562095c;
        int r102 = r100.length;
        int r103 = r102 % 16;
        if (r103 == 0) goto L5;
        int r104 = (r102 + 16) - r103;
    L6:
        byte[] r105 = new byte[r104];
        System.arraycopy(r100, 0, r105, 0, r102);
        SecretKeySpec r106 = new SecretKeySpec(r101, CryptoConst.ALGORITHM_AES);     // Catch: BadPaddingException -> L18 IllegalBlockSizeException -> L20 InvalidKeyException -> L22 NoSuchPaddingException -> L24 NoSuchAlgorithmException -> L26
        Cipher r107 = Cipher.getInstance("AES/CBC/NoPadding");     // Catch: BadPaddingException -> L18 IllegalBlockSizeException -> L20 InvalidKeyException -> L22 NoSuchPaddingException -> L24 NoSuchAlgorithmException -> L26
        r107.init(1, r106, new IvParameterSpec(new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, HTTP.CR, 14, 15}));     // Catch: InvalidAlgorithmParameterException -> L10 BadPaddingException -> L18 IllegalBlockSizeException -> L20 InvalidKeyException -> L22 NoSuchPaddingException -> L24 NoSuchAlgorithmException -> L26
    L12:
        byte[] r108 = new byte[r104];     // Catch: BadPaddingException -> L18 IllegalBlockSizeException -> L20 InvalidKeyException -> L22 NoSuchPaddingException -> L24 NoSuchAlgorithmException -> L26
        r107.doFinal(r105, 0, r104, r108);     // Catch: ShortBufferException -> L15 BadPaddingException -> L18 IllegalBlockSizeException -> L20 InvalidKeyException -> L22 NoSuchPaddingException -> L24 NoSuchAlgorithmException -> L26
        return r108;
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: BadPaddingException -> L18 IllegalBlockSizeException -> L20 InvalidKeyException -> L22 NoSuchPaddingException -> L24 NoSuchAlgorithmException -> L26
    L37:
        return r108;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: BadPaddingException -> L18 IllegalBlockSizeException -> L20 InvalidKeyException -> L22 NoSuchPaddingException -> L24 NoSuchAlgorithmException -> L26
    L22:
        e = move-exception;
        e.printStackTrace();
    L28:
        return null;
    L26:
        e = move-exception;
        e.printStackTrace();
    L18:
        e = move-exception;
        e.printStackTrace();
    L20:
        e = move-exception;
        e.printStackTrace();
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L5:
        r104 = r102;
        goto L6
    }

    public final byte[] b(byte[] r110, boolean r111) {
        y1.a.k(r110);
        if (y1.a.h(r110, this.f562097e) == false) goto L32;
        byte[] r100 = this.f562098f;
        if (r100 != null) goto L8;
    L17:
        boolean r101 = true;
    L18:
        if (r101 == false) goto L32;
        int r102 = this.f562097e.length;
        byte[] r103 = this.f562099g;
        System.arraycopy(r110, r102, r103, 0, r103.length);
        int r104 = y1.a.d(this.f562099g);
        byte[] r105 = new byte[r104];
        System.arraycopy(r110, this.f562097e.length + this.f562099g.length, r105, 0, r104);
        long r106 = y1.a.e(r105, r104);
        byte[] r107 = {(byte) r106, (byte) (r106 >> 8), (byte) (r106 >> 16), (byte) (r106 >> 24)};
        int r108 = (this.f562097e.length + this.f562099g.length) + r104;
        byte[] r109 = this.f562100h;
        System.arraycopy(r110, r108, r109, 0, r109.length);
        int r112 = 0;
    L21:
        byte[] r113 = this.f562100h;
        if (r112 >= r113.length) goto L28;
        if (r107[r112] != r113[r112]) goto L26;
        r112 = r112 + 1;
        goto L21
    L26:
        return new byte[]{1};
    L28:
        if (r111 == true) goto L30;
        return r105;
    L30:
        return c(r105);
    L8:
        if (r110.length < r100.length) goto L15;
        int r114 = 0;
    L12:
        if (r114 >= r100.length) goto L17;
        if (r110[(r110.length - 1) - r114] != r100[(r100.length - 1) - r114]) goto L15;
        r114 = r114 + 1;
    L15:
        r101 = false;
    L32:
        return new byte[]{0, 0, 0, 0, 0};
    }
}
