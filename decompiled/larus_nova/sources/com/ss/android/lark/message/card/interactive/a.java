package com.ss.android.lark.message.card.interactive;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.card.action.InteractiveHandler;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import java.net.URLDecoder;
import java.net.URLEncoder;
import jrb.c;
import jrb.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    public final void c(String r100, String r101) {
        throw null;
    }

    public static String b(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L31;
        if (InteractiveHandler.d(r100) == false) goto L31;
        if (TextUtils.isEmpty(r101) == true) goto L43;
        String r102 = UriProtector.getQueryParameter(UriProtector.parse(r100), "bdp_launch_query");
        if (r102 != null) goto L37;
        JSONObject r103 = new JSONObject();
        r103.put("__trigger_id__", r101);     // Catch: Throwable -> L20 JSONException -> L22
        StringBuffer r104 = new StringBuffer("bdp_launch_query=");     // Catch: Throwable -> L20 JSONException -> L22
        r104.append(URLEncoder.encode(r103.toString(), XML.CHARSET_UTF8));     // Catch: Throwable -> L20 JSONException -> L22
        int r105 = r100.length();     // Catch: Throwable -> L20 JSONException -> L22
        int r106 = r100.indexOf("?");     // Catch: Throwable -> L20 JSONException -> L22
        if (r106 > (-1)) goto L15;
        r100 = r100 + "?" + r104.toString();     // Catch: Throwable -> L20 JSONException -> L22
    L34:
        return r100;
    L15:
        if ((r105 - 1) != r106) goto L17;
        r100 = r100 + r104.toString();     // Catch: Throwable -> L20 JSONException -> L22
        goto L34
    L17:
        r100 = r100 + "&" + r104.toString();     // Catch: Throwable -> L20 JSONException -> L22
    L20:
        e = move-exception;
        e.printStackTrace();
        return r100;
    L37:
        JSONObject r107 = new JSONObject(URLDecoder.decode(r102, XML.CHARSET_UTF8).replace("\\", ""));     // Catch: Throwable -> L26 JSONException -> L28
        r107.put("__trigger_id__", r101);     // Catch: Throwable -> L26 JSONException -> L28
        return d(r100, URLEncoder.encode(r107.toString(), XML.CHARSET_UTF8));
    L26:
        e = move-exception;
        Log.e("InteractiveHandler", "error:" + e.getMessage());
        e.printStackTrace();
        return r100;
    L43:
        return r100;
    L31:
        if (TextUtils.isEmpty(r101) == false) goto L42;
        d r108 = d.f500168g;
        OPMonitor r109 = c.a(r108);
        r109.setErrorMessage(r108.message);
        r109.flush();
        return r100;
    L42:
        return r100;
    }

    public static String d(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (TextUtils.isEmpty("bdp_launch_query") == false) goto L7;
        return r100;
    L7:
        return r100.replaceAll("(bdp_launch_query=[^&]*)", "bdp_launch_query=" + r101);
    }

    public static void a(a r100, boolean r101, String r102, long r103) {
        r100.getClass();
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L12
        if (r101 == false) goto L6;
        String r105 = "success";
    L7:
        r104.put("state", r105);     // Catch: Exception -> L12
        if (r101 == true) goto L10;
        r104.put("errorMsg", r102);     // Catch: Exception -> L12
    L10:
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L12
        r106.put("duration", System.currentTimeMillis() - r103);     // Catch: Exception -> L12
        MonitorUtils.monitorEvent("op_messagecard_trigger_code", r104, r106, null);     // Catch: Exception -> L12
        return;
    L6:
        r105 = "fail";
    L12:
        e = move-exception;
        Log.e("InteractiveHandler", e.getMessage(), e);
    }
}
