package ny9;

import android.os.Bundle;
import com.larus.livetutor.impl.home.viewmodel.LiveTutorHomeVM;
import com.obric.trace.ObricActionBarTrackType;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class v {
    public static final Bundle a(zs8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return com.larus.utils.f.c(new Pair[]{TuplesKt.to("previous_page", r100.b()), TuplesKt.to("enter_method", r100.getEnterMethod()), TuplesKt.to("bot_id", r100.getBotId()), TuplesKt.to("chat_type", r100.getChatType()), TuplesKt.to("click_from", r100.getClickFrom()), TuplesKt.to("action_bar_key", r100.a()), TuplesKt.to(LiveTutorHomeVM.ACTION_BAR_ITEM_ID, r100.c()), TuplesKt.to(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r100.m()), TuplesKt.to("action_bar_template_type", r100.i()), TuplesKt.to("prompt_type", r100.e()), TuplesKt.to("prompt_from", r100.n()), TuplesKt.to("visual_size", r100.k()), TuplesKt.to("tag_code", r100.g()), TuplesKt.to("reference_image_scene", r100.o()), TuplesKt.to("ai_generate_tab_id", r100.f()), TuplesKt.to("ai_generate_tab_name", r100.p()), TuplesKt.to("ai_generate_tab_type", r100.j()), TuplesKt.to("ai_creation_recommend_from", r100.h()), TuplesKt.to("enable_show_update_dialog", Boolean.valueOf(r100.l())), TuplesKt.to("bundle_template_type", r100.getTemplateType()), TuplesKt.to("bundle_template_sub_type", r100.d()), TuplesKt.to("conversation_id", r100.Y1())});
    }
}
