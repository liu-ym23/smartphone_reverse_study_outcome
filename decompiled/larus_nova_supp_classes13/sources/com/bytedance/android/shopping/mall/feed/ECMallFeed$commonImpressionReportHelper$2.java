package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.shopping.api.mall.common.feed.help.ECMallCommonImpressionReportHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/shopping/api/mall/common/feed/help/ECMallCommonImpressionReportHelper;", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECMallFeed$commonImpressionReportHelper$2 extends Lambda implements Function0<ECMallCommonImpressionReportHelper> {
    final /* synthetic */ ECMallFeed this$0;

    public ECMallFeed$commonImpressionReportHelper$2(ECMallFeed r1) {
        this.this$0 = r1;
        super(0);
    }

    public final ECMallCommonImpressionReportHelper invoke() {
        ECMallFeed r0 = this.this$0;
        int r1 = ECMallFeed.I1;
        ECMallCommonImpressionReportHelper.b r2 = r0.t();
        if (r2 != null) goto L7;
        return null;
    L7:
        return new ECMallCommonImpressionReportHelper(r2, new ECMallFeed$commonImpressionReportHelper$2$$special$$inlined$let$lambda$1(this));
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m991invoke() {
        return invoke();
    }
}
