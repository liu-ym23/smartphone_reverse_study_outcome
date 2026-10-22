package com.larus.bmhome.chat.bean;

import com.larus.bmhome.chat.model.ChatDraftItem;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g {
    public static final PromptContent.SuggestV2ExtraForMultiAction a(PromptContent.SuggestItem r210) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        Map<String, String> r100 = r210.getExtra();
        if (r100 == null) goto L5;
        String r101 = r100.get("suggest_action_type");
    L6:
        Map<String, String> r102 = r210.getExtra();
        if (r102 == null) goto L9;
        String r103 = r102.get("actionbar_item_id");
    L10:
        Map<String, String> r104 = r210.getExtra();
        if (r104 == null) goto L13;
        String r105 = r104.get("actionbar_template_id");
    L14:
        Map<String, String> r106 = r210.getExtra();
        if (r106 == null) goto L17;
        String r107 = r106.get("actionbar_key");
    L18:
        Map<String, String> r108 = r210.getExtra();
        if (r108 == null) goto L21;
        String r109 = r108.get("is_font_bold");
    L22:
        Map<String, String> r110 = r210.getExtra();
        if (r110 == null) goto L25;
        String r111 = r110.get(ChatDraftItem.TYPE_MSG_EXT);
    L26:
        Map<String, String> r112 = r210.getExtra();
        if (r112 == null) goto L29;
        String r113 = r112.get("cursor_pos");
    L30:
        Map<String, String> r114 = r210.getExtra();
        if (r114 == null) goto L33;
        String r115 = r114.get("user_prompt");
    L34:
        Map<String, String> r116 = r210.getExtra();
        if (r116 == null) goto L37;
        String r117 = r116.get(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL);
    L38:
        Map<String, String> r118 = r210.getExtra();
        if (r118 == null) goto L41;
        String r119 = r118.get("speech_key");
    L42:
        Map<String, String> r120 = r210.getExtra();
        if (r120 == null) goto L45;
        String r121 = r120.get("actionbar_default_selection_cfg");
    L46:
        Map<String, String> r122 = r210.getExtra();
        if (r122 == null) goto L49;
        String r123 = r122.get("bot_info");
    L50:
        Map<String, String> r124 = r210.getExtra();
        if (r124 == null) goto L53;
        String r211 = r124.get("show_from");
    L55:
        return new PromptContent.SuggestV2ExtraForMultiAction(r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r211, null, r210.getItemId(), 8192, null);
    L53:
        r211 = null;
        goto L55
    L49:
        r123 = null;
        goto L50
    L45:
        r121 = null;
        goto L46
    L41:
        r119 = null;
        goto L42
    L37:
        r117 = null;
        goto L38
    L33:
        r115 = null;
        goto L34
    L29:
        r113 = null;
        goto L30
    L25:
        r111 = null;
        goto L26
    L21:
        r109 = null;
        goto L22
    L17:
        r107 = null;
        goto L18
    L13:
        r105 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }
}
