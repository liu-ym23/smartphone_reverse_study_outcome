package org.bouncycastle.pqc.crypto.xmss;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
final class WOTSPlus {
    private final KeyedHashFunctions khf;
    private final WOTSPlusParameters params;
    private byte[] publicSeed;
    private byte[] secretKeySeed;

    public WOTSPlus(WOTSPlusParameters r100) {
        if (r100 == null) goto L7;
        this.params = r100;
        int r101 = r100.getTreeDigestSize();
        this.khf = new KeyedHashFunctions(r100.getTreeDigest(), r101);
        this.secretKeySeed = new byte[r101];
        this.publicSeed = new byte[r101];
        return;
    L7:
        throw new NullPointerException("params == null");
    }

    private byte[] chain(byte[] r100, int r101, int r102, OTSHashAddress r110) {
        int r103 = this.params.getTreeDigestSize();
        if (r100 == null) goto L27;
        if (r100.length != r103) goto L25;
        if (r110 == null) goto L23;
        if (r110.toByteArray() == null) goto L21;
        int r104 = r101 + r102;
        if (r104 > (this.params.getWinternitzParameter() - 1)) goto L19;
        if (r102 != 0) goto L13;
        return r100;
    L13:
        byte[] r105 = chain(r100, r101, r102 - 1, r110);
        int r106 = 0;
        OTSHashAddress r107 = (OTSHashAddress) new OTSHashAddress.Builder().withLayerAddress(r110.getLayerAddress()).withTreeAddress(r110.getTreeAddress()).withOTSAddress(r110.getOTSAddress()).withChainAddress(r110.getChainAddress()).withHashAddress(r104 - 1).withKeyAndMask(0).build();
        byte[] r111 = this.khf.PRF(this.publicSeed, r107.toByteArray());
        byte[] r108 = this.khf.PRF(this.publicSeed, ((OTSHashAddress) new OTSHashAddress.Builder().withLayerAddress(r107.getLayerAddress()).withTreeAddress(r107.getTreeAddress()).withOTSAddress(r107.getOTSAddress()).withChainAddress(r107.getChainAddress()).withHashAddress(r107.getHashAddress()).withKeyAndMask(1).build()).toByteArray());
        byte[] r109 = new byte[r103];
    L14:
        if (r106 >= r103) goto L17;
        r109[r106] = (byte) (r105[r106] ^ r108[r106]);
        r106 = r106 + 1;
        goto L14
    L17:
        return this.khf.F(r111, r109);
    L19:
        throw new IllegalArgumentException("max chain length must not be greater than w");
    L21:
        throw new NullPointerException("otsHashAddress byte array == null");
    L23:
        throw new NullPointerException("otsHashAddress == null");
    L25:
        throw new IllegalArgumentException("startHash needs to be " + r103 + HTTP.CONTENT_RANGE_BYTES);
    L27:
        throw new NullPointerException("startHash == null");
    }

    private List<Integer> convertToBaseW(byte[] r100, int r101, int r102) {
        if (r100 == null) goto L26;
        if (r101 != 4) goto L6;
    L10:
        int r103 = XMSSUtil.log2(r101);
        if (r102 > ((r100.length * 8) / r103)) goto L24;
        ArrayList r104 = new ArrayList();
        int r105 = 0;
    L14:
        if (r105 >= r100.length) goto L22;
        int r106 = 8 - r103;
    L16:
        if (r106 < 0) goto L21;
        r104.add(Integer.valueOf((r100[r105] >> r106) & (r101 - 1)));
        if (r104.size() == r102) goto L19;
        r106 = r106 - r103;
        goto L16
    L19:
        return r104;
    L21:
        r105 = r105 + 1;
        goto L14
    L22:
        return r104;
    L24:
        throw new IllegalArgumentException("outLength too big");
    L6:
        if (r101 == 16) goto L10;
        throw new IllegalArgumentException("w needs to be 4 or 16");
    L26:
        throw new NullPointerException("msg == null");
    }

    private byte[] expandSecretKeySeed(int r100) {
        if (r100 < 0) goto L8;
        if (r100 >= this.params.getLen()) goto L8;
        return this.khf.PRF(this.secretKeySeed, XMSSUtil.toBytesBigEndian(r100, 32));
    L8:
        throw new IllegalArgumentException("index out of bounds");
    }

    public KeyedHashFunctions getKhf() {
        return this.khf;
    }

    public WOTSPlusParameters getParams() {
        return this.params;
    }

    public WOTSPlusPrivateKeyParameters getPrivateKey() {
        int r100 = this.params.getLen();
        byte[][] r101 = new byte[r100][];
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L6;
        r101[r102] = expandSecretKeySeed(r102);
        r102 = r102 + 1;
        goto L3
    L6:
        return new WOTSPlusPrivateKeyParameters(this.params, r101);
    }

    public WOTSPlusPublicKeyParameters getPublicKey(OTSHashAddress r100) {
        if (r100 == null) goto L10;
        byte[][] r101 = new byte[this.params.getLen()][];
        int r102 = 0;
    L5:
        if (r102 >= this.params.getLen()) goto L8;
        r100 = (OTSHashAddress) new OTSHashAddress.Builder().withLayerAddress(r100.getLayerAddress()).withTreeAddress(r100.getTreeAddress()).withOTSAddress(r100.getOTSAddress()).withChainAddress(r102).withHashAddress(r100.getHashAddress()).withKeyAndMask(r100.getKeyAndMask()).build();
        r101[r102] = chain(expandSecretKeySeed(r102), 0, this.params.getWinternitzParameter() - 1, r100);
        r102 = r102 + 1;
        goto L5
    L8:
        return new WOTSPlusPublicKeyParameters(this.params, r101);
    L10:
        throw new NullPointerException("otsHashAddress == null");
    }

