package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.HttpDnsUtil;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.HttpsURLConnClient;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.IPAddressUtils;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.Ipv6ConnectionManager;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public class HttpDnsResolveCall implements Callable<Void> {
    private static final String DEVICE_PLATFORM = "android";
    private static final String HTTPDNS_SOURCE = "tt-ok";
    public static final String MSG_HTTPDDNS_COMPLETED_HOSTS_KEY = "httpdns_completed_hosts";
    public static final int MSG_HTTPDNS_COMPLETED = 3;
    private static final String TAG = null;
    private DnsRecord.CacheStaleReason mCacheStaleReason;
    private List<String> mCallbackHostList;
    private List<String> mHostList;
    private final HostResolveManager mHostResolveManager;
    private String mHosts;
    private final WeakHandler mHttpDnsHanlder;
    private final String mSdkVersion;
    private int mType;

    static {
        TAG = "HttpDnsResolveCall";
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Void call2() {
        String[] r100 = this.mHosts.split(",");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L6;
        String r103 = r100[r102];
        this.mHostList.add(r103);
        this.mCallbackHostList.add(r103);
        r102 = r102 + 1;
        goto L3
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "Start httpdns resolve for host : " + this.mHostList);
    L8:
        String r104 = HttpDns.getService().getHttpDnsDomain();
        if (HttpDns.getService().getHttpDnsDomainHardCodeIps().size() != 0) goto L12;
        this.mHostResolveManager.resetHttpDnsDomainFailedCnt();
    L12:
        if (HttpDnsUtil.isValidHost(r104) == true) goto L14;
    L18:
        String r105 = null;
    L19:
        if (r105 == null) goto L21;
        parseHttpDnsResponse(r105);
        this.mHostResolveManager.resetHttpDnsDomainFailedCnt();
    L37:
        Iterator<String> r106 = this.mHostList.iterator();
    L39:
        if (r106.hasNext() == false) goto L41;
        String r107 = r106.next();
        this.mHostResolveManager.removeHttpDnsResolvingFuture(r107);
        this.mHostResolveManager.removeHttpDnsCache(r107);
        goto L39
    L41:
        Message r108 = Message.obtain();
        r108.obj = this;
        r108.what = 3;
        Bundle r109 = new Bundle();
        r109.putStringArrayList(MSG_HTTPDDNS_COMPLETED_HOSTS_KEY, (ArrayList) this.mCallbackHostList);
        r108.setData(r109);
        this.mHttpDnsHanlder.sendMessage(r108);
        if (Logger.debug() == false) goto L44;
        Logger.d(TAG, "send message to collect result handler for host : " + this.mCallbackHostList);
    L44:
        return null;
    L21:
        Iterator<String> r110 = HttpDns.getService().getHttpDnsDomainHardCodeIps().iterator();
    L23:
        if (r110.hasNext() == false) goto L37;
        String r111 = r110.next();
        if (IPAddressUtils.isValidIpv4(r111) == true) goto L31;
        if (IPAddressUtils.isValidIpv6(r111) == true) goto L31;
        if (Logger.debug() == false) goto L23;
        Logger.d(TAG, "httpdns backup domian hardcode ip: " + r111 + " is invalid");
    L31:
        String r112 = doHttpDnsRequest(r111);
        if (r112 != null) goto L36;
        if (Logger.debug() == false) goto L23;
        Logger.d(TAG, "httpdns request failed use hardcode ip: " + r111 + " try next hardcode ip");
        goto L23
    L36:
        parseHttpDnsResponse(r112);
        goto L37
    L14:
        if (this.mHostResolveManager.getHttpDnsDomainFailedCnt().get() >= 2) goto L18;
        r105 = doHttpDnsRequest(r104);
        if (r105 != null) goto L19;
        this.mHostResolveManager.addHttpDnsDomainFailedCnt();
        goto L19
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() throws Exception {
        return call2();
    }

    private String doHttpDnsRequest(String r100) {
        StringBuilder r101 = new StringBuilder("https://");
        if (Ipv6ConnectionManager.getIpv6GloballyReachable().get() == true) goto L5;
        this.mType = 1;
    L5:
        r101.append(r100);
        r101.append("/q?host=");
        r101.append(this.mHosts);
        r101.append("&aid=");
        r101.append(HttpDns.getService().getHttpDnsDepend().getAppId());
        r101.append("&okhttp_version=");
        r101.append(this.mSdkVersion);
        r101.append("&p=android&source=tt-ok&f=");
        r101.append(this.mType);
        r101.append("&reason=");
        r101.append(this.mCacheStaleReason.ordinal() - 1);
        if (this.mHostResolveManager.getDetectedHardCodeipsCnt().get() >= 3) goto L9;
        r101.append("&refresh_bkup_ip=1");
        this.mHostResolveManager.setDetectedHardCodeipsCnt();
    L9:
        return HttpsURLConnClient.executeGet(r101.toString(), r100);
    }

    private void parseHttpDnsResponse(String r100) {
        if (Logger.debug() == false) goto L26;
        Logger.d(TAG, "parseHttpDnsResponse");
    L26:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L22
        if (this.mHostList.size() <= 1) goto L17;
        JSONArray r102 = r101.optJSONArray(MultiProcessFileUtils.KEY_DNS);     // Catch: JSONException -> L22
        if (r102 != null) goto L13;
        return;
    L13:
        int r103 = 0;
    L15:
        if (r103 >= r102.length()) goto L18;
        parseSingleHostHttpDnsResponse(r102.optJSONObject(r103));     // Catch: JSONException -> L22
        r103 = r103 + 1;     // Catch: JSONException -> L22
    L18:
        JSONArray r104 = r101.optJSONArray("httpdns_backup_ip");     // Catch: JSONException -> L22
        if (r104 == null) goto L29;
        HttpDns.getService().setHttpDnsHardCodeIps(r104);     // Catch: JSONException -> L22
        return;
    L29:
        return;
    L17:
        parseSingleHostHttpDnsResponse(r101);     // Catch: JSONException -> L22
    L23:
        if (Logger.debug() == false) goto L30;
        Logger.d(TAG, "httpdns server returned a invalid json response.");
        return;
    }

    private void parseSingleHostHttpDnsResponse(JSONObject r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        String r100 = r110.optString("host");
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "parseSingleHostHttpDnsResponse for host " + r100);
    L7:
        int r101 = r110.optInt(RemoteMessageConst.TTL);
        JSONArray r111 = r110.optJSONArray("ips");
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        if (r111 == null) goto L23;
        int r104 = 0;
    L11:
        if (r104 >= r111.length()) goto L23;
        String r105 = r111.optString(r104);
        if (IPAddressUtils.isValidIpv6(r105) == false) goto L16;
        r103.add(r105);
    L21:
        r104 = r104 + 1;
        goto L11
    L16:
        if (IPAddressUtils.isValidIpv4(r105) == false) goto L19;
        r102.add(r105);
        goto L21
    L19:
        if (Logger.debug() == false) goto L21;
        Logger.d(TAG, "httpdns server returned a invalid address: " + r105);
    L23:
        if (this.mHostList.contains(r100) == true) goto L25;
        return;
    L25:
        if (r102.size() <= 0) goto L27;
    L28:
        this.mHostResolveManager.addHttpDnsCache(r100, new DnsRecord(r100, System.currentTimeMillis(), r102, r103, r101));
        this.mHostResolveManager.removeHttpDnsResolvingFuture(r100);
        this.mHostList.remove(r100);
        return;
    L27:
        if (r103.size() > 0) goto L28;
    }

    public HttpDnsResolveCall(String r100, String r101, HostResolveManager r102, DnsRecord.CacheStaleReason r103, WeakHandler r104) {
        this.mHostList = new ArrayList();
        this.mCallbackHostList = new ArrayList();
        this.mType = 0;
        this.mHosts = r100;
        this.mSdkVersion = r101;
        this.mHostResolveManager = r102;
        this.mCacheStaleReason = r103;
        this.mHttpDnsHanlder = r104;
    }
}
