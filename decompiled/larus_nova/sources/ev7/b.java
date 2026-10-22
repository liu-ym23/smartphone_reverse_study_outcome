package ev7;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes23.dex */
public final class b implements a.InterfaceC5824a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.b f474470a;

    @Override // ev7.a.InterfaceC5824a
    public final Object a() {
        return this.f474470a.f474466e;
    }

    @Override // ev7.a.InterfaceC5824a
    public final jv7.b b() throws IOException {
        this.f474470a.f474467f.await();     // Catch: InterruptedException -> L4
    L6:
        File r100 = this.f474470a.f474465d;
        if (r100 != null) goto L9;
    L11:
        byte[] r101 = this.f474470a.f474468g;
        if (r101 != null) goto L19;
        return null;
    L19:
        return new jv7.a(r101);
    L9:
        if (r100.exists() == false) goto L11;
        return new jv7.g(this.f474470a.f474465d, 0);
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    @Override // ev7.a.InterfaceC5824a
    public final void destroy() {
        File r100 = this.f474470a.f474465d;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.exists() == false) goto L9;
        this.f474470a.f474465d.delete();
        return;
    }

    @Override // ev7.a.InterfaceC5824a
    public final long getLength() {
        this.f474470a.f474467f.await();     // Catch: InterruptedException -> L4
    L6:
        File r100 = this.f474470a.f474465d;
        if (r100 != null) goto L9;
    L12:
        byte[] r101 = this.f474470a.f474468g;
        if (r101 != null) goto L15;
        return 0;
    L15:
        return r101.length;
    L9:
        if (r100.exists() == false) goto L12;
        return this.f474470a.f474465d.length();
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    @Override // ev7.a.InterfaceC5824a
    public final InputStream openStream() throws IOException {
        this.f474470a.f474467f.await();     // Catch: InterruptedException -> L4
    L6:
        a.b r100 = this.f474470a;
        if (r100.f474469h != null) goto L29;
        File r101 = r100.f474465d;
        if (r101 == null) goto L16;
        if (r101.exists() == false) goto L14;
        InputStream r102 = new PolarisFileInputStreamWrapper(this.f474470a.f474465d);
    L19:
        if (r102 != null) goto L27;
        if (this.f474470a.f474469h == null) goto L25;
        throw new IOException("no cache data", this.f474470a.f474469h);
    L25:
        throw new IOException("no cache data for unknown reason");
    L27:
        return new BufferedInputStream(r102);
    L14:
        throw new IOException("no cache data for file deleted");
    L16:
        if (r100.f474468g == null) goto L18;
        r102 = new ByteArrayInputStream(this.f474470a.f474468g);
        goto L19
    L18:
        r102 = null;
        goto L19
    L29:
        throw new IOException("exception on exec", this.f474470a.f474469h);
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    public b(a.b r100) {
        this.f474470a = r100;
    }
}
