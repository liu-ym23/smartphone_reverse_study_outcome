package com.obric.cae.libs.statusreport;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes33.dex */
public class LinkStatsParcel implements Parcelable {
    public static final Parcelable.Creator<LinkStatsParcel> CREATOR = null;
    private int ccaLevel;
    private int center_freq;
    private int contention_atime_be;
    private int contention_atime_bk;
    private int contention_atime_vi;
    private int contention_atime_vo;
    private int deltaCcaBusyTime;
    private int deltaRadioOnTime;
    private int deltaRxSuccess;
    private long deltaTxBad;
    private long deltaTxRetries;
    private long deltaTxSuccess;
    private int link_id;
    private int on_time_scan;
    private int per;
    private float power_pred_mw;
    private int radio_id;
    private int rl_cca_busy_rate;
    private int rl_rx_link_speed;
    private int rl_tx_link_speed;
    private int rssi_ack;
    private int rssi_data;
    private int rssi_mgmt;
    private int rx_speed_kbps;
    private int txBadLevel;
    private long txMpduBe;
    private long txMpduVi;
    private long txMpduVo;
    private int txRetranLevel;
    private int txRetranLevelBe;
    private int txRetranLevelVi;
    private int txRetranLevelVo;
    private long txRetriesBe;
    private long txRetriesVi;
    private long txRetriesVo;
    private int tx_speed_kbps;
    private int width;

