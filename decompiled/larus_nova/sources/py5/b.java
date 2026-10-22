package py5;

import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.iesgurd.i;
import com.bytedance.iesgurd.j;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.utils.GeckoExecutors;
import java.io.IOException;
import java.io.OutputStream;
import wy5.c;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f531035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f531036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f531037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ny5.a f531038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f531039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PrepareMeta f531040f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f531041g;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
    }

    public final void a(int r110) {
        this.f531035a += (long) r110;
        long r100 = System.currentTimeMillis();
        if ((r100 - this.f531037c) < 100) goto L5;
    L7:
        this.f531037c = r100;
        j r101 = this.f531039e;
        UpdatePackage r102 = this.f531040f.getPack();
        long r103 = this.f531041g;
        long r104 = this.f531035a;
        if (r101.f250720m == null) goto L10;
    L12:
        GeckoExecutors.a().execute(new i(r101, r102, r103, r104));
        return;
    L10:
        if (r101.f250710c != null) goto L12;
        return;
    L5:
        if (this.f531035a >= this.f531041g) goto L7;
    }

    @Override // java.io.OutputStream
    public final void write(int r100) throws IOException {
        this.f531038d.write(r100);
        a(4);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r100) throws IOException {
        this.f531038d.write(r100);
        a(r100.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r100, int r101, int r102) throws IOException {
        this.f531038d.write(r100, r101, r102);
        a(r102);
    }

    public b(ny5.a r100, j r101, PrepareMeta r102, long r103) {
        this.f531038d = r100;
        this.f531039e = r101;
        this.f531040f = r102;
        this.f531041g = r103;
    }
}
