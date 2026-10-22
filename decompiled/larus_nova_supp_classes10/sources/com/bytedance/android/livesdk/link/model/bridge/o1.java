package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001RB\u0010\u000b\u001a*\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002j\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bRB\u0010\u000e\u001a*\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002j\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/o1;", "Lvh7/c;", "", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getRtcInfoMap", "()Ljava/util/Map;", "getRtcInfoMap$annotations", "()V", "rtcInfoMap", "getPushStreamModeRTCMap", "getPushStreamModeRTCMap$annotations", "pushStreamModeRTCMap", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface o1 extends vh7.c<o1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "push_stream_mode_rtc_map")
    Map<Long, String> getPushStreamModeRTCMap();

    @FieldName(name = "rtc_info_map")
    Map<Long, String> getRtcInfoMap();
}
