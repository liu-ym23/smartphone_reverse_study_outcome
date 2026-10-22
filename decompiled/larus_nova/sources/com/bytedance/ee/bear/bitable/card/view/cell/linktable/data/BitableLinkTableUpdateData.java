package com.bytedance.ee.bear.bitable.card.view.cell.linktable.data;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.bitable.infoarch.toolbar.ToolbarContainerModel;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/linktable/data/BitableLinkTableUpdateData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "tableName", "getTableName", "setTableName", "maxLinkLimit", "", "getMaxLinkLimit", "()Ljava/lang/Integer;", "setMaxLinkLimit", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "visibleRecordNum", "getVisibleRecordNum", "setVisibleRecordNum", "value", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BitableNativeViewData;", "getValue", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BitableNativeViewData;", "setValue", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BitableNativeViewData;)V", "toolBarData", "Lcom/bytedance/ee/bear/bitable/infoarch/toolbar/ToolbarContainerModel;", "getToolBarData", "()Lcom/bytedance/ee/bear/bitable/infoarch/toolbar/ToolbarContainerModel;", "setToolBarData", "(Lcom/bytedance/ee/bear/bitable/infoarch/toolbar/ToolbarContainerModel;)V", "searchConfigIcon", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "getSearchConfigIcon", "()Lcom/bytedance/ee/bear/bitable/panel/Icon;", "setSearchConfigIcon", "(Lcom/bytedance/ee/bear/bitable/panel/Icon;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableLinkTableUpdateData implements NonProguard {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f207826id;
    private Integer maxLinkLimit;
    private Icon searchConfigIcon;
    private String tableName;
    private ToolbarContainerModel toolBarData;
    private BitableNativeViewData value;
    private Integer visibleRecordNum;

    public BitableLinkTableUpdateData() {
        this.maxLinkLimit = 500;
        this.visibleRecordNum = 0;
    }

    public final String getId() {
        return this.f207826id;
    }

    public final Integer getMaxLinkLimit() {
        return this.maxLinkLimit;
    }

    public final Icon getSearchConfigIcon() {
        return this.searchConfigIcon;
    }

    public final String getTableName() {
        return this.tableName;
    }

    public final ToolbarContainerModel getToolBarData() {
        return this.toolBarData;
    }

    public final BitableNativeViewData getValue() {
        return this.value;
    }

    public final Integer getVisibleRecordNum() {
        return this.visibleRecordNum;
    }

    public final void setId(String r100) {
        this.f207826id = r100;
    }

    public final void setMaxLinkLimit(Integer r100) {
        this.maxLinkLimit = r100;
    }

    public final void setSearchConfigIcon(Icon r100) {
        this.searchConfigIcon = r100;
    }

    public final void setTableName(String r100) {
        this.tableName = r100;
    }

    public final void setToolBarData(ToolbarContainerModel r100) {
        this.toolBarData = r100;
    }

    public final void setValue(BitableNativeViewData r100) {
        this.value = r100;
    }

    public final void setVisibleRecordNum(Integer r100) {
        this.visibleRecordNum = r100;
    }
}
