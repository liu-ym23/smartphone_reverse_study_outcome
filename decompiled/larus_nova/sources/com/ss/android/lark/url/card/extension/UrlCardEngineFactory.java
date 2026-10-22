package com.ss.android.lark.url.card.extension;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.CardComponent;
import com.bytedance.lark.pb.basic.v1.CardVisitInfo;
import com.bytedance.lark.pb.basic.v1.EngineEntity;
import com.bytedance.lark.pb.basic.v1.RichTextElement;
import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
import com.facebook.keyframes.model.KFAnimation;
import com.larksuite.component.card.cardcontainer.UniversalCardRuntimeJsLoader;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.data.CardAttachment;
import com.larksuite.component.card.protocol.data.CardContent;
import com.larksuite.component.card.protocol.data.ComponentStatus;
import com.larksuite.component.card.protocol.data.action.ActionInfo;
import com.larksuite.component.card.protocol.data.action.ActionStatus;
import com.larksuite.component.card.protocol.data.at.AtProperty;
import com.larksuite.component.card.protocol.data.media.AudioInfo;
import com.larksuite.component.card.protocol.data.media.VideoInfo;
import com.larksuite.component.card.protocol.data.media.VisitInfo;
import com.larksuite.component.card.protocol.data.options.OptionUser;
import com.larksuite.component.card.protocol.data.person.Character;
import com.larksuite.component.card.utils.CardDataUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.ss.android.lark.export.engine.smartcard.SmartCardEngineProperty;
import com.ss.android.lark.export.parser.ModelParserRenderRouterEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.url.card.UrlCardProperty;
import com.ss.android.lark.url.card.c;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import vcb.d;

