package com.larus.dora.o.impl.memory;

import com.larus.dora.api.model.FlowDoraSubBizType;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.ranges.LongRange;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class OMemoryRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OMemoryRepo f338779a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LongRange f338780b = null;

    public OMemoryRepo() {
    }

    static {
        f338779a = new OMemoryRepo();
        f338780b = new LongRange(1, 3);
    }

    public static JSONObject b() {
        JSONObject r100 = new JSONObject();
        r100.put("dora_sub_biz", FlowDoraSubBizType.G1_G2.getValue());
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object f(Continuation<? super p0> r110) {
        if ((r110 instanceof OMemoryRepo$fetchProfileList$1) == false) goto L7;
        OMemoryRepo$fetchProfileList$1 r100 = (OMemoryRepo$fetchProfileList$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        OMemoryRepo$fetchProfileList$1 r102 = r100;
        Object r111 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L14;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L28
    L19:
        com.larus.network.http.a r112 = (com.larus.network.http.a) r111;     // Catch: Throwable -> L28
        if ((r112 instanceof com.larus.network.http.y) == false) goto L22;
        com.larus.network.http.y r113 = (com.larus.network.http.y) r112;     // Catch: Throwable -> L28
    L23:
        if (r113 == null) goto L25;
        p0 r114 = (p0) r113.f360135b;     // Catch: Throwable -> L28
    L26:
        Object r115 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L28
    L30:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r115);
        if (r105 == null) goto L34;
        FLogger.f375446a.e("OMemoryRepo", "fetchProfileList failed", r105);
    L34:
        if (Result.m9455isFailureimpl(r115) == false) goto L37;
        return null;
    L37:
        return r115;
    L25:
        r114 = null;
        goto L26
    L22:
        r113 = null;
        goto L23
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r111);
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L28
        com.larus.dora.api.network.a r106 = com.larus.dora.api.network.a.f331768a;     // Catch: Throwable -> L28
        JSONObject r107 = b();     // Catch: Throwable -> L28
        r102.label = 1;     // Catch: Throwable -> L28
        r111 = com.larus.dora.api.network.a.c(r106, p0.class, "/alice/wearable/diary/get_user_profile_list", r107, null, r102, 248);     // Catch: Throwable -> L28
        if (r111 != r103) goto L19;
        return r103;
    L28:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new OMemoryRepo$fetchProfileList$1(this, r110);
        goto L8
    }

    public final Object c(String r100, Continuation<? super Boolean> r110) {
        if ((r110 instanceof OMemoryRepo$deleteEvent$1) == false) goto L7;
        OMemoryRepo$deleteEvent$1 r101 = (OMemoryRepo$deleteEvent$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        OMemoryRepo$deleteEvent$1 r103 = r101;
        Object r111 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L21
    L19:
        Object r106 = Result.m9449constructorimpl(Boxing.boxBoolean(r111 instanceof com.larus.network.http.y));     // Catch: Throwable -> L21
    L23:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r106);
        if (r112 == null) goto L26;
        FLogger.f375446a.e("OMemoryRepo", "deleteEvent failed", r112);
    L26:
        Boolean r113 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r106) == true) goto L29;
        return r106;
    L29:
        return r113;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r111);
        JSONObject r107 = b();
        r107.put("event_ids", new JSONArray().put(r100));
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L21
        com.larus.dora.api.network.a r109 = com.larus.dora.api.network.a.f331768a;     // Catch: Throwable -> L21
        r103.label = 1;     // Catch: Throwable -> L21
        r111 = com.larus.dora.api.network.a.c(r109, Object.class, "/alice/wearable/event/delete_user_event", r107, null, r103, 248);     // Catch: Throwable -> L21
        if (r111 != r104) goto L19;
        return r104;
    L21:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = new OMemoryRepo$deleteEvent$1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object d(long r110, Continuation<? super p0> r111) {
        if ((r111 instanceof OMemoryRepo$deleteProfile$1) == false) goto L7;
        OMemoryRepo$deleteProfile$1 r100 = (OMemoryRepo$deleteProfile$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        OMemoryRepo$deleteProfile$1 r102 = r100;
        Object r112 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L14;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L28
    L19:
        com.larus.network.http.a r113 = (com.larus.network.http.a) r112;     // Catch: Throwable -> L28
        if ((r113 instanceof com.larus.network.http.y) == false) goto L22;
        com.larus.network.http.y r114 = (com.larus.network.http.y) r113;     // Catch: Throwable -> L28
    L23:
        if (r114 == null) goto L25;
        p0 r115 = (p0) r114.f360135b;     // Catch: Throwable -> L28
    L26:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L28
    L30:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L34;
        FLogger.f375446a.e("OMemoryRepo", "deleteProfile failed", r117);
    L34:
        if (Result.m9455isFailureimpl(r116) == false) goto L37;
        return null;
    L37:
        return r116;
    L25:
        r115 = null;
        goto L26
    L22:
        r114 = null;
        goto L23
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r112);
        JSONObject r105 = b();
        r105.put("entry_id", r110);
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L28
        com.larus.dora.api.network.a r106 = com.larus.dora.api.network.a.f331768a;     // Catch: Throwable -> L28
        r102.label = 1;     // Catch: Throwable -> L28
        r112 = com.larus.dora.api.network.a.c(r106, p0.class, "/alice/wearable/diary/delete_user_profile", r105, null, r102, 248);     // Catch: Throwable -> L28
        if (r112 != r103) goto L19;
        return r103;
    L28:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new OMemoryRepo$deleteProfile$1(this, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object e(String r110, Continuation<? super a0> r111) {
        if ((r111 instanceof OMemoryRepo$fetchEventList$1) == false) goto L7;
        OMemoryRepo$fetchEventList$1 r100 = (OMemoryRepo$fetchEventList$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        OMemoryRepo$fetchEventList$1 r102 = r100;
        Object r112 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L14;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L28
    L19:
        com.larus.network.http.a r113 = (com.larus.network.http.a) r112;     // Catch: Throwable -> L28
        if ((r113 instanceof com.larus.network.http.y) == false) goto L22;
        com.larus.network.http.y r114 = (com.larus.network.http.y) r113;     // Catch: Throwable -> L28
    L23:
        if (r114 == null) goto L25;
        a0 r115 = (a0) r114.f360135b;     // Catch: Throwable -> L28
    L26:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L28
    L30:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L34;
        FLogger.f375446a.e("OMemoryRepo", "fetchEventList failed", r117);
    L34:
        if (Result.m9455isFailureimpl(r116) == false) goto L37;
        return null;
    L37:
        return r116;
    L25:
        r115 = null;
        goto L26
    L22:
        r114 = null;
        goto L23
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r112);
        JSONObject r105 = b();
        r105.put("size", 20);
        r105.put(EffectConfiguration.KEY_CURSOR, r110);
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L28
        com.larus.dora.api.network.a r106 = com.larus.dora.api.network.a.f331768a;     // Catch: Throwable -> L28
        r102.label = 1;     // Catch: Throwable -> L28
        r112 = com.larus.dora.api.network.a.c(r106, a0.class, "/alice/wearable/event/list_user_event", r105, null, r102, 248);     // Catch: Throwable -> L28
        if (r112 != r103) goto L19;
        return r103;
    L28:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new OMemoryRepo$fetchEventList$1(this, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object g(long r110, String r111, Continuation<? super q0> r112) {
        if ((r112 instanceof OMemoryRepo$updateProfile$1) == false) goto L7;
        OMemoryRepo$updateProfile$1 r100 = (OMemoryRepo$updateProfile$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        OMemoryRepo$updateProfile$1 r102 = r100;
        Object r113 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        boolean r105 = true;
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L14;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L38
    L19:
        com.larus.network.http.a r114 = (com.larus.network.http.a) r113;     // Catch: Throwable -> L38
        if ((r114 instanceof com.larus.network.http.y) == false) goto L23;
        q0 r115 = new q0((p0) ((com.larus.network.http.y) r114).f360135b, Boxing.boxLong(0));     // Catch: Throwable -> L38
    L36:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L38
    L40:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L44;
        FLogger.f375446a.e("OMemoryRepo", "updateProfile failed", r117);
    L44:
        if (Result.m9455isFailureimpl(r116) == false) goto L47;
        return null;
    L47:
        return r116;
    L23:
        if ((r114 instanceof com.larus.network.http.f) == false) goto L35;
        Long r118 = Boxing.boxLong(((com.larus.network.http.f) r114).f360157d.getCode());     // Catch: Throwable -> L38
        long r119 = r118.longValue();     // Catch: Throwable -> L38
        LongRange r120 = f338780b;     // Catch: Throwable -> L38
        long r106 = r120.getFirst();     // Catch: Throwable -> L38
        if (r119 <= r120.getLast()) goto L27;
    L29:
        r105 = false;
    L30:
        if (r105 == true) goto L33;
        r118 = null;
    L33:
        if (r118 == null) goto L35;
        r115 = new q0(null, Boxing.boxLong(r118.longValue()));     // Catch: Throwable -> L38
        goto L36
    L27:
        if (r106 > r119) goto L29;
    L35:
        r115 = null;
        goto L36
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r113);
        JSONObject r107 = b();
        r107.put("entry_id", r110);
        r107.put("content", r111);
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L38
        com.larus.dora.api.network.a r108 = com.larus.dora.api.network.a.f331768a;     // Catch: Throwable -> L38
        r102.label = 1;     // Catch: Throwable -> L38
        r113 = com.larus.dora.api.network.a.c(r108, p0.class, "/alice/wearable/diary/update_user_profile", r107, null, r102, 248);     // Catch: Throwable -> L38
        if (r113 != r103) goto L19;
        return r103;
    L38:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new OMemoryRepo$updateProfile$1(this, r112);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(String r110, long r111, String r112, Continuation<? super q0> r113) {
        if ((r113 instanceof OMemoryRepo$addProfile$1) == false) goto L7;
        OMemoryRepo$addProfile$1 r100 = (OMemoryRepo$addProfile$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        OMemoryRepo$addProfile$1 r102 = r100;
        Object r114 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        boolean r105 = true;
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L14;
        ResultKt.throwOnFailure(r114);     // Catch: Throwable -> L38
    L19:
        com.larus.network.http.a r115 = (com.larus.network.http.a) r114;     // Catch: Throwable -> L38
        if ((r115 instanceof com.larus.network.http.y) == false) goto L23;
        q0 r116 = new q0((p0) ((com.larus.network.http.y) r115).f360135b, Boxing.boxLong(0));     // Catch: Throwable -> L38
    L36:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L38
    L40:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L44;
        FLogger.f375446a.e("OMemoryRepo", "addProfile failed", r118);
    L44:
        if (Result.m9455isFailureimpl(r117) == false) goto L47;
        return null;
    L47:
        return r117;
    L23:
        if ((r115 instanceof com.larus.network.http.f) == false) goto L35;
        Long r119 = Boxing.boxLong(((com.larus.network.http.f) r115).f360157d.getCode());     // Catch: Throwable -> L38
        long r120 = r119.longValue();     // Catch: Throwable -> L38
        LongRange r121 = f338780b;     // Catch: Throwable -> L38
        long r106 = r121.getFirst();     // Catch: Throwable -> L38
        if (r120 <= r121.getLast()) goto L27;
    L29:
        r105 = false;
    L30:
        if (r105 == true) goto L33;
        r119 = null;
    L33:
        if (r119 == null) goto L35;
        r116 = new q0(null, Boxing.boxLong(r119.longValue()));     // Catch: Throwable -> L38
        goto L36
    L27:
        if (r106 > r120) goto L29;
    L35:
        r116 = null;
        goto L36
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r114);
        JSONObject r107 = b();
        r107.put("content", r110);
        r107.put("client_req_id", r112);
        r107.put("max_entries", r111);
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L38
        com.larus.dora.api.network.a r108 = com.larus.dora.api.network.a.f331768a;     // Catch: Throwable -> L38
        r102.label = 1;     // Catch: Throwable -> L38
        r114 = com.larus.dora.api.network.a.c(r108, p0.class, "/alice/wearable/diary/add_user_profile", r107, null, r102, 248);     // Catch: Throwable -> L38
        if (r114 != r103) goto L19;
        return r103;
    L38:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new OMemoryRepo$addProfile$1(this, r113);
        goto L8
    }
}
