package com.larus.suggest.impl.wcb.policy;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.bmhome.chat.bean.NexPulseConf;
import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes31.dex */
public final class w implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<com.larus.suggest.impl.wcb.request.f, String> f370011a;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w(Function1<? super com.larus.suggest.impl.wcb.request.f, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "cacheScope");
        this.f370011a = r100;
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final String b(com.larus.suggest.impl.wcb.request.f r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        return n(r100).f369918d;
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long c(com.larus.suggest.impl.wcb.request.f r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        return n(r100).f369919e;
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long e(com.larus.suggest.impl.wcb.request.f r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        return n(r100).f369921g;
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long f(com.larus.suggest.impl.wcb.request.f r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        return n(r100).f369915a;
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long g(com.larus.suggest.impl.wcb.request.f r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        return n(r100).f369920f;
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long i(com.larus.suggest.impl.wcb.request.f r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        return System.currentTimeMillis() - n(r100).f369917c;
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final String j(com.larus.suggest.impl.wcb.request.f r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        return this.f370011a.invoke(r100);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final v k(com.larus.suggest.impl.wcb.request.f r210) {
        Intrinsics.checkNotNullParameter(r210, "snapshot");
        String r100 = this.f370011a.invoke(r210);
        com.larus.suggest.impl.repo.e r101 = com.larus.suggest.impl.repo.e.f369922a;
        int r102 = r210.f370118f.f370099a.getScene();
        String r103 = r210.f370113a;
        r101.getClass();
        com.larus.suggest.impl.repo.d r104 = com.larus.suggest.impl.repo.e.b(r100, r102, r103);
        String r105 = ", conv_id=";
        if (r104 != null) goto L6;
        FLogger.f375446a.i("WcbLog", "[LocalCache] cache miss: no state, executionId=" + r210.f370117e + ", conv_id=" + r210.f370114b + ", cache_scope=" + r100 + ", scene=" + r210.f370118f.f370099a.getScene());
        return v.b.f370010a;
    L6:
        long r106 = AppHost.f326268a.getAppClock().currentTimeMillis() / 1000;
        long r110 = r104.f369915a;
        if (1 <= r110) goto L9;
    L11:
        boolean r107 = false;
    L13:
        if (r107 == false) goto L17;
        com.larus.suggest.impl.repo.e.a(r100, r210.f370118f.f370099a.getScene(), r210.f370113a);
        FLogger.f375446a.i("WcbLog", "[LocalCache] cache miss: expired response cleared, executionId=" + r210.f370117e + ", conv_id=" + r210.f370114b + ", cache_scope=" + r100 + ", scene=" + r210.f370118f.f370099a.getScene() + ", expireTimeSec=" + x.a(Long.valueOf(r104.f369915a), r106) + ", nowSec=" + r106 + ", retainedLastRequestTimeMs=" + r104.f369917c + ", retainedFreqReqIntervalSec=" + r104.f369919e);
        return v.b.f370010a;
    L17:
        if (r110 > 0) goto L20;
        FLogger.f375446a.i("WcbLog", "[LocalCache] cache miss: no valid expiry, executionId=" + r210.f370117e + ", conv_id=" + r210.f370114b + ", cache_scope=" + r100 + ", scene=" + r210.f370118f.f370099a.getScene() + ", expireTimeSec=" + x.a(Long.valueOf(r104.f369915a), r106));
        return v.b.f370010a;
    L20:
        int r111 = r210.f370118f.f370099a.getScene();
        String r108 = r210.f370113a;
        long r112 = r104.f369916b;
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r108, "userId");
        if (r112 > 0) goto L23;
        String r113 = ", cache_scope=";
        NexPulseResponseData r114 = null;
    L25:
        r105 = ", conv_id=";
        NexPulseResponseData r115 = r114;
    L45:
        if (r115 == null) goto L50;
        if (r115.isValid() != true) goto L50;
        boolean r109 = true;
    L52:
        if (r109 == false) goto L55;
        FLogger.f375446a.i("WcbLog", "[LocalCache] cache hit, executionId=" + r210.f370117e + ", expireTimeSec=" + x.a(Long.valueOf(r104.f369915a), r106) + r105 + r210.f370114b + r113 + r100 + ", scene=" + r210.f370118f.f370099a.getScene() + ", responseVersion=" + r104.f369916b + ", nowSec=" + r106);
        return new v.a(r115);
    L55:
        com.larus.suggest.impl.repo.e r116 = com.larus.suggest.impl.repo.e.f369922a;
        int r117 = r210.f370118f.f370099a.getScene();
        String r118 = r210.f370113a;
        r116.getClass();
        com.larus.suggest.impl.repo.e.a(r100, r117, r118);
        FLogger r119 = FLogger.f375446a;
        StringBuilder r120 = new StringBuilder("[LocalCache] cache miss: missing or invalid response cleared, executionId=");
        r120.append(r210.f370117e);
        r120.append(r105);
        r120.append(r210.f370114b);
        r120.append(r113);
        r120.append(r100);
        r120.append(", scene=");
        r120.append(r210.f370118f.f370099a.getScene());
        r120.append(", responsePresent=");
        if (r115 == null) goto L58;
        boolean r121 = true;
    L59:
        r120.append(r121);
        r120.append(", responseVersion=");
        r120.append(r104.f369916b);
        r120.append(", retainedLastRequestTimeMs=");
        r120.append(r104.f369917c);
        r120.append(", retainedFreqReqIntervalSec=");
        r120.append(r104.f369919e);
        r119.i("WcbLog", r120.toString());
        return v.b.f370010a;
    L58:
        r121 = false;
    L50:
        r109 = false;
        goto L52
    L23:
        com.larus.suggest.impl.repo.c r122 = com.larus.suggest.impl.repo.e.f369923b;
        String r123 = com.larus.suggest.impl.repo.e.c(r100, r111);
        r122.getClass();
        r113 = ", cache_scope=";
        Intrinsics.checkNotNullParameter(r123, "key");
        Intrinsics.checkNotNullParameter(r108, "userId");
        r114 = null;
        String r124 = ((Keva) com.larus.suggest.impl.repo.c.f369914b.getValue()).getString(com.larus.suggest.impl.repo.c.b(r123, r108), null);
        if (r124 == null) goto L25;
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L28
        Object r126 = Result.m9449constructorimpl((com.larus.suggest.impl.repo.e.a) HttpExtKt.f360123f.fromJson(r124, com.larus.suggest.impl.repo.e.a.class));     // Catch: Throwable -> L28
    L30:
        Throwable r127 = Result.m9452exceptionOrNullimpl(r126);
        if (r127 == null) goto L35;
        FLogger.f375446a.e("WcbLog", "[keva] invalid policy response, conversationId=" + r100 + ", scene=" + r111, r127);
    L35:
        if (Result.m9455isFailureimpl(r126) == false) goto L37;
        r126 = null;
    L37:
        com.larus.suggest.impl.repo.e.a r128 = (com.larus.suggest.impl.repo.e.a) r126;
        if (r128 != null) goto L41;
    L43:
        r115 = null;
        goto L45
    L41:
        if (r128.f369924a == r112) goto L44;
        FLogger.f375446a.w("WcbLog", "[keva] policy response version mismatch, conversationId=" + r100 + ", scene=" + r111 + ", expected=" + r112 + ", actual=" + r128.f369924a);
        goto L43
    L44:
        r115 = r128.f369925b;
    L28:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    L9:
        if (r110 > r106) goto L11;
        r107 = true;
        goto L13
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final boolean l(com.larus.suggest.impl.wcb.request.f r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        return false;
    }

    public final com.larus.suggest.impl.repo.d n(com.larus.suggest.impl.wcb.request.f r100) {
        com.larus.suggest.impl.repo.e r101 = com.larus.suggest.impl.repo.e.f369922a;
        String r102 = this.f370011a.invoke(r100);
        int r103 = r100.f370118f.f370099a.getScene();
        String r104 = r100.f370113a;
        r101.getClass();
        com.larus.suggest.impl.repo.d r105 = com.larus.suggest.impl.repo.e.b(r102, r103, r104);
        if (r105 == null) goto L5;
        return r105;
    L5:
        return new com.larus.suggest.impl.repo.d(0);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final void d(com.larus.suggest.impl.wcb.request.f r310, NexPulseConf r311) {
        Intrinsics.checkNotNullParameter(r310, "snapshot");
        String r100 = this.f370011a.invoke(r310);
        com.larus.suggest.impl.repo.e r101 = com.larus.suggest.impl.repo.e.f369922a;
        int r102 = r310.f370118f.f370099a.getScene();
        String r103 = r310.f370113a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r103, "userId");
        FLogger r104 = FLogger.f375446a;
        r104.i("WcbLog", "[keva] updateNexPulseConf conversationId=" + r100 + ", scene=" + r102 + ", conf=" + r311);
        com.larus.suggest.impl.repo.d r105 = com.larus.suggest.impl.repo.e.b(r100, r102, r103);
        boolean r110 = false;
        if (r105 != null) goto L5;
        r105 = new com.larus.suggest.impl.repo.d(0);
    L5:
        com.larus.suggest.impl.repo.d r111 = r105;
        if (r311 == null) goto L11;
        String r106 = r311.getThroughToken();
        if (r106 == null) goto L11;
        String r107 = p0.a(r106);
        if (r107 == null) goto L11;
    L12:
        String r112 = r107;
        if (r311 == null) goto L17;
        Long r108 = r311.getFreqReqInterval();
        if (r108 == null) goto L17;
        long r210 = RangesKt.coerceAtLeast(r108.longValue(), 0);
    L18:
        if (r311 == null) goto L22;
        Long r109 = r311.getFreqControlInterval();
        if (r109 == null) goto L22;
        long r211 = RangesKt.coerceAtLeast(r109.longValue(), 0);
    L23:
        com.larus.suggest.impl.repo.e.e(r100, r102, com.larus.suggest.impl.repo.d.a(r111, 0, 0, 0, r112, r210, r211, 0, 71), r103);
        StringBuilder r113 = new StringBuilder("[LocalCache] record network response conf, executionId=");
        r113.append(r310.f370117e);
        r113.append(", conv_id=");
        r113.append(r310.f370114b);
        r113.append(", cache_scope=");
        r113.append(r100);
        r113.append(", scene=");
        r113.append(r310.f370118f.f370099a.getScene());
        r113.append(", confPresent=");
        if (r311 == null) goto L26;
        r110 = true;
    L26:
        r113.append(r110);
        r113.append(", freqReqIntervalSec=");
        if (r311 == null) goto L31;
        Long r114 = r311.getFreqReqInterval();
        if (r114 == null) goto L31;
        long r115 = 0;
        long r116 = RangesKt.coerceAtLeast(r114.longValue(), 0);
    L32:
        r113.append(r116);
        r113.append(", freqControlIntervalSec=");
        if (r311 == null) goto L37;
        Long r117 = r311.getFreqControlInterval();
        if (r117 == null) goto L37;
        long r118 = RangesKt.coerceAtLeast(r117.longValue(), r115);
    L38:
        r113.append(r118);
        r104.i("WcbLog", r113.toString());
        return;
    L37:
        r118 = r115;
    L31:
        r115 = 0;
        r116 = 0;
    L22:
        r211 = 0;
    L17:
        r210 = 0;
    L11:
        r107 = r111.f369918d;
        goto L12
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final void m(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final void a(com.larus.suggest.impl.wcb.request.f r210, NexPulseResponseData r310, long r311) {
        Intrinsics.checkNotNullParameter(r210, "snapshot");
        Intrinsics.checkNotNullParameter(r310, "response");
        String r110 = this.f370011a.invoke(r210);
        com.larus.suggest.impl.repo.e r100 = com.larus.suggest.impl.repo.e.f369922a;
        int r111 = r210.f370118f.f370099a.getScene();
        String r112 = r210.f370113a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "conversationId");
        Intrinsics.checkNotNullParameter(r310, "response");
        Intrinsics.checkNotNullParameter(r112, "userId");
        com.larus.suggest.impl.repo.d r101 = com.larus.suggest.impl.repo.e.b(r110, r111, r112);
        if (r101 != null) goto L5;
        r101 = new com.larus.suggest.impl.repo.d(0);
    L5:
        long r102 = Math.max(r101.f369916b + 1, r311);
        com.larus.suggest.impl.repo.c r103 = com.larus.suggest.impl.repo.e.f369923b;
        String r104 = com.larus.suggest.impl.repo.e.c(r110, r111);
        String r105 = GsonProtectorUtils.toJson(HttpExtKt.f360123f, new com.larus.suggest.impl.repo.e.a(r102, r310));
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "key");
        Intrinsics.checkNotNullParameter(r105, "value");
        Intrinsics.checkNotNullParameter(r112, "userId");
        ((Keva) com.larus.suggest.impl.repo.c.f369914b.getValue()).storeString(com.larus.suggest.impl.repo.c.b(r104, r112), r105);
        NexPulseConf r106 = r310.getConf();
        long r113 = 0;
        if (r106 == null) goto L10;
        Long r107 = r106.getExpireTime();
        if (r107 == null) goto L10;
        long r108 = r107.longValue();
    L11:
        com.larus.suggest.impl.repo.e.e(r110, r111, com.larus.suggest.impl.repo.d.a(r101, r108, r102, 0, null, 0, 0, r311, 60), r112);
        long r109 = AppHost.f326268a.getAppClock().currentTimeMillis() / 1000;
        FLogger r114 = FLogger.f375446a;
        StringBuilder r115 = new StringBuilder("[LocalCache] persist accepted response, executionId=");
        r115.append(r210.f370117e);
        r115.append(", conv_id=");
        r115.append(r210.f370114b);
        r115.append(", cache_scope=");
        r115.append(r110);
        r115.append(", scene=");
        r115.append(r210.f370118f.f370099a.getScene());
        r115.append(", expireTimeSec=");
        NexPulseConf r116 = r310.getConf();
        if (r116 == null) goto L16;
        Long r117 = r116.getExpireTime();
        if (r117 == null) goto L16;
        r113 = r117.longValue();
    L16:
        r115.append(x.a(Long.valueOf(r113), r109));
        r115.append(", updateTimeMs=");
        r115.append(r311);
        r114.i("WcbLog", r115.toString());
        return;
    L10:
        r108 = 0;
        goto L11
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final void h(com.larus.suggest.impl.wcb.request.f r210, long r211, long r212) {
        Intrinsics.checkNotNullParameter(r210, "snapshot");
        String r100 = this.f370011a.invoke(r210);
        com.larus.suggest.impl.repo.e r101 = com.larus.suggest.impl.repo.e.f369922a;
        int r102 = r210.f370118f.f370099a.getScene();
        String r103 = r210.f370113a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r103, "userId");
        com.larus.suggest.impl.repo.d r104 = com.larus.suggest.impl.repo.e.b(r100, r102, r103);
        if (r104 != null) goto L5;
        r104 = new com.larus.suggest.impl.repo.d(0);
    L5:
        com.larus.suggest.impl.repo.e.e(r100, r102, com.larus.suggest.impl.repo.d.a(r104, 0, 0, r212, null, 0, 0, 0, 123), r103);
        FLogger.f375446a.i("WcbLog", "[LocalCache] record request start, executionId=" + r210.f370117e + ", conv_id=" + r210.f370114b + ", cache_scope=" + r100 + ", scene=" + r210.f370118f.f370099a.getScene() + ", requestTimeMs=" + r212);
    }
}
