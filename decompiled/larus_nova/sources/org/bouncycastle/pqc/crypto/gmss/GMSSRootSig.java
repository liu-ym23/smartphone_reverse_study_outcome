package org.bouncycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import kotlin.UByte;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.bouncycastle.util.encoders.Hex;
import tb2.c;

/* JADX INFO: loaded from: classes42.dex */
public class GMSSRootSig {
    private long big8;
    private int checksum;
    private int counter;
    private GMSSRandom gmssRandom;
    private byte[] hash;
    private int height;

    /* JADX INFO: renamed from: ii, reason: collision with root package name */
    private int f525518ii;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f525519k;
    private int keysize;
    private int mdsize;
    private Digest messDigestOTS;
    private int messagesize;
    private byte[] privateKeyOTS;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f525520r;
    private byte[] seed;
    private byte[] sign;
    private int steps;
    private int test;
    private long test8;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f525521w;

    public GMSSRootSig(Digest r100, int r101, int r102) {
        this.messDigestOTS = r100;
        this.gmssRandom = new GMSSRandom(r100);
        int r103 = this.messDigestOTS.getDigestSize();
        this.mdsize = r103;
        this.f525521w = r101;
        this.height = r102;
        this.f525519k = (1 << r101) - 1;
        this.messagesize = (int) Math.ceil(((double) (r103 << 3)) / ((double) r101));
    }

    public GMSSRootSig(Digest r110, byte[][] r111, int[] r112) {
        this.messDigestOTS = r110;
        this.gmssRandom = new GMSSRandom(r110);
        this.counter = r112[0];
        this.test = r112[1];
        this.f525518ii = r112[2];
        this.f525520r = r112[3];
        this.steps = r112[4];
        this.keysize = r112[5];
        this.height = r112[6];
        this.f525521w = r112[7];
        this.checksum = r112[8];
        int r113 = this.messDigestOTS.getDigestSize();
        this.mdsize = r113;
        int r114 = this.f525521w;
        this.f525519k = (1 << r114) - 1;
        this.messagesize = (int) Math.ceil(((double) (r113 << 3)) / ((double) r114));
        this.privateKeyOTS = r111[0];
        this.seed = r111[1];
        this.hash = r111[2];
        this.sign = r111[3];
        byte[] r115 = r111[4];
        this.test8 = (((((((((long) (r115[1] & UByte.MAX_VALUE)) << 8) | (r115[0] & UByte.MAX_VALUE)) | (((long) (r115[2] & UByte.MAX_VALUE)) << 16)) | (((long) (r115[3] & UByte.MAX_VALUE)) << 24)) | (((long) (r115[4] & UByte.MAX_VALUE)) << 32)) | (((long) (r115[5] & UByte.MAX_VALUE)) << 40)) | (((long) (r115[6] & UByte.MAX_VALUE)) << 48)) | (((long) (r115[7] & UByte.MAX_VALUE)) << 56);
        this.big8 = ((((((((long) (r115[8] & UByte.MAX_VALUE)) | (((long) (r115[9] & UByte.MAX_VALUE)) << 8)) | (((long) (r115[10] & UByte.MAX_VALUE)) << 16)) | (((long) (r115[11] & UByte.MAX_VALUE)) << 24)) | (((long) (r115[12] & UByte.MAX_VALUE)) << 32)) | (((long) (r115[13] & UByte.MAX_VALUE)) << 40)) | (((long) (r115[14] & UByte.MAX_VALUE)) << 48)) | (((long) (r115[15] & UByte.MAX_VALUE)) << 56);
    }

