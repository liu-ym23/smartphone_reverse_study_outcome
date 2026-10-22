package com.bytedance.ee.bear.drive.biz.wps;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001f\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001f\u0010\n\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/wps/DriveWPSPreviewViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "liveWpsTryReload", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getLiveWpsTryReload", "()Landroidx/lifecycle/MutableLiveData;", "liveWpsIsEditMode", "getLiveWpsIsEditMode", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveWPSPreviewViewModel extends ViewModel {
    private final MutableLiveData<Boolean> liveWpsIsEditMode;
    private final MutableLiveData<Boolean> liveWpsTryReload;

    public DriveWPSPreviewViewModel() {
        Boolean r1 = Boolean.FALSE;
        this.liveWpsTryReload = new MutableLiveData(r1);
        this.liveWpsIsEditMode = new MutableLiveData(r1);
    }

    public final MutableLiveData<Boolean> getLiveWpsIsEditMode() {
        return this.liveWpsIsEditMode;
    }

    public final MutableLiveData<Boolean> getLiveWpsTryReload() {
        return this.liveWpsTryReload;
    }
}
