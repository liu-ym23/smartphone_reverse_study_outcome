package com.bytedance.ee.bear.bitable.panel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/panel/BitableViewTreePanelViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "panelActive", "Landroidx/lifecycle/MutableLiveData;", "", "getPanelActive", "()Landroidx/lifecycle/MutableLiveData;", "panelModel", "Lcom/bytedance/ee/bear/bitable/panel/BitableViewTreePanelModel;", "getPanelModel", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableViewTreePanelViewModel extends ViewModel {
    private final MutableLiveData<Boolean> panelActive;
    private final MutableLiveData<BitableViewTreePanelModel> panelModel;

    public BitableViewTreePanelViewModel() {
        this.panelActive = new MutableLiveData();
        this.panelModel = new MutableLiveData();
    }

    public final MutableLiveData<Boolean> getPanelActive() {
        return this.panelActive;
    }

    public final MutableLiveData<BitableViewTreePanelModel> getPanelModel() {
        return this.panelModel;
    }
}
