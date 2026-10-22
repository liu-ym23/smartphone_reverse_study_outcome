package com.bytedance.privacy.pcc.network.model;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.privacy.pcc.AppInfo;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes21.dex */
public class b {

    @SerializedName("att_cert_chain")
    private final String attCertChain;

    @SerializedName(WsConstants.KEY_PAYLOAD)
    private final String payload;

    @SerializedName("signature")
    private final String signature;

    public static class a {

        @SerializedName("app_info")
        private final C3730a appInfo;

        @SerializedName("client_nonce")
        private final String clientNonce;

        @SerializedName("client_version")
        private final String clientVersion;

        /* JADX INFO: renamed from: com.bytedance.privacy.pcc.network.model.b$a$a, reason: collision with other inner class name */
        public static class C3730a {

            @SerializedName("app_id")
            private final String appId;

            @SerializedName("app_svc_id")
            private final String appSvcId;

            public C3730a(String r100, String r101) {
                this.appId = r100;
                this.appSvcId = r101;
            }
        }

        public final String toString() {
            return GsonProtectorUtils.toJson(new GsonBuilder().disableHtmlEscaping().create(), this);
        }

        public a(String r100, AppInfo r101) {
            this.clientVersion = "2.0.0";
            this.clientNonce = r100;
            this.appInfo = new C3730a(r101.appId, r101.appSvcId);
        }
    }

    public final String toString() {
        return GsonProtectorUtils.toJson(new GsonBuilder().disableHtmlEscaping().create(), this);
    }

    public b(String r100, String r101, String r102) {
        this.attCertChain = r100;
        this.payload = r101;
        this.signature = r102;
    }
}
