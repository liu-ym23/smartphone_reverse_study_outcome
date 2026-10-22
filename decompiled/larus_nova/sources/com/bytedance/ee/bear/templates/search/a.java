package com.bytedance.ee.bear.templates.search;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.templates.search.recommend.RecommendView;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchFragment f239340a;

    public a(SearchFragment r100) {
        this.f239340a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((ConnectionService.NetworkState) r100).a() == false) goto L18;
        RecommendView r101 = this.f239340a.f239323i;
        RecommendView r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recommendView");
        r101 = null;
    L8:
        if (r101.getVisibility() == 8) goto L19;
        Disposable r103 = this.f239340a.f239324j;
        if (r103 == null) goto L12;
        r103.dispose();
    L12:
        SearchFragment r104 = this.f239340a;
        RecommendView r105 = r104.f239323i;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("recommendView");
    L16:
        r104.f239324j = r102.a();
        return;
    L15:
        r102 = r105;
        goto L16
    L19:
        return;
    }
}
