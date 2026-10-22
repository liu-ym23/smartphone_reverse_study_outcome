package com.bytedance.ee.bear.bitable.uikit.catalog;

import com.bytedance.ee.bear.bitable.uikit.Action;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/catalog/ToggleFolderAction;", "Lcom/bytedance/ee/bear/bitable/uikit/Action;", "id", "", "collapsed", "", "<init>", "(Ljava/lang/String;Z)V", "getCollapsed", "()Z", "setCollapsed", "(Z)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToggleFolderAction extends Action {
    private boolean collapsed;

    public final boolean getCollapsed() {
        return this.collapsed;
    }

    public final void setCollapsed(boolean r100) {
        this.collapsed = r100;
    }

    public ToggleFolderAction(String r100, boolean r101) {
        Action.Companion.getClass();
        super(r100, Action.access$getTYPE_TOGGLE_FOLDER$cp());
        this.collapsed = r101;
    }
}
