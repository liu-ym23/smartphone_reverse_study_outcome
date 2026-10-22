package com.bytedance.ee.bear.list.create;

import com.bytedance.ee.bear.list.DocumentListInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements nc5.a<DocumentListInfo> {
    public final /* synthetic */ i a;
    public final /* synthetic */ nc5.a<DocumentListInfo> b;

    @Override // nc5.a
    public final void onFailure(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        tt5.a.e(this.a.b, "createFolder network error", r4, false);
        this.b.onFailure(r4);
    }

    @Override // nc5.a
    public final void onSuccess(DocumentListInfo r3) {
        DocumentListInfo r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "result");
        tt5.a.h(this.a.b, "createFolder success");
        this.b.onSuccess(r4);
    }

    public k(i r1, nc5.a<DocumentListInfo> r2) {
        this.a = r1;
        this.b = r2;
    }
}
