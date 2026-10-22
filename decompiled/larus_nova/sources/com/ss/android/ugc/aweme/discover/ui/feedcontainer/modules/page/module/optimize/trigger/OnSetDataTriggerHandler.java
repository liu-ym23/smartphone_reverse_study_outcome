package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.trigger;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/trigger/OnSetDataTriggerHandler;", "Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/trigger/AbsTriggerHandler;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OnSetDataTriggerHandler extends AbsTriggerHandler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TriggerEnterParams f450750e;

    @Override // java.lang.Runnable
    public final void run() {
        this.f450750e.f450768a.i().g(this.f450750e.f450769b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public OnSetDataTriggerHandler(TriggerEnterParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        super(r100);
        this.f450750e = r100;
    }
}
