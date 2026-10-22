package com.bytedance.bdp.appbase.request.contextservice.entity.http;

import com.alipay.sdk.m.u.i;
import com.bytedance.bdp.appbase.network.BdpFromSource;
import com.bytedance.bdp.appbase.network.IBdpNetCall;
import com.bytedance.bdp.appbase.request.contextservice.entity.RequestData;
import com.bytedance.bdp.appbase.request.contextservice.entity.RequestHeaders;
import com.bytedance.bdp.serviceapi.defaults.network.BdpRequest;

/* JADX INFO: loaded from: classes11.dex */
public final class HttpRequestTask {
    public static final int CANCEL = 1;
    public static final int FINISH = 2;
    public static final int INITED = 0;
    private IBdpNetCall call;
    private final ExtraParam extraParam;
    public final RequestHeaders header;
    public final String method;
    public final String prefetchId;
    public final String reqRuntimeType;
    public final RequestData requestData;
    public final String responseType;
    private int status;
    public final int taskId;
    public final String url;

    public static final class ExtraParam {
        public static final ExtraParam DEFAULT = null;
        public Long allowMaxFileSize;
        public final boolean appendHostCookie;
        public final boolean enableCache;
        public final String fromSource;
        public String innerMiniAppHostCookie;
        public final boolean isDeveloperRequest;
        public Long timeout;
        public final boolean useCloud;
        public final boolean useDouyinCloud;
        public final boolean usePrefetchCache;
        public final boolean useTTNetWithHostParams;
        public final boolean withCommonParams;
        public final boolean withHttpDns;
        public final boolean withRequestEncrypt;

        public static final class Builder {
            private Long allowMaxFileSize;
            private boolean appendHostCookie;
            private boolean enableCache;
            private String fromSource;
            private boolean isDeveloperRequest;
            private Long timeout;
            private boolean useCloud;
            private boolean useDouyinCloud;
            private boolean usePrefetchCache;
            private boolean useTTNetWithHostParams;
            private boolean withCommonParams;
            private boolean withHttpDns;
            private boolean withRequestEncrypt;

            public static Builder create() {
                return new Builder();
            }

            public ExtraParam build() {
                return new ExtraParam(this.isDeveloperRequest, this.usePrefetchCache, this.useCloud, this.useDouyinCloud, this.withCommonParams, this.withHttpDns, this.appendHostCookie, this.useTTNetWithHostParams, this.withRequestEncrypt, this.timeout, this.enableCache, this.fromSource, this.allowMaxFileSize);
            }

            public Builder() {
                this.isDeveloperRequest = false;
                this.allowMaxFileSize = Long.MAX_VALUE;
            }

            public Builder allowMaxFileSize(Long r100) {
                this.allowMaxFileSize = r100;
                return this;
            }

            public Builder appendHostCookie(boolean r100) {
                this.appendHostCookie = r100;
                return this;
            }

            public Builder enableCache(boolean r100) {
                this.enableCache = r100;
                return this;
            }

            public Builder fromSource(BdpFromSource r100) {
                this.fromSource = r100.getFrom();
                return this;
            }

            public Builder isDeveloperRequest(boolean r100) {
                this.isDeveloperRequest = r100;
                return this;
            }

            public Builder timeout(Long r100) {
                this.timeout = r100;
                return this;
            }

            public Builder useCloud(boolean r100) {
                this.useCloud = r100;
                return this;
            }

            public Builder useDouyinCloud(boolean r100) {
                this.useDouyinCloud = r100;
                return this;
            }

            public Builder usePrefetchCache(boolean r100) {
                this.usePrefetchCache = r100;
                return this;
            }

            public Builder useTTNetWithHostParams(boolean r100) {
                this.useTTNetWithHostParams = r100;
                return this;
            }

            public Builder withCommonParams(boolean r100) {
                this.withCommonParams = r100;
                return this;
            }

            public Builder withHttpDns(boolean r100) {
                this.withHttpDns = r100;
                return this;
            }

            public Builder withRequestEncrypt(boolean r100) {
                this.withRequestEncrypt = r100;
                return this;
            }
        }

        static {
            DEFAULT = new ExtraParam(false, false, false, false, false, false, true, false, false, -1L, true, BdpRequest.FromSource.empty.getValue(), Long.MAX_VALUE);
        }

        public String toString() {
            return "{isDeveloperRequest: " + this.isDeveloperRequest + ", usePrefetchCache: " + this.usePrefetchCache + ", appendHostCookie: " + this.appendHostCookie + ", useCloud: " + this.useCloud + ", withCommonParams: " + this.withCommonParams + ", withHttpDns: " + this.withHttpDns + ", useTTNetWithHostParams: " + this.useTTNetWithHostParams + ", timeout: " + this.timeout + ", enableCache: " + this.enableCache + ", from: " + this.fromSource + ", allowMaxFileSize: " + this.allowMaxFileSize + i.f25855d;
        }

        public ExtraParam(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107, boolean r110, Long r111, boolean r112, String r113, Long r114) {
            this.innerMiniAppHostCookie = "";
            this.isDeveloperRequest = r100;
            this.usePrefetchCache = r101;
            this.useCloud = r102;
            this.useDouyinCloud = r103;
            this.withCommonParams = r104;
            this.withHttpDns = r105;
            this.appendHostCookie = r106;
            this.useTTNetWithHostParams = r107;
            this.withRequestEncrypt = r110;
            this.timeout = r111;
            this.enableCache = r112;
            this.fromSource = r113;
            this.allowMaxFileSize = r114;
        }
    }

    public boolean cancel() {
        if (this.status == 0) goto L6;
        return false;
    L6:
        this.status = 1;
        IBdpNetCall r100 = this.call;
        if (r100 == null) goto L9;
        r100.cancel();
    L9:
        return true;
    }

    public boolean finish() {
        if (this.status == 0) goto L6;
        return false;
    L6:
        this.status = 2;
        return true;
    }

    public final ExtraParam getExtraParam() {
        ExtraParam r100 = this.extraParam;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return ExtraParam.DEFAULT;
    }

    public boolean isCancel() {
        if (this.status == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        return "{taskId: " + this.taskId + ", url: " + this.url + ", method: " + this.method + ", data: " + this.requestData + ", header: " + this.header + ", responseType: " + this.responseType + ", extraParam: " + this.extraParam + '}';
    }

    public void setCall(IBdpNetCall r100) {
        this.call = r100;
    }

    public HttpRequestTask(int r100, String r101, String r102, String r103, RequestHeaders r104, RequestData r105, ExtraParam r106, String r107, String r110) {
        this.status = 0;
        this.call = null;
        this.taskId = r100;
        this.url = r101;
        this.method = r102;
        this.responseType = r103;
        if (r104 != null) goto L5;
        this.header = new RequestHeaders();
    L6:
        this.requestData = r105;
        this.extraParam = r106;
        this.prefetchId = r107;
        this.reqRuntimeType = r110;
        return;
    L5:
        this.header = r104;
        goto L6
    }
}
