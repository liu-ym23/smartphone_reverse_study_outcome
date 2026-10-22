package com.bytedance.locallife.bridge.common.method;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements ko6.p.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f257056a;

    @Override // com.bytedance.ies.xbridge.model.idl.XBaseModel
    public final Map<String, Object> convert() {
        String r100 = this.f257056a;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Any");
        return MapsKt.hashMapOf(new Pair[]{TuplesKt.to("errorMsg", r100)});
    }

    @Override // com.bytedance.ies.xbridge.model.idl.XBaseModel
    public final JSONObject toJSON() {
        JSONObject r100 = new JSONObject();
        r100.put("errorMsg", this.f257056a);
        return r100;
    }

    @Override // ko6.p.c
    public final String getErrorMsg() {
        return this.f257056a;
    }

    public a(String r100) {
        this.f257056a = r100;
    }

    @Override // ko6.p.c
    public final void setErrorMsg(String r100) {
        this.f257056a = r100;
    }
}
