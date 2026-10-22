package com.bytedance.locallife.groupon.api;

import com.ss.android.ugc.aweme.feed.model.nearby.NearbyPageType;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/bytedance/locallife/groupon/api/IGrouponUndertakeService;", "", "gatherGrouponCommonParams", "", "", "pageType", "Lcom/ss/android/ugc/aweme/feed/model/nearby/NearbyPageType;", "gatherGrouponCommonParamsToString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IGrouponUndertakeService {
    Map<String, Object> gatherGrouponCommonParams(NearbyPageType r100);

    String gatherGrouponCommonParamsToString(NearbyPageType r100);
}
