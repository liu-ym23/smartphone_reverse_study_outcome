package com.bytedance.fresco.encoder;

import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes19.dex */
class LZWEncoder {
    static final int BITS = 12;
    private static final int EOF = -1;
    static final int HSIZE = 5003;
    int ClearCode;
    int EOFCode;
    int a_count;
    byte[] accum;
    boolean clear_flg;
    int[] codetab;
    private int curPixel;
    int cur_accum;
    int cur_bits;
    int free_ent;
    int g_init_bits;
    int hsize;
    int[] htab;
    private int imgH;
    private int imgW;
    private int initCodeSize;
    int[] masks;
    int maxbits;
    int maxcode;
    int maxmaxcode;
    int n_bits;
    private byte[] pixAry;
    private int remaining;

    public final int MAXCODE(int r100) {
        return (1 << r100) - 1;
    }

    private int nextPixel() {
        int r100 = this.remaining;
        if (r100 != 0) goto L6;
        return -1;
    L6:
        this.remaining = r100 - 1;
        byte[] r101 = this.pixAry;
        int r102 = this.curPixel;
        this.curPixel = r102 + 1;
        return r101[r102] & UByte.MAX_VALUE;
    }

    public void cl_block(OutputStream r100) throws IOException {
        cl_hash(this.hsize);
        int r101 = this.ClearCode;
        this.free_ent = r101 + 2;
        this.clear_flg = true;
        output(r101, r100);
    }

    public void cl_hash(int r100) {
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        this.htab[r101] = -1;
        r101 = r101 + 1;
        goto L3
    }

    public void encode(OutputStream r100) throws IOException {
        r100.write(this.initCodeSize);
        this.remaining = this.imgW * this.imgH;
        this.curPixel = 0;
        compress(this.initCodeSize + 1, r100);
        r100.write(0);
    }

    public void flush_char(OutputStream r100) throws IOException {
        int r101 = this.a_count;
        if (r101 <= 0) goto L6;
        r100.write(r101);
        r100.write(this.accum, 0, this.a_count);
        this.a_count = 0;
        return;
    }

    public void char_out(byte r100, OutputStream r101) throws IOException {
        byte[] r102 = this.accum;
        int r103 = this.a_count;
        int r104 = r103 + 1;
        this.a_count = r104;
        r102[r103] = r100;
        if (r104 < 254) goto L6;
        flush_char(r101);
        return;
    }

    public void compress(int r100, OutputStream r110) throws IOException {
        this.g_init_bits = r100;
        int r101 = 0;
        this.clear_flg = false;
        this.n_bits = r100;
        this.maxcode = MAXCODE(r100);
        int r102 = 1 << (r100 - 1);
        this.ClearCode = r102;
        this.EOFCode = r102 + 1;
        this.free_ent = r102 + 2;
        this.a_count = 0;
        int r103 = nextPixel();
        int r104 = this.hsize;
    L4:
        if (r104 >= 65536) goto L6;
        r101 = r101 + 1;
        r104 = r104 * 2;
        goto L4
    L6:
        int r105 = 8 - r101;
        int r106 = this.hsize;
        cl_hash(r106);
        output(this.ClearCode, r110);
    L7:
        int r107 = nextPixel();
        if (r107 == (-1)) goto L28;
        int r108 = (r107 << this.maxbits) + r103;
        int r109 = (r107 << r105) ^ r103;
        int r111 = this.htab[r109];
        if (r111 == r108) goto L11;
        if (r111 < 0) goto L23;
        int r112 = r106 - r109;
        if (r109 != 0) goto L16;
        r112 = 1;
    L16:
        r109 = r109 - r112;
        if (r109 >= 0) goto L19;
        r109 = r109 + r106;
    L19:
        int r113 = this.htab[r109];
        if (r113 == r108) goto L21;
        if (r113 >= 0) goto L16;
    L21:
        r103 = this.codetab[r109];
    L23:
        output(r103, r110);
        int r114 = this.free_ent;
        if (r114 >= this.maxmaxcode) goto L26;
        int[] r115 = this.codetab;
        this.free_ent = r114 + 1;
        r115[r109] = r114;
        this.htab[r109] = r108;
    L27:
        r103 = r107;
        goto L7
    L26:
        cl_block(r110);
        goto L27
    L11:
        r103 = this.codetab[r109];
        goto L7
    L28:
        output(r103, r110);
        output(this.EOFCode, r110);
    }

    public void output(int r100, OutputStream r101) throws IOException {
        int r102 = this.cur_accum;
        int[] r103 = this.masks;
        int r104 = this.cur_bits;
        int r105 = r102 & r103[r104];
        this.cur_accum = r105;
        if (r104 <= 0) goto L5;
        this.cur_accum = r105 | (r100 << r104);
    L6:
        this.cur_bits = r104 + this.n_bits;
    L8:
        if (this.cur_bits < 8) goto L11;
        char_out((byte) (this.cur_accum & 255), r101);
        this.cur_accum >>= 8;
        this.cur_bits -= 8;
        goto L8
    L11:
        if (this.free_ent > this.maxcode) goto L15;
        if (this.clear_flg == true) goto L15;
    L22:
        if (r100 == this.EOFCode) goto L24;
        return;
    L24:
        if (this.cur_bits <= 0) goto L26;
        char_out((byte) (this.cur_accum & 255), r101);
        this.cur_accum >>= 8;
        this.cur_bits -= 8;
        goto L24
    L26:
        flush_char(r101);
        return;
    L15:
        if (this.clear_flg == false) goto L17;
        int r106 = this.g_init_bits;
        this.n_bits = r106;
        this.maxcode = MAXCODE(r106);
        this.clear_flg = false;
        goto L22
    L17:
        int r107 = this.n_bits + 1;
        this.n_bits = r107;
        if (r107 != this.maxbits) goto L20;
        this.maxcode = this.maxmaxcode;
        goto L22
    L20:
        this.maxcode = MAXCODE(r107);
        goto L22
    L5:
        this.cur_accum = r100;
        goto L6
    }

    public LZWEncoder(int r100, int r101, byte[] r102, int r103) {
        this.maxbits = 12;
        this.maxmaxcode = 4096;
        this.htab = new int[5003];
        this.codetab = new int[5003];
        this.hsize = 5003;
        this.free_ent = 0;
        this.clear_flg = false;
        this.cur_accum = 0;
        this.cur_bits = 0;
        this.masks = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, UnixStat.PERM_MASK, 8191, 16383, 32767, 65535};
        this.accum = new byte[256];
        this.imgW = r100;
        this.imgH = r101;
        this.pixAry = r102;
        this.initCodeSize = Math.max(2, r103);
    }
}
