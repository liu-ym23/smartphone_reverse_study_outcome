package com.larus.home.impl.main.side_bar.view.adapter;

import android.os.Handler;
import android.os.Looper;
import com.larus.account.base.api.ILoginService;
import com.larus.im.bean.job.AIJobListQuery;
import com.larus.im.bean.job.AIJobListResult;
import com.larus.im.bean.job.AIJobRequestState;
import com.larus.im.bean.job.AIJobRequestStatus;
import com.larus.im.bean.job.AIJobRequestType;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.im.service.AIJobObserver;
import com.larus.im.service.IAIJobService;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class t0 implements AIJobObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t0 f345021a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f345022b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f345023c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final WeakHashMap<a, Unit> f345024d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Set<String> f345025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f345026f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f345027g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f345028h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Long f345029i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f345030j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f345031k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f345032l = null;

    public interface a {
        void a(Set<String> r100);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f345033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f345034b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f345033a == r101.f345033a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f345034b, r101.f345034b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f345033a;
            return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f345034b.hashCode();
        }

        public final String toString() {
            return "PageAnchor(createTime=" + this.f345033a + ", jobId=" + this.f345034b + ')';
        }

        public b(long r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "jobId");
            this.f345033a = r100;
            this.f345034b = r101;
        }
    }

    public static final class c implements n38.j {
        public c() {
        }

        @Override // n38.j
        public final void a(n38.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            t0.f345021a.getClass();
            t0.b(new r0(false));
        }

        @Override // n38.j
        public final void b(n38.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            t0.f345021a.getClass();
            t0.b(new r0(true));
        }
    }

    public static final class d implements IIMCallback<AIJobListResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f345035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Set<String> f345036b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1<Set<String>, Unit> f345037c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Set<b> f345038d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f345039e;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return !y0.a();
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(final IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            t0 r101 = t0.f345021a;
            final long r102 = this.f345035a;
            final int r103 = this.f345039e;
            final Function1<Set<String>, Unit> r104 = this.f345037c;
            Function0 r105 = new u0(r102, r103, r100, r104);
            r101.getClass();
            t0.b(r105);
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(AIJobListResult r110) {
            final AIJobListResult r100 = r110;
            Intrinsics.checkNotNullParameter(r100, "result");
            t0 r111 = t0.f345021a;
            final long r101 = this.f345035a;
            final Set<String> r102 = this.f345036b;
            final Function1<Set<String>, Unit> r103 = this.f345037c;
            final Set<b> r104 = this.f345038d;
            final int r105 = this.f345039e;
            Function0 r106 = new v0(r101, r102, r100, r103, r104, r105);
            r111.getClass();
            t0.b(r106);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(long r100, Set<String> r101, Function1<? super Set<String>, Unit> r102, Set<b> r103, int r104) {
            this.f345035a = r100;
            this.f345036b = r101;
            this.f345037c = r102;
            this.f345038d = r103;
            this.f345039e = r104;
        }
    }

    public t0() {
    }

    static {
        f345021a = new t0();
        f345022b = new Handler(Looper.getMainLooper());
        f345023c = LazyKt.lazy(LazyThreadSafetyMode.NONE, new n0());
        f345024d = new WeakHashMap();
        f345025e = SetsKt.emptySet();
        f345031k = new c();
        f345032l = new int[]{1, 2};
    }

    public static void d() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L7;
        f345028h++;
        f345030j = true;
        g();
        return;
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }

    public static void g() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L16;
        if (f345029i == null) goto L7;
        return;
    L7:
        if (f345030j == false) goto L18;
        f345030j = false;
        if (ILoginService.f286097a.getAccountInfo().f531528a == true) goto L13;
        a(SetsKt.emptySet());
        return;
    L13:
        final long r100 = f345028h;
        final long r101 = f345027g;
        f345029i = Long.valueOf(r100);
        f(f345032l, 0, SetsKt.emptySet(), r101, new m0(r101, r100));
        return;
    L18:
        return;
    L16:
        throw new IllegalStateException("Check failed.".toString());
    }

    public static void a(Set r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L13;
        Set<String> r101 = SetsKt.plus(SetsKt.minus(f345025e, r100), SetsKt.minus(r100, f345025e));
        f345025e = r100;
        if (r101.isEmpty() == false) goto L7;
        return;
    L7:
        Iterator r102 = CollectionsKt.toList(f345024d.keySet()).iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        ((a) r102.next()).a(r101);
        goto L9
    L11:
        return;
    L13:
        throw new IllegalStateException("Check failed.".toString());
    }

    public static void b(final Function0 r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        f345022b.post(new p0(r100));
    }

    public static boolean c(String r100) {
        if (ILoginService.f286097a.getAccountInfo().f531528a == false) goto L18;
        com.larus.bmhome.a0.f294919z1.getClass();
        if (com.larus.bmhome.a0.a.f294921b == true) goto L7;
        return false;
    L7:
        if (r100 != null) goto L9;
    L12:
        boolean r101 = true;
    L13:
        if (r101 == false) goto L15;
        return false;
    L15:
        if (f345025e.contains(r100) == false) goto L21;
        return true;
    L21:
        return false;
    L9:
        if (StringsKt.isBlank(r100) == true) goto L12;
        r101 = false;
        goto L13
    L18:
        return false;
    }

    @Override // com.larus.im.service.AIJobObserver
    public final void onJobsChanged(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "ids");
        FLogger.f375446a.i("SideBarJobIndicator", "onJobsChanged count=" + r100.size());
        b(new SideBarScheduledJobIndicatorProvider$requestReload$1(this));
    }

    @Override // com.larus.im.service.AIJobObserver
    public final void onRequestStateChanged(AIJobRequestState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (r100.getRequestType() == AIJobRequestType.JOB_CHAIN) goto L5;
        return;
    L5:
        if (r100.getStatus() != AIJobRequestStatus.SUCCESS) goto L9;
        b(new SideBarScheduledJobIndicatorProvider$requestReload$1(this));
        return;
    }

    public static void f(final int[] r110, final int r111, final Set r112, final long r113, final Function1 r114) {
        if (r111 < r110.length) goto L6;
        r114.invoke(r112);
        return;
    L6:
        e(r110[r111], null, SetsKt.emptySet(), SetsKt.emptySet(), r113, new q0(r113, r114, r110, r111, r112));
    }

    public static void e(int r110, b r111, Set r112, Set r113, long r114, Function1 r115) {
        if (f345027g == r114) goto L5;
        return;
    L5:
        IAIJobService r100 = (IAIJobService) f345023c.getValue();
        if (r111 == null) goto L8;
        long r101 = r111.f345033a;
    L9:
        long r102 = r101;
        if (r111 == null) goto L12;
        String r103 = r111.f345034b;
    L13:
        r100.getLocalJobList(new AIJobListQuery(1, r110, r102, r103, 50), new d(r114, r113, r115, r112, r110));
        return;
    L12:
        r103 = null;
        goto L13
    L8:
        r101 = 0;
        goto L9
    }
}
