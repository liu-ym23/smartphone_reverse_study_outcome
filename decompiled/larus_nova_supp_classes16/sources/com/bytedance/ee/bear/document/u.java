package com.bytedance.ee.bear.document;

import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class u implements com.bytedance.ee.bear.document.multitask.a.b {
    public final /* synthetic */ DocActivity a;

    public /* synthetic */ u(DocActivity r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.document.multitask.a.b
    public final DocumentPluginHost getPluginHost() {
        Fragment r0 = this.a.getSupportFragmentManager().findFragmentById(2131369388);
        if ((r0 instanceof DocumentFragment) == false) goto L5;
        DocumentFragment r1 = (DocumentFragment) r0;
    L6:
        if (r1 != null) goto L9;
        return null;
    L9:
        return (DocumentPluginHost) r1.e;
    L5:
        r1 = null;
        goto L6
    }
}
