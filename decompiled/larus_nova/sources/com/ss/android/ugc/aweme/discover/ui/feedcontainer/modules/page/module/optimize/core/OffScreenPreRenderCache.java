package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.core;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/core/OffScreenPreRenderCache;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OffScreenPreRenderCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Object, CacheInfo<Object>> f450718a;

    public OffScreenPreRenderCache(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f450718a = Collections.synchronizedMap(new IdentityHashMap());
    }
}
