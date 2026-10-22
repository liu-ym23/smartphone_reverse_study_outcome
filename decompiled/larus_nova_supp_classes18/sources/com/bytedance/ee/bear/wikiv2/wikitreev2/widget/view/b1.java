package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import com.bytedance.ee.bear.DocObjInfo;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b1<T> implements Consumer {
    public final /* synthetic */ WikiTreeCtrlView a;
    public final /* synthetic */ String b;

    public b1(WikiTreeCtrlView r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        DocObjInfo r6 = (DocObjInfo) r5;
        tt5.a.b(this.a.e, "fetchDocObjInfo. sucess");
        if (r6 == null) goto L13;
        WikiTreeCtrlView r0 = this.a;
        String r1 = this.b;
        if (r0.f == null) goto L14;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r2 = r0.getViewModel();
        if (r2 == null) goto L9;
        r2.updatePinStatus(r1, r6.isPined());
    L9:
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r3 = r0.getViewModel();
        if (r3 == null) goto L15;
        r3.updateStarStatus(r1, r6.isStared());
        return;
    L15:
        return;
    L14:
        return;
    }
}
