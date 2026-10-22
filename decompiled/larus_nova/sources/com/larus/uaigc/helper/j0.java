package com.larus.uaigc.helper;

import androidx.collection.LruCache;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationAsset;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.livetutor.impl.home.viewmodel.LiveTutorHomeVM;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.uaigc.chat.image.event.GenerateImageTrace;
import com.larus.utils.logger.FLogger;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.bduploader.BDVideoUploaderBase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.a4;
import tx9.l3;
import tx9.u2;

/* JADX INFO: loaded from: classes31.dex */
public final class j0 implements hy9.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f373031a = null;

    static {
        f373031a = new j0();
    }

    public j0() {
    }

    @Override // hy9.d
    public final ky9.a b() {
        return GenerateImageTrace.f370818a;
    }

    @Override // hy9.d
    public final ky9.b e() {
        return com.larus.uaigc.chat.image.event.b.f370831a;
    }

    @Override // hy9.d
    public final void c(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        tx9.r0.f(r100, "my_replica");
    }

    @Override // hy9.d
    public final void j(Message r310, String r311) {
        if (r310 == null) goto L185;
        List<CreationItem> r100 = bz9.a.g(r310);
        if (com.larus.bmhome.chat.bean.d.j0(r310) == false) goto L7;
    L11:
        Map<String, String> r101 = r310.getExt();
        String r102 = "";
        String r103 = null;
        if (r101 == null) goto L16;
        String r104 = r101.get("log_id");
        FLogger r105 = FLogger.f375446a;
        r105.d("BotUtils", "msgId: " + r310.getMessageId() + "; logId: " + r104);
        String r106 = r101.get("show_from");
        if (r104 == null) goto L17;
        r105.d("BotUtils", "msgId: " + r310.getMessageId() + "; NO logId");
        String r107 = "";
    L18:
        IAIChatControlTraceService.Companion r108 = IAIChatControlTraceService.f365889a;
        String r109 = r310.getReplyId();
        if (r109 != null) goto L21;
        r109 = "";
    L21:
        String r110 = r108.Sa(r109);
        int r210 = 0;
        boolean r211 = false;
        r211 = false;
        r211 = false;
        r211 = false;
        if (r110.length() != 0) goto L24;
        boolean r111 = true;
    L25:
        if (r111 == false) goto L45;
        LruCache<String, Message> r112 = r108.mb();
        String r113 = r310.getReplyId();
        if (r113 != null) goto L29;
        r113 = "";
    L29:
        Message r114 = r112.get(r113);
        if (r114 == null) goto L34;
        Map<String, String> r115 = r114.getExt();
        if (r115 == null) goto L34;
        String r116 = r115.get("original_content_source");
    L35:
        if (r116 == null) goto L39;
        r102 = r116;
    L39:
        if (r102.length() != 0) goto L41;
        boolean r117 = true;
    L42:
        if (r117 == false) goto L44;
        r102 = "other";
    L44:
        String r118 = r102;
    L46:
        ArrayList r119 = (ArrayList) r100;
        String r120 = "0";
        if ((!r119.isEmpty()) == false) goto L87;
        ArrayList r121 = new ArrayList();
        Iterator r122 = r119.iterator();
    L50:
        if (r122.hasNext() == false) goto L61;
        Object r123 = r122.next();
        Integer r124 = ((CreationItem) r123).type;
        if (r124 != null) goto L55;
    L57:
        boolean r125 = false;
    L58:
        if (r125 == false) goto L50;
        r121.add(r123);
        goto L50
    L55:
        if (r124.intValue() != 1) goto L57;
        r125 = true;
        goto L58
    L61:
        if ((!r121.isEmpty()) == false) goto L182;
        String r126 = r310.getMessageId();
        String r127 = r310.getConversationId();
        String r128 = CollectionsKt.joinToString$default(r121, ",", null, null, 0, null, new com.larus.uaigc.chat.markdown.helper.e0(), 30, null);
        String r129 = CollectionsKt.joinToString$default(r121, ",", null, null, 0, null, new com.larus.uaigc.chat.markdown.helper.f0(), 30, null);
        if (com.larus.bmhome.chat.bean.d.z0(r310) == false) goto L65;
        r120 = "1";
    L65:
        String r130 = r106;
        CreationItem r131 = (CreationItem) CollectionsKt.firstOrNull(r121);
        if (r131 == null) goto L75;
        CreationGenDetail r132 = r131.genDetail;
        if (r132 == null) goto L75;
        Integer r133 = r132.taskType;
        if (r133 == null) goto L75;
        if (r133.intValue() != 5) goto L75;
        boolean r134 = true;
    L76:
        CreationItem r135 = (CreationItem) CollectionsKt.firstOrNull(r121);
        if (r135 == null) goto L86;
        CreationGenDetail r136 = r135.genDetail;
        if (r136 == null) goto L86;
        Integer r137 = r136.taskType;
        if (r137 == null) goto L86;
        if (r137.intValue() != 7) goto L86;
        r211 = true;
    L86:
        boolean r138 = com.larus.im.bean.message.a.C0(r310);
        u2.c(r311, r127, r120, r107, r126, r118, r128, r129, "bot", Boolean.valueOf(r134), Boolean.valueOf(r211), Boolean.valueOf(r138), tz9.a.a(r310), null, r130, 90112);
        return;
    L75:
        r134 = false;
        goto L76
    L182:
        return;
    L87:
        Map<String, CreationTask> r139 = com.larus.uaigc.chat.markdown.helper.j0.d(dp8.e.c(r310));
        if (r139 == null) goto L90;
        Collection<CreationTask> r140 = r139.values();
    L91:
        if (r140 == null) goto L105;
        ArrayList r141 = new ArrayList();
        Iterator<T> r142 = r140.iterator();
    L94:
        if (r142.hasNext() == false) goto L106;
        CreationTask r143 = (CreationTask) r142.next();
        if (r143 == null) goto L102;
        CreationAsset r144 = r143.asset;
        if (r144 == null) goto L102;
        UserCreationImage r145 = r144.imageContent;
        if (r145 == null) goto L102;
        ImageInfo r146 = r145.f365014a;
    L103:
        if (r146 == null) goto L94;
        r141.add(r146);
    L102:
        r146 = null;
    L106:
        if (r141 != null) goto L108;
    L111:
        boolean r147 = true;
    L112:
        if (r147 == true) goto L135;
        String r148 = r310.getMessageId();
        String r149 = r310.getConversationId();
        ArrayList r212 = r141;
        String r150 = CollectionsKt.joinToString$default(r212, ",", null, null, 0, null, new com.larus.uaigc.chat.markdown.helper.g0(), 30, null);
        String r151 = CollectionsKt.joinToString$default(r212, ",", null, null, 0, null, new com.larus.uaigc.chat.markdown.helper.h0(), 30, null);
        if (com.larus.bmhome.chat.bean.d.z0(r310) == false) goto L116;
        r120 = "1";
    L116:
        String r152 = r106;
        Collection<CreationTask> r153 = r140;
        CreationTask r154 = (CreationTask) CollectionsKt.firstOrNull(r153);
        if (r154 == null) goto L124;
        Integer r155 = r154.taskType;
        if (r155 == null) goto L124;
        if (r155.intValue() != 5) goto L124;
        boolean r156 = true;
    L125:
        CreationTask r157 = (CreationTask) CollectionsKt.firstOrNull(r153);
        if (r157 == null) goto L133;
        Integer r158 = r157.taskType;
        if (r158 == null) goto L133;
        if (r158.intValue() != 7) goto L133;
        boolean r159 = true;
    L134:
        boolean r160 = com.larus.im.bean.message.a.C0(r310);
        int r161 = 7;
        u2.c(r311, r149, r120, r107, r148, r118, r150, r151, "bot", Boolean.valueOf(r156), Boolean.valueOf(r159), Boolean.valueOf(r160), tz9.a.a(r310), null, r152, 90112);
    L136:
        if (r140 == null) goto L153;
        Iterator<T> r162 = r140.iterator();
    L139:
        if (r162.hasNext() == false) goto L151;
        Object r163 = r162.next();
        CreationTask r164 = (CreationTask) r163;
        if (r164 == null) goto L148;
        Integer r165 = r164.loadingAssetType;
        if (r165 == null) goto L148;
        if (r165.intValue() != r161) goto L148;
        boolean r166 = true;
    L149:
        if (r166 == false) goto L139;
    L152:
        CreationTask r167 = (CreationTask) r163;
    L154:
        if (r167 == null) goto L184;
        CreationAsset r168 = r167.asset;
        if (r168 == null) goto L162;
        ep8.a r169 = r168.videoContent;
        if (r169 == null) goto L162;
        AiGenVideoContentData r170 = r169.videoInfo;
        if (r170 == null) goto L162;
        r103 = r170.getVid();
    L162:
        String r171 = r103;
        String r172 = r310.getMessageId();
        String r173 = tz9.a.a(r310);
        Integer r174 = r167.index;
        if (r174 == null) goto L165;
        r210 = r174.intValue();
    L165:
        a4.d(r171, r172, r311, r173, Integer.valueOf(r210 + 1), r167.f310760id, null, null, BDVideoUploaderBase.KeyIsDynamicSliceLowSize);
        return;
    L184:
        return;
    L148:
        r166 = false;
        goto L149
    L151:
        r163 = null;
        goto L152
    L153:
        r167 = null;
    L133:
        r159 = false;
    L124:
        r156 = false;
        goto L125
    L135:
        r161 = 7;
        goto L136
    L108:
        if (r141.isEmpty() == true) goto L111;
        r147 = false;
        goto L112
    L105:
        r141 = null;
        goto L106
    L90:
        r140 = null;
        goto L91
    L41:
        r117 = false;
    L34:
        r116 = null;
        goto L35
    L45:
        r118 = r110;
        goto L46
    L24:
        r111 = false;
    L17:
        r107 = null;
        goto L18
    L16:
        r106 = null;
        goto L17
    L7:
        if (com.larus.bmhome.chat.bean.d.a0(r310) == true) goto L11;
        if (((ArrayList) r100).isEmpty() == false) goto L11;
        return;
    }

    @Override // hy9.d
    public final void k(String r100, String r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r104, "params");
        r104.putOpt("use_click_from", "ai_generate_board");     // Catch: JSONException -> L5
        r104.putOpt("action_bar_key", r100);     // Catch: JSONException -> L5
        r104.putOpt(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r101);     // Catch: JSONException -> L5
        r104.putOpt(LiveTutorHomeVM.ACTION_BAR_ITEM_ID, r102);     // Catch: JSONException -> L5
        r104.putOpt("image_edit_function_tab", r103);     // Catch: JSONException -> L5
    L7:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("use_replica_button_cancel");
        r106.f21463a.merge(r105);
        r106.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("InstructionHitPoints", "error in mobUseReplicaButtonCancel " + e.getLocalizedMessage());
        goto L7
    }

    @Override // hy9.d
    public final void d(int r100, String r101, String r102, String r103, String r104) {
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "params");
        r105.putOpt("click_from", "ai_generate_board");     // Catch: JSONException -> L5
        r105.putOpt("is_active_click", Integer.valueOf(r100));     // Catch: JSONException -> L5
        r105.putOpt("action_bar_key", r101);     // Catch: JSONException -> L5
        r105.putOpt(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r102);     // Catch: JSONException -> L5
        r105.putOpt(LiveTutorHomeVM.ACTION_BAR_ITEM_ID, r103);     // Catch: JSONException -> L5
        r105.putOpt("image_edit_function_tab", r104);     // Catch: JSONException -> L5
    L7:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("use_replica_button_click");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("InstructionHitPoints", "error in mobUseReplicaButtonClick " + e.getLocalizedMessage());
        goto L7
    }

    @Override // hy9.d
    public final void f(String r100, String r101, String r102, String r103, String r104) {
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "params");
        r105.putOpt("show_from", r100);     // Catch: JSONException -> L5
        r105.putOpt("action_bar_key", r101);     // Catch: JSONException -> L5
        r105.putOpt(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r102);     // Catch: JSONException -> L5
        r105.putOpt(LiveTutorHomeVM.ACTION_BAR_ITEM_ID, r103);     // Catch: JSONException -> L5
        r105.putOpt("image_edit_function_tab", r104);     // Catch: JSONException -> L5
    L7:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("use_replica_button_show");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("InstructionHitPoints", "error in mobUseReplicaButtonShow " + e.getLocalizedMessage());
        goto L7
    }

    @Override // hy9.d
    public final void a(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111) {
        JSONObject r107 = new JSONObject();
        Intrinsics.checkNotNullParameter(r107, "params");
        if (r100 != null) goto L23;
    L7:
        if (r101 == null) goto L9;
        r107.put("tab_type_after", r101);     // Catch: JSONException -> L5
    L9:
        if (r102 == null) goto L11;
        r107.put("enter_method", r102);     // Catch: JSONException -> L5
    L11:
        if (r103 == null) goto L13;
        r107.put("bot_id", r103);     // Catch: JSONException -> L5
    L13:
        if (r111 == null) goto L16;
        r107.put("current_page", r111);     // Catch: JSONException -> L5
    L16:
        if (com.larus.utils.o0.d(r106) == false) goto L18;
        r107.put("from_template_id", r106);     // Catch: JSONException -> L5
    L18:
        r107.putOpt("image_edit_function_id", r110);     // Catch: JSONException -> L5
        r107.putOpt(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r104);     // Catch: JSONException -> L5
        r107.putOpt("action_bar_template_type", r105);     // Catch: JSONException -> L5
    L21:
        TrackParams r108 = new TrackParams().merge(r107);
        by7.a r109 = new by7.a("image_edit_tab_switch");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("InstructionHitPoints", "error in mobImageEditTabSwitch " + e.getLocalizedMessage());
        goto L21
    L23:
        r107.put("tab_type_before", r100);     // Catch: JSONException -> L5
        goto L7
    }

    @Override // hy9.d
    public final void h(String r100, Integer r101, String r102, String r103, String r104, String r105, String r106, String r107, JSONObject r110, by7.e r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        nz9.c.b(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112);
    }

    @Override // hy9.d
    public final void g(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, String r211, String r212, Boolean r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, JSONObject r311, by7.e r312) {
        Intrinsics.checkNotNullParameter(r215, "tabType");
        Intrinsics.checkNotNullParameter(r311, "params");
        Intrinsics.checkNotNullParameter(r311, "params");
        if (r213 != null) goto L35;
        String r117 = null;
    L7:
        r311.putOpt("is_deep_thinking", r117);     // Catch: JSONException -> L28
        r311.putOpt("ai_create_show_mode", r214);     // Catch: JSONException -> L28
        r311.putOpt("button_name", r110);     // Catch: JSONException -> L28
        r311.putOpt("parent_button_name", r111);     // Catch: JSONException -> L28
        r311.putOpt("show_from", r113);     // Catch: JSONException -> L28
        r311.putOpt(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r114);     // Catch: JSONException -> L28
        r311.putOpt(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r210);     // Catch: JSONException -> L28
        r311.putOpt("action_bar_template_type", r211);     // Catch: JSONException -> L28
        r311.putOpt("image_edit_function_id", r112);     // Catch: JSONException -> L28
        if (r115 == null) goto L10;
        r311.put("bot_id", r115);     // Catch: JSONException -> L28
    L10:
        if (r116 == null) goto L13;
        r311.put("enter_method", r116);     // Catch: JSONException -> L28
    L13:
        if (com.larus.utils.o0.d(r212) == false) goto L15;
        r311.put("previous_page", r212);     // Catch: JSONException -> L28
    L15:
        if (r215 == null) goto L17;
        r311.put("tab_type", r215);     // Catch: JSONException -> L28
    L17:
        if (r216 == null) goto L19;
        r311.put("current_page", r216);     // Catch: JSONException -> L28
    L19:
        if (r217 == null) goto L21;
        r311.put("template_page_type", r217);     // Catch: JSONException -> L28
    L21:
        if (r218 == null) goto L23;
        r311.put("prompt_type", r218);     // Catch: JSONException -> L28
    L23:
        if (r219 == null) goto L25;
        r311.put("prompt_from", r219);     // Catch: JSONException -> L28
    L25:
        if (r310 == null) goto L30;
        r311.put("visual_size", r310);     // Catch: JSONException -> L28
    L28:
        e = move-exception;
        FLogger.f375446a.e("InstructionHitPoints", "error in mobImageEditFunctionShow " + e.getLocalizedMessage());
    L30:
        TrackParams r100 = new TrackParams().merge(r311);
        by7.a r101 = new by7.a("image_edit_function_show");
        if (r312 == null) goto L33;
        r101.f21464b = r312;
    L33:
        r101.f21463a.merge(r100);
        r101.b();
        return;
    L35:
        r117 = l3.f(r213);     // Catch: JSONException -> L28
        goto L7
    }

    @Override // hy9.d
    public final void i(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r210, String r211, Boolean r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, JSONObject r312, by7.e r313) {
        Intrinsics.checkNotNullParameter(r218, "tabType");
        Intrinsics.checkNotNullParameter(r312, "params");
        Intrinsics.checkNotNullParameter(r312, "params");
        if (r212 != null) goto L52;
        String r118 = null;
    L7:
        r312.putOpt("is_deep_thinking", r118);     // Catch: JSONException -> L37
        r312.putOpt("ai_create_show_mode", r213);     // Catch: JSONException -> L37
        r312.putOpt("button_name", r110);     // Catch: JSONException -> L37
        r312.putOpt("parent_button_name", r111);     // Catch: JSONException -> L37
        r312.putOpt("show_from", r113);     // Catch: JSONException -> L37
        r312.putOpt(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r114);     // Catch: JSONException -> L37
        r312.putOpt(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r117);     // Catch: JSONException -> L37
        r312.putOpt("action_bar_template_type", r210);     // Catch: JSONException -> L37
        r312.putOpt("image_edit_function_id", r112);     // Catch: JSONException -> L37
        if (com.larus.utils.o0.d(r211) == false) goto L10;
        r312.put("previous_page", r211);     // Catch: JSONException -> L37
    L10:
        if (r115 == null) goto L12;
        r312.put("bot_id", r115);     // Catch: JSONException -> L37
    L12:
        if (r116 == null) goto L15;
        r312.put("enter_method", r116);     // Catch: JSONException -> L37
    L15:
        if (com.larus.utils.o0.d(r214) == false) goto L18;
        r312.put("recommend_from", r214);     // Catch: JSONException -> L37
    L18:
        if (com.larus.utils.o0.d(r217) == false) goto L21;
        r312.put("template_rec_extra", r217);     // Catch: JSONException -> L37
    L21:
        if (com.larus.utils.o0.d(r216) == false) goto L24;
        r312.put("template_rec_req_id", r216);     // Catch: JSONException -> L37
    L24:
        if (com.larus.utils.o0.d(r215) == false) goto L27;
        r312.put("from_template_id", r215);     // Catch: JSONException -> L37
    L27:
        if (com.larus.utils.o0.d(r218) == false) goto L30;
        r312.put("tab_type", r218);     // Catch: JSONException -> L37
    L30:
        if (com.larus.utils.o0.d(r219) == false) goto L32;
        r312.put("creation_task_id", r219);     // Catch: JSONException -> L37
    L32:
        if (r310 == null) goto L34;
        r312.put("current_page", r310);     // Catch: JSONException -> L37
    L34:
        if (r311 == null) goto L39;
        r312.put("template_page_type", r311);     // Catch: JSONException -> L37
    L37:
        e = move-exception;
        FLogger.f375446a.e("InstructionHitPoints", "error in mobImageEditFunctionClick " + e.getLocalizedMessage());
    L39:
        TrackParams r100 = new TrackParams().merge(r312);
        by7.a r101 = new by7.a("image_edit_function_click");
        if (r313 == null) goto L42;
        r101.f21464b = r313;
    L42:
        r101.f21463a.merge(r100);
        r101.b();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L45
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("image_edit_function_click", r312, null, null);     // Catch: Throwable -> L45
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L45
    L47:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L56;
        FLogger.f375446a.e("InstructionHitPoints", "slardar report error, image_edit_function_click " + r104.getLocalizedMessage());
        return;
    L56:
        return;
    L45:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L47
    L52:
        r118 = l3.f(r212);     // Catch: JSONException -> L37
        goto L7
    }
}
