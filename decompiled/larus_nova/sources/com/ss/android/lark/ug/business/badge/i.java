package com.ss.android.lark.ug.business.badge;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.ugreach.v1.GetUGScenarioRequest;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.ug.common.ApmUtils;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i {
    public i() {
    }

    public static void a(List r100, final BadgeManager$getScenarioCallback$1 r110) {
        final String r101 = "SCENE_BADGE_SETTING";
        Intrinsics.checkNotNullParameter("SCENE_BADGE_SETTING", "scenarioId");
        Intrinsics.checkNotNullParameter(r110, "callback");
        GetUGScenarioRequest.Builder r102 = new GetUGScenarioRequest.Builder();
        r102.scenario_id("SCENE_BADGE_SETTING");
        if (r100 != null) goto L5;
    L10:
        SdkSender.asynSendRequestNonWrap(Command.GET_UG_SCENARIO, r102, new ApmUtils.GetDataCallback(new BadgeService$getScenario$3(r110, r101), "ug_reach_fetch_scenario_info", null, 4, null), new g());
        return;
    L5:
        if ((!r100.isEmpty()) == false) goto L7;
        List r103 = r100;
    L8:
        if (r103 == null) goto L10;
        r102.specified_reach_point_ids(r100);
        goto L10
    L7:
        r103 = null;
        goto L8
    }
}
