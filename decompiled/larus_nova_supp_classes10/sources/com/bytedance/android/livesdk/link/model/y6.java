package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/y6;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/q1;", "", "Lcom/bytedance/android/livesdk/link/model/p;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getAnchorUserList", "()Ljava/util/List;", "getAnchorUserList$annotations", "()V", "anchorUserList", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface y6 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.q1>, com.bytedance.android.livesdk.link.model.bridge.q1 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "linked_users")
    List<p> getAnchorUserList();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "multi_live_core_info")
    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.u1 getLiveCoreInfo();

    @FieldName(name = "multi_rtc_info")
    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.v1 getRtcInfo();
}
