package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class w0 {
    private static void a(String r100, String r101) {
        j1 r102 = new j1(r100, r101);
        b0.a().a(r102);
    }

    public static boolean a() {
        String r100 = q0.a();
        if (TextUtils.isEmpty(r100) == false) goto L5;
        r100 = d.a(q0.i(), "Privacy_MY", "public_key_time_interval", "");
        q0.f(r100);
    L5:
        String r101 = q0.m();
        if (TextUtils.isEmpty(r101) == false) goto L9;
        r101 = d.a(q0.i(), "Privacy_MY", "public_key_time_last", "");
        q0.c(r101);
    L9:
        if (TextUtils.isEmpty(r100) == false) goto L11;
    L21:
        return true;
    L11:
        if (TextUtils.isEmpty(r101) == true) goto L21;
        if ((System.currentTimeMillis() - CastLongProtector.parseLong(r101)) <= CastIntegerProtector.parseInt(r100)) goto L17;
        return true;
    L17:
        return false;
    L19:
        e = move-exception;
        v.e("GetPublicKey", "checkCachePubKey NumberFormatException :" + e.getMessage());
        goto L21
    }

    public static void b(String r100, String r101) {
        String r102 = "{url}/getPublicKey?keytype=4".replace("{url}", a1.f(r100, r101));
        String r103 = q0.f();
        HashMap r104 = new HashMap();
        r104.put("App-Id", r103);
        n0 r105 = w.a(r102, new byte[0], r104);     // Catch: Exception -> L5
    L7:
        if (r105 != null) goto L12;
        String r106 = "get pubKey response is null";
    L9:
        v.e("GetPublicKey", r106);
        return;
    L12:
        if (r105.b() == 200) goto L15;
        r106 = "get pubKey fail HttpCode :" + r105.b();
        goto L9
    L15:
        if (TextUtils.isEmpty(r105.a()) == true) goto L20;
        d(r105.a(), r101);
        return;
    L20:
        return;
    L5:
        e = move-exception;
        v.e("GetPublicKey", "get pubKey response Exception :" + e.getMessage());
        r105 = null;
        goto L7
    }

    public static String c(String r100, String r101) {
        String r102 = q0.c();
        if (TextUtils.isEmpty(r102) == false) goto L6;
        r102 = d.a(q0.i(), "Privacy_MY", "public_key_version", "");
        q0.g(r102);
    L6:
        if (EventConstant.Value.AUTH_VERSION_2.equals(r102) == true) goto L10;
        a(r100, r101);
        return null;
    L10:
        if ("maint".equals(r101) == false) goto L14;
        String r103 = q0.n();
        if (TextUtils.isEmpty(r103) == false) goto L18;
        r103 = AesGcmKS.decrypt("HiAnalytics_Sdk_Public_Sp_Key", d.a(q0.i(), "Privacy_MY", "public_key_maint", ""));
        q0.d(r103);
    L18:
        if (TextUtils.isEmpty(r103) == false) goto L20;
    L23:
        a(r100, r101);
        return null;
    L20:
        if (a() == true) goto L23;
        return r103;
    L14:
        r103 = q0.o();
        if (TextUtils.isEmpty(r103) == false) goto L18;
        r103 = AesGcmKS.decrypt("HiAnalytics_Sdk_Public_Sp_Key", d.a(q0.i(), "Privacy_MY", "public_key_oper", ""));
        q0.e(r103);
        goto L18
    }

    private static void d(String r100, String r101) {
        JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L9
        String r103 = r102.optString("publicKey");     // Catch: JSONException -> L9
        String r104 = r102.optString("publicKeyOM");     // Catch: JSONException -> L9
        String r105 = r102.optString("pubkey_version");     // Catch: JSONException -> L9
        String r106 = System.currentTimeMillis() + "";     // Catch: JSONException -> L9
        String r107 = r102.optString("timeInterval");     // Catch: JSONException -> L9
        d.b(q0.i(), "Privacy_MY", "public_key_oper", AesGcmKS.encrypt("HiAnalytics_Sdk_Public_Sp_Key", r103));     // Catch: JSONException -> L9
        d.b(q0.i(), "Privacy_MY", "public_key_maint", AesGcmKS.encrypt("HiAnalytics_Sdk_Public_Sp_Key", r104));     // Catch: JSONException -> L9
        d.b(q0.i(), "Privacy_MY", "public_key_time_interval", r107);     // Catch: JSONException -> L9
        d.b(q0.i(), "Privacy_MY", "public_key_version", r105);     // Catch: JSONException -> L9
        d.b(q0.i(), "Privacy_MY", "public_key_time_last", r106);     // Catch: JSONException -> L9
        q0.e(r103);     // Catch: JSONException -> L9
        q0.d(r104);     // Catch: JSONException -> L9
        q0.g(r105);     // Catch: JSONException -> L9
        q0.c(r106);     // Catch: JSONException -> L9
        q0.f(r107);     // Catch: JSONException -> L9
        return;
    L9:
        e = move-exception;
        v.e("GetPublicKey", "get pubKey parse json JSONException :" + e.getMessage());
    }
}
