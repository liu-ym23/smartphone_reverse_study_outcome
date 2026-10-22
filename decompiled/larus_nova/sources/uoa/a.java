package uoa;

import com.byted.cast.linkcommon.security.SecurityUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes34.dex */
public final class a {
    public static byte[] a(byte[] r100, b r101) throws Exception {
        Cipher r102 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);
        byte[] r103 = new byte[12];
        new SecureRandom().nextBytes(r103);
        r102.init(1, r101.f550961b, new GCMParameterSpec(128, r103));
        byte[] r104 = r102.doFinal(r100);
        ByteBuffer r105 = ByteBuffer.allocate(r104.length + 22);
        r105.put(d.f550964e);
        r105.order(ByteOrder.LITTLE_ENDIAN).putLong(r101.f550960a);
        r105.put(r103);
        r105.put(r104);
        return r105.array();
    }
}
