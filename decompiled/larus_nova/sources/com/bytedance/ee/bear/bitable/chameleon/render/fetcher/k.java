package com.bytedance.ee.bear.bitable.chameleon.render.fetcher;

import com.bytedance.ee.bear.bitable.preload.bean.BitableOfflineResultModel;
import com.bytedance.ee.bear.bitable.preload.util.BitablePreloadBridgeUtil;

/* JADX INFO: loaded from: classes15.dex */
public final class k {
    public static final String b(String r100) {
        int r101 = 0;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return "";
    L9:
        StringBuilder r103 = new StringBuilder(r100.length());
    L11:
        if (r101 >= r100.length()) goto L28;
        char r104 = r100.charAt(r101);
        if (r104 != '\r') goto L15;
        r103.append("\\r");
    L26:
        r101 = r101 + 1;
        goto L11
    L15:
        if (r104 != '\"') goto L17;
        r103.append("\\\"");
        goto L26
    L17:
        if (r104 == '\\') goto L23;
        switch(r104) {
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            default: goto L19;
        };
    L19:
        r103.append(r104);
        goto L26
    L20:
        r103.append("\\n");
        goto L26
    L21:
        r103.append("\\t");
        goto L26
    L22:
        r103.append("\\b");
        goto L26
    L23:
        r103.append("\\\\");
        goto L26
    L28:
        return r103.toString();
    L5:
        r102 = false;
        goto L6
    }

    public static final void a(boolean r100, BaseAppTableSsrDataFetcher.Payload r101, String r110, String r111, tb5.m r112) {
        if (r101 == null) goto L5;
        int r102 = r101.getApiCode();
    L8:
        boolean r103 = true;
        if (r110 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        String r105 = "";
        String r106 = null;
        if (r104 == false) goto L32;
        if (r101 == null) goto L20;
        String r113 = r101.getErrorMsg();
    L21:
        if (r113 != null) goto L23;
    L26:
        if (r103 == true) goto L31;
        if (r101 == null) goto L29;
        r110 = r101.getErrorMsg();
    L30:
        if (r110 != null) goto L32;
    L29:
        r110 = null;
    L31:
        r110 = "";
        goto L32
    L23:
        if (r113.length() == 0) goto L26;
        r103 = false;
        goto L26
    L20:
        r113 = null;
    L32:
        StringBuilder r107 = new StringBuilder("{\"requestStart\":");
        if (r101 == null) goto L35;
        long r108 = r101.getRequestStart();
    L36:
        r107.append(r108);
        r107.append(",\"apiCode\":");
        r107.append(r102);
        r107.append(",\"errorMsg\":\"");
        r107.append(b(r110));
        r107.append("\",\"xttLogId\":\"");
        if (r101 == null) goto L39;
        r106 = r101.getXttLogId();
    L39:
        if (r106 == null) goto L42;
        r105 = r106;
    L42:
        r107.append(b(r105));
        r107.append("\",\"source\":\"prefetch\",\"cacheElapsedTime\":0,\"preloadQueryResult\":\"not_triggered\"}");
        BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(r100, false, r107.toString(), r111), r112);
        return;
    L35:
        r108 = 0;
        goto L36
    L11:
        if (r110.length() == 0) goto L14;
        r104 = false;
        goto L15
    L5:
        if (r100 == false) goto L7;
        r102 = 0;
        goto L8
    L7:
        r102 = -1;
        goto L8
    }
}
