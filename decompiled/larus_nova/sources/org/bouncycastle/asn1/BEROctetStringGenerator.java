package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes42.dex */
public class BEROctetStringGenerator extends BERGenerator {

    public class BufferedBEROctetStream extends OutputStream {
        private byte[] _buf;
        private DEROutputStream _derOut;
        private int _off;
        final /* synthetic */ BEROctetStringGenerator this$0;

        public BufferedBEROctetStream(BEROctetStringGenerator r100, byte[] r101) {
            this.this$0 = r100;
            this._buf = r101;
            this._off = 0;
            this._derOut = new DEROutputStream(r100._out);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            int r100 = this._off;
            if (r100 == 0) goto L5;
            DEROctetString.encode(this._derOut, true, this._buf, 0, r100);
        L5:
            this._derOut.flushInternal();
            this.this$0.writeBEREnd();
        }

        @Override // java.io.OutputStream
        public void write(int r100) throws IOException {
            byte[] r101 = this._buf;
            int r102 = this._off;
            int r103 = r102 + 1;
            this._off = r103;
            r101[r102] = (byte) r100;
            if (r103 != r101.length) goto L6;
            DEROctetString.encode(this._derOut, true, r101, 0, r101.length);
            this._off = 0;
            return;
        }

        @Override // java.io.OutputStream
        public void write(byte[] r100, int r101, int r102) throws IOException {
        L2:
            if (r102 <= 0) goto L7;
            int r103 = Math.min(r102, this._buf.length - this._off);
            System.arraycopy(r100, r101, this._buf, this._off, r103);
            int r104 = this._off + r103;
            this._off = r104;
            byte[] r105 = this._buf;
            if (r104 < r105.length) goto L10;
            DEROctetString.encode(this._derOut, true, r105, 0, r105.length);
            this._off = 0;
            r101 = r101 + r103;
            r102 = r102 - r103;
            goto L2
        L10:
            return;
        }
    }

    public BEROctetStringGenerator(OutputStream r100) throws IOException {
        super(r100);
        writeBERHeader(36);
    }

    public BEROctetStringGenerator(OutputStream r100, int r101, boolean r102) throws IOException {
        super(r100, r101, r102);
        writeBERHeader(36);
    }

    public OutputStream getOctetOutputStream() {
        return getOctetOutputStream(new byte[1000]);
    }

    public OutputStream getOctetOutputStream(byte[] r100) {
        return new BufferedBEROctetStream(this, r100);
    }
}
