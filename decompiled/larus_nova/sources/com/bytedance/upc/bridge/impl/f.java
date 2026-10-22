package com.bytedance.upc.bridge.impl;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class f implements gp7.c.InterfaceC6053c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f272429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f272430b;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final Map<String, Object> convert() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("errorCode", Integer.valueOf(this.f272429a)), TuplesKt.to("errorMsg", this.f272430b)});
    }

    @Override // gp7.c.InterfaceC6053c
    public final void setErrorCode(Number r100) {
    }

    @Override // gp7.c.InterfaceC6053c
    public final void setErrorMsg(String r100) {
    }

    @Override // gp7.c.InterfaceC6053c
    public final Number getErrorCode() {
        return Integer.valueOf(this.f272429a);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final JSONObject toJSON() {
        return new JSONObject();
    }

    @Override // gp7.c.InterfaceC6053c
    public final String getErrorMsg() {
        return this.f272430b;
    }

    public f(int r100) {
        this.f272429a = r100;
        this.f272430b = "";
    }
}
