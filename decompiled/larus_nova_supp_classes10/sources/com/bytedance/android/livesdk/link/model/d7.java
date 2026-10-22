package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/d7;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "", "getScene", "()I", "getScene$annotations", "()V", "scene", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d7 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.u1>, com.bytedance.android.livesdk.link.model.bridge.u1 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "ktv_live_core_info")
    /* synthetic */ com.bytedance.android.livesdk.chatroom.model.interact.i0 getKtvLiveCoreInfo();

    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.p1 getMultiAnchorLiveCoreInfo();

    @FieldName(name = "scene")
    int getScene();

    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.i2 getSingingChallengeLiveCoreInfo();

    @FieldName(name = "video_equal_room_live_core_info")
    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.l2 getVideoEqualRoomLiveCoreInfo();

    @FieldName(name = "video_position_live_core_info")
    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.m2 getVideoPositionLiveCoreInfo();

    @FieldName(name = "ktv_live_core_info#setter")
    /* synthetic */ void setKtvLiveCoreInfo(com.bytedance.android.livesdk.chatroom.model.interact.i0 r1);
}
