package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.TranslateUrlPreviewContext;
import com.bytedance.lark.pb.im.v1.PushMessageReadStates;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.api.service.impl.h2;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.ShareGroupChatContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.preview.entity.component.property.PreviewHeaderProperty;
import com.ss.android.lark.chat.preview.entity.component.property.TextViewProperty;
import com.ss.android.lark.export.entity.ExtTranslateInfo;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponent;
import com.ss.android.lark.export.entity.preview.UrlPreviewState;
import com.ss.android.lark.export.entity.preview.UrlPreviewTemplate;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w4b.d0 f416678a = null;

    static {
        f416678a = ChatCoreModule.a().getSettingDependency();
    }

    public static String d(f5b.b r100) {
        if (r100 != null) goto L6;
        Log.w("MessageInfoUtils", "getMessageTranslateCacheKey message is null");
        return "";
    L6:
        Message r101 = r100.getMessage();
        if (r101 == null) goto L22;
        Message.Type r102 = r101.getType();
        Message.Type r103 = Message.Type.AUDIO;
        if (r102 != r103) goto L22;
        if (r101.getType() != r103) goto L17;
        AudioContent r104 = (AudioContent) r101.getContent();
        if (r104.isNeedHideText() == true) goto L17;
        if (TextUtils.isEmpty(r104.getRecognizedText()) == true) goto L17;
        boolean r105 = true;
    L18:
        if (r105 == true) goto L22;
        Log.w("MessageInfoUtils", "audio message text not shown, translateCacheKey is null");
        return "";
    L17:
        r105 = false;
    L22:
        return r100.getId() + "_" + r101.getContentVersion();
    }

    public static String e(Message r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (r100.getType() != Message.Type.SHARE_GROUP_CHAT) goto L13;
        ShareGroupChatContent r101 = (ShareGroupChatContent) r100.getContent();
        if (r101 != null) goto L10;
        return "";
    L10:
        if (r101.getChat() != null) goto L12;
        return "";
    L12:
        return UIHelper.mustacheFormat(R.string.Lark_Legacy_ShareGroupChatForwardFormat, "chat_name", r101.getChat().getName());
    L13:
        return "";
    }

    public static Message f(MessageInfo r100) {
        Message r101 = r100.getMessage();
        if (r101 != null) goto L5;
        return r101;
    L5:
        TranslateInfo r102 = r100.getTranslateInfo();
        if (r102 != null) goto L8;
        return null;
    L8:
        if (Objects.equals(r101.getTranslateLanguage(), r102.getLanguage()) == true) goto L10;
        return null;
    L10:
        if (r102.getTranslateContent() == null) goto L18;
        Message r103 = r101.clone();
        if (r103 == null) goto L19;
        r103.setMessageContent(r102.getTranslateContent());
        return r103;
    L19:
        return null;
    L18:
        return null;
    }

    public static boolean j(Message r100) {
        if (ChatCoreModule.a().getFeatureConfigDependency().b() == true) goto L6;
        return false;
    L6:
        if (r100.getType() == Message.Type.AUDIO) goto L9;
        return false;
    L9:
        if ((r100.getContent() instanceof AudioContent) == false) goto L23;
        AudioContent r101 = (AudioContent) r100.getContent();
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("ai.translate.message.audio") == true) goto L13;
        return false;
    L13:
        if (r101 != null) goto L15;
    L19:
        boolean r102 = false;
    L20:
        if (r102 == false) goto L25;
        return true;
    L25:
        return false;
    L15:
        if (r101.isNeedHideText() == true) goto L19;
        if (TextUtils.isEmpty(r101.getRecognizedText()) == true) goto L19;
        r102 = true;
        goto L20
    L23:
        return false;
    }

    public static boolean k(Message r100) {
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("messagecard.translate.support") == true) goto L5;
        return false;
    L5:
        boolean r101 = ChatCoreModule.a().getFeatureGatingDependency().isEnable("messagecard.translate.force_enable_translate");
        if (r100.getType() == Message.Type.CARD) goto L9;
        return false;
    L9:
        if ((r100.getContent() instanceof CardContent) == false) goto L24;
        CardContent r102 = (CardContent) r100.getContent();
        if (r102.getExtraInfo() != null) goto L13;
    L14:
        if (r101 == true) goto L17;
        return false;
    L17:
        if (r102.getType() == CardContent.Type.TEXT) goto L20;
        return false;
    L20:
        if (r102.getCardVersion() >= 2) goto L22;
        return false;
    L22:
        return true;
    L13:
        if (r102.getExtraInfo().getEnableTranslate() == true) goto L17;
    L24:
        return false;
    }

    public static boolean m(Message r100) {
        if (r100.getTranslateDisplayRule() != 1) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r100.getType() != Message.Type.CARD) goto L14;
        if (k(r100) == false) goto L18;
        return r101;
    L18:
        if (r101 == true) goto L20;
        return false;
    L20:
        if (TextUtils.isEmpty(r100.getTranslateLanguage()) == true) goto L24;
        return true;
    L24:
        return false;
    L14:
        if (r100.getType() != Message.Type.AUDIO) goto L18;
        if (j(r100) == false) goto L18;
        return r101;
    L5:
        if (r100.getTranslateDisplayRule() == 0) goto L7;
        r101 = true;
        goto L9
    }

    public static boolean n(f5b.b r100) {
        int r101 = r100.getMessage().getTranslateDisplayRule();
        String r102 = r100.getMessage().getTranslateLanguage();
        TranslateInfo r103 = r100.getTranslateInfo();
        if (r101 == 1) goto L9;
        if (r101 == 0) goto L9;
        if (TextUtils.isEmpty(r102) == true) goto L9;
        if (r103 == null) goto L9;
        return true;
    L9:
        return false;
    }

    public static Map<String, PreviewHangPoint> p(Map<String, PreviewHangPoint> r110) {
        HashMap r100 = new HashMap();
        Iterator<Map.Entry<String, PreviewHangPoint>> r111 = r110.entrySet().iterator();
    L4:
        if (r111.hasNext() == false) goto L10;
        PreviewHangPoint r101 = r111.next().getValue();
        if (r101 == null) goto L4;
        if (r101.getUrlCardPreviewEntity() == null) goto L4;
        UrlCardPreviewEntity r102 = r101.getUrlCardPreviewEntity();
        UrlInlinePreviewEntity r103 = r102.getInlineEntity();
        UrlCardPreviewEntity r112 = new UrlCardPreviewEntity(new UrlInlinePreviewEntity.Builder().sourceId(r103.getSourceId()).previewId(r103.getPreviewId()).netIconKey(r103.getNetIconKey()).title(r103.getTitle()).netUrlTag(r103.getNetUrlTag()).version(r103.getVersion()).udIcon(r103.getUdIcon()).needReload(r103.getNeedReload()).isSdkPreview(r103.isSdkPreview()).passThroughImage(r103.getPassThroughImage()).useColorIcon(r103.getUseColorIcon()).headerInfo(r103.getHeaderInfo()).build(), null, null, r102.getComponentTreeTime());
        r100.put(r101.getHangPointId(), new PreviewHangPoint(r101.getUrl(), r101.getHangPointId(), r101.getMessageId(), r101.getPreviewId(), r101.getNeedLocalPreview(), r101.isLazyLoad(), r101.getSendScene(), r112));
        goto L4
    L10:
        return r100;
    }

    public static boolean c(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L9:
        Log.e("MessageInfoUtils", "chat id is not match: current chat id is: " + r100 + ", push chat id is: " + r101);
        return false;
    L5:
        if (r100.equals(r101) == false) goto L9;
        return true;
    }

    public static void h(Content r100, Map<String, PreviewHangPoint> r101) {
        if (r100 == null) goto L41;
        if (r101 == null) goto L45;
        boolean r102 = r100 instanceof TextContent;
        if (r102 == false) goto L8;
    L24:
        if (r102 == false) goto L27;
        com.ss.android.lark.parser.internal.r.x(((TextContent) r100).getRichText(), r101);
        return;
    L27:
        if ((r100 instanceof PostContent) == false) goto L44;
        com.ss.android.lark.parser.internal.r.x(((PostContent) r100).getRichText(), r101);
        return;
    L44:
        return;
    L8:
        if ((r100 instanceof PostContent) == true) goto L24;
        if ((r100 instanceof MergeForwardContent) == false) goto L42;
        Iterator<Message> r103 = ((MergeForwardContent) r100).getMessages().iterator();
    L14:
        if (r103.hasNext() == false) goto L46;
        Content r104 = r103.next().getContent();
        boolean r105 = r104 instanceof TextContent;
        if (r105 == true) goto L19;
        if ((r104 instanceof PostContent) == false) goto L14;
    L19:
        if (r105 == true) goto L20;
        if ((r104 instanceof PostContent) == false) goto L14;
        com.ss.android.lark.parser.internal.r.x(((PostContent) r104).getRichText(), r101);
        goto L14
    L20:
        com.ss.android.lark.parser.internal.r.x(((TextContent) r104).getRichText(), r101);
        goto L14
    L46:
        return;
    L42:
        return;
    L45:
        return;
    }

    public static boolean l(Content r100, String r101) {
        if ((r100 instanceof BaseTextContent) == false) goto L13;
        RichText r102 = ((BaseTextContent) r100).getRichText();
        if (r102 == null) goto L13;
        RichTextElement r103 = r102.getElements().getDictionary().get(r101);
        if (r103 != null) goto L9;
        return false;
    L9:
        RichTextElement.RichTextProperty r104 = r103.getProperty();
        if ((r104 instanceof RichTextElement.AnchorProperty) == false) goto L13;
        return ((RichTextElement.AnchorProperty) r104).isCustom();
    L13:
        return false;
    }

    public static boolean a(Content r110, Map<String, PreviewHangPoint> r111, String r112) {
        if ((r110 instanceof TextContent) == false) goto L5;
    L6:
        Iterator<PreviewHangPoint> r113 = r111.values().iterator();
    L8:
        if (r113.hasNext() == false) goto L110;
        PreviewHangPoint r100 = r113.next();
        if (r100 == null) goto L8;
        boolean r101 = l(r110, r100.getHangPointId());
        UrlCardPreviewEntity r102 = r100.getUrlCardPreviewEntity();
        if (r101 == true) goto L8;
        if (r102 == null) goto L8;
        PreviewHangPoint r103 = h2.f411600a.get(Integer.valueOf(h2.a(r100, r112)));
        if (r103 == null) goto L67;
        HashMap r104 = new HashMap();
        r104.put(r103.getHangPointId(), r103);
        h(r110, r104);
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("im.messenger.url_card_header_translate") == false) goto L8;
        UrlCardPreviewEntity r105 = r103.getUrlCardPreviewEntity();
        if (r105 == null) goto L23;
        String r106 = r105.getInlineEntity().getTitle();
        if (r106 == null) goto L26;
        Log.w("MessageInfoUtils", "apply translate " + r102.getInlineEntity().getPreviewId());
        int r107 = h6b.h.f483953a;
        Intrinsics.checkNotNullParameter(r102, "urlCardPreviewEntity");
        Intrinsics.checkNotNullParameter(r106, "inlineTranslation");
        ExtTranslateInfo r108 = r102.getExtTranslateInfo();
        if (r108 == null) goto L8;
        String r109 = r108.getInlineReplacementElementId();
        if (r109 == null) goto L8;
        UrlPreviewBody r114 = r102.getPreviewBody();
        if (r114 == null) goto L8;
        Map<String, UrlPreviewState> r115 = r114.getStates();
        TextViewProperty r116 = null;
        PreviewHeaderProperty r117 = null;
        if (r115 == null) goto L38;
        UrlPreviewState r118 = r115.get(r114.getCurrentStateId());
    L39:
        HashMap<String, UrlPreviewTemplate> r119 = r114.getTemplates();
        if (r118 == null) goto L42;
        String r120 = r118.getTemplateId();
    L43:
        UrlPreviewTemplate r121 = r119.get(r120);
        if (r121 == null) goto L8;
        Map<String, UrlPreviewComponent> r122 = r121.getElements();
        if (r122 == null) goto L66;
        UrlPreviewComponent r123 = r122.get(r109);
        if (r123 == null) goto L66;
        int r124 = h6b.h.a.f483954a[r123.getType().ordinal()];
        if (r124 != 1) goto L54;
        Log.i("UrlPreviewTranslateUtil", "apply translate to type: " + r123.getType() + ", id: " + r109 + ", previewId: " + r102.getInlineEntity().getPreviewId());
        BaseProperty r125 = r123.getProperty();
        if ((r125 instanceof PreviewHeaderProperty) == false) goto L64;
        r117 = (PreviewHeaderProperty) r125;
    L64:
        if (r117 == null) goto L8;
        r117.setTitle(r106);
        goto L8
    L54:
        if (r124 != 2) goto L55;
        Log.i("UrlPreviewTranslateUtil", "apply translate to type: " + r123.getType() + ", id: " + r109 + ", previewId: " + r102.getInlineEntity().getPreviewId());
        BaseProperty r126 = r123.getProperty();
        if ((r126 instanceof TextViewProperty) == false) goto L59;
        r116 = (TextViewProperty) r126;
    L59:
        if (r116 == null) goto L8;
        r116.setText(r106);
        goto L8
    L55:
        Log.w("UrlPreviewTranslateUtil", "element type not supported: " + r123.getType() + ", id: " + r109 + ", previewId: " + r102.getInlineEntity().getPreviewId());
    L66:
        Log.w("UrlPreviewTranslateUtil", "element not found, id: " + r109 + ", previewId: " + r102.getInlineEntity().getPreviewId());
        goto L8
    L42:
        r120 = null;
        goto L43
    L38:
        r118 = null;
        goto L39
    L26:
        Log.w("MessageInfoUtils", "translated title not found " + r103.getPreviewId());
        goto L8
    L23:
        Log.w("MessageInfoUtils", "translated entity not found " + r103.getPreviewId());
        goto L8
    L67:
        return true;
    L110:
        return false;
    L5:
        if ((r110 instanceof PostContent) == true) goto L6;
        return false;
    }

    public static void o(String r100, PushMessageReadStates r101, aqb.h r102) {
        if (c(r100, r101.chat_id) == true) goto L5;
        return;
    L5:
        Map<String, PushMessageReadStates.ReadStates> r103 = r101.read_states;
        Map<String, PushMessageReadStates.ReadStatesExtra> r104 = r101.read_states_extra;
        HashSet r105 = new HashSet();
        if (CollectionUtils.isNotEmpty(r103) == false) goto L9;
        r105.addAll(r103.keySet());
    L9:
        if (CollectionUtils.isNotEmpty(r104) == false) goto L11;
        r105.addAll(r104.keySet());
    L11:
        Iterator r106 = r105.iterator();
    L13:
        if (r106.hasNext() == false) goto L30;
        String r107 = (String) r106.next();
        Log.i("MessageInfoUtils", "onPushReadStateMessage: " + r107);
        MessageInfo r108 = r102.p(r107);
        if (r108 != null) goto L16;
        Log.i("MessageInfoUtils", "onPushReadStateMessage: message not found!");
        goto L13
    L16:
        if (r103 != null) goto L18;
    L20:
        if (r104 != null) goto L22;
    L28:
        r102.q(r108);
        goto L13
    L22:
        if (r104.get(r107) == null) goto L28;
        PushMessageReadStates.ReadStatesExtra r109 = r104.get(r107);
        Message r110 = r108.getMessage();
        if (r109.me_read.booleanValue() == false) goto L26;
        int r111 = 2;
    L27:
        r110.setMeReadType(r111);
        Log.i("MessageInfoUtils", "onPushReadStateMessage, ReadStatesExtra, " + r107);
        goto L28
    L26:
        r111 = 0;
        goto L27
    L18:
        if (r103.get(r107) == null) goto L20;
        PushMessageReadStates.ReadStates r112 = r103.get(r107);
        r108.getMessage().setReadCount(r112.read_count.intValue());
        r108.getMessage().setUnReadCount(r112.unread_count.intValue());
        r108.getMessage().setReadAtChatterIds(r112.read_at_chatter_ids);
        Log.i("MessageInfoUtils", "onPushReadStateMessage, ReadStates, " + r107);
        goto L20
    }

    public static void b(Map<String, PreviewHangPoint> r100, String r101, Map<String, TranslateUrlPreviewContext> r102, Message r103) {
        Iterator<Map.Entry<String, PreviewHangPoint>> r104 = r100.entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L9;
        PreviewHangPoint r105 = r104.next().getValue();
        String r106 = r105.getHangPointId();
        boolean r107 = l(r103.getContent(), r106);
        UrlCardPreviewEntity r108 = r105.getUrlCardPreviewEntity();
        if (r107 == true) goto L4;
        if (r108 == null) goto L4;
        UrlInlinePreviewEntity r109 = r108.getInlineEntity();
        TranslateUrlPreviewContext r110 = new TranslateUrlPreviewContext.Builder().preview_id(r109.getPreviewId()).title(r109.getTitle()).tag(r109.getNetUrlTag()).target_language(r101).is_sdk_preview(Boolean.valueOf(r109.isSdkPreview())).build();
        ((HashMap) r102).put(r106, r110);
        goto L4
    }

    public static void g(Map<String, f5b.b> r100, String r101, Map<String, TranslateUrlPreviewContext> r102, Map<String, Map<String, PreviewHangPoint>> r103) {
        Iterator<Map.Entry<String, f5b.b>> r104 = r100.entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L21;
        f5b.b r105 = r104.next().getValue();
        Message.Type r106 = r105.getMessage().getType();
        if (r106 == Message.Type.TEXT) goto L20;
        if (r106 == Message.Type.POST) goto L20;
        if (r106 != Message.Type.MERGE_FORWARD) goto L4;
        Iterator<Message> r107 = ((MergeForwardContent) r105.getMessage().getContent()).getMessages().iterator();
    L14:
        if (r107.hasNext() == false) goto L4;
        Message r108 = r107.next();
        if (r108.getType() == Message.Type.TEXT) goto L19;
        if (r108.getType() != Message.Type.POST) goto L14;
    L19:
        i(r108.getContent(), r103, r108, r101, r102);
    L20:
        i(r105.getMessage().getContent(), r103, r105.getMessage(), r101, r102);
        goto L4
    }

    public static void i(Content r100, Map<String, Map<String, PreviewHangPoint>> r101, Message r102, String r103, Map<String, TranslateUrlPreviewContext> r104) {
        if ((r100 instanceof TextContent) == false) goto L8;
        Map<String, PreviewHangPoint> r105 = ((TextContent) r100).getPreviewHangPoints();
        if (CollectionUtils.isEmpty(r105) == true) goto L13;
        HashMap r106 = (HashMap) r101;
        r106.put(r102.getId(), p(r105));
        b(r105, r103, r104, r102);
        return;
    L13:
        return;
    L8:
        if ((r100 instanceof PostContent) == false) goto L15;
        Map<String, PreviewHangPoint> r107 = ((PostContent) r100).getPreviewHangPoints();
        if (CollectionUtils.isEmpty(r107) == true) goto L16;
        HashMap r108 = (HashMap) r101;
        r108.put(r102.getId(), p(r107));
        b(r107, r103, r104, r102);
        return;
    L16:
        return;
    }
}
