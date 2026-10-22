package com.ss.android.lark.message.lynxcard.settings;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: classes36.dex */
@AppConfig(key = "lynx_card_message_render_start_time")
public class CardMessageUserLynxRenderSettings {

    @SerializedName(ILoadStallMonitor.START_TIME)
    public int start_time;

    public CardMessageUserLynxRenderSettings() {
    }
}
