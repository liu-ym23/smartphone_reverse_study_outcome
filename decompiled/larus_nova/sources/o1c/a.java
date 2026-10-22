package o1c;

import android.os.SystemClock;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.k0;
import com.ss.android.lark.preload.v2.condition.ConditionSet;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class a<P, T> implements c<P, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f521736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f521737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f521738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f521739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f521740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConditionSet f521741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ConditionSet f521742g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ConditionSet f521743h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public P f521744i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public IGetDataCallback<?> f521745j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c.a f521746k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f521747l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f521748m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f521749n;

    public abstract void d(P r100);

    public abstract Set<String> f(P r100);

    @Override // java.lang.Runnable
    public final void run() {
        this.f521741f.getClass();
        e(this.f521744i);
    }

    @Override // o1c.c
    public final void s1() {
        c.a r100 = this.f521746k;
        if (r100 == null) goto L5;
        r100.g(this);
    L5:
        b r101 = this.f521749n;
        if (r101 == null) goto L9;
        r101.b(this);
        return;
    }

    public a() {
        this.f521736a = k0.a(8);
        this.f521737b = 10;
        this.f521739d = true;
        this.f521740e = new d(0);
        this.f521741f = new ConditionSet();
        this.f521742g = new ConditionSet();
        this.f521743h = new ConditionSet();
    }

    @Override // o1c.c
    public final ConditionSet C1() {
        return this.f521743h;
    }

    @Override // o1c.c
    public final long L0() {
        return this.f521747l;
    }

    @Override // o1c.c
    public final d R() {
        return this.f521740e;
    }

    @Override // o1c.c
    public final boolean T0() {
        return this.f521739d;
    }

    @Override // o1c.c
    public final int getPriority() {
        return this.f521737b;
    }

    @Override // o1c.c
    public final String getTaskId() {
        return this.f521736a;
    }

    @Override // o1c.c
    public boolean isInterrupted() {
        return this.f521738c;
    }

    @Override // o1c.c
    public final ConditionSet p0() {
        return this.f521741f;
    }

    @Override // o1c.c
    public final ConditionSet w0() {
        return this.f521742g;
    }

    @Override // o1c.c
    public final void J0(e1c.a r100) {
        this.f521749n = r100;
    }

    @Override // o1c.c
    public final void K(e1c.d r100) {
        this.f521746k = r100;
    }

    @Override // o1c.c
    public final void L(ConditionSet r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f521741f = r100;
    }

    @Override // o1c.c
    public final void N0(boolean r100) {
        this.f521739d = r100;
    }

    @Override // o1c.c
    public final void b0(IGetDataCallback<?> r100) {
        this.f521745j = r100;
    }

    @Override // java.lang.Comparable
    public final int compareTo(c<?, ?> r100) {
        c<?, ?> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        return this.f521737b - r101.getPriority();
    }

    public void e(P r100) {
        Set<String> r101 = f(r100);
        this.f521748m = SystemClock.elapsedRealtime();
        c.a r102 = this.f521746k;
        if (r102 == null) goto L5;
        r102.e(this, r101.size());
    L5:
        d(r100);
        b r103 = this.f521749n;
        if (r103 == null) goto L8;
        r103.a(this, r101);
    L8:
        c.a r104 = this.f521746k;
        if (r104 == null) goto L12;
        r104.b(this, r101.size(), MapsKt.mapOf(TuplesKt.to("executeTime", Long.valueOf(SystemClock.elapsedRealtime() - this.f521748m))));
        return;
    }

    @Override // o1c.c
    public final void e1(ConditionSet r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f521743h = r100;
    }

    @Override // o1c.c
    public final void h1(P r100) {
        this.f521744i = r100;
    }

    @Override // o1c.c
    public void k(boolean r100) {
        this.f521738c = r100;
    }

    @Override // o1c.c
    public final void o0(ConditionSet r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f521742g = r100;
    }

    @Override // o1c.c
    public final void setPriority(int r100) {
        this.f521737b = r100;
    }

    @Override // o1c.c
    public final void y0(long r100) {
        this.f521747l = r100;
    }

    @Override // o1c.c
    public void J1(P r100, IGetDataCallback<?> r101) {
        d(r100);
    }
}
