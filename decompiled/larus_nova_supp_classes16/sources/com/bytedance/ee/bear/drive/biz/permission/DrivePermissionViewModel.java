package com.bytedance.ee.bear.drive.biz.permission;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.drive.biz.permission.inject.PointValue;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/permission/DrivePermissionViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "tenantId", "Landroidx/lifecycle/MutableLiveData;", "", "getTenantId", "()Landroidx/lifecycle/MutableLiveData;", "liveCopyPerm", "", "getLiveCopyPerm", "liveCopyEscape", "getLiveCopyEscape", "liveOuterCopyable", "Lcom/bytedance/ee/bear/drive/biz/permission/inject/PointValue;", "getLiveOuterCopyable", "liveOuterRawCopyable", "getLiveOuterRawCopyable", "liveOuterEditable", "getLiveOuterEditable", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePermissionViewModel extends ViewModel {
    private final MutableLiveData<Boolean> liveCopyEscape;
    private final MutableLiveData<Boolean> liveCopyPerm;
    private final MutableLiveData<PointValue> liveOuterCopyable;
    private final MutableLiveData<Boolean> liveOuterEditable;
    private final MutableLiveData<Boolean> liveOuterRawCopyable;
    private final MutableLiveData<String> tenantId;

    public DrivePermissionViewModel() {
        this.tenantId = new MutableLiveData();
        this.liveCopyPerm = new MutableLiveData();
        this.liveCopyEscape = new MutableLiveData();
        this.liveOuterCopyable = new MutableLiveData();
        this.liveOuterRawCopyable = new MutableLiveData();
        this.liveOuterEditable = new MutableLiveData();
    }

    public final MutableLiveData<Boolean> getLiveCopyEscape() {
        return this.liveCopyEscape;
    }

    public final MutableLiveData<Boolean> getLiveCopyPerm() {
        return this.liveCopyPerm;
    }

    public final MutableLiveData<PointValue> getLiveOuterCopyable() {
        return this.liveOuterCopyable;
    }

    public final MutableLiveData<Boolean> getLiveOuterEditable() {
        return this.liveOuterEditable;
    }

    public final MutableLiveData<Boolean> getLiveOuterRawCopyable() {
        return this.liveOuterRawCopyable;
    }

    public final MutableLiveData<String> getTenantId() {
        return this.tenantId;
    }
}
