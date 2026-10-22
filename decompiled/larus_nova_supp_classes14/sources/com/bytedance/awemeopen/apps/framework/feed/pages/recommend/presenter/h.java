package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends g04.a<jz3.a> {
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a e;

    public h(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r2) {
        Intrinsics.checkNotNullParameter(r2, "feedGroupParameters");
        super(r2.a);
        this.e = r2;
    }

    @Override // g04.a
    public final void f(jz3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.e.c.getUIConfig();
    }
}
