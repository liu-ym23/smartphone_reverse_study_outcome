package com.google.gson;

import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes.dex */
public interface TypeAdapterFactory {
    <T> TypeAdapter<T> create(Gson r100, TypeToken<T> r101);
}
