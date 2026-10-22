package com.larus.uaigc.bean.createpage;

import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ny9.u;
import wc9.e;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\bK\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\b\u0018\u0000 r2\u00020\u0001:\u0002rsBõ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u0012\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u0012\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0017\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010$\u001a\u00020\u0017\u0012\b\b\u0002\u0010%\u001a\u00020\u0017\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b'\u0010(J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010X\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00104J\u0017\u0010Y\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u0010?J\u000b\u0010^\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u0017\u0010_\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003J\u0017\u0010`\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003J\u0019\u0010a\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000fHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0017HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010#HÆ\u0003J\t\u0010h\u001a\u00020\u0017HÆ\u0003J\t\u0010i\u001a\u00020\u0017HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jü\u0002\u0010k\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f2\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010 \u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020\u00172\b\b\u0002\u0010%\u001a\u00020\u00172\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010lJ\u0013\u0010m\u001a\u00020\u00172\b\u0010n\u001a\u0004\u0018\u00010oHÖ\u0003J\t\u0010p\u001a\u00020\rHÖ\u0001J\t\u0010q\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010*R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010*R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010*R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010*R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010@\u001a\u0004\b>\u0010?R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u001f\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bC\u00107R\u001f\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bD\u00107R!\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bE\u00107R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010*R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010*R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u0010*R\u0011\u0010 \u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u0010*R\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010$\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b$\u0010JR\u0011\u0010%\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\bN\u0010JR\u0013\u0010&\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u0010*¨\u0006t"}, d2 = {"Lcom/larus/uaigc/bean/createpage/CreationSendMessageConfig;", "Ljava/io/Serializable;", "cvsId", "", "botId", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "content", "scene", "txtScene", "enterMethod", "previousPage", "actionInstruction", "", "actionBarInstructionMap", "", "attachmentInfo", "Lcom/larus/bmhome/view/AttachmentInfo;", "customMultiAttachmentInfo", "Lcom/larus/bmhome/chat/CustomMultiAttachmentInfo;", "imageEditDataWithMask", "Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;", "hasImagePreprocessed", "", "hitPointData", "Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "messageExtMap", "bizExtMap", "sendTrackExtMap", "creationSendTraceId", "actionBarCreationId", "actionBarCreationType", "localIntercepted", "localInterceptInfo", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "isReEdit", "clearInputContent", "lyricCreateType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/conversation/Conversation;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Lcom/larus/bmhome/view/AttachmentInfo;Lcom/larus/bmhome/chat/CustomMultiAttachmentInfo;Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;Ljava/lang/Boolean;Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/larus/bmhome/chat/bean/ChatPageContext;ZZLjava/lang/String;)V", "getCvsId", "()Ljava/lang/String;", "getBotId", "getConversation", "()Lcom/larus/im/bean/conversation/Conversation;", "getContent", "getScene", "getTxtScene", "getEnterMethod", "getPreviousPage", "getActionInstruction", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getActionBarInstructionMap", "()Ljava/util/Map;", "getAttachmentInfo", "()Lcom/larus/bmhome/view/AttachmentInfo;", "getCustomMultiAttachmentInfo", "()Lcom/larus/bmhome/chat/CustomMultiAttachmentInfo;", "getImageEditDataWithMask", "()Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;", "getHasImagePreprocessed", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHitPointData", "()Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "getMessageExtMap", "getBizExtMap", "getSendTrackExtMap", "getCreationSendTraceId", "getActionBarCreationId", "getActionBarCreationType", "getLocalIntercepted", "()Z", "getLocalInterceptInfo", "getChatPageContext", "()Lcom/larus/bmhome/chat/bean/ChatPageContext;", "getClearInputContent", "getLyricCreateType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/conversation/Conversation;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Lcom/larus/bmhome/view/AttachmentInfo;Lcom/larus/bmhome/chat/CustomMultiAttachmentInfo;Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;Ljava/lang/Boolean;Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/larus/bmhome/chat/bean/ChatPageContext;ZZLjava/lang/String;)Lcom/larus/uaigc/bean/createpage/CreationSendMessageConfig;", "equals", "other", "", "hashCode", "toString", "Companion", "Builder", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationSendMessageConfig implements Serializable {
    public static final b Companion = null;
    private final String actionBarCreationId;
    private final String actionBarCreationType;
    private final Map<String, String> actionBarInstructionMap;
    private final Integer actionInstruction;
    private final AttachmentInfo attachmentInfo;
    private final Map<String, String> bizExtMap;
    private final String botId;
    private final ChatPageContext chatPageContext;
    private final boolean clearInputContent;
    private final String content;
    private final e conversation;
    private final String creationSendTraceId;
    private final CustomMultiAttachmentInfo customMultiAttachmentInfo;
    private final String cvsId;
    private final String enterMethod;
    private final Boolean hasImagePreprocessed;
    private final u hitPointData;
    private final ImageEditDataWithMask imageEditDataWithMask;
    private final boolean isReEdit;
    private final String localInterceptInfo;
    private final boolean localIntercepted;
    private final String lyricCreateType;
    private final Map<String, String> messageExtMap;
    private final String previousPage;
    private final String scene;
    private final Map<String, String> sendTrackExtMap;
    private final String txtScene;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CreationSendMessageConfig f370355a;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            Object[] r110 = 0 == true ? 1 : 0;
            this.f370355a = new CreationSendMessageConfig(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r110, null, null, null, null, null, false, null, null, false, false, null, 134217727, null);
        }

        public final void a(String r310) {
            this.f370355a = CreationSendMessageConfig.copy$default(this.f370355a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r310, null, false, null, null, false, false, null, 133693439, null);
        }

        public final void b(String r310) {
            this.f370355a = CreationSendMessageConfig.copy$default(this.f370355a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r310, false, null, null, false, false, null, 133169151, null);
        }

        public final void c(Map r310) {
            this.f370355a = CreationSendMessageConfig.copy$default(this.f370355a, null, null, null, null, null, null, null, null, null, r310, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217215, null);
        }

        public final void d(Integer r310) {
            this.f370355a = CreationSendMessageConfig.copy$default(this.f370355a, null, null, null, null, null, null, null, null, r310, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217471, null);
        }

        public final void e(AttachmentInfo r310) {
            this.f370355a = CreationSendMessageConfig.copy$default(this.f370355a, null, null, null, null, null, null, null, null, null, null, r310, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134216703, null);
        }

        public final void f(String r310) {
            this.f370355a = CreationSendMessageConfig.copy$default(this.f370355a, null, r310, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217725, null);
        }

        public final void g(ChatPageContext r310) {
            this.f370355a = CreationSendMessageConfig.copy$default(this.f370355a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, r310, false, false, null, 125829119, null);
        }

        public final void h(boolean r310) {
            this.f370355a = CreationSendMessageConfig.copy$default(this.f370355a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, r310, null, 100663295, null);
        }

        public final void i(String r310) {
            this.f370355a = CreationSendMessageConfig.copy$default(this.f370355a, null, null, null, r310, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217719, null);
        }

        public final void j(e r310) {
            this.f370355a = CreationSendMessageConfig.copy$default(this.f370355a, null, null, r310, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217723, null);
        }

        public final void k(CustomMultiAttachmentInfo r310) {
            this.f370355a = CreationSendMessageConfig.copy$default(this.f370355a, null, null, null, null, null, null, null, null, null, null, null, r310, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134215679, null);
        }

        public final void l(String r310) {
            this.f370355a = CreationSendMessageConfig.copy$default(this.f370355a, r310, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217726, null);
        }

        public final void m(String r310) {
            this.f370355a = CreationSendMessageConfig.copy$default(this.f370355a, null, null, null, null, null, null, r310, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217663, null);
        }

        public final void n(u r310) {
            this.f370355a = CreationSendMessageConfig.copy$default(this.f370355a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r310, null, null, null, null, null, null, false, null, null, false, false, null, 134201343, null);
        }

        public final void o(String r310) {
            CreationSendMessageConfig r100 = this.f370355a;
            if (r310 != null) goto L5;
            String r210 = "";
        L6:
            this.f370355a = CreationSendMessageConfig.copy$default(r100, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, r210, null, false, false, null, 130023423, null);
            return;
        L5:
            r210 = r310;
            goto L6
        }

        public final void p(boolean r310) {
            this.f370355a = CreationSendMessageConfig.copy$default(this.f370355a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r310, null, null, false, false, null, 132120575, null);
        }

        public final void q(Map r310) {
            this.f370355a = CreationSendMessageConfig.copy$default(this.f370355a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r310, null, null, null, null, null, false, null, null, false, false, null, 134184959, null);
        }

        public final void r(String r310) {
            this.f370355a = CreationSendMessageConfig.copy$default(this.f370355a, null, null, null, null, null, null, null, r310, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217599, null);
        }

        public final void s(String r310) {
            this.f370355a = CreationSendMessageConfig.copy$default(this.f370355a, null, null, null, null, r310, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217711, null);
        }

        public final void t(Map r310) {
            this.f370355a = CreationSendMessageConfig.copy$default(this.f370355a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r310, null, null, null, false, null, null, false, false, null, 134086655, null);
        }

        public final void u(String r310) {
            this.f370355a = CreationSendMessageConfig.copy$default(this.f370355a, null, null, null, null, null, r310, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217695, null);
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    public CreationSendMessageConfig() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217727, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreationSendMessageConfig copy$default(CreationSendMessageConfig r110, String r111, String r112, e r210, String r211, String r212, String r213, String r214, String r215, Integer r216, Map r217, AttachmentInfo r218, CustomMultiAttachmentInfo r219, ImageEditDataWithMask r310, Boolean r311, u r312, Map r313, Map r314, Map r315, String r316, String r317, String r318, boolean r319, String r410, ChatPageContext r411, boolean r412, boolean r413, String r414, int r415, Object r416) {
        if ((r415 & 1) == 0) goto L5;
        String r100 = r110.cvsId;
    L7:
        if ((r415 & 2) == 0) goto L9;
        String r101 = r110.botId;
    L11:
        if ((r415 & 4) == 0) goto L13;
        e r102 = r110.conversation;
    L15:
        if ((r415 & 8) == 0) goto L17;
        String r103 = r110.content;
    L19:
        if ((r415 & 16) == 0) goto L21;
        String r104 = r110.scene;
    L23:
        if ((r415 & 32) == 0) goto L25;
        String r105 = r110.txtScene;
    L27:
        if ((r415 & 64) == 0) goto L29;
        String r106 = r110.enterMethod;
    L31:
        if ((r415 & 128) == 0) goto L33;
        String r107 = r110.previousPage;
    L35:
        if ((r415 & 256) == 0) goto L37;
        Integer r113 = r110.actionInstruction;
    L39:
        if ((r415 & 512) == 0) goto L41;
        Map r114 = r110.actionBarInstructionMap;
    L43:
        if ((r415 & 1024) == 0) goto L45;
        AttachmentInfo r115 = r110.attachmentInfo;
    L47:
        if ((r415 & 2048) == 0) goto L49;
        CustomMultiAttachmentInfo r116 = r110.customMultiAttachmentInfo;
    L51:
        if ((r415 & 4096) == 0) goto L53;
        ImageEditDataWithMask r117 = r110.imageEditDataWithMask;
    L55:
        if ((r415 & 8192) == 0) goto L57;
        Boolean r118 = r110.hasImagePreprocessed;
    L58:
        Boolean r320 = r118;
        if ((r415 & 16384) == 0) goto L61;
        u r119 = r110.hitPointData;
    L62:
        u r321 = r119;
        if ((r415 & 32768) == 0) goto L65;
        Map r120 = r110.messageExtMap;
    L66:
        Map r322 = r120;
        if ((r415 & 65536) == 0) goto L69;
        Map r121 = r110.bizExtMap;
    L70:
        Map r323 = r121;
        if ((r415 & 131072) == 0) goto L73;
        Map r122 = r110.sendTrackExtMap;
    L74:
        Map r324 = r122;
        if ((r415 & 262144) == 0) goto L77;
        String r123 = r110.creationSendTraceId;
    L78:
        String r325 = r123;
        if ((r415 & 524288) == 0) goto L81;
        String r124 = r110.actionBarCreationId;
    L82:
        String r326 = r124;
        if ((r415 & 1048576) == 0) goto L85;
        String r125 = r110.actionBarCreationType;
    L86:
        String r327 = r125;
        if ((r415 & 2097152) == 0) goto L89;
        boolean r126 = r110.localIntercepted;
    L90:
        boolean r328 = r126;
        if ((r415 & 4194304) == 0) goto L93;
        String r127 = r110.localInterceptInfo;
    L94:
        String r417 = r127;
        if ((r415 & 8388608) == 0) goto L97;
        ChatPageContext r128 = r110.chatPageContext;
    L98:
        ChatPageContext r418 = r128;
        if ((r415 & 16777216) == 0) goto L101;
        boolean r129 = r110.isReEdit;
    L102:
        boolean r419 = r129;
        if ((r415 & 33554432) == 0) goto L105;
        boolean r130 = r110.clearInputContent;
    L107:
        if ((r415 & 67108864) == 0) goto L109;
        String r108 = r110.lyricCreateType;
    L111:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r417, r418, r419, r130, r108);
    L109:
        r108 = r414;
        goto L111
    L105:
        r130 = r413;
        goto L107
    L101:
        r129 = r412;
        goto L102
    L97:
        r128 = r411;
        goto L98
    L93:
        r127 = r410;
        goto L94
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.cvsId;
    }

    public final Map<String, String> component10() {
        return this.actionBarInstructionMap;
    }

    public final AttachmentInfo component11() {
        return this.attachmentInfo;
    }

    public final CustomMultiAttachmentInfo component12() {
        return this.customMultiAttachmentInfo;
    }

    public final ImageEditDataWithMask component13() {
        return this.imageEditDataWithMask;
    }

    public final Boolean component14() {
        return this.hasImagePreprocessed;
    }

    public final u component15() {
        return this.hitPointData;
    }

    public final Map<String, String> component16() {
        return this.messageExtMap;
    }

    public final Map<String, String> component17() {
        return this.bizExtMap;
    }

    public final Map<String, String> component18() {
        return this.sendTrackExtMap;
    }

    public final String component19() {
        return this.creationSendTraceId;
    }

    public final String component2() {
        return this.botId;
    }

    public final String component20() {
        return this.actionBarCreationId;
    }

    public final String component21() {
        return this.actionBarCreationType;
    }

    public final boolean component22() {
        return this.localIntercepted;
    }

    public final String component23() {
        return this.localInterceptInfo;
    }

    public final ChatPageContext component24() {
        return this.chatPageContext;
    }

    public final boolean component25() {
        return this.isReEdit;
    }

    public final boolean component26() {
        return this.clearInputContent;
    }

    public final String component27() {
        return this.lyricCreateType;
    }

    public final e component3() {
        return this.conversation;
    }

    public final String component4() {
        return this.content;
    }

    public final String component5() {
        return this.scene;
    }

    public final String component6() {
        return this.txtScene;
    }

    public final String component7() {
        return this.enterMethod;
    }

    public final String component8() {
        return this.previousPage;
    }

    public final Integer component9() {
        return this.actionInstruction;
    }

    public final CreationSendMessageConfig copy(String r310, String r311, e r312, String r313, String r314, String r315, String r316, String r317, Integer r318, Map<String, String> r319, AttachmentInfo r410, CustomMultiAttachmentInfo r411, ImageEditDataWithMask r412, Boolean r413, u r414, Map<String, String> r415, Map<String, String> r416, Map<String, String> r417, String r418, String r419, String r510, boolean r511, String r512, ChatPageContext r513, boolean r514, boolean r515, String r516) {
        Intrinsics.checkNotNullParameter(r512, "localInterceptInfo");
        return new CreationSendMessageConfig(r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationSendMessageConfig) == true) goto L8;
        return false;
    L8:
        CreationSendMessageConfig r101 = (CreationSendMessageConfig) r100;
        if (Intrinsics.areEqual(this.cvsId, r101.cvsId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.conversation, r101.conversation) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.txtScene, r101.txtScene) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.previousPage, r101.previousPage) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.actionInstruction, r101.actionInstruction) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.actionBarInstructionMap, r101.actionBarInstructionMap) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.attachmentInfo, r101.attachmentInfo) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.customMultiAttachmentInfo, r101.customMultiAttachmentInfo) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.imageEditDataWithMask, r101.imageEditDataWithMask) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.hasImagePreprocessed, r101.hasImagePreprocessed) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.hitPointData, r101.hitPointData) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.messageExtMap, r101.messageExtMap) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.bizExtMap, r101.bizExtMap) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.sendTrackExtMap, r101.sendTrackExtMap) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.creationSendTraceId, r101.creationSendTraceId) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.actionBarCreationId, r101.actionBarCreationId) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.actionBarCreationType, r101.actionBarCreationType) == true) goto L72;
        return false;
    L72:
        if (this.localIntercepted == r101.localIntercepted) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.localInterceptInfo, r101.localInterceptInfo) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.chatPageContext, r101.chatPageContext) == true) goto L81;
        return false;
    L81:
        if (this.isReEdit == r101.isReEdit) goto L84;
        return false;
    L84:
        if (this.clearInputContent == r101.clearInputContent) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.lyricCreateType, r101.lyricCreateType) == true) goto L89;
        return false;
    L89:
        return true;
    }

    public int hashCode() {
        String r100 = this.cvsId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.botId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        e r107 = this.conversation;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.content;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.scene;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.txtScene;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.enterMethod;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.previousPage;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.actionInstruction;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Map<String, String> r128 = this.actionBarInstructionMap;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        AttachmentInfo r131 = this.attachmentInfo;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        CustomMultiAttachmentInfo r134 = this.customMultiAttachmentInfo;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        ImageEditDataWithMask r137 = this.imageEditDataWithMask;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Boolean r140 = this.hasImagePreprocessed;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        u r143 = this.hitPointData;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        Map<String, String> r146 = this.messageExtMap;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        Map<String, String> r149 = this.bizExtMap;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        Map<String, String> r152 = this.sendTrackExtMap;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.creationSendTraceId;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        String r158 = this.actionBarCreationId;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        String r161 = this.actionBarCreationType;
        if (r161 != null) goto L85;
        int r162 = 0;
    L86:
        int r163 = (r160 + r162) * 31;
        int r164 = 1231;
        if (this.localIntercepted == false) goto L89;
        int r165 = 1231;
    L90:
        int r166 = (((r163 + r165) * 31) + this.localInterceptInfo.hashCode()) * 31;
        ChatPageContext r167 = this.chatPageContext;
        if (r167 != null) goto L93;
        int r168 = 0;
    L94:
        int r169 = (r166 + r168) * 31;
        if (this.isReEdit == false) goto L97;
        int r170 = 1231;
    L98:
        int r171 = (r169 + r170) * 31;
        if (this.clearInputContent == true) goto L102;
        r164 = 1237;
    L102:
        int r172 = (r171 + r164) * 31;
        String r173 = this.lyricCreateType;
        if (r173 == null) goto L107;
        r101 = r173.hashCode();
    L107:
        return r172 + r101;
    L97:
        r170 = 1237;
        goto L98
    L93:
        r168 = r167.hashCode();
        goto L94
    L89:
        r165 = 1237;
        goto L90
    L85:
        r162 = r161.hashCode();
        goto L86
    L81:
        r159 = r158.hashCode();
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationSendMessageConfig(cvsId=" + this.cvsId + ", botId=" + this.botId + ", conversation=" + this.conversation + ", content=" + this.content + ", scene=" + this.scene + ", txtScene=" + this.txtScene + ", enterMethod=" + this.enterMethod + ", previousPage=" + this.previousPage + ", actionInstruction=" + this.actionInstruction + ", actionBarInstructionMap=" + this.actionBarInstructionMap + ", attachmentInfo=" + this.attachmentInfo + ", customMultiAttachmentInfo=" + this.customMultiAttachmentInfo + ", imageEditDataWithMask=" + this.imageEditDataWithMask + ", hasImagePreprocessed=" + this.hasImagePreprocessed + ", hitPointData=" + this.hitPointData + ", messageExtMap=" + this.messageExtMap + ", bizExtMap=" + this.bizExtMap + ", sendTrackExtMap=" + this.sendTrackExtMap + ", creationSendTraceId=" + this.creationSendTraceId + ", actionBarCreationId=" + this.actionBarCreationId + ", actionBarCreationType=" + this.actionBarCreationType + ", localIntercepted=" + this.localIntercepted + ", localInterceptInfo=" + this.localInterceptInfo + ", chatPageContext=" + this.chatPageContext + ", isReEdit=" + this.isReEdit + ", clearInputContent=" + this.clearInputContent + ", lyricCreateType=" + this.lyricCreateType + ')';
    }

    public final String getActionBarCreationId() {
        return this.actionBarCreationId;
    }

    public final String getActionBarCreationType() {
        return this.actionBarCreationType;
    }

    public final Map<String, String> getActionBarInstructionMap() {
        return this.actionBarInstructionMap;
    }

    public final Integer getActionInstruction() {
        return this.actionInstruction;
    }

    public final AttachmentInfo getAttachmentInfo() {
        return this.attachmentInfo;
    }

    public final Map<String, String> getBizExtMap() {
        return this.bizExtMap;
    }

    public final String getBotId() {
        return this.botId;
    }

    public final ChatPageContext getChatPageContext() {
        return this.chatPageContext;
    }

    public final boolean getClearInputContent() {
        return this.clearInputContent;
    }

    public final String getContent() {
        return this.content;
    }

    public final e getConversation() {
        return this.conversation;
    }

    public final String getCreationSendTraceId() {
        return this.creationSendTraceId;
    }

    public final CustomMultiAttachmentInfo getCustomMultiAttachmentInfo() {
        return this.customMultiAttachmentInfo;
    }

    public final String getCvsId() {
        return this.cvsId;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final Boolean getHasImagePreprocessed() {
        return this.hasImagePreprocessed;
    }

    public final u getHitPointData() {
        return this.hitPointData;
    }

    public final ImageEditDataWithMask getImageEditDataWithMask() {
        return this.imageEditDataWithMask;
    }

    public final String getLocalInterceptInfo() {
        return this.localInterceptInfo;
    }

    public final boolean getLocalIntercepted() {
        return this.localIntercepted;
    }

    public final String getLyricCreateType() {
        return this.lyricCreateType;
    }

    public final Map<String, String> getMessageExtMap() {
        return this.messageExtMap;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final String getScene() {
        return this.scene;
    }

    public final Map<String, String> getSendTrackExtMap() {
        return this.sendTrackExtMap;
    }

    public final String getTxtScene() {
        return this.txtScene;
    }

    public final boolean isReEdit() {
        return this.isReEdit;
    }

    public CreationSendMessageConfig(String r100, String r101, e r102, String r103, String r104, String r105, String r110, String r111, Integer r112, Map<String, String> r113, AttachmentInfo r114, CustomMultiAttachmentInfo r115, ImageEditDataWithMask r116, Boolean r117, u r118, Map<String, String> r119, Map<String, String> r210, Map<String, String> r211, String r212, String r213, String r214, boolean r215, String r216, ChatPageContext r217, boolean r218, boolean r219, String r310) {
        Intrinsics.checkNotNullParameter(r216, "localInterceptInfo");
        this.cvsId = r100;
        this.botId = r101;
        this.conversation = r102;
        this.content = r103;
        this.scene = r104;
        this.txtScene = r105;
        this.enterMethod = r110;
        this.previousPage = r111;
        this.actionInstruction = r112;
        this.actionBarInstructionMap = r113;
        this.attachmentInfo = r114;
        this.customMultiAttachmentInfo = r115;
        this.imageEditDataWithMask = r116;
        this.hasImagePreprocessed = r117;
        this.hitPointData = r118;
        this.messageExtMap = r119;
        this.bizExtMap = r210;
        this.sendTrackExtMap = r211;
        this.creationSendTraceId = r212;
        this.actionBarCreationId = r213;
        this.actionBarCreationType = r214;
        this.localIntercepted = r215;
        this.localInterceptInfo = r216;
        this.chatPageContext = r217;
        this.isReEdit = r218;
        this.clearInputContent = r219;
        this.lyricCreateType = r310;
    }

    public /* synthetic */ CreationSendMessageConfig(String r210, String r310, e r311, String r312, String r313, String r314, String r315, String r316, Integer r317, Map r318, AttachmentInfo r319, CustomMultiAttachmentInfo r410, ImageEditDataWithMask r411, Boolean r412, u r413, Map r414, Map r415, Map r416, String r417, String r418, String r419, boolean r510, String r511, ChatPageContext r512, boolean r513, boolean r514, String r515, int r516, DefaultConstructorMarker r517) {
        if ((r516 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r516 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r516 & 4) == 0) goto L13;
        e r102 = null;
    L15:
        if ((r516 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r516 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r516 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r516 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r516 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r516 & 256) == 0) goto L37;
        Integer r110 = null;
    L39:
        if ((r516 & 512) == 0) goto L41;
        Map r111 = null;
    L43:
        if ((r516 & 1024) == 0) goto L45;
        AttachmentInfo r112 = null;
    L47:
        if ((r516 & 2048) == 0) goto L49;
        CustomMultiAttachmentInfo r113 = null;
    L51:
        if ((r516 & 4096) == 0) goto L53;
        ImageEditDataWithMask r114 = null;
    L55:
        if ((r516 & 8192) == 0) goto L57;
        Boolean r115 = null;
    L59:
        if ((r516 & 16384) == 0) goto L61;
        u r108 = null;
    L63:
        if ((r516 & 32768) == 0) goto L65;
        Map r116 = null;
    L67:
        if ((r516 & 65536) == 0) goto L69;
        Map r117 = null;
    L71:
        if ((r516 & 131072) == 0) goto L73;
        Map r118 = null;
    L75:
        if ((r516 & 262144) == 0) goto L77;
        String r119 = null;
    L79:
        if ((r516 & 524288) == 0) goto L81;
        String r211 = null;
    L83:
        if ((r516 & 1048576) == 0) goto L85;
        String r212 = null;
    L86:
        boolean r213 = false;
        if ((r516 & 2097152) == 0) goto L89;
        boolean r214 = false;
    L91:
        if ((r516 & 4194304) == 0) goto L93;
        String r215 = "";
    L95:
        if ((r516 & 8388608) == 0) goto L97;
        ChatPageContext r216 = null;
    L99:
        if ((r516 & 16777216) != 0) goto L103;
        r213 = r513;
    L103:
        if ((r516 & 33554432) == 0) goto L105;
        boolean r217 = true;
    L107:
        if ((r516 & 67108864) == 0) goto L109;
        String r109 = null;
    L110:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r211, r212, r214, r215, r216, r213, r217, r109);
        return;
    L109:
        r109 = r515;
        goto L110
    L105:
        r217 = r514;
        goto L107
    L97:
        r216 = r512;
        goto L99
    L93:
        r215 = r511;
        goto L95
    L89:
        r214 = r510;
        goto L91
    L85:
        r212 = r419;
        goto L86
    L81:
        r211 = r418;
        goto L83
    L77:
        r119 = r417;
        goto L79
    L73:
        r118 = r416;
        goto L75
    L69:
        r117 = r415;
        goto L71
    L65:
        r116 = r414;
        goto L67
    L61:
        r108 = r413;
        goto L63
    L57:
        r115 = r412;
        goto L59
    L53:
        r114 = r411;
        goto L55
    L49:
        r113 = r410;
        goto L51
    L45:
        r112 = r319;
        goto L47
    L41:
        r111 = r318;
        goto L43
    L37:
        r110 = r317;
        goto L39
    L33:
        r107 = r316;
        goto L35
    L29:
        r106 = r315;
        goto L31
    L25:
        r105 = r314;
        goto L27
    L21:
        r104 = r313;
        goto L23
    L17:
        r103 = r312;
        goto L19
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = r310;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
