package com.ss.cast.discovery.ssdp;

import android.text.TextUtils;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Logger;
import com.byted.cast.common.utils.DLNAOptionUtils;
import com.byted.cast.linkcommon.cybergarage.cast.CastSSDPPacket;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.net.HostInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.device.NTS;
import com.byted.cast.linkcommon.cybergarage.upnp.device.SearchListener;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDP;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDPPacket;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes40.dex */
public class CastDevice implements SearchListener {
    private static final String PROTOCOL_VERSION = "1";
    private static final String TAG = null;
    ArrayList<String> hostAddresses;
    private a mAdvertiser;
    private ContextManager.CastContext mCastContext;
    private String mDeviceId;
    private String mIp;
    private int mLeaseTime;
    private String mMyName;
    private int mPort;
    private String mProtocol;
    private String mServiceType;
    private String mSinkVersion;
    private CastSSDPSearchSocketList mSsdpSearchSockList;

    public CastDevice() {
        this(null);
    }

    @Override // com.byted.cast.linkcommon.cybergarage.upnp.device.SearchListener
    public final /* synthetic */ void deviceSearchReceived(SSDPPacket r100) {
        SearchListener.CC.$default$deviceSearchReceived(this, r100);
    }

    public boolean start() {
        stop(true);
        this.hostAddresses = HostInterface.getHostAddresses();
        CastSSDPSearchSocketList r100 = new CastSSDPSearchSocketList(this.mCastContext, null, 1900, SSDP.BDLINK_ADDRESS, SSDP.getIPv6Address());
        this.mSsdpSearchSockList = r100;
        if (r100.open() == true) goto L6;
        return false;
    L6:
        this.mSsdpSearchSockList.addSearchListener(this);
        this.mSsdpSearchSockList.start();
        announce();
        a r101 = new a(this);
        this.mAdvertiser = r101;
        r101.start();
        return true;
    }

    public boolean stop() {
        return stop(true);
    }

    static {
        TAG = "CastDevice";
    }

    public void announce() {
        Iterator<String> r100 = this.hostAddresses.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        String r101 = r100.next();
        if (TextUtils.isEmpty(r101) == true) goto L4;
        announce(r101);
        goto L4
    }

    public String toString() {
        return "Device{, mDeviceId='" + this.mDeviceId + "', mServiceType='" + this.mServiceType + "', mIp='" + this.mIp + "', mPort='" + this.mPort + "', mProtocol='" + this.mProtocol + "', mLeaseTime='" + this.mLeaseTime + "', mSinkVersion='" + this.mSinkVersion + "', mMyName='" + this.mMyName + "'}";
    }

