package com.bytedance.ee.bear.list.folder.complaint;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes18.dex */
public final class g extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FolderComplaintSuccessFragment f228096c;

    public g(FolderComplaintSuccessFragment r100) {
        this.f228096c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        if (this.f228096c.getActivity() == null) goto L6;
        this.f228096c.getActivity().onBackPressed();
        return;
    }
}
