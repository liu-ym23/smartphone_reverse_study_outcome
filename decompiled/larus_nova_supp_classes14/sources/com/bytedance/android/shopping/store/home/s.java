package com.bytedance.android.shopping.store.home;

import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.store.common.const.LiveStyles;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.preload.data.AIPreloadType;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s {
    public final ConcurrentHashMap<String, String> a;

    public s() {
        this.a = new ConcurrentHashMap();
    }

    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.a.put(r2, r3);
    }

    public final void b(JSONObject r5, StoreTabConfig r6, ECStoreParam r7) {
        String r0 = "0";
        if (r6 == null) goto L9;
        r5.put("tab_name", r6.getTabName());
        r5.put("tab_type", r6.getTabType());
        if (r6.getDefaultSelected() == false) goto L7;
        Object r8 = CommentScene.COMMENTSCENE_NO_AWEME;
    L8:
        r5.put("flag_default_selected", r8);
        goto L9
    L7:
        r8 = "0";
    L9:
        if (r7 != null) goto L11;
    L65:
        Iterator<Map.Entry<String, String>> r9 = this.a.entrySet().iterator();
    L67:
        if (r9.hasNext() == false) goto L69;
        Map.Entry<String, String> r10 = r9.next();
        r5.put(r10.getKey(), r10.getValue());
        goto L67
    L69:
        return;
    L11:
        if (r7.isPreview() == false) goto L13;
        Object r11 = CommentScene.COMMENTSCENE_NO_AWEME;
    L14:
        r5.put("flag_is_preview", r11);
        if (r7.getStoreUIParam().getHasHeaderLive() == false) goto L17;
        Object r12 = CommentScene.COMMENTSCENE_NO_AWEME;
    L18:
        r5.put("flag_has_header_live", r12);
        if (r7.getStoreUIParam().getHasHeaderVideo() == false) goto L21;
        Object r13 = CommentScene.COMMENTSCENE_NO_AWEME;
    L22:
        r5.put("flag_has_header_video", r13);
        Integer r14 = r7.getStoreUIParam().getLiveStyle();
        int r2 = LiveStyles.FLOATWINDOW.getType();
        if (r14 == null) goto L28;
        if (r14.intValue() != r2) goto L28;
    L31:
        Object r15 = "0";
    L32:
        r5.put("live_show", r15);
        if (r7.isCroppedStyle() == false) goto L35;
        String r16 = "split";
    L36:
        r5.put("modal", r16);
        r5.put("sec_shop_id", r7.getSecShopId());
        r5.put("shop_id", r7.getShopId());
        r5.put("entrance_location", r7.getEntranceLocation());
        AIPreloadType r17 = r7.getInfoAIPreloadType();
        AIPreloadType r3 = AIPreloadType.AI_PRELOAD_EXPIRED;
        if (r17 == r3) goto L39;
    L41:
        AIPreloadType r18 = r7.getInfoAIPreloadType();
        AIPreloadType r4 = AIPreloadType.AI_PRELOAD_SUCCESS;
        if (r18 == r4) goto L44;
    L46:
        r5.put("flag_api_preload_type", r7.getApiPreloadType().getValue());
        if (Intrinsics.areEqual(r7.getFlagHasActivityFloat(), Boolean.TRUE) == false) goto L50;
        r0 = CommentScene.COMMENTSCENE_NO_AWEME;
    L53:
        r5.put("flag_has_activity_float", r0);
        r5.put("shop_type", r7.getShopType());
        Map<String, String> r19 = r7.getLogExtra();
        if (r19 == null) goto L59;
        Iterator<Map.Entry<String, String>> r20 = r19.entrySet().iterator();
    L57:
        if (r20.hasNext() == false) goto L59;
        Map.Entry<String, String> r1 = r20.next();
        r5.put(r1.getKey(), r1.getValue());
    L59:
        Map<String, String> r21 = r7.getTabPerfLogExtra();
        if (r21 == null) goto L65;
        Iterator<Map.Entry<String, String>> r22 = r21.entrySet().iterator();
    L63:
        if (r22.hasNext() == false) goto L65;
        Map.Entry<String, String> r23 = r22.next();
        r5.put(r23.getKey(), r23.getValue());
        goto L63
    L50:
        if (Intrinsics.areEqual(r7.getFlagHasActivityFloat(), Boolean.FALSE) == true) goto L53;
        r0 = null;
        goto L53
    L44:
        if (r7.getTabAIPreloadType() != r4) goto L46;
        r5.put("flag_hit_ai_preload", CommentScene.COMMENTSCENE_NO_AWEME);
        goto L46
    L39:
        if (r7.getTabAIPreloadType() != r3) goto L41;
        r5.put("ai_preload_cache_invalid", CommentScene.COMMENTSCENE_NO_AWEME);
        goto L41
    L35:
        r16 = "full";
    L28:
        if (r7.getStoreUIParam().getHasHeaderLive() == false) goto L31;
        r15 = CommentScene.COMMENTSCENE_NO_AWEME;
        goto L32
    L21:
        r13 = "0";
        goto L22
    L17:
        r12 = "0";
        goto L18
    L13:
        r11 = "0";
        goto L14
    }

    public static void c(s r2, String r3, StoreTabConfig r4, ECStoreParam r5, JSONObject r6, JSONObject r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r8 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r8 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r8 & 16) == 0) goto L14;
        r7 = null;
    L14:
        Intrinsics.checkNotNullParameter(r3, "eventName");
        int r9 = ECMonitorService.b;
        if (r6 != null) goto L17;
        r6 = new JSONObject();
    L17:
        r2.b(r6, r4, r5);
        Unit r10 = Unit.INSTANCE;
        ECMonitorService.a.a(r3, r6, r7, null);
    }
}
