package com.bytedance.ee.bear.drive.loader.download.platform.abs.model;

import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority$DownloadPriority;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;

/* JADX INFO: loaded from: classes16.dex */
public class DownloadParams {
    private DownloadRequestInfo.DownloadType downloadType;
    private DriveBizScene driveBizScene;
    private DriveWatermarkScene driveWatermarkScene;
    private DrivePriority$DownloadPriority priority;
    private boolean saveToLocalFilePath;

    public static class Builder {
        private DownloadRequestInfo.DownloadType downloadType;
        private DriveBizScene driveBizScene;
        private DriveWatermarkScene driveWatermarkScene;
        private DrivePriority$DownloadPriority priority;
        private boolean saveToLocalFilePath;

        public DownloadParams build() {
            return new DownloadParams(this.saveToLocalFilePath, this.priority, this.downloadType, this.driveBizScene, this.driveWatermarkScene);
        }

        public Builder() {
        }

        public Builder downloadType(DownloadRequestInfo.DownloadType r100) {
            this.downloadType = r100;
            return this;
        }

        public Builder driveBizScene(DriveBizScene r100) {
            this.driveBizScene = r100;
            return this;
        }

        public Builder driveWatermarkScene(DriveWatermarkScene r100) {
            this.driveWatermarkScene = r100;
            return this;
        }

        public Builder priority(DrivePriority$DownloadPriority r100) {
            this.priority = r100;
            return this;
        }

        public Builder saveToLocalFilePath(boolean r100) {
            this.saveToLocalFilePath = r100;
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

    public DrivePriority$DownloadPriority getPriority() {
        return this.priority;
    }

    public boolean isSaveToLocalFilePath() {
        return this.saveToLocalFilePath;
    }

    public void setDownloadType(DownloadRequestInfo.DownloadType r100) {
        this.downloadType = r100;
    }

    public void setDriveBizScene(DriveBizScene r100) {
        this.driveBizScene = r100;
    }

    public void setDriveWatermarkScene(DriveWatermarkScene r100) {
        this.driveWatermarkScene = r100;
    }

    public void setPriority(DrivePriority$DownloadPriority r100) {
        this.priority = r100;
    }

    public void setSaveToLocalFilePath(boolean r100) {
        this.saveToLocalFilePath = r100;
    }

    public DownloadParams(boolean r100, DrivePriority$DownloadPriority r101, DownloadRequestInfo.DownloadType r102, DriveBizScene r103, DriveWatermarkScene r104) {
        this.saveToLocalFilePath = r100;
        this.priority = r101;
        this.downloadType = r102;
        this.driveBizScene = r103;
        this.driveWatermarkScene = r104;
    }
}
