package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes41.dex */
public class ig extends ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected InputStream f464115a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected OutputStream f958a;

    public ig() {
        this.f464115a = null;
        this.f958a = null;
    }

    public ig(OutputStream r100) {
        this.f464115a = null;
        this.f958a = r100;
    }

    @Override // com.xiaomi.push.ij
    public int a(byte[] r100, int r101, int r102) {
        InputStream r103 = this.f464115a;
        if (r103 == null) goto L13;
        int r104 = r103.read(r100, r101, r102);     // Catch: IOException -> L9
        if (r104 < 0) goto L8;
        return r104;
    L8:
        throw new ik(4);
    L9:
        e = move-exception;
        throw new ik(0, e);
    L13:
        throw new ik(1, "Cannot read from null inputStream");
    }

    @Override // com.xiaomi.push.ij
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo9290a(byte[] r100, int r101, int r102) {
        OutputStream r103 = this.f958a;
        if (r103 == null) goto L10;
        r103.write(r100, r101, r102);     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        throw new ik(0, e);
    L10:
        throw new ik(1, "Cannot write to null outputStream");
    }
}
