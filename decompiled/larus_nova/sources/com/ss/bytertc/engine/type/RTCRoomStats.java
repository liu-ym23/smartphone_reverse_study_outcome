package com.ss.bytertc.engine.type;

import androidx.camera.video.AudioStats;
import com.ss.bytertc.engine.InternalRTCStats;

/* JADX INFO: loaded from: classes40.dex */
public class RTCRoomStats {
    public double cpuAppUsage;
    public double cpuTotalUsage;
    public int rtt;
    public int rxAudioKBitRate;
    public long rxBytes;
    public int rxCellularKBitrate;
    public int rxJitter;
    public int rxKBitRate;
    public double rxLostrate;
    public int rxScreenKBitRate;
    public int rxVideoKBitRate;
    public int totalDuration;
    public int txAudioKBitRate;
    public long txBytes;
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
        this.txJitter = 0;
        this.rxJitter = 0;
        this.txLostrate = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.rxLostrate = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.rtt = 0;
        this.txCellularKBitrate = 0;
        this.rxCellularKBitrate = 0;
    }

    public String toString() {
        return "RtcStats{totalDuration=" + this.totalDuration + ", txBytes=" + this.txBytes + ", rxBytes=" + this.rxBytes + ", txKBitRate=" + this.txKBitRate + ", rxKBitRate=" + this.rxKBitRate + ", txAudioKBitRate=" + this.txAudioKBitRate + ", rxAudioKBitRate=" + this.rxAudioKBitRate + ", txVideoKBitRate=" + this.txVideoKBitRate + ", rxVideoKBitRate=" + this.rxVideoKBitRate + ", txScreenKBitRate=" + this.txScreenKBitRate + ", rxScreenKBitRate=" + this.rxScreenKBitRate + ", users=" + this.users + ", cpuTotalUsage=" + this.cpuTotalUsage + ", cpuAppUsage=" + this.cpuAppUsage + ", txLostrate=" + this.txLostrate + ", rxLostrate=" + this.rxLostrate + ", rtt=" + this.rtt + ", txJitter=" + this.txJitter + ", rxJitter=" + this.rxJitter + ", txCellularKBitRate=" + this.txCellularKBitrate + ", rxCellularKBitRate=" + this.rxCellularKBitrate + '}';
    }

    public RTCRoomStats() {
    }

    public RTCRoomStats(InternalRTCStats r100) {
        this.totalDuration = r100.totalDuration;
        this.txBytes = r100.txBytes;
        this.rxBytes = r100.rxBytes;
        this.txKBitRate = r100.txKBitRate;
        this.rxKBitRate = r100.rxKBitRate;
        this.txAudioKBitRate = r100.txAudioKBitRate;
        this.rxAudioKBitRate = r100.rxAudioKBitRate;
        this.txVideoKBitRate = r100.txVideoKBitRate;
        this.rxVideoKBitRate = r100.rxVideoKBitRate;
        this.txScreenKBitRate = r100.txScreenKBitRate;
        this.rxScreenKBitRate = r100.rxScreenKBitRate;
        this.users = r100.users;
        this.cpuTotalUsage = r100.cpuTotalUsage;
        this.cpuAppUsage = r100.cpuAppUsage;
        this.txLostrate = r100.txLostrate;
        this.rxLostrate = r100.rxLostrate;
        this.rtt = r100.rtt;
        this.txJitter = r100.txJitter;
        this.rxJitter = r100.rxJitter;
        this.txCellularKBitrate = r100.txCellularKBitrate;
        this.rxCellularKBitrate = r100.rxCellularKBitrate;
    }
}
