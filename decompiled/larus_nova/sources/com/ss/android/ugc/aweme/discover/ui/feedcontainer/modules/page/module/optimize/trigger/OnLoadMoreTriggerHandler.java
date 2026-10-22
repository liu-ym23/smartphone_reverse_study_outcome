package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.trigger;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.android.cachalot.api.Trigger;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/trigger/OnLoadMoreTriggerHandler;", "Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/trigger/AbsTriggerHandler;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OnLoadMoreTriggerHandler extends AbsTriggerHandler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TriggerEnterParams f450744e;

    @Override // java.lang.Runnable
    public final void run() {
        IntRange r100 = this.f450744e.f450768a.i().e(this.f450744e.f450769b);     // Catch: Throwable -> L14
        if (r100 == null) goto L17;
        LinkedList r101 = new LinkedList();     // Catch: Throwable -> L14
        int r102 = r100.getFirst();     // Catch: Throwable -> L14
        int r103 = r100.getLast();     // Catch: Throwable -> L14
        int r104 = r100.getStep();     // Catch: Throwable -> L14
        if (r104 < 0) goto L8;
        if (r102 <= r103) goto L9;
    L12:
        AbsTriggerHandler.c(this, r101, Trigger.ON_SET_DATA_AFTER_LOAD_MORE, 8);     // Catch: Throwable -> L14
        return;
    L9:
        r101.add(Integer.valueOf(r102));     // Catch: Throwable -> L14
        if (r102 == r103) goto L12;
        r102 = r102 + r104;     // Catch: Throwable -> L14
        goto L9
    L8:
        if (r102 < r103) goto L12;
    L17:
        return;
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L23;
        throw th;
    }

    public OnLoadMoreTriggerHandler(TriggerEnterParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        super(r100);
        this.f450744e = r100;
    }
}
