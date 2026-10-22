package com.bytedance.ee.bear.fileselector;

import com.bytedance.ee.bear.fileselector.view.FilePanelDragView;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements FilePanelDragView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileSelectFragment f226783a;

    public b(FilePanelDragView r100, FileSelectFragment r101) {
        this.f226783a = r101;
    }

    @Override // com.bytedance.ee.bear.fileselector.view.FilePanelDragView.b
    public final void a(int r100) {
        FileSelectFragment r101 = this.f226783a;
        if (r100 != 0) goto L6;
        int r102 = FileSelectFragment.f226737q;
        r101.dismissDialog();
        return;
    }
}
