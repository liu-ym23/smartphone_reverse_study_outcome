package b85;

import com.bytedance.ee.bear.drive.loader.download.DownCallback;
import com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency;
import com.bytedance.ee.bear.drive.loader.download.platform.DownloadOptions;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import java.util.HashSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t0 extends DownCallback {
    public final /* synthetic */ f85.a a;
    public final /* synthetic */ u75.b.a b;
    public final /* synthetic */ u0 c;

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public final void onFailure(DriveException r3) {
        super.onFailure(r3);
        u0 r0 = this.c;
        u75.b.a r1 = this.b;
        r0.getClass();
        u0.a(r3, r1);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.DownCallback, com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public final void onHitCache(w75.c r5) {
        super.onHitCache(r5);
        this.c.b.getDevReport().k("success", "DEC0", ((f85.a.C0229a) this.a.a).a, 2);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public final void onSubmit(String r4) {
        super.onSubmit(r4);
        ((HashSet) this.c.f).add(r4);
        this.c.b.getDevReport().b(((f85.a.C0229a) this.a.a).a, "rust_download", this.c.b.getPreviewStrategy());
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.DownCallback, com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
    public final void onSuccess(String r4, String r5) {
        super.onSuccess(r4, r5);
        this.c.b.getDevReport().k("success", "DEC0", ((f85.a.C0229a) this.a.a).a, 2);
    }

    public t0(u0 r8, w75.c r9, u75.b.a r10, IFileDownloadDependency r11, a95.a r12, DownloadOptions r13, f85.a r14, u75.b.a r16) {
        this.c = r8;
        this.a = r14;
        this.b = r16;
        super(r9, r10, r11, 2, r12, r13);
    }
}
