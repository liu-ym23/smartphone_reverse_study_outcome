package com.bytedance.upc.bridge.impl;

import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class j implements gp7.g.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f272432a;

    @Override // gp7.g.c
    public final void setAuthorityResultList(List<? extends gp7.g.e> r100) {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final Map<String, Object> convert() {
        return MapsKt.mapOf(TuplesKt.to("authorityResultList", this.f272432a));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final JSONObject toJSON() {
        return new JSONObject();
    }

    @Override // gp7.g.c
    public final List<gp7.g.e> getAuthorityResultList() {
        return CollectionsKt.emptyList();
    }

    public j(List r100) {
        this.f272432a = r100;
    }
}
