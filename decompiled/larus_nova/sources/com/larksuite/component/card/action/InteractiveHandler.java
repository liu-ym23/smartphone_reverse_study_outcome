package com.larksuite.component.card.action;

import android.net.Uri;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.tool.v1.HttpHeader;
import com.bytedance.lark.pb.tool.v1.HttpHeaderMap;
import com.bytedance.lark.pb.tool.v1.HttpMethod;
import com.bytedance.lark.pb.tool.v1.UserSendHttpRequest;
import com.bytedance.lark.pb.tool.v1.UserSendHttpResponse;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Objects;
import okio.ByteString;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class InteractiveHandler {
    public InteractiveHandler() {
    }

    public static boolean d(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (r100.startsWith("sslocal://") == false) goto L8;
        return true;
    L8:
        Uri r101 = UriProtector.parse(r100);
        ova.f.m().getClass();
        if (ova.f.q(r101) == true) goto L11;
        return false;
    L11:
        return TextUtils.equals("/client/mini_program/open", r101.getPath());
    }

    public static String b(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L31;
        if (d(r100) == false) goto L31;
        if (TextUtils.isEmpty(r101) == true) goto L43;
        String r102 = UriProtector.getQueryParameter(UriProtector.parse(r100), "bdp_launch_query");
        if (r102 != null) goto L37;
        JSONObject r103 = new JSONObject();
        r103.put("__trigger_id__", r101);     // Catch: UnsupportedEncodingException -> L20 Throwable -> L22
        StringBuilder r104 = new StringBuilder("bdp_launch_query=");     // Catch: UnsupportedEncodingException -> L20 Throwable -> L22
        r104.append(URLEncoder.encode(r103.toString(), XML.CHARSET_UTF8));     // Catch: UnsupportedEncodingException -> L20 Throwable -> L22
        int r105 = r100.length();     // Catch: UnsupportedEncodingException -> L20 Throwable -> L22
        int r106 = r100.indexOf("?");     // Catch: UnsupportedEncodingException -> L20 Throwable -> L22
        if (r106 > (-1)) goto L15;
        r100 = r100 + "?" + r104;     // Catch: UnsupportedEncodingException -> L20 Throwable -> L22
    L34:
        return r100;
    L15:
        if ((r105 - 1) != r106) goto L17;
        r100 = r100 + r104.toString();     // Catch: UnsupportedEncodingException -> L20 Throwable -> L22
        goto L34
    L17:
        r100 = r100 + "&" + r104;     // Catch: UnsupportedEncodingException -> L20 Throwable -> L22
    L22:
        e = move-exception;
        Log.e("InteractiveHandler", "error:" + e.getMessage());
        return r100;
    L37:
        JSONObject r107 = new JSONObject(URLDecoder.decode(r102, XML.CHARSET_UTF8).replace("\\", ""));     // Catch: UnsupportedEncodingException -> L26 Throwable -> L28
        r107.put("__trigger_id__", r101);     // Catch: UnsupportedEncodingException -> L26 Throwable -> L28
        return e(r100, URLEncoder.encode(r107.toString(), XML.CHARSET_UTF8));
    L28:
        e = move-exception;
        Log.e("InteractiveHandler", "error:" + e.getMessage());
        return r100;
    L43:
        return r100;
    L31:
        if (TextUtils.isEmpty(r101) == false) goto L42;
        fyb.e r108 = com.larksuite.component.card.monitor.b.f283718a;
        com.larksuite.component.card.monitor.c r109 = com.larksuite.component.card.monitor.c.f283724c;
        com.larksuite.component.card.monitor.b r110 = com.larksuite.component.card.monitor.b.c.a(r109);
        r110.setErrorMessage(r109.message);
        r110.flush();
        return r100;
    L42:
        return r100;
    }

    public static String e(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (TextUtils.isEmpty("bdp_launch_query") == false) goto L7;
        return r100;
    L7:
        return r100.replaceAll("(bdp_launch_query=[^&]*)", "bdp_launch_query=" + r101);
    }

    public final void c(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("user_id", ty7.a.a().getLoginUserId());     // Catch: JSONException -> L5
        r102.put(MusicAppletPage.KEY_MESSAGE_ID, r101);     // Catch: JSONException -> L5
        r102.put("trigger_code", r100);     // Catch: JSONException -> L5
    L7:
        final long r103 = System.currentTimeMillis();
        ArrayList r104 = new ArrayList();
        r104.add(new HttpHeader("Content-Type", "application/json; charset=utf-8"));
        UserSendHttpRequest.Builder r105 = new UserSendHttpRequest.Builder().method(HttpMethod.POST);
        String r106 = String.format("https://%s/lark/card/api/bindTriggerCode", new Object[]{ty7.a.a().getDynamicDomain("open_msg_card")});
        Log.d("UrlConfig", "dynamicUrl:" + r106);
        UserSendHttpRequest.Builder r107 = r105.url(r106).headers(new HttpHeaderMap(r104)).body(ByteString.encodeUtf8(r102.toString()));
        r107.disable_cookie = Boolean.FALSE;
        Command r108 = Command.USER_SEND_HTTP;
        IGetDataCallback<UserSendHttpResponse> r109 = new AnonymousClass1(this, r103);
        final ProtoAdapter<UserSendHttpResponse> r110 = UserSendHttpResponse.ADAPTER;
        Objects.requireNonNull(r110);
        SdkSender.asynSendRequestNonWrap(r108, r107, r109, new e(r110));
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void a(InteractiveHandler r100, boolean r101, String r102, long r103) {
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
