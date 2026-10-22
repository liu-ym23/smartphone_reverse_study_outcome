package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.trigger;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.android.cachalot.api.Trigger;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/trigger/OnScrollStateChangedHandler;", "Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/trigger/AbsTriggerHandler;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OnScrollStateChangedHandler extends AbsTriggerHandler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f450747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f450748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TriggerEnterParams f450749g;

    @Override // com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.trigger.AbsTriggerHandler
    public final void a() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Queue<Integer> r100 = this.f450749g.getContext().i().C(this.f450747e, this.f450748f);     // Catch: Throwable -> L8
        if (r100 != null) goto L5;
        return;
    L5:
        if ((!r100.isEmpty()) == false) goto L15;
        AbsTriggerHandler.c(this, r100, Trigger.SCROLL_STOP, 12);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }

    public OnScrollStateChangedHandler(TriggerEnterParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        super(r100);
        this.f450749g = r100;
        this.f450747e = r100.f450769b;
    }

    public final void d(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f450748f = r101;
        this.f450749g.getContext().i().c();
        run();
    }
}
