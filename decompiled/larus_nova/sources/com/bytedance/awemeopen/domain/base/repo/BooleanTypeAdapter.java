package com.bytedance.awemeopen.domain.base.repo;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes44.dex */
class BooleanTypeAdapter implements JsonDeserializer<Boolean> {
    public BooleanTypeAdapter() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final Boolean deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) throws JsonParseException {
        JsonPrimitive r103 = (JsonPrimitive) r100;
        if (r103.isBoolean() == true) goto L23;
        Boolean r104 = null;
        if (r103.isString() == false) goto L14;
        String r105 = r100.getAsString();
        if (r105.equalsIgnoreCase("true") == false) goto L11;
        return Boolean.TRUE;
    L11:
        if (r105.equalsIgnoreCase("false") == false) goto L26;
        return Boolean.FALSE;
    L26:
        return null;
    L14:
        int r106 = r100.getAsInt();
        if (r106 != 0) goto L18;
        boolean r107 = false;
    L22:
        return Boolean.valueOf(r107);
    L18:
        if (r106 != 1) goto L20;
        r104 = Boolean.TRUE;
    L20:
        r107 = r104.booleanValue();
        goto L22
    L23:
        return Boolean.valueOf(r100.getAsBoolean());
    }
}
