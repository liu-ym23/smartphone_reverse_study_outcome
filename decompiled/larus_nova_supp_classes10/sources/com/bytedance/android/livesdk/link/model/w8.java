package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R8\u0010\u000b\u001a\u001e\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0018\u00010\u0003j\u000e\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0018\u0001`\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/w8;", "Lvh7/c;", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getSortedFollowedList", "()Ljava/util/List;", "setSortedFollowedList", "(Ljava/util/List;)V", "sortedFollowedList", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface w8 extends vh7.c<w8> {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ q8 getActivityData();

    /* synthetic */ IAnchorTopTips getAnchorTopTips();

    /* synthetic */ a0 getAutoMatchBanner();

    /* synthetic */ long getDurationTime();

    /* synthetic */ List<IRoom> getFollowedList();

    /* synthetic */ String getFollowedListGroupName();

    /* synthetic */ boolean getPkAvailable();

    /* synthetic */ List<IRoom> getRecentList();

    /* synthetic */ List<IRoom> getRecommendList();

    /* synthetic */ Map<Long, IRivalExtraInfo> getRivalExtraInfos();

    /* synthetic */ Map<Long, r2> getRoom2Tags();

    /* synthetic */ y8 getSearchBar();

    /* synthetic */ int getSkinType();

    List<IRoom> getSortedFollowedList();

    /* synthetic */ long getTabLocate();

    /* synthetic */ Map<Long, r2> getTagsMap();

    /* synthetic */ z8 getTipBar();

    /* synthetic */ String getTips();

    void setSortedFollowedList(List<? extends IRoom> r1);
}
