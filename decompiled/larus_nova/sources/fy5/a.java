package fy5;

import android.text.TextUtils;
import by5.n;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.framwork.core.sdklib.apm6.safety.ApmSDKInternalException;
import com.bytedance.framwork.core.sdkmonitor.e;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import xu3.h;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f479281a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f479282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f479283c;

    /* JADX INFO: renamed from: fy5.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes19.dex */
    public static class RunnableC5965a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f479284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f479285b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Throwable f479286c;

        public final void a() {
            String r100 = this.f479284a;
            String r101 = this.f479285b;
            ApmSDKInternalException r102 = new ApmSDKInternalException("tag=" + r100 + " message=" + r101, this.f479286c);
            JSONObject r103 = new JSONObject();     // Catch: Throwable -> L20
            r103.put("event_type", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);     // Catch: Throwable -> L20
            r103.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L20
            StringWriter r104 = new StringWriter();     // Catch: Throwable -> L20
            PrintWriter r105 = new PrintWriter(r104);     // Catch: Throwable -> L20
            r102.printStackTrace(r105);     // Catch: Throwable -> L20
            Throwable r106 = r102.getCause();     // Catch: Throwable -> L20
            if (r106 == null) goto L8;
            r106.printStackTrace(r105);     // Catch: Throwable -> L20
            Throwable r107 = r106.getCause();     // Catch: Throwable -> L20
            if (r107 == null) goto L8;
            r107.printStackTrace(r105);     // Catch: Throwable -> L20
        L8:
            String r108 = r104.toString();     // Catch: Throwable -> L20
            r105.close();     // Catch: Throwable -> L20
            r103.put("stack", r108);     // Catch: Throwable -> L20
            r103.put("exception_type", 1);     // Catch: Throwable -> L20
            r103.put("message", r100 + "_" + r101);     // Catch: Throwable -> L20
            JSONObject r109 = new JSONObject();     // Catch: Throwable -> L20
            r109.put("apm_sdk", "apm6_error");     // Catch: Throwable -> L20
            r103.put("filters", r109);     // Catch: Throwable -> L20
            JSONObject r110 = new JSONObject();     // Catch: Throwable -> L20
            JSONArray r111 = new JSONArray();     // Catch: Throwable -> L20
            r111.put(r103);     // Catch: Throwable -> L20
            r110.put("data", r111);     // Catch: Throwable -> L20
            JSONObject r112 = n.c();     // Catch: Throwable -> L20
            if (r112 != null) goto L27;
            r112 = null;
        L13:
            if (r112 == null) goto L15;
            r112.put("aid", "44444");     // Catch: Throwable -> L20
        L15:
            r110.put("header", r112);     // Catch: Throwable -> L20
            if (n.f21462e == true) goto L18;
        L18:
            a.b(a.f479283c, r110.toString().getBytes());     // Catch: Throwable -> L20
            return;
        L27:
            r112 = new JSONObject(r112.toString());     // Catch: Exception -> L24 Throwable -> L20
        L21:
            if (n.f21462e == true) goto L23;
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

        public RunnableC5965a(String r100, String r101, Throwable r102) {
            this.f479284a = r100;
            this.f479285b = r101;
            this.f479286c = r102;
        }
    }

    static {
        f479281a = new AtomicInteger(0);
        f479282b = true;
    }

    public static void b(String r100, byte[] r101) {
        if (NetworkUtils.isNetworkAvailable(n.getContext()) == false) goto L5;
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.length == 0) goto L27;
        HashMap r102 = new HashMap();     // Catch: Throwable -> L17
        byte[] r103 = e.b(r101, r102);     // Catch: Throwable -> L17
        HashMap r104 = new HashMap(n.b());     // Catch: Throwable -> L17
        r104.put("aid", "44444");     // Catch: Throwable -> L17
        String r105 = h.a(r100, r104);     // Catch: Throwable -> L17
        if (n.f21462e == false) goto L15;
        av3.b.a("APM-SDK", "http request:url:" + r105);     // Catch: Throwable -> L17
    L15:
        n.a(r105, r102, r103);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        if (n.f21462e == false) goto L26;
        th.printStackTrace();
        return;
    L26:
        return;
    L27:
        return;
    L5:
        if (n.f21462e == false) goto L24;
        av3.b.a("APM-SDK", "network unreachable");
        return;
    }

    public static void a(String r100, String r101, Throwable r102) {
        if (TextUtils.isEmpty(f479283c) == false) goto L6;
        return;
    L6:
        if (f479282b == false) goto L12;
        AtomicInteger r103 = f479281a;
        if (r103.get() >= 3) goto L13;
        r103.incrementAndGet();
        gy5.a.b.f483331a.b(new RunnableC5965a(r100, r101, r102));
        return;
    L13:
        return;
    }
}
