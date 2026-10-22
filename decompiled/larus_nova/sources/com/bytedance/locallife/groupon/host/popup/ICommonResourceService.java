package com.bytedance.locallife.groupon.host.popup;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.ugc.aweme.feed.model.nearby.NearbyPageType;
import kotlin.Metadata;
import ur6.b;
import zq6.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J&\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J*\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0016J\"\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u001dH\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/locallife/groupon/host/popup/ICommonResourceService;", "", "resourceAbility", "c2Context", "exclusionManager", "Lzq6/a;", "getPopUpHandler", "getClickThroughDialogHandler", "getCommonPendantHandler", "Lcom/ss/android/ugc/aweme/feed/model/nearby/NearbyPageType;", "pageType", "", "startMallResourceRequest", "endMallResourceRequest", WidgetCostModule.TYPE_ON_CREATE, "onGrouponShow", "onGrouponHide", "", "moduleId", "targetId", "", GXTemplateKey.GAIAX_ANIMATION, "Lur6/b;", "callback", "runGrouponEntranceAnimation", "data", "onReceiveCommonFloatData", "cacheKey", "sendInfo", "Lur6/a;", "getDrawCouponResult", "locallife-groupon-host-api_release"}, k = 1, mv = {1, 4, 3})
public interface ICommonResourceService {
    void endMallResourceRequest(NearbyPageType r100);

    a getClickThroughDialogHandler();

    a getCommonPendantHandler(Object r100, Object r101);

    void getDrawCouponResult(String r100, String r101, ur6.a r102);

    a getPopUpHandler(Object r100, Object r101, Object r102);

    void onCreate(NearbyPageType r100);

    void onGrouponHide(NearbyPageType r100);

    void onGrouponShow(NearbyPageType r100);

    void onReceiveCommonFloatData(Object r100);

    void runGrouponEntranceAnimation(String r100, String r101, int r102, b r103);

    void startMallResourceRequest(NearbyPageType r100);
}
