package com.bytedance.ee.bear.fileselector;

import com.bytedance.ee.bear.fileselector.view.FilePanelDragView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements FilePanelDragView.b {
    public final /* synthetic */ FileSelectFragment a;

    public b(FilePanelDragView r1, FileSelectFragment r2) {
        this.a = r2;
    }

    @Override // com.bytedance.ee.bear.fileselector.view.FilePanelDragView.b
    public final void a(int r2) {
        FileSelectFragment r0 = this.a;
        if (r2 != 0) goto L6;
        int r3 = FileSelectFragment.q;
        r0.dismissDialog();
        return;
    }
}
