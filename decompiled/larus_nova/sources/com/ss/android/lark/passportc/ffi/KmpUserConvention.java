package com.ss.android.lark.passportc.ffi;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.q;
import com.ss.android.lark.passportc.dwarf.UserScope;
import f0c.h;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes37.dex */
@UserScope
public final class KmpUserConvention implements q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f438157d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f438158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f438159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f438160c;

    public static final class a implements Function1<h, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KmpUserConvention f438161a;

        public a(KmpUserConvention r100) {
            this.f438161a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(h r100) {
            h r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "userStatePayload");
            KmpUserConvention r102 = this.f438161a;
            BuildersKt.launch$default(r102.f438159b, null, null, new KmpUserConvention$1$invoke$1(r102, r101, null), 3, null);
            return Unit.INSTANCE;
        }
    }

    public static final class b {
    }

    static {
    }

    @Inject
    public KmpUserConvention(m r100) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        this.f438158a = r100;
        CoroutineDispatcher r101 = com.lark.kmp.impl.a.f278589a;
        this.f438159b = CoroutineScopeKt.CoroutineScope(com.lark.kmp.impl.a.f278591c);
        this.f438160c = LazyKt.lazy(new KmpUserConvention$userService$2(this));
        r100.a(new a(this));
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        gy7.h r101 = (gy7.h) this.f438160c.getValue();
        if (r101 != null) goto L5;
        Log.w("PassportKmpUserConvention", "afterUserOffline skipped: KMP user service not found");
        return;
    L5:
        r101.a(com.ss.android.lark.passportc.ffi.b.c(r100));
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        gy7.h r101 = (gy7.h) this.f438160c.getValue();
        if (r101 != null) goto L5;
        Log.w("PassportKmpUserConvention", "afterUserOnline skipped: KMP user service not found");
        return;
    L5:
        r101.c(com.ss.android.lark.passportc.ffi.b.c(r100));
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        gy7.h r101 = (gy7.h) this.f438160c.getValue();
        if (r101 != null) goto L5;
        Log.w("PassportKmpUserConvention", "onUserOffline skipped: KMP user service not found");
        return;
    L5:
        r101.b(com.ss.android.lark.passportc.ffi.b.c(r100));
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        gy7.h r101 = (gy7.h) this.f438160c.getValue();
        if (r101 != null) goto L5;
        Log.w("PassportKmpUserConvention", "onUserOnline skipped: KMP user service not found");
        return;
    L5:
        r101.f(com.ss.android.lark.passportc.ffi.b.c(r100));
    }
}
