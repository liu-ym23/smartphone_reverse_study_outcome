package com.unicom.online.account.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttvideoengine.net.DNSParser;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class am {
    public static String a(Context r100, String r101) {
        return r100.getSharedPreferences("cu_auth", 0).getString(r101, "");
    L5:
        e = move-exception;
        aj.a(e);
        return "";
    }

    public static void a(Context r100, String r101, List<d> r110) {
        if (r110.size() != 0) goto L14;
        return;
    L14:
        JSONArray r102 = new JSONArray();     // Catch: Exception -> L11
        int r103 = 0;
    L7:
        if (r103 >= r110.size()) goto L9;
        d r104 = (d) ListProtector.get(r110, r103);     // Catch: Exception -> L11
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L11
        r105.put("domain", r104.f462035a);     // Catch: Exception -> L11
        r105.put(DNSParser.DNS_RESULT_IP, r104.f462036b);     // Catch: Exception -> L11
        r105.put("expire", r104.f462037c);     // Catch: Exception -> L11
        r102.put(r105);     // Catch: Exception -> L11
        r103 = r103 + 1;     // Catch: Exception -> L11
        goto L7
    L9:
        SharedPreferences.Editor r106 = r100.getSharedPreferences("cu_auth", 0).edit();     // Catch: Exception -> L11
        r106.putString(r101, r102.toString());     // Catch: Exception -> L11
        r106.apply();     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    public static List<d> b(Context r100, String r101) {
        int r102 = 0;
        String r103 = r100.getSharedPreferences("cu_auth", 0).getString(r101, null);     // Catch: Exception -> L8
        ArrayList r104 = new ArrayList();     // Catch: Exception -> L8
        JSONArray r105 = new JSONArray(r103);     // Catch: Exception -> L8
    L4:
        if (r102 >= r105.length()) goto L7;
        JSONObject r106 = JSONArrayProtectorUtils.getJSONObject(r105, r102);     // Catch: Exception -> L8
        d r107 = new d();     // Catch: Exception -> L8
        r107.f462035a = r106.optString("domain");     // Catch: Exception -> L8
        r107.f462036b = r106.optString(DNSParser.DNS_RESULT_IP);     // Catch: Exception -> L8
        r107.f462037c = r106.optLong("expire");     // Catch: Exception -> L8
        r104.add(r107);     // Catch: Exception -> L8
        r102 = r102 + 1;
        goto L4
    L7:
        return r104;
    L8:
        e = move-exception;
        e.printStackTrace();
        return new ArrayList();
    }
}
