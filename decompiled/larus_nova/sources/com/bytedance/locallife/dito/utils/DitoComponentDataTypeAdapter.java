package com.bytedance.locallife.dito.utils;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/dito/utils/DitoComponentDataTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/bytedance/locallife/dito/data/d;", "<init>", "()V", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class DitoComponentDataTypeAdapter extends TypeAdapter<com.bytedance.locallife.dito.data.d> {
    public DitoComponentDataTypeAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final com.bytedance.locallife.dito.data.d read(JsonReader r100) {
        Intrinsics.checkNotNullParameter(r100, "in");
        JsonElement r101 = new JsonParser().parse(r100);
        if (r101.isJsonObject() == true) goto L7;
        return null;
    L7:
        return new com.bytedance.locallife.dito.data.d(r101.getAsJsonObject());
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, com.bytedance.locallife.dito.data.d r101) {
        com.bytedance.locallife.dito.data.d r102 = r101;
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        if (r102 != null) goto L5;
        r100.nullValue();
        return;
    L5:
        r100.jsonValue(r102.f258198a.toString());
    }
}
