package com.bytedance.upc.bridge.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements gp7.b.c {
    public d() {
    }

    @Override // gp7.b.c
    public final void setStatus(Boolean r100) {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final Map<String, Object> convert() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("status", Boolean.TRUE);
        return r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final JSONObject toJSON() {
        return new JSONObject();
    }

    @Override // gp7.b.c
    public final Boolean getStatus() {
        return Boolean.TRUE;
    }
}
