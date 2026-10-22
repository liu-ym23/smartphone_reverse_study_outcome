package com.ss.android.lark.chat.export.entity.message.content;

import com.ss.android.lark.chat.export.entity.chatter.OpenChatter;
import com.ss.android.lark.chat.export.entity.message.Content;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0012\u0010\u001d\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001cR\u0012\u0010\u001e\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0012\u0010\u001f\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001cR\u0012\u0010 \u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001c¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chat/export/entity/message/content/OpenSystemContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "<init>", "()V", "type", "Lcom/ss/android/lark/chat/export/entity/message/content/SystemMessageType;", "getType", "()Lcom/ss/android/lark/chat/export/entity/message/content/SystemMessageType;", "formattedContent", "", "getFormattedContent", "()Ljava/lang/CharSequence;", "fromChatterId", "", "getFromChatterId", "()Ljava/lang/String;", "toChatterId", "getToChatterId", "triggerId", "getTriggerId", "fromChatter", "Lcom/ss/android/lark/chat/export/entity/chatter/OpenChatter;", "getFromChatter", "()Lcom/ss/android/lark/chat/export/entity/chatter/OpenChatter;", "toChatter", "getToChatter", "isVoIPSystemMessage", "", "()Z", "isVCSystemMessage", "isRedPackSystemMessage", "isMyAINewTopic", "isMockMyAIToolMessage", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class OpenSystemContent extends Content {
    public abstract CharSequence getFormattedContent();

    public abstract OpenChatter getFromChatter();

    public abstract String getFromChatterId();

    public abstract OpenChatter getToChatter();

    public abstract String getToChatterId();

    public abstract String getTriggerId();

    public abstract SystemMessageType getType();

    public abstract boolean isMockMyAIToolMessage();

    public abstract boolean isMyAINewTopic();

    public abstract boolean isRedPackSystemMessage();

    public abstract boolean isVCSystemMessage();

    public abstract boolean isVoIPSystemMessage();

    public OpenSystemContent() {
    }
}
