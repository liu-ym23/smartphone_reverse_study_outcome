package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.utils;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config.BindManagerConfig;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config.CachalotAsyncConfig;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.trigger.PreloadTriggerContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/utils/ExtraLayoutHelper;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExtraLayoutHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f450772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f450773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BindManagerConfig<?> f450774c;

    public final boolean a() {
        CachalotAsyncConfig<?> r100 = this.f450774c.f450658a;
        boolean r101 = r100.f450681h;
        boolean r102 = false;
        if (r100.f450679f <= 0) goto L5;
        r102 = true;
    L5:
        if (r102 == true) goto L7;
    L9:
        return r102;
    L7:
        if (this.f450772a >= 0) goto L9;
        this.f450772a = (int) (this.f450773b.getHeight() * this.f450774c.f450658a.f450679f);
        goto L9
    }

    public ExtraLayoutHelper(RecyclerView r100, PreloadTriggerContext r101, BindManagerConfig<?> r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "config");
        this.f450773b = r100;
        this.f450774c = r102;
        this.f450772a = -1;
    }
}
