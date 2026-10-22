package gbb;

import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends d {
    @Override // gbb.d, gbb.g
    public /* bridge */ /* synthetic */ void delete() throws IOException {
        super.delete();
    }

    @Override // gbb.d, gbb.g
    public final synchronized File c(String r100) throws IOException {
        monitor-enter(this);
        File r101 = ((b) this.f480770a).q(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public a(File r100, int r101, long r102) {
        int r103 = b.f480765q;     // Catch: IOException -> L8
        if (r100.exists() == true) goto L6;
        r100.mkdirs();     // Catch: IOException -> L8
    L6:
        this.f480770a = new b(r100, r101, r102);     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}
