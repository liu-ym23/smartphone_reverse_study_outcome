package org.bouncycastle.pqc.crypto.lms;

import java.util.Arrays;
import java.util.List;
import org.bouncycastle.pqc.crypto.ExhaustedPrivateKeyException;

/* JADX INFO: loaded from: classes42.dex */
class HSS {

    public static class PlaceholderLMSPrivateKey extends LMSPrivateKeyParameters {
        public PlaceholderLMSPrivateKey(LMSigParameters r100, LMOtsParameters r101, int r102, byte[] r103, int r104, byte[] r105) {
            super(r100, r101, r102, r103, r104, r105);
        }

        @Override // org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters
        public LMOtsPrivateKey getNextOtsPrivateKey() {
            throw new RuntimeException("placeholder only");
        }

        @Override // org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters
        public LMSPublicKeyParameters getPublicKey() {
            throw new RuntimeException("placeholder only");
        }
    }

    public HSS() {
    }

    public static HSSPrivateKeyParameters generateHSSKeyPair(HSSKeyGenerationParameters r210) {
        int r100 = r210.getDepth();
        LMSPrivateKeyParameters[] r101 = new LMSPrivateKeyParameters[r100];
        LMSSignature[] r102 = new LMSSignature[r210.getDepth() - 1];
        byte[] r103 = new byte[32];
        r210.getRandom().nextBytes(r103);
        byte[] r110 = new byte[16];
        r210.getRandom().nextBytes(r110);
        byte[] r111 = new byte[0];
        long r211 = 1;
        int r112 = 0;
    L3:
        if (r112 >= r100) goto L9;
        if (r112 != 0) goto L6;
        r101[r112] = new LMSPrivateKeyParameters(r210.getLmsParameters()[r112].getLMSigParam(), r210.getLmsParameters()[r112].getLMOTSParam(), 0, r110, 1 << r210.getLmsParameters()[r112].getLMSigParam().getH(), r103);
        int r104 = r112;
        byte[] r105 = r111;
    L7:
        r211 = r211 * ((long) (1 << r210.getLmsParameters()[r104].getLMSigParam().getH()));
        r112 = r104 + 1;
        r111 = r105;
        goto L3
    L6:
        r104 = r112;
        r105 = r111;
        r101[r104] = new PlaceholderLMSPrivateKey(r210.getLmsParameters()[r112].getLMSigParam(), r210.getLmsParameters()[r112].getLMOTSParam(), -1, r105, 1 << r210.getLmsParameters()[r112].getLMSigParam().getH(), r105);
        goto L7
    L9:
        if (r211 != 0) goto L12;
        r211 = Long.MAX_VALUE;
    L12:
        return new HSSPrivateKeyParameters(r210.getDepth(), Arrays.asList(r101), Arrays.asList(r102), 0, r211);
    }

    public static HSSSignature generateSignature(int r100, LMSContext r101) {
        return new HSSSignature(r100 - 1, r101.getSignedPubKeys(), LMS.generateSign(r101));
    }

    public static HSSSignature generateSignature(HSSPrivateKeyParameters r110, byte[] r111) {
        int r100 = r110.getL();
        monitor-enter(r110);
        rangeTestKeys(r110);     // Catch: Throwable -> L11
        List<LMSPrivateKeyParameters> r101 = r110.getKeys();     // Catch: Throwable -> L11
        List<LMSSignature> r102 = r110.getSig();     // Catch: Throwable -> L11
        int r103 = r100 - 1;     // Catch: Throwable -> L11
        LMSPrivateKeyParameters r104 = r110.getKeys().get(r103);     // Catch: Throwable -> L11
        LMSSignedPubKey[] r105 = new LMSSignedPubKey[r103];     // Catch: Throwable -> L11
        int r106 = 0;
    L5:
        if (r106 >= r103) goto L7;
        int r112 = r106 + 1;     // Catch: Throwable -> L11
        r105[r106] = new LMSSignedPubKey(r102.get(r106), r101.get(r112).getPublicKey());     // Catch: Throwable -> L11
        r106 = r112;
        goto L5
    L7:
        r110.incIndex();     // Catch: Throwable -> L11
        monitor-exit(r110);     // Catch: Throwable -> L11
        LMSContext r113 = r104.generateLMSContext().withSignedPublicKeys(r105);
        r113.update(r111, 0, r111.length);
        return generateSignature(r100, r113);
    L11:
        th = move-exception;
        throw th;
    }

