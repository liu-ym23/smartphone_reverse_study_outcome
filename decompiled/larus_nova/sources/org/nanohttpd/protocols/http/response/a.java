package org.nanohttpd.protocols.http.response;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes42.dex */
public final class a extends FilterOutputStream {
    public final void a() throws IOException {
        ((FilterOutputStream) this).out.write("0\r\n\r\n".getBytes());
    }

    public a(OutputStream r100) {
        super(r100);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int r100) throws IOException {
        write(new byte[]{(byte) r100}, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] r100) throws IOException {
        write(r100, 0, r100.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] r100, int r101, int r102) throws IOException {
        if (r102 != 0) goto L4;
        return;
    L4:
        ((FilterOutputStream) this).out.write(String.format("%x\r\n", new Object[]{Integer.valueOf(r102)}).getBytes());
        ((FilterOutputStream) this).out.write(r100, r101, r102);
        ((FilterOutputStream) this).out.write("\r\n".getBytes());
    }
}
