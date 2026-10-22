package com.bytedance.ee.bear.middleground.permission.dlp.model;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
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

            public CheckTime(Policy r100) {
                this.this$1 = r100;
                this.DLPCheckTime = 900;
            }

            public void setDLPCheckTime(int r100) {
                this.DLPCheckTime = r100;
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

        public Policy(DlpPolicyModel r100) {
            this.this$0 = r100;
            this.res = false;
            this.dlpUpdateTime = 0;
        }

        public void setDlpUpdateTime(long r100) {
            this.dlpUpdateTime = r100;
        }

        public void setRes(boolean r100) {
            this.res = r100;
        }

        public void setSetting(CheckTime r100) {
            this.setting = r100;
        }

        public void setTimeout(long r100) {
            this.timeout = r100;
        }
    }

    public DlpPolicyModel() {
    }

    public Policy getPolicy() {
        return this.policy;
    }

    public void setPolicy(Policy r100) {
        this.policy = r100;
    }
}
