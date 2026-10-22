package com.bytedance.android.shopping.yata.business.function.common;

import android.content.Context;
import com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import java.util.LinkedHashMap;
import jta.g;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class TTPay {
    public static final /* synthetic */ int a = 0;

    public static final class a implements IH5PayCallback {
        public final /* synthetic */ Function2 a;

        public a(Function2 r1) {
            this.a = r1;
        }

        public final void onResult(int r2, String r3) {
            this.a.invoke(Integer.valueOf(r2), r3);
            TTCJPayUtils.Companion.getInstance().releaseAll();
        }
    }

    static {
    }

    public static void a(Context r10, JSONObject r11, Function2 r12) {
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        JSONObject r0 = r11.optJSONObject("sdk_info");
        int r5 = r11.optInt("service", -1);
        String r2 = "";
        String r6 = r11.optString("sub_way", "");
        String r8 = r11.optString("ext", "{}");
        String r7 = r11.optString("referer", "");
        TTCJPayUtils r13 = TTCJPayUtils.Companion.getInstance().setContext(r10);
        ECAppInfoService r14 = ECAppInfoService.e;
        TTCJPayUtils r15 = r13.setAid(r14.getAppId()).setDid(g.d());
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("channel", r14.getChannel());
        r1.put("iid", g.e());
        TTCJPayUtils r16 = r15.setRiskInfoParams(r1);
        LinkedHashMap r3 = new LinkedHashMap();
        String r17 = r14.getSessionID();
        if (r17 == null) goto L6;
        r2 = r17;
    L6:
        r3.put("sessionid", r2);
        TTCJPayUtils r4 = r16.setLoginToken(r3).setObserver(new TTPay$ttpay$1());
        if (r0 == null) goto L9;
        String r18 = r0.toString();
    L10:
        r4.pay(r18, r5, r6, r7, r8, new a(r12));
        return;
    L9:
        r18 = null;
        goto L10
    }
}
