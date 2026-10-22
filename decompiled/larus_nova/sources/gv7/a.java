package gv7;

import ev7.c;
import ev7.e;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import kgc.d;

/* JADX INFO: loaded from: classes23.dex */
public final class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f482838a;

    public a(b r100) {
        this.f482838a = r100;
    }

    @Override // ev7.e
    public final void b(jv7.b r100, InputStream r101, OutputStream r102, c r103) throws IOException {
        d r104 = (d) this.f482838a;
        r104.getClass();
        File r105 = null;
        r105 = r104.d(Collections.singletonList(r100), r101);     // Catch: Throwable -> L8
        if (r105.length() <= 0) goto L6;
        jgc.d.d(r102, r105);     // Catch: Throwable -> L8
    L6:
        r105.delete();
        return;
    L8:
        th = move-exception;
        if (r105 == null) goto L11;
        r105.delete();
    L11:
        throw th;
    }
}
