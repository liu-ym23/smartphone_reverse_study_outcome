package com.bytedance.ee.bear.bitable.itemview.stack;

import com.bytedance.ee.bear.bitable.itemview.recordpages.ItemViewRecordPagesData;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010\u001b\u001a\u00020\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/stack/ItemViewStackData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "action", "", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "stackIdentify", "getStackIdentify", "setStackIdentify", "data", "Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordPagesData;", "getData", "()Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordPagesData;", "setData", "(Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordPagesData;)V", RuleConditionBean.OPEN_URL_KEY, "getOpenUrl", "setOpenUrl", "isPush", "", "isPop", "isPopAll", "isUpdateTop", "isPopAndPushRecord", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewStackData implements NonProguard {
    private String action;
    private ItemViewRecordPagesData data;
    private String openUrl;
    private String stackIdentify;

    public final boolean isPop() {
        return Intrinsics.areEqual(this.action, "Pop");
    }

    public final boolean isPopAll() {
        return Intrinsics.areEqual(this.action, "PopAll");
    }

    public final boolean isPopAndPushRecord() {
        return Intrinsics.areEqual(this.action, "PopAndPushRecord");
    }

    public final boolean isPush() {
        return Intrinsics.areEqual(this.action, "Push");
    }

    public final boolean isUpdateTop() {
        return Intrinsics.areEqual(this.action, "UpdateTop");
    }

    public ItemViewStackData() {
        this.action = "default";
        this.stackIdentify = "";
        this.openUrl = "";
    }

    public final String getAction() {
        return this.action;
    }

    public final ItemViewRecordPagesData getData() {
        return this.data;
    }

    public final String getOpenUrl() {
        return this.openUrl;
    }

    public final String getStackIdentify() {
        return this.stackIdentify;
    }

    public final void setAction(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.action = r100;
    }

    public final void setData(ItemViewRecordPagesData r100) {
        this.data = r100;
    }

    public final void setOpenUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.openUrl = r100;
    }

    public final void setStackIdentify(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.stackIdentify = r100;
    }
}
