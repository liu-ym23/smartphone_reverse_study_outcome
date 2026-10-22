package com.bytedance.android.shopping.api.mall;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001JN\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\nH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/ILegouECEventCenterService;", "", "enqueueEvent", "", "eventName", "", "timestamp", "", "sceneID", "isGlobal", "", "params", "", "isSticky", "legou-mall-common-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILegouECEventCenterService {
    void enqueueEvent(String r1, long r2, String r4, boolean r5, Map<String, ? extends Object> r6, boolean r7);
}
