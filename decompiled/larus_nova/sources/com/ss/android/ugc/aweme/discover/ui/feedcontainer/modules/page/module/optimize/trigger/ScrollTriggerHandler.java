package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.trigger;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.ugc.android.cachalot.api.Trigger;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/trigger/ScrollTriggerHandler;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScrollTriggerHandler extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OnScrollStateChangedHandler f450766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OnScrollHandler f450767b;

    public ScrollTriggerHandler(TriggerEnterParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f450766a = new OnScrollStateChangedHandler(r100);
        this.f450767b = new OnScrollHandler(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrollStateChanged(r100, r101);
        this.f450766a.d(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrolled(r100, r101, r110);
        OnScrollHandler r102 = this.f450767b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Queue r103 = r102.f450746e.f450768a.i().f(r100, r110);
        if (r103 != null) goto L5;
        return;
    L5:
        if ((!r103.isEmpty()) == false) goto L9;
        r102.b(r103, Trigger.SCROLL, false, true, false);
        return;
    }
}
