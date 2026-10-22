package org.bouncycastle.util.encoders;

/* JADX INFO: loaded from: classes42.dex */
public class BufferedEncoder {
    protected byte[] buf;
    protected int bufOff;
    protected Translator translator;

    public BufferedEncoder(Translator r100, int r101) {
        this.translator = r100;
        if ((r101 % r100.getEncodedBlockSize()) != 0) goto L7;
        this.buf = new byte[r101];
        this.bufOff = 0;
        return;
    L7:
        throw new IllegalArgumentException("buffer size not multiple of input block size");
    }

    public int processByte(byte r100, byte[] r101, int r110) {
        byte[] r102 = this.buf;
        int r103 = this.bufOff;
        int r104 = r103 + 1;
        this.bufOff = r104;
        r102[r103] = r100;
        if (r104 != r102.length) goto L6;
        int r105 = this.translator.encode(r102, 0, r102.length, r101, r110);
        this.bufOff = 0;
        return r105;
    L6:
        return 0;
    }

    public int processBytes(byte[] r110, int r111, int r112, byte[] r113, int r114) {
        if (r112 < 0) goto L10;
        byte[] r100 = this.buf;
        int r101 = r100.length;
        int r102 = this.bufOff;
        int r103 = r101 - r102;
        int r104 = 0;
        if (r112 <= r103) goto L6;
        System.arraycopy(r110, r111, r100, r102, r103);
        Translator r105 = this.translator;
        byte[] r106 = this.buf;
        int r107 = r105.encode(r106, 0, r106.length, r113, r114) + 0;
        this.bufOff = 0;
        int r115 = r112 - r103;
        int r116 = r111 + r103;
        int r108 = r114 + r107;
        int r117 = r115 - (r115 % this.buf.length);
        r104 = r107 + this.translator.encode(r110, r116, r117, r113, r108);
        r112 = r115 - r117;
        r111 = r116 + r117;
    L6:
        if (r112 == 0) goto L8;
        System.arraycopy(r110, r111, this.buf, this.bufOff, r112);
        this.bufOff += r112;
    L8:
        return r104;
    L10:
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
