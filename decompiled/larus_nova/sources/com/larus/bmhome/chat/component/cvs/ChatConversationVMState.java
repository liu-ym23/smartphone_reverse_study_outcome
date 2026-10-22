package com.larus.bmhome.chat.component.cvs;

import com.larus.im.bean.bot.BotModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u001a\u001a\u00020\u0003H\u0016J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JS\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006("}, d2 = {"Lcom/larus/bmhome/chat/component/cvs/ChatConversationVMState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "conversationId", "", "botId", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "bot", "Lcom/larus/im/bean/bot/BotModel;", "botModelUpdated", "", "conversationIsNull", "boundUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/conversation/Conversation;Lcom/larus/im/bean/bot/BotModel;ZZLjava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "getBotId", "getConversation", "()Lcom/larus/im/bean/conversation/Conversation;", "getBot", "()Lcom/larus/im/bean/bot/BotModel;", "getBotModelUpdated", "()Z", "getConversationIsNull", "getBoundUserId", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatConversationVMState implements w1a.b {
    private final BotModel bot;
    private final String botId;
    private final boolean botModelUpdated;
    private final String boundUserId;
    private final wc9.e conversation;
    private final String conversationId;
    private final boolean conversationIsNull;

    public ChatConversationVMState() {
        this(null, null, null, null, false, false, null, 127, null);
    }

    public static /* synthetic */ ChatConversationVMState copy$default(ChatConversationVMState r100, String r101, String r102, wc9.e r103, BotModel r104, boolean r110, boolean r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.conversationId;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.botId;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.conversation;
    L11:
        wc9.e r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.bot;
    L14:
        BotModel r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.botModelUpdated;
    L17:
        boolean r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.conversationIsNull;
    L20:
        boolean r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.boundUserId;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.conversationId;
    }

    public final String component2() {
        return this.botId;
    }

    public final wc9.e component3() {
        return this.conversation;
    }

    public final BotModel component4() {
        return this.bot;
    }

    public final boolean component5() {
        return this.botModelUpdated;
    }

    public final boolean component6() {
        return this.conversationIsNull;
    }

    public final String component7() {
        return this.boundUserId;
    }

    public final ChatConversationVMState copy(String r110, String r111, wc9.e r112, BotModel r113, boolean r114, boolean r115, String r116) {
        Intrinsics.checkNotNullParameter(r110, "conversationId");
        Intrinsics.checkNotNullParameter(r111, "botId");
        Intrinsics.checkNotNullParameter(r116, "boundUserId");
        return new ChatConversationVMState(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatConversationVMState) == true) goto L8;
        return false;
    L8:
        ChatConversationVMState r101 = (ChatConversationVMState) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.conversation, r101.conversation) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bot, r101.bot) == true) goto L21;
        return false;
    L21:
        if (this.botModelUpdated == r101.botModelUpdated) goto L24;
        return false;
    L24:
        if (this.conversationIsNull == r101.conversationIsNull) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.boundUserId, r101.boundUserId) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.conversationId.hashCode() * 31) + this.botId.hashCode()) * 31;
        wc9.e r101 = this.conversation;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        BotModel r105 = this.bot;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (r104 + r102) * 31;
        int r107 = 1231;
        if (this.botModelUpdated == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.conversationIsNull == true) goto L19;
        r107 = 1237;
    L19:
        return ((r109 + r107) * 31) + this.boundUserId.hashCode();
    L13:
        r108 = 1237;
        goto L14
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return super.toString();
    }

    public final BotModel getBot() {
        return this.bot;
    }

    public final String getBotId() {
        return this.botId;
    }

    public final boolean getBotModelUpdated() {
        return this.botModelUpdated;
    }

    public final String getBoundUserId() {
        return this.boundUserId;
    }

    public final wc9.e getConversation() {
        return this.conversation;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final boolean getConversationIsNull() {
        return this.conversationIsNull;
    }

    public ChatConversationVMState(String r100, String r101, wc9.e r102, BotModel r103, boolean r104, boolean r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "botId");
        Intrinsics.checkNotNullParameter(r106, "boundUserId");
        this.conversationId = r100;
        this.botId = r101;
        this.conversation = r102;
        this.bot = r103;
        this.botModelUpdated = r104;
        this.conversationIsNull = r105;
        this.boundUserId = r106;
    }

    public /* synthetic */ ChatConversationVMState(String r100, String r101, wc9.e r102, BotModel r110, boolean r111, boolean r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = "";
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r114 & 4) == 0) goto L13;
        wc9.e r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        BotModel r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r114 & 32) == 0) goto L25;
        boolean r107 = false;
    L27:
        if ((r114 & 64) == 0) goto L29;
        String r117 = "";
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
