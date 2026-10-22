package com.ss.bytertc.engine;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes40.dex */
public class InternalRTCStats {
    public double cpuAppUsage;
    public double cpuTotalUsage;
    public int rtt;
    public int rxAudioKBitRate;
    public int rxBytes;
    public int rxCellularKBitrate;
    public int rxJitter;
    public int rxKBitRate;
    public double rxLostrate;
    public int rxScreenKBitRate;
    public int rxVideoKBitRate;
    public int totalDuration;
    public int txAudioKBitRate;
    public int txBytes;
    public int txCellularKBitrate;
    public int txJitter;
    public int txKBitRate;
    public double txLostrate;
    public int txScreenKBitRate;
    public int txVideoKBitRate;
    public int users;

    public void reset() {
        this.totalDuration = 0;
        this.txBytes = 0;
        this.rxBytes = 0;
        this.txKBitRate = 0;
        this.rxKBitRate = 0;
        this.txAudioKBitRate = 0;
        this.rxAudioKBitRate = 0;
        this.txVideoKBitRate = 0;
        this.rxVideoKBitRate = 0;
        this.txScreenKBitRate = 0;
        this.rxScreenKBitRate = 0;
        this.users = 0;
        this.cpuTotalUsage = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.cpuAppUsage = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.rxLostrate = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.txLostrate = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.rtt = 0;
        this.txJitter = 0;
        this.rxJitter = 0;
        this.txCellularKBitrate = 0;
        this.rxCellularKBitrate = 0;
    }

    public String toString() {
        return "RtcStats{totalDuration=" + this.totalDuration + ", txBytes=" + this.txBytes + ", rxBytes=" + this.rxBytes + ", txKBitRate=" + this.txKBitRate + ", rxKBitRate=" + this.rxKBitRate + ", txAudioKBitRate=" + this.txAudioKBitRate + ", rxAudioKBitRate=" + this.rxAudioKBitRate + ", txVideoKBitRate=" + this.txVideoKBitRate + ", rxVideoKBitRate=" + this.rxVideoKBitRate + ", txScreenKBitRate=" + this.txScreenKBitRate + ", rxScreenKBitRate=" + this.rxScreenKBitRate + ", users=" + this.users + ", cpuTotalUsage=" + this.cpuTotalUsage + ", cpuAppUsage=" + this.cpuAppUsage + ", txLostrate=" + this.txLostrate + ", rxLostrate=" + this.rxLostrate + ", rtt=" + this.rtt + ", txJitter=" + this.txJitter + ", rxJitter=" + this.rxJitter + ", txCellularKBitrate=" + this.txCellularKBitrate + ", rxCellularKBitrate=" + this.rxCellularKBitrate + '}';
    }

    public InternalRTCStats() {
    }

    public InternalRTCStats(int r100, int r101, int r102, int r103, int r104, int r105, int r110, int r111, int r112, int r113, int r114, int r115, double r116, double r117, double r210, double r211, int r212, int r213, int r214, int r215, int r216) {
        this.totalDuration = r100;
        this.txBytes = r101;
        this.rxBytes = r102;
        this.txKBitRate = r103;
        this.rxKBitRate = r104;
        this.txAudioKBitRate = r105;
        this.rxAudioKBitRate = r110;
        this.txVideoKBitRate = r111;
        this.rxVideoKBitRate = r112;
        this.txScreenKBitRate = r113;
        this.rxScreenKBitRate = r114;
        this.users = r115;
        this.cpuTotalUsage = r116;
        this.cpuAppUsage = r117;
        this.rxLostrate = r211;
        this.txLostrate = r210;
        this.rtt = r212;
        this.txJitter = r213;
        this.rxJitter = r214;
        this.txCellularKBitrate = r215;
        this.rxCellularKBitrate = r216;
    }

    private static InternalRTCStats create(int r210, int r211, int r212, int r310, int r311, int r312, int r313, int r314, int r315, int r316, int r317, int r318, double r319, double r410, double r411, double r412, int r413, int r414, int r415, int r510, int r511) {
        return new InternalRTCStats(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r510, r511);
    }
}
