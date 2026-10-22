package com.bytedance.ee.bear.list.more.more3;

import com.bytedance.ee.bear.list.DocumentListInfo;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpaceFolderMoreProvider f228791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SpaceFolderMoreProvider.b f228792b;

    public p(SpaceFolderMoreProvider r100, SpaceFolderMoreProvider.b r101) {
        this.f228791a = r100;
        this.f228792b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        DocumentListInfo r101 = (DocumentListInfo) r100;
        if (r101 != null) goto L5;
    L7:
        oj5.b r102 = this.f228792b.c();
        if (r102 == null) goto L10;
        r102.f523573r = false;
    L10:
        SpaceFolderMoreProvider.b r103 = this.f228792b;
        r103.e(r103.c());
        return;
    L5:
        if (r101.getParent() == null) goto L7;
        tt5.a.h("SpaceFolderMoreProvider", "folderComplaintFlow ok. isComplaint= " + r101.getParent().Q1);
        this.f228791a.f228716m.Q1 = r101.getParent().Q1;
        goto L7
    }
}
