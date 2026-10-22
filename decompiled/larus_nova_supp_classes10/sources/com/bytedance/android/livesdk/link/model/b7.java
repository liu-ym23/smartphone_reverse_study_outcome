package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/b7;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/s1;", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b7 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.s1>, com.bytedance.android.livesdk.link.model.bridge.s1 {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "linkmic_infos")
    /* synthetic */ Map<Long, String> getChannelMap();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "use_multi_channel")
    /* synthetic */ boolean getUseMultiChannel();

    @FieldName(name = "linkmic_infos#setter")
    /* synthetic */ void setChannelMap(Map<Long, String> r1);

    @FieldName(name = "use_multi_channel#setter")
    /* synthetic */ void setUseMultiChannel(boolean r1);
}
