package com.bytedance.awemeopen.apps.photo.presenter;

/* JADX INFO: loaded from: classes14.dex */
public final class j0 implements nz3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PhotoPagerPresenter f197982a;

    @Override // nz3.d
    public final void a() {
        nz3.d r100 = this.f197982a.Q;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // nz3.d
    public final boolean b() {
        nz3.d r100 = this.f197982a.Q;
        if (r100 == null) goto L5;
        boolean r101 = r100.b();
    L6:
        if (r101 == true) goto L8;
    L10:
        return false;
    L8:
        if (this.f197982a.A != 0) goto L10;
        return true;
    L5:
        r101 = true;
        goto L6
    }

    @Override // nz3.d
    public final void c() {
        nz3.d r100 = this.f197982a.Q;
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    @Override // nz3.d
    public final boolean d() {
        nz3.d r100 = this.f197982a.Q;
        if (r100 == null) goto L5;
        boolean r101 = r100.d();
    L6:
        if (r101 == false) goto L10;
        PhotoPagerPresenter r102 = this.f197982a;
        if (r102.A != (r102.o() - 1)) goto L10;
        return true;
    L10:
        return false;
    L5:
        r101 = true;
        goto L6
    }

    public j0(PhotoPagerPresenter r100) {
        this.f197982a = r100;
    }
}
