package com.bytedance.android.livesdk.livecommerce.livereplay.utils;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.livereplay.model.ECScrollProductCardData;
import com.bytedance.android.livesdk.livecommerce.room.f;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final ni2.a a(ECScrollProductCardData r10, String r11, long r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$convertUI");
        Intrinsics.checkNotNullParameter(r11, "replayId");
        int r1 = a.a;
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, "replayId");
        ECUIPromotion r4 = k.d(r10.getPromotion(), f.a(), r12, Boolean.FALSE);
        JSONObject r13 = r4.getExtraTransmissibleLogParams();
        if (r13 != null) goto L5;
        r13 = new JSONObject();
    L5:
        r13.put("episode_id", r11);
        r13.put("ecom_entrance_form", "replay_live_card");
        Unit r2 = Unit.INSTANCE;
        r4.setExtraTransmissibleLogParams(r13);
        Map r14 = r4.getEventParams();
        if (r14 != null) goto L8;
        r14 = new LinkedHashMap();
    L8:
        r14.put("episode_id", r11);
        r14.put("ecom_entrance_form", "replay_live_card");
        r4.setEventParams(r14);
        r4.setExplainType(1);
        r4.getClientData().b = true;
        return new ni2.a(r4, r10.getExplainStartTime(), r10.getExplainEndTime(), r10.isGenera());
    }
}
