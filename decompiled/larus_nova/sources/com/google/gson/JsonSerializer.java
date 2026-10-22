package com.google.gson;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface JsonSerializer<T> {
    JsonElement serialize(T r100, Type r101, JsonSerializationContext r102);
}
