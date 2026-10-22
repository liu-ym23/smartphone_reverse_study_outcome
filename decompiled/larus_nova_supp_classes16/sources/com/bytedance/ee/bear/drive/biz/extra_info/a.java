package com.bytedance.ee.bear.drive.biz.extra_info;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ FileExtraInfoView a;

    public a(FileExtraInfoView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        tt5.a.h("DriveComponent", "FileExtraInfoView#initListener click " + this.a.h);
        FileExtraInfoView.a r3 = this.a.h;
        if (r3 == null) goto L6;
        r3.c();
        return;
    }
}
