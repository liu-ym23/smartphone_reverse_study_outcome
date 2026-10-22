package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larus/platform/model/audio/RealtimeCallBtnPositionConfig;", "", "<init>", "()V", "realtimeCallBtnShowTopRight", "", "getRealtimeCallBtnShowTopRight", "()Z", "setRealtimeCallBtnShowTopRight", "(Z)V", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallBtnPositionConfig {

    @SerializedName("realtime_call_btn_show_top_right")
    private boolean realtimeCallBtnShowTopRight;

    public RealtimeCallBtnPositionConfig() {
        this.realtimeCallBtnShowTopRight = true;
    }

    public final boolean getRealtimeCallBtnShowTopRight() {
        return this.realtimeCallBtnShowTopRight;
    }

    public final void setRealtimeCallBtnShowTopRight(boolean r100) {
        this.realtimeCallBtnShowTopRight = r100;
    }
}
