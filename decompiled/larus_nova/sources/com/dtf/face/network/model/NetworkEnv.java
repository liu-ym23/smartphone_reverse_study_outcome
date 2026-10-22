package com.dtf.face.network.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.heytap.mcssdk.constant.b;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkEnv {
    public static final int DOMAIN_EXCEPTION_CODE_TIMEOUT = -3;
    public static CopyOnWriteArrayList<String> invalidUrls;

    @JSONField(name = b.f276376z)
    public String appKey;

    @JSONField(name = b.A)
    public String appSecret;

    @JSONField(name = "backupUrls")
    public List<String> backupUrls;

    @JSONField(name = "dnsUrls")
    public Map<String, List<String>> dnsUrls;

    @JSONField(name = "envName")
    public String envName;

    @JSONField(name = "isIPv6")
    public boolean isIPv6;

    @JSONField(name = "safBackupUrl")
    public String safBackupUrl;

    @JSONField(name = "safHost")
    public String safHost;

    @JSONField(name = "safUrl")
    public String safUrl;

    static {
        invalidUrls = new CopyOnWriteArrayList();
    }

    public NetworkEnv() {
    }

    private String turnToNextUrl(String r100, boolean r101, CopyOnWriteArrayList<String> r102) {
        if (this.safBackupUrl.equals(r100) == false) goto L6;
        return "";
    L6:
        if (r101 == false) goto L18;
        List<String> r103 = this.backupUrls;
        if (r103 == null) goto L18;
        if (r103.size() <= 0) goto L18;
        Iterator<String> r104 = this.backupUrls.iterator();
    L13:
        if (r104.hasNext() == false) goto L18;
        String r105 = r104.next();
        if (r102.contains(r105) == true) goto L13;
        return r105;
    L18:
        return this.safBackupUrl;
    }

    public synchronized String getValidUrl(String r100, boolean r101, boolean r102) {
        monitor-enter(this);
        if (r102 == false) goto L11;
        if (invalidUrls.contains(r100) == true) goto L7;
        invalidUrls.add(r100);     // Catch: Throwable -> L17
    L7:
        String r103 = turnToNextUrl(r100, r101, invalidUrls);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r103;
    L11:
        if (invalidUrls.contains(r100) == false) goto L15;
        String r104 = turnToNextUrl(r100, r101, invalidUrls);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r104;
    L15:
        monitor-exit(this);
        return r100;
    L17:
        th = move-exception;
        throw th;
    }
}
