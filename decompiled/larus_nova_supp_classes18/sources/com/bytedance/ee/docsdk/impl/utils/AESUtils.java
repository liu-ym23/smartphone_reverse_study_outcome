package com.bytedance.ee.docsdk.impl.utils;

import android.util.Base64;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.ss.android.lark.chameleon.idependency.Log;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/AESUtils;", "", "()V", "Companion", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AESUtils {
    private static final String AES = "AES";
    private static final String AES_CBC_PKCS5_PADDING = "AES/CBC/PKCS5Padding";
    public static final String AES_ECB_PKCS5_PADDING = "AES/ECB/PKCS5Padding";
    private static final String AES_GCM_NOPADDING = "AES/GCM/NoPadding";
    public static final String CHARSET = "UTF-8";
    public static final Companion Companion = null;
    private static final String PBKDF2_WITH_HMAC_SHA1 = "PBKDF2WithHmacSHA1";
    public static final int SECRET_KEY_LENGTH = 16;
    private static final String TAG = "AESUtils";

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001c\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u001a\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u001a\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/AESUtils$Companion;", "", "()V", AESUtils.AES, "", "AES_CBC_PKCS5_PADDING", "AES_ECB_PKCS5_PADDING", "AES_GCM_NOPADDING", "CHARSET", "PBKDF2_WITH_HMAC_SHA1", "SECRET_KEY_LENGTH", "", "TAG", "Base64DecodeAndDecrypt", "cipherText", "secretKey", "Ljavax/crypto/SecretKey;", "clearPassphrase", "", "pwd", "", "decrypt", "cipherBytes", "", "encrypt", "plaintext", "encryptAndBase64Encode", "getKey", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final void clearPassphrase(char[] r4) {
            int r0 = r4.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L5;
            r4[r2] = 0;
            r2 = r2 + 1;
            goto L3
        }

        @JvmStatic
        public final SecretKey getKey(char[] r8) {
            Intrinsics.checkNotNullParameter(r8, "pwd");
            byte[] r3 = new byte[32];
            int r4 = 0;
        L3:
            if (r4 >= 32) goto L5;
            r3[r4] = (byte) ((r4 << 3) & (r4 << 1));
            r4 = r4 + 1;
            goto L3
        L5:
            PBEKeySpec r2 = new PBEKeySpec(r8, r3, CCMLynxCardView.ViewType.BANNER, 256);
            clearPassphrase(r8);
        L8:
            return new SecretKeySpec(SecretKeyFactory.getInstance(AESUtils.PBKDF2_WITH_HMAC_SHA1).generateSecret(r2).getEncoded(), AESUtils.AES);
        L12:
            e = move-exception;
            Log.e(AESUtils.TAG, "getKey error ", e);
            return null;
        L9:
            e = move-exception;
            Log.e(AESUtils.TAG, "getKey error ", e);
            return null;
        }

        @JvmStatic
        public final String Base64DecodeAndDecrypt(String r2, SecretKey r3) {
            return decrypt(Base64.decode(r2, 0), r3);
        }

        @JvmStatic
        public final String decrypt(byte[] r4, SecretKey r5) {
            Cipher r0 = Cipher.getInstance(AESUtils.AES_CBC_PKCS5_PADDING);     // Catch: Exception -> L4
            r0.init(2, r5, new IvParameterSpec(new byte[r0.getBlockSize()]));     // Catch: Exception -> L4
            return new String(r0.doFinal(r4), StandardCharsets.UTF_8);
        L4:
            e = move-exception;
            Log.e(AESUtils.TAG, "decrypt error ", e);
            return "";
        }

        @JvmStatic
        public final byte[] encrypt(String r4, SecretKey r5) {
            Intrinsics.checkNotNullParameter(r4, "plaintext");
            Cipher r0 = Cipher.getInstance(AESUtils.AES_CBC_PKCS5_PADDING);     // Catch: Exception -> L5
            r0.init(1, r5, new IvParameterSpec(new byte[r0.getBlockSize()]));     // Catch: Exception -> L5
            return r0.doFinal(r4.getBytes(StandardCharsets.UTF_8));
        L5:
            e = move-exception;
            Log.e(AESUtils.TAG, "encrypt error ", e);
            return new byte[0];
        }

        @JvmStatic
        public final String encryptAndBase64Encode(String r2, SecretKey r3) {
            Intrinsics.checkNotNullParameter(r2, "plaintext");
            return Base64.encodeToString(encrypt(r2, r3), 0);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final String Base64DecodeAndDecrypt(String r1, SecretKey r2) {
        return Companion.Base64DecodeAndDecrypt(r1, r2);
    }

    @JvmStatic
    public static final String decrypt(byte[] r1, SecretKey r2) {
        return Companion.decrypt(r1, r2);
    }

    @JvmStatic
    public static final byte[] encrypt(String r1, SecretKey r2) {
        return Companion.encrypt(r1, r2);
    }

    @JvmStatic
    public static final String encryptAndBase64Encode(String r1, SecretKey r2) {
        return Companion.encryptAndBase64Encode(r1, r2);
    }

    @JvmStatic
    public static final SecretKey getKey(char[] r1) {
        return Companion.getKey(r1);
    }

    private AESUtils() {
        throw new UnsupportedOperationException("u can't instantiate me");
    }
}
