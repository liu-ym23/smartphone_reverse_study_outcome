package b85;

import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s0 implements u75.b.a {
    public final /* synthetic */ u75.b.a a;

    public s0(u75.b.a r1) {
        this.a = r1;
    }

    @Override // u75.b.a
    public final void b(com.bytedance.ee.bear.drive.view.preview.wrapper.z r2) {
        this.a.b(r2);
    }

    @Override // u75.b.a
    public final void c(ErrCode r2) {
        this.a.c(r2);
    }

    @Override // u75.b.a
    public final void onProgress(int r2) {
        if (r2 < 10) goto L6;
        this.a.onProgress(r2);
        return;
    }

    @Override // u75.b.a
    public final <I> void a(InfoCode r2, I r3) {
        this.a.a(r2, r3);
    }
}
