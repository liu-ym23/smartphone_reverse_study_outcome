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

/* JADX INFO: loaded from: classes16.dex */
public abstract class b extends xy4.a implements Cloneable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f569452j = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f569453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, d> f569454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f569455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LiveData<ConnectionService.NetworkState> f569456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f569457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C8401b f569458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f569459h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f569460i;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f569461a;

        public a(b r100) {
            this.f569461a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ConnectionService.NetworkState r101 = (ConnectionService.NetworkState) r100;
            Intrinsics.checkNotNullParameter(r101, "networkState");
            if (r101.a() == false) goto L17;
            tt5.a.h("RetryGeckoUpdateListener", "network reconnect");
            Iterator r102 = ((ConcurrentHashMap) this.f569461a.f569454c).entrySet().iterator();
        L6:
            if (r102.hasNext() == false) goto L10;
            Map.Entry r103 = (Map.Entry) r102.next();
            if (((d) r103.getValue()).f569464b == false) goto L6;
            r102.remove();
            ((d) r103.getValue()).a(this.f569461a);
            goto L6
        L10:
            b r104 = this.f569461a;
            r104.getClass();
            m.d(new e(r104));
            return;
        }
    }

    /* JADX INFO: renamed from: yy4.b$b, reason: collision with other inner class name */
    public static final class C8401b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f569462a;

        public C8401b(b r100) {
            this.f569462a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((Boolean) r100).booleanValue() == true) goto L17;
            tt5.a.h("RetryGeckoUpdateListener", "exit doze mode");
            Iterator r101 = ((ConcurrentHashMap) this.f569462a.f569454c).entrySet().iterator();
        L6:
            if (r101.hasNext() == false) goto L10;
            Map.Entry r102 = (Map.Entry) r101.next();
            if (((d) r102.getValue()).f569465c == false) goto L6;
            r101.remove();
            ((d) r102.getValue()).a(this.f569462a);
            goto L6
        L10:
            b r103 = this.f569462a;
            r103.getClass();
            m.d(new f(r103));
            return;
        }
    }

    public static final class c {
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f569463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f569464b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f569465c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicInteger f569466d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f569467e;

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f569468a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f569469b;

            public a(d r100, b r101) {
                this.f569468a = r100;
                this.f569469b = r101;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Long r101 = (Long) r100;
                tt5.a.h("RetryGeckoUpdateListener", "retry, retryCount is " + this.f569468a.b());
                d r102 = this.f569468a;
                b r103 = this.f569469b;
                String r104 = r102.f569463a;
                r103.f569459h = false;
                r103.e(r104);
                b r105 = this.f569469b;
                d r106 = this.f569468a;
                r105.a(r106.f569463a, r106.f569467e, r106.b(), true);
                this.f569468a.f569466d.incrementAndGet();
            }
        }

        /* JADX INFO: renamed from: yy4.b$d$b, reason: collision with other inner class name */
        public static final class C8402b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f569470a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f569471b;

            public C8402b(b r100, d r101) {
                this.f569470a = r100;
                this.f569471b = r101;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
                tt5.a.e("RetryGeckoUpdateListener", "retry failed", r101, false);
                b r102 = this.f569470a;
                String r103 = this.f569471b.f569463a;
                String r104 = r101.getMessage();
                int r105 = this.f569471b.b();
                int r106 = b.f569452j;
                r102.a(r103, r104, r105, false);
                this.f569470a.d(this.f569471b.f569463a);
            }
        }

        public final int b() {
            return this.f569466d.get();
        }

        public final int hashCode() {
            return this.f569463a.hashCode();
        }

        public final void a(b r100) {
            Intrinsics.checkNotNullParameter(r100, "retryListener");
            if (this.f569464b == false) goto L5;
        L11:
            tt5.a.h("RetryGeckoUpdateListener", "retry, reconnected or exit doze mode");
            String r101 = this.f569463a;
            r100.f569459h = false;
            r100.e(r101);
            return;
        L5:
            if (this.f569465c == true) goto L11;
            if (b() < 3) goto L10;
            tt5.a.d("RetryGeckoUpdateListener", "retry ignore, retryCount is " + b());
            String r102 = this.f569463a;
            String r103 = this.f569467e;
            int r104 = b();
            int r105 = b.f569452j;
            r100.a(r102, r103, r104, false);
            r100.d(this.f569463a);
            return;
        L10:
            Flowable.timer((int) (Math.pow(2.0d, b()) * ((double) 30)), TimeUnit.SECONDS).subscribe(new a(this, r100), new C8402b(r100, this));
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f569463a, ((d) r100).f569463a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public d(String r100, boolean r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "channel");
            this.f569463a = r100;
            this.f569464b = r101;
            this.f569465c = r102;
            this.f569466d = new AtomicInteger();
            this.f569467e = "";
        }
    }

    static {
    }

    public abstract void e(String r100);

    public b() {
        this.f569453b = CollectionsKt.emptyList();
        this.f569454c = new ConcurrentHashMap();
        j r100 = j.a.f217090a;
        this.f569455d = r100;
        this.f569456e = r100.a();
        this.f569457f = new a(this);
        this.f569458g = new C8401b(this);
    }

    public final b b() {
        Object r100 = super.clone();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.doc.newresupdate.retry.RetryGeckoUpdateListener");
        return (b) r100;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        tt5.a.h("RetryGeckoUpdateListener", "onFinish, remove task, channel = " + r100);
        ((ConcurrentHashMap) this.f569454c).remove(r100);
    }

    public final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        d r102 = (d) ((ConcurrentHashMap) this.f569454c).get(r100);
        boolean r103 = !this.f569455d.getNetworkState().a();
        Boolean r104 = yy4.a.f569451a.getValue();
        if (r104 == null) goto L5;
        boolean r105 = r104.booleanValue();
    L6:
        String r106 = "";
        if (r102 != null) goto L13;
        tt5.a.h("RetryGeckoUpdateListener", "onFailed, create new task");
        r102 = new d(r100, r103, r105);
        if (r101 == null) goto L12;
        r106 = r101;
    L12:
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r102.f569467e = r106;
        ((ConcurrentHashMap) this.f569454c).put(r100, r102);
    L18:
        if (r103 == true) goto L21;
        if (r105 == true) goto L21;
        tt5.a.h("RetryGeckoUpdateListener", "onFailed, errorMsg = " + r101 + ", retry");
        r102.a(this);
        return;
    L21:
        if (r103 == false) goto L23;
        tt5.a.h("RetryGeckoUpdateListener", "onFailed, disconnected");
        m.d(new yy4.c(this));
        return;
    L23:
        if (r105 == false) goto L28;
        tt5.a.h("RetryGeckoUpdateListener", "onFailed, in doze");
        m.d(new yy4.d(this));
        return;
    L28:
        return;
    L13:
        r102.f569464b = r103;
        r102.f569465c = r105;
        if (r101 == null) goto L17;
        r106 = r101;
    L17:
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r102.f569467e = r106;
        goto L18
    L5:
        r105 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.d, com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckServerVersionFail(Map<String, List<Pair<String, Long>>> r100, Throwable r101) {
        super.onCheckServerVersionFail(r100, r101);
        tt5.a.b("RetryGeckoUpdateListener", "onCheckServerVersionFail, hasGeckoInternalRetry: " + this.f569459h);
        if (this.f569459h == false) goto L13;
        Iterator<T> r102 = this.f569453b.iterator();
    L6:
        if (r102.hasNext() == false) goto L13;
        String r103 = (String) r102.next();
        if (r101 == null) goto L11;
        String r104 = r101.getMessage();
        if (r104 == null) goto L11;
    L12:
        c(r103, r104);
    L11:
        r104 = "";
    L13:
        this.f569459h = true;
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.d, com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckServerVersionSuccess(Map<String, List<Pair<String, Long>>> r100, Map<String, List<UpdatePackage>> r101) {
        super.onCheckServerVersionSuccess(r100, r101);
        String r102 = EChannel.DOCS_FULLPKG_CHANNEL.toString();
        boolean r103 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.full_pkg_included");
        boolean r104 = this.f569453b.contains(r102);
        tt5.a.h("RetryGeckoUpdateListener", "isFullPkgIncluded " + r103 + ", hasFullResInChannel " + r104);
        if (this.f569460i == true) goto L41;
        if (r104 == false) goto L42;
        if (r103 == true) goto L43;
        Application r105 = eu5.b.f474075a;
        boolean r106 = d0.l(r102);
        this.f569460i = r106;
        if (r106 == true) goto L44;
        boolean r107 = true;
        if (r101 == null) goto L18;
        Iterator<List<UpdatePackage>> r108 = r101.values().iterator();
        if (r108.hasNext() == false) goto L18;
        Iterator<T> r109 = r108.next().iterator();
    L14:
        if (r109.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((UpdatePackage) r109.next()).getChannel(), r102) == false) goto L14;
        boolean r110 = true;
    L19:
        if (r110 == true) goto L45;
        if (r100 == null) goto L29;
        Iterator<List<Pair<String, Long>>> r111 = r100.values().iterator();
        if (r111.hasNext() == false) goto L29;
        Iterator<T> r112 = r111.next().iterator();
    L25:
        if (r112.hasNext() == false) goto L29;
        if (Intrinsics.areEqual(((Pair) r112.next()).first, r102) == false) goto L25;
    L30:
        tt5.a.h("RetryGeckoUpdateListener", "onCheckServerVersionSuccess, isRemoteExist = false, isLocalExist = " + r107);
        if (r107 == false) goto L33;
        vy4.a.c(eu5.b.f474075a, r102);
        c(r102, "already the lastest");
        return;
    L33:
        a(r102, "no hit pkg", 0, false);
        return;
    L29:
        r107 = false;
        goto L30
    L45:
        return;
    L18:
        r110 = false;
        goto L19
    L44:
        return;
    L43:
        return;
    L42:
        return;
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.d, com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateFailed(UpdatePackage r100, Throwable r101) {
        super.onUpdateFailed(r100, r101);
        String r102 = r100.getChannel();
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        if (r101 == null) goto L10;
        String r104 = r101.getMessage();
        if (r104 == null) goto L10;
        r103 = r104;
    L10:
        c(r102, r103);
    }
}
