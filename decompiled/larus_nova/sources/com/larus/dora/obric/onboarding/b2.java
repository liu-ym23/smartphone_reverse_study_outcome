package com.larus.dora.obric.onboarding;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larus.dora.impl.DoraBuryPointManager;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f340827a = 0;

    static {
    }

    public static void b(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() <= 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L15;
        g49.d.d("ObricDoraOnboardingTracker", "trackQueryInterrupt: conversationId=".concat(r100));
        DoraBuryPointManager.f331862a.L("obric_onboarding_query_interrupt", MapsKt.mapOf(new Pair[]{TuplesKt.to("interrupt_method", "single_click"), TuplesKt.to("conversation_id", r100)}));
        return;
    L15:
        return;
    L6:
        r101 = false;
        goto L7
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cardContentType");
        Intrinsics.checkNotNullParameter(r101, ReportConstant.COMMON_ACTION_TYPE);
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        if (r101.length() != 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L16;
        g49.d.d("ObricDoraOnboardingTracker", "trackCardClick: cardContentType=" + r100 + ", actionType=" + r101);
        DoraBuryPointManager.f331862a.L("dora_card_click", MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, "dora_onboarding"), TuplesKt.to("card_content_type", r100), TuplesKt.to("action_type", r101)}));
        return;
    L16:
        return;
    L10:
        r103 = false;
        goto L11
    L5:
        r102 = false;
        goto L6
    }
}
