package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.trigger;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.android.cachalot.api.Trigger;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/trigger/OnUpdateDataHandler;", "Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/trigger/AbsTriggerHandler;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OnUpdateDataHandler extends AbsTriggerHandler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f450751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PreloadTriggerContext f450752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TriggerEnterParams f450753g;

    @Override // com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.trigger.AbsTriggerHandler
    public final void a() {
        this.f450751e.removeCallbacks(this);
        RecyclerView r100 = this.f450751e;
        this.f450753g.getContext().i().c();
        r100.postDelayed(this, 0 + ((long) 50));
    }

    @Override // java.lang.Runnable
    public final void run() {
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    L21:
        return;
    L3:
        if (this.f450752f.a() == false) goto L16;
        boolean r100 = false;
        Queue<Integer> r101 = this.f450753g.getContext().i().C(this.f450751e, 0);     // Catch: Throwable -> L13
        if (r101 != null) goto L8;
    L9:
        r100 = true;
    L10:
        if (r100 == true) goto L20;
        AbsTriggerHandler.c(this, r101, Trigger.DATA_UPDATED, 12);     // Catch: Throwable -> L13
        return;
    L20:
        return;
    L8:
        if (r101.isEmpty() == false) goto L10;
    }

    public OnUpdateDataHandler(TriggerEnterParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        super(r100);
        this.f450753g = r100;
        this.f450751e = r100.f450769b;
        this.f450752f = r100.getContext();
    }
}
