package com.obric.cae.libs.l4NetStatus;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes33.dex */
public class QoeStatus implements Parcelable {
    public static final Parcelable.Creator<QoeStatus> CREATOR = null;
    public String appPackageName;
    public int errBitMap;
    public String ifName;
    public int recvOooPercent;
    public int recvPackets;
    public int recvRate;
    public int rttAve;
    public int sendPackets;
    public int sendRate;
    public int sendRetrans;
    public int statSrcType;
    public int streamNum;
    public int tcpSndCwnd;
    public int tcpSndSsthresh;
    public long totalRecvBytes;
    public long totalRecvPackets;
    public long totalSegsIn;
    public long totalSegsOut;
    public long totalSendBytes;
    public long totalSendPackets;
    public int uid;
    public int unacked;

    public class a implements Parcelable.Creator<QoeStatus> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QoeStatus createFromParcel(Parcel r100) {
            return new QoeStatus(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final QoeStatus[] newArray(int r100) {
            return new QoeStatus[r100];
        }
    }

    public void clear() {
        this.statSrcType = 0;
        this.uid = 0;
        this.appPackageName = "NULL";
        this.ifName = "NULL";
        this.streamNum = 0;
        this.rttAve = 0;
        this.totalSendPackets = 0;
        this.totalRecvPackets = 0;
        this.totalSegsOut = 0;
        this.totalSegsIn = 0;
        this.totalSendBytes = 0;
        this.totalRecvBytes = 0;
        this.sendPackets = 0;
        this.recvPackets = 0;
        this.sendRate = 0;
        this.recvRate = 0;
        this.sendRetrans = 0;
        this.recvOooPercent = 0;
        this.unacked = 0;
        this.tcpSndSsthresh = 0;
        this.tcpSndCwnd = 0;
        this.errBitMap = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "QoeStatus{statSrcType=" + this.statSrcType + ", uid=" + this.uid + ", appPackageName='" + this.appPackageName + "', ifName='" + this.ifName + "', streamNum=" + this.streamNum + ", rttAve=" + this.rttAve + ", totalSendPackets=" + this.totalSendPackets + ", totalRecvPackets=" + this.totalRecvPackets + ", totalSegsOut=" + this.totalSegsOut + ", totalSegsIn=" + this.totalSegsIn + ", totalSendBytes=" + this.totalSendBytes + ", totalRecvBytes=" + this.totalRecvBytes + ", sendPackets=" + this.sendPackets + ", recvPackets=" + this.recvPackets + ", sendRate=" + this.sendRate + ", recvRate=" + this.recvRate + ", sendRetrans=" + this.sendRetrans + ", recvOooPercent=" + this.recvOooPercent + ", unacked=" + this.unacked + ", errBitMap=" + this.errBitMap + ", tcpSndSsthresh=" + this.tcpSndSsthresh + ", tcpSndCwnd=" + this.tcpSndCwnd + '}';
    }

    public QoeStatus() {
        this.statSrcType = 0;
        this.appPackageName = "NULL";
        this.ifName = "NULL";
    }

    public String getAppPackageName() {
        return this.appPackageName;
    }

    public int getErrBitMap() {
        return this.errBitMap;
    }

    public String getIfName() {
        return this.ifName;
    }

    public int getRecvOooPercent() {
        return this.recvOooPercent;
    }

    public int getRecvPackets() {
        return this.recvPackets;
    }

    public int getRecvRate() {
        return this.recvRate;
    }

    public int getRttAve() {
        return this.rttAve;
    }

    public int getSendPackets() {
        return this.sendPackets;
    }

    public int getSendRate() {
        return this.sendRate;
    }

    public int getSendRetrans() {
        return this.sendRetrans;
    }

    public int getStatSrcType() {
        return this.statSrcType;
    }

    public int getStreamNum() {
        return this.streamNum;
    }

    public int getTcpSndCwnd() {
        return this.tcpSndCwnd;
    }

    public int getTcpSndSsthresh() {
        return this.tcpSndSsthresh;
    }

    public long getTotalRecvBytes() {
        return this.totalRecvBytes;
    }

    public long getTotalRecvPackets() {
        return this.totalRecvPackets;
    }

    public long getTotalSegsIn() {
        return this.totalSegsIn;
    }

    public long getTotalSegsOut() {
        return this.totalSegsOut;
    }

    public long getTotalSendBytes() {
        return this.totalSendBytes;
    }

    public long getTotalSendPackets() {
        return this.totalSendPackets;
    }

    public int getUid() {
        return this.uid;
    }

    public int getUnacked() {
        return this.unacked;
    }

