package com.bytedance.upc.bridge.impl;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements gp7.a.c {
    public a() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final Map<String, Object> convert() {
        return MapsKt.mapOf(TuplesKt.to("code", 0));
    }

    @Override // gp7.a.c
    public final Number getCode() {
        return 0;
    }

    @Override // gp7.a.c
    public final void setCode(Number r100) {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final JSONObject toJSON() {
        return new JSONObject();
    }
}
