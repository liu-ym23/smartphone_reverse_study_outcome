package com.bytedance.ee.bear.list.share;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t2 extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ ShareFolderListStyleAdapter c;

    public t2(ShareFolderListStyleAdapter r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r2) {
        View.OnClickListener r0 = this.c.o;
        if (r0 == null) goto L6;
        r0.onClick(r2);
        return;
    }
}
