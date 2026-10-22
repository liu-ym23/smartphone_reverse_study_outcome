package com.bytedance.mira;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class MiraParamPre {
    private IALogSupport mALogSupport;
    private boolean mEnableInitProcessOpt;
    private IHostSupport mHostSupport;

    public static class Builder {
        private IALogSupport mALogSupport;
        private boolean mEnableInitProcessOpt;
        private IHostSupport mHostSupport;

        public MiraParamPre build() {
            MiraParamPre r0 = new MiraParamPre(null);
            MiraParamPre.access$102(r0, this.mEnableInitProcessOpt);
            MiraParamPre.access$202(r0, this.mHostSupport);
            MiraParamPre.access$302(r0, this.mALogSupport);
            return r0;
        }

        public Builder() {
            this.mEnableInitProcessOpt = false;
            this.mHostSupport = null;
            this.mALogSupport = null;
        }

        public Builder withALogSupport(IALogSupport r1) {
            this.mALogSupport = r1;
            return this;
        }

        public Builder withEnableOptInitProcess(boolean r1) {
            this.mEnableInitProcessOpt = r1;
            return this;
        }

        public Builder withHostSupport(IHostSupport r1) {
            this.mHostSupport = r1;
            return this;
        }
    }

    public String toString() {
        return "MiraParamPre{, mEnableInitProcessOpt=" + this.mEnableInitProcessOpt + ", mHostSupport=" + this.mHostSupport + ", mALogSupport=" + this.mALogSupport + '}';
    }

    private MiraParamPre() {
    }

    public IALogSupport getALogSupport() {
        return this.mALogSupport;
    }

    public IHostSupport getHostSupport() {
        return this.mHostSupport;
    }

    public boolean isEnableInitProcessOpt() {
        return this.mEnableInitProcessOpt;
    }

    public /* synthetic */ MiraParamPre(1 r1) {
        this();
    }

    public static /* synthetic */ boolean access$102(MiraParamPre r0, boolean r1) {
        r0.mEnableInitProcessOpt = r1;
        return r1;
    }

    public static /* synthetic */ IHostSupport access$202(MiraParamPre r0, IHostSupport r1) {
        r0.mHostSupport = r1;
        return r1;
    }

    public static /* synthetic */ IALogSupport access$302(MiraParamPre r0, IALogSupport r1) {
        r0.mALogSupport = r1;
        return r1;
    }
}
