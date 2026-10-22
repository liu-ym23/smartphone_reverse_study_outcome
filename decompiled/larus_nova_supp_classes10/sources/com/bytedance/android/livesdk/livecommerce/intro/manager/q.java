package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.os.Looper;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q implements com.bytedance.android.livesdk.livecommerce.intro.manager.d {
    public final ArrayList<com.bytedance.android.livesdk.livecommerce.intro.manager.b> a;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ q a;

        public b(q r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ q a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Runnable c;

        public c(q r1, int r2, Runnable r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.i(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ q a;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.intro.manager.b b;
        public final /* synthetic */ Runnable c;

        public d(q r1, com.bytedance.android.livesdk.livecommerce.intro.manager.b r2, Runnable r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.d(this.b, this.c);     // Catch: Throwable -> L4
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

    public q() {
        this.a = new ArrayList();
    }

    public static boolean a() {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b() {
        if (a() == true) goto L6;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.a.b.post(new b(this));
        return;
    L6:
        dm.a.a("IntroCardQueue").a("release");
        this.a.clear();
    }

    public final int c(int r9, Runnable r10) {
        boolean r0 = false;
        int r1 = 0;
    L4:
        if (r1 >= this.a.size()) goto L12;
        com.bytedance.android.livesdk.livecommerce.intro.manager.b r2 = (com.bytedance.android.livesdk.livecommerce.intro.manager.b) CollectionsKt.getOrNull(this.a, r1);
        if (r2 == null) goto L10;
        if (r2.c == r9) goto L12;
    L10:
        r1 = r1 + 1;
    L12:
        if (r1 < this.a.size()) goto L20;
        if (r10 == null) goto L15;
        r10.run();
    L15:
        dm.a.b r3 = dm.a.a("IntroCardQueue");
        StringBuilder r5 = new StringBuilder("removeCard not find cardType: ");
        r5.append(r9);
        r5.append(" hideCard:");
        if (r10 == null) goto L18;
        r0 = true;
    L18:
        r5.append(r0);
        r5.append(" index:");
        r5.append(r1);
        r3.a(r5.toString());
        return -1;
    L20:
        com.bytedance.android.livesdk.livecommerce.intro.manager.b r4 = (com.bytedance.android.livesdk.livecommerce.intro.manager.b) ListProtector.remove(this.a, r1);
        if (r10 == null) goto L23;
        r10.run();
    L24:
        dm.a.b r6 = dm.a.a("IntroCardQueue");
        StringBuilder r7 = new StringBuilder("removeCard cardType: ");
        r7.append(r9);
        r7.append(" removeCard:");
        r7.append(r4);
        r7.append(" hideCard:");
        if (r10 == null) goto L27;
        r0 = true;
    L27:
        r7.append(r0);
        r6.a(r7.toString());
        return r1;
    L23:
        r4.e.run();
        goto L24
    }

    public final void d(com.bytedance.android.livesdk.livecommerce.intro.manager.b r9, Runnable r10) {
        Intrinsics.checkNotNullParameter(r9, "queueParams");
        if (a() == true) goto L6;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.a.b.post(new d(this, r9, r10));
        return;
    L6:
        dm.a.a("IntroCardQueue").a("requestShow params: " + r9);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_ANIM_OPT().a() == false) goto L9;
        c(r9.c, r10);
    L10:
        int r1 = this.a.size();
    L11:
        if (r1 < 0) goto L52;
        r1 = r1 - 1;
        if (r1 < 0) goto L14;
        com.bytedance.android.livesdk.livecommerce.intro.manager.b r3 = (com.bytedance.android.livesdk.livecommerce.intro.manager.b) CollectionsKt.getOrNull(this.a, r1);
        if (r3 == null) goto L11;
        boolean r6 = true;
        if (r9.a < r3.a) goto L20;
        if (r9.b == false) goto L11;
        com.bytedance.android.livesdk.livecommerce.intro.manager.b r4 = (com.bytedance.android.livesdk.livecommerce.intro.manager.b) CollectionsKt.getOrNull(this.a, r1);
        if (r4 == null) goto L11;
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_ANIM_OPT().a() == false) goto L37;
        int r5 = r4.c;
        if (r10 != null) goto L30;
    L35:
        Runnable r7 = null;
    L36:
        int r8 = c(r5, r7);
    L38:
        dm.a.a("IntroCardQueue").a("requestShow removeCard:" + r4 + " removeIndex:" + r8);
        goto L11
    L30:
        if (r5 == r9.c) goto L33;
        r6 = false;
    L33:
        if (r6 == false) goto L35;
        r7 = r10;
        goto L36
    L37:
        r8 = c(r4.c, null);
        goto L38
    L20:
        dm.a.a("IntroCardQueue").a("requestShow lastCard: " + r3 + " add queue");
        ListProtector.add(this.a, r1 + 1, r9);
        return;
    L14:
        this.a.add(r9);
        r9.d.run();
        dm.a.a("IntroCardQueue").a("requestShow queue is empty add and show");
        return;
    L52:
        return;
    L9:
        c(r9.c, null);
        goto L10
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.d
    public final void i(int r5, Runnable r6) {
        if (a() == true) goto L6;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.a.b.post(new c(this, r5, r6));
        return;
    L6:
        dm.a.b r1 = dm.a.a("IntroCardQueue");
        StringBuilder r2 = new StringBuilder("requestHide cardType: ");
        r2.append(r5);
        r2.append(" hideCard: ");
        if (r6 == null) goto L9;
        boolean r3 = true;
    L10:
        r2.append(r3);
        r1.a(r2.toString());
        int r7 = c(r5, r6);
        dm.a.a("IntroCardQueue").a("requestHide index:" + r7);
        if (r7 != 0) goto L18;
        com.bytedance.android.livesdk.livecommerce.intro.manager.b r8 = (com.bytedance.android.livesdk.livecommerce.intro.manager.b) CollectionsKt.firstOrNull(this.a);
        if (r8 == null) goto L19;
        Runnable r9 = r8.d;
        if (r9 == null) goto L20;
        r9.run();
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L9:
        r3 = false;
        goto L10
    }
}
