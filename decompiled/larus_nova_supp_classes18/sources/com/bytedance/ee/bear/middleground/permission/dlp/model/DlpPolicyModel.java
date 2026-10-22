package com.bytedance.ee.bear.middleground.permission.dlp.model;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DlpPolicyModel extends Result implements NonProguard {
    private Policy policy;

    public class Policy implements NonProguard {
        private long dlpUpdateTime;
        private boolean res;
        private CheckTime setting;
        final /* synthetic */ DlpPolicyModel this$0;
        private long timeout;

        public class CheckTime implements NonProguard {
            private int DLPCheckTime;
            final /* synthetic */ Policy this$1;

            public int getDLPCheckTime() {
                return this.DLPCheckTime;
            }

            public CheckTime(Policy r1) {
                this.this$1 = r1;
                this.DLPCheckTime = 900;
            }

            public void setDLPCheckTime(int r1) {
                this.DLPCheckTime = r1;
            }
        }

        public long getDlpUpdateTime() {
            return this.dlpUpdateTime;
        }

        public CheckTime getSetting() {
            return this.setting;
        }

        public long getTimeout() {
            return this.timeout;
        }

        public boolean isRes() {
            return this.res;
        }

        public Policy(DlpPolicyModel r3) {
            this.this$0 = r3;
            this.res = false;
            this.dlpUpdateTime = 0;
        }

        public void setDlpUpdateTime(long r1) {
            this.dlpUpdateTime = r1;
        }

        public void setRes(boolean r1) {
            this.res = r1;
        }

        public void setSetting(CheckTime r1) {
            this.setting = r1;
        }

        public void setTimeout(long r1) {
            this.timeout = r1;
        }
    }

    public DlpPolicyModel() {
    }

    public Policy getPolicy() {
        return this.policy;
    }

    public void setPolicy(Policy r1) {
        this.policy = r1;
    }
}
