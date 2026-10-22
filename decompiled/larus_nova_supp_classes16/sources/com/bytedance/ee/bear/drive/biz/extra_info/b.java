package com.bytedance.ee.bear.drive.biz.extra_info;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ FileExtraInfoView a;

    public b(FileExtraInfoView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        tt5.a.h("DriveComponent", "FileExtraInfoView#mCommentInfoView click " + this.a.h);
        FileExtraInfoView r3 = this.a;
        FileExtraInfoView.a r0 = r3.h;
        if (r0 == null) goto L6;
        r0.b(r3.e);
        return;
    }
}
