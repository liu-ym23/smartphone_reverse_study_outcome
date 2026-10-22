package com.bytedance.ttnet.utils;

import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.util.l;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.ttnet.AppConsts;
import com.bytedance.ttnet.http.HttpRequestInfo;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class RequestTicketUtil {
    public static final String HNAME_X_REQ_TICKET = "X-SS-REQ-TICKET";
    private static ICdnCacheVerifyCallback sCdnCacheVerifyProcessor = null;
    private static volatile boolean sEnabled = true;
    private static IRequestTicketProcessor sTicketProcessor;

    /* JADX INFO: loaded from: classes22.dex */
    public interface ICdnCacheVerifyCallback {
        void onCallback(String r100, HttpRequestInfo r101);
    }

    public interface IRequestTicketProcessor {
        void checkReqTicket(String r100, String r101, String r102, HttpRequestInfo r103);

        void sendSetCookieEvent(String r100, String r101, int r102, boolean r103, JSONObject r104);
    }

    public RequestTicketUtil() {
    }

    public static ICdnCacheVerifyCallback getCdnCacheVerifyProcessor() {
        return sCdnCacheVerifyProcessor;
    }

    public static IRequestTicketProcessor getRequestTicketProcessor() {
        return sTicketProcessor;
    }

    public static void setCdnCacheVerifyProcessor(ICdnCacheVerifyCallback r100) {
        sCdnCacheVerifyProcessor = r100;
    }

    public static void setEnable(boolean r100) {
        sEnabled = r100;
    }

    public static void setRequestTicketProcessor(IRequestTicketProcessor r100) {
        sTicketProcessor = r100;
    }

    public static void tryGenReqTicket(String r100, List<Header> r101, RetrofitMetrics r102) {
        if (sEnabled == true) goto L5;
        return;
    L5:
        r102.genReqTicketStart();
        if (l.b(r100).getHost().endsWith(AppConsts.getHostSuffix()) == false) goto L9;
        String r103 = String.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L15
    L11:
        if (StringUtils.isEmpty(r103) == true) goto L13;
        r101.add(new Header(HNAME_X_REQ_TICKET, r103));     // Catch: Throwable -> L15
        goto L13
    L9:
        r103 = null;
    L13:
        r102.genReqTicketEnd();
    }

    public static void checkReqTicket(String r100, String r101, String r102, HttpRequestInfo r103) {
        IRequestTicketProcessor r104 = sTicketProcessor;
        if (r104 == null) goto L6;
        r104.checkReqTicket(r100, r101, r102, r103);
        return;
    }

    public static void sendSetCookieEvent(String r100, String r101, int r102, boolean r103, JSONObject r110) {
        IRequestTicketProcessor r104 = sTicketProcessor;
        if (r104 == null) goto L6;
        r104.sendSetCookieEvent(r100, r101, r102, r103, r110);
        return;
    }
}
