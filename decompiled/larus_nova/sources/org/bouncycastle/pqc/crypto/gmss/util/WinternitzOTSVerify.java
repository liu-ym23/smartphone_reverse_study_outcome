package org.bouncycastle.pqc.crypto.gmss.util;

import kotlin.UByte;
import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes42.dex */
public class WinternitzOTSVerify {
    private int mdsize;
    private Digest messDigestOTS;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f525522w;

    public WinternitzOTSVerify(Digest r100, int r101) {
        this.f525522w = r101;
        this.messDigestOTS = r100;
        this.mdsize = r100.getDigestSize();
    }

    private void hashSignatureBlock(byte[] r100, int r101, int r102, byte[] r103, int r104) {
        if (r102 >= 1) goto L5;
        System.arraycopy(r100, r101, r103, r104, this.mdsize);
        return;
    L5:
        this.messDigestOTS.update(r100, r101, this.mdsize);
    L6:
        this.messDigestOTS.doFinal(r103, r104);
        r102 = r102 - 1;
        if (r102 <= 0) goto L11;
        this.messDigestOTS.update(r103, r104, this.mdsize);
        goto L6
    }

    public byte[] Verify(byte[] r210, byte[] r310) {
        WinternitzOTSVerify r100 = this;
        int r101 = r100.mdsize;
        byte[] r102 = new byte[r101];
        r100.messDigestOTS.update(r210, 0, r210.length);
        r100.messDigestOTS.doFinal(r102, 0);
        int r103 = r100.mdsize << 3;
        int r104 = r100.f525522w;
        int r110 = (r103 + (r104 - 1)) / r104;
        int r111 = r100.getLog((r110 << r104) + 1);
        int r105 = r100.f525522w;
        int r106 = r100.mdsize;
        int r112 = r106 * ((((r111 + r105) - 1) / r105) + r110);
        if (r112 == r310.length) goto L6;
        return null;
    L6:
        byte[] r113 = new byte[r112];
        int r107 = 8;
        if ((8 % r105) != 0) goto L17;
        int r108 = 8 / r105;
        int r114 = (1 << r105) - 1;
        int r109 = 0;
        int r115 = 0;
        int r116 = 0;
    L9:
        if (r116 >= r101) goto L14;
        int r117 = r115;
        int r118 = 0;
    L11:
        if (r118 >= r108) goto L13;
        int r119 = r102[r116] & r114;
        int r120 = r109 + r119;
        int r121 = r100.mdsize;
        int r122 = r116;
        hashSignatureBlock(r310, r117 * r121, r114 - r119, r113, r117 * r121);
        r102[r122] = (byte) (r102[r122] >>> r100.f525522w);
        r117 = r117 + 1;
        r118 = r118 + 1;
        r109 = r120;
        r116 = r122;
        r108 = r108;
        goto L11
    L13:
        r116 = r116 + 1;
        r115 = r117;
        goto L9
    L14:
        int r123 = r115;
        int r124 = (r110 << r100.f525522w) - r109;
        int r125 = 0;
    L15:
        if (r125 >= r111) goto L69;
        int r126 = r100.mdsize;
        hashSignatureBlock(r310, r123 * r126, r114 - (r124 & r114), r113, r123 * r126);
        int r127 = r100.f525522w;
        r124 = r124 >>> r127;
        r123 = r123 + 1;
        r125 = r125 + r127;
    L69:
        int r211 = r112;
    L70:
        r100.messDigestOTS.update(r113, 0, r211);
        byte[] r128 = new byte[r100.mdsize];
        r100.messDigestOTS.doFinal(r128, 0);
        return r128;
    L17:
        long r129 = 0;
        if (r105 >= 8) goto L39;
        int r130 = r106 / r105;
        int r131 = (1 << r105) - 1;
        int r132 = 0;
        int r133 = 0;
        int r134 = 0;
        int r135 = 0;
    L20:
        if (r135 >= r130) goto L29;
        int r136 = r132;
        long r137 = 0;
        int r138 = 0;
    L23:
        if (r138 >= r100.f525522w) goto L25;
        r137 = r137 ^ ((long) ((r102[r136] & UByte.MAX_VALUE) << (r138 << 3)));
        r136 = r136 + 1;
        r138 = r138 + 1;
        r111 = r111;
        goto L23
    L25:
        int r212 = r111;
        int r139 = r134;
        int r140 = 0;
    L26:
        if (r140 >= r107) goto L28;
        int r141 = (int) (r137 & ((long) r131));
        int r142 = r133 + r141;
        int r143 = this.mdsize;
        r100 = this;
        hashSignatureBlock(r310, r139 * r143, r131 - r141, r113, r139 * r143);
        r137 = r137 >>> r100.f525522w;
        r139 = r139 + 1;
        r140 = r140 + 1;
        r131 = r131;
        r135 = r135;
        r133 = r142;
        r107 = 8;
        goto L26
    L28:
        r135 = r135 + 1;
        r134 = r139;
        r132 = r136;
        r111 = r212;
        r107 = 8;
        goto L20
    L29:
        int r213 = r111;
        int r144 = r131;
        int r145 = r100.mdsize % r100.f525522w;
        int r146 = 0;
    L30:
        if (r146 >= r145) goto L32;
        r129 = r129 ^ ((long) ((r102[r132] & UByte.MAX_VALUE) << (r146 << 3)));
        r132 = r132 + 1;
        r146 = r146 + 1;
        r133 = r133;
        r134 = r134;
        goto L30
    L32:
        int r147 = r134;
        int r148 = r145 << 3;
        int r149 = 0;
    L33:
        if (r149 >= r148) goto L35;
        int r150 = (int) (r129 & ((long) r144));
        int r151 = r133 + r150;
        int r152 = r100.mdsize;
        hashSignatureBlock(r310, r147 * r152, r144 - r150, r113, r147 * r152);
        int r153 = r100.f525522w;
        r129 = r129 >>> r153;
        r147 = r147 + 1;
        r149 = r149 + r153;
        r133 = r151;
        goto L33
    L35:
        int r154 = (r110 << r100.f525522w) - r133;
        int r155 = 0;
    L36:
        if (r155 >= r213) goto L69;
        int r156 = r100.mdsize;
        hashSignatureBlock(r310, r147 * r156, r144 - (r154 & r144), r113, r147 * r156);
        int r157 = r100.f525522w;
        r154 = r154 >>> r157;
        r147 = r147 + 1;
        r155 = r155 + r157;
        goto L36
    L39:
        if (r105 >= 57) goto L69;
        int r158 = (r106 << 3) - r105;
        int r159 = (1 << r105) - 1;
        byte[] r160 = new byte[r106];
        int r161 = 0;
        int r162 = 0;
        int r163 = 0;
    L42:
        if (r161 > r158) goto L51;
        int r164 = r161 >>> 3;
        int r165 = r161 % 8;
        int r214 = r158;
        int r166 = r161 + r100.f525522w;
        int r167 = (r166 + 7) >>> 3;
        long r215 = 0;
        int r216 = 0;
    L44:
        if (r164 >= r167) goto L46;
        int r217 = r167;
        r215 = r215 ^ ((long) ((r102[r164] & UByte.MAX_VALUE) << (r216 << 3)));
        r216 = r216 + 1;
        r164 = r164 + 1;
        r167 = r217;
        r166 = r166;
        goto L44
    L46:
        int r218 = r166;
        long r168 = r215 >>> r165;
        int r169 = r112;
        long r170 = r159;
        long r171 = r168 & r170;
        int r219 = r110;
        r162 = (int) (((long) r162) + r171);
        int r172 = r100.mdsize;
        long r220 = r171;
        System.arraycopy(r310, r163 * r172, r160, 0, r172);
    L48:
        if (r220 >= r170) goto L50;
        r100.messDigestOTS.update(r160, 0, r106);
        r100.messDigestOTS.doFinal(r160, 0);
        r220 = r220 + 1;
        goto L48
    L50:
        int r173 = r100.mdsize;
        System.arraycopy(r160, 0, r113, r163 * r173, r173);
        r163 = r163 + 1;
        r158 = r214;
        r110 = r219;
        r112 = r169;
        r161 = r218;
        goto L42
    L51:
        int r221 = r110;
        r211 = r112;
        int r174 = r161 >>> 3;
        if (r174 >= r100.mdsize) goto L62;
        int r175 = r161 % 8;
        int r176 = 0;
    L54:
        int r177 = r100.mdsize;
        if (r174 >= r177) goto L57;
        r129 = r129 ^ ((long) ((r102[r174] & UByte.MAX_VALUE) << (r176 << 3)));
        r176 = r176 + 1;
        r174 = r174 + 1;
        goto L54
    L57:
        long r178 = r159;
        long r179 = (r129 >>> r175) & r178;
        r162 = (int) (((long) r162) + r179);
        System.arraycopy(r310, r163 * r177, r160, 0, r177);
    L59:
        if (r179 >= r178) goto L61;
        r100.messDigestOTS.update(r160, 0, r106);
        r100.messDigestOTS.doFinal(r160, 0);
        r179 = r179 + 1;
        goto L59
    L61:
        int r180 = r100.mdsize;
        System.arraycopy(r160, 0, r113, r163 * r180, r180);
        r163 = r163 + 1;
    L62:
        int r181 = (r221 << r100.f525522w) - r162;
        int r182 = 0;
    L63:
        if (r182 >= r111) goto L70;
        long r183 = r181 & r159;
        int r184 = r100.mdsize;
        System.arraycopy(r310, r163 * r184, r160, 0, r184);
    L66:
        if (r183 >= r159) goto L68;
        r100.messDigestOTS.update(r160, 0, r106);
        r100.messDigestOTS.doFinal(r160, 0);
        r183 = r183 + 1;
        goto L66
    L68:
        int r185 = r100.mdsize;
        System.arraycopy(r160, 0, r113, r163 * r185, r185);
        int r186 = r100.f525522w;
        r181 = r181 >>> r186;
        r163 = r163 + 1;
        r182 = r182 + r186;
        goto L63
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

    public int getSignatureLength() {
        int r100 = this.messDigestOTS.getDigestSize();
        int r101 = this.f525522w;
        int r102 = ((r100 << 3) + (r101 - 1)) / r101;
        int r103 = getLog((r102 << r101) + 1);
        int r104 = this.f525522w;
        return r100 * (r102 + (((r103 + r104) - 1) / r104));
    }
}
