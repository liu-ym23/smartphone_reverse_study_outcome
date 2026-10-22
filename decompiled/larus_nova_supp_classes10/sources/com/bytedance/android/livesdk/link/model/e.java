package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/e;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/d;", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface e extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.d>, com.bytedance.android.livesdk.link.model.bridge.d {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "avatar_medium")
    /* synthetic */ py.k getAvatar();

    @FieldName(name = "belong_room_id")
    /* synthetic */ String getBelongRoomId();

    @FieldName(name = "belong_open_id")
    /* synthetic */ String getBelongUserId();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "id")
    /* synthetic */ String getId();

    @FieldName(name = "linkmic_id_str")
    /* synthetic */ String getLinkmicIdStr();

    @FieldName(name = "nickname")
    /* synthetic */ String getNickName();
}
