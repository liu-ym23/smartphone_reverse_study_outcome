package com.ss.videoarch.strategy.strategy.networkStrategy;

import android.text.TextUtils;
import com.ss.videoarch.strategy.NativeObject;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.utils.JNINamespace;
import com.ss.videoarch.strategy.utils.VeLSUtils;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes38.dex */
@JNINamespace("jni")
public class NetworkProber extends NativeObject {
    public static final int PROBE_IPV6 = 0;
    static final String TAG = "NetworkProber";
    public static final int UDP_Compatibility_PROBE = 1;
    private static volatile NetworkProber sInstance;
    public final int NTP_SERVICE;
    private final String PROBE_QUIC;
    private final String PROBE_UDP;
    private final String TCP_PROTOCOL;
    private final String UDP_PROTOCOL;
    private boolean mSupportQuicConnect;
    private boolean mSupportUdpConnect;

    public static class UDPProbeInfo {
        public String domain;
        public int number;
        public int port;
        public int rtt;
        public int succ;

        public UDPProbeInfo() {
            this.domain = "";
            this.port = 8000;
            this.number = 0;
            this.rtt = 50;
            this.succ = 90;
        }
    }

    private native void nativeDestoryProbe();

    private native String nativeGetUdpProbeInfo(String r100, int r101);

    private native int nativeNetworkReachableProbe(String r100, String r101, int r102);

    private native void nativeSetProbePackageSize(int r100);

    private native void nativeSetProbeResultVaildTime(int r100);

    private native void nativeUpdateProbeParamsFromSettings(String r100);

    public static NetworkProber inst() {
        if (sInstance != null) goto L15;
        monitor-enter(NetworkProber.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new NetworkProber();     // Catch: Throwable -> L11
    L9:
        monitor-exit(NetworkProber.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void initUdpProbe() {
        int r100 = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableRtmProbe;
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableRtmProbe != (-1)) goto L6;
        return;
    L6:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableRtmProbe != 0) goto L9;
        inst().destoryProbe();
        return;
    L9:
        inst().setProbePackageSize(LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mUDPProbePackageSize);
        inst().setProbeResultVaildTime(LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mUDPProbeResultVaildTime);
        inst().updateProbeParamsFromSettings(getUDPProbeInfos());
    }

    public NetworkProber() {
        this.mSupportUdpConnect = false;
        this.mSupportQuicConnect = false;
        this.PROBE_UDP = "probe_udp";
        this.PROBE_QUIC = "probe_quic";
        this.UDP_PROTOCOL = "udp";
        this.TCP_PROTOCOL = "tcp";
        this.NTP_SERVICE = 2;
    }

    public void destoryProbe() {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L5;
        return;
    L5:
        nativeDestoryProbe();
    }

    public String getUDPProbeInfos() {
        JSONArray r100 = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mUDPProbeInfos;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.toString();
    }

    public void setProbePackageSize(int r100) {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L5;
        return;
    L5:
        nativeSetProbePackageSize(r100);
    }

    public void setProbeResultVaildTime(int r100) {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L5;
        return;
    L5:
        nativeSetProbeResultVaildTime(r100);
    }

    public void updateProbeParamsFromSettings(String r100) {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L5;
        return;
    L5:
        nativeUpdateProbeParamsFromSettings(r100);
    }

    public JSONArray getUdpProbeResultInfo(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        if (VeLSUtils.isLoadSoSuccess() == true) goto L8;
        return null;
    L8:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableRtmProbe == 1) goto L16;
        return null;
    L16:
        return new JSONArray(nativeGetUdpProbeInfo(r100, r101));
    L13:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public long networkActionByCommand(int r100, String r101, int r102, String r103) {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L5;
        return -1;
    L5:
        if (r100 == 0) goto L8;
        return -1;
    L8:
        return nativeNetworkReachableProbe(r101, "tcp", r102);
    }
}
