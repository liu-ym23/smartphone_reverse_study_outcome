package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer;
import com.bytedance.ee.bear.widget.AtEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t0 implements AtEditText.a {
    public final /* synthetic */ InputComment a;

    @Override // com.bytedance.ee.bear.widget.AtEditText.a
    public final void a() {
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText.a
    public final boolean b() {
        IImageViewer r0 = this.a.r0;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L14;
        IImageViewer r2 = this.a.r0;
        if (r2 == null) goto L12;
        r2.close();
    L12:
        return true;
    L14:
        if (this.a.X.isSelected() == false) goto L16;
        this.a.B(false);
    L16:
        return false;
    L5:
        if (r0.isShowing() != true) goto L7;
        r1 = true;
        goto L8
    }

    public t0(InputComment r1) {
        this.a = r1;
    }
}
