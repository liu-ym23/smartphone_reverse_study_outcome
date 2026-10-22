package rk4;

import com.alibaba.gaiax.template.GXTemplateKey;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import pk4.j;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends ForwardingSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f538252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c.a f538253b;

    public b(c.a r100, BufferedSource r101) {
        this.f538253b = r100;
        super(r101);
        this.f538252a = 0;
    }

    @Override // okio.ForwardingSource, okio.Source
    public final long read(Buffer r100, long r101) throws IOException {
        long r102 = super.read(r100, r101);
        long r103 = this.f538252a;
        if (r102 == (-1)) goto L5;
        long r104 = r102;
    L6:
        this.f538252a = r103 + r104;
        long r105 = this.f538253b.f538254a.contentLength();
        if (r105 == (-1)) goto L9;
        j.a("VisionLoggingInterceptor", "progress: " + r102 + " / " + this.f538252a + " / " + r105 + "; " + ((int) ((this.f538252a * 100) / r105)) + GXTemplateKey.GAIAX_PE);
    L9:
        return r102;
    L5:
        r104 = 0;
        goto L6
    }
}
