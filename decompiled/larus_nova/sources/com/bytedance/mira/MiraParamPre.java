package com.bytedance.mira;

/* JADX INFO: loaded from: classes.dex */
public class MiraParamPre {
    private IALogSupport mALogSupport;
    private boolean mEnableInitProcessOpt;
    private IHostSupport mHostSupport;

    /* JADX INFO: renamed from: com.bytedance.mira.MiraParamPre$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes21.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private IALogSupport mALogSupport;
        private boolean mEnableInitProcessOpt;
        private IHostSupport mHostSupport;

        public MiraParamPre build() {
            MiraParamPre r100 = new MiraParamPre(null);
            MiraParamPre.access$102(r100, this.mEnableInitProcessOpt);
            MiraParamPre.access$202(r100, this.mHostSupport);
            MiraParamPre.access$302(r100, this.mALogSupport);
            return r100;
        }

        public Builder() {
            this.mEnableInitProcessOpt = false;
            this.mHostSupport = null;
            this.mALogSupport = null;
        }

        public Builder withALogSupport(IALogSupport r100) {
            this.mALogSupport = r100;
            return this;
        }

        public Builder withEnableOptInitProcess(boolean r100) {
            this.mEnableInitProcessOpt = r100;
            return this;
        }

        public Builder withHostSupport(IHostSupport r100) {
            this.mHostSupport = r100;
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

    public /* synthetic */ MiraParamPre(AnonymousClass1 r100) {
        this();
    }

    public static /* synthetic */ boolean access$102(MiraParamPre r100, boolean r101) {
        r100.mEnableInitProcessOpt = r101;
        return r101;
    }

    public static /* synthetic */ IHostSupport access$202(MiraParamPre r100, IHostSupport r101) {
        r100.mHostSupport = r101;
        return r101;
    }

    public static /* synthetic */ IALogSupport access$302(MiraParamPre r100, IALogSupport r101) {
        r100.mALogSupport = r101;
        return r101;
    }
}