    public WOTSPlusPublicKeyParameters getPublicKeyFromSignature(byte[] r100, WOTSPlusSignature r101, OTSHashAddress r102) {
        if (r100 == null) goto L24;
        if (r100.length != this.params.getTreeDigestSize()) goto L22;
        if (r101 == null) goto L20;
        if (r102 == null) goto L18;
        List<Integer> r103 = convertToBaseW(r100, this.params.getWinternitzParameter(), this.params.getLen1());
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L9:
        if (r105 >= this.params.getLen1()) goto L11;
        r106 = r106 + ((this.params.getWinternitzParameter() - 1) - ((Integer) ListProtector.get(r103, r105)).intValue());
        r105 = r105 + 1;
        goto L9
    L11:
        r103.addAll(convertToBaseW(XMSSUtil.toBytesBigEndian(r106 << (8 - ((this.params.getLen2() * XMSSUtil.log2(this.params.getWinternitzParameter())) % 8)), (int) Math.ceil(((double) (this.params.getLen2() * XMSSUtil.log2(this.params.getWinternitzParameter()))) / 8.0d)), this.params.getWinternitzParameter(), this.params.getLen2()));
        byte[][] r107 = new byte[this.params.getLen()][];
    L13:
        if (r104 >= this.params.getLen()) goto L16;
        r102 = (OTSHashAddress) new OTSHashAddress.Builder().withLayerAddress(r102.getLayerAddress()).withTreeAddress(r102.getTreeAddress()).withOTSAddress(r102.getOTSAddress()).withChainAddress(r104).withHashAddress(r102.getHashAddress()).withKeyAndMask(r102.getKeyAndMask()).build();
        r107[r104] = chain(r101.toByteArray()[r104], ((Integer) ListProtector.get(r103, r104)).intValue(), (this.params.getWinternitzParameter() - 1) - ((Integer) ListProtector.get(r103, r104)).intValue(), r102);
        r104 = r104 + 1;
        goto L13
    L16:
        return new WOTSPlusPublicKeyParameters(this.params, r107);
    L18:
        throw new NullPointerException("otsHashAddress == null");
    L20:
        throw new NullPointerException("signature == null");
    L22:
        throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
    L24:
        throw new NullPointerException("messageDigest == null");
    }

    public byte[] getPublicSeed() {
        return Arrays.clone(this.publicSeed);
    }

    public byte[] getSecretKeySeed() {
        return Arrays.clone(this.secretKeySeed);
    }

    public byte[] getWOTSPlusSecretKey(byte[] r100, OTSHashAddress r101) {
        OTSHashAddress r102 = (OTSHashAddress) new OTSHashAddress.Builder().withLayerAddress(r101.getLayerAddress()).withTreeAddress(r101.getTreeAddress()).withOTSAddress(r101.getOTSAddress()).build();
        return this.khf.PRF(r100, r102.toByteArray());
    }

    public void importKeys(byte[] r100, byte[] r101) {
        if (r100 == null) goto L17;
        if (r100.length != this.params.getTreeDigestSize()) goto L15;
        if (r101 == null) goto L13;
        if (r101.length != this.params.getTreeDigestSize()) goto L11;
        this.secretKeySeed = r100;
        this.publicSeed = r101;
        return;
    L11:
        throw new IllegalArgumentException("size of publicSeed needs to be equal to size of digest");
    L13:
        throw new NullPointerException("publicSeed == null");
    L15:
        throw new IllegalArgumentException("size of secretKeySeed needs to be equal to size of digest");
    L17:
        throw new NullPointerException("secretKeySeed == null");
    }

    public WOTSPlusSignature sign(byte[] r100, OTSHashAddress r101) {
        if (r100 == null) goto L21;
        if (r100.length != this.params.getTreeDigestSize()) goto L19;
        if (r101 == null) goto L17;
        List<Integer> r102 = convertToBaseW(r100, this.params.getWinternitzParameter(), this.params.getLen1());
        int r103 = 0;
        int r104 = 0;
    L8:
        if (r103 >= this.params.getLen1()) goto L10;
        r104 = r104 + ((this.params.getWinternitzParameter() - 1) - ((Integer) ListProtector.get(r102, r103)).intValue());
        r103 = r103 + 1;
        goto L8
    L10:
        r102.addAll(convertToBaseW(XMSSUtil.toBytesBigEndian(r104 << (8 - ((this.params.getLen2() * XMSSUtil.log2(this.params.getWinternitzParameter())) % 8)), (int) Math.ceil(((double) (this.params.getLen2() * XMSSUtil.log2(this.params.getWinternitzParameter()))) / 8.0d)), this.params.getWinternitzParameter(), this.params.getLen2()));
        byte[][] r105 = new byte[this.params.getLen()][];
        int r106 = 0;
    L12:
        if (r106 >= this.params.getLen()) goto L15;
        r101 = (OTSHashAddress) new OTSHashAddress.Builder().withLayerAddress(r101.getLayerAddress()).withTreeAddress(r101.getTreeAddress()).withOTSAddress(r101.getOTSAddress()).withChainAddress(r106).withHashAddress(r101.getHashAddress()).withKeyAndMask(r101.getKeyAndMask()).build();
        r105[r106] = chain(expandSecretKeySeed(r106), 0, ((Integer) ListProtector.get(r102, r106)).intValue(), r101);
        r106 = r106 + 1;
        goto L12
    L15:
        return new WOTSPlusSignature(this.params, r105);
    L17:
        throw new NullPointerException("otsHashAddress == null");
    L19:
        throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
    L21:
        throw new NullPointerException("messageDigest == null");
    }
}
