package com.bytedance.ee.bear.content.common.morepanel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/content/common/morepanel/CommonMorePanelViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "selectData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/content/common/morepanel/CommonMorePanelItemData;", "getSelectData", "()Landroidx/lifecycle/MutableLiveData;", "triggerResetData", "", "getTriggerResetData", "setTriggerResetData", "(Landroidx/lifecycle/MutableLiveData;)V", "contentmanager-content-widget_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonMorePanelViewModel extends ViewModel {
    private final MutableLiveData<CommonMorePanelItemData> selectData;
    private MutableLiveData<Boolean> triggerResetData;

    public CommonMorePanelViewModel() {
        this.selectData = new MutableLiveData();
        this.triggerResetData = new MutableLiveData();
    }

    public final MutableLiveData<CommonMorePanelItemData> getSelectData() {
        return this.selectData;
    }

    public final MutableLiveData<Boolean> getTriggerResetData() {
        return this.triggerResetData;
    }

    public final void setTriggerResetData(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.triggerResetData = r100;
    }
}
