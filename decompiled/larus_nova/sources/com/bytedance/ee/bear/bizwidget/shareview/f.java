package com.bytedance.ee.bear.bizwidget.shareview;

import android.app.Dialog;
import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h.a f216547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h.c f216548b;

    public /* synthetic */ f(h.a r100, h.c r101) {
        this.f216547a = r100;
        this.f216548b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        h.a r101 = this.f216547a;
        h.c r102 = this.f216548b;
        r101.getClass();
        r102.a();
        h r103 = r101.f216558a;
        Dialog r104 = r103.f216551b;
        if (r104 != null) goto L5;
        return;
    L5:
        if (r104.isShowing() == false) goto L9;
        h.a(r103.f216551b);
        return;
    }
}
