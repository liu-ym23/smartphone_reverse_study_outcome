package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.trigger;

import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.async.IAsyncPrefetchStrategy;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config.SerialPreloader;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/trigger/PreloadTriggerContext;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface PreloadTriggerContext {
    boolean a();

    boolean c(long r100, boolean r101);

    void e(long r100);

    void h(SerialPreloader r100);

    IAsyncPrefetchStrategy i();
}
