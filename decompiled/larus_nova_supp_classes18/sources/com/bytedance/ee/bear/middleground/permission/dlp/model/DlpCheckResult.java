package com.bytedance.ee.bear.middleground.permission.dlp.model;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DlpCheckResult extends Result implements NonProguard {
    private ConcurrentHashMap<String, DlpResult> resultMap;
    private long timeout;

    public class DlpResult implements NonProguard {
        private String bizAction;
        private boolean isAllow;
        private long scsUpdateTime;
        final /* synthetic */ DlpCheckResult this$0;

        public String getBizAction() {
            return this.bizAction;
        }

        public long getScsUpdateTime() {
            return this.scsUpdateTime;
        }

        public boolean isAllow() {
            return this.isAllow;
        }

        public DlpResult(DlpCheckResult r1) {
            this.this$0 = r1;
        }

        public void setAllow(boolean r1) {
            this.isAllow = r1;
        }

        public void setBizAction(String r1) {
            this.bizAction = r1;
        }

        public void setScsUpdateTime(long r1) {
            this.scsUpdateTime = r1;
        }
    }

    public DlpCheckResult() {
        this.resultMap = new ConcurrentHashMap();
    }

    public ConcurrentHashMap<String, DlpResult> getResultMap() {
        return this.resultMap;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public void setResultMap(ConcurrentHashMap<String, DlpResult> r1) {
        this.resultMap = r1;
    }

    public void setTimeout(long r1) {
        this.timeout = r1;
    }
}
