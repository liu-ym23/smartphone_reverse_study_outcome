package com.ss.android.ugc.aweme.search.hostapi;

import com.bytedance.android.ecom.service_annotation.ReturnSubService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H'J\n\u0010\b\u001a\u0004\u0018\u00010\tH'J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH'J\b\u0010\f\u001a\u00020\rH'J\b\u0010\u000e\u001a\u00020\u000fH'J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H'J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H'J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H'J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H'J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H'¨\u0006\u001a"}, d2 = {"Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchHostService;", "", "getITradeSearchAddressService", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchAddressService;", "getITradeSearchAwemeHostService", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchAwemeHostService;", "getITradeSearchEventService", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchEventService;", "getITradeSearchFrescoService", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchFrescoService;", "getITradeSearchHostABService", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchHostABService;", "getITradeSearchHostAbility", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchHostAbility;", "getITradeSearchHostAppInfo", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchHostAppInfo;", "getITradeSearchHostLogService", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchHostLogService;", "getITradeSearchHostNetService", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchHostNetService;", "getITradeSearchHostRouterService", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchHostRouterService;", "getITradeSearchHostUserService", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchHostUserService;", "getITradeSearchPadSplitService", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchPadSplitService;", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface ITradeSearchHostService {
    @ReturnSubService
    ITradeSearchAddressService getITradeSearchAddressService();

    @ReturnSubService
    ITradeSearchAwemeHostService getITradeSearchAwemeHostService();

    @ReturnSubService
    ITradeSearchEventService getITradeSearchEventService();

    @ReturnSubService
    ITradeSearchFrescoService getITradeSearchFrescoService();

    @ReturnSubService
    ITradeSearchHostABService getITradeSearchHostABService();

    @ReturnSubService
    ITradeSearchHostAbility getITradeSearchHostAbility();

    @ReturnSubService
    ITradeSearchHostAppInfo getITradeSearchHostAppInfo();

    @ReturnSubService
    ITradeSearchHostLogService getITradeSearchHostLogService();

    @ReturnSubService
    ITradeSearchHostNetService getITradeSearchHostNetService();

    @ReturnSubService
    ITradeSearchHostRouterService getITradeSearchHostRouterService();

    @ReturnSubService
    ITradeSearchHostUserService getITradeSearchHostUserService();

    @ReturnSubService
    ITradeSearchPadSplitService getITradeSearchPadSplitService();
}
