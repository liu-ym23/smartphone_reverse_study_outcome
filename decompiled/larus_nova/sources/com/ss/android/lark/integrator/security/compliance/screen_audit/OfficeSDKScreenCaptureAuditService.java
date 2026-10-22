package com.ss.android.lark.integrator.security.compliance.screen_audit;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.featuregating.interfaces.IFeatureGatingService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.q;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.LarkContext;
import f0c.h;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@UserScope
public final class OfficeSDKScreenCaptureAuditService implements q {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f428100n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IFeatureGatingService f428101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.integrator.security.compliance.screen_audit.d f428102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.integrator.security.compliance.screen_audit.b f428103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f428104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.auditsdk.screen.b f428105e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f428106f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f428107g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f428108h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f428109i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f428110j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f428111k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f428112l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Application f428113m;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSDKScreenCaptureAuditService f428114a;

        public b(OfficeSDKScreenCaptureAuditService r100) {
            this.f428114a = r100;
        }

        public final void a() {
            OfficeSDKScreenCaptureAuditService r100 = this.f428114a;
            if (r100.f428111k == false) goto L5;
            Log.w("OfficeSDKScreenAudit", "start() called more than once, ignored");
            return;
        L5:
            r100.f428111k = true;
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
            com.ss.android.lark.auditsdk.wrapper.b.d.f409722a.b();     // Catch: Throwable -> L8
            Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L10:
            Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
            if (r103 == null) goto L14;
            Log.e("OfficeSDKScreenAudit", "AuditModule.init failed", r103);
        L14:
            if (r100.f428112l == true) goto L17;
            r100.f428101a.addFeatureGatingUpdateListener("admin.security.activity_auditing_for_doubao_chat", r100.f428107g, "_normal_fg");
            r100.f428101a.addFeatureGatingUpdateListener("core.custom_mobile.enable_audit_device", r100.f428108h, "_normal_fg");
            r100.f428101a.addFeatureGatingUpdateListener("lark.security.screen_audit.officesdk_common_chain_disabled", r100.f428109i, "_normal_fg");
            r100.f428112l = true;
            Log.i("OfficeSDKScreenAudit", "fg update listeners registered");
        L17:
            r100.b("start");
            return;
        L8:
            th = move-exception;
            Result.Companion r104 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L10
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
    }

    public static final class c implements jdb.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSDKScreenCaptureAuditService f428115a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ OfficeSDKScreenCaptureAuditService f428116a;

            public a(OfficeSDKScreenCaptureAuditService r100) {
                this.f428116a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                OfficeSDKScreenCaptureAuditService r100 = this.f428116a;     // Catch: Throwable -> L4
                int r101 = OfficeSDKScreenCaptureAuditService.f428100n;     // Catch: Throwable -> L4
                r100.b("audit fg update");     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public c(OfficeSDKScreenCaptureAuditService r100) {
            this.f428115a = r100;
        }

        @Override // jdb.c
        public final void a(boolean r100) {
            OfficeSDKScreenCaptureAuditService r101 = this.f428115a;
            r101.f428104d.post(new a(r101));
        }
    }

    public static final class d implements jdb.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSDKScreenCaptureAuditService f428117a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ OfficeSDKScreenCaptureAuditService f428118a;

            public a(OfficeSDKScreenCaptureAuditService r100) {
                this.f428118a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                OfficeSDKScreenCaptureAuditService r100 = this.f428118a;     // Catch: Throwable -> L4
                int r101 = OfficeSDKScreenCaptureAuditService.f428100n;     // Catch: Throwable -> L4
                r100.b("chain-mode fg update");     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public d(OfficeSDKScreenCaptureAuditService r100) {
            this.f428117a = r100;
        }

        @Override // jdb.c
        public final void a(boolean r100) {
            OfficeSDKScreenCaptureAuditService r101 = this.f428117a;
            r101.f428104d.post(new a(r101));
        }
    }

    public static final class e implements jdb.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSDKScreenCaptureAuditService f428119a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ OfficeSDKScreenCaptureAuditService f428120a;

            public a(OfficeSDKScreenCaptureAuditService r100) {
                this.f428120a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                OfficeSDKScreenCaptureAuditService r100 = this.f428120a;     // Catch: Throwable -> L4
                int r101 = OfficeSDKScreenCaptureAuditService.f428100n;     // Catch: Throwable -> L4
                r100.b("device fg update");     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public e(OfficeSDKScreenCaptureAuditService r100) {
            this.f428119a = r100;
        }

        @Override // jdb.c
        public final void a(boolean r100) {
            OfficeSDKScreenCaptureAuditService r101 = this.f428119a;
            r101.f428104d.post(new a(r101));
        }
    }

