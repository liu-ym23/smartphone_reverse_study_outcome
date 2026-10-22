package com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async;

import com.alibaba.fastjson.JSONObject;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.FlowableEmitter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import nq4.d;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f209077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ nq4.a<Object> f209078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f209079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f209080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ JSONObject f209081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ FlowableEmitter<AsyncFetchResult<Object>> f209082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<nq4.c<d>> f209083g;

    public b(a r100, nq4.a<Object> r101, String r102, String r103, JSONObject r104, FlowableEmitter<AsyncFetchResult<Object>> r105, Ref.ObjectRef<nq4.c<d>> r106) {
        this.f209077a = r100;
        this.f209078b = r101;
        this.f209079c = r102;
        this.f209080d = r103;
        this.f209081e = r104;
        this.f209082f = r105;
        this.f209083g = r106;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r100 = this.f209077a;     // Catch: Throwable -> L4
        nq4.a<Object> r101 = this.f209078b;     // Catch: Throwable -> L4
        String r102 = this.f209079c;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L4
        String r103 = this.f209080d;     // Catch: Throwable -> L4
        JSONObject r104 = this.f209081e;     // Catch: Throwable -> L4
        FlowableEmitter<AsyncFetchResult<Object>> r105 = this.f209082f;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L4
        a.a(r100, r101, r102, r103, r104, r105, this.f209083g.element);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
