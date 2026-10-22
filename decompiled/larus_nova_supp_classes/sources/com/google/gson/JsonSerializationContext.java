package com.google.gson;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface JsonSerializationContext {
    JsonElement serialize(Object r1);

    JsonElement serialize(Object r1, Type r2);
}
