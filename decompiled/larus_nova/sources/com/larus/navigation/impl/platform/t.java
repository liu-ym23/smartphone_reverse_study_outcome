package com.larus.navigation.impl.platform;

import com.bytedance.navigation.kmp.data.NavigationTraceLevel;
import com.larus.lbs.trace.api.model.LbsTraceLevel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<ci9.a, ci9.b, Unit> f359951a;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f359952a = null;

        static {
            int[] r100 = new int[NavigationTraceLevel.values().length];
            r100[NavigationTraceLevel.INFO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[NavigationTraceLevel.WARNING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[NavigationTraceLevel.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f359952a = r100;
        }
    }

    static {
    }

    public t() {
        this(null);
    }

    public t(Object r100) {
        Function2<ci9.a, ci9.b, Unit> r101 = new s();
        Intrinsics.checkNotNullParameter(r101, "reportEvent");
        this.f359951a = r101;
    }

    public final void a(e37.j r110, b37.k r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "event");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L20
        Function2<ci9.a, ci9.b, Unit> r101 = this.f359951a;     // Catch: Throwable -> L20
        ci9.a r102 = new ci9.a(r110.f470927a, r110.f470928b, r110.f470929c, r110.f470930d);     // Catch: Throwable -> L20
        String r103 = r111.f17270a;     // Catch: Throwable -> L20
        int r104 = b.f359952a[r111.f17271b.ordinal()];     // Catch: Throwable -> L20
        if (r104 != 1) goto L6;
        LbsTraceLevel r105 = LbsTraceLevel.INFO;     // Catch: Throwable -> L20
    L14:
        LbsTraceLevel r106 = r105;
        Long r107 = r111.f17272c;     // Catch: Throwable -> L20
        if (r107 == null) goto L17;
        long r108 = r107.longValue();     // Catch: Throwable -> L20
    L18:
        r101.invoke(r102, new ci9.b(r103, r106, r108, r111.f17273d));     // Catch: Throwable -> L20
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L32;
        int r114 = com.larus.navigation.api.c.f359656a;     // Catch: Throwable -> L26
        com.larus.navigation.api.c.c("kmp_trace", "navigation Trace report failed: " + r113.getMessage(), r113);     // Catch: Throwable -> L26
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L32:
        return;
    L17:
        r108 = -1;
        goto L18
    L6:
        if (r104 != 2) goto L8;
        r105 = LbsTraceLevel.WARNING;     // Catch: Throwable -> L20
        goto L14
    L8:
        if (r104 != 3) goto L11;
        r105 = LbsTraceLevel.ERROR;     // Catch: Throwable -> L20
        goto L14
    L11:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    }
}
