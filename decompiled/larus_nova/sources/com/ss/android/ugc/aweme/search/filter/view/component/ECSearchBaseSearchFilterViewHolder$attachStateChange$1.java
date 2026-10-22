package com.ss.android.ugc.aweme.search.filter.view.component;

import android.view.View;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/ss/android/ugc/aweme/search/filter/view/component/ECSearchBaseSearchFilterViewHolder$attachStateChange$1", "Landroid/view/View$OnAttachStateChangeListener;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchBaseSearchFilterViewHolder$attachStateChange$1 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECSearchBaseSearchFilterViewHolder f452991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f452992b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f452992b.post(new ECSearchBaseSearchFilterViewHolder$attachStateChange$1$onViewAttachedToWindow$1(this));
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Logger.a("onViewDetachedFromWindow", "onViewDetachedFromWindow");
    }

    public ECSearchBaseSearchFilterViewHolder$attachStateChange$1(ECSearchBaseSearchFilterViewHolder r100, View r101) {
        this.f452991a = r100;
        this.f452992b = r101;
    }
}
