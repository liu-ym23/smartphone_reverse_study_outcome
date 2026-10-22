package com.bytedance.locallife.bridge.groupon.method;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements qo6.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Number f257117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, ? extends Object> f257118b;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final JSONObject toJSON() {
        return new JSONObject(this.f257118b);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final Map<String, Object> convert() {
        return this.f257118b;
    }

    @Override // qo6.d.c
    public final Number getCode() {
        return this.f257117a;
    }

    @Override // qo6.d.c
    public final Map<String, Object> getResult() {
        return this.f257118b;
    }

    public f(Map<String, ? extends Object> r100) {
        this.f257117a = 1;
        if (r100 == null) goto L14;
        Map<String, Object> r101 = com.bytedance.locallife.groupon.basic.utils.b.a(r100);
        Map r102 = new LinkedHashMap(MapsKt.mapCapacity(r101.size()));
        Iterator r103 = ((LinkedHashMap) r101).entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L15;
        Map.Entry r104 = (Map.Entry) r103.next();
        Object r105 = r104.getKey();
        if ((r104.getValue() instanceof XBaseModel) == false) goto L12;
        Object r106 = r104.getValue();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel");
        Object r107 = ((XBaseModel) r106).convert();
        if (r107 != null) goto L13;
        r107 = MapsKt.emptyMap();
    L13:
        r102.put(r105, r107);
        goto L6
    L12:
        r107 = r104.getValue();
    L15:
        this.f257118b = r102;
        return;
    L14:
        r102 = MapsKt.emptyMap();
        goto L15
    }

    @Override // qo6.d.c
    public final void setCode(Number r100) {
        this.f257117a = r100;
    }

    @Override // qo6.d.c
    public void setResult(Map<String, ? extends Object> r100) {
        this.f257118b = r100;
    }
}
