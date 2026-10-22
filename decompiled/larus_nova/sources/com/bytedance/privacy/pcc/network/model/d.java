package com.bytedance.privacy.pcc.network.model;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes21.dex */
public class d {

    @SerializedName("att_cert_chain")
    private final String attCertChain;

    @SerializedName(WsConstants.KEY_PAYLOAD)
    private final String payload;

    @SerializedName("signature")
    private final String signature;

    public static class a {

        @SerializedName("app_info")
        private final C3732a appInfo;

        @SerializedName("client_version")
        private final String clientVersion;

        @SerializedName("time_begin")
        private final long timeBegin;

        @SerializedName("time_end")
        private final long timeEnd;

        /* JADX INFO: renamed from: com.bytedance.privacy.pcc.network.model.d$a$a, reason: collision with other inner class name */
        public static class C3732a {

            @SerializedName("app_id")
            private final String appId;

            @SerializedName("app_svc_id")
            private final String appSvcId;
        }

        public final String toString() {
            return GsonProtectorUtils.toJson(new GsonBuilder().disableHtmlEscaping().create(), this);
        }
    }

    public final String toString() {
        return GsonProtectorUtils.toJson(new GsonBuilder().disableHtmlEscaping().create(), this);
    }
}