    public static void incrementIndex(HSSPrivateKeyParameters r100) {
        monitor-enter(r100);
        rangeTestKeys(r100);     // Catch: Throwable -> L6
        r100.incIndex();     // Catch: Throwable -> L6
        r100.getKeys().get(r100.getL() - 1).incIndex();     // Catch: Throwable -> L6
        monitor-exit(r100);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static void rangeTestKeys(HSSPrivateKeyParameters r100) {
        monitor-enter(r100);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (r100.getIndex() < r100.getIndexLimit()) goto L12;
        StringBuilder r101 = new StringBuilder("hss private key");     // Catch: Throwable -> L27
        if (r100.isShard() == false) goto L9;
        String r102 = " shard";
    L10:
        r101.append(r102);     // Catch: Throwable -> L27
        r101.append(" is exhausted");     // Catch: Throwable -> L27
        throw new ExhaustedPrivateKeyException(r101.toString());     // Catch: Throwable -> L27
    L9:
        r102 = "";
        goto L10
    L12:
        int r103 = r100.getL();     // Catch: Throwable -> L27
        List<LMSPrivateKeyParameters> r104 = r100.getKeys();     // Catch: Throwable -> L27
        int r105 = r103;
    L13:
        int r106 = r105 - 1;     // Catch: Throwable -> L27
        if (r104.get(r106).getIndex() != (1 << r104.get(r106).getSigParameters().getH())) goto L23;
        if (r106 == 0) goto L16;
        r105 = r106;
        goto L13
    L16:
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L27
        r107.append("hss private key");     // Catch: Throwable -> L27
        if (r100.isShard() == false) goto L19;
        String r108 = " shard";
    L20:
        r107.append(r108);     // Catch: Throwable -> L27
        r107.append(" is exhausted the maximum limit for this HSS private key");     // Catch: Throwable -> L27
        throw new ExhaustedPrivateKeyException(r107.toString());     // Catch: Throwable -> L27
    L19:
        r108 = "";
    L23:
        if (r105 >= r103) goto L25;
        r100.replaceConsumedKey(r105);     // Catch: Throwable -> L27
        r105 = r105 + 1;     // Catch: Throwable -> L27
        goto L23
    L25:
        monitor-exit(r100);     // Catch: Throwable -> L27
    }

    public static boolean verifySignature(HSSPublicKeyParameters r100, HSSSignature r101, byte[] r102) {
        int r103 = r101.getlMinus1();
        int r104 = r103 + 1;
        if (r104 == r100.getL()) goto L5;
        return false;
    L5:
        LMSSignature[] r105 = new LMSSignature[r104];
        LMSPublicKeyParameters[] r106 = new LMSPublicKeyParameters[r103];
        int r107 = 0;
    L6:
        if (r107 >= r103) goto L8;
        r105[r107] = r101.getSignedPubKey()[r107].getSignature();
        r106[r107] = r101.getSignedPubKey()[r107].getPublicKey();
        r107 = r107 + 1;
        goto L6
    L8:
        r105[r103] = r101.getSignature();
        LMSPublicKeyParameters r108 = r100.getLMSPublicKey();
        int r109 = 0;
    L9:
        if (r109 >= r103) goto L19;
        if (LMS.verifySignature(r108, r105[r109], r106[r109].toByteArray()) == false) goto L12;
        r108 = r106[r109];     // Catch: Exception -> L15
        r109 = r109 + 1;
    L15:
        e = move-exception;
        throw new IllegalStateException(e.getMessage(), e);
    L12:
        return false;
    L19:
        return LMS.verifySignature(r108, r105[r103], r102);
    }
}
