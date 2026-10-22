package com.ss.android.lark.url.card.action;

import com.google.gson.JsonObject;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.component.card.protocol.context.ActionContext;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/url/card/action/UrlCardActionContext;", "Lcom/larksuite/component/card/protocol/context/ActionContext;", RemoteMessageConst.MSGID, "", "chatId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getChatId", "()Ljava/lang/String;", "toJson", "Lcom/google/gson/JsonObject;", "url-card_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlCardActionContext extends ActionContext {
    private final String chatId;
    private final String msgId;

    /* JADX WARN: Multi-variable type inference failed */
    public UrlCardActionContext() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

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

    public UrlCardActionContext(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "chatId");
        this.msgId = r100;
        this.chatId = r101;
    }

    public /* synthetic */ UrlCardActionContext(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
