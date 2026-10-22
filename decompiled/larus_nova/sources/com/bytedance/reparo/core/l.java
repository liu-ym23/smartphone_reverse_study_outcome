package com.bytedance.reparo.core;

import android.app.Application;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.reparo.core.common.event.Event;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.core.exception.PatchInstallException;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f267380m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Object f267381n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f267382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f267383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c97.f f267384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c97.e f267385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Application f267386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c97.a f267387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<d> f267388g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConcurrentHashMap<c97.h, d97.d> f267389h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ConcurrentHashMap<String, p> f267390i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<d97.d> f267391j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f267392k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f267393l;

    /* JADX INFO: loaded from: classes21.dex */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f267394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f267395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f267396c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ l f267397d;

        /* JADX INFO: renamed from: com.bytedance.reparo.core.l$a$a, reason: collision with other inner class name */
        public class C3740a extends a97.a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c97.h f267398c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a f267399d;

            @Override // a97.a
            public final void c() {
                c97.h r100 = this.f267398c;
                long r101 = this.f267399d.f267395b;
                Event r102 = PatchEventReporter.d(r100, 2);
                r102.f267345d = r101;
                r102.f267347f = true;
                r102.j();
            }

            @Override // a97.a
            public final void b(PatchException r100) {
                c97.h r101 = this.f267398c;
                long r102 = this.f267399d.f267395b;
                Event r103 = PatchEventReporter.d(r101, 1);
                r103.f267345d = r102;
                r103.e(r100);
                r103.j();
            }

            public C3740a(a r100, c97.h r101) {
                this.f267399d = r100;
                this.f267398c = r101;
            }
        }

        public final void a(z87.a.C8429a r100) {
            p r101 = this.f267394a;
            l r102 = this.f267397d;
            g r103 = r102.f267383b;
            i r104 = r102.f267382a;
            c97.a r105 = r102.f267387f;
            c97.h r106 = r101.b();
            r106.f22881a = r100.f570946a;
            if (r100.f570947b == false) goto L8;
            if (w87.b.f(r100.f570948c) == true) goto L8;
            r106.f22882b = true;
            r106.f22883c = r100.f570948c;
        L8:
            if (r100.f570949d == true) goto L10;
        L12:
            d97.d r107 = d97.d.a(r106, r103, r104, r105);
            long r108 = this.f267395b;
            PatchEventReporter.a r109 = PatchEventReporter.f267312a;
            Event r110 = PatchEventReporter.a(r107.f467633c, 1);
            r110.f267345d = r108;
            r110.f267347f = true;
            r110.j();
            l r111 = this.f267397d;
            r111.getClass();
            Object r112 = l.f267381n;
            monitor-enter(r112);
        L26:
            th = move-exception;
            throw th;
        L15:
            if (r111.f267389h.contains(r107) == false) goto L18;
            monitor-exit(r112);     // Catch: Throwable -> L26
        L20:
            C3740a r113 = new C3740a(this, r107.f467633c.a());
            if (r107.f467633c.f22885e == false) goto L23;
            this.f267397d.getClass();
            l.h(r107, 1, r113);
        L24:
            this.f267397d.f267390i.remove(this.f267396c);
            return;
        L23:
            this.f267397d.g(r107, r113);
            goto L24
        L18:
            r111.f267389h.put(r107.f467633c, r107);     // Catch: Throwable -> L26
            c97.e r114 = r111.f267385d;     // Catch: Throwable -> L26
            c97.h r115 = r107.f467633c;     // Catch: Throwable -> L26
            r114.b().add(r115);     // Catch: Throwable -> L26
            r111.l();     // Catch: Throwable -> L26
            r111.i();     // Catch: Throwable -> L26
            monitor-exit(r112);     // Catch: Throwable -> L26
            goto L20
        L10:
            if (w87.b.g(r100.f570951f) == false) goto L12;
            r106.f22884d = true;
            r106.f22885e = r100.f570950e;
            r106.f22886f = r100.f570951f;
            goto L12
        }

        public a(l r100, p r101, long r102, String r103) {
            this.f267397d = r100;
            this.f267394a = r101;
            this.f267395b = r102;
            this.f267396c = r103;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class b extends a97.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d97.d f267400c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c97.h f267401d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f267402e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ d97.b f267403f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ l f267404g;

        @Override // a97.a
        public final void c() {
            d97.d r100 = this.f267400c;
            r100.getClass();
            r100.f467622a = true;
            if (this.f267401d.equals(r100.f467633c) == true) goto L5;
            this.f267404g.l();
        L5:
            k.c("PatchManager", "load patch success" + this.f267401d.toString());
            c97.h r101 = this.f267401d;
            long r102 = this.f267402e;
            d97.b r103 = this.f267403f;
            Event r104 = PatchEventReporter.b(r101, true);
            r104.f267345d = r102;
            r104.f267347f = true;
            r104.j();
            Event r105 = new Event();
            r105.f267342a = "PatchEventReporter";
            r105.f267344c = "patch_load_duration";
            r105.f267355n = PatchEventReporter.f267312a;
            r105.f267343b = 0;
            r105.f267348g = true;
            r105.i("patch_id", w87.d.a(r101.f22890j));
            r105.i("is_async", w87.d.a(Boolean.valueOf(r101.f22892l)));
        L7:
            if (r103.f467627e.isEmpty() == true) goto L23;
            String[] r106 = r103.f467627e.pop();
            long[] r107 = r103.f467628f.pop();
            int r108 = 0;
        L10:
            if (r108 >= r106.length) goto L7;
            if (TextUtils.isEmpty(r106[r108]) == true) goto L7;
            if (r107[r108] < 0) goto L21;
            String r109 = r106[r108];
            int r110 = 1;
        L18:
            if (r103.f467623a.containsKey(r109) == false) goto L20;
            r109 = r106[r108] + r110;
            r110 = r110 + 1;
            goto L18
        L20:
            r103.f467623a.put(r109, Long.valueOf(r107[r108]));
        L22:
            r108 = r108 + 1;
            goto L10
        L21:
            r103.f467624b.put("nativeErr", r106[r108]);
            goto L22
        L23:
            Iterator<Map.Entry<String, Long>> r111 = r103.f467623a.entrySet().iterator();
        L25:
            if (r111.hasNext() == false) goto L30;
            Map.Entry<String, Long> r112 = r111.next();
            String r113 = r112.getKey();
            Long r114 = r112.getValue();
            if (r105.f267352k != null) goto L29;
            r105.f267352k = new HashMap();
        L29:
            r105.f267352k.put(r113, r114);
            goto L25
        L30:
            Iterator<Map.Entry<String, String>> r115 = r103.f467624b.entrySet().iterator();
        L32:
            if (r115.hasNext() == false) goto L34;
            Map.Entry<String, String> r116 = r115.next();
            r105.i(r116.getKey(), r116.getValue());
            k.e("DurationMetric", "error tag " + r116.getKey() + " : " + r116.getValue());
            goto L32
        L34:
            r105.j();
            l.a(this.f267404g);
        }

        @Override // a97.a
        public final void b(PatchException r100) {
            k.b("PatchManager", "load patch failed " + this.f267401d.toString(), r100);
            c97.h r101 = this.f267401d;
            long r102 = this.f267402e;
            Event r103 = PatchEventReporter.b(r101, false);
            r103.f267345d = r102;
            r103.e(r100);
            r103.j();
            d97.d r104 = this.f267400c;
            r104.getClass();
            if (this.f267401d.equals(r104.f467633c) == true) goto L5;
            this.f267404g.l();
        L5:
            l.a(this.f267404g);
        }

        public b(l r100, a97.a r101, d97.d r102, c97.h r103, long r104, d97.b r105) {
            this.f267404g = r100;
            this.f267400c = r102;
            this.f267401d = r103;
            this.f267402e = r104;
            this.f267403f = r105;
            super(r101);
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d97.d f267405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f267406b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f267406b.g(this.f267405a, a97.a.f2281b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(l r100, d97.d r101) {
            this.f267406b = r100;
            this.f267405a = r101;
        }
    }

    public interface d {
        void onChanged();
    }

    static {
        f267380m = new Object();
        f267381n = new Object();
    }

    public final void e() {
        Object r100 = f267381n;
        monitor-enter(r100);
        Iterator<c97.h> r101 = this.f267385d.b().iterator();     // Catch: Throwable -> L44
    L6:
        if (r101.hasNext() == false) goto L27;
        c97.h r102 = r101.next();     // Catch: Throwable -> L44
        c97.e r103 = this.f267385d;     // Catch: Throwable -> L44
        r103.getClass();     // Catch: Throwable -> L44
        if (r102.f22894n == true) goto L22;
        boolean r104 = false;
        if (TextUtils.equals(r103.f22871a, r102.f22891k) == false) goto L23;
        boolean r105 = w87.b.g(r102.f22881a);     // Catch: Throwable -> L44
        if (r102.f22882b == false) goto L17;
        if (w87.b.f(r102.f22883c) == false) goto L17;
        r105 = false;
    L17:
        if (r102.f22884d == true) goto L19;
    L21:
        if (r105 == false) goto L23;
    L19:
        if (w87.b.g(r102.f22886f) == true) goto L21;
        r105 = false;
    L23:
        if (r104 == true) goto L6;
        r101.remove();     // Catch: Throwable -> L44
        if (this.f267392k == false) goto L6;
        w87.b.delete(r102.f22881a);     // Catch: Throwable -> L44
        l();     // Catch: Throwable -> L44
    L22:
        r104 = true;
        goto L23
    L27:
        Iterator<Map.Entry<c97.h, d97.d>> r106 = this.f267389h.entrySet().iterator();     // Catch: Throwable -> L44
    L29:
        if (r106.hasNext() == false) goto L36;
        Map.Entry<c97.h, d97.d> r107 = r106.next();     // Catch: Throwable -> L44
        d97.d r108 = r107.getValue();     // Catch: Throwable -> L44
        if (r108 == null) goto L29;
        c97.h r109 = r107.getKey();     // Catch: Throwable -> L44
        if (this.f267385d.b().contains(r109) == true) goto L29;
        j(r108);     // Catch: Throwable -> L44
        r106.remove();     // Catch: Throwable -> L44
        goto L29
    L36:
        Iterator<c97.h> r110 = this.f267385d.b().iterator();     // Catch: Throwable -> L44
    L38:
        if (r110.hasNext() == false) goto L42;
        c97.h r111 = r110.next();     // Catch: Throwable -> L44
        if (this.f267389h.get(r111) != null) goto L38;
        this.f267389h.put(r111, d97.d.a(r111, this.f267383b, this.f267382a, this.f267387f));     // Catch: Throwable -> L44
        goto L38
    L42:
        monitor-exit(r100);     // Catch: Throwable -> L44
        return;
    L44:
        th = move-exception;
        throw th;
    }

    public final void i() {
        List<d> r100 = this.f267388g;
        if (r100 != null) goto L5;
        return;
    L5:
        if (((ArrayList) r100).size() <= 0) goto L12;
        Iterator r101 = ((ArrayList) this.f267388g).iterator();
    L8:
        if (r101.hasNext() == false) goto L13;
        ((d) r101.next()).onChanged();
        goto L8
    L13:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public final void l() {
        if (this.f267392k == false) goto L62;
        c97.e r100 = this.f267385d;
        c97.f r101 = this.f267384c;
        r100.getClass();
        r101.getClass();
        String r102 = c97.f.a.b(r100);     // Catch: JSONException -> L8
        if (TextUtils.equals(SliceInitService.DEFAULT_SWITCH, r102) == true) goto L10;
    L11:
        File r103 = r101.f22873a.a();
        i r104 = r101.f22873a;
        ?? r105 = r6;
        if (r104.f267374d != null) goto L14;
        File r106 = r104.b();
        r104.f267374d = new PolarisFileWrapper(r106, "public.lock");
        r105 = r106;
    L14:
        PolarisFileWrapper r107 = r104.f267374d;
        c97.c r108 = null;
        w87.b.c(r103);     // Catch: Throwable -> L26 IOException -> L28
        PolarisFileOutputStreamWrapper r109 = new PolarisFileOutputStreamWrapper(r103);     // Catch: Throwable -> L26 IOException -> L28
        c97.c r110 = new c97.c(r107);     // Catch: IOException -> L24 Throwable -> L37
        r109.write(r102.getBytes());     // Catch: Throwable -> L20 IOException -> L22
        r110.close();     // Catch: IOException -> L34
        r105 = r109;
    L49:
    L36:
        w87.c.a(r105);
        return;
    L22:
        IOException e100 = e;
        r108 = r110;
        r105 = r109;
    L30:
        k.b("LocalRecordParser", "write local record failed. ", e100);     // Catch: Throwable -> L37
        if (r108 == null) goto L36;
        r108.close();     // Catch: IOException -> L34
        r105 = r105;
    L20:
        Throwable th10 = th;
        r108 = r110;
        ?? r111 = r109;
    L39:
        if (r108 != null) goto L47;
    L44:
        w87.c.a(r111);
        throw th10;
    L47:
        r108.close();     // Catch: IOException -> L42
    L42:
        e = move-exception;
        k.b("LocalRecordParser", "close lock helper failed.(write)", e);
    L24:
        e = move-exception;
        e100 = e;
        r105 = r109;
        goto L30
    L34:
        e = move-exception;
        k.b("LocalRecordParser", "close lock helper failed.(write)", e);
    L28:
        e = move-exception;
        e100 = e;
        r105 = 0;
    L26:
        th = move-exception;
        th10 = th;
        r111 = 0;
    L37:
        th = move-exception;
        th10 = th;
        r111 = r105;
    L10:
        r102 = "";
    L8:
        e = move-exception;
        String r112 = "to json error. ";
        k.b("LocalRecordParser", "to json error. " + r100.toString(), e);
        goto L10
    }

    public static void a(l r100) {
        r100.getClass();
        int r101 = WandTrick.e().nativeGetCheckRuntimeStartUp();     // Catch: Throwable -> L9
        int r102 = WandTrick.e().nativeGetHookRuntimeImageGenerateStatus();     // Catch: Throwable -> L9
        if (r102 == 0) goto L6;
        k.a("nativeGetHookRuntimeImageGenerateStatus", "nativeGetHookRuntimeImageGenerateStatus " + r102);     // Catch: Throwable -> L9
    L6:
        if (r101 == 0) goto L14;
        k.a("nativeGetCheckRuntimeStartUp", "nativeGetCheckRuntimeStartUp " + r101);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        k.b("PatchManager", "reportRuntimeImageGenerateCheckStatus", th);
    }

    public final void b(boolean r100) {
        Object r101 = f267381n;
        monitor-enter(r101);
        Object[] r102 = new Object[1];     // Catch: Throwable -> L18
        if (this.f267392k == false) goto L7;
        String r103 = PullConfiguration.PROCESS_NAME_MAIN;
    L8:
        r102[0] = r103;     // Catch: Throwable -> L18
        k.c("PatchManager", String.format("clear all patches in %s process.", r102));     // Catch: Throwable -> L18
        this.f267385d.b().clear();     // Catch: Throwable -> L18
        e();     // Catch: Throwable -> L18
        if (this.f267392k == false) goto L16;
        l();     // Catch: Throwable -> L18
        i r104 = this.f267382a;     // Catch: Throwable -> L18
        if (r104.f267375e != null) goto L13;
        r104.f267375e = new PolarisFileWrapper(r104.b(), "install");     // Catch: Throwable -> L18
    L13:
        w87.b.delete(r104.f267375e);     // Catch: Throwable -> L18
        if (r100 == false) goto L16;
        i();     // Catch: Throwable -> L18
    L16:
        monitor-exit(r101);     // Catch: Throwable -> L18
        return;
    L7:
        r103 = "sub";
    L18:
        th = move-exception;
        throw th;
    }

    public final boolean c(d97.d r100) {
        Object r101 = f267381n;
        monitor-enter(r101);
        Iterator<c97.h> r102 = this.f267389h.keySet().iterator();     // Catch: Throwable -> L25
    L6:
        if (r102.hasNext() == false) goto L15;
        c97.h r103 = r102.next();     // Catch: Throwable -> L25
        d97.d r104 = this.f267389h.get(r103);     // Catch: Throwable -> L25
        if (r104 == null) goto L6;
        if (r104.f467622a == false) goto L6;
        if (TextUtils.equals(r103.f22888h, r100.f467633c.f22888h) == false) goto L6;
        monitor-exit(r101);     // Catch: Throwable -> L25
        return true;
    L15:
        Iterator r105 = ((HashSet) this.f267391j).iterator();     // Catch: Throwable -> L25
    L17:
        if (r105.hasNext() == false) goto L22;
        if (TextUtils.equals(((d97.d) r105.next()).f467633c.f22888h, r100.f467633c.f22888h) == false) goto L17;
        monitor-exit(r101);     // Catch: Throwable -> L25
        return true;
    L22:
        monitor-exit(r101);     // Catch: Throwable -> L25
        return false;
    L25:
        th = move-exception;
        throw th;
    }

    public final boolean d(p r100) {
        Object r101 = f267381n;
        monitor-enter(r101);
        Iterator<c97.h> r102 = this.f267389h.keySet().iterator();     // Catch: Throwable -> L15
    L6:
        if (r102.hasNext() == false) goto L12;
        if (r100.a(r102.next()) == false) goto L6;
        monitor-exit(r101);     // Catch: Throwable -> L15
        return true;
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    public final void f(boolean r100) {
        if (r100 == false) goto L20;
        Object r101 = f267381n;
        monitor-enter(r101);
        c97.e r102 = this.f267384c.a();     // Catch: Throwable -> L17
        if (TextUtils.equals(this.f267385d.a(), r102.a()) == true) goto L8;
        c97.e r103 = this.f267385d;     // Catch: Throwable -> L17
        r103.f22871a = r102.a();     // Catch: Throwable -> L17
    L8:
        Set<c97.h> r104 = this.f267385d.b();     // Catch: Throwable -> L17
        Iterator<c97.h> r105 = r104.iterator();     // Catch: Throwable -> L17
    L10:
        if (r105.hasNext() == false) goto L14;
        c97.h r106 = r105.next();     // Catch: Throwable -> L17
        if (r102.b().contains(r106) == true) goto L10;
        r105.remove();     // Catch: Throwable -> L17
        goto L10
    L14:
        r104.addAll(r102.b());     // Catch: Throwable -> L17
        monitor-exit(r101);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L20:
        e();
        if (r100 == true) goto L30;
        Set<Map.Entry<c97.h, d97.d>> r107 = this.f267389h.entrySet();
        ArrayList r108 = new ArrayList();
        r108.addAll(r107);
        Collections.sort(r108, new m());
        Iterator r109 = r108.iterator();
    L24:
        if (r109.hasNext() == false) goto L30;
        d97.e r110 = ((d97.d) ((Map.Entry) r109.next()).getValue()).f467635e;
        if (r110 == null) goto L24;
        if (r110.c() == false) goto L24;
        WandTrick.f267316i = r110.a();
    L30:
        Iterator<Map.Entry<c97.h, d97.d>> r111 = this.f267389h.entrySet().iterator();
    L32:
        if (r111.hasNext() == false) goto L50;
        d97.d r112 = r111.next().getValue();
        if (r112 == null) goto L32;
        if (r112.f467622a == true) goto L32;
        if (r100 == true) goto L40;
        k(r112);
        goto L32
    L40:
        if (r112.f467633c.f22884d == false) goto L43;
        int r113 = 1;
    L46:
        if (r113 != 0) goto L47;
        k(r112);
        goto L32
    L47:
        h(r112, r113, a97.a.f2281b);
        goto L32
    L43:
        if (c(r112) == false) goto L45;
        r113 = 2;
        goto L46
    L45:
        r113 = 0;
        goto L46
    }

    public final void j(d97.d r100) {
        k.c("PatchManager", "start offline patch " + r100.f467633c.toString());
        a97.g r101 = r100.f467636f;
        d97.c r102 = r101.f2294b.f2291b;
        if (r102 == null) goto L5;
        r102.f467622a = false;
    L5:
        r101.f2295c.getClass();
        ((HashSet) this.f267391j).add(r100);
        r100.f467622a = false;
        if (this.f267392k == false) goto L9;
        w87.b.delete(r100.f467633c.f22881a);
        return;
    }

    public final void k(d97.d r100) {
        c97.h r101 = r100.f467633c;
        if (this.f267392k == false) goto L5;
    L8:
        boolean r102 = r101.f22892l;
        k.c("PatchManager", "postLoadTask, asyncLoad = " + r102);
        if (r102 == true) goto L11;
        g(r100, a97.a.f2281b);
        return;
    L11:
        e97.c.a().execute(new c(this, r100));
        return;
    L5:
        if (r101.f22893m == true) goto L8;
        k.c("PatchManager", "the patch doesn't support sub process " + r101.toString());
    }

    public void update(p r110) {
        if (this.f267392k == true) goto L5;
        return;
    L5:
        r110.getClass();
        StringBuilder r100 = new StringBuilder();
        r100.append(w87.d.a(r110.f267417b));
        r100.append("_");
        r100.append(w87.d.a(r110.f267421f));
        r100.append("_");
        r100.append(w87.d.a(r110.f267419d));
        r100.append("_");
        r100.append(w87.d.a(r110.f267418c));
        r100.append("_");
        String r101 = "1";
        if (r110.f267422g == false) goto L8;
        String r102 = "1";
    L9:
        r100.append(r102);
        r100.append("_");
        if (r110.f267423h == true) goto L13;
        r101 = "0";
    L13:
        r100.append(r101);
        String r103 = r100.toString();
        Object r104 = f267380m;
        monitor-enter(r104);
    L45:
        th = move-exception;
        throw th;
    L16:
        if (this.f267390i.containsKey(r103) == false) goto L21;
        k.c("PatchManager", "the patch update request already exist. " + r110.toString());     // Catch: Throwable -> L45
        monitor-exit(r104);     // Catch: Throwable -> L45
        return;
    L21:
        if (d(r110) == false) goto L25;
        k.c("PatchManager", "the patch already updated." + r110.toString());     // Catch: Throwable -> L45
        monitor-exit(r104);     // Catch: Throwable -> L45
        return;
    L25:
        this.f267390i.put(r103, r110);     // Catch: Throwable -> L45
        monitor-exit(r104);     // Catch: Throwable -> L45
        long r105 = SystemClock.elapsedRealtime();
        i r106 = this.f267382a;
        r106.getClass();
        if (r106.f267375e != null) goto L30;
        r106.f267375e = new PolarisFileWrapper(r106.b(), "install");
    L30:
        PolarisFileWrapper r111 = new PolarisFileWrapper(r106.f267375e, r110.f267419d);
        Application r107 = this.f267386e;
        File r108 = r110.f267416a;
        g r112 = this.f267383b;
        c97.a r113 = this.f267387f;
        z87.a r109 = new z87.a(r107, r108, r111, r112, r113, this.f267382a);
        a r114 = new a(this, r110, r105, r103);
    L42:
        th = move-exception;
        k.b("PatchInstaller", "", th);
        r109.d(r114, new PatchInstallException("install failed. ", th));
        return;
    L32:
        if (w87.b.g(r108) == true) goto L34;
        k.e("PatchInstaller", String.format("patch file %s not exists. install skipped.", new Object[]{r108.getAbsolutePath()}));     // Catch: Throwable -> L42
        r109.d(r114, new PatchInstallException(String.format("patch file %s not exists. install skipped.", new Object[]{r108.getAbsolutePath()})));     // Catch: Throwable -> L42
        return;
    L34:
        long r115 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L42
        k.c("PatchInstaller", "start install " + r108.getName());     // Catch: Throwable -> L42
        w87.b.delete(r111);     // Catch: Throwable -> L42
        c97.g r116 = new c97.g(r108, r113, r111, r112);     // Catch: Throwable -> L42
        r116.b();     // Catch: Throwable -> L42
        r109.c(r107, r116, r112);     // Catch: Throwable -> L42
        k.c("PatchInstaller", String.format("install " + r108.getName() + " success, cost %s milliseconds", new Object[]{String.valueOf(SystemClock.elapsedRealtime() - r115)}));     // Catch: Throwable -> L42
        z87.a.C8429a r117 = new z87.a.C8429a();     // Catch: Throwable -> L42
        r117.f570946a = r111;     // Catch: Throwable -> L42
        if ((!w87.b.f(r116.f22879f)) == false) goto L38;
        r117.f570947b = true;     // Catch: Throwable -> L42
        r117.f570948c = r116.f22879f;     // Catch: Throwable -> L42
    L38:
        if ((!((HashMap) r116.f22880g).isEmpty()) == false) goto L40;
        r117.f570949d = true;     // Catch: Throwable -> L42
        r117.f570950e = ((c97.j) ((HashMap) r116.f22880g).get(((c97.b) r116.f22876c).b())).f22902b;     // Catch: Throwable -> L42
        r117.f570951f = r116.f22878e;     // Catch: Throwable -> L42
    L40:
        r114.a(r117);     // Catch: Throwable -> L42
        return;
    L8:
        r102 = "0";
        goto L9
    }

    public final synchronized void g(d97.d r110, a97.a r111) {
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (r110.f467622a == false) goto L9;
        k.c("PatchManager", "already load " + r110.f467633c.toString());     // Catch: Throwable -> L25
        r111.d();     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L9:
        k.c("PatchManager", "start load patch " + r110.f467633c.toString());     // Catch: Throwable -> L25
        if (c(r110) == false) goto L14;
        h(r110, 2, r111);     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L14:
        c97.h r100 = r110.f467633c.a();     // Catch: Throwable -> L25
        long r101 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L25
        d97.b r102 = new d97.b();     // Catch: Throwable -> L25
        b r103 = new b(this, r111, r110, r100, r101, r102);     // Catch: Throwable -> L25
        r110.f467636f.a(r103, r102);     // Catch: Throwable -> L17 PatchException -> L19
    L23:
        monitor-exit(this);
        return;
    L19:
        e = move-exception;
        r103.b(e);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r111.a(new PatchException("unknownError", th, 0));     // Catch: Throwable -> L25
        goto L23
    }

    public static void h(d97.d r100, int r101, a97.a r102) {
        if ((r101 & 1) == 0) goto L6;
        k.c("PatchManager", "load in fake " + r100.f467633c.toString() + " : there are so libraries in the patch");
    L6:
        if ((r101 & 2) == 0) goto L8;
        k.c("PatchManager", "load in fake " + r100.f467633c.toString() + " : the patch of the same issueId has been posted online");
    L8:
        r100.getClass();
        r100.f467622a = true;
        r102.d();
    }

    public l(Application r100, i r101, g r102, c97.a r103, String r104, boolean r105) {
        this.f267389h = new ConcurrentHashMap();
        this.f267390i = new ConcurrentHashMap();
        this.f267391j = new HashSet();
        this.f267386e = r100;
        this.f267382a = r101;
        this.f267383b = r102;
        this.f267387f = r103;
        this.f267392k = r105;
        this.f267393l = r104;
        c97.f r106 = new c97.f(r101);
        this.f267384c = r106;
        this.f267385d = r106.a();
    }
}