/* JADX INFO: loaded from: classes38.dex */
public final class UrlCardEngineFactory implements com.ss.android.lark.export.a<com.ss.android.lark.url.card.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<Boolean> f444620b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<com.ss.android.lark.url.card.a> f444621a;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f444622a = null;

        static {
            int[] r100 = new int[ModelParserRenderRouterEntity.CardEngineType.values().length];
            r100[ModelParserRenderRouterEntity.CardEngineType.UNIVERSAL_CARD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f444622a = r100;
        }
    }

    @Override // com.ss.android.lark.export.a
    public final void a() {
    }

    static {
        f444620b = LazyKt.lazy(UrlCardEngineFactory$Companion$enableMemLeakFix$2.INSTANCE);
    }

    public UrlCardEngineFactory() {
        this.f444621a = new ArrayList();
    }

    @Override // com.ss.android.lark.export.a
    public final UrlCardProperty c(CardComponent.EngineProperty r310, EngineEntity r311) {
        Intrinsics.checkNotNullParameter(r310, "pbEngineProperty");
        Intrinsics.checkNotNullParameter(r311, "pbEntity");
        UniversalCardRuntimeJsLoader.b r100 = UniversalCardRuntimeJsLoader.f283220a;
        com.ss.android.lark.url.card.b.f444611a.getClass();
        Intrinsics.checkNotNullParameter(r311, "pbEntity");
        UniversalCardEntity r101 = r311.universal_card_entity;
        CardAttachment r102 = new CardAttachment();
        UniversalCardEntity.Attachment r103 = r101.content.attachment;
        if (r103 == null) goto L134;
        CardAttachment r104 = new CardAttachment();
        if (CollectionUtils.isNotEmpty(r103.at_users) == false) goto L32;
        HashMap<String, AtProperty> r110 = new HashMap(r103.at_users.size());
        Iterator<String> r111 = r103.at_users.keySet().iterator();
    L8:
        if (r111.hasNext() == false) goto L30;
        String r105 = r111.next();
        RichTextElement.AtProperty r112 = r103.at_users.get(r105);     // Catch: Exception -> L28
        AtProperty r113 = new AtProperty();     // Catch: Exception -> L28
        if (r112 == null) goto L13;
        String r114 = r112.user_id;     // Catch: Exception -> L28
    L14:
        r113.setUserId(r114);     // Catch: Exception -> L28
        if (r112 == null) goto L17;
        String r115 = r112.content;     // Catch: Exception -> L28
    L18:
        r113.setContent(r115);     // Catch: Exception -> L28
        if (r112 != null) goto L21;
        boolean r116 = false;
    L22:
        r113.setOutChatUser(r116);     // Catch: Exception -> L28
        if (r112 != null) goto L25;
        boolean r117 = false;
    L26:
        r113.setAnonymous(r117);     // Catch: Exception -> L28
        r110.put(r105, r113);     // Catch: Exception -> L28
        goto L8
    L25:
        r117 = r112.is_anonymous.booleanValue();     // Catch: Exception -> L28
        goto L26
    L21:
        r116 = r112.is_outer.booleanValue();     // Catch: Exception -> L28
        goto L22
    L17:
        r115 = null;
        goto L18
    L13:
        r114 = null;
    L28:
        e = move-exception;
        Log.e("ModelParseCardProperty_[OPCard]", "transform AtProperty failed", e);
        goto L8
    L30:
        r104.setAtUsers(r110);
    L32:
        if (CollectionUtils.isNotEmpty(r103.images) == false) goto L43;
        HashMap<String, com.ss.android.lark.widget.richtext.RichTextElement.ImageProperty> r118 = new HashMap(r103.images.size());
        Iterator<String> r119 = r103.images.keySet().iterator();
    L35:
        if (r119.hasNext() == false) goto L41;
        String r106 = r119.next();
        r118.put(r106, com.ss.android.lark.url.card.b.b(r103.images.get(r106)));     // Catch: Exception -> L39
    L39:
        e = move-exception;
        Log.e("ModelParseCardProperty_[OPCard]", "transform ImageProperty failed", e);
        goto L35
    L41:
        r104.setImages(r118);
    L43:
        if (CollectionUtils.isNotEmpty(r103.characters) == false) goto L51;
        HashMap<String, OptionUser> r107 = new HashMap(r103.characters.size());
        Iterator<String> r108 = r103.characters.keySet().iterator();
    L46:
        if (r108.hasNext() == false) goto L50;
        String r120 = r108.next();
        UniversalCardEntity.Character r121 = r103.characters.get(r120);
        if (r121 == null) goto L46;
        r107.put(r120, new OptionUser(r121.f253587id, r121.content, r121.avatar_key));
        goto L46
    L50:
        r104.setOptionUsers(r107);
    L51:
        UniversalCardEntity.SummaryContent r109 = r103.summary;
        if (r109 == null) goto L93;
        List<UniversalCardEntity.SummaryContent.Item> r122 = r109.items;
        if (r122 == null) goto L93;
        StringBuilder r123 = new StringBuilder();
        Iterator<UniversalCardEntity.SummaryContent.Item> r124 = r122.iterator();
    L57:
        if (r124.hasNext() == false) goto L91;
        UniversalCardEntity.SummaryContent.Item r125 = r124.next();
        if (r125 == null) goto L57;
        if (TextUtils.isEmpty(r125.text) == false) goto L62;
        if (r125.image != null) goto L65;
        if (r125.at_user != null) goto L68;
        UniversalCardEntity.SummaryContent.Item.Emotion r126 = r125.emotion;
        if (r126 == null) goto L74;
        if (TextUtils.isEmpty(r126.key) == true) goto L74;
        r123.append(EmojiHandler.e(r125.emotion.key));
    L74:
        UniversalCardEntity.SummaryContent.Item.CharacterList r127 = r125.person_list;
        if (r127 == null) goto L57;
        if (CollectionUtils.isNotEmpty(r127.characters) == false) goto L57;
        StringBuilder r128 = new StringBuilder();
        Iterator<UniversalCardEntity.Character> r129 = r125.person_list.characters.iterator();
    L80:
        if (r129.hasNext() == false) goto L90;
        UniversalCardEntity.Character r130 = r129.next();
        if (TextUtils.isEmpty(r130.content) == true) goto L80;
        if (r128.length() <= 0) goto L86;
        boolean r131 = true;
    L87:
        if (r131 == false) goto L89;
        r128.append(UIHelper.getString(R.string.Lark_SmartCard_Comma));
    L89:
        r128.append(r130.content);
        goto L80
    L86:
        r131 = false;
        goto L87
    L90:
        r123.append(r128.toString());
        goto L57
    L68:
        r123.append("@");
        r123.append(r125.at_user.content);
        goto L57
    L65:
        r123.append(UIHelper.getString(R.string.Lark_Legacy_ImageSummarize));
        goto L57
    L62:
        r123.append(r125.text);
        goto L57
    L91:
        r104.setSummary(r123.toString());
    L93:
        if (CollectionUtils.isNotEmpty(r103.characters) == false) goto L104;
        r104.setCharacters(new HashMap());
        HashMap r132 = new HashMap(r103.characters.size());
        Iterator<String> r133 = r103.characters.keySet().iterator();
    L96:
        if (r133.hasNext() == false) goto L100;
        String r134 = r133.next();
        UniversalCardEntity.Character r135 = r103.characters.get(r134);
        if (r135 == null) goto L96;
        r132.put(r134, new Character(Integer.valueOf(r135.type.getValue()), r135.f253587id, r135.content, r135.avatar_key));
        goto L96
    L100:
        HashMap<String, Character> r136 = r104.getCharacters();
        if (r136 == null) goto L104;
        r136.putAll(r132);
    L104:
        if (CollectionUtils.isNotEmpty(r103.audios) == false) goto L119;
        r104.setAudios(new HashMap());
        HashMap r137 = new HashMap();
        Iterator<String> r138 = r103.audios.keySet().iterator();
    L107:
        if (r138.hasNext() == false) goto L115;
        String r139 = r138.next();
        UniversalCardEntity.AudioInfo r140 = r103.audios.get(r139);
        if (r140 == null) goto L107;
        CardVisitInfo r141 = r140.visit_info;
        if (r141 == null) goto L113;
        VisitInfo r210 = new VisitInfo(r141.scene_type.getValue(), r141.entity_type.getValue(), r141.entity_id, r141.inner_msg_id.longValue(), r141.auth_file_key, new HashMap(r141.im_ext), new HashMap(r141.ext));
    L114:
        r137.put(r139, new AudioInfo(r140.key, r140.duration.intValue(), r140.size.longValue(), r210));
        goto L107
    L113:
        r210 = null;
        goto L114
    L115:
        HashMap<String, AudioInfo> r142 = r104.getAudios();
        if (r142 == null) goto L119;
        r142.putAll(r137);
    L119:
        if (CollectionUtils.isNotEmpty(r103.videos) == false) goto L133;
        r104.setVideos(new HashMap());
        HashMap r143 = new HashMap();
        Iterator<String> r144 = r103.videos.keySet().iterator();
    L122:
        if (r144.hasNext() == false) goto L130;
        String r145 = r144.next();
        UniversalCardEntity.VideoInfo r146 = r103.videos.get(r145);
        if (r146 == null) goto L122;
        CardVisitInfo r147 = r146.visit_info;
        if (r147 == null) goto L128;
        VisitInfo r211 = new VisitInfo(r147.scene_type.getValue(), r147.entity_type.getValue(), r147.entity_id, r147.inner_msg_id.longValue(), r147.auth_file_key, new HashMap(r147.im_ext), new HashMap(r147.ext));
    L129:
        r143.put(r145, new VideoInfo(r146.key, r146.duration.intValue(), r146.size.longValue(), r146.url, r146.mime, r211));
        r103 = r103;
        r144 = r144;
        goto L122
    L128:
        r211 = null;
        goto L129
    L130:
        HashMap<String, VideoInfo> r148 = r104.getVideos();
        if (r148 == null) goto L133;
        r148.putAll(r143);
    L133:
        r102 = r104;
    L134:
        CardContent r149 = new CardContent(r101.content.card, r102);
        Boolean r150 = r101.streaming_mode;
        CardData.a.C3904a r151 = new CardData.a.C3904a();
        String r152 = r101.card_id;
        Intrinsics.checkNotNullParameter(r152, "cardID");
        r151.f283876a = r152;
        r151.f283877b = r101.card_id;
        String r153 = r101.version;
        r151.f283878c = r153;
        r151.f283879d = r153;
        r151.f283880e = r149;
        r151.f283881f = null;
        r151.f283883h = null;
        r151.f283882g = new ComponentStatus(r101.local_extra.get(Integer.valueOf(UniversalCardEntity.LocalExtraKey.OPEN_PLATFORM_MESSAGE_CARD.getValue())));
        Intrinsics.checkNotNull(r150);
        r151.f283885j = r150.booleanValue();
        CardDataUtils.f283938a.getClass();
        r151.f283886k = CardDataUtils.k(r101);
        HashMap r154 = new HashMap();
        UniversalCardEntity.ActionStatus r155 = r101.action_status;
        if (r155 == null) goto L139;
        Map<String, String> r156 = r155.component_status_by_action_id;
        if (r156 == null) goto L139;
        r154.putAll(r156);
    L139:
        UniversalCardEntity.ActionStatus r157 = r101.action_status;
        if (r157 == null) goto L142;
        Map<String, String> r158 = r157.component_status_by_name;
    L143:
        ActionStatus r159 = new ActionStatus(r158, r154);
        UniversalCardEntity.Attachment r160 = r101.content.attachment;
        if (r160 == null) goto L148;
        Boolean r161 = r160.ignore_at_remind;
        if (r161 == null) goto L148;
        boolean r162 = !r161.booleanValue();
    L149:
        r151.f283884i = new ActionInfo(r159, r162, false, LarkContext.getApplication().getString(R.string.Lark_Legacy_forwardCardToast), r101.source_type.intValue(), r101.source_id);
        return new UrlCardProperty(r151.a(), r311.universal_card_entity);
    L148:
        r162 = true;
        goto L149
    L142:
        r158 = null;
        goto L143
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.export.a
    public final c b(SmartCardEngineProperty r100, TCStyle r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r102, "dependency");
        c r103 = null;
        Object[] r104 = 0;
        Object[] r105 = 0;
        Object[] r106 = 0;
        if ((r100 instanceof UrlCardProperty) == false) goto L5;
        SmartCardEngineProperty r107 = r100;
    L6:
        ModelParserRenderRouterEntity.CardEngineType r108 = r107.getEngineType();
        if (b.f444622a[r108.ordinal()] != 1) goto L11;
        r103 = new c((UrlCardProperty) r100, r101, r102);
        if (f444620b.getValue().booleanValue() == true) goto L11;
        this.f444621a.add(r103);
    L11:
        return r103;
    L5:
        Object[] r109 = r106 == true ? 1 : 0;
        Object[] r110 = r105 == true ? 1 : 0;
        r107 = new SmartCardEngineProperty(r109, r110, 3, r104 == true ? 1 : 0);
        goto L6
    }
}
