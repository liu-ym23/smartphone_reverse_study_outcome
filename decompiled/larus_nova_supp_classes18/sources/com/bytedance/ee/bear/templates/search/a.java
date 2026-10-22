package com.bytedance.ee.bear.templates.search;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.templates.search.recommend.RecommendView;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ SearchFragment a;

    public a(SearchFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        if (((ConnectionService.NetworkState) r4).a() == false) goto L18;
        RecommendView r5 = this.a.i;
        RecommendView r0 = null;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recommendView");
        r5 = null;
    L8:
        if (r5.getVisibility() == 8) goto L19;
        Disposable r6 = this.a.j;
        if (r6 == null) goto L12;
        r6.dispose();
    L12:
        SearchFragment r7 = this.a;
        RecommendView r2 = r7.i;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("recommendView");
    L16:
        r7.j = r0.a();
        return;
    L15:
        r0 = r2;
        goto L16
    L19:
        return;
    }
}
