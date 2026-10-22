package com.ss.android.ugc.route_monitor.impl.route_out;

import android.os.Handler;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.route_monitor.impl.biz_event.BizEventDataRecorder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class k implements com.ss.android.ugc.route_monitor.utils.j.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, h> f454702a = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f454703a;

        public a(h r100) {
            this.f454703a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HashMap<String, h> r100 = k.f454702a;     // Catch: Throwable -> L4
            h r101 = this.f454703a;     // Catch: Throwable -> L4
            b r102 = b.f454595c;     // Catch: Throwable -> L4
            j r103 = new j(r101);     // Catch: Throwable -> L4
            r102.f454775b.execute(r103);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f454702a = new HashMap();
    }

    public static void i() {
        com.ss.android.ugc.route_monitor.c.a().getClass();
        b r100 = b.f454595c;
        r100.f454775b.execute(new com.ss.android.ugc.route_monitor.utils.d(r100));
        Iterator<Map.Entry<String, h>> r101 = f454702a.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry<String, h> r102 = r101.next();
        String r103 = r102.getKey();
        JSONObject r104 = r102.getValue().b();
        b r105 = b.f454595c;
        r105.getClass();
        if (TextUtils.isEmpty(r103) == true) goto L4;
        r105.f454775b.execute(new com.ss.android.ugc.route_monitor.utils.f(r105, r103, r104));
        goto L4
    L9:
        b r106 = b.f454595c;
        r106.getClass();
        Throwable r107 = new Throwable();
        r106.f454775b.execute(new com.ss.android.ugc.route_monitor.utils.h(r106, r107));
    }

    public static void l(l r100) {
        BizEventDataRecorder r101 = BizEventDataRecorder.f454415e;
        r101.getClass();
        com.ss.android.ugc.route_monitor.utils.q r102 = BizEventDataRecorder.f454413c;
        KProperty<?>[] r103 = BizEventDataRecorder.f454412b;
        if (((com.ss.android.ugc.route_monitor.impl.biz_event.a) r102.getValue(r101, r103[0])).f454416a == true) goto L5;
        return;
    L5:
        h r104 = new h(r100.f454704a);
        b r105 = b.f454595c;
        i r106 = new i(r104);
        r105.f454775b.execute(r106);
        Handler r107 = com.ss.android.ugc.route_monitor.utils.r.f454781a;
        com.ss.android.ugc.route_monitor.utils.r.a(new a(r104), ((com.ss.android.ugc.route_monitor.impl.biz_event.a) r102.getValue(r101, r103[0])).f454419d);
    }
}
