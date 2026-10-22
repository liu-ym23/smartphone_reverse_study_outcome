package com.bytedance.android.window.shop.home.tab.event;

import com.bytedance.android.ec.core.event.BaseMetricsEvent2;
import com.bytedance.android.ec.core.event.eventdumper.EventKey;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/event/WindowCardTimeCostEvent;", "Lcom/bytedance/android/ec/core/event/BaseMetricsEvent2;", "cardType", "", "timeCost", "", "(IJ)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowCardTimeCostEvent extends BaseMetricsEvent2 {

    @EventKey("card_type")
    private final int cardType;

    @EventKey("time_cost")
    private final long timeCost;

    public WindowCardTimeCostEvent(int r2, long r3) {
        super("window_perf_card_render");
        this.cardType = r2;
        this.timeCost = r3;
    }
}
