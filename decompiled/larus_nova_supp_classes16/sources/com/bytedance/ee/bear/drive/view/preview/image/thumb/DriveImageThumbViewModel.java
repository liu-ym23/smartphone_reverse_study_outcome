package com.bytedance.ee.bear.drive.view.preview.image.thumb;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/image/thumb/DriveImageThumbViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "isOnImageDowngrade", "Landroidx/lifecycle/MutableLiveData;", "", "()Landroidx/lifecycle/MutableLiveData;", "isOnImageThumbProcess", "isImageThumbSuccess", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveImageThumbViewModel extends ViewModel {
    private final MutableLiveData<Boolean> isImageThumbSuccess;
    private final MutableLiveData<Boolean> isOnImageDowngrade;
    private final MutableLiveData<Boolean> isOnImageThumbProcess;

    public DriveImageThumbViewModel() {
        this.isOnImageDowngrade = new MutableLiveData();
        this.isOnImageThumbProcess = new MutableLiveData();
        this.isImageThumbSuccess = new MutableLiveData();
    }

    public final MutableLiveData<Boolean> isImageThumbSuccess() {
        return this.isImageThumbSuccess;
    }

    public final MutableLiveData<Boolean> isOnImageDowngrade() {
        return this.isOnImageDowngrade;
    }

    public final MutableLiveData<Boolean> isOnImageThumbProcess() {
        return this.isOnImageThumbProcess;
    }
}
