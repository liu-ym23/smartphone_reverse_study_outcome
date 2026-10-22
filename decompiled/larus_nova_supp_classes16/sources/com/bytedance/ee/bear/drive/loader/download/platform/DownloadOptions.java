package com.bytedance.ee.bear.drive.loader.download.platform;

import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DownloadOptions {
    private static final String TAG = "DownloadOptions";
    private DriveBizScene driveBizScene;
    private DriveWatermarkScene driveWatermarkScene;

    public static DownloadOptions defaultOptions() {
        return new DownloadOptions();
    }

    public boolean canCache() {
        DriveBizScene r0 = this.driveBizScene;
        if (r0 == null) goto L14;
        DriveWatermarkScene r2 = this.driveWatermarkScene;
        if (r2 != null) goto L8;
        return true;
    L8:
        if (r0 != DriveBizScene.DriveBizScene_UNKNOWN) goto L10;
        return true;
    L10:
        if (r2 == DriveWatermarkScene.DriveWatermarkScene_NONE) goto L17;
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

    public static DownloadOptions from(BaseOpenEntity r2) {
        tt5.a.h(TAG, "from, baseOpenEntity: " + r2);
        DownloadOptions r0 = new DownloadOptions();
        r0.setDriveBizScene(r2.getBizScene());
        r0.setDriveWatermarkScene(r2.getWatermarkScene());
        return r0;
    }

    public void setDriveBizScene(DriveBizScene r1) {
        this.driveBizScene = r1;
    }

    public void setDriveWatermarkScene(DriveWatermarkScene r1) {
        this.driveWatermarkScene = r1;
    }
}
