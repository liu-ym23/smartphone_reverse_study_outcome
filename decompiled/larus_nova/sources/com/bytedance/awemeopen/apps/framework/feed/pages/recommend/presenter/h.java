package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h extends g04.a<jz3.a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a f195511e;

    public h(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r100) {
        Intrinsics.checkNotNullParameter(r100, "feedGroupParameters");
        super(r100.f195161a);
        this.f195511e = r100;
    }

    @Override // g04.a
    public final void f(jz3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f195511e.f195163c.getUIConfig();
    }
}
