package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import android.view.View;
import com.bytedance.awemeopen.apps.framework.base.view.DiggLayout;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class j extends g04.a<jz3.a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DiggLayout f195520e;

    @Override // g04.a
    public final void i() {
        if (this.f195520e.getChildCount() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        this.f195520e.removeAllViews();
        return;
    L9:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public j(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f195520e = (DiggLayout) e(R.id.item_digg_layout);
    }

    @Override // g04.a
    public final void f(jz3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }
}
