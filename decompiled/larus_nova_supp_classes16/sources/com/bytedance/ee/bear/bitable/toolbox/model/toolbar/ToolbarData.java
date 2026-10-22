package com.bytedance.ee.bear.bitable.toolbox.model.toolbar;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/model/toolbar/ToolbarData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "baseId", "", "getBaseId", "()Ljava/lang/String;", "setBaseId", "(Ljava/lang/String;)V", "tableId", "getTableId", "setTableId", "viewId", "getViewId", "setViewId", "menus", "", "Lcom/bytedance/ee/bear/bitable/toolbox/model/toolbar/ToolbarData$MenuItem;", "getMenus", "()[Lcom/bytedance/ee/bear/bitable/toolbox/model/toolbar/ToolbarData$MenuItem;", "setMenus", "([Lcom/bytedance/ee/bear/bitable/toolbox/model/toolbar/ToolbarData$MenuItem;)V", "[Lcom/bytedance/ee/bear/bitable/toolbox/model/toolbar/ToolbarData$MenuItem;", "equals", "", "other", "", "hashCode", "", "MenuItem", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToolbarData implements NonProguard {
    private String baseId;
    private MenuItem[] menus;
    private String tableId;
    private String viewId;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010#\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020\u000eH\u0016J\b\u0010'\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/model/toolbar/ToolbarData$MenuItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "count", "", "getCount", "()Ljava/lang/Integer;", "setCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "active", "", "getActive", "()Z", "setActive", "(Z)V", "disabled", "getDisabled", "setDisabled", "hasInvalidCondition", "getHasInvalidCondition", "setHasInvalidCondition", "showBadge", "getShowBadge", "setShowBadge", "equals", "other", "", "hashCode", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MenuItem implements NonProguard {
        private boolean active;
        private Integer count;
        private boolean disabled;
        private boolean hasInvalidCondition;
        private String id;
        private boolean showBadge;
        private String title;

        public MenuItem() {
        }

        public String toString() {
            return "Menu(id=" + this.id + ", title=" + this.title + ", count='" + this.count + "', active=" + this.active + ", disabled=" + this.disabled + ", hasInvalidCondition=" + this.hasInvalidCondition + ')';
        }

        public int hashCode() {
            return super.hashCode();
        }

        public final boolean getActive() {
            return this.active;
        }

        public final Integer getCount() {
            return this.count;
        }

        public final boolean getDisabled() {
            return this.disabled;
        }

        public final boolean getHasInvalidCondition() {
            return this.hasInvalidCondition;
        }

        public final String getId() {
            return this.id;
        }

        public final boolean getShowBadge() {
            return this.showBadge;
        }

        public final String getTitle() {
            return this.title;
        }

        public boolean equals(Object r4) {
            if ((r4 instanceof MenuItem) == true) goto L5;
            return false;
        L5:
            MenuItem r5 = (MenuItem) r4;
            if (TextUtils.equals(this.id, r5.id) == true) goto L9;
            return false;
        L9:
            if (TextUtils.equals(this.title, r5.title) == true) goto L12;
            return false;
        L12:
            if (this.count == r5.count) goto L15;
            return false;
        L15:
            if (this.active == r5.active) goto L18;
            return false;
        L18:
            if (this.disabled == r5.disabled) goto L21;
            return false;
        L21:
            if (this.hasInvalidCondition == r5.hasInvalidCondition) goto L23;
            return false;
        L23:
            return true;
        }

        public final void setActive(boolean r1) {
            this.active = r1;
        }

        public final void setCount(Integer r1) {
            this.count = r1;
        }

        public final void setDisabled(boolean r1) {
            this.disabled = r1;
        }

        public final void setHasInvalidCondition(boolean r1) {
            this.hasInvalidCondition = r1;
        }

        public final void setId(String r1) {
            this.id = r1;
        }

        public final void setShowBadge(boolean r1) {
            this.showBadge = r1;
        }

        public final void setTitle(String r1) {
            this.title = r1;
        }
    }

    public ToolbarData() {
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final String getBaseId() {
        return this.baseId;
    }

    public final MenuItem[] getMenus() {
        return this.menus;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof ToolbarData) == true) goto L5;
        return false;
    L5:
        ToolbarData r5 = (ToolbarData) r4;
        if (TextUtils.equals(this.baseId, r5.baseId) == true) goto L9;
        return false;
    L9:
        if (TextUtils.equals(this.tableId, r5.tableId) == true) goto L12;
        return false;
    L12:
        if (TextUtils.equals(this.viewId, r5.viewId) == true) goto L15;
        return false;
    L15:
        if (Arrays.equals(this.menus, r5.menus) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final void setBaseId(String r1) {
        this.baseId = r1;
    }

    public final void setMenus(MenuItem[] r1) {
        this.menus = r1;
    }

    public final void setTableId(String r1) {
        this.tableId = r1;
    }

    public final void setViewId(String r1) {
        this.viewId = r1;
    }
}
