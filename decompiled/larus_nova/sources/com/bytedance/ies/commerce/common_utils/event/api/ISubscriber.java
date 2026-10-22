package com.bytedance.ies.commerce.common_utils.event.api;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/commerce/common_utils/event/api/ISubscriber;", "", "onEvent", "", "sessionId", "", "name", "data", "Lorg/json/JSONObject;", "common_utils_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ISubscriber {
    void onEvent(String r100, String r101, JSONObject r102);
}
