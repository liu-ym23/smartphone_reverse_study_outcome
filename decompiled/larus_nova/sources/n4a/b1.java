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
public abstract class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b1 f517163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f517164b;

    public b1() {
        this.f517164b = null;
    }

    public b1(b1 r100) {
        this.f517164b = null;
        this.f517163a = r100;
    }

    public final byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] r100 = b(this.f517164b);
        b1 r101 = this.f517163a;
        if (r101 == null) goto L6;
        r101.f517164b = r100;
        return r101.a();
    L6:
        return r100;
    }

    public abstract byte[] b(byte[] r100) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public void c(byte[] r100) {
    }
}
