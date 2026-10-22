package kk1;

import android.os.Handler;
import com.bytedance.android.live.core.cmc.setting.CMCSettings;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livesdk.config.i20;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Runnable f503758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f503759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f503760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f503761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f503762e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f503763a;

        public final void a() {
            if (this.f503763a.f503758a == null) goto L6;
            tn1.c.a("InteractionShowScheduler", "timeout mShowInteractionTask=" + this.f503763a.f503758a + " mIdentify=" + this.f503763a.f503759b);
            this.f503763a.f();
            return;
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

        public a(e r100) {
            this.f503763a = r100;
        }
    }

    public final void d() {
        this.f503762e = true;
        a();
    }

    public final void a() {
        if (this.f503758a != null) goto L5;
        return;
    L5:
        int r100 = i20.f120421a.getValue().mStrategy;
        if (r100 != 0) goto L8;
        f();
        return;
    L8:
        if (r100 == 1) goto L23;
        if (r100 == 2) goto L20;
        if (r100 == 3) goto L15;
        return;
    L15:
        if (this.f503762e == true) goto L17;
        return;
    L17:
        if (this.f503761d != 0) goto L28;
        f();
        return;
    L28:
        return;
    L20:
        if (this.f503761d != 0) goto L30;
        tn1.c.a("InteractionShowScheduler", "idle mShowInteractionTask=" + this.f503758a + " mIdentify=" + this.f503759b);
        f();
        return;
    L30:
        return;
    L23:
        if (this.f503762e == false) goto L32;
        f();
        return;
    }

    public final void c() {
        if (i20.f120421a.getValue().mEnableCmc == true) goto L5;
    L7:
        this.f503758a = null;
        i0.c().removeCallbacks(this.f503760c);
        this.f503761d = 0;
        this.f503762e = false;
        return;
    L5:
        if (this.f503758a == null) goto L7;
        tn1.c.a("InteractionShowScheduler", "removeCallbacks mShowInteractionTask=" + this.f503758a + " mIdentify=" + this.f503759b);
        i0.k(this.f503759b, this.f503758a);
        goto L7
    }

    public final void f() {
        if (this.f503758a == null) goto L21;
        i20 r100 = i20.f120421a;
        if (r100.getValue().mInsertQueue == false) goto L8;
        i0.f(this.f503758a);
        goto L21
    L8:
        if (r100.getValue().mEnableCmc == false) goto L20;
        String r101 = this.f503759b;
        Runnable r102 = this.f503758a;
        if (r102 == null) goto L21;
        Handler r103 = i0.c();
        if (i0.b() == true) goto L15;
    L19:
        r103.postAtTime(r102, 3);
        goto L21
    L15:
        if (CMCSettings.LIVE_CMC_CONFIG.getValue().mInsertSupport == false) goto L19;
        if (i0.f66192b.b(r101, r102, 3) == true) goto L21;
        r103.postAtTime(r102, 3);
        goto L21
    L20:
        this.f503758a.run();
    L21:
        this.f503758a = null;
        i0.c().removeCallbacks(this.f503760c);
        this.f503761d = 0;
        this.f503762e = false;
    }

    public e() {
        this.f503760c = new a(this);
        this.f503761d = 0;
        this.f503762e = false;
    }

    public final void e(int r100) {
        this.f503761d = r100;
        tn1.c.a("InteractionShowScheduler", "onStateChanged mState=" + this.f503761d);
        a();
    }

    public final void b(Runnable r100, String r101) {
        this.f503758a = r100;
        this.f503759b = r101;
        a();
        if (this.f503758a == null) goto L6;
        i0.c().postDelayed(this.f503760c, i20.f120421a.getValue().mTimeout);
        return;
    }
}
