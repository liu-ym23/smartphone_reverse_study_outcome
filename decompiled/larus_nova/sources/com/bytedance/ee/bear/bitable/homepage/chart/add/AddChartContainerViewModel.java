package com.bytedance.ee.bear.bitable.homepage.chart.add;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/add/AddChartContainerViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "onBaseSelected", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/bitable/homepage/chart/add/SelectedBase;", "getOnBaseSelected", "()Landroidx/lifecycle/MutableLiveData;", "onDismissEvent", "", "getOnDismissEvent", "containerEnv", "", "getContainerEnv", "()Ljava/lang/String;", "setContainerEnv", "(Ljava/lang/String;)V", "hpFrom", "getHpFrom", "setHpFrom", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddChartContainerViewModel extends ViewModel {
    private String containerEnv;
    private String hpFrom;
    private final MutableLiveData<SelectedBase> onBaseSelected;
    private final MutableLiveData<Unit> onDismissEvent;

    public AddChartContainerViewModel() {
        this.onBaseSelected = new MutableLiveData();
        this.onDismissEvent = new MutableLiveData();
        this.containerEnv = "";
        this.hpFrom = "";
    }

    public final String getContainerEnv() {
        return this.containerEnv;
    }

    public final String getHpFrom() {
        return this.hpFrom;
    }

    public final MutableLiveData<SelectedBase> getOnBaseSelected() {
        return this.onBaseSelected;
    }

    public final MutableLiveData<Unit> getOnDismissEvent() {
        return this.onDismissEvent;
    }

    public final void setContainerEnv(String r100) {
        this.containerEnv = r100;
    }

    public final void setHpFrom(String r100) {
        this.hpFrom = r100;
    }
}
