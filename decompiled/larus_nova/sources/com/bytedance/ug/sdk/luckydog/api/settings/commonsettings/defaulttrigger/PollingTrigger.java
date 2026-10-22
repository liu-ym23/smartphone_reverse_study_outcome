package com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.defaulttrigger;

import android.os.SystemClock;
import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;
import com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.h;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class PollingTrigger extends xk7.c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f271609l = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f271610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f271611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f271612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ScheduledFuture<?> f271613f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f271614g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f271615h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PollingTrigger$mAppLifecycleCallback$1 f271616i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ILuckyDogCommonSettingsService.Channel f271617j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f271618k;

    public static final class a implements com.bytedance.ug.sdk.luckydog.api.settings.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PollingTrigger f271619a;

        public a(PollingTrigger r100) {
            this.f271619a = r100;
        }

        @Override // com.bytedance.ug.sdk.luckydog.api.settings.d
        public final void a(ILuckyDogCommonSettingsService.Channel r100, boolean r101) {
            h r102 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.f271628a;
            xk7.e r103 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.b(this.f271619a.f271617j);
            if (r103 == null) goto L5;
            Long r104 = Long.valueOf(r103.h());
        L6:
            if (r101 == false) goto L13;
            long r105 = this.f271619a.f271618k;
            if (r104 != null) goto L11;
        L14:
            ScheduledFuture<?> r106 = this.f271619a.f271613f;
            if (r106 == null) goto L17;
            r106.cancel(false);
        L17:
            PollingTrigger r107 = this.f271619a;
            xk7.e r108 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.b(r107.f271617j);
            if (r108 == null) goto L20;
            long r109 = r108.h();
        L21:
            r107.f271618k = r109;
            PollingTrigger r110 = this.f271619a;
            PThreadScheduledThreadPoolExecutor r111 = yk7.f.f568242a;
            r110.f271613f = yk7.f.a(r110.d(), this.f271619a.f271618k);
            this.f271619a.f271614g.set(false);
            return;
        L20:
            r109 = this.f271619a.f271618k;
            goto L21
        L11:
            if (r105 != r104.longValue()) goto L14;
        L13:
            if (this.f271619a.f271614g.get() == true) goto L14;
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    static {
        f271609l = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PollingTrigger.class), "mRunnable", "getMRunnable()Ljava/lang/Runnable;"))};
    }

    public final Runnable d() {
        Lazy r100 = this.f271615h;
        KProperty r101 = f271609l[0];
        return (Runnable) r100.getValue();
    }

    @Override // jl7.a
    public final void b(xk7.e r100) {
        super.b(r100);
        to7.c.e(this.f271616i);
    }

    public PollingTrigger(ILuckyDogCommonSettingsService.Channel r100, long r101) {
        this.f271617j = r100;
        this.f271618k = r101;
        AtomicBoolean r102 = new AtomicBoolean(false);
        this.f271614g = r102;
        this.f271615h = LazyKt.lazy(new PollingTrigger$mRunnable$2(this));
        this.f271616i = new PollingTrigger$mAppLifecycleCallback$1(this);
        this.f271611d = this.f271618k;
        this.f271612e = SystemClock.elapsedRealtime();
        this.f271610c = SystemClock.elapsedRealtime();
        if (this.f271618k <= 0) goto L5;
        PThreadScheduledThreadPoolExecutor r103 = yk7.f.f568242a;
        this.f271613f = yk7.f.a(d(), this.f271618k);
        r102.set(false);
        to7.c.d(this.f271616i);
    L6:
        h r104 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.f271628a;
        xk7.e r105 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.b(r100);
        if (r105 == null) goto L10;
        a r106 = new a(this);
        r105.f564224d.add(r106);
        return;
    L10:
        return;
    L5:
        com.bytedance.ug.sdk.luckydog.api.log.d.a("PollingTrigger", "polling interval is less 0");
        goto L6
    }
}
