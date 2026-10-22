package org.bouncycastle.pqc.crypto.gmss.util;

import kotlin.UByte;
import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes42.dex */
public class WinternitzOTSignature {
    private int checksumsize;
    private GMSSRandom gmssRandom;
    private int keysize;
    private int mdsize;
    private Digest messDigestOTS;
    private int messagesize;
    private byte[][] privateKeyOTS;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f525523w;

    public WinternitzOTSignature(byte[] r100, Digest r101, int r102) {
        this.f525523w = r102;
        this.messDigestOTS = r101;
        this.gmssRandom = new GMSSRandom(r101);
        int r103 = this.messDigestOTS.getDigestSize();
        this.mdsize = r103;
        int r104 = (((r103 << 3) + r102) - 1) / r102;
        this.messagesize = r104;
        int r105 = getLog((r104 << r102) + 1);
        this.checksumsize = r105;
        int r106 = this.messagesize + (((r105 + r102) - 1) / r102);
        this.keysize = r106;
        this.privateKeyOTS = new byte[r106][];
        int r107 = this.mdsize;
        byte[] r108 = new byte[r107];
        int r109 = 0;
        System.arraycopy(r100, 0, r108, 0, r107);
    L4:
        if (r109 >= this.keysize) goto L6;
        this.privateKeyOTS[r109] = this.gmssRandom.nextSeed(r108);
        r109 = r109 + 1;
        goto L4
    }

    private void hashPrivateKeyBlock(int r100, int r101, byte[] r102, int r103) {
        if (r101 >= 1) goto L5;
        System.arraycopy(this.privateKeyOTS[r100], 0, r102, r103, this.mdsize);
        return;
    L5:
        this.messDigestOTS.update(this.privateKeyOTS[r100], 0, this.mdsize);
    L6:
        this.messDigestOTS.doFinal(r102, r103);
        r101 = r101 - 1;
        if (r101 <= 0) goto L11;
        this.messDigestOTS.update(r102, r103, this.mdsize);
        goto L6
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

    public byte[][] getPrivateKey() {
        return this.privateKeyOTS;
    }

    public byte[] getPublicKey() {
        int r100 = this.keysize * this.mdsize;
        byte[] r101 = new byte[r100];
        int r102 = (1 << this.f525523w) - 1;
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r103 >= this.keysize) goto L6;
        hashPrivateKeyBlock(r103, r102, r101, r104);
        r104 = r104 + this.mdsize;
        r103 = r103 + 1;
        goto L4
    L6:
        this.messDigestOTS.update(r101, 0, r100);
        byte[] r105 = new byte[this.mdsize];
        this.messDigestOTS.doFinal(r105, 0);
        return r105;
    }

