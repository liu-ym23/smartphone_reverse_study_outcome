package com.bytedance.kmp.livesdk.gift.platform.resourcemanager;

import com.bytedance.android.live.revenue.common.h;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.BaseGetResourceException;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class GiftResourceManager implements com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String>, e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static GiftResourceManager f252386h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f252387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Long, f> f252388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.kmp.livesdk.gift.platform.resourcemanager.b> f252389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f252390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f252391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ed6.a<com.bytedance.android.livesdk.gift.platform.business.effect.assets.e> f252392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f252393g;

    public static final class a {
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f252394a = null;

        static {
            f252394a = new b();
        }

        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r102 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) r100;
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r103 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) r101;
            int r104 = r103.f129094d - r102.f129094d;
            if (r104 > 0) goto L9;
            if (r104 < 0) goto L11;
            long r105 = r103.f129095e - r102.f129095e;
            if (r105 > 0) goto L9;
            if (r105 < 0) goto L11;
            return 0;
        L11:
            return -1;
        L9:
            return 1;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f252395a;

        public c(Function0 r100) {
            this.f252395a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f252395a.invoke();
        }
    }

    static {
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final void d(int r100) {
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final void i(int r100) {
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final void j() {
        this.f252387a = false;
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final void k() {
        this.f252387a = true;
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a a() {
        return this.f252393g.f252397a;
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final void clear() {
        ((ConcurrentHashMap) this.f252388b).clear();
    }

    public final void o() {
    L3:
        if (this.f252392f.f472215a.peek() == null) goto L15;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100 = this.f252392f.f472215a.poll();
        if (r100 == null) goto L3;
        Map<Long, f> r101 = this.f252388b;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        f r103 = (f) r102.get(Long.valueOf(r100.f129099i));
        if (r103 == null) goto L3;
        Iterator<T> r104 = r103.b().iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        ((com.bytedance.kmp.livesdk.gift.platform.resourcemanager.c) r104.next()).a(r100.f129099i);
        goto L12
    L14:
        Map<Long, f> r105 = this.f252388b;
        ConcurrentHashMap r106 = (ConcurrentHashMap) r105;
        r106.remove(Long.valueOf(r100.f129099i));
        goto L3
    }

    public final void p() {
        if (this.f252390d < this.f252393g.f252401e) goto L5;
        return;
    L5:
        if (this.f252392f.f472215a.isEmpty() == true) goto L33;
        int r100 = this.f252391e;
        int r101 = this.f252393g.f252402f;
        if (1 > r101) goto L13;
        if (r100 < r101) goto L13;
        o();
        this.f252391e = 0;
        return;
    L13:
        final com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r102 = this.f252392f.f472215a.poll();
        if (r102 != null) goto L20;
        if (this.f252392f.f472215a.isEmpty() == true) goto L30;
        p();
        return;
    L30:
        return;
    L20:
        if (this.f252387a == true) goto L22;
    L25:
        com.bytedance.live.kmp.util.c r103 = com.bytedance.live.kmp.util.c.f255167a;
        r102.f129096f = System.currentTimeMillis();
        if (e(r102) == false) goto L28;
        r(this, new GiftResourceManager$newTryConsumeResourceRequest$1(this, r102));
        p();
        return;
    L28:
        this.f252390d++;
        m(r102);
        return;
    L22:
        if (r102.f129094d != 1) goto L25;
        r(this, new GiftResourceManager$onCancel$1(this, r102));
        p();
        return;
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final void f() {
        clear();
        o();
    }

    public GiftResourceManager(d r100) {
        this.f252393g = r100;
        this.f252388b = new ConcurrentHashMap();
        this.f252389c = new ArrayList();
        this.f252392f = new ed6.a(b.f252394a);
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final boolean e(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.a() != 1) goto L9;
        return true;
    L9:
        if (r100.a() != 2) goto L11;
        return false;
    L11:
        String r101 = uy0.a.a(this.f252393g.f252397a.b(r100));
        return ((uy0.b) com.bytedance.android.live.revenue.core.util.f.a(uy0.b.class)).Y4(r101 + ".fetched");
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final void g(com.bytedance.kmp.livesdk.gift.platform.resourcemanager.b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (((ArrayList) this.f252389c).contains(r100) == true) goto L8;
        ((ArrayList) this.f252389c).add(r100);
        return;
    }

    public final void m(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100) {
        d r101 = this.f252393g;
        r101.f252398b.a(r100, r101).a(r100, this);
    }

    public final String n(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        String r101 = this.f252393g.f252397a.b(r100);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        String r102 = uy0.a.a(r101);
        if (r100.f129103m == true) goto L9;
        StringBuilder r103 = new StringBuilder();
        r103.append(r102);
        int r104 = h.f90835a;
        r103.append(h.a(r100.f129100j[0]));
        return r103.toString();
    L9:
        return r102;
    }

    public static /* synthetic */ void r(GiftResourceManager r100, Function0 r101) {
        r100.q(r101, Long.valueOf(0));
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a
    public final void b(final com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "s");
        String r102 = uy0.a.a(this.f252393g.f252397a.b(r100));
        ((uy0.b) com.bytedance.android.live.revenue.core.util.f.a(uy0.b.class)).L(r102 + ".fetched");
        r(this, new GiftResourceManager$onResult$1(this, r100));
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final void c(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100, com.bytedance.kmp.livesdk.gift.platform.resourcemanager.c r101) {
        if (this.f252387a == false) goto L8;
        if (r100.f129094d != 1) goto L8;
        r101.a(r100.f129099i);
        return;
    L8:
        if (e(r100) == false) goto L10;
        String r102 = n(r100);
        r101.c(r100.f129099i, r102);
        return;
    L10:
        long r103 = r100.f129099i;
        Map<Long, f> r104 = this.f252388b;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        f r106 = (f) r105.get(Long.valueOf(r103));
        if (r106 == null) goto L20;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r107 = r106.f252412b;
        if (r107.f129094d >= r100.f129094d) goto L18;
        r100.c();
        this.f252392f.f472215a.remove(r107);
        this.f252392f.f472215a.add(r100);
        f r108 = new f(r100);
        List<com.bytedance.kmp.livesdk.gift.platform.resourcemanager.c> r109 = r106.b();
        Intrinsics.checkNotNullParameter(r109, "list");
        List<com.bytedance.kmp.livesdk.gift.platform.resourcemanager.c> r110 = r109;
        if ((true ^ r110.isEmpty()) == false) goto L17;
        ((CopyOnWriteArrayList) r108.f252411a).addAll(r110);
    L17:
        r108.a(r101);
        Map<Long, f> r111 = this.f252388b;
        ConcurrentHashMap r112 = (ConcurrentHashMap) r111;
        r112.remove(Long.valueOf(r103));
        Map<Long, f> r113 = this.f252388b;
        ConcurrentHashMap r114 = (ConcurrentHashMap) r113;
        Object r115 = r114.put(Long.valueOf(r103), r108);
    L19:
        if (r115 == null) goto L20;
        return;
    L18:
        r107.c();
        r106.a(r101);
        r115 = Unit.INSTANCE;
    L20:
        f r116 = new f(r100);
        r116.a(r101);
        Map<Long, f> r117 = this.f252388b;
        ConcurrentHashMap r118 = (ConcurrentHashMap) r117;
        r118.put(Long.valueOf(r103), r116);
        r100.c();
        this.f252392f.f472215a.add(r100);
        p();
        Unit r119 = Unit.INSTANCE;
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e
    public final String h(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100, boolean r101) {
        if (e(r100) == true) goto L5;
        if (r101 == false) goto L12;
        long r102 = r100.f129099i;
        Map<Long, f> r103 = this.f252388b;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        if (r104.containsKey(Long.valueOf(r102)) == true) goto L13;
        f r105 = new f(r100);
        Map<Long, f> r106 = this.f252388b;
        ConcurrentHashMap r107 = (ConcurrentHashMap) r106;
        r107.put(Long.valueOf(r102), r105);
        r100.c();
        m(r100);
        return null;
    L13:
        return null;
    L12:
        return null;
    L5:
        return n(r100);
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a
    public final void l(final com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100, final BaseGetResourceException r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "error");
        if (e(r100) == false) goto L6;
        this.f252390d--;
        p();
        return;
    L6:
        r(this, new GiftResourceManager$onFailure$1(this, r100, r101));
    }

    public final void q(Function0<Unit> r100, Long r101) {
        if (r101 != null) goto L4;
    L6:
        l r102 = l.f267516a;
        Observable<Long> r103 = Observable.just(Unit.INSTANCE);
    L7:
        int r104 = p.f267522a;
        r103.observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r100));
        return;
    L4:
        if (r101.longValue() <= 0) goto L6;
        l r105 = l.f267516a;
        long r106 = r101.longValue();
        int r107 = p.f267522a;
        Scheduler r108 = Schedulers.computation();
        r103 = Observable.timer(r106, TimeUnit.MILLISECONDS, r108);
        goto L7
    }
}
