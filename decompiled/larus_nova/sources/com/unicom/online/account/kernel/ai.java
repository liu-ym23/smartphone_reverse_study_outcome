package com.unicom.online.account.kernel;

import android.content.Context;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public final class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ExecutorService f461972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ExecutorService f461973b;

    static {
        f461972a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("unt/kernel/ai"));
        f461973b = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("unt/kernel/ai"));
    }

    public static String a(int r100, int r101, String r102, int r103, int r104, final int r105, final String r106) {
        if (ac.a() == true) goto L6;
        return "";
    L6:
        if (an.a(r102).booleanValue() == false) goto L13;
        r102 = i.g();
    L13:
        LinkedHashMap r107 = new LinkedHashMap();     // Catch: Exception -> L10
        r107.put("result", Integer.valueOf(r100));     // Catch: Exception -> L10
        r107.put("type", Integer.valueOf(r101));     // Catch: Exception -> L10
        r107.put("os", 1);     // Catch: Exception -> L10
        r107.put("apiKey", ak.c());     // Catch: Exception -> L10
        r107.put(OnekeyLoginConstants.CU_KEY_SEQ, r102);     // Catch: Exception -> L10
        r107.put("ret_code", Integer.valueOf(r103));     // Catch: Exception -> L10
        r107.put("sdk_v", ac.d());     // Catch: Exception -> L10
        r107.put("setTime", Integer.valueOf(r104));     // Catch: Exception -> L10
        r107.put(OnekeyLoginConstants.NET_TYPE, Integer.valueOf(ak.a()));     // Catch: Exception -> L10
        r107.put("access_process", new AnonymousClass3());     // Catch: Exception -> L10
        r107.put("err_info", new AnonymousClass4(r105, r106));     // Catch: Exception -> L10
        return new JSONObject(r107).toString();
    L10:
        e = move-exception;
        aj.a(e);
        return "";
    }

    public static /* synthetic */ String a(String r100) {
        return b(r100);
    }

    private static String a(TreeMap<String, Object> r100) {
        StringBuilder r101 = new StringBuilder();     // Catch: Exception -> L13
        Iterator<Map.Entry<String, Object>> r102 = r100.entrySet().iterator();     // Catch: Exception -> L13
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, Object> r103 = r102.next();     // Catch: Exception -> L13
        String r104 = r103.getKey();     // Catch: Exception -> L13
        Object r105 = r103.getValue();     // Catch: Exception -> L13
        if (r105 == null) goto L4;
        if (an.b(r104).booleanValue() == false) goto L4;
        String r106 = URLEncoder.encode(r105.toString(), "UTF-8");     // Catch: Exception -> L13
        r101.append(r104);     // Catch: Exception -> L13
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L13
        r101.append(r106);     // Catch: Exception -> L13
        r101.append("&");     // Catch: Exception -> L13
        goto L4
    L10:
        r101.deleteCharAt(r101.length() - 1);     // Catch: Exception -> L13
        return r101.toString();
    L13:
        e = move-exception;
        e.getMessage();
        throw new Exception("http请求参数出错");
    }

    public static void a(final Context r100, final String r101) {
        if (ac.a() == true) goto L5;
        return;
    L5:
        final ao r102 = new ao();
        FutureTask r103 = new FutureTask(new AnonymousClass1(r101, r100, r102), r102);
        f461972a.execute(r103);     // Catch: Exception -> L23
        ao r104 = (ao) r103.get();     // Catch: Exception -> L23
        if (r104.f462018a.contains("\"code\":0") == false) goto L9;
        FutureTask r105 = new FutureTask(new AnonymousClass2(r100), r102);     // Catch: Exception -> L23
        f461973b.execute(r105);     // Catch: Exception -> L23
    L10:
        c r106 = e.f462038i;     // Catch: Exception -> L23
        r106.f462027a = 0;     // Catch: Exception -> L23
        r106.f462028b = 0;     // Catch: Exception -> L23
        r106.f462029c = 0;     // Catch: Exception -> L23
        g r107 = r106.f462031e;     // Catch: Exception -> L23
        if (r107 == null) goto L13;
        r107.b();     // Catch: Exception -> L23
    L13:
        g r108 = e.f462038i.f462032f;     // Catch: Exception -> L23
        if (r108 == null) goto L16;
        r108.b();     // Catch: Exception -> L23
    L16:
        g r109 = e.f462038i.f462033g;     // Catch: Exception -> L23
        if (r109 == null) goto L19;
        r109.b();     // Catch: Exception -> L23
    L19:
        g r110 = e.f462038i.f462034h;     // Catch: Exception -> L23
        if (r110 == null) goto L28;
        r110.b();     // Catch: Exception -> L23
        return;
    L28:
        return;
    L9:
        l.a(r100, r104.f462019b);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
    }

    private static String b(String r100) {
        String r101 = ak.d();     // Catch: Exception -> L9
        String r102 = al.a(r100, r101.substring(0, 16), r101.substring(16, 32));     // Catch: Exception -> L9
        String r103 = s.a(r101, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCqlsahFVMRr61qP/zUqXJlhwhEAR6ynO9ldpawnABDwDiHDymSzsSyyHKE2mS3178d0gGJ5v0TnpNh3+IiOQknpRUvAvXeA9P8DkCNBZBSwCEHo74xQ1+TLMk7f0Qn45GfMipLO0ryYCR4Xg4zE8TubqJ2oyy9pi/QoBdtjx+vJwIDAQAB");     // Catch: Exception -> L9
        String r104 = al.b(ak.f461999k + "?params=" + r102 + "&paramsKey=" + r103);     // Catch: Exception -> L9
        TreeMap r105 = new TreeMap();     // Catch: Exception -> L9
        HashMap r106 = new HashMap(16);     // Catch: Exception -> L9
        r105.put("params", r102);     // Catch: Exception -> L9
        r105.put("paramsKey", r103);     // Catch: Exception -> L9
        r105.put("sign", r104);     // Catch: Exception -> L9
        r106.put("sign", r104);     // Catch: Exception -> L9
        r106.put("api-protocol", "1.1");     // Catch: Exception -> L9
    L15:
        return a(r105);
    L6:
        e = move-exception;
        aj.a(e);     // Catch: Exception -> L9
        return "";
    L9:
        e = move-exception;
        aj.a(e);
        e.toString();
        return null;
    }
}
