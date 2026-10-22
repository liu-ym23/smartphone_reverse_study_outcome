package com.bytedance.android.shopping.store.tabkit.events;

import com.bytedance.android.ec.core.event.BaseMetricsEvent2;
import com.bytedance.android.ec.core.event.eventdumper.EventKey;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/events/PageViewEvent;", "Lcom/bytedance/android/ec/core/event/BaseMetricsEvent2;", "()V", "anchorTabId", "", "getAnchorTabId", "()Ljava/lang/String;", "setAnchorTabId", "(Ljava/lang/String;)V", "enterType", "getEnterType", "setEnterType", "mainTab", "getMainTab", "setMainTab", "pageType", "getPageType", "setPageType", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PageViewEvent extends BaseMetricsEvent2 {

    @EventKey("anchor_tab_id")
    private String anchorTabId;

    @EventKey("enter_type")
    private String enterType;

    @EventKey("main_tab")
    private String mainTab;

    @EventKey("page_type")
    private String pageType;

    public PageViewEvent() {
        super("page_view");
    }

    public final String getAnchorTabId() {
        return this.anchorTabId;
    }

    public final String getEnterType() {
        return this.enterType;
    }

    public final String getMainTab() {
        return this.mainTab;
    }

    public final String getPageType() {
        return this.pageType;
    }

    public final void setAnchorTabId(String r1) {
        this.anchorTabId = r1;
    }

    public final void setEnterType(String r1) {
        this.enterType = r1;
    }

    public final void setMainTab(String r1) {
        this.mainTab = r1;
    }

    public final void setPageType(String r1) {
        this.pageType = r1;
    }
}
