package wh2;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.promotion.ECResourceConfig;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.m0;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static Map<String, ECResourceConfig> a;

    static {
    }

    public static List a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "viewId");
        if (r5 != null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L13;
        return null;
    L13:
        if (a == null) goto L32;
    L24:
        Map<String, ECResourceConfig> r1 = a;
        if (r1 == null) goto L34;
        ECResourceConfig r6 = r1.get(r5);
        if (r6 == null) goto L35;
        Map r7 = r6.getColors();
        if (r7 != null) goto L31;
        return null;
    L31:
        return (List) r7.get(r4);
    L35:
        return null;
    L34:
        return null;
    L32:
        String r2 = EComABUtils.getLiveListTabSkinConfig();     // Catch: Exception -> L22
        if (com.bytedance.android.livesdk.livecommerce.playback.main.c.a(r2) == true) goto L18;
        r2 = null;
    L18:
        if (r2 != null) goto L20;
        r2 = "{\"instant_retail_shop_merge_green\":{\"colors\":{\"live_list_tab_text_selected_color\":[\"#00BC35\"],\"live_list_tab_text_unselected_color\":[\"#80161823\"],\"live_list_tab_text_disabled_color\":[\"#40161823\"],\"live_list_tab_bg_selected_color\":[\"#1400C638\"],\"live_list_tab_bg_unselected_color\":[\"#08161823\"],\"live_list_tab_bg_disabled_color\":[\"#08161823\"]}}}";
    L20:
        int r3 = m0.a;     // Catch: Exception -> L22
        a = (Map) m0.a.a.fromJson(r2, new a().getType());     // Catch: Exception -> L22
    L22:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L24
    L5:
        if (r5.length() == 0) goto L8;
        r0 = false;
        goto L10
    }
}
