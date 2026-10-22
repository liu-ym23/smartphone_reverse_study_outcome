package jv7;

import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes23.dex */
public abstract class d extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f500560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f500561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f500562c;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f500562c == false) goto L10;
        File r100 = this.f500560a;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.exists() == false) goto L12;
        r100.delete();
        return;
    L12:
        return;
    }

    @Override // jv7.b
    public final long b() {
        return this.f500561b;
    }

    public d(File r100, boolean r101) {
        this.f500560a = r100;
        this.f500561b = r100.length();
        this.f500562c = r101;
    }
}
