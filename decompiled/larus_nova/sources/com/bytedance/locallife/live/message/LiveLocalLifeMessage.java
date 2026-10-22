package com.bytedance.locallife.live.message;

import com.bytedance.android.livehostapi.business.depend.livead.model.ILiveLocalLifeMessage;
import com.bytedance.android.livesdkapi.message.ExternalBaseMessage;
import com.bytedance.android.livesdkapi.message.ExternalMessageType;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import mv6.e;

/* JADX INFO: loaded from: classes21.dex */
@ProtoMessage("webcast.im.DataLifeLiveMessage")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0007\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001%B\u0007¢\u0006\u0004\b\"\u0010#J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0006\u0010\u000b\u001a\u00020\nR\"\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018¨\u0006&"}, d2 = {"Lcom/bytedance/locallife/live/message/LiveLocalLifeMessage;", "Lcom/bytedance/android/livesdkapi/message/ExternalBaseMessage;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/ILiveLocalLifeMessage;", "Lmv6/e;", "getMessageBody", "Lcom/bytedance/android/livesdkapi/message/ExternalMessageType;", "getExternalMessageType", "", "getIntType", "getUpdateType", "", "isRefreshSingleCard", "type", "I", "getType", "()I", "setType", "(I)V", "", ContainerPosition.BODY, "Ljava/lang/String;", "getBody", "()Ljava/lang/String;", "setBody", "(Ljava/lang/String;)V", "_messageBody", "Lmv6/e;", "get_messageBody", "()Lmv6/e;", "set_messageBody", "(Lmv6/e;)V", "uniqueKey", "getUniqueKey", "setUniqueKey", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLocalLifeMessage extends ExternalBaseMessage implements ILiveLocalLifeMessage {
    public static final a Companion = null;
    public static final int INT_TYPE = 3001;
    public static final int MSG_TYPE_AGG_CARD_UPDATE = 8;
    public static final int MSG_TYPE_ATMOSPHERE = 5;
    public static final int MSG_TYPE_LOTTERY_CONDITION_FINISH = 9;
    public static final int MSG_TYPE_LOTTERY_UPDATE = 4;
    public static final int MSG_TYPE_LOTTERY_UPDATE_REF = 7;
    public static final int MSG_TYPE_REFRESH_CARD_LIST = 3;
    public static final int MSG_TYPE_REFRESH_GROUPON_INFO = 1;
    public static final int MSG_TYPE_UPDATE_GROUPON_INFO_V2 = 2;
    public static final int MSG_TYPE_USER_ADDRESS_UPDATE = 101;
    private e _messageBody;

    @SerializedName(ContainerPosition.BODY)
    private String body;

    @SerializedName("type")
    private int type;
    private String uniqueKey;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.android.livesdkapi.message.ExternalBaseMessage, com.bytedance.android.livesdkapi.message.BaseMessage, tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public int getIntType() {
        return 3001;
    }

    public final e getMessageBody() {
        if (this._messageBody != null) goto L9;
        this._messageBody = (e) LiveLifeSaaSUtil.r().fromJson(this.body, e.class);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.getLocalizedMessage();
    L9:
        return this._messageBody;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.model.ILiveLocalLifeMessage
    public int getUpdateType() {
        e r100 = getMessageBody();
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.f();
    }

    public final boolean isRefreshSingleCard() {
        e r100 = getMessageBody();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.e();
    }

    public LiveLocalLifeMessage() {
    }

    public final String getBody() {
        return this.body;
    }

    @Override // com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public ExternalMessageType getExternalMessageType() {
        return ExternalMessageType.EXTERNAL_LIVE_LIFE;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUniqueKey() {
        return this.uniqueKey;
    }

    public final e get_messageBody() {
        return this._messageBody;
    }

    public final void setBody(String r100) {
        this.body = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public final void setUniqueKey(String r100) {
        this.uniqueKey = r100;
    }

    public final void set_messageBody(e r100) {
        this._messageBody = r100;
    }
}
