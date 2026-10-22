package jx4;

import com.ss.android.lark.vfs.VFSPath;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class b implements com.bytedance.ee.bear.doc.resupdate.f {
    public final com.bytedance.ee.bear.doc.resupdate.f a;

    @Override // u45.a
    public void onStart() {
        com.bytedance.ee.bear.doc.resupdate.f r0 = this.a;
        if (r0 == null) goto L6;
        r0.onStart();
        return;
    }

    public b() {
    }

    public b(com.bytedance.ee.bear.doc.resupdate.f r1) {
        this.a = r1;
    }

    @Override // u45.a
    public void a(int r2) {
        com.bytedance.ee.bear.doc.resupdate.f r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    @Override // u45.a
    public void b(VFSPath r2) {
        com.bytedance.ee.bear.doc.resupdate.f r0 = this.a;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    @Override // u45.a
    public void c(Exception r2) {
        com.bytedance.ee.bear.doc.resupdate.f r0 = this.a;
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.f
    public final void d(String r2) {
        com.bytedance.ee.bear.doc.resupdate.f r0 = this.a;
        if (r0 == null) goto L6;
        r0.d(r2);
        return;
    }
}
