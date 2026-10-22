package com.bytedance.ee.bear.list.create;

import com.bytedance.ee.bear.list.DocumentListInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements nc5.a<DocumentListInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f227742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ nc5.a<DocumentListInfo> f227743b;

    @Override // nc5.a
    public final void onFailure(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        tt5.a.e(this.f227742a.f227735b, "createFolder network error", r100, false);
        this.f227743b.onFailure(r100);
    }

    @Override // nc5.a
    public final void onSuccess(DocumentListInfo r100) {
        DocumentListInfo r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        tt5.a.h(this.f227742a.f227735b, "createFolder success");
        this.f227743b.onSuccess(r101);
    }

    public k(i r100, nc5.a<DocumentListInfo> r101) {
        this.f227742a = r100;
        this.f227743b = r101;
    }
}
