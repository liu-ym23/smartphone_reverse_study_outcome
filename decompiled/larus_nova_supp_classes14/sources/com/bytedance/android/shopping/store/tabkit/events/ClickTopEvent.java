package com.bytedance.android.shopping.store.tabkit.events;

import com.bytedance.android.ec.core.event.BaseMetricsEvent2;
import com.bytedance.android.ec.core.event.eventdumper.EventKey;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/events/ClickTopEvent;", "Lcom/bytedance/android/ec/core/event/BaseMetricsEvent2;", "()V", "mainTab", "", "getMainTab", "()Ljava/lang/String;", "setMainTab", "(Ljava/lang/String;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClickTopEvent extends BaseMetricsEvent2 {

    @EventKey("main_tab")
    private String mainTab;

    public ClickTopEvent() {
        super("click_top_tab");
    }

    public final String getMainTab() {
        return this.mainTab;
    }

    public final void setMainTab(String r1) {
        this.mainTab = r1;
    }
}
