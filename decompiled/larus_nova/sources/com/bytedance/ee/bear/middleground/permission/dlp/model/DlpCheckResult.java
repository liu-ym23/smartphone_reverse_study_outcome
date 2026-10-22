package com.bytedance.ee.bear.middleground.permission.dlp.model;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes18.dex */
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

        public DlpResult(DlpCheckResult r100) {
            this.this$0 = r100;
        }

        public void setAllow(boolean r100) {
            this.isAllow = r100;
        }

        public void setBizAction(String r100) {
            this.bizAction = r100;
        }

        public void setScsUpdateTime(long r100) {
            this.scsUpdateTime = r100;
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

    public void setResultMap(ConcurrentHashMap<String, DlpResult> r100) {
        this.resultMap = r100;
    }

    public void setTimeout(long r100) {
        this.timeout = r100;
    }
}
