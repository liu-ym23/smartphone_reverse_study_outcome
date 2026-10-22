package com.ss.android.ugc.aweme.search.common.event;

import com.ss.android.ugc.aweme.search.common.list.ESSaasCommonList$updateListAdapterHelper$2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/event/ECSearchUpdateListAdapterHelper;", "Lcom/ss/android/ugc/aweme/search/common/event/IECSearchSafeEventBusWrapper$EventListener;", "Lcom/ss/android/ugc/aweme/search/common/event/ECSearchListEvent;", "AdapterHolder", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchUpdateListAdapterHelper implements IECSearchSafeEventBusWrapper$EventListener<ECSearchListEvent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdapterHolder f451592a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/event/ECSearchUpdateListAdapterHelper$AdapterHolder;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface AdapterHolder {
        void a(ECSearchListEvent r100);
    }

    @Override // com.ss.android.ugc.aweme.search.common.event.IECSearchSafeEventBusWrapper$EventListener
    public final Class<ECSearchListEvent> b() {
        return ECSearchListEvent.class;
    }

    public ECSearchUpdateListAdapterHelper(ESSaasCommonList$updateListAdapterHelper$2.AnonymousClass1 r100) {
        Intrinsics.checkNotNullParameter(r100, "adapterHolder");
        this.f451592a = r100;
        ECSearchSafeEventBusWrapper.f451591b.getClass();
        ECSearchSafeEventBusWrapper.a(this);
    }

    @Override // com.ss.android.ugc.aweme.search.common.event.IECSearchSafeEventBusWrapper$EventListener
    public final void a(ECSearchListEvent r100) {
        ECSearchListEvent r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "updateItemEvent");
        AdapterHolder r102 = this.f451592a;
        if (r102 == null) goto L6;
        r102.a(r101);
        return;
    }
}
