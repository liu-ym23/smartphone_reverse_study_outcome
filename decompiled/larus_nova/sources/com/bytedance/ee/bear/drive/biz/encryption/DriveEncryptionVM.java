package com.bytedance.ee.bear.drive.biz.encryption;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/encryption/DriveEncryptionVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "encryptionKeyDeleted", "Landroidx/lifecycle/MutableLiveData;", "", "getEncryptionKeyDeleted", "()Landroidx/lifecycle/MutableLiveData;", "isEncryptionKeyDeleted", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveEncryptionVM extends ViewModel {
    private final MutableLiveData<Boolean> encryptionKeyDeleted;

    public final boolean isEncryptionKeyDeleted() {
        return Intrinsics.areEqual(this.encryptionKeyDeleted.getValue(), Boolean.TRUE);
    }

    public DriveEncryptionVM() {
        this.encryptionKeyDeleted = new MutableLiveData();
    }

    public final MutableLiveData<Boolean> getEncryptionKeyDeleted() {
        return this.encryptionKeyDeleted;
    }
}
