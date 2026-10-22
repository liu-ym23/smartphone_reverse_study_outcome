package com.huawei.hms.healthlite;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.hihealthlite.HiHealthKitClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class aabf {

    /* JADX INFO: renamed from: aab, reason: collision with root package name */
    private static volatile aabf f277488aab;
    private static List<aabe> aaba;

    static {
        aaba = new ArrayList();
    }

    public static aabf aaba() {
        if (f277488aab != null) goto L15;
        monitor-enter(aabf.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f277488aab != null) goto L9;
        f277488aab = new aabf();     // Catch: Throwable -> L11
    L9:
        monitor-exit(aabf.class);     // Catch: Throwable -> L11
    L15:
        return f277488aab;
    }

    public List<aabe> aab() {
        return aaba;
    }

    private aabf() {
        Context r100 = HiHealthKitClient.getInstance().getContext();
        aabg.aaba("QueryUrlUtil", "entry initDataTypeDefinition");
        aabg.aaba("QueryUrlUtil", "enter parsing h5_url_definition.json");
        StringBuilder r101 = new StringBuilder(131072);
        InputStream r102 = r100.getAssets().open("h5_url_definition.json");     // Catch: IOException -> L36
        InputStreamReader r103 = new InputStreamReader(r102, StandardCharsets.UTF_8);     // Catch: Throwable -> L29
        BufferedReader r104 = new BufferedReader(r103);     // Catch: Throwable -> L23
    L52:
        String r105 = r104.readLine();     // Catch: Throwable -> L17
        if (r105 == null) goto L12;
        if (r105.length() >= 128) goto L52;
        r101.append(r105);     // Catch: Throwable -> L17
    L12:
        r104.close();     // Catch: Throwable -> L23
        r103.close();     // Catch: Throwable -> L29
        if (r102 == null) goto L37;
        r102.close();     // Catch: IOException -> L36
    L37:
        String r106 = r101.toString();
        if (TextUtils.isEmpty(r106) == false) goto L48;
        aabg.aab("QueryUrlUtil", "read DataType definition config empty");
        return;
    L48:
        aaba.clear();     // Catch: JSONException -> L45
        JSONArray r107 = JSONObjectProtectorUtils.getJSONArray(new JSONObject(r106), "urls");     // Catch: JSONException -> L45
        int r108 = 0;
    L42:
        if (r108 >= r107.length()) goto L46;
        aabe r109 = new aabe(JSONArrayProtectorUtils.getJSONObject(r107, r108));     // Catch: JSONException -> L45
        aaba.add(r109);     // Catch: JSONException -> L45
        r108 = r108 + 1;
    L46:
        aabg.aaba("QueryUrlUtil", "Parsing data_type_definition.json success");
        return;
    L45:
        aabg.aab("QueryUrlUtil", "Parsing h5 u.json failure");
    L17:
        th = move-exception;
        r104.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: Throwable -> L23
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r103.close();     // Catch: Throwable -> L26
    L28:
        throw th;     // Catch: Throwable -> L29
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        if (r102 != null) goto L59;
    L35:
        throw th;     // Catch: IOException -> L36
    L59:
        r102.close();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L36
    L36:
        aabg.aaba("QueryUrlUtil", "assets resourceh5_url_definition.jsonread failure");
        goto L37
    }
}
