package com.bytedance.locallife.groupon.utils;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes21.dex */
class JsonParseUtils$2 extends TypeAdapter<Integer> {
    public JsonParseUtils$2() {
    }

    @Override // com.google.gson.TypeAdapter
    public final Integer read(JsonReader r100) throws IOException {
        JsonToken r101 = r100.peek();
        int r102 = a.f258853a[r101.ordinal()];
        if (r102 == 1) goto L23;
        if (r102 != 2) goto L7;
        r100.nextNull();
        return null;
    L7:
        if (r102 != 3) goto L9;
        return Integer.valueOf(r100.nextInt());
    L18:
        e = move-exception;
        throw new JsonSyntaxException(e);
    L9:
        if (r102 != 4) goto L15;
        String r103 = r100.nextString();
        return Integer.valueOf(CastIntegerProtector.parseInt(r103));
    L28:
        return Integer.valueOf(Boolean.parseBoolean(r103) ? 1 : 0);
    L15:
        throw new IllegalStateException("Expected BOOLEAN or NUMBER but was " + r101);
    L23:
        return Integer.valueOf(r100.nextBoolean() ? 1 : 0);
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, Integer r101) throws IOException {
        Integer r102 = r101;
        if (r102 != null) goto L5;
        r100.nullValue();
        return;
    L5:
        r100.value(r102);
    }
}