    public QoeStatus(Parcel r100) {
        this.statSrcType = r100.readInt();
        this.uid = r100.readInt();
        this.appPackageName = r100.readString();
        this.ifName = r100.readString();
        this.streamNum = r100.readInt();
        this.rttAve = r100.readInt();
        this.totalSendPackets = r100.readLong();
        this.totalRecvPackets = r100.readLong();
        this.totalSegsOut = r100.readLong();
        this.totalSegsIn = r100.readLong();
        this.totalSendBytes = r100.readLong();
        this.totalRecvBytes = r100.readLong();
        this.sendPackets = r100.readInt();
        this.recvPackets = r100.readInt();
        this.sendRate = r100.readInt();
        this.recvRate = r100.readInt();
        this.sendRetrans = r100.readInt();
        this.recvOooPercent = r100.readInt();
        this.unacked = r100.readInt();
        this.tcpSndSsthresh = r100.readInt();
        this.tcpSndCwnd = r100.readInt();
        this.errBitMap = r100.readInt();
    }

    public void setAppPackageName(String r100) {
        this.appPackageName = r100;
    }

    public void setErrBitMap(int r100) {
        this.errBitMap = r100;
    }

    public void setIfName(String r100) {
        this.ifName = r100;
    }

    public void setRecvOooPercent(int r100) {
        this.recvOooPercent = r100;
    }

    public void setRecvPackets(int r100) {
        this.recvPackets = r100;
    }

    public void setRecvRate(int r100) {
        this.recvRate = r100;
    }

    public void setRttAve(int r100) {
        this.rttAve = r100;
    }

    public void setSendPackets(int r100) {
        this.sendPackets = r100;
    }

    public void setSendRate(int r100) {
        this.sendRate = r100;
    }

    public void setSendRetrans(int r100) {
        this.sendRetrans = r100;
    }

    public void setStatSrcType(int r100) {
        this.statSrcType = r100;
    }

    public void setStreamNum(int r100) {
        this.streamNum = r100;
    }

    public void setTcpSndCwnd(int r100) {
        this.tcpSndCwnd = r100;
    }

    public void setTcpSndSsthresh(int r100) {
        this.tcpSndSsthresh = r100;
    }

    public void setTotalRecvBytes(long r100) {
        this.totalRecvBytes = r100;
    }

    public void setTotalRecvPackets(long r100) {
        this.totalRecvPackets = r100;
    }

    public void setTotalSegsIn(long r100) {
        this.totalSegsIn = r100;
    }

    public void setTotalSegsOut(long r100) {
        this.totalSegsOut = r100;
    }

    public void setTotalSendBytes(long r100) {
        this.totalSendBytes = r100;
    }

    public void setTotalSendPackets(long r100) {
        this.totalSendPackets = r100;
    }

    public void setUid(int r100) {
        this.uid = r100;
    }

    public void setUnacked(int r100) {
        this.unacked = r100;
    }

    public QoeStatus(QoeStatus r100) {
        this.statSrcType = r100.statSrcType;
        this.uid = r100.uid;
        this.appPackageName = r100.appPackageName;
        this.ifName = r100.ifName;
        this.streamNum = r100.streamNum;
        this.rttAve = r100.rttAve;
        this.totalSendPackets = r100.totalSendPackets;
        this.totalRecvPackets = r100.totalRecvPackets;
        this.totalSegsOut = r100.totalSegsOut;
        this.totalSegsIn = r100.totalSegsIn;
        this.totalSendBytes = r100.totalSendBytes;
        this.totalRecvBytes = r100.totalRecvBytes;
        this.sendPackets = r100.sendPackets;
        this.recvPackets = r100.recvPackets;
        this.sendRate = r100.sendRate;
        this.recvRate = r100.recvRate;
        this.sendRetrans = r100.sendRetrans;
        this.recvOooPercent = r100.recvOooPercent;
        this.unacked = r100.unacked;
        this.tcpSndSsthresh = r100.tcpSndSsthresh;
        this.tcpSndCwnd = r100.tcpSndCwnd;
        this.errBitMap = r100.errBitMap;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.statSrcType);
        r100.writeInt(this.uid);
        r100.writeString(this.appPackageName);
        r100.writeString(this.ifName);
        r100.writeInt(this.streamNum);
        r100.writeInt(this.rttAve);
        r100.writeLong(this.totalSendPackets);
        r100.writeLong(this.totalRecvPackets);
        r100.writeLong(this.totalSegsOut);
        r100.writeLong(this.totalSegsIn);
        r100.writeLong(this.totalSendBytes);
        r100.writeLong(this.totalRecvBytes);
        r100.writeInt(this.sendPackets);
        r100.writeInt(this.recvPackets);
        r100.writeInt(this.sendRate);
        r100.writeInt(this.recvRate);
        r100.writeInt(this.sendRetrans);
        r100.writeInt(this.recvOooPercent);
        r100.writeInt(this.unacked);
        r100.writeInt(this.tcpSndSsthresh);
        r100.writeInt(this.tcpSndCwnd);
        r100.writeInt(this.errBitMap);
    }
}
