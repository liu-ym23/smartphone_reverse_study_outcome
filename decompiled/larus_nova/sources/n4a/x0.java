package n4a;

import android.text.TextUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes32.dex */
public final class x0 extends b1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f517884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d0 f517885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object[] f517886e;

    public x0(c1 r100, c0 r101, String r102, Object... r103) {
        super(r100);
        this.f517884c = r102;
        this.f517885d = r101;
        this.f517886e = r103;
    }

    @Override // n4a.b1
    public final byte[] b(byte[] r100) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String r101 = f5.d(r100);
        if (TextUtils.isEmpty(r101) == false) goto L12;
        return null;
    L12:
        String r102 = String.format(f5.o(this.f517884c), this.f517886e);     // Catch: Throwable -> L8
    L11:
        return f5.j("{\"pinfo\":\"" + f5.d(this.f517885d.b(f5.j(r102))) + "\",\"els\":[" + r101 + "]}");
    L8:
        th = move-exception;
        th.printStackTrace();
        r.f(th, "ofm", "gpj");
        r102 = "";
        goto L11
    }
}
