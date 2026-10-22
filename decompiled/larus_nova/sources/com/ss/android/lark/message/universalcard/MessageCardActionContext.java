package com.ss.android.lark.message.universalcard;

import com.google.gson.JsonObject;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.component.card.protocol.context.ActionContext;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/message/universalcard/MessageCardActionContext;", "Lcom/larksuite/component/card/protocol/context/ActionContext;", RemoteMessageConst.MSGID, "", "chatId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getMsgId", "()Ljava/lang/String;", "getChatId", "toJson", "Lcom/google/gson/JsonObject;", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageCardActionContext extends ActionContext {
    private final String chatId;
    private final String msgId;

    @Override // com.larksuite.component.card.protocol.context.ActionContext
    public JsonObject toJson() {
        JsonObject r100 = new JsonObject();
        r100.addProperty(MusicAppletPage.KEY_MESSAGE_ID, this.msgId);
        r100.addProperty("chat_id", this.chatId);
        return r100;
    }

    public final String getChatId() {
        return this.chatId;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public MessageCardActionContext(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "chatId");
        this.msgId = r100;
        this.chatId = r101;
    }
}
