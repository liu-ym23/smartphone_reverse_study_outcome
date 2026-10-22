package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import android.view.View;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ WikiSpaceListRvView a;
    public final /* synthetic */ SpaceBean b;
    public final /* synthetic */ int c;

    public d(WikiSpaceListRvView r1, SpaceBean r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        WikiSpaceListRvView.a r4 = this.a.getViewDelegate();
        if (r4 == null) goto L6;
        r4.a(this.b, this.c);
        return;
    }
}
