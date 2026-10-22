package com.bytedance.ttnet.httpdns;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.ttnet.TTNetInit;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes22.dex */
public class TTDnsQuery {
    private Map<String, String> controlHeaders;
    private String host;
    private CountDownLatch latch;
    private TTDnsResult result;
    private int sdkId;
    private String uuid;

    public void await() throws InterruptedException {
        this.latch.await();
    }

    public void resume() {
        this.latch.countDown();
    }

    public void doQuery() throws Exception {
        SsCronetHttpClient.inst(TTNetInit.getTTNetDepend().getContext()).ttDnsResolve(this.host, this.sdkId, this.uuid, this.controlHeaders);
    }

    public String host() {
        return this.host;
    }

    public TTDnsResult result() {
        return this.result;
    }

    public int sdkId() {
        return this.sdkId;
    }

    public String uuid() {
        return this.uuid;
    }

    public void setResult(TTDnsResult r100) {
        this.result = r100;
    }

    public TTDnsQuery(String r100, int r101, Map<String, String> r102) {
        this.host = r100;
        this.sdkId = r101;
        this.controlHeaders = r102;
        this.uuid = UUID.randomUUID().toString();
        this.latch = new CountDownLatch(1);
    }
}
