package e85;

import b85.f0;
import com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency;
import w75.a;

/* JADX INFO: loaded from: classes16.dex */
public abstract class a<FM extends w75.a> implements d<FM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FM f471355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0 f471356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IFileDownloadDependency f471357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f471358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f471359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a95.a f471360f;

    @Override // e85.d
    public final void a(boolean r100) {
        this.f471359e = r100;
    }

    @Override // e85.d
    public final void c(boolean r100) {
        this.f471358d = r100;
    }

    public a(FM r100, f0 r101, IFileDownloadDependency r102, a95.a r103) {
        this.f471355a = r100;
        this.f471356b = r101;
        this.f471357c = r102;
        this.f471360f = r103;
    }
}
