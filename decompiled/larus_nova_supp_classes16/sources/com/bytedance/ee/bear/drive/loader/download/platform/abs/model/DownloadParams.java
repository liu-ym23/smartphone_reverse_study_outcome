package com.bytedance.ee.bear.drive.loader.download.platform.abs.model;

import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DownloadParams {
    private DownloadRequestInfo.DownloadType downloadType;
    private DriveBizScene driveBizScene;
    private DriveWatermarkScene driveWatermarkScene;
    private DrivePriority.DownloadPriority priority;
    private boolean saveToLocalFilePath;

    public static class Builder {
        private DownloadRequestInfo.DownloadType downloadType;
        private DriveBizScene driveBizScene;
        private DriveWatermarkScene driveWatermarkScene;
        private DrivePriority.DownloadPriority priority;
        private boolean saveToLocalFilePath;

        public DownloadParams build() {
            return new DownloadParams(this.saveToLocalFilePath, this.priority, this.downloadType, this.driveBizScene, this.driveWatermarkScene);
        }

        public Builder() {
        }

        public Builder downloadType(DownloadRequestInfo.DownloadType r1) {
            this.downloadType = r1;
            return this;
        }

        public Builder driveBizScene(DriveBizScene r1) {
            this.driveBizScene = r1;
            return this;
        }

        public Builder driveWatermarkScene(DriveWatermarkScene r1) {
            this.driveWatermarkScene = r1;
            return this;
        }

        public Builder priority(DrivePriority.DownloadPriority r1) {
            this.priority = r1;
            return this;
        }

        public Builder saveToLocalFilePath(boolean r1) {
            this.saveToLocalFilePath = r1;
            return this;
        }
    }

    public String toString() {
        return "DownloadParams{saveToLocalFilePath=" + this.saveToLocalFilePath + ", priority=" + this.priority + ", downloadType=" + this.downloadType + ", driveBizScene=" + this.driveBizScene + ", driveWatermarkScene=" + this.driveWatermarkScene + '}';
    }

    public DownloadRequestInfo.DownloadType getDownloadType() {
        return this.downloadType;
    }

    public DriveBizScene getDriveBizScene() {
        return this.driveBizScene;
    }

    public DriveWatermarkScene getDriveWatermarkScene() {
        return this.driveWatermarkScene;
    }

    public DrivePriority.DownloadPriority getPriority() {
        return this.priority;
    }

    public boolean isSaveToLocalFilePath() {
        return this.saveToLocalFilePath;
    }

    public void setDownloadType(DownloadRequestInfo.DownloadType r1) {
        this.downloadType = r1;
    }

    public void setDriveBizScene(DriveBizScene r1) {
        this.driveBizScene = r1;
    }

    public void setDriveWatermarkScene(DriveWatermarkScene r1) {
        this.driveWatermarkScene = r1;
    }

    public void setPriority(DrivePriority.DownloadPriority r1) {
        this.priority = r1;
    }

    public void setSaveToLocalFilePath(boolean r1) {
        this.saveToLocalFilePath = r1;
    }

    public DownloadParams(boolean r1, DrivePriority.DownloadPriority r2, DownloadRequestInfo.DownloadType r3, DriveBizScene r4, DriveWatermarkScene r5) {
        this.saveToLocalFilePath = r1;
        this.priority = r2;
        this.downloadType = r3;
        this.driveBizScene = r4;
        this.driveWatermarkScene = r5;
    }
}
