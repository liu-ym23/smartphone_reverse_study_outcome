package com.bytedance.ug.sdk.luckycat.impl.route;

/* JADX INFO: loaded from: classes22.dex */
public final class f extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gn7.b f271444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gn7.a f271445b;

    @Override // bk7.c
    public final void onLoadSucceed() {
        this.f271444a.onSuccess();
        gn7.a r100 = this.f271445b;
        if (r100 == null) goto L6;
        r100.getClass();
        return;
    }

    @Override // bk7.c
    public final void onShow() {
        gn7.a r100 = this.f271445b;
        if (r100 == null) goto L6;
        r100.getClass();
        return;
    }

    @Override // bk7.c
    public final void a(String r100) {
        this.f271444a.onFail(r100);
    }

    @Override // bk7.c
    public final void onClose(int r100) {
        gn7.a r101 = this.f271445b;
        if (r101 == null) goto L6;
        r101.getClass();
        return;
    }

    public f(gn7.b r100, gn7.a r101) {
        this.f271444a = r100;
        this.f271445b = r101;
    }
}
