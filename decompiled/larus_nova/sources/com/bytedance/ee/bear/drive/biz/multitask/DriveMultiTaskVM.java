package com.bytedance.ee.bear.drive.biz.multitask;

import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/multitask/DriveMultiTaskVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "currentDriveViewModel", "Lcom/bytedance/ee/bear/drive/core/DriveViewModel;", "getCurrentDriveViewModel", "()Lcom/bytedance/ee/bear/drive/core/DriveViewModel;", "setCurrentDriveViewModel", "(Lcom/bytedance/ee/bear/drive/core/DriveViewModel;)V", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMultiTaskVM extends ViewModel {
    private DriveViewModel currentDriveViewModel;

    public DriveMultiTaskVM() {
    }

    public final DriveViewModel getCurrentDriveViewModel() {
        return this.currentDriveViewModel;
    }

    public final void setCurrentDriveViewModel(DriveViewModel r100) {
        this.currentDriveViewModel = r100;
    }
}
