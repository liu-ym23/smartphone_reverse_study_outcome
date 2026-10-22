package com.bytedance.awemeopen.infra.base.event;

import android.text.TextUtils;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.servicesapi.event.AoEventService;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Function0<String> f198600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Function0<String> f198601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Function0<Boolean> f198602h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f198603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f198604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f198605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f198606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d[] f198607e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f198608a;

        public final void a() {
            JSONObject r100 = this.f198608a.c();
            if (AoEventReportRules.check(this.f198608a.f198604b, r100) == false) goto L5;
            b r101 = this.f198608a;
            String r102 = r101.f198604b;
            r101.getClass();
            ((AoEventService) j64.a.a(AoEventService.class)).k2(r102, r100, r101.f198605c, r101.f198606d);
        L5:
            AoLogger.g("AoEvent", new Object[]{this.f198608a.f198604b, r100.toString()});
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

        public a(b r100) {
            this.f198608a = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.awemeopen.infra.base.event.b$b, reason: collision with other inner class name */
    public static class C2872b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f198609a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f198610b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f198611c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public JSONObject f198612d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final d f198613e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c f198614f;

        public final b a() {
            return new b(this.f198609a, this.f198610b, this.f198611c, this.f198612d, new d[]{null, this.f198614f, null, this.f198613e});
        }

        public C2872b(String r100) {
            com.bytedance.awemeopen.infra.base.event.c r101 = com.bytedance.awemeopen.infra.base.event.c.f198616a;
            this.f198609a = System.currentTimeMillis();
            this.f198610b = r100;
            this.f198613e = r101;
            this.f198614f = new c();
        }

        public final b b(d r110, d r111) {
            return new b(this.f198609a, this.f198610b, this.f198611c, this.f198612d, new d[]{null, this.f198614f, null, this.f198613e, r110, null, r111});
        }

        public final b c(d r110, d r111) {
            return new b(this.f198609a, this.f198610b, this.f198611c, this.f198612d, new d[]{null, this.f198614f, null, this.f198613e, r110, r111});
        }

        public final void d(String r100, Object r101) {
            c r102 = this.f198614f;
            r102.getClass();
            if (r100 == null) goto L15;
            if (r101 == null) goto L16;
        L10:
            e = move-exception;
            AoLogger.j(e);
            return;
        L6:
            if (r102.f198615a != null) goto L8;
            r102.f198615a = new JSONObject();     // Catch: JSONException -> L10
        L8:
            r102.f198615a.put(r100, r101);     // Catch: JSONException -> L10
            return;
        L16:
            return;
        }
    }

    public static class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public JSONObject f198615a;

        public c() {
        }

        @Override // com.bytedance.awemeopen.infra.base.event.d
        public final JSONObject getParams() {
            return this.f198615a;
        }
    }

    public final void b() {
        if (TextUtils.isEmpty(this.f198604b) == false) goto L5;
        return;
    L5:
        a r100 = new a(this);
        AoPool r101 = AoPool.f198803a;
        Intrinsics.checkNotNullParameter(r100, "task");
        AoPool.f198803a.getClass();
        AoPool.c().executeLogic(r100);
    }

    public final JSONObject c() {
        JSONObject r100 = new JSONObject();
        d[] r101 = this.f198607e;     // Catch: Throwable -> L11
        int r102 = r101.length;     // Catch: Throwable -> L11
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L9;
        d r104 = r101[r103];     // Catch: Throwable -> L11
        if (r104 == null) goto L8;
        d(r100, r104.getParams());     // Catch: Throwable -> L11
    L8:
        r103 = r103 + 1;     // Catch: Throwable -> L11
        goto L4
    L9:
        r100.put(BdpAppEventConstant.PARAMS_TIMESTAMP, this.f198603a);     // Catch: Throwable -> L11
    L13:
        return r100;
    L11:
        th = move-exception;
        AoLogger.j(th);
        goto L13
    }

    public static C2872b a(String r100) {
        com.bytedance.awemeopen.infra.base.event.c r101 = com.bytedance.awemeopen.infra.base.event.c.f198616a;
        return new C2872b(r100);
    }

    public static void d(JSONObject r100, JSONObject r101) {
        if (r101 == null) goto L36;
        Iterator<String> r102 = r101.keys();     // Catch: Throwable -> L23
    L5:
        if (r102.hasNext() == false) goto L37;
        String r103 = r102.next();     // Catch: Throwable -> L23
        if (r100.has(r103) == false) goto L9;
        AoLogger.c("AoEvent", new Object[]{"collition key: " + r103});     // Catch: Throwable -> L23
        String r104 = "";
        if (r101.has(r103) == true) goto L21;
        int r105 = 0;
    L15:
        if (r105 >= 10) goto L20;
        String r106 = r103 + "_" + r105;     // Catch: Throwable -> L23
        if (r101.has(r106) == false) goto L18;
        r105 = r105 + 1;     // Catch: Throwable -> L23
        goto L15
    L18:
        r104 = r106;
        goto L21
    L20:
        AoLogger.c("not detect valid key", new Object[0]);     // Catch: Throwable -> L23
    L21:
        r100.put(r104, r101.get(r103));     // Catch: Throwable -> L23
        goto L5
    L9:
        r100.put(r103, r101.get(r103));     // Catch: Throwable -> L23
        goto L5
    L37:
        return;
    L23:
        th = move-exception;
        AoLogger.j(th);
        return;
    }

    public b(long r100, String r101, String r102, JSONObject r103, d[] r104) {
        this.f198603a = r100;
        this.f198604b = r101;
        this.f198605c = r102;
        this.f198606d = r103;
        this.f198607e = r104;
    }
}
