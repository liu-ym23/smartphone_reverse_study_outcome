package com.bytedance.ee.bear.bitable.titlebar;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.common.l;
import com.bytedance.ee.bear.bitable.panel.EPanelItemIcon;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010%\u001a\u00020 J\u0006\u0010&\u001a\u00020 J\u0010\u0010\u001a\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0007J\b\u0010*\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/bitable/titlebar/BitableCatalogModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "tableName", "", "getTableName", "()Ljava/lang/String;", "setTableName", "(Ljava/lang/String;)V", "tableId", "getTableId", "setTableId", "viewName", "getViewName", "setViewName", "viewId", "getViewId", "setViewId", "blockType", "getBlockType", "setBlockType", "viewType", "getViewType", "setViewType", "icon", "getIcon", "setIcon", "iconUrl", "getIconUrl", "setIconUrl", "needShowBadge", "", "getNeedShowBadge", "()Z", "setNeedShowBadge", "(Z)V", "isValid", "showDivider", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableCatalogModel implements NonProguard {
    private String blockType;
    private String icon;
    private String iconUrl;
    private boolean needShowBadge;
    private String tableId;
    private String tableName;
    private String viewId;
    private String viewName;
    private String viewType;

    public BitableCatalogModel() {
    }

    public final boolean isValid() {
        if (TextUtils.isEmpty(this.tableName) == true) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.isEmpty(this.viewName) == false) goto L8;
        return false;
    }

    public final boolean showDivider() {
        String r100 = this.viewType;
        int r101 = l.f209851a;
        if (r100 != null) goto L5;
    L20:
        return false;
    L5:
        switch(r100.hashCode()) {
            case -1138692297: goto L17;
            case -196315310: goto L14;
            case 3148996: goto L11;
            case 98121812: goto L8;
            default: goto L20;
        };
    L8:
        if (r100.equals("gantt") == false) goto L20;
    L19:
        return true;
    L11:
        if (r100.equals("form") == true) goto L19;
    L14:
        if (r100.equals("gallery") == false) goto L20;
    L17:
        if (r100.equals("kanban") == true) goto L19;
        goto L19
    }

    public String toString() {
        return "CatalogModel{tableName='" + this.tableName + "', tableId='" + this.tableId + "', viewName='" + this.viewName + "', viewId='" + this.viewId + "', blockType='" + this.blockType + "', viewType='" + this.viewType + ", needShowBadge='" + this.needShowBadge + "''}";
    }

    public final String getBlockType() {
        return this.blockType;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final boolean getNeedShowBadge() {
        return this.needShowBadge;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final String getTableName() {
        return this.tableName;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final String getViewName() {
        return this.viewName;
    }

    public final String getViewType() {
        return this.viewType;
    }

    public final int getIcon(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = this.viewType;
        if (r101 == null) goto L6;
        return EPanelItemIcon.getEPanelItemIconById(r100, r101, this.icon);
    L6:
        return EPanelItemIcon.getEPanelItemIconById(r100, this.blockType, this.icon);
    }

    public final void setBlockType(String r100) {
        this.blockType = r100;
    }

    public final void setIcon(String r100) {
        this.icon = r100;
    }

    public final void setIconUrl(String r100) {
        this.iconUrl = r100;
    }

    public final void setNeedShowBadge(boolean r100) {
        this.needShowBadge = r100;
    }

    public final void setTableId(String r100) {
        this.tableId = r100;
    }

    public final void setTableName(String r100) {
        this.tableName = r100;
    }

    public final void setViewId(String r100) {
        this.viewId = r100;
    }

    public final void setViewName(String r100) {
        this.viewName = r100;
    }

    public final void setViewType(String r100) {
        this.viewType = r100;
    }
}
