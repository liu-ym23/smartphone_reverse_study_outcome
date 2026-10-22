package com.ss.ttvideoengine.net;

import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class IPCache {
    private static IPCache mInstance = null;
    private static String mNetExtraInfo = null;
    private static int mNetType = -1;
    private ConcurrentHashMap<String, IpInfo> mIpRecord;

    public static class IpInfo {
        public long ip_expiretime;
        public JSONObject ip_json;

        public IpInfo() {
        }
    }

    public static IPCache getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(IPCache.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new IPCache();     // Catch: Throwable -> L11
    L9:
        monitor-exit(IPCache.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public void clear() {
        ConcurrentHashMap<String, IpInfo> r100 = this.mIpRecord;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    public int getRecordSize() {
        ConcurrentHashMap<String, IpInfo> r100 = this.mIpRecord;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.size();
    }

    private IPCache() {
        this.mIpRecord = new ConcurrentHashMap();
    }

    public String getCurNetExtraInfo() {
        return mNetExtraInfo;
    }

    public int getCurNetType() {
        return mNetType;
    }

    public IpInfo get(String r100) {
        ConcurrentHashMap<String, IpInfo> r101 = this.mIpRecord;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.get(r100);
    }

    public void setCurNetExtraInfo(String r100) {
        mNetExtraInfo = r100;
    }

    public void setCurNetType(int r100) {
        mNetType = r100;
    }

    public void put(String r100, IpInfo r101) {
        ConcurrentHashMap<String, IpInfo> r102 = this.mIpRecord;
        if (r102 == null) goto L6;
        r102.put(r100, r101);
        return;
    }
}