    private void oneStep() {
        int r100 = this.f525521w;
        if ((8 % r100) != 0) goto L18;
        int r101 = this.test;
        if (r101 != 0) goto L10;
        this.privateKeyOTS = this.gmssRandom.nextSeed(this.seed);
        int r102 = this.f525518ii;
        if (r102 >= this.mdsize) goto L9;
        byte[] r103 = this.hash;
        byte r104 = r103[r102];
        this.test = this.f525519k & r104;
        r103[r102] = (byte) (r104 >>> this.f525521w);
    L13:
        if (this.test != 0) goto L67;
        byte[] r105 = this.privateKeyOTS;
        byte[] r106 = this.sign;
        int r107 = this.counter;
        int r108 = this.mdsize;
        System.arraycopy(r105, 0, r106, r107 * r108, r108);
        int r109 = this.counter + 1;
        this.counter = r109;
        if ((r109 % (8 / this.f525521w)) != 0) goto L72;
        this.f525518ii++;
        return;
    L72:
        return;
    L67:
        return;
    L9:
        int r110 = this.checksum;
        this.test = this.f525519k & r110;
        this.checksum = r110 >>> this.f525521w;
        goto L13
    L10:
        if (r101 <= 0) goto L13;
        Digest r111 = this.messDigestOTS;
        byte[] r112 = this.privateKeyOTS;
        r111.update(r112, 0, r112.length);
        byte[] r113 = new byte[this.messDigestOTS.getDigestSize()];
        this.privateKeyOTS = r113;
        this.messDigestOTS.doFinal(r113, 0);
        this.test--;
        goto L13
    L18:
        if (r100 >= 8) goto L46;
        int r114 = this.test;
        if (r114 != 0) goto L39;
        int r115 = this.counter;
        if ((r115 % 8) != 0) goto L36;
        int r116 = this.f525518ii;
        int r117 = this.mdsize;
        if (r116 >= r117) goto L36;
        this.big8 = 0;
        if (r115 >= ((r117 / r100) << 3)) goto L31;
        int r118 = 0;
    L29:
        if (r118 >= this.f525521w) goto L36;
        long r119 = this.big8;
        byte[] r120 = this.hash;
        int r121 = this.f525518ii;
        this.big8 = r119 ^ ((long) ((r120[r121] & UByte.MAX_VALUE) << (r118 << 3)));
        this.f525518ii = r121 + 1;
        r118 = r118 + 1;
        goto L29
    L31:
        int r122 = 0;
    L33:
        if (r122 >= (this.mdsize % this.f525521w)) goto L36;
        long r123 = this.big8;
        byte[] r124 = this.hash;
        int r125 = this.f525518ii;
        this.big8 = r123 ^ ((long) ((r124[r125] & UByte.MAX_VALUE) << (r122 << 3)));
        this.f525518ii = r125 + 1;
        r122 = r122 + 1;
    L36:
        if (this.counter != this.messagesize) goto L38;
        this.big8 = this.checksum;
    L38:
        this.test = (int) (this.big8 & ((long) this.f525519k));
        this.privateKeyOTS = this.gmssRandom.nextSeed(this.seed);
    L42:
        if (this.test != 0) goto L74;
        byte[] r126 = this.privateKeyOTS;
        byte[] r127 = this.sign;
        int r128 = this.counter;
        int r129 = this.mdsize;
        System.arraycopy(r126, 0, r127, r128 * r129, r129);
        this.big8 >>>= this.f525521w;
    L44:
        this.counter++;
        return;
    L74:
        return;
    L39:
        if (r114 <= 0) goto L42;
        Digest r130 = this.messDigestOTS;
        byte[] r131 = this.privateKeyOTS;
        r130.update(r131, 0, r131.length);
        byte[] r132 = new byte[this.messDigestOTS.getDigestSize()];
        this.privateKeyOTS = r132;
        this.messDigestOTS.doFinal(r132, 0);
        this.test--;
        goto L42
    L46:
        if (r100 >= 57) goto L76;
        long r133 = this.test8;
        if (r133 != 0) goto L62;
        this.big8 = 0;
        this.f525518ii = 0;
        int r134 = this.f525520r;
        int r135 = r134 % 8;
        int r136 = r134 >>> 3;
        int r137 = this.mdsize;
        if (r136 < r137) goto L52;
        int r138 = this.checksum;
        this.test8 = this.f525519k & r138;
        this.checksum = r138 >>> r100;
    L60:
        this.privateKeyOTS = this.gmssRandom.nextSeed(this.seed);
    L65:
        if (this.test8 != 0) goto L77;
        byte[] r139 = this.privateKeyOTS;
        byte[] r140 = this.sign;
        int r141 = this.counter;
        int r142 = this.mdsize;
        System.arraycopy(r139, 0, r140, r141 * r142, r142);
        goto L44
    L77:
        return;
    L52:
        if (r134 > ((r137 << 3) - r100)) goto L54;
        int r143 = r134 + r100;
        this.f525520r = r143;
        r137 = (r143 + 7) >>> 3;
    L55:
        long r144 = this.big8;
        if (r136 >= r137) goto L58;
        int r145 = this.hash[r136] & UByte.MAX_VALUE;
        int r146 = this.f525518ii;
        this.big8 = r144 ^ ((long) (r145 << (r146 << 3)));
        this.f525518ii = r146 + 1;
        r136 = r136 + 1;
        goto L55
    L58:
        long r147 = r144 >>> r135;
        this.big8 = r147;
        this.test8 = r147 & ((long) this.f525519k);
        goto L60
    L54:
        this.f525520r = r134 + r100;
        goto L55
    L62:
        if (r133 <= 0) goto L65;
        Digest r148 = this.messDigestOTS;
        byte[] r149 = this.privateKeyOTS;
        r148.update(r149, 0, r149.length);
        byte[] r150 = new byte[this.messDigestOTS.getDigestSize()];
        this.privateKeyOTS = r150;
        this.messDigestOTS.doFinal(r150, 0);
        this.test8--;
        goto L65
    }

