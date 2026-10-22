package yy4;

import android.app.Application;
import android.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.doc.resupdate.d0;
import com.bytedance.ee.util.ui.m;
import com.bytedance.geckox.model.UpdatePackage;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class b extends xy4.a implements Cloneable {
    public static final /* synthetic */ int j = 0;
    public List<String> b;
    public final Map<String, d> c;
    public final j d;
    public final LiveData<ConnectionService.NetworkState> e;
    public final a f;
    public final C0329b g;
    public volatile boolean h;
    public boolean i;

    public static final class a<T> implements Observer {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            ConnectionService.NetworkState r4 = (ConnectionService.NetworkState) r3;
            Intrinsics.checkNotNullParameter(r4, "networkState");
            if (r4.a() == false) goto L17;
            tt5.a.h("RetryGeckoUpdateListener", "network reconnect");
            Iterator r5 = ((ConcurrentHashMap) this.a.c).entrySet().iterator();
        L6:
            if (r5.hasNext() == false) goto L10;
            Map.Entry r0 = (Map.Entry) r5.next();
            if (((d) r0.getValue()).b == false) goto L6;
            r5.remove();
            ((d) r0.getValue()).a(this.a);
            goto L6
        L10:
            b r6 = this.a;
            r6.getClass();
            m.d(new e(r6));
            return;
        }
    }

    /* JADX INFO: renamed from: yy4.b$b, reason: collision with other inner class name */
    public static final class C0329b<T> implements Observer {
        public final /* synthetic */ b a;

        public C0329b(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            if (((Boolean) r3).booleanValue() == true) goto L17;
            tt5.a.h("RetryGeckoUpdateListener", "exit doze mode");
            Iterator r4 = ((ConcurrentHashMap) this.a.c).entrySet().iterator();
        L6:
            if (r4.hasNext() == false) goto L10;
            Map.Entry r0 = (Map.Entry) r4.next();
            if (((d) r0.getValue()).c == false) goto L6;
            r4.remove();
            ((d) r0.getValue()).a(this.a);
            goto L6
        L10:
            b r5 = this.a;
            r5.getClass();
            m.d(new f(r5));
            return;
        }
    }

    public static final class c {
    }

    public static final class d {
        public final String a;
        public boolean b;
        public boolean c;
        public final AtomicInteger d;
        public String e;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ d a;
            public final /* synthetic */ b b;

            public a(d r1, b r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r5) {
                Long r6 = (Long) r5;
                tt5.a.h("RetryGeckoUpdateListener", "retry, retryCount is " + this.a.b());
                d r7 = this.a;
                b r0 = this.b;
                String r8 = r7.a;
                r0.h = false;
                r0.e(r8);
                b r9 = this.b;
                d r1 = this.a;
                r9.a(r1.a, r1.e, r1.b(), true);
                this.a.d.incrementAndGet();
            }
        }

        /* JADX INFO: renamed from: yy4.b$d$b, reason: collision with other inner class name */
        public static final class C0330b<T> implements Consumer {
            public final /* synthetic */ b a;
            public final /* synthetic */ d b;

            public C0330b(b r1, d r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r6) {
                Throwable r7 = (Throwable) r6;
                tt5.a.e("RetryGeckoUpdateListener", "retry failed", r7, false);
                b r0 = this.a;
                String r1 = this.b.a;
                String r8 = r7.getMessage();
                int r3 = this.b.b();
                int r4 = b.j;
                r0.a(r1, r8, r3, false);
                this.a.d(this.b.a);
            }
        }

        public final int b() {
            return this.d.get();
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final void a(b r6) {
            Intrinsics.checkNotNullParameter(r6, "retryListener");
            if (this.b == false) goto L5;
        L11:
            tt5.a.h("RetryGeckoUpdateListener", "retry, reconnected or exit doze mode");
            String r0 = this.a;
            r6.h = false;
            r6.e(r0);
            return;
        L5:
            if (this.c == true) goto L11;
            if (b() < 3) goto L10;
            tt5.a.d("RetryGeckoUpdateListener", "retry ignore, retryCount is " + b());
            String r1 = this.a;
            String r2 = this.e;
            int r3 = b();
            int r4 = b.j;
            r6.a(r1, r2, r3, false);
            r6.d(this.a);
            return;
        L10:
            Flowable.timer((int) (Math.pow(2.0d, b()) * ((double) 30)), TimeUnit.SECONDS).subscribe(new a(this, r6), new C0330b(r6, this));
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public d(String r2, boolean r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "channel");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = new AtomicInteger();
            this.e = "";
        }
    }

    static {
    }

    public abstract void e(String r1);

    public b() {
        this.b = CollectionsKt.emptyList();
        this.c = new ConcurrentHashMap();
        j r0 = j.a.a;
        this.d = r0;
        this.e = r0.a();
        this.f = new a(this);
        this.g = new C0329b(this);
    }

    public final b b() {
        Object r0 = super.clone();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.doc.newresupdate.retry.RetryGeckoUpdateListener");
        return (b) r0;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    public final void d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "channel");
        tt5.a.h("RetryGeckoUpdateListener", "onFinish, remove task, channel = " + r3);
        ((ConcurrentHashMap) this.c).remove(r3);
    }

    public final void c(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "channel");
        d r0 = (d) ((ConcurrentHashMap) this.c).get(r7);
        boolean r1 = !this.d.getNetworkState().a();
        Boolean r2 = (Boolean) yy4.a.a.getValue();
        if (r2 == null) goto L5;
        boolean r3 = r2.booleanValue();
    L6:
        String r4 = "";
        if (r0 != null) goto L13;
        tt5.a.h("RetryGeckoUpdateListener", "onFailed, create new task");
        r0 = new d(r7, r1, r3);
        if (r8 == null) goto L12;
        r4 = r8;
    L12:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.e = r4;
        ((ConcurrentHashMap) this.c).put(r7, r0);
    L18:
        if (r1 == true) goto L21;
        if (r3 == true) goto L21;
        tt5.a.h("RetryGeckoUpdateListener", "onFailed, errorMsg = " + r8 + ", retry");
        r0.a(this);
        return;
    L21:
        if (r1 == false) goto L23;
        tt5.a.h("RetryGeckoUpdateListener", "onFailed, disconnected");
        m.d(new yy4.c(this));
        return;
    L23:
        if (r3 == false) goto L28;
        tt5.a.h("RetryGeckoUpdateListener", "onFailed, in doze");
        m.d(new yy4.d(this));
        return;
    L28:
        return;
    L13:
        r0.b = r1;
        r0.c = r3;
        if (r8 == null) goto L17;
        r4 = r8;
    L17:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.e = r4;
        goto L18
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.d
    public final void onCheckServerVersionFail(Map<String, List<Pair<String, Long>>> r3, Throwable r4) {
        super.onCheckServerVersionFail(r3, r4);
        tt5.a.b("RetryGeckoUpdateListener", "onCheckServerVersionFail, hasGeckoInternalRetry: " + this.h);
        if (this.h == false) goto L13;
        Iterator<T> r5 = this.b.iterator();
    L6:
        if (r5.hasNext() == false) goto L13;
        String r0 = (String) r5.next();
        if (r4 == null) goto L11;
        String r1 = r4.getMessage();
        if (r1 == null) goto L11;
    L12:
        c(r0, r1);
    L11:
        r1 = "";
    L13:
        this.h = true;
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.d
    public final void onCheckServerVersionSuccess(Map<String, List<Pair<String, Long>>> r6, Map<String, List<UpdatePackage>> r7) {
        super.onCheckServerVersionSuccess(r6, r7);
        String r0 = EChannel.DOCS_FULLPKG_CHANNEL.toString();
        boolean r1 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.full_pkg_included");
        boolean r2 = this.b.contains(r0);
        tt5.a.h("RetryGeckoUpdateListener", "isFullPkgIncluded " + r1 + ", hasFullResInChannel " + r2);
        if (this.i == true) goto L41;
        if (r2 == false) goto L42;
        if (r1 == true) goto L43;
        Application r3 = eu5.b.a;
        boolean r4 = d0.l(r0);
        this.i = r4;
        if (r4 == true) goto L44;
        boolean r5 = true;
        if (r7 == null) goto L18;
        Iterator<List<UpdatePackage>> r8 = r7.values().iterator();
        if (r8.hasNext() == false) goto L18;
        Iterator<T> r9 = r8.next().iterator();
    L14:
        if (r9.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((UpdatePackage) r9.next()).getChannel(), r0) == false) goto L14;
        boolean r10 = true;
    L19:
        if (r10 == true) goto L45;
        if (r6 == null) goto L29;
        Iterator<List<Pair<String, Long>>> r11 = r6.values().iterator();
        if (r11.hasNext() == false) goto L29;
        Iterator<T> r12 = r11.next().iterator();
    L25:
        if (r12.hasNext() == false) goto L29;
        if (Intrinsics.areEqual(((Pair) r12.next()).first, r0) == false) goto L25;
    L30:
        tt5.a.h("RetryGeckoUpdateListener", "onCheckServerVersionSuccess, isRemoteExist = false, isLocalExist = " + r5);
        if (r5 == false) goto L33;
        vy4.a.c(eu5.b.a, r0);
        c(r0, "already the lastest");
        return;
    L33:
        a(r0, "no hit pkg", 0, false);
        return;
    L29:
        r5 = false;
        goto L30
    L45:
        return;
    L18:
        r10 = false;
        goto L19
    L44:
        return;
    L43:
        return;
    L42:
        return;
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.d
    public final void onUpdateFailed(UpdatePackage r2, Throwable r3) {
        super.onUpdateFailed(r2, r3);
        String r4 = r2.getChannel();
        String r0 = "";
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        if (r3 == null) goto L10;
        String r5 = r3.getMessage();
        if (r5 == null) goto L10;
        r0 = r5;
    L10:
        c(r4, r0);
    }
}
