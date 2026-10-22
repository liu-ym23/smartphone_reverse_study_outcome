package com.bytedance.ee.bear.drive.loader.download.platform;

import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;

/* JADX INFO: loaded from: classes16.dex */
public class DownloadOptions {
    private static final String TAG = "DownloadOptions";
    private DriveBizScene driveBizScene;
    private DriveWatermarkScene driveWatermarkScene;

    public static DownloadOptions defaultOptions() {
        return new DownloadOptions();
    }

    public boolean canCache() {
        DriveBizScene r100 = this.driveBizScene;
        if (r100 == null) goto L14;
        DriveWatermarkScene r101 = this.driveWatermarkScene;
        if (r101 != null) goto L8;
        return true;
    L8:
        if (r100 != DriveBizScene.DriveBizScene_UNKNOWN) goto L10;
        return true;
    L10:
        if (r101 == DriveWatermarkScene.DriveWatermarkScene_NONE) goto L17;
        return false;
    L17:
        return true;
    L14:
        return true;
    }

    public String toString() {
        return "DownloadOptions{driveBizScene=" + this.driveBizScene + ", driveWatermarkScene=" + this.driveWatermarkScene + '}';
    }

    private DownloadOptions() {
        this.driveBizScene = null;
        this.driveWatermarkScene = null;
    }

    public DriveBizScene getDriveBizScene() {
        return this.driveBizScene;
    }

    public DriveWatermarkScene getDriveWatermarkScene() {
        return this.driveWatermarkScene;
    }

    public static DownloadOptions from(BaseOpenEntity r100) {
        tt5.a.h(TAG, "from, baseOpenEntity: " + r100);
        DownloadOptions r101 = new DownloadOptions();
        r101.setDriveBizScene(r100.getBizScene());
        r101.setDriveWatermarkScene(r100.getWatermarkScene());
        return r101;
    }

    public void setDriveBizScene(DriveBizScene r100) {
        this.driveBizScene = r100;
    }

    public void setDriveWatermarkScene(DriveWatermarkScene r100) {
        this.driveWatermarkScene = r100;
    }
}
