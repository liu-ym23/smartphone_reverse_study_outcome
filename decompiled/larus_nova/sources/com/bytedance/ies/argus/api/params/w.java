package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class w extends m<x> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f245789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f245790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f245791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f245792e;

    @Override // com.bytedance.ies.argus.api.params.BaseAspectParams
    public final com.bytedance.ies.argus.strategy.a f() {
        return new x(new LinkedHashMap());
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject c(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r101 = new JSONObject();
        JSONUtilsKt.d(r101, "resource_url", this.f245789b);
        return r101;
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r110) {
        Intrinsics.checkNotNullParameter(r110, "action");
        JSONObject r111 = new JSONObject();
        JSONUtilsKt.d(r111, "resource_url", this.f245789b);
        JSONUtilsKt.d(r111, "resource_point", this.f245792e);
        JSONUtilsKt.d(r111, "resource_type", this.f245791d);
        JSONUtilsKt.d(r111, "origin_headers", CollectionsKt.joinToString$default(this.f245790c.keySet(), ",", null, null, 0, null, null, 62, null));
        return r111;
    }

    public w(String r100, Map<String, String> r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "originHeaders");
        Intrinsics.checkNotNullParameter(r102, "resourceType");
        Intrinsics.checkNotNullParameter(r103, "resourcePoint");
        this.f245789b = r100;
        this.f245790c = r101;
        this.f245791d = r102;
        this.f245792e = r103;
    }
}
