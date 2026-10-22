package com.larus.larkfeed.impl.gallery;

/* JADX INFO: loaded from: classes30.dex */
public final class e implements kza.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarkImageView f355210a;

    public e(LarkImageView r100) {
        this.f355210a = r100;
    }

    @Override // kza.g
    public final void a(boolean r100) {
        LarkImageView r101 = this.f355210a;
        r101.f355178i = r100;
        com.larus.gallery.api.j r102 = r101.f355176g;
        if (r102 == null) goto L6;
        r102.c(r100);
        return;
    }

    @Override // kza.g
    public final void b(boolean r100) {
        LarkImageView r101 = this.f355210a;
        r101.f355177h = r100;
        com.larus.gallery.api.j r102 = r101.f355176g;
        if (r102 == null) goto L6;
        r102.a(r100);
        return;
    }
}
