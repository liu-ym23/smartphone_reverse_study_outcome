package com.ss.android.ugc.aweme.search.common;

import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/ECSearchPriceMotionListener;", "Lcom/ss/android/ugc/aweme/search/common/IECSearchRenderListener;", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchPriceMotionListener implements IECSearchRenderListener {
    public ECSearchPriceMotionListener() {
    }

    @Override // com.ss.android.ugc.aweme.search.common.IECSearchRenderListener
    public final void a(Map<String, ? extends Object> r100) {
        Event r101 = new Event("ec_search_result_after_render", System.currentTimeMillis(), null, 4, null);
        r101.setMapParams(r100);
        EventCenter.enqueueEvent(r101);
    }
}
