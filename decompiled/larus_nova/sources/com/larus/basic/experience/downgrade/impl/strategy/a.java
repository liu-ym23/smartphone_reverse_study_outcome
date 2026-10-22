package com.larus.basic.experience.downgrade.impl.strategy;

import com.larus.platform.model.downgrade.BlockDowngradeStrategyConfig;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a<T> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BlockDowngradeStrategyConfig f294849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f294850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f294851c;

    /* JADX INFO: renamed from: com.larus.basic.experience.downgrade.impl.strategy.a$a, reason: collision with other inner class name */
    public static final class C4014a {
    }

    public static final class b extends BDNetworkTagContextProviderAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f294852a;

        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final int triggerType() {
            return !this.f294852a ? 1 : 0;
        }

        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final boolean markAsNewUser() {
            return super.markAsNewUser();
        }

        public b(boolean r100) {
            this.f294852a = r100;
        }
    }

    static {
    }

    @Override // com.larus.basic.experience.downgrade.impl.strategy.c
    public final Map<String, List<String>> a() {
        return this.f294849a.getBodyMatchers();
    }

    @Override // com.larus.basic.experience.downgrade.impl.strategy.c
    public final Map<String, List<String>> b() {
        return this.f294849a.getQueryMatchers();
    }

    @Override // com.larus.basic.experience.downgrade.impl.strategy.c
    public final Map<String, List<String>> f() {
        return this.f294849a.getExtraMatchers();
    }

    @Override // com.larus.basic.experience.downgrade.impl.strategy.c
    public final int d() {
        return this.f294850b;
    }

    @Override // com.larus.basic.experience.downgrade.impl.strategy.c
    public final int g() {
        return this.f294851c;
    }

    public a(BlockDowngradeStrategyConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f294849a = r100;
        this.f294850b = 100;
        this.f294851c = -1;
    }

    @Override // com.larus.basic.experience.downgrade.impl.strategy.c
    public final Pair c(com.larus.basic.experience.downgrade.impl.strategy.b r100, com.larus.network.http.a r101) {
        return TuplesKt.to(r100, r101);
    }

    @Override // com.larus.basic.experience.downgrade.impl.strategy.c
    public final Object e(com.larus.basic.experience.downgrade.impl.strategy.b<T> r100, Continuation<? super com.larus.basic.experience.downgrade.impl.strategy.b<T>> r101) {
        Pair<Boolean, String> r102 = c.a.a(this, r100, false);
        boolean r103 = r102.component1().booleanValue();
        String r104 = r102.component2();
        FLogger.f375446a.i("BlockDowngradeStrategy", "preProcess, path = " + r100.f294853a + ", isAuto = " + r103 + ", reason = " + r104);
        Map<String, String> r105 = r100.f294855c;
        LinkedHashMap r106 = new LinkedHashMap();
        r106.putAll(r105);
        android.util.Pair<String, String> r107 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new b(r103));
        Pair r108 = new Pair(r107.first, r107.second);
        Map<String, String> r109 = r100.f294860h;
        if (r109 == null) goto L5;
        String r110 = r109.put("request_tag", (String) r108.getSecond());
    L5:
        r106.putAll(MapsKt.mapOf(r108));
        Unit r111 = Unit.INSTANCE;
        return com.larus.basic.experience.downgrade.impl.strategy.b.a(r100, r106, null, 251);
    }
}
