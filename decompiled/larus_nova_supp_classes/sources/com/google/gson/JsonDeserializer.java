package com.google.gson;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface JsonDeserializer<T> {
    T deserialize(JsonElement r1, Type r2, JsonDeserializationContext r3) throws JsonParseException;
}
