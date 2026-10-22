package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\r\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013RB\u0010\u001d\u001a*\u0012\b\u0012\u00060\bj\u0002`\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016j\u0014\u0012\b\u0012\u00060\bj\u0002`\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/d1;", "Lvh7/c;", "", "getLinkMicIdStr", "()Ljava/lang/String;", "getLinkMicIdStr$annotations", "()V", "linkMicIdStr", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getLinkMicId", "()Ljava/lang/Long;", "getLinkMicId$annotations", "linkMicId", "getRtcExtInfo", "getRtcExtInfo$annotations", "rtcExtInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/s1;", "getMultiChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/s1;", "getMultiChannelInfo$annotations", "multiChannelInfo", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/LinkerId;", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getLinkerContentMap", "()Ljava/util/Map;", "getLinkerContentMap$annotations", "linkerContentMap", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d1 extends vh7.c<d1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "link_mic_id")
    Long getLinkMicId();

    @FieldName(name = "linkmic_id_str")
    String getLinkMicIdStr();

    @FieldName(name = "linker_content_map")
    Map<Long, g2> getLinkerContentMap();

    @FieldName(name = "multi_channel_info")
    s1 getMultiChannelInfo();

    @FieldName(name = "rtc_ext_info")
    String getRtcExtInfo();
}
