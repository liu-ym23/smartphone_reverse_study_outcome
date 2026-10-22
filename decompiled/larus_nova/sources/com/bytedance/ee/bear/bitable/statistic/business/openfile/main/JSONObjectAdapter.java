package com.bytedance.ee.bear.bitable.statistic.business.openfile.main;

import com.alibaba.fastjson.JSONObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/statistic/business/openfile/main/JSONObjectAdapter;", "Lcom/bytedance/ee/bear/bitable/statistic/business/openfile/main/IJSONObjectAdapter;", "fastJsonObject", "Lcom/alibaba/fastjson/JSONObject;", "<init>", "(Lcom/alibaba/fastjson/JSONObject;)V", "convertToOrgJSONObject", "Lorg/json/JSONObject;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSONObjectAdapter implements IJSONObjectAdapter {
    private final JSONObject fastJsonObject;

    @Override // com.bytedance.ee.bear.bitable.statistic.business.openfile.main.IJSONObjectAdapter
    public org.json.JSONObject convertToOrgJSONObject() {
        return new org.json.JSONObject(this.fastJsonObject.toJSONString());
    }

    public JSONObjectAdapter(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "fastJsonObject");
        this.fastJsonObject = r100;
    }
}
