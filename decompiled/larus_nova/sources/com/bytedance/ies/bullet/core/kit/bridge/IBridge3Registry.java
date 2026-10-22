package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.ies.bullet.service.base.i0;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/IBridge3Registry;", "Lcom/bytedance/ies/bullet/service/base/i0;", "", "methodName", "Lorg/json/JSONObject;", "params", "Lcom/bytedance/ies/bullet/core/kit/bridge/Callback;", "callBack", "", "handle", "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IBridge3Registry extends i0 {
    void handle(String r100, JSONObject r101, Callback r102);

    @Override // com.bytedance.ies.bullet.service.base.i0
    /* synthetic */ void release();
}
