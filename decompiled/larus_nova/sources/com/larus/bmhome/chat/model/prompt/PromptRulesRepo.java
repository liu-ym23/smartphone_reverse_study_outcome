package com.larus.bmhome.chat.model.prompt;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.bmhome.chat.bean.IsSuggestWordsHitRulesRequest;
import com.larus.bmhome.chat.bean.IsSuggestWordsHitRulesResponse;
import com.larus.bmhome.chat.bean.RuleRequestParamRequest;
import com.larus.bmhome.chat.model.repo.PromptRulesApi;
import com.larus.bmhome.chat.model.repo.UpdateWcbSuggestsApi;
import com.larus.network.FlowHttpConnection;
import com.larus.network.http.ServiceType;
import com.larus.network.http.a;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import com.ss.ttm.player.MediaPlayer;
import ic8.r0;
import java.util.List;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class PromptRulesRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PromptRulesRepo f307566a = null;

    static {
        f307566a = new PromptRulesRepo();
    }

    public PromptRulesRepo() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(List<RuleRequestParamRequest> r110, int r111, Continuation<? super List<r0>> r112) {
        if ((r112 instanceof PromptRulesRepo$getPromptRules$1) == false) goto L7;
        PromptRulesRepo$getPromptRules$1 r100 = (PromptRulesRepo$getPromptRules$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        PromptRulesRepo$getPromptRules$1 r113 = r100;
        Object r114 = r113.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r113.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r114);
    L17:
        a r115 = (a) r114;
        if ((r115 instanceof y) == false) goto L30;
        y r116 = (y) r115;
        Long r117 = r116.f360205g;
        if (r117 == null) goto L30;
        if (r117.longValue() != 0) goto L30;
        IsSuggestWordsHitRulesResponse r118 = (IsSuggestWordsHitRulesResponse) r116.f360135b;
        if (r118 == null) goto L31;
        List<r0> r119 = r118.getRulesData();
        if (r119 != null) goto L29;
        return null;
    L29:
        return CollectionsKt.filterNotNull(r119);
    L31:
        return null;
    L30:
        FLogger.f375446a.e("PromptLaunchRepo", "failed in fetch prompt rules remote");
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        PromptRulesApi.a r120 = PromptRulesApi.f307727a;
        IsSuggestWordsHitRulesRequest r104 = new IsSuggestWordsHitRulesRequest(r110, Boxing.boxInt(r111), Boxing.boxInt(1));
        Gson r121 = new Gson();
        Intrinsics.checkNotNullParameter(r104, "<this>");
        Intrinsics.checkNotNullParameter(r121, "gson");
        JSONObject r105 = new JSONObject(GsonProtectorUtils.toJson(r121, r104));
        r113.label = 1;
        r120.getClass();
        r114 = IFlowDowngradeService.a.b(FlowDowngradeServiceDelegate.INSTANCE, ServiceType.IM, IsSuggestWordsHitRulesResponse.class, "/biz/onboarding/is_hit_risk_word", r105, null, true, null, MapsKt.mapOf(TuplesKt.to("source", DowngradeSource.COLD_LAUNCH.getValue())), r113, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        if (r114 != r102) goto L17;
        return r102;
    L7:
        r100 = new PromptRulesRepo$getPromptRules$1(this, r112);
        goto L8
    }

    public final Object b(String r110, String r111, String r112, Continuation<? super Unit> r113) {
        if ((r113 instanceof PromptRulesRepo$updateWcbSuggests$1) == false) goto L7;
        PromptRulesRepo$updateWcbSuggests$1 r100 = (PromptRulesRepo$updateWcbSuggests$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        PromptRulesRepo$updateWcbSuggests$1 r102 = r100;
        Object r114 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r114);
    L17:
        dm9.a r115 = (dm9.a) r114;
        if ((r115 instanceof dm9.a.b) == false) goto L21;
        FLogger.f375446a.i("PromptLaunchRepo", "success updateWcbSuggests");
    L24:
        return Unit.INSTANCE;
    L21:
        if ((r115 instanceof dm9.a.C5690a) == false) goto L24;
        FLogger.f375446a.e("PromptLaunchRepo", "failed updateWcbSuggests " + ((dm9.a.C5690a) r115).f469230c);
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        UpdateWcbSuggestsApi.a r116 = UpdateWcbSuggestsApi.f307759a;
        PromptRulesRepo$updateWcbSuggests$result$1 r105 = new PromptRulesRepo$updateWcbSuggests$result$1(r111, r110, r112, null);
        r102.label = 1;
        r116.getClass();
        FlowHttpConnection r117 = FlowHttpConnection.f359975a;
        r114 = FlowHttpConnection.g(ServiceType.IM, UpdateWcbSuggestsApi.class, r105, false, null, null, null, r102, 248);
        if (r114 != r103) goto L17;
        return r103;
    L7:
        r100 = new PromptRulesRepo$updateWcbSuggests$1(this, r113);
        goto L8
    }
}
