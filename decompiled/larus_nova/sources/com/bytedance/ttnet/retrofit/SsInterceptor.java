package com.bytedance.ttnet.retrofit;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.ttnet.AppConsts;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.CdnCacheVerifyUtils;
import com.bytedance.ttnet.utils.RequestTicketUtil;
import com.obric.sva.sdk.utils.InteractConst;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import qx5.a;

/* JADX INFO: loaded from: classes3.dex */
public final class SsInterceptor extends a {
    private static final String SET_COOKIE = "Set-Cookie";
    private static volatile boolean sEncryptQueryEnabled;
    private static volatile boolean sHttpInfoInjectedByInterceptor;

    public SsInterceptor() {
    }

    public static void EnableEncryptQuery(boolean r100) {
        sEncryptQueryEnabled = r100;
    }

    @Override // qx5.a
    public Request processBeforeSendRequest(Request r100) throws IOException {
        Request r101 = super.processBeforeSendRequest(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        if (sHttpInfoInjectedByInterceptor == true) goto L9;
        HttpRequestInfo.injectCreate();
        sHttpInfoInjectedByInterceptor = true;
    L9:
        Request.Builder r102 = r101.newBuilder();
        String r103 = r101.getUrl();
        ArrayList r104 = new ArrayList();
        if (r101.getHeaders() == null) goto L12;
        r104.addAll(r101.getHeaders());
    L12:
        String r105 = tryFilterDupQuery(r103, r101.getMetrics());
        tryEncryptRequestHeader(r105, r102, r104, r101.getMetrics());
        RequestTicketUtil.tryGenReqTicket(r105, r104, r101.getMetrics());
        CdnCacheVerifyUtils.preProcessing(r105, r104, r101.getMetrics());
        ClientKeyManager.inst().AddClientKeyHeader(r104, r101.getMetrics());
        r102.url(r105);
        r102.headers(r104);
        return r102.build();
    }

    private void checkCommandHeader(Request r100, Response r101) {
        if (NetworkParams.getCommandListener() == null) goto L25;
        r100.getMetrics().commandListenerStart();
        NetworkParams.getCommandListener().b();     // Catch: Throwable -> L19
        if (StringUtils.isEmpty("") == true) goto L21;
        List<Header> r102 = r101.headers("");     // Catch: Throwable -> L19
        if (r102 == null) goto L21;
        if (r102.size() <= 0) goto L21;
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L19
        Iterator<Header> r104 = r102.iterator();     // Catch: Throwable -> L19
    L15:
        if (r104.hasNext() == false) goto L17;
        r103.add(r104.next().getValue());     // Catch: Throwable -> L19
        goto L15
    L17:
        NetworkParams.getCommandListener().a(r103);     // Catch: Throwable -> L19
    L21:
        r100.getMetrics().commandListenerEnd();
        return;
    L19:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r100.getMetrics().commandListenerEnd();
        throw th;
    }

    private String tryFilterDupQuery(String r100, RetrofitMetrics r101) {
        if (StringUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        r101.filterDupQueryStart();
        LinkedHashMap r102 = new LinkedHashMap();     // Catch: Throwable -> L53
        Pair<String, String> r103 = UrlUtils.parseUrlWithValueList(r100, r102);     // Catch: Throwable -> L53
        if (r103 != null) goto L11;
        r101.filterDupQueryEnd();
        return r100;
    L11:
        if (r102.isEmpty() == true) goto L30;
        Iterator r104 = r102.entrySet().iterator();     // Catch: Throwable -> L53
    L14:
        if (r104.hasNext() == false) goto L30;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Throwable -> L53
        if (r105 == null) goto L14;
        List r106 = (List) r105.getValue();     // Catch: Throwable -> L53
        if (r106 == null) goto L14;
        if (r106.isEmpty() == true) goto L14;
        LinkedHashSet r107 = new LinkedHashSet();     // Catch: Throwable -> L53
        Iterator r108 = r106.iterator();     // Catch: Throwable -> L53
    L25:
        if (r108.hasNext() == false) goto L14;
        String r109 = (String) r108.next();     // Catch: Throwable -> L53
        if (r107.contains(r109) == true) goto L28;
        r107.add(r109);     // Catch: Throwable -> L53
        goto L25
    L28:
        r108.remove();     // Catch: Throwable -> L53
    L30:
        UrlBuilder r110 = new UrlBuilder(((String) r103.first) + ((String) r103.second));     // Catch: Throwable -> L53
        if (r102.isEmpty() == true) goto L50;
        Iterator r111 = r102.entrySet().iterator();     // Catch: Throwable -> L53
    L34:
        if (r111.hasNext() == false) goto L50;
        Map.Entry r112 = (Map.Entry) r111.next();     // Catch: Throwable -> L53
        if (r112 == null) goto L34;
        if (r112.getKey() == null) goto L34;
        List r113 = (List) r112.getValue();     // Catch: Throwable -> L53
        if (r113 == null) goto L34;
        if (r113.isEmpty() == true) goto L34;
        Iterator r114 = r113.iterator();     // Catch: Throwable -> L53
    L48:
        if (r114.hasNext() == false) goto L34;
        r110.addParam((String) r112.getKey(), (String) r114.next());     // Catch: Throwable -> L53
    L50:
        String r115 = r110.build();     // Catch: Throwable -> L53
        r101.filterDupQueryEnd();
        return r115;
    L53:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L57
        r101.filterDupQueryEnd();
        return r100;
    L57:
        th = move-exception;
        r101.filterDupQueryEnd();
        throw th;
    }

    @Override // qx5.a
    public void processAfterReceiveResponse(Request r100, SsResponse r101) throws Exception {
        super.processAfterReceiveResponse(r100, r101);
        if (r100 == null) goto L8;
        if (r101 == null) goto L9;
        Response r102 = r101.raw();
        checkCommandHeader(r100, r102);
        ClientKeyManager.inst().UpdateClientKeyAndSessionInfo(r100, r102);
        checkRequestTicket(r100, r102, null);
        CdnCacheVerifyUtils.postProcessing(r100, r102, null);
        return;
    L9:
        return;
    }

    private void checkRequestTicket(Request r110, Response r111, HttpRequestInfo r112) {
        r110.getMetrics().checkReqTicketStart();
        Object r100 = r111.getExtraInfo();     // Catch: Throwable -> L75
        if ((r100 instanceof HttpRequestInfo) == false) goto L86;
        r112 = (HttpRequestInfo) r100;     // Catch: Throwable -> L75
        if (r112.reqContext == 0) goto L86;
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L75
        List<Header> r102 = r111.getHeaders();     // Catch: Throwable -> L75
        int r103 = 0;
    L9:
        if (r103 >= r102.size()) goto L20;
        Header r104 = r102.get(r103);     // Catch: Exception -> L17 Throwable -> L75
        if (r104 == null) goto L19;
        if (TextUtils.isEmpty(r104.getName()) == true) goto L19;
        r101.put(r104.getName().toUpperCase(), r104.getValue());     // Catch: Exception -> L17 Throwable -> L75
    L19:
        r103 = r103 + 1;     // Catch: Throwable -> L75
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L75
        goto L19
    L20:
        T r105 = r112.reqContext;     // Catch: Throwable -> L75
        if ((r105 instanceof RequestContext) == false) goto L23;
        ((RequestContext) r105).headers = r101;     // Catch: Throwable -> L75
    L23:
        ((RequestContext) r105).status = r111.getStatus();     // Catch: Throwable -> L75
        ((RequestContext) r112.reqContext).remoteIp = r112.remoteIp;     // Catch: Throwable -> L75
    L86:
        String r106 = r111.getUrl();     // Catch: Throwable -> L33
        Header r107 = r110.getFirstHeader(RequestTicketUtil.HNAME_X_REQ_TICKET);     // Catch: Throwable -> L33
        String r108 = null;
        if (r107 == null) goto L27;
        String r109 = r107.getValue();     // Catch: Throwable -> L33
    L28:
        Header r113 = r111.getFirstHeader(RequestTicketUtil.HNAME_X_REQ_TICKET);     // Catch: Throwable -> L33
        if (r113 == null) goto L31;
        r108 = r113.getValue();     // Catch: Throwable -> L33
    L31:
        RequestTicketUtil.checkReqTicket(r106, r109, r108, r112);     // Catch: Throwable -> L33
    L82:
        String r114 = r110.getUrl();     // Catch: Throwable -> L71
        Uri r115 = Uri.parse(r114);     // Catch: Throwable -> L71
        if (r115.getHost().endsWith(AppConsts.getHostSuffix()) == true) goto L39;
        r110.getMetrics().checkReqTicketEnd();
        return;
    L39:
        String[] r116 = {InteractConst.INTENT_SESSION_ID, "tt_sessionid"};     // Catch: Throwable -> L71
        List<Header> r117 = r111.headers(new String[]{"Set-Cookie"}[0]);     // Catch: Throwable -> L71
        if (r117 != null) goto L42;
    L73:
        r110.getMetrics().checkReqTicketEnd();
        return;
    L42:
        if (r117.size() <= 0) goto L73;
        Iterator<Header> r118 = r117.iterator();     // Catch: Throwable -> L71
    L45:
        if (r118.hasNext() == false) goto L73;
        Header r119 = r118.next();     // Catch: Throwable -> L71
        int r120 = 0;
    L49:
        if (r120 >= 2) goto L45;
        String r121 = px5.a.a(r119.getValue(), r116[r120]);     // Catch: Throwable -> L71
        if (Logger.debug() == false) goto L54;
        Logger.d("SsOkHttpClient", r121);     // Catch: Throwable -> L71
    L54:
        if (StringUtils.isEmpty(r121) == true) goto L70;
        int r122 = r111.getStatus();     // Catch: Throwable -> L71
        boolean r123 = r112.reqTicketUnmatch;     // Catch: Throwable -> L71
        JSONObject r124 = new JSONObject();     // Catch: Throwable -> L71
        String r125 = r115.getEncodedQuery();     // Catch: Throwable -> L78
        if (StringUtils.isEmpty(r125) == true) goto L61;
        r124.put("url_query", r125);     // Catch: Throwable -> L78
    L61:
        if (StringUtils.isEmpty(r112.remoteIp) == true) goto L64;
        r124.put("remote_ip", r112.remoteIp);     // Catch: Throwable -> L71
    L64:
        if (r111.getHeaders() == null) goto L66;
        r124.put("header_list", r111.getHeaders().toString());     // Catch: Throwable -> L71
    L66:
        int r126 = r114.indexOf("?");     // Catch: Throwable -> L71
        if (r126 != (-1)) goto L69;
        r126 = r114.length();     // Catch: Throwable -> L71
    L69:
        RequestTicketUtil.sendSetCookieEvent("set_cookie", r114.substring(0, r126), r122, r123, r124);     // Catch: Throwable -> L71
    L70:
        r120 = r120 + 1;
        goto L49
    L71:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L75
        goto L73
    L27:
        r109 = null;
    L33:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        r110.getMetrics().checkReqTicketEnd();
        throw th;
    }

    private void tryEncryptRequestHeader(String r100, Request.Builder r101, List<Header> r102, RetrofitMetrics r103) {
        if (sEncryptQueryEnabled == true) goto L27;
        return;
    L27:
        LinkedList r104 = new LinkedList();     // Catch: Throwable -> L22
        r103.encryptRequestStart();     // Catch: Throwable -> L22
        String r105 = ay5.a.f(r100, r104);     // Catch: Throwable -> L19
        r103.encryptRequestEnd();     // Catch: Throwable -> L22
        if (r105 == null) goto L11;
        r101.url(r105);     // Catch: Throwable -> L22
    L11:
        if (r104.isEmpty() == true) goto L34;
        Iterator r106 = r104.iterator();     // Catch: Throwable -> L22
    L14:
        if (r106.hasNext() == false) goto L35;
        Pair r107 = (Pair) r106.next();     // Catch: Throwable -> L22
        if (r107 == null) goto L14;
        r102.add(new Header((String) r107.first, (String) r107.second));     // Catch: Throwable -> L22
        goto L14
    L35:
        return;
    L34:
        return;
    L19:
        th = move-exception;
        r103.encryptRequestEnd();     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.printStackTrace();
    }
}
