package com.larus.basic.experience.downgrade.impl.strategy;

import com.larus.platform.model.downgrade.DelayDowngradeStrategyConfig;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes25.dex */
public final class DelayDowngradeStrategy<T> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DelayDowngradeStrategyConfig f294843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f294844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f294845c;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.basic.experience.downgrade.impl.strategy.c
    public final Map<String, List<String>> a() {
        return this.f294843a.getBodyMatchers();
    }

    @Override // com.larus.basic.experience.downgrade.impl.strategy.c
    public final Map<String, List<String>> b() {
        return this.f294843a.getQueryMatchers();
    }

    @Override // com.larus.basic.experience.downgrade.impl.strategy.c
    public final Map<String, List<String>> f() {
        return this.f294843a.getExtraMatchers();
    }

    @Override // com.larus.basic.experience.downgrade.impl.strategy.c
    public final int d() {
        return this.f294844b;
    }

    @Override // com.larus.basic.experience.downgrade.impl.strategy.c
    public final int g() {
        return this.f294845c;
    }

    public DelayDowngradeStrategy(DelayDowngradeStrategyConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f294843a = r100;
        this.f294844b = 90;
        this.f294845c = -1;
    }

    @Override // com.larus.basic.experience.downgrade.impl.strategy.c
    public final Pair c(b r100, com.larus.network.http.a r101) {
        return TuplesKt.to(r100, r101);
    }

    @Override // com.larus.basic.experience.downgrade.impl.strategy.c
    public final Object e(b<T> r210, Continuation<? super b<T>> r211) {
        b<T> r100 = r210;
        if ((r211 instanceof DelayDowngradeStrategy$preProcess$1) == false) goto L7;
        DelayDowngradeStrategy$preProcess$1 r101 = (DelayDowngradeStrategy$preProcess$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r100 = (b) r101.L$0;
        ResultKt.throwOnFailure(r103);
        String r106 = "DelayDowngradeStrategy";
    L30:
        FLogger.f375446a.i(r106, "preProcess delay done, path = " + r100.f294853a);
    L32:
        return r100;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        Pair<Boolean, String> r107 = c.a.a(this, r100, true);
        boolean r108 = r107.component1().booleanValue();
        String r109 = r107.component2();
        FLogger r110 = FLogger.f375446a;
        r110.i("DelayDowngradeStrategy", "preProcess, path = " + r100.f294853a + ", matched = " + r108 + ", reason = " + r109);
        if (r108 == true) goto L17;
        return r100;
    L17:
        long r111 = 0;
        long r112 = RangesKt.coerceAtLeast(this.f294843a.getBaseDelayMs(), 0);
        r106 = "DelayDowngradeStrategy";
        long r113 = RangesKt.coerceAtLeast(this.f294843a.getJitterMs(), 0);
        if (r113 <= 0) goto L21;
        r111 = Random.Default.nextLong(r113);
    L21:
        long r114 = r112 + r111;
        Map<String, String> r115 = r100.f294860h;
        if (r115 == null) goto L26;
        String r116 = r115.put("delay", String.valueOf(r114));
    L26:
        if (r114 <= 0) goto L31;
        r110.i(r106, "preProcess, path = " + r100.f294853a + ", delay = " + r114 + "ms (base=" + r112 + ", jitter=" + r111 + '/' + r113 + ')');
        r101.L$0 = r100;
        r101.label = 1;
        if (DelayKt.delay(r114, r101) != r104) goto L30;
        return r104;
    L31:
        r110.i(r106, "preProcess, path = " + r100.f294853a + ", delay skipped");
    L7:
        r101 = new DelayDowngradeStrategy$preProcess$1(this, r211);
        goto L8
    }
}
