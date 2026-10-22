package com.bytedance.ee.bear.bitable.itemview.cell.cellview;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RichTextCell f213878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ qt4.a f213879b;

    public k(RichTextCell r100, qt4.a r101) {
        this.f213878a = r100;
        this.f213879b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f213878a.O("text click");
        qt4.a r101 = this.f213879b;
        if (r101 == null) goto L8;
        Runnable r102 = r101.f534789f;
        if (r102 == null) goto L9;
        r102.run();
        return;
    L9:
        return;
    }
}
