package com.bytedance.ee.bear.bitable.uikit.catalog;

import com.bytedance.ee.bear.bitable.uikit.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/catalog/TreeSortAction;", "Lcom/bytedance/ee/bear/bitable/uikit/Action;", "id", "", "beforeId", "afterId", "targetParentId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBeforeId", "()Ljava/lang/String;", "setBeforeId", "(Ljava/lang/String;)V", "getAfterId", "setAfterId", "getTargetParentId", "setTargetParentId", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TreeSortAction extends Action {
    private String afterId;
    private String beforeId;
    private String targetParentId;

    @Override // com.bytedance.ee.bear.bitable.uikit.Action
    public String toString() {
        return "TreeSortAction(id=" + getId() + ", beforeId=" + this.beforeId + ", afterId=" + this.afterId + ", targetParentId:" + this.targetParentId + ')';
    }

    public final String getAfterId() {
        return this.afterId;
    }

    public final String getBeforeId() {
        return this.beforeId;
    }

    public final String getTargetParentId() {
        return this.targetParentId;
    }

    public final void setAfterId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.afterId = r100;
    }

    public final void setBeforeId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.beforeId = r100;
    }

    public final void setTargetParentId(String r100) {
        this.targetParentId = r100;
    }

    public TreeSortAction(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "beforeId");
        Intrinsics.checkNotNullParameter(r102, "afterId");
        Action.Companion.getClass();
        super(r100, Action.access$getTYPE_BLOCK_TREE_SORT$cp());
        this.beforeId = r101;
        this.afterId = r102;
        this.targetParentId = r103;
    }
}
