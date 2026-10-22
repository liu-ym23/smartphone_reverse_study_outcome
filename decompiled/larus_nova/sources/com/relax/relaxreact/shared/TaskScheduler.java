package com.relax.relaxreact.shared;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.rts.kmp.foundation.i;
import com.bytedance.rts.kmp.foundation.p;
import com.relax.relaxreact.RendererSchedulerBridge;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
public final class TaskScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f405566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<? super Function0<Unit>, Unit> f405567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<Function0<Unit>> f405568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<Function1<Long, Unit>> f405569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<Function1<Long, Unit>> f405570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<Long> f405571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<Long> f405572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<Long> f405573h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f405574i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Long f405575j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function1<? super Long, Unit> f405576k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f405577l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f405578m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f405579n;

    /* JADX INFO: renamed from: com.relax.relaxreact.shared.TaskScheduler$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", "callback", "Lkotlin/Function0;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda implements Function1<Function0<? extends Unit>, Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Function0<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            r100.invoke();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    public final void d() {
        final p r100 = new p(this);
        Function1<Long, Unit> r101 = new TaskScheduler$requestFrame$callback$1(r100);
        c r102 = this.f405566a;
        Long r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("schedulerBridge");
        r102 = null;
    L5:
        long r104 = r102.d(r101);
        if (r104 == 0) goto L8;
        r103 = Long.valueOf(r104);
    L8:
        this.f405575j = r103;
    }

    public final void b(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        if (this.f405579n == false) goto L5;
        return;
    L5:
        i.f(this.f405568c, r100);
        if (this.f405574i != null) goto L17;
        final p r101 = new p(this);
        Function0<Unit> r102 = new TaskScheduler$requestDispatch$callback$1(r101);
        c r103 = this.f405566a;
        Long r104 = null;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("schedulerBridge");
        r103 = null;
    L10:
        long r105 = r103.a(r102);
        if (r105 == 0) goto L13;
        r104 = Long.valueOf(r105);
    L13:
        this.f405574i = r104;
        if (this.f405575j != null) goto L18;
        d();
        return;
    L18:
        return;
    }

    public final void c(Function1<? super Long, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (this.f405579n == false) goto L5;
        return;
    L5:
        i.f(this.f405570e, r100);
        if (this.f405577l == true) goto L20;
        final p r101 = new p(this);
        final long r102 = this.f405578m + 1;
        this.f405578m = r102;
        Function1<Long, Unit> r103 = new TaskScheduler$requestFrameCommit$callback$1(r101, r102);
        c r104 = this.f405566a;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("schedulerBridge");
        r104 = null;
    L11:
        if (r104.f(r103) < 0) goto L13;
        this.f405577l = true;
        return;
    L13:
        this.f405576k = r103;
        this.f405577l = true;
        Intrinsics.checkNotNullParameter(r103, "callback");
        if (this.f405579n == true) goto L23;
        i.f(this.f405569d, r103);
        if (this.f405575j != null) goto L22;
        d();
        return;
    L22:
        return;
    L23:
        return;
    }

    public TaskScheduler(RendererSchedulerBridge r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "schedulerBridge");
        this.f405568c = new ArrayList();
        this.f405569d = new ArrayList();
        this.f405570e = new ArrayList();
        this.f405571f = new ArrayList();
        this.f405572g = new ArrayList();
        this.f405573h = new ArrayList();
        this.f405566a = r100;
        this.f405567b = r101;
    }

    public static final void a(TaskScheduler r100, Function0 r101) {
        if (r100.f405579n == true) goto L10;
        Function1<? super Function0<Unit>, Unit> r102 = r100.f405567b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("callbackRunner");
        r102 = null;
    L8:
        r102.invoke(r101);
        return;
    }
}
