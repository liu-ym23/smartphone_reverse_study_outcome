package com.bytedance.common.wschannel;

import android.text.TextUtils;
import com.alibaba.gaiax.render.view.basic.GXImageView;
import com.alipay.sdk.m.u.i;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.server.FrontierMessageManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ChannelInfo {
    int aid;
    String appKey;
    final int channelId;
    String deviceId;
    boolean disableFallbackWs;
    boolean enablePassportAuth;
    Map<String, String> extra;
    int fpid;
    Map<String, String> headers;
    String installId;
    boolean privateProtocolEnabled;
    String privateProtocolUrl;
    List<Integer> serviceIdList;
    TransportMode transportMode;
    int updateVersionCode;
    List<String> urls;

    public static class Builder {
        private int aid;
        private int appVersion;
        private String appkey;
        private final int channelId;
        private String deviceId;
        boolean disableFallbackWS;
        boolean enablePassportAuth;
        Map<String, String> extra;
        private int fpid;
        Map<String, String> headers;
        private String installId;
        boolean privateProtocolEnabled;
        String privateProtocolUrl;
        List<Integer> serviceIdList;
        TransportMode transportMode;
        List<String> urls;

        public ChannelInfo builder() {
            return new ChannelInfo(this.fpid, this.aid, this.appVersion, this.appkey, this.channelId, this.deviceId, this.installId, this.urls, this.extra, this.privateProtocolEnabled, this.serviceIdList, this.privateProtocolUrl, this.transportMode, this.disableFallbackWS, this.enablePassportAuth, this);
        }

        public Builder(int r100) {
            this.extra = new HashMap();
            this.headers = new HashMap();
            this.urls = new ArrayList();
            this.serviceIdList = new ArrayList();
            this.transportMode = TransportMode.TUDP;
            this.enablePassportAuth = false;
            this.channelId = r100;
        }

        public static Builder create(int r100) {
            return new Builder(r100);
        }

        public Builder disableFallbackWebSocket(boolean r100) {
            this.disableFallbackWS = r100;
            return this;
        }

        public Builder enablePassportAuth(boolean r100) {
            this.enablePassportAuth = r100;
            return this;
        }

        public Builder enablePrivateProtocol(boolean r100) {
            this.privateProtocolEnabled = r100;
            return this;
        }

        public Builder extras(Map<String, String> r100) {
            if (r100 == null) goto L4;
            this.extra.putAll(r100);
        L4:
            return this;
        }

        public Builder headers(Map<String, String> r100) {
            if (r100 == null) goto L4;
            this.headers.putAll(r100);
        L4:
            return this;
        }

        public Builder setAid(int r100) {
            this.aid = r100;
            return this;
        }

        public Builder setAppKey(String r100) {
            this.appkey = r100;
            return this;
        }

        public Builder setAppVersion(int r100) {
            this.appVersion = r100;
            return this;
        }

        public Builder setDeviceId(String r100) {
            this.deviceId = r100;
            return this;
        }

        public Builder setFPID(int r100) {
            this.fpid = r100;
            return this;
        }

        public Builder setInstallId(String r100) {
            this.installId = r100;
            return this;
        }

        public Builder transportModeForPrivateProtocol(TransportMode r100) {
            this.transportMode = r100;
            return this;
        }

        public Builder uniqueServiceIdList(List<Integer> r100) {
            if (r100 == null) goto L4;
            this.serviceIdList.addAll(r100);
        L4:
            return this;
        }

        public Builder urlForPrivateProtocol(String r100) {
        L11:
            this.privateProtocolUrl = null;
            Logger.e("ChannelInfo", "The private protocol url is invalid.");
        L12:
            return this;
        L4:
            if (r100.startsWith("wss:") == false) goto L7;
            r100 = GXImageView.NET_HTTPS_PREFIX + r100.substring(4);     // Catch: Throwable -> L11
        L9:
            new URI(r100);     // Catch: Throwable -> L11
            this.privateProtocolUrl = r100;     // Catch: Throwable -> L11
            goto L12
        L7:
            if (r100.startsWith("ws:") == false) goto L9;
            r100 = GXImageView.NET_HTTP_PREFIX + r100.substring(3);     // Catch: Throwable -> L11
            goto L9
        }

        public Builder urls(List<String> r100) {
            if (r100 == null) goto L4;
            this.urls.addAll(r100);
        L4:
            return this;
        }

        public Builder extra(String r100, String r101) {
            if (StringUtils.isEmpty(r100) == true) goto L5;
            this.extra.put(r100, r101);
        L5:
            return this;
        }

        public Builder header(String r100, String r101) {
            if (StringUtils.isEmpty(r100) == true) goto L5;
            this.headers.put(r100, r101);
        L5:
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.common.wschannel.WsLoginAuthStrategy$RequestAuthInfo] */
    private void checkLoginAuthHeader() {
        if (this.enablePassportAuth == true) goto L5;
        return;
    L5:
        WsLoginAuthStrategy$LoginCallback r100 = WsChannelSettings.getLoginAuthCallback();
        if (r100 != 0) goto L8;
        return;
    L8:
        final ArrayList r101 = new ArrayList();
        if (this.privateProtocolEnabled == false) goto L14;
        if (TextUtils.isEmpty(this.privateProtocolUrl) == true) goto L14;
        r101.add(this.privateProtocolUrl);
    L16:
        final HashMap r102 = new HashMap(this.headers);
        r100.checkPassportLoginHeader(new WsLoginAuthStrategy$RequestAuthInfo(r101, r102));     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        Logger.e("ChannelInfo", "check au fail: " + e.getMessage());
        return;
    L14:
        if (this.urls.isEmpty() == true) goto L16;
        r101.addAll(this.urls);
        goto L16
    }

    public String toString() {
        return "ChannelInfo{channelId = " + this.channelId + ", deviceId = " + this.deviceId + ", installId = " + this.installId + ", fpid = " + this.fpid + ", aid = " + this.aid + ", updateVersionCode = " + this.updateVersionCode + ", appKey = " + this.appKey + ", header = " + this.headers + ", extra = " + this.extra + ", urls = " + this.urls + i.f25855d;
    }

    public ChannelInfo(ChannelInfo r100) {
        this.extra = new HashMap();
        this.headers = new HashMap();
        this.urls = new ArrayList();
        this.serviceIdList = new ArrayList();
        this.channelId = r100.channelId;
        this.deviceId = r100.deviceId;
        this.installId = r100.installId;
        List<String> r101 = r100.urls;
        if (r101 == null) goto L5;
        this.urls.addAll(r101);
    L5:
        Map<String, String> r102 = r100.extra;
        if (r102 == null) goto L8;
        this.extra.putAll(r102);
    L8:
        Map<String, String> r103 = r100.headers;
        if (r103 == null) goto L11;
        this.headers.putAll(r103);
    L11:
        this.fpid = r100.fpid;
        this.aid = r100.aid;
        this.appKey = r100.appKey;
        this.updateVersionCode = r100.updateVersionCode;
        this.privateProtocolEnabled = r100.privateProtocolEnabled;
        this.transportMode = r100.transportMode;
        this.privateProtocolUrl = r100.privateProtocolUrl;
        List<Integer> r104 = r100.serviceIdList;
        if (r104 == null) goto L14;
        this.serviceIdList.addAll(r104);
    L14:
        this.disableFallbackWs = r100.disableFallbackWs;
        this.enablePassportAuth = r100.enablePassportAuth;
        checkLoginAuthHeader();
    }

    public ChannelInfo(int r100, int r101, int r102, String r103, int r104, String r110, String r111, List<String> r112, Map<String, String> r113, boolean r114, List<Integer> r115, String r116, TransportMode r117, boolean r118, boolean r119, Builder r210) {
        this.extra = new HashMap();
        this.headers = new HashMap();
        this.urls = new ArrayList();
        this.serviceIdList = new ArrayList();
        this.channelId = r104;
        this.deviceId = r110;
        this.installId = r111;
        this.updateVersionCode = r102;
        if (r112 == null) goto L5;
        this.urls.addAll(r112);
    L5:
        if (r113 == null) goto L7;
        this.extra.putAll(r113);
    L7:
        Map<String, String> r105 = r210.headers;
        if (r105 == null) goto L11;
        this.headers.putAll(r105);
    L11:
        if (FrontierMessageManager.isQos2Enabled() == false) goto L13;
        this.headers.put("x-support-qos2", "1");
    L13:
        this.fpid = r100;
        this.aid = r101;
        this.appKey = r103;
        this.serviceIdList = r115;
        this.privateProtocolEnabled = r114;
        this.privateProtocolUrl = r116;
        this.transportMode = r117;
        if (TextUtils.isEmpty(r116) == false) goto L16;
        this.privateProtocolEnabled = false;
    L16:
        this.disableFallbackWs = r118;
        this.enablePassportAuth = r119;
        checkLoginAuthHeader();
    }
}
