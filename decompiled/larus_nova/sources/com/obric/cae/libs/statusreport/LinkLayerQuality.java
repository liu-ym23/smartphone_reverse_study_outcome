package com.obric.cae.libs.statusreport;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes33.dex */
public class LinkLayerQuality implements Parcelable {
    public static final Parcelable.Creator<LinkLayerQuality> CREATOR = null;
    private static final String TAG = "LinkLayerQuality";
    private int arpNeighbourCount;
    private String band;
    private String band1;
    private int ccaScore;
    private int contentionAtimeBk;
    private int contentionAtimeVi;
    private int currentChannelAPCount;
    private List<Integer> delaySizeMatrix;
    private int deltaRxBytes;
    private int deltaRxFcsErr;
    private int deltaTxBytes;
    private int delta_channel_cca_busy_time;
    private int delta_channel_on_time;
    private int delta_channel_rx_time;
    private int delta_channel_tx_time;
    private int freq;
    private String ifName;
    private boolean is_mlo_iface;
    private List<LinkStatsParcel> linkStats;
    private int perScore;
    private int rssiScore;
    private int rxBw;
    private int rxFcsErrLevel;
    private int rxMcs;
    private int rxMode;
    private int rxNss;
    private int rxRealSpeed;
    private int rxTputPred;
    private int rxlink_speed;
    private int scenario;
    private int totalRxBytes;
    private int totalTxBytes;
    private int txBw;
    private float txDelayAvg;
    private float txDelayP10;
    private float txDelayP90;
    private long txDelayPkts;
    private int txMcs;
    private int txMode;
    private int txNss;
    private int txRealSpeed;
    private int txTputPred;
    private int txlink_speed;
    private String wifiGeneration;
    private int wifiStandard;

