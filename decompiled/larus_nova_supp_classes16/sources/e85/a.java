package e85;

import b85.f0;
import com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency;
import w75.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a<FM extends w75.a> implements d<FM> {
    public final FM a;
    public final f0 b;
    public final IFileDownloadDependency c;
    public boolean d;
    public boolean e;
    public final a95.a f;

    @Override // e85.d
    public final void a(boolean r1) {
        this.e = r1;
    }

    @Override // e85.d
    public final void c(boolean r1) {
        this.d = r1;
    }

    public a(FM r1, f0 r2, IFileDownloadDependency r3, a95.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.f = r4;
    }
}
