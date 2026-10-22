package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.os.Bundle;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public class DnsRecord {
    public static final String MSG_DNSRECORD_HOST = "dnsrecord_host";
    public static final int MSG_HTTPDNS_CACHE_EXPIRED = 12;
    public static final int MSG_REFRESH_HTTPDNS_STALE_CACHE = 10;
    public static final int MSG_REMOVE_HTTPDNS_STALE_CACHE = 13;
    public static final int MSG_REMOVE_LOCALDNS_STALE_CACHE = 11;
    private static final String TAG = null;
    private long mFetchTime;
    private final WeakHandler mHandler;
    private String mHost;
    private List<String> mIpv4List;
    private List<String> mIpv6List;
    private long mTTL;

    public static final enum CacheStaleReason extends Enum<CacheStaleReason> {
        private static final /* synthetic */ CacheStaleReason[] $VALUES = null;
        public static final CacheStaleReason CACHE_STALE_BOTH = null;
        public static final CacheStaleReason CACHE_STALE_EXPIRED = null;
        public static final CacheStaleReason CACHE_STALE_NETCHANGED = null;
        public static final CacheStaleReason CACHE_UNSET = null;
        public static final CacheStaleReason CACHE_VALID = null;
        public static final CacheStaleReason PRELOAD_BATCH = null;
        public static final CacheStaleReason REFRESH_BATCH = null;

        static {
            CacheStaleReason r100 = new CacheStaleReason("CACHE_UNSET", 0);
            CACHE_UNSET = r100;
            CacheStaleReason r101 = new CacheStaleReason("CACHE_VALID", 1);
            CACHE_VALID = r101;
            CacheStaleReason r102 = new CacheStaleReason("CACHE_STALE_BOTH", 2);
            CACHE_STALE_BOTH = r102;
            CacheStaleReason r103 = new CacheStaleReason("CACHE_STALE_NETCHANGED", 3);
            CACHE_STALE_NETCHANGED = r103;
            CacheStaleReason r104 = new CacheStaleReason("CACHE_STALE_EXPIRED", 4);
            CACHE_STALE_EXPIRED = r104;
            CacheStaleReason r105 = new CacheStaleReason("PRELOAD_BATCH", 5);
            PRELOAD_BATCH = r105;
            CacheStaleReason r110 = new CacheStaleReason("REFRESH_BATCH", 6);
            REFRESH_BATCH = r110;
            $VALUES = new CacheStaleReason[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static CacheStaleReason[] values() {
            return (CacheStaleReason[]) $VALUES.clone();
        }

        public static CacheStaleReason valueOf(String r100) {
            return (CacheStaleReason) a.a(CacheStaleReason.class, r100);
        }

        private CacheStaleReason(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        TAG = "DnsRecord";
    }

    public void removeHttpDnsRefreshTask() {
        this.mHandler.removeMessages(10);
        this.mHandler.removeMessages(12);
    }

    public void removeHttpDnsRemoveTask() {
        this.mHandler.removeMessages(13);
    }

    public void removeLocalDnsRemoveTask() {
        this.mHandler.removeMessages(11);
    }

    public void addHttpDnsRefreshTask() {
        Message r100 = Message.obtain();
        r100.obj = this;
        r100.what = 12;
        setHostToMessage(r100);
        this.mHandler.sendMessageDelayed(r100, this.mTTL * 1000);
        Message r101 = Message.obtain();
        r101.obj = this;
        r101.what = 10;
        setHostToMessage(r101);
        this.mHandler.sendMessageDelayed(r101, (this.mTTL * 1000) + (((long) HttpDns.getService().getHttpDnsRefreshStaleCacheInterval().get()) * 1000));
    }

    public void addHttpDnsRemoveTask() {
        Message r100 = Message.obtain();
        r100.obj = this;
        r100.what = 13;
        setHostToMessage(r100);
        this.mHandler.sendMessageDelayed(r100, this.mTTL * 1000);
    }

    public void addLocalDnsRemoveTask() {
        Message r100 = Message.obtain();
        r100.obj = this;
        r100.what = 11;
        setHostToMessage(r100);
        this.mHandler.sendMessageDelayed(r100, ((long) HttpDns.getService().getLocalDnsCacheTTL().get()) * 1000);
    }

    public long getFetchTime() {
        return this.mFetchTime;
    }

    public String getHost() {
        return this.mHost;
    }

    public List<String> getIpv4List() {
        return this.mIpv4List;
    }

    public List<String> getIpv6List() {
        return this.mIpv6List;
    }

    public long getTTL() {
        return this.mTTL;
    }

    private void setHostToMessage(Message r100) {
        Bundle r101 = new Bundle();
        r101.putString(MSG_DNSRECORD_HOST, this.mHost);
        r100.setData(r101);
    }

    public DnsRecord(String r100, long r101, List<String> r102, List<String> r103, int r104) {
        this.mHost = r100;
        this.mFetchTime = r101;
        this.mIpv4List = r102;
        this.mIpv6List = r103;
        this.mTTL = r104;
        this.mHandler = new WeakHandler(HttpDns.getService().getHttpDnsHandlerThread().getLooper(), HttpDns.getService());
    }
}
