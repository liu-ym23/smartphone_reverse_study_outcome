package com.google.gson;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface JsonSerializationContext {
    JsonElement serialize(Object r100);

    JsonElement serialize(Object r100, Type r101);
}
