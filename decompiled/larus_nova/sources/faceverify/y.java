package faceverify;

import com.dtf.toyger.base.blob.RSAEncrypt;
import java.security.interfaces.RSAPublicKey;

/* JADX INFO: loaded from: classes41.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f476186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f476187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RSAPublicKey f476188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f476189d;

    static {
        ytc.a.b();
    }

    public static native String b(byte[] r100);

    public final native byte[] a(int r100);

    public native byte[] a(byte[] r100);

    public y(String r100, boolean r101) {
        this.f476189d = true;
        this.f476188c = RSAEncrypt.loadPublicKeyByStr(r100);     // Catch: Exception -> L5
        byte[] r102 = a(16);     // Catch: Exception -> L5
        this.f476186a = r102;     // Catch: Exception -> L5
        this.f476187b = RSAEncrypt.encrypt(this.f476188c, r102);     // Catch: Exception -> L5
        this.f476189d = r101;     // Catch: Exception -> L5
        return;
    L6:
        throw new IllegalArgumentException("fail to init crypto manager");
    }
}