    public byte[] getSignature(byte[] r210) {
        int r100 = this.keysize;
        int r101 = this.mdsize;
        byte[] r102 = new byte[r100 * r101];
        byte[] r103 = new byte[r101];
        int r104 = 0;
        this.messDigestOTS.update(r210, 0, r210.length);
        this.messDigestOTS.doFinal(r103, 0);
        int r105 = this.f525523w;
        int r106 = 8;
        if ((8 % r105) != 0) goto L14;
        int r107 = 8 / r105;
        int r108 = (1 << r105) - 1;
        int r109 = 0;
        int r110 = 0;
        int r111 = 0;
    L5:
        if (r109 >= r101) goto L10;
        int r112 = 0;
    L7:
        if (r112 >= r107) goto L9;
        int r113 = r103[r109] & r108;
        r110 = r110 + r113;
        hashPrivateKeyBlock(r111, r113, r102, this.mdsize * r111);
        r103[r109] = (byte) (r103[r109] >>> this.f525523w);
        r111 = r111 + 1;
        r112 = r112 + 1;
        goto L7
    L9:
        r109 = r109 + 1;
        goto L5
    L10:
        int r114 = (this.messagesize << this.f525523w) - r110;
    L12:
        if (r104 >= this.checksumsize) goto L66;
        hashPrivateKeyBlock(r111, r114 & r108, r102, this.mdsize * r111);
        int r115 = this.f525523w;
        r114 = r114 >>> r115;
        r111 = r111 + 1;
        r104 = r104 + r115;
    L66:
        return r102;
    L14:
        if (r105 >= 8) goto L36;
        int r116 = this.mdsize / r105;
        int r117 = (1 << r105) - 1;
        int r118 = 0;
        int r119 = 0;
        int r120 = 0;
        int r121 = 0;
    L16:
        if (r118 >= r116) goto L25;
        int r122 = 0;
        long r123 = 0;
    L19:
        if (r122 >= this.f525523w) goto L21;
        r123 = r123 ^ ((long) ((r103[r119] & UByte.MAX_VALUE) << (r122 << 3)));
        r119 = r119 + 1;
        r122 = r122 + 1;
        goto L19
    L21:
        long r124 = r123;
        int r125 = 0;
    L22:
        if (r125 >= r106) goto L24;
        int r126 = ((int) r124) & r117;
        r121 = r121 + r126;
        hashPrivateKeyBlock(r120, r126, r102, this.mdsize * r120);
        r124 = r124 >>> this.f525523w;
        r120 = r120 + 1;
        r125 = r125 + 1;
        r106 = 8;
        goto L22
    L24:
        r118 = r118 + 1;
        r106 = 8;
        goto L16
    L25:
        int r127 = this.mdsize % this.f525523w;
        int r128 = 0;
        long r129 = 0;
    L26:
        if (r128 >= r127) goto L28;
        r129 = r129 ^ ((long) ((r103[r119] & UByte.MAX_VALUE) << (r128 << 3)));
        r119 = r119 + 1;
        r128 = r128 + 1;
        goto L26
    L28:
        int r130 = r127 << 3;
        int r131 = 0;
    L29:
        if (r131 >= r130) goto L31;
        int r132 = ((int) r129) & r117;
        r121 = r121 + r132;
        hashPrivateKeyBlock(r120, r132, r102, this.mdsize * r120);
        int r133 = this.f525523w;
        r129 = r129 >>> r133;
        r120 = r120 + 1;
        r131 = r131 + r133;
        goto L29
    L31:
        int r134 = (this.messagesize << this.f525523w) - r121;
    L33:
        if (r104 >= this.checksumsize) goto L66;
        hashPrivateKeyBlock(r120, r134 & r117, r102, this.mdsize * r120);
        int r135 = this.f525523w;
        r134 = r134 >>> r135;
        r120 = r120 + 1;
        r104 = r104 + r135;
        goto L33
    L36:
        if (r105 >= 57) goto L66;
        int r136 = this.mdsize;
        int r137 = (r136 << 3) - r105;
        int r138 = (1 << r105) - 1;
        byte[] r139 = new byte[r136];
        int r140 = 0;
        int r141 = 0;
        int r142 = 0;
    L38:
        if (r140 > r137) goto L47;
        int r143 = r140 >>> 3;
        int r144 = r140 % 8;
        r140 = r140 + this.f525523w;
        int r145 = (r140 + 7) >>> 3;
        int r146 = 0;
        long r147 = 0;
    L40:
        if (r143 >= r145) goto L42;
        r147 = r147 ^ ((long) ((r103[r143] & UByte.MAX_VALUE) << (r146 << 3)));
        r146 = r146 + 1;
        r143 = r143 + 1;
        r103 = r103;
        r137 = r137;
        goto L40
    L42:
        byte[] r211 = r103;
        int r212 = r137;
        long r148 = (r147 >>> r144) & ((long) r138);
        r142 = (int) (((long) r142) + r148);
        System.arraycopy(this.privateKeyOTS[r141], 0, r139, 0, this.mdsize);
    L44:
        if (r148 <= 0) goto L46;
        this.messDigestOTS.update(r139, 0, r136);
        this.messDigestOTS.doFinal(r139, 0);
        r148 = r148 - 1;
        goto L44
    L46:
        int r149 = this.mdsize;
        System.arraycopy(r139, 0, r102, r141 * r149, r149);
        r141 = r141 + 1;
        r103 = r211;
        r137 = r212;
        goto L38
    L47:
        byte[] r213 = r103;
        int r150 = r140 >>> 3;
        if (r150 >= this.mdsize) goto L58;
        int r151 = r140 % 8;
        int r152 = 0;
        long r153 = 0;
    L50:
        int r154 = this.mdsize;
        if (r150 >= r154) goto L53;
        r153 = r153 ^ ((long) ((r213[r150] & UByte.MAX_VALUE) << (r152 << 3)));
        r152 = r152 + 1;
        r150 = r150 + 1;
        goto L50
    L53:
        long r155 = (r153 >>> r151) & ((long) r138);
        r142 = (int) (((long) r142) + r155);
        System.arraycopy(this.privateKeyOTS[r141], 0, r139, 0, r154);
    L55:
        if (r155 <= 0) goto L57;
        this.messDigestOTS.update(r139, 0, r136);
        this.messDigestOTS.doFinal(r139, 0);
        r155 = r155 - 1;
        goto L55
    L57:
        int r156 = this.mdsize;
        System.arraycopy(r139, 0, r102, r141 * r156, r156);
        r141 = r141 + 1;
    L58:
        int r157 = (this.messagesize << this.f525523w) - r142;
        int r158 = 0;
    L60:
        if (r158 >= this.checksumsize) goto L66;
        long r159 = r157 & r138;
        System.arraycopy(this.privateKeyOTS[r141], 0, r139, 0, this.mdsize);
    L63:
        if (r159 <= 0) goto L65;
        this.messDigestOTS.update(r139, 0, r136);
        this.messDigestOTS.doFinal(r139, 0);
        r159 = r159 - 1;
        goto L63
    L65:
        int r160 = this.mdsize;
        System.arraycopy(r139, 0, r102, r141 * r160, r160);
        int r161 = this.f525523w;
        r157 = r157 >>> r161;
        r141 = r141 + 1;
        r158 = r158 + r161;
        goto L60
    }
}
