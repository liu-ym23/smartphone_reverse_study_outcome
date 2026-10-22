package com.google.gson;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface JsonDeserializationContext {
    <T> T deserialize(JsonElement r1, Type r2) throws JsonParseException;
}