    public static final class f implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSDKScreenCaptureAuditService f428121a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "outState");
        }

        public f(OfficeSDKScreenCaptureAuditService r100) {
            this.f428121a = r100;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            com.ss.android.lark.integrator.security.compliance.screen_audit.d r101 = this.f428121a.f428102b;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "activity");
            r101.c(r100);
            this.f428121a.f428103c.getClass();
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            this.f428121a.f428102b.b(r100);
            this.f428121a.f428103c.b(r100);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            this.f428121a.f428102b.c(r100);
            this.f428121a.f428103c.getClass();
            Intrinsics.checkNotNullParameter(r100, "activity");
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSDKScreenCaptureAuditService f428122a;

        public g(OfficeSDKScreenCaptureAuditService r100) {
            this.f428122a = r100;
        }

        public final void a() {
            OfficeSDKScreenCaptureAuditService r100 = this.f428122a;
            if (r100.f428111k == true) goto L5;
            Log.i("OfficeSDKScreenAudit", "stop() called but not started, skip");
            return;
        L5:
            Log.i("OfficeSDKScreenAudit", "stop, cleaning up");
            if (r100.f428112l == true) goto L43;
        L30:
            Application r101 = LarkContext.getApplication();
            if (r101 != null) goto L34;
            r101 = r100.f428113m;
        L34:
            if (r101 != null) goto L36;
            Log.e("OfficeSDKScreenAudit", "application is null, cleanup managers without lifecycle unregister");
            r100.f428102b.a();
            com.ss.android.lark.integrator.security.compliance.screen_audit.b r102 = r100.f428103c;
            int r103 = com.ss.android.lark.integrator.security.compliance.screen_audit.b.f428123d;
            r102.a(LarkContext.getApplication());
            r100.f428105e.a(null);
        L37:
            r100.f428111k = false;
            return;
        L36:
            r100.c(r101, false);
            r100.a(r101, false);
            r100.f428113m = null;
            goto L37
        L43:
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L10
            r100.f428101a.removeFeatureGatingUpdateListener(r100.f428107g, "_normal_fg");     // Catch: Throwable -> L10
            Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        L12:
            Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
            if (r106 == null) goto L39;
            Log.e("OfficeSDKScreenAudit", "remove audit fg listener failed", r106);
        L39:
            r100.f428101a.removeFeatureGatingUpdateListener(r100.f428108h, "_normal_fg");     // Catch: Throwable -> L17
            Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
        L19:
            Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
            if (r108 == null) goto L41;
            Log.e("OfficeSDKScreenAudit", "remove device fg listener failed", r108);
        L41:
            r100.f428101a.removeFeatureGatingUpdateListener(r100.f428109i, "_normal_fg");     // Catch: Throwable -> L24
            Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
        L26:
            Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
            if (r110 == null) goto L29;
            Log.e("OfficeSDKScreenAudit", "remove chain-mode fg listener failed", r110);
        L29:
            r100.f428112l = false;
            Log.i("OfficeSDKScreenAudit", "fg update listeners removed");
        L24:
            th = move-exception;
            Result.Companion r111 = Result.Companion;
            r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L17:
            th = move-exception;
            Result.Companion r112 = Result.Companion;
            r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L10:
            th = move-exception;
            Result.Companion r113 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L12
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
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Inject
    public OfficeSDKScreenCaptureAuditService(com.ss.android.lark.integrator.security.compliance.screen_audit.a r100) {
        Intrinsics.checkNotNullParameter(r100, "reporter");
        this.f428101a = FeatureGatingModule.getFeatureGatingService();
        this.f428102b = new com.ss.android.lark.integrator.security.compliance.screen_audit.d(r100);
        this.f428103c = new com.ss.android.lark.integrator.security.compliance.screen_audit.b(r100);
        this.f428104d = new Handler(Looper.getMainLooper());
        this.f428105e = new com.ss.android.lark.auditsdk.screen.b(r100, new OfficeSDKScreenCaptureAuditService$coordinator$1(this));
        this.f428106f = new f(this);
        this.f428107g = new c(this);
        this.f428108h = new e(this);
        this.f428109i = new d(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        Log.i("OfficeSDKScreenAudit", "afterUserOnline scene=" + r100.f475036b);
        this.f428104d.post(new b(this));
    }

    public final void b(String r110) {
        if (this.f428111k == true) goto L6;
        Log.i("OfficeSDKScreenAudit", "service stopped, ignore fg state update, reason=".concat(r110));
        return;
    L6:
        Application r100 = LarkContext.getApplication();
        if (r100 != null) goto L10;
        Log.e("OfficeSDKScreenAudit", "application is null, skip applyCurrentFGState, reason=".concat(r110));
        return;
    L10:
        this.f428113m = r100;
        boolean r101 = this.f428101a.isCurrentEnable("lark.security.screen_audit.officesdk_common_chain_disabled");
        boolean r102 = !r101;
        boolean r103 = this.f428101a.isCurrentEnable("admin.security.activity_auditing_for_doubao_chat");
        boolean r104 = this.f428101a.isCurrentEnable("core.custom_mobile.enable_audit_device");
        if (r103 == false) goto L14;
        if (r104 == false) goto L14;
        boolean r105 = true;
    L15:
        Log.i("OfficeSDKScreenAudit", "apply fg state, reason=" + r110 + " commonChainDisabled=" + r101 + " useCommonChain=" + r102 + " audit=" + r103 + " device=" + r104 + " commonFlowEnabled=" + r104 + " legacyEnabled=" + r105);
        if (r102 == false) goto L18;
        c(r100, false);
        a(r100, r104);
        return;
    L18:
        a(r100, false);
        c(r100, r105);
        return;
    L14:
        r105 = false;
        goto L15
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        Log.i("OfficeSDKScreenAudit", "onUserOffline scene=" + r100.f475036b);
        this.f428104d.post(new g(this));
    }

    public final void a(Application r100, boolean r101) {
        if (r101 == false) goto L25;
        Log.i("OfficeSDKScreenAudit", "common chain enabled, start screen audit coordinator");
        com.ss.android.lark.auditsdk.screen.b r102 = this.f428105e;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "application");
        if (r102.f409569d == true) goto L33;
        r100.registerActivityLifecycleCallbacks(r102.f409574i);     // Catch: Throwable -> L23
        r102.f409569d = true;
        r102.f409570e = r100;
        Log.i("ScreenAuditCore", "[" + r102.f409566a + "] coordinator started");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        com.ss.android.lark.appcontext.applifecycle.c r104 = com.ss.android.lark.appcontext.applifecycle.c.a.f408832a;     // Catch: Throwable -> L11
        r104.getClass();     // Catch: Throwable -> L11
        Object r105 = Result.m9449constructorimpl(Collections.unmodifiableSet(new LinkedHashSet(r104.f408828b)));     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r105) == false) goto L16;
        r105 = null;
    L16:
        Set r106 = (Set) r105;
        if (r106 != null) goto L19;
        r106 = SetsKt.emptySet();
    L19:
        Log.i("ScreenAuditCore", "[" + r102.f409566a + "] arm existing activities, count=" + r106.size());
        Iterator r107 = r106.iterator();
    L21:
        if (r107.hasNext() == false) goto L34;
        Activity r108 = (Activity) r107.next();
        r102.f409571f = new WeakReference(r108);
        com.ss.android.lark.auditsdk.screen.h r109 = r102.f409572g;
        Intrinsics.checkNotNull(r108);
        r109.a(r108);
        r102.f409573h.a(r108);
        goto L21
    L34:
        return;
    L11:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L23:
        th = move-exception;
        Log.e("ScreenAuditCore", "[" + r102.f409566a + "] register lifecycle failed", th);
        return;
    L33:
        return;
    L25:
        Log.i("OfficeSDKScreenAudit", "common chain disabled, stop screen audit coordinator");
        this.f428105e.a(r100);
    }

    public final void c(Application r100, boolean r101) {
        if (r101 == false) goto L27;
        if (this.f428110j == false) goto L7;
        return;
    L7:
        r100.registerActivityLifecycleCallbacks(this.f428106f);
        this.f428110j = true;
        Log.i("OfficeSDKScreenAudit", "legacy lifecycle callbacks registered, capture / recording listeners armed");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        com.ss.android.lark.appcontext.applifecycle.c r103 = com.ss.android.lark.appcontext.applifecycle.c.a.f408832a;     // Catch: Throwable -> L10
        r103.getClass();     // Catch: Throwable -> L10
        Object r104 = Result.m9449constructorimpl(Collections.unmodifiableSet(new LinkedHashSet(r103.f408828b)));     // Catch: Throwable -> L10
    L13:
        if (Result.m9455isFailureimpl(r104) == false) goto L15;
        r104 = null;
    L15:
        Set r105 = (Set) r104;
        if (r105 != null) goto L19;
        r105 = SetsKt.emptySet();
    L19:
        if (r105.isEmpty() == false) goto L21;
        Log.i("OfficeSDKScreenAudit", "no already-started activities to arm");
        return;
    L21:
        Iterator r106 = r105.iterator();
    L23:
        if (r106.hasNext() == false) goto L25;
        Activity r107 = (Activity) r106.next();
        com.ss.android.lark.integrator.security.compliance.screen_audit.d r108 = this.f428102b;
        Intrinsics.checkNotNull(r107);
        r108.b(r107);
        this.f428103c.b(r107);
        goto L23
    L25:
        Log.i("OfficeSDKScreenAudit", "armed existing started activities for legacy chain: count=" + r105.size());
        return;
    L10:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L27:
        if (this.f428110j == true) goto L29;
        return;
    L29:
        r100.unregisterActivityLifecycleCallbacks(this.f428106f);
        this.f428110j = false;
        this.f428102b.a();
        this.f428103c.a(r100);
        Log.i("OfficeSDKScreenAudit", "legacy lifecycle callbacks unregistered, all listeners cleaned");
    }
}
