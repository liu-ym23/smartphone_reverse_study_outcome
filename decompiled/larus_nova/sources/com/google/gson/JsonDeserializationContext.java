package com.google.gson;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface JsonDeserializationContext {
    <T> T deserialize(JsonElement r100, Type r101) throws JsonParseException;
}
