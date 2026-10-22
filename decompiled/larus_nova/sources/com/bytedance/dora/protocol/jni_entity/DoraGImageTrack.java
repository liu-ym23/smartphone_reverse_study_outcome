package com.bytedance.dora.protocol.jni_entity;

/* JADX INFO: loaded from: classes15.dex */
public class DoraGImageTrack {
    public int bluetoothSendDuration;
    public int bluetoothSendSize;
    public int captureTotal;
    public DoraGDeviceStatus deviceStatus;
    public int finishCmdAr1To2800Duration;
    public int spiFirstFrameReceiveDuration;
    public int spiReceiveDuration;
    public int startCmd2800ToAr1Duration;
    public int transferTotal;
    public int wifiSendDuration;

    public String toString() {
        return "DoraGImageTrack{startCmd2800ToAr1Duration=" + this.startCmd2800ToAr1Duration + ", finishCmdAr1To2800Duration=" + this.finishCmdAr1To2800Duration + ", captureTotal=" + this.captureTotal + ", transferTotal=" + this.transferTotal + ", spiFirstFrameReceiveDuration=" + this.spiFirstFrameReceiveDuration + ", spiReceiveDuration=" + this.spiReceiveDuration + ", bluetoothSendDuration=" + this.bluetoothSendDuration + ", wifiSendDuration=" + this.wifiSendDuration + ", bluetoothSendSize=" + this.bluetoothSendSize + ", deviceStatus=" + this.deviceStatus + '}';
    }

    public DoraGImageTrack(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, DoraGDeviceStatus r110) {
        this.startCmd2800ToAr1Duration = r100;
        this.finishCmdAr1To2800Duration = r101;
        this.spiFirstFrameReceiveDuration = r102;
        this.spiReceiveDuration = r103;
        this.bluetoothSendDuration = r104;
        this.wifiSendDuration = r105;
        this.captureTotal = r106;
        this.transferTotal = r107;
        this.bluetoothSendSize = r108;
        this.deviceStatus = r110;
    }
}
