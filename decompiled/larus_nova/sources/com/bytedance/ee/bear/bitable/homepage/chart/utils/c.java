package com.bytedance.ee.bear.bitable.homepage.chart.utils;

import android.app.Application;
import android.net.Uri;
import com.alipay.sdk.m.p.e;
import com.bytedance.ee.bear.bitable.core.usercomponent.compat.BitableSdkSenderCompat;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.bytedance.lark.pb.tool.v1.HttpHeader;
import com.bytedance.lark.pb.tool.v1.HttpHeaderMap;
import com.bytedance.lark.pb.tool.v1.HttpMethod;
import com.bytedance.lark.pb.tool.v1.UserSendHttpRequest;
import com.bytedance.lark.pb.tool.v1.UserSendHttpResponse;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.passport_api.IPassportApi;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f212637a = null;

        static {
            int[] r100 = new int[SendHttpRequest.Method.values().length];
            r100[SendHttpRequest.Method.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[SendHttpRequest.Method.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f212637a = r100;
        }
    }

    static {
    }

    public c() {
    }

    public static Uri a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return UriProtector.parse("https://" + jcb.b.c().a("docs_api") + r100);
    }

    public static void c(Uri r100, SendHttpRequest.Method r101, JSONObject r102, IGetDataCallback r103) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        Intrinsics.checkNotNullParameter(r103, "callback");
        b(r100, r101, r102, true, r103);
    }

    public static void b(Uri r110, SendHttpRequest.Method r111, Object r210, boolean r211, final IGetDataCallback r212) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        Intrinsics.checkNotNullParameter(r111, e.f25671s);
        Intrinsics.checkNotNullParameter(r212, "callback");
        if (r211 == true) goto L5;
    L52:
        Uri.Builder r100 = r110.buildUpon();
        SendHttpRequest.Builder r101 = new SendHttpRequest.Builder();
        if (r210 == null) goto L71;
        int r112 = b.f212637a[r111.ordinal()];
        boolean r102 = true;
        if (r112 == 1) goto L61;
        if (r112 != 2) goto L59;
        ByteString.a r103 = ByteString.Companion;
        String r104 = r210.toString();
        r103.getClass();
        r101.body(ByteString.a.b(r104));
    L72:
        r101.url(r100.build().toString()).method(r111);
        HashMap r105 = new HashMap();
        IPassportApi r106 = (IPassportApi) ApiUtils.getApi(IPassportApi.class);
        xzb.a r107 = (xzb.a) ApiUtils.getApi(xzb.a.class);
        if (r106 == null) goto L85;
        if (r107 == null) goto L85;
        int r108 = r106.envType();
        Locale r109 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
        Application r113 = LarkContext.getApplication();
        if (r108 == 2) goto L79;
        r102 = false;
    L79:
        r105.putAll(qu5.b.a(r113, r102, r106.getDeviceId(), r107.getUserId(), r109));
        if (r211 == false) goto L83;
        String r114 = r107.getSession();
        StringBuilder r115 = new StringBuilder("bear-session=");
        r115.append(r114);
        r115.append("; session=");
        r115.append(r114);
        r115.append("; lang=");
        r115.append(r109.getLanguage());
        r115.append("; locale=");
        r115.append(r109.getLanguage());
        r115.append('_');
        String r116 = r109.getCountry();
        Intrinsics.checkNotNull(r109);
        r115.append(r116.toUpperCase(r109));
        r105.put("Cookie", r115.toString());
    L83:
        if (r108 != 3) goto L85;
        r105.put("Env", "Pre_release");
    L85:
        r101.headers(r105);
        BitableSdkSenderCompat.a(Command.SEND_HTTP, r101, r212, SendHttpResponse.ADAPTER);
        return;
    L59:
        throw new IllegalArgumentException("Unsupported method " + r111);
    L61:
        if ((r210 instanceof JSONObject) == false) goto L70;
        JSONObject r117 = (JSONObject) r210;
        Iterator<String> r118 = r117.keys();
    L64:
        if (r118.hasNext() == false) goto L72;
        String r119 = r118.next();
        Object r120 = r117.opt(r119);
        if (r120 == null) goto L69;
        r100.appendQueryParameter(r119, r120.toString());
        goto L64
    L69:
        throw new IllegalArgumentException("Required value was null.".toString());
    L70:
        tt5.a.d("NetUtil", "get request with invalid params");
        goto L72
    L71:
        r102 = true;
        goto L72
    L5:
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.user_send_http.enable") == false) goto L52;
        Uri.Builder r121 = r110.buildUpon();
        if (r210 == null) goto L25;
        int r122 = b.f212637a[r111.ordinal()];
        if (r122 == 1) goto L15;
        if (r122 != 2) goto L13;
        ByteString.a r123 = ByteString.Companion;
        String r124 = r210.toString();
        r123.getClass();
        ByteString r125 = ByteString.a.b(r124);
    L26:
        HashMap r126 = new HashMap();
        IPassportApi r127 = (IPassportApi) ApiUtils.getApi(IPassportApi.class);
        xzb.a r128 = (xzb.a) ApiUtils.getApi(xzb.a.class);
        if (r127 == null) goto L36;
        if (r128 == null) goto L36;
        int r129 = r127.envType();
        Locale r130 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
        Application r131 = LarkContext.getApplication();
        if (r129 != 2) goto L32;
        boolean r132 = true;
    L33:
        r126.putAll(qu5.b.a(r131, r132, r127.getDeviceId(), r128.getUserId(), r130));
        if (r129 != 3) goto L36;
        r126.put("Env", "Pre_release");
        goto L36
    L32:
        r132 = false;
    L36:
        String r133 = r121.build().toString();
        r126.put("x-docs-add-csrf-token", "1");
        UserSendHttpRequest.Builder r134 = new UserSendHttpRequest.Builder().url(r133);
        int r135 = b.f212637a[r111.ordinal()];
        if (r135 == 1) goto L42;
        if (r135 != 2) goto L41;
        HttpMethod r136 = HttpMethod.POST;
    L43:
        UserSendHttpRequest.Builder r137 = r134.method(r136);
        HttpHeaderMap.Builder r138 = new HttpHeaderMap.Builder();
        ArrayList r139 = new ArrayList(r126.size());
        Iterator r140 = r126.entrySet().iterator();
    L45:
        if (r140.hasNext() == false) goto L47;
        Map.Entry r141 = (Map.Entry) r140.next();
        String r142 = (String) r141.getKey();
        r139.add(new HttpHeader.Builder().name(r142).value((String) r141.getValue()).build());
        goto L45
    L47:
        UserSendHttpRequest.Builder r143 = r137.headers(r138.headers(r139).build());
        if (r125 == null) goto L50;
        r143.body(r125);
    L50:
        Command r144 = Command.USER_SEND_HTTP;
        Intrinsics.checkNotNull(r143);
        BitableSdkSenderCompat.a(r144, r143, new NetUtil$toUserSendCallback$1(r212), UserSendHttpResponse.ADAPTER);
        return;
    L41:
        throw new IllegalArgumentException("Unsupported method " + r111);
    L42:
        r136 = HttpMethod.GET;
        goto L43
    L13:
        throw new IllegalArgumentException("Unsupported method " + r111);
    L15:
        if ((r210 instanceof JSONObject) == false) goto L24;
        JSONObject r145 = (JSONObject) r210;
        Iterator<String> r146 = r145.keys();
    L18:
        if (r146.hasNext() == false) goto L25;
        String r147 = r146.next();
        Object r148 = r145.opt(r147);
        if (r148 == null) goto L23;
        r121.appendQueryParameter(r147, r148.toString());
        goto L18
    L23:
        throw new IllegalArgumentException("Required value was null.".toString());
    L24:
        tt5.a.d("NetUtil", "get request with invalid params");
    L25:
        r125 = null;
        goto L26
    }
}
