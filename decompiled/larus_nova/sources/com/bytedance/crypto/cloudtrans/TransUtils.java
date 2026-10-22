package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.UByte;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class TransUtils {
    private static final String TAG = "TransUtils";

    public TransUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static long byteArrayToLong(byte[] r100) {
        long r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101 = (r101 << 8) | ((long) (r100[r102] & UByte.MAX_VALUE));
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static int bytesToInt(byte[] r100) {
        if (r100.length != 4) goto L7;
        int r101 = (((r100[0] & UByte.MAX_VALUE) << 24) | ((r100[1] & UByte.MAX_VALUE) << 16)) | ((r100[2] & UByte.MAX_VALUE) << 8);
        return (r100[3] & UByte.MAX_VALUE) | r101;
    L7:
        throw new IllegalArgumentException("Byte array must be exactly 4 bytes long");
    }

    public static long bytesToLong(byte[] r100) {
        if (r100.length != 8) goto L7;
        long r101 = (((((((long) (r100[0] & UByte.MAX_VALUE)) << 56) | (((long) (r100[1] & UByte.MAX_VALUE)) << 48)) | (((long) (r100[2] & UByte.MAX_VALUE)) << 40)) | (((long) (r100[3] & UByte.MAX_VALUE)) << 32)) | (((long) (r100[4] & UByte.MAX_VALUE)) << 24)) | (((long) (r100[5] & UByte.MAX_VALUE)) << 16);
        return ((((long) (r100[6] & UByte.MAX_VALUE)) << 8) | r101) | ((long) (r100[7] & UByte.MAX_VALUE));
    L7:
        throw new IllegalArgumentException("Byte array must be exactly 8 bytes long");
    }

    public static String certChainsToPEM(Certificate[] r100, int r101) {
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L10;
        String r104 = Base64.getEncoder().encodeToString(r100[r103].getEncoded());     // Catch: Exception -> L6
        r102.append("-----BEGIN CERTIFICATE-----\\n");     // Catch: Exception -> L6
        r102.append(r104);     // Catch: Exception -> L6
        r102.append("\\n-----END CERTIFICATE-----\\n");     // Catch: Exception -> L6
        r103 = r103 + 1;
    L6:
        e = move-exception;
        throw new CloudTransException("certChainsToPEM failed, error: " + e.getMessage());
    L10:
        return r102.toString();
    }

    private static boolean checkRotProvisionState(Context r100) {
        String r101 = FrameworkSecurityCompat.rotCheckState(r100, new Bundle());     // Catch: Exception -> L8
        LogUtils.i(TAG, "checkRotProvisionState:" + r101);     // Catch: Exception -> L8
        JSONObject r102 = new JSONObject(r101);     // Catch: Exception -> L8
        boolean r103 = JSONObjectProtectorUtils.getBoolean(r102, "dev_key_provisioned");     // Catch: Exception -> L8
        boolean r104 = JSONObjectProtectorUtils.getBoolean(r102, "dev_cert_provisioned");     // Catch: Exception -> L8
        if (r103 == false) goto L13;
        if (r104 == false) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static boolean checkVendorKmProp() {
        return TextUtils.equals(getSystemProperty("vendor.km.devcert.status"), a.VALUE_CLICK_TYPE);
    }

    public static byte[] concatenate(byte[]... r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        r101.write(r100[r103]);
        r103 = r103 + 1;
        goto L3
    L6:
        return r101.toByteArray();
    }

    public static String convertToPem(PublicKey r100) {
        if (CryptoConst.ALGORITHM_EC.equals(r100.getAlgorithm()) == false) goto L7;
        return "-----BEGIN PUBLIC KEY-----\\n" + Base64.getEncoder().encodeToString(r100.getEncoded()) + "\\n-----END PUBLIC KEY-----";
    L7:
        throw new IllegalArgumentException("不是有效的ECC公钥");
    }

    public static PublicKey getPublicKeyFromBytes(byte[] r100) {
        X509EncodedKeySpec r101 = new X509EncodedKeySpec(r100);
        return KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePublic(r101);
    }

    public static PublicKey getPublicKeyFromPEM(String r100) {
        return KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(r100.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replaceAll("\\s", ""))));
    L5:
        e = move-exception;
        throw new CloudTransException("getPublicKeyFromPEM failed, " + e.getMessage());
    }

    public static String getSystemProperty(String r100) {
        return (String) INVOKESTATIC_com_bytedance_crypto_cloudtrans_TransUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(null, new Object[]{r100, "unknown"});
    L5:
        e = move-exception;
        LogUtils.e(TAG, "Get system property failed!! error:" + e.getMessage());
        return "unknown";
    }

    public static byte[] intToByteArray(int r100) {
        ByteBuffer r101 = ByteBuffer.allocate(4);
        r101.putInt(r100);
        return r101.array();
    }

    public static boolean isBDDevice() {
        INVOKESTATIC_com_bytedance_crypto_cloudtrans_TransUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.security.secretdata.SecretDataManager");     // Catch: ClassNotFoundException -> L5
        return true;
    L5:
        INVOKESTATIC_com_bytedance_crypto_cloudtrans_TransUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.obric.security.secretdata.SecretDataManager");     // Catch: ClassNotFoundException -> L7
        return true;
    L7:
        INVOKESTATIC_com_bytedance_crypto_cloudtrans_TransUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.aiassistant.security.secretdata.SecretDataManager");     // Catch: ClassNotFoundException -> L9
        return true;
    L9:
        return false;
    }

    public static boolean isDevCertExist(Context r100) {
        if (checkVendorKmProp() == false) goto L5;
    L8:
        return true;
    L5:
        if (checkRotProvisionState(r100) == true) goto L8;
        return false;
    }

    public static void logLongString(String r100, String r101) {
        if (r101.length() <= 4000) goto L8;
        int r102 = 0;
    L6:
        if (r102 >= r101.length()) goto L10;
        int r103 = r102 + 4000;
        r101.substring(r102, Math.min(r101.length(), r103));
        r102 = r103;
        goto L6
    L10:
        return;
    }

    public static byte[] longToByteArray(long r100) {
        ByteBuffer r101 = ByteBuffer.allocate(8);
        r101.putLong(r100);
        return r101.array();
    }

    public static void printErrorInfo(String r100, String r101) {
        LogUtils.e(r100, r101);
        throw new CloudTransException(r101);
    }

    public static byte[] sha256(byte[] r100) {
        return MessageDigest.getInstance("SHA-256").digest(r100);
    }

    public static boolean verifySignature(PublicKey r100, byte[] r101, String r102) {
        Signature r103 = Signature.getInstance("SHA256withECDSA");
        r103.initVerify(r100);
        r103.update(r101);
        return r103.verify(CryptoUtils.hexStringToByteArray(r102));
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_crypto_cloudtrans_TransUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }
}
