package com.bytedance.ttnet.okhttp;

import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.ttnet.AbsOptionalTTNetDepend;
import com.bytedance.ttnet.ITTNetDepend;
import java.util.List;
import ox5.a;

/* JADX INFO: loaded from: classes3.dex */
public class OkHttpAppInfoProvider implements a {
    private static volatile OkHttpAppInfoProvider sInstance;
    private ICronetAppProvider mCronetProvider;
    private ITTNetDepend mTTNetDepend;

    public static OkHttpAppInfoProvider inst() {
        if (sInstance != null) goto L15;
        monitor-enter(OkHttpAppInfoProvider.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new OkHttpAppInfoProvider();     // Catch: Throwable -> L11
    L9:
        monitor-exit(OkHttpAppInfoProvider.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    @Override // ox5.a
    public List<String> getAbSdkVersion() {
        ICronetAppProvider r100 = this.mCronetProvider;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getAbSdkVersion();
    }

    @Override // ox5.a
    public int getAid() {
        ITTNetDepend r100 = this.mTTNetDepend;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getAppId();
    }

    @Override // ox5.a
    public String getHttpDnsDomain() {
        ITTNetDepend r100 = this.mTTNetDepend;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getTTNetServiceDomainMap().get("httpdns");
    }

    @Override // ox5.a
    public String[] getHttpDnsDomainHardCodeIps() {
        Object r100 = this.mTTNetDepend;
        if ((r100 instanceof AbsOptionalTTNetDepend) == true) goto L5;
        return null;
    L5:
        return ((AbsOptionalTTNetDepend) r100).getHttpDnsHardCodeIps();
    }

    @Override // ox5.a
    public String[] getHttpDnsPreloadDomains() {
        Object r100 = this.mTTNetDepend;
        if ((r100 instanceof AbsOptionalTTNetDepend) == true) goto L5;
        return null;
    L5:
        return ((AbsOptionalTTNetDepend) r100).getPreloadDomains();
    }

    private OkHttpAppInfoProvider() {
    }

    public void setCronetProvider(ICronetAppProvider r100) {
        this.mCronetProvider = r100;
    }

    public void setTTNetDepend(ITTNetDepend r100) {
        this.mTTNetDepend = r100;
    }

    @Override // ox5.a
    public void sendAppMonitorEvent(String r100, String r101) {
        ICronetAppProvider r102 = this.mCronetProvider;
        if (r102 == null) goto L6;
        r102.sendAppMonitorEvent(r100, r101);
        return;
    }
}
