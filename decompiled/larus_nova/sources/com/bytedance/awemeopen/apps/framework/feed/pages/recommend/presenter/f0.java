package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import android.view.View;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f0 extends g04.a<jz3.a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a f195507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f195508f;

    public f0(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r100) {
        Intrinsics.checkNotNullParameter(r100, "feedGroupParameters");
        super(r100.f195161a);
        this.f195507e = r100;
    }

    @Override // g04.a
    public final void f(jz3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (this.f195508f == true) goto L7;
        final View r101 = this.f479457a.findViewById(R.id.feed_page);
        Intrinsics.checkNotNull(r101);
        r101.post(new e0(r101, this));
        return;
    }
}
