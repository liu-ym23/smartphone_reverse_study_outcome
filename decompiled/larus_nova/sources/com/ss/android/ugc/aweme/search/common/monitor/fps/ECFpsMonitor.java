package com.ss.android.ugc.aweme.search.common.monitor.fps;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/monitor/fps/ECFpsMonitor;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ECFpsMonitor {
    ECFpsMonitor a(Object r100);

    ECFpsMonitor b(RecyclerView r100);

    ECFpsMonitor c(Function0<? extends Map<String, String>> r100);

    ECFpsMonitor d(RecyclerView r100);

    void stop();
}
