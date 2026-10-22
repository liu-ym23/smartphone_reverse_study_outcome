package com.ss.android.ugc.aweme.search.hostimpl;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchEventService;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/hostimpl/ECSearchEventService;", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchEventService;", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchEventService implements ITradeSearchEventService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECSearchEventService f453270a = null;

    private ECSearchEventService() {
    }

    static {
        f453270a = new ECSearchEventService();
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchEventService
    public final void logV3(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        AppLogNewUtils.onEventV3("tobsdk_livesdk_" + r100, r101);
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchEventService
    public final void logV3(String r100, JSONObject r101, String r102, PageFinder r103) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "btm");
        Intrinsics.checkNotNullParameter(r103, "pageFinder");
        Iterator<Map.Entry<String, Object>> r104 = BtmSDK.INSTANCE.createReportParams(r102, r103).entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry<String, Object> r105 = r104.next();
        r101.putOpt(r105.getKey(), r105.getValue());
        goto L4
    L6:
        logV3(r100, r101);
    }
}
