package com.ss.android.lark.chat.entity.message.content;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.lark.pb.basic.v1.Content;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.export.entity.chatter.OpenChatter;
import com.ss.android.lark.chat.export.entity.message.content.ContentValue;
import com.ss.android.lark.chat.export.entity.message.content.OpenSystemContent;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import com.ss.android.lark.chat.export.entity.message.content.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 w2\u00020\u0001:\u0001wB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010\u0005J\u0010\u0010_\u001a\u00020]2\b\u0010X\u001a\u0004\u0018\u00010\u0005J\u0010\u0010`\u001a\u00020]2\b\u0010Y\u001a\u0004\u0018\u00010\u0005J\u0010\u0010a\u001a\u00020]2\b\u0010Z\u001a\u0004\u0018\u00010\u0005J\u0010\u0010b\u001a\u00020]2\b\u0010[\u001a\u0004\u0018\u00010\u0005J\u000e\u0010c\u001a\u00020]2\u0006\u0010d\u001a\u000200J\b\u0010m\u001a\u00020 H\u0016J\u0013\u0010n\u001a\u0002002\b\u0010o\u001a\u0004\u0018\u00010pH\u0096\u0002J \u0010q\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050@H\u0002J\u0012\u0010r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000eJ\u001a\u0010s\u001a\u00020]2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000eJ\u0012\u0010t\u001a\u0002002\b\u0010u\u001a\u0004\u0018\u00010vH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\fX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0016j\b\u0012\u0004\u0012\u00020\u0005`\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR&\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010,\"\u0004\b<\u0010.R\u001a\u0010=\u001a\u000200X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00101\"\u0004\b>\u00103R3\u0010?\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bA\u0010BR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010FX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010H\"\u0004\bM\u0010JR\u001d\u0010N\u001a\u0004\u0018\u00010\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bP\u0010D\u001a\u0004\bO\u0010\u0007R\u001d\u0010Q\u001a\u0004\u0018\u00010\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bS\u0010D\u001a\u0004\bR\u0010\u0007R\u001d\u0010T\u001a\u0004\u0018\u00010\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bV\u0010D\u001a\u0004\bU\u0010\u0007R\u0010\u0010W\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010e\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bg\u0010D\u001a\u0004\bf\u0010\u0007R\u0014\u0010h\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bh\u00101R\u0014\u0010i\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bi\u00101R\u0014\u0010j\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bj\u00101R\u0014\u0010k\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bk\u00101R\u0014\u0010l\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bl\u00101¨\u0006x"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/SystemContent;", "Lcom/ss/android/lark/chat/export/entity/message/content/OpenSystemContent;", "<init>", "()V", "messageTemplate", "", "getMessageTemplate", "()Ljava/lang/String;", "setMessageTemplate", "(Ljava/lang/String;)V", "contents", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "systemContents", "", "", "Lcom/ss/android/lark/chat/export/entity/message/content/ContentValue;", "getSystemContents", "()Ljava/util/Map;", "setSystemContents", "(Ljava/util/Map;)V", "localMentionAgentIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLocalMentionAgentIds", "()Ljava/util/ArrayList;", "setLocalMentionAgentIds", "(Ljava/util/ArrayList;)V", "localMentionTriggerMessageId", "getLocalMentionTriggerMessageId", "setLocalMentionTriggerMessageId", "itemActions", "", "Lcom/ss/android/lark/chat/export/entity/message/content/SystemMessageItemAction;", "getItemActions", "setItemActions", "systemExtraContent", "Lcom/bytedance/lark/pb/basic/v1/Content$SystemExtraContent;", "getSystemExtraContent", "()Lcom/bytedance/lark/pb/basic/v1/Content$SystemExtraContent;", "setSystemExtraContent", "(Lcom/bytedance/lark/pb/basic/v1/Content$SystemExtraContent;)V", "version", "getVersion", "()I", "setVersion", "(I)V", "isMsgClickable", "", "()Z", "setMsgClickable", "(Z)V", "type", "Lcom/ss/android/lark/chat/export/entity/message/content/SystemMessageType;", "getType", "()Lcom/ss/android/lark/chat/export/entity/message/content/SystemMessageType;", "setType", "(Lcom/ss/android/lark/chat/export/entity/message/content/SystemMessageType;)V", "systemTypeValue", "getSystemTypeValue", "setSystemTypeValue", "isMockToolMessage", "setMockToolMessage", "chatterIds", "Lkotlin/Triple;", "getChatterIds", "()Lkotlin/Triple;", "chatterIds$delegate", "Lkotlin/Lazy;", "fromChatter", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "getFromChatter", "()Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "setFromChatter", "(Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;)V", "toChatter", "getToChatter", "setToChatter", "fromChatterId", "getFromChatterId", "fromChatterId$delegate", "toChatterId", "getToChatterId", "toChatterId$delegate", "triggerId", "getTriggerId", "triggerId$delegate", "voIPFromId", "voIPToId", "voIpTriggerId", "vcFromId", "vcToId", "setVoIPFromId", "", "voipFromId", "setVoIPToId", "setVoIpTriggerId", "setVcFromId", "setVcToId", "setIsMockToolMessage", "boolean", "formattedContent", "getFormattedContent", "formattedContent$delegate", "isVoIPSystemMessage", "isVCSystemMessage", "isRedPackSystemMessage", "isMyAINewTopic", "isMockMyAIToolMessage", "hashCode", "equals", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "", "parseChatterIds", "getContents", "setContents", "isContentSame", "diffable", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SystemContent extends OpenSystemContent {
    public static final a Companion = null;
    private final Lazy chatterIds$delegate;
    private final HashMap<String, String> contents;
    private final Lazy formattedContent$delegate;
    private ChatChatter fromChatter;
    private final Lazy fromChatterId$delegate;
    private boolean isMockToolMessage;
    private boolean isMsgClickable;
    private Map<Integer, ? extends e> itemActions;
    private ArrayList<String> localMentionAgentIds;
    private String localMentionTriggerMessageId;
    private String messageTemplate;
    private Map<String, ? extends List<? extends ContentValue>> systemContents;
    private Content.SystemExtraContent systemExtraContent;
    private int systemTypeValue;
    private ChatChatter toChatter;
    private final Lazy toChatterId$delegate;
    private final Lazy triggerId$delegate;
    private SystemMessageType type;
    private String vcFromId;
    private String vcToId;
    private int version;
    private String voIPFromId;
    private String voIPToId;
    private String voIpTriggerId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.ss.android.lark.chat.export.entity.message.content.OpenSystemContent
    public String getFormattedContent() {
        return (String) this.formattedContent$delegate.getValue();
    }

    @Override // com.ss.android.lark.chat.export.entity.message.content.OpenSystemContent
    public String getFromChatterId() {
        return (String) this.fromChatterId$delegate.getValue();
    }

    @Override // com.ss.android.lark.chat.export.entity.message.content.OpenSystemContent
    public String getToChatterId() {
        return (String) this.toChatterId$delegate.getValue();
    }

    @Override // com.ss.android.lark.chat.export.entity.message.content.OpenSystemContent
    public String getTriggerId() {
        return (String) this.triggerId$delegate.getValue();
    }

    public SystemContent() {
        this.contents = new HashMap();
        this.systemContents = new HashMap();
        this.localMentionAgentIds = new ArrayList();
        this.itemActions = new HashMap();
        this.type = SystemMessageType.UNKNOWN;
        this.chatterIds$delegate = LazyKt.lazy(new SystemContent$chatterIds$2(this));
        this.fromChatterId$delegate = LazyKt.lazy(new SystemContent$fromChatterId$2(this));
        this.toChatterId$delegate = LazyKt.lazy(new SystemContent$toChatterId$2(this));
        this.triggerId$delegate = LazyKt.lazy(new SystemContent$triggerId$2(this));
        this.formattedContent$delegate = LazyKt.lazy(new SystemContent$formattedContent$2(this));
    }

    @Override // com.ss.android.lark.chat.export.entity.message.content.OpenSystemContent
    public /* bridge */ /* synthetic */ OpenChatter getFromChatter() {
        return getFromChatter();
    }

    @Override // com.ss.android.lark.chat.export.entity.message.content.OpenSystemContent
    public /* bridge */ /* synthetic */ OpenChatter getToChatter() {
        return getToChatter();
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.ss.android.lark.chat.export.entity.message.content.OpenSystemContent
    public boolean isMyAINewTopic() {
        if (getType() != SystemMessageType.MyAI_NewTopicTip) goto L5;
    L8:
        return true;
    L5:
        if (getType() == SystemMessageType.MyAI_SceneTopicDynamicTip) goto L8;
        return false;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.content.OpenSystemContent
    public boolean isRedPackSystemMessage() {
        if (getType() != SystemMessageType.GRAB_OTHER_HONGBAO) goto L5;
    L16:
        return true;
    L5:
        if (getType() == SystemMessageType.OTHER_GRAB_MY_HONGBAO) goto L16;
        if (getType() == SystemMessageType.LAST_HONGBAO_IS_GRABBED) goto L16;
        if (getType() == SystemMessageType.SEND_HONGBAO_MESSAGE_FAILED) goto L16;
        if (getType() == SystemMessageType.SIMPLIFY_OTHER_GRAB_MY_HONGBAO) goto L16;
        if (getType() == SystemMessageType.SIMPLIFY_OTHER_GRAB_MY_HONGBAO_NOT_OVER_OUT_NUM) goto L16;
        return false;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.content.OpenSystemContent
    public boolean isVCSystemMessage() {
        if (getType() != SystemMessageType.VC_CALL_DURATION) goto L5;
    L22:
        return true;
    L5:
        if (getType() == SystemMessageType.VC_CALL_FINISH_NOTICE) goto L22;
        if (getType() == SystemMessageType.VC_CALL_HOST_BUSY) goto L22;
        if (getType() == SystemMessageType.VC_CALL_HOST_CANCEL) goto L22;
        if (getType() == SystemMessageType.VC_CALL_PARTI_BUSY) goto L22;
        if (getType() == SystemMessageType.VC_CALL_PARTI_CANCEL) goto L22;
        if (getType() == SystemMessageType.VC_CALL_PARTI_NO_ANSWER) goto L22;
        if (getType() == SystemMessageType.VC_CALL_CONNECT_FAIL) goto L22;
        if (getType() == SystemMessageType.VC_CALL_DISCONNECT) goto L22;
        return false;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.content.OpenSystemContent
    public boolean isVoIPSystemMessage() {
        if (getType() != SystemMessageType.USER_CALL_E2EE_VOICE_ON_MISSING) goto L5;
    L14:
        return true;
    L5:
        if (getType() == SystemMessageType.USER_CALL_E2EE_VOICE_ON_CANCELL) goto L14;
        if (getType() == SystemMessageType.USER_CALL_E2EE_VOICE_DURATION) goto L14;
        if (getType() == SystemMessageType.USER_CALL_E2EE_VOICE_WHEN_REFUSED) goto L14;
        if (getType() == SystemMessageType.USER_CALL_E2EE_VOICE_WHEN_OCCUPY) goto L14;
        return false;
    }

    public final Map<String, String> getContents() {
        return this.contents;
    }

    public final Map<Integer, e> getItemActions() {
        return this.itemActions;
    }

    public final ArrayList<String> getLocalMentionAgentIds() {
        return this.localMentionAgentIds;
    }

    public final String getLocalMentionTriggerMessageId() {
        return this.localMentionTriggerMessageId;
    }

    public final String getMessageTemplate() {
        return this.messageTemplate;
    }

    public final Map<String, List<ContentValue>> getSystemContents() {
        return this.systemContents;
    }

    public final Content.SystemExtraContent getSystemExtraContent() {
        return this.systemExtraContent;
    }

    public final int getSystemTypeValue() {
        return this.systemTypeValue;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.content.OpenSystemContent
    public SystemMessageType getType() {
        return this.type;
    }

    public final int getVersion() {
        return this.version;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.content.OpenSystemContent
    public boolean isMockMyAIToolMessage() {
        return this.isMockToolMessage;
    }

    public final boolean isMockToolMessage() {
        return this.isMockToolMessage;
    }

    public final boolean isMsgClickable() {
        return this.isMsgClickable;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.content.OpenSystemContent
    public /* bridge */ /* synthetic */ CharSequence getFormattedContent() {
        return getFormattedContent();
    }

    @Override // com.ss.android.lark.chat.export.entity.message.content.OpenSystemContent
    public ChatChatter getFromChatter() {
        return this.fromChatter;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.content.OpenSystemContent
    public ChatChatter getToChatter() {
        return this.toChatter;
    }

    public static final Triple access$getChatterIds(SystemContent r100) {
        return (Triple) r100.chatterIds$delegate.getValue();
    }

    public static final Triple access$parseChatterIds(SystemContent r100) {
        String r101 = null;
        if (r100.isVCSystemMessage() == false) goto L6;
        String r102 = r100.vcFromId;
        String r103 = r100.vcToId;
    L12:
        return new Triple(r102, r103, r101);
    L6:
        if (r100.isVoIPSystemMessage() == false) goto L8;
        r102 = r100.voIPFromId;
        String r104 = r100.voIPToId;
        r101 = r100.voIpTriggerId;
        r103 = r104;
        goto L12
    L8:
        Map<String, String> r105 = r100.getContents();
        r102 = r105.get("caller_id");
        r103 = r105.get("callee_id");
        if (r103 != null) goto L12;
        r103 = "";
        goto L12
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SystemContent) == false) goto L15;
        SystemContent r101 = (SystemContent) r100;
        if (Intrinsics.areEqual(this.messageTemplate, r101.messageTemplate) == true) goto L11;
        return false;
    L11:
        if (getType() == r101.getType()) goto L14;
        return false;
    L14:
        return Intrinsics.areEqual(new HashSet(this.contents.values()), new HashSet(r101.contents.values()));
    L15:
        return false;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public boolean isContentSame(com.ss.android.lark.chat.export.entity.message.Content r100) {
        if ((r100 instanceof SystemContent) == false) goto L21;
        SystemContent r101 = (SystemContent) r100;
        if (Intrinsics.areEqual(this.localMentionAgentIds, r101.localMentionAgentIds) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.localMentionTriggerMessageId, r101.localMentionTriggerMessageId) == true) goto L10;
        return false;
    L10:
        Content.SystemExtraContent r102 = this.systemExtraContent;
        Content.NewTopicSystemMessageExtraContent r103 = null;
        if (r102 == null) goto L13;
        Content.NewTopicSystemMessageExtraContent r104 = r102.new_topic_system_message_extra_content;
    L14:
        Content.SystemExtraContent r105 = r101.systemExtraContent;
        if (r105 == null) goto L18;
        r103 = r105.new_topic_system_message_extra_content;
    L18:
        if (Intrinsics.areEqual(r104, r103) == true) goto L21;
        return false;
    L13:
        r104 = null;
    L21:
        return super.isContentSame(r100);
    }

    public final void setContents(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "contents");
        this.contents.clear();
        this.contents.putAll(r100);
    }

    public void setFromChatter(ChatChatter r100) {
        this.fromChatter = r100;
    }

    public final void setIsMockToolMessage(boolean r100) {
        this.isMockToolMessage = r100;
    }

    public final void setItemActions(Map<Integer, ? extends e> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.itemActions = r100;
    }

    public final void setLocalMentionAgentIds(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.localMentionAgentIds = r100;
    }

    public final void setLocalMentionTriggerMessageId(String r100) {
        this.localMentionTriggerMessageId = r100;
    }

    public final void setMessageTemplate(String r100) {
        this.messageTemplate = r100;
    }

    public final void setMockToolMessage(boolean r100) {
        this.isMockToolMessage = r100;
    }

    public final void setMsgClickable(boolean r100) {
        this.isMsgClickable = r100;
    }

    public final void setSystemContents(Map<String, ? extends List<? extends ContentValue>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.systemContents = r100;
    }

    public final void setSystemExtraContent(Content.SystemExtraContent r100) {
        this.systemExtraContent = r100;
    }

    public final void setSystemTypeValue(int r100) {
        this.systemTypeValue = r100;
    }

    public void setToChatter(ChatChatter r100) {
        this.toChatter = r100;
    }

    public void setType(SystemMessageType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public final void setVcFromId(String r100) {
        this.vcFromId = r100;
    }

    public final void setVcToId(String r100) {
        this.vcToId = r100;
    }

    public final void setVersion(int r100) {
        this.version = r100;
    }

    public final void setVoIPFromId(String r100) {
        this.voIPFromId = r100;
    }

    public final void setVoIPToId(String r100) {
        this.voIPToId = r100;
    }

    public final void setVoIpTriggerId(String r100) {
        this.voIpTriggerId = r100;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content, y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((com.ss.android.lark.chat.export.entity.message.Content) r100);
    }
}
