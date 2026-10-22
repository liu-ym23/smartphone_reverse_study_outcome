package io2;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: io2.a$a, reason: collision with other inner class name */
    public static final class C6336a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f495190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f495191b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f495192c;

        public b(a r100, Activity r101, boolean r102) {
            this.f495190a = r100;
            this.f495191b = r101;
            this.f495192c = r102;
        }

        public final void a() {
            Window r100 = this.f495191b.getWindow();
            if (r100 == null) goto L13;
            System.currentTimeMillis();
            View r101 = r100.getDecorView();
            if (c.f346345e == false) goto L10;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == c.f346341a) goto L10;
            c.a(r102, "getDecorView");
        L10:
            if (this.f495192c == false) goto L12;
            r100.addFlags(128);
            goto L13
        L12:
            r100.clearFlags(128);
            this.f495190a.getClass();
            a.a(r101);
        L13:
            this.f495190a.getClass();
            ALogger.d("LiveSleep_ScreenControlHelper", "real setKeepScreenOn:" + this.f495192c + ", screen auto off time:-1");
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

    public a() {
    }

    public static void a(View r100) {
        r100.setKeepScreenOn(false);
        if ((r100 instanceof ViewGroup) == false) goto L10;
        Iterator<View> r101 = UtilityKotlinExtentionsKt.g((ViewGroup) r100).iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        View r102 = r101.next();
        if (r102 == null) goto L6;
        a(r102);
        goto L6
    L16:
        return;
    }

    public final void b(boolean r100, Activity r101) {
        ALogger.d("LiveSleep_ScreenControlHelper", "setKeepScreenOn:" + r100 + ", activity:" + r101);
        MainThreadPostUtils.b(new b(this, r101, r100));
    }
}
