package com.ss.android.lark.seccache.impl;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import com.byted.cast.linkcommon.security.SecurityUtil;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f440389a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f440390b = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f440391a = null;

        static {
            f440391a = new b();
        }
    }

    static {
        f440389a = new byte[]{-1, -1, -1, -1};
        f440390b = new Object();
    }

    public static void d() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyGenerator r100 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES, "AndroidKeyStore");
        r100.init(new KeyGenParameterSpec.Builder("cache", 3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setRandomizedEncryptionRequired(false).build());
        r100.generateKey();
    }

    public static Key e() throws NoSuchAlgorithmException, IOException, KeyStoreException, UnrecoverableEntryException, CertificateException, InvalidAlgorithmParameterException, NoSuchProviderException {
        KeyStore r100 = KeyStore.getInstance("AndroidKeyStore");
        r100.load(null);
        Key r101 = r100.getKey("cache", null);
        if (r101 != null) goto L15;
        Object r102 = f440390b;
        monitor-enter(r102);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        d();     // Catch: Throwable -> L12
    L9:
        monitor-exit(r102);     // Catch: Throwable -> L12
        return r100.getKey("cache", null);
    L15:
        return r101;
    }

    public b() {
    }

    public static byte[] a(byte[] r100) throws Exception {
        ByteBuffer r101 = ByteBuffer.wrap(r100);
        int r102 = r101.getInt();
        if (r102 < 12) goto L9;
        if (r102 >= 16) goto L9;
        byte[] r103 = new byte[r102];
        r101.get(r103);
        byte[] r104 = new byte[r101.remaining()];
        r101.get(r104);
        Cipher r105 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);
        r105.init(2, e(), new GCMParameterSpec(128, r103));
        return r105.doFinal(r104);
    L9:
        throw new IllegalArgumentException("invalid iv length");
    }

    public static byte[] f(PolarisFileWrapper r100) throws IOException {
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r100);
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        byte[] r103 = new byte[1024];
    L3:
        int r104 = r101.read(r103);
        if (r104 == (-1)) goto L6;
        r102.write(r103, 0, r104);
        goto L3
    L6:
        r101.close();
        return r102.toByteArray();
    }

    public static byte[] b(PolarisFileWrapper r100, boolean r101) throws Exception {
        byte[] r102 = f440389a;
        if (r100.exists() == false) goto L40;
        byte[] r103 = f(r100);
        if (Build.VERSION.SDK_INT < 23) goto L38;
        boolean r104 = false;
        ByteBuffer r105 = ByteBuffer.wrap(r103);     // Catch: Exception -> L10
        int r106 = r105.getInt();     // Catch: Exception -> L10
        if (r106 != 4) goto L12;
        byte[] r107 = new byte[r106];     // Catch: Exception -> L10
        r105.get(r107);     // Catch: Exception -> L10
        boolean r108 = Arrays.equals(r107, r102);     // Catch: Exception -> L10
    L13:
        if (r108 == false) goto L27;
        byte[] r109 = new byte[r105.remaining()];     // Catch: Exception -> L10
        r105.get(r109);     // Catch: Exception -> L10
        if (r101 == true) goto L49;
        byte[] r110 = new byte[0];     // Catch: Exception -> L10
        byte[] r111 = a(r109);     // Catch: Throwable -> L42 Exception -> L43
        PolarisFileOutputStreamWrapper r112 = new PolarisFileOutputStreamWrapper(r100);     // Catch: Exception -> L21 Throwable -> L41
        r112.write(r111);     // Catch: Exception -> L21 Throwable -> L41
        r112.close();     // Catch: Exception -> L21 Throwable -> L41
        goto L53
    L52:
        return r111;
    L21:
        r110 = r111;
    L53:
        return r111;
    L50:
        return r110;
    L24:
        if (r100.delete() == true) goto L50;
        Log.e("KeystoreImpl", "decrypt error and file can not be delete.");     // Catch: Throwable -> L42
        goto L50
    L49:
        return a(r109);
    L27:
        if (r101 == true) goto L29;
        return r103;
    L29:
        c(r100, true);     // Catch: Exception -> L10
        return r103;
    L12:
        r108 = false;
    L10:
        e = move-exception;
        Log.e("KeystoreImpl", e);
        ByteBuffer r113 = ByteBuffer.wrap(r103);
        int r114 = r113.getInt();
        if (r114 != 4) goto L34;
        byte[] r115 = new byte[r114];
        r113.get(r115);
        r104 = Arrays.equals(r115, r102);
    L34:
        if (r104 == true) goto L36;
        return r103;
    L36:
        Log.e("KeystoreImpl", "Decryption fails and the content is ciphertext");
        throw new KeyStoreException("Decryption fails and the content is ciphertext");
    L38:
        return r103;
    L40:
        throw new IllegalArgumentException("File to be encrypted not exists");
    }

    public static void c(PolarisFileWrapper r100, boolean r101) throws Exception {
        if (r101 == true) goto L5;
        return;
    L5:
        if (r100.exists() == false) goto L11;
        byte[] r102 = f(r100);
        if (Build.VERSION.SDK_INT < 23) goto L12;
        Cipher r103 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);
        byte[] r104 = new byte[12];
        SecureRandom.getInstance("SHA1PRNG").nextBytes(r104);
        r103.init(1, e(), new GCMParameterSpec(128, r104));
        byte[] r105 = r103.doFinal(r102);
        ByteBuffer r106 = ByteBuffer.allocate(r105.length + 24);
        r106.putInt(4);
        r106.put(f440389a);
        r106.putInt(12);
        r106.put(r104);
        r106.put(r105);
        byte[] r107 = r106.array();
        PolarisFileOutputStreamWrapper r108 = new PolarisFileOutputStreamWrapper(r100);
        r108.write(r107);
        r108.close();
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("File to be encrypted must be non null");
    }
}