    public int getLog(int r100) {
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

    public byte[] getSig() {
        return this.sign;
    }

    public byte[][] getStatByte() {
        byte[][] r100 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{5, this.mdsize});
        r100[0] = this.privateKeyOTS;
        r100[1] = this.seed;
        r100[2] = this.hash;
        r100[3] = this.sign;
        r100[4] = getStatLong();
        return r100;
    }

    public int[] getStatInt() {
        return new int[]{this.counter, this.test, this.f525518ii, this.f525520r, this.steps, this.keysize, this.height, this.f525521w, this.checksum};
    }

    public byte[] getStatLong() {
        long r100 = this.test8;
        long r101 = this.big8;
        return new byte[]{(byte) (r100 & 255), (byte) ((r100 >> 8) & 255), (byte) ((r100 >> 16) & 255), (byte) ((r100 >> 24) & 255), (byte) ((r100 >> 32) & 255), (byte) ((r100 >> 40) & 255), (byte) ((r100 >> 48) & 255), (byte) ((r100 >> 56) & 255), (byte) (r101 & 255), (byte) ((r101 >> 8) & 255), (byte) ((r101 >> 16) & 255), (byte) ((r101 >> 24) & 255), (byte) ((r101 >> 32) & 255), (byte) ((r101 >> 40) & 255), (byte) ((r101 >> 48) & 255), (byte) ((r101 >> 56) & 255)};
    }

