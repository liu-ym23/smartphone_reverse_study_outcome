package com.bytedance.upc.bridge.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class i implements gp7.f.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f272431a;

    @Override // gp7.f.c
    public final void setStatus(Boolean r100) {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final Map<String, Object> convert() {
        LinkedHashMap r100 = new LinkedHashMap();
        String r101 = this.f272431a;
        if (r101 == null) goto L5;
        r100.put("status", Boolean.valueOf(Intrinsics.areEqual(r101, "on")));
    L5:
        return r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final JSONObject toJSON() {
        return new JSONObject();
    }

    @Override // gp7.f.c
    public final Boolean getStatus() {
        return Boolean.TRUE;
    }

    public i(String r100) {
        this.f272431a = r100;
    }
}
