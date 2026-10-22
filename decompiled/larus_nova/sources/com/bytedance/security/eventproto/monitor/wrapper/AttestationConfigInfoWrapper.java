package com.bytedance.security.eventproto.monitor.wrapper;

/* JADX INFO: loaded from: classes6.dex */
public class AttestationConfigInfoWrapper {
    private Boolean addCustomInfo;
    private Boolean devHealthStatusRequired;
    private Boolean reqRpdid;
    private Boolean reqRpuid;
    private Boolean reqUdid;

    /* JADX INFO: renamed from: com.bytedance.security.eventproto.monitor.wrapper.AttestationConfigInfoWrapper$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes22.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private final AttestationConfigInfoWrapper wrap;

        public Builder() {
            this.wrap = new AttestationConfigInfoWrapper(null);
        }

        public AttestationConfigInfoWrapper build() {
            return this.wrap;
        }

        public Builder setAddCustomInfo(boolean r100) {
            AttestationConfigInfoWrapper.access$402(this.wrap, Boolean.valueOf(r100));
            return this;
        }

        public Builder setDevHealthStatusRequired(boolean r100) {
            AttestationConfigInfoWrapper.access$502(this.wrap, Boolean.valueOf(r100));
            return this;
        }

        public Builder setReqRpdid(boolean r100) {
            AttestationConfigInfoWrapper.access$202(this.wrap, Boolean.valueOf(r100));
            return this;
        }

        public Builder setReqRpuid(boolean r100) {
            AttestationConfigInfoWrapper.access$302(this.wrap, Boolean.valueOf(r100));
            return this;
        }

        public Builder setReqUdid(boolean r100) {
            AttestationConfigInfoWrapper.access$102(this.wrap, Boolean.valueOf(r100));
            return this;
        }
    }

    private AttestationConfigInfoWrapper() {
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Boolean getAddCustomInfo() {
        return this.addCustomInfo;
    }

    public Boolean getDevHealthStatusRequired() {
        return this.devHealthStatusRequired;
    }

    public Boolean getReqRpdid() {
        return this.reqRpdid;
    }

    public Boolean getReqRpuid() {
        return this.reqRpuid;
    }

    public Boolean getReqUdid() {
        return this.reqUdid;
    }

    public /* synthetic */ AttestationConfigInfoWrapper(AnonymousClass1 r100) {
        this();
    }

    public static /* synthetic */ Boolean access$102(AttestationConfigInfoWrapper r100, Boolean r101) {
        r100.reqUdid = r101;
        return r101;
    }

    public static /* synthetic */ Boolean access$202(AttestationConfigInfoWrapper r100, Boolean r101) {
        r100.reqRpdid = r101;
        return r101;
    }

    public static /* synthetic */ Boolean access$302(AttestationConfigInfoWrapper r100, Boolean r101) {
        r100.reqRpuid = r101;
        return r101;
    }

    public static /* synthetic */ Boolean access$402(AttestationConfigInfoWrapper r100, Boolean r101) {
        r100.addCustomInfo = r101;
        return r101;
    }

    public static /* synthetic */ Boolean access$502(AttestationConfigInfoWrapper r100, Boolean r101) {
        r100.devHealthStatusRequired = r101;
        return r101;
    }
}
