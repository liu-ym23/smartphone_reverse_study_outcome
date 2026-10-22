package com.ss.android.lark.ug.banner.ui.template;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TemplateItemAdapter f444403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TemplateItemAdapter.b f444404b;

    public a(TemplateItemAdapter r100, int r101, TemplateItemAdapter.b r102) {
        this.f444403a = r100;
        this.f444404b = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TemplateItemAdapter.a r101 = this.f444403a.f444400a;
        if (r101 == null) goto L6;
        r101.a(r100, this.f444404b.a());
        return;
    }
}
