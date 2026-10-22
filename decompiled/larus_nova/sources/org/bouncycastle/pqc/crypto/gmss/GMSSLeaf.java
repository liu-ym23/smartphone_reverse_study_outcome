package org.bouncycastle.pqc.crypto.gmss;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class GMSSLeaf {
    private byte[] concHashs;
    private GMSSRandom gmssRandom;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f525515i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f525516j;
    private int keysize;
    private byte[] leaf;
    private int mdsize;
    private Digest messDigestOTS;
    byte[] privateKeyOTS;
    private byte[] seed;
    private int steps;
    private int two_power_w;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f525517w;

    public GMSSLeaf(Digest r100, int r101, int r102) {
        this.f525517w = r101;
        this.messDigestOTS = r100;
        this.gmssRandom = new GMSSRandom(r100);
        int r103 = this.messDigestOTS.getDigestSize();
        this.mdsize = r103;
        double r104 = r101;
        int r105 = (int) Math.ceil(((double) (r103 << 3)) / r104);
        int r106 = r105 + ((int) Math.ceil(((double) getLog((r105 << r101) + 1)) / r104));
        this.keysize = r106;
        int r107 = 1 << r101;
        this.two_power_w = r107;
        this.steps = (int) Math.ceil(((double) ((((r107 - 1) * r106) + 1) + r106)) / ((double) r102));
        int r108 = this.mdsize;
        this.seed = new byte[r108];
        this.leaf = new byte[r108];
        this.privateKeyOTS = new byte[r108];
        this.concHashs = new byte[r108 * this.keysize];
    }

    public GMSSLeaf(Digest r100, int r101, int r102, byte[] r110) {
        this.f525517w = r101;
        this.messDigestOTS = r100;
        this.gmssRandom = new GMSSRandom(r100);
        int r103 = this.messDigestOTS.getDigestSize();
        this.mdsize = r103;
        double r104 = r101;
        int r105 = (int) Math.ceil(((double) (r103 << 3)) / r104);
        int r106 = r105 + ((int) Math.ceil(((double) getLog((r105 << r101) + 1)) / r104));
        this.keysize = r106;
        int r107 = 1 << r101;
        this.two_power_w = r107;
        this.steps = (int) Math.ceil(((double) ((((r107 - 1) * r106) + 1) + r106)) / ((double) r102));
        int r108 = this.mdsize;
        this.seed = new byte[r108];
        this.leaf = new byte[r108];
        this.privateKeyOTS = new byte[r108];
        this.concHashs = new byte[r108 * this.keysize];
        initLeafCalc(r110);
    }

    public GMSSLeaf(Digest r100, byte[][] r110, int[] r111) {
        this.f525515i = r111[0];
        this.f525516j = r111[1];
        this.steps = r111[2];
        this.f525517w = r111[3];
        this.messDigestOTS = r100;
        this.gmssRandom = new GMSSRandom(r100);
        int r101 = this.messDigestOTS.getDigestSize();
        this.mdsize = r101;
        int r102 = (int) Math.ceil(((double) (r101 << 3)) / ((double) this.f525517w));
        this.keysize = r102 + ((int) Math.ceil(((double) getLog((r102 << this.f525517w) + 1)) / ((double) this.f525517w)));
        this.two_power_w = 1 << this.f525517w;
        this.privateKeyOTS = r110[0];
        this.seed = r110[1];
        this.concHashs = r110[2];
        this.leaf = r110[3];
    }

    private GMSSLeaf(GMSSLeaf r100) {
        this.messDigestOTS = r100.messDigestOTS;
        this.mdsize = r100.mdsize;
        this.keysize = r100.keysize;
        this.gmssRandom = r100.gmssRandom;
        this.leaf = Arrays.clone(r100.leaf);
        this.concHashs = Arrays.clone(r100.concHashs);
        this.f525515i = r100.f525515i;
        this.f525516j = r100.f525516j;
        this.two_power_w = r100.two_power_w;
        this.f525517w = r100.f525517w;
        this.steps = r100.steps;
        this.seed = Arrays.clone(r100.seed);
        this.privateKeyOTS = Arrays.clone(r100.privateKeyOTS);
    }

    private int getLog(int r100) {
        int r101 = 1;
        int r102 = 2;
    L3:
        if (r102 >= r100) goto L5;
        r102 = r102 << 1;
        r101 = r101 + 1;
        goto L3
    L5:
        return r101;
    }

    private void updateLeafCalc() {
        byte[] r100 = new byte[this.messDigestOTS.getDigestSize()];
        int r101 = 0;
    L4:
        if (r101 >= (this.steps + 10000)) goto L21;
        int r102 = this.f525515i;
        if (r102 == this.keysize) goto L8;
    L11:
        if (r102 != 0) goto L13;
    L18:
        this.f525515i = r102 + 1;
        this.f525516j = 0;
        this.privateKeyOTS = this.gmssRandom.nextSeed(this.seed);
    L19:
        r101 = r101 + 1;
        goto L4
    L13:
        if (this.f525516j == (this.two_power_w - 1)) goto L18;
        Digest r103 = this.messDigestOTS;
        byte[] r104 = this.privateKeyOTS;
        r103.update(r104, 0, r104.length);
        this.privateKeyOTS = r100;
        this.messDigestOTS.doFinal(r100, 0);
        int r105 = this.f525516j + 1;
        this.f525516j = r105;
        if (r105 != (this.two_power_w - 1)) goto L19;
        byte[] r106 = this.privateKeyOTS;
        byte[] r107 = this.concHashs;
        int r108 = this.mdsize;
        System.arraycopy(r106, 0, r107, (this.f525515i - 1) * r108, r108);
        goto L19
    L8:
        if (this.f525516j != (this.two_power_w - 1)) goto L11;
        Digest r109 = this.messDigestOTS;
        byte[] r110 = this.concHashs;
        r109.update(r110, 0, r110.length);
        byte[] r111 = new byte[this.messDigestOTS.getDigestSize()];
        this.leaf = r111;
        this.messDigestOTS.doFinal(r111, 0);
        return;
    L21:
        throw new IllegalStateException("unable to updateLeaf in steps: " + this.steps + " " + this.f525515i + " " + this.f525516j);
    }

    public byte[] getLeaf() {
        return Arrays.clone(this.leaf);
    }

    public byte[][] getStatByte() {
        return new byte[][]{this.privateKeyOTS, this.seed, this.concHashs, this.leaf};
    }

    public int[] getStatInt() {
        return new int[]{this.f525515i, this.f525516j, this.steps, this.f525517w};
    }

    public void initLeafCalc(byte[] r100) {
        this.f525515i = 0;
        this.f525516j = 0;
        byte[] r101 = new byte[this.mdsize];
        System.arraycopy(r100, 0, r101, 0, this.seed.length);
        this.seed = this.gmssRandom.nextSeed(r101);
    }

    public GMSSLeaf nextLeaf() {
        GMSSLeaf r100 = new GMSSLeaf(this);
        r100.updateLeafCalc();
        return r100;
    }

    public String toString() {
        String r100 = "";
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= 4) goto L6;
        r100 = r100 + getStatInt()[r102] + " ";
        r102 = r102 + 1;
        goto L4
    L6:
        String r103 = r100 + " " + this.mdsize + " " + this.keysize + " " + this.two_power_w + " ";
        byte[][] r104 = getStatByte();
    L7:
        if (r101 >= 4) goto L13;
        if (r104[r101] == null) goto L11;
        StringBuilder r105 = new StringBuilder();
        r105.append(r103);
        r105.append(new String(Hex.encode(r104[r101])));
        r105.append(" ");
    L12:
        r103 = r105.toString();
        r101 = r101 + 1;
        goto L7
    L11:
        r105 = new StringBuilder();
        r105.append(r103);
        r105.append("null ");
        goto L12
    L13:
        return r103;
    }
}
