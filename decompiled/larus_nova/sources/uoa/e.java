package uoa;

import com.google.crypto.tink.proto.EllipticCurveType;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes34.dex */
public interface e {
    byte[] a();

    byte[] b(byte[] r100) throws GeneralSecurityException;

    EllipticCurveType c();
}
