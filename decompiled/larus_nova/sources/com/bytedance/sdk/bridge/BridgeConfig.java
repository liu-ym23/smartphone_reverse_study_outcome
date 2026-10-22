package com.bytedance.sdk.bridge;

import android.content.Context;

/* JADX INFO: loaded from: classes22.dex */
public class BridgeConfig {
    private Context application;
    private String authHost;
    private uc7.a bridgeMonitorInterceptor;
    private Boolean ignoreNameSpace;
    private Boolean isCompatiblePreLoadWebview;
    private Boolean isDebug;
    private Boolean jsCallSuccessCostEnable;
    private boolean safeGetUrl;
    private String schema;

    public static class Builder {
        private Context application;
        private String authHost;
        private uc7.a bridgeMonitorInterceptor;
        private Boolean ignoreNameSpace;
        private Boolean isCompatiblePreLoadWebview;
        private Boolean isDebug;
        private Boolean jsCallSuccessCostEnable;
        private boolean safeGetUrl;
        private String schema;

        public Builder bridgeMonitorInterceptor(uc7.a r100) {
            return this;
        }

        public BridgeConfig build() {
            return new BridgeConfig(this.isDebug, this.schema, this.ignoreNameSpace, this.jsCallSuccessCostEnable, this.isCompatiblePreLoadWebview, null, this.safeGetUrl, this.authHost, this.application, null);
        }

        public Builder() {
            this.ignoreNameSpace = Boolean.TRUE;
            this.authHost = "https://ib.snssdk.com";
        }

        public Builder isCompatiblePreLoadWebview(Boolean r100) {
            this.isCompatiblePreLoadWebview = r100;
            return this;
        }

        public Builder isDebug(Boolean r100) {
            this.isDebug = r100;
            return this;
        }

        public Builder jsCallSuccessCostEnable(Boolean r100) {
            this.jsCallSuccessCostEnable = r100;
            return this;
        }

        public Builder safeGetUrl(boolean r100) {
            this.safeGetUrl = r100;
            return this;
        }

        public Builder setApplication(Context r100) {
            this.application = r100;
            return this;
        }

        public Builder setAuthConfigHost(String r100) {
            this.authHost = r100;
            return this;
        }

        public Builder setIgnoreNameSpace(Boolean r100) {
            this.ignoreNameSpace = r100;
            return this;
        }

        public Builder setSchema(String r100) {
            this.schema = r100;
            return this;
        }
    }

    public static /* synthetic */ class a {
    }

    public uc7.a getBridgeMonitorInterceptor() {
        return null;
    }

    public Boolean isCompatiblePreLoadWebview() {
        Boolean r100 = this.isCompatiblePreLoadWebview;
        if (r100 != null) goto L5;
        boolean r101 = false;
    L7:
        return Boolean.valueOf(r101);
    L5:
        r101 = r100.booleanValue();
        goto L7
    }

    public Boolean isDebug() {
        Boolean r100 = this.isDebug;
        if (r100 != null) goto L5;
        boolean r101 = false;
    L7:
        return Boolean.valueOf(r101);
    L5:
        r101 = r100.booleanValue();
        goto L7
    }

    public Boolean isIgnoreNameSpace() {
        Boolean r100 = this.ignoreNameSpace;
        if (r100 != null) goto L5;
        boolean r101 = false;
    L7:
        return Boolean.valueOf(r101);
    L5:
        r101 = r100.booleanValue();
        goto L7
    }

    public Boolean jsCallSuccessCostEnable() {
        Boolean r100 = this.jsCallSuccessCostEnable;
        if (r100 != null) goto L5;
        boolean r101 = false;
    L7:
        return Boolean.valueOf(r101);
    L5:
        r101 = r100.booleanValue();
        goto L7
    }

    public Context getApplication() {
        return this.application;
    }

    public String getAuthHost() {
        return this.authHost;
    }

    public String getSchema() {
        return this.schema;
    }

    public boolean safeGetUrl() {
        return this.safeGetUrl;
    }

    private BridgeConfig(Boolean r100, String r101, Boolean r102, Boolean r103, Boolean r104, uc7.a r105, boolean r106, String r107, Context r108) {
        this.isDebug = r100;
        this.schema = r101;
        this.ignoreNameSpace = r102;
        this.jsCallSuccessCostEnable = r103;
        this.isCompatiblePreLoadWebview = r104;
        this.application = r108;
        this.authHost = r107;
        this.safeGetUrl = r106;
    }

    public /* synthetic */ BridgeConfig(Boolean r100, String r101, Boolean r102, Boolean r103, Boolean r104, uc7.a r105, boolean r106, String r107, Context r108, a r110) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }
}
