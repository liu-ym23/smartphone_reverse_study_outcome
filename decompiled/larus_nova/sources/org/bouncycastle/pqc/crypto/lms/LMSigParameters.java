package org.bouncycastle.pqc.crypto.lms;

import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;

/* JADX INFO: loaded from: classes42.dex */
public class LMSigParameters {
    public static final LMSigParameters lms_sha256_n32_h10 = null;
    public static final LMSigParameters lms_sha256_n32_h15 = null;
    public static final LMSigParameters lms_sha256_n32_h20 = null;
    public static final LMSigParameters lms_sha256_n32_h25 = null;
    public static final LMSigParameters lms_sha256_n32_h5 = null;
    private static Map<Object, LMSigParameters> paramBuilders;
    private final ASN1ObjectIdentifier digestOid;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f525536h;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f525537m;
    private final int type;

    static {
        ASN1ObjectIdentifier r100 = NISTObjectIdentifiers.id_sha256;
        lms_sha256_n32_h5 = new LMSigParameters(5, 32, 5, r100);
        lms_sha256_n32_h10 = new LMSigParameters(6, 32, 10, r100);
        lms_sha256_n32_h15 = new LMSigParameters(7, 32, 15, r100);
        lms_sha256_n32_h20 = new LMSigParameters(8, 32, 20, r100);
        lms_sha256_n32_h25 = new LMSigParameters(9, 32, 25, r100);
        paramBuilders = new AnonymousClass1();
    }

    public LMSigParameters(int r100, int r101, int r102, ASN1ObjectIdentifier r103) {
        this.type = r100;
        this.f525537m = r101;
        this.f525536h = r102;
        this.digestOid = r103;
    }

    public static /* synthetic */ int access$000(LMSigParameters r100) {
        return r100.type;
    }

    public static LMSigParameters getParametersForType(int r100) {
        return paramBuilders.get(Integer.valueOf(r100));
    }

    public ASN1ObjectIdentifier getDigestOID() {
        return this.digestOid;
    }

    public int getH() {
        return this.f525536h;
    }

    public int getM() {
        return this.f525537m;
    }

    public int getType() {
        return this.type;
    }
}
