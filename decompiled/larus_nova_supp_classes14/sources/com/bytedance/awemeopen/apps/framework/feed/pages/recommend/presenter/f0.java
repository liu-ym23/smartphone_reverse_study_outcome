package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f0 extends g04.a<jz3.a> {
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a e;
    public boolean f;

    public f0(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r2) {
        Intrinsics.checkNotNullParameter(r2, "feedGroupParameters");
        super(r2.a);
        this.e = r2;
    }

    @Override // g04.a
    public final void f(jz3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (this.f == true) goto L7;
        final View r3 = this.a.findViewById(2131372243);
        Intrinsics.checkNotNull(r3);
        r3.post(new e0(r3, this));
        return;
    }
}
