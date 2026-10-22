package com.bytedance.ee.bear.middleground.permission.secret.detail;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SecretDetailFragment f234071a;

    public e(SecretDetailFragment r100) {
        this.f234071a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.suite.lark.component.navroute.forseti.g r101 = com.suite.lark.component.navroute.forseti.f.b(this.f234071a);
        if (r101 == null) goto L6;
        r101.g(null);
        return;
    }
}
