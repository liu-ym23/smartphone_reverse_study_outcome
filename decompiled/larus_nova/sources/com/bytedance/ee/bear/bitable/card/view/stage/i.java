package com.bytedance.ee.bear.bitable.card.view.stage;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes15.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StageDataViewHolder f208727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.larksuite.component.universe_design.menu.c f208728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f208729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f208730d;

    public i(StageDataViewHolder r100, com.larksuite.component.universe_design.menu.c r101, View r102, View r103) {
        this.f208727a = r100;
        this.f208728b = r101;
        this.f208729c = r102;
        this.f208730d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f208727a.f208670a.a(this.f208728b);
        ViewParent r101 = this.f208729c.getParent();
        if (r101 != null) goto L5;
    L7:
        this.f208728b.b(this.f208730d);
        b r102 = this.f208727a.f208670a.getView();
        if (r102 == null) goto L11;
        r102.GY(r100);
        return;
    L11:
        return;
    L5:
        if ((r101 instanceof ViewGroup) == false) goto L7;
        ((ViewGroup) r101).removeAllViews();
        goto L7
    }
}
