package com.ss.android.lark.todo.impl.utils;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes38.dex */
public class EnumIntTypeAdapterFactory implements TypeAdapterFactory {
    public static EnumIntTypeAdapterFactory a() {
        return new EnumIntTypeAdapterFactory();
    }

    private EnumIntTypeAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(Gson r100, TypeToken<T> r101) {
        Class<? super T> r102 = r101.getRawType();
        if (Enum.class.isAssignableFrom(r102) == true) goto L5;
        return null;
    L5:
        if (r102 != Enum.class) goto L8;
        return null;
    L8:
        if (r102.isEnum() == true) goto L11;
        r102 = r102.getSuperclass();
    L11:
        return new EnumIntTypeAdapter(r102);
    }
}
