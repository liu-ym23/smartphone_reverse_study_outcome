package com.bytedance.ee.bear.bitable.common.viewmodel;

import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.bitable.cardview.GridViewLayoutType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/viewmodel/TableInfoViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "baseId", "", "getBaseId", "()Ljava/lang/String;", "setBaseId", "(Ljava/lang/String;)V", "tableId", "getTableId", "setTableId", "isSyncTable", "", "()Z", "setSyncTable", "(Z)V", "viewId", "getViewId", "setViewId", "viewType", "", "getViewType", "()Ljava/lang/Integer;", "setViewType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "gridViewLayoutType", "Lcom/bytedance/ee/bear/bitable/cardview/GridViewLayoutType;", "getGridViewLayoutType", "()Lcom/bytedance/ee/bear/bitable/cardview/GridViewLayoutType;", "setGridViewLayoutType", "(Lcom/bytedance/ee/bear/bitable/cardview/GridViewLayoutType;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TableInfoViewModel extends ViewModel {
    private String baseId;
    private GridViewLayoutType gridViewLayoutType;
    private boolean isSyncTable;
    private String tableId;
    private String viewId;
    private Integer viewType;

    public TableInfoViewModel() {
        this.baseId = "";
        this.tableId = "";
        this.viewId = "";
    }

    public final String getBaseId() {
        return this.baseId;
    }

    public final GridViewLayoutType getGridViewLayoutType() {
        return this.gridViewLayoutType;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final Integer getViewType() {
        return this.viewType;
    }

    public final boolean isSyncTable() {
        return this.isSyncTable;
    }

    public final void setBaseId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.baseId = r100;
    }

    public final void setGridViewLayoutType(GridViewLayoutType r100) {
        this.gridViewLayoutType = r100;
    }

    public final void setSyncTable(boolean r100) {
        this.isSyncTable = r100;
    }

    public final void setTableId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tableId = r100;
    }

    public final void setViewId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.viewId = r100;
    }

    public final void setViewType(Integer r100) {
        this.viewType = r100;
    }
}
