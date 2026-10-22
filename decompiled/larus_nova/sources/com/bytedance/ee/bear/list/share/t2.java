package com.bytedance.ee.bear.list.share;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class t2 extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ShareFolderListStyleAdapter f229532c;

    public t2(ShareFolderListStyleAdapter r100) {
        this.f229532c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        View.OnClickListener r101 = this.f229532c.f229435o;
        if (r101 == null) goto L6;
        r101.onClick(r100);
        return;
    }
}
