package com.bytedance.ug.sdk.luckydog.task.newTimer.network;

import android.app.Activity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import zm7.m;
import zm7.q;

/* JADX INFO: loaded from: classes22.dex */
public final class LuckyTimerReportWrapper extends uo7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f272049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile float f272050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f272051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f272052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedList<Integer> f272053e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f272054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f272055g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f272056h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f272057i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f272058j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f272059k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicLong f272060l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f272061m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f272062n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f272063o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f272064p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final m f272065q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final dm7.a f272066r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.bytedance.ug.sdk.luckydog.task.newTimer.pendant.d f272067s;

    public final void n(float r110) {
        float r100 = this.f272058j + r110;
        this.f272058j = r100;
        if (r100 < this.f272061m) goto L21;
        JSONObject r111 = new JSONObject();
        r111.put("cache_timer_interval", Float.valueOf(this.f272050b));
        this.f272058j = 0.0f;
        r111.put("expire_at", new LuckyTimerReportWrapper$incrTsCache$spExpireAt$1(this).invoke());
        if (this.f272065q.e() == null) goto L22;
        il7.m.a().k("lucky_cache_increment_" + this.f272065q.e(), r111.toString());
        String r101 = il7.m.a().e("lucky_cache_keys", "");
        if (r101 != null) goto L9;
    L12:
        boolean r112 = true;
    L13:
        if (r112 == false) goto L15;
        il7.m.a().k("lucky_cache_keys", this.f272065q.e());
        return;
    L15:
        List r113 = CollectionsKt.toMutableList(StringsKt.split$default(r101, new String[]{","}, false, 0, 6, null));
        String r102 = this.f272065q.e();
        if (r102 != null) goto L18;
        return;
    L18:
        if (r113.contains(r102) == true) goto L25;
        r113.add(r102);
        il7.m.a().k("lucky_cache_keys", CollectionsKt.joinToString$default(r113, ",", null, null, 0, null, null, 62, null));
        return;
    L25:
        return;
    L9:
        if (r101.length() == 0) goto L12;
        r112 = false;
        goto L13
    L22:
        return;
    }

    @Override // uo7.c, uo7.b
    public final void onEnterBackground(Activity r100) {
        super.onEnterBackground(r100);
        if (this.f272065q.d() != null) goto L5;
    L17:
        boolean r101 = true;
    L18:
        if (r101 == false) goto L22;
        to7.c.e(this);
        return;
    L22:
        if (this.f272050b == 0.0f) goto L25;
        o(this, this.f272050b, false, "onEnterBackground");
        return;
    L25:
        return;
    L5:
        if (this.f272065q.a() == true) goto L17;
        q r102 = this.f272065q.d();
        if (r102 == null) goto L16;
        if (r102.a() >= r102.f()) goto L12;
    L14:
        r101 = false;
        goto L18
    L12:
        if (r102.f() == (-1)) goto L14;
    L16:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.ug.sdk.luckyhost.api.api.timer.TimerConfig");
    }

    public static final void l(LuckyTimerReportWrapper r100, float r101) {
        r100.getClass();
        JSONObject r102 = new JSONObject(il7.m.a().e("lucky_cache_increment_" + r100.f272065q.e(), ""));     // Catch: Exception -> L5
        r102.put("cache_timer_interval", Float.valueOf(r101));     // Catch: Exception -> L5
        il7.m.a().k("lucky_cache_increment_" + r100.f272065q.e(), r102.toString());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b(r100.f272049a, "setCacheIncTime(), interval = " + r101 + ", " + e.getMessage());
    }

    public static void o(LuckyTimerReportWrapper r100, float r110, boolean r111, String r112) {
        monitor-enter(r100);
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L19
        if (r100.f272056h.get() == false) goto L7;
    L16:
        com.bytedance.ug.sdk.luckydog.api.log.d.d(r100.f272049a, "report retrun, isRequesting = " + r100.f272056h + ", incrTime = " + r110);     // Catch: Throwable -> L19
        monitor-exit(r100);
        return;
    L7:
        if ((r101 - r100.f272060l.get()) < 1000) goto L16;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(r100.f272049a, "report incrTime = " + r110 + ", isAdjust = " + r111 + ", from = " + r112);     // Catch: Throwable -> L19
        r100.f272056h.set(true);     // Catch: Throwable -> L19
        r100.f272060l.set(r101);     // Catch: Throwable -> L19
        c r113 = c.f272080c;     // Catch: Throwable -> L19
        String r102 = r100.f272064p;     // Catch: Throwable -> L19
        int r103 = (int) r110;     // Catch: Throwable -> L19
        d r104 = new d(r100, null, r110, r111);     // Catch: Throwable -> L19
        if (r100.f272054f == true) goto L12;
        boolean r105 = true;
    L13:
        r113.getClass();     // Catch: Throwable -> L19
        c.w(r102, r101, r103, r104, r105);     // Catch: Throwable -> L19
        r100.f272056h.set(false);     // Catch: Throwable -> L19
        monitor-exit(r100);
        return;
    L12:
        r105 = false;
    L19:
        th = move-exception;
        throw th;
    }

    public LuckyTimerReportWrapper(String r100, String r101, m r102, dm7.a r103, com.bytedance.ug.sdk.luckydog.task.newTimer.pendant.d r104) {
        this.f272063o = r100;
        this.f272064p = r101;
        this.f272065q = r102;
        this.f272066r = r103;
        this.f272067s = r104;
        this.f272049a = "LuckyTimerReportWrapper";
        float r105 = 0.0f;
        float r106 = new JSONObject(il7.m.a().e("lucky_cache_increment_" + r102.e(), "")).optLong("cache_timer_interval", 0);     // Catch: Exception -> L5
    L6:
        this.f272050b = r106;
        this.f272051c = new AtomicLong(86400000);
        q r107 = this.f272065q.d();
        if (r107 == null) goto L9;
        r105 = r107.a();
    L9:
        this.f272052d = r105;
        this.f272053e = new LinkedList();
        boolean r108 = false;
        this.f272056h = new AtomicBoolean(false);
        this.f272060l = new AtomicLong(0);
        this.f272061m = il7.m.a().c("progress_persist_interval_ts", 30);
        this.f272062n = this.f272065q.e();
        to7.c.d(this);
        this.f272052d += this.f272050b;
        q r109 = this.f272065q.d();
        if (r109 == null) goto L27;
        List<Integer> r110 = r109.d();
        if (r110 != null) goto L14;
    L15:
        r108 = true;
    L16:
        if (r108 == true) goto L35;
        List<Integer> r111 = r109.d();
        if (r111 != null) goto L21;
        Intrinsics.throwNpe();
    L21:
        Iterator<Integer> r112 = r111.iterator();
    L23:
        if (r112.hasNext() == false) goto L36;
        int r113 = r112.next().intValue();
        if (r113 < r109.a()) goto L23;
        this.f272053e.add(Integer.valueOf(r113));
        goto L23
    L36:
        return;
    L35:
        return;
    L14:
        if (r110.isEmpty() == false) goto L16;
    L27:
        return;
    L5:
        r106 = 0.0f;
        goto L6
    }
}
