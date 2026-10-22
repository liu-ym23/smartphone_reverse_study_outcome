package com.bytedance.android.shopping.store.tabkit.events;

import com.bytedance.android.ec.core.event.BaseMetricsEvent2;
import com.bytedance.android.ec.core.event.eventdumper.EventKey;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/events/RouterParamErrorEvent;", "Lcom/bytedance/android/ec/core/event/BaseMetricsEvent2;", "()V", "anchorTabId", "", "getAnchorTabId", "()Ljava/lang/String;", "setAnchorTabId", "(Ljava/lang/String;)V", "routerParam", "getRouterParam", "setRouterParam", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RouterParamErrorEvent extends BaseMetricsEvent2 {

    @EventKey("anchor_tab_id")
    private String anchorTabId;

    @EventKey("router_param")
    private String routerParam;

    public RouterParamErrorEvent() {
        super("router_param_error");
    }

    public final String getAnchorTabId() {
        return this.anchorTabId;
    }

    public final String getRouterParam() {
        return this.routerParam;
    }

    public final void setAnchorTabId(String r1) {
        this.anchorTabId = r1;
    }

    public final void setRouterParam(String r1) {
        this.routerParam = r1;
    }
}
