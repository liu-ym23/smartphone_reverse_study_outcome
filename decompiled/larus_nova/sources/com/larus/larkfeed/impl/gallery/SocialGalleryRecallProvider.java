package com.larus.larkfeed.impl.gallery;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class SocialGalleryRecallProvider extends com.larus.gallery.api.t<kza.m> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final kza.n f355192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LarkOfficeMaterialGalleryDataSource f355193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SocialGalleryRecallProvider$observer$1 f355194h;

    @Override // com.larus.gallery.api.t
    public final void t() {
        kza.c r100 = this.f355192f.f506789f;
        if (r100 == null) goto L6;
        r100.a(this.f355194h);
        return;
    }

    @Override // com.larus.gallery.api.t
    public final void u() {
        kza.c r100 = this.f355192f.f506789f;
        if (r100 == null) goto L6;
        r100.d(this.f355194h);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.larkfeed.impl.gallery.SocialGalleryRecallProvider$observer$1] */
    public SocialGalleryRecallProvider(kza.n r100, LarkOfficeMaterialGalleryDataSource r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "dataSource");
        this.f355192f = r100;
        this.f355193g = r101;
        this.f355194h = new SocialGalleryRecallProvider$observer$1(this);
    }
}
