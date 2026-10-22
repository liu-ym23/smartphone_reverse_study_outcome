package com.bytedance.ee.bear.middleground.comment.input;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class z1 extends com.ss.android.lark.appcontext.applifecycle.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f232029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f232030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ kf5.b f232031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f232032d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kf5.b f232033a;

        public a(kf5.b r100) {
            this.f232033a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.f232033a.e().isAttachedToWindow() == false) goto L9;
            this.f232033a.e().requestFocus();     // Catch: Throwable -> L6
            this.f232033a.l();     // Catch: Throwable -> L6
            return;
        }
    }

    @Override // com.ss.android.lark.appcontext.applifecycle.a, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        int r101 = a2.f231893a;
        if (Intrinsics.areEqual(r100, this.f232030b) == false) goto L6;
        AppLifecycle.a.f408803a.j(this);
        return;
    }

    @Override // com.ss.android.lark.appcontext.applifecycle.a, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        int r101 = a2.f231893a;
        if (Intrinsics.areEqual(r100, this.f232030b) == false) goto L6;
        this.f232029a = true;
        return;
    }

    @Override // com.ss.android.lark.appcontext.applifecycle.a, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        int r101 = a2.f231893a;
        if (Intrinsics.areEqual(r100, this.f232030b) == true) goto L7;
        this.f232029a = true;
        return;
    L7:
        if (this.f232029a == true) goto L9;
        return;
    L9:
        AppLifecycle.a.f408803a.j(this);
        this.f232031c.c("BotConfigKeepAlive");
        this.f232032d.invoke();
        rcb.e.a(new a(this.f232031c), 100);
    }

    public z1(FragmentActivity r100, kf5.b r101, Function0 r102) {
        this.f232030b = r100;
        this.f232031c = r101;
        this.f232032d = r102;
    }
}
