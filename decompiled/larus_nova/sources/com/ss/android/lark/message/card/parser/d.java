package com.ss.android.lark.message.card.parser;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.CardAppInfo;
import com.bytedance.lark.pb.basic.v1.CardContent;
import com.bytedance.lark.pb.basic.v1.CardVisitInfo;
import com.bytedance.lark.pb.basic.v1.Content;
import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
import com.larksuite.component.card.cardcontainer.UniversalCardRuntimeJsLoader;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.y;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.message.CardAction;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.card.style.MessageCardStyleProvider;
import com.ss.android.lark.message.lynxcard.settings.CardMessageUserLynxRenderSettings;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import idb.f;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class d {
    public static HashSet<String> b(List<CardContent.Url> r100) {
        HashSet<String> r101 = new HashSet();
        Iterator<CardContent.Url> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        CardContent.Url r103 = r102.next();
        if (TextUtils.isEmpty(r103.android_url) == false) goto L7;
        if (TextUtils.isEmpty(r103.url) == true) goto L4;
        r101.add(r103.url);
        goto L4
    L7:
        r101.add(r103.android_url);
        goto L4
    L11:
        return r101;
    }

    public static com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.VisitInfo c(CardVisitInfo r110) {
        if (r110 != null) goto L6;
        return null;
    L6:
        return new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.VisitInfo(r110.scene_type.getValue(), r110.entity_type.getValue(), r110.entity_id, r110.inner_msg_id.longValue(), r110.auth_file_key, new HashMap(r110.im_ext), new HashMap(r110.ext));
    }

    public static com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment d(CardContent.JsonAttachment r110) {
        com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment r100 = new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment();
        if (CollectionUtils.isNotEmpty(r110.at_users) == false) goto L14;
        HashMap<String, RichTextElement.AtProperty> r101 = new HashMap(r110.at_users.size());
        Iterator<Map.Entry<String, com.bytedance.lark.pb.basic.v1.RichTextElement.AtProperty>> r102 = r110.at_users.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<String, com.bytedance.lark.pb.basic.v1.RichTextElement.AtProperty> r103 = r102.next();
        r101.put(r103.getKey(), com.ss.android.lark.message.card.b.a().getAtProperty(r103.getValue()));     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Log.e("ModelParserCardContent_[OPCard]", "transform AtProperty failed", e);
        goto L6
    L12:
        r100.setAtUsers(r101);
    L14:
        if (CollectionUtils.isNotEmpty(r110.images) == false) goto L25;
        HashMap<String, RichTextElement.ImageProperty> r104 = new HashMap(r110.images.size());
        Iterator<Map.Entry<String, com.bytedance.lark.pb.basic.v1.RichTextElement.ImageProperty>> r105 = r110.images.entrySet().iterator();
    L17:
        if (r105.hasNext() == false) goto L23;
        Map.Entry<String, com.bytedance.lark.pb.basic.v1.RichTextElement.ImageProperty> r106 = r105.next();
        r104.put(r106.getKey(), com.ss.android.lark.message.card.b.a().getImageProperty(r106.getValue()));     // Catch: Exception -> L21
    L21:
        e = move-exception;
        Log.e("ModelParserCardContent_[OPCard]", "transform ImageProperty failed", e);
        goto L17
    L23:
        r100.setImages(r104);
    L25:
        if (CollectionUtils.isNotEmpty(r110.option_users) == false) goto L32;
        HashMap<String, com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.OptionUser> r107 = new HashMap(r110.option_users.size());
        Iterator<Map.Entry<String, CardContent.JsonAttachment.OptionUser>> r108 = r110.option_users.entrySet().iterator();
    L28:
        if (r108.hasNext() == false) goto L30;
        Map.Entry<String, CardContent.JsonAttachment.OptionUser> r109 = r108.next();
        r107.put(r109.getKey(), new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.OptionUser(r109.getValue().user_id, r109.getValue().content, r109.getValue().avatar_key));
        goto L28
    L30:
        r100.setOptionUsers(r107);
    L32:
        if (CollectionUtils.isNotEmpty(r110.component_status_by_name) == false) goto L35;
        HashMap<String, String> r111 = new HashMap(r110.component_status_by_name.size());
        r111.putAll(r110.component_status_by_name);
        r100.setComponentStatusByName(r111);
    L35:
        if (TextUtils.isEmpty(r110.card_simple_summary) == true) goto L37;
        r100.setSummary(r110.card_simple_summary);
    L86:
        if (CollectionUtils.isNotEmpty(r110.persons) == false) goto L93;
        HashMap<String, com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.Person> r112 = new HashMap(r110.persons.size());
        Iterator<Map.Entry<String, CardContent.JsonAttachment.PersonInfo>> r113 = r110.persons.entrySet().iterator();
    L89:
        if (r113.hasNext() == false) goto L91;
        Map.Entry<String, CardContent.JsonAttachment.PersonInfo> r114 = r113.next();
        r112.put(r114.getKey(), new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.Person(r114.getValue().person_id, r114.getValue().type.ordinal(), r114.getValue().content, r114.getValue().avatar_key));
        goto L89
    L91:
        r100.setPersonMap(r112);
    L93:
        if (CollectionUtils.isNotEmpty(r110.audios) == false) goto L100;
        HashMap<String, com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.AudioInfo> r115 = new HashMap(r110.audios.size());
        Iterator<Map.Entry<String, CardContent.JsonAttachment.AudioInfo>> r116 = r110.audios.entrySet().iterator();
    L96:
        if (r116.hasNext() == false) goto L98;
        Map.Entry<String, CardContent.JsonAttachment.AudioInfo> r117 = r116.next();
        com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.VisitInfo r118 = c(r117.getValue().visit_info);
        r115.put(r117.getKey(), new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.AudioInfo(r117.getValue().key, r117.getValue().duration.intValue(), r117.getValue().size.longValue(), r118));
        goto L96
    L98:
        r100.setAudioInfoMap(r115);
    L100:
        if (CollectionUtils.isNotEmpty(r110.videos) == false) goto L106;
        HashMap<String, com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.VideoInfo> r119 = new HashMap(r110.videos.size());
        Iterator<Map.Entry<String, CardContent.JsonAttachment.VideoInfo>> r120 = r110.videos.entrySet().iterator();
    L103:
        if (r120.hasNext() == false) goto L105;
        Map.Entry<String, CardContent.JsonAttachment.VideoInfo> r121 = r120.next();
        com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.VisitInfo r122 = c(r121.getValue().visit_info);
        r119.put(r121.getKey(), new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.VideoInfo(r121.getValue().key, r121.getValue().duration.intValue(), r121.getValue().size.longValue(), r121.getValue().url, r121.getValue().mime, r122));
        goto L103
    L105:
        r100.setVideoInfoMap(r119);
    L106:
        return r100;
    L37:
        CardContent.JsonAttachment.SummaryContent r123 = r110.summary;
        if (r123 == null) goto L86;
        if (r123.items == null) goto L86;
        StringBuilder r124 = new StringBuilder();
        Iterator<CardContent.JsonAttachment.SummaryContent.Item> r125 = r110.summary.items.iterator();
    L43:
        if (r125.hasNext() == false) goto L84;
        CardContent.JsonAttachment.SummaryContent.Item r126 = r125.next();
        if (r126 == null) goto L43;
        if (TextUtils.isEmpty(r126.text) == false) goto L48;
        if (r126.image != null) goto L51;
        if (r126.at_user != null) goto L54;
        CardContent.JsonAttachment.SummaryContent.Item.Emotion r127 = r126.emotion;
        if (r127 == null) goto L60;
        if (TextUtils.isEmpty(r127.key) == true) goto L60;
        r124.append(EmojiHandler.e(r126.emotion.key));
    L60:
        CardContent.JsonAttachment.SummaryContent.Item.PersonList r128 = r126.person_list;
        if (r128 == null) goto L75;
        if (CollectionUtils.isNotEmpty(r128.persons) == false) goto L75;
        StringBuilder r129 = new StringBuilder();
        Iterator<CardContent.JsonAttachment.PersonInfo> r130 = r126.person_list.persons.iterator();
    L66:
        if (r130.hasNext() == false) goto L73;
        CardContent.JsonAttachment.PersonInfo r131 = r130.next();
        if (TextUtils.isEmpty(r131.content) == true) goto L66;
        if (r129.length() <= 0) goto L72;
        r129.append(UIHelper.getString(R.string.Lark_SmartCard_Comma));
    L72:
        r129.append(r131.content);
        goto L66
    L73:
        r124.append(r129.toString());
    L75:
        if (r126.i18n_content == null) goto L43;
        Application r132 = LarkContext.getApplication();
        String r133 = r126.i18n_content.key;
        int r134 = r132.getResources().getIdentifier(r133, "string", r132.getPackageName());
        if (r134 != 0) goto L82;
        String r135 = r126.i18n_content.defaultValue;
        if (r135 != null) goto L83;
        r135 = "";
    L83:
        r124.append(r135);
        goto L43
    L82:
        r135 = UIUtils.getString(r132, r134);
        goto L83
    L54:
        r124.append("@");
        r124.append(r126.at_user.content);
        goto L43
    L51:
        r124.append(UIHelper.getString(R.string.Lark_Legacy_ImageSummarize));
        goto L43
    L48:
        r124.append(r126.text);
        goto L43
    L84:
        r100.setSummary(r124.toString());
        goto L86
    }

    public static CardAction.Parameters e(com.bytedance.lark.pb.basic.v1.CardAction.Parameters r100) {
        CardAction.MessageInfo r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        CardAction.Parameters r102 = new CardAction.Parameters();
        r102.setMessageId(r100.message_id);
        r102.setUserId(r100.user_id);
        r102.setParameters(new HashMap(r100.parameters));
        com.bytedance.lark.pb.basic.v1.CardAction.UserInfo r103 = r100.user_info;
        if (r103 != null) goto L8;
        CardAction.UserInfo r104 = null;
    L9:
        r102.setUserInfo(r104);
        com.bytedance.lark.pb.basic.v1.CardAction.MessageInfo r105 = r100.message_info;
        if (r105 == null) goto L13;
        r101 = new CardAction.MessageInfo();
        r101.setMessageOpenId(r105.message_open_id);
    L13:
        r102.setMessageInfo(r101);
        return r102;
    L8:
        r104 = new CardAction.UserInfo();
        r104.setUserOpenId(r103.user_open_id);
        goto L9
    }

    public static com.bytedance.lark.pb.basic.v1.CardAction.Parameters f(CardAction.Parameters r100) {
        String r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        com.bytedance.lark.pb.basic.v1.CardAction.Parameters.Builder r102 = new com.bytedance.lark.pb.basic.v1.CardAction.Parameters.Builder().message_id(r100.getMessageId()).user_id(r100.getUserId()).parameters(new HashMap(r100.getParameters()));
        com.bytedance.lark.pb.basic.v1.CardAction.UserInfo.Builder r103 = new com.bytedance.lark.pb.basic.v1.CardAction.UserInfo.Builder();
        if (r100.getUserInfo() == null) goto L8;
        String r104 = r100.getUserInfo().getUserOpenId();
    L9:
        com.bytedance.lark.pb.basic.v1.CardAction.Parameters.Builder r105 = r102.user_info(r103.user_open_id(r104).build());
        com.bytedance.lark.pb.basic.v1.CardAction.MessageInfo.Builder r106 = new com.bytedance.lark.pb.basic.v1.CardAction.MessageInfo.Builder();
        if (r100.getMessageInfo() == null) goto L13;
        r101 = r100.getMessageInfo().getMessageOpenId();
    L13:
        return r105.message_info(r106.message_open_id(r101).build()).build();
    L8:
        r104 = null;
        goto L9
    }

    public static com.ss.android.lark.chat.entity.message.content.CardContent a(Content r210, CardContent r211) {
        int r100 = com.ss.android.lark.message.card.utils.b.f431929a;
        Intrinsics.checkNotNullParameter(r211, "cardContent");
        String r101 = r211.universal_host_card_id;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L21;
        String r103 = r211.json_body;
        if (r103 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == false) goto L21;
        if (r211.universal_card_entity != null) goto L21;
        boolean r105 = true;
    L22:
        String r106 = null;
        if (r105 == false) goto L41;
        Log.e("ModelParserCardContent", "getCardContent card error, host_card_id=" + r211.universal_host_card_id);
        Intrinsics.checkNotNullParameter(r211, "pbCardContent");
        com.ss.android.lark.chat.entity.message.content.CardContent r107 = new com.ss.android.lark.chat.entity.message.content.CardContent();
        Log.i("ModelParserCardContentEntity", "getErrorCardContent messageId:" + r107.getMessageId() + ", traceId:" + gyb.a.a().subTrace().getTracingID());
        r107.setHostCardId(r211.universal_host_card_id);
        r107.setType(com.ss.android.lark.chat.entity.message.content.CardContent.Type.TEXT);
        r107.setCardVersion(2);
        r107.setExtraType(com.ss.android.lark.chat.entity.message.content.CardContent.ExtraType.UNKNOWN);
        r107.setActions(MapsKt.emptyMap());
        r107.setDataSource(com.ss.android.lark.chat.entity.message.content.CardContent.DataSource.CARD_ENTITY);
        LarkAppContext.Companion.getClass();
        InputStream r108 = LarkAppContext.access$getInstance$cp().getContext().getAssets().open("error_card_dsl.json");     // Catch: Throwable -> L36
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L29
        String r109 = Okio.buffer(Okio.source(r108)).readUtf8();     // Catch: Throwable -> L29
        Log.d("ErrorCardUtil", "getErrorDslJsonString successfully read error card");     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r108, null);     // Catch: Throwable -> L36
        r106 = r109;
    L38:
        r107.setDslJsonString(r106);
        r107.setDslJsonAttachment(new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment());
        r107.setCardHeader(new com.ss.android.lark.chat.entity.message.content.CardContent.CardHeader());
        r107.setExtraInfo(new com.ss.android.lark.chat.entity.message.content.CardContent.ExtraInfo());
        r107.setEnableForward(false);
        r107.setForward(false);
        r107.setJsonCardUrls(new HashSet());
        r107.setUniversalCardID("");
        r107.setUniversalCardVersion("");
        r107.setStreamingMode(false);
        return r107;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        CloseableKt.closeFinally(r108, th);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Log.e("ErrorCardUtil", "getErrorDslJsonString error", th);
        goto L38
    L41:
        if (r211.universal_card_entity == null) goto L316;
        Log.i("ModelParserCardContent", "getCardContent by card entity, message_id=" + r211.universal_card_entity.source_id);
        UniversalCardEntity r110 = r211.universal_card_entity;
        String r111 = r211.universal_host_card_id;
        int r112 = e.f431907a;
        Intrinsics.checkNotNullParameter(r110, "pbEntity");
        com.ss.android.lark.chat.entity.message.content.CardContent r113 = new com.ss.android.lark.chat.entity.message.content.CardContent();
        OPTrace r114 = gyb.a.a().subTrace();
        Log.i("ModelParserCardContentEntity", "getContent messageId:" + r110.source_id + ", traceId:" + r114.getTracingID());
        r113.setType(com.ss.android.lark.chat.entity.message.content.CardContent.Type.TEXT);
        r113.setCardVersion(2);
        r113.setExtraType(com.ss.android.lark.chat.entity.message.content.CardContent.ExtraType.UNKNOWN);
        r113.setActions(MapsKt.emptyMap());
        r113.setHostCardId(r111);
        CardAppInfo r115 = r110.app_info;
        if (r115 == null) goto L45;
        r113.setSendCardBotId(r115.bot_id);
        r113.setSendAppId(r115.app_id);
    L45:
        UniversalCardEntity.DataSource r116 = r110.data_source;
        if (r116 != null) goto L48;
        int r117 = -1;
    L49:
        if (r117 == 1) goto L55;
        if (r117 == 2) goto L54;
        if (r117 == 3) goto L53;
        com.ss.android.lark.chat.entity.message.content.CardContent.DataSource r118 = com.ss.android.lark.chat.entity.message.content.CardContent.DataSource.IM_ENTITY;
    L56:
        r113.setDataSource(r118);
        r113.setDslJsonString(r110.content.card);
        UniversalCardRuntimeJsLoader.b r119 = UniversalCardRuntimeJsLoader.f283220a;
        UniversalCardEntity.Attachment r120 = r110.content.attachment;
        String r121 = "";
        if (r120 != null) goto L59;
        com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment r122 = null;
    L203:
        r113.setDslJsonAttachment(r122);
        UniversalCardEntity.ActionStatus r123 = r110.action_status;
        if (r123 == null) goto L218;
        Map<String, String> r124 = r123.component_status_by_action_id;
        if (r124 == null) goto L208;
        HashMap<String, String> r125 = r113.getComponentStatusByActionId();
        r125.clear();
        r125.putAll(r124);
    L208:
        Map<String, String> r126 = r123.component_status_by_name;
        if (r126 == null) goto L218;
        if (r113.getDslJsonAttachment() != null) goto L213;
        r113.setDslJsonAttachment(new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment());
    L213:
        com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment r127 = r113.getDslJsonAttachment();
        if (r127 == null) goto L218;
        HashMap<String, String> r128 = r127.getComponentStatusByName();
        if (r128 == null) goto L218;
        r128.clear();
        r128.putAll(r126);
    L218:
        UniversalCardEntity.CardHeader r129 = r110.card_header;
        if (r129 != null) goto L221;
        com.ss.android.lark.chat.entity.message.content.CardContent.CardHeader r130 = null;
    L232:
        r113.setCardHeader(r130);
        com.ss.android.lark.chat.entity.message.content.CardContent.ExtraInfo r131 = new com.ss.android.lark.chat.entity.message.content.CardContent.ExtraInfo();
        UniversalCardEntity.Content r132 = r110.content;
        if (r132 == null) goto L237;
        UniversalCardEntity.Config r133 = r132.config;
        if (r133 == null) goto L237;
        r131.setGadgetPreload(r133.is_gadget_preload.booleanValue());
        r131.setGadgetAppIds(r133.gadget_client_ids);
        r131.setAnalyticsData(r133.analytics_data);
        r131.setMeegoPreload(r133.is_meego_pre_load.booleanValue());
        r131.setParseTraceId(r114.getTracingID());
        r131.setEnableTranslate(r133.enable_translate.booleanValue());
        r131.setParseUUID(UUID.randomUUID().toString());
        r131.setCustomParameter(r133.custom_parameter);
    L238:
        Log.i("ModelParserCardContentEntity", "parseCardContent parseUUID:" + r131.getParseUUID());
        r113.setExtraInfo(r131);
        UniversalCardEntity.Content r134 = r110.content;
        if (r134 == null) goto L243;
        UniversalCardEntity.Config r135 = r134.config;
        if (r135 == null) goto L243;
        r113.setEnableForward(r135.enable_forward.booleanValue());
        r113.setForward(r135.is_forward.booleanValue());
        com.ss.android.lark.chat.entity.message.content.CardContent.WidthMode.a r136 = com.ss.android.lark.chat.entity.message.content.CardContent.WidthMode.Companion;
        String r137 = r135.width_mode;
        r136.getClass();
        r113.setWidthMode(com.ss.android.lark.chat.entity.message.content.CardContent.WidthMode.a.a(r137));
    L243:
        List<UniversalCardEntity.Url> r138 = r110.json_card_urls;
        if (r138 == null) goto L271;
        List<UniversalCardEntity.Url> r139 = r138;
        ArrayList r140 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r139, 10));
        Iterator<T> r141 = r139.iterator();
    L247:
        if (r141.hasNext() == false) goto L270;
        UniversalCardEntity.Url r142 = (UniversalCardEntity.Url) r141.next();
        String r143 = r142.android_url;
        if (r143 != null) goto L251;
    L258:
        String r144 = r142.url;
        if (r144 != null) goto L261;
    L266:
        r143 = null;
    L267:
        if (r143 != null) goto L269;
        r143 = "";
    L269:
        r140.add(r143);
        goto L247
    L261:
        if (r144.length() <= 0) goto L263;
        boolean r145 = true;
    L264:
        if (r145 == false) goto L266;
        r143 = r144;
        goto L267
    L263:
        r145 = false;
        goto L264
    L251:
        if (r143.length() <= 0) goto L253;
        boolean r146 = true;
    L254:
        if (r146 == true) goto L257;
        r143 = null;
    L257:
        if (r143 != null) goto L269;
    L253:
        r146 = false;
        goto L254
    L270:
        r113.setJsonCardUrls(new HashSet(r140));
    L271:
        String r147 = r110.card_id;
        if (r147 == null) goto L275;
        r121 = r147;
    L275:
        r113.setUniversalCardID(r121);
        r113.setUniversalCardVersion(r110.version);
        r113.setStreamingMode(r110.streaming_mode.booleanValue());
        UniversalCardEntity.StreamingConfig r148 = r110.streaming_config;
        if (r148 == null) goto L313;
        com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig r149 = new com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig();
        com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig.PrintStrategy.a r150 = com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig.PrintStrategy.Companion;
        int r151 = r148.print_strategy.getValue();
        r150.getClass();
        if (r151 != 1) goto L280;
        com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig.PrintStrategy r152 = com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig.PrintStrategy.FAST;
    L284:
        r149.setPrintStrategy(r152);
        UniversalCardEntity.StreamingConfig.PrintConfig r153 = r148.print_frequency_ms;
        if (r153 == null) goto L298;
        Integer r154 = r153.f253589android;
        if (r154.intValue() <= 0) goto L289;
        boolean r155 = true;
    L291:
        if (Boolean.valueOf(r155).booleanValue() == true) goto L294;
        r154 = null;
    L294:
        if (r154 == null) goto L296;
        int r156 = r154.intValue();
    L297:
        r149.setPrintFrequencyMs(r156);
        goto L298
    L296:
        r156 = r153.default_.intValue();
        goto L297
    L289:
        r155 = false;
    L298:
        UniversalCardEntity.StreamingConfig.PrintConfig r157 = r148.print_step;
        if (r157 == null) goto L312;
        Integer r158 = r157.f253589android;
        if (r158.intValue() <= 0) goto L303;
        boolean r159 = true;
    L305:
        if (Boolean.valueOf(r159).booleanValue() == false) goto L307;
        Integer r160 = r158;
    L308:
        if (r160 == null) goto L310;
        int r161 = r160.intValue();
    L311:
        r149.setPrintStep(r161);
        goto L312
    L310:
        r161 = r157.default_.intValue();
        goto L311
    L307:
        r160 = null;
        goto L308
    L303:
        r159 = false;
    L312:
        com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig r162 = r149;
    L314:
        r113.setStreamingConfig(r162);
        ResourceCleanScene.a r163 = ResourceCleanScene.Companion;
        Map<String, com.bytedance.lark.pb.basic.v1.ResourceCleanScene> r164 = r110.clean_resource_key_scene;
        r163.getClass();
        r113.setCleanResourceKeyScene(ResourceCleanScene.a.b(r164));
        return r113;
    L280:
        if (r151 == 2) goto L282;
        r152 = com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig.PrintStrategy.DEFAULT;
        goto L284
    L282:
        r152 = com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig.PrintStrategy.DELAY;
        goto L284
    L313:
        r162 = null;
    L237:
        Log.w("ModelParserCardContentEntity", "parseCardContent config is null");
        goto L238
    L221:
        r130 = new com.ss.android.lark.chat.entity.message.content.CardContent.CardHeader();
        r130.setMainTitle(r129.main_title);
        r130.setTitle(r129.title);
        r130.setTheme(r129.theme);
        String r165 = r129.subtitle;
        if (r165 == null) goto L232;
        if (r165.length() <= 0) goto L226;
        boolean r166 = true;
    L227:
        if (r166 == true) goto L230;
        r165 = null;
    L230:
        if (r165 == null) goto L232;
        r130.setSubTitle(r165);
        goto L232
    L226:
        r166 = false;
        goto L227
    L59:
        r122 = new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment();
        Map<String, com.bytedance.lark.pb.basic.v1.RichTextElement.AtProperty> r167 = r120.at_users;
        if (r167 != null) goto L62;
    L71:
        Map<String, com.bytedance.lark.pb.basic.v1.RichTextElement.ImageProperty> r168 = r120.images;
        if (r168 != null) goto L74;
    L83:
        Map<String, UniversalCardEntity.Character> r169 = r120.characters;
        if (r169 != null) goto L86;
    L95:
        ModelParserCardContentEntity$parseJsonAttachmentFromEntity$1$visitInfoConverter$1 r170 = ModelParserCardContentEntity$parseJsonAttachmentFromEntity$1$visitInfoConverter$1.INSTANCE;
        Map<String, UniversalCardEntity.AudioInfo> r171 = r120.audios;
        if (r171 != null) goto L98;
    L107:
        Map<String, UniversalCardEntity.VideoInfo> r172 = r120.videos;
        if (r172 != null) goto L110;
    L119:
        String r173 = r120.card_simple_summary;
        if (r173 != null) goto L122;
    L131:
        UniversalCardEntity.SummaryContent r174 = r120.summary;
        if (r174 == null) goto L203;
        List<UniversalCardEntity.SummaryContent.Item> r175 = r174.items;
        if (r175 == null) goto L203;
        StringBuilder r176 = new StringBuilder();
        Iterator r177 = CollectionsKt.filterNotNull(r175).iterator();
    L137:
        if (r177.hasNext() == false) goto L202;
        UniversalCardEntity.SummaryContent.Item r178 = (UniversalCardEntity.SummaryContent.Item) r177.next();
        String r179 = r178.text;
        if (r179 != null) goto L141;
    L147:
        boolean r180 = false;
    L148:
        if (r180 == true) goto L149;
        if (r178.image != null) goto L152;
        if (r178.at_user != null) goto L155;
        UniversalCardEntity.SummaryContent.Item.Emotion r181 = r178.emotion;
        if (r181 == null) goto L167;
        String r182 = r181.key;
        if (r182 == null) goto L167;
        if (r182.length() <= 0) goto L163;
        boolean r183 = true;
    L165:
        if (r183 != true) goto L167;
        boolean r184 = true;
    L168:
        if (r184 == true) goto L169;
        UniversalCardEntity.SummaryContent.Item.CharacterList r185 = r178.person_list;
        if (r185 == null) goto L177;
        List<UniversalCardEntity.Character> r186 = r185.characters;
        if (r186 == null) goto L177;
        if ((!r186.isEmpty()) != true) goto L177;
        boolean r187 = true;
    L178:
        if (r187 == true) goto L179;
        if (r178.i18n_content == null) goto L137;
        Application r188 = LarkContext.getApplication();
        int r189 = r188.getResources().getIdentifier(r178.i18n_content.key, "string", r188.getPackageName());
        if (r189 != 0) goto L200;
        String r190 = r178.i18n_content.defaultValue;
        if (r190 != null) goto L201;
        r190 = "";
    L201:
        r176.append(r190);
        goto L137
    L200:
        r190 = UIUtils.getString(r188, r189);
        goto L201
    L179:
        StringBuilder r191 = new StringBuilder();
        UniversalCardEntity.SummaryContent.Item.CharacterList r192 = r178.person_list;
        if (r192 == null) goto L137;
        List<UniversalCardEntity.Character> r193 = r192.characters;
        if (r193 == null) goto L137;
        Iterator<T> r194 = r193.iterator();
    L185:
        if (r194.hasNext() == false) goto L137;
        UniversalCardEntity.Character r195 = (UniversalCardEntity.Character) r194.next();
        if (r191.length() <= 0) goto L189;
        boolean r196 = true;
    L190:
        if (r196 == false) goto L192;
        r191.append(UIHelper.getString(R.string.Lark_SmartCard_Comma));
    L192:
        r191.append(r195.content);
        goto L185
    L189:
        r196 = false;
    L177:
        r187 = false;
        goto L178
    L169:
        r176.append(EmojiHandler.e(r178.emotion.key));
        goto L137
    L163:
        r183 = false;
    L167:
        r184 = false;
        goto L168
    L155:
        r176.append("@");
        r176.append(r178.at_user.content);
        goto L137
    L152:
        r176.append(UIHelper.getString(R.string.Lark_Legacy_ImageSummarize));
        goto L137
    L149:
        r176.append(r178.text);
        goto L137
    L141:
        if (r179.length() <= 0) goto L143;
        boolean r197 = true;
    L145:
        if (r197 != true) goto L147;
        r180 = true;
        goto L148
    L143:
        r197 = false;
        goto L145
    L202:
        r122.setSummary(r176.toString());
        goto L203
    L122:
        if (r173.length() != 0) goto L124;
        boolean r198 = true;
    L126:
        if ((!r198) == true) goto L129;
        r173 = null;
    L129:
        if (r173 == null) goto L131;
        r122.setSummary(r173);
        goto L203
    L124:
        r198 = false;
        goto L126
    L110:
        if ((!r172.isEmpty()) == true) goto L113;
        r172 = null;
    L113:
        if (r172 == null) goto L119;
        HashMap<String, com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.VideoInfo> r199 = new HashMap();
        Iterator<Map.Entry<String, UniversalCardEntity.VideoInfo>> r200 = r172.entrySet().iterator();
    L116:
        if (r200.hasNext() == false) goto L118;
        Map.Entry<String, UniversalCardEntity.VideoInfo> r201 = r200.next();
        String r1100 = r201.getKey();
        UniversalCardEntity.VideoInfo r202 = r201.getValue();
        r199.put(r1100, new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.VideoInfo(r202.key, r202.duration.intValue(), r202.size.longValue(), r202.url, r202.mime, r170.invoke(r202.visit_info)));
        goto L116
    L118:
        r122.setVideoInfoMap(r199);
        goto L119
    L98:
        if ((!r171.isEmpty()) == true) goto L101;
        r171 = null;
    L101:
        if (r171 == null) goto L107;
        HashMap<String, com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.AudioInfo> r203 = new HashMap();
        Iterator<Map.Entry<String, UniversalCardEntity.AudioInfo>> r204 = r171.entrySet().iterator();
    L104:
        if (r204.hasNext() == false) goto L106;
        Map.Entry<String, UniversalCardEntity.AudioInfo> r205 = r204.next();
        String r1101 = r205.getKey();
        UniversalCardEntity.AudioInfo r206 = r205.getValue();
        r203.put(r1101, new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.AudioInfo(r206.key, r206.duration.intValue(), r206.size.longValue(), r170.invoke(r206.visit_info)));
        goto L104
    L106:
        r122.setAudioInfoMap(r203);
        goto L107
    L86:
        if ((!r169.isEmpty()) == true) goto L89;
        r169 = null;
    L89:
        if (r169 == null) goto L95;
        HashMap<String, com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.OptionUser> r1102 = new HashMap();
        HashMap<String, com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.Person> r1103 = new HashMap();
        Iterator<Map.Entry<String, UniversalCardEntity.Character>> r1104 = r169.entrySet().iterator();
    L92:
        if (r1104.hasNext() == false) goto L94;
        Map.Entry<String, UniversalCardEntity.Character> r1105 = r1104.next();
        String r1106 = r1105.getKey();
        UniversalCardEntity.Character r1107 = r1105.getValue();
        r1102.put(r1106, new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.OptionUser(r1107.f253587id, r1107.content, r1107.avatar_key));
        r1103.put(r1106, new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.Person(r1107.f253587id, r1107.type.ordinal(), r1107.content, r1107.avatar_key));
        goto L92
    L94:
        r122.setOptionUsers(r1102);
        r122.setPersonMap(r1103);
        goto L95
    L74:
        if ((!r168.isEmpty()) == true) goto L77;
        r168 = null;
    L77:
        if (r168 == null) goto L83;
        HashMap<String, RichTextElement.ImageProperty> r1108 = new HashMap(r168.size());
        Iterator<Map.Entry<String, com.bytedance.lark.pb.basic.v1.RichTextElement.ImageProperty>> r1109 = r168.entrySet().iterator();
    L80:
        if (r1109.hasNext() == false) goto L82;
        Map.Entry<String, com.bytedance.lark.pb.basic.v1.RichTextElement.ImageProperty> r1110 = r1109.next();
        r1108.put(r1110.getKey(), com.ss.android.lark.message.card.b.a().getImageProperty(r1110.getValue()));
        goto L80
    L82:
        r122.setImages(r1108);
        goto L83
    L62:
        if ((!r167.isEmpty()) == true) goto L65;
        r167 = null;
    L65:
        if (r167 == null) goto L71;
        HashMap<String, RichTextElement.AtProperty> r1111 = new HashMap(r167.size());
        Iterator<Map.Entry<String, com.bytedance.lark.pb.basic.v1.RichTextElement.AtProperty>> r1112 = r167.entrySet().iterator();
    L68:
        if (r1112.hasNext() == false) goto L70;
        Map.Entry<String, com.bytedance.lark.pb.basic.v1.RichTextElement.AtProperty> r1113 = r1112.next();
        r1111.put(r1113.getKey(), com.ss.android.lark.message.card.b.a().getAtProperty(r1113.getValue()));
        goto L68
    L70:
        r122.setAtUsers(r1111);
        goto L71
    L53:
        r118 = com.ss.android.lark.chat.entity.message.content.CardContent.DataSource.STREAMING_ENTITY;
        goto L56
    L54:
        r118 = com.ss.android.lark.chat.entity.message.content.CardContent.DataSource.CARD_ENTITY;
        goto L56
    L55:
        r118 = com.ss.android.lark.chat.entity.message.content.CardContent.DataSource.IM_ENTITY;
        goto L56
    L48:
        r117 = e.a.f431908a[r116.ordinal()];
        goto L49
    L316:
        com.ss.android.lark.chat.entity.message.content.CardContent r207 = new com.ss.android.lark.chat.entity.message.content.CardContent();
        CardAppInfo r208 = r211.app_info;
        if (r208 == null) goto L319;
        r207.setSendCardBotId(r208.bot_id);
        r207.setSendAppId(r211.app_info.app_id);
    L319:
        com.ss.android.lark.chat.entity.message.content.CardContent.Type.a r209 = com.ss.android.lark.chat.entity.message.content.CardContent.Type.Companion;
        int r212 = r211.type.getValue();
        r209.getClass();
        if (r212 != 1) goto L322;
        com.ss.android.lark.chat.entity.message.content.CardContent.Type r213 = com.ss.android.lark.chat.entity.message.content.CardContent.Type.VOTE;
    L328:
        r207.setType(r213);
        r207.setWidthMode(com.ss.android.lark.chat.entity.message.content.CardContent.WidthMode.forString(r211.width_mode));
        r207.setDataSource(com.ss.android.lark.chat.entity.message.content.CardContent.DataSource.IM_CONTENT);
        r207.setHostCardId(r211.universal_host_card_id);
        long r214 = System.currentTimeMillis();
        OPTrace r215 = gyb.a.a().subTrace();
        if (r207.getCardVersion() != 1) goto L332;
        RichText r216 = com.ss.android.lark.message.card.b.a().parseRichTextFromPb(r211.richtext);
    L346:
        Log.i("ModelParserCardContent", "parseRichText messageId:nulltraceId:" + r215.getTracingID());
        r207.setRichText(r216);
        com.ss.android.lark.chat.entity.message.content.CardContent.ExtraType.a r217 = com.ss.android.lark.chat.entity.message.content.CardContent.ExtraType.Companion;
        int r218 = r211.extra.getValue();
        r217.getClass();
        if (r218 != 1) goto L349;
        com.ss.android.lark.chat.entity.message.content.CardContent.ExtraType r219 = com.ss.android.lark.chat.entity.message.content.CardContent.ExtraType.SENDER_CANNOT_CLICK;
    L350:
        r207.setExtraType(r219);
        Map<String, com.bytedance.lark.pb.basic.v1.CardAction> r220 = r211.actions;
        if (r220 != null) goto L353;
        HashMap r221 = new HashMap();
    L354:
        HashMap r222 = new HashMap();
        Iterator r1114 = r221.keySet().iterator();
    L356:
        if (r1114.hasNext() == false) goto L413;
        String r223 = (String) r1114.next();
        CardAction r1115 = (CardAction) r221.get(r223);
        JSONObject r1116 = new JSONObject();
        if (r1115 != null) goto L360;
    L411:
        long r1117 = r214;
        OPTrace r1118 = r215;
        Iterator r1119 = r1114;
    L412:
        r1114 = r1119;
        r215 = r1118;
        r214 = r1117;
        goto L356
    L360:
        if (r1115.getParameters() == null) goto L411;
        if (r1115.getParameters().getParameters() == null) goto L411;
        String r1120 = r1115.getParameters().getParameters().get("initial_type");
        r1116.put("tag", r1120);     // Catch: JSONException -> L408
        r1119 = r1114;
        r1118 = r215;
        r1117 = r214;
        if (f.a().isEnable("messagecard.action.allow_empty_value.android") == true) goto L512;
        String r1121 = "";
        if ("input".equals(r1120) == false) goto L389;
    L399:
        String r224 = r1115.getParameters().getParameters().get("initial_value");     // Catch: JSONException -> L406
        if (TextUtils.isEmpty(r224) == true) goto L403;
    L401:
        r1121 = r224;
    L403:
        if (TextUtils.isEmpty(r1121) == true) goto L412;
        r1116.put("value", r1121);     // Catch: JSONException -> L406
        r222.put(r223, r1116.toString());     // Catch: JSONException -> L406
        goto L412
    L389:
        if ("checker".equals(r1120) == true) goto L399;
        if ("select_img".equals(r1120) == false) goto L396;
        r224 = r1115.getParameters().getParameters().get("selected_values");     // Catch: JSONException -> L406
        if (TextUtils.isEmpty(r224) == true) goto L403;
    L396:
        r224 = r1115.getParameters().getParameters().get("initial_option");     // Catch: JSONException -> L406
        if (TextUtils.isEmpty(r224) == true) goto L403;
    L512:
        if ("input".equals(r1120) == false) goto L370;
    L380:
        String r225 = r1115.getParameters().getParameters().get("initial_value");     // Catch: JSONException -> L406
        if (r225 != null) goto L384;
    L383:
        r225 = null;
    L384:
        if (r225 == null) goto L412;
        r1116.put("value", r225);     // Catch: JSONException -> L406
        r222.put(r223, r1116.toString());     // Catch: JSONException -> L406
        goto L412
    L370:
        if ("checker".equals(r1120) == true) goto L380;
        if ("select_img".equals(r1120) == false) goto L377;
        r225 = r1115.getParameters().getParameters().get("selected_values");     // Catch: JSONException -> L406
        if (r225 == null) goto L383;
    L377:
        r225 = r1115.getParameters().getParameters().get("initial_option");     // Catch: JSONException -> L406
        if (r225 == null) goto L383;
    L406:
        e = e;
    L410:
        Log.w("ModelParserCardContent", "parseComponentStatusByActionId is exception", e);
    L408:
        e = e;
        r1117 = r214;
        r1118 = r215;
        r1119 = r1114;
        goto L410
    L413:
        long r1122 = r214;
        OPTrace r1123 = r215;
        r207.getComponentStatusByActionId().clear();
        r207.getComponentStatusByActionId().putAll(r222);
        r207.setActions(r221);
        r207.setStreamingMode(r211.streaming_mode.booleanValue());
        String r226 = r211.card_id;
        if (r226 != null) goto L416;
        r226 = "";
    L416:
        r207.setUniversalCardID(r226);
        r207.setUniversalCardVersion(r211.version);
        if (r211.streaming_config == null) goto L429;
        com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig r227 = new com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig();
        r227.setPrintStrategy(com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig.PrintStrategy.forNumber(r211.streaming_config.print_strategy.getValue()));
        UniversalCardEntity.StreamingConfig.PrintConfig r228 = r211.streaming_config.print_frequency_ms;
        if (r228 == null) goto L423;
        r227.setPrintFrequencyMs(r228.default_.intValue());
        if (r228.f253589android.intValue() <= 0) goto L423;
        r227.setPrintFrequencyMs(r228.f253589android.intValue());
    L423:
        UniversalCardEntity.StreamingConfig.PrintConfig r229 = r211.streaming_config.print_step;
        if (r229 == null) goto L428;
        r227.setPrintStep(r229.default_.intValue());
        if (r229.f253589android.intValue() <= 0) goto L428;
        r227.setPrintStep(r229.f253589android.intValue());
    L428:
        r207.setStreamingConfig(r227);
    L429:
        Integer r230 = r211.card_version;
        if (r230 != null) goto L432;
        int r231 = 1;
    L433:
        r207.setCardVersion(r231);
        CardContent.CardHeader r232 = r211.card_header;
        if (r232 == null) goto L445;
        com.ss.android.lark.chat.entity.message.content.CardContent.CardHeader r233 = new com.ss.android.lark.chat.entity.message.content.CardContent.CardHeader();
        r233.setMainTitle(r232.main_title);
        r233.setTitle(r232.title);
        r233.setStyle(r232.style);
        r233.setTheme(r232.theme);
        if (TextUtils.isEmpty(r232.subtitle) == true) goto L439;
        r233.setSubTitle(r232.subtitle);
    L439:
        if (r232.icon != null) goto L506;
    L444:
        r207.setCardHeader(r233);
        goto L445
    L506:
        r233.setIcon(com.ss.android.lark.message.card.b.a().getImageProperty(r232.icon));     // Catch: Exception -> L442
    L442:
        e = move-exception;
        Log.e("ModelParserCardContent", "parse header icon exception", e);
    L445:
        long r234 = System.currentTimeMillis() - r1122;
        String r235 = r1123.getTracingID();
        CardContent.ExtraInfo r236 = r211.extra_info;
        com.ss.android.lark.chat.entity.message.content.CardContent.ExtraInfo r237 = new com.ss.android.lark.chat.entity.message.content.CardContent.ExtraInfo();
        if (r236 == null) goto L459;
        CardContent.GadgetConfig r238 = r236.gadget_config;
        if (r238 == null) goto L450;
        r237.setGadgetPreload(r238.is_preload.booleanValue());
        r237.setGadgetAppIds(r236.gadget_config.cli_ids);
    L450:
        CardContent.CustomConfig r239 = r236.custom_config;
        if (r239 == null) goto L453;
        r237.setAnalyticsData(r239.analytics_data);
        r237.setEnableTranslate(r236.custom_config.enable_translate.booleanValue());
    L453:
        CardContent.MeegoConfig r240 = r236.meego_config;
        if (r240 == null) goto L456;
        r237.setMeegoPreload(r240.is_preload.booleanValue());
    L456:
        String r241 = r236.custom_parameter;
        if (r241 == null) goto L460;
        r237.setCustomParameter(r241);
    L460:
        r237.setParseDuration(r234);
        r237.setParseTraceId(r235);
        String r242 = UUID.randomUUID().toString();
        Log.i("ModelParserCardContent", "parseCardContent parseUUID:" + r242);
        r237.setParseUUID(r242);
        r207.setExtraInfo(r237);
        CardMessageUserLynxRenderSettings r243 = lrb.a.f510479a;
        if (com.ss.android.lark.message.card.b.a().getFgValue("lynxcard.client.render.enable") == false) goto L500;
        r207.setDslJsonString(r211.json_body);
        UniversalCardRuntimeJsLoader.b r244 = UniversalCardRuntimeJsLoader.f283220a;
        new HashMap();
        CardContent.JsonAttachment r245 = r211.json_attachment;
        if (r245 == null) goto L468;
        r207.setDslJsonAttachment(d(r245));
        if (r207.getDslJsonAttachment() == null) goto L467;
        r207.getDslJsonAttachment().getOptionUsers();
    L467:
        r207.setForward(r211.json_attachment.is_forward.booleanValue());
    L468:
        List<CardContent.Url> r246 = r211.json_card_urls;
        if (r246 == null) goto L472;
        r207.setJsonCardUrls(b(r246));
    L472:
        if (r221.size() > 0) goto L474;
        HashMap<String, String> r247 = new HashMap();
    L499:
        r207.setActionSelectValue(r247);
        goto L500
    L474:
        r247 = new HashMap();
        Iterator r248 = r221.keySet().iterator();
    L476:
        if (r248.hasNext() == false) goto L499;
        String r249 = (String) r248.next();
        CardAction r250 = (CardAction) r221.get(r249);
        if (r250 == null) goto L476;
        if (r250.getParameters() == null) goto L476;
        if (r250.getParameters().getParameters() == null) goto L476;
        String r251 = r250.getParameters().getParameters().get("initial_type");
        if ("input".equals(r251) == true) goto L496;
        if ("checker".equals(r251) == true) goto L496;
        if ("select_img".equals(r251) == true) goto L490;
        String r252 = r250.getParameters().getParameters().get("initial_option");
        if (TextUtils.isEmpty(r252) == true) goto L476;
        r247.put(r249, r252);
        goto L476
    L490:
        String r253 = r250.getParameters().getParameters().get("selected_values");
        if (TextUtils.isEmpty(r253) == true) goto L476;
        r247.put(r249, r253);
    L496:
        String r254 = r250.getParameters().getParameters().get("initial_value");
        if (TextUtils.isEmpty(r254) == true) goto L476;
        r247.put(r249, r254);
    L500:
        r207.setEnableForward(r211.enable_forward.booleanValue());
        if (r210 == null) goto L503;
        ResourceCleanScene.a r255 = ResourceCleanScene.Companion;
        Map<String, com.bytedance.lark.pb.basic.v1.ResourceCleanScene> r256 = r210.clean_resource_key_scene;
        r255.getClass();
        r207.setCleanResourceKeyScene(ResourceCleanScene.a.b(r256));
    L503:
        return r207;
    L459:
        Log.w("ModelParserCardContent", "extra Info is null");
        goto L460
    L432:
        r231 = r230.intValue();
        goto L433
    L353:
        r221 = new HashMap(y.b(r220, new b()));
        goto L354
    L349:
        r219 = com.ss.android.lark.chat.entity.message.content.CardContent.ExtraType.UNKNOWN;
        goto L350
    L332:
        if (com.ss.android.lark.message.card.b.f431903a == null) goto L334;
    L345:
        r216 = com.ss.android.lark.message.card.b.a().parseRichTextFromPbWithStyleMerge(r211.richtext, com.ss.android.lark.message.card.b.f431903a.a());
        goto L346
    L334:
        if (com.ss.android.lark.message.card.b.f431903a != null) goto L345;
        monitor-enter(com.ss.android.lark.message.card.b.class);
    L342:
        th = move-exception;
        throw th;
    L338:
        if (com.ss.android.lark.message.card.b.f431903a != null) goto L340;
        com.ss.android.lark.message.card.b.f431903a = new MessageCardStyleProvider();     // Catch: Throwable -> L342
        com.ss.android.lark.message.card.b.f431903a.c();     // Catch: Throwable -> L342
    L340:
        monitor-exit(com.ss.android.lark.message.card.b.class);     // Catch: Throwable -> L342
        goto L345
    L322:
        if (r212 == 2) goto L326;
        if (r212 == 3) goto L325;
        r213 = com.ss.android.lark.chat.entity.message.content.CardContent.Type.UNKNOWN;
        goto L328
    L325:
        r213 = com.ss.android.lark.chat.entity.message.content.CardContent.Type.VCHAT;
        goto L328
    L326:
        r213 = com.ss.android.lark.chat.entity.message.content.CardContent.Type.TEXT;
        goto L328
    L13:
        if (r103.length() == 0) goto L16;
        r104 = false;
    L21:
        r105 = false;
        goto L22
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
