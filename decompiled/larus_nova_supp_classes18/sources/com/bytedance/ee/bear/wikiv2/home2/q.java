package com.bytedance.ee.bear.wikiv2.home2;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q implements View.OnClickListener {
    public final /* synthetic */ SwipeMenuLayout a;
    public final /* synthetic */ SpaceBean b;
    public final /* synthetic */ WikiHomeRecentSpaceView c;

    public q(SwipeMenuLayout r1, SpaceBean r2, WikiHomeRecentSpaceView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.a.b();
        String r5 = this.b.space_id;
        if (r5 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == true) goto L14;
        WikiHomeRecentSpaceView.b r7 = this.c.k;
        if (r7 == null) goto L15;
        SpaceBean r1 = this.b;
        r7.N2(r1.space_id, true ^ r1.is_star);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r6 = false;
        goto L9
    }
}
