package com.vivo.push.restructure.request;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.vivo.push.i;
import com.vivo.push.util.t;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* JADX INFO: loaded from: classes41.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Integer, b> f462502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Integer f462503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HandlerThread f462504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f462505d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static d f462506a;

        static {
            f462506a = new d(0);
        }
    }

    private synchronized Integer b() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f462503b != null) goto L7;
        this.f462503b = 0;     // Catch: Throwable -> L14
    L7:
        if (this.f462503b.intValue() >= 0) goto L9;
    L10:
        this.f462503b = 0;     // Catch: Throwable -> L14
    L11:
        Integer r100 = Integer.valueOf(this.f462503b.intValue() + 1);     // Catch: Throwable -> L14
        this.f462503b = r100;     // Catch: Throwable -> L14
        Integer r101 = new Integer(r100.intValue());     // Catch: Throwable -> L14
        monitor-exit(this);
        return r101;
    L9:
        if (this.f462503b.intValue() < Integer.MAX_VALUE) goto L11;
        goto L10
    }

    private d() {
        this.f462502a = new ConcurrentHashMap();
        this.f462503b = null;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("request_timer_task——thread");
        this.f462504c = r100;
        ThreadMethodProxy.start(r100);
        this.f462505d = new e(this, this.f462504c.getLooper());
    }

    public static d a() {
        return a.f462506a;
    }

    public /* synthetic */ d(byte r100) {
        this();
    }

    public final void a(com.vivo.push.restructure.a.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.g() == false) goto L29;
        com.vivo.push.restructure.request.a.a r101 = r100.h();
        int r102 = r101.b();
        if (r102 <= 0) goto L30;
        this.f462505d.removeMessages(r102);
        b r103 = this.f462502a.remove(Integer.valueOf(r102));
        if (r103 != null) goto L10;
        return;
    L10:
        if (r103.b() != null) goto L12;
        return;
    L12:
        if (r103.a() != null) goto L14;
        return;
    L14:
        if (r101.c() == 0) goto L26;
        r103.b().a(r101.c());
        return;
    L26:
        com.vivo.push.restructure.request.a.a.a r104 = new com.vivo.push.restructure.request.a.a.a(r100.i());     // Catch: JSONException -> L17
    L19:
        if (r104 == null) goto L22;
        r103.b().a(r103.a().a(r104));
        return;
    L22:
        r103.b().a(8003);
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        r104 = null;
        goto L19
    L30:
        return;
    }

    private static int a(Intent r100) {
        Context r101 = com.vivo.push.restructure.a.a().b();
        if (r101 != null) goto L6;
        return 8002;
    L6:
        i r102 = i.a(r101, "com.vivo.vms.aidlservice");
        if (r102.a() == true) goto L9;
    L14:
        String r103 = com.vivo.push.restructure.a.a().e().k();
        if (TextUtils.isEmpty(r103) == false) goto L18;
        return 8001;
    L18:
        Intent r104 = new Intent("com.vivo.pushservice.action.METHOD");
        r104.setPackage(r103);
        r104.setClassName(r103, "com.vivo.push.sdk.service.PushService");
        com.vivo.push.a.a.a(r101, r104);     // Catch: Exception -> L21
    L23:
        return 0;
    L21:
        e = move-exception;
        t.a("RequestManager", "CommandBridge startService exception: ", e);
        goto L23
    L9:
        if ("com.vivo.pushservice".equals(r101.getPackageName()) == true) goto L14;
        if (r102.a(r100.getExtras()) == false) goto L13;
        return 0;
    L13:
        t.b("RequestManager", "send command error by aidl");
        t.c(r101, "send command error by aidl");
        goto L14
    }

    public final void a(b r100) {
        Integer r101 = b();
        int r102 = a(r100.a().a(r101.intValue()));
        if (r102 != 0) goto L11;
        if (r100.c() > 0) goto L7;
        return;
    L7:
        if (r100.b() == null) goto L15;
        this.f462502a.put(r101, r100);
        this.f462505d.sendEmptyMessageDelayed(r101.intValue(), r100.c());
        return;
    L15:
        return;
    L11:
        if (r100.b() == null) goto L16;
        r100.b().a(r102);
        return;
    }

    public static /* synthetic */ Map a(d r100) {
        return r100.f462502a;
    }
}
