package com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async;

import android.webkit.ValueCallback;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.TableDataModel;
import io.reactivex.FlowableEmitter;
import kotlin.jvm.internal.Intrinsics;
import nq4.d;

/* JADX INFO: loaded from: classes15.dex */
public final class c<T> implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ nq4.a<d> f209084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowableEmitter<AsyncFetchResult<d>> f209085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ nq4.c<d> f209086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a f209087d;

    /* JADX WARN: Multi-variable type inference failed */
    public c(nq4.a<? extends d> r100, FlowableEmitter<AsyncFetchResult<d>> r101, nq4.c<d> r102, a r103) {
        this.f209084a = r100;
        this.f209085b = r101;
        this.f209086c = r102;
        this.f209087d = r103;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r100) {
        String r101 = (String) r100;
        nq4.a<d> r102 = this.f209084a;     // Catch: Exception -> L15
        Intrinsics.checkNotNull(r101);     // Catch: Exception -> L15
        TableDataModel r103 = r102.parse(r101);     // Catch: Exception -> L15
        if (r103 == null) goto L14;
        if (r103.isLoading() == true) goto L12;
        tt5.a.h("AsyncFetchManager", "tryAsyncFetch, loaded");     // Catch: Exception -> L15
        if (this.f209085b.isCancelled() == true) goto L10;
        this.f209085b.onNext(new AsyncFetchResult(r103, AsyncFetchResult.EResultState.LOADED));     // Catch: Exception -> L15
        this.f209085b.onComplete();     // Catch: Exception -> L15
    L11:
        this.f209087d.f209055b.remove(this.f209086c);     // Catch: Exception -> L15
        a r104 = this.f209087d;     // Catch: Exception -> L15
        nq4.c<d> r105 = this.f209086c;     // Catch: Exception -> L15
        r104.getClass();     // Catch: Exception -> L15
        a.c(r105);     // Catch: Exception -> L15
        return;
    L10:
        tt5.a.h("AsyncFetchManager", "tryAsyncFetch, task " + this.f209086c + " is already canceled");     // Catch: Exception -> L15
        goto L11
    L12:
        tt5.a.b("AsyncFetchManager", "tryAsyncFetch, loading...");     // Catch: Exception -> L15
        return;
    L14:
        throw new IllegalArgumentException("value is null!");     // Catch: Exception -> L15
    L15:
        e = move-exception;
        tt5.a.e("AsyncFetchManager", "tryAsyncFetch, parse failed", e, false);
        if (this.f209085b.isCancelled() == true) goto L23;
        this.f209085b.onError(e);
        return;
    }
}
