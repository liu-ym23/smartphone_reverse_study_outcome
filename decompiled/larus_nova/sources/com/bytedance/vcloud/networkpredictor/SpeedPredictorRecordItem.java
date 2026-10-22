package com.bytedance.vcloud.networkpredictor;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class SpeedPredictorRecordItem {
    private long mBytes;
    private long mLastDataRecv;
    private long mMDLBufferCurrentSize;
    private long mMDLBufferMaxSize;
    private long mMDLRangeEndOffset;
    private long mMDLRangeStartOffset;
    private String mProtocol;
    private long mTcpInfoRtt;
    private long mTime;
    private long mTimestamp;
    private int mTrackType;
    private String mhost;
    private String mloadType;

    public SpeedPredictorRecordItem() {
        this.mTrackType = 0;
    }

    public long getBytes() {
        return this.mBytes;
    }

    public String getHost() {
        return this.mhost;
    }

    public long getLastDataRecv() {
        return this.mLastDataRecv;
    }

    public String getLoadType() {
        return this.mloadType;
    }

    public long getMDLBufferCurrentSize() {
        return this.mMDLBufferCurrentSize;
    }

    public long getMDLBufferMaxSize() {
        return this.mMDLBufferMaxSize;
    }

    public long getMDLRangeEndOffset() {
        return this.mMDLRangeEndOffset;
    }

    public long getMDLRangeStartOffset() {
        return this.mMDLRangeStartOffset;
    }

    public String getProtocol() {
        return this.mProtocol;
    }

    public long getTcpInfoRtt() {
        return this.mTcpInfoRtt;
    }

    public long getTime() {
        return this.mTime;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public int getTrackType() {
        return this.mTrackType;
    }

    public void extractFields(JSONObject r100) throws Throwable {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mTrackType = r100.optInt("trackType");
        this.mBytes = r100.optLong("size");
        this.mTime = r100.optLong(WiseOpenHianalyticsData.UNION_COSTTIME);
        this.mTimestamp = r100.optLong("timestamp");
        this.mloadType = r100.optString("loadType");
        this.mhost = r100.optString("host");
        this.mTcpInfoRtt = r100.optLong("rtt");
        this.mLastDataRecv = r100.optLong("last_data_recv");
        this.mProtocol = r100.optString("protocol");
        this.mMDLBufferCurrentSize = r100.optLong("cbs");
        this.mMDLBufferMaxSize = r100.optLong("fbs");
        this.mMDLRangeStartOffset = r100.optLong("s_off");
        this.mMDLRangeEndOffset = r100.optLong("e_off");
    }

    public void setBytes(long r100) {
        this.mBytes = r100;
    }

    public void setHost(String r100) {
        this.mhost = r100;
    }

    public void setLastDataRecv(long r100) {
        this.mLastDataRecv = r100;
    }

    public void setLoadType(String r100) {
        this.mloadType = r100;
    }

    public void setMDLBufferCurrentSize(long r100) {
        this.mMDLBufferCurrentSize = r100;
    }

    public void setMDLBufferMaxSize(long r100) {
        this.mMDLBufferMaxSize = r100;
    }

    public void setMDLRangeEndOffset(long r100) {
        this.mMDLRangeEndOffset = r100;
    }

    public void setMDLRangeStartOffset(long r100) {
        this.mMDLRangeStartOffset = r100;
    }

    public void setProtocol(String r100) {
        this.mProtocol = r100;
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
