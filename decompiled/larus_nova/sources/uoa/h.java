package uoa;

import com.google.crypto.tink.proto.EllipticCurveType;
import java.security.GeneralSecurityException;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes34.dex */
public final class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f550975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f550976b;

    public h() throws Exception {
        byte[] r100 = new byte[32];
        com.google.crypto.tink.internal.e.f275756a.get().nextBytes(r100);
        r100[0] = (byte) (r100[0] | 7);
        byte r101 = (byte) (r100[31] & 63);
        r100[31] = r101;
        r100[31] = (byte) (r101 | ByteCompanionObject.MIN_VALUE);
        this.f550975a = r100;
        byte[] r102 = new byte[32];
        r102[0] = 9;
        this.f550976b = lv7.e.a(r100, r102);
    }

    @Override // uoa.e
    public final byte[] a() {
        return this.f550976b;
    }

    @Override // uoa.e
    public final EllipticCurveType c() {
        return EllipticCurveType.CURVE25519;
    }

    @Override // uoa.e
    public final byte[] b(byte[] r100) throws GeneralSecurityException {
        if (r100.length != 0) goto L7;
        return new byte[0];
    L7:
        return lv7.e.a(this.f550975a, r100);
    }
}
