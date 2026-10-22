package com.bytedance.ee.bear.bitable.itemview.record;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordCatalogData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "showAddTo", "", "getShowAddTo", "()Z", "setShowAddTo", "(Z)V", "baseName", "", "getBaseName", "()Ljava/lang/String;", "setBaseName", "(Ljava/lang/String;)V", "tableName", "getTableName", "setTableName", "baseId", "getBaseId", "setBaseId", "tableId", "getTableId", "setTableId", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRecordCatalogData implements NonProguard {
    private String baseId;
    private String baseName;
    private boolean showAddTo;
    private String tableId;
    private String tableName;

    public ItemViewRecordCatalogData() {
        this.showAddTo = true;
        this.baseName = "";
        this.tableName = "";
    }

    public final String getBaseId() {
        return this.baseId;
    }

    public final String getBaseName() {
        return this.baseName;
    }

    public final boolean getShowAddTo() {
        return this.showAddTo;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final String getTableName() {
        return this.tableName;
    }

    public final void setBaseId(String r100) {
        this.baseId = r100;
    }

    public final void setBaseName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.baseName = r100;
    }

    public final void setShowAddTo(boolean r100) {
        this.showAddTo = r100;
    }

    public final void setTableId(String r100) {
        this.tableId = r100;
    }

    public final void setTableName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tableName = r100;
    }
}
