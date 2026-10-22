package com.larus.dora.o.impl.diary;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larus.account.base.api.ILoginService;
import com.larus.dora.api.model.FlowDoraSubBizType;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraODiaryRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraODiaryRepo f338435a = null;

    static {
        f338435a = new DoraODiaryRepo();
    }

    public DoraODiaryRepo() {
    }

    public static JSONObject a(l0 r100) {
        if (r100 == null) goto L5;
        String r101 = r100.f338560c;
    L6:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        if (r100 == null) goto L10;
        int r102 = r100.f338561d;
    L12:
        if (StringsKt.isBlank(r101) == false) goto L15;
        if (r102 > 0) goto L15;
        return null;
    L15:
        JSONObject r103 = new JSONObject();
        if (r102 <= 0) goto L19;
        r103.put("diary_version", r102);
    L19:
        if ((!StringsKt.isBlank(r101)) == false) goto L21;
        JSONObject r104 = new JSONObject();
        r104.put("snapshot_json", r101);
        Unit r105 = Unit.INSTANCE;
        r103.put("extra", r104);
    L21:
        return r103;
    L10:
        r102 = 0;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object g(Continuation<? super u0> r100) {
        if ((r100 instanceof DoraODiaryRepo$fetchStyleList$1) == false) goto L7;
        DoraODiaryRepo$fetchStyleList$1 r101 = (DoraODiaryRepo$fetchStyleList$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        DoraODiaryRepo$fetchStyleList$1 r103 = r101;
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L23
    L19:
        com.larus.network.http.a r107 = (com.larus.network.http.a) r104;     // Catch: Exception -> L23
        if ((r107 instanceof com.larus.network.http.y) == false) goto L25;
        return (u0) ((com.larus.network.http.y) r107).f360135b;
    L25:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L23
        FlowDoraSubBizType.Companion.getClass();     // Catch: Exception -> L23
        r108.put("dora_sub_biz", FlowDoraSubBizType.a.a());     // Catch: Exception -> L23
        com.larus.dora.api.network.a r109 = com.larus.dora.api.network.a.f331768a;     // Catch: Exception -> L23
        r103.label = 1;     // Catch: Exception -> L23
        r104 = com.larus.dora.api.network.a.c(r109, u0.class, "/alice/wearable/diary/get_style", r108, null, r103, 248);     // Catch: Exception -> L23
        if (r104 != r105) goto L19;
        return r105;
    L23:
        e = move-exception;
        FLogger.f375446a.e("DoraODiaryRepo", "fetchStyleList error: " + e.getMessage());
    L7:
        r101 = new DoraODiaryRepo$fetchStyleList$1(this, r100);
        goto L8
    }

    public final Object b(List<String> r100, Continuation<? super Boolean> r110) {
        if ((r110 instanceof DoraODiaryRepo$deleteDiary$1) == false) goto L7;
        DoraODiaryRepo$deleteDiary$1 r101 = (DoraODiaryRepo$deleteDiary$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        DoraODiaryRepo$deleteDiary$1 r103 = r101;
        Object r111 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r111);     // Catch: Exception -> L21
    L19:
        boolean r106 = ((com.larus.network.http.a) r111) instanceof com.larus.network.http.y;     // Catch: Exception -> L21
    L24:
        return Boxing.boxBoolean(r106);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r111);
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L21
        r107.put("diary_ids", new JSONArray(r100));     // Catch: Exception -> L21
        com.larus.dora.api.network.a r108 = com.larus.dora.api.network.a.f331768a;     // Catch: Exception -> L21
        r103.label = 1;     // Catch: Exception -> L21
        r111 = com.larus.dora.api.network.a.c(r108, Object.class, "/alice/wearable/diary/delete_user_diary", r107, null, r103, 248);     // Catch: Exception -> L21
        if (r111 != r104) goto L19;
        return r104;
    L21:
        e = move-exception;
        FLogger.f375446a.e("DoraODiaryRepo", "deleteDiary error: " + e.getMessage());
        r106 = false;
    L7:
        r101 = new DoraODiaryRepo$deleteDiary$1(this, r110);
        goto L8
    }

    public final Object c(String r100, Continuation<? super Boolean> r110) {
        if ((r110 instanceof DoraODiaryRepo$deleteStyle$1) == false) goto L7;
        DoraODiaryRepo$deleteStyle$1 r101 = (DoraODiaryRepo$deleteStyle$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        DoraODiaryRepo$deleteStyle$1 r103 = r101;
        Object r111 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r111);     // Catch: Exception -> L21
    L19:
        boolean r106 = ((com.larus.network.http.a) r111) instanceof com.larus.network.http.y;     // Catch: Exception -> L21
    L24:
        return Boxing.boxBoolean(r106);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r111);
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L21
        FlowDoraSubBizType.Companion.getClass();     // Catch: Exception -> L21
        r107.put("dora_sub_biz", FlowDoraSubBizType.a.a());     // Catch: Exception -> L21
        r107.put("style_id", r100);     // Catch: Exception -> L21
        com.larus.dora.api.network.a r108 = com.larus.dora.api.network.a.f331768a;     // Catch: Exception -> L21
        r103.label = 1;     // Catch: Exception -> L21
        r111 = com.larus.dora.api.network.a.c(r108, Object.class, "/alice/wearable/diary/delete_style", r107, null, r103, 248);     // Catch: Exception -> L21
        if (r111 != r104) goto L19;
        return r104;
    L21:
        e = move-exception;
        FLogger.f375446a.e("DoraODiaryRepo", "deleteStyle error: " + e.getMessage());
        r106 = false;
    L7:
        r101 = new DoraODiaryRepo$deleteStyle$1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object e(String r110, Continuation<? super String> r111) {
        if ((r111 instanceof DoraODiaryRepo$fetchDetailRawJson$1) == false) goto L7;
        DoraODiaryRepo$fetchDetailRawJson$1 r100 = (DoraODiaryRepo$fetchDetailRawJson$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DoraODiaryRepo$fetchDetailRawJson$1 r102 = r100;
        Object r112 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L16;
        if (r104 != 1) goto L15;
        r110 = (String) r102.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L29
    L20:
        com.larus.network.http.a r113 = (com.larus.network.http.a) r112;     // Catch: Exception -> L29
        if ((r113 instanceof com.larus.network.http.y) == false) goto L27;
        b0 r114 = (b0) ((com.larus.network.http.y) r113).f360135b;     // Catch: Exception -> L29
        if (r114 == null) goto L31;
        JsonObject r115 = r114.a();     // Catch: Exception -> L29
        if (r115 == null) goto L31;
        return r115.toString();
    L31:
        return null;
    L27:
        FLogger.f375446a.e("DoraODiaryRepo", "fetchDetailRawJson failed, diaryId=" + r110);     // Catch: Exception -> L29
        goto L31
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r112);
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L29
        r105.put("user_id", ILoginService.f286097a.getAccountInfo().f531531d);     // Catch: Exception -> L29
        r105.put("diary_id", r110);     // Catch: Exception -> L29
        com.larus.dora.api.network.a r106 = com.larus.dora.api.network.a.f331768a;     // Catch: Exception -> L29
        r102.L$0 = r110;     // Catch: Exception -> L29
        r102.label = 1;     // Catch: Exception -> L29
        r112 = com.larus.dora.api.network.a.c(r106, b0.class, "/alice/wearable/diary/get_diary_detail_v2", r105, null, r102, 248);     // Catch: Exception -> L29
        if (r112 != r103) goto L20;
        return r103;
    L29:
        e = move-exception;
        FLogger.f375446a.e("DoraODiaryRepo", "fetchDetailRawJson error: " + e.getMessage());
    L7:
        r100 = new DoraODiaryRepo$fetchDetailRawJson$1(this, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.ArrayList] */
    public final Object f(int r110, Continuation<? super Map<Integer, ? extends List<String>>> r111) {
        if ((r111 instanceof DoraODiaryRepo$fetchFeedbackReasons$1) == false) goto L7;
        DoraODiaryRepo$fetchFeedbackReasons$1 r100 = (DoraODiaryRepo$fetchFeedbackReasons$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DoraODiaryRepo$fetchFeedbackReasons$1 r102 = r100;
        Object r112 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L14;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L58
    L19:
        com.larus.network.http.a r113 = (com.larus.network.http.a) r112;     // Catch: Exception -> L58
        if ((r113 instanceof com.larus.network.http.y) == false) goto L22;
        com.larus.network.http.y r114 = (com.larus.network.http.y) r113;     // Catch: Exception -> L58
    L23:
        if (r114 == null) goto L25;
        e0 r115 = (e0) r114.f360135b;     // Catch: Exception -> L58
    L26:
        if (r115 == null) goto L28;
        Map<String, List<String>> r116 = r115.a();     // Catch: Exception -> L58
    L29:
        if (r116 != null) goto L31;
        r116 = MapsKt.emptyMap();     // Catch: Exception -> L58
    L31:
        Set<Map.Entry<String, List<String>>> r117 = r116.entrySet();     // Catch: Exception -> L58
        ArrayList r118 = new ArrayList();     // Catch: Exception -> L58
        Iterator<T> r119 = r117.iterator();     // Catch: Exception -> L58
    L33:
        if (r119.hasNext() == false) goto L56;
        Map.Entry r105 = (Map.Entry) r119.next();     // Catch: Exception -> L58
        String r106 = (String) r105.getKey();     // Catch: Exception -> L58
        List r107 = (List) r105.getValue();     // Catch: Exception -> L58
        Integer r108 = StringsKt.toIntOrNull(r106);     // Catch: Exception -> L58
        if (r108 == null) goto L53;
        int r109 = r108.intValue();     // Catch: Exception -> L58
        if (r107 == null) goto L46;
        List r120 = CollectionsKt.filterNotNull(r107);     // Catch: Exception -> L58
        if (r120 == null) goto L46;
        List r121 = new ArrayList();     // Catch: Exception -> L58
        Iterator r122 = r120.iterator();     // Catch: Exception -> L58
    L42:
        if (r122.hasNext() == false) goto L47;
        Object r123 = r122.next();     // Catch: Exception -> L58
        if ((!StringsKt.isBlank((String) r123)) == false) goto L42;
        r121.add(r123);     // Catch: Exception -> L58
    L47:
        if (r121 != 0) goto L50;
        r121 = CollectionsKt.emptyList();     // Catch: Exception -> L58
    L50:
        if (r121.isEmpty() == true) goto L53;
        Pair r124 = TuplesKt.to(Boxing.boxInt(r109), r121);     // Catch: Exception -> L58
    L54:
        if (r124 == null) goto L33;
        r118.add(r124);     // Catch: Exception -> L58
    L46:
        r121 = 0;
    L53:
        r124 = null;
        goto L54
    L56:
        return MapsKt.toMap(r118);
    L28:
        r116 = null;
        goto L29
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
        com.larus.dora.api.network.a r125 = com.larus.dora.api.network.a.f331768a;     // Catch: Exception -> L58
        JSONObject r126 = new JSONObject();     // Catch: Exception -> L58
        r126.put("scene", 2);     // Catch: Exception -> L58
        r126.put("target_type", r110);     // Catch: Exception -> L58
        Unit r127 = Unit.INSTANCE;     // Catch: Exception -> L58
        r102.label = 1;     // Catch: Exception -> L58
        r112 = com.larus.dora.api.network.a.c(r125, e0.class, "/alice/wearable/feedback/get_config", r126, null, r102, 248);     // Catch: Exception -> L58
        if (r112 != r103) goto L19;
        return r103;
    L58:
        e = move-exception;
        FLogger.f375446a.e("DoraODiaryRepo", "fetchFeedbackReasons error: " + e.getMessage());
        return MapsKt.emptyMap();
    L7:
        r100 = new DoraODiaryRepo$fetchFeedbackReasons$1(this, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object h(t0 r100, Continuation<? super v0> r110) {
        if ((r110 instanceof DoraODiaryRepo$setStyle$1) == false) goto L7;
        DoraODiaryRepo$setStyle$1 r101 = (DoraODiaryRepo$setStyle$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        DoraODiaryRepo$setStyle$1 r103 = r101;
        Object r111 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r111);     // Catch: Exception -> L23
    L19:
        com.larus.network.http.a r112 = (com.larus.network.http.a) r111;     // Catch: Exception -> L23
        if ((r112 instanceof com.larus.network.http.y) == false) goto L25;
        return (v0) ((com.larus.network.http.y) r112).f360135b;
    L25:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r111);
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L23
        FlowDoraSubBizType.Companion.getClass();     // Catch: Exception -> L23
        r106.put("dora_sub_biz", FlowDoraSubBizType.a.a());     // Catch: Exception -> L23
        r106.put("style_info", new JSONObject(new Gson().toJson(r100)));     // Catch: Exception -> L23
        r106.put("req_id", UUID.randomUUID().toString());     // Catch: Exception -> L23
        com.larus.dora.api.network.a r107 = com.larus.dora.api.network.a.f331768a;     // Catch: Exception -> L23
        r103.label = 1;     // Catch: Exception -> L23
        r111 = com.larus.dora.api.network.a.c(r107, v0.class, "/alice/wearable/diary/set_style", r106, null, r103, 248);     // Catch: Exception -> L23
        if (r111 != r104) goto L19;
        return r104;
    L23:
        e = move-exception;
        FLogger.f375446a.e("DoraODiaryRepo", "setStyle error: " + e.getMessage());
    L7:
        r101 = new DoraODiaryRepo$setStyle$1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object j(t0 r100, Continuation<? super v0> r110) {
        if ((r110 instanceof DoraODiaryRepo$updateStyle$1) == false) goto L7;
        DoraODiaryRepo$updateStyle$1 r101 = (DoraODiaryRepo$updateStyle$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        DoraODiaryRepo$updateStyle$1 r103 = r101;
        Object r111 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r111);     // Catch: Exception -> L23
    L19:
        com.larus.network.http.a r112 = (com.larus.network.http.a) r111;     // Catch: Exception -> L23
        if ((r112 instanceof com.larus.network.http.y) == false) goto L25;
        return (v0) ((com.larus.network.http.y) r112).f360135b;
    L25:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r111);
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L23
        FlowDoraSubBizType.Companion.getClass();     // Catch: Exception -> L23
        r106.put("dora_sub_biz", FlowDoraSubBizType.a.a());     // Catch: Exception -> L23
        r106.put("style_info", new JSONObject(new Gson().toJson(r100)));     // Catch: Exception -> L23
        com.larus.dora.api.network.a r107 = com.larus.dora.api.network.a.f331768a;     // Catch: Exception -> L23
        r103.label = 1;     // Catch: Exception -> L23
        r111 = com.larus.dora.api.network.a.c(r107, v0.class, "/alice/wearable/diary/update_style", r106, null, r103, 248);     // Catch: Exception -> L23
        if (r111 != r104) goto L19;
        return r104;
    L23:
        e = move-exception;
        FLogger.f375446a.e("DoraODiaryRepo", "updateStyle error: " + e.getMessage());
    L7:
        r101 = new DoraODiaryRepo$updateStyle$1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object d(String r110, Integer r111, Continuation<? super j> r112) {
        if ((r112 instanceof DoraODiaryRepo$fetchBriefList$1) == false) goto L7;
        DoraODiaryRepo$fetchBriefList$1 r100 = (DoraODiaryRepo$fetchBriefList$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DoraODiaryRepo$fetchBriefList$1 r102 = r100;
        Object r113 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L14;
        ResultKt.throwOnFailure(r113);     // Catch: Exception -> L28
    L23:
        com.larus.network.http.a r114 = (com.larus.network.http.a) r113;     // Catch: Exception -> L28
        if ((r114 instanceof com.larus.network.http.y) == true) goto L33;
        FLogger.f375446a.e("DoraODiaryRepo", "fetchBriefList failed");     // Catch: Exception -> L28
    L30:
        return null;
    L33:
        return (j) ((com.larus.network.http.y) r114).f360135b;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r113);
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L28
        if (r111 == null) goto L19;
        int r115 = r111.intValue();     // Catch: Exception -> L28
    L20:
        r105.put(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, r115);     // Catch: Exception -> L28
        r105.put(EffectConfiguration.KEY_CURSOR, r110);     // Catch: Exception -> L28
        com.larus.dora.api.network.a r106 = com.larus.dora.api.network.a.f331768a;     // Catch: Exception -> L28
        r102.label = 1;     // Catch: Exception -> L28
        r113 = com.larus.dora.api.network.a.c(r106, j.class, "/alice/wearable/diary/list_user_diary_brief", r105, null, r102, 248);     // Catch: Exception -> L28
        if (r113 != r103) goto L23;
        return r103;
    L19:
        FlowDoraSubBizType.Companion.getClass();     // Catch: Exception -> L28
        r115 = FlowDoraSubBizType.a.a();     // Catch: Exception -> L28
    L28:
        e = move-exception;
        FLogger.f375446a.e("DoraODiaryRepo", "fetchBriefList error: " + e.getMessage());
    L7:
        r100 = new DoraODiaryRepo$fetchBriefList$1(this, r112);
        goto L8
    }

    public final Object i(String r110, int r111, List<String> r112, String r210, Integer r211, l0 r212, Continuation<? super Boolean> r213) {
        int r100 = r111;
        if ((r213 instanceof DoraODiaryRepo$submitFeedback$1) == false) goto L7;
        DoraODiaryRepo$submitFeedback$1 r101 = (DoraODiaryRepo$submitFeedback$1) r213;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        DoraODiaryRepo$submitFeedback$1 r113 = r101;
        Object r103 = r113.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r113.label;
        boolean r114 = false;
        boolean r115 = true;
        if (r105 == 0) goto L16;
        if (r105 != 1) goto L15;
        r100 = r113.I$0;
        String r106 = (String) r113.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L60
    L54:
        boolean r107 = ((com.larus.network.http.a) r103) instanceof com.larus.network.http.y;     // Catch: Exception -> L60
        FLogger r108 = FLogger.f375446a;     // Catch: Exception -> L60
        StringBuilder r109 = new StringBuilder("submitFeedback diary=");     // Catch: Exception -> L60
        r109.append(r106);     // Catch: Exception -> L60
        r109.append(" action=");     // Catch: Exception -> L60
        r109.append(r100);     // Catch: Exception -> L60
        r109.append(" ok=");     // Catch: Exception -> L60
        if (r107 == true) goto L58;
        r115 = false;
    L58:
        r109.append(r115);     // Catch: Exception -> L60
        r108.i("DoraODiaryRepo", r109.toString());     // Catch: Exception -> L60
        r114 = r107;
    L63:
        return Boxing.boxBoolean(r114);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        JSONObject r116 = new JSONObject();     // Catch: Exception -> L60
        Integer r117 = null;
        if (r212 == null) goto L26;
        String r118 = r212.f338559b;     // Catch: Exception -> L60
        if (r118 == null) goto L26;
        if ((!StringsKt.isBlank(r118)) == true) goto L25;
        r118 = null;
    L25:
        if (r118 == null) goto L26;
    L27:
        r116.put("target_id", r118);     // Catch: Exception -> L60
        if (r212 == null) goto L30;
        int r119 = r212.f338558a;     // Catch: Exception -> L60
    L31:
        r116.put("target_type", r119);     // Catch: Exception -> L60
        r116.put("action_type", r100);     // Catch: Exception -> L60
        if ((!r112.isEmpty()) == false) goto L35;
        r116.put("reasons", new JSONArray(r112).toString());     // Catch: Exception -> L60
    L35:
        if ((!StringsKt.isBlank(r210)) == false) goto L37;
        r116.put("content", StringsKt.take(StringsKt.trim(r210).toString(), 1000));     // Catch: Exception -> L60
    L37:
        JSONObject r120 = a(r212);     // Catch: Exception -> L60
        if (r120 == null) goto L40;
        r116.put(PerfLog.PARAM_KEY_CONTEXT_ID, r120);     // Catch: Exception -> L60
    L40:
        JSONObject r121 = new JSONObject();     // Catch: Exception -> L60
        if (r211 != null) goto L43;
    L50:
        FlowDoraSubBizType.Companion.getClass();     // Catch: Exception -> L60
        int r122 = FlowDoraSubBizType.a.a();     // Catch: Exception -> L60
    L51:
        r121.put("dora_sub_biz", r122);     // Catch: Exception -> L60
        r121.put("scene", 2);     // Catch: Exception -> L60
        r121.put("feedback", r116);     // Catch: Exception -> L60
        com.larus.dora.api.network.a r123 = com.larus.dora.api.network.a.f331768a;     // Catch: Exception -> L60
        r106 = r110;
        r113.L$0 = r106;     // Catch: Exception -> L60
        r113.I$0 = r100;     // Catch: Exception -> L60
        r113.label = 1;     // Catch: Exception -> L60
        r103 = com.larus.dora.api.network.a.c(r123, k0.class, "/alice/wearable/feedback/submit", r121, null, r113, 248);     // Catch: Exception -> L60
        if (r103 != r104) goto L54;
        return r104;
    L43:
        if (r211.intValue() <= 0) goto L45;
        boolean r124 = true;
    L46:
        if (r124 == false) goto L48;
        r117 = r211;
    L48:
        if (r117 == null) goto L50;
        r122 = r117.intValue();     // Catch: Exception -> L60
        goto L51
    L45:
        r124 = false;
        goto L46
    L30:
        r119 = 1;
    L26:
        r118 = r110;
    L60:
        e = move-exception;
        FLogger.f375446a.e("DoraODiaryRepo", "submitFeedback error: " + e.getMessage());
    L7:
        r101 = new DoraODiaryRepo$submitFeedback$1(this, r213);
        goto L8
    }
}
