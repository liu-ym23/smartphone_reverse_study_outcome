package com.bytedance.caijing.sdk.infra.base.api.container.old_container;

import com.android.ttcjpaysdk.base.service.ICJExternalEventCenterCallback;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&J*\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&J\u001a\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH&J\u001c\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/container/old_container/CJExternalEventService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "enqueueEvent", "", "eventName", "", "timestamp", "", "params", "Lorg/json/JSONObject;", "registerJsEventSubscriber", "", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJExternalEventCenterCallback;", "registerSubscriber", "containerId", "unregisterJsEventSubscriber", "subscriber", "unregisterSubscriber", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJExternalEventService extends ICJService {
    void enqueueEvent(String r100, long r101, JSONObject r102);

    Object registerJsEventSubscriber(String r100, ICJExternalEventCenterCallback r101);

    Object registerSubscriber(String r100, long r101, String r102, ICJExternalEventCenterCallback r103);

    void unregisterJsEventSubscriber(String r100, Object r101);

    void unregisterSubscriber(Object r100, String r101);
}
