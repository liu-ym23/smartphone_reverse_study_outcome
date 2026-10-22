package jx4;

import com.ss.android.lark.vfs.VFSPath;

/* JADX INFO: loaded from: classes16.dex */
public class b implements com.bytedance.ee.bear.doc.resupdate.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.doc.resupdate.f f500817a;

    @Override // u45.a
    public void onStart() {
        com.bytedance.ee.bear.doc.resupdate.f r100 = this.f500817a;
        if (r100 == null) goto L6;
        r100.onStart();
        return;
    }

    public b() {
    }

    public b(com.bytedance.ee.bear.doc.resupdate.f r100) {
        this.f500817a = r100;
    }

    @Override // u45.a
    public void a(int r100) {
        com.bytedance.ee.bear.doc.resupdate.f r101 = this.f500817a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // u45.a
    public void b(VFSPath r100) {
        com.bytedance.ee.bear.doc.resupdate.f r101 = this.f500817a;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // u45.a
    public void c(Exception r100) {
        com.bytedance.ee.bear.doc.resupdate.f r101 = this.f500817a;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.f
    public final void d(String r100) {
        com.bytedance.ee.bear.doc.resupdate.f r101 = this.f500817a;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }
}
