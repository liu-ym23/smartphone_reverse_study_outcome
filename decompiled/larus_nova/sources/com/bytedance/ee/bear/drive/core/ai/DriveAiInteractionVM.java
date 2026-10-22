package com.bytedance.ee.bear.drive.core.ai;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\rR\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/ai/DriveAiInteractionVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mutableActive", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "active", "Landroidx/lifecycle/LiveData;", "getActive", "()Landroidx/lifecycle/LiveData;", "setActive", "", "clear", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveAiInteractionVM extends ViewModel {
    private final LiveData<Boolean> active;
    private final MutableLiveData<Boolean> mutableActive;

    public final void clear() {
        setActive(false);
    }

    public DriveAiInteractionVM() {
        MutableLiveData<Boolean> r100 = new MutableLiveData(Boolean.FALSE);
        this.mutableActive = r100;
        this.active = r100;
    }

    public final LiveData<Boolean> getActive() {
        return this.active;
    }

    public final void setActive(boolean r100) {
        if (Intrinsics.areEqual(this.mutableActive.getValue(), Boolean.valueOf(r100)) == true) goto L6;
        this.mutableActive.setValue(Boolean.valueOf(r100));
        return;
    }
}
