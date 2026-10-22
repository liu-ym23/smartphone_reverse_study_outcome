package com.bytedance.ee.bear.wikiv2.home2;

import android.view.View;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w implements View.OnClickListener {
    public final /* synthetic */ SpaceBean a;
    public final /* synthetic */ WikiHomeTopSpaceView b;

    public w(SpaceBean r1, WikiHomeTopSpaceView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        String r3 = this.a.space_id;
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L14;
        WikiHomeTopSpaceView.b r5 = this.b.f;
        if (r5 == null) goto L15;
        r5.a(this.a.space_id);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r4 = false;
        goto L9
    }
}
