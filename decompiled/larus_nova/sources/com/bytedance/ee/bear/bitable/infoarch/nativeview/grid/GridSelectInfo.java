package com.bytedance.ee.bear.bitable.infoarch.nativeview.grid;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridSelectInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "showCheckBox", "", "getShowCheckBox", "()Z", "setShowCheckBox", "(Z)V", "isSelected", "setSelected", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GridSelectInfo implements NonProguard {
    private boolean isSelected;
    private boolean showCheckBox;

    public GridSelectInfo() {
    }

    public final boolean getShowCheckBox() {
        return this.showCheckBox;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean r100) {
        this.isSelected = r100;
    }

    public final void setShowCheckBox(boolean r100) {
        this.showCheckBox = r100;
    }
}
