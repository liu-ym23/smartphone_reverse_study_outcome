package com.bytedance.ee.bear.list.recent;

import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u implements gd5.a {
    public final /* synthetic */ v a;

    @Override // gd5.a
    public final void a() {
        this.a.getClass();
        tt5.a.h("RecentDocumentModel", "showListNotify()...");
        com.bytedance.ee.bear.list.list.e.a r0 = this.a.i;
        if (r0 == null) goto L6;
        r0.a5();
        return;
    }

    public u(v r1) {
        this.a = r1;
    }

    @Override // gd5.a
    public final void b(ArrayList<Document> r3) {
        this.a.getClass();
        tt5.a.h("RecentDocumentModel", "onListChanged()...new size = " + hu5.a.c(r3));
        v r0 = this.a;
        r0.getClass();
        new z0(r0.k).a(r3);
    }
}
