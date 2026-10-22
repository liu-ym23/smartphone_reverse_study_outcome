package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes42.dex */
class LMS {
    static final short D_INTR = -31869;
    static final short D_LEAF = -32126;

    public LMS() {
    }

    public static LMSPrivateKeyParameters generateKeys(LMSigParameters r100, LMOtsParameters r110, int r111, byte[] r112, byte[] r113) throws IllegalArgumentException {
        if (r113 == null) goto L8;
        if (r113.length < r100.getM()) goto L8;
        return new LMSPrivateKeyParameters(r100, r110, r111, r112, 1 << r100.getH(), r113);
    L8:
        throw new IllegalArgumentException("root seed is less than " + r100.getM());
    }

    public static LMSSignature generateSign(LMSContext r100) {
        LMOtsSignature r101 = LM_OTS.lm_ots_generate_signature(r100.getPrivateKey(), r100.getQ(), r100.getC());
        return new LMSSignature(r100.getPrivateKey().getQ(), r101, r100.getSigParams(), r100.getPath());
    }

    public static LMSSignature generateSign(LMSPrivateKeyParameters r100, byte[] r101) {
        LMSContext r102 = r100.generateLMSContext();
        r102.update(r101, 0, r101.length);
        return generateSign(r102);
    }

    public static boolean verifySignature(LMSPublicKeyParameters r110, LMSContext r111) {
        LMSSignature r100 = (LMSSignature) r111.getSignature();
        LMSigParameters r101 = r100.getParameter();
        int r102 = r101.getH();
        byte[][] r103 = r100.getY();
        byte[] r112 = LM_OTS.lm_ots_validate_signature_calculate(r111);
        int r104 = (1 << r102) + r100.getQ();
        byte[] r105 = r110.getI();
        Digest r106 = DigestUtil.getDigest(r101.getDigestOID());
        int r107 = r106.getDigestSize();
        byte[] r108 = new byte[r107];
        r106.update(r105, 0, r105.length);
        LmsUtils.u32str(r104, r106);
        LmsUtils.u16str(D_LEAF, r106);
        r106.update(r112, 0, r112.length);
        r106.doFinal(r108, 0);
        int r113 = 0;
    L3:
        if (r104 <= 1) goto L10;
        if ((r104 & 1) != 1) goto L7;
        r106.update(r105, 0, r105.length);
        LmsUtils.u32str(r104 / 2, r106);
        LmsUtils.u16str(D_INTR, r106);
        byte[] r109 = r103[r113];
        r106.update(r109, 0, r109.length);
        r106.update(r108, 0, r107);
    L8:
        r106.doFinal(r108, 0);
        r104 = r104 / 2;
        r113 = r113 + 1;
        goto L3
    L7:
        r106.update(r105, 0, r105.length);
        LmsUtils.u32str(r104 / 2, r106);
        LmsUtils.u16str(D_INTR, r106);
        r106.update(r108, 0, r107);
        byte[] r114 = r103[r113];
        r106.update(r114, 0, r114.length);
        goto L8
    L10:
        return r110.matchesT1(r108);
    }

    public static boolean verifySignature(LMSPublicKeyParameters r100, LMSSignature r101, byte[] r102) {
        LMSContext r103 = r100.generateOtsContext(r101);
        LmsUtils.byteArray(r102, r103);
        return verifySignature(r100, r103);
    }

    public static boolean verifySignature(LMSPublicKeyParameters r100, byte[] r101, byte[] r102) {
        LMSContext r103 = r100.generateLMSContext(r101);
        LmsUtils.byteArray(r102, r103);
        return verifySignature(r100, r103);
    }
}
