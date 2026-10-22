package com.ss.android.lark.chat.entity.message.content;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONType;
import com.alipay.sdk.m.x.d;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.message.CardAction;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.i;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0010\u009a\u0001\u009b\u0001\u009c\u0001\u009d\u0001\u009e\u0001\u009f\u0001 \u0001¡\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u008d\u0001\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0085\u0001j\u000b\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0086\u0001H\u0002J\u001b\u0010\u008e\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00180\u0085\u0001j\t\u0012\u0004\u0012\u00020\u0018`\u0086\u0001H\u0002J\u0007\u0010\u0093\u0001\u001a\u00020=J\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0090\u0001J\u0014\u0010\u0095\u0001\u001a\u00020=2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0001H\u0016J\u0014\u0010\u0097\u0001\u001a\u00020=2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\u0098\u0001\u001a\u00030\u0099\u00012\u0006\u0010~\u001a\u00020\u0018R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010B\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010G\u001a\u0004\u0018\u00010HX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001a\u0010M\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010-\"\u0004\bO\u0010/R\u001a\u0010P\u001a\u00020=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010?\"\u0004\bQ\u0010AR:\u0010R\u001a\"\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00180Sj\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0018`TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010Y\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010D\"\u0004\b[\u0010FR\u001c\u0010\\\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010D\"\u0004\b^\u0010FR:\u0010_\u001a\"\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00180Sj\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0018`TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010V\"\u0004\ba\u0010XR\u001c\u0010b\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010D\"\u0004\bd\u0010FR\u001c\u0010e\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010D\"\u0004\bg\u0010FR\u001c\u0010h\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010D\"\u0004\bj\u0010FR\u001c\u0010k\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010D\"\u0004\bm\u0010FR\u001a\u0010n\u001a\u00020=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010?\"\u0004\bo\u0010AR\u001c\u0010p\u001a\u0004\u0018\u00010qX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u001e\u0010v\u001a\u0004\u0018\u00010=X\u0086\u000e¢\u0006\u0010\n\u0002\u0010z\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001c\u0010{\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010D\"\u0004\b}\u0010FR\u0011\u0010~\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u007f\u0010DR\u0015\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00188F¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010DR\u0013\u0010\u0082\u0001\u001a\u00020\u00188F¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010DR*\u0010\u0084\u0001\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0085\u0001j\u000b\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0086\u00018F¢\u0006\b\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R5\u0010\u0089\u0001\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0085\u0001j\u000b\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0086\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u0088\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R;\u0010\u008f\u0001\u001a \u0012\u0004\u0012\u00020\u0018\u0012\u0005\u0012\u00030\u0090\u00010Sj\u000f\u0012\u0004\u0012\u00020\u0018\u0012\u0005\u0012\u00030\u0090\u0001`TX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010V\"\u0005\b\u0092\u0001\u0010X¨\u0006¢\u0001"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/CardContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "<init>", "()V", "type", "Lcom/ss/android/lark/chat/entity/message/content/CardContent$Type;", "getType", "()Lcom/ss/android/lark/chat/entity/message/content/CardContent$Type;", "setType", "(Lcom/ss/android/lark/chat/entity/message/content/CardContent$Type;)V", "extraType", "Lcom/ss/android/lark/chat/entity/message/content/CardContent$ExtraType;", "getExtraType", "()Lcom/ss/android/lark/chat/entity/message/content/CardContent$ExtraType;", "setExtraType", "(Lcom/ss/android/lark/chat/entity/message/content/CardContent$ExtraType;)V", "richText", "Lcom/ss/android/lark/widget/richtext/RichText;", "getRichText", "()Lcom/ss/android/lark/widget/richtext/RichText;", "setRichText", "(Lcom/ss/android/lark/widget/richtext/RichText;)V", SlcCommonAction.KEY_ACTIONS, "", "", "Lcom/ss/android/lark/chat/entity/message/CardAction;", "getActions", "()Ljava/util/Map;", "setActions", "(Ljava/util/Map;)V", "widthMode", "Lcom/ss/android/lark/chat/entity/message/content/CardContent$WidthMode;", "getWidthMode", "()Lcom/ss/android/lark/chat/entity/message/content/CardContent$WidthMode;", "setWidthMode", "(Lcom/ss/android/lark/chat/entity/message/content/CardContent$WidthMode;)V", "dataSource", "Lcom/ss/android/lark/chat/entity/message/content/CardContent$DataSource;", "getDataSource", "()Lcom/ss/android/lark/chat/entity/message/content/CardContent$DataSource;", "setDataSource", "(Lcom/ss/android/lark/chat/entity/message/content/CardContent$DataSource;)V", "cardVersion", "", "getCardVersion", "()I", "setCardVersion", "(I)V", "cardHeader", "Lcom/ss/android/lark/chat/entity/message/content/CardContent$CardHeader;", "getCardHeader", "()Lcom/ss/android/lark/chat/entity/message/content/CardContent$CardHeader;", "setCardHeader", "(Lcom/ss/android/lark/chat/entity/message/content/CardContent$CardHeader;)V", "extraInfo", "Lcom/ss/android/lark/chat/entity/message/content/CardContent$ExtraInfo;", "getExtraInfo", "()Lcom/ss/android/lark/chat/entity/message/content/CardContent$ExtraInfo;", "setExtraInfo", "(Lcom/ss/android/lark/chat/entity/message/content/CardContent$ExtraInfo;)V", "enableForward", "", "getEnableForward", "()Z", "setEnableForward", "(Z)V", "dslJsonString", "getDslJsonString", "()Ljava/lang/String;", "setDslJsonString", "(Ljava/lang/String;)V", "dslJsonAttachment", "Lcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment;", "getDslJsonAttachment", "()Lcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment;", "setDslJsonAttachment", "(Lcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment;)V", "contentVersion", "getContentVersion", "setContentVersion", "isForward", "setForward", "actionSelectValue", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getActionSelectValue", "()Ljava/util/HashMap;", "setActionSelectValue", "(Ljava/util/HashMap;)V", "messageId", "getMessageId", "setMessageId", "lynxDigest", "getLynxDigest", "setLynxDigest", "componentStatusByActionId", "getComponentStatusByActionId", "setComponentStatusByActionId", "sendCardBotId", "getSendCardBotId", "setSendCardBotId", "sendAppId", "getSendAppId", "setSendAppId", "universalCardID", "getUniversalCardID", "setUniversalCardID", "universalCardVersion", "getUniversalCardVersion", "setUniversalCardVersion", "isStreamingMode", "setStreamingMode", "streamingConfig", "Lcom/ss/android/lark/chat/entity/message/content/CardContent$StreamingConfig;", "getStreamingConfig", "()Lcom/ss/android/lark/chat/entity/message/content/CardContent$StreamingConfig;", "setStreamingConfig", "(Lcom/ss/android/lark/chat/entity/message/content/CardContent$StreamingConfig;)V", "isTranslate", "()Ljava/lang/Boolean;", "setTranslate", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "hostCardId", "getHostCardId", "setHostCardId", "digest", "getDigest", "lynxSimpleDigest", "getLynxSimpleDigest", "cardDetailDigest", "getCardDetailDigest", "cardUrls", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getCardUrls", "()Ljava/util/HashSet;", "jsonCardUrls", "getJsonCardUrls", "setJsonCardUrls", "(Ljava/util/HashSet;)V", "getCardUrlsCompact", "getRichTextCardUrls", "cleanResourceKeyScene", "Lcom/ss/android/lark/image/entity/ResourceCleanScene;", "getCleanResourceKeyScene", "setCleanResourceKeyScene", "resourceIsCleaned", "firstResourceScene", "isItemSame", "diffable", "isContentSame", "setTranslateMsgCardSummary", "", "WidthMode", "DataSource", "Type", "ExtraType", "CardHeader", "ExtraInfo", "JsonAttachment", "StreamingConfig", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JSONType(typeName = "CardContent")
public final class CardContent extends Content {
    private HashMap<String, String> actionSelectValue;
    private Map<String, ? extends CardAction> actions;
    private CardHeader cardHeader;
    private int cardVersion;
    private HashMap<String, ResourceCleanScene> cleanResourceKeyScene;
    private HashMap<String, String> componentStatusByActionId;
    private int contentVersion;
    private DataSource dataSource;
    private JsonAttachment dslJsonAttachment;
    private String dslJsonString;
    private boolean enableForward;
    private ExtraInfo extraInfo;
    private ExtraType extraType;
    private String hostCardId;
    private boolean isForward;
    private boolean isStreamingMode;
    private Boolean isTranslate;
    private HashSet<String> jsonCardUrls;
    private String lynxDigest;
    private String messageId;
    private RichText richText;
    private String sendAppId;
    private String sendCardBotId;
    private StreamingConfig streamingConfig;
    private Type type;
    private String universalCardID;
    private String universalCardVersion;
    private WidthMode widthMode;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006%"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/CardContent$CardHeader;", "Ljava/io/Serializable;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "mainTitle", "getMainTitle", "setMainTitle", "theme", "getTheme", "setTheme", "subTitle", "getSubTitle", "setSubTitle", "style", "", "getStyle", "()Ljava/util/Map;", "setStyle", "(Ljava/util/Map;)V", "icon", "Lcom/ss/android/lark/widget/richtext/RichTextElement$ImageProperty;", "getIcon", "()Lcom/ss/android/lark/widget/richtext/RichTextElement$ImageProperty;", "setIcon", "(Lcom/ss/android/lark/widget/richtext/RichTextElement$ImageProperty;)V", "equals", "", "o", "", "hashCode", "", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CardHeader implements Serializable {
        private RichTextElement.ImageProperty icon;
        private String mainTitle;
        private Map<String, String> style;
        private String subTitle;
        private String theme;
        private String title;

