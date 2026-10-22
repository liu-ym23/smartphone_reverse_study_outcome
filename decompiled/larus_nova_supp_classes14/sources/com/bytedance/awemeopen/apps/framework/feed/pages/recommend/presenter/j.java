package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import android.view.View;
import com.bytedance.awemeopen.apps.framework.base.view.DiggLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j extends g04.a<jz3.a> {
    public final DiggLayout e;

    @Override // g04.a
    public final void i() {
        if (this.e.getChildCount() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        this.e.removeAllViews();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public j(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.e = (DiggLayout) e(2131375734);
    }

    @Override // g04.a
    public final void f(jz3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }
}
