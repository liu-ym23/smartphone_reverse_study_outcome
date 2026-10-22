package com.bytedance.locallife.bridge.groupon.method;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a0 implements qo6.s.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Number f257102a;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final Map<String, Object> convert() {
        return new HashMap();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final JSONObject toJSON() {
        return new JSONObject();
    }

    public a0() {
        this.f257102a = 1;
    }

    @Override // qo6.s.c
    public final Number getCode() {
        return this.f257102a;
    }

    @Override // qo6.s.c
    public final void setCode(Number r100) {
        this.f257102a = r100;
    }
}
