package com.bytedance.ee.bear.drive.biz.extra_info;

import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileExtraInfoView f222974a;

    public b(FileExtraInfoView r100) {
        this.f222974a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        tt5.a.h("DriveComponent", "FileExtraInfoView#mCommentInfoView click " + this.f222974a.f222961h);
        FileExtraInfoView r101 = this.f222974a;
        FileExtraInfoView.a r102 = r101.f222961h;
        if (r102 == null) goto L6;
        r102.b(r101.f222958e);
        return;
    }
}
