package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.trigger;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/trigger/OnScrollHandler;", "Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/trigger/AbsTriggerHandler;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OnScrollHandler extends AbsTriggerHandler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TriggerEnterParams f450746e;

    @Override // com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.trigger.AbsTriggerHandler
    public final void a() {
    }

    @Override // java.lang.Runnable
    public final void run() {
    }

    public OnScrollHandler(TriggerEnterParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        super(r100);
        this.f450746e = r100;
    }
}
