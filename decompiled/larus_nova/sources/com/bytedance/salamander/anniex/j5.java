package com.bytedance.salamander.anniex;

import com.facebook.imagepipeline.memory.BitmapPoolType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class j5 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.bytedance.salamander.adapter.e f268153h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final com.bytedance.salamander.adapter.e f268154i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final j5 f268155j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final SLAnnieXMonitor f268156k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f268157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f268158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f268159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f268160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, SLAnnieXMonitor> f268161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<f4> f268162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<e4> f268163g;

    public static final class a {
    }

    static {
        new Semaphore(1);
        new Semaphore(1);
        f268153h = new com.bytedance.salamander.adapter.e();
        f268154i = new com.bytedance.salamander.adapter.e();
        f268155j = new j5();
        f268156k = new SLAnnieXMonitor(BitmapPoolType.DUMMY, false, false);
    }

    public j5() {
        this.f268161e = new LinkedHashMap();
        this.f268162f = new ArrayList();
        this.f268163g = new ArrayList();
    }

    public static void b(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "responseStr");
        z5.f268541a.getClass();
        Intrinsics.checkNotNullParameter(r100, "settingsString");
        if (f268155j.f268157a == true) goto L5;
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.c("HybridSettings", "disable parseSettingsWithV2Response");
        return;
    L5:
        final Function1<c6, Unit> r101 = new SLHybridSettings$Companion$parseSettingsWithV2Response$handleResponse$1(r100);
        Function1<Boolean, Object> r102 = new SLHybridSettings$Companion$parseSettingsWithV2Response$1$task$1(r100, r101);
        d8.f268040b.a(r102);
    }

    public final SLAnnieXMonitor a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        if (this.f268157a == false) goto L5;
        com.bytedance.salamander.adapter.e r101 = f268153h;
        if (r101.f267779a.f267780a.tryAcquire() == false) goto L9;
        SLAnnieXMonitor r102 = (SLAnnieXMonitor) ((LinkedHashMap) this.f268161e).get(r100);
        if (r102 != null) goto L13;
        r102 = new SLAnnieXMonitor(r100, this.f268158b, this.f268159c);
        com.bytedance.rts.foundation.m.e(this.f268161e, r100, r102);
    L13:
        r101.b();
        return r102;
    L9:
        return f268156k;
    L5:
        return f268156k;
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        com.bytedance.salamander.adapter.e r101 = f268153h;
        r101.a();
        final SLAnnieXMonitor r102 = (SLAnnieXMonitor) ((LinkedHashMap) this.f268161e).get(r100);
        if (r102 == null) goto L5;
        d8.f268040b.a(new SLAnnieXMonitor$reportMemory$1(r102));
    L5:
        com.bytedance.rts.foundation.m.delete(this.f268161e, r100);
        r101.b();
    }
}
