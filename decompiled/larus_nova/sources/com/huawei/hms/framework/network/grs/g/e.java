package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import com.larus.apm.impl.protector.RunnableProtector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class e {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f277233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f277234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ JSONArray f277235c;

        public a(long r100, ArrayList r101, JSONArray r102) {
            this.f277233a = r100;
            this.f277234b = r101;
            this.f277235c = r102;
        }

        public void com_huawei_hms_framework_network_grs_g_e$a__run$___twin___() {
            com.huawei.hms.framework.network.grs.g.j.a r100 = new com.huawei.hms.framework.network.grs.g.j.a();
            r100.put("total_time", this.f277233a);
            Iterator r101 = this.f277234b.iterator();
        L4:
            if (r101.hasNext() == false) goto L10;
            d r102 = (d) r101.next();
            if (r102.o() == true) goto L9;
            if (r102.m() == false) goto L4;
        L9:
            r100.put(e.a(r102));
            r101.remove();
            boolean r103 = true;
        L11:
            if (r103 == true) goto L16;
            if (this.f277234b.size() <= 0) goto L16;
            ArrayList r104 = this.f277234b;
            d r105 = (d) ListProtector.get(r104, r104.size() - 1);
            r100.put(e.a(r105));
            this.f277234b.remove(r105);
        L16:
            if (this.f277234b.size() <= 0) goto L22;
            Iterator r106 = this.f277234b.iterator();
        L19:
            if (r106.hasNext() == false) goto L22;
            this.f277235c.put(new JSONObject(e.a((d) r106.next())));
        L22:
            if (this.f277235c.length() <= 0) goto L24;
            r100.put("failed_info", this.f277235c.toString());
        L24:
            Logger.d("HaReportHelper", "grssdk report data to aiops is: %s", new Object[]{new JSONObject(r100.get())});
            HianalyticsHelper.getInstance().onEvent(r100.get(), "grs_request");
            return;
        L10:
            r103 = false;
            goto L11
        }

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_framework_network_grs_g_e$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_framework_network_grs_g_e$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_huawei_hms_framework_network_grs_g_e$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static /* synthetic */ LinkedHashMap a(d r100) {
        return b(r100);
    }

    public static void a(ArrayList<d> r100, long r101, JSONArray r102, Context r103) {
        if (r103 == null) goto L10;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.size() > 0) goto L7;
        return;
    L7:
        if (HianalyticsHelper.getInstance().isEnableReport(r103) == false) goto L13;
        HianalyticsHelper.getInstance().getReportExecutor().submit(new a(r101, r100, r102));
        return;
    L13:
        return;
    }

    private static LinkedHashMap<String, String> b(d r100) {
        LinkedHashMapPack r101 = new LinkedHashMapPack();
        Exception r102 = r100.d();
        if (r102 == null) goto L5;
        r101.put("error_code", ExceptionCode.getErrorCodeFromException(r102));
        r101.put(CrashHianalyticsData.EXCEPTION_NAME, r102.getClass().getSimpleName());
        r101.put("message", StringUtils.anonymizeMessage(r102.getMessage()));
    L13:
        r101.put("domain", new URL(r100.l()).getHost());     // Catch: MalformedURLException -> L9
    L11:
        r101.put("req_start_time", r100.h());
        r101.put("req_end_time", r100.g());
        r101.put("req_total_time", r100.i());
        return r101.getAll();
    L9:
        e = move-exception;
        Logger.w("HaReportHelper", "report host MalformedURLException", e);
        goto L11
    L5:
        r101.put("error_code", r100.b());
        r101.put(CrashHianalyticsData.EXCEPTION_NAME, r100.c());
        goto L13
    }
}
