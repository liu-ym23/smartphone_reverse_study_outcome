package com.larus.suggest.impl.repo;

import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.network.http.f;
import com.larus.network.http.y;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import ic8.k0;
import ic8.s;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f369910a = null;

    /* JADX INFO: renamed from: com.larus.suggest.impl.repo.a$a, reason: collision with other inner class name */
    public static final class C4499a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f369911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f369912b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4499a) == true) goto L8;
            return false;
        L8:
            C4499a r101 = (C4499a) r100;
            if (this.f369911a == r101.f369911a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f369912b, r101.f369912b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f369911a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            String r102 = this.f369912b;
            if (r102 != null) goto L5;
            int r103 = 0;
        L7:
            return r101 + r103;
        L5:
            r103 = r102.hashCode();
            goto L7
        }

        public final String toString() {
            return "ErrorInfo(code=" + this.f369911a + ", msg=" + this.f369912b + ')';
        }

        public C4499a(long r100, String r101) {
            this.f369911a = r100;
            this.f369912b = r101;
        }
    }

    static {
        f369910a = new a();
    }

    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(String r210, String r211, int r212, String r213, k0 r214, String r215, boolean r216, Continuation r310) {
        if ((r310 instanceof NexPulseRepo$getNexPulse$1) == false) goto L7;
        NexPulseRepo$getNexPulse$1 r100 = (NexPulseRepo$getNexPulse$1) r310;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        NexPulseRepo$getNexPulse$1 r110 = r100;
        Object r102 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r110.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
        Object r104 = null;
    L31:
        com.larus.network.http.a r105 = (com.larus.network.http.a) r102;
        if ((r105 instanceof y) == false) goto L47;
        y r106 = (y) r105;
        Long r107 = r106.f360205g;
        if (r107 != null) goto L37;
    L40:
        FLogger.f375446a.e(r12, "failed in get next pulse code=" + r106.f360205g + " msg=" + r106.f360204f);
        Long r108 = r106.f360205g;
        if (r108 == null) goto L43;
        long r109 = r108.longValue();
    L45:
        return TuplesKt.to(r104, new C4499a(r109, r106.f360204f));
    L43:
        r109 = -1;
        goto L45
    L37:
        if (r107.longValue() != 0) goto L40;
        NexPulseResponseData r112 = (NexPulseResponseData) r106.f360135b;
        FLogger.f375446a.i("WcbNexPulseRepo", "success in get next pulse " + r112);
        return TuplesKt.to(r112, r104);
    L47:
        if ((r105 instanceof f) == false) goto L51;
        FLogger.f375446a.e(r12, "failed get next pulse " + r105);
        f r113 = (f) r105;
        return TuplesKt.to(r104, new C4499a(r113.f360157d.getCode(), r113.f360157d.getMessage()));
    L51:
        return TuplesKt.to(r104, r104);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        FLogger.f375446a.i("WcbNexPulseRepo", "getNexPulse botId=" + r210 + " cvsId=" + r211 + " scene=" + r212 + " params=" + r214 + " token=" + r213 + " isFirst=false reqSrc=" + r215 + " skipCache=" + r216);
        LinkedHashMap r114 = new LinkedHashMap();
        if (z2.f365865a.z3().a() == false) goto L17;
        r114.put("resource-slot", "slot_api");
    L17:
        NexPulseApi.a r115 = NexPulseApi.f369908a;
        s r116 = new s(r210, r211, Boxing.boxInt(r212), r214, r216, r213, false);
        r110.label = 1;
        r115.getClass();
        FlowDowngradeServiceDelegate r117 = FlowDowngradeServiceDelegate.INSTANCE;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L20
        Object r119 = Result.m9449constructorimpl(new JSONObject(HttpExtKt.f360123f.toJson(r116)));     // Catch: Throwable -> L20
    L23:
        if (Result.m9455isFailureimpl(r119) == false) goto L25;
        r119 = null;
    L25:
        JSONObject r120 = (JSONObject) r119;
        if (r120 != null) goto L28;
        r120 = new JSONObject();
    L28:
        r104 = null;
        r102 = IFlowDowngradeService.a.b(r117, ServiceType.IM, NexPulseResponseData.class, "/biz/onboarding/get_nexpulse", r120, r114, false, null, MapsKt.mapOf(TuplesKt.to("source", r215)), r110, TTVideoEngineInterface.PLAYER_OPTION_DUMMYSURFACE_FORBID);
        if (r102 != r111) goto L31;
        return r111;
    L20:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new NexPulseRepo$getNexPulse$1(this, r310);
        goto L8
    }
}
