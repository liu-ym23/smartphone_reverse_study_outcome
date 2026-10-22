package com.bytedance.locallife.groupon.utils;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes21.dex */
class JsonParseUtils$1 extends TypeAdapter<Boolean> {
    public JsonParseUtils$1() {
    }

    @Override // com.google.gson.TypeAdapter
    public final Boolean read(JsonReader r100) throws IOException {
        JsonToken r101 = r100.peek();
        int r102 = a.f258853a[r101.ordinal()];
        boolean r103 = true;
        if (r102 == 1) goto L24;
        if (r102 != 2) goto L7;
        r100.nextNull();
        return null;
    L7:
        if (r102 != 3) goto L9;
    L19:
        e = move-exception;
        throw new JsonSyntaxException(e);
    L14:
        if (r100.nextInt() != 0) goto L17;
        r103 = false;
    L17:
        return Boolean.valueOf(r103);
    L9:
        if (r102 != 4) goto L12;
        return Boolean.valueOf(Boolean.parseBoolean(r100.nextString()));
    L12:
        throw new IllegalStateException("Expected BOOLEAN or NUMBER but was " + r101);
    L24:
        return Boolean.valueOf(r100.nextBoolean());
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, Boolean r101) throws IOException {
        Boolean r102 = r101;
        if (r102 != null) goto L5;
        r100.nullValue();
        return;
    L5:
        r100.value(r102);
    }
}
