package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.DnsResult;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.HttpDns;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Dns;
import okhttp3.ttnet.TTNetDns;
import okhttp3.ttnet.TTNetDnsResult;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public class OkHttp3DnsParserInterceptor implements TTNetDns {
    private static volatile OkHttp3DnsParserInterceptor mInstance;
    private final String TAG;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3DnsParserInterceptor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$httpdns$DnsResult$Source = null;

        static {
            int[] r100 = new int[DnsResult.Source.values().length];
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$httpdns$DnsResult$Source = r100;
            r100[DnsResult.Source.HTTPDNS_CACHE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$httpdns$DnsResult$Source[DnsResult.Source.LOCALDNS_CACHE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$httpdns$DnsResult$Source[DnsResult.Source.HTTPDNS_REQUEST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$httpdns$DnsResult$Source[DnsResult.Source.LOCALDNS_REQUEST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$httpdns$DnsResult$Source[DnsResult.Source.HTTPDNS_STALE_CACHE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$httpdns$DnsResult$Source[DnsResult.Source.HARDCODE_IPS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$httpdns$DnsResult$Source[DnsResult.Source.UNKNOWN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static OkHttp3DnsParserInterceptor inst() {
        if (mInstance != null) goto L15;
        monitor-enter(OkHttp3DnsParserInterceptor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new OkHttp3DnsParserInterceptor();     // Catch: Throwable -> L11
    L9:
        monitor-exit(OkHttp3DnsParserInterceptor.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public OkHttp3DnsParserInterceptor() {
        this.TAG = "OkHttp3DnsParserInterceptor";
    }

    private String constructDnsInfoJson(List<InetAddress> r100, DnsResult.Source r101) {
        JSONObject r102 = new JSONObject();
        JSONArray r103 = new JSONArray();     // Catch: Exception -> L31
        Iterator<InetAddress> r104 = r100.iterator();     // Catch: Exception -> L31
    L5:
        if (r104.hasNext() == false) goto L11;
        InetAddress r105 = r104.next();     // Catch: Exception -> L31
        if (r105 == null) goto L5;
        if (TextUtils.isEmpty(r105.getHostAddress()) == true) goto L5;
        r103.put(r105.getHostAddress());     // Catch: Exception -> L31
        goto L5
    L11:
        r102.put("address_list", r103);     // Catch: Exception -> L31
        int r106 = 1;
        if (HttpDns.getService().isHttpDnsPrefer().get() == false) goto L14;
        int r107 = 1;
    L15:
        r102.put("httpdns_prefer", r107);     // Catch: Exception -> L31
        TTNetDnsSource r108 = TTNetDnsSource.NOT_SET;     // Catch: Exception -> L31
        TTNetDnsCacheSource r109 = TTNetDnsCacheSource.UNKNOWN;     // Catch: Exception -> L31
        switch(AnonymousClass1.$SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$httpdns$DnsResult$Source[r101.ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            default: goto L24;
        };     // Catch: Exception -> L31
    L18:
        r108 = TTNetDnsSource.SERVE_FROM_HARDCODE_HOSTS;     // Catch: Exception -> L31
        goto L24
    L19:
        r108 = TTNetDnsSource.SERVE_FROM_CACHE;     // Catch: Exception -> L31
        r109 = TTNetDnsCacheSource.SOURCE_HTTPDNS;     // Catch: Exception -> L31
        boolean r110 = true;
    L25:
        r102.put("source", r108.mValue);     // Catch: Exception -> L31
        r102.put("cache_source", r109.mValue);     // Catch: Exception -> L31
        if (r110 == true) goto L29;
        r106 = 0;
    L29:
        r102.put("from_stale_cache", r106);     // Catch: Exception -> L31
    L34:
        return r102.toString();
    L20:
        r108 = TTNetDnsSource.SERVE_FROM_PROC_DNS_JOB;     // Catch: Exception -> L31
        goto L24
    L21:
        r108 = TTNetDnsSource.SERVE_FROM_HTTP_DNS_JOB;     // Catch: Exception -> L31
        goto L24
    L22:
        r108 = TTNetDnsSource.SERVE_FROM_CACHE;     // Catch: Exception -> L31
        r109 = TTNetDnsCacheSource.SOURCE_PROC;     // Catch: Exception -> L31
        goto L24
    L23:
        r108 = TTNetDnsSource.SERVE_FROM_CACHE;     // Catch: Exception -> L31
        r109 = TTNetDnsCacheSource.SOURCE_HTTPDNS;     // Catch: Exception -> L31
    L24:
        r110 = false;
        goto L25
    L14:
        r107 = 0;
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L34
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3DnsParserInterceptor] */
    @Override // okhttp3.ttnet.TTNetDns
    public TTNetDnsResult lookup(String r100, int r101) throws UnknownHostException {
        if (Logger.debug() == false) goto L5;
        Logger.d(this.TAG, "lookup address list for " + r100 + " " + r101);
    L5:
        DnsResult r102 = HttpDns.getService().getHttpDnsResultForHostSyncBlock(r100);
        DnsResult.Source r103 = DnsResult.Source.UNKNOWN;
        ?? r104 = new ArrayList();
        if (r102 != null) goto L8;
    L28:
        r104 = Dns.SYSTEM.lookup(r100);     // Catch: UnknownHostException -> L27
        r103 = DnsResult.Source.LOCALDNS_REQUEST;     // Catch: UnknownHostException -> L27
    L26:
        return new TTNetDnsResult(r104, constructDnsInfoJson(r104, r103));
    L8:
        if (r102.ipv4List.isEmpty() == true) goto L10;
    L11:
        Iterator<String> r105 = r102.ipv6List.iterator();
        Iterator<String> r106 = r102.ipv4List.iterator();
    L13:
        if (r105.hasNext() == true) goto L19;
        if (r106.hasNext() == true) goto L19;
        r103 = r102.source;
    L19:
        if (r105.hasNext() == false) goto L22;
        r104.add(InetAddress.getByName(r105.next()));
    L22:
        if (r106.hasNext() == false) goto L13;
        r104.add(InetAddress.getByName(r106.next()));
        goto L13
    L10:
        if (r102.ipv6List.isEmpty() == true) goto L28;
        goto L11
    }
}
