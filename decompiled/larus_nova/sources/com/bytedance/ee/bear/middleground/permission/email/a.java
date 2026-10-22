package com.bytedance.ee.bear.middleground.permission.email;

import android.widget.LinearLayout;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InviteEmailRouteActivity.b f233842a;

    public a(InviteEmailRouteActivity.b r100) {
        this.f233842a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        LinearLayout r100 = this.f233842a.f233838a.get();
        if (r100 == null) goto L6;
        r100.setVisibility(0);
        return;
    }
}