        public CardHeader() {
        }

        public int hashCode() {
            String r100 = this.mainTitle;
            int r101 = 0;
            if (r100 == null) goto L5;
            Intrinsics.checkNotNull(r100);
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.subTitle;
            if (r104 == null) goto L10;
            if (r104 == null) goto L10;
            int r105 = r104.hashCode();
        L11:
            int r106 = (r103 + r105) * 31;
            Map<String, String> r107 = this.style;
            if (r107 == null) goto L15;
            if (r107 == null) goto L15;
            int r108 = r107.hashCode();
        L16:
            int r109 = (r106 + r108) * 31;
            String r110 = this.theme;
            if (r110 == null) goto L21;
            if (r110 == null) goto L21;
            r101 = r110.hashCode();
        L21:
            return r109 + r101;
        L15:
            r108 = 0;
        L10:
            r105 = 0;
            goto L11
        L5:
            r102 = 0;
            goto L6
        }

        public final RichTextElement.ImageProperty getIcon() {
            return this.icon;
        }

        public final String getMainTitle() {
            return this.mainTitle;
        }

        public final Map<String, String> getStyle() {
            return this.style;
        }

        public final String getSubTitle() {
            return this.subTitle;
        }

        public final String getTheme() {
            return this.theme;
        }

        public final String getTitle() {
            return this.title;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L22:
            return false;
        L8:
            if (Intrinsics.areEqual(CardHeader.class, r100.getClass()) == false) goto L22;
            CardHeader r101 = (CardHeader) r100;
            if (Intrinsics.areEqual(this.mainTitle, r101.mainTitle) == true) goto L14;
        L12:
            return false;
        L14:
            if (Intrinsics.areEqual(this.style, r101.style) == true) goto L12;
            if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == false) goto L12;
            if (Intrinsics.areEqual(this.theme, r101.theme) == true) goto L12;
            return true;
        }

        public final void setIcon(RichTextElement.ImageProperty r100) {
            this.icon = r100;
        }

        public final void setMainTitle(String r100) {
            this.mainTitle = r100;
        }

        public final void setStyle(Map<String, String> r100) {
            this.style = r100;
        }

        public final void setSubTitle(String r100) {
            this.subTitle = r100;
        }

        public final void setTheme(String r100) {
            this.theme = r100;
        }

        public final void setTitle(String r100) {
            this.title = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/CardContent$DataSource;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IM_CONTENT", "IM_ENTITY", "CARD_ENTITY", "STREAMING_ENTITY", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DataSource extends Enum<DataSource> {
        public static final DataSource CARD_ENTITY = null;
        public static final DataSource IM_CONTENT = null;
        public static final DataSource IM_ENTITY = null;
        public static final DataSource STREAMING_ENTITY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DataSource[] f415323a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415324b = null;
        private final String value;

        public static EnumEntries<DataSource> getEntries() {
            return f415324b;
        }

        static {
            DataSource r100 = new DataSource("IM_CONTENT", 0, "im_content");
            IM_CONTENT = r100;
            DataSource r101 = new DataSource("IM_ENTITY", 1, "im_entity");
            IM_ENTITY = r101;
            DataSource r102 = new DataSource("CARD_ENTITY", 2, "card_entity");
            CARD_ENTITY = r102;
            DataSource r103 = new DataSource("STREAMING_ENTITY", 3, "streaming_entity");
            STREAMING_ENTITY = r103;
            DataSource[] r104 = {r100, r101, r102, r103};
            f415323a = r104;
            f415324b = EnumEntriesKt.enumEntries(r104);
        }

        public static DataSource[] values() {
            return (DataSource[]) f415323a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static DataSource valueOf(String r100) {
            return (DataSource) r27.a.a(DataSource.class, r100);
        }

        public DataSource(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001a\u0010\u0011\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u001a\u0010\u001d\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR\u001a\u0010 \u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR\"\u0010#\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/CardContent$ExtraInfo;", "Ljava/io/Serializable;", "<init>", "()V", "isGadgetPreload", "", "()Z", "setGadgetPreload", "(Z)V", "analyticsData", "", "getAnalyticsData", "()Ljava/lang/String;", "setAnalyticsData", "(Ljava/lang/String;)V", "isMeegoPreload", "setMeegoPreload", "parseTraceId", "getParseTraceId", "setParseTraceId", "parseDuration", "", "getParseDuration", "()J", "setParseDuration", "(J)V", "enableTranslate", "getEnableTranslate", "setEnableTranslate", "parseUUID", "getParseUUID", "setParseUUID", "customParameter", "getCustomParameter", "setCustomParameter", "gadgetAppIds", "", "getGadgetAppIds", "()Ljava/util/List;", "setGadgetAppIds", "(Ljava/util/List;)V", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ExtraInfo implements Serializable {
        private String analyticsData;
        private String customParameter;
        private boolean enableTranslate;
        private List<String> gadgetAppIds;
        private boolean isGadgetPreload;
        private boolean isMeegoPreload;
        private long parseDuration;
        private String parseTraceId;
        private String parseUUID;

        public ExtraInfo() {
            this.parseTraceId = "";
            this.parseUUID = "";
            this.customParameter = "";
        }

        public final String getAnalyticsData() {
            return this.analyticsData;
        }

        public final String getCustomParameter() {
            return this.customParameter;
        }

        public final boolean getEnableTranslate() {
            return this.enableTranslate;
        }

        public final List<String> getGadgetAppIds() {
            return this.gadgetAppIds;
        }

        public final long getParseDuration() {
            return this.parseDuration;
        }

        public final String getParseTraceId() {
            return this.parseTraceId;
        }

        public final String getParseUUID() {
            return this.parseUUID;
        }

        public final boolean isGadgetPreload() {
            return this.isGadgetPreload;
        }

        public final boolean isMeegoPreload() {
            return this.isMeegoPreload;
        }

        public final void setAnalyticsData(String r100) {
            this.analyticsData = r100;
        }

        public final void setCustomParameter(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.customParameter = r100;
        }

        public final void setEnableTranslate(boolean r100) {
            this.enableTranslate = r100;
        }

        public final void setGadgetAppIds(List<String> r100) {
            this.gadgetAppIds = r100;
        }

        public final void setGadgetPreload(boolean r100) {
            this.isGadgetPreload = r100;
        }

        public final void setMeegoPreload(boolean r100) {
            this.isMeegoPreload = r100;
        }

        public final void setParseDuration(long r100) {
            this.parseDuration = r100;
        }

        public final void setParseTraceId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.parseTraceId = r100;
        }

        public final void setParseUUID(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.parseUUID = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R$\u0010\b\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fj\u0002\b\u0006j\u0002\b\u0007¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/CardContent$ExtraType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "UNKNOWN", "SENDER_CANNOT_CLICK", "number", "getNumber", "()I", "setNumber$im_sdk_base_release", "(I)V", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ExtraType extends Enum<ExtraType> {
        public static final a Companion = null;
        public static final ExtraType SENDER_CANNOT_CLICK = null;
        public static final ExtraType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ExtraType[] f415325a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415326b = null;
        private int number;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<ExtraType> getEntries() {
            return f415326b;
        }

        static {
            ExtraType r100 = new ExtraType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ExtraType r101 = new ExtraType("SENDER_CANNOT_CLICK", 1, 1);
            SENDER_CANNOT_CLICK = r101;
            ExtraType[] r102 = {r100, r101};
            f415325a = r102;
            f415326b = EnumEntriesKt.enumEntries(r102);
            Companion = new a();
        }

        public static ExtraType[] values() {
            return (ExtraType[]) f415325a.clone();
        }

        public final int getNumber() {
            return this.number;
        }

        public static ExtraType valueOf(String r100) {
            return (ExtraType) r27.a.a(ExtraType.class, r100);
        }

        public final void setNumber$im_sdk_base_release(int r100) {
            this.number = r100;
        }

        public ExtraType(String r100, int r101, int r102) {
            super(r100, r101);
            this.number = r102;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 )2\u00020\u0001:\u0006)*+,-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R6\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR6\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR6\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0012`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR6\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\fR6\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0019`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR6\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010\fR6\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\n\"\u0004\b#\u0010\fR\u001c\u0010$\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006/"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment;", "Ljava/io/Serializable;", "<init>", "()V", "images", "Ljava/util/HashMap;", "", "Lcom/ss/android/lark/widget/richtext/RichTextElement$ImageProperty;", "Lkotlin/collections/HashMap;", "getImages", "()Ljava/util/HashMap;", "setImages", "(Ljava/util/HashMap;)V", "atUsers", "Lcom/ss/android/lark/widget/richtext/RichTextElement$AtProperty;", "getAtUsers", "setAtUsers", "optionUsers", "Lcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment$OptionUser;", "getOptionUsers", "setOptionUsers", "componentStatusByName", "getComponentStatusByName", "setComponentStatusByName", "personMap", "Lcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment$Person;", "getPersonMap", "setPersonMap", "audioInfoMap", "Lcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment$AudioInfo;", "getAudioInfoMap", "setAudioInfoMap", "videoInfoMap", "Lcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment$VideoInfo;", "getVideoInfoMap", "setVideoInfoMap", "summary", "getSummary", "()Ljava/lang/String;", "setSummary", "(Ljava/lang/String;)V", "Companion", "OptionUser", "Person", "VisitInfo", com.larksuite.component.card.protocol.data.media.AudioInfo.TAG, com.larksuite.component.card.protocol.data.media.VideoInfo.TAG, "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class JsonAttachment implements Serializable {
        public static final a Companion = null;
        private HashMap<String, RichTextElement.AtProperty> atUsers;
        private HashMap<String, AudioInfo> audioInfoMap;
        private HashMap<String, String> componentStatusByName;
        private HashMap<String, RichTextElement.ImageProperty> images;
        private HashMap<String, OptionUser> optionUsers;
        private HashMap<String, Person> personMap;
        private String summary;
        private HashMap<String, VideoInfo> videoInfoMap;

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u001c\u001a\u00020\u001dR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment$AudioInfo;", "Ljava/io/Serializable;", "key", "", "duration", "", "size", "", "visitInfo", "Lcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment$VisitInfo;", "<init>", "(Ljava/lang/String;IJLcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment$VisitInfo;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getDuration", "()I", "setDuration", "(I)V", "getSize", "()J", "setSize", "(J)V", "getVisitInfo", "()Lcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment$VisitInfo;", "setVisitInfo", "(Lcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment$VisitInfo;)V", "toJson", "Lorg/json/JSONObject;", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class AudioInfo implements Serializable {
            private int duration;
            private String key;
            private long size;
            private VisitInfo visitInfo;

            public final JSONObject toJson() {
                JSONObject r100 = new JSONObject();
                r100.put("key", this.key);     // Catch: JSONException -> L5
                r100.put("duration", this.duration);     // Catch: JSONException -> L5
                r100.put("size", this.size);     // Catch: JSONException -> L5
            L6:
                return r100;
            L5:
                Log.e("JsonAttachment", "audioInfo toJSON error");
                goto L6
            }

            public final int getDuration() {
                return this.duration;
            }

            public final String getKey() {
                return this.key;
            }

            public final long getSize() {
                return this.size;
            }

            public final VisitInfo getVisitInfo() {
                return this.visitInfo;
            }

            public final void setDuration(int r100) {
                this.duration = r100;
            }

            public final void setKey(String r100) {
                Intrinsics.checkNotNullParameter(r100, "<set-?>");
                this.key = r100;
            }

            public final void setSize(long r100) {
                this.size = r100;
            }

            public final void setVisitInfo(VisitInfo r100) {
                this.visitInfo = r100;
            }

            public AudioInfo(String r100, int r101, long r102, VisitInfo r103) {
                Intrinsics.checkNotNullParameter(r100, "key");
                this.key = r100;
                this.duration = r101;
                this.size = r102;
                this.visitInfo = r103;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment$OptionUser;", "Ljava/io/Serializable;", "userId", "", "content", "avatarKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getContent", "setContent", "getAvatarKey", "setAvatarKey", "toJson", "Lorg/json/JSONObject;", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class OptionUser implements Serializable {
            private String avatarKey;
            private String content;
            private String userId;

            public final JSONObject toJson() {
                JSONObject r100 = new JSONObject();
                r100.put("content", this.content);
                r100.put("userID", this.userId);
                r100.put("avatarKey", this.avatarKey);
                return r100;
            }

            public final String getAvatarKey() {
                return this.avatarKey;
            }

            public final String getContent() {
                return this.content;
            }

            public final String getUserId() {
                return this.userId;
            }

            public final void setAvatarKey(String r100) {
                Intrinsics.checkNotNullParameter(r100, "<set-?>");
                this.avatarKey = r100;
            }

            public final void setContent(String r100) {
                Intrinsics.checkNotNullParameter(r100, "<set-?>");
                this.content = r100;
            }

            public final void setUserId(String r100) {
                Intrinsics.checkNotNullParameter(r100, "<set-?>");
                this.userId = r100;
            }

            public OptionUser(String r100, String r101, String r102) {
                Intrinsics.checkNotNullParameter(r100, "userId");
                Intrinsics.checkNotNullParameter(r101, "content");
                Intrinsics.checkNotNullParameter(r102, "avatarKey");
                this.userId = r100;
                this.content = r101;
                this.avatarKey = r102;
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment$Person;", "Ljava/io/Serializable;", "personID", "", "type", "", "content", "avatarKey", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getPersonID", "()Ljava/lang/String;", "setPersonID", "(Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "getContent", "setContent", "getAvatarKey", "setAvatarKey", "toJson", "Lorg/json/JSONObject;", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Person implements Serializable {
            private String avatarKey;
            private String content;
            private String personID;
            private int type;

            public final JSONObject toJson() {
                JSONObject r100 = new JSONObject();
                r100.put("content", this.content);     // Catch: JSONException -> L5
                r100.put("personID", this.personID);     // Catch: JSONException -> L5
                r100.put("type", this.type);     // Catch: JSONException -> L5
                r100.put("avatarKey", this.avatarKey);     // Catch: JSONException -> L5
            L6:
                return r100;
            L5:
                Log.e("JsonAttachment", "person toJSON error");
                goto L6
            }

            public final String getAvatarKey() {
                return this.avatarKey;
            }

            public final String getContent() {
                return this.content;
            }

            public final String getPersonID() {
                return this.personID;
            }

            public final int getType() {
                return this.type;
            }

            public final void setAvatarKey(String r100) {
                Intrinsics.checkNotNullParameter(r100, "<set-?>");
                this.avatarKey = r100;
            }

            public final void setContent(String r100) {
                Intrinsics.checkNotNullParameter(r100, "<set-?>");
                this.content = r100;
            }

            public final void setPersonID(String r100) {
                Intrinsics.checkNotNullParameter(r100, "<set-?>");
                this.personID = r100;
            }

            public final void setType(int r100) {
                this.type = r100;
            }

            public Person(String r100, int r101, String r102, String r103) {
                Intrinsics.checkNotNullParameter(r100, "personID");
                Intrinsics.checkNotNullParameter(r102, "content");
                Intrinsics.checkNotNullParameter(r103, "avatarKey");
                this.personID = r100;
                this.type = r101;
                this.content = r102;
                this.avatarKey = r103;
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\"\u001a\u00020#R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment$VideoInfo;", "Ljava/io/Serializable;", "key", "", "duration", "", "size", "", "url", "mime", "visitInfo", "Lcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment$VisitInfo;", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment$VisitInfo;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getDuration", "()I", "setDuration", "(I)V", "getSize", "()J", "setSize", "(J)V", "getUrl", "setUrl", "getMime", "setMime", "getVisitInfo", "()Lcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment$VisitInfo;", "setVisitInfo", "(Lcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment$VisitInfo;)V", "toJson", "Lorg/json/JSONObject;", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class VideoInfo implements Serializable {
            private int duration;
            private String key;
            private String mime;
            private long size;
            private String url;
            private VisitInfo visitInfo;

            public final JSONObject toJson() {
                JSONObject r100 = new JSONObject();
                r100.put("key", this.key);     // Catch: JSONException -> L5
                r100.put("duration", this.duration);     // Catch: JSONException -> L5
                r100.put("size", this.size);     // Catch: JSONException -> L5
                r100.put("url", this.url);     // Catch: JSONException -> L5
                r100.put("mime", this.mime);     // Catch: JSONException -> L5
            L6:
                return r100;
            L5:
                Log.e("JsonAttachment", "videoInfo toJSON error");
                goto L6
            }

            public final int getDuration() {
                return this.duration;
            }

            public final String getKey() {
                return this.key;
            }

            public final String getMime() {
                return this.mime;
            }

            public final long getSize() {
                return this.size;
            }

            public final String getUrl() {
                return this.url;
            }

            public final VisitInfo getVisitInfo() {
                return this.visitInfo;
            }

            public final void setDuration(int r100) {
                this.duration = r100;
            }

            public final void setKey(String r100) {
                Intrinsics.checkNotNullParameter(r100, "<set-?>");
                this.key = r100;
            }

            public final void setMime(String r100) {
                this.mime = r100;
            }

            public final void setSize(long r100) {
                this.size = r100;
            }

            public final void setUrl(String r100) {
                this.url = r100;
            }

            public final void setVisitInfo(VisitInfo r100) {
                this.visitInfo = r100;
            }

            public VideoInfo(String r100, int r101, long r102, String r103, String r104, VisitInfo r105) {
                Intrinsics.checkNotNullParameter(r100, "key");
                this.key = r100;
                this.duration = r101;
                this.size = r102;
                this.url = r103;
                this.mime = r104;
                this.visitInfo = r105;
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\f\u0012\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R6\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R6\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#¨\u0006&"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/CardContent$JsonAttachment$VisitInfo;", "Ljava/io/Serializable;", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "", "entityType", "entityId", "", "innerMsgId", "", "authFileKey", "imExt", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "ext", "<init>", "(IILjava/lang/String;JLjava/lang/String;Ljava/util/HashMap;Ljava/util/HashMap;)V", "getSceneType", "()I", "setSceneType", "(I)V", "getEntityType", "setEntityType", "getEntityId", "()Ljava/lang/String;", "setEntityId", "(Ljava/lang/String;)V", "getInnerMsgId", "()J", "setInnerMsgId", "(J)V", "getAuthFileKey", "setAuthFileKey", "getImExt", "()Ljava/util/HashMap;", "setImExt", "(Ljava/util/HashMap;)V", "getExt", "setExt", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class VisitInfo implements Serializable {
            private String authFileKey;
            private String entityId;
            private int entityType;
            private HashMap<String, String> ext;
            private HashMap<String, String> imExt;
            private long innerMsgId;
            private int sceneType;

            public final String getAuthFileKey() {
                return this.authFileKey;
            }

            public final String getEntityId() {
                return this.entityId;
            }

            public final int getEntityType() {
                return this.entityType;
            }

            public final HashMap<String, String> getExt() {
                return this.ext;
            }

            public final HashMap<String, String> getImExt() {
                return this.imExt;
            }

            public final long getInnerMsgId() {
                return this.innerMsgId;
            }

            public final int getSceneType() {
                return this.sceneType;
            }

            public final void setAuthFileKey(String r100) {
                Intrinsics.checkNotNullParameter(r100, "<set-?>");
                this.authFileKey = r100;
            }

            public final void setEntityId(String r100) {
                Intrinsics.checkNotNullParameter(r100, "<set-?>");
                this.entityId = r100;
            }

            public final void setEntityType(int r100) {
                this.entityType = r100;
            }

            public final void setExt(HashMap<String, String> r100) {
                Intrinsics.checkNotNullParameter(r100, "<set-?>");
                this.ext = r100;
            }

            public final void setImExt(HashMap<String, String> r100) {
                Intrinsics.checkNotNullParameter(r100, "<set-?>");
                this.imExt = r100;
            }

            public final void setInnerMsgId(long r100) {
                this.innerMsgId = r100;
            }

            public final void setSceneType(int r100) {
                this.sceneType = r100;
            }

            public VisitInfo(int r100, int r101, String r102, long r103, String r104, HashMap<String, String> r105, HashMap<String, String> r106) {
                Intrinsics.checkNotNullParameter(r102, "entityId");
                Intrinsics.checkNotNullParameter(r104, "authFileKey");
                Intrinsics.checkNotNullParameter(r105, "imExt");
                Intrinsics.checkNotNullParameter(r106, "ext");
                this.sceneType = r100;
                this.entityType = r101;
                this.entityId = r102;
                this.innerMsgId = r103;
                this.authFileKey = r104;
                this.imExt = r105;
                this.ext = r106;
            }
        }

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
        }

        public JsonAttachment() {
            this.images = new HashMap();
            this.atUsers = new HashMap();
            this.optionUsers = new HashMap();
            this.componentStatusByName = new HashMap();
            this.personMap = new HashMap();
            this.audioInfoMap = new HashMap();
            this.videoInfoMap = new HashMap();
        }

        public final HashMap<String, RichTextElement.AtProperty> getAtUsers() {
            return this.atUsers;
        }

        public final HashMap<String, AudioInfo> getAudioInfoMap() {
            return this.audioInfoMap;
        }

        public final HashMap<String, String> getComponentStatusByName() {
            return this.componentStatusByName;
        }

        public final HashMap<String, RichTextElement.ImageProperty> getImages() {
            return this.images;
        }

        public final HashMap<String, OptionUser> getOptionUsers() {
            return this.optionUsers;
        }

        public final HashMap<String, Person> getPersonMap() {
            return this.personMap;
        }

        public final String getSummary() {
            return this.summary;
        }

        public final HashMap<String, VideoInfo> getVideoInfoMap() {
            return this.videoInfoMap;
        }

        public final void setAtUsers(HashMap<String, RichTextElement.AtProperty> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.atUsers = r100;
        }

        public final void setAudioInfoMap(HashMap<String, AudioInfo> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.audioInfoMap = r100;
        }

        public final void setComponentStatusByName(HashMap<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.componentStatusByName = r100;
        }

        public final void setImages(HashMap<String, RichTextElement.ImageProperty> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.images = r100;
        }

        public final void setOptionUsers(HashMap<String, OptionUser> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.optionUsers = r100;
        }

        public final void setPersonMap(HashMap<String, Person> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.personMap = r100;
        }

        public final void setSummary(String r100) {
            this.summary = r100;
        }

        public final void setVideoInfoMap(HashMap<String, VideoInfo> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.videoInfoMap = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/CardContent$StreamingConfig;", "Ljava/io/Serializable;", "<init>", "()V", "printStrategy", "Lcom/ss/android/lark/chat/entity/message/content/CardContent$StreamingConfig$PrintStrategy;", "getPrintStrategy", "()Lcom/ss/android/lark/chat/entity/message/content/CardContent$StreamingConfig$PrintStrategy;", "setPrintStrategy", "(Lcom/ss/android/lark/chat/entity/message/content/CardContent$StreamingConfig$PrintStrategy;)V", "printFrequencyMs", "", "getPrintFrequencyMs", "()I", "setPrintFrequencyMs", "(I)V", "printStep", "getPrintStep", "setPrintStep", "PrintStrategy", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StreamingConfig implements Serializable {
        private int printFrequencyMs;
        private int printStep;
        private PrintStrategy printStrategy;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/CardContent$StreamingConfig$PrintStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "FAST", "DELAY", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum PrintStrategy extends Enum<PrintStrategy> {
            public static final a Companion = null;
            public static final PrintStrategy DEFAULT = null;
            public static final PrintStrategy DELAY = null;
            public static final PrintStrategy FAST = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ PrintStrategy[] f415327a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f415328b = null;

            public static final class a {
                public a() {
                }
            }

            public static EnumEntries<PrintStrategy> getEntries() {
                return f415328b;
            }

            static {
                PrintStrategy r100 = new PrintStrategy("DEFAULT", 0);
                DEFAULT = r100;
                PrintStrategy r101 = new PrintStrategy("FAST", 1);
                FAST = r101;
                PrintStrategy r102 = new PrintStrategy("DELAY", 2);
                DELAY = r102;
                PrintStrategy[] r103 = {r100, r101, r102};
                f415327a = r103;
                f415328b = EnumEntriesKt.enumEntries(r103);
                Companion = new a();
            }

            public static PrintStrategy[] values() {
                return (PrintStrategy[]) f415327a.clone();
            }

            @JvmStatic
            public static final PrintStrategy forNumber(int r100) {
                Companion.getClass();
                if (r100 == 1) goto L9;
                if (r100 == 2) goto L11;
                return DEFAULT;
            L11:
                return DELAY;
            L9:
                return FAST;
            }

            public static PrintStrategy valueOf(String r100) {
                return (PrintStrategy) r27.a.a(PrintStrategy.class, r100);
            }

            public PrintStrategy(String r100, int r101) {
                super(r100, r101);
            }
        }

        public StreamingConfig() {
            this.printStrategy = PrintStrategy.DEFAULT;
        }

        public final int getPrintFrequencyMs() {
            return this.printFrequencyMs;
        }

        public final int getPrintStep() {
            return this.printStep;
        }

        public final PrintStrategy getPrintStrategy() {
            return this.printStrategy;
        }

        public final void setPrintFrequencyMs(int r100) {
            this.printFrequencyMs = r100;
        }

        public final void setPrintStep(int r100) {
            this.printStep = r100;
        }

        public final void setPrintStrategy(PrintStrategy r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.printStrategy = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R$\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fj\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/CardContent$Type;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "UNKNOWN", "VOTE", CardAdapter.TEXT, "VCHAT", "OPEN_CARD", "number", "getNumber", "()I", "setNumber$im_sdk_base_release", "(I)V", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final a Companion = null;
        public static final Type OPEN_CARD = null;
        public static final Type TEXT = null;
        public static final Type UNKNOWN = null;
        public static final Type VCHAT = null;
        public static final Type VOTE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f415329a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415330b = null;
        private int number;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Type> getEntries() {
            return f415330b;
        }

        static {
            Type r100 = new Type("UNKNOWN", 0, -1);
            UNKNOWN = r100;
            Type r101 = new Type("VOTE", 1, 1);
            VOTE = r101;
            Type r102 = new Type(CardAdapter.TEXT, 2, 2);
            TEXT = r102;
            Type r103 = new Type("VCHAT", 3, 3);
            VCHAT = r103;
            Type r104 = new Type("OPEN_CARD", 4, 4);
            OPEN_CARD = r104;
            Type[] r105 = {r100, r101, r102, r103, r104};
            f415329a = r105;
            f415330b = EnumEntriesKt.enumEntries(r105);
            Companion = new a();
        }

        public static Type[] values() {
            return (Type[]) f415329a.clone();
        }

        public final int getNumber() {
            return this.number;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public final void setNumber$im_sdk_base_release(int r100) {
            this.number = r100;
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.number = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/CardContent$WidthMode;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEFAULT", "COMPACT", "FILL", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum WidthMode extends Enum<WidthMode> {
        public static final WidthMode COMPACT = null;
        public static final a Companion = null;
        public static final WidthMode DEFAULT = null;
        public static final WidthMode FILL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ WidthMode[] f415331a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415332b = null;
        private final String value;

        public static final class a {
            public a() {
            }

            @JvmStatic
            public static WidthMode a(String r100) {
                WidthMode r101 = WidthMode.COMPACT;
                if (Intrinsics.areEqual(r100, r101.getValue()) == true) goto L10;
                WidthMode r102 = WidthMode.FILL;
                if (Intrinsics.areEqual(r100, r102.getValue()) == false) goto L9;
                return r102;
            L9:
                return WidthMode.DEFAULT;
            L10:
                return r101;
            }
        }

        @JvmStatic
        public static final WidthMode forString(String r100) {
            Companion.getClass();
            return a.a(r100);
        }

        public static EnumEntries<WidthMode> getEntries() {
            return f415332b;
        }

        static {
            WidthMode r100 = new WidthMode("DEFAULT", 0, "default");
            DEFAULT = r100;
            WidthMode r101 = new WidthMode("COMPACT", 1, "compact");
            COMPACT = r101;
            WidthMode r102 = new WidthMode("FILL", 2, LynxVideoManagerLite.FILL);
            FILL = r102;
            WidthMode[] r103 = {r100, r101, r102};
            f415331a = r103;
            f415332b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static WidthMode[] values() {
            return (WidthMode[]) f415331a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static WidthMode valueOf(String r100) {
            return (WidthMode) r27.a.a(WidthMode.class, r100);
        }

        public WidthMode(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public final ResourceCleanScene firstResourceScene() {
        return (ResourceCleanScene) CollectionsKt.firstOrNull(this.cleanResourceKeyScene.values());
    }

    public final String getCardDetailDigest() {
        String r100 = this.lynxDigest;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return ((a) ApiUtils.getApi(a.class)).getSummary(this);
    }

    public final HashSet<String> getCardUrls() {
        String r100 = this.dslJsonString;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L62;
        HashSet<String> r102 = new HashSet();
        if (CollectionUtils.isNotEmpty(this.actions) == false) goto L29;
        Map<String, ? extends CardAction> r103 = this.actions;
        if (r103 == null) goto L29;
        Collection<? extends CardAction> r104 = r103.values();
        if (r104 == null) goto L29;
        Iterator<T> r105 = r104.iterator();
    L18:
        if (r105.hasNext() == false) goto L29;
        CardAction.OpenUrl r106 = ((CardAction) r105.next()).getOpenUrl();
        if (r106 == null) goto L18;
        if (TextUtils.isEmpty(r106.getAndroidUrl()) == false) goto L24;
        String r107 = r106.getUrl();
    L26:
        if (TextUtils.isEmpty(r107) == true) goto L18;
        if (r107 == null) goto L18;
        r102.add(r107);
        goto L18
    L24:
        r107 = r106.getAndroidUrl();
    L29:
        RichText r108 = this.richText;
        if (r108 == null) goto L34;
        List<String> r109 = r108.getUrls();
        if (r109 == null) goto L34;
        r102.addAll(r109);
    L34:
        RichText r110 = this.richText;
        if (r110 == null) goto L39;
        RichText.RichTextElements r111 = r110.getElements();
        if (r111 == null) goto L39;
        Map<String, RichTextElement> r112 = r111.getDictionary();
    L40:
        if (r112 == null) goto L81;
        Iterator<Map.Entry<String, RichTextElement>> r113 = r112.entrySet().iterator();
    L43:
        if (r113.hasNext() == false) goto L82;
        RichTextElement r114 = r113.next().getValue();
        if (r114 == null) goto L47;
        RichTextElement.RichTextProperty r115 = r114.getProperty();
    L48:
        if (r114 == null) goto L50;
        RichTextElement.RichTextTag r116 = r114.getTag();
    L52:
        if (r116 != RichTextElement.RichTextTag.LINK) goto L43;
        if ((r115 instanceof RichTextElement.LinkProperty) == false) goto L43;
        RichTextElement.LinkProperty r117 = (RichTextElement.LinkProperty) r115;
        String r118 = r117.getAndroidUrl();
        if (r118 != null) goto L59;
        r118 = r117.getUrl();
    L59:
        if (TextUtils.isEmpty(r118) == true) goto L43;
        r102.add(r118);
        goto L43
    L50:
        r116 = null;
        goto L52
    L47:
        r115 = null;
        goto L48
    L82:
        return r102;
    L81:
        return r102;
    L39:
        r112 = null;
        goto L40
    L62:
        return this.jsonCardUrls;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final String getDigest() {
        StringBuilder r100 = new StringBuilder();
        CardHeader r101 = this.cardHeader;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getMainTitle();
    L6:
        boolean r104 = false;
        if (r103 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        if (r105 == false) goto L17;
        CardHeader r106 = this.cardHeader;
        if (r106 == null) goto L20;
        String r107 = r106.getTitle();
    L21:
        if (r107 != null) goto L23;
    L28:
        boolean r108 = false;
    L30:
        if (r108 == false) goto L32;
        r100.append(r107);
        r100.append(" ");
    L32:
        CardHeader r109 = this.cardHeader;
        if (r109 == null) goto L42;
        String r110 = r109.getSubTitle();
        if (r110 == null) goto L42;
        if (r110.length() <= 0) goto L39;
        boolean r111 = true;
    L40:
        if (r111 != true) goto L42;
        boolean r112 = true;
    L43:
        if (r112 == false) goto L48;
        CardHeader r113 = this.cardHeader;
        if (r113 == null) goto L47;
        r102 = r113.getSubTitle();
    L47:
        r100.append(r102);
        r100.append(" ");
    L48:
        String r114 = i.g(this.richText, true);
        if (r114 != null) goto L51;
    L56:
        if (r104 == false) goto L59;
        r100.append(r114);
    L59:
        return r100.toString();
    L51:
        if (r114.length() <= 0) goto L53;
        boolean r115 = true;
    L54:
        if (r115 != true) goto L56;
        r104 = true;
        goto L56
    L53:
        r115 = false;
        goto L54
    L39:
        r111 = false;
    L42:
        r112 = false;
        goto L43
    L23:
        if (r107.length() <= 0) goto L25;
        boolean r116 = true;
    L26:
        if (r116 != true) goto L28;
        r108 = true;
        goto L30
    L25:
        r116 = false;
    L20:
        r107 = null;
        goto L21
    L17:
        CardHeader r117 = this.cardHeader;
        if (r117 == null) goto L20;
        r107 = r117.getMainTitle();
        goto L21
    L9:
        if (r103.length() == 0) goto L12;
        r105 = false;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    public final String getLynxSimpleDigest() {
        JsonAttachment r100 = this.dslJsonAttachment;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSummary();
    }

    public final boolean resourceIsCleaned() {
        return !this.cleanResourceKeyScene.isEmpty();
    }

    public CardContent() {
        this.widthMode = WidthMode.DEFAULT;
        this.dataSource = DataSource.IM_CONTENT;
        this.actionSelectValue = new HashMap();
        this.componentStatusByActionId = new HashMap();
        this.sendCardBotId = "";
        this.sendAppId = "";
        this.cleanResourceKeyScene = new HashMap();
    }

    public final HashMap<String, String> getActionSelectValue() {
        return this.actionSelectValue;
    }

    public final Map<String, CardAction> getActions() {
        return this.actions;
    }

    public final CardHeader getCardHeader() {
        return this.cardHeader;
    }

    public final int getCardVersion() {
        return this.cardVersion;
    }

    public final HashMap<String, ResourceCleanScene> getCleanResourceKeyScene() {
        return this.cleanResourceKeyScene;
    }

    public final HashMap<String, String> getComponentStatusByActionId() {
        return this.componentStatusByActionId;
    }

    public final int getContentVersion() {
        return this.contentVersion;
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public final JsonAttachment getDslJsonAttachment() {
        return this.dslJsonAttachment;
    }

    public final String getDslJsonString() {
        return this.dslJsonString;
    }

    public final boolean getEnableForward() {
        return this.enableForward;
    }

    public final ExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public final ExtraType getExtraType() {
        return this.extraType;
    }

    public final String getHostCardId() {
        return this.hostCardId;
    }

    public final HashSet<String> getJsonCardUrls() {
        return this.jsonCardUrls;
    }

    public final String getLynxDigest() {
        return this.lynxDigest;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final RichText getRichText() {
        return this.richText;
    }

    public final String getSendAppId() {
        return this.sendAppId;
    }

    public final String getSendCardBotId() {
        return this.sendCardBotId;
    }

    public final StreamingConfig getStreamingConfig() {
        return this.streamingConfig;
    }

    public final Type getType() {
        return this.type;
    }

    public final String getUniversalCardID() {
        return this.universalCardID;
    }

    public final String getUniversalCardVersion() {
        return this.universalCardVersion;
    }

    public final WidthMode getWidthMode() {
        return this.widthMode;
    }

    public final boolean isForward() {
        return this.isForward;
    }

    public final boolean isStreamingMode() {
        return this.isStreamingMode;
    }

    public final Boolean isTranslate() {
        return this.isTranslate;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public boolean isContentSame(Content r100) {
        if ((r100 instanceof CardContent) == true) goto L5;
        return false;
    L5:
        CardContent r101 = (CardContent) r100;
        if (TextUtils.isEmpty(r101.dslJsonString) == false) goto L10;
        return super.isContentSame(r100);
    L10:
        if (r101.contentVersion == this.contentVersion) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(r101.dslJsonString, this.dslJsonString) == true) goto L16;
        return false;
    L16:
        return super.isContentSame(r100);
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public boolean isItemSame(Content r100) {
        if ((r100 instanceof CardContent) == true) goto L5;
        return false;
    L5:
        if (this != r100) goto L8;
        return true;
    L8:
        CardContent r101 = (CardContent) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (this.cardVersion == r101.cardVersion) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cardHeader, r101.cardHeader) == true) goto L18;
        return false;
    L18:
        return Intrinsics.areEqual(this.richText, r101.richText);
    }

    public final void setActionSelectValue(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.actionSelectValue = r100;
    }

    public final void setActions(Map<String, ? extends CardAction> r100) {
        this.actions = r100;
    }

    public final void setCardHeader(CardHeader r100) {
        this.cardHeader = r100;
    }

    public final void setCardVersion(int r100) {
        this.cardVersion = r100;
    }

    public final void setCleanResourceKeyScene(HashMap<String, ResourceCleanScene> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cleanResourceKeyScene = r100;
    }

    public final void setComponentStatusByActionId(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.componentStatusByActionId = r100;
    }

    public final void setContentVersion(int r100) {
        this.contentVersion = r100;
    }

    public final void setDataSource(DataSource r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dataSource = r100;
    }

    public final void setDslJsonAttachment(JsonAttachment r100) {
        this.dslJsonAttachment = r100;
    }

    public final void setDslJsonString(String r100) {
        this.dslJsonString = r100;
    }

    public final void setEnableForward(boolean r100) {
        this.enableForward = r100;
    }

    public final void setExtraInfo(ExtraInfo r100) {
        this.extraInfo = r100;
    }

    public final void setExtraType(ExtraType r100) {
        this.extraType = r100;
    }

    public final void setForward(boolean r100) {
        this.isForward = r100;
    }

    public final void setHostCardId(String r100) {
        this.hostCardId = r100;
    }

    public final void setJsonCardUrls(HashSet<String> r100) {
        this.jsonCardUrls = r100;
    }

    public final void setLynxDigest(String r100) {
        this.lynxDigest = r100;
    }

    public final void setMessageId(String r100) {
        this.messageId = r100;
    }

    public final void setRichText(RichText r100) {
        this.richText = r100;
    }

    public final void setSendAppId(String r100) {
        this.sendAppId = r100;
    }

    public final void setSendCardBotId(String r100) {
        this.sendCardBotId = r100;
    }

    public final void setStreamingConfig(StreamingConfig r100) {
        this.streamingConfig = r100;
    }

    public final void setStreamingMode(boolean r100) {
        this.isStreamingMode = r100;
    }

    public final void setTranslate(Boolean r100) {
        this.isTranslate = r100;
    }

    public final void setTranslateMsgCardSummary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "digest");
        this.lynxDigest = r100;
    }

    public final void setType(Type r100) {
        this.type = r100;
    }

    public final void setUniversalCardID(String r100) {
        this.universalCardID = r100;
    }

    public final void setUniversalCardVersion(String r100) {
        this.universalCardVersion = r100;
    }

    public final void setWidthMode(WidthMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.widthMode = r100;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content, y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((Content) r100);
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content, y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((Content) r100);
    }
}
