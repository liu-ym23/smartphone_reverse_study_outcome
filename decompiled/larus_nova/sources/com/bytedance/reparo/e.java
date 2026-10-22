package com.bytedance.reparo;

import android.app.Application;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.reparo.core.common.event.Event;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.core.l;
import com.bytedance.reparo.core.o;
import com.bytedance.reparo.model.PatchFetchInfo;
import com.bytedance.reparo.provider.ReparoProvider;
import com.bytedance.reparo.secondary.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements l.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile e f267426h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScheduledExecutorService f267427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Application f267428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f267429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f267430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f267431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f267432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RemotePatchFetcher f267433g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f267434a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f267434a.g();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(e r100) {
            this.f267434a = r100;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f267435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f267436b;

        public final void a(PatchException r100) {
            if ((r100 instanceof RemotePatchFetcher.ResponseNullException) == true) goto L11;
            Logger.b("PatchManager", "query remote patch info failed", r100);
        L8:
            long r101 = this.f267435a;
            Event r102 = com.bytedance.reparo.secondary.c.c(false);
            r102.f267345d = r101;
            r102.e(r100);
            r102.j();
            return;
        L11:
            Logger.f267463a.e("query remote patch info failed: " + r100.getMessage());     // Catch: Throwable -> L10
            goto L8
        }

        public final void b(List<PatchFetchInfo> r100) {
            e r101 = this.f267436b;
            long r102 = this.f267435a;
            monitor-enter(r101);
            String r103 = e97.b.a(r100);     // Catch: Throwable -> L13
            Logger.c();     // Catch: Throwable -> L13
            Event r104 = com.bytedance.reparo.secondary.c.c(true);     // Catch: Throwable -> L13
            r104.f267351j = r103;     // Catch: Throwable -> L13
            r104.f267345d = r102;     // Catch: Throwable -> L13
            r104.f267347f = true;     // Catch: Throwable -> L13
            r104.j();     // Catch: Throwable -> L13
            e.e(r100);     // Catch: Throwable -> L13
            List<PatchFetchInfo> r105 = r101.c(r100);     // Catch: Throwable -> L13
            e97.b.a(r105);     // Catch: Throwable -> L13
            Logger.c();     // Catch: Throwable -> L13
            ArrayList r106 = (ArrayList) r105;     // Catch: Throwable -> L13
            if (r106.size() <= 0) goto L10;
            Iterator r107 = r106.iterator();     // Catch: Throwable -> L13
        L8:
            if (r107.hasNext() == false) goto L11;
            PatchFetchInfo r108 = (PatchFetchInfo) r107.next();     // Catch: Throwable -> L13
            r101.a().execute(new f(r108, r101.f267429c));     // Catch: Throwable -> L13
        L11:
            monitor-exit(r101);
            return;
        L10:
            Logger.c();     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        }

        public b(e r100, long r101) {
            this.f267436b = r100;
            this.f267435a = r101;
        }
    }

    @Override // com.bytedance.reparo.core.l.d
    public final void onChanged() {
        Object[] r100 = new Object[1];
        if (this.f267431e == false) goto L5;
        String r101 = PullConfiguration.PROCESS_NAME_MAIN;
    L6:
        r100[0] = r101;
        String.format("patch changed in %s process", r100);
        Logger.c();
        if (this.f267431e == false) goto L16;
        Application r102 = this.f267428b;
        int r103 = ReparoProvider.f267462a;
        r102.getContentResolver().notifyChange(UriProtector.parse("content://" + r102.getPackageName() + ".reparo"), null);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        Logger.b("FrankieProvider", "notifySubProcess failed! ", e);
        return;
    L16:
        return;
    L5:
        r101 = "sub";
        goto L6
    }

    public static e b() {
        if (f267426h != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f267426h != null) goto L9;
        f267426h = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f267426h;
    }

    public final ScheduledExecutorService a() {
        if (this.f267427a != null) goto L6;
        this.f267427a = PThreadExecutorsUtils.newScheduledThreadPool(1, new e97.h());
    L6:
        return this.f267427a;
    }

    public final void f() {
        if (this.f267431e == false) goto L13;
        return;
    L13:
        this.f267428b.getContentResolver().registerContentObserver(UriProtector.parse("content://" + this.f267428b.getPackageName() + ".reparo"), true, new g97.a());     // Catch: Exception -> L7
        return;
    L11:
        Logger.f267463a.e("registerContentObserver failed, current process name: " + e97.f.b(this.f267428b));     // Catch: Throwable -> L10
        return;
    }

    public void update() {
        if (this.f267432f == true) goto L5;
        return;
    L5:
        if (this.f267431e == true) goto L7;
        return;
    L7:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        a().execute(new a(this));
        return;
    L9:
        g();
    }

    public e() {
        this.f267432f = false;
    }

    public final void g() {
        long r100 = SystemClock.elapsedRealtime();
        RemotePatchFetcher r101 = this.f267433g;
        b r102 = new b(this, r100);
        r101.getClass();
        int r103 = o.c().b();     // Catch: Throwable -> L15
        if (r103 != (-1)) goto L6;
        r102.a(new PatchException("wrong abi bits", 0));     // Catch: Throwable -> L15
    L18:
        return;
    L6:
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L15
        r104.put("patch", new JSONArray());     // Catch: Throwable -> L15
        int r105 = 1;
        if ((r101.f267295b.getApplicationInfo().flags & 2) == 0) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == true) goto L13;
        r105 = 0;
    L13:
        r104.put("debug", r105);     // Catch: Throwable -> L15
        Uri.Builder r107 = UriProtector.parse(g.a().f267450i).buildUpon();     // Catch: Throwable -> L15
        r107.appendQueryParameter("hotfix_abi", String.valueOf(r103));     // Catch: Throwable -> L15
        r107.appendQueryParameter("sdk_version", w87.d.a("0.0.4-rc.56"));     // Catch: Throwable -> L15
        r107.appendQueryParameter("hotfix_type", "reparo");     // Catch: Throwable -> L15
        r107.appendQueryParameter("channel", r101.f267294a.getChannel());     // Catch: Throwable -> L15
        r102.b(r101.a(r101.f267294a.executePatchRequest(33554432, r107.toString(), r104.toString().getBytes(), "application/json; charset=utf-8")));     // Catch: Throwable -> L15
        goto L18
    L9:
        r106 = false;
    L15:
        th = move-exception;
        r102.a(new PatchException("queryRemotePatchInfo error.", th, 0));
    }

    public static void e(List r100) {
        Iterator r101 = ((ConcurrentHashMap) o.c().e()).entrySet().iterator();
    L3:
        boolean r102 = false;
        if (r101.hasNext() == false) goto L13;
        Map.Entry r103 = (Map.Entry) r101.next();
        c97.h r104 = (c97.h) r103.getKey();
        d97.d r105 = (d97.d) r103.getValue();
        Iterator r106 = r100.iterator();
    L7:
        if (r106.hasNext() == false) goto L11;
        if (((PatchFetchInfo) r106.next()).equals(r104) == false) goto L7;
        r102 = true;
        goto L7
    L11:
        if (r102 == true) goto L3;
        r105.f467637g = true;
        goto L3
    L13:
        o r107 = o.c();
        r107.a();
        l r108 = r107.f267414d;
        r108.getClass();
        Object r109 = l.f267381n;
        monitor-enter(r109);
        Iterator<Map.Entry<c97.h, d97.d>> r110 = r108.f267389h.entrySet().iterator();     // Catch: Throwable -> L32
    L17:
        if (r110.hasNext() == false) goto L28;
        Map.Entry<c97.h, d97.d> r111 = r110.next();     // Catch: Throwable -> L32
        d97.d r112 = r111.getValue();     // Catch: Throwable -> L32
        if (r112 == null) goto L17;
        if (r112.f467637g == false) goto L17;
        if (r112.f467635e != null) goto L26;
        r108.f267385d.b().remove(r111.getKey());     // Catch: Throwable -> L32
    L27:
        r102 = true;
        goto L17
    L26:
        c97.h r113 = r111.getKey();     // Catch: Throwable -> L32
        r113.getClass();     // Catch: Throwable -> L32
        r113.f22891k += "_illegal";     // Catch: Throwable -> L32
        r113.f22894n = true;     // Catch: Throwable -> L32
        goto L27
    L28:
        if (r102 == false) goto L30;
        r108.e();     // Catch: Throwable -> L32
        r108.l();     // Catch: Throwable -> L32
        r108.i();     // Catch: Throwable -> L32
    L30:
        monitor-exit(r109);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw th;
    }

    public final List<PatchFetchInfo> c(List<PatchFetchInfo> r100) {
        ArrayList r101 = new ArrayList();
        Map<c97.h, d97.d> r102 = o.c().e();
        Iterator<PatchFetchInfo> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L26;
        PatchFetchInfo r104 = r103.next();
        boolean r105 = false;
        if (TextUtils.equals(this.f267430d, r104.getHostAppVersion()) == true) goto L8;
    L12:
        boolean r106 = false;
    L13:
        if (r106 == false) goto L4;
        ConcurrentHashMap r107 = (ConcurrentHashMap) r102;
        Set r108 = r107.keySet();
        if (r107.size() == 0) goto L17;
        Iterator r109 = r108.iterator();
    L20:
        if (r109.hasNext() == false) goto L24;
        if (r104.equals((c97.h) r109.next()) == false) goto L20;
        r105 = true;
        goto L20
    L24:
        if (r105 == true) goto L4;
        r101.add(r104);
        goto L4
    L17:
        r101.add(r104);
        goto L4
    L8:
        if (TextUtils.isEmpty(r104.getMd5()) == true) goto L12;
        if (TextUtils.isEmpty(r104.getUrl()) == true) goto L12;
        r106 = true;
        goto L13
    L26:
        return r101;
    }

    public final synchronized void d(Application r110, com.bytedance.reparo.secondary.b r111, boolean r112, String r113, com.bytedance.reparo.core.g r114) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.f267432f == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.f267431e = r112;     // Catch: Throwable -> L20
        this.f267428b = r110;     // Catch: Throwable -> L20
        this.f267430d = r113;     // Catch: Throwable -> L20
        this.f267429c = new d(r110);     // Catch: Throwable -> L20
        o r100 = o.c();     // Catch: Throwable -> L20
        Application r101 = this.f267428b;     // Catch: Throwable -> L20
        c97.a r102 = r111.getAbiHelper(r101);     // Catch: Throwable -> L20
        com.bytedance.reparo.secondary.f r115 = com.bytedance.reparo.secondary.f.a();     // Catch: Throwable -> L20
        ((HashSet) r115.f267481a).add("disableNewAndroid");     // Catch: Throwable -> L20
        if (r115.f267483c.opt("disableNewAndroid") == null) goto L10;
        boolean r116 = true;
    L11:
        if (r116 == true) goto L13;
        boolean r103 = true;
    L14:
        r100.d(r101, r114, r113, r102, r112, r103);     // Catch: Throwable -> L20
        o.c().f(this);     // Catch: Throwable -> L20
        this.f267433g = new RemotePatchFetcher(this.f267428b, r111);     // Catch: Throwable -> L20
        if (r112 == true) goto L17;
        f();     // Catch: Throwable -> L20
    L17:
        this.f267432f = true;     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L13:
        r103 = false;
        goto L14
    L10:
        r116 = false;
        goto L11
    }
}
