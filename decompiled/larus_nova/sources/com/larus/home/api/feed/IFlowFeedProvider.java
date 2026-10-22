package com.larus.home.api.feed;

import com.larus.larkfeed.impl.mixedfeed.flow.SideBarLarkFeedProvider;
import com.ss.android.lark.utils.statistics.PerfLog;
import eb9.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import th9.b;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/larus/home/api/feed/IFlowFeedProvider;", "", "providerId", "", "getProviderId", "()Ljava/lang/String;", "sourceId", "getSourceId", "createSource", "Lcom/larus/home/api/feed/IFlowFeedAdapterSource;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/home/api/feed/FlowFeedHostContext;", "observeAvailability", "Lcom/larus/home/api/feed/IFlowFeedAvailabilityObservation;", "listener", "Lkotlin/Function0;", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFlowFeedProvider {
    String a();

    SideBarLarkFeedProvider.b b(m r100);

    b c(Function0 r100);

    String d();
}
