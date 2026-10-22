package com.bytedance.privacy.pcc;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.sdk.account.platform.api.ITaptapService;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.miui.easygo.constant.EasyGoConstant;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes21.dex */
public final class EvidenceTokenVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f266687a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f266688b = null;

    public EvidenceTokenVerifier() {
    }

    static {
        f266687a = EvidenceTokenVerifier.class.getSimpleName();
        f266688b = new AnonymousClass1();
    }

    public static byte[] a(byte[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= (r100.length - 1)) goto L9;
        if (r100[r101] != 0) goto L9;
        r101 = r101 + 1;
    L9:
        if ((r100[r101] & ByteCompanionObject.MIN_VALUE) == 0) goto L13;
        byte[] r102 = new byte[(r100.length - r101) + 1];
        System.arraycopy(r100, r101, r102, 1, r100.length - r101);
        return r102;
    L13:
        return Arrays.copyOfRange(r100, r101, r100.length);
    }

    public static void b(String r210, String r211, String r212, String r213, String r214, com.bytedance.privacy.pcc.network.model.c.d r215) throws Exception {
        if (e67.b.a().b() == false) goto L5;
        String r100 = "boe";
    L6:
        String r101 = f266687a;
        k67.b.a(r101, "verify: start V2 JWT evidence token verification (env=" + r100 + ")");
        String[] r102 = r210.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r102.length != 3) goto L183;
        String r103 = r102[0];
        String r110 = r102[1];
        String r104 = r102[2];
        String r111 = new String(Base64.decode(r103, 11), StandardCharsets.UTF_8);
        k67.b.a(r101, "header: ".concat(r111));
        JsonObject r112 = JsonParser.parseString(r111).getAsJsonObject();
        if (r112.has("typ") == false) goto L11;
        String r113 = r112.get("typ").getAsString();
    L13:
        if ("JWT".equals(r113) == false) goto L181;
        if (r112.has("alg") == false) goto L17;
        String r114 = r112.get("alg").getAsString();
    L19:
        if ("ES256".equals(r114) == false) goto L179;
        if (r112.has("ver") == false) goto L23;
        int r105 = r112.get("ver").getAsInt();
    L25:
        if (r105 != 1100) goto L177;
        if (r112.has(ITaptapService.ResponseConstants.KID) == false) goto L175;
        String r115 = r112.get(ITaptapService.ResponseConstants.KID).getAsString();
        k67.b.a(r101, "verify: header parsed (typ=" + r113 + " alg=" + r114 + " ver=" + r105 + " kid=" + r115 + ")");
        String r116 = new String(Base64.decode(r110, 11), StandardCharsets.UTF_8);
        k67.b.a(r101, "payload: ".concat(r116));
        JsonObject r106 = JsonParser.parseString(r116).getAsJsonObject();
        k67.b.a(r101, "verify: payload parsed successfully");
        if (r106.has("iss") == false) goto L173;
        String r117 = r106.get("iss").getAsString();
        k67.b.e(r101, "verify: iss=" + r117);
        if ("TKMS-Auth-Center-TEE".equals(r117) == false) goto L33;
    L37:
        String r107 = r100 + "_" + r117 + "_" + r115;
        k67.b.a(r101, "verify: looking up key: " + r107);
        HashMap r118 = (HashMap) f266688b;
        if (r118.containsKey(r107) == false) goto L171;
        PublicKey r108 = KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePublic(new X509EncodedKeySpec(Base64.decode(((String) r118.get(r107)).replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replace("\n", "").replace("\r", "").trim(), 0)));     // Catch: Exception -> L42
    L44:
        if (r108 == null) goto L169;
        k67.b.a(r101, "verify: public key obtained for " + r107);
        byte[] r109 = Base64.decode(r104, 11);
        int r119 = r109.length / 2;
        byte[] r120 = a(Arrays.copyOfRange(r109, 0, r119));
        byte[] r121 = a(Arrays.copyOfRange(r109, r119, r109.length));
        int r122 = ((r120.length + 2) + 2) + r121.length;
        byte[] r123 = new byte[r122 + 2];
        r123[0] = 48;
        r123[1] = (byte) r122;
        r123[2] = 2;
        r123[3] = (byte) r120.length;
        System.arraycopy(r120, 0, r123, 4, r120.length);
        int r124 = r120.length + 4;
        int r125 = r124 + 1;
        r123[r124] = 2;
        r123[r125] = (byte) r121.length;
        int r126 = 0;
        System.arraycopy(r121, 0, r123, r125 + 1, r121.length);
        byte[] r127 = (r103 + "." + r110).getBytes(StandardCharsets.UTF_8);
        Signature r128 = Signature.getInstance("SHA256withECDSA");
        r128.initVerify(r108);
        r128.update(r127);
        if (r128.verify(r123) == false) goto L167;
        k67.b.a(r101, "verify: JWT signature valid");
        long r129 = System.currentTimeMillis() / 1000;
        if (r106.has("nbf") == false) goto L55;
        long r130 = r106.get("nbf").getAsLong();
        if (r129 >= r130) goto L55;
        throw new Exception("JWT not yet valid: nbf=" + r130 + " now=" + r129);
    L55:
        if (r106.has(OnekeyLoginConstants.CU_KEY_TOKEN_EXPIRES) == false) goto L61;
        long r131 = r106.get(OnekeyLoginConstants.CU_KEY_TOKEN_EXPIRES).getAsLong();
        if (r129 <= r131) goto L61;
        throw new Exception("JWT expired: exp=" + r131 + " now=" + r129);
    L61:
        k67.b.a(r101, "verify: time validation OK (now=" + r129 + ")");
        if (r106.has("service_id") == false) goto L165;
        String r132 = r106.get("service_id").getAsString();
        if (r132.equals(r212) == true) goto L71;
        String r133 = "service_id mismatch: expected=" + r212 + " got=" + r132;
        String r134 = k67.b.d(r101);
        c67.b r135 = k67.b.f501968a;
        if (r135 == null) goto L68;
        r135.w(r134, r133);
    L68:
        String r136 = k67.b.d(r101);
        c67.b r137 = k67.b.f501968a;
        if (r137 == null) goto L71;
        r137.w(r136, "verify: service_id validation skipped (known issue in current server implementation)");
    L71:
        k67.b.e(r101, "verify: service_id=" + r132 + " (expected appSvcId=" + r212 + ")");
        MessageDigest r138 = MessageDigest.getInstance("SHA-256");
        r138.update(r211.getBytes(StandardCharsets.UTF_8));
        r138.update(r212.getBytes(StandardCharsets.UTF_8));
        r138.update(r213.getBytes(StandardCharsets.UTF_8));
        r138.update(r214.getBytes(StandardCharsets.UTF_8));
        if (r215 != null) goto L74;
    L82:
        String r139 = a.e(r138.digest());
        String r140 = a.e(r139.getBytes(StandardCharsets.UTF_8));
        k67.b.a(r101, "reportData (raw hex, 32B): ".concat(r139));
        k67.b.a(r101, "reportData (hex-of-hex, 128 hex chars): " + r140);
        if ("TKMS-Auth-Center".equals(r117) == false) goto L114;
        k67.b.e(r101, "verify: Non-TEE cluster, verifying extra fields");
        if (r106.has("extra") == false) goto L112;
        JsonObject r141 = r106.getAsJsonObject("extra");
        k67.b.a(r101, "verify: extra object: " + r141.toString());
        k67.b.a(r101, "verify: extra fields: " + r141.keySet());
        if (r141.has("app_id") == false) goto L110;
        String r142 = r141.get("app_id").getAsString();
        k67.b.a(r101, "verify: extra.app_id=" + r142 + " (expected=" + r211 + ")");
        if (r142.equals(r211) == false) goto L108;
        k67.b.e(r101, "verify: extra.app_id match OK");
        if (r141.has("svc_id") == false) goto L106;
        String r143 = r141.get("svc_id").getAsString();
        k67.b.a(r101, "verify: extra.svc_id=" + r143 + " (expected=" + r212 + ")");
        if (r143.equals(r212) == false) goto L104;
        k67.b.e(r101, "verify: extra.svc_id match OK");
        if (r141.has("user_data") == false) goto L102;
        String r144 = r141.get("user_data").getAsString();
        k67.b.a(r101, "verify: extra.user_data=" + r144);
        k67.b.a(r101, "verify: expected user_data=" + r140);
        if (TextUtils.equals(r140, r144) == false) goto L100;
        k67.b.e(r101, "verify: extra.user_data match OK");
    L162:
        k67.b.e(r101, "verify: V2 JWT evidence token verification completed successfully");
        return;
    L100:
        throw new Exception("extra.user_data mismatch: expected=" + r140 + " got=" + r144);
    L102:
        throw new Exception("JWT extra missing 'user_data' field");
    L104:
        throw new Exception("extra.svc_id mismatch: expected=" + r212 + " got=" + r143);
    L106:
        throw new Exception("JWT extra missing 'svc_id' field");
    L108:
        throw new Exception("extra.app_id mismatch: expected=" + r211 + " got=" + r142);
    L110:
        throw new Exception("JWT extra missing 'app_id' field");
    L112:
        throw new Exception("JWT payload missing 'extra' field for Non-TEE issuer");
    L114:
        if ("TKMS-Auth-Center-TEE".equals(r117) == false) goto L162;
        k67.b.e(r101, "verify: TEE cluster, verifying tdx fields");
        if (r106.has("tdx") == false) goto L161;
        JsonObject r145 = r106.getAsJsonObject("tdx");
        k67.b.a(r101, "verify: tdx object: " + r145.toString());
        if (r145.has("quote") == false) goto L135;
        JsonObject r146 = r145.getAsJsonObject("quote");
        if (r146 == null) goto L135;
        if (r146.isJsonNull() == true) goto L135;
        if (r146.has(ContainerPosition.BODY) == false) goto L135;
        JsonObject r147 = r146.getAsJsonObject(ContainerPosition.BODY);
        if (r147 == null) goto L135;
        if (r147.isJsonNull() == true) goto L135;
        if (r147.has("reportdata") == false) goto L133;
        String r148 = r147.get("reportdata").getAsString();
        String r149 = "tdx.quote.body.reportdata";
    L136:
        if (r148 == null) goto L138;
    L140:
        StringBuilder r150 = new StringBuilder("verify: report_data source=");
        r150.append(r149);
        r150.append(", value='");
        r150.append(r148);
        r150.append("' (len=");
        if (r148 == null) goto L143;
        r126 = r148.length();
    L143:
        r150.append(r126);
        r150.append(")");
        k67.b.e(r101, r150.toString());
        if (r148 != null) goto L146;
    L155:
        if (r148 != null) goto L157;
        String r151 = "field is null";
    L159:
        throw new Exception("JWT tdx.report_data missing or empty (" + r151 + ") for TEE issuer");
    L157:
        r151 = "field is empty string";
        goto L159
    L146:
        if (r148.isEmpty() == true) goto L155;
        k67.b.a(r101, "tdx.report_data (from JWT, len=" + r148.length() + "): " + r148);
        if (TextUtils.equals(r140, r148) == false) goto L154;
        k67.b.e(r101, "verify: tdx.report_data match OK");
        if (r145.has("dcap_verify_result") == false) goto L162;
        k67.b.e(r101, "verify: tdx.dcap_verify_result=" + r145.get("dcap_verify_result").getAsString());
        goto L162
    L154:
        throw new Exception("tdx.report_data mismatch: expected=" + r140 + " got=" + r148);
    L138:
        if (r145.has("report_data") == false) goto L140;
        r148 = r145.get("report_data").getAsString();
        r149 = "tdx.report_data";
        goto L140
    L133:
        if (r147.has("report_data") == false) goto L135;
        r148 = r147.get("report_data").getAsString();
        r149 = "tdx.quote.body.report_data";
    L135:
        r149 = null;
        r148 = null;
        goto L136
    L161:
        throw new Exception("JWT payload missing 'tdx' field for TEE issuer");
    L74:
        if (r215.a() == null) goto L77;
        r138.update(r215.a().getBytes(StandardCharsets.UTF_8));
    L77:
        if (r215.c() == null) goto L80;
        r138.update(r215.c().getBytes(StandardCharsets.UTF_8));
    L80:
        if (r215.d() == null) goto L82;
        r138.update(r215.d().getBytes(StandardCharsets.UTF_8));
        goto L82
    L165:
        throw new Exception("JWT payload missing 'service_id' field");
    L167:
        throw new Exception("JWT ECDSA signature verification failed");
    L169:
        throw new Exception("failed to parse public key for: " + r107);
    L42:
        e = move-exception;
        k67.b.c(r101, "pemStringToPublicKey failed: " + e.getMessage());
        r108 = null;
        goto L44
    L171:
        throw new Exception("public key not found for: env=" + r100 + " iss=" + r117 + " kid=" + r115 + " (key=" + r107 + ")");
    L33:
        if ("TKMS-Auth-Center".equals(r117) == true) goto L37;
        throw new Exception("unknown issuer: '" + r117 + "', expected TKMS-Auth-Center-TEE or TKMS-Auth-Center");
    L173:
        throw new Exception("JWT payload missing 'iss' field");
    L175:
        throw new Exception("JWT header missing 'kid' field");
    L177:
        throw new Exception("unsupported JWT ver: " + r105 + ", expected 1100");
    L23:
        r105 = 0;
        goto L25
    L179:
        throw new Exception("unsupported JWT alg: '" + r114 + "', expected ES256");
    L17:
        r114 = "";
        goto L19
    L181:
        throw new Exception("invalid JWT typ: '" + r113 + "', expected JWT");
    L11:
        r113 = "";
        goto L13
    L183:
        throw new Exception("invalid JWT format: expected 3 parts, got " + r102.length);
    L5:
        r100 = "prod";
        goto L6
    }
}
