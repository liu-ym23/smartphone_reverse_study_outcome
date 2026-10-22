package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import androidx.versionedparcelable.VersionedParcel;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.a;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

/* JADX INFO: loaded from: classes23.dex */
public abstract class FileSHA256 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f277967a = 8192;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f277968b = "SHA-256";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f277969c = "FileSHA256";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f277970d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f277971e = null;

    static {
        f277971e = new String[]{"SHA-256", McElieceCCA2KeyGenParameterSpec.SHA384, "SHA-512"};
    }

    public FileSHA256() {
    }

    private static boolean a(File r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.exists() == false) goto L8;
        if (r100.length() <= 0) goto L8;
        return true;
    }

    public static String fileSHA256Encrypt(File r100) {
        return fileSHAEncrypt(r100, "SHA-256");
    }

    public static String inputStreamSHA256Encrypt(InputStream r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return inputStreamSHAEncrypt(r100, "SHA-256");
    }

    private static boolean a(String r100) {
        String[] r101 = f277971e;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r101[r103].equals(r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String fileSHAEncrypt(File r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L40:
        b.b(f277969c, "algorithm is empty or not safe");
        return "";
    L5:
        if (a(r101) == false) goto L40;
        if (a(r100) == true) goto L11;
        b.b(f277969c, "file is not valid");
        return "";
    L11:
        VersionedParcel.AnonymousClass1 r102 = 0;
        String r103 = null;
        r103 = null;
        MessageDigest r104 = MessageDigest.getInstance(r101);     // Catch: Throwable -> L26 IOException -> L28 NoSuchAlgorithmException -> L31
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L26 IOException -> L28 NoSuchAlgorithmException -> L31
    L43:
        byte[] r106 = new byte[8192];     // Catch: IOException -> L22 NoSuchAlgorithmException -> L24 Throwable -> L36
        boolean r107 = false;
    L15:
        int r108 = r105.read(r106);     // Catch: IOException -> L22 NoSuchAlgorithmException -> L24 Throwable -> L36
        if (r108 <= 0) goto L18;
        r104.update(r106, 0, r108);     // Catch: IOException -> L22 NoSuchAlgorithmException -> L24 Throwable -> L36
        r107 = true;
        goto L15
    L18:
        if (r107 == false) goto L21;
        r103 = HexUtil.byteArray2HexStr(r104.digest());     // Catch: IOException -> L22 NoSuchAlgorithmException -> L24 Throwable -> L36
        goto L21
    L21:
        a.a(r105);
    L35:
        return r103;
    L22:
        e = e;
    L30:
        b.b(f277969c, "IOException" + e.getMessage());     // Catch: Throwable -> L36
    L34:
        a.a(r105);
    L24:
        e = e;
    L33:
        b.b(f277969c, "NoSuchAlgorithmException" + e.getMessage());     // Catch: Throwable -> L36
    L36:
        th = th;
        r102 = "";
    L38:
        a.a(r102);
        throw th;
    L28:
        e = e;
        r105 = null;
    L31:
        e = e;
        r105 = null;
    L26:
        th = th;
        goto L38
    }

    public static String inputStreamSHAEncrypt(InputStream r100, String r101) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L8;
    L26:
        b.b(f277969c, "algorithm is empty or not safe");
        return "";
    L8:
        if (a(r101) == false) goto L26;
        byte[] r102 = new byte[8192];
        MessageDigest r103 = MessageDigest.getInstance(r101);     // Catch: Throwable -> L19 Throwable -> L21
    L12:
        int r104 = r100.read(r102);     // Catch: Throwable -> L19 Throwable -> L21
        if (r104 < 0) goto L16;
        if (r104 <= 0) goto L12;
        r103.update(r102, 0, r104);     // Catch: Throwable -> L19 Throwable -> L21
        goto L12
    L16:
        String r105 = HexUtil.byteArray2HexStr(r103.digest());     // Catch: Throwable -> L19 Throwable -> L21
        a.a(r100);
        return r105;
    L19:
        th = move-exception;
        a.a(r100);
        throw th;
    L21:
        b.b(f277969c, "inputstraem exception");     // Catch: Throwable -> L19
        a.a(r100);
        return "";
    }

    public static boolean validateFileSHA256(File r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return false;
    L7:
        return r101.equalsIgnoreCase(fileSHA256Encrypt(r100));
    }

    public static boolean validateInputStreamSHA256(InputStream r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return false;
    L7:
        return r101.equals(inputStreamSHA256Encrypt(r100));
    }

    public static boolean validateFileSHA(File r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L9:
        b.b(f277969c, "hash value is null || algorithm is illegal");
        return false;
    L5:
        if (a(r102) == false) goto L9;
        return r101.equals(fileSHAEncrypt(r100, r102));
    }

    public static boolean validateInputStreamSHA(InputStream r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L9:
        b.b(f277969c, "hash value is null || algorithm is illegal");
        return false;
    L5:
        if (a(r102) == false) goto L9;
        return r101.equals(inputStreamSHAEncrypt(r100, r102));
    }
}
