package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor r100) {
        this.constructorConstructor = r100;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r100, TypeToken<T> r101) {
        JsonAdapter r102 = (JsonAdapter) r101.getRawType().getAnnotation(JsonAdapter.class);
        if (r102 != null) goto L7;
        return null;
    L7:
        return (TypeAdapter<T>) getTypeAdapter(this.constructorConstructor, r100, r101, r102);
    }

    public TypeAdapter<?> getTypeAdapter(ConstructorConstructor r100, Gson r101, TypeToken<?> r110, JsonAdapter r111) {
        Object r102 = r100.get(TypeToken.get(r111.value())).construct();
        boolean r103 = r111.nullSafe();
        if ((r102 instanceof TypeAdapter) == false) goto L6;
        TypeAdapter<?> r104 = (TypeAdapter) r102;
    L24:
        if (r104 == null) goto L28;
        if (r103 == true) goto L27;
        return r104;
    L27:
        return r104.nullSafe();
    L28:
        return r104;
    L6:
        if ((r102 instanceof TypeAdapterFactory) == false) goto L8;
        r104 = ((TypeAdapterFactory) r102).create(r101, r110);
        goto L24
    L8:
        boolean r112 = r102 instanceof JsonSerializer;
        if (r112 == true) goto L16;
        if ((r102 instanceof JsonDeserializer) == true) goto L16;
        throw new IllegalArgumentException("Invalid attempt to bind an instance of " + r102.getClass().getName() + " as a @JsonAdapter for " + r110.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
    L16:
        if (r112 == false) goto L18;
        JsonSerializer r105 = (JsonSerializer) r102;
    L20:
        if ((r102 instanceof JsonDeserializer) == false) goto L22;
        JsonDeserializer r106 = (JsonDeserializer) r102;
    L23:
        r104 = new TreeTypeAdapter(r105, r106, r101, r110, null, r103);
        r103 = false;
        goto L24
    L22:
        r106 = null;
        goto L23
    L18:
        r105 = null;
        goto L20
    }
}
