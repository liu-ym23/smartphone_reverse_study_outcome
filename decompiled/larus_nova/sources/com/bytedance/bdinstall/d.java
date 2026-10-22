package com.bytedance.bdinstall;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.download.api.config.DownloadNetworkFactory;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f199630a = null;

    /* JADX INFO: loaded from: classes8.dex */
    public static class a extends BDNetworkTagContextProviderAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f199631a;

        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final int triggerType() {
            return 0;
        }

        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final boolean markAsNewUser() {
            return !this.f199631a;
        }

        public a(boolean r100) {
            this.f199631a = r100;
        }
    }

    static {
        f199630a = new String[]{"aid", "app_version", "tt_data", "device_id", "bd_did"};
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static HashMap<String, String> c(boolean r100) {
        HashMap<String, String> r101 = new HashMap();
        Pair<String, String> r102 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new a(r100));     // Catch: Throwable -> L7
        if (r102 == null) goto L9;
        r101.put(r102.first, r102.second);     // Catch: Throwable -> L7
    L9:
        return r101;
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    public static void b(StringBuilder r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r102) == false) goto L8;
        return;
    L8:
        if (r100.toString().indexOf(63) >= 0) goto L10;
        r100.append("?");
    L11:
        r100.append(r101);
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(Uri.encode(r102));
        return;
    L10:
        r100.append("&");
        goto L11
    }

    public static String d(String r100, boolean r101, b0 r110) {
        if (TextUtils.isEmpty(r100) == true) goto L20;
        Uri r102 = UriProtector.parse(r100);
        String r103 = r102.getQuery();
        ArrayList r104 = new ArrayList();
        String[] r105 = f199630a;
        int r106 = r105.length;
        int r107 = 0;
    L5:
        if (r107 >= r106) goto L10;
        String r108 = r105[r107];
        String r109 = UriProtector.getQueryParameter(r102, r108);
        if (TextUtils.isEmpty(r109) == true) goto L9;
        r104.add(new Pair(r108, r109));
    L9:
        r107 = r107 + 1;
        goto L5
    L10:
        Uri.Builder r111 = r102.buildUpon();
        r111.clearQuery();
        Iterator r112 = r104.iterator();
    L12:
        if (r112.hasNext() == false) goto L14;
        Pair r113 = (Pair) r112.next();
        r111.appendQueryParameter((String) r113.first, (String) r113.second);
        goto L12
    L14:
        r111.appendQueryParameter("tt_info", new String(Base64.encode(f(r103, r101, r110), 8)));
        return r111.build().toString();
    L20:
        return r100;
    }

    public static byte[] f(String r100, boolean r101, b0 r102) {
        ByteArrayOutputStream r103 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r104 = null;
        if (r101 == false) goto L11;
        GZIPOutputStream r105 = new GZIPOutputStream(r103);     // Catch: Throwable -> L9
        r105.write(r100.getBytes("UTF-8"));     // Catch: Throwable -> L7
        r104 = r105;
    L12:
        if (r104 == null) goto L21;
        r104.close();     // Catch: IOException -> L19
    L33:
    L21:
        byte[] r106 = r103.toByteArray();
        if (r101 == false) goto L43;
        if (r102 != null) goto L25;
        return r106;
    L25:
        return r102.encrypt(r106, r106.length);
    L43:
        return r106;
    L7:
        th = th;
        r104 = r105;
    L36:
        t.e(th);     // Catch: Throwable -> L26
        if (r104 == null) goto L21;
        r104.close();     // Catch: IOException -> L19
    L26:
        th = move-exception;
        if (r104 != null) goto L40;
    L32:
        throw th;
    L40:
        r104.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        t.e(e);
        goto L32
    L11:
        r103.write(r100.getBytes("UTF-8"));     // Catch: Throwable -> L9
    L19:
        e = move-exception;
        t.e(e);
    L9:
        th = th;
        goto L36
    }

    public static d84.a a(g0 r100, String r101, boolean r102, b0 r103, boolean r104) {
        StringBuilder r105 = new StringBuilder(r101);
        d84.a r106 = null;
        d84.a r107 = new d84.a(r101, 200, null, r100.get(d(r105.toString(), r102, r103), c(r104)));     // Catch: Exception -> L5
        t.a("network client is ready. response is " + r107);     // Catch: Exception -> L5
        return r107;
    L5:
        e = move-exception;
        if ((e instanceof RangersHttpException) == false) goto L9;
        RangersHttpException r108 = (RangersHttpException) e;
        r106 = new d84.a("", r108.getResponseCode(), null, r108.getMessage());
    L9:
        t.c("active http error = ", e);
        return r106;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static d84.a e(g0 r100, String r101, JSONObject r102, boolean r103, b0 r104, boolean r105, List r106) {
        HashMap<String, String> r107 = c(r105);
        if (r103 == false) goto L5;
        r107.put("Content-Type", DownloadNetworkFactory.ContentType.TT_DATA);
    L6:
        if (r106 != null) goto L8;
    L13:
        d84.a r108 = null;
        byte[] r109 = f(r102.toString(), r103, r104);     // Catch: Exception -> L20
        if (r109 == null) goto L18;
        if (r103 == false) goto L18;
        r101 = r101 + "&tt_data=a";     // Catch: Exception -> L20
    L18:
        d84.a r110 = new d84.a(r101, 200, null, r100.post(r101, r109, r107));     // Catch: Exception -> L20
        t.a("network client is ready. response is " + r110);     // Catch: Exception -> L20
        return r110;
    L20:
        e = move-exception;
        if ((e instanceof RangersHttpException) == false) goto L24;
        RangersHttpException r111 = (RangersHttpException) e;
        r108 = new d84.a("", r111.getResponseCode(), null, r111.getMessage());
    L24:
        t.c("doRegister# http error= " + e.toString(), e);
        return r108;
    L8:
        if (r106.size() <= 0) goto L13;
        int r112 = 0;
    L11:
        if (r112 >= r106.size()) goto L13;
        Pair r113 = (Pair) ListProtector.get(r106, r112);
        r107.put(r113.first, r113.second);
        r112 = r112 + 1;
        goto L11
    L5:
        r107.put("Content-Type", "application/json; charset=utf-8");
        goto L6
    }
}
