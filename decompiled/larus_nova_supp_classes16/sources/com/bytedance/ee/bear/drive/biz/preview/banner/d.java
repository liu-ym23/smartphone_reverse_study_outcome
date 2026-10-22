package com.bytedance.ee.bear.drive.biz.preview.banner;

import android.view.View;
import com.larksuite.component.universe_design.notice.UDNotice;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ a.b a;
    public final /* synthetic */ a b;

    public d(a.b r1, a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.h.onClick(r2);
        UDNotice r3 = this.b.f;
        if (r3 == null) goto L5;
        r3.setVisibility(8);
    L5:
        this.b.f();
        this.b.b();
    }
}