    public void initSign(byte[] r110, byte[] r111) {
        this.hash = new byte[this.mdsize];
        this.messDigestOTS.update(r111, 0, r111.length);
        byte[] r100 = new byte[this.messDigestOTS.getDigestSize()];
        this.hash = r100;
        this.messDigestOTS.doFinal(r100, 0);
        int r101 = this.mdsize;
        byte[] r102 = new byte[r101];
        System.arraycopy(this.hash, 0, r102, 0, r101);
        int r103 = getLog((this.messagesize << this.f525521w) + 1);
        int r104 = this.f525521w;
        int r105 = 8;
        if ((8 % r104) != 0) goto L14;
        int r106 = 8 / r104;
        int r107 = 0;
        int r108 = 0;
    L6:
        if (r107 >= this.mdsize) goto L11;
        int r112 = 0;
    L8:
        if (r112 >= r106) goto L10;
        byte r113 = r102[r107];
        r108 = r108 + (this.f525519k & r113);
        r102[r107] = (byte) (r113 >>> this.f525521w);
        r112 = r112 + 1;
        goto L8
    L10:
        r107 = r107 + 1;
        goto L6
    L11:
        int r109 = (this.messagesize << this.f525521w) - r108;
        this.checksum = r109;
        int r114 = 0;
    L12:
        if (r114 >= r103) goto L54;
        r108 = r108 + (this.f525519k & r109);
        int r115 = this.f525521w;
        r109 = r109 >>> r115;
        r114 = r114 + r115;
    L54:
        int r116 = this.messagesize + ((int) Math.ceil(((double) r103) / ((double) this.f525521w)));
        this.keysize = r116;
        this.steps = (int) Math.ceil(((double) (r116 + r108)) / ((double) (1 << this.height)));
        int r117 = this.keysize;
        int r118 = this.mdsize;
        this.sign = new byte[r117 * r118];
        this.counter = 0;
        this.test = 0;
        this.f525518ii = 0;
        this.test8 = 0;
        this.f525520r = 0;
        this.privateKeyOTS = new byte[r118];
        byte[] r119 = new byte[r118];
        this.seed = r119;
        System.arraycopy(r110, 0, r119, 0, r118);
        return;
    L14:
        if (r104 >= 8) goto L35;
        int r120 = this.mdsize / r104;
        int r121 = 0;
        int r122 = 0;
        int r123 = 0;
    L16:
        if (r121 >= r120) goto L25;
        int r124 = 0;
        long r125 = 0;
    L19:
        if (r124 >= this.f525521w) goto L21;
        r125 = r125 ^ ((long) ((r102[r122] & UByte.MAX_VALUE) << (r124 << 3)));
        r122 = r122 + 1;
        r124 = r124 + 1;
        goto L19
    L21:
        int r126 = 0;
    L22:
        if (r126 >= r105) goto L24;
        int r127 = r120;
        r123 = r123 + ((int) (((long) this.f525519k) & r125));
        r125 = r125 >>> this.f525521w;
        r126 = r126 + 1;
        r120 = r127;
        r105 = 8;
        goto L22
    L24:
        r121 = r121 + 1;
        r105 = 8;
        goto L16
    L25:
        int r128 = this.mdsize % this.f525521w;
        int r129 = 0;
        long r130 = 0;
    L26:
        if (r129 >= r128) goto L28;
        r130 = r130 ^ ((long) ((r102[r122] & UByte.MAX_VALUE) << (r129 << 3)));
        r122 = r122 + 1;
        r129 = r129 + 1;
        goto L26
    L28:
        int r131 = r128 << 3;
        int r132 = 0;
    L29:
        if (r132 >= r131) goto L31;
        r123 = r123 + ((int) (((long) this.f525519k) & r130));
        int r133 = this.f525521w;
        r130 = r130 >>> r133;
        r132 = r132 + r133;
        goto L29
    L31:
        int r134 = (this.messagesize << this.f525521w) - r123;
        this.checksum = r134;
        r108 = r123;
        int r135 = 0;
    L32:
        if (r135 >= r103) goto L54;
        r108 = r108 + (this.f525519k & r134);
        int r136 = this.f525521w;
        r134 = r134 >>> r136;
        r135 = r135 + r136;
        goto L32
    L35:
        if (r104 >= 57) goto L53;
        int r137 = 0;
        int r138 = 0;
    L37:
        int r139 = this.mdsize;
        int r140 = this.f525521w;
        if (r137 > ((r139 << 3) - r140)) goto L43;
        int r141 = r137 >>> 3;
        int r142 = r137 % 8;
        r137 = r137 + r140;
        int r143 = (r137 + 7) >>> 3;
        long r144 = 0;
        int r145 = 0;
    L40:
        if (r141 >= r143) goto L42;
        r144 = r144 ^ ((long) ((r102[r141] & UByte.MAX_VALUE) << (r145 << 3)));
        r145 = r145 + 1;
        r141 = r141 + 1;
        goto L40
    L42:
        r138 = (int) (((long) r138) + ((r144 >>> r142) & ((long) this.f525519k)));
        goto L37
    L43:
        int r146 = r137 >>> 3;
        if (r146 >= r139) goto L50;
        int r147 = r137 % 8;
        int r148 = 0;
        long r149 = 0;
    L47:
        if (r146 >= this.mdsize) goto L49;
        r149 = r149 ^ ((long) ((r102[r146] & UByte.MAX_VALUE) << (r148 << 3)));
        r148 = r148 + 1;
        r146 = r146 + 1;
        goto L47
    L49:
        long r150 = r149 >>> r147;
        r138 = (int) (((long) r138) + (r150 & ((long) this.f525519k)));
    L50:
        int r151 = (this.messagesize << this.f525521w) - r138;
        this.checksum = r151;
        r108 = r138;
        int r152 = 0;
    L51:
        if (r152 >= r103) goto L54;
        r108 = r108 + (this.f525519k & r151);
        int r153 = this.f525521w;
        r151 = r151 >>> r153;
        r152 = r152 + r153;
        goto L51
    L53:
        r108 = 0;
        goto L54
    }

    public String toString() {
        String r100 = "" + this.big8 + c.DEFAULT_TEXT;
        int[] r101 = getStatInt();
        int r102 = 0;
        byte[][] r103 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{5, this.mdsize});
        byte[][] r104 = getStatByte();
        int r105 = 0;
    L4:
        if (r105 >= 9) goto L6;
        r100 = r100 + r101[r105] + " ";
        r105 = r105 + 1;
    L6:
        if (r102 >= 5) goto L8;
        r100 = r100 + new String(Hex.encode(r104[r102])) + " ";
        r102 = r102 + 1;
        goto L6
    L8:
        return r100;
    }

    public boolean updateSign() {
        int r100 = 0;
    L4:
        if (r100 >= this.steps) goto L13;
        if (this.counter >= this.keysize) goto L9;
        oneStep();
    L9:
        if (this.counter == this.keysize) goto L10;
        r100 = r100 + 1;
        goto L4
    L10:
        return true;
    L13:
        return false;
    }
}
