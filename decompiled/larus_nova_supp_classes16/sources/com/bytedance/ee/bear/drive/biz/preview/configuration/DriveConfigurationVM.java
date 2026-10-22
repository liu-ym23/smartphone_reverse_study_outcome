package com.bytedance.ee.bear.drive.biz.preview.configuration;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.drive.biz.preview.orientation.DrivePreviewStatus;
import com.bytedance.ee.bear.drive.biz.preview.vc.pdf.DrivePdfState;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/configuration/DriveConfigurationVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "liveUiState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/drive/biz/preview/orientation/DrivePreviewStatus;", "getLiveUiState", "()Landroidx/lifecycle/MutableLiveData;", "isPortrait", "", "isLandscape", "lastPreviewConfig", "Lcom/bytedance/ee/bear/drive/biz/preview/vc/pdf/DrivePdfState$V2Offset;", "getLastPreviewConfig", "currentV2Offset", "getCurrentV2Offset", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveConfigurationVM extends ViewModel {
    private final MutableLiveData<DrivePdfState.V2Offset> currentV2Offset;
    private final MutableLiveData<Boolean> isLandscape;
    private final MutableLiveData<Boolean> isPortrait;
    private final MutableLiveData<DrivePdfState.V2Offset> lastPreviewConfig;
    private final MutableLiveData<DrivePreviewStatus> liveUiState;

    public DriveConfigurationVM() {
        this.liveUiState = new MutableLiveData();
        this.isPortrait = new MutableLiveData();
        this.isLandscape = new MutableLiveData();
        this.lastPreviewConfig = new MutableLiveData();
        this.currentV2Offset = new MutableLiveData();
    }

    public final MutableLiveData<DrivePdfState.V2Offset> getCurrentV2Offset() {
        return this.currentV2Offset;
    }

    public final MutableLiveData<DrivePdfState.V2Offset> getLastPreviewConfig() {
        return this.lastPreviewConfig;
    }

    public final MutableLiveData<DrivePreviewStatus> getLiveUiState() {
        return this.liveUiState;
    }

    public final MutableLiveData<Boolean> isLandscape() {
        return this.isLandscape;
    }

    public final MutableLiveData<Boolean> isPortrait() {
        return this.isPortrait;
    }
}