    public class a implements Parcelable.Creator<LinkStatsParcel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LinkStatsParcel createFromParcel(Parcel r100) {
            return new LinkStatsParcel(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final LinkStatsParcel[] newArray(int r100) {
            return new LinkStatsParcel[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public LinkStatsParcel() {
    }

    public int getCcaLevel() {
        return this.ccaLevel;
    }

    public int getCenter_freq() {
        return this.center_freq;
    }

    public int getContention_atime_be() {
        return this.contention_atime_be;
    }

    public int getContention_atime_bk() {
        return this.contention_atime_bk;
    }

    public int getContention_atime_vi() {
        return this.contention_atime_vi;
    }

    public int getContention_atime_vo() {
        return this.contention_atime_vo;
    }

    public int getDeltaCcaBusyTime() {
        return this.deltaCcaBusyTime;
    }

    public int getDeltaRadioOnTime() {
        return this.deltaRadioOnTime;
    }

    public int getDeltaRxSuccess() {
        return this.deltaRxSuccess;
    }

    public long getDeltaTxBad() {
        return this.deltaTxBad;
    }

    public long getDeltaTxRetries() {
        return this.deltaTxRetries;
    }

    public long getDeltaTxSuccess() {
        return this.deltaTxSuccess;
    }

    public int getLink_id() {
        return this.link_id;
    }

    public int getOn_time_scan() {
        return this.on_time_scan;
    }

    public int getPer() {
        return this.per;
    }

    public float getPower_pred_mw() {
        return this.power_pred_mw;
    }

    public int getRadio_id() {
        return this.radio_id;
    }

    public int getRl_cca_busy_rate() {
        return this.rl_cca_busy_rate;
    }

    public int getRl_rx_link_speed() {
        return this.rl_rx_link_speed;
    }

    public int getRl_tx_link_speed() {
        return this.rl_tx_link_speed;
    }

    public int getRssi_ack() {
        return this.rssi_ack;
    }

    public int getRssi_data() {
        return this.rssi_data;
    }

    public int getRssi_mgmt() {
        return this.rssi_mgmt;
    }

    public int getRx_speed_kbps() {
        return this.rx_speed_kbps;
    }

    public int getTxBadLevel() {
        return this.txBadLevel;
    }

    public long getTxMpduBe() {
        return this.txMpduBe;
    }

    public long getTxMpduVi() {
        return this.txMpduVi;
    }

    public long getTxMpduVo() {
        return this.txMpduVo;
    }

    public int getTxRetranLevel() {
        return this.txRetranLevel;
    }

    public int getTxRetranLevelBe() {
        return this.txRetranLevelBe;
    }

    public int getTxRetranLevelVi() {
        return this.txRetranLevelVi;
    }

    public int getTxRetranLevelVo() {
        return this.txRetranLevelVo;
    }

    public long getTxRetriesBe() {
        return this.txRetriesBe;
    }

    public long getTxRetriesVi() {
        return this.txRetriesVi;
    }

    public long getTxRetriesVo() {
        return this.txRetriesVo;
    }

    public int getTx_speed_kbps() {
        return this.tx_speed_kbps;
    }

    public int getWidth() {
        return this.width;
    }

    public LinkStatsParcel(Parcel r100) {
        this.link_id = r100.readInt();
        this.radio_id = r100.readInt();
        this.center_freq = r100.readInt();
        this.deltaCcaBusyTime = r100.readInt();
        this.deltaRadioOnTime = r100.readInt();
        this.ccaLevel = r100.readInt();
        this.deltaTxSuccess = r100.readLong();
        this.deltaTxRetries = r100.readLong();
        this.txRetranLevel = r100.readInt();
        this.deltaTxBad = r100.readLong();
        this.txBadLevel = r100.readInt();
        this.deltaRxSuccess = r100.readInt();
        this.contention_atime_be = r100.readInt();
        this.contention_atime_bk = r100.readInt();
        this.contention_atime_vi = r100.readInt();
        this.contention_atime_vo = r100.readInt();
        this.txMpduBe = r100.readLong();
        this.txRetriesBe = r100.readLong();
        this.txRetranLevelBe = r100.readInt();
        this.txMpduVi = r100.readLong();
        this.txRetriesVi = r100.readLong();
        this.txRetranLevelVi = r100.readInt();
        this.txMpduVo = r100.readLong();
        this.txRetriesVo = r100.readLong();
        this.txRetranLevelVo = r100.readInt();
        this.width = r100.readInt();
        this.rssi_mgmt = r100.readInt();
        this.rssi_data = r100.readInt();
        this.rssi_ack = r100.readInt();
        this.rl_tx_link_speed = r100.readInt();
        this.rl_rx_link_speed = r100.readInt();
        this.rl_cca_busy_rate = r100.readInt();
        this.per = r100.readInt();
        this.on_time_scan = r100.readInt();
        this.tx_speed_kbps = r100.readInt();
        this.rx_speed_kbps = r100.readInt();
        this.power_pred_mw = r100.readFloat();
    }

    public void setCcaLevel(int r100) {
        this.ccaLevel = r100;
    }

    public void setCenter_freq(int r100) {
        this.center_freq = r100;
    }

    public void setContention_atime_be(int r100) {
        this.contention_atime_be = r100;
    }

    public void setContention_atime_bk(int r100) {
        this.contention_atime_bk = r100;
    }

    public void setContention_atime_vi(int r100) {
        this.contention_atime_vi = r100;
    }

    public void setContention_atime_vo(int r100) {
        this.contention_atime_vo = r100;
    }

    public void setDeltaCcaBusyTime(int r100) {
        this.deltaCcaBusyTime = r100;
    }

    public void setDeltaRadioOnTime(int r100) {
        this.deltaRadioOnTime = r100;
    }

    public void setDeltaRxSuccess(int r100) {
        this.deltaRxSuccess = r100;
    }

    public void setDeltaTxBad(long r100) {
        this.deltaTxBad = r100;
    }

    public void setDeltaTxRetries(long r100) {
        this.deltaTxRetries = r100;
    }

    public void setDeltaTxSuccess(long r100) {
        this.deltaTxSuccess = r100;
    }

    public void setLink_id(int r100) {
        this.link_id = r100;
    }

    public void setOn_time_scan(int r100) {
        this.on_time_scan = r100;
    }

    public void setPer(int r100) {
        this.per = r100;
    }

    public void setPower_pred_mw(float r100) {
        this.power_pred_mw = r100;
    }

    public void setRadio_id(int r100) {
        this.radio_id = r100;
    }

    public void setRl_cca_busy_rate(int r100) {
        this.rl_cca_busy_rate = r100;
    }

    public void setRl_rx_link_speed(int r100) {
        this.rl_rx_link_speed = r100;
    }

    public void setRl_tx_link_speed(int r100) {
        this.rl_tx_link_speed = r100;
    }

    public void setRssi_ack(int r100) {
        this.rssi_ack = r100;
    }

    public void setRssi_data(int r100) {
        this.rssi_data = r100;
    }

    public void setRssi_mgmt(int r100) {
        this.rssi_mgmt = r100;
    }

    public void setRx_speed_kbps(int r100) {
        this.rx_speed_kbps = r100;
    }

    public void setTxBadLevel(int r100) {
        this.txBadLevel = r100;
    }

    public void setTxMpduBe(long r100) {
        this.txMpduBe = r100;
    }

    public void setTxMpduVi(long r100) {
        this.txMpduVi = r100;
    }

    public void setTxMpduVo(long r100) {
        this.txMpduVo = r100;
    }

    public void setTxRetranLevel(int r100) {
        this.txRetranLevel = r100;
    }

    public void setTxRetranLevelBe(int r100) {
        this.txRetranLevelBe = r100;
    }

    public void setTxRetranLevelVi(int r100) {
        this.txRetranLevelVi = r100;
    }

    public void setTxRetranLevelVo(int r100) {
        this.txRetranLevelVo = r100;
    }

    public void setTxRetriesBe(long r100) {
        this.txRetriesBe = r100;
    }

    public void setTxRetriesVi(long r100) {
        this.txRetriesVi = r100;
    }

    public void setTxRetriesVo(long r100) {
        this.txRetriesVo = r100;
    }

    public void setTx_speed_kbps(int r100) {
        this.tx_speed_kbps = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.link_id);
        r100.writeInt(this.radio_id);
        r100.writeInt(this.center_freq);
        r100.writeInt(this.deltaCcaBusyTime);
        r100.writeInt(this.deltaRadioOnTime);
        r100.writeInt(this.ccaLevel);
        r100.writeLong(this.deltaTxSuccess);
        r100.writeLong(this.deltaTxRetries);
        r100.writeInt(this.txRetranLevel);
        r100.writeLong(this.deltaTxBad);
        r100.writeInt(this.txBadLevel);
        r100.writeInt(this.deltaRxSuccess);
        r100.writeInt(this.contention_atime_be);
        r100.writeInt(this.contention_atime_bk);
        r100.writeInt(this.contention_atime_vi);
        r100.writeInt(this.contention_atime_vo);
        r100.writeLong(this.txMpduBe);
        r100.writeLong(this.txRetriesBe);
        r100.writeInt(this.txRetranLevelBe);
        r100.writeLong(this.txMpduVi);
        r100.writeLong(this.txRetriesVi);
        r100.writeInt(this.txRetranLevelVi);
        r100.writeLong(this.txMpduVo);
        r100.writeLong(this.txRetriesVo);
        r100.writeInt(this.txRetranLevelVo);
        r100.writeInt(this.width);
        r100.writeInt(this.rssi_mgmt);
        r100.writeInt(this.rssi_data);
        r100.writeInt(this.rssi_ack);
        r100.writeInt(this.rl_tx_link_speed);
        r100.writeInt(this.rl_rx_link_speed);
        r100.writeInt(this.rl_cca_busy_rate);
        r100.writeInt(this.per);
        r100.writeInt(this.on_time_scan);
        r100.writeInt(this.tx_speed_kbps);
        r100.writeInt(this.rx_speed_kbps);
        r100.writeFloat(this.power_pred_mw);
    }
}
