package n4a;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes32.dex */
public final class v0 extends b1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f0 f517816c;

    public v0(a1 r100) {
        super(r100);
        this.f517816c = new f0();
    }

    @Override // n4a.b1
    public final byte[] b(byte[] r100) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return this.f517816c.b(r100);
    }
}
