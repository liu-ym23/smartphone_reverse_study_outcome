package com.bytedance.vcloud.networkpredictor;

/* JADX INFO: loaded from: classes22.dex */
public class SpeedPredictorRecordOld implements ISpeedRecordOld {
    private long mBytes;
    private long mLastRecvDate;
    private String mProtocol;
    private String mStreamId;
    private long mTcpInfoRtt;
    private long mTime;
    private long mTimestamp;
    private int mTrackType;

    public SpeedPredictorRecordOld() {
        this.mStreamId = "";
        this.mTrackType = 0;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedRecordOld
    public long getBytes() {
        return this.mBytes;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedRecordOld
    public long getLastRecvDate() {
        return this.mLastRecvDate;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedRecordOld
    public String getProtocol() {
        return this.mProtocol;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedRecordOld
    public String getStreamId() {
        return this.mStreamId;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedRecordOld
    public long getTcpInfoRtt() {
        return this.mTcpInfoRtt;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedRecordOld
    public long getTime() {
        return this.mTime;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedRecordOld
    public long getTimestamp() {
        return this.mTimestamp;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedRecordOld
    public int getTrackType() {
        return this.mTrackType;
    }

    public void setBytes(long r100) {
        this.mBytes = r100;
    }

    public void setLastRecvDate(long r100) {
        this.mLastRecvDate = r100;
    }

    public void setProtocol(String r100) {
        this.mProtocol = r100;
    }

    public void setSteamId(String r100) {
        this.mStreamId = r100;
    }

    public void setTcpInfoRtt(long r100) {
        this.mTcpInfoRtt = r100;
    }

    public void setTime(long r100) {
        this.mTime = r100;
    }

    public void setTimestamp(long r100) {
        this.mTimestamp = r100;
    }

    public void setTrackType(int r100) {
        this.mTrackType = r100;
    }
}
