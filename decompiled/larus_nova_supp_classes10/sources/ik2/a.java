package ik2;

import android.os.Looper;
import com.bytedance.android.ec.common.api.card.CardType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements ef.a {
    public final ArrayList<ef.d> a;

    /* JADX INFO: renamed from: ik2.a$a, reason: collision with other inner class name */
    public static final class C0144a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;

        public b(a r1) {
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
        public final /* synthetic */ a a;
        public final /* synthetic */ CardType b;
        public final /* synthetic */ Runnable c;

        public c(a r1, CardType r2, Runnable r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c(this.b, this.c);     // Catch: Throwable -> L4
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
        public final /* synthetic */ a a;
        public final /* synthetic */ ef.d b;

        public d(a r1, ef.d r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.l(this.b);     // Catch: Throwable -> L4
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
        this.a = new ArrayList();
    }

    public final boolean a() {
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
        dm.a.a("CardManager").a("release");
    L8:
        if (this.a.size() <= 0) goto L10;
        ((ef.d) ListProtector.remove(this.a, 0)).e.run();
        goto L8
    }

    public final void l(ef.d r9) {
        Intrinsics.checkNotNullParameter(r9, "params");
        if (a() == true) goto L6;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.a.b.post(new d(this, r9));
        return;
    L6:
        dm.a.a("CardManager").a("requestShow params: " + r9);
        d(r9.c, null);
        int r1 = this.a.size();
    L7:
        if (r1 < 0) goto L26;
        r1 = r1 - 1;
        if (r1 < 0) goto L10;
        ef.d r3 = (ef.d) ListProtector.get(this.a, r1);
        if (r9.a < r3.a) goto L13;
        if (r9.b == false) goto L7;
        ef.d r4 = (ef.d) ListProtector.get(this.a, r1);
        int r5 = d(r4.c, null);
        dm.a.a("CardManager").a("requestShow removeCard:" + r4 + " removeIndex:" + r5);
        goto L7
    L13:
        dm.a.a("CardManager").a("requestShow lastCard: " + r3 + " add queue");
        ListProtector.add(this.a, r1 + 1, r9);
        return;
    L10:
        this.a.add(r9);
        r9.d.run();
        dm.a.a("CardManager").a("requestShow queue is empty add and show");
        return;
    }

    public final void c(CardType r5, Runnable r6) {
        Intrinsics.checkNotNullParameter(r5, "cardType");
        if (a() == true) goto L6;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.a.b.post(new c(this, r5, r6));
        return;
    L6:
        dm.a.b r1 = dm.a.a("CardManager");
        StringBuilder r2 = new StringBuilder("requestHide cardType: ");
        r2.append(r5);
        r2.append(" hideCard: ");
        if (r6 == null) goto L9;
        boolean r3 = true;
    L10:
        r2.append(r3);
        r1.a(r2.toString());
        int r7 = d(r5, r6);
        dm.a.a("CardManager").a("requestHide index:" + r7);
        if (r7 != 0) goto L18;
        ef.d r8 = (ef.d) CollectionsKt.firstOrNull(this.a);
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

    public final int d(CardType r9, Runnable r10) {
        boolean r0 = false;
        int r1 = 0;
    L4:
        if (r1 >= this.a.size()) goto L10;
        if (((ef.d) ListProtector.get(this.a, r1)).c == r9) goto L10;
        r1 = r1 + 1;
    L10:
        if (r1 < this.a.size()) goto L18;
        if (r10 == null) goto L13;
        r10.run();
    L13:
        dm.a.b r2 = dm.a.a("CardManager");
        StringBuilder r5 = new StringBuilder("removeCard not find cardType: ");
        r5.append(r9);
        r5.append(" hideCard:");
        if (r10 == null) goto L16;
        r0 = true;
    L16:
        r5.append(r0);
        r5.append(" index:");
        r5.append(r1);
        r2.a(r5.toString());
        return -1;
    L18:
        ef.d r3 = (ef.d) ListProtector.remove(this.a, r1);
        if (r10 == null) goto L21;
        r10.run();
    L22:
        dm.a.b r6 = dm.a.a("CardManager");
        StringBuilder r7 = new StringBuilder("removeCard cardType: ");
        r7.append(r9);
        r7.append(" removeCard:");
        r7.append(r3);
        r7.append(" hideCard:");
        if (r10 == null) goto L25;
        r0 = true;
    L25:
        r7.append(r0);
        r6.a(r7.toString());
        return r1;
    L21:
        r3.e.run();
        goto L22
    }
}
