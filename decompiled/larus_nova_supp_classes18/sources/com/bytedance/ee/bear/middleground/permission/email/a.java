package com.bytedance.ee.bear.middleground.permission.email;

import android.widget.LinearLayout;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements Action {
    public final /* synthetic */ InviteEmailRouteActivity.b a;

    public a(InviteEmailRouteActivity.b r1) {
        this.a = r1;
    }

    public final void run() {
        LinearLayout r0 = this.a.a.get();
        if (r0 == null) goto L6;
        r0.setVisibility(0);
        return;
    }
}
