package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/c5;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/r0;", "", "Lja0/a;", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c5 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.r0>, com.bytedance.android.livesdk.link.model.bridge.r0, ja0.a {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ String getBattleAttachedInfo();

    /* synthetic */ u1 getBattleSetting();

    /* synthetic */ Map<String, IBattleUserInfo> getBattleUserInfoMap();

    /* synthetic */ boolean getCanSwitchMulti();

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    /* synthetic */ String getEventTrackingInfo();

    /* synthetic */ Object getFlexInstance();

    /* synthetic */ t4 getLinkIconConfig();

    /* synthetic */ String getRequestSource();

    /* synthetic */ x2 getSkinConfig();

    /* synthetic */ int getSkinType();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r1);
}
