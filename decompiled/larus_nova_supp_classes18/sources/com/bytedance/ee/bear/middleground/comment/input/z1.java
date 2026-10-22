package com.bytedance.ee.bear.middleground.comment.input;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z1 extends com.ss.android.lark.appcontext.applifecycle.a {
    public boolean a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ kf5.b c;
    public final /* synthetic */ Function0<Unit> d;

    public static final class a implements Runnable {
        public final /* synthetic */ kf5.b a;

        public a(kf5.b r1) {
            this.a = r1;
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
            if (this.a.e().isAttachedToWindow() == false) goto L9;
            this.a.e().requestFocus();     // Catch: Throwable -> L6
            this.a.l();     // Catch: Throwable -> L6
            return;
        }
    }

    public final void onActivityDestroyed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        int r0 = a2.a;
        if (Intrinsics.areEqual(r2, this.b) == false) goto L6;
        AppLifecycle.a.a.j(this);
        return;
    }

    public final void onActivityPaused(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        int r0 = a2.a;
        if (Intrinsics.areEqual(r2, this.b) == false) goto L6;
        this.a = true;
        return;
    }

    public final void onActivityResumed(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        int r0 = a2.a;
        if (Intrinsics.areEqual(r3, this.b) == true) goto L7;
        this.a = true;
        return;
    L7:
        if (this.a == true) goto L9;
        return;
    L9:
        AppLifecycle.a.a.j(this);
        this.c.c("BotConfigKeepAlive");
        this.d.invoke();
        rcb.e.a(new a(this.c), 100);
    }

    public z1(FragmentActivity r1, kf5.b r2, Function0 r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }
}