    public class a implements Parcelable.Creator<LinkLayerQuality> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LinkLayerQuality createFromParcel(Parcel r100) {
            LinkLayerQuality r101 = new LinkLayerQuality();
            LinkLayerQuality.a(r101, r100.readString());
            LinkLayerQuality.b(r101, r100.readInt());
            LinkLayerQuality.m(r101, r100.readInt());
            LinkLayerQuality.x(r101, r100.readInt());
            LinkLayerQuality.b(r101, r100.readString());
            LinkLayerQuality.c(r101, r100.readString());
            LinkLayerQuality.d(r101, r100.readString());
            LinkLayerQuality.F(r101, r100.readInt());
            LinkLayerQuality.G(r101, r100.readInt());
            LinkLayerQuality.H(r101, r100.readInt());
            LinkLayerQuality.a(r101, r100.readInt());
            LinkLayerQuality.c(r101, r100.readInt());
            LinkLayerQuality.d(r101, r100.readInt());
            LinkLayerQuality.e(r101, r100.readInt());
            LinkLayerQuality.f(r101, r100.readInt());
            LinkLayerQuality.g(r101, r100.readInt());
            LinkLayerQuality.h(r101, r100.readInt());
            LinkLayerQuality.i(r101, r100.readInt());
            LinkLayerQuality.j(r101, r100.readInt());
            LinkLayerQuality.k(r101, r100.readInt());
            LinkLayerQuality.l(r101, r100.readInt());
            LinkLayerQuality.n(r101, r100.readInt());
            LinkLayerQuality.o(r101, r100.readInt());
            LinkLayerQuality.p(r101, r100.readInt());
            LinkLayerQuality.q(r101, r100.readInt());
            LinkLayerQuality.r(r101, r100.readInt());
            LinkLayerQuality.s(r101, r100.readInt());
            LinkLayerQuality.t(r101, r100.readInt());
            LinkLayerQuality.u(r101, r100.readInt());
            LinkLayerQuality.v(r101, r100.readInt());
            LinkLayerQuality.w(r101, r100.readInt());
            LinkLayerQuality.y(r101, r100.readInt());
            LinkLayerQuality.z(r101, r100.readInt());
            int r102 = 0;
            if (r100.readByte() == 0) goto L5;
            boolean r103 = true;
        L6:
            LinkLayerQuality.a(r101, r103);
            r100.readTypedList(LinkLayerQuality.a(r101), LinkStatsParcel.CREATOR);
            LinkLayerQuality.A(r101, r100.readInt());
            LinkLayerQuality.B(r101, r100.readInt());
            LinkLayerQuality.C(r101, r100.readInt());
            LinkLayerQuality.D(r101, r100.readInt());
            LinkLayerQuality.E(r101, r100.readInt());
            LinkLayerQuality.a(r101, r100.readFloat());
            LinkLayerQuality.b(r101, r100.readFloat());
            LinkLayerQuality.c(r101, r100.readFloat());
            LinkLayerQuality.a(r101, r100.readLong());
            int r104 = r100.readInt();
            LinkLayerQuality.a(r101, new ArrayList(r104));
        L7:
            if (r102 >= r104) goto L9;
            LinkLayerQuality.b(r101).add(Integer.valueOf(r100.readInt()));
            r102 = r102 + 1;
            goto L7
        L9:
            return r101;
        L5:
            r103 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final LinkLayerQuality[] newArray(int r100) {
            return new LinkLayerQuality[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder(" LinkLayerQuality:  ifName: ");
        r100.append(this.ifName);
        r100.append(" freq: ");
        r100.append(this.freq);
        r100.append(" txlink_speed: ");
        r100.append(this.txlink_speed);
        r100.append(" rxlink_speed: ");
        r100.append(this.rxlink_speed);
        r100.append(" band: ");
        r100.append(this.band);
        r100.append(" band1: ");
        r100.append(this.band1);
        r100.append(" wifiGeneration: ");
        r100.append(this.wifiGeneration);
        r100.append(" deltaRxFcsErr: ");
        r100.append(this.deltaRxFcsErr);
        r100.append(" rxFcsErrLevel: ");
        r100.append(this.rxFcsErrLevel);
        r100.append(" totalTxBytes: ");
        r100.append(this.totalTxBytes);
        r100.append(" deltaTxBytes: ");
        r100.append(this.deltaTxBytes);
        r100.append(" txRealSpeed: ");
        r100.append(this.txRealSpeed);
        r100.append(" totalRxBytes: ");
        r100.append(this.totalRxBytes);
        r100.append(" deltaRxBytes: ");
        r100.append(this.deltaRxBytes);
        r100.append(" rxRealSpeed: ");
        r100.append(this.rxRealSpeed);
        r100.append(" txMode: ");
        r100.append(this.txMode);
        r100.append(" txMcs: ");
        r100.append(this.txMcs);
        r100.append(" txBw: ");
        r100.append(this.txBw);
        r100.append(" txNss: ");
        r100.append(this.txNss);
        r100.append(" rxMode: ");
        r100.append(this.rxMode);
        r100.append(" rxMcs: ");
        r100.append(this.rxMcs);
        r100.append(" rxBw: ");
        r100.append(this.rxBw);
        r100.append(" rxNss: ");
        r100.append(this.rxNss);
        r100.append(" delta_channel_on_time: ");
        r100.append(this.delta_channel_on_time);
        r100.append(" delta_channel_tx_time: ");
        r100.append(this.delta_channel_tx_time);
        r100.append(" delta_channel_rx_time: ");
        r100.append(this.delta_channel_rx_time);
        r100.append(" delta_channel_cca_busy_time: ");
        r100.append(this.delta_channel_cca_busy_time);
        r100.append(" ccaScore: ");
        r100.append(this.ccaScore);
        r100.append(" perScore: ");
        r100.append(this.perScore);
        r100.append(" rssiScore: ");
        r100.append(this.rssiScore);
        r100.append(" scenario: ");
        r100.append(this.scenario);
        r100.append(" currentChannelAPCount: ");
        r100.append(this.currentChannelAPCount);
        r100.append(" arpNeighbourCount: ");
        r100.append(this.arpNeighbourCount);
        r100.append(" is_mlo_iface: ");
        r100.append(this.is_mlo_iface);
        if (this.linkStats == null) goto L5;
        r100.append(" linkStats size: ");
        r100.append(this.linkStats.size());
    L6:
        r100.append(" rxTputPred: ");
        r100.append(this.rxTputPred);
        r100.append(" txTputPred: ");
        r100.append(this.txTputPred);
        r100.append(" wifiStandard: ");
        r100.append(this.wifiStandard);
        r100.append(" contentionAtimeBk: ");
        r100.append(this.contentionAtimeBk);
        r100.append(" contentionAtimeVi: ");
        r100.append(this.contentionAtimeVi);
        r100.append(" txDelayAvg: ");
        r100.append(this.txDelayAvg);
        r100.append(" txDelayP10: ");
        r100.append(this.txDelayP10);
        r100.append(" txDelayP90: ");
        r100.append(this.txDelayP90);
        r100.append(" txDelayPkts: ");
        r100.append(this.txDelayPkts);
        if (this.delaySizeMatrix == null) goto L9;
        r100.append(" delaySizeMatrix size: ");
        r100.append(this.delaySizeMatrix.size());
    L11:
        return r100.toString();
    L9:
        r100.append(" delaySizeMatrix is null");
        goto L11
    L5:
        r100.append(" linkStats is null");
        goto L6
    }

    public LinkLayerQuality() {
        this.linkStats = new ArrayList();
        this.delaySizeMatrix = new ArrayList();
    }

    public int getArpNeighbourCount() {
        return this.arpNeighbourCount;
    }

    public String getBand() {
        return this.band;
    }

    public String getBand1() {
        return this.band1;
    }

    public int getCcaScore() {
        return this.ccaScore;
    }

    public int getContentionAtimeBk() {
        return this.contentionAtimeBk;
    }

    public int getContentionAtimeVi() {
        return this.contentionAtimeVi;
    }

    public int getCurrentChannelAPCount() {
        return this.currentChannelAPCount;
    }

    public List<Integer> getDelaySizeMatrix() {
        return this.delaySizeMatrix;
    }

    public int getDeltaRxBytes() {
        return this.deltaRxBytes;
    }

    public int getDeltaRxFcsErr() {
        return this.deltaRxFcsErr;
    }

    public int getDeltaTxBytes() {
        return this.deltaTxBytes;
    }

    public int getDelta_channel_cca_busy_time() {
        return this.delta_channel_cca_busy_time;
    }

    public int getDelta_channel_on_time() {
        return this.delta_channel_on_time;
    }

    public int getDelta_channel_rx_time() {
        return this.delta_channel_rx_time;
    }

    public int getDelta_channel_tx_time() {
        return this.delta_channel_tx_time;
    }

    public int getFreq() {
        return this.freq;
    }

    public String getIfName() {
        return this.ifName;
    }

    public List<LinkStatsParcel> getLinkStats() {
        return this.linkStats;
    }

    public int getPerScore() {
        return this.perScore;
    }

    public int getRssiScore() {
        return this.rssiScore;
    }

    public int getRxBw() {
        return this.rxBw;
    }

    public int getRxFcsErrLevel() {
        return this.rxFcsErrLevel;
    }

    public int getRxMcs() {
        return this.rxMcs;
    }

    public int getRxMode() {
        return this.rxMode;
    }

    public int getRxNss() {
        return this.rxNss;
    }

    public int getRxRealSpeed() {
        return this.rxRealSpeed;
    }

    public int getRxTputPred() {
        return this.rxTputPred;
    }

    public int getRxlinkSpeed() {
        return this.rxlink_speed;
    }

    public int getScenario() {
        return this.scenario;
    }

    public int getTotalRxBytes() {
        return this.totalRxBytes;
    }

    public int getTotalTxBytes() {
        return this.totalTxBytes;
    }

    public int getTxBw() {
        return this.txBw;
    }

    public float getTxDelayAvg() {
        return this.txDelayAvg;
    }

    public float getTxDelayP10() {
        return this.txDelayP10;
    }

    public float getTxDelayP90() {
        return this.txDelayP90;
    }

    public long getTxDelayPkts() {
        return this.txDelayPkts;
    }

    public int getTxMcs() {
        return this.txMcs;
    }

    public int getTxMode() {
        return this.txMode;
    }

    public int getTxNss() {
        return this.txNss;
    }

    public int getTxRealSpeed() {
        return this.txRealSpeed;
    }

    public int getTxTputPred() {
        return this.txTputPred;
    }

    public int getTxlinkSpeed() {
        return this.txlink_speed;
    }

    public String getWifiGeneration() {
        return this.wifiGeneration;
    }

    public int getWifiStandard() {
        return this.wifiStandard;
    }

    public boolean isMloIface() {
        return this.is_mlo_iface;
    }

    public LinkLayerQuality(LinkLayerQuality r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        this.ifName = r100.ifName;
        this.freq = r100.freq;
        this.txlink_speed = r100.txlink_speed;
        this.rxlink_speed = r100.rxlink_speed;
        this.band = r100.band;
        this.band1 = r100.band1;
        this.wifiGeneration = r100.wifiGeneration;
        this.deltaRxFcsErr = r100.deltaRxFcsErr;
        this.rxFcsErrLevel = r100.rxFcsErrLevel;
        this.totalTxBytes = r100.totalTxBytes;
        this.deltaTxBytes = r100.deltaTxBytes;
        this.txRealSpeed = r100.txRealSpeed;
        this.totalRxBytes = r100.totalRxBytes;
        this.deltaRxBytes = r100.deltaRxBytes;
        this.rxRealSpeed = r100.rxRealSpeed;
        this.txMode = r100.txMode;
        this.txMcs = r100.txMcs;
        this.txBw = r100.txBw;
        this.txNss = r100.txNss;
        this.rxMode = r100.rxMode;
        this.rxMcs = r100.rxMcs;
        this.rxBw = r100.rxBw;
        this.rxNss = r100.rxNss;
        this.delta_channel_on_time = r100.delta_channel_on_time;
        this.delta_channel_tx_time = r100.delta_channel_tx_time;
        this.delta_channel_rx_time = r100.delta_channel_rx_time;
        this.delta_channel_cca_busy_time = r100.delta_channel_cca_busy_time;
        this.ccaScore = r100.ccaScore;
        this.perScore = r100.perScore;
        this.rssiScore = r100.rssiScore;
        this.scenario = r100.scenario;
        this.currentChannelAPCount = r100.currentChannelAPCount;
        this.arpNeighbourCount = r100.arpNeighbourCount;
        this.is_mlo_iface = r100.is_mlo_iface;
        if (r100.linkStats == null) goto L8;
        this.linkStats = new ArrayList(r100.linkStats);
    L9:
        this.rxTputPred = r100.rxTputPred;
        this.txTputPred = r100.txTputPred;
        this.wifiStandard = r100.wifiStandard;
        this.contentionAtimeBk = r100.contentionAtimeBk;
        this.contentionAtimeVi = r100.contentionAtimeVi;
        this.txDelayAvg = r100.txDelayAvg;
        this.txDelayP10 = r100.txDelayP10;
        this.txDelayP90 = r100.txDelayP90;
        this.txDelayPkts = r100.txDelayPkts;
        if (r100.delaySizeMatrix == null) goto L12;
        this.delaySizeMatrix = new ArrayList(r100.delaySizeMatrix);
        return;
    L12:
        this.delaySizeMatrix = new ArrayList();
        return;
    L8:
        this.linkStats = new ArrayList();
        goto L9
    }

    public static /* synthetic */ List a(LinkLayerQuality r100) {
        return r100.linkStats;
    }

    public static /* synthetic */ List b(LinkLayerQuality r100) {
        return r100.delaySizeMatrix;
    }

    public void setArpNeighbourCount(int r100) {
        this.arpNeighbourCount = r100;
    }

    public void setBand(String r100) {
        this.band = r100;
    }

    public void setBand1(String r100) {
        this.band1 = r100;
    }

    public void setCcaScore(int r100) {
        this.ccaScore = r100;
    }

    public void setContentionAtimeBk(int r100) {
        this.contentionAtimeBk = r100;
    }

    public void setContentionAtimeVi(int r100) {
        this.contentionAtimeVi = r100;
    }

    public void setCurrentChannelAPCount(int r100) {
        this.currentChannelAPCount = r100;
    }

    public void setDelaySizeMatrix(List<Integer> r100) {
        this.delaySizeMatrix = r100;
    }

    public void setDeltaRxBytes(int r100) {
        this.deltaRxBytes = r100;
    }

    public void setDeltaRxFcsErr(int r100) {
        this.deltaRxFcsErr = r100;
    }

    public void setDeltaTxBytes(int r100) {
        this.deltaTxBytes = r100;
    }

    public void setDelta_channel_cca_busy_time(int r100) {
        this.delta_channel_cca_busy_time = r100;
    }

    public void setDelta_channel_on_time(int r100) {
        this.delta_channel_on_time = r100;
    }

    public void setDelta_channel_rx_time(int r100) {
        this.delta_channel_rx_time = r100;
    }

    public void setDelta_channel_tx_time(int r100) {
        this.delta_channel_tx_time = r100;
    }

    public void setFreq(int r100) {
        this.freq = r100;
    }

    public void setIfName(String r100) {
        this.ifName = r100;
    }

    public void setLinkStats(List<LinkStatsParcel> r100) {
        this.linkStats = r100;
    }

    public void setMloIface(boolean r100) {
        this.is_mlo_iface = r100;
    }

    public void setPerScore(int r100) {
        this.perScore = r100;
    }

    public void setRssiScore(int r100) {
        this.rssiScore = r100;
    }

    public void setRxBw(int r100) {
        this.rxBw = r100;
    }

    public void setRxFcsErrLevel(int r100) {
        this.rxFcsErrLevel = r100;
    }

    public void setRxMcs(int r100) {
        this.rxMcs = r100;
    }

    public void setRxMode(int r100) {
        this.rxMode = r100;
    }

    public void setRxNss(int r100) {
        this.rxNss = r100;
    }

    public void setRxRealSpeed(int r100) {
        this.rxRealSpeed = r100;
    }

    public void setRxTputPred(int r100) {
        this.rxTputPred = r100;
    }

    public void setRxlinkSpeed(int r100) {
        this.rxlink_speed = r100;
    }

    public void setScenario(int r100) {
        this.scenario = r100;
    }

    public void setTotalRxBytes(int r100) {
        this.totalRxBytes = r100;
    }

    public void setTotalTxBytes(int r100) {
        this.totalTxBytes = r100;
    }

    public void setTxBw(int r100) {
        this.txBw = r100;
    }

    public void setTxDelayAvg(float r100) {
        this.txDelayAvg = r100;
    }

    public void setTxDelayP10(float r100) {
        this.txDelayP10 = r100;
    }

    public void setTxDelayP90(float r100) {
        this.txDelayP90 = r100;
    }

    public void setTxDelayPkts(long r100) {
        this.txDelayPkts = r100;
    }

    public void setTxMcs(int r100) {
        this.txMcs = r100;
    }

    public void setTxMode(int r100) {
        this.txMode = r100;
    }

    public void setTxNss(int r100) {
        this.txNss = r100;
    }

    public void setTxRealSpeed(int r100) {
        this.txRealSpeed = r100;
    }

    public void setTxTputPred(int r100) {
        this.txTputPred = r100;
    }

    public void setTxlinkSpeed(int r100) {
        this.txlink_speed = r100;
    }

    public void setWifiGeneration(String r100) {
        this.wifiGeneration = r100;
    }

    public void setWifiStandard(int r100) {
        this.wifiStandard = r100;
    }

    public static /* synthetic */ void A(LinkLayerQuality r100, int r101) {
        r100.rxTputPred = r101;
    }

    public static /* synthetic */ void B(LinkLayerQuality r100, int r101) {
        r100.txTputPred = r101;
    }

    public static /* synthetic */ void C(LinkLayerQuality r100, int r101) {
        r100.wifiStandard = r101;
    }

    public static /* synthetic */ void D(LinkLayerQuality r100, int r101) {
        r100.contentionAtimeBk = r101;
    }

    public static /* synthetic */ void E(LinkLayerQuality r100, int r101) {
        r100.contentionAtimeVi = r101;
    }

    public static /* synthetic */ void F(LinkLayerQuality r100, int r101) {
        r100.deltaRxFcsErr = r101;
    }

    public static /* synthetic */ void G(LinkLayerQuality r100, int r101) {
        r100.rxFcsErrLevel = r101;
    }

    public static /* synthetic */ void H(LinkLayerQuality r100, int r101) {
        r100.totalTxBytes = r101;
    }

    public static /* synthetic */ void a(LinkLayerQuality r100, float r101) {
        r100.txDelayAvg = r101;
    }

    public static /* synthetic */ void b(LinkLayerQuality r100, float r101) {
        r100.txDelayP10 = r101;
    }

    public static /* synthetic */ void c(LinkLayerQuality r100, float r101) {
        r100.txDelayP90 = r101;
    }

    public static /* synthetic */ void d(LinkLayerQuality r100, int r101) {
        r100.totalRxBytes = r101;
    }

    public static /* synthetic */ void e(LinkLayerQuality r100, int r101) {
        r100.deltaRxBytes = r101;
    }

    public static /* synthetic */ void f(LinkLayerQuality r100, int r101) {
        r100.rxRealSpeed = r101;
    }

    public static /* synthetic */ void g(LinkLayerQuality r100, int r101) {
        r100.txMode = r101;
    }

    public static /* synthetic */ void h(LinkLayerQuality r100, int r101) {
        r100.txMcs = r101;
    }

    public static /* synthetic */ void i(LinkLayerQuality r100, int r101) {
        r100.txBw = r101;
    }

    public static /* synthetic */ void j(LinkLayerQuality r100, int r101) {
        r100.txNss = r101;
    }

    public static /* synthetic */ void k(LinkLayerQuality r100, int r101) {
        r100.rxMode = r101;
    }

    public static /* synthetic */ void l(LinkLayerQuality r100, int r101) {
        r100.rxMcs = r101;
    }

    public static /* synthetic */ void m(LinkLayerQuality r100, int r101) {
        r100.txlink_speed = r101;
    }

    public static /* synthetic */ void n(LinkLayerQuality r100, int r101) {
        r100.rxBw = r101;
    }

    public static /* synthetic */ void o(LinkLayerQuality r100, int r101) {
        r100.rxNss = r101;
    }

    public static /* synthetic */ void p(LinkLayerQuality r100, int r101) {
        r100.delta_channel_on_time = r101;
    }

    public static /* synthetic */ void q(LinkLayerQuality r100, int r101) {
        r100.delta_channel_tx_time = r101;
    }

    public static /* synthetic */ void r(LinkLayerQuality r100, int r101) {
        r100.delta_channel_rx_time = r101;
    }

    public static /* synthetic */ void s(LinkLayerQuality r100, int r101) {
        r100.delta_channel_cca_busy_time = r101;
    }

    public static /* synthetic */ void t(LinkLayerQuality r100, int r101) {
        r100.ccaScore = r101;
    }

    public static /* synthetic */ void u(LinkLayerQuality r100, int r101) {
        r100.perScore = r101;
    }

    public static /* synthetic */ void v(LinkLayerQuality r100, int r101) {
        r100.rssiScore = r101;
    }

    public static /* synthetic */ void w(LinkLayerQuality r100, int r101) {
        r100.scenario = r101;
    }

    public static /* synthetic */ void x(LinkLayerQuality r100, int r101) {
        r100.rxlink_speed = r101;
    }

    public static /* synthetic */ void y(LinkLayerQuality r100, int r101) {
        r100.currentChannelAPCount = r101;
    }

    public static /* synthetic */ void z(LinkLayerQuality r100, int r101) {
        r100.arpNeighbourCount = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.ifName);
        r100.writeInt(this.freq);
        r100.writeInt(this.txlink_speed);
        r100.writeInt(this.rxlink_speed);
        r100.writeString(this.band);
        r100.writeString(this.band1);
        r100.writeString(this.wifiGeneration);
        r100.writeInt(this.deltaRxFcsErr);
        r100.writeInt(this.rxFcsErrLevel);
        r100.writeInt(this.totalTxBytes);
        r100.writeInt(this.deltaTxBytes);
        r100.writeInt(this.txRealSpeed);
        r100.writeInt(this.totalRxBytes);
        r100.writeInt(this.deltaRxBytes);
        r100.writeInt(this.rxRealSpeed);
        r100.writeInt(this.txMode);
        r100.writeInt(this.txMcs);
        r100.writeInt(this.txBw);
        r100.writeInt(this.txNss);
        r100.writeInt(this.rxMode);
        r100.writeInt(this.rxMcs);
        r100.writeInt(this.rxBw);
        r100.writeInt(this.rxNss);
        r100.writeInt(this.delta_channel_on_time);
        r100.writeInt(this.delta_channel_tx_time);
        r100.writeInt(this.delta_channel_rx_time);
        r100.writeInt(this.delta_channel_cca_busy_time);
        r100.writeInt(this.ccaScore);
        r100.writeInt(this.perScore);
        r100.writeInt(this.rssiScore);
        r100.writeInt(this.scenario);
        r100.writeInt(this.currentChannelAPCount);
        r100.writeInt(this.arpNeighbourCount);
        r100.writeByte(this.is_mlo_iface ? 1 : 0);
        r100.writeTypedList(this.linkStats);
        r100.writeInt(this.rxTputPred);
        r100.writeInt(this.txTputPred);
        r100.writeInt(this.wifiStandard);
        r100.writeInt(this.contentionAtimeBk);
        r100.writeInt(this.contentionAtimeVi);
        r100.writeFloat(this.txDelayAvg);
        r100.writeFloat(this.txDelayP10);
        r100.writeFloat(this.txDelayP90);
        r100.writeLong(this.txDelayPkts);
        List<Integer> r102 = this.delaySizeMatrix;
        if (r102 == null) goto L12;
        r100.writeInt(r102.size());
        Iterator<Integer> r103 = this.delaySizeMatrix.iterator();
    L6:
        if (r103.hasNext() == false) goto L17;
        Integer r104 = r103.next();
        if (r104 == null) goto L10;
        int r105 = r104.intValue();
    L11:
        r100.writeInt(r105);
        goto L6
    L10:
        r105 = 0;
        goto L11
    L17:
        return;
    L12:
        r100.writeInt(0);
    }

    public static /* synthetic */ void a(LinkLayerQuality r100, int r101) {
        r100.deltaTxBytes = r101;
    }

    public static /* synthetic */ void b(LinkLayerQuality r100, int r101) {
        r100.freq = r101;
    }

    public static /* synthetic */ void c(LinkLayerQuality r100, int r101) {
        r100.txRealSpeed = r101;
    }

    public static /* synthetic */ void d(LinkLayerQuality r100, String r101) {
        r100.wifiGeneration = r101;
    }

    public static /* synthetic */ void a(LinkLayerQuality r100, long r101) {
        r100.txDelayPkts = r101;
    }

    public static /* synthetic */ void b(LinkLayerQuality r100, String r101) {
        r100.band = r101;
    }

    public static /* synthetic */ void c(LinkLayerQuality r100, String r101) {
        r100.band1 = r101;
    }

    public static /* synthetic */ void a(LinkLayerQuality r100, String r101) {
        r100.ifName = r101;
    }

    public static /* synthetic */ void a(LinkLayerQuality r100, ArrayList r101) {
        r100.delaySizeMatrix = r101;
    }

    public static /* synthetic */ void a(LinkLayerQuality r100, boolean r101) {
        r100.is_mlo_iface = r101;
    }
}
