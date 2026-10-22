package eu3;

import com.bytedance.apm6.foundation.safety.ApmInternalException;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.services.apm.api.IHttpService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import xu3.c;
import xu3.d;
import xu3.h;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f474058a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f474059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f474060c;

    /* JADX INFO: renamed from: eu3.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes14.dex */
    public static class C5820a extends cv3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f474061d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f474062e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Throwable f474063f;

        public final void a() {
            String r100 = this.f474061d;
            String r101 = this.f474062e;
            ApmInternalException r102 = new ApmInternalException("tag=" + r100 + " message=" + r101, this.f474063f);
            JSONObject r103 = new JSONObject();     // Catch: Throwable -> L16
            r103.put("event_type", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);     // Catch: Throwable -> L16
            r103.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L16
            StringWriter r104 = new StringWriter();     // Catch: Throwable -> L16
            PrintWriter r105 = new PrintWriter(r104);     // Catch: Throwable -> L16
            r102.printStackTrace(r105);     // Catch: Throwable -> L16
            Throwable r106 = r102.getCause();     // Catch: Throwable -> L16
            if (r106 == null) goto L8;
            r106.printStackTrace(r105);     // Catch: Throwable -> L16
            Throwable r107 = r106.getCause();     // Catch: Throwable -> L16
            if (r107 == null) goto L8;
            r107.printStackTrace(r105);     // Catch: Throwable -> L16
        L8:
            String r108 = r104.toString();     // Catch: Throwable -> L16
            r105.close();     // Catch: Throwable -> L16
            r103.put("stack", r108);     // Catch: Throwable -> L16
            r103.put("exception_type", 1);     // Catch: Throwable -> L16
            r103.put("message", r100 + "_" + r101);     // Catch: Throwable -> L16
            JSONObject r109 = new JSONObject();     // Catch: Throwable -> L16
            r109.put("apm_sdk", "apm6_error");     // Catch: Throwable -> L16
            r109.put("host_aid", String.valueOf(du3.a.b()));     // Catch: Throwable -> L16
            r103.put("filters", r109);     // Catch: Throwable -> L16
            JSONObject r110 = new JSONObject();     // Catch: Throwable -> L16
            JSONArray r111 = new JSONArray();     // Catch: Throwable -> L16
            r111.put(r103);     // Catch: Throwable -> L16
            r110.put("data", r111);     // Catch: Throwable -> L16
            JSONObject r112 = new JSONObject();     // Catch: Throwable -> L16
            d.a(r112, du3.a.j());     // Catch: Throwable -> L16
            du3.b r113 = du3.a.f470025c;     // Catch: Throwable -> L16
            if (r113 == null) goto L11;
            r113.c();     // Catch: Throwable -> L16
            d.a(r112, null);     // Catch: Throwable -> L16
        L11:
            r112.put("os", "Android");     // Catch: Throwable -> L16
            r112.put("aid", 2085);     // Catch: Throwable -> L16
            r112.put("device_id", du3.a.f());     // Catch: Throwable -> L16
            r112.put("channel", du3.a.d());     // Catch: Throwable -> L16
            r112.put("version_code", du3.a.n());     // Catch: Throwable -> L16
            r112.put("update_version_code", du3.a.l());     // Catch: Throwable -> L16
            r112.put("device_id", du3.a.f());     // Catch: Throwable -> L16
            r112.put("uid", du3.a.f470025c.getUid());     // Catch: Throwable -> L16
            r112.put("process_name", du3.a.e());     // Catch: Throwable -> L16
            r110.put("header", r112);     // Catch: Throwable -> L16
            if (xu3.a.a() == true) goto L14;
        L14:
            a.c(a.f474060c, r110.toString().getBytes());     // Catch: Throwable -> L16
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public C5820a(String r100, String r101, Throwable r102) {
            this.f474061d = r100;
            this.f474062e = r101;
            this.f474063f = r102;
        }
    }

    static {
        f474058a = new AtomicInteger(0);
        f474059b = true;
    }

    public static tu3.a a(String r100, byte[] r101) {
        HashMap r102 = new HashMap();
        if (r101.length <= 128) goto L15;
        ByteArrayOutputStream r103 = new ByteArrayOutputStream(8192);     // Catch: IOException -> L16
        GZIPOutputStream r104 = new GZIPOutputStream(r103);     // Catch: Throwable -> L10
        r104.write(r101);     // Catch: Throwable -> L8
        c.a(r104);     // Catch: IOException -> L16
        byte[] r105 = r103.toByteArray();     // Catch: IOException -> L16
        r102.put("Content-Encoding", DownloadHelper.GZIP);     // Catch: IOException -> L16
        r101 = r105;
    L8:
        th = th;
    L12:
        c.a(r104);     // Catch: IOException -> L16
        throw th;     // Catch: IOException -> L16
    L10:
        th = th;
        r104 = null;
    L15:
        return new tu3.a(h.a(r100, du3.a.m()), r102, r101);
    }

    public static void c(String r100, byte[] r101) {
        if (NetworkUtils.isNetworkAvailable(xu3.a.getContext()) == false) goto L5;
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.length == 0) goto L27;
        tu3.a r102 = a(r100, r101);     // Catch: Throwable -> L17
        if (xu3.a.a() == false) goto L15;
        av3.b.a("APM-CustomException", "http request:url:" + r102.f547615a + " headers:" + r102.f547616b);     // Catch: Throwable -> L17
    L15:
        String r103 = r102.f547615a;     // Catch: Throwable -> L17
        Map<String, String> r104 = r102.f547616b;     // Catch: Throwable -> L17
        ((IHttpService) qu3.c.a(IHttpService.class)).doPost(r103, r102.f547617c, r104);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        if (xu3.a.a() == false) goto L26;
        th.printStackTrace();
        return;
    L26:
        return;
    L27:
        return;
    L5:
        if (xu3.a.a() == false) goto L24;
        av3.b.a("APM-CustomException", "network unreachable");
        return;
    }

    public static void b(String r100, String r101, Throwable r102) {
        if (f474059b == false) goto L9;
        AtomicInteger r103 = f474058a;
        if (r103.get() >= 3) goto L10;
        r103.incrementAndGet();
        cv3.b.a(AsyncTaskManagerType.IO).c(new C5820a(r100, r101, r102));
        return;
    L10:
        return;
    }
}
