package com.bytedance.ee.bear.list.more.more3;

import com.bytedance.ee.bear.list.DocumentListInfo;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ SpaceFolderMoreProvider a;
    public final /* synthetic */ SpaceFolderMoreProvider.b b;

    public p(SpaceFolderMoreProvider r1, SpaceFolderMoreProvider.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        DocumentListInfo r5 = (DocumentListInfo) r4;
        if (r5 != null) goto L5;
    L7:
        oj5.b r6 = this.b.c();
        if (r6 == null) goto L10;
        r6.r = false;
    L10:
        SpaceFolderMoreProvider.b r7 = this.b;
        r7.e(r7.c());
        return;
    L5:
        if (r5.getParent() == null) goto L7;
        tt5.a.h("SpaceFolderMoreProvider", "folderComplaintFlow ok. isComplaint= " + r5.getParent().Q1);
        this.a.m.Q1 = r5.getParent().Q1;
        goto L7
    }
}
