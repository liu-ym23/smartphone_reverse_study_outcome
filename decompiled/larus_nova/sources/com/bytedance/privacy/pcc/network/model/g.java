package com.bytedance.privacy.pcc.network.model;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.privacy.pcc.AppInfo;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes21.dex */
public class g {

    @SerializedName(WsConstants.KEY_PAYLOAD)
    private final String payloadBase64;

    @SerializedName("signature")
    private final String signature;

    public static class a {

        @SerializedName("app_info")
        private final C3733a appInfo;

        @SerializedName("channel_id")
        private final String channelId;

        @SerializedName("channel_ret")
        private final String channelRet;

        @SerializedName("client_version")
        private final String clientVersion;

        /* JADX INFO: renamed from: com.bytedance.privacy.pcc.network.model.g$a$a, reason: collision with other inner class name */
        public static class C3733a {

            @SerializedName("app_id")
            private final String appId;

            @SerializedName("app_svc_id")
            private final String appSvcId;

            public C3733a(String r100, String r101) {
                this.appId = r100;
                this.appSvcId = r101;
            }
        }

        public final String toString() {
            return GsonProtectorUtils.toJson(new Gson(), this);
        }

        public a(AppInfo r100, String r101) {
            this.clientVersion = "2.0.0";
            this.appInfo = new C3733a(r100.appId, r100.appSvcId);
            this.channelId = r101;
            this.channelRet = "0";
        }
    }

    public final String toString() {
        return GsonProtectorUtils.toJson(new Gson(), this);
    }

    public g(String r100, String r101) {
        this.payloadBase64 = r100;
        this.signature = r101;
    }
}
