package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("live.IntelligentPopMessage")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/IntelligentPopMessage;", "Lsg2/a;", "", "isNormalPromotion", "", "toJsonString", "", "msgType", "I", "bubbleType", "", "promotionId", "J", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2DelayParam;", "delayParam", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2DelayParam;", "", "params", "Ljava/util/Map;", "listTopPath", "Ljava/lang/String;", "popPath", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntelligentPopMessage extends sg2.a {

    @SerializedName("bubble_type")
    public int bubbleType;

    @SerializedName("delay_param")
    public ECV2DelayParam delayParam;

    @SerializedName("list_top_path")
    public String listTopPath;

    @SerializedName("msg_type")
    public int msgType;

    @SerializedName("params")
    public Map<String, String> params;

    @SerializedName("pop_path")
    public String popPath;

    @SerializedName("promotion_id")
    public long promotionId;

    public final boolean isNormalPromotion() {
        if (this.bubbleType != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // sg2.a
    public String toJsonString() {
        return new Gson().toJson(this);
    L4:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return toString();
    }

    public IntelligentPopMessage() {
    }
}
