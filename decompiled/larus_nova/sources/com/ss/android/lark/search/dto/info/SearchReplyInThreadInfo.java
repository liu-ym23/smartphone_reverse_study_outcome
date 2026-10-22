package com.ss.android.lark.search.dto.info;

import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchReplyInThreadInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "<init>", "()V", "chatType", "Lcom/ss/android/lark/chat/entity/chat/Chat$Type;", "getChatType", "()Lcom/ss/android/lark/chat/entity/chat/Chat$Type;", "setChatType", "(Lcom/ss/android/lark/chat/entity/chat/Chat$Type;)V", "chatId", "", "getChatId", "()Ljava/lang/String;", "setChatId", "(Ljava/lang/String;)V", "p2pChatterId", "getP2pChatterId", "setP2pChatterId", "getEntityId", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchReplyInThreadInfo extends SearchBaseInfo {
    private String chatId;
    private Chat.Type chatType;
    private String p2pChatterId;

    public final String getEntityId() {
        if (this.chatType != Chat.Type.P2P) goto L6;
        return this.p2pChatterId;
    L6:
        return this.chatId;
    }

    public SearchReplyInThreadInfo() {
        this.chatId = "";
        this.p2pChatterId = "";
    }

    public final String getChatId() {
        return this.chatId;
    }

    public final Chat.Type getChatType() {
        return this.chatType;
    }

    public final String getP2pChatterId() {
        return this.p2pChatterId;
    }

    public final void setChatId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.chatId = r100;
    }

    public final void setChatType(Chat.Type r100) {
        this.chatType = r100;
    }

    public final void setP2pChatterId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.p2pChatterId = r100;
    }
}
