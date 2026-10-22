package ik2;

import android.os.Looper;
import com.bytedance.android.ec.common.api.card.CardType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements ef.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<ef.d> f490261a;

    /* JADX INFO: renamed from: ik2.a$a, reason: collision with other inner class name */
    public static final class C6279a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f490262a;

        public b(a r100) {
            this.f490262a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f490262a.b();     // Catch: Throwable -> L4
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f490263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CardType f490264b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Runnable f490265c;

        public c(a r100, CardType r101, Runnable r102) {
            this.f490263a = r100;
            this.f490264b = r101;
            this.f490265c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f490263a.c(this.f490264b, this.f490265c);     // Catch: Throwable -> L4
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f490266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ef.d f490267b;

        public d(a r100, ef.d r101) {
            this.f490266a = r100;
            this.f490267b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f490266a.l(this.f490267b);     // Catch: Throwable -> L4
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
        this.f490261a = new ArrayList();
    }

    public final boolean a() {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b() {
        if (a() == true) goto L6;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.a.f151988b.post(new b(this));
        return;
    L6:
        dm.a.a("CardManager").a("release");
    L8:
        if (this.f490261a.size() <= 0) goto L10;
        ((ef.d) ListProtector.remove(this.f490261a, 0)).f472409e.run();
        goto L8
    }

    @Override // ef.a
    public final void l(ef.d r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (a() == true) goto L6;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.a.f151988b.post(new d(this, r100));
        return;
    L6:
        dm.a.a("CardManager").a("requestShow params: " + r100);
        d(r100.f472407c, null);
        int r101 = this.f490261a.size();
    L7:
        if (r101 < 0) goto L26;
        r101 = r101 - 1;
        if (r101 < 0) goto L10;
        ef.d r102 = (ef.d) ListProtector.get(this.f490261a, r101);
        if (r100.f472405a < r102.f472405a) goto L13;
        if (r100.f472406b == false) goto L7;
        ef.d r103 = (ef.d) ListProtector.get(this.f490261a, r101);
        int r104 = d(r103.f472407c, null);
        dm.a.a("CardManager").a("requestShow removeCard:" + r103 + " removeIndex:" + r104);
        goto L7
    L13:
        dm.a.a("CardManager").a("requestShow lastCard: " + r102 + " add queue");
        ListProtector.add(this.f490261a, r101 + 1, r100);
        return;
    L10:
        this.f490261a.add(r100);
        r100.f472408d.run();
        dm.a.a("CardManager").a("requestShow queue is empty add and show");
        return;
    }

    @Override // ef.a
    public final void c(CardType r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "cardType");
        if (a() == true) goto L6;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.a.f151988b.post(new c(this, r100, r101));
        return;
    L6:
        dm.a.b r102 = dm.a.a("CardManager");
        StringBuilder r103 = new StringBuilder("requestHide cardType: ");
        r103.append(r100);
        r103.append(" hideCard: ");
        if (r101 == null) goto L9;
        boolean r104 = true;
    L10:
        r103.append(r104);
        r102.a(r103.toString());
        int r105 = d(r100, r101);
        dm.a.a("CardManager").a("requestHide index:" + r105);
        if (r105 != 0) goto L18;
        ef.d r106 = (ef.d) CollectionsKt.firstOrNull(this.f490261a);
        if (r106 == null) goto L19;
        Runnable r107 = r106.f472408d;
        if (r107 == null) goto L20;
        r107.run();
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L9:
        r104 = false;
        goto L10
    }

    public final int d(CardType r100, Runnable r110) {
        boolean r101 = false;
        int r102 = 0;
    L4:
        if (r102 >= this.f490261a.size()) goto L10;
        if (((ef.d) ListProtector.get(this.f490261a, r102)).f472407c == r100) goto L10;
        r102 = r102 + 1;
    L10:
        if (r102 < this.f490261a.size()) goto L18;
        if (r110 == null) goto L13;
        r110.run();
    L13:
        dm.a.b r103 = dm.a.a("CardManager");
        StringBuilder r104 = new StringBuilder("removeCard not find cardType: ");
        r104.append(r100);
        r104.append(" hideCard:");
        if (r110 == null) goto L16;
        r101 = true;
    L16:
        r104.append(r101);
        r104.append(" index:");
        r104.append(r102);
        r103.a(r104.toString());
        return -1;
    L18:
        ef.d r105 = (ef.d) ListProtector.remove(this.f490261a, r102);
        if (r110 == null) goto L21;
        r110.run();
    L22:
        dm.a.b r106 = dm.a.a("CardManager");
        StringBuilder r107 = new StringBuilder("removeCard cardType: ");
        r107.append(r100);
        r107.append(" removeCard:");
        r107.append(r105);
        r107.append(" hideCard:");
        if (r110 == null) goto L25;
        r101 = true;
    L25:
        r107.append(r101);
        r106.a(r107.toString());
        return r102;
    L21:
        r105.f472409e.run();
        goto L22
    }
}
