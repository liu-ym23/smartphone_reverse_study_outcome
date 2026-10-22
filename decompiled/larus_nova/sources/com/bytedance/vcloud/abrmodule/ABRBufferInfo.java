package com.bytedance.vcloud.abrmodule;

/* JADX INFO: loaded from: classes22.dex */
public class ABRBufferInfo implements IBufferInfo {
    private long mFileAvailSize;
    private long mHeadSize;
    private float mPlayerAvailDuration;
    private String mStreamId;

    public ABRBufferInfo() {
        this.mStreamId = "";
        this.mPlayerAvailDuration = -1.0f;
        this.mFileAvailSize = -1;
        this.mHeadSize = -1;
    }

    @Override // com.bytedance.vcloud.abrmodule.IBufferInfo
    public long getFileAvailSize() {
        return this.mFileAvailSize;
    }

    @Override // com.bytedance.vcloud.abrmodule.IBufferInfo
    public long getHeadSize() {
        return this.mHeadSize;
    }

    @Override // com.bytedance.vcloud.abrmodule.IBufferInfo
    public float getPlayerAvailDuration() {
        return this.mPlayerAvailDuration;
    }

    @Override // com.bytedance.vcloud.abrmodule.IBufferInfo
    public String getStreamId() {
        return this.mStreamId;
    }

    public void setFileAvailSize(long r100) {
        this.mFileAvailSize = r100;
    }

    public void setHeadSize(long r100) {
        this.mHeadSize = r100;
    }

    public void setPlayerAvailDuration(float r100) {
        this.mPlayerAvailDuration = r100;
    }

    public void setStreamId(String r100) {
        this.mStreamId = r100;
    }
}
