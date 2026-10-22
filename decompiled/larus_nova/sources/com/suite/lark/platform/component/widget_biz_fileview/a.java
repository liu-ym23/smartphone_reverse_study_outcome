package com.suite.lark.platform.component.widget_biz_fileview;

import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileView f460922a;

    public a(FileView r100) {
        this.f460922a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f460922a.f460889j.setVisibility(8);
        FileView r101 = this.f460922a;
        FileView.c r102 = r101.f460897r;
        if (r102 == null) goto L5;
        r102.b(r101.f460896q);
    L5:
        FileView r103 = this.f460922a;
        FileView.FileState r104 = r103.f460896q.f460909h;
        if (r104.f460898a != 2) goto L11;
        r104.f460898a = 1;
        r103.f460889j.setVisibility(8);
        FileView r105 = this.f460922a;
        FileView.c r106 = r105.f460897r;
        if (r106 == null) goto L12;
        r106.d(r105.f460896q);
        return;
    L12:
        return;
    }
}
