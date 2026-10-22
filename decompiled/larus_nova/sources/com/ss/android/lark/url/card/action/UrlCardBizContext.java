package com.ss.android.lark.url.card.action;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.lark.pb.openplatform.v1.UniversalCardBizType;
import com.google.gson.JsonObject;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.component.card.protocol.context.BizContext;
import com.ss.android.lark.url.card.data.UrlCardLocalDataStore;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/url/card/action/UrlCardBizContext;", "Lcom/larksuite/component/card/protocol/context/BizContext;", RemoteMessageConst.MSGID, "", "chatId", "bizId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMsgId", "()Ljava/lang/String;", "getChatId", "localDataStore", "Lcom/ss/android/lark/url/card/data/UrlCardLocalDataStore;", "getLocalDataStore", "()Lcom/ss/android/lark/url/card/data/UrlCardLocalDataStore;", "localDataStore$delegate", "Lkotlin/Lazy;", "toJson", "Lcom/google/gson/JsonObject;", "url-card_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlCardBizContext extends BizContext {
    private final String chatId;
    private final Lazy localDataStore$delegate;
    private final String msgId;

    public final UrlCardLocalDataStore getLocalDataStore() {
        return (UrlCardLocalDataStore) this.localDataStore$delegate.getValue();
    }

    @Override // com.larksuite.component.card.protocol.context.BizContext
    public JsonObject toJson() {
        JsonObject r100 = new JsonObject();
        r100.addProperty("msg_id", this.msgId);
        r100.addProperty("chat_id", this.chatId);
        r100.addProperty(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, getBizId());
        r100.addProperty("biz_type", Integer.valueOf(getBizType().getValue()));
        return r100;
    }

    public final String getChatId() {
        return this.chatId;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public UrlCardBizContext(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "chatId");
        Intrinsics.checkNotNullParameter(r102, "bizId");
        super(r102, UniversalCardBizType.BIZ_TYPE_URL_PREVIEW);
        this.msgId = r100;
        this.chatId = r101;
        this.localDataStore$delegate = LazyKt.lazy(UrlCardBizContext$localDataStore$2.INSTANCE);
    }

    public /* synthetic */ UrlCardBizContext(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101, r102);
    }
}
