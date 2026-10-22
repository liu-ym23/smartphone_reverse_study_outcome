package com.bytedance.crypto.obfuscated;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.security.keystore.KeyGenParameterSpec;
import com.android.ttcjpaysdk.thirdparty.fingerprint.CJPayFingerprintSharedPrefUtils;
import com.byted.cast.linkcommon.security.SecurityUtil;
import com.bytedance.crypto.utils.CryptoConst;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes15.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SecretKeySpec f204270a;

    public static SecretKey a() {
        KeyStore r100 = KeyStore.getInstance("AndroidKeyStore");
        r100.load(null);
        if (r100.containsAlias("secret_master_key") == true) goto L7;
        KeyGenerator r101 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES, "AndroidKeyStore");
        r101.init(new KeyGenParameterSpec.Builder("secret_master_key", 3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setRandomizedEncryptionRequired(false).setKeySize(256).build());
        return r101.generateKey();
    L7:
        return (SecretKey) r100.getKey("secret_master_key", null);
    }

    public static SecretKeySpec a(Context r110, String r111) {
        k r100 = k.a(r110);
        r100.getClass();
        "queryKey, alias: ".concat(r111);
        Cursor r101 = r100.getReadableDatabase().query("key_item", null, "alias =? ", new String[]{r111}, null, null, null);
        if (r101 != null) goto L6;
    L4:
        n r102 = null;
    L12:
        String r103 = r110.getPackageName() + r111;
        if (r102 != null) goto L34;
        byte[] r104 = new byte[32];
        new SecureRandom().nextBytes(r104);
        byte[] r112 = new byte[12];
        new SecureRandom().nextBytes(r112);
        byte[] r105 = r103.getBytes(StandardCharsets.UTF_8);
        GCMParameterSpec r113 = new GCMParameterSpec(128, r112);     // Catch: Exception -> L22
        Cipher r114 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);     // Catch: Exception -> L22
        r114.init(1, a(), r113);     // Catch: Exception -> L22
        if (r105 != null) goto L18;
    L20:
        byte[] r106 = r114.doFinal(r104);     // Catch: Exception -> L22
    L24:
        if (r106 != null) goto L26;
    L33:
        return null;
    L26:
        if (r106.length == 0) goto L33;
        String r107 = o.a(r112);
        String r108 = o.a(r106);
        k r115 = k.a(r110);
        r115.getClass();
        "insertKey, alias: ".concat(r111);
        SQLiteDatabase r116 = r115.getWritableDatabase();
        ContentValues r117 = new ContentValues();
        r117.put("alias", r111);
        r117.put("version", 1);
        r117.put("cipher", r108);
        r117.put(CJPayFingerprintSharedPrefUtils.KEY_IV, r107);
        r117.put("extra", "");
        if (r116.insert("key_item", null, r117) != (-1)) goto L32;
        return null;
    L32:
        return new SecretKeySpec(r104, CryptoConst.ALGORITHM_AES);
    L18:
        if (r105.length <= 0) goto L20;
        r114.updateAAD(r105);     // Catch: Exception -> L22
    L22:
        e = move-exception;
        e.getMessage();
        e.printStackTrace();
        r106 = new byte[0];
        goto L24
    L34:
        byte[] r118 = o.a(r102.f204269b);
        byte[] r119 = o.a(r102.f204268a);
        byte[] r109 = r103.getBytes(StandardCharsets.UTF_8);
        GCMParameterSpec r120 = new GCMParameterSpec(128, r118);     // Catch: Exception -> L42
        Cipher r121 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);     // Catch: Exception -> L42
        r121.init(2, a(), r120);     // Catch: Exception -> L42
        if (r109 != null) goto L38;
    L40:
        byte[] r122 = r121.doFinal(r119);     // Catch: Exception -> L42
    L44:
        if (r122 != null) goto L46;
    L50:
        return null;
    L46:
        if (r122.length == 0) goto L50;
        return new SecretKeySpec(r122, CryptoConst.ALGORITHM_AES);
    L38:
        if (r109.length <= 0) goto L40;
        r121.updateAAD(r109);     // Catch: Exception -> L42
    L42:
        e = move-exception;
        e.getMessage();
        e.printStackTrace();
        r122 = new byte[0];
        goto L44
    L6:
        if (r101.getCount() != 0) goto L8;
        r101.close();
        goto L4
    L8:
        r102 = new n();
        if (r101.moveToFirst() == false) goto L11;
        r101.getInt(r101.getColumnIndex("version"));
        r102.f204269b = r101.getString(r101.getColumnIndex(CJPayFingerprintSharedPrefUtils.KEY_IV));
        r102.f204268a = r101.getString(r101.getColumnIndex("cipher"));
        r101.getString(r101.getColumnIndex("extra"));
    L11:
        r101.close();
        goto L12
    }
}
