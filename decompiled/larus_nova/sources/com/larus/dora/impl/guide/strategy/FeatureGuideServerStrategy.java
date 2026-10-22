package com.larus.dora.impl.guide.strategy;

import com.larus.dora.impl.util.b0;
import java.util.Calendar;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class FeatureGuideServerStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Continuation<? super Result<Boolean>>, Object> f335981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f335982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f335983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f335984d;

    public final Object a(Continuation<? super Boolean> r110) {
        if ((r110 instanceof FeatureGuideServerStrategy$isConditionMet$1) == false) goto L7;
        FeatureGuideServerStrategy$isConditionMet$1 r100 = (FeatureGuideServerStrategy$isConditionMet$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        if (r103 == 0) goto L15;
        if (r103 != 1) goto L14;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L45
    L39:
        Object r112 = ((Result) r111).m9458unboximpl();     // Catch: Throwable -> L45
        Throwable r105 = Result.m9452exceptionOrNullimpl(r112);     // Catch: Throwable -> L45
        if (r105 == null) goto L43;
        g49.d.c(this.f335982b, "FeatureGuideServerStrategy remote failed: " + r105.getMessage(), r105);     // Catch: Throwable -> L45
        r112 = Boxing.boxBoolean(false);     // Catch: Throwable -> L45
    L43:
        r104 = ((Boolean) r112).booleanValue();     // Catch: Throwable -> L45
    L48:
        if (this.f335983c == false) goto L55;
        if (r104 == false) goto L55;
        b0.f338123a.getClass();     // Catch: Exception -> L52
        b0.j().storeLong(this.f335984d, System.currentTimeMillis());     // Catch: Exception -> L52
    L52:
        e = move-exception;
        g49.d.c(this.f335982b, "FeatureGuideServerStrategy store keva failed: " + e.getMessage(), e);
    L55:
        return Boxing.boxBoolean(r104);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r111);
        g49.d.d(this.f335982b, "FeatureGuideServerStrategy.isConditionMet() start");
        if (this.f335983c == false) goto L36;
        long r106 = -1;
        b0.f338123a.getClass();     // Catch: Exception -> L20
        r106 = b0.j().getLong(this.f335984d, -1);     // Catch: Exception -> L20
    L22:
        long r107 = System.currentTimeMillis();
        if (r106 > 0) goto L25;
    L32:
        boolean r113 = false;
    L33:
        if (r113 == false) goto L36;
        g49.d.d(this.f335982b, "FeatureGuideServerStrategy skipped due to daily limit: key=" + this.f335984d);
        return Boxing.boxBoolean(false);
    L25:
        if (r107 <= 0) goto L32;
        Calendar r114 = Calendar.getInstance();
        r114.setTimeInMillis(r106);
        Calendar r108 = Calendar.getInstance();
        r108.setTimeInMillis(r107);
        if (r114.get(1) != r108.get(1)) goto L32;
        if (r114.get(6) != r108.get(6)) goto L32;
        r113 = true;
    L20:
        e = move-exception;
        g49.d.c(this.f335982b, "FeatureGuideServerStrategy read keva failed: " + e.getMessage(), e);
    L36:
        Function1<Continuation<? super Result<Boolean>>, Object> r115 = this.f335981a;     // Catch: Throwable -> L45
        r100.label = 1;     // Catch: Throwable -> L45
        r111 = r115.invoke(r100);     // Catch: Throwable -> L45
        if (r111 != r102) goto L39;
        return r102;
    L45:
        th = move-exception;
        g49.d.c(this.f335982b, "FeatureGuideServerStrategy exception: " + th.getMessage(), th);
    L7:
        r100 = new FeatureGuideServerStrategy$isConditionMet$1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeatureGuideServerStrategy(Function1<? super Continuation<? super Result<Boolean>>, ? extends Object> r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "remoteChecker");
        Intrinsics.checkNotNullParameter(r101, "tag");
        this.f335981a = r100;
        this.f335982b = r101;
        this.f335983c = r102;
        this.f335984d = "dora_guide_server_limit_".concat(r101);
    }
}
