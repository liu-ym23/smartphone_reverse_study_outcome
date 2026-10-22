package com.bytedance.crash.monitor;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.crash.util.p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class e implements zg4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f203285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public fh4.h f203286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public fh4.d f203287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zg4.b f203288d;

    public zg4.b b() {
        return new zg4.b(this.f203285a);
    }

    public final void c() {
        zg4.b r100 = this.f203288d;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r100.f572050e == false) goto L9;
        monitor-exit(r100);
        return;
    L9:
        r100.f572050e = true;     // Catch: Throwable -> L12
        p.e("init：" + r100.f572049d.a());     // Catch: Throwable -> L12
        wh4.b.post(r100);     // Catch: Throwable -> L12
        monitor-exit(r100);
    }

    public e(f r100) {
        this.f203285a = r100;
        zg4.b r101 = b();
        this.f203288d = r101;
        if (r101.f572053h != null) goto L6;
        r101.f572053h = new CopyOnWriteArrayList();
    L6:
        if (((CopyOnWriteArrayList) r101.f572053h).contains(this) == true) goto L9;
        ((CopyOnWriteArrayList) r101.f572053h).add(this);
    L9:
        if (r101.f572051f == false) goto L12;
        a(r101.f572047b);
        return;
    }

    @Override // zg4.c
    public void a(JSONObject r100) {
        p.b("onConfigChanged:" + this.f203285a.a());
        if (r100 != null) goto L5;
        return;
    L5:
        d(r100);
        e(r100);
        fh4.f r101 = this.f203285a.e();
        fh4.d r102 = this.f203287c;
        r101.getClass();
        if (r102 == null) goto L9;
        p.e("updateConfig :" + r101.f477020d.a() + HTTP.HEADER_LINE_DELIM + r102);
        r101.f477017a = r102;
        wh4.b.f(r101);
        wh4.b.post(new fh4.e(r101));
        wh4.b.postDelayed(r101, 30000);
    L9:
        f r103 = this.f203285a;
        if (r103.f203289a != null) goto L20;
        monitor-enter(r103);
    L17:
        th = move-exception;
        throw th;
    L13:
        if (r103.f203289a != null) goto L15;
        r103.f203289a = new fh4.i(r103);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r103);     // Catch: Throwable -> L17
    L20:
        fh4.i r104 = r103.f203289a;
        fh4.h r105 = this.f203286b;
        if (r105 != null) goto L24;
        r104.getClass();
        return;
    L24:
        if (r104.f477049c.isEmpty() == true) goto L29;
        fh4.j r106 = r104.f477049c.poll();
        fh4.i.f477045h.decrementAndGet();
        if (r105.a(r106.f477054c) == false) goto L24;
        r104.f477048b.add(r106);
        fh4.i.f477044g.addAndGet(1);
        goto L24
    L29:
        if (fh4.i.f477046i == true) goto L34;
        fh4.i.a r107 = fh4.i.a.f477050b;
        if (r107.f477051a == true) goto L34;
        r107.f477051a = true;
        fh4.i.f477046i = true;
        wh4.b.f(r107);
        wh4.b.postDelayed(r107, 30000);
    L34:
        r104.f477047a = r105;
    }

    public void d(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        HashSet r101 = new HashSet();
        JSONObject r102 = r100.optJSONObject("custom_event_settings");
        if (r102 == null) goto L7;
        JSONObject r103 = r102.optJSONObject("allow_log_type");
    L8:
        boolean r104 = true;
        if (r103 == null) goto L16;
        Iterator<String> r105 = r103.keys();
    L12:
        if (r105.hasNext() == false) goto L16;
        String r106 = r105.next();
        if (r103.optInt(r106) != 1) goto L12;
        r101.add(r106);
    L16:
        JSONObject r107 = new JSONObject();
        JSONObject r108 = r100.optJSONObject("exception_modules");
        boolean r109 = false;
        if (r108 == null) goto L25;
        JSONObject r110 = r108.optJSONObject(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        if (r110 == null) goto L25;
        if (r110.optInt("enable_upload") == 1) goto L24;
        r104 = false;
    L24:
        r107 = r110.optJSONObject("metric_sampling");
        r109 = r104;
    L25:
        this.f203287c = new fh4.d(r101, r107, r109);
        p.b("parseEnsureConfig:" + this.f203285a.f203292d + " " + this.f203287c);
        return;
    L7:
        r103 = null;
        goto L8
    }

    public void e(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        HashSet r101 = new HashSet();
        JSONObject r102 = r100.optJSONObject("custom_event_settings");
        if (r102 == null) goto L7;
        JSONObject r103 = r102.optJSONObject("allow_service_name");
    L8:
        if (r103 == null) goto L15;
        Iterator<String> r104 = r103.keys();
    L11:
        if (r104.hasNext() == false) goto L15;
        String r105 = r104.next();
        if (r103.optInt(r105) != 1) goto L11;
        r101.add(r105);
    L15:
        this.f203286b = new fh4.h(r101);
        return;
    L7:
        r103 = null;
        goto L8
    }
}
