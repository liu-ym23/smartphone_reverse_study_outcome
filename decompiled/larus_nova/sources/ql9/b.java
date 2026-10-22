package ql9;

import android.util.Base64;
import com.alipay.sdk.m.n.d;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f533825a = 0;

    static {
    }

    public static byte[] b(byte[] r100) throws Exception {
        Intrinsics.checkNotNullParameter(r100, "dataByteArray");
        X509EncodedKeySpec r101 = new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrp4sMcJjY9hb2J3sHWlwIEBrJlw2Cimv+rZAQmR8V3EI+0PUK14pL8OcG7CY79li30IHwYGWwUapADKA01nKgNeq7+rSciMYZv6ByVq+ocxKY8az78HwIppwxKWpQ+ziqYavvfE5+iHIzAc8RvGj9lL6xx1zhoPkdaA0agAyuMQIDAQAB", 0));
        PublicKey r102 = KeyFactory.getInstance(d.f25615a).generatePublic(r101);
        Cipher r103 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r103.init(1, r102);
        int r104 = r100.length;
        ByteArrayOutputStream r105 = new ByteArrayOutputStream();
        int r106 = 0;
        int r107 = 0;
    L3:
        int r108 = r104 - r106;
        if (r108 <= 0) goto L10;
        if (r108 <= 117) goto L8;
        byte[] r109 = r103.doFinal(r100, r106, 117);
    L9:
        Intrinsics.checkNotNull(r109);
        r105.write(r109, 0, r109.length);
        r107 = r107 + 1;
        r106 = r107 * 117;
        goto L3
    L8:
        r109 = r103.doFinal(r100, r106, r108);
        goto L9
    L10:
        byte[] r110 = r105.toByteArray();
        r105.close();
        Intrinsics.checkNotNull(r110);
        return r110;
    }

    public static byte[] a(byte[] r100, String r101) throws Exception {
        Intrinsics.checkNotNullParameter(r100, "encryptedDataArray");
        PKCS8EncodedKeySpec r102 = new PKCS8EncodedKeySpec(Base64.decode(r101, 0));
        PrivateKey r103 = KeyFactory.getInstance(d.f25615a).generatePrivate(r102);
        Cipher r104 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r104.init(2, r103);
        int r105 = r100.length;
        ByteArrayOutputStream r106 = new ByteArrayOutputStream();
        int r107 = 0;
        int r108 = 0;
    L3:
        int r109 = r105 - r107;
        if (r109 <= 0) goto L10;
        if (r109 <= 128) goto L8;
        byte[] r110 = r104.doFinal(r100, r107, 128);
    L9:
        Intrinsics.checkNotNull(r110);
        r106.write(r110, 0, r110.length);
        r108 = r108 + 1;
        r107 = r108 * 128;
        goto L3
    L8:
        r110 = r104.doFinal(r100, r107, r109);
        goto L9
    L10:
        byte[] r111 = r106.toByteArray();
        r106.close();
        Intrinsics.checkNotNull(r111);
        return r111;
    }
}
