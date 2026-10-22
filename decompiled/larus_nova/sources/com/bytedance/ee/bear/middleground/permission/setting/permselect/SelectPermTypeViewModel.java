package com.bytedance.ee.bear.middleground.permission.setting.permselect;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fJ\u0006\u0010\u0010\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/setting/permselect/SelectPermTypeViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "permType", "", "dismissLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getPermTypeValue", "setPermType", "", "setDismiss", "dismiss", "getDismissLiveData", "Landroidx/lifecycle/LiveData;", BasicTestActionHandler.TEST_ACTION_RESET, "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectPermTypeViewModel extends ViewModel {
    private final MutableLiveData<Boolean> dismissLiveData;
    private int permType;

    public final void reset() {
        this.permType = 0;
        this.dismissLiveData.setValue(Boolean.FALSE);
    }

    public SelectPermTypeViewModel() {
        this.dismissLiveData = new MutableLiveData();
    }

    public final LiveData<Boolean> getDismissLiveData() {
        return this.dismissLiveData;
    }

    public final int getPermTypeValue() {
        return this.permType;
    }

    public final void setDismiss(boolean r100) {
        this.dismissLiveData.setValue(Boolean.valueOf(r100));
    }

    public final void setPermType(int r100) {
        this.permType = r100;
    }
}
