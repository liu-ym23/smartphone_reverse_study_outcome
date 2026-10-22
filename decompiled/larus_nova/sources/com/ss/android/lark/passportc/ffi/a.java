package com.ss.android.lark.passportc.ffi;

import com.lark.kmp.basic.ActionContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.api.p;
import f0c.f;
import f0c.g;
import gy7.e;
import gy7.l;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class a implements p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f438162c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f438163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f438164b;

    /* JADX INFO: renamed from: com.ss.android.lark.passportc.ffi.a$a, reason: collision with other inner class name */
    public static final class C5240a implements Function1<f0c.b, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f438165a;

        public C5240a(a r100) {
            this.f438165a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(f0c.b r100) {
            f0c.b r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "state");
            a r102 = this.f438165a;
            BuildersKt.launch$default(r102.f438164b, null, null, new KmpGlobalConvention$1$invoke$1(r102, r101, null), 3, null);
            return Unit.INSTANCE;
        }
    }

    public static final class b {
    }

    static {
    }

    public static e a() {
        com.lark.kmp.containerization.b r100 = iy7.a.a();
        if (r100 == null) goto L9;
        Object r101 = r100.a(Reflection.getOrCreateKotlinClass(e.class));
        if (r101 == null) goto L8;
        return (e) r101;
    L8:
        throw new IllegalArgumentException("No instance of " + Reflection.getOrCreateKotlinClass(e.class).getSimpleName() + " found");
    L9:
        return null;
    }

    @Inject
    public a(j r100) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        this.f438163a = r100;
        this.f438164b = CoroutineScopeKt.CoroutineScope(com.lark.kmp.impl.a.f278591c);
        r100.c(new C5240a(this));
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOffline(f0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        int r101 = com.ss.android.lark.passportc.ffi.b.f438166a;
        gy7.p r102 = com.ss.android.lark.passportc.ffi.b.b(r100.f475031c);
        if (r102 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r100.f475024b.getContext(), "userActionContext");
        ActionContext r103 = ActionContext.InternalContext;
        com.ss.android.lark.passportc.ffi.b.a(r100.f475024b.f475036b);
        gy7.j r104 = new gy7.j(r102, r103);
        e r105 = a();
        if (r105 != null) goto L8;
        Log.w("PassportKmpGlobalConvention", "afterUserOffline skipped: KMP global service not found");
        return;
    L8:
        r105.g(r104);
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOnline(f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        int r101 = com.ss.android.lark.passportc.ffi.b.f438166a;
        gy7.p r102 = com.ss.android.lark.passportc.ffi.b.b(r100.f475032c);
        if (r102 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r100.f475024b.getContext(), "userActionContext");
        ActionContext r103 = ActionContext.InternalContext;
        com.ss.android.lark.passportc.ffi.b.a(r100.f475024b.f475036b);
        l r104 = new l(r102, r103);
        e r105 = a();
        if (r105 != null) goto L8;
        Log.w("PassportKmpGlobalConvention", "afterUserOnline skipped: KMP global service not found");
        return;
    L8:
        r105.b(r104);
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOffline(f0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        int r101 = com.ss.android.lark.passportc.ffi.b.f438166a;
        gy7.p r102 = com.ss.android.lark.passportc.ffi.b.b(r100.f475031c);
        if (r102 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r100.f475024b.getContext(), "userActionContext");
        ActionContext r103 = ActionContext.InternalContext;
        com.ss.android.lark.passportc.ffi.b.a(r100.f475024b.f475036b);
        gy7.j r104 = new gy7.j(r102, r103);
        e r105 = a();
        if (r105 != null) goto L8;
        Log.w("PassportKmpGlobalConvention", "onUserOffline skipped: KMP global service not found");
        return;
    L8:
        r105.a(r104);
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOnline(f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        int r101 = com.ss.android.lark.passportc.ffi.b.f438166a;
        gy7.p r102 = com.ss.android.lark.passportc.ffi.b.b(r100.f475032c);
        if (r102 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r100.f475024b.getContext(), "userActionContext");
        ActionContext r103 = ActionContext.InternalContext;
        com.ss.android.lark.passportc.ffi.b.a(r100.f475024b.f475036b);
        l r104 = new l(r102, r103);
        e r105 = a();
        if (r105 != null) goto L8;
        Log.w("PassportKmpGlobalConvention", "onUserOnline skipped: KMP global service not found");
        return;
    L8:
        r105.d(r104);
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserChanged(g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "currentState");
        if (r101.a() != null) goto L6;
        Log.w("PassportKmpGlobalConvention", "afterUserChanged skipped: current user payload is null");
        return;
    L6:
        int r102 = com.ss.android.lark.passportc.ffi.b.f438166a;
        gy7.b r103 = new gy7.b(com.ss.android.lark.passportc.ffi.b.c(r101.f475024b), com.ss.android.lark.passportc.ffi.b.b(r101.a()));
        e r104 = a();
        if (r104 != null) goto L9;
        Log.w("PassportKmpGlobalConvention", "afterUserChanged skipped: KMP global service not found");
        return;
    L9:
        r104.f(r103, com.ss.android.lark.passportc.ffi.b.b(r100));
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserChanged(g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "currentState");
        if (r101.a() != null) goto L6;
        Log.w("PassportKmpGlobalConvention", "onUserChanged skipped: current user payload is null");
        return;
    L6:
        int r102 = com.ss.android.lark.passportc.ffi.b.f438166a;
        gy7.b r103 = new gy7.b(com.ss.android.lark.passportc.ffi.b.c(r101.f475024b), com.ss.android.lark.passportc.ffi.b.b(r101.a()));
        e r104 = a();
        if (r104 != null) goto L9;
        Log.w("PassportKmpGlobalConvention", "onUserChanged skipped: KMP global service not found");
        return;
    L9:
        r104.c(r103, com.ss.android.lark.passportc.ffi.b.b(r100));
    }
}
