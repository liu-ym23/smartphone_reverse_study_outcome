package com.bytedance.bdlocation.network.request;

import android.util.Pair;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.retrofit2.client.Header;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class RequestUtil {
    public RequestUtil() {
    }

    public static List<Header> overseaHeaderList(List<Header> r100) {
        if (r100 != null) goto L4;
        r100 = new ArrayList();
    L4:
        r100.add(new Header("Content-Type", "application/json"));
        return r100;
    }

    public static List<Header> headerList(List<Header> r100, final int r101) {
        if (r100 != null) goto L5;
        r100 = new ArrayList();
    L5:
        if (BDLocationConfig.isDebug() == true) goto L7;
    L16:
        Pair<String, String> r102 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new AnonymousClass1(r101));     // Catch: Throwable -> L15
        if (r102 == null) goto L14;
        r100.add(new Header((String) r102.first, (String) r102.second));     // Catch: Throwable -> L15
    L14:
        return r100;
    L7:
        if (BDLocationConfig.isOnline() == true) goto L16;
        Pair r103 = BDLocationConfig.getEnv();
        if (r103 == null) goto L16;
        r100.add(new Header((String) r103.first, "1"));
        r100.add(new Header("x-tt-env", (String) r103.second));
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Map<String, String> headerMap(Map<String, String> r100, final int r101) {
        if (r100 != null) goto L5;
        Map<String, String> r102 = new HashMap();
    L5:
        if (BDLocationConfig.isDebug() == true) goto L7;
    L16:
        Pair<String, String> r103 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new AnonymousClass2(r101));     // Catch: Throwable -> L15
        if (r103 == null) goto L14;
        r102.put(r103.first, r103.second);     // Catch: Throwable -> L15
    L14:
        return r102;
    L7:
        if (BDLocationConfig.isOnline() == true) goto L16;
        Pair r104 = BDLocationConfig.getEnv();
        if (r104 == null) goto L16;
        r102.put(r104.first, "1");
        r102.put("x-tt-env", r104.second);
        goto L16
    }
}
