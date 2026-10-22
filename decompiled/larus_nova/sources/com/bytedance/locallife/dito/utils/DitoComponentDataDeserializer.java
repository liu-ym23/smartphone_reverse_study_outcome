package com.bytedance.locallife.dito.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/dito/utils/DitoComponentDataDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/locallife/dito/data/d;", "<init>", "()V", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class DitoComponentDataDeserializer implements JsonDeserializer<com.bytedance.locallife.dito.data.d> {
    public DitoComponentDataDeserializer() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final com.bytedance.locallife.dito.data.d deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        if (r100 == null) goto L10;
        JsonObject r103 = r100.getAsJsonObject();
        if (r103 != null) goto L9;
        return null;
    L9:
        return new com.bytedance.locallife.dito.data.d(r103);
    L10:
        return null;
    }
}
