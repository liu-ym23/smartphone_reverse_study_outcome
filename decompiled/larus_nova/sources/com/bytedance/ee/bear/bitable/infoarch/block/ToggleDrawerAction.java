package com.bytedance.ee.bear.bitable.infoarch.block;

import com.bytedance.ee.bear.bitable.uikit.Action;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/block/ToggleDrawerAction;", "Lcom/bytedance/ee/bear/bitable/uikit/Action;", "blockCatalogueHidden", "", "<init>", "(Z)V", "getBlockCatalogueHidden", "()Z", "toString", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToggleDrawerAction extends Action {
    private final boolean blockCatalogueHidden;

    @Override // com.bytedance.ee.bear.bitable.uikit.Action
    public String toString() {
        return "ToggleDrawerAction(action=" + getAction() + ", isHidden=" + this.blockCatalogueHidden + '}';
    }

    public final boolean getBlockCatalogueHidden() {
        return this.blockCatalogueHidden;
    }

    public ToggleDrawerAction(boolean r100) {
        super(null, "BlockCatalogueStatusChange");
        this.blockCatalogueHidden = r100;
    }
}
