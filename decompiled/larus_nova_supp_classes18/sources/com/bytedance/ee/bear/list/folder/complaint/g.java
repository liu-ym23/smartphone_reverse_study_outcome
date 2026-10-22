package com.bytedance.ee.bear.list.folder.complaint;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends t {
    public final /* synthetic */ FolderComplaintSuccessFragment c;

    public g(FolderComplaintSuccessFragment r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r1) {
        if (this.c.getActivity() == null) goto L6;
        this.c.getActivity().onBackPressed();
        return;
    }
}
