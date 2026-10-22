package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.os.Bundle;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public class LocalDnsResolveCall implements Callable<Void> {
    public static final int MSG_LOCALDNS_COMPLETED = 1;
    public static final String MSG_LOCALDNS_COMPLETED_HOST_KEY = "localdns_completed_host";
    private final String TAG;
    private final String mHost;
    private final HostResolveManager mHostResolveManager;
    private final WeakHandler mHttpDnsHanlder;

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Void call2() {
        long r100 = System.currentTimeMillis();
        ArrayList r101 = new ArrayList();
        ArrayList r110 = new ArrayList();
        InetAddress[] r102 = InetAddress.getAllByName(this.mHost);     // Catch: UnknownHostException -> L24
        int r103 = r102.length;     // Catch: UnknownHostException -> L24
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L16;
        InetAddress r105 = r102[r104];     // Catch: UnknownHostException -> L24
        if ((r105 instanceof Inet4Address) == false) goto L9;
        r101.add(r105.getHostAddress());     // Catch: UnknownHostException -> L24
    L14:
        r104 = r104 + 1;     // Catch: UnknownHostException -> L24
        goto L4
    L9:
        if ((r105 instanceof Inet6Address) == false) goto L12;
        r110.add(r105.getHostAddress());     // Catch: UnknownHostException -> L24
        goto L14
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d(this.TAG, "local dns server returned a invalid address: " + r105.getHostAddress());     // Catch: UnknownHostException -> L24
        goto L14
    L16:
        if (Logger.debug() == false) goto L19;
        Logger.d(this.TAG, "local dns resolved success for host: " + this.mHost);     // Catch: UnknownHostException -> L24
    L19:
        if (r101.size() <= 0) goto L21;
    L22:
        this.mHostResolveManager.addLocalDnsCache(this.mHost, new DnsRecord(this.mHost, System.currentTimeMillis(), r101, r110, HttpDns.getService().getLocalDnsCacheTTL().get()));     // Catch: UnknownHostException -> L24
    L27:
        if (HttpDns.getService().isHttpDnsPrefer().get() == true) goto L45;
        Message r106 = Message.obtain();
        r106.obj = this;
        r106.what = 1;
        Bundle r107 = new Bundle();
        r107.putString(MSG_LOCALDNS_COMPLETED_HOST_KEY, this.mHost);
        r106.setData(r107);
        this.mHttpDnsHanlder.sendMessage(r106);
        if (Logger.debug() == false) goto L31;
        Logger.d(this.TAG, "send message to collect result handler for host : " + this.mHost);
    L31:
        long r108 = System.currentTimeMillis() - r100;
        JSONObject r109 = new JSONObject();     // Catch: JSONException -> L43
        r109.put("host", this.mHost);     // Catch: JSONException -> L43
        if (r101.size() == 0) goto L36;
    L38:
        r109.put("status", "succeed");     // Catch: JSONException -> L43
        ArrayList r111 = new ArrayList();     // Catch: JSONException -> L43
        r111.addAll(r110);     // Catch: JSONException -> L43
        r111.addAll(r101);     // Catch: JSONException -> L43
        r109.put("result", r111);     // Catch: JSONException -> L43
    L39:
        r109.put("rtt", r108);     // Catch: JSONException -> L43
        if (Logger.debug() == false) goto L45;
        Logger.d(this.TAG, r109.toString());     // Catch: JSONException -> L43
        goto L45
    L36:
        if (r110.size() != 0) goto L38;
        r109.put("status", "failed");     // Catch: JSONException -> L43
        r109.put("result", "");     // Catch: JSONException -> L43
    L43:
        e = move-exception;
        e.printStackTrace();
    L45:
        this.mHostResolveManager.removeLocalDnsResolvingFuture(this.mHost);
        return null;
    L21:
        if (r110.size() <= 0) goto L27;
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L27
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() throws Exception {
        return call2();
    }

    public LocalDnsResolveCall(String r100, HostResolveManager r101, WeakHandler r102) {
        this.TAG = "LocalDnsResolveCall";
        this.mHost = r100;
        this.mHostResolveManager = r101;
        this.mHttpDnsHanlder = r102;
    }
}
