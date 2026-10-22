package com.ss.android.ugc.aweme.search.hostimpl;

import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchEventService;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchFrescoService;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostLogService;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/aweme/search/hostimpl/AbsECSearchHostService;", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchHostService;", "()V", "getITradeSearchAwemeHostService", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchAwemeHostService;", "getITradeSearchEventService", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchEventService;", "getITradeSearchFrescoService", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchFrescoService;", "getITradeSearchHostLogService", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchHostLogService;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsECSearchHostService implements ITradeSearchHostService {
    public AbsECSearchHostService() {
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService
    public ITradeSearchAwemeHostService getITradeSearchAwemeHostService() {
        return ECSearchAwemeHostService.f453269a;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService
    public ITradeSearchEventService getITradeSearchEventService() {
        return ECSearchEventService.f453270a;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService
    public ITradeSearchFrescoService getITradeSearchFrescoService() {
        return ECSearchFrescoService.INSTANCE;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService
    public ITradeSearchHostLogService getITradeSearchHostLogService() {
        return ECSearchLogService.f453271a;
    }
}
