package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import java.io.Serializable;

/* JADX INFO: loaded from: classes19.dex */
public class HostResolveJob implements Serializable, Comparable<HostResolveJob> {
    private long mCreatedTime;
    private String mHost;
    public IHttpDnsCallback mHttpDnsCallback;
    private boolean mIsLocalDnsExpired;

    public String getHost() {
        return this.mHost;
    }

    public boolean isLocalDnsExpired() {
        return this.mIsLocalDnsExpired;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(HostResolveJob r100) {
        long r101 = r100.mCreatedTime;
        long r102 = this.mCreatedTime;
        if (r101 != r102) goto L7;
        return 0;
    L7:
        if (r101 >= r102) goto L9;
        return -1;
    L9:
        return 1;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(HostResolveJob r100) {
        return compareTo2(r100);
    }

    public HostResolveJob(String r100, IHttpDnsCallback r101, boolean r102) {
        this.mHost = r100;
        this.mHttpDnsCallback = r101;
        this.mCreatedTime = System.currentTimeMillis();
        this.mIsLocalDnsExpired = r102;
    }
}
