package com.bytedance.locallife.dito.data;

import com.bytedance.locallife.dito.utils.DitoComponentDataDeserializer;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@JsonAdapter(DitoComponentDataDeserializer.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/dito/data/d;", "", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JsonObject f258198a;

    public d(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "rawData");
        this.f258198a = r100;
    }
}
