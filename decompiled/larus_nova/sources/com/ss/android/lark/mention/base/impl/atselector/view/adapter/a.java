package com.ss.android.lark.mention.base.impl.atselector.view.adapter;

import android.view.View;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.view.AtView;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseAtBean f431838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtHeaderSelectedAdapter f431839b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AtHeaderSelectedAdapter.a r101 = this.f431839b.f431832b;
        if (r101 != null) goto L5;
        return;
    L5:
        BaseAtBean r102 = this.f431838a;
        ((AtView.c) r101).f431826a.f431818i.c5(r102);
    }

    public a(AtHeaderSelectedAdapter r100, BaseAtBean r101) {
        this.f431839b = r100;
        this.f431838a = r101;
    }
}
