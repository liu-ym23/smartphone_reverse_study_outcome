package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
class LM_OTS {
    static final short D_MESG = -32383;
    private static final short D_PBLC = -32640;
    private static final int ITER_J = 22;
    private static final int ITER_K = 20;
    private static final int ITER_PREV = 23;
    static final int MAX_HASH = 32;
    static final int SEED_LEN = 32;
    static final int SEED_RANDOMISER_INDEX = -3;

    public LM_OTS() {
    }

    public static int cksm(byte[] r100, int r101, LMOtsParameters r102) {
        int r103 = (1 << r102.getW()) - 1;
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r104 >= ((r101 * 8) / r102.getW())) goto L7;
        r105 = (r105 + r103) - coef(r100, r104, r102.getW());
        r104 = r104 + 1;
        goto L4
    L7:
        return r105 << r102.getLs();
    }

    public static int coef(byte[] r100, int r101, int r102) {
        int r103 = (r101 * r102) / 8;
        int r104 = ((~r101) & ((8 / r102) - 1)) * r102;
        int r105 = r100[r103] >>> r104;
        return r105 & ((1 << r102) - 1);
    }

    public static LMOtsSignature lm_ots_generate_signature(LMOtsPrivateKey r110, byte[] r111, byte[] r112) {
        LMOtsParameters r100 = r110.getParameter();
        int r101 = r100.getN();
        int r102 = r100.getP();
        int r103 = r100.getW();
        byte[] r104 = new byte[r102 * r101];
        Digest r105 = DigestUtil.getDigest(r100.getDigestOID());
        SeedDerive r106 = r110.getDerivationFunction();
        int r107 = cksm(r111, r101, r100);
        r111[r101] = (byte) ((r107 >>> 8) & 255);
        r111[r101 + 1] = (byte) r107;
        int r108 = r101 + 23;
        byte[] r109 = Composer.compose().bytes(r110.getI()).u32str(r110.getQ()).padUntil(0, r108).build();
        r106.setJ(0);
        int r113 = 0;
    L3:
        if (r113 >= r102) goto L13;
        Pack.shortToBigEndian((short) r113, r109, 20);
        if (r113 >= (r102 - 1)) goto L7;
        boolean r114 = true;
    L8:
        int r115 = 23;
        r106.deriveSeed(r109, r114, 23);
        int r116 = coef(r111, r113, r103);
        int r117 = 0;
    L9:
        if (r117 >= r116) goto L11;
        r109[22] = (byte) r117;
        r105.update(r109, 0, r108);
        r115 = 23;
        r105.doFinal(r109, 23);
        r117 = r117 + 1;
        goto L9
    L11:
        System.arraycopy(r109, r115, r104, r101 * r113, r101);
        r113 = r113 + 1;
        goto L3
    L7:
        r114 = false;
        goto L8
    L13:
        return new LMOtsSignature(r100, r112, r104);
    }

    public static LMOtsSignature lm_ots_generate_signature(LMSigParameters r100, LMOtsPrivateKey r101, byte[][] r102, byte[] r103, boolean r104) {
        byte[] r105 = new byte[34];
        if (r104 == true) goto L5;
        LMSContext r106 = r101.getSignatureContext(r100, r102);
        LmsUtils.byteArray(r103, 0, r103.length, r106);
        byte[] r107 = r106.getC();
        r105 = r106.getQ();
    L7:
        return lm_ots_generate_signature(r101, r105, r107);
    L5:
        r107 = new byte[32];
        System.arraycopy(r103, 0, r105, 0, r101.getParameter().getN());
        goto L7
    }

    public static boolean lm_ots_validate_signature(LMOtsPublicKey r100, LMOtsSignature r101, byte[] r102, boolean r103) throws LMSException {
        if (r101.getType().equals(r100.getParameter()) == false) goto L7;
        return Arrays.areEqual(lm_ots_validate_signature_calculate(r100, r101, r102), r100.getK());
    L7:
        throw new LMSException("public key and signature ots types do not match");
    }

    public static byte[] lm_ots_validate_signature_calculate(LMOtsPublicKey r100, LMOtsSignature r101, byte[] r102) {
        LMSContext r103 = r100.createOtsContext(r101);
        LmsUtils.byteArray(r102, r103);
        return lm_ots_validate_signature_calculate(r103);
    }

    public static byte[] lm_ots_validate_signature_calculate(LMSContext r110) {
        LMOtsPublicKey r100 = r110.getPublicKey();
        LMOtsParameters r101 = r100.getParameter();
        Object r102 = r110.getSignature();
        if ((r102 instanceof LMSSignature) == false) goto L5;
        LMOtsSignature r103 = ((LMSSignature) r102).getOtsSignature();
    L6:
        int r104 = r101.getN();
        int r105 = r101.getW();
        int r106 = r101.getP();
        byte[] r111 = r110.getQ();
        int r107 = cksm(r111, r104, r101);
        r111[r104] = (byte) ((r107 >>> 8) & 255);
        r111[r104 + 1] = (byte) r107;
        byte[] r108 = r100.getI();
        int r109 = r100.getQ();
        Digest r112 = DigestUtil.getDigest(r101.getDigestOID());
        LmsUtils.byteArray(r108, r112);
        LmsUtils.u32str(r109, r112);
        LmsUtils.u16str(D_PBLC, r112);
        Composer r113 = Composer.compose().bytes(r108).u32str(r109);
        int r114 = r104 + 23;
        byte[] r115 = r113.padUntil(0, r114).build();
        int r116 = (1 << r105) - 1;
        byte[] r117 = r103.getY();
        Digest r118 = DigestUtil.getDigest(r101.getDigestOID());
        int r119 = 0;
    L7:
        if (r119 >= r106) goto L12;
        Pack.shortToBigEndian((short) r119, r115, 20);
        System.arraycopy(r117, r119 * r104, r115, 23, r104);
        int r120 = coef(r111, r119, r105);
    L9:
        if (r120 >= r116) goto L11;
        r115[22] = (byte) r120;
        r118.update(r115, 0, r114);
        r118.doFinal(r115, 23);
        r120 = r120 + 1;
        goto L9
    L11:
        r112.update(r115, 23, r104);
        r119 = r119 + 1;
        goto L7
    L12:
        byte[] r121 = new byte[r104];
        r112.doFinal(r121, 0);
        return r121;
    L5:
        r103 = (LMOtsSignature) r102;
        goto L6
    }

    public static LMOtsPublicKey lms_ots_generatePublicKey(LMOtsPrivateKey r100) {
        byte[] r101 = lms_ots_generatePublicKey(r100.getParameter(), r100.getI(), r100.getQ(), r100.getMasterSecret());
        return new LMOtsPublicKey(r100.getParameter(), r100.getI(), r100.getQ(), r101);
    }

    public static byte[] lms_ots_generatePublicKey(LMOtsParameters r110, byte[] r111, int r112, byte[] r113) {
        Digest r100 = DigestUtil.getDigest(r110.getDigestOID());
        byte[] r101 = Composer.compose().bytes(r111).u32str(r112).u16str(-32640).padUntil(0, 22).build();
        r100.update(r101, 0, r101.length);
        Digest r102 = DigestUtil.getDigest(r110.getDigestOID());
        byte[] r103 = Composer.compose().bytes(r111).u32str(r112).padUntil(0, r102.getDigestSize() + 23).build();
        SeedDerive r104 = new SeedDerive(r111, r113, DigestUtil.getDigest(r110.getDigestOID()));
        r104.setQ(r112);
        r104.setJ(0);
        int r114 = r110.getP();
        int r115 = r110.getN();
        int r116 = (1 << r110.getW()) - 1;
        int r105 = 0;
    L3:
        if (r105 >= r114) goto L12;
        if (r105 >= (r114 - 1)) goto L7;
        boolean r106 = true;
    L8:
        r104.deriveSeed(r103, r106, 23);
        Pack.shortToBigEndian((short) r105, r103, 20);
        int r107 = 0;
    L9:
        if (r107 >= r116) goto L11;
        r103[22] = (byte) r107;
        r102.update(r103, 0, r103.length);
        r102.doFinal(r103, 23);
        r107 = r107 + 1;
        goto L9
    L11:
        r100.update(r103, 23, r115);
        r105 = r105 + 1;
        goto L3
    L7:
        r106 = false;
        goto L8
    L12:
        byte[] r117 = new byte[r100.getDigestSize()];
        r100.doFinal(r117, 0);
        return r117;
    }
}
