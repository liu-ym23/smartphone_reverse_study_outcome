package com.bytedance.ee.bear.bitable.statistic.business.openfile.main;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B/\u0012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016R.\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/statistic/business/openfile/main/MapJSONObjectAdapter;", "Lcom/bytedance/ee/bear/bitable/statistic/business/openfile/main/IJSONObjectAdapter;", "map", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/util/HashMap;)V", "convertToOrgJSONObject", "Lorg/json/JSONObject;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MapJSONObjectAdapter implements IJSONObjectAdapter {
    private final HashMap<String, Object> map;

    @Override // com.bytedance.ee.bear.bitable.statistic.business.openfile.main.IJSONObjectAdapter
    public JSONObject convertToOrgJSONObject() {
        return new JSONObject(this.map);
    }

    public MapJSONObjectAdapter(HashMap<String, Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        this.map = r2;
    }
}
