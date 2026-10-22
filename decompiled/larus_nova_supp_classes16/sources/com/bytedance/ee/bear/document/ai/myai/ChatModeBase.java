package com.bytedance.ee.bear.document.ai.myai;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR.\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/myai/ChatModeBase;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "bizType", "", "getBizType", "()Ljava/lang/String;", "setBizType", "(Ljava/lang/String;)V", "aiChatModeId", "", "getAiChatModeId", "()Ljava/lang/Long;", "setAiChatModeId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "chatId", "getChatId", "setChatId", "actions", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/document/ai/myai/ActionButton;", "Lkotlin/collections/ArrayList;", "getActions", "()Ljava/util/ArrayList;", "setActions", "(Ljava/util/ArrayList;)V", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatModeBase implements NonProguard {
    private ArrayList<ActionButton> actions;
    private Long aiChatModeId;
    private String bizType;
    private String chatId;

    public ChatModeBase() {
    }

    public String toString() {
        return "ChatModeBase(bizType=" + this.bizType + ", aiChatModeId=" + this.aiChatModeId + ", chatId=" + this.chatId + ", actions=" + this.actions + ')';
    }

    public final ArrayList<ActionButton> getActions() {
        return this.actions;
    }

    public final Long getAiChatModeId() {
        return this.aiChatModeId;
    }

    public final String getBizType() {
        return this.bizType;
    }

    public final String getChatId() {
        return this.chatId;
    }

    public final void setActions(ArrayList<ActionButton> r1) {
        this.actions = r1;
    }

    public final void setAiChatModeId(Long r1) {
        this.aiChatModeId = r1;
    }

    public final void setBizType(String r1) {
        this.bizType = r1;
    }

    public final void setChatId(String r1) {
        this.chatId = r1;
    }
}
