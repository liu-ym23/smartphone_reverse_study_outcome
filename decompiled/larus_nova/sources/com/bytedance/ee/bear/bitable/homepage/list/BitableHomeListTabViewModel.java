package com.bytedance.ee.bear.bitable.homepage.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/list/BitableHomeListTabViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "tabIndexState", "Landroidx/lifecycle/MutableLiveData;", "", "setTabIndexState", "", "state", "tabIndexStateLiveData", "Landroidx/lifecycle/LiveData;", "getTabIndexStateLiveData", "()Landroidx/lifecycle/LiveData;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableHomeListTabViewModel extends ViewModel {
    private final MutableLiveData<Integer> tabIndexState;

    public BitableHomeListTabViewModel() {
        this.tabIndexState = new MutableLiveData();
    }

    public final LiveData<Integer> getTabIndexStateLiveData() {
        return this.tabIndexState;
    }

    public final void setTabIndexState(int r100) {
        this.tabIndexState.setValue(Integer.valueOf(r100));
    }
}
