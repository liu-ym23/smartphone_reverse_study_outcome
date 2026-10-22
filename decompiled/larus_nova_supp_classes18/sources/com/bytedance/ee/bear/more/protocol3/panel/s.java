package com.bytedance.ee.bear.more.protocol3.panel;

import com.bytedance.ee.bear.list.more.itemv2.ShareItemV2;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s {
    public static final Map<String, String> a = null;

    static {
        a = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("add_main_nav", "more.add_to_nav"), TuplesKt.to("multi_task", "more.floating_window"), TuplesKt.to("rename", "more.rename"), TuplesKt.to("moveV2", "more.move_to"), TuplesKt.to("move_to", "more.move_to"), TuplesKt.to("star", "more.star"), TuplesKt.to("pin", "more.pin"), TuplesKt.to("manual_cache", "more.offline_available"), TuplesKt.to("delete", "more.delete"), TuplesKt.to("add_shortcut", "more.add_short_cut"), TuplesKt.to("permission", "more.permission_setting"), TuplesKt.to("make_copy", "more.make_copy"), TuplesKt.to("contact_service", "more.contact_support"), TuplesKt.to("report", "more.report"), TuplesKt.to("subscribe", "more.follow_updates"), TuplesKt.to("subscribe_comment", "more.subscribe_comment"), TuplesKt.to("apply_edit_permission", "more.apply_edit_permission"), TuplesKt.to("copy_link", "more.copy_link"), TuplesKt.to("operation_record", "more.history"), TuplesKt.to(ThumbGlideUrl.SOURCE_TEMPLATE, "more.convert_to_template"), TuplesKt.to("template_switch", "more.template_type_switch"), TuplesKt.to("retention_label", "more.retention_label"), TuplesKt.to("add_to_workbench", "more.add_to_workbench"), TuplesKt.to("browser_view", "more.browser_view"), TuplesKt.to(ShareItemV2.SHARE_ID, "more.share"), TuplesKt.to("ai_smart", "more.my_ai"), TuplesKt.to("pageviewV2", "more.page_view"), TuplesKt.to("item_file_statsV2", "more.page_view"), TuplesKt.to("item_page_settings", "more.page_setting"), TuplesKt.to("iconV2", "more.icon"), TuplesKt.to("SecretMoreItem", "more.secret_level"), TuplesKt.to("tts", "more.listen_doc"), TuplesKt.to("translateV2", "more.translate"), TuplesKt.to("docx_translate", "more.translate"), TuplesKt.to("item_revision_switch", "more.revision_mode"), TuplesKt.to("searchV2", "more.find_replace"), TuplesKt.to("historyV2", "more.history"), TuplesKt.to("edition_list", "more.edition_list"), TuplesKt.to("structureV2", "more.outline"), TuplesKt.to("item_time_zoneV2", "more.time_zone"), TuplesKt.to("BitableProMoreItem", "more.bitable_pro"), TuplesKt.to("export", "more.download_as"), TuplesKt.to("transfer_apply", "more.transfer_ownership"), TuplesKt.to("ai_summary", "more.ai_overview"), TuplesKt.to("WikiPinItem", "more.pin"), TuplesKt.to("WikiStarItem", "more.star"), TuplesKt.to("WikiExploreStarItem", "more.wiki_explore_star"), TuplesKt.to("WikiShortcutItem", "more.wiki_shortcut"), TuplesKt.to("wiki_make_copy", "more.make_copy"), TuplesKt.to("wiki_delete", "more.delete"), TuplesKt.to("expired_content", "more.expired_content"), TuplesKt.to("freshNess", "more.freshness"), TuplesKt.to("share", "more.share"), TuplesKt.to("SHARE", "more.share"), TuplesKt.to("COPY_LINK", "more.copy_link"), TuplesKt.to("disassociate", "more.disassociate")});
    }

    public static String a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "itemId");
        if (StringsKt.startsWith$default(r4, "more.", false, 2, null) == false) goto L5;
        return r4;
    L5:
        String r0 = a.get(r4);
        if (r0 == null) goto L8;
        return r0;
    L8:
        return r4;
    }
}
