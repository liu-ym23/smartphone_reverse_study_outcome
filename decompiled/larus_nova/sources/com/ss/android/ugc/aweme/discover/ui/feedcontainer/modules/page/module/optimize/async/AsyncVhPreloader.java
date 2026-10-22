package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.async;

import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config.BindManagerEx;
import com.ss.android.ugc.aweme.search.optimize.PreBindResult;
import com.ss.ugc.android.cachalot.api.Trigger;
import com.ss.ugc.android.cachalot.common.async.controller.a;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/async/AsyncVhPreloader;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AsyncVhPreloader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f450652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BindManagerEx f450653b;

    public AsyncVhPreloader(ExecutorService r100, AsyncBindManager r101) {
        Intrinsics.checkNotNullParameter(r100, "executor");
        this.f450652a = r100;
        this.f450653b = r101;
    }

    public final PreBindResult a(int r100, a r101, Trigger r102) {
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "trigger");
        BindManagerEx r103 = this.f450653b;
        if (r103 == null) goto L7;
        PreBindResult r104 = r103.a(r100, r101, r102);
        if (r104 == null) goto L7;
        return r104;
    L7:
        return new PreBindResult(false, "asyncBindManager is null.");
    }
}
