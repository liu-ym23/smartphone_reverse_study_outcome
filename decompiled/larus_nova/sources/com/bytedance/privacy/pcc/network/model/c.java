package com.bytedance.privacy.pcc.network.model;

import android.util.Base64;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f266702f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f266703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f266704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f266705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f266706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f266707e;

    public static class a {

        @SerializedName("evidence_detail")
        private String evidenceDetail;

        @SerializedName("evidence_extra")
        private String evidenceExtra;

        @SerializedName("evidence_token")
        private String evidenceToken;

        @SerializedName("evidence_version")
        private String evidenceVersion;

        public a() {
        }

        public final String a() {
            return this.evidenceToken;
        }
    }

    public static class b {

        @SerializedName("access_token")
        private String accessToken;

        @SerializedName("channel_expiry_time")
        private String channelExpiryTime;

        @SerializedName("channel_id")
        private String channelId;

        @SerializedName("evidence_info")
        private a evidenceInfo;

        @SerializedName("service_info")
        private C3731c serviceInfo;

        public static /* synthetic */ C3731c a(b r100) {
            return r100.serviceInfo;
        }

        public static /* synthetic */ a b(b r100) {
            return r100.evidenceInfo;
        }

        public static /* synthetic */ String c(b r100) {
            return r100.accessToken;
        }

        public static /* synthetic */ String d(b r100) {
            return r100.channelId;
        }

        public static /* synthetic */ String e(b r100) {
            return r100.channelExpiryTime;
        }

        public b(C3731c r100, a r101, String r102, String r103, String r104) {
            this.serviceInfo = r100;
            this.evidenceInfo = r101;
            this.accessToken = r102;
            this.channelId = r103;
            this.channelExpiryTime = r104;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.privacy.pcc.network.model.c$c, reason: collision with other inner class name */
    public static class C3731c {

        @SerializedName("app_id")
        private String appId;

        @SerializedName("app_svc_id")
        private String appSvcId;

        @SerializedName("app_svc_key_info")
        private d appSvcKeyInfo;

        public C3731c() {
        }

        public final d b() {
            return this.appSvcKeyInfo;
        }

        public static /* synthetic */ d a(C3731c r100) {
            return r100.appSvcKeyInfo;
        }
    }

    public static class d {

        @SerializedName("svc_key_id")
        private String svcKeyId;

        @SerializedName("svc_key_type")
        private String svcKeyType;

        @SerializedName("svc_key_version")
        private String svcKeyVersion;

        @SerializedName("svc_pub_key")
        private String svcPubKey;

        public d() {
        }

        public final String a() {
            return this.svcKeyId;
        }

        public final String b() {
            return this.svcKeyType;
        }

        public final String c() {
            return this.svcKeyVersion;
        }

        public final String d() {
            return this.svcPubKey;
        }
    }

    static {
        f266702f = c.class.getSimpleName();
    }

    public final a b() {
        b r100 = this.f266703a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return b.b(r100);
    }

    public final C3731c c() {
        b r100 = this.f266703a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return b.a(r100);
    }

    public static c d(String r100, String r101) throws Exception {
        JsonObject r102 = JsonParser.parseString(r100).getAsJsonObject();
        int r103 = r102.get("code").getAsInt();
        if (r103 != 0) goto L19;
        JsonObject r104 = r102.getAsJsonObject("data");
        String r105 = r104.get(WsConstants.KEY_PAYLOAD).getAsString();
        String r106 = new String(Base64.decode(r105, 0), StandardCharsets.UTF_8);
        String r107 = f266702f;
        k67.b.e(r107, "CreateChannelResponse payload JSON: ".concat(r106));
        b r108 = (b) GsonProtectorUtils.fromJson(new Gson(), r106, b.class);
        if (b.a(r108) != null) goto L7;
    L13:
        String r109 = k67.b.d(r107);
        c67.b r110 = k67.b.f501968a;
        if (r110 == null) goto L17;
        r110.w(r109, "CreateChannelResponse: serviceInfo or appSvcKeyInfo is null");
    L17:
        return new c(r108, r105, r101, r104.get("signature").getAsString(), 2);
    L7:
        if (C3731c.a(b.a(r108)) == null) goto L13;
        d r111 = C3731c.a(b.a(r108));
        StringBuilder r112 = new StringBuilder("CreateChannelResponse SvcKeyInfo: keyId=");
        r112.append(r111.a());
        r112.append(", keyType=");
        r112.append(r111.b());
        r112.append(", keyVer=");
        r112.append(r111.c());
        r112.append(", pubKey=");
        if (r111.d() == null) goto L11;
        String r113 = "present(len=" + r111.d().length() + ")";
    L12:
        r112.append(r113);
        k67.b.e(r107, r112.toString());
        goto L17
    L11:
        r113 = "null";
        goto L12
    L19:
        throw new Exception("unexpected server code=" + r103);
    }

    public c(b r100, String r101, String r102, String r103, int r104) {
        this.f266703a = r100;
        this.f266704b = r101;
        this.f266705c = r102;
        this.f266706d = r103;
        this.f266707e = r104;
    }

    public static c a(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, int r210) {
        a r100 = null;
        if (r110 != null) goto L5;
    L7:
        C3731c r101 = null;
    L8:
        if (r111 == null) goto L13;
        if (r111.isEmpty() == true) goto L13;
        r100 = (a) GsonProtectorUtils.fromJson(new Gson(), r111, a.class);
    L13:
        return new c(new b(r101, r100, r112, r113, r114), r115, r116, r117, r210);
    L5:
        if (r110.isEmpty() == true) goto L7;
        r101 = (C3731c) GsonProtectorUtils.fromJson(new Gson(), r110, C3731c.class);
        goto L8
    }
}
