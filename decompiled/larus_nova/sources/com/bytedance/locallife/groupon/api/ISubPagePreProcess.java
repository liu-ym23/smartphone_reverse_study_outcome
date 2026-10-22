package com.bytedance.locallife.groupon.api;

import com.bytedance.locallife.groupon.struct.NearbyOpenSubPageStruct;
import com.ss.android.ugc.aweme.feed.model.nearby.NearbyPageType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\tH'¨\u0006\u0012"}, d2 = {"Lcom/bytedance/locallife/groupon/api/ISubPagePreProcess;", "", "buildFinalSchema", "", "pageType", "Lcom/ss/android/ugc/aweme/feed/model/nearby/NearbyPageType;", "schema", "openSessionId", "subPage", "Lcom/bytedance/locallife/groupon/struct/NearbyOpenSubPageStruct;", "isMatch", "", "nearbyHalfType", "Lcom/bytedance/locallife/groupon/api/NearbyHalfType;", "needPreOpen", "subPageStruct", "preprocess", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface ISubPagePreProcess {
    String buildFinalSchema(NearbyPageType r100, String r101, String r102, NearbyOpenSubPageStruct r103);

    boolean isMatch(NearbyPageType r100, String r101);

    NearbyHalfType nearbyHalfType();

    boolean needPreOpen(NearbyOpenSubPageStruct r100);

    void preprocess(NearbyPageType r100, String r101, NearbyOpenSubPageStruct r102);
}
