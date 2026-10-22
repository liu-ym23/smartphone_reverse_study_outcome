package com.bytedance.ies.argus.bean.config;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/argus/bean/config/ContainerIdentityDeserializer;", "Lcom/google/gson/JsonDeserializer;", "", "", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class ContainerIdentityDeserializer implements JsonDeserializer<Map<String, ? extends String>> {
    public ContainerIdentityDeserializer() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final Map<String, ? extends String> deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        if (r100 != null) goto L4;
    L22:
        return null;
    L4:
        if (r100.isJsonObject() == false) goto L22;
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<Map.Entry<String, JsonElement>> r104 = r100.getAsJsonObject().entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L20;
        Map.Entry<String, JsonElement> r105 = r104.next();
        String r106 = r105.getKey();
        JsonElement r107 = r105.getValue();
        if (r107.isJsonArray() == false) goto L8;
        Iterator<JsonElement> r108 = r107.getAsJsonArray().iterator();
    L13:
        if (r108.hasNext() == false) goto L8;
        JsonElement r109 = r108.next();
        if (r109.isJsonPrimitive() == false) goto L13;
        if (r109.getAsJsonPrimitive().isString() == false) goto L13;
        r103.put(r109.getAsString(), r106);
        goto L13
    L20:
        if ((!r103.isEmpty()) == false) goto L22;
        return r103;
    }
}
