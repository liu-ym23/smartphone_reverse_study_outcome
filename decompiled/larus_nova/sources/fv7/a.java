package fv7;

import ev7.c;
import ev7.e;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes23.dex */
public final class a extends e {
    public a() {
    }

    @Override // ev7.e
    public final void b(jv7.b r100, InputStream r101, OutputStream r102, c r103) throws IOException {
        int r104 = b.f478964a;
        BufferedInputStream r105 = new BufferedInputStream(r101, 4096);
        BufferedOutputStream r106 = new BufferedOutputStream(r102, 16384);
        b.a(r100, r106, r105);     // Catch: Throwable -> L6
        r106.flush();
        return;
    L6:
        th = move-exception;
        r106.flush();
        throw th;
    }
}
