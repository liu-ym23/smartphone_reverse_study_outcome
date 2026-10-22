package com.bytedance.ee.bear.bitable.managerpanel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR%\u0010\f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rj\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "active", "Landroidx/lifecycle/MutableLiveData;", "", "getActive", "()Landroidx/lifecycle/MutableLiveData;", "panelData", "Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData;", "getPanelData", "mExpandedTableList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getMExpandedTableList", "()Ljava/util/ArrayList;", "operationCallBack", "Lcom/bytedance/ee/bear/bitable/managerpanel/OperationCallBack;", "getOperationCallBack", "()Lcom/bytedance/ee/bear/bitable/managerpanel/OperationCallBack;", "setOperationCallBack", "(Lcom/bytedance/ee/bear/bitable/managerpanel/OperationCallBack;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableManagerPanelViewModel extends ViewModel {
    private final MutableLiveData<Boolean> active;
    private final ArrayList<String> mExpandedTableList;
    private i operationCallBack;
    private final MutableLiveData<BitableManagerPanelData> panelData;

    public final i getOperationCallBack() {
        return null;
    }

    public final void setOperationCallBack(i r100) {
    }

    public BitableManagerPanelViewModel() {
        this.active = new MutableLiveData();
        this.panelData = new MutableLiveData();
        this.mExpandedTableList = new ArrayList();
    }

    public final MutableLiveData<Boolean> getActive() {
        return this.active;
    }

    public final ArrayList<String> getMExpandedTableList() {
        return this.mExpandedTableList;
    }

    public final MutableLiveData<BitableManagerPanelData> getPanelData() {
        return this.panelData;
    }
}
