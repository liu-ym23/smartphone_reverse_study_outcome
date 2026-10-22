package com.ss.ttvideoengine.selector.gracie;

import com.bytedance.vcloud.abrmodule.IDeviceInfo;

/* JADX INFO: loaded from: classes34.dex */
class GracieDeviceInfo implements IDeviceInfo {
    private int mHeight;
    private int mWidth;

    @Override // com.bytedance.vcloud.abrmodule.IDeviceInfo
    public int getHDRInfo() {
        return -1;
    }

    @Override // com.bytedance.vcloud.abrmodule.IDeviceInfo
    public int getHWDecodeMaxLength() {
        return -1;
    }

    @Override // com.bytedance.vcloud.abrmodule.IDeviceInfo
    public int getScreenFps() {
        return -1;
    }

    @Override // com.bytedance.vcloud.abrmodule.IDeviceInfo
    public int getScreenHeight() {
        return this.mHeight;
    }

    @Override // com.bytedance.vcloud.abrmodule.IDeviceInfo
    public int getScreenWidth() {
        return this.mWidth;
    }

    private GracieDeviceInfo(int r100, int r101) {
        this.mWidth = r100;
        this.mHeight = r101;
    }
}
