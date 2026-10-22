package com.google.gson;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface JsonDeserializer<T> {
    T deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) throws JsonParseException;
}
