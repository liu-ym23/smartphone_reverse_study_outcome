package com.bytedance.ee.bear.bitable.infoarch.nativeview.grid;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseRecordData;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010)\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridRecordData;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseRecordData;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridCellData;", "<init>", "()V", "countNumber", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "getCountNumber", "()Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "setCountNumber", "(Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;)V", "hierarchyCounter", "getHierarchyCounter", "setHierarchyCounter", "hierarchyTint", "getHierarchyTint", "setHierarchyTint", "hierarchyLevel", "", "getHierarchyLevel", "()I", "setHierarchyLevel", "(I)V", "selectInfo", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridSelectInfo;", "getSelectInfo", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridSelectInfo;", "setSelectInfo", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridSelectInfo;)V", "showHorizontalDivider", "", "getShowHorizontalDivider", "()Z", "setShowHorizontalDivider", "(Z)V", "showBottomDivider", "getShowBottomDivider", "setShowBottomDivider", "showTopDivider", "getShowTopDivider", "setShowTopDivider", "nextHierarchyLevel", "getNextHierarchyLevel", "setNextHierarchyLevel", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GridRecordData extends BaseRecordData<GridCellData> {
    private SimpleItemModel countNumber;
    private SimpleItemModel hierarchyCounter;
    private int hierarchyLevel;
    private SimpleItemModel hierarchyTint;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f213506id;
    private int nextHierarchyLevel;
    private GridSelectInfo selectInfo;
    private boolean showBottomDivider;
    private boolean showHorizontalDivider;
    private boolean showTopDivider;

    public GridRecordData() {
        this.showHorizontalDivider = true;
    }

    public final SimpleItemModel getCountNumber() {
        return this.countNumber;
    }

    public final SimpleItemModel getHierarchyCounter() {
        return this.hierarchyCounter;
    }

    public final int getHierarchyLevel() {
        return this.hierarchyLevel;
    }

    public final SimpleItemModel getHierarchyTint() {
        return this.hierarchyTint;
    }

    public final String getId() {
        return this.f213506id;
    }

    public final int getNextHierarchyLevel() {
        return this.nextHierarchyLevel;
    }

    public final GridSelectInfo getSelectInfo() {
        return this.selectInfo;
    }

    public final boolean getShowBottomDivider() {
        return this.showBottomDivider;
    }

    public final boolean getShowHorizontalDivider() {
        return this.showHorizontalDivider;
    }

    public final boolean getShowTopDivider() {
        return this.showTopDivider;
    }

    public final void setCountNumber(SimpleItemModel r100) {
        this.countNumber = r100;
    }

    public final void setHierarchyCounter(SimpleItemModel r100) {
        this.hierarchyCounter = r100;
    }

    public final void setHierarchyLevel(int r100) {
        this.hierarchyLevel = r100;
    }

    public final void setHierarchyTint(SimpleItemModel r100) {
        this.hierarchyTint = r100;
    }

    public final void setId(String r100) {
        this.f213506id = r100;
    }

    public final void setNextHierarchyLevel(int r100) {
        this.nextHierarchyLevel = r100;
    }

    public final void setSelectInfo(GridSelectInfo r100) {
        this.selectInfo = r100;
    }

    public final void setShowBottomDivider(boolean r100) {
        this.showBottomDivider = r100;
    }

    public final void setShowHorizontalDivider(boolean r100) {
        this.showHorizontalDivider = r100;
    }

    public final void setShowTopDivider(boolean r100) {
        this.showTopDivider = r100;
    }
}
