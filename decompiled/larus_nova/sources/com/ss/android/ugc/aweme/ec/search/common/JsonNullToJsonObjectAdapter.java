package com.ss.android.ugc.aweme.ec.search.common;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/ec/search/common/JsonNullToJsonObjectAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/google/gson/JsonObject;", "<init>", "()V", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class JsonNullToJsonObjectAdapter implements JsonDeserializer<JsonObject> {
    public JsonNullToJsonObjectAdapter() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final JsonObject deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        if (r100 != null) goto L4;
    L9:
        return null;
    L4:
        if (r100.isJsonNull() == true) goto L9;
        if (r100.isJsonObject() == false) goto L9;
        return r100.getAsJsonObject();
    }
}
