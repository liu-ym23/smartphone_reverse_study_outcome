package com.bytedance.android.shopping.deepfeed.data;

import android.net.Uri;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.shopping.deepfeed.data.repo.DeepFeedAbValues;
import com.bytedance.android.shopping.utils.q;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public static final DeepFeedQueryParam a(Uri r19) {
        Intrinsics.checkNotNullParameter(r19, "$this$toDeepFeedParams");
        String r1 = UriProtector.getQueryParameter(r19, "ab_values");
        boolean r2 = false;
        if (r1 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        DeepFeedAbValues r5 = null;
    L12:
        if (r1 != null) goto L14;
    L15:
        r2 = true;
    L16:
        if (r2 == true) goto L22;
        JSONObject r3 = k.c(r1);
        if (r3 == null) goto L22;
        Map<String, ? extends Object> r6 = z1.k(r3);
        if (r5 == null) goto L22;
        r5.setOriginMap(r6);
    L22:
        String r7 = UriProtector.getQueryParameter(r19, "ecom_scene_id");
        String r8 = UriProtector.getQueryParameter(r19, "tracker");
        if (r8 == null) goto L25;
        HashMap r9 = q.a(r8);
    L26:
        HashMap r10 = r9;
        String r11 = UriProtector.getQueryParameter(r19, "rec_pass_params");
        if (r11 == null) goto L29;
        HashMap r12 = q.a(r11);
    L31:
        return new DeepFeedQueryParam(r7, r10, r12, UriProtector.getQueryParameter(r19, "filters"), UriProtector.getQueryParameter(r19, "source_btm_token"), UriProtector.getQueryParameter(r19, "biz_code"), UriProtector.getQueryParameter(r19, "scene_code"), UriProtector.getQueryParameter(r19, "card_param"), UriProtector.getQueryParameter(r19, "pass_through_params"), UriProtector.getQueryParameter(r19, "triggers"), UriProtector.getQueryParameter(r19, "share_element_view_id"), UriProtector.getQueryParameter(r19, "neg_feedback_json"), r5);
    L29:
        r12 = new HashMap();
        goto L31
    L25:
        r9 = new HashMap();
        goto L26
    L14:
        if (r1.length() != 0) goto L16;
    L11:
        int r13 = t0.a;
        r5 = (DeepFeedAbValues) GsonProtectorUtils.fromJson(t0.a.a, r1, DeepFeedAbValues.class);
        goto L12
    L5:
        if (r1.length() == 0) goto L8;
        r4 = false;
        goto L9
    }
}
