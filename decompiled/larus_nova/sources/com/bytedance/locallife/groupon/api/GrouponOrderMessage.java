package com.bytedance.locallife.groupon.api;

import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/locallife/groupon/api/GrouponOrderMessage;", "Ljava/io/Serializable;", "()V", "msgType", "", "getMsgType", "()Ljava/lang/Integer;", "setMsgType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "statusCode", "getStatusCode", "setStatusCode", "toastContent", "", "getToastContent", "()Ljava/lang/String;", "setToastContent", "(Ljava/lang/String;)V", UserInfo.UPDATE_TIME, "", "getUpdateTime", "()J", "setUpdateTime", "(J)V", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GrouponOrderMessage implements Serializable {

    @SerializedName(SeiMessageConst.MSG_TYPE)
    private Integer msgType;

    @SerializedName("status_code")
    private Integer statusCode;

    @SerializedName("toast_content")
    private String toastContent;

    @SerializedName("update_time")
    private long updateTime;

    public GrouponOrderMessage() {
        this.toastContent = "";
    }

    public final Integer getMsgType() {
        return this.msgType;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public final String getToastContent() {
        return this.toastContent;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final void setMsgType(Integer r100) {
        this.msgType = r100;
    }

    public final void setStatusCode(Integer r100) {
        this.statusCode = r100;
    }

    public final void setToastContent(String r100) {
        this.toastContent = r100;
    }

    public final void setUpdateTime(long r100) {
        this.updateTime = r100;
    }
}
