package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/f;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/link/model/bridge/q1;", "getRtcLiveCoreData", "()Lcom/bytedance/android/livesdk/link/model/bridge/q1;", "getRtcLiveCoreData$annotations", "()V", "rtcLiveCoreData", "", "getMultiDefaultAnchorLayout", "()I", "getMultiDefaultAnchorLayout$annotations", "multiDefaultAnchorLayout", "Lcom/bytedance/android/livesdk/link/model/bridge/h;", "getAnchorLayOutInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/h;", "getAnchorLayOutInfo$annotations", "anchorLayOutInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f extends vh7.c<f> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "layout_info")
    h getAnchorLayOutInfo();

    @FieldName(name = "anchor_ui_layout")
    int getMultiDefaultAnchorLayout();

    @FieldName(name = "rtc_live_core_data")
    q1 getRtcLiveCoreData();
}
