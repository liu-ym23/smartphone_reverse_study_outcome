package com.larus.voicecall.api.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/larus/voicecall/api/bean/ModeControlParams;", "", "<init>", "()V", "hangupWaitTimes", "", "getHangupWaitTimes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModeControlParams {

    @SerializedName("hangup_wait_time_s")
    private final Integer hangupWaitTimes;

    public ModeControlParams() {
    }

    public final Integer getHangupWaitTimes() {
        return this.hangupWaitTimes;
    }
}
