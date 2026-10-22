package com.bytedance.ee.bear.bitable.itemview.record;

import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewNoticeData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "data", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "getData", "()Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "setData", "(Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;)V", "isInfo", "", "isError", "isWarning", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewNoticeData implements NonProguard {
    private SimpleItemModel data;
    private String type;

    public ItemViewNoticeData() {
    }

    public final boolean isError() {
        return Intrinsics.areEqual(this.type, "error");
    }

    public final boolean isInfo() {
        return Intrinsics.areEqual(this.type, "info");
    }

    public final boolean isWarning() {
        return Intrinsics.areEqual(this.type, "warning");
    }

    public final SimpleItemModel getData() {
        return this.data;
    }

    public final String getType() {
        return this.type;
    }

    public final void setData(SimpleItemModel r100) {
        this.data = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }
}
