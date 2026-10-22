package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.trigger;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.async.AsyncBindManager;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.core.AsyncCacheExtension;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.utils.ExtraLayoutHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/trigger/TriggerEnterParams;", "", "Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/trigger/PreloadTriggerContext;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/trigger/PreloadTriggerContext;", "getContext", "()Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/trigger/PreloadTriggerContext;", PerfLog.PARAM_KEY_CONTEXT_ID, "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TriggerEnterParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PreloadTriggerContext f450768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f450769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AsyncBindManager<?> f450770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AsyncCacheExtension<?> f450771d;

    public final PreloadTriggerContext getContext() {
        return this.f450768a;
    }

    public TriggerEnterParams(PreloadTriggerContext r100, RecyclerView r101, AsyncBindManager<?> r102, AsyncCacheExtension<?> r103, ExtraLayoutHelper r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "recyclerView");
        Intrinsics.checkNotNullParameter(r102, "bindManager");
        Intrinsics.checkNotNullParameter(r103, "cacheExtension");
        Intrinsics.checkNotNullParameter(r104, "extraLayoutHelper");
        this.f450768a = r100;
        this.f450769b = r101;
        this.f450770c = r102;
        this.f450771d = r103;
    }
}
