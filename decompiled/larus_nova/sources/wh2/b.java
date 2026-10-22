package wh2;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.promotion.ECResourceConfig;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.m0;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, ECResourceConfig> f559645a;

    static {
    }

    public static List a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "viewId");
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        return null;
    L13:
        if (f559645a == null) goto L32;
    L24:
        Map<String, ECResourceConfig> r103 = f559645a;
        if (r103 == null) goto L34;
        ECResourceConfig r104 = r103.get(r101);
        if (r104 == null) goto L35;
        Map<String, List<String>> r105 = r104.getColors();
        if (r105 != null) goto L31;
        return null;
    L31:
        return r105.get(r100);
    L35:
        return null;
    L34:
        return null;
    L32:
        String r106 = EComABUtils.getLiveListTabSkinConfig();     // Catch: Exception -> L22
        if (com.bytedance.android.livesdk.livecommerce.playback.main.c.a(r106) == true) goto L18;
        r106 = null;
    L18:
        if (r106 != null) goto L20;
        r106 = "{\"instant_retail_shop_merge_green\":{\"colors\":{\"live_list_tab_text_selected_color\":[\"#00BC35\"],\"live_list_tab_text_unselected_color\":[\"#80161823\"],\"live_list_tab_text_disabled_color\":[\"#40161823\"],\"live_list_tab_bg_selected_color\":[\"#1400C638\"],\"live_list_tab_bg_unselected_color\":[\"#08161823\"],\"live_list_tab_bg_disabled_color\":[\"#08161823\"]}}}";
    L20:
        int r107 = m0.f153098a;     // Catch: Exception -> L22
        f559645a = (Map) m0.a.f153099a.fromJson(r106, new a().getType());     // Catch: Exception -> L22
    L22:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L24
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L10
    }
}
