package com.bytedance.ee.bear.drive.biz.extra_info;

import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileExtraInfoView f222973a;

    public a(FileExtraInfoView r100) {
        this.f222973a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        tt5.a.h("DriveComponent", "FileExtraInfoView#initListener click " + this.f222973a.f222961h);
        FileExtraInfoView.a r101 = this.f222973a.f222961h;
        if (r101 == null) goto L6;
        r101.c();
        return;
    }
}