    public void byebye() {
        int r100 = HostInterface.getNHostAddresses();
        String[] r101 = new String[r100];
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L5;
        r101[r103] = HostInterface.getHostAddress(r103);
        r103 = r103 + 1;
    L5:
        if (r102 >= r100) goto L13;
        String r104 = r101[r102];
        if (r104 == null) goto L12;
        if (r104.length() <= 0) goto L12;
        byebye(r101[r102]);
    L12:
        r102 = r102 + 1;
        goto L5
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public String getIp() {
        return this.mIp;
    }

    public int getLeaseTime() {
        return this.mLeaseTime;
    }

    public String getMyName() {
        return this.mMyName;
    }

    public int getPort() {
        return this.mPort;
    }

    public String getProtocol() {
        return this.mProtocol;
    }

    public String getServiceType() {
        return this.mServiceType;
    }

    public String getSinkVersion() {
        return this.mSinkVersion;
    }

    public CastDevice(ContextManager.CastContext r100) {
        this.hostAddresses = new ArrayList();
        this.mCastContext = r100;
    }

    private boolean stop(boolean r100) {
        if (r100 == false) goto L4;
        byebye();
    L4:
        CastSSDPSearchSocketList r101 = this.mSsdpSearchSockList;
        if (r101 == null) goto L7;
        r101.stop();
        this.mSsdpSearchSockList.close();
        this.mSsdpSearchSockList.clear();
    L7:
        a r102 = this.mAdvertiser;
        if (r102 == null) goto L12;
        r102.stop();
        this.mAdvertiser = null;
        return true;
    L12:
        return true;
    }

    public void announce(String r100) {
        c r101 = new c(this.mCastContext);
        r101.setHeader(HTTP.NTS, NTS.ALIVE);
        r101.setHeader(HTTP.DEVICEID, getDeviceId());
        r101.setHeader(HTTP.SERVICE, getServiceType());
        r101.setHeader(HTTP.PROTOCOL, getProtocol());
        r101.setHeader(HTTP.PROTOCOLVERSION, "1");
        r101.setHeader(HTTP.IP, getIp());
        r101.setHeader(HTTP.PORT, String.valueOf(getPort()));
        r101.setHeader(HTTP.MYNAME, getMyName());
        r101.setHeader(HTTP.SINKVERSION, getSinkVersion());
        Logger.d(TAG, " announce ssdpReq is : " + r101 + " bindAddr is: " + r100);
        d r102 = new d(this.mCastContext, false);
        r101.setHost(SSDP.BDLINK_ADDRESS, 1900);
        r102.setMulticastInetAddress(SSDP.BDLINK_ADDRESS, 1900);
        r102.post(r101, r100, 0);
        if (DLNAOptionUtils.isEnableSinkBDLinkSSDPBroadcast(this.mCastContext) == false) goto L6;
        d r103 = new d(this.mCastContext, false);
        r101.setHost(SSDP.BROADCAST_ADDRESS, 1900);
        r103.setMulticastInetAddress(SSDP.BROADCAST_ADDRESS, 1900);
        r103.postWithBroadcast(r101, r100, 0);
        return;
    }

    @Override // com.byted.cast.linkcommon.cybergarage.upnp.device.SearchListener
    public void bdlinkDeviceSearchReceived(CastSSDPPacket r100) {
        deviceSearchResponse(r100);
    }

    public void byebye(String r100) {
        c r101 = new c(this.mCastContext);
        r101.setHeader(HTTP.NTS, NTS.BYEBYE);
        r101.setHeader(HTTP.DEVICEID, getDeviceId());
        r101.setHeader(HTTP.SERVICE, getServiceType());
        r101.setHeader(HTTP.PROTOCOL, getProtocol());
        r101.setHeader(HTTP.PROTOCOLVERSION, "1");
        Logger.d(TAG, " byebye ssdpReq is : " + r101 + " bindAddr is: " + r100);
        d r102 = new d(this.mCastContext, false);
        r101.setHost(SSDP.BDLINK_ADDRESS, 1900);
        r102.setMulticastInetAddress(SSDP.BDLINK_ADDRESS, 1900);
        r102.post(r101, r100, 0);
        if (DLNAOptionUtils.isEnableSinkBDLinkSSDPBroadcast(this.mCastContext) == false) goto L6;
        d r103 = new d(this.mCastContext, false);
        r101.setHost(SSDP.BROADCAST_ADDRESS, 1900);
        r103.setMulticastInetAddress(SSDP.BROADCAST_ADDRESS, 1900);
        r103.postWithBroadcast(r101, r100, 0);
        return;
    }

    public void deviceSearchResponse(CastSSDPPacket r100) {
        String r101 = TAG;
        Logger.d(r101, "deviceSearchResponse, ssdpPacket:" + r100);
        String r102 = r100.getSearchTarget();
        String r103 = r100.getProtocol();
        if (TextUtils.isEmpty(r102) == false) goto L5;
    L20:
        Logger.d(r101, "deviceSearchResponse, searchTarget:" + r102 + " getServiceType " + getServiceType());
        return;
    L5:
        if (TextUtils.isEmpty(getServiceType()) == true) goto L20;
        if (r102.contains(getServiceType()) == false) goto L20;
        if (TextUtils.isEmpty(r103) == false) goto L12;
    L18:
        Logger.d(r101, "deviceSearchResponse, protocol:" + r103 + " getProtocol() " + getProtocol());
        return;
    L12:
        if (TextUtils.isEmpty(getProtocol()) == true) goto L18;
        if (r103.contains(getProtocol()) == false) goto L18;
        postSearchResponse(r100);
    }

    public boolean postSearchResponse(CastSSDPPacket r100) {
        h r101 = new h(this.mCastContext);
        r101.setHeader(HTTP.DEVICEID, getDeviceId());
        r101.setHeader(HTTP.SERVICE, getServiceType());
        r101.setHeader(HTTP.PROTOCOL, getProtocol());
        r101.setHeader(HTTP.PROTOCOLVERSION, "1");
        r101.setHeader(HTTP.IP, getIp());
        r101.setHeader(HTTP.PORT, String.valueOf(getPort()));
        r101.setHeader(HTTP.MYNAME, getMyName());
        r101.setHeader(HTTP.SINKVERSION, getSinkVersion());
        String r102 = r100.getRemoteAddress();
        int r103 = r100.getRemotePort();
        CastSSDPSearchResponseSocket r104 = new CastSSDPSearchResponseSocket(this.mCastContext);
        r104.open();
        Logger.d(TAG, " postSearchResponse ssdpRes is : " + r101 + " remoteAddr is: " + r102);
        r104.post(r102, r103, r101);
        return true;
    }

    public void setDeviceId(String r100) {
        this.mDeviceId = r100;
    }

    public void setIp(String r100) {
        this.mIp = r100;
    }

    public void setLeaseTime(int r100) {
        this.mLeaseTime = r100;
    }

    public void setMyName(String r100) {
        this.mMyName = r100;
    }

    public void setPort(int r100) {
        this.mPort = r100;
    }

    public void setProtocol(String r100) {
        this.mProtocol = r100;
    }

    public void setServiceType(String r100) {
        this.mServiceType = r100;
    }

    public void setSinkVersion(String r100) {
        this.mSinkVersion = r100;
    }
}
